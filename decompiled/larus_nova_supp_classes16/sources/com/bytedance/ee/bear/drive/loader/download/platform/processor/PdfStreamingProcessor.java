package com.bytedance.ee.bear.drive.loader.download.platform.processor;

import android.webkit.URLUtil;
import com.bytedance.ee.bear.drive.loader.download.platform.ProcessorContext;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IPreviewGetModel;
import w55.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PdfStreamingProcessor extends AbsServerTransformProcessor {
    private static final long STREAMING_THRESHOLD = 10485760;

    public PdfStreamingProcessor(ProcessorContext r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.processor.AbsServerTransformProcessor
    public boolean checkReadyResult(IPreviewGetModel r11) {
        String r0 = r11.getPreviewUrl();
        boolean r3 = false;
        boolean r1 = com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.drive.pdf_linearized_enable", false);
        boolean r2 = r11.getLinearized();
        boolean r4 = URLUtil.isNetworkUrl(r0);
        boolean r5 = getProcessorContext().getResourceHolder().getDownloadStrategy().enableStreaming();
        boolean r6 = n.j(o75.b.a().getDriveConfig());
        boolean r7 = getProcessorContext().getFileModel().i();
        tt5.a.h("DrivePlatform_Processor", "PdfStreamingProcessor checkReadyResult fgEnable=" + r1 + " linearized=" + r2 + " isNetworkUrl=" + r4 + " pluginEnable=" + r6 + " isVCFollowMode=" + r7 + " strategyEnable=" + r5);
        if (r1 == false) goto L10;
        if (r5 == false) goto L10;
        if (r2 == false) goto L10;
        if (r4 == false) goto L10;
        if (r6 == false) goto L10;
        if (r7 == true) goto L10;
        r3 = true;
    L10:
        if (r3 == false) goto L15;
        getProcessorContext().getFileModel().j();
        getProcessorContext().getFileModel().c(r0);
        getProcessorContext().getFileModel().f(r11.getPreviewFileSize());
        w75.c r8 = getProcessorContext().getFileModel();
        String r12 = r11.getExtra();
        if (r12 != null) goto L14;
        r12 = "";
    L14:
        r8.o(r12);
    L15:
        return r3;
    }
}
