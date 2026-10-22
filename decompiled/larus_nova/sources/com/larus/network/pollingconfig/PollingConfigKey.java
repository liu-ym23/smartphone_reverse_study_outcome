package com.larus.network.pollingconfig;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/network/pollingconfig/PollingConfigKey;", "", "key", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "DISABLE_NETWORK_RETRY", "network_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PollingConfigKey extends Enum<PollingConfigKey> {
    public static final PollingConfigKey DISABLE_NETWORK_RETRY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PollingConfigKey[] f360215a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f360216b = null;
    private final String key;

    public static EnumEntries<PollingConfigKey> getEntries() {
        return f360216b;
    }

    static {
        PollingConfigKey r100 = new PollingConfigKey();
        DISABLE_NETWORK_RETRY = r100;
        PollingConfigKey[] r101 = {r100};
        f360215a = r101;
        f360216b = EnumEntriesKt.enumEntries(r101);
    }

    public PollingConfigKey() {
        super("DISABLE_NETWORK_RETRY", 0);
        this.key = "disable_network_retry";
    }

    public static PollingConfigKey[] values() {
        return (PollingConfigKey[]) f360215a.clone();
    }

    public final String getKey() {
        return this.key;
    }

    public static PollingConfigKey valueOf(String r100) {
        return (PollingConfigKey) a.a(PollingConfigKey.class, r100);
    }
}
