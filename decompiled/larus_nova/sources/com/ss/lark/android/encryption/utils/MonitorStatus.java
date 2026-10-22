package com.ss.lark.android.encryption.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/lark/android/encryption/utils/MonitorStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SUCCESS", "FAILED", "security-encryption_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MonitorStatus extends Enum<MonitorStatus> {
    public static final MonitorStatus FAILED = null;
    public static final MonitorStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MonitorStatus[] f456817a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f456818b = null;
    private final int value;

    public static EnumEntries<MonitorStatus> getEntries() {
        return f456818b;
    }

    static {
        MonitorStatus r100 = new MonitorStatus("SUCCESS", 0, 1);
        SUCCESS = r100;
        MonitorStatus r101 = new MonitorStatus("FAILED", 1, 0);
        FAILED = r101;
        MonitorStatus[] r102 = {r100, r101};
        f456817a = r102;
        f456818b = EnumEntriesKt.enumEntries(r102);
    }

    public static MonitorStatus[] values() {
        return (MonitorStatus[]) f456817a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MonitorStatus valueOf(String r100) {
        return (MonitorStatus) r27.a.a(MonitorStatus.class, r100);
    }

    public MonitorStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
