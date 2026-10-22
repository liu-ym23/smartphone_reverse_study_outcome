package com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\\\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006("}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmMinutesListResponse;", "Ljava/io/Serializable;", "total", "", "offset", "timestamp", "", "size", "hasMore", "", "list", "", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmMinutesItem;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;)V", "getTotal", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOffset", "getTimestamp", "()Ljava/lang/String;", "getSize", "getHasMore", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;)Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmMinutesListResponse;", "equals", "other", "", "hashCode", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmMinutesListResponse implements Serializable {

    @SerializedName("has_more")
    private final Boolean hasMore;

    @SerializedName("list")
    private final List<MmMinutesItem> list;

    @SerializedName("offset")
    private final Integer offset;

    @SerializedName("size")
    private final Integer size;

    @SerializedName("timestamp")
    private final String timestamp;

    @SerializedName("total")
    private final Integer total;

    public MmMinutesListResponse() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MmMinutesListResponse copy$default(MmMinutesListResponse r100, Integer r101, Integer r102, String r103, Integer r104, Boolean r105, List r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.total;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.offset;
    L8:
        Integer r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.timestamp;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.size;
    L14:
        Integer r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.hasMore;
    L17:
        Boolean r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.list;
    L20:
        Integer r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Integer component1() {
        return this.total;
    }

    public final Integer component2() {
        return this.offset;
    }

    public final String component3() {
        return this.timestamp;
    }

    public final Integer component4() {
        return this.size;
    }

    public final Boolean component5() {
        return this.hasMore;
    }

    public final List<MmMinutesItem> component6() {
        return this.list;
    }

    public final MmMinutesListResponse copy(Integer r100, Integer r110, String r111, Integer r112, Boolean r113, List<MmMinutesItem> r114) {
        return new MmMinutesListResponse(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmMinutesListResponse) == true) goto L8;
        return false;
    L8:
        MmMinutesListResponse r101 = (MmMinutesListResponse) r100;
        if (Intrinsics.areEqual(this.total, r101.total) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.offset, r101.offset) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.timestamp, r101.timestamp) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.size, r101.size) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.hasMore, r101.hasMore) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.list, r101.list) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.total;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.offset;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.timestamp;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.size;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.hasMore;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<MmMinutesItem> r116 = this.list;
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
        return "MmMinutesListResponse(total=" + this.total + ", offset=" + this.offset + ", timestamp=" + this.timestamp + ", size=" + this.size + ", hasMore=" + this.hasMore + ", list=" + this.list + ')';
    }

    public final Boolean getHasMore() {
        return this.hasMore;
    }

    public final List<MmMinutesItem> getList() {
        return this.list;
    }

    public final Integer getOffset() {
        return this.offset;
    }

    public final Integer getSize() {
        return this.size;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final Integer getTotal() {
        return this.total;
    }

    public MmMinutesListResponse(Integer r100, Integer r101, String r102, Integer r103, Boolean r104, List<MmMinutesItem> r105) {
        this.total = r100;
        this.offset = r101;
        this.timestamp = r102;
        this.size = r103;
        this.hasMore = r104;
        this.list = r105;
    }

    public /* synthetic */ MmMinutesListResponse(Integer r100, Integer r101, String r102, Integer r103, Boolean r110, List r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        Integer r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        Integer r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        Integer r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        Boolean r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        List r115 = null;
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
