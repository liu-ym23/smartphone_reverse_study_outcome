package com.bytedance.ee.bear.drive.loader.download.platform;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.AbsProcessor;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.IProcessor;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.NotSupportProcessor;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.SimilarFileProcessor;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.SourceFilePreviewProcessor;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.SourceFileProcessor;
import g85.d;
import g85.g;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import w75.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
class ProcessorCreator {
    private static final String TAG = "DrivePlatform_ProcessorCreator";
    private IResourceHolder mResourceHolder;
    private a95.a mUserAbility;

    public IProcessor createNotSupportProcessor(ProcessorCreateParams r8) {
        return new NotSupportProcessor(new ProcessorContext(r8.fileModel, r8.callback, this.mResourceHolder, this.mUserAbility, r8.downloadOptions));
    }

    public IProcessor createSimilarFileProcessor(ProcessorCreateParams r8) {
        return new SimilarFileProcessor(new ProcessorContext(r8.fileModel, r8.callback, this.mResourceHolder, this.mUserAbility, r8.downloadOptions));
    }

    public IProcessor createSourceFileProcessor(ProcessorCreateParams r8) {
        return new SourceFileProcessor(new ProcessorContext(r8.fileModel, r8.callback, this.mResourceHolder, this.mUserAbility, r8.downloadOptions));
    }

    public ProcessorCreator(IResourceHolder r1, a95.a r2) {
        this.mResourceHolder = r1;
        this.mUserAbility = r2;
    }

    private IProcessor createProcessor(int r6, ProcessorContext r7) {
        Class<? extends AbsProcessor> r0 = d.a.get(r6, NotSupportProcessor.class);
        if (r0 != null) goto L11;
        return null;
    L11:
        Constructor<? extends AbsProcessor> r1 = r0.getDeclaredConstructor(new Class[]{ProcessorContext.class});     // Catch: Exception -> L7
        r1.setAccessible(true);     // Catch: Exception -> L7
        return r1.newInstance(new Object[]{r7});
    L7:
        e = move-exception;
        tt5.a.d(TAG, "createProcessor failed, type: " + r6 + ", exp: " + e);
        return null;
    }

    public List<IProcessor> create(ProcessorCreateParams r14, IProcessor r16) {
        c r7 = r14.fileModel;
        IDownloader.ICallback r8 = r14.callback;
        List<Integer> r0 = r7.p();
        if (r0 != null) goto L6;
        r0 = new ArrayList(0);
    L6:
        ArrayList r9 = new ArrayList();
        Iterator<Integer> r10 = r0.iterator();
    L8:
        if (r10.hasNext() == false) goto L20;
        int r11 = r10.next().intValue();
        SparseArray<String> r1 = g.a;
        if (r11 != 0) goto L12;
        int r2 = 9;
    L13:
        String r3 = r7.I();
        SparseArray<String> r4 = g.a;
        if (TextUtils.isEmpty(r3) == false) goto L16;
        r3 = "UNKNOWN";
    L16:
        IProcessor r5 = createProcessor(r11, new ProcessorContext(r7, new w75.d.a(r2, r4.get(r11, r3)), r8, this.mResourceHolder, this.mUserAbility, r14.downloadOptions));
        if (r5 == null) goto L8;
        r9.add(r5);
        goto L8
    L12:
        r2 = r11;
        goto L13
    L20:
        if (r9.isEmpty() == false) goto L23;
        if (r16 == null) goto L23;
        r9.add(r16);
    L23:
        return r9;
    }

    public IProcessor createSourceFilePreviewProcessor(c r8, IDownloader.ICallback r9) {
        return new SourceFilePreviewProcessor(new ProcessorContext(r8, r9, this.mResourceHolder, this.mUserAbility, DownloadOptions.defaultOptions()));
    }
}
