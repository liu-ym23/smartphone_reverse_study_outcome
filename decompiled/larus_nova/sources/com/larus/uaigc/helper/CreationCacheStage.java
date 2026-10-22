package com.larus.uaigc.helper;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/uaigc/helper/CreationCacheStage;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PREPROCESS_REUSE_CHECKED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum CreationCacheStage extends Enum<CreationCacheStage> {
    public static final CreationCacheStage PREPROCESS_REUSE_CHECKED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CreationCacheStage[] f372933a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f372934b = null;
    private final String value;

    public static EnumEntries<CreationCacheStage> getEntries() {
        return f372934b;
    }

    static {
        CreationCacheStage r100 = new CreationCacheStage();
        PREPROCESS_REUSE_CHECKED = r100;
        CreationCacheStage[] r101 = {r100};
        f372933a = r101;
        f372934b = EnumEntriesKt.enumEntries(r101);
    }

    public CreationCacheStage() {
        super("PREPROCESS_REUSE_CHECKED", 0);
        this.value = "preprocess_reuse_checked";
    }

    public static CreationCacheStage[] values() {
        return (CreationCacheStage[]) f372933a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static CreationCacheStage valueOf(String r100) {
        return (CreationCacheStage) r27.a.a(CreationCacheStage.class, r100);
    }
}
