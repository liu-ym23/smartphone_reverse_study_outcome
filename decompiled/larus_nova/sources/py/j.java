package py;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0016\bg\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u0002:\u0001,R\u001e\u0010\t\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\f\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006R\u001e\u0010\u000f\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\b\u001a\u0004\b\r\u0010\u0006R\"\u0010\u0016\u001a\u00020\u00108&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\b\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00178&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\b\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\"\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b!\u0010\b\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010 R$\u0010&\u001a\u0004\u0018\u00010\u00178&@&X§\u000e¢\u0006\u0012\u0012\u0004\b%\u0010\b\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR$\u0010*\u001a\u0004\u0018\u00010\u00178&@&X§\u000e¢\u0006\u0012\u0012\u0004\b)\u0010\b\u001a\u0004\b'\u0010\u0019\"\u0004\b(\u0010\u001b¨\u0006-"}, d2 = {"Lpy/j;", "Lvh7/c;", "", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getFollowingCount", "()J", "getFollowingCount$annotations", "()V", "followingCount", "getFollowerCount", "getFollowerCount$annotations", "followerCount", "getFollowStatus", "getFollowStatus$annotations", "followStatus", "", "getInvalidFollowStatus", "()Z", "setInvalidFollowStatus", "(Z)V", "getInvalidFollowStatus$annotations", "invalidFollowStatus", "", "getRemarkName", "()Ljava/lang/String;", "setRemarkName", "(Ljava/lang/String;)V", "getRemarkName$annotations", "remarkName", "getPushStatus", "setPushStatus", "(J)V", "getPushStatus$annotations", "pushStatus", "getFollowerCountStr", "setFollowerCountStr", "getFollowerCountStr$annotations", "followerCountStr", "getFollowingCountStr", "setFollowingCountStr", "getFollowingCountStr$annotations", "followingCountStr", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface j extends vh7.c<j> {
    public static final a Companion = null;
    public static final int FOLLOW_BACK = 3;
    public static final int FOLLOW_EACH_OTHER = 2;
    public static final int HAS_FOLLOWED = 1;
    public static final int NOT_FOLLOWING = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f530970a = null;

        public a() {
        }

        static {
            f530970a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f530970a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "follow_status")
    long getFollowStatus();

    /* synthetic */ long getFollowStatusKmp();

    @FieldName(name = "follower_count")
    long getFollowerCount();

    @FieldName(name = "follower_count_str")
    String getFollowerCountStr();

    @FieldName(name = "following_count")
    long getFollowingCount();

    @FieldName(name = "following_count_str")
    String getFollowingCountStr();

    @FieldName(name = "invalid_follow_status")
    boolean getInvalidFollowStatus();

    @FieldName(name = "push_status")
    long getPushStatus();

    @FieldName(name = "remark_name")
    String getRemarkName();

    /* synthetic */ boolean isFollowing();

    @FieldName(name = "follower_count_str#setter")
    void setFollowerCountStr(String r100);

    @FieldName(name = "following_count_str#setter")
    void setFollowingCountStr(String r100);

    @FieldName(name = "invalid_follow_status#setter")
    void setInvalidFollowStatus(boolean r100);

    @FieldName(name = "push_status#setter")
    void setPushStatus(long r100);

    @FieldName(name = "remark_name#setter")
    void setRemarkName(String r100);
}
