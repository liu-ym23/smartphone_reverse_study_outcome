package com.larus.uploader.impl.preheat;

import com.larus.utils.logger.FLogger;
import com.ss.bduploader.BDImageXInfo;
import com.ss.bduploader.BDImageXUploaderListener;

/* JADX INFO: loaded from: classes31.dex */
public final class a implements BDImageXUploaderListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f375325a;

    @Override // com.ss.bduploader.BDImageXUploaderListener
    public final int imageXUploadCheckNetState(int r100, int r101) {
        return 1;
    }

    public a(long r100) {
        this.f375325a = r100;
    }

    @Override // com.ss.bduploader.BDImageXUploaderListener
    public final void onLog(int r100, int r101, String r102) {
        FLogger.f375446a.i("ImgUploadPreheat", "[onLog] what:" + r100 + ", code:" + r101 + ", info" + r102);
    }

    @Override // com.ss.bduploader.BDImageXUploaderListener
    public final void onNotify(int r100, long r101, BDImageXInfo r102) {
        FLogger r103 = FLogger.f375446a;
        r103.i("ImgUploadPreheat", "what=" + r100 + ", parameter=" + r101 + ", info=" + r102);
        if (r100 != 123) goto L7;
        r103.i("ImgUploadPreheat", "preheat complete, costMs=" + (System.currentTimeMillis() - this.f375325a));
        return;
    L7:
        if (r100 == 124) goto L9;
        return;
    L9:
        if (r101 != 1) goto L11;
        boolean r104 = true;
    L12:
        r103.i("ImgUploadPreheat", "[preheat] resultUsed hit=" + r104);
        return;
    L11:
        r104 = false;
        goto L12
    }
}
