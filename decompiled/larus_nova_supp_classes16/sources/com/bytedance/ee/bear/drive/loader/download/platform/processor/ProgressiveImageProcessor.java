package com.bytedance.ee.bear.drive.loader.download.platform.processor;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.drive.loader.download.platform.ProcessorContext;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IPreviewGetModel;
import com.bytedance.ee.util.ui.n;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ProgressiveImageProcessor extends AbsServerTransformProcessor {

    public static final class ImageExtra implements Serializable {
        public int height;
        public int width;

        private ImageExtra() {
        }
    }

    public ProgressiveImageProcessor(ProcessorContext r1) {
        super(r1);
    }

    private boolean canProgressive(IPreviewGetModel r4) {
        if (TextUtils.isEmpty(r4.getPreviewUrl()) == false) goto L5;
    L18:
        return false;
    L5:
        if (TextUtils.isEmpty(r4.getExtra()) == true) goto L18;
        ImageExtra r5 = (ImageExtra) JSON.parseObject(r4.getExtra(), ImageExtra.class);     // Catch: Exception -> L17
        if (isExtraValid(r5) == true) goto L11;
        return false;
    L11:
        if ((r5.width * r5.height) <= ((n.t() * n.v()) * 2)) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == true) goto L22;
        return true;
    L22:
        return false;
    L13:
        r6 = false;
    L17:
        tt5.a.d("DrivePlatform_Processor", "canProgressive, parse ");
        goto L18
    }

    private boolean isExtraValid(ImageExtra r2) {
        if (r2 != null) goto L4;
    L8:
        return false;
    L4:
        if (r2.width <= 0) goto L8;
        if (r2.height <= 0) goto L8;
        return true;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.processor.AbsServerTransformProcessor
    public boolean checkReadyResult(IPreviewGetModel r5) {
        if (r5.getLinearized() == true) goto L5;
        return false;
    L5:
        boolean r0 = canProgressive(r5);
        tt5.a.h("DrivePlatform_Processor", "ProgressiveImageProcessor.handleTransformResult(), can progressive: " + r0);
        if (r0 == false) goto L9;
        getProcessorContext().getFileModel().j();
        getProcessorContext().getFileModel().c(r5.getPreviewUrl());
        return true;
    L9:
        tt5.a.h("DrivePlatform_Processor", "not satisfy progressive processing conditions, download the origin file!!");
        return false;
    }
}
