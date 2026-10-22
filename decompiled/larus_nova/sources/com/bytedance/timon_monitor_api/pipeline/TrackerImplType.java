package com.bytedance.timon_monitor_api.pipeline;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/timon_monitor_api/pipeline/TrackerImplType;", "", "", "type", "I", "getType", "()I", "Empty", "SingleThread", "ScenceId", "MultiThread", "timon-monitor-api_release"}, k = 1, mv = {1, 4, 0})
public final enum TrackerImplType extends Enum<TrackerImplType> {
    public static final TrackerImplType Empty = null;
    public static final TrackerImplType MultiThread = null;
    public static final TrackerImplType ScenceId = null;
    public static final TrackerImplType SingleThread = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TrackerImplType[] f270716a = null;
    private final int type;

    static {
        TrackerImplType r100 = new TrackerImplType("Empty", 0, 0);
        Empty = r100;
        TrackerImplType r101 = new TrackerImplType("SingleThread", 1, 1);
        SingleThread = r101;
        TrackerImplType r102 = new TrackerImplType("ScenceId", 2, 2);
        ScenceId = r102;
        TrackerImplType r103 = new TrackerImplType("MultiThread", 3, 3);
        MultiThread = r103;
        f270716a = new TrackerImplType[]{r100, r101, r102, r103};
    }

    public static TrackerImplType valueOf(String r100) {
        return (TrackerImplType) a.a(TrackerImplType.class, r100);
    }

    public static TrackerImplType[] values() {
        return (TrackerImplType[]) f270716a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public TrackerImplType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
