package com.larus.dora.impl.file.upload;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/impl/file/upload/DoraFileUploaderTrigger;", "", "traceName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTraceName", "()Ljava/lang/String;", "APP_FOREGROUND", "APP_BACKGROUND_DORA_WAKEUP", "AFTER_FETCH", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraFileUploaderTrigger extends Enum<DoraFileUploaderTrigger> {
    public static final DoraFileUploaderTrigger AFTER_FETCH = null;
    public static final DoraFileUploaderTrigger APP_BACKGROUND_DORA_WAKEUP = null;
    public static final DoraFileUploaderTrigger APP_FOREGROUND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraFileUploaderTrigger[] f335767a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f335768b = null;
    private final String traceName;

    public static EnumEntries<DoraFileUploaderTrigger> getEntries() {
        return f335768b;
    }

    static {
        DoraFileUploaderTrigger r100 = new DoraFileUploaderTrigger("APP_FOREGROUND", 0, "AppEnterForeground");
        APP_FOREGROUND = r100;
        DoraFileUploaderTrigger r101 = new DoraFileUploaderTrigger("APP_BACKGROUND_DORA_WAKEUP", 1, "AppBackgroundAndDoraWakeup");
        APP_BACKGROUND_DORA_WAKEUP = r101;
        DoraFileUploaderTrigger r102 = new DoraFileUploaderTrigger("AFTER_FETCH", 2, "AfterFetch");
        AFTER_FETCH = r102;
        DoraFileUploaderTrigger[] r103 = {r100, r101, r102};
        f335767a = r103;
        f335768b = EnumEntriesKt.enumEntries(r103);
    }

    public static DoraFileUploaderTrigger[] values() {
        return (DoraFileUploaderTrigger[]) f335767a.clone();
    }

    public final String getTraceName() {
        return this.traceName;
    }

    public static DoraFileUploaderTrigger valueOf(String r100) {
        return (DoraFileUploaderTrigger) r27.a.a(DoraFileUploaderTrigger.class, r100);
    }

    public DoraFileUploaderTrigger(String r100, int r101, String r102) {
        super(r100, r101);
        this.traceName = r102;
    }
}
