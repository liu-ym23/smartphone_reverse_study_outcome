package zkb;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.s;
import com.ss.android.lark.image.uploader.utils.c;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.suite.lark.platform.component.storage.file.dirs.f;
import com.suite.lark.platform.component.storage.file.dirs.h;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f572738a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, Integer> f572739b = null;

    public a() {
    }

    static {
        f572738a = new a();
        f572739b = new HashMap();
    }

    public final synchronized String b(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "filePath");     // Catch: Throwable -> L9
        HashMap<String, Integer> r101 = f572739b;     // Catch: Throwable -> L9
        Integer r102 = r101.get(r100);     // Catch: Throwable -> L9
        if (r102 != null) goto L6;
        r102 = 0;     // Catch: Throwable -> L9
    L6:
        r101.put(r100, Integer.valueOf(r102.intValue() + 1));     // Catch: Throwable -> L9
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L9
        String r104 = String.format("%s_%s", Arrays.copyOf(new Object[]{r100, r102}, 2));     // Catch: Throwable -> L9
        monitor-exit(this);
        return r104;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean c(String r100, String r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TEMP_PATH);     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r101, "path");     // Catch: Throwable -> L7
        long r102 = System.currentTimeMillis();     // Catch: Throwable -> L7
        boolean r103 = new PolarisFileWrapper(r100).renameTo(new PolarisFileWrapper(r101));     // Catch: Throwable -> L7
        int r104 = c.f426438a;     // Catch: Throwable -> L7
        c.a("CacheManager", "rename time cost: " + (System.currentTimeMillis() - r102));     // Catch: Throwable -> L7
        monitor-exit(this);
        return r103;
    L7:
        th = move-exception;
        throw th;
    }

    public static String a(Context r100, String r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "filePath");
        int r104 = h.f460642c;
        String r105 = h.a.a(r100).b(new f()).getRealPath();
        PolarisFileWrapper r106 = new PolarisFileWrapper(r101);
        StringCompanionObject r107 = StringCompanionObject.INSTANCE;
        String r108 = String.format("%s_%s_%s", Arrays.copyOf(new Object[]{r106.getPath(), Long.valueOf(r106.length()), Long.valueOf(r106.lastModified())}, 3));
        String r109 = s.b(r108);
        if (TextUtils.isEmpty(r109) == false) goto L6;
        r109 = String.valueOf(Objects.hashCode(r108));
    L6:
        return r105 + File.separator + r109 + '_' + r102 + '_' + r103;
    }
}
