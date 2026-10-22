package com.bytedance.ee.lark.infra.foundation.utils;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;

/* JADX INFO: loaded from: classes19.dex */
@AppConfig(key = "filesystem_new_crypto_config")
public class FileEncryptSettings {

    @SerializedName("api_share_intercept")
    public boolean apiShareIntercept;

    @SerializedName("manual_api_decrypt")
    public boolean manualApiDecrypt;

    @SerializedName("old_system_api_decrypt")
    public boolean oldSystemApiDecrypt;

    @SerializedName("open_document_more_action_intercept")
    public boolean openDocumentMoreActionIntercept;

    @SerializedName("save_image_album_intercept")
    public boolean saveImageAlbumIntercept;

    @SerializedName("save_video_album_intercept")
    public boolean saveVideoAlbumIntercept;

    @SerializedName("ttfile_encrypt_enable")
    public boolean ttFileEncryptEnable;

    @SerializedName("web_touch_callout_intercept")
    public boolean webTouchCalloutIntercept;

    public FileEncryptSettings() {
        this.webTouchCalloutIntercept = true;
        this.apiShareIntercept = true;
        this.saveImageAlbumIntercept = true;
        this.saveVideoAlbumIntercept = true;
        this.openDocumentMoreActionIntercept = true;
    }
}
