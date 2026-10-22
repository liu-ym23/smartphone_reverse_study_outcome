package com.bytedance.ee.bear.appsetting.host;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@AppConfig(key = CcmHostAppSettingMap.SETTING_KEY)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/appsetting/host/CcmHostAppSettingMap;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "lark", "Lcom/bytedance/ee/bear/appsetting/host/CcmHostConfig;", "getLark", "()Lcom/bytedance/ee/bear/appsetting/host/CcmHostConfig;", "setLark", "(Lcom/bytedance/ee/bear/appsetting/host/CcmHostConfig;)V", "doubaoPersonal", "getDoubaoPersonal", "setDoubaoPersonal", "doubaoEnterprise", "getDoubaoEnterprise", "setDoubaoEnterprise", "Companion", "base-app-setting_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CcmHostAppSettingMap implements NonProguard {
    public static final a Companion = null;
    public static final String SETTING_KEY = "ccm_host_app_setting";

    @SerializedName("doubao_enterprise")
    private CcmHostConfig doubaoEnterprise;

    @SerializedName("doubao_personal")
    private CcmHostConfig doubaoPersonal;
    private CcmHostConfig lark;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CcmHostAppSettingMap() {
    }

    public final CcmHostConfig getDoubaoEnterprise() {
        return this.doubaoEnterprise;
    }

    public final CcmHostConfig getDoubaoPersonal() {
        return this.doubaoPersonal;
    }

    public final CcmHostConfig getLark() {
        return this.lark;
    }

    public final void setDoubaoEnterprise(CcmHostConfig r100) {
        this.doubaoEnterprise = r100;
    }

    public final void setDoubaoPersonal(CcmHostConfig r100) {
        this.doubaoPersonal = r100;
    }

    public final void setLark(CcmHostConfig r100) {
        this.lark = r100;
    }
}
