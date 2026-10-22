package com.bytedance.ee.bear.drive.loader.download.platform.processor;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.drive.loader.download.platform.ProcessorContext;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IPreviewGetModel;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OggFileProcessor extends AbsServerTransformProcessor {

    public static class Extra {

        @JSONField(name = "mime_type")
        public String mineType;

        private Extra() {
        }

        public String toString() {
            return "Extra{mineType='" + this.mineType + "'}";
        }
    }

    public OggFileProcessor(ProcessorContext r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.processor.AbsServerTransformProcessor
    public boolean checkReadyResult(IPreviewGetModel r4) {
        w75.c r0 = getProcessorContext().getFileModel();
        String r1 = r4.getPreviewUrl();
        Objects.requireNonNull(r1);
        r0.c(r1);
        Extra r5 = (Extra) JSON.parseObject(r4.getExtra(), Extra.class);
        if (r5 != null) goto L5;
    L7:
        tt5.a.d("DrivePlatform_Processor", "ogg file mimeType is empty! extra = " + r5);
    L9:
        if ("6".equals(getProcessorContext().getResourceHolder().getDownloadStrategy().getPreviewFileSourceType()) == false) goto L11;
        return false;
    L11:
        if (r5 != null) goto L13;
        return false;
    L13:
        if ("video/ogg".equalsIgnoreCase(r5.mineType) == false) goto L17;
        return true;
    L17:
        return false;
    L5:
        if (TextUtils.isEmpty(r5.mineType) == true) goto L7;
        getProcessorContext().getFileModel().q(r5.mineType);
        goto L9
    }
}
