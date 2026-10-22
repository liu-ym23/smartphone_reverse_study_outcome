package ntb;

import android.content.Context;
import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.officesdk.di.core.deps.StorageVolume;
import com.ss.android.lark.vfs.VFSFile;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: classes37.dex */
public interface v extends com.ss.android.lark.officesdk.di.core.b {
    PolarisFileWrapper A(Context r100, Uri r101, boolean r102);

    void b(String r100);

    boolean e();

    String getString();

    VFSFile i(String r100);

    InputStream k(String r100);

    File l0(StorageVolume r100, String... r101);
}
