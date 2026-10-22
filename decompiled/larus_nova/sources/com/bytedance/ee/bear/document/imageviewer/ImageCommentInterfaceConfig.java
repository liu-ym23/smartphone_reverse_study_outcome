package com.bytedance.ee.bear.document.imageviewer;

import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;

/* JADX INFO: loaded from: classes16.dex */
@AppConfig(key = ImageCommentInterfaceConfig.KEY)
public class ImageCommentInterfaceConfig implements NonProguard {
    public static final String KEY = "ccm_image_comment_interface_config";
    public boolean uniform_interface_enable;

    public ImageCommentInterfaceConfig() {
    }

    public static ImageCommentInterfaceConfig getValue() {
        return (ImageCommentInterfaceConfig) c.a.f206237a.c(KEY, ImageCommentInterfaceConfig.class, new ImageCommentInterfaceConfig());
    }
}
