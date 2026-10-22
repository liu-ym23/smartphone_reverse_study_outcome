package b35;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Pair;
import ay4.d;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.ss.android.lark.vfs.VFSFile;
import java.io.FileNotFoundException;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Pair a(Context r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "path");
        InputStream r3 = null;
        if (TextUtils.isEmpty(r5) == true) goto L17;
        VFSFile r7 = d.a().i(r5);
    L14:
        e = move-exception;
        tt5.a.e("BaseResourceInterceptor", "readResponseStream... err happens", e, false);
    L27:
        return new Pair(r3, -1L);
    L6:
        if (r7.exists() == false) goto L8;
        r3 = r7.newInputStream();     // Catch: Exception -> L14
    L12:
        return new Pair(r3, Long.valueOf(r7.length()));
    L8:
        if (r4 == null) goto L12;
        AssetManager r8 = r4.getAssets();     // Catch: Exception -> L14
        if (r8 == null) goto L12;
        r3 = r8.open(r5);     // Catch: Exception -> L14
        goto L12
    L17:
        if (TextUtils.isEmpty(r6) == true) goto L25;
        if (r4 == null) goto L27;
        ContentResolver r9 = r4.getContentResolver();     // Catch: FileNotFoundException -> L23
        if (r9 == null) goto L27;
        r3 = ContentResolverWrapper.openInputStream(r9, UriProtector.parse(r6));     // Catch: FileNotFoundException -> L23
    L23:
        e = move-exception;
        tt5.a.e("BaseResourceInterceptor", "readResponseStream from uri... err", e, false);
        goto L27
    L25:
        tt5.a.d("BaseResourceInterceptor", "readResponseStream... empty file path and uri");
        goto L27
    }
}
