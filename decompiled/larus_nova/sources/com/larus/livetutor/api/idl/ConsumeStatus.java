package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/livetutor/api/idl/ConsumeStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "Unconsume", "Consume", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ConsumeStatus extends Enum<ConsumeStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ConsumeStatus[] $VALUES = null;
    public static final a Companion = null;

    @SerializedName("2")
    public static final ConsumeStatus Consume = null;

    @SerializedName("1")
    public static final ConsumeStatus Unconsume = null;

    @SerializedName("0")
    public static final ConsumeStatus Unknown = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ ConsumeStatus[] $values() {
        return new ConsumeStatus[]{Unknown, Unconsume, Consume};
    }

    public static EnumEntries<ConsumeStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        Unknown = new ConsumeStatus("Unknown", 0, 0);
        Unconsume = new ConsumeStatus("Unconsume", 1, 1);
        Consume = new ConsumeStatus("Consume", 2, 2);
        ConsumeStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static ConsumeStatus[] values() {
        return (ConsumeStatus[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final ConsumeStatus findByValue(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L12;
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L14;
        return null;
    L14:
        return Consume;
    L15:
        return Unconsume;
    L12:
        return Unknown;
    }

    public static ConsumeStatus valueOf(String r100) {
        return (ConsumeStatus) r27.a.a(ConsumeStatus.class, r100);
    }

    private ConsumeStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
