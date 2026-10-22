package com.larus.asr.session.component;

import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f287733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f287734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f287735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f287736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.larus.audio.b f287737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f287738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f287739g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f287733a, r101.f287733a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f287734b, r101.f287734b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f287735c, r101.f287735c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f287736d, r101.f287736d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f287737e, r101.f287737e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f287738f, r101.f287738f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f287739g, r101.f287739g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f287733a.hashCode() * 31) + this.f287734b.hashCode()) * 31) + this.f287735c.hashCode()) * 31) + this.f287736d.hashCode()) * 31;
        com.larus.audio.b r101 = this.f287737e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f287738f;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f287739g;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AsrFinalResult(message=" + this.f287733a + ", rawText=" + this.f287734b + ", resultTaskId=" + this.f287735c + ", messageExt=" + this.f287736d + ", successResult=" + this.f287737e + ", audioDataTosUri=" + this.f287738f + ", audioEventResponse=" + this.f287739g + ')';
    }

    public j(Message r100, String r101, String r102, Map<String, String> r103, com.larus.audio.b r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "rawText");
        Intrinsics.checkNotNullParameter(r102, "resultTaskId");
        Intrinsics.checkNotNullParameter(r103, "messageExt");
        this.f287733a = r100;
        this.f287734b = r101;
        this.f287735c = r102;
        this.f287736d = r103;
        this.f287737e = r104;
        this.f287738f = r105;
        this.f287739g = r106;
    }
}
