package com.bytedance.awemeopen.apps.framework.comment.view.diggbury.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentColorMode;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentColorViewModel;
import com.bytedance.awemeopen.apps.framework.comment.util.d;
import com.bytedance.awemeopen.apps.framework.utils.t;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ry3.b;
import x54.a;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fB\u001b\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\u001e\u0010\"B#\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\u0006\u0010#\u001a\u00020\u0018¢\u0006\u0004\b\u001e\u0010$R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006%"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/view/diggbury/view/DiggNewView2;", "Lcom/bytedance/awemeopen/apps/framework/comment/view/diggbury/view/BaseDiggBuryFrameLayout;", "", "d", "Z", "isAnimating", "()Z", "setAnimating", "(Z)V", "Landroid/widget/TextView;", "<set-?>", "e", "Landroid/widget/TextView;", "getMCountView", "()Landroid/widget/TextView;", "mCountView", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "getMDiggView", "()Landroid/widget/ImageView;", "setMDiggView", "(Landroid/widget/ImageView;)V", "mDiggView", "", "getRootViewId", "()I", "rootViewId", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class DiggNewView2 extends BaseDiggBuryFrameLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f194267g = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f194268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f194269e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f194270f;

    @Override // com.bytedance.awemeopen.apps.framework.comment.view.diggbury.view.BaseDiggBuryFrameLayout
    public int getRootViewId() {
        return R.layout.aweme_comment_digg_v3;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.view.diggbury.view.BaseDiggBuryFrameLayout
    public final void a() {
        super.a();
        this.f194270f = (ImageView) findViewById(R.id.digg_icon);
        this.f194269e = (TextView) findViewById(R.id.digg_count);
        LinearLayout r100 = (LinearLayout) findViewById(R.id.digg_container);
        int r101 = a.a(18);
        ImageView r102 = this.f194270f;
        ViewGroup.LayoutParams r103 = null;
        if (r102 == null) goto L5;
        ViewGroup.LayoutParams r104 = r102.getLayoutParams();
    L6:
        if (r104 == null) goto L9;
        r104.width = r101;
    L9:
        ImageView r105 = this.f194270f;
        if (r105 == null) goto L12;
        r103 = r105.getLayoutParams();
    L12:
        if (r103 == null) goto L15;
        r103.height = r101;
    L15:
        ImageView r106 = this.f194270f;
        if (r106 == null) goto L18;
        r106.setImageDrawable(com.bytedance.awemeopen.apps.framework.comment.view.a.b(false, getColorMode(), getContext()));
    L18:
        TextView r107 = this.f194269e;
        if (r107 == null) goto L29;
        Context r108 = getContext();
        CommentColorViewModel.a r109 = CommentColorViewModel.Companion;
        CommentColorMode r110 = getColorMode();
        r109.getClass();
        if (CommentColorViewModel.a.b(r110) == false) goto L24;
        int r111 = R.color.TextTertiary;
    L27:
        r107.setTextColor(ContextCompat.getColor(r108, r111));
        return;
    L24:
        if (CommentColorViewModel.a.a(getColorMode()) == false) goto L26;
        r111 = R.color.ConstTextInverse4;
        goto L27
    L26:
        r111 = R.color.TextReverse3;
        goto L27
    L29:
        return;
    L5:
        r104 = null;
        goto L6
    }

    public final TextView getMCountView() {
        return this.f194269e;
    }

    public final ImageView getMDiggView() {
        return this.f194270f;
    }

    public DiggNewView2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setAnimating(boolean r100) {
        this.f194268d = r100;
    }

    public final void setMDiggView(ImageView r100) {
        this.f194270f = r100;
    }

    public DiggNewView2(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public DiggNewView2(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
    }

    public final void b(boolean r110, boolean r111, long r112) {
        if (this.f194270f == null) goto L58;
        TextView r100 = this.f194269e;
        if (r100 != null) goto L8;
        return;
    L8:
        if (this.f194268d == true) goto L25;
        int r101 = d.f194185a;
        Long r102 = Long.valueOf(r112);
        int r103 = com.bytedance.awemeopen.apps.framework.comment.util.a.f194183a;
        if (r102 == null) goto L13;
        r102.longValue();
        String r104 = t.a(r102.longValue());
        if (r104 == null) goto L13;
    L14:
        String r105 = r104;
        if (StringsKt.contains$default(r105, "w", false, 2, null) == false) goto L17;
        r105 = StringsKt.replace$default(r105, "w", "万", false, 4, null);
    L17:
        r100.setText(r105);
        TextView r106 = this.f194269e;
        if (r106 == null) goto L25;
        if (r112 > 0) goto L23;
        int r113 = 8;
    L24:
        r106.setVisibility(r113);
        goto L25
    L23:
        r113 = 0;
    L13:
        r104 = "0";
    L25:
        Context r114 = getContext();
        ImageView r115 = this.f194270f;
        if (r115 == null) goto L30;
        r115.setSelected(r110);
    L30:
        if (this.f194263c == r110) goto L48;
        ImageView r116 = this.f194270f;
        if (r116 == null) goto L34;
        r116.setImageDrawable(com.bytedance.awemeopen.apps.framework.comment.view.a.b(r110, getColorMode(), r114));
    L34:
        if (r110 == false) goto L38;
        TextView r117 = this.f194269e;
        if (r117 == null) goto L48;
        r117.setTextColor(ContextCompat.getColor(r114, R.color.BGBadge));
        goto L48
    L38:
        TextView r118 = this.f194269e;
        if (r118 == null) goto L48;
        CommentColorViewModel.a r107 = CommentColorViewModel.Companion;
        CommentColorMode r108 = getColorMode();
        r107.getClass();
        if (CommentColorViewModel.a.b(r108) == false) goto L44;
        int r109 = R.color.TextTertiary;
    L47:
        r118.setTextColor(ContextCompat.getColor(r114, r109));
        goto L48
    L44:
        if (CommentColorViewModel.a.a(getColorMode()) == false) goto L46;
        r109 = R.color.ConstTextInverse4;
        goto L47
    L46:
        r109 = R.color.TextReverse3;
    L48:
        ImageView r119 = this.f194270f;
        if (r119 == null) goto L52;
        r119.setVisibility(0);
    L52:
        if (r111 == false) goto L56;
        final ImageView r120 = this.f194270f;
        if (r120 == null) goto L56;
        r120.animate().scaleX(0.8f).scaleY(0.8f).setDuration(80).withEndAction(new b(r120)).start();
    L56:
        setActive(r110);
        return;
    }
}
