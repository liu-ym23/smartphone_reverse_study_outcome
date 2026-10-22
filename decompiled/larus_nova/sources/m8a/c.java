package m8a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes32.dex */
public final class c extends BaseDataSubscriber<CloseableReference<PooledByteBuffer>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.a f512498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f512499b;

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onFailureImpl(DataSource<CloseableReference<PooledByteBuffer>> r100) {
        Throwable r101 = r100.getFailureCause();
        if (r101 == null) goto L5;
        LLog.e("LynxImageHelper", "loadBitmapFromRemote failed: " + r101.toString());
    L5:
        d r102 = this.f512499b;
        if (r102.f512502a == null) goto L19;
        d.c r103 = r102.f512503b;
        if (r103 == null) goto L14;
        d.a r104 = r103.f512521f;
        if (r104 == null) goto L14;
        if (r104.f512512f == null) goto L14;
        String r105 = "Android BigImageDrawingHelper loading image from remote failed, and the url is " + this.f512499b.f512503b.f512521f.f512512f + ". The Fresco throw error msg is " + r101.toString();
    L17:
        this.f512499b.f512502a.onImageLoadFailed(r105);
        return;
    L14:
        if (r101 == null) goto L16;
        r105 = r101.toString();
        goto L17
    L16:
        r105 = "";
        goto L17
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onNewResultImpl(DataSource<CloseableReference<PooledByteBuffer>> r110) {
        if (r110.isFinished() == true) goto L5;
        return;
    L5:
        CloseableReference<PooledByteBuffer> r111 = r110.getResult();
        if (r111 == null) goto L34;
        CloseableReference<PooledByteBuffer> r100 = r111.clone();
        PooledByteBufferInputStream r101 = new PooledByteBufferInputStream(r100.get());     // Catch: Throwable -> L17
        BitmapRegionDecoder r102 = BitmapRegionDecoder.newInstance(r101, false);     // Catch: Throwable -> L13
        BitmapFactory.Options r103 = new BitmapFactory.Options();     // Catch: Throwable -> L13
        d.c r104 = this.f512499b.m(this.f512498a, r102.getWidth(), r102.getHeight());     // Catch: Throwable -> L13
        if (r104 == null) goto L15;
        r103.inSampleSize = r104.f512516a;     // Catch: Throwable -> L13
        r103.inPreferredConfig = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L13
        r104.f512519d = r102.decodeRegion(r104.f512517b, r103);     // Catch: Throwable -> L13
        r104.f512520e = false;     // Catch: Throwable -> L13
        d r105 = this.f512499b;     // Catch: Throwable -> L13
        r105.f512504c.post(new a(r105, r104));     // Catch: Throwable -> L13
    L15:
        r102.recycle();     // Catch: Throwable -> L13
    L30:
        d.d(r101);
        r111.close();
        r100.close();
        return;
    L13:
        th = th;
    L35:
        th.printStackTrace();     // Catch: Throwable -> L31
        d r106 = this.f512499b;     // Catch: Throwable -> L31
        if (r106.f512502a == null) goto L30;
        d.c r107 = r106.f512503b;     // Catch: Throwable -> L31
        if (r107 == null) goto L28;
        d.a r108 = r107.f512521f;     // Catch: Throwable -> L31
        if (r108 == null) goto L28;
        if (r108.f512512f == null) goto L28;
        String r109 = "Android BigImageDrawingHelper loading image from remote onNewResultImpl failed, and the url is " + this.f512499b.f512503b.f512521f.f512512f + ". The Fresco throw error msg is " + th.toString();     // Catch: Throwable -> L31
    L29:
        this.f512499b.f512502a.onImageLoadFailed(r109);     // Catch: Throwable -> L31
    L28:
        r109 = th.toString();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        d.d(r101);
        r111.close();
        r100.close();
        throw th;
    L17:
        th = th;
        r101 = null;
        goto L35
    }

    public c(d r100, d.a r101) {
        this.f512499b = r100;
        this.f512498a = r101;
    }
}
