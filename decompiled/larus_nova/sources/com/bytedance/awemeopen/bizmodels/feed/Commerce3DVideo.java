package com.bytedance.awemeopen.bizmodels.feed;

import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r14.j0;
import t14.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\"\u0010#J\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u001b\u0010\bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010\u0014R\u001c\u0010 \u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0006\u001a\u0004\b!\u0010\b¨\u0006$"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/Commerce3DVideo;", "Ljava/io/Serializable;", "", "valid", "", "cid", "Ljava/lang/String;", "getCid", "()Ljava/lang/String;", "setCid", "(Ljava/lang/String;)V", "Lr14/j0;", "backgroundVideo", "Lr14/j0;", "getBackgroundVideo", "()Lr14/j0;", "Lt14/a;", "foregroundAnim", "Lt14/a;", "getForegroundAnim", "()Lt14/a;", "", "gestureType", "I", "getGestureType", "()I", NativeDownloadModel.JsonKey.WEB_URL, "getWebUrl", RuleConditionBean.OPEN_URL_KEY, "getOpenUrl", "coverImg", "getCoverImg", "complianceData", "getComplianceData", "<init>", "(Ljava/lang/String;Lr14/j0;Lt14/a;ILjava/lang/String;Ljava/lang/String;Lt14/a;Ljava/lang/String;)V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class Commerce3DVideo implements Serializable {

    @SerializedName(ShortVideoSegments.KEY_BACKGROUND_VIDEO)
    private final j0 backgroundVideo;
    private String cid;

    @SerializedName("compliance_data")
    private final String complianceData;

    @SerializedName("cover_img")
    private final a coverImg;

    @SerializedName("foreground_anim")
    private final a foregroundAnim;

    @SerializedName("gesture_type")
    private final int gestureType;

    @SerializedName("open_url")
    private final String openUrl;

    @SerializedName("web_url")
    private final String webUrl;

    public Commerce3DVideo() {
        this(null, null, null, 0, null, null, null, null, 255, null);
    }

    public final boolean valid() {
        if (this.backgroundVideo != null) goto L5;
    L7:
        return false;
    L5:
        if (this.foregroundAnim == null) goto L7;
        return true;
    }

    public final j0 getBackgroundVideo() {
        return this.backgroundVideo;
    }

    public final String getCid() {
        return this.cid;
    }

    public final String getComplianceData() {
        return this.complianceData;
    }

    public final a getCoverImg() {
        return this.coverImg;
    }

    public final a getForegroundAnim() {
        return this.foregroundAnim;
    }

    public final int getGestureType() {
        return this.gestureType;
    }

    public final String getOpenUrl() {
        return this.openUrl;
    }

    public final String getWebUrl() {
        return this.webUrl;
    }

    public final void setCid(String r100) {
        this.cid = r100;
    }

    public Commerce3DVideo(String r100, j0 r101, a r102, int r103, String r104, String r105, a r106, String r107) {
        this.cid = r100;
        this.backgroundVideo = r101;
        this.foregroundAnim = r102;
        this.gestureType = r103;
        this.webUrl = r104;
        this.openUrl = r105;
        this.coverImg = r106;
        this.complianceData = r107;
    }

    public /* synthetic */ Commerce3DVideo(String r110, j0 r111, a r112, int r113, String r114, String r115, a r116, String r117, int r118, DefaultConstructorMarker r119) {
        String r100 = null;
        if ((r118 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        j0 r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        a r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        int r104 = 1;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        a r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
