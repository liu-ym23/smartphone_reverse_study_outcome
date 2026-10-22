package r14;

import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.vm.UnifyPreVerifyRiskSmsVM;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b \u0010!R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lr14/a;", "", "", "code", "I", "getCode", "()I", "setCode", "(I)V", "showType", "getShowType", "setShowType", "", "toastMsg", "Ljava/lang/String;", "getToastMsg", "()Ljava/lang/String;", "setToastMsg", "(Ljava/lang/String;)V", "extra", "getExtra", "setExtra", "transcode", "getTranscode", "setTranscode", "", ITTVideoEngineEventSource.KEY_MUTE, "Z", "getMute", "()Z", "setMute", "(Z)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class a {

    @SerializedName("code")
    private int code;

    @SerializedName("extra")
    private String extra;

    @SerializedName(ITTVideoEngineEventSource.KEY_MUTE)
    private boolean mute;

    @SerializedName("show_type")
    private int showType;

    @SerializedName(UnifyPreVerifyRiskSmsVM.KEY_TOAST_MSG)
    private String toastMsg;

    @SerializedName("transcode")
    private int transcode;

    /* JADX INFO: renamed from: r14.a$a, reason: collision with other inner class name */
    public static final class C7417a {
    }

    static {
    }

    public a() {
        this.showType = 2;
        this.toastMsg = "";
        this.extra = "";
        this.transcode = 3;
    }
}
