package ld0;

import com.bytedance.android.livesdk.chatroom.model.v1;
import com.google.gson.annotations.SerializedName;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public class a implements v1 {

    @SerializedName("camera_open")
    public int cameraOpen;

    @SerializedName("link_id")
    public String linkId;

    @SerializedName("mode")
    private int mode;

    @SerializedName("sing_mode")
    private int singMode;

    @SerializedName("song_type")
    public int songType;

    @SerializedName("timestamp")
    public long timestamp;

    public a() {
    }

    public final boolean b() {
        if (this.singMode == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final String toString() {
        return "VideoStateSei{linkId='" + this.linkId + "', singMode=" + this.singMode + ", mode=" + this.mode + ", cameraOpen=" + this.cameraOpen + ", timestamp=" + this.timestamp + '}';
    }

    public static a a(String r100, String r101, JSONObject r102) throws JSONException {
        a r103 = new a();
        new JSONObject();
        JSONObject r104 = r102.optJSONObject(r101);
        r103.linkId = r104.optString("link_id");
        r103.timestamp = r104.optLong("timestamp");
        r103.singMode = r104.optInt("sing_mode");
        r103.mode = r104.optInt("mode");
        r103.songType = r104.optInt("song_type");
        if ((r104.get("camera_open") instanceof Boolean) == false) goto L5;
        r103.cameraOpen = r104.optBoolean("camera_open") ? 1 : 0;
    L6:
        return r103;
    L5:
        r103.cameraOpen = r104.optInt("camera_open");
        goto L6
    }
}
