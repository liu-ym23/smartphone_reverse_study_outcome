package com.bytedance.awemeopen.bizmodels.feed;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import java.io.Serializable;
import kotlin.Metadata;
import t14.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b-\u0010.R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/MvModel;", "Ljava/io/Serializable;", "", "mvId", "Ljava/lang/String;", "getMvId", "()Ljava/lang/String;", "setMvId", "(Ljava/lang/String;)V", "name", "getName", "setName", "Lt14/a;", "iconUrl", "Lt14/a;", "getIconUrl", "()Lt14/a;", "setIconUrl", "(Lt14/a;)V", "", "userCount", "Ljava/lang/Long;", "getUserCount", "()Ljava/lang/Long;", "setUserCount", "(Ljava/lang/Long;)V", SocialConstants.PARAM_APP_DESC, "getDesc", "setDesc", "extra", "getExtra", "setExtra", "", "isCollected", "Z", "()Z", "setCollected", "(Z)V", "Lcom/bytedance/awemeopen/bizmodels/feed/WelfareActivity;", "welfareActivity", "Lcom/bytedance/awemeopen/bizmodels/feed/WelfareActivity;", "getWelfareActivity", "()Lcom/bytedance/awemeopen/bizmodels/feed/WelfareActivity;", "setWelfareActivity", "(Lcom/bytedance/awemeopen/bizmodels/feed/WelfareActivity;)V", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class MvModel implements Serializable {

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private String desc;

    @SerializedName("extra")
    private String extra;

    @SerializedName("icon_url")
    private a iconUrl;

    @SerializedName("is_collected")
    private boolean isCollected;

    @SerializedName("id")
    private String mvId;

    @SerializedName("name")
    private String name;

    @SerializedName("user_count")
    private Long userCount;

    @SerializedName("activity_info")
    private WelfareActivity welfareActivity;

    public MvModel() {
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final a getIconUrl() {
        return this.iconUrl;
    }

    public final String getMvId() {
        return this.mvId;
    }

    public final String getName() {
        return this.name;
    }

    public final Long getUserCount() {
        return this.userCount;
    }

    public final WelfareActivity getWelfareActivity() {
        return this.welfareActivity;
    }

    public final boolean isCollected() {
        return this.isCollected;
    }

    public final void setCollected(boolean r100) {
        this.isCollected = r100;
    }

    public final void setDesc(String r100) {
        this.desc = r100;
    }

    public final void setExtra(String r100) {
        this.extra = r100;
    }

    public final void setIconUrl(a r100) {
        this.iconUrl = r100;
    }

    public final void setMvId(String r100) {
        this.mvId = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setUserCount(Long r100) {
        this.userCount = r100;
    }

    public final void setWelfareActivity(WelfareActivity r100) {
        this.welfareActivity = r100;
    }
}
