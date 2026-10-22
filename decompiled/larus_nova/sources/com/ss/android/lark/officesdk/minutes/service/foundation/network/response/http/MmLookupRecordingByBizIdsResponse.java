package com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http;

import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0014B!\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R&\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmLookupRecordingByBizIdsResponse;", "Ljava/io/Serializable;", "entries", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmLookupRecordingByBizIdsResponse$Entry;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getEntries", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Entry", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmLookupRecordingByBizIdsResponse implements Serializable {

    @SerializedName("entries")
    private final ArrayList<Entry> entries;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmLookupRecordingByBizIdsResponse$Entry;", "Ljava/io/Serializable;", "bizType", "", "bizId", "recordingId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBizType", "()Ljava/lang/String;", "getBizId", "getRecordingId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Entry implements Serializable {

        @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID)
        private final String bizId;

        @SerializedName("biz_type")
        private final String bizType;

        @SerializedName("recording_id")
        private final String recordingId;

        public Entry() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ Entry copy$default(Entry r100, String r101, String r102, String r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.bizType;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.bizId;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.recordingId;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final String component1() {
            return this.bizType;
        }

        public final String component2() {
            return this.bizId;
        }

        public final String component3() {
            return this.recordingId;
        }

        public final Entry copy(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "bizType");
            Intrinsics.checkNotNullParameter(r101, "bizId");
            Intrinsics.checkNotNullParameter(r102, "recordingId");
            return new Entry(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Entry) == true) goto L8;
            return false;
        L8:
            Entry r101 = (Entry) r100;
            if (Intrinsics.areEqual(this.bizType, r101.bizType) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.bizId, r101.bizId) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.recordingId, r101.recordingId) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.bizType.hashCode() * 31) + this.bizId.hashCode()) * 31) + this.recordingId.hashCode();
        }

        public String toString() {
            return "Entry(bizType=" + this.bizType + ", bizId=" + this.bizId + ", recordingId=" + this.recordingId + ')';
        }

        public final String getBizId() {
            return this.bizId;
        }

        public final String getBizType() {
            return this.bizType;
        }

        public final String getRecordingId() {
            return this.recordingId;
        }

        public Entry(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "bizType");
            Intrinsics.checkNotNullParameter(r101, "bizId");
            Intrinsics.checkNotNullParameter(r102, "recordingId");
            this.bizType = r100;
            this.bizId = r101;
            this.recordingId = r102;
        }

        public /* synthetic */ Entry(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = "";
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = "";
        L11:
            this(r100, r101, r102);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MmLookupRecordingByBizIdsResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MmLookupRecordingByBizIdsResponse copy$default(MmLookupRecordingByBizIdsResponse r100, ArrayList r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.entries;
    L6:
        return r100.copy(r101);
    }

    public final ArrayList<Entry> component1() {
        return this.entries;
    }

    public final MmLookupRecordingByBizIdsResponse copy(ArrayList<Entry> r100) {
        Intrinsics.checkNotNullParameter(r100, "entries");
        return new MmLookupRecordingByBizIdsResponse(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmLookupRecordingByBizIdsResponse) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.entries, ((MmLookupRecordingByBizIdsResponse) r100).entries) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.entries.hashCode();
    }

    public String toString() {
        return "MmLookupRecordingByBizIdsResponse(entries=" + this.entries + ')';
    }

    public final ArrayList<Entry> getEntries() {
        return this.entries;
    }

    public MmLookupRecordingByBizIdsResponse(ArrayList<Entry> r100) {
        Intrinsics.checkNotNullParameter(r100, "entries");
        this.entries = r100;
    }

    public /* synthetic */ MmLookupRecordingByBizIdsResponse(ArrayList r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new ArrayList();
    L5:
        this(r100);
    }
}
