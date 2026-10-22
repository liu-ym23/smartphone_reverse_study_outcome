package jy9;

import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f500969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f500970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Message, Map<String, String>> f500971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f500972d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f500969a, r101.f500969a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f500970b, r101.f500970b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f500971c, r101.f500971c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f500972d, r101.f500972d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f500969a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        z r104 = this.f500970b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((((r103 + r101) * 31) + this.f500971c.hashCode()) * 31) + this.f500972d.hashCode();
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BeautifyConfig(curBotId=" + this.f500969a + ", imageEditConfig=" + this.f500970b + ", replyTrackMapResolver=" + this.f500971c + ", beautifyEnv=" + this.f500972d + ')';
    }

    public b(String r100, z r101, q r102, c r103) {
        Intrinsics.checkNotNullParameter(r102, "replyTrackMapResolver");
        Intrinsics.checkNotNullParameter(r103, "beautifyEnv");
        this.f500969a = r100;
        this.f500970b = r101;
        this.f500971c = r102;
        this.f500972d = r103;
    }
}
