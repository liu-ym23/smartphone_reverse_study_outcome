package w20;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b#\u0010$R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lw20/j8;", "", "", "enter_from_merge", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setEnter_from_merge", "(Ljava/lang/String;)V", "enter_method", "c", "setEnter_method", "user_id", "f", "setUser_id", "sec_user_id", "getSec_user_id", "setSec_user_id", "room_id", "e", "setRoom_id", "", "follow_status", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "setFollow_status", "(Ljava/lang/Integer;)V", "Lw20/j8$a;", "args", "Lw20/j8$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lw20/j8$a;", "setArgs", "(Lw20/j8$a;)V", "<init>", "()V", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j8 {

    @SerializedName("args")
    private a args;

    @SerializedName("enter_from_merge")
    private String enter_from_merge;

    @SerializedName("enter_method")
    private String enter_method;

    @SerializedName("follow_status")
    private Integer follow_status;

    @SerializedName("room_id")
    private String room_id;

    @SerializedName("sec_user_id")
    private String sec_user_id;

    @SerializedName("user_id")
    private String user_id;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lw20/j8$a;", "", "", "episode_extra", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setEpisode_extra", "(Ljava/lang/String;)V", "", "is_vr_camera", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "set_vr_camera", "(Ljava/lang/Boolean;)V", "<init>", "()V", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("episode_extra")
        private String episode_extra;

        @SerializedName("is_vr_camera")
        private Boolean is_vr_camera;

        public a() {
        }

        public final String a() {
            return this.episode_extra;
        }
    }

    public j8() {
    }

    public final a a() {
        return this.args;
    }

    public final String b() {
        return this.enter_from_merge;
    }

    public final String c() {
        return this.enter_method;
    }

    public final Integer d() {
        return this.follow_status;
    }

    public final String e() {
        return this.room_id;
    }

    public final String f() {
        return this.user_id;
    }
}
