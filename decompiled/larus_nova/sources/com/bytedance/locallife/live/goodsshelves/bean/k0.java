package com.bytedance.locallife.live.goodsshelves.bean;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.locallife.common.adapter.StringJsonAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R(\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/k0;", "", "", "level", "I", "c", "()I", "Lcom/bytedance/locallife/live/goodsshelves/bean/a1;", "singleProductExpression", "Lcom/bytedance/locallife/live/goodsshelves/bean/a1;", "d", "()Lcom/bytedance/locallife/live/goodsshelves/bean/a1;", "Lcom/bytedance/locallife/live/goodsshelves/bean/l0;", "feConfig", "Lcom/bytedance/locallife/live/goodsshelves/bean/l0;", "b", "()Lcom/bytedance/locallife/live/goodsshelves/bean/l0;", "", "", "abParams", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "failInfo", "getFailInfo", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class k0 {

    @SerializedName(AppConstants.BUNDLE_ACTIVITY_AB_PARAMS_KEYS)
    private final Map<String, Object> abParams;

    @SerializedName("fail_info")
    private final Map<String, Object> failInfo;

    @SerializedName("fe_config")
    @JsonAdapter(StringJsonAdapterFactory.class)
    private final l0 feConfig;

    @SerializedName("level")
    private final int level;

    @SerializedName("single_product_expression")
    private final a1 singleProductExpression;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k0) == true) goto L8;
        return false;
    L8:
        k0 r101 = (k0) r100;
        if (this.level == r101.level) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.singleProductExpression, r101.singleProductExpression) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.feConfig, r101.feConfig) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.abParams, r101.abParams) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.failInfo, r101.failInfo) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.level * 31;
        a1 r101 = this.singleProductExpression;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        l0 r105 = this.feConfig;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Map<String, Object> r108 = this.abParams;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Map<String, Object> r111 = this.failInfo;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MarketingAtmosphereExpressionData(level=" + this.level + ", singleProductExpression=" + this.singleProductExpression + ", feConfig=" + this.feConfig + ", abParams=" + this.abParams + ", failInfo=" + this.failInfo + ')';
    }

    public k0() {
        this.level = 0;
        this.singleProductExpression = null;
        this.feConfig = null;
        this.abParams = null;
        this.failInfo = null;
    }

    public final Map<String, Object> a() {
        return this.abParams;
    }

    public final l0 b() {
        return this.feConfig;
    }

    public final int c() {
        return this.level;
    }

    public final a1 d() {
        return this.singleProductExpression;
    }
}
