package sfb;

import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.h;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final h b() {
        VFSFiles.f444819b.getClass();
        return VFSFiles.b(true);
    }

    @JvmStatic
    public static final String a(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        return "";
    L10:
        if (b().i(r100).exists() == false) goto L14;
        return r100;
    L14:
        return "";
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    @JvmStatic
    public static final boolean c(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
    L13:
        return false;
    L11:
        if (b().i(r100).exists() == false) goto L13;
        return true;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }
}
