package xg4;

import android.os.FileObserver;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;

/* JADX INFO: loaded from: classes15.dex */
public final class f extends FileObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f563653a;

    @Override // android.os.FileObserver
    public final void onEvent(int r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L26;
        return;
    L26:
        throw null;     // Catch: Throwable -> L7
    L8:
        if (TextUtils.isEmpty(null) == true) goto L10;
        return;
    L10:
        int r102 = new j().f563668d;
        if (r102 == Process.myPid()) goto L13;
        return;
    L13:
        String r103 = i.b(System.currentTimeMillis(), r102, false);
        PolarisFileWrapper r104 = new PolarisFileWrapper(this.f563653a.f563658d, r103);
        PolarisFileWrapper r105 = new PolarisFileWrapper(this.f563653a.f563658d, "from_external_flag");
        if (r105.exists() == false) goto L24;
    L22:
        com.bytedance.crash.util.h.h(r104, null, false);     // Catch: IOException -> L18
        return;
    L18:
        e = move-exception;
        a.c(e);
        return;
    L24:
        r105.createNewFile();     // Catch: IOException -> L21
        goto L22
    }

    public f(i r100, String r101, String r102) {
        this.f563653a = r100;
        super(r101, 136);
    }
}
