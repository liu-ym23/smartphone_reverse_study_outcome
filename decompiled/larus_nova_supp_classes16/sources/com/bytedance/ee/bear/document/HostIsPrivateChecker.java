package com.bytedance.ee.bear.document;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class HostIsPrivateChecker {
    public static final /* synthetic */ int a = 0;

    @AppConfig(key = "openplatform_error_page_info")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R(\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR \u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/document/HostIsPrivateChecker$OpenplatformErrorPageInfo;", "", "<init>", "()V", "privateHostList", "", "", "getPrivateHostList", "()Ljava/util/List;", "setPrivateHostList", "(Ljava/util/List;)V", "pingHosts", "getPingHosts", "setPingHosts", "publicPingHost", "getPublicPingHost", "()Ljava/lang/String;", "setPublicPingHost", "(Ljava/lang/String;)V", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OpenplatformErrorPageInfo {

        @SerializedName("pingHosts")
        private List<String> pingHosts;

        @SerializedName("privateHost")
        private List<String> privateHostList;

        @SerializedName("publicPingHost")
        private String publicPingHost;

        public OpenplatformErrorPageInfo() {
        }

        public final List<String> a() {
            return this.privateHostList;
        }

        public final String b() {
            return this.publicPingHost;
        }
    }

    static {
    }
}
