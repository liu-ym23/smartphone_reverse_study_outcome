package w20;

import com.bytedance.android.live.base.model.user.User;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lw20/yc;", "", "", "isShowNotPreviewOption", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setShowNotPreviewOption", "(Ljava/lang/Boolean;)V", "", "visibleType", "Ljava/lang/Integer;", "getVisibleType", "()Ljava/lang/Integer;", "setVisibleType", "(Ljava/lang/Integer;)V", "", "Lcom/bytedance/android/live/base/model/user/User;", "userList", "Ljava/util/List;", "getUserList", "()Ljava/util/List;", "setUserList", "(Ljava/util/List;)V", "<init>", "()V", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class yc {

    @SerializedName("isShowNotPreviewOption")
    private Boolean isShowNotPreviewOption;

    @SerializedName("userList")
    private List<? extends User> userList;

    @SerializedName("visibleType")
    private Integer visibleType;

    public yc() {
    }
}
