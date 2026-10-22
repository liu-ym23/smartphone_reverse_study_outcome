package com.dtf.face.config;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONField;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class Upload {

    @JSONField(name = "accessKeyId")
    public String accessKeyId;

    @JSONField(name = "accessKeySecret")
    public String accessKeySecret;

    @JSONField(name = "bucket")
    public String bucket;

    @JSONField(name = "captureConfig")
    public JSONArray captureConfig;

    @JSONField(name = "chameleonFileNamePrefix")
    public String chameleonFileNamePrefix;

    @JSONField(name = "chameleonFrameEnable")
    public boolean chameleonFrameEnable;

    @JSONField(name = "chameleonUploadCompressRate")
    public float chameleonUploadCompressRate;

    @JSONField(name = "collectFileNamePrefix")
    public String collectFileNamePrefix;

    @JSONField(name = "collection")
    public List<String> collection;

    @JSONField(name = "desiredWidth")
    public int desiredWidth;

    @JSONField(name = "enableSmoothTransition")
    public boolean enableSmoothTransition;

    @JSONField(name = "encryptionDegrade")
    public boolean encryptionDegrade;

    @JSONField(name = "endpoint")
    public String endpoint;

    @JSONField(name = "isMirror")
    public Boolean isMirror;

    @JSONField(name = "photinusPicture")
    public boolean photinusPicture;

    @JSONField(name = "photinusType")
    public int photinusType;

    @JSONField(name = "photinusVideo")
    public boolean photinusVideo;

    @JSONField(name = MapBundleKey.OfflineMapKey.OFFLINE_RATION)
    public float ratio;

    @JSONField(name = "securityToken")
    public String securityToken;

    @JSONField(name = "uploadImageType")
    public String uploadImageType;

    @JSONField(name = "upload_compress_rate")
    public float upload_compress_rate;

    public Upload() {
        this.photinusPicture = true;
        this.enableSmoothTransition = true;
        this.encryptionDegrade = false;
        this.chameleonFrameEnable = false;
    }
}
