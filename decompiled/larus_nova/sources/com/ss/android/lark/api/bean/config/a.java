package com.ss.android.lark.api.bean.config;

import androidx.fragment.app.Fragment;
import com.ss.android.lark.api.ui.ForsetiPlaceHolderFragment;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f408666g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f408667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f408668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ForsetiPageType f408669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Fragment f408670d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Fragment> f408671e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f408672f;

    /* JADX INFO: renamed from: com.ss.android.lark.api.bean.config.a$a, reason: collision with other inner class name */
    public static final class C4743a {
        @JvmStatic
        public static a a() {
            ForsetiMarginType r100 = ForsetiMarginType.DEFAULT;
            c r101 = new c(r100, null);
            c r102 = new c(r100, null);
            ForsetiPageType.Companion.getClass();
            return new a(r101, r102, ForsetiPageType.access$getDEFAULT$cp(), null, 56);
        }
    }

    static {
    }

    public a() {
        this(null, null, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f408667a, r101.f408667a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f408668b, r101.f408668b) == true) goto L15;
        return false;
    L15:
        if (this.f408669c == r101.f408669c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f408670d, r101.f408670d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f408671e, r101.f408671e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f408672f, r101.f408672f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f408667a.hashCode() * 31) + this.f408668b.hashCode()) * 31) + this.f408669c.hashCode()) * 31;
        Fragment r101 = this.f408670d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Function0<Fragment> r105 = this.f408671e;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return ((r104 + r102) * 31) + this.f408672f.hashCode();
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ForsetiChainConfig(topMargin=" + this.f408667a + ", bottomMargin=" + this.f408668b + ", forsetiPageType=" + this.f408669c + ", forsetiPlaceHolderFragment=" + this.f408670d + ", forsetiPlaceHolderProvider=" + this.f408671e + ", extraOptions=" + this.f408672f + ')';
    }

    public a(c r100, c r101, ForsetiPageType r102, b r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = new c(0);
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = new c(0);
    L9:
        if ((r104 & 4) == 0) goto L12;
        ForsetiPageType.Companion.getClass();
        r102 = ForsetiPageType.access$getDEFAULT$cp();
    L12:
        if ((r104 & 8) == 0) goto L14;
        ForsetiPlaceHolderFragment r105 = new ForsetiPlaceHolderFragment();
    L16:
        if ((r104 & 16) == 0) goto L18;
        ForsetiChainConfig$1 r106 = ForsetiChainConfig$1.INSTANCE;
    L20:
        if ((r104 & 32) == 0) goto L22;
        r103 = new b(false, false, null, 127);
    L22:
        Intrinsics.checkNotNullParameter(r100, "topMargin");
        Intrinsics.checkNotNullParameter(r101, "bottomMargin");
        Intrinsics.checkNotNullParameter(r102, "forsetiPageType");
        Intrinsics.checkNotNullParameter(r103, "extraOptions");
        this.f408667a = r100;
        this.f408668b = r101;
        this.f408669c = r102;
        this.f408670d = r105;
        this.f408671e = r106;
        this.f408672f = r103;
        return;
    L18:
        r106 = null;
        goto L20
    L14:
        r105 = null;
        goto L16
    }
}
