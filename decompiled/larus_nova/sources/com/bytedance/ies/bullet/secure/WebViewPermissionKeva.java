package com.bytedance.ies.bullet.secure;

import android.net.Uri;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.keva.Keva;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class WebViewPermissionKeva {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f247747a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<String> f247748b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f247749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f247750b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f247749a == r101.f247749a) goto L12;
            return false;
        L12:
            if (this.f247750b == r101.f247750b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f247749a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f247750b == true) goto L11;
            r100 = 1237;
        L11:
            return r102 + r100;
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "PermissionStatus(granted=" + this.f247749a + ", retain=" + this.f247750b + ')';
        }

        public a(boolean r100, boolean r101) {
            this.f247749a = r100;
            this.f247750b = r101;
        }
    }

    static {
        f247747a = LazyKt.lazy(WebViewPermissionKeva$keva$2.INSTANCE);
        f247748b = new CopyOnWriteArrayList();
    }

    public static String a(String r100, String r101) {
        return r100 + '|' + r101;
    }

    public static a b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        Intrinsics.checkNotNullParameter(r101, "resource");
        String r102 = a(r100, r101);
        Boolean r103 = Boolean.valueOf(f247748b.contains(r102));
        if (r103.booleanValue() == true) goto L7;
        r103 = null;
    L7:
        if (r103 == null) goto L10;
        r103.booleanValue();
        return new a(true, false);
    L10:
        Lazy r104 = f247747a;
        if (((Keva) r104.getValue()).contains(r102) == true) goto L14;
        return null;
    L14:
        return new a(((Keva) r104.getValue()).getBoolean(r102, false), true);
    }

    public static void c(String r100, String r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        Intrinsics.checkNotNullParameter(r101, "resource");
        if (r103 == false) goto L5;
        f247748b.add(a(r100, r101));
        return;
    L5:
        Lazy r104 = f247747a;
        if (((Keva) r104.getValue()).count() < 80) goto L8;
        ((Keva) r104.getValue()).clear();
    L8:
        ((Keva) r104.getValue()).storeBoolean(a(r100, r101), r102);
    }

    public static void d(Uri r100, List r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        Intrinsics.checkNotNullParameter(r101, "resourceList");
        String r104 = r100.toString();
        Intrinsics.checkNotNullParameter(r104, PlayerResolution.SDKKEY.ORIGIN);
        Intrinsics.checkNotNullParameter(r101, "resourceList");
        Iterator r105 = r101.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        c(r104, (String) r105.next(), r102, r103);
        goto L4
    }
}
