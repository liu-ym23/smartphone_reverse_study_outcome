package nac;

import android.content.Context;
import android.net.Uri;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.FileSystem;
import com.ss.android.lark.vfs.NativeFileSystem;
import com.ss.android.lark.vfs.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f518494a = null;

    static {
        f518494a = new a();
    }

    public a() {
    }

    @Override // com.ss.android.lark.vfs.c
    public final String getName() {
        return "NativeFileSystemProvider";
    }

    @Override // com.ss.android.lark.vfs.c
    public final String scheme() {
        return "file";
    }

    @Override // com.ss.android.lark.vfs.c
    public final FileSystem a(Context r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        return new NativeFileSystem();
    }
}
