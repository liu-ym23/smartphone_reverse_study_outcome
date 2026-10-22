package i02;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class g {

    @SerializedName("landscape")
    public b landscape;

    @SerializedName("portrait")
    public b portrait;

    public static class a {

        @SerializedName("close")
        public String closeUrl;

        @SerializedName("height")
        public int height;

        @SerializedName("open")
        public String openUrl;

        @SerializedName("width")
        public int width;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        @SerializedName("x")
        public int f487871x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        @SerializedName("y")
        public int f487872y;

        public a() {
        }
    }

    public static class b {

        @SerializedName("h")
        public int actualHeight;

        @SerializedName("w")
        public int actualWidth;

        @SerializedName("align")
        public int align;

        @SerializedName("aFrame")
        public int[] alphaFrame;

        @SerializedName("background")
        public HashMap<String, b> backgroundItemMap;

        @SerializedName("foreground")
        public HashMap<String, b> foregroundItemMap;

        @SerializedName("icons")
        public a icons;

        @SerializedName("has_audio")
        public int isAudio;

        @SerializedName(GXTemplateKey.GAIAX_LAYERS)
        private List<c> layersModel;

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

        @SerializedName("vibrate_path")
        public String vibratePath;

        @SerializedName("videoH")
        public int videoHeight;

        @SerializedName("videoW")
        public int videoWidth;

        public final List<DataSource.Layer> a() {
            if (this.layersModel != null) goto L5;
            return null;
        L5:
            ArrayList r100 = new ArrayList();
            Iterator<c> r101 = this.layersModel.iterator();
        L7:
            if (r101.hasNext() == false) goto L41;
            c r102 = r101.next();
            r102.getClass();
            DataSource.Layer r103 = new DataSource.Layer();
            r103.f451147a = r102.name;
            int r104 = r102.type;
            r103.f451148b = r104;
            if (r104 == 0) goto L14;
            if (r104 == 1) goto L14;
            if (r104 != 2) goto L15;
            r103.f451150d = new DataSource.Area(r102.alphaArea);
            r103.f451149c = new DataSource.Area(r102.rgbArea);
        L15:
            d r105 = r102.maskContainer;
            if (r105 == null) goto L40;
            if (r105.alphaArea != null) goto L20;
        L38:
            DataSource.MaskContainer r106 = null;
        L39:
            r103.f451152f = r106;
            goto L40
        L20:
            if (r105.rgbArea == null) goto L38;
            r106 = new DataSource.MaskContainer();
            new DataSource.Area(r105.alphaArea);
            new DataSource.Area(r105.rgbArea);
            int[] r107 = r105.contentPadding;
            if (r107 != null) goto L25;
        L28:
            int[] r108 = r105.flexPadding;
            if (r108 == null) goto L37;
            int[] r110 = r105.anchorPoint;
            if (r110 == null) goto L37;
            if (r108.length != 4) goto L36;
            int r111 = r108[1];
            int r109 = r108[3];
            int r112 = r108[0];
            int r113 = r108[2];
        L36:
            int r114 = r110[0];
            int r115 = r110[1];
        L37:
            r106.f451153a = r105.fallbackLayer;
            goto L39
        L25:
            if (r107.length != 4) goto L28;
            int r116 = r107[1];
            int r117 = r107[3];
            int r118 = r107[0];
            int r119 = r107[2];
        L40:
            r100.add(r103);
        L14:
            r103.f451151e = r102.enableTap;
            goto L15
        L41:
            return r100;
        }

        public b() {
            this.foregroundItemMap = new HashMap();
            this.backgroundItemMap = new HashMap();
        }
    }

    public static class c {

        @SerializedName("alphaFrame")
        public int[] alphaArea;

        @SerializedName("enableTap")
        public boolean enableTap;

        @SerializedName("maskContainer")
        public d maskContainer;

        @SerializedName("name")
        public String name;

        @SerializedName("originSize")
        public int[] originSize;

        @SerializedName("rgbFrame")
        public int[] rgbArea;

        @SerializedName("type")
        public int type;

        public c() {
        }
    }

    public static class d {

        @SerializedName("alignType")
        public int alignType;

        @SerializedName("alphaFrame")
        public int[] alphaArea;

        @SerializedName("anchorPoint")
        public int[] anchorPoint;

        @SerializedName("type")
        public int containerType;

        @SerializedName("contentPadding")
        public int[] contentPadding;

        @SerializedName("disableFlexX")
        public boolean disableFlexX;

        @SerializedName("disableFlexY")
        public boolean disableFlexY;

        @SerializedName("fallbackLayer")
        public String fallbackLayer;

        @SerializedName("flexPadding")
        public int[] flexPadding;

        @SerializedName("rgbFrame")
        public int[] rgbArea;

        public d() {
            this.disableFlexX = false;
            this.disableFlexY = false;
        }
    }

    public g() {
    }
}
