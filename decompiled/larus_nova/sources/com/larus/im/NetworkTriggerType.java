package com.larus.im;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/im/NetworkTriggerType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Auto", "User", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NetworkTriggerType extends Enum<NetworkTriggerType> {
    public static final NetworkTriggerType Auto = null;
    public static final NetworkTriggerType User = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NetworkTriggerType[] f346404a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f346405b = null;
    private final int value;

    public static EnumEntries<NetworkTriggerType> getEntries() {
        return f346405b;
    }

    static {
        NetworkTriggerType r100 = new NetworkTriggerType("Auto", 0, 0);
        Auto = r100;
        NetworkTriggerType r101 = new NetworkTriggerType("User", 1, 1);
        User = r101;
        NetworkTriggerType[] r102 = {r100, r101};
        f346404a = r102;
        f346405b = EnumEntriesKt.enumEntries(r102);
    }

    public static NetworkTriggerType[] values() {
        return (NetworkTriggerType[]) f346404a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static NetworkTriggerType valueOf(String r100) {
        return (NetworkTriggerType) r27.a.a(NetworkTriggerType.class, r100);
    }

    public NetworkTriggerType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
