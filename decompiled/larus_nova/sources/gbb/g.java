package gbb;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.lark.android.encryption.exception.DecryptException;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes35.dex */
public interface g {

    public interface a {
        boolean write(File r100);
    }

    PolarisFileWrapper a(String r100) throws IOException, DecryptException;

    File b();

    File c(String r100) throws IOException;

    void d(String r100, a r101) throws IOException;

    void delete() throws IOException;

    void remove(String r100) throws IOException;
}
