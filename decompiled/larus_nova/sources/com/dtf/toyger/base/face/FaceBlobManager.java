package com.dtf.toyger.base.face;

import android.graphics.Rect;
import android.graphics.RectF;
import com.dtf.face.log.RecordService;
import com.dtf.toyger.base.algorithm.TGFrame;
import faceverify.w;
import faceverify.y;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public abstract class FaceBlobManager extends w<ToygerFaceInfo> {
    public static final int MONITOR_COMPRESS_RATE = 30;
    public static final int MONITOR_IMAGE_WIDTH = 160;
    public byte[] bestDepthImage;
    public byte[] bestIRImage;
    public byte[] bestLightImage;
    public String compressFormat;
    public float compressRate;
    public ToygerDepthInfo depthInfo;
    public int desireWidth;
    public TGFrame irFrame;
    public boolean isMirror;
    public boolean isNano;

    public abstract void addMonitorImage(TGFrame r100);

    public abstract Map<String, Object> generateBlob(Map<String, Object> r100);

    @Override // faceverify.w
    public abstract byte[] generateBlob(List<ToygerFaceInfo> r100, Map<String, Object> r101);

    public abstract byte[] generateFaceBlob(TGFrame r100, ToygerFaceAttr r101);

    public abstract byte[] generateLocalMatchingBlob(String r100, byte[] r101, byte[] r102, String r103);

    public abstract byte[] getFileIdBlob(String r100);

    public abstract byte[] getMonitorBlob();

    @Override // faceverify.w
    public abstract boolean isUTF8();

    @Override // faceverify.w
    public byte[] getKey() {
        return this.crypto.f476187b;
    }

    public FaceBlobManager() {
    }

    public String getBlobElemType(ToygerFaceInfo r100) {
        if (r100.frame.frameType == 0) goto L7;
        RecordService.getInstance().recordEvent(4, "ToygerFrameTypeError", new String[]{"errMsg", String.valueOf(r100.frame.frameType)});
        return w.SUB_TYPE_PANO;
    L7:
        return w.SUB_TYPE_PANO;
    }

    public FaceBlobManager(ToygerFaceBlobConfig r100, boolean r101) {
        this.config = r100;
        this.desireWidth = r100.desiredWidth;
        this.crypto = new y(r100.pubkey, r101);
    }

    public static Rect convertFaceRegion(RectF r100, int r101, int r102, int r103, boolean r104) {
        if (r104 == false) goto L5;
        float r105 = r101;
        float r106 = r102;
        return new Rect((int) ((1.0f - r100.right) * r105), (int) (r100.top * r106), (int) ((1.0f - r100.left) * r105), (int) (r100.bottom * r106));
    L5:
        float r107 = r101;
        float r108 = r102;
        return new Rect((int) (r100.left * r107), (int) (r100.top * r108), (int) (r100.right * r107), (int) (r100.bottom * r108));
    }
}
