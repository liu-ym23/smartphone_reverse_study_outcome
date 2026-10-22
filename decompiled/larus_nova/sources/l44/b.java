package l44;

import com.bytedance.awemeopen.bizmodels.profile.User;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Ll44/b;", "", "Lcom/bytedance/awemeopen/bizmodels/profile/User;", "user", "Lcom/bytedance/awemeopen/bizmodels/profile/User;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/awemeopen/bizmodels/profile/User;", "setUser", "(Lcom/bytedance/awemeopen/bizmodels/profile/User;)V", "<init>", "()V", "ao_domain_release"}, k = 1, mv = {1, 7, 1})
public final class b {

    @SerializedName("user_data")
    private User user;

    public b() {
    }

    public final User a() {
        return this.user;
    }
}
