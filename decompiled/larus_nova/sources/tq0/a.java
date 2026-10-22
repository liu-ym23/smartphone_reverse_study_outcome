package tq0;

import am3.g;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.api.stamp.GetShelfInfoResponse.Data")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ltq0/a;", "", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "shelfInfo", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "", "disableEntrance", "Z", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("disable_entrance")
    public boolean disableEntrance;

    @SerializedName("shelf_info")
    public ShelfInfo shelfInfo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.shelfInfo, r101.shelfInfo) == true) goto L8;
        return false;
    L8:
        if (this.disableEntrance == r101.disableEntrance) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        ShelfInfo r100 = this.shelfInfo;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.disableEntrance;
        ?? r104 = r103;
        if (r103 == false) goto L10;
        r104 = 1;
    L10:
        return r102 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "GetShelfInfoResponse(shelfInfo=" + this.shelfInfo + ", disableEntrance=" + this.disableEntrance + ")";
    }

    public a() {
        this.shelfInfo = null;
        this.disableEntrance = false;
    }

    public a(g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L11;
        if (r103 != 1) goto L7;
        this.shelfInfo = new ShelfInfo(r100);
        goto L3
    L7:
        if (r103 != 2) goto L8;
        this.disableEntrance = am3.h.a(r100);
        r102 = r102 | true;
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L11:
        r100.d(r101);
        if (this.shelfInfo != null) goto L15;
        this.shelfInfo = null;
    L15:
        if ((r102 & true) == true) goto L27;
        this.disableEntrance = false;
        return;
    }
}
