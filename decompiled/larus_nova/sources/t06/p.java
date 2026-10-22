package t06;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\t\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0011R\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001e\u0010\u0011R.\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\t\u001a\u0004\b%\u0010\u000bR\u001c\u0010&\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\t\u001a\u0004\b'\u0010\u000b¨\u0006("}, d2 = {"Lt06/p;", "Lt06/a;", "", "verifyMode", "I", ce.f26396k, "()I", "", "disableGlobalPkSign", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "", "", "urlDegradeList", "Ljava/util/List;", RXScreenCaptureService.KEY_INDEX, "()Ljava/util/List;", "enableTsVerify", "d", "", "blockTimestamp", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "highRiskSceneList", ce.f26391f, "highRiskUrlDegradeList", "h", "forbiddenVerifyUrl", "f", "", "feLimitLoadSecCid", "Ljava/util/Map;", "e", "()Ljava/util/Map;", "usePreDecodeInfo", ce.f26395j, "blockReadBlockFailed", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class p extends a {

    @SerializedName("block_read_block_failed")
    private final Boolean blockReadBlockFailed;

    @SerializedName("block_timestamp")
    private final Long blockTimestamp;

    @SerializedName("disable_global_pk_sign")
    private final Boolean disableGlobalPkSign;

    @SerializedName("enable_ts_verify")
    private final Boolean enableTsVerify;

    @SerializedName("fe_limit_load_sec_cid")
    private final Map<String, List<String>> feLimitLoadSecCid;

    @SerializedName("forbidden_verify_url")
    private final List<String> forbiddenVerifyUrl;

    @SerializedName("high_risk_scene_list")
    private final List<String> highRiskSceneList;

    @SerializedName("high_risk_url_degrade_list")
    private final List<String> highRiskUrlDegradeList;

    @SerializedName("url_degrade_list")
    private final List<String> urlDegradeList;

    @SerializedName("use_predecode_info")
    private final Boolean usePreDecodeInfo;

    @SerializedName("sign_verify_mode")
    private final int verifyMode;

    public p() {
        Boolean r100 = Boolean.FALSE;
        this.verifyMode = 0;
        this.disableGlobalPkSign = r100;
        this.urlDegradeList = null;
        this.enableTsVerify = r100;
        this.blockTimestamp = null;
        this.highRiskSceneList = null;
        this.highRiskUrlDegradeList = null;
        this.forbiddenVerifyUrl = null;
        this.feLimitLoadSecCid = null;
        this.usePreDecodeInfo = r100;
        this.blockReadBlockFailed = r100;
    }

    public final Boolean a() {
        return this.blockReadBlockFailed;
    }

    public final Long b() {
        return this.blockTimestamp;
    }

    public final Boolean c() {
        return this.disableGlobalPkSign;
    }

    public final Boolean d() {
        return this.enableTsVerify;
    }

    public final Map<String, List<String>> e() {
        return this.feLimitLoadSecCid;
    }

    public final List<String> f() {
        return this.forbiddenVerifyUrl;
    }

    public final List<String> g() {
        return this.highRiskSceneList;
    }

    public final List<String> h() {
        return this.highRiskUrlDegradeList;
    }

    public final List<String> i() {
        return this.urlDegradeList;
    }

    public final Boolean j() {
        return this.usePreDecodeInfo;
    }

    public final int k() {
        return this.verifyMode;
    }
}
