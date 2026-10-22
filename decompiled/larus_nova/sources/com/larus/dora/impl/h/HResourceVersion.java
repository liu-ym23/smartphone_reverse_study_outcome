package com.larus.dora.impl.h;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/h/HResourceVersion;", "", "key", "", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getValue", "DEVICE_LIST_PAGE_VERSION", "BIND_PAGE_VERSION", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HResourceVersion extends Enum<HResourceVersion> {
    public static final HResourceVersion BIND_PAGE_VERSION = null;
    public static final HResourceVersion DEVICE_LIST_PAGE_VERSION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HResourceVersion[] f336010a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f336011b = null;
    private final String key;
    private final String value;

    public static EnumEntries<HResourceVersion> getEntries() {
        return f336011b;
    }

    static {
        HResourceVersion r100 = new HResourceVersion("DEVICE_LIST_PAGE_VERSION", 0, "${device_list_page_version}");
        DEVICE_LIST_PAGE_VERSION = r100;
        HResourceVersion r101 = new HResourceVersion("BIND_PAGE_VERSION", 1, "${bind_page_version}");
        BIND_PAGE_VERSION = r101;
        HResourceVersion[] r102 = {r100, r101};
        f336010a = r102;
        f336011b = EnumEntriesKt.enumEntries(r102);
    }

    public static HResourceVersion[] values() {
        return (HResourceVersion[]) f336010a.clone();
    }

    public final String getKey() {
        return this.key;
    }

    public final String getValue() {
        return this.value;
    }

    public static HResourceVersion valueOf(String r100) {
        return (HResourceVersion) a.a(HResourceVersion.class, r100);
    }

    public HResourceVersion(String r100, int r101, String r102) {
        super(r100, r101);
        this.key = r102;
        this.value = "v3";
    }
}
