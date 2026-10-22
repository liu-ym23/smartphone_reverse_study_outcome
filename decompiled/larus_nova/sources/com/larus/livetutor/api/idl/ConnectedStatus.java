package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/larus/livetutor/api/idl/ConnectedStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Idle", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ConnectedStatus extends Enum<ConnectedStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ConnectedStatus[] $VALUES = null;
    public static final a Companion = null;

    @SerializedName("0")
    public static final ConnectedStatus Idle = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ ConnectedStatus[] $values() {
        return new ConnectedStatus[]{Idle};
    }

    public static EnumEntries<ConnectedStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        Idle = new ConnectedStatus("Idle", 0, 0);
        ConnectedStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static ConnectedStatus[] values() {
        return (ConnectedStatus[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final ConnectedStatus findByValue(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L7;
        return null;
    L7:
        return Idle;
    }

    public static ConnectedStatus valueOf(String r100) {
        return (ConnectedStatus) r27.a.a(ConnectedStatus.class, r100);
    }

    private ConnectedStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
