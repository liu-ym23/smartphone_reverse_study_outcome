package com.larus.dora.impl.device.manage;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x0 f334087a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f334088b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f334089c = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f334090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f334091b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f334092c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f334093d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f334094e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f334095f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f334096g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Integer f334097h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f334098i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f334099j;

        public a() {
            this(null, null, null, 0, 0, 0, null, null, null, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f334090a, r101.f334090a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f334091b, r101.f334091b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f334092c, r101.f334092c) == true) goto L18;
            return false;
        L18:
            if (this.f334093d == r101.f334093d) goto L21;
            return false;
        L21:
            if (this.f334094e == r101.f334094e) goto L24;
            return false;
        L24:
            if (this.f334095f == r101.f334095f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f334096g, r101.f334096g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f334097h, r101.f334097h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f334098i, r101.f334098i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.f334099j, r101.f334099j) == true) goto L38;
            return false;
        L38:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f334090a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f334091b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f334092c;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (((((((r106 + r108) * 31) + this.f334093d) * 31) + this.f334094e) * 31) + this.f334095f) * 31;
            String r110 = this.f334096g;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            Integer r113 = this.f334097h;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.f334098i;
            if (r116 != null) goto L25;
            int r117 = 0;
        L26:
            int r118 = (r115 + r117) * 31;
            String r119 = this.f334099j;
            if (r119 == null) goto L31;
            r101 = r119.hashCode();
        L31:
            return r118 + r101;
        L25:
            r117 = r116.hashCode();
            goto L26
        L21:
            r114 = r113.hashCode();
            goto L22
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "CachedDeviceInfo(name=" + this.f334090a + ", mac=" + this.f334091b + ", sn=" + this.f334092c + ", sku=" + this.f334093d + ", type=" + this.f334094e + ", productId=" + this.f334095f + ", model=" + this.f334096g + ", vendorId=" + this.f334097h + ", softVersion=" + this.f334098i + ", caseSoftVersion=" + this.f334099j + ')';
        }

        public final DoraDevice a() {
            DoraDevice r100 = new DoraDevice();
            r100.name = this.f334090a;
            r100.f204389mac = this.f334091b;
            r100.f204390sn = this.f334092c;
            r100.sku = this.f334093d;
            r100.type = this.f334094e;
            r100.productId = this.f334095f;
            r100.model = this.f334096g;
            Integer r101 = this.f334097h;
            if (r101 == null) goto L5;
            r100.vendorId = r101.intValue();
        L5:
            r100.softVersion = this.f334098i;
            r100.caseSoftVersion = this.f334099j;
            return r100;
        }

        public final int getType() {
            return this.f334094e;
        }

        public a(String r100, String r101, String r102, int r103, int r104, int r105, String r106, Integer r107, String r108, String r110) {
            this.f334090a = r100;
            this.f334091b = r101;
            this.f334092c = r102;
            this.f334093d = r103;
            this.f334094e = r104;
            this.f334095f = r105;
            this.f334096g = r106;
            this.f334097h = r107;
            this.f334098i = r108;
            this.f334099j = r110;
        }
    }

    public x0() {
    }

    static {
        f334087a = new x0();
        f334088b = LazyKt.lazy(new v0());
        f334089c = LazyKt.lazy(new w0());
    }

    public static DoraDevice a() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L18
        String r102 = ((Keva) f334088b.getValue()).getString("last_connected_device_info", "");     // Catch: Throwable -> L18
        if (r102 != null) goto L6;
    L9:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
        g49.d.d("DoraLastConnectedDeviceCache", "getDevice empty cache");     // Catch: Throwable -> L18
    L15:
        DoraDevice r104 = null;
    L16:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L18
    L20:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L24;
        g49.d.b("DoraLastConnectedDeviceCache", "getDevice failed error=" + r106.getMessage());
    L24:
        if (Result.m9455isFailureimpl(r105) == true) goto L28;
        r100 = r105;
    L28:
        return (DoraDevice) r100;
    L12:
        a r107 = (a) ((Gson) f334089c.getValue()).fromJson(r102, a.class);     // Catch: Throwable -> L18
        if (r107 == null) goto L15;
        r104 = r107.a();     // Catch: Throwable -> L18
        g49.d.d("DoraLastConnectedDeviceCache", "getDevice mac=" + r104.f204389mac + ", productId=" + r104.productId + ", model=" + r104.model);     // Catch: Throwable -> L18
        goto L16
    L6:
        if (r102.length() == 0) goto L9;
        r103 = false;
    L18:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    }

    public static void b(DoraDevice r110, String r210) {
        Intrinsics.checkNotNullParameter(r110, "device");
        Intrinsics.checkNotNullParameter(r210, "source");
        String r100 = r110.name;
        String r111 = r110.f204389mac;
        String r101 = r110.f204390sn;
        int r102 = r110.sku;
        int r112 = r110.type;
        int r113 = r110.productId;
        String r114 = r110.model;
        a r103 = new a(r100, r111, r101, r102, r112, r113, r114, Integer.valueOf(r110.vendorId), r110.softVersion, r110.caseSoftVersion);
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L9
        ((Keva) f334088b.getValue()).storeString("last_connected_device_info", ((Gson) f334089c.getValue()).toJson(r103));     // Catch: Throwable -> L9
        String r105 = "DoraLastConnectedDeviceCache";
        g49.d.d(r105, "save source=" + r210 + ", mac=" + r111 + ", productId=" + r113 + ", model=" + r114);     // Catch: Throwable -> L7
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L12:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L20;
        g49.d.b(r105, "save failed source=" + r210 + ", error=" + r107.getMessage());
        return;
    L20:
        return;
    L7:
        th = th;
    L11:
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L9:
        th = th;
        r105 = "DoraLastConnectedDeviceCache";
        goto L11
    }
}
