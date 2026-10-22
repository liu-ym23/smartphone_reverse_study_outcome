package j10;

import am3.g;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.game.api.ConfigExtraResponse.Data")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lj10/a;", "", "", "gameId", "J", "", PromotionProductPrivilegesStruct.TAGS, "Ljava/lang/String;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f496856a;

    @SerializedName("game_id")
    public long gameId;

    @SerializedName("config_extra")
    public String tags;

    public a() {
        this.gameId = 0;
        this.tags = "";
    }

    public a(g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L11;
        if (r103 != 1) goto L7;
        this.gameId = r100.j();
        r102 = r102 | true;
        goto L3
    L7:
        if (r103 != 3) goto L8;
        this.tags = am3.h.c(r100);
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L11:
        r100.d(r101);
        if ((r102 & true) == true) goto L15;
        this.gameId = 0;
    L15:
        if (this.tags != null) goto L27;
        this.tags = "";
        return;
    }
}
