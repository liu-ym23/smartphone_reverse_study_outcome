package vv;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.im.InteractionPlayAuthEventParam")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Lvv/e;", "", "", "promoteGameId", "Ljava/lang/String;", "gameName", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e implements vh7.h {

    @SerializedName(EventConstants.ExtraJson.GAME_NAME)
    public String gameName;

    @SerializedName("promote_game_id")
    public String promoteGameId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L10;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.promoteGameId, r101.promoteGameId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.gameName, r101.gameName) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.promoteGameId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.gameName;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "InteractionPlayAuthEventParam(promoteGameId=" + this.promoteGameId + ", gameName=" + this.gameName + ")";
    }

    public e() {
        this.promoteGameId = "";
        this.gameName = "";
    }

    public e(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.promoteGameId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.gameName = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.promoteGameId != null) goto L16;
        this.promoteGameId = "";
    L16:
        if (this.gameName != null) goto L28;
        this.gameName = "";
        return;
    }

    public e(int r100) {
        Intrinsics.checkNotNullParameter("", "promoteGameId");
        Intrinsics.checkNotNullParameter("", "gameName");
        this.promoteGameId = "";
        this.gameName = "";
    }
}
