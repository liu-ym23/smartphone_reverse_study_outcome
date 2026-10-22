package wt;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.AnchorRecommendPropDetailResponse.Data")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lwt/g;", "", "", "gameId", "Ljava/lang/String;", "gameName", "gameIcon", "gameIntroduction", "Lwt/e;", "gamePropInfo", "Lwt/e;", "Lwt/c;", "accountInfo", "Lwt/c;", "Lwt/f;", "userInfoStats", "Lwt/f;", "", "Lwt/m;", "userClaimCoupons", "Ljava/util/List;", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g implements vh7.h {

    @SerializedName("user_info")
    public c accountInfo;

    @SerializedName("game_icon")
    public String gameIcon;

    @SerializedName("game_id")
    public String gameId;

    @SerializedName("game_introduction")
    public String gameIntroduction;

    @SerializedName(EventConstants.ExtraJson.GAME_NAME)
    public String gameName;

    @SerializedName("game_prop")
    public e gamePropInfo;

    @SerializedName("user_claim_coupons")
    public List<m> userClaimCoupons;

    @SerializedName("user_info_stats")
    public f userInfoStats;

    public g() {
        this.gameId = "";
        this.gameName = "";
        this.gameIntroduction = "";
        this.userClaimCoupons = new ArrayList();
    }

    public g(am3.g r100) {
        this.userClaimCoupons = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        switch(r102) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.userClaimCoupons.add(new m(r100));
        goto L3
    L8:
        this.userInfoStats = new f(r100);
        goto L3
    L9:
        this.accountInfo = new c(r100);
        goto L3
    L10:
        this.gameIcon = am3.h.c(r100);
        goto L3
    L11:
        this.gameIntroduction = am3.h.c(r100);
        goto L3
    L12:
        this.gameName = am3.h.c(r100);
        goto L3
    L13:
        this.gameId = am3.h.c(r100);
        goto L3
    L14:
        this.gamePropInfo = new e(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.gameId != null) goto L19;
        this.gameId = "";
    L19:
        if (this.gameName != null) goto L22;
        this.gameName = "";
    L22:
        if (this.gameIntroduction != null) goto L25;
        this.gameIntroduction = "";
    L25:
        if (this.userClaimCoupons.isEmpty() == false) goto L48;
        this.userClaimCoupons = new ArrayList();
        return;
    }
}
