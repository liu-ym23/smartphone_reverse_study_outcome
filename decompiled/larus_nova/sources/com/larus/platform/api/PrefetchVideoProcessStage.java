package com.larus.platform.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/platform/api/PrefetchVideoProcessStage;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CMD_INIT", "CMD_PROCESS", "BIND_PROCESS", "REFRESH_PROCESS", "UN_CONSUMED_PROCESS", "EXPIRATION_PROCESS", "EXCEPTION", "FILTERED", "UNLIMITED_FLOW_PROCESS", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PrefetchVideoProcessStage extends Enum<PrefetchVideoProcessStage> {
    public static final PrefetchVideoProcessStage BIND_PROCESS = null;
    public static final PrefetchVideoProcessStage CMD_INIT = null;
    public static final PrefetchVideoProcessStage CMD_PROCESS = null;
    public static final PrefetchVideoProcessStage EXCEPTION = null;
    public static final PrefetchVideoProcessStage EXPIRATION_PROCESS = null;
    public static final PrefetchVideoProcessStage FILTERED = null;
    public static final PrefetchVideoProcessStage REFRESH_PROCESS = null;
    public static final PrefetchVideoProcessStage UNLIMITED_FLOW_PROCESS = null;
    public static final PrefetchVideoProcessStage UN_CONSUMED_PROCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PrefetchVideoProcessStage[] f364838a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f364839b = null;
    private final String value;

    public static EnumEntries<PrefetchVideoProcessStage> getEntries() {
        return f364839b;
    }

    static {
        PrefetchVideoProcessStage r100 = new PrefetchVideoProcessStage("CMD_INIT", 0, "cache_init");
        CMD_INIT = r100;
        PrefetchVideoProcessStage r101 = new PrefetchVideoProcessStage("CMD_PROCESS", 1, "cmd_process");
        CMD_PROCESS = r101;
        PrefetchVideoProcessStage r102 = new PrefetchVideoProcessStage("BIND_PROCESS", 2, "bind_process");
        BIND_PROCESS = r102;
        PrefetchVideoProcessStage r103 = new PrefetchVideoProcessStage("REFRESH_PROCESS", 3, "refresh_process");
        REFRESH_PROCESS = r103;
        PrefetchVideoProcessStage r104 = new PrefetchVideoProcessStage("UN_CONSUMED_PROCESS", 4, "un_consumed_process");
        UN_CONSUMED_PROCESS = r104;
        PrefetchVideoProcessStage r105 = new PrefetchVideoProcessStage("EXPIRATION_PROCESS", 5, "expiration_process");
        EXPIRATION_PROCESS = r105;
        PrefetchVideoProcessStage r110 = new PrefetchVideoProcessStage("EXCEPTION", 6, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        EXCEPTION = r110;
        PrefetchVideoProcessStage r111 = new PrefetchVideoProcessStage("FILTERED", 7, "filtered");
        FILTERED = r111;
        PrefetchVideoProcessStage r112 = new PrefetchVideoProcessStage("UNLIMITED_FLOW_PROCESS", 8, "unlimited_flow_process");
        UNLIMITED_FLOW_PROCESS = r112;
        PrefetchVideoProcessStage[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f364838a = r113;
        f364839b = EnumEntriesKt.enumEntries(r113);
    }

    public static PrefetchVideoProcessStage[] values() {
        return (PrefetchVideoProcessStage[]) f364838a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static PrefetchVideoProcessStage valueOf(String r100) {
        return (PrefetchVideoProcessStage) r27.a.a(PrefetchVideoProcessStage.class, r100);
    }

    public PrefetchVideoProcessStage(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
