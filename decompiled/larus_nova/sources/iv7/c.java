package iv7;

import java.io.FilterOutputStream;
import java.io.IOException;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes23.dex */
public final class c extends FilterOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f495948a;

    public c(l r100) {
        super(r100);
        this.f495948a = 0;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int r100) throws IOException {
        this.f495948a++;
        ((FilterOutputStream) this).out.write(r100);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] r100) throws IOException {
        this.f495948a += (long) r100.length;
        ((FilterOutputStream) this).out.write(r100);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(@Nonnull byte[] r100, int r101, int r102) throws IOException {
        this.f495948a += (long) r102;
        ((FilterOutputStream) this).out.write(r100, r101, r102);
    }
}
