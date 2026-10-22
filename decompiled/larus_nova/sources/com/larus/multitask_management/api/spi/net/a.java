package com.larus.multitask_management.api.spi.net;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import nuc.b2;
import nuc.g2;

/* JADX INFO: loaded from: classes4.dex */
@Serializable
public final class a<T> {
    public static final b Companion = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g2 f359392e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f359393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f359394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f359395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final T f359396d;

    public static final class b {
        public b() {
        }

        public final <T> juc.d<a<T>> serializer(final juc.d<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "typeSerial0");
            return new C4422a(r100);
        }
    }

    public a() {
        this(0, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f359393a == r101.f359393a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f359394b, r101.f359394b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f359395c, r101.f359395c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f359396d, r101.f359396d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f359393a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f359394b;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f359395c;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        T r109 = this.f359396d;
        if (r109 == null) goto L15;
        r103 = r109.hashCode();
    L15:
        return r108 + r103;
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public final String toString() {
        return "BizResponse(code=" + this.f359393a + ", msg=" + this.f359394b + ", payload=" + this.f359395c + ", data=" + this.f359396d + ')';
    }

    static {
        Companion = new b();
        g2 r100 = new g2("com.larus.multitask_management.api.spi.net.BizResponse", null, 4);
        r100.j("code", true);
        r100.j("msg", true);
        r100.j(WsConstants.KEY_PAYLOAD, true);
        r100.j("data", true);
        f359392e = r100;
    }

    public final boolean a() {
        if (this.f359393a != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public a(long r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        String r102 = "";
        if ((r101 & 2) == 0) goto L8;
        String r103 = "";
    L10:
        if ((r101 & 4) != 0) goto L13;
        r102 = null;
    L13:
        this.f359393a = r100;
        this.f359394b = r103;
        this.f359395c = r102;
        this.f359396d = null;
        return;
    L8:
        r103 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ a(int r100, long r101, String r102, String r103, Object r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, f359392e);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = 0;
    L7:
        this.f359393a = r101;
        if ((r100 & 2) != 0) goto L10;
        this.f359394b = "";
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.f359395c = "";
    L16:
        if ((r100 & 8) != 0) goto L18;
        this.f359396d = null;
        return;
    L18:
        this.f359396d = r104;
        return;
    L14:
        this.f359395c = r103;
        goto L16
    L10:
        this.f359394b = r102;
        goto L12
    }
}
