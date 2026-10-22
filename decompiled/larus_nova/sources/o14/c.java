package o14;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import r14.a0;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lo14/c;", "", "Lo14/a;", "comment", "Lo14/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lo14/a;", "setComment", "(Lo14/a;)V", "", "isPartSeeItem", "Z", "()Z", "setPartSeeItem", "(Z)V", "Lr14/a0;", "logPb", "Lr14/a0;", "getLogPb", "()Lr14/a0;", "setLogPb", "(Lr14/a0;)V", "", "statusCode", "I", "getStatusCode", "()I", "setStatusCode", "(I)V", "", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG, "Ljava/lang/String;", "getStatusMsg", "()Ljava/lang/String;", "setStatusMsg", "(Ljava/lang/String;)V", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public class c {

    @SerializedName("comment")
    private a comment;

    @SerializedName("is_part_see_item")
    private boolean isPartSeeItem;

    @SerializedName("log_pb")
    private a0 logPb;

    @SerializedName("status_code")
    private int statusCode;

    @SerializedName("status_msg")
    private String statusMsg;

    public c() {
    }

    public final a a() {
        return this.comment;
    }
}
