package pt;

import com.bytedance.common.utility.Logger;
import com.ss.bduploader.BDImageXInfo;
import com.ss.bduploader.BDImageXUploader;
import com.ss.bduploader.BDImageXUploaderListener;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements BDImageXUploaderListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BDImageXUploader f530620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f530621b;

    public c(BDImageXUploader r100, d r101) {
        this.f530620a = r100;
        this.f530621b = r101;
    }

    @Override // com.ss.bduploader.BDImageXUploaderListener
    public final int imageXUploadCheckNetState(int r100, int r101) {
        return this.f530621b.f530624c.imageXUploadCheckNetState(r100, r101);
    }

    @Override // com.ss.bduploader.BDImageXUploaderListener
    public final void onLog(int r100, int r101, String r102) {
        Logger.i("ImageXUtil", "what = " + r100 + " code = " + r101 + " info = " + r102);
        this.f530621b.f530624c.onLog(r100, r101, r102);
    }

    @Override // com.ss.bduploader.BDImageXUploaderListener
    public final void onNotify(int r100, long r101, BDImageXInfo r102) {
        this.f530621b.f530624c.onNotify(r100, r101, r102);
        if (r100 != 0) goto L7;
        this.f530620a.close();
        return;
    }
}
