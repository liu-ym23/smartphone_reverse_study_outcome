package xi2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b¨\u0006\u001e"}, d2 = {"Lxi2/j0;", "", "", "name", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "code", "b", "setCode", "", "canOperate", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setCanOperate", "(Z)V", "isSelected", "f", "setSelected", "subMsg", "e", "setSubMsg", "operateDisableMsg", "d", "setOperateDisableMsg", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j0 {

    @SerializedName("can_operate")
    private boolean canOperate;

    @SerializedName("code")
    private String code;

    @SerializedName("is_selected")
    private boolean isSelected;

    @SerializedName("name")
    private String name;

    @SerializedName("operate_disable_msg")
    private String operateDisableMsg;

    @SerializedName("sub_msg")
    private String subMsg;

    public j0() {
        this.canOperate = true;
    }

    public final boolean a() {
        return this.canOperate;
    }

    public final String b() {
        return this.code;
    }

    public final String c() {
        return this.name;
    }

    public final String d() {
        return this.operateDisableMsg;
    }

    public final String e() {
        return this.subMsg;
    }

    public final boolean f() {
        return this.isSelected;
    }
}
