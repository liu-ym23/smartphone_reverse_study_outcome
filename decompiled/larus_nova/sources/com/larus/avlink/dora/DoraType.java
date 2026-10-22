package com.larus.avlink.dora;

import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/avlink/dora/DoraType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", ServiceType.DORA, "DORA_RADIO", "dora_avlink_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraType extends Enum<DoraType> {
    public static final DoraType DORA = null;
    public static final DoraType DORA_RADIO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraType[] f291756a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291757b = null;
    private final String value;

    public static EnumEntries<DoraType> getEntries() {
        return f291757b;
    }

    static {
        DoraType r100 = new DoraType(ServiceType.DORA, 0, "dora_call");
        DORA = r100;
        DoraType r101 = new DoraType("DORA_RADIO", 1, "dora_radio");
        DORA_RADIO = r101;
        DoraType[] r102 = {r100, r101};
        f291756a = r102;
        f291757b = EnumEntriesKt.enumEntries(r102);
    }

    public static DoraType[] values() {
        return (DoraType[]) f291756a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static DoraType valueOf(String r100) {
        return (DoraType) a.a(DoraType.class, r100);
    }

    public DoraType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
