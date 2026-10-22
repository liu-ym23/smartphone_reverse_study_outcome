package faceverify;

import com.dtf.toyger.base.ToygerBiometricInfo;
import com.dtf.toyger.base.algorithm.TGFrame;
import com.dtf.toyger.base.algorithm.ToygerBlobConfig;
import com.dtf.toyger.base.face.ToygerDepthInfo;
import com.dtf.toyger.base.face.ToygerFaceAttr;
import com.dtf.toyger.base.face.ToygerFaceInfo;
import com.ss.android.lark.image.entity.LoadParams;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public abstract class w<Info extends ToygerBiometricInfo> {
    public static final String BLOB_ELEM_IMAGE_HASHCODE = "hash";
    public static final String BLOB_ELEM_IMAGE_RUNTIMEINFO = "runtimeInfo";
    public static final String BLOB_ELEM_IMAGE_TYPE = "ImageType";
    public static final String BLOB_ELEM_SUBTYPE_GYRO = "gyro";
    public static final String BLOB_ELEM_TYPE_DOC = "doc";
    public static final String BLOB_ELEM_TYPE_FACE = "face";
    public static final String BLOB_ELEM_TYPE_SENSOR = "sensor";
    public static final String BLOB_VERSION = "1.0";
    public static final int META_ALGRESULT_BAT = 3;
    public static final int META_ALGRESULT_DRAGONFLY = 2;
    public static final int META_ALGRESULT_VERIFY = 1;
    public static final String META_COLL_KEY_AUTH_INFO = "authInfo";
    public static final String META_COLL_KEY_IMAGE_SIG = "imageSig";
    public static final int META_SERIALIZER_JSON = 1;
    public static final int META_SERIALIZER_PB = 2;
    public static final String META_TYPE_DOC = "zdoc";
    public static final String META_TYPE_FACE = "zface";
    public static final String SUB_TYPE_DARK = "Dark";
    public static final String SUB_TYPE_DEPTH = "Depth";
    public static final String SUB_TYPE_DOC_IMAGE = "docimage";
    public static final String SUB_TYPE_IR = "SLIR";
    public static final String SUB_TYPE_NANO = "Nano";
    public static final String SUB_TYPE_PANO = "Pano";
    public static final String SUB_TYPE_SURVEILLANCE = "Surveillance";
    public static final String SUB_TYPE_VERSION = "1.0";
    public static final String TAG = "TOYGER_FLOW_BlobManager";
    public ToygerBlobConfig config;
    public y crypto;

    static {
        ytc.a.b();
    }

    public abstract byte[] generateBlob(List<Info> r100, Map<String, Object> r101);

    public abstract byte[] getKey();

    public abstract boolean isUTF8();

    public native byte[] processDepthInfo(ToygerDepthInfo r100);

    public native byte[] processFrame(ToygerFaceInfo r100, ToygerFaceAttr r101, int r102, int r103, String r104, boolean r105, Map<String, Object> r106);

    public native byte[] processFrame(ToygerFaceInfo r100, ToygerFaceAttr r101, String r102, boolean r103, Map<String, Object> r104);

    public native byte[] processFrame(byte[] r100);

    public native byte[] processSensorData(String r100);

    public w() {
    }

    public byte[] processIRFrameInfo(TGFrame r100, boolean r101) {
        int r102 = this.config.getDesiredWidth().intValue();
        int r103 = (int) (this.config.getCompressRate() * 100.0f);
        if (r100 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L16;
        byte[] r105 = f.a(r100, r102, r103, LoadParams.ImageFormat.JPEG, r101);
        if (r105 == null) goto L16;
        byte[] r106 = this.crypto.a(r105);
        if (r106 == null) goto L16;
        return r106;
    L16:
        return null;
    L5:
        if (r100.data == null) goto L8;
        r104 = false;
        goto L9
    }
}
