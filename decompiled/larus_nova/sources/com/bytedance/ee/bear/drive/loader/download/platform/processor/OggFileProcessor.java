package com.bytedance.ee.bear.drive.loader.download.platform.processor;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.drive.loader.download.platform.ProcessorContext;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IPreviewGetModel;
import java.util.Objects;

/* JADX INFO: loaded from: classes16.dex */
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

    public OggFileProcessor(ProcessorContext r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.processor.AbsServerTransformProcessor
    public boolean checkReadyResult(IPreviewGetModel r100) {
        w75.c r101 = getProcessorContext().getFileModel();
        String r102 = r100.getPreviewUrl();
        Objects.requireNonNull(r102);
        r101.c(r102);
        Extra r103 = (Extra) JSON.parseObject(r100.getExtra(), Extra.class);
        if (r103 != null) goto L5;
    L7:
        tt5.a.d("DrivePlatform_Processor", "ogg file mimeType is empty! extra = " + r103);
    L9:
        if ("6".equals(getProcessorContext().getResourceHolder().getDownloadStrategy().getPreviewFileSourceType()) == false) goto L11;
        return false;
    L11:
        if (r103 != null) goto L13;
        return false;
    L13:
        if ("video/ogg".equalsIgnoreCase(r103.mineType) == false) goto L17;
        return true;
    L17:
        return false;
    L5:
        if (TextUtils.isEmpty(r103.mineType) == true) goto L7;
        getProcessorContext().getFileModel().q(r103.mineType);
        goto L9
    }
}
