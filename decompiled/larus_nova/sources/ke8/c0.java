package ke8;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.cotdetail.list.view.UplinkTextMenuController;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.TextBlock;
import com.larus.mainbot.impl.databinding.LarusCotDetailUserUploadCellBinding;
import com.larus.nova.R;
import com.larus.platform.api.IFlowThemeConfigProvider;
import com.larus.platform.api.ThemeColorKey;
import com.larus.platform.api.ThemeConfigScene;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
public final class c0 extends le8.a<he8.f> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f503046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f503047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f503048d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Message f503049e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f503050f;

    public static final class a {
    }

    static {
    }

    private final LarusCotDetailUserUploadCellBinding getBinding() {
        return (LarusCotDetailUserUploadCellBinding) this.f503046b.getValue();
    }

    private final UplinkTextMenuController getMenuController() {
        return (UplinkTextMenuController) this.f503050f.getValue();
    }

    @Override // le8.a
    public final void b() {
        UplinkTextMenuController r100 = getMenuController();
        r100.f302061j++;
        r100.e();
        r100.f302059h = null;
        r100.f302060i = null;
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("onViewRecycled=messageId=");
        Message r103 = this.f503049e;
        if (r103 == null) goto L5;
        String r104 = r103.getMessageId();
    L6:
        r102.append(r104);
        r102.append(", sizeChangedWidth=");
        r102.append(this.f503048d);
        r102.append(", sizeChangedHeight=");
        r102.append(this.f503047c);
        r101.i("UplinkTextView", r102.toString());
        this.f503049e = null;
        this.f503048d = 0;
        this.f503047c = 0;
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        UplinkTextMenuController r100 = getMenuController();
        r100.f302061j++;
        r100.e();
        super.onDetachedFromWindow();
    }

    public c0(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f503046b = LazyKt.lazy(new a0(r100, this));
        this.f503050f = LazyKt.lazy(new b0(this));
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        TextView r101 = getBinding().f358563b;
        Intrinsics.checkNotNull(r101);
        r101.setTextSize(0, we8.a.a(i5.t(), false));
        r101.setLineSpacing(0.0f, 1.1f);
    }

    public static UplinkTextMenuController c(c0 r100) {
        return new UplinkTextMenuController(r100.getBinding().f358563b, r100.getBinding().f358564c);
    }

    @Override // le8.b
    public final void a(ie8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        kc8.y r101 = r100.f489500c;
        Integer r102 = null;
        if (r101 == null) goto L5;
        kc8.y.a r103 = r101.b();
        r103.f502652g = getAttachedRecyclerView();
        kc8.y r104 = r103.a();
    L6:
        UplinkTextMenuController r105 = getMenuController();
        Message r106 = r100.f489498a;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "message");
        r105.f302061j++;
        r105.e();
        r105.f302059h = r106;
        r105.f302060i = r104;
        Block r107 = (Block) CollectionsKt.firstOrNull(com.larus.im.bean.message.a.d(r100.f489498a));
        if (r107 == null) goto L13;
        BlockContent r108 = r107.getContent();
        if (r108 == null) goto L13;
        TextBlock r109 = r108.getTextBlock();
        if (r109 == null) goto L13;
        String r110 = r109.text;
    L14:
        this.f503049e = r100.f489498a;
        getBinding().f358563b.setText(r110);
        IFlowThemeConfigProvider r111 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r111 == null) goto L17;
        r111.d(getBinding().f358563b, ThemeColorKey.MESSAGE_SEND_TEXT_COLOR, ThemeConfigScene.CHAT, AdaptThemeFeatureKey.SEND_MESSAGE_TEXT);
    L17:
        FrameLayout r112 = getBinding().f358564c;
        Drawable r113 = ContextCompat.getDrawable(getContext(), v19.c.b(R.attr.larus_bg_outbox, getContext(), R.drawable.larus_bg_outbox));
        if (r113 == null) goto L22;
        IFlowThemeConfigProvider r114 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r114 == null) goto L23;
        IFlowThemeConfigProvider.a.a(r114, r113, ThemeColorKey.MESSAGE_BUBBLE_COLOR, ThemeConfigScene.CHAT, AdaptThemeFeatureKey.SEND_MESSAGE_BUBBLE);
    L23:
        r112.setBackground(r113);
        FLogger r115 = FLogger.f375446a;
        StringBuilder r116 = new StringBuilder("bindData,mesageid:");
        r116.append(r100.f489498a.getMessageId());
        r116.append(" content.length: ");
        if (r110 == null) goto L26;
        r102 = Integer.valueOf(r110.length());
    L26:
        r116.append(r102);
        r115.i("UplinkTextView", r116.toString());
        return;
    L22:
        r113 = null;
    L13:
        r110 = null;
        goto L14
    L5:
        r104 = null;
        goto L6
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        this.f503048d = r100;
        this.f503047c = r101;
    }
}
