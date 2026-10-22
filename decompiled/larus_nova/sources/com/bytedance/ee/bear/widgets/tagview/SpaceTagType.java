package com.bytedance.ee.bear.widgets.tagview;

import android.content.Context;
import android.view.View;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes18.dex */
public final class SpaceTagType {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f240339e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f240340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f240341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f240342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Context, View> f240343d;

    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        public static SpaceTagType a(boolean r100) {
            return new SpaceTagType(r100, null, null, SpaceTagType$Companion$appPerm$1.INSTANCE);
        }

        @JvmStatic
        public static SpaceTagType b(boolean r100) {
            return new SpaceTagType(r100, null, null, SpaceTagType$Companion$enterprisePublic$1.INSTANCE);
        }

        @JvmStatic
        public static SpaceTagType c(boolean r100) {
            return new SpaceTagType(r100, null, null, SpaceTagType$Companion$external$1.INSTANCE);
        }

        @JvmStatic
        public static SpaceTagType d(boolean r100) {
            return new SpaceTagType(r100, null, null, SpaceTagType$Companion$internetPublic$1.INSTANCE);
        }

        @JvmStatic
        public static SpaceTagType g(boolean r100) {
            return new SpaceTagType(r100, 1, 60, SpaceTagType$Companion$risk$1.INSTANCE);
        }

        @JvmStatic
        public static SpaceTagType h(boolean r100) {
            return new SpaceTagType(r100, null, null, SpaceTagType$Companion$star$1.INSTANCE);
        }

        @JvmStatic
        public static SpaceTagType i(boolean r100) {
            return new SpaceTagType(r100, null, null, SpaceTagType$Companion$template$1.INSTANCE);
        }

        @JvmStatic
        public static SpaceTagType e(final String r100, boolean r101) {
            boolean r102 = false;
            if (r100 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == true) goto L13;
            if (r101 == false) goto L13;
            r102 = true;
        L13:
            return new SpaceTagType(r102, 1, 60, new SpaceTagType$Companion$normal$1(r100));
        L5:
            if (r100.length() == 0) goto L8;
            r103 = false;
            goto L9
        }

        @JvmStatic
        public static SpaceTagType f(final String r100, boolean r101, boolean r102) {
            boolean r103 = false;
            if (r100 != null) goto L5;
        L8:
            boolean r104 = true;
        L9:
            if (r104 == false) goto L11;
        L13:
            if (r101 == false) goto L17;
            if (r102 == false) goto L17;
            r103 = true;
        L17:
            return c(r103);
        L11:
            if (((a) org.koin.java.a.c(a.class, null, null, 6)).isEnable() == false) goto L13;
            return new SpaceTagType(r102, 1, 60, new SpaceTagType$Companion$organizationName$1(r100));
        L5:
            if (r100.length() == 0) goto L8;
            r104 = false;
            goto L9
        }
    }

    static {
        new Companion();
    }

    @JvmStatic
    public static final SpaceTagType b(String r100, boolean r101, boolean r102) {
        return Companion.f(r100, r101, r102);
    }

    @JvmStatic
    public static final SpaceTagType a(boolean r100) {
        return new SpaceTagType(r100, null, null, SpaceTagType$Companion$app$1.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SpaceTagType(boolean r100, Integer r101, Integer r102, Function1<? super Context, ? extends View> r103) {
        this.f240340a = r100;
        this.f240341b = r101;
        this.f240342c = r102;
        this.f240343d = r103;
    }
}
