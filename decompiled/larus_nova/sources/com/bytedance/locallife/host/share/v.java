package com.bytedance.locallife.host.share;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/bytedance/locallife/host/share/v;", "", "", "image", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "innerUrl", "b", "", "forbitList", "Ljava/util/List;", "getForbitList", "()Ljava/util/List;", "shareItems", "getShareItems", "title", "c", "url", "d", "platform", "getPlatform", SocialConstants.PARAM_APP_DESC, "getDesc", "Lcom/bytedance/locallife/host/share/u;", "shareChannels", "getShareChannels", "locallife-host-api_release"}, k = 1, mv = {1, 4, 3})
public final class v {

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private final String desc;

    @SerializedName("shareEntriesForbidList")
    private final List<String> forbitList;

    @SerializedName("image")
    private final String image;

    @SerializedName("innerUrl")
    private final String innerUrl;

    @SerializedName("platform")
    private final String platform;

    @SerializedName("shareChannels")
    private final List<u> shareChannels;

    @SerializedName("shareitems")
    private final List<String> shareItems;

    @SerializedName("title")
    private final String title;

    @SerializedName("url")
    private final String url;

    public v() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.innerUrl, r101.innerUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.forbitList, r101.forbitList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.shareItems, r101.shareItems) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.platform, r101.platform) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.shareChannels, r101.shareChannels) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.image;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.innerUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.forbitList;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.shareItems;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.title;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.url;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.platform;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.desc;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        List<u> r125 = this.shareChannels;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ShareInfo(image=" + this.image + ", innerUrl=" + this.innerUrl + ", forbitList=" + this.forbitList + ", shareItems=" + this.shareItems + ", title=" + this.title + ", url=" + this.url + ", platform=" + this.platform + ", desc=" + this.desc + ", shareChannels=" + this.shareChannels + ')';
    }

    public final String a() {
        return this.image;
    }

    public final String b() {
        return this.innerUrl;
    }

    public final String c() {
        return this.title;
    }

    public final String d() {
        return this.url;
    }

    public v(String r100, String r101, List<String> r102, List<String> r103, String r104, String r105, String r106, String r107, List<u> r108) {
        this.image = r100;
        this.innerUrl = r101;
        this.forbitList = r102;
        this.shareItems = r103;
        this.title = r104;
        this.url = r105;
        this.platform = r106;
        this.desc = r107;
        this.shareChannels = r108;
    }
}
