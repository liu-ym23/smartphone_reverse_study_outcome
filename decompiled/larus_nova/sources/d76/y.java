package d76;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public class y {

    @SerializedName("landscape")
    public a landscape;

    @SerializedName("portrait")
    public a portrait;

    public static class a {

        @SerializedName("h")
        public int actualHeight;

        @SerializedName("w")
        public int actualWidth;

        @SerializedName("align")
        public int align;

        @SerializedName("aFrame")
        public int[] alphaFrame;

        @SerializedName("masks")
        public Map<String, Map<String, DataSource.Element>> masks;

        @SerializedName("path")
        public String path;

        @SerializedName("rgbFrame")
        public int[] rgbFrame;

        @SerializedName("f")
        public int totalFrame;

        @SerializedName(BaseSwitches.V)
        public int version;

        @SerializedName("videoH")
        public int videoHeight;

        @SerializedName("videoW")
        public int videoWidth;

        public a() {
        }
    }

    public y() {
    }
}
