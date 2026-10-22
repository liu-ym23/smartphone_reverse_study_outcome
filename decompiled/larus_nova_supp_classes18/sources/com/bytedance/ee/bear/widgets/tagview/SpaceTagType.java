package com.bytedance.ee.bear.widgets.tagview;

import android.content.Context;
import android.view.View;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class SpaceTagType {
    public static final /* synthetic */ int e = 0;
    public boolean a;
    public final Integer b;
    public final Integer c;
    public final Function1<Context, View> d;

    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        public static SpaceTagType a(boolean r3) {
            return new SpaceTagType(r3, null, null, SpaceTagType$Companion$appPerm$1.INSTANCE);
        }

        @JvmStatic
        public static SpaceTagType b(boolean r3) {
            return new SpaceTagType(r3, null, null, SpaceTagType$Companion$enterprisePublic$1.INSTANCE);
        }

        @JvmStatic
        public static SpaceTagType c(boolean r3) {
            return new SpaceTagType(r3, null, null, SpaceTagType$Companion$external$1.INSTANCE);
        }

        @JvmStatic
        public static SpaceTagType d(boolean r3) {
            return new SpaceTagType(r3, null, null, SpaceTagType$Companion$internetPublic$1.INSTANCE);
        }

        @JvmStatic
        public static SpaceTagType g(boolean r4) {
            return new SpaceTagType(r4, 1, 60, SpaceTagType$Companion$risk$1.INSTANCE);
        }

        @JvmStatic
        public static SpaceTagType h(boolean r3) {
            return new SpaceTagType(r3, null, null, SpaceTagType$Companion$star$1.INSTANCE);
        }

        @JvmStatic
        public static SpaceTagType i(boolean r3) {
            return new SpaceTagType(r3, null, null, SpaceTagType$Companion$template$1.INSTANCE);
        }

        @JvmStatic
        public static SpaceTagType e(final String r4, boolean r5) {
            boolean r1 = false;
            if (r4 != null) goto L5;
        L8:
            boolean r3 = true;
        L9:
            if (r3 == true) goto L13;
            if (r5 == false) goto L13;
            r1 = true;
        L13:
            return new SpaceTagType(r1, 1, 60, new SpaceTagType$Companion$normal$1(r4));
        L5:
            if (r4.length() == 0) goto L8;
            r3 = false;
            goto L9
        }

        @JvmStatic
        public static SpaceTagType f(final String r5, boolean r6, boolean r7) {
            boolean r0 = false;
            if (r5 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == false) goto L11;
        L13:
            if (r6 == false) goto L17;
            if (r7 == false) goto L17;
            r0 = true;
        L17:
            return c(r0);
        L11:
            if (((a) org.koin.java.a.c(a.class, null, null, 6)).isEnable() == false) goto L13;
            return new SpaceTagType(r7, 1, 60, new SpaceTagType$Companion$organizationName$1(r5));
        L5:
            if (r5.length() == 0) goto L8;
            r2 = false;
            goto L9
        }
    }

    static {
        new Companion();
    }

    @JvmStatic
    public static final SpaceTagType b(String r0, boolean r1, boolean r2) {
        return Companion.f(r0, r1, r2);
    }

    @JvmStatic
    public static final SpaceTagType a(boolean r3) {
        return new SpaceTagType(r3, null, null, SpaceTagType$Companion$app$1.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SpaceTagType(boolean r1, Integer r2, Integer r3, Function1<? super Context, ? extends View> r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
