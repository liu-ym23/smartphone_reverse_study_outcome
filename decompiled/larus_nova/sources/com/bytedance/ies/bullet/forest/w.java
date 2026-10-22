package com.bytedance.ies.bullet.forest;

import com.bytedance.forest.postprocessor.ForestPostProcessor;
import com.bytedance.forest.postprocessor.ProcessableData;
import com.bytedance.forest.postprocessor.ProcessedData;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.a2;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class w extends ForestPostProcessor<TemplateBundle> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f246774a;

    @Override // com.bytedance.forest.postprocessor.ForestPostProcessor
    public final ProcessedData<TemplateBundle> onProcess(ProcessableData r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (r100.f244433d == false) goto L20;
        ByteBuffer r101 = (ByteBuffer) r100.f244443n.getValue();
        if (r101 == null) goto L8;
        com.bytedance.forest.utils.i.h("TemplateBundleProcessor", "TemplateBundleProcessor onProcess by DirectBuffer", false, 60);
        int r102 = (r101.capacity() * 3) / 2;
        a2 r103 = new a2(0, false, r100.f244430a);
        ByteBuffer r104 = r101.duplicate();
        r104.position(0);
        byte[] r105 = new byte[r104.remaining()];
        r104.get(r105);
        x.a(r100, r105);
        TemplateBundle r106 = TemplateBundle.a(r101, r103);
        a(r106, r100.f244432c);
        Unit r107 = Unit.INSTANCE;
        return new ProcessedData(r102, r106);
    L8:
        InputStream r108 = (InputStream) r100.f244442m.getValue();
        com.bytedance.forest.utils.i.h("TemplateBundleProcessor", "TemplateBundleProcessor onProcess by ByteArray", false, 60);     // Catch: Throwable -> L12
        byte[] r109 = ByteStreamsKt.readBytes(r108);     // Catch: Throwable -> L12
        int r110 = (r109.length * 3) / 2;     // Catch: Throwable -> L12
        x.a(r100, r109);     // Catch: Throwable -> L12
        com.bytedance.forest.utils.i.h("TemplateBundleProcessor", "size: " + r110, false, 60);     // Catch: Throwable -> L12
        TemplateBundle r111 = TemplateBundle.b(r109);     // Catch: Throwable -> L12
        a(r111, r100.f244432c);     // Catch: Throwable -> L12
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L12
        ProcessedData<TemplateBundle> r113 = new ProcessedData(r110, r111);     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r108, null);
        return r113;
    L12:
        th = move-exception;
        com.bytedance.forest.utils.i.e(com.bytedance.forest.utils.i.f244548a, "TemplateBundleProcessor", "error occurs when read data", th, true, 112);     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r108, th);
        throw th;
    L20:
        com.bytedance.forest.utils.i.h("TemplateBundleProcessor", "Only preload request can be processed", false, 60);
        throw new Throwable("Only preload request can be processed");
    }

    public w(String r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r101 & 2) == 0) goto L8;
        boolean r102 = true;
    L9:
        super(r102);
        this.f246774a = r100;
        return;
    L8:
        r102 = false;
        goto L9
    }

    public final void a(TemplateBundle r100, String r101) {
        String r102 = this.f246774a;
        boolean r103 = true;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L10:
        if (r104 == true) goto L12;
        com.bytedance.forest.utils.i.h("TemplateBundleProcessor", "====preCodeCache======", false, 60);
        r100.j(this.f246774a);
        return;
    L12:
        if (r101 != null) goto L14;
    L17:
        if (r103 == true) goto L21;
        com.bytedance.forest.utils.i.h("TemplateBundleProcessor", "====preCodeCache======", false, 60);
        r100.j(r101);
        return;
    L21:
        return;
    L14:
        if (r101.length() == 0) goto L17;
        r103 = false;
        goto L17
    L5:
        if (r102.length() == 0) goto L8;
        r104 = false;
        goto L10
    }
}
