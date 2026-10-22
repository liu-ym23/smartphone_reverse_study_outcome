package zx5;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements Closeable {

    /* JADX INFO: renamed from: zx5.a$a, reason: collision with other inner class name */
    public class C8504a extends OutputStream {
        @Override // java.io.OutputStream
        public final void write(int r100) throws IOException {
        }

        public C8504a() {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        monitor-enter(this);
        monitor-exit(this);
    }

    static {
        PatternProtector.compile("[a-z0-9_-]{1,120}");
        new C8504a();
    }

    public void delete() throws IOException {
        close();
        b.a(null);
        throw null;
    }
}
