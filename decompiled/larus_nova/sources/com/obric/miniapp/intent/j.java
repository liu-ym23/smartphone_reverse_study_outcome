package com.obric.miniapp.intent;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f397711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f397712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f397713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONObject f397714d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f397711a, r101.f397711a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397712b, r101.f397712b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f397713c, r101.f397713c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f397714d, r101.f397714d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f397711a.hashCode() * 31) + this.f397712b.hashCode()) * 31) + this.f397713c.hashCode()) * 31) + this.f397714d.hashCode();
    }

    public final String toString() {
        return "IntentCardOperationRequest(op=" + this.f397711a + ", requestId=" + this.f397712b + ", scene=" + this.f397713c + ", payload=" + this.f397714d + ')';
    }

    public j(String r100, String r101, String r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "op");
        Intrinsics.checkNotNullParameter(r101, "requestId");
        Intrinsics.checkNotNullParameter(r102, "scene");
        Intrinsics.checkNotNullParameter(r103, WsConstants.KEY_PAYLOAD);
        this.f397711a = r100;
        this.f397712b = r101;
        this.f397713c = r102;
        this.f397714d = r103;
    }
}
