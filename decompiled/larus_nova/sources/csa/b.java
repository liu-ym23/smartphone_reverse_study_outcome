package csa;

import android.opengl.GLES20;
import com.larus.apm.impl.protector.RunnableProtector;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f465196a;

    public final void a() {
        ByteBuffer r100 = this.f465196a.f20337o;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        a r101 = this.f465196a;
        r101.f20337o = null;
        int[] r102 = r101.f20338p;
        if (r102 == null) goto L8;
        GLES20.glDeleteTextures(1, r102, 0);
        r101.f20338p = null;
    L8:
        a.j(this.f465196a);
        this.f465196a.k("changePreviewSize");
        this.f465196a.getClass();
        a r103 = this.f465196a;
        r103.f20339q = false;
        r103.f20329g.requestRender();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(a r100) {
        this.f465196a = r100;
    }
}
