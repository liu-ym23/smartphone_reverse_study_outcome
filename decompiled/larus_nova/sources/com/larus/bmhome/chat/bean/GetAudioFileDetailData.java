package com.larus.bmhome.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012(\b\u0002\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006HÆ\u0003J3\u0010\f\u001a\u00020\u00002(\b\u0002\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006HÆ\u0001J\u0006\u0010\r\u001a\u00020\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eR6\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/bean/GetAudioFileDetailData;", "Landroid/os/Parcelable;", "detailMap", "Ljava/util/HashMap;", "", "Lcom/larus/bmhome/chat/bean/AudioFileDetail;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/util/HashMap;)V", "getDetailMap", "()Ljava/util/HashMap;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetAudioFileDetailData implements Parcelable {
    public static final Parcelable.Creator<GetAudioFileDetailData> CREATOR = null;

    @SerializedName("detail_map")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final HashMap<String, AudioFileDetail> detailMap;

    public static final class a implements Parcelable.Creator<GetAudioFileDetailData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final GetAudioFileDetailData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() != 0) goto L5;
            HashMap r101 = null;
        L10:
            return new GetAudioFileDetailData(r101);
        L5:
            int r102 = r100.readInt();
            HashMap r103 = new HashMap(r102);
            int r104 = 0;
        L6:
            if (r104 == r102) goto L8;
            r103.put(r100.readString(), AudioFileDetail.CREATOR.createFromParcel(r100));
            r104 = r104 + 1;
            goto L6
        L8:
            r101 = r103;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public final GetAudioFileDetailData[] newArray(int r100) {
            return new GetAudioFileDetailData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public GetAudioFileDetailData() {
        this(null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GetAudioFileDetailData) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.detailMap, ((GetAudioFileDetailData) r100).detailMap) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        HashMap<String, AudioFileDetail> r100 = this.detailMap;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "GetAudioFileDetailData(detailMap=" + this.detailMap + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        HashMap<String, AudioFileDetail> r102 = this.detailMap;
        if (r102 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<Map.Entry<String, AudioFileDetail>> r103 = r102.entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        Map.Entry<String, AudioFileDetail> r104 = r103.next();
        r100.writeString(r104.getKey());
        r104.getValue().writeToParcel(r100, r101);
        goto L7
    }

    public final HashMap<String, AudioFileDetail> a() {
        return this.detailMap;
    }

    public GetAudioFileDetailData(HashMap<String, AudioFileDetail> r100) {
        this.detailMap = r100;
    }
}
