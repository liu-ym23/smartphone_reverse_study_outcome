package com.bytedance.locallife.pdp.biz.common.frame;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/locallife/pdp/biz/common/frame/FrameData;", "Landroid/os/Parcelable;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/locallife/pdp/biz/common/frame/FrameInfo;", "data", "Ljava/util/concurrent/ConcurrentHashMap;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/concurrent/ConcurrentHashMap;", "", "prevTs", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class FrameData implements Parcelable {
    public static final Parcelable.Creator<FrameData> CREATOR = null;

    @SerializedName("data")
    private final ConcurrentHashMap<String, FrameInfo> data;

    @SerializedName("prevTs")
    private final Long prevTs;

    public static final class a implements Parcelable.Creator<FrameData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FrameData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Long r101 = null;
            if (r100.readInt() != 0) goto L5;
            ConcurrentHashMap r102 = null;
        L9:
            if (r100.readInt() == 0) goto L13;
            r101 = Long.valueOf(r100.readLong());
        L13:
            return new FrameData(r102, r101);
        L5:
            int r103 = r100.readInt();
            r102 = new ConcurrentHashMap(r103);
            int r104 = 0;
        L6:
            if (r104 == r103) goto L9;
            r102.put(r100.readString(), FrameInfo.CREATOR.createFromParcel(r100));
            r104 = r104 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final FrameData[] newArray(int r100) {
            return new FrameData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FrameData) == true) goto L8;
        return false;
    L8:
        FrameData r101 = (FrameData) r100;
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.prevTs, r101.prevTs) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        ConcurrentHashMap<String, FrameInfo> r100 = this.data;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.prevTs;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FrameData(data=" + this.data + ", prevTs=" + this.prevTs + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        ConcurrentHashMap<String, FrameInfo> r102 = this.data;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L9:
        Long r103 = this.prevTs;
        if (r103 != null) goto L12;
        r100.writeInt(0);
        return;
    L12:
        r100.writeInt(1);
        r100.writeLong(r103.longValue());
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<Map.Entry<String, FrameInfo>> r104 = r102.entrySet().iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        Map.Entry<String, FrameInfo> r105 = r104.next();
        r100.writeString(r105.getKey());
        r105.getValue().writeToParcel(r100, r101);
        goto L7
    }

    public final ConcurrentHashMap<String, FrameInfo> a() {
        return this.data;
    }

    public final Long b() {
        return this.prevTs;
    }

    public FrameData(ConcurrentHashMap<String, FrameInfo> r100, Long r101) {
        this.data = r100;
        this.prevTs = r101;
    }
}
