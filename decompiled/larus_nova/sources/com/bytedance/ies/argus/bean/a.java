package com.bytedance.ies.argus.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/bytedance/ies/argus/bean/a;", "Lcom/bytedance/ies/argus/repository/b;", "Lcom/bytedance/ies/argus/bean/s;", "reportConfig", "Lcom/bytedance/ies/argus/bean/s;", "e", "()Lcom/bytedance/ies/argus/bean/s;", "Lcom/bytedance/ies/argus/bean/m;", "globalDef", "Lcom/bytedance/ies/argus/bean/m;", "b", "()Lcom/bytedance/ies/argus/bean/m;", "Lcom/bytedance/ies/argus/bean/b;", "innerInitSettings", "Lcom/bytedance/ies/argus/bean/b;", "d", "()Lcom/bytedance/ies/argus/bean/b;", "Lcom/bytedance/ies/argus/bean/l;", "forceHttpsSetting", "Lcom/bytedance/ies/argus/bean/l;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/ies/argus/bean/l;", "Lcom/bytedance/ies/argus/bean/g;", "webLoadSettings", "Lcom/bytedance/ies/argus/bean/g;", "f", "()Lcom/bytedance/ies/argus/bean/g;", "", "", "injectSecurityContextJsbList", "Ljava/util/List;", "c", "()Ljava/util/List;", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class a extends com.bytedance.ies.argus.repository.b {

    @SerializedName("force_https_config")
    private final l forceHttpsSetting;

    @SerializedName("global_def")
    private final m globalDef;

    @SerializedName("inject_security_context_jsb_list")
    private final List<String> injectSecurityContextJsbList;

    @SerializedName("inner_init_settings")
    private final b innerInitSettings;

    @SerializedName("report")
    private final s reportConfig;

    @SerializedName("web_load")
    private final g webLoadSettings;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.reportConfig, r101.reportConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.globalDef, r101.globalDef) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.innerInitSettings, r101.innerInitSettings) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.forceHttpsSetting, r101.forceHttpsSetting) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.webLoadSettings, r101.webLoadSettings) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.injectSecurityContextJsbList, r101.injectSecurityContextJsbList) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        s r100 = this.reportConfig;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        m r104 = this.globalDef;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        b r107 = this.innerInitSettings;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        l r110 = this.forceHttpsSetting;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        g r113 = this.webLoadSettings;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.injectSecurityContextJsbList;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
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
        return "ArgusGlobalCommonConfig(reportConfig=" + this.reportConfig + ", globalDef=" + this.globalDef + ", innerInitSettings=" + this.innerInitSettings + ", forceHttpsSetting=" + this.forceHttpsSetting + ", webLoadSettings=" + this.webLoadSettings + ", injectSecurityContextJsbList=" + this.injectSecurityContextJsbList + ')';
    }

    public a() {
        this.reportConfig = null;
        this.globalDef = null;
        this.innerInitSettings = null;
        this.forceHttpsSetting = null;
        this.webLoadSettings = null;
        this.injectSecurityContextJsbList = null;
    }

    public final l a() {
        return this.forceHttpsSetting;
    }

    public final m b() {
        return this.globalDef;
    }

    public final List<String> c() {
        return this.injectSecurityContextJsbList;
    }

    public final b d() {
        return this.innerInitSettings;
    }

    public final s e() {
        return this.reportConfig;
    }

    public final g f() {
        return this.webLoadSettings;
    }
}
