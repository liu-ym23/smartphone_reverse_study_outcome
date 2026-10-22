package com.larus.network.http;

import android.util.EventsUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.xmlpull.v1.XmlPullParser;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/network/http/RecordType;", XmlPullParser.NO_NAMESPACE, "value", XmlPullParser.NO_NAMESPACE, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NO_RECORD", "DOUBAO_RECORD", "network_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final enum RecordType extends Enum<RecordType> {
    public static final RecordType DOUBAO_RECORD = null;
    public static final RecordType NO_RECORD = null;
    public static final /* synthetic */ RecordType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<RecordType> getEntries() {
        return b;
    }

    static {
        RecordType r0 = new RecordType("NO_RECORD", 0, 0);
        NO_RECORD = r0;
        RecordType r1 = new RecordType("DOUBAO_RECORD", 1, 1);
        DOUBAO_RECORD = r1;
        RecordType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static RecordType[] values() {
        return (RecordType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static RecordType valueOf(String r1) {
        return (RecordType) a.a(RecordType.class, r1);
    }

    public RecordType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
