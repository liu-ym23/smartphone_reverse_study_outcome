package p34;

import com.bytedance.awemeopen.bizmodels.profile.User;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import r14.a0;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lp34/c;", "Ln14/a;", "Lcom/bytedance/awemeopen/bizmodels/profile/User;", "user", "Lcom/bytedance/awemeopen/bizmodels/profile/User;", "f", "()Lcom/bytedance/awemeopen/bizmodels/profile/User;", "setUser", "(Lcom/bytedance/awemeopen/bizmodels/profile/User;)V", "Lr14/a0;", "logPb", "Lr14/a0;", "e", "()Lr14/a0;", "setLogPb", "(Lr14/a0;)V", "<init>", "()V", "ao_domain_release"}, k = 1, mv = {1, 7, 1})
public final class c extends n14.a {

    @SerializedName("log_pb")
    private a0 logPb;

    @SerializedName("user")
    private User user;

    public c() {
    }

    public final a0 e() {
        return this.logPb;
    }

    public final User f() {
        return this.user;
    }
}
