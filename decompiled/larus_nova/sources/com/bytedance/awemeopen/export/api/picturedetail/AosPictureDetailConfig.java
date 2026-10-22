package com.bytedance.awemeopen.export.api.picturedetail;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.awemeopen.export.api.pageconfig.feedhome.FeedFollowExtra;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b \b\u0007\u0018\u0000 R2\u00020\u0001:\u0001SB\u0007¢\u0006\u0004\bO\u0010PB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\bO\u0010QJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R$\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0012\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u0010\u0016R$\u00101\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0012\u001a\u0004\b2\u0010\u0014\"\u0004\b3\u0010\u0016R\"\u00105\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010;\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010A\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010<\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@R\"\u0010D\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010\u000b\u001a\u0004\bE\u0010\r\"\u0004\bF\u0010\u000fR$\u0010G\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010\u001f\u001a\u0004\bH\u0010!\"\u0004\bI\u0010#R\"\u0010J\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010\u000b\u001a\u0004\bK\u0010\r\"\u0004\bL\u0010\u000fR\u0011\u0010N\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\bM\u0010\u0014¨\u0006T"}, d2 = {"Lcom/bytedance/awemeopen/export/api/picturedetail/AosPictureDetailConfig;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "", "shouldPaddingStatusBarHeight", "Z", "getShouldPaddingStatusBarHeight", "()Z", "setShouldPaddingStatusBarHeight", "(Z)V", "", "previousPage", "Ljava/lang/String;", "getPreviousPage", "()Ljava/lang/String;", "setPreviousPage", "(Ljava/lang/String;)V", "enterAid", "getEnterAid", "setEnterAid", "enterRequestId", "getEnterRequestId", "setEnterRequestId", "Lorg/json/JSONObject;", "hostCommonParams", "Lorg/json/JSONObject;", "getHostCommonParams", "()Lorg/json/JSONObject;", "setHostCommonParams", "(Lorg/json/JSONObject;)V", "hostExtraParams", "getHostExtraParams", "setHostExtraParams", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/FeedFollowExtra;", "feedFollowExtra", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/FeedFollowExtra;", "getFeedFollowExtra", "()Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/FeedFollowExtra;", "setFeedFollowExtra", "(Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/FeedFollowExtra;)V", "hostPlaceholderUrl", "getHostPlaceholderUrl", "setHostPlaceholderUrl", "contentScene", "getContentScene", "setContentScene", "", "hostEnterTime", "J", "getHostEnterTime", "()J", "setHostEnterTime", "(J)V", "offscreenPageLimit", "I", "getOffscreenPageLimit", "()I", "setOffscreenPageLimit", "(I)V", "imageDiskCacheCount", "getImageDiskCacheCount", "setImageDiskCacheCount", "optVisibilityAggregated", "getOptVisibilityAggregated", "setOptVisibilityAggregated", "localLifeSchemaParams", "getLocalLifeSchemaParams", "setLocalLifeSchemaParams", "enablePreloadFilterExemptItem", "getEnablePreloadFilterExemptItem", "setEnablePreloadFilterExemptItem", "getHostEnterFrom", "hostEnterFrom", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_export_api_release"}, k = 1, mv = {1, 7, 1})
public final class AosPictureDetailConfig implements Parcelable {
    public static final String CONFIG_KEY = "PICTURE_DETAIL_CONFIG_KEY";
    public static final a CREATOR = null;
    private String contentScene;
    private boolean enablePreloadFilterExemptItem;
    private String enterAid;
    private String enterRequestId;
    private FeedFollowExtra feedFollowExtra;
    private JSONObject hostCommonParams;
    private long hostEnterTime;
    private JSONObject hostExtraParams;
    private String hostPlaceholderUrl;
    private int imageDiskCacheCount;
    private JSONObject localLifeSchemaParams;
    private int offscreenPageLimit;
    private boolean optVisibilityAggregated;
    private String previousPage;
    private boolean shouldPaddingStatusBarHeight;

    public static final class a implements Parcelable.Creator<AosPictureDetailConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AosPictureDetailConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new AosPictureDetailConfig(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final AosPictureDetailConfig[] newArray(int r100) {
            return new AosPictureDetailConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getHostEnterFrom() {
        return this.hostCommonParams.optString("host_enter_from", "");
    }

    public AosPictureDetailConfig() {
        this.hostCommonParams = new JSONObject();
        this.hostExtraParams = new JSONObject();
        this.offscreenPageLimit = 3;
    }

    public final String getContentScene() {
        return this.contentScene;
    }

    public final boolean getEnablePreloadFilterExemptItem() {
        return this.enablePreloadFilterExemptItem;
    }

    public final String getEnterAid() {
        return this.enterAid;
    }

    public final String getEnterRequestId() {
        return this.enterRequestId;
    }

    public final FeedFollowExtra getFeedFollowExtra() {
        return this.feedFollowExtra;
    }

    public final JSONObject getHostCommonParams() {
        return this.hostCommonParams;
    }

    public final long getHostEnterTime() {
        return this.hostEnterTime;
    }

    public final JSONObject getHostExtraParams() {
        return this.hostExtraParams;
    }

    public final String getHostPlaceholderUrl() {
        return this.hostPlaceholderUrl;
    }

    public final int getImageDiskCacheCount() {
        return this.imageDiskCacheCount;
    }

    public final JSONObject getLocalLifeSchemaParams() {
        return this.localLifeSchemaParams;
    }

    public final int getOffscreenPageLimit() {
        return this.offscreenPageLimit;
    }

    public final boolean getOptVisibilityAggregated() {
        return this.optVisibilityAggregated;
    }

    public final String getPreviousPage() {
        return this.previousPage;
    }

    public final boolean getShouldPaddingStatusBarHeight() {
        return this.shouldPaddingStatusBarHeight;
    }

    public AosPictureDetailConfig(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this();
        this.previousPage = r100.readString();
        this.enterAid = r100.readString();
        this.enterRequestId = r100.readString();
        boolean r101 = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.shouldPaddingStatusBarHeight = r102;
        String r103 = r100.readString();
        if (r103 == null) goto L9;
        JSONObject r104 = new JSONObject(r103);
    L10:
        this.hostCommonParams = r104;
        this.feedFollowExtra = (FeedFollowExtra) r100.readParcelable(FeedFollowExtra.class.getClassLoader());
        this.hostPlaceholderUrl = r100.readString();
        this.contentScene = r100.readString();
        this.hostEnterTime = r100.readLong();
        String r105 = r100.readString();
        if (r105 == null) goto L13;
        JSONObject r106 = new JSONObject(r105);
    L14:
        this.hostExtraParams = r106;
        this.offscreenPageLimit = r100.readInt();
        this.imageDiskCacheCount = r100.readInt();
        if (r100.readByte() == 0) goto L17;
        boolean r107 = true;
    L18:
        this.optVisibilityAggregated = r107;
        String r108 = r100.readString();
        if (r108 == null) goto L25;
        JSONObject r109 = new JSONObject(r108);     // Catch: Exception -> L22
    L23:
        this.localLifeSchemaParams = r109;
    L22:
        r109 = new JSONObject();
    L25:
        if (r100.readByte() != 0) goto L28;
        r101 = false;
    L28:
        this.enablePreloadFilterExemptItem = r101;
        return;
    L17:
        r107 = false;
        goto L18
    L13:
        r106 = new JSONObject();
        goto L14
    L9:
        r104 = new JSONObject();
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public final void setContentScene(String r100) {
        this.contentScene = r100;
    }

    public final void setEnablePreloadFilterExemptItem(boolean r100) {
        this.enablePreloadFilterExemptItem = r100;
    }

    public final void setEnterAid(String r100) {
        this.enterAid = r100;
    }

    public final void setEnterRequestId(String r100) {
        this.enterRequestId = r100;
    }

    public final void setFeedFollowExtra(FeedFollowExtra r100) {
        this.feedFollowExtra = r100;
    }

    public final void setHostCommonParams(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.hostCommonParams = r100;
    }

    public final void setHostEnterTime(long r100) {
        this.hostEnterTime = r100;
    }

    public final void setHostExtraParams(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.hostExtraParams = r100;
    }

    public final void setHostPlaceholderUrl(String r100) {
        this.hostPlaceholderUrl = r100;
    }

    public final void setImageDiskCacheCount(int r100) {
        this.imageDiskCacheCount = r100;
    }

    public final void setLocalLifeSchemaParams(JSONObject r100) {
        this.localLifeSchemaParams = r100;
    }

    public final void setOffscreenPageLimit(int r100) {
        this.offscreenPageLimit = r100;
    }

    public final void setOptVisibilityAggregated(boolean r100) {
        this.optVisibilityAggregated = r100;
    }

    public final void setPreviousPage(String r100) {
        this.previousPage = r100;
    }

    public final void setShouldPaddingStatusBarHeight(boolean r100) {
        this.shouldPaddingStatusBarHeight = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.previousPage);
        r100.writeString(this.enterAid);
        r100.writeString(this.enterRequestId);
        r100.writeByte(this.shouldPaddingStatusBarHeight ? 1 : 0);
        r100.writeString(this.hostCommonParams.toString());
        r100.writeParcelable(this.feedFollowExtra, r101);
        r100.writeString(this.hostPlaceholderUrl);
        r100.writeString(this.contentScene);
        r100.writeLong(this.hostEnterTime);
        r100.writeString(this.hostExtraParams.toString());
        r100.writeInt(this.offscreenPageLimit);
        r100.writeInt(this.imageDiskCacheCount);
        r100.writeByte(this.optVisibilityAggregated ? 1 : 0);
        JSONObject r102 = this.localLifeSchemaParams;
        if (r102 == null) goto L5;
        String r103 = String.valueOf(r102);
    L6:
        r100.writeString(r103);
        r100.writeByte(this.enablePreloadFilterExemptItem ? 1 : 0);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
