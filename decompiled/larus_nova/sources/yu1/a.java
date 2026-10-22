package yu1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public class a {
    private String anchorId;
    private String enterFromMerge;
    private String enterMethod;
    private String followStatus;
    private String liveGuideStoreParam;
    private long roomID;

    public a() {
        this.anchorId = "0";
        this.enterFromMerge = "";
        this.enterMethod = "";
        this.followStatus = "";
        this.liveGuideStoreParam = "";
    }

    public final String getAnchorId() {
        return this.anchorId;
    }

    public final String getEnterFromMerge() {
        return this.enterFromMerge;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getFollowStatus() {
        return this.followStatus;
    }

    public final String getLiveGuideStoreParam() {
        return this.liveGuideStoreParam;
    }

    public final long getRoomID() {
        return this.roomID;
    }

    public final void setAnchorId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.anchorId = r100;
    }

    public final void setEnterFromMerge(String r100) {
        this.enterFromMerge = r100;
    }

    public final void setEnterMethod(String r100) {
        this.enterMethod = r100;
    }

    public final void setFollowStatus(String r100) {
        this.followStatus = r100;
    }

    public final void setLiveGuideStoreParam(String r100) {
        this.liveGuideStoreParam = r100;
    }

    public final void setRoomID(long r100) {
        this.roomID = r100;
    }
}
