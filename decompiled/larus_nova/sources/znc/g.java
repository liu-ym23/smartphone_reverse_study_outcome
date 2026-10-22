package znc;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.ss.android.lark.vfs.VFSFile;
import java.io.File;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class g extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f573046c;

    @Override // znc.a
    public final InputStream b() {
        return new PolarisFileInputStreamWrapper(this.f573046c);
    }

    public g(VFSFile r100) {
        Intrinsics.checkNotNullParameter(r100, "sourceFile");
        this.f573046c = r100;
    }
}
