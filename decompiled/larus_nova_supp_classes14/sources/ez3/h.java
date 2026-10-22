package ez3;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentColorMode;
import com.bytedance.awemeopen.apps.framework.comment.widget.view.CommentMentionEditText;
import com.bytedance.awemeopen.apps.framework.comment.write.refactor.l;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h extends d {
    public final int o;
    public ViewGroup p;

    public static final class a {
    }

    static {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.refactor.BaseCmtInputPresenter
    public final void I() {
        bz3.b r0 = this.f.o;
        if (r0 == null) goto L5;
        r0.h(this.h);
    L5:
        AppCompatEditText r1 = this.h;
        if (r1 == null) goto L19;
        CharSequence r2 = this.g;
        if (r2 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == true) goto L17;
        CharSequence r4 = this.g;
    L18:
        r1.setHint(r4);
        goto L19
    L17:
        r4 = AosExtConfig.b.getCommentConfig().d;
        goto L18
    L11:
        if (r2.length() == 0) goto L14;
        r3 = false;
    L19:
        AppCompatEditText r5 = this.h;
        if (r5 == null) goto L28;
        fz3.a r6 = this.f.i;
        if (r6 == null) goto L26;
        CharSequence r7 = r6.a;
        if (r7 == null) goto L26;
    L27:
        r5.setText(r7);
    L26:
        r7 = "";
    L28:
        h();
        J();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // ez3.d
    public final void J() {
        if (this.i == null) goto L54;
        CommentMentionEditText r0 = this.h;
        Editable r1 = null;
        if (r0 == null) goto L7;
        Editable r2 = r0.getText();
    L8:
        if (r2 == null) goto L58;
        int r3 = this.f.m;
        CommentMentionEditText r4 = this.h;
        if (r4 == null) goto L15;
        Editable r5 = r4.getText();
        if (r5 == null) goto L15;
        int r6 = r5.length();
    L16:
        int r7 = r3 - r6;
        if (r7 < 0) goto L42;
        AppCompatTextView r8 = this.i;
        if (r8 == null) goto L22;
        r8.setVisibility(8);
    L22:
        CommentMentionEditText r9 = this.h;
        if (r9 == null) goto L25;
        r1 = r9.getText();
    L25:
        if (r1 != null) goto L27;
    L30:
        boolean r10 = true;
    L31:
        if (r10 == false) goto L35;
        AppCompatEditText r11 = this.h;
        if (r11 == null) goto L35;
        Intrinsics.checkNotNull(r11);
        int r12 = r11.getPaddingLeft();
        AppCompatEditText r13 = this.h;
        Intrinsics.checkNotNull(r13);
        r11.setPadding(r12, 0, r13.getPaddingRight(), 0);
    L35:
        int r14 = this.f.n;
        if (r14 <= 0) goto L55;
        AppCompatEditText r15 = this.h;
        if (r15 == null) goto L41;
        r15.setHeight(r14);
    L41:
        this.f.n = 0;
        return;
    L55:
        return;
    L27:
        if (r1.length() == 0) goto L30;
        r10 = false;
        goto L31
    L42:
        AppCompatTextView r16 = this.i;
        if (r16 == null) goto L46;
        r16.setVisibility(0);
    L46:
        AppCompatTextView r17 = this.i;
        if (r17 == null) goto L50;
        r17.setText(String.valueOf(r7));
    L50:
        AppCompatEditText r18 = this.h;
        if (r18 == null) goto L57;
        r18.post(new g(this));
        return;
    L57:
        return;
    L15:
        r6 = 0;
        goto L16
    L58:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public h(com.bytedance.awemeopen.apps.framework.comment.write.refactor.g r2) {
        Intrinsics.checkNotNullParameter(r2, "inputContext");
        super(r2);
        this.o = 3;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // az3.a
    public final void A(com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a r5) {
        l r6 = (l) r5;
        Intrinsics.checkNotNullParameter(r6, "viewProvider");
        super.F(r6);
        ViewGroup r7 = this.m;
        if (r7 == null) goto L6;
        r7.setVisibility(8);
    L6:
        ViewGroup r8 = this.j;
        if ((r8 instanceof LinearLayout) == false) goto L9;
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.widget.LinearLayout");
        ((LinearLayout) r8).setGravity(48);
    L9:
        AppCompatEditText r9 = this.h;
        if (r9 == null) goto L13;
        Resources r2 = Resources.getSystem();
        r9.setMinHeight(MathKt.roundToInt(TypedValue.applyDimension(1, 24, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()))));
    L13:
        AppCompatEditText r10 = this.h;
        if (r10 == null) goto L27;
        Editable r1 = r10.getText();
        if (r1 != null) goto L19;
    L22:
        boolean r3 = true;
    L23:
        if (r3 == false) goto L25;
        int r4 = 1;
    L26:
        r10.setMaxLines(r4);
        goto L27
    L25:
        r4 = this.o;
        goto L26
    L19:
        if (r1.length() == 0) goto L22;
        r3 = false;
    L27:
        AppCompatEditText r11 = this.h;
        if (r11 == null) goto L31;
        r11.setEllipsize(TextUtils.TruncateAt.END);
    L31:
        AppCompatEditText r12 = this.h;
        if (r12 == null) goto L35;
        r12.setVerticalFadingEdgeEnabled(true);
    L35:
        AppCompatEditText r13 = this.h;
        ViewGroup r0 = null;
        if (r13 == null) goto L38;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
    L39:
        if (r14 == null) goto L42;
        r14.height = -2;
    L42:
        AppCompatEditText r15 = this.h;
        if (r15 == null) goto L45;
        r15.requestLayout();
    L45:
        CommentMentionEditText r16 = this.h;
        if (r16 == null) goto L48;
        r16.setOnClipPasteListener(new i());
    L48:
        com.bytedance.awemeopen.apps.framework.comment.util.b.a(this.h, CommentColorMode.MODE_LIGHT);
        View r17 = this.e;
        if (r17 == null) goto L51;
        r0 = (ViewGroup) r17.findViewById(2131367330);
    L51:
        this.p = r0;
        return;
    L38:
        r14 = null;
        goto L39
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // ez3.d, android.text.TextWatcher
    public final void afterTextChanged(Editable r5) {
        super.afterTextChanged(r5);
        AppCompatEditText r0 = this.h;
        boolean r1 = false;
        if (r0 == null) goto L15;
        if (r5 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
        int r4 = 1;
    L14:
        r0.setMaxLines(r4);
        goto L15
    L13:
        r4 = this.o;
        goto L14
    L7:
        if (r5.length() == 0) goto L10;
        r3 = false;
    L15:
        AppCompatEditText r2 = this.h;
        if (r2 == null) goto L28;
        if (r5 != null) goto L20;
    L23:
        boolean r6 = true;
    L24:
        if (r6 == false) goto L26;
        TextUtils.TruncateAt r7 = TextUtils.TruncateAt.END;
    L27:
        r2.setEllipsize(r7);
        goto L28
    L26:
        r7 = null;
        goto L27
    L20:
        if (r5.length() == 0) goto L23;
        r6 = false;
    L28:
        if (r5 != null) goto L30;
    L32:
        if (r1 == false) goto L37;
        bz3.b r8 = this.f.o;
        if (r8 == null) goto L38;
        r8.g();
        return;
    L38:
        return;
    L37:
        return;
    L30:
        if (r5.length() != 0) goto L32;
        r1 = true;
        goto L32
    }
}
