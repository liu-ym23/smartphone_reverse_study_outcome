package tm7;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes22.dex */
public class a {

    @SerializedName("act_base")
    public String actBase;

    @SerializedName("act_data")
    public String actData;

    @SerializedName("activity_infos")
    public List<C7743a> activityInfos;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_IS_APP_LOGIN)
    public boolean isAppLogin;

    /* JADX INFO: renamed from: tm7.a$a, reason: collision with other inner class name */
    public static class C7743a {

        @SerializedName("act_hash")
        public String actHash;

        @SerializedName("activity_id")
        public String activityId;

        @SerializedName("is_union_login")
        public boolean isUnionLogin;

        public final int hashCode() {
            return Objects.hash(new Object[]{this.activityId, this.actHash, Boolean.valueOf(this.isUnionLogin)});
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L19:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L19;
            C7743a r101 = (C7743a) r100;
            if (this.isUnionLogin == r101.isUnionLogin) goto L13;
        L17:
            return false;
        L13:
            if (Objects.equals(this.activityId, r101.activityId) == false) goto L17;
            if (Objects.equals(this.actHash, r101.actHash) == false) goto L17;
            return true;
        }
    }

    public final String toString() {
        return "CommonResp{actBase='" + this.actBase + "', actData='" + this.actData + "', activityInfos=" + this.activityInfos + ", isAppLogin=" + this.isAppLogin + '}';
    }

    public a() {
    }
}
