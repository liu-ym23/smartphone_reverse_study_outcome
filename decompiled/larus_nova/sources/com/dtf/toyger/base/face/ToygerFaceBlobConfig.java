package com.dtf.toyger.base.face;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.dtf.face.config.Upload;
import com.dtf.toyger.base.algorithm.ToygerBlobConfig;
import com.ss.android.lark.image.entity.LoadParams;
import faceverify.w;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class ToygerFaceBlobConfig extends ToygerBlobConfig {

    @JSONField(name = "collection")
    public List<String> collection;

    @JSONField(name = "desiredWidth")
    public int desiredWidth;

    @JSONField(name = "uploadImageType")
    public String uploadImageType;

    @JSONField(name = "upload_compress_rate")
    public float upload_compress_rate;

    @Override // com.dtf.toyger.base.algorithm.ToygerBlobConfig
    public Integer getDesiredWidth() {
        return Integer.valueOf(this.desiredWidth);
    }

    public ToygerFaceBlobConfig() {
        this.upload_compress_rate = 0.7f;
        this.desiredWidth = 480;
        ArrayList r100 = new ArrayList();
        this.collection = r100;
        r100.add(w.SUB_TYPE_PANO);
        this.uploadImageType = LoadParams.ImageFormat.JPEG;
    }

    @Override // com.dtf.toyger.base.algorithm.ToygerBlobConfig
    public float getCompressRate() {
        return this.upload_compress_rate;
    }

    private static ToygerFaceBlobConfig from(Upload r100) {
        ToygerFaceBlobConfig r101 = new ToygerFaceBlobConfig();
        r101.upload_compress_rate = r100.upload_compress_rate;
        r101.collection = r100.collection;
        r101.desiredWidth = r100.desiredWidth;
        r101.uploadImageType = r100.uploadImageType;
        return r101;
    }

    public int getMinWidth(int r100) {
        int r101 = this.desiredWidth;
        if (r101 <= r100) goto L5;
        return r100;
    L5:
        return r101;
    }

    public static ToygerFaceBlobConfig from(Object r100, String r101) {
        if (r100 == null) goto L20;
        if (r101 == null) goto L20;
        if ((r100 instanceof String) == false) goto L8;
        ToygerFaceBlobConfig r102 = (ToygerFaceBlobConfig) JSON.parseObject((String) r100, ToygerFaceBlobConfig.class);
    L10:
        if (r102.desiredWidth > 0) goto L13;
        r102.desiredWidth = 1280;
    L13:
        if (r102.collection != null) goto L15;
        r102.collection = new ArrayList();
    L15:
        r102.pubkey = r101;
        if (r102.uploadImageType != null) goto L18;
        r102.uploadImageType = LoadParams.ImageFormat.JPEG;
    L18:
        return r102;
    L8:
        r102 = from((Upload) r100);
    L20:
        return new ToygerFaceBlobConfig();
    }

    public ToygerFaceBlobConfig(float r100, int r101, String r102, String r103) {
        this.upload_compress_rate = r100;
        this.desiredWidth = r101;
        this.pubkey = r102;
        this.uploadImageType = r103;
    }
}
