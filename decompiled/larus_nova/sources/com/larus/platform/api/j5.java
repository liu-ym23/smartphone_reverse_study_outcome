package com.larus.platform.api;

import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class j5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f365171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f365172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f365173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f365174d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f365175e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Message f365176f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AuthScene f365177g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i5 f365178h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Unit> f365179i;

    public j5() {
        this(null, false, false, null, null, null, null, null, null, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j5) == true) goto L8;
        return false;
    L8:
        j5 r101 = (j5) r100;
        if (Intrinsics.areEqual(this.f365171a, r101.f365171a) == true) goto L12;
        return false;
    L12:
        if (this.f365172b == r101.f365172b) goto L15;
        return false;
    L15:
        if (this.f365173c == r101.f365173c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f365174d, r101.f365174d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f365175e, r101.f365175e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f365176f, r101.f365176f) == true) goto L27;
        return false;
    L27:
        if (this.f365177g == r101.f365177g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f365178h, r101.f365178h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f365179i, r101.f365179i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f365171a.hashCode() * 31;
        int r101 = 1231;
        if (this.f365172b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f365173c == true) goto L10;
        r101 = 1237;
    L10:
        int r104 = (((((r103 + r101) * 31) + this.f365174d.hashCode()) * 31) + this.f365175e.hashCode()) * 31;
        Message r105 = this.f365176f;
        int r106 = 0;
        if (r105 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (((r104 + r107) * 31) + this.f365177g.hashCode()) * 31;
        i5 r109 = this.f365178h;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        Function0<Unit> r112 = this.f365179i;
        if (r112 == null) goto L23;
        r106 = r112.hashCode();
    L23:
        return r111 + r106;
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r105.hashCode();
        goto L14
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "StartMusicAuthParams(botId=" + this.f365171a + ", isMessageIdFromQuery=" + this.f365172b + ", isNeedReSendOrReply=" + this.f365173c + ", messageId=" + this.f365174d + ", jumpUrl=" + this.f365175e + ", authMessage=" + this.f365176f + ", authScene=" + this.f365177g + ", startMusicAuthAdditionalJSBParams=" + this.f365178h + ", onClickThirdPartyMusicPlatformToAuthCallback=" + this.f365179i + ')';
    }

    public j5(String r100, boolean r101, boolean r102, String r103, String r104, Message r105, AuthScene r110, i5 r111, com.larus.avlink.plugins.x0 r112, int r113) {
        if ((r113 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r113 & 2) == 0) goto L9;
        r101 = true;
    L9:
        if ((r113 & 4) == 0) goto L12;
        r102 = true;
    L12:
        if ((r113 & 8) == 0) goto L15;
        r103 = "";
    L15:
        if ((r113 & 16) == 0) goto L18;
        r104 = "";
    L18:
        if ((r113 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r113 & 64) == 0) goto L24;
        r110 = AuthScene.LocalLife;
    L24:
        if ((r113 & 128) == 0) goto L27;
        r111 = null;
    L27:
        if ((r113 & 256) == 0) goto L29;
        r112 = null;
    L29:
        Intrinsics.checkNotNullParameter(r100, "botId");
        Intrinsics.checkNotNullParameter(r103, "messageId");
        Intrinsics.checkNotNullParameter(r104, "jumpUrl");
        Intrinsics.checkNotNullParameter(r110, "authScene");
        this.f365171a = r100;
        this.f365172b = r101;
        this.f365173c = r102;
        this.f365174d = r103;
        this.f365175e = r104;
        this.f365176f = r105;
        this.f365177g = r110;
        this.f365178h = r111;
        this.f365179i = r112;
    }
}
