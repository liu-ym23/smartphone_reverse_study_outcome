package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;

/* JADX INFO: loaded from: classes22.dex */
public class MicroAppObject implements IMediaObject {
    private static final String APP_ID = "micro_app_object_app_id";
    private static final String IMAGE_ID = "micro_app_object_image_id";
    private static final String PATH = "micro_app_object_only_path";
    private static final String QUERY = "micro_app_object_query";
    private static final String THIRD_APP_SCHEMA = "micro_app_object_third_app_schema";
    private static final String TITLE = "micro_app_object_title";
    public String appId;
    public String imageId;
    public String path;
    public String query;
    public String thirdAppSchema;
    public String title;

    public MicroAppObject() {
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public boolean checkArgs() {
        return true;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public void serialize(Bundle r100) {
        r100.putString(APP_ID, this.appId);
        r100.putString(TITLE, this.title);
        r100.putString(PATH, this.path);
        r100.putString(QUERY, this.query);
        r100.putString(IMAGE_ID, this.imageId);
        r100.putString(THIRD_APP_SCHEMA, this.thirdAppSchema);
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public int type() {
        return 9;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public void unserialize(Bundle r100) {
        this.appId = r100.getString(APP_ID);
        this.title = r100.getString(TITLE);
        this.path = r100.getString(PATH);
        this.query = r100.getString(QUERY);
        this.imageId = r100.getString(IMAGE_ID);
        this.thirdAppSchema = r100.getString(THIRD_APP_SCHEMA);
    }
}
