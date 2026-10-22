package com.bytedance.ee.bear.more.view3.ui;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.bytedance.ee.bear.more.protocol3.k;
import com.bytedance.ee.bear.more.protocol3.panel.ItemUIStyle;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class UINormalItem extends com.bytedance.ee.bear.more.view3.ui.a {
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final View.OnClickListener q;
    public final MoreUiAction r;
    public final Function2<Context, Integer, Drawable> s;
    public final boolean t;
    public final Lazy u;

    public static final class a {
    }

    public final class b extends k {
        public final String e;
        public final /* synthetic */ UINormalItem f;

        @Override // com.bytedance.ee.bear.more.protocol3.k
        public final int e() {
            return this.f.i(2131563670, 2131563671);
        }

        public b(UINormalItem r3) {
            this.f = r3;
            super(r3.a);
            this.e = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a();
        }

        @Override // com.bytedance.ee.bear.more.protocol3.k
        public final void a(View r7) {
            Intrinsics.checkNotNullParameter(r7, "itemView");
            AppCompatImageView r1 = r7.findViewById(2131380307);
            TextView r2 = (TextView) r7.findViewById(2131380309);
            UDBadgeView r3 = r7.findViewById(2131380308);
            UINormalItem r4 = this.f;
            int r5 = com.bytedance.ee.bear.more.view3.ui.a.m;
            r4.g(r1, r2, null);
            if (Intrinsics.areEqual(this.e, Locale.ENGLISH.getLanguage()) == false) goto L8;
            if (this.d == ItemUIStyle.DOUBAO) goto L8;
            r2.setTextSize(2, 11.0f);
        L8:
            if (this.f.n == true) goto L10;
        L12:
            int r6 = 8;
        L13:
            r3.setVisibility(r6);
            UINormalItem r8 = this.f;
            r8.getClass();
            Intrinsics.checkNotNullParameter(r7, "itemView");
            r7.setOnClickListener(new com.bytedance.ee.bear.more.view3.ui.b(r8, null));
            return;
        L10:
            if (com.bytedance.ee.bear.more.k.a(this.a) == false) goto L12;
            r6 = 0;
            goto L13
        }
    }

    public final class c extends k {
        public final /* synthetic */ UINormalItem e;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ UINormalItem a;

            /* JADX INFO: renamed from: com.bytedance.ee.bear.more.view3.ui.UINormalItem$c$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0124a {
                public static final /* synthetic */ int[] a = null;

                static {
                    int[] r0 = new int[MoreUiAction.MoreAction.values().length];
                    r0[MoreUiAction.MoreAction.PERM_PLATFORM_ACTION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
                L9:
                    r0[MoreUiAction.MoreAction.UNEAABLE_TIPS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
                L5:
                    a = r0;
                }
            }

            public a(UINormalItem r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r6) {
                UINormalItem r0 = this.a;
                MoreUiAction r1 = r0.r;
                if (r1 == null) goto L22;
                MoreUiAction.MoreAction r2 = r1.getAction();
                int r3 = C0124a.a[r2.ordinal()];
                if (r3 != 1) goto L7;
                View.OnClickListener r7 = r0.q;
                if (r7 == null) goto L26;
                r7.onClick(null);
                return;
            L26:
                return;
            L7:
                if (r3 != 2) goto L22;
                if (r0.h == true) goto L22;
                if (TextUtils.isEmpty(r1.getMsg()) == true) goto L14;
                Toast.showFailureText(r6.getContext(), r1.getMsg(), 0);
                return;
            L14:
                View.OnClickListener r8 = r0.q;
                if (r8 == null) goto L25;
                r8.onClick(null);
                return;
            L25:
                return;
            L22:
                UINormalItem r4 = this.a;
                Intrinsics.checkNotNull(r6);
                UINormalItem r5 = this.a;
                boolean r9 = r5.h;
                String r10 = r5.i;
                View.OnClickListener r11 = r5.j;
                View.OnClickListener r12 = r5.q;
                r4.getClass();
                com.bytedance.ee.bear.more.view3.ui.a.h(r6, r9, r10, r11, r12);
            }
        }

        @Override // com.bytedance.ee.bear.more.protocol3.k
        public final int e() {
            return this.e.i(2131563690, 2131563691);
        }

        public c(UINormalItem r1) {
            this.e = r1;
            super(r1.a);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.bytedance.ee.bear.more.protocol3.k
        public final void a(View r19) {
            Intrinsics.checkNotNullParameter(r19, "itemView");
            AppCompatImageView r2 = r19.findViewById(2131374718);
            TextView r3 = (TextView) r19.findViewById(2131388772);
            UDBadgeView r4 = r19.findViewById(2131363831);
            TextView r5 = (TextView) r19.findViewById(2131380689);
            UINormalItem r6 = this.e;
            int r7 = com.bytedance.ee.bear.more.view3.ui.a.m;
            String r8 = null;
            r6.g(r2, r3, null);
            UINormalItem r9 = this.e;
            if (r9.n == true) goto L5;
        L9:
            int r10 = 8;
        L10:
            r4.setVisibility(r10);
            if (this.e.o == true) goto L13;
        L15:
            UINormalItem r11 = this.e;
            if (r11.o == true) goto L18;
        L22:
            int r12 = 8;
        L23:
            r5.setVisibility(r12);
            UINormalItem r13 = this.e;
            boolean r14 = r13.h;
            TextView r15 = (TextView) r19.findViewById(2131373298);
            if (r15 == null) goto L48;
            Object r16 = r15.getTag(2025031300);
            if (r16 != null) goto L29;
        L38:
            TextPaint r17 = r15.getPaint();
            CharSequence r18 = r15.getText();
            if (r18 == null) goto L41;
            r8 = r18.toString();
        L41:
            LinearGradient r20 = new LinearGradient(r17.measureText(r8), 0.0f, 0.0f, r15.getTextSize(), r15.getContext().getResources().getColor(2131108768), r15.getContext().getResources().getColor(2131108678), Shader.TileMode.CLAMP);
            r17.setShader(r20);
            r15.setTag(2025031300, r20);
            Unit r21 = Unit.INSTANCE;
        L42:
            if (r14 == true) goto L44;
        L46:
            int r22 = 8;
        L47:
            r15.setVisibility(r22);
            goto L48
        L44:
            if (r13.p == false) goto L46;
            r22 = 0;
            goto L47
        L29:
            if ((r16 instanceof Shader) == true) goto L32;
            r16 = null;
        L32:
            if (r16 == null) goto L38;
            if ((r16 instanceof Shader) == false) goto L36;
            Shader r23 = (Shader) r16;
        L37:
            if (r23 != null) goto L42;
        L36:
            r23 = null;
        L48:
            r19.setOnClickListener(new a(this.e));
            return;
        L18:
            if (r11.h == false) goto L22;
            if (com.bytedance.ee.bear.more.k.b(this.a) == false) goto L22;
            r12 = 0;
            goto L23
        L13:
            if ((r3.getLayoutParams() instanceof ConstraintLayout.LayoutParams) == false) goto L15;
            ViewGroup.LayoutParams r24 = r3.getLayoutParams();
            Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams r25 = (ConstraintLayout.LayoutParams) r24;
            r25.setMarginEnd(y9c.d.a(40));
            r3.setLayoutParams(r25);
            goto L15
        L5:
            if (r9.h == false) goto L9;
            if (com.bytedance.ee.bear.more.k.a(this.a) == false) goto L9;
            r10 = 0;
            goto L10
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final int e() {
        k r0 = (k) this.u.getValue();
        r0.d = this.d;
        return r0.e();
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final void a(View r3) {
        Intrinsics.checkNotNullParameter(r3, "itemView");
        super.a(r3);
        k r0 = (k) this.u.getValue();
        r0.d = this.d;
        r0.c = this.c;
        r0.a(r3);
    }

    @Override // com.bytedance.ee.bear.more.protocol3.k
    public final boolean f(k r5) {
        Intrinsics.checkNotNullParameter(r5, "obj");
        if ((r5 instanceof UINormalItem) == false) goto L39;
        UINormalItem r6 = (UINormalItem) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L9;
        return false;
    L9:
        if (this.f == r6.f) goto L11;
        return false;
    L11:
        if (this.g == r6.g) goto L13;
        return false;
    L13:
        if (this.n == r6.n) goto L15;
        return false;
    L15:
        if (this.o == r6.o) goto L17;
        return false;
    L17:
        if (this.p == r6.p) goto L19;
        return false;
    L19:
        if (this.h == r6.h) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L23;
        return false;
    L23:
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L25;
        return false;
    L25:
        if (this.s != null) goto L27;
        boolean r0 = true;
    L29:
        if (r6.s != null) goto L31;
        boolean r3 = true;
    L32:
        if (r0 == r3) goto L34;
        return false;
    L34:
        if (this.t == r6.t) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.c, r6.c) == false) goto L52;
        return true;
    L52:
        return false;
    L31:
        r3 = false;
        goto L32
    L27:
        r0 = false;
        goto L29
    L39:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UINormalItem(String r12, String r13, int r14, int r15, boolean r16, boolean r17, boolean r18, boolean r19, String r20, View.OnClickListener r21, View.OnClickListener r22, MoreUiAction r23, Function2<? super Context, ? super Integer, ? extends Drawable> r24, boolean r25) {
        Intrinsics.checkNotNullParameter(r12, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r13, "title");
        Intrinsics.checkNotNullParameter(r20, "disableReason");
        super(r12, r13, r14, r15, r19, r20, r21, r24, r25);
        this.n = r16;
        this.o = r17;
        this.p = r18;
        this.q = r22;
        this.r = r23;
        this.s = r24;
        this.t = r25;
        this.u = LazyKt.lazy(new UINormalItem$uiItem$2(this));
    }
}
