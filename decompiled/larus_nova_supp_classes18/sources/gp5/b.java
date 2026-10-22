package gp5;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogController;
import com.larksuite.component.universe_design.edittext.UDEditText;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends UDDialogController {
    public final RunnableC0237b A;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public CharSequence j;
    public CharSequence k;
    public Function1<? super Boolean, Boolean> l;
    public View m;
    public int n;
    public gp5.a.b o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public gp5.a.InterfaceC0236a t;
    public gp5.a.InterfaceC0236a u;
    public Button v;
    public SpaceEditText w;
    public SpaceEditText x;
    public TextView y;
    public CharSequence z;

    public static final class a {
    }

    /* JADX INFO: renamed from: gp5.b$b, reason: collision with other inner class name */
    public static final class RunnableC0237b implements Runnable {
        public final /* synthetic */ b a;

        public RunnableC0237b(b r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            UDDialog r0 = this.a.getMDialog();     // Catch: Throwable -> L13
            if (r0 == null) goto L7;
            boolean r1 = true;
            if (r0.isShowing() != true) goto L7;
        L8:
            if (r1 == false) goto L16;
            b r2 = this.a;     // Catch: Throwable -> L13
            if (r2.s == false) goto L20;
            rcb.c.h(r2.w, null);     // Catch: Throwable -> L13
            return;
        L20:
            return;
        L16:
            return;
        L7:
            r1 = false;
        L13:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L21;
            throw th;
        }
    }

    public static final class c implements TextWatcher {
        public final /* synthetic */ b a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r1, "s");
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r1, "s");
        }

        public c(b r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r3) {
            Intrinsics.checkNotNullParameter(r3, "s");
            this.a.b(r3);
            b r0 = this.a;
            gp5.a.b r1 = r0.o;
            if (r1 == null) goto L5;
            r1.a(r3, r0.x);
        L5:
            b r2 = this.a;
            if (r2.p == false) goto L15;
            SpaceEditText r4 = r2.x;
            if (r4 != null) goto L10;
            return;
        L10:
            if (r3.length() <= 0) goto L12;
            boolean r5 = true;
        L13:
            r4.m(r5);
            return;
        L12:
            r5 = false;
            goto L13
        }
    }

    public static final class d extends t {
        public final /* synthetic */ b c;
        public final /* synthetic */ Button d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r4) {
            SpaceEditText r5 = this.c.w;
            if (r5 == null) goto L8;
            Editable r6 = r5.getText();
            if (r6 == null) goto L8;
            String r7 = r6.toString();
            if (r7 == null) goto L8;
        L9:
            gp5.a.InterfaceC0236a r0 = this.c.t;
            if (r0 == null) goto L12;
            r0.a(r7);
        L12:
            rcb.c.c(this.d.getContext());
            if (this.c.getMAutoDismiss() == false) goto L33;
            UDDialog r8 = this.c.getMDialog();
            if (r8 == null) goto L37;
            Handler r1 = DialogLancet.resolveDialogHandler(r8);
            if (r1 != null) goto L19;
        L21:
            DialogLancet.beforeDialogDismiss(r8);
            r8.dismiss();     // Catch: Throwable -> L24 Exception -> L26
        L30:
            DialogLancet.afterDialogDismiss(r8);
            return;
        L24:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r8);
            throw th;
        L26:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L24
            Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L24
            if (r2 == null) goto L30;
            com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L24
            goto L30
        L19:
            if (Looper.myLooper() == r1.getLooper()) goto L21;
            r1.post(DialogLancet.createDismissRunnable(r8));
            return;
        L37:
            return;
        L33:
            return;
        L8:
            r7 = "";
            goto L9
        }

        public d(b r1, Button r2) {
            this.c = r1;
            this.d = r2;
        }
    }

    public static final class e extends t {
        public final /* synthetic */ b c;
        public final /* synthetic */ View d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r4) {
            SpaceEditText r5 = this.c.w;
            if (r5 == null) goto L8;
            Editable r6 = r5.getText();
            if (r6 == null) goto L8;
            String r7 = r6.toString();
            if (r7 == null) goto L8;
        L9:
            gp5.a.InterfaceC0236a r0 = this.c.u;
            if (r0 == null) goto L12;
            r0.a(r7);
        L12:
            rcb.c.c(this.d.getContext());
            if (this.c.getMAutoDismiss() == false) goto L33;
            UDDialog r8 = this.c.getMDialog();
            if (r8 == null) goto L37;
            Handler r1 = DialogLancet.resolveDialogHandler(r8);
            if (r1 != null) goto L19;
        L21:
            DialogLancet.beforeDialogDismiss(r8);
            r8.dismiss();     // Catch: Throwable -> L24 Exception -> L26
        L30:
            DialogLancet.afterDialogDismiss(r8);
            return;
        L24:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r8);
            throw th;
        L26:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L24
            Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L24
            if (r2 == null) goto L30;
            com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L24
            goto L30
        L19:
            if (Looper.myLooper() == r1.getLooper()) goto L21;
            r1.post(DialogLancet.createDismissRunnable(r8));
            return;
        L37:
            return;
        L33:
            return;
        L8:
            r7 = "";
            goto L9
        }

        public e(b r1, View r2) {
            this.c = r1;
            this.d = r2;
        }
    }

    static {
    }

    public final int getDefaultContentRes() {
        return 2131559271;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [android.widget.EditText, com.bytedance.ee.bear.widgets.universedesign.SpaceEditText] */
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
    public final View onCreateContent() {
        View r0 = super.onCreateContent();
        ViewParent r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        this.x = (SpaceEditText) r0.findViewById(2131391787);
        this.y = (TextView) r0.findViewById(2131391786);
        ?? r2 = this.x;
        this.w = r2;
        if (r2 == 0) goto L8;
        r2.setText(this.k);
    L8:
        SpaceEditText r3 = this.x;
        if (r3 == 0) goto L11;
        r3.setFilterMenuWhiteList(this.l);
    L11:
        UDEditText r4 = this.x;
        if (r4 == null) goto L15;
        r4.addTextChangedListener(new c(this));
    L15:
        if (TextUtils.isEmpty(this.z) == true) goto L22;
        TextView r5 = this.y;
        if (r5 == null) goto L19;
        r5.setVisibility(0);
    L19:
        TextView r6 = this.y;
        if (r6 == null) goto L22;
        r6.setText(this.z);
    L22:
        UDEditText r7 = this.x;
        if (r7 == null) goto L25;
        setupViewPadding(r7, this.b, this.c, this.d, this.e);
    L25:
        boolean r8 = true;
        if (this.p == false) goto L34;
        SpaceEditText r9 = this.x;
        if (r9 == null) goto L34;
        if (this.k.length() <= 0) goto L32;
        boolean r10 = true;
    L33:
        r9.m(r10);
        goto L34
    L32:
        r10 = false;
    L34:
        int r11 = this.a;
        if (r11 == (-1)) goto L39;
        UDEditText r12 = this.x;
        if (r12 == null) goto L39;
        r12.setInputType(r11);
    L39:
        CharSequence r13 = this.j;
        if (r13 == null) goto L44;
        UDEditText r14 = this.x;
        if (r14 == null) goto L44;
        r14.setHint(r13);
    L44:
        int r15 = this.f;
        if (r15 == (-1)) goto L50;
        UDEditText r16 = this.x;
        if (r16 == null) goto L50;
        r16.setMaxLines(r15);
    L50:
        if (this.g == (-1)) goto L55;
        UDEditText r17 = this.x;
        if (r17 == null) goto L55;
        r17.setHintTextColor(UDColorUtils.getColor(getContext(), this.g));
    L55:
        if (this.h == (-1)) goto L59;
        UDEditText r18 = this.x;
        if (r18 == null) goto L59;
        r18.setTextColor(UDColorUtils.getColor(getContext(), this.h));
    L59:
        int r19 = this.i;
        if (r19 == (-1)) goto L64;
        SpaceEditText r20 = this.x;
        if (r20 == null) goto L64;
        r20.setBackgroundResource(r19);
    L64:
        int r21 = this.n;
        if (r21 != (-1)) goto L67;
    L71:
        UDEditText r22 = this.x;
        if (r22 == null) goto L74;
        r22.setSelection(this.k.length());
    L74:
        CharSequence r23 = getMMessage();
        if (r23 != null) goto L77;
    L80:
        if (r8 == false) goto L90;
        TextView r24 = (TextView) r0.findViewById(2131391794);
        if (r24 == null) goto L84;
        r24.setVisibility(8);
    L84:
        UDEditText r25 = this.x;
        if (r25 == null) goto L87;
        ViewGroup.LayoutParams r26 = r25.getLayoutParams();
    L88:
        Intrinsics.checkNotNull(r26, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) r26).topMargin = 0;
        goto L90
    L87:
        r26 = null;
    L90:
        if (this.m == null) goto L95;
        UDEditText r27 = this.x;
        if (r27 == null) goto L94;
        r1 = r27.getParent();
    L94:
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r1).addView(this.m);
    L95:
        return r0;
    L77:
        if (r23.length() == 0) goto L80;
        r8 = false;
        goto L80
    L67:
        if (r21 > this.k.length()) goto L71;
        UDEditText r28 = this.x;
        if (r28 == null) goto L74;
        r28.setSelection(this.n);
        goto L74
    }

    public final View onCreateFooter() {
        View r0 = super.onCreateFooter();
        View r2 = null;
        if (this.t == null) goto L12;
        if (r0 == null) goto L6;
        Button r1 = (Button) r0.findViewById(2131391777);
    L7:
        this.v = r1;
        if (r1 == null) goto L10;
        r1.setOnClickListener(new d(this, r1));
    L10:
        b(this.k);
        goto L12
    L6:
        r1 = null;
    L12:
        if (this.u == null) goto L17;
        if (r0 == null) goto L15;
        r2 = r0.findViewById(2131391778);
    L15:
        if (r2 == null) goto L17;
        r2.setOnClickListener(new e(this, r2));
    L17:
        return r0;
    }

    public final void onDismiss() {
        super.onDismiss();
        UDEditText r0 = this.w;
        if (r0 == null) goto L6;
        r0.removeCallbacks(this.A);
        return;
    }

    public final void onShow() {
        super.onShow();
        UDEditText r0 = this.w;
        if (r0 == null) goto L6;
        r0.postDelayed(this.A, 300);
        return;
    }

    public b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.k = "";
        this.n = -1;
        this.p = true;
        this.s = true;
        this.A = new RunnableC0237b(this);
    }

    public final void b(CharSequence r4) {
        boolean r1 = true;
        if (this.q == false) goto L9;
        if (r4.length() > 0) goto L15;
    L7:
        r1 = false;
    L15:
        boolean r5 = this.r;
        if (r5 == false) goto L18;
        r1 = r5;
    L18:
        Button r6 = this.v;
        if (r6 == null) goto L21;
        r6.setEnabled(r1);
    L21:
        if (r1 == false) goto L23;
        int r7 = 2131105548;
    L24:
        Button r0 = this.v;
        if (r0 == null) goto L28;
        r0.setTextColor(getContext().getResources().getColor(r7));
        return;
    L28:
        return;
    L23:
        r7 = 2131105554;
        goto L24
    L9:
        if (r4.length() <= 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L7;
        if (TextUtils.equals(this.k, r4) == true) goto L7;
    L11:
        r2 = false;
        goto L12
    }

    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r2, UDDialog r3) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        Intrinsics.checkNotNullParameter(r3, "dialog");
        if ((r2 instanceof gp5.a) == false) goto L11;
        super.apply(r2, r3);
        gp5.a r4 = (gp5.a) r2;
        this.a = r4.a;
        this.b = r4.b;
        this.c = r4.c;
        this.d = r4.d;
        this.e = r4.e;
        this.f = r4.f;
        this.g = r4.g;
        this.h = r4.h;
        this.i = r4.i;
        this.j = r4.j;
        this.k = r4.k;
        this.l = r4.t;
        this.m = r4.l;
        this.z = r4.v;
        this.n = r4.m;
        this.o = r4.q;
        this.s = r4.w;
        this.p = r4.n;
        this.q = r4.o;
        this.r = r4.p;
        this.t = r4.r;
        this.u = r4.s;
        Configuration r5 = getContext().getResources().getConfiguration();
        if (r5 != null) goto L7;
        return;
    L7:
        if (r5.orientation != 2) goto L13;
        setMWidth(286.0f);
        return;
    L13:
        return;
    L11:
        throw new IllegalArgumentException("builder should be BearUDInputDialogBuilder, but actually ".concat(r2.getClass().getSimpleName()).toString());
    }
}
