package com.obric.assistant.live.island;

import android.app.PendingIntent;
import com.google.gson.JsonObject;
import com.obric.livecard.api.DefaultIslandCardCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PendingIntent f390146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JsonObject f390147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DefaultIslandCardCallback f390148c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f390146a, r101.f390146a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f390147b, r101.f390147b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f390148c, r101.f390148c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f390146a.hashCode() * 31) + this.f390147b.hashCode()) * 31;
        DefaultIslandCardCallback r101 = this.f390148c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "SessionBehavior(intent=" + this.f390146a + ", ext=" + this.f390147b + ", callback=" + this.f390148c + ')';
    }

    public t(PendingIntent r100, JsonObject r101, DefaultIslandCardCallback r102) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        Intrinsics.checkNotNullParameter(r101, "ext");
        this.f390146a = r100;
        this.f390147b = r101;
        this.f390148c = r102;
    }
}
