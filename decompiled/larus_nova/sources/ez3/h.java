package ez3;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentColorMode;
import com.bytedance.awemeopen.apps.framework.comment.widget.view.CommentMentionEditText;
import com.bytedance.awemeopen.apps.framework.comment.write.refactor.l;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
public final class h extends d {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f474874o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewGroup f474875p;

    public static final class a {
    }

    static {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.refactor.BaseCmtInputPresenter
    public final void I() {
        bz3.b r100 = this.f474860f.f194547o;
        if (r100 == null) goto L5;
        r100.h(this.f474862h);
    L5:
        CommentMentionEditText r101 = this.f474862h;
        if (r101 == null) goto L19;
        CharSequence r102 = this.f474861g;
        if (r102 != null) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == true) goto L17;
        CharSequence r104 = this.f474861g;
    L18:
        r101.setHint(r104);
        goto L19
    L17:
        r104 = AosExtConfig.f193138b.getCommentConfig().f1844d;
        goto L18
    L11:
        if (r102.length() == 0) goto L14;
        r103 = false;
    L19:
        CommentMentionEditText r105 = this.f474862h;
        if (r105 == null) goto L28;
        fz3.a r106 = this.f474860f.f194541i;
        if (r106 == null) goto L26;
        CharSequence r107 = r106.f479349a;
        if (r107 == null) goto L26;
    L27:
        r105.setText(r107);
    L26:
        r107 = "";
    L28:
        h();
        J();
    }

    @Override // ez3.d
    public final void J() {
        if (this.f474863i == null) goto L54;
        CommentMentionEditText r100 = this.f474862h;
        Editable r101 = null;
        if (r100 == null) goto L7;
        Editable r102 = r100.getText();
    L8:
        if (r102 == null) goto L58;
        int r103 = this.f474860f.f194545m;
        CommentMentionEditText r104 = this.f474862h;
        if (r104 == null) goto L15;
        Editable r105 = r104.getText();
        if (r105 == null) goto L15;
        int r106 = r105.length();
    L16:
        int r107 = r103 - r106;
        if (r107 < 0) goto L42;
        DmtTextView r108 = this.f474863i;
        if (r108 == null) goto L22;
        r108.setVisibility(8);
    L22:
        CommentMentionEditText r109 = this.f474862h;
        if (r109 == null) goto L25;
        r101 = r109.getText();
    L25:
        if (r101 != null) goto L27;
    L30:
        boolean r110 = true;
    L31:
        if (r110 == false) goto L35;
        CommentMentionEditText r111 = this.f474862h;
        if (r111 == null) goto L35;
        Intrinsics.checkNotNull(r111);
        int r112 = r111.getPaddingLeft();
        CommentMentionEditText r113 = this.f474862h;
        Intrinsics.checkNotNull(r113);
        r111.setPadding(r112, 0, r113.getPaddingRight(), 0);
    L35:
        int r114 = this.f474860f.f194546n;
        if (r114 <= 0) goto L55;
        CommentMentionEditText r115 = this.f474862h;
        if (r115 == null) goto L41;
        r115.setHeight(r114);
    L41:
        this.f474860f.f194546n = 0;
        return;
    L55:
        return;
    L27:
        if (r101.length() == 0) goto L30;
        r110 = false;
        goto L31
    L42:
        DmtTextView r116 = this.f474863i;
        if (r116 == null) goto L46;
        r116.setVisibility(0);
    L46:
        DmtTextView r117 = this.f474863i;
        if (r117 == null) goto L50;
        r117.setText(String.valueOf(r107));
    L50:
        CommentMentionEditText r118 = this.f474862h;
        if (r118 == null) goto L57;
        r118.post(new g(this));
        return;
    L57:
        return;
    L15:
        r106 = 0;
        goto L16
    L58:
        return;
    L7:
        r102 = null;
        goto L8
    }

    public h(com.bytedance.awemeopen.apps.framework.comment.write.refactor.g r100) {
        Intrinsics.checkNotNullParameter(r100, "inputContext");
        super(r100);
        this.f474874o = 3;
    }

    @Override // az3.a
    public final void A(com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a r100) {
        l r101 = (l) r100;
        Intrinsics.checkNotNullParameter(r101, "viewProvider");
        super.F(r101);
        ViewGroup r102 = this.f474867m;
        if (r102 == null) goto L6;
        r102.setVisibility(8);
    L6:
        ViewGroup r103 = this.f474864j;
        if ((r103 instanceof LinearLayout) == false) goto L9;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.widget.LinearLayout");
        ((LinearLayout) r103).setGravity(48);
    L9:
        CommentMentionEditText r104 = this.f474862h;
        if (r104 == null) goto L13;
        Resources r105 = Resources.getSystem();
        r104.setMinHeight(MathKt.roundToInt(TypedValue.applyDimension(1, 24, WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()))));
    L13:
        CommentMentionEditText r106 = this.f474862h;
        if (r106 == null) goto L27;
        Editable r107 = r106.getText();
        if (r107 != null) goto L19;
    L22:
        boolean r108 = true;
    L23:
        if (r108 == false) goto L25;
        int r109 = 1;
    L26:
        r106.setMaxLines(r109);
        goto L27
    L25:
        r109 = this.f474874o;
        goto L26
    L19:
        if (r107.length() == 0) goto L22;
        r108 = false;
    L27:
        CommentMentionEditText r110 = this.f474862h;
        if (r110 == null) goto L31;
        r110.setEllipsize(TextUtils.TruncateAt.END);
    L31:
        CommentMentionEditText r111 = this.f474862h;
        if (r111 == null) goto L35;
        r111.setVerticalFadingEdgeEnabled(true);
    L35:
        CommentMentionEditText r112 = this.f474862h;
        ViewGroup r113 = null;
        if (r112 == null) goto L38;
        ViewGroup.LayoutParams r114 = r112.getLayoutParams();
    L39:
        if (r114 == null) goto L42;
        r114.height = -2;
    L42:
        CommentMentionEditText r115 = this.f474862h;
        if (r115 == null) goto L45;
        r115.requestLayout();
    L45:
        CommentMentionEditText r116 = this.f474862h;
        if (r116 == null) goto L48;
        r116.setOnClipPasteListener(new i());
    L48:
        com.bytedance.awemeopen.apps.framework.comment.util.b.a(this.f474862h, CommentColorMode.MODE_LIGHT);
        View r117 = this.f194492e;
        if (r117 == null) goto L51;
        r113 = (ViewGroup) r117.findViewById(R.id.comment_content_container);
    L51:
        this.f474875p = r113;
        return;
    L38:
        r114 = null;
        goto L39
    }

    @Override // ez3.d, android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        super.afterTextChanged(r100);
        CommentMentionEditText r101 = this.f474862h;
        boolean r102 = false;
        if (r101 == null) goto L15;
        if (r100 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
        int r104 = 1;
    L14:
        r101.setMaxLines(r104);
        goto L15
    L13:
        r104 = this.f474874o;
        goto L14
    L7:
        if (r100.length() == 0) goto L10;
        r103 = false;
    L15:
        CommentMentionEditText r105 = this.f474862h;
        if (r105 == null) goto L28;
        if (r100 != null) goto L20;
    L23:
        boolean r106 = true;
    L24:
        if (r106 == false) goto L26;
        TextUtils.TruncateAt r107 = TextUtils.TruncateAt.END;
    L27:
        r105.setEllipsize(r107);
        goto L28
    L26:
        r107 = null;
        goto L27
    L20:
        if (r100.length() == 0) goto L23;
        r106 = false;
    L28:
        if (r100 != null) goto L30;
    L32:
        if (r102 == false) goto L37;
        bz3.b r108 = this.f474860f.f194547o;
        if (r108 == null) goto L38;
        r108.g();
        return;
    L38:
        return;
    L37:
        return;
    L30:
        if (r100.length() != 0) goto L32;
        r102 = true;
        goto L32
    }
}
