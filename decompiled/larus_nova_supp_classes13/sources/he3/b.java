package he3;

import com.bytedance.android.shopping.infeed.data.idl.ImageURL;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lhe3/b;", "", "", "userId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "secUserId", "a", "name", "getName", "Lcom/bytedance/android/shopping/infeed/data/idl/ImageURL;", "avatar", "Lcom/bytedance/android/shopping/infeed/data/idl/ImageURL;", "getAvatar", "()Lcom/bytedance/android/shopping/infeed/data/idl/ImageURL;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("avatar")
    private final ImageURL avatar;

    @SerializedName("name")
    private final String name;

    @SerializedName("sec_user_id")
    private final String secUserId;

    @SerializedName("user_id")
    private final String userId;

    public b() {
    }

    public final String a() {
        return this.secUserId;
    }

    public final String b() {
        return this.userId;
    }
}
