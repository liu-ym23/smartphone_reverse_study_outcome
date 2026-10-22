package com.ss.android.lark.chameleonv2.lkapi.biz.statistics;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.texturerender.VideoSurfaceTexture;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0003H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/biz/statistics/IBizStatistics$SendEventData;", "Lcom/bytedance/ee/util/io/NonProguard;", "eventType", "", VideoSurfaceTexture.KEY_TIME, "", "params", "", "<init>", "(Ljava/lang/String;JLjava/util/Map;)V", "getEventType", "()Ljava/lang/String;", "getTimeStamp", "()J", "getParams", "()Ljava/util/Map;", "toString", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IBizStatistics$SendEventData implements NonProguard {
    private final String eventType;
    private final Map<String, String> params;
    private final long timeStamp;

    public IBizStatistics$SendEventData() {
        this(null, 0, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IBizStatistics$SendEventData copy$default(IBizStatistics$SendEventData r100, String r101, long r102, Map r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.eventType;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.timeStamp;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.params;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.eventType;
    }

    public final long component2() {
        return this.timeStamp;
    }

    public final Map<String, String> component3() {
        return this.params;
    }

    public final IBizStatistics$SendEventData copy(String r100, long r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r102, "params");
        return new IBizStatistics$SendEventData(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IBizStatistics$SendEventData) == true) goto L8;
        return false;
    L8:
        IBizStatistics$SendEventData r101 = (IBizStatistics$SendEventData) r100;
        if (Intrinsics.areEqual(this.eventType, r101.eventType) == true) goto L12;
        return false;
    L12:
        if (this.timeStamp == r101.timeStamp) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.eventType.hashCode() * 31;
        long r101 = this.timeStamp;
        return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.params.hashCode();
    }

    public String toString() {
        return "SendEventData(eventType='" + this.eventType + "', timeStamp=" + this.timeStamp + ", params=" + this.params.size() + ')';
    }

    public final String getEventType() {
        return this.eventType;
    }

    public final Map<String, String> getParams() {
        return this.params;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public IBizStatistics$SendEventData(String r100, long r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.eventType = r100;
        this.timeStamp = r101;
        this.params = r102;
    }

    public /* synthetic */ IBizStatistics$SendEventData(String r100, long r101, Map r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = new LinkedHashMap();
    L11:
        this(r100, r101, r102);
    }
}
