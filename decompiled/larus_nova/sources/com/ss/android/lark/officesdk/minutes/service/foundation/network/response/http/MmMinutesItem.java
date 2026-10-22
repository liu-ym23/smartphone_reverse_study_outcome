package com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015JV\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015¨\u0006&"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmMinutesItem;", "Ljava/io/Serializable;", "objectToken", "", "status", "", "topic", "url", "duration", "", "createTime", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getObjectToken", "()Ljava/lang/String;", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTopic", "getUrl", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCreateTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmMinutesItem;", "equals", "", "other", "", "hashCode", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmMinutesItem implements Serializable {

    @SerializedName("create_time")
    private final Long createTime;

    @SerializedName("duration")
    private final Long duration;

    @SerializedName("object_token")
    private final String objectToken;

    @SerializedName("status")
    private final Integer status;

    @SerializedName("topic")
    private final String topic;

    @SerializedName("url")
    private final String url;

    public MmMinutesItem() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ MmMinutesItem copy$default(MmMinutesItem r100, String r101, Integer r102, String r103, String r104, Long r105, Long r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.objectToken;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.status;
    L8:
        Integer r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.topic;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.url;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.duration;
    L17:
        Long r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.createTime;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.objectToken;
    }

    public final Integer component2() {
        return this.status;
    }

    public final String component3() {
        return this.topic;
    }

    public final String component4() {
        return this.url;
    }

    public final Long component5() {
        return this.duration;
    }

    public final Long component6() {
        return this.createTime;
    }

    public final MmMinutesItem copy(String r100, Integer r110, String r111, String r112, Long r113, Long r114) {
        return new MmMinutesItem(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmMinutesItem) == true) goto L8;
        return false;
    L8:
        MmMinutesItem r101 = (MmMinutesItem) r100;
        if (Intrinsics.areEqual(this.objectToken, r101.objectToken) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.topic, r101.topic) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.createTime, r101.createTime) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.objectToken;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.status;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.topic;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.url;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.duration;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.createTime;
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
        return "MmMinutesItem(objectToken=" + this.objectToken + ", status=" + this.status + ", topic=" + this.topic + ", url=" + this.url + ", duration=" + this.duration + ", createTime=" + this.createTime + ')';
    }

    public final Long getCreateTime() {
        return this.createTime;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final String getObjectToken() {
        return this.objectToken;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final String getTopic() {
        return this.topic;
    }

    public final String getUrl() {
        return this.url;
    }

    public MmMinutesItem(String r100, Integer r101, String r102, String r103, Long r104, Long r105) {
        this.objectToken = r100;
        this.status = r101;
        this.topic = r102;
        this.url = r103;
        this.duration = r104;
        this.createTime = r105;
    }

    public /* synthetic */ MmMinutesItem(String r100, Integer r101, String r102, String r103, Long r110, Long r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        Integer r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r106 = null;
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
