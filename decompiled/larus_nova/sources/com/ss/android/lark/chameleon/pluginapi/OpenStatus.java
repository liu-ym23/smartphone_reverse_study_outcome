package com.ss.android.lark.chameleon.pluginapi;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/chameleon/pluginapi/OpenStatus;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAILED", "TIMEOUT", "CANCEL", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OpenStatus extends Enum<OpenStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OpenStatus[] $VALUES = null;
    public static final OpenStatus CANCEL = null;
    public static final OpenStatus FAILED = null;
    public static final OpenStatus SUCCESS = null;
    public static final OpenStatus TIMEOUT = null;

    private static final /* synthetic */ OpenStatus[] $values() {
        return new OpenStatus[]{SUCCESS, FAILED, TIMEOUT, CANCEL};
    }

    public static EnumEntries<OpenStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        SUCCESS = new OpenStatus("SUCCESS", 0);
        FAILED = new OpenStatus("FAILED", 1);
        TIMEOUT = new OpenStatus("TIMEOUT", 2);
        CANCEL = new OpenStatus("CANCEL", 3);
        OpenStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static OpenStatus[] values() {
        return (OpenStatus[]) $VALUES.clone();
    }

    public static OpenStatus valueOf(String r100) {
        return (OpenStatus) a.a(OpenStatus.class, r100);
    }

    private OpenStatus(String r100, int r101) {
        super(r100, r101);
    }
}
