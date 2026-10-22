package faceverify;

import android.content.Context;
import android.graphics.PointF;
import com.dtf.toyger.base.ToygerAttr;
import com.dtf.toyger.base.ToygerBiometricInfo;
import com.dtf.toyger.base.algorithm.IToygerDelegate;
import com.dtf.toyger.base.algorithm.TGDepthFrame;
import com.dtf.toyger.base.algorithm.TGFrame;
import com.dtf.toyger.base.face.ToygerFaceAlgorithmConfig;
import faceverify.p;
import faceverify.r;
import faceverify.s;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public abstract class q<C extends r, State extends s, Attr extends ToygerAttr, Info extends ToygerBiometricInfo, AlgorithmConfig extends p> implements IToygerDelegate<State, Attr, Info> {
    public static final String ASSET_DOC = "toyger.doc.dat";
    public static final String ASSET_FACE = "toyger.face.dat";
    public static final String ASSET_FACE_HIGH = "toyger.face.high.dat";
    public static final String ASSET_LICENSE = "toyger.license";
    public static final String ASSET_MOUTH = "toyger.mouth.dat";
    public static final String ASSET_QUALITY = "toyger.quality.dat";
    public static final String KEY_ALGORITHM_CONFIG = "algorithm";
    public static final String KEY_ASYNC_BLOB = "AsyncBlob";
    public static final String KEY_CAMERA_CONFIG = "camera_config";
    public static final String KEY_COLLECT_SIG = "collectInfoSig";
    public static final String KEY_COMPLETE_BLOB = "CompleteBlob";
    public static final String KEY_CONTENT_ATTR = "elementContentAttr";
    public static final String KEY_CONTENT_BITMAP = "elementContentBitmap";
    public static final String KEY_CONTENT_FACE_ATTR = "elementFaceAttr";
    public static final String KEY_CONTENT_MD5 = "elementContentMd5";
    public static final String KEY_CONTENT_SIG = "contentSig";
    public static final String KEY_DOC_FRAME_RECT = "docFrameRect";
    public static final String KEY_ELEMENT_CONTENT = "elementContent";
    public static final String KEY_ENABLE_ENCUP = "enableEncUp";
    public static final String KEY_ENABLE_VIDEO_CAPTURE_CONFIG = "enableVideoCapture";
    public static final String KEY_FACE_AREA = "faceArea";
    public static final String KEY_IFFA_MSG = "IFFAMsg";
    public static final String KEY_IS_MIRROR = "is_mirror";
    public static final String KEY_LOCAL_MATCHING_COMMAND = "LocalMatchingCommand";
    public static final String KEY_META_SERIALIZER = "meta_serializer";
    public static final String KEY_NINE_SHOT_BLOB = "NineShootBlob";
    public static final String KEY_PHOTINUS_CONFIG = "photinus";
    public static final String KEY_PREVIEW_TRACE = "previewTrace";
    public static final String KEY_PUBLIC_KEY = "pubkey";
    public static final String KEY_RES_9_CONTENT = "content";
    public static final String KEY_RES_9_IS_UTF8 = "isUTF8";
    public static final String KEY_RES_9_KEY = "key";
    public static final String KEY_ROTATE_TIMES = "rotateTimes";
    public static final String KEY_TOKEN = "TOKEN";
    public static final String KEY_UPLOAD_CONFIG = "upload";
    public static final String KEY_USER_ID = "USER_ID";
    public static final String P_TAG_ANDROID = "TOYGER_FLOW_ANDROID";
    public static final String P_TAG_NATIVE = "TOYGER_FLOW_NATIVE";
    public static final String TAG = "TOYGER_FLOW_ANDROID";
    public static final String TAG_NATIVE = "TOYGER_FLOW_NATIVE";
    public C mToygerCallback;

    public static boolean preLoad(Context r100) {
        return false;
    }

    public abstract boolean config(Map<String, Object> r100);

    @Override // com.dtf.toyger.base.algorithm.IToygerDelegate
    public abstract void handleCaptureCompleted(int r100, List<Info> r101, Map<String, Object> r102);

    @Override // com.dtf.toyger.base.algorithm.IToygerDelegate
    public abstract void handleInfoReady(TGFrame r100, Attr r101);

    @Override // com.dtf.toyger.base.algorithm.IToygerDelegate
    public abstract void handleLog(int r100, HashMap<String, Object> r101);

    @Override // com.dtf.toyger.base.algorithm.IToygerDelegate
    public abstract void handleScanCompleted(int r100, List<Info> r101, Map<String, Object> r102);

    @Override // com.dtf.toyger.base.algorithm.IToygerDelegate
    public abstract void handleStateUpdated(State r100, Attr r101);

    public abstract boolean init(Context r100, C r101, String r102, String r103, Map<String, Object> r104);

    public abstract boolean init(Context r100, boolean r101, C r102);

    public abstract boolean processImage(List<TGFrame> r100, TGDepthFrame r101);

    public abstract void release();

    public abstract void reset();

    public abstract void updateNativeState(int r100, String r101);

    public q() {
    }

    @Override // com.dtf.toyger.base.algorithm.IToygerDelegate
    public PointF handleAlignDepthPoint(PointF r100) {
        return this.mToygerCallback.onAlignDepthPoint(r100);
    }

    @Override // com.dtf.toyger.base.algorithm.IToygerDelegate
    public void handleEventTriggered(int r100, String r101) {
        if (r100 != (-16)) goto L5;
    L9:
        HashMap r102 = new HashMap();
        if (r101 == null) goto L12;
        r102.put(ToygerFaceAlgorithmConfig.DRAGONFLY_LIVENESS, r101);
    L13:
        this.mToygerCallback.onEvent(r100, r102);
        return;
    L12:
        r102.put(ToygerFaceAlgorithmConfig.DRAGONFLY_LIVENESS, "-1");
        goto L13
    L5:
        if (r100 == (-15)) goto L9;
        switch(r100) {
            case -48: goto L8;
            case -47: goto L8;
            case -46: goto L8;
            case -45: goto L8;
            case -44: goto L8;
            default: goto L7;
        };
    L7:
        r102 = null;
        goto L13
    L8:
        r102 = new HashMap();
        r102.put("message", r101);
        goto L13
    }
}
