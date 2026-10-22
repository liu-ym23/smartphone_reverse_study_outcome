package jkc;

import android.content.Context;
import android.net.Uri;
import android.util.Pair;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes40.dex */
public interface c {
    InputStream D5(File r100) throws IOException;

    Pair<Integer, String> Ec(String r100);

    Pair<Integer, String> Gd(Context r100, Uri r101);

    int Q9(File r100);

    void f5(String r100, long r101, String r102);

    Pair<Integer, String> m3(File r100);

    int o1();

    OutputStream p3(File r100, boolean r101) throws IOException;
}
