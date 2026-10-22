package com.bytedance.awemeopen.bizmodels.profile;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/profile/f;", "", "", "topItem", "I", "getTopItem", "()I", "setTopItem", "(I)V", "starAtlasOrder", "getStarAtlasOrder", "setStarAtlasOrder", "eliteLogin", "getEliteLogin", "setEliteLogin", "enterprise", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setEnterprise", "headImage", "getHeadImage", "setHeadImage", "eHomepageTabManagement", "getEHomepageTabManagement", "setEHomepageTabManagement", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class f {

    @SerializedName("e_homepage_tab_management")
    private int eHomepageTabManagement;

    @SerializedName("elite_login")
    private int eliteLogin;

    @SerializedName("enterprise")
    private int enterprise;

    @SerializedName("head_image")
    private int headImage;

    @SerializedName("star_atlas_order")
    private int starAtlasOrder;

    @SerializedName("top_item")
    private int topItem;

    public f() {
        this.topItem = -1;
        this.starAtlasOrder = -1;
        this.eliteLogin = -1;
        this.enterprise = -1;
        this.headImage = -1;
        this.eHomepageTabManagement = -1;
    }

    public final int a() {
        return this.enterprise;
    }
}
