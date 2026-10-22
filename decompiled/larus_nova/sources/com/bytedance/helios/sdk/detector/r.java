package com.bytedance.helios.sdk.detector;

import com.mammon.speechaudiosdk.session.type.SpeechCode;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f245546a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r f245547b = null;

    public r() {
    }

    @Override // com.bytedance.helios.sdk.detector.a
    public final String b() {
        return "Location";
    }

    @Override // com.bytedance.helios.sdk.detector.a
    public final String getResourceId() {
        return "loc";
    }

    static {
        f245547b = new r();
        f245546a = new int[]{100000, 100001, 100002, 100003, 100004, 100005, 100006, 100007, 100008, 100009, 100010, 100011, 100012, 100013, 100900, 100901, 100902, 100903, 100904, 100905, 100906, 100907, 100908, 100909, 100910, 100911, 100912, 101000, 101001, 101100, 102300, 102302, 102400, 102401, 100018, 100019, 100020, SpeechCode.SPEECH_TOKEN_NOT_GET_DID, SpeechCode.SPEECH_VC_TASK_TYPE_NOT_MATCH, SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE};
    }

    @Override // com.bytedance.helios.sdk.detector.a
    public final int[] a() {
        return f245546a;
    }
}
