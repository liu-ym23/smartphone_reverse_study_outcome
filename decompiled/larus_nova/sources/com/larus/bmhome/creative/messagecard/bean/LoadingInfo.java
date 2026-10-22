package com.larus.bmhome.creative.messagecard.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJV\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/creative/messagecard/bean/LoadingInfo;", "Ljava/io/Serializable;", "height", "", "width", "loadingText", "", "waitTimeSec", "refreshTimeSec", "loadingBeginTimeSec", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "()Ljava/lang/Long;", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/larus/bmhome/creative/messagecard/bean/LoadingInfo;", "equals", "", "other", "", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoadingInfo implements Serializable {

    @SerializedName("height")
    public final Long height;

    @SerializedName("loading_begin_time_sec")
    public final Long loadingBeginTimeSec;

    @SerializedName("loading_text")
    public final String loadingText;

    @SerializedName("refresh_time_sec")
    public final Long refreshTimeSec;

    @SerializedName("wait_time_sec")
    public final Long waitTimeSec;

    @SerializedName("width")
    public final Long width;

    public LoadingInfo() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ LoadingInfo copy$default(LoadingInfo r100, Long r101, Long r102, String r103, Long r104, Long r105, Long r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.height;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.width;
    L8:
        Long r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.loadingText;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.waitTimeSec;
    L14:
        Long r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.refreshTimeSec;
    L17:
        Long r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.loadingBeginTimeSec;
    L20:
        Long r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Long component1() {
        return this.height;
    }

    public final Long component2() {
        return this.width;
    }

    public final String component3() {
        return this.loadingText;
    }

    public final Long component4() {
        return this.waitTimeSec;
    }

    public final Long component5() {
        return this.refreshTimeSec;
    }

    public final Long component6() {
        return this.loadingBeginTimeSec;
    }

    public final LoadingInfo copy(Long r100, Long r110, String r111, Long r112, Long r113, Long r114) {
        return new LoadingInfo(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LoadingInfo) == true) goto L8;
        return false;
    L8:
        LoadingInfo r101 = (LoadingInfo) r100;
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.loadingText, r101.loadingText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.waitTimeSec, r101.waitTimeSec) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.refreshTimeSec, r101.refreshTimeSec) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.loadingBeginTimeSec, r101.loadingBeginTimeSec) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Long r100 = this.height;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.width;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.loadingText;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.waitTimeSec;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.refreshTimeSec;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.loadingBeginTimeSec;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "LoadingInfo(height=" + this.height + ", width=" + this.width + ", loadingText=" + this.loadingText + ", waitTimeSec=" + this.waitTimeSec + ", refreshTimeSec=" + this.refreshTimeSec + ", loadingBeginTimeSec=" + this.loadingBeginTimeSec + ')';
    }

    public LoadingInfo(Long r100, Long r101, String r102, Long r103, Long r104, Long r105) {
        this.height = r100;
        this.width = r101;
        this.loadingText = r102;
        this.waitTimeSec = r103;
        this.refreshTimeSec = r104;
        this.loadingBeginTimeSec = r105;
    }

    public /* synthetic */ LoadingInfo(Long r100, Long r101, String r102, Long r103, Long r110, Long r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        Long r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        Long r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        Long r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        Long r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        Long r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
