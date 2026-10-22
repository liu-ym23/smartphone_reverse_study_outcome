package sj3;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lsj3/i;", "", "", "Lsj3/l;", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "Ljava/util/List;", "c", "()Ljava/util/List;", "", "content", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "Lsj3/o;", "wordRecord", "Lsj3/o;", "d", "()Lsj3/o;", "Lsj3/k;", "extraInfo", "Lsj3/k;", "b", "()Lsj3/k;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("content")
    private final String content;

    @SerializedName("extra_info")
    private final k extraInfo;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION)
    private final List<l> pos;

    @SerializedName("word_record")
    private final o wordRecord;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L14;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.pos, r101.pos) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.wordRecord, r101.wordRecord) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extraInfo, r101.extraInfo) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        List<l> r100 = this.pos;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.content;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        o r107 = this.wordRecord;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        k r110 = this.extraInfo;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "StoreSearchSugItemDTO(pos=" + this.pos + ", content=" + this.content + ", wordRecord=" + this.wordRecord + ", extraInfo=" + this.extraInfo + ")";
    }

    public i() {
        this.pos = null;
        this.content = null;
        this.wordRecord = null;
        this.extraInfo = null;
    }

    public final String a() {
        return this.content;
    }

    public final k b() {
        return this.extraInfo;
    }

    public final List<l> c() {
        return this.pos;
    }

    public final o d() {
        return this.wordRecord;
    }
}
