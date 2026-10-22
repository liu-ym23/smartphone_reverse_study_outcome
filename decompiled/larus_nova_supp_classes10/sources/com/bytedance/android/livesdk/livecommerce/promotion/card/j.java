package com.bytedance.android.livesdk.livecommerce.promotion.card;

import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j {
    public final HashMap<PromotionCardModuleName, IPromotionUIConfig.d> a;

    public static final class a {
        public IPromotionUIConfig.c a;
        public int b;
        public IPromotionUIConfig.b c;
        public final j d;
        public final PromotionCardModuleName e;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotion.card.j$a$a, reason: collision with other inner class name */
        public static final class C0085a {
            public String a;
            public float[] b;
            public float c;
            public boolean d;
            public int e;
            public String f;
            public float g;
            public float h;
            public final a i;

            public C0085a(a r5, IPromotionUIConfig.b r6) {
                Intrinsics.checkNotNullParameter(r5, "styleFactory");
                this.i = r5;
                boolean r7 = true;
                this.d = true;
                float r0 = 1.0f;
                this.h = 1.0f;
                String r1 = null;
                if (r6 == null) goto L5;
                String r2 = r6.b();
            L6:
                this.a = r2;
                if (r6 == null) goto L9;
                float[] r3 = r6.i();
            L10:
                this.b = r3;
                float r4 = 0.0f;
                if (r6 == null) goto L13;
                float r8 = r6.e();
            L14:
                this.c = r8;
                if (r6 == null) goto L17;
                r7 = r6.f();
            L17:
                this.d = r7;
                if (r6 == null) goto L20;
                int r9 = r6.g();
            L21:
                this.e = r9;
                if (r6 == null) goto L24;
                r1 = r6.d();
            L24:
                this.f = r1;
                if (r6 == null) goto L27;
                r4 = r6.h();
            L27:
                this.g = r4;
                if (r6 == null) goto L30;
                r0 = r6.c();
            L30:
                this.h = r0;
                return;
            L20:
                r9 = 0;
                goto L21
            L13:
                r8 = 0.0f;
                goto L14
            L9:
                r3 = null;
                goto L10
            L5:
                r2 = null;
                goto L6
            }
        }

        public static final class b {
            public int a;
            public int b;
            public Integer c;
            public Integer d;
            public Integer e;
            public Integer f;
            public Integer g;
            public Integer h;
            public Integer i;
            public Integer j;
            public final PromotionCardModuleName k;
            public final PromotionCardModuleName l;
            public final PromotionCardModuleName m;
            public final PromotionCardModuleName n;
            public final PromotionCardModuleName o;
            public final PromotionCardModuleName p;
            public final PromotionCardModuleName q;
            public final PromotionCardModuleName r;
            public final a s;

            public b(a r2, IPromotionUIConfig.c r3) {
                Intrinsics.checkNotNullParameter(r2, "styleFactory");
                this.s = r2;
                int r4 = 0;
                if (r3 == null) goto L5;
                int r0 = r3.r();
            L6:
                this.a = r0;
                if (r3 == null) goto L9;
                r4 = r3.c();
            L9:
                this.b = r4;
                PromotionCardModuleName r5 = null;
                if (r3 == null) goto L12;
                Integer r1 = r3.m();
            L13:
                this.c = r1;
                if (r3 == null) goto L16;
                Integer r6 = r3.l();
            L17:
                this.d = r6;
                if (r3 == null) goto L20;
                Integer r7 = r3.j();
            L21:
                this.e = r7;
                if (r3 == null) goto L24;
                Integer r8 = r3.k();
            L25:
                this.f = r8;
                if (r3 == null) goto L28;
                Integer r9 = r3.i();
            L29:
                this.g = r9;
                if (r3 == null) goto L32;
                Integer r10 = r3.h();
            L33:
                this.h = r10;
                if (r3 == null) goto L36;
                Integer r11 = r3.f();
            L37:
                this.i = r11;
                if (r3 == null) goto L40;
                Integer r12 = r3.g();
            L41:
                this.j = r12;
                if (r3 == null) goto L44;
                PromotionCardModuleName r13 = r3.d();
            L45:
                this.k = r13;
                if (r3 == null) goto L48;
                PromotionCardModuleName r14 = r3.e();
            L49:
                this.l = r14;
                if (r3 == null) goto L52;
                PromotionCardModuleName r15 = r3.n();
            L53:
                this.m = r15;
                if (r3 == null) goto L56;
                PromotionCardModuleName r16 = r3.o();
            L57:
                this.n = r16;
                if (r3 == null) goto L60;
                PromotionCardModuleName r17 = r3.q();
            L61:
                this.o = r17;
                if (r3 == null) goto L64;
                PromotionCardModuleName r18 = r3.p();
            L65:
                this.p = r18;
                if (r3 == null) goto L68;
                PromotionCardModuleName r19 = r3.b();
            L69:
                this.q = r19;
                if (r3 == null) goto L72;
                r5 = r3.a();
            L72:
                this.r = r5;
                return;
            L68:
                r19 = null;
                goto L69
            L64:
                r18 = null;
                goto L65
            L60:
                r17 = null;
                goto L61
            L56:
                r16 = null;
                goto L57
            L52:
                r15 = null;
                goto L53
            L48:
                r14 = null;
                goto L49
            L44:
                r13 = null;
                goto L45
            L40:
                r12 = null;
                goto L41
            L36:
                r11 = null;
                goto L37
            L32:
                r10 = null;
                goto L33
            L28:
                r9 = null;
                goto L29
            L24:
                r8 = null;
                goto L25
            L20:
                r7 = null;
                goto L21
            L16:
                r6 = null;
                goto L17
            L12:
                r1 = null;
                goto L13
            L5:
                r0 = 0;
                goto L6
            }
        }

        public final void a(Function1 r12) {
            Intrinsics.checkNotNullParameter(r12, "factory");
            C0085a r0 = new C0085a(this, this.c);
            r12.invoke(r0);
            a r13 = r0.i;
            r13.c = new IPromotionUIConfig.b(r0.a, r0.b, r0.c, r0.d, r0.e, r0.f, r0.g, r0.h);
        }

        public final void b(Function1 r24) {
            Intrinsics.checkNotNullParameter(r24, "factory");
            b r2 = new b(this, this.a);
            r24.invoke(r2);
            a r1 = r2.s;
            r1.a = new IPromotionUIConfig.c(r2.a, r2.b, r2.c, r2.d, r2.e, r2.f, r2.g, r2.h, r2.i, r2.j, r2.k, r2.l, r2.m, r2.n, r2.o, r2.p, r2.q, r2.r);
        }

        public a(j r2, PromotionCardModuleName r3, IPromotionUIConfig.d r4) {
            Intrinsics.checkNotNullParameter(r2, "configFactory");
            Intrinsics.checkNotNullParameter(r3, "module");
            this.d = r2;
            this.e = r3;
            int r5 = -1;
            this.b = -1;
            IPromotionUIConfig.b r6 = null;
            if (r4 == null) goto L5;
            IPromotionUIConfig.c r0 = r4.b();
        L6:
            this.a = r0;
            if (r4 == null) goto L9;
            r5 = r4.c();
        L9:
            this.b = r5;
            if (r4 == null) goto L12;
            r6 = r4.a();
        L12:
            this.c = r6;
            return;
        L5:
            r0 = null;
            goto L6
        }
    }

    public j(Map<PromotionCardModuleName, IPromotionUIConfig.d> r2) {
        HashMap<PromotionCardModuleName, IPromotionUIConfig.d> r0 = new HashMap();
        this.a = r0;
        if (r2 == null) goto L6;
        r0.putAll(r2);
        return;
    }

    public final j a(PromotionCardModuleName r6, Function1<? super a, Unit> r7) {
        Intrinsics.checkNotNullParameter(r6, "module");
        Intrinsics.checkNotNullParameter(r7, "factory");
        a r0 = new a(this, r6, this.a.get(r6));
        r7.invoke(r0);
        j r8 = r0.d;
        PromotionCardModuleName r9 = r0.e;
        IPromotionUIConfig.d r1 = new IPromotionUIConfig.d(r0.c, r0.b, r0.a);
        r8.a.put(r9, r1);
        return r0.d;
    }
}
