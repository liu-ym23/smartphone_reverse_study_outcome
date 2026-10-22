package lgc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RandomAccessFile f509217a;

    public a(File r100) throws FileNotFoundException {
        this.f509217a = new RandomAccessFile(r100, "r");
    }
}
