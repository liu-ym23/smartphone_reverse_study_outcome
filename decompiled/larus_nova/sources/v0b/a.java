package v0b;

import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleonv2.debug.g;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.lark.vfs.h;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f552340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ChameleonConfig f552341b;

    @Override // v0b.f
    public final void onStart() {
        f r100 = this.f552340a;
        if (r100 == null) goto L6;
        r100.onStart();
        return;
    }

    @Override // v0b.f
    public final void a(int r100) {
        f r101 = this.f552340a;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // v0b.f
    public final void b(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        f r101 = this.f552340a;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    @Override // v0b.f
    public final void c(Exception r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        VFSFiles.f444819b.getClass();     // Catch: IOException -> L5
        h r101 = VFSFiles.b(true);     // Catch: IOException -> L5
        int r102 = e.f552347a;     // Catch: IOException -> L5
        e.b(r101.t(e.e(this.f552341b)));     // Catch: IOException -> L5
    L7:
        f r103 = this.f552340a;
        if (r103 == null) goto L13;
        r103.c(r100);
        return;
    L13:
        return;
    L5:
        e = move-exception;
        j.b("CML_TAG_D_Downloader", "onDownloadError:" + e);
        goto L7
    }

    public a(g r100, ChameleonConfig r101) {
        this.f552340a = r100;
        this.f552341b = r101;
    }
}
