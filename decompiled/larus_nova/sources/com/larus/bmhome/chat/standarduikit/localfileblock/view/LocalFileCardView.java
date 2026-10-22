package com.larus.bmhome.chat.standarduikit.localfileblock.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.bmhome.chat.standarduikit.fileblock.view.FileAudioButtonView;
import com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel.g;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.mainbot.impl.databinding.LarusBlockItemLocalFileBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.h;
import vl8.a;
import vl8.b;
import vl8.c;
import vl8.e;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0004H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/localfileblock/view/LocalFileCardView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/localfileblock/view/LocalFileCardViewInput;", "Lcom/larus/bmhome/chat/standarduikit/localfileblock/view/LocalFileCardViewOutput;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "boundPath", "", "binding", "Lcom/larus/mainbot/impl/databinding/LarusBlockItemLocalFileBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusBlockItemLocalFileBinding;", "binding$delegate", "Lkotlin/Lazy;", "bindData", "", "input", BdpAppEventConstant.PARAMS_OUTPUT, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalFileCardView extends ConstraintLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f309472c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f309473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f309474b;

    private final LarusBlockItemLocalFileBinding getBinding() {
        return (LarusBlockItemLocalFileBinding) this.f309474b.getValue();
    }

    public LocalFileCardView(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f309473a = "";
        this.f309474b = LazyKt.lazy(new a(r100, this));
        setBackgroundResource(R.drawable.larus_bg_gaokao_8_radius);
    }

    public final void S5(final e r100, final g r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, BdpAppEventConstant.PARAMS_OUTPUT);
        this.f309473a = r100.f555698g;
        Integer r102 = r100.f555700i;
        if (r102 == null) goto L5;
        setBackgroundResource(r102.intValue());
    L5:
        boolean r103 = h.f552477a;
        if (h.b(getContext()) == false) goto L8;
        String r104 = r100.f555692a;
    L9:
        ImageLoaderKt.u(getBinding().f358463c, r104, "cot_detail_page");
        getBinding().f358464d.setText(r100.f555694c);
        TextView r105 = getBinding().f358464d;
        if (r100.f555696e == false) goto L12;
        int r106 = 2;
    L13:
        r105.setMaxLines(r106);
        TextView r107 = getBinding().f358464d;
        if (r100.f555696e == false) goto L16;
        TextUtils.TruncateAt r108 = TextUtils.TruncateAt.END;
    L17:
        r107.setEllipsize(r108);
        getBinding().f358465e.setText(r100.f555695d);
        TextView r109 = getBinding().f358465e;
        int r110 = 0;
        if (r100.f555696e == false) goto L25;
        boolean r111 = true;
        if (r100.f555695d.length() <= 0) goto L22;
        boolean r112 = true;
    L23:
        if (r112 == false) goto L25;
    L27:
        if (r111 == false) goto L29;
        int r113 = 0;
    L30:
        r109.setVisibility(r113);
        FileAudioButtonView r114 = getBinding().f358462b;
        if (r100.f555697f == true) goto L34;
        r110 = 8;
    L34:
        r114.setVisibility(r110);
        getBinding().f358462b.c(r100.f555699h);
        e1.d(getBinding().f358462b, new b(r100, r101, this));
        e1.d(getBinding().f358461a, new c(r101));
        return;
    L29:
        r113 = 8;
        goto L30
    L22:
        r112 = false;
    L25:
        r111 = false;
        goto L27
    L16:
        r108 = null;
        goto L17
    L12:
        r106 = Integer.MAX_VALUE;
        goto L13
    L8:
        r104 = r100.f555693b;
        goto L9
    }

    public static Unit R5(LocalFileCardView r100, String r101, vl8.g r102) {
        Intrinsics.checkNotNullParameter(r102, "state");
        if (Intrinsics.areEqual(r100.f309473a, r101) == false) goto L6;
        r100.getBinding().f358462b.c(r102);
    L6:
        return Unit.INSTANCE;
    }
}
