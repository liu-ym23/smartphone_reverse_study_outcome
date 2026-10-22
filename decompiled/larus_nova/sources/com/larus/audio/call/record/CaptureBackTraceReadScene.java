package com.larus.audio.call.record;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/audio/call/record/CaptureBackTraceReadScene;", "", "<init>", "(Ljava/lang/String;I)V", "REALTIME_CALL", "CONTINUOUS_TALK", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CaptureBackTraceReadScene extends Enum<CaptureBackTraceReadScene> {
    public static final CaptureBackTraceReadScene CONTINUOUS_TALK = null;
    public static final CaptureBackTraceReadScene REALTIME_CALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CaptureBackTraceReadScene[] f289557a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f289558b = null;

    public static EnumEntries<CaptureBackTraceReadScene> getEntries() {
        return f289558b;
    }

    static {
        CaptureBackTraceReadScene r100 = new CaptureBackTraceReadScene("REALTIME_CALL", 0);
        REALTIME_CALL = r100;
        CaptureBackTraceReadScene r101 = new CaptureBackTraceReadScene("CONTINUOUS_TALK", 1);
        CONTINUOUS_TALK = r101;
        CaptureBackTraceReadScene[] r102 = {r100, r101};
        f289557a = r102;
        f289558b = EnumEntriesKt.enumEntries(r102);
    }

    public static CaptureBackTraceReadScene[] values() {
        return (CaptureBackTraceReadScene[]) f289557a.clone();
    }

    public static CaptureBackTraceReadScene valueOf(String r100) {
        return (CaptureBackTraceReadScene) r27.a.a(CaptureBackTraceReadScene.class, r100);
    }

    public CaptureBackTraceReadScene(String r100, int r101) {
        super(r100, r101);
    }
}
