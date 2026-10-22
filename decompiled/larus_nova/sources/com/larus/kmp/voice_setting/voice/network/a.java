package com.larus.kmp.voice_setting.voice.network;

import com.bytedance.common.wschannel.WsConstants;
import juc.d;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import nuc.b2;
import nuc.g2;

/* JADX INFO: loaded from: classes30.dex */
@Serializable
public final class a<T> {
    public static final b Companion = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g2 f353983e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f353984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f353985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f353986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final T f353987d;

    public static final class b {
        public b() {
        }

        public final <T> d<a<T>> serializer(final d<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "typeSerial0");
            return new C4392a(r100);
        }
    }

    public a() {
        long r100 = 0;
        this(r100, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f353984a == r101.f353984a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f353985b, r101.f353985b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f353986c, r101.f353986c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f353987d, r101.f353987d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f353984a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f353985b;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f353986c;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        T r109 = this.f353987d;
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
        return "BizResponse(code=" + this.f353984a + ", msg=" + this.f353985b + ", payload=" + this.f353986c + ", data=" + this.f353987d + ')';
    }

    static {
        Companion = new b();
        g2 r100 = new g2("com.larus.kmp.voice_setting.voice.network.BizResponse", null, 4);
        r100.j("code", true);
        r100.j("msg", true);
        r100.j(WsConstants.KEY_PAYLOAD, true);
        r100.j("data", true);
        f353983e = r100;
    }

    public /* synthetic */ a(long r100, Object r101, int r110) {
        if ((r110 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        long r102 = r100;
        if ((r110 & 2) == 0) goto L8;
        String r103 = "";
    L10:
        if ((r110 & 4) == 0) goto L12;
        String r104 = "";
    L14:
        if ((r110 & 8) == 0) goto L16;
        Object r105 = null;
    L17:
        this(r102, r103, r104, r105);
        return;
    L16:
        r105 = r101;
        goto L17
    L12:
        r104 = null;
        goto L14
    L8:
        r103 = null;
        goto L10
    }

    public a(long r100, String r101, String r102, T r103) {
        this.f353984a = r100;
        this.f353985b = r101;
        this.f353986c = r102;
        this.f353987d = r103;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ a(int r100, long r101, String r102, String r103, Object r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, f353983e);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = 0;
    L7:
        this.f353984a = r101;
        if ((r100 & 2) != 0) goto L10;
        this.f353985b = "";
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.f353986c = "";
    L16:
        if ((r100 & 8) != 0) goto L18;
        this.f353987d = null;
        return;
    L18:
        this.f353987d = r104;
        return;
    L14:
        this.f353986c = r103;
        goto L16
    L10:
        this.f353985b = r102;
        goto L12
    }
}
