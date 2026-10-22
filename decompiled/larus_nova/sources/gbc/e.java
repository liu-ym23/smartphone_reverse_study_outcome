package gbc;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f480815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f480816b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f480815a, r101.f480815a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f480816b, r101.f480816b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f480815a.hashCode() * 31) + this.f480816b.hashCode();
    }

    public final String toString() {
        return "VoiceAnalyticsPayload(eventName=" + this.f480815a + ", params=" + this.f480816b + ')';
    }

    public e(Map r100) {
        Intrinsics.checkNotNullParameter("im_voice_input_click", "eventName");
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f480815a = "im_voice_input_click";
        this.f480816b = r100;
    }
}
