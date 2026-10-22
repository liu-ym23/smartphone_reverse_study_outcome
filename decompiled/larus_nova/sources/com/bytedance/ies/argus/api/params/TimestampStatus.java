package com.bytedance.ies.argus.api.params;

import com.amap.api.col.s.ce;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/argus/api/params/TimestampStatus;", "", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "UNKNOWN", "LessOrEqual", "Greater", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum TimestampStatus extends Enum<TimestampStatus> {
    public static final TimestampStatus Greater = null;
    public static final TimestampStatus LessOrEqual = null;
    public static final TimestampStatus UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TimestampStatus[] f245696a = null;
    private final String strValue;

    public static TimestampStatus valueOf(String r100) {
        return (TimestampStatus) r27.a.a(TimestampStatus.class, r100);
    }

    public static TimestampStatus[] values() {
        return (TimestampStatus[]) f245696a.clone();
    }

    static {
        TimestampStatus r100 = new TimestampStatus("UNKNOWN", 0, "unknown");
        UNKNOWN = r100;
        TimestampStatus r101 = new TimestampStatus("LessOrEqual", 1, "le");
        LessOrEqual = r101;
        TimestampStatus r102 = new TimestampStatus("Greater", 2, ce.f26391f);
        Greater = r102;
        f245696a = new TimestampStatus[]{r100, r101, r102};
    }

    public final String getStrValue() {
        return this.strValue;
    }

    public TimestampStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.strValue = r102;
    }
}
