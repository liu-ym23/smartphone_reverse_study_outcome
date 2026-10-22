package com.larus.dora.impl.log.g;

import com.android.ttcjpaysdk.bdpay.counter.outer.bean.ConfirmNextAction;
import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/dora/impl/log/g/LogResultType;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "SUCCESS", "TIMEOUT", FlowDoraWifiScene.OTA, ConfirmNextAction.ACTION_TYPE_QUERY, "DEVICE_DISCONNECT", "GET_G_LOG_DATA_TIMEOUT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LogResultType extends Enum<LogResultType> {
    public static final LogResultType DEVICE_DISCONNECT = null;
    public static final LogResultType GET_G_LOG_DATA_TIMEOUT = null;
    public static final LogResultType OTA = null;
    public static final LogResultType QUERY = null;
    public static final LogResultType SUCCESS = null;
    public static final LogResultType TIMEOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LogResultType[] f336117a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f336118b = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f336119id;

    public static EnumEntries<LogResultType> getEntries() {
        return f336118b;
    }

    static {
        LogResultType r100 = new LogResultType("SUCCESS", 0, 0);
        SUCCESS = r100;
        LogResultType r101 = new LogResultType("TIMEOUT", 1, 1);
        TIMEOUT = r101;
        LogResultType r102 = new LogResultType(FlowDoraWifiScene.OTA, 2, 2);
        OTA = r102;
        LogResultType r103 = new LogResultType(ConfirmNextAction.ACTION_TYPE_QUERY, 3, 3);
        QUERY = r103;
        LogResultType r104 = new LogResultType("DEVICE_DISCONNECT", 4, 4);
        DEVICE_DISCONNECT = r104;
        LogResultType r105 = new LogResultType("GET_G_LOG_DATA_TIMEOUT", 5, 5);
        GET_G_LOG_DATA_TIMEOUT = r105;
        LogResultType[] r110 = {r100, r101, r102, r103, r104, r105};
        f336117a = r110;
        f336118b = EnumEntriesKt.enumEntries(r110);
    }

    public static LogResultType[] values() {
        return (LogResultType[]) f336117a.clone();
    }

    public final int getId() {
        return this.f336119id;
    }

    public static LogResultType valueOf(String r100) {
        return (LogResultType) r27.a.a(LogResultType.class, r100);
    }

    public LogResultType(String r100, int r101, int r102) {
        super(r100, r101);
        this.f336119id = r102;
    }
}
