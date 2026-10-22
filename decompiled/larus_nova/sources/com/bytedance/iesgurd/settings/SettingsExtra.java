package com.bytedance.iesgurd.settings;

import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0018\u0010\u0019R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/bytedance/iesgurd/settings/SettingsExtra;", "", "", "", "noLocalAk", "Ljava/util/List;", "getNoLocalAk", "()Ljava/util/List;", "setNoLocalAk", "(Ljava/util/List;)V", "Lcom/bytedance/iesgurd/settings/SettingsExtra$a;", "pcdnInfo", "Lcom/bytedance/iesgurd/settings/SettingsExtra$a;", "getPcdnInfo", "()Lcom/bytedance/iesgurd/settings/SettingsExtra$a;", "setPcdnInfo", "(Lcom/bytedance/iesgurd/settings/SettingsExtra$a;)V", "Lcom/bytedance/iesgurd/settings/SettingsExtra$ProbeInfo;", "probeInfo", "Lcom/bytedance/iesgurd/settings/SettingsExtra$ProbeInfo;", "getProbeInfo", "()Lcom/bytedance/iesgurd/settings/SettingsExtra$ProbeInfo;", "setProbeInfo", "(Lcom/bytedance/iesgurd/settings/SettingsExtra$ProbeInfo;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ProbeInfo", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class SettingsExtra {

    @SerializedName("no_local_ak")
    private List<String> noLocalAk;

    @SerializedName("p2p")
    private a pcdnInfo;

    @SerializedName("probe")
    private ProbeInfo probeInfo;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/iesgurd/settings/SettingsExtra$ProbeInfo;", "", "()V", "probeThreshold", "", "getProbeThreshold", "()I", "setProbeThreshold", "(I)V", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    public static final class ProbeInfo {

        @SerializedName("probe_threshold")
        private int probeThreshold;

        public ProbeInfo() {
        }

        public final int getProbeThreshold() {
            return this.probeThreshold;
        }

        public final void setProbeThreshold(int r100) {
            this.probeThreshold = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/iesgurd/settings/SettingsExtra$a;", "", "", "businessId", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "setBusinessId", "(Ljava/lang/Integer;)V", "", "groupId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "testId", "c", "setTestId", "<init>", "()V", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
    public static final class a {

        @SerializedName(WsConstants.KEY_SESSION_ID)
        private Integer businessId;

        @SerializedName("pcdn_groupid")
        private String groupId;

        @SerializedName("pcdn_testid")
        private String testId;

        public a() {
            this.groupId = "";
            this.testId = "";
        }

        public final Integer a() {
            return this.businessId;
        }

        public final String b() {
            return this.groupId;
        }

        public final String c() {
            return this.testId;
        }
    }

    public SettingsExtra() {
    }

    public final List<String> getNoLocalAk() {
        return this.noLocalAk;
    }

    public final a getPcdnInfo() {
        return this.pcdnInfo;
    }

    public final ProbeInfo getProbeInfo() {
        return this.probeInfo;
    }

    public final void setNoLocalAk(List<String> r100) {
        this.noLocalAk = r100;
    }

    public final void setPcdnInfo(a r100) {
        this.pcdnInfo = r100;
    }

    public final void setProbeInfo(ProbeInfo r100) {
        this.probeInfo = r100;
    }
}
