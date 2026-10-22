package wkb;

import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.dirs.h;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes36.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final VFSPath a() {
        int r100 = h.f460642c;
        h r101 = h.a.a(LarkContext.getApplication());
        VFSFiles.f444819b.getClass();
        r101.c(VFSFiles.b(true));
        return r101.b(new a());
    }
}
