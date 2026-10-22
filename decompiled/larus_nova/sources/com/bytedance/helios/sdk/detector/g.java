package com.bytedance.helios.sdk.detector;

import android.hardware.camera2.CameraCaptureSession;
import com.bytedance.android.livesdkapi.model.LinkMediaModel;
import com.bytedance.helios.api.consumer.PrivacyEvent;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g f245525e = null;

    static {
        g r100 = new g();
        f245525e = r100;
        r100.h(f.f245524c);
    }

    @Override // com.bytedance.helios.sdk.detector.b
    public final int[] e() {
        int[] r100 = f.f245522a;
        return f.f245522a;
    }

    @Override // com.bytedance.helios.sdk.detector.l
    public final String k() {
        int[] r100 = f.f245522a;
        return SRStrategy.KEY_CURRENT_RESOLUTION;
    }

    public g() {
    }

    @Override // com.bytedance.helios.sdk.detector.b
    public final void g(PrivacyEvent r100) {
        ApiConfig r101 = this.f245516a.get(r100.f245366c);
        if (r101.f245513b != 3) goto L10;
        int r102 = r101.f245514c;
        if (r102 != 100101) goto L7;
    L9:
        o(r100);
        return;
    L7:
        if (r102 == 100201) goto L9;
        return;
    L10:
        int r103 = r101.f245514c;
        if (r103 == 100100) goto L15;
        if (r103 == 100200) goto L15;
    L17:
        n(r101, r100);
        return;
    L15:
        if (l(r100) == 0) goto L17;
        a();
        goto L17
    }

    @Override // com.bytedance.helios.sdk.detector.l
    public final List<Integer> j(int r100) {
        switch(r100) {
            case 100103: goto L10;
            case 100105: goto L15;
            case 100106: goto L14;
            case 100204: goto L13;
            case 100205: goto L12;
            default: goto L11;
        };
    L11:
        return CollectionsKt.emptyList();
    L12:
        return CollectionsKt.listOf(new Integer[]{Integer.valueOf(LinkMediaModel.LIVE_LINK_OPEN_ALBUM_REQUEST_CODE), 100202, 100203});
    L13:
        return CollectionsKt.listOf(new Integer[]{100202, 100203});
    L14:
        return CollectionsKt.listOf(100100);
    L15:
        return CollectionsKt.listOf(100104);
    L10:
        return CollectionsKt.listOf(100102);
    }

    @Override // com.bytedance.helios.sdk.detector.l
    public final long l(PrivacyEvent r100) {
        int r101 = r100.f245366c;
        int r102 = 0;
        if (r101 == 100100) goto L14;
        Object r103 = null;
        switch(r101) {
            case 100200: goto L11;
            case 100201: goto L10;
            case 100202: goto L7;
            case 100203: goto L7;
            case 100204: goto L7;
            case 100205: goto L10;
            default: goto L6;
        };
    L6:
        r103 = r100.f245389z.getThisOrClass();
    L15:
        if (r103 == null) goto L18;
        r102 = r103.hashCode();
    L18:
        return r102;
    L7:
        CameraCaptureSession r104 = (CameraCaptureSession) r100.f245389z.getThisOrClass();
        if (r104 == null) goto L15;
        r103 = r104.getDevice();
        goto L15
    L10:
        r103 = r100.f245389z.getThisOrClass();
        goto L15
    L11:
        Object[] r105 = r100.f245389z.getParameters();
        if (r105 == null) goto L15;
        r103 = r105[0];
        goto L15
    L14:
        r103 = r100.f245389z.getResult();
        goto L15
    }
}
