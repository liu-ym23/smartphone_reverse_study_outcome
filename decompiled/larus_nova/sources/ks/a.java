package ks;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.DataChannelTrackInfo")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lks/a;", "", "", "clickIdNature", "Ljava/lang/String;", "gamecpExtra", "gamecpPassThrough", "gameName", "packageName", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName(EventConstants.ExtraJson.KEY_DOWNLOAD_CLICK_ID_NATURE)
    public String clickIdNature;

    @SerializedName(EventConstants.ExtraJson.GAME_NAME)
    public String gameName;

    @SerializedName("gamecp_extra")
    public String gamecpExtra;

    @SerializedName("gamecp_pass_through")
    public String gamecpPassThrough;

    @SerializedName("package_name")
    public String packageName;

    public a() {
    }

    public a(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.clickIdNature = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.gamecpExtra = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.gamecpPassThrough = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.gameName = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.packageName = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }
}
