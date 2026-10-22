package znc;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public interface b {

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f573013a = null;

        static {
            f573013a = new a();
        }

        public a() {
        }

        @Override // znc.b
        public final File b(File r100) {
            Intrinsics.checkNotNullParameter(r100, "file");
            return r100;
        }

        @Override // znc.b
        public final OutputStream a(PolarisFileWrapper r100) throws FileNotFoundException {
            Intrinsics.checkNotNullParameter(r100, "file");
            return new PolarisFileOutputStreamWrapper(r100);
        }

        @Override // znc.b
        public final void c(PolarisFileWrapper r100) {
            Intrinsics.checkNotNullParameter(r100, "directory");
        }

        @Override // znc.b
        public final InputStream j(File r100) throws FileNotFoundException {
            Intrinsics.checkNotNullParameter(r100, "file");
            return new PolarisFileInputStreamWrapper(r100);
        }
    }

    OutputStream a(PolarisFileWrapper r100) throws FileNotFoundException;

    File b(File r100);

    void c(PolarisFileWrapper r100);

    InputStream j(File r100) throws FileNotFoundException;
}
