package com.larus.im.internal.core.message;

import com.larus.im.bean.message.ClientControllerParam;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f347810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f347811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ClientControllerParam f347812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f347813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f347814e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f347810a, r101.f347810a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f347811b, r101.f347811b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f347812c, r101.f347812c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f347813d, r101.f347813d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f347814e, r101.f347814e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f347810a.hashCode() * 31;
        String r101 = this.f347811b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        ClientControllerParam r105 = this.f347812c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Map<String, String> r108 = this.f347813d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Map<String, String> r111 = this.f347814e;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "RegenMessageRequest(message=" + this.f347810a + ", botId=" + this.f347811b + ", params=" + this.f347812c + ", appletPayload=" + this.f347813d + ", ext=" + this.f347814e + ')';
    }

    public r(Message r100, String r101, ClientControllerParam r102, Map<String, String> r103, Map<String, String> r104) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f347810a = r100;
        this.f347811b = r101;
        this.f347812c = r102;
        this.f347813d = r103;
        this.f347814e = r104;
    }
}
