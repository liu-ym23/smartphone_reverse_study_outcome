package dn2;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes11.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f469316a;

    @SerializedName("room")
    public Room room;

    @SerializedName("type")
    public long type;

    @SerializedName("user")
    public User user;

    public static class a {

        @SerializedName("authentication_info")
        public String authInfo;

        @SerializedName("text_after_action")
        public String buttonAfterText;

        @SerializedName("text_before_action")
        public String buttonBeforeText;

        @SerializedName("edit_script")
        public String editScript;

        public final String toString() {
            return "ReCommendConfig{buttonBeforeText='" + this.buttonBeforeText + "', buttonAfterText='" + this.buttonAfterText + "', authInfo='" + this.authInfo + "', editScript='" + this.editScript + "'}";
        }

        public a(String r100, String r101, String r102, String r103) {
            this.buttonBeforeText = r100;
            this.buttonAfterText = r101;
            this.authInfo = r102;
            this.editScript = r103;
        }
    }

    public h() {
    }

    public final String toString() {
        return "RecommendItemBean{type=" + this.type + ", room=" + this.room + ", user=" + this.user + ", reCommendConfig=" + this.f469316a + '}';
    }
}
