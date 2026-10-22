package com.larus.im.internal.audio.session.omni;

import com.larus.im.internal.jni.model.OmniAVVideoFrameData;
import com.larus.im.internal.jni.session.observer.OmniAVVideoFrameProcessorDelegate;
import com.larus.im.service.audio.ILLMVideoStreamIndex;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class x0 implements OmniAVVideoFrameProcessorDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f347396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.larus.im.service.audio.w f347397b;

    public static final class a implements com.larus.im.service.audio.u {
        public a(OmniAVVideoFrameData r100) {
            Intrinsics.checkNotNullParameter(r100, "frame");
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f347398a = null;

        static {
            int[] r100 = new int[ILLMVideoStreamIndex.values().length];
            r100[ILLMVideoStreamIndex.STREAM_INDEX_MAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ILLMVideoStreamIndex.STREAM_INDEX_SCREEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ILLMVideoStreamIndex.STREAM_INDEX_UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f347398a = r100;
        }
    }

    public x0(Integer r100) {
        this.f347396a = r100;
    }

    @Override // com.larus.im.internal.jni.session.observer.OmniAVVideoFrameProcessorDelegate
    public final OmniAVVideoFrameData onProcessCaptureFrame(int r100, OmniAVVideoFrameData r101) {
        Intrinsics.checkNotNullParameter(r101, "frame");
        Integer r102 = this.f347396a;
        if (r102 == null) goto L6;
        r100 = r102.intValue();
    L6:
        if (r100 == 0) goto L11;
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L10;
        ILLMVideoStreamIndex r103 = ILLMVideoStreamIndex.STREAM_INDEX_UNKNOWN;
    L13:
        if ((!r101.getPlanes().isEmpty()) == false) goto L15;
        a r104 = new a(r101);
    L16:
        com.larus.im.service.audio.w r105 = this.f347397b;
        if (r105 == null) goto L19;
        r105.a(r103, r104);
    L19:
        int r106 = com.larus.im.a.f346406a;
        gd9.o r107 = com.larus.im.internal.d.f347913a;
        com.larus.im.internal.audio.u.f347501c.getClass();
        com.larus.im.internal.utils.x r108 = com.larus.im.internal.utils.x.f350563a;
        int r109 = b.f347398a[r103.ordinal()];
        if (r109 == 1) goto L28;
        if (r109 != 2) goto L23;
        com.larus.im.internal.utils.x.f350568f.getClass();
    L29:
        return r101;
    L23:
        if (r109 != 3) goto L26;
        com.larus.im.internal.utils.x.f350566d.getClass();
        com.larus.im.internal.utils.x.f350568f.getClass();
        goto L29
    L26:
        throw new NoWhenBranchMatchedException();
    L28:
        com.larus.im.internal.utils.x.f350566d.getClass();
        goto L29
    L15:
        r104 = null;
        goto L16
    L10:
        r103 = ILLMVideoStreamIndex.STREAM_INDEX_SCREEN;
    L11:
        r103 = ILLMVideoStreamIndex.STREAM_INDEX_MAIN;
        goto L13
    }
}
