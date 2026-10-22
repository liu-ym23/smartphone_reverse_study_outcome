package com.larus.bmhome.chat.api;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f297248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f297249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f297250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f297251d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f297252e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f297253f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<String, Object> f297254g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r0) == true) goto L8;
        return false;
    L8:
        r0 r101 = (r0) r100;
        if (Intrinsics.areEqual(this.f297248a, r101.f297248a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f297249b, r101.f297249b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f297250c, r101.f297250c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f297251d, r101.f297251d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f297252e, r101.f297252e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f297253f, r101.f297253f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f297254g, r101.f297254g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f297248a.hashCode() * 31) + this.f297249b.hashCode()) * 31) + this.f297250c.hashCode()) * 31) + this.f297251d.hashCode()) * 31) + this.f297252e.hashCode()) * 31) + this.f297253f.hashCode()) * 31;
        HashMap<String, Object> r101 = this.f297254g;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MsgData(msgID=" + this.f297248a + ", queryMsgID=" + this.f297249b + ", cardID=" + this.f297250c + ", conversationID=" + this.f297251d + ", sectionID=" + this.f297252e + ", senderID=" + this.f297253f + ", traceInfo=" + this.f297254g + ')';
    }

    public r0(String r100, String r101, String r102, String r103, String r104, String r105, HashMap<String, Object> r106) {
        Intrinsics.checkNotNullParameter(r100, "msgID");
        Intrinsics.checkNotNullParameter(r101, "queryMsgID");
        Intrinsics.checkNotNullParameter(r102, "cardID");
        Intrinsics.checkNotNullParameter(r103, "conversationID");
        Intrinsics.checkNotNullParameter(r104, "sectionID");
        Intrinsics.checkNotNullParameter(r105, "senderID");
        this.f297248a = r100;
        this.f297249b = r101;
        this.f297250c = r102;
        this.f297251d = r103;
        this.f297252e = r104;
        this.f297253f = r105;
        this.f297254g = r106;
    }
}
