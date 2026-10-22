package n25;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.ss.android.lark.vfs.VFSFile;
import j25.q;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import k25.e0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static InputStream a(Context r3, String r4) {
        q r5 = e0.m().x(yu5.c.h(r4));
        if (r5 == null) goto L5;
        String r0 = r5.d;
        String r6 = r5.e;
    L6:
        tt5.a.b("BaseResourceInterceptor", "path = " + r0 + "---uri = " + r6);
    L21:
        e = move-exception;
        tt5.a.d("BaseResourceInterceptor", "internalGetLocalImageStream: " + e);
        return null;
    L8:
        if (TextUtils.isEmpty(r0) == true) goto L10;
    L13:
        InputStream r7 = (InputStream) b(r3, r0, r6).first;     // Catch: IOException -> L21
        if (r7 != null) goto L16;
        tt5.a.k("BaseResourceInterceptor", "internalGetLocalImageStream()... end  inputStream is null ");     // Catch: IOException -> L21
    L25:
        return null;
    L16:
        if (r7.available() <= 0) goto L18;
        return r7;
    L18:
        r7.close();     // Catch: IOException -> L21
        goto L25
    L10:
        if (TextUtils.isEmpty(r6) == false) goto L13;
        tt5.a.h("BaseResourceInterceptor", "internalGetLocalImageStream()... end  cannot find fileModel by ");     // Catch: IOException -> L21
        goto L25
    L5:
        r0 = "";
        r6 = "";
        goto L6
    }

    public static Pair b(Context r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "path");
        InputStream r3 = null;
        if (TextUtils.isEmpty(r5) == true) goto L17;
        VFSFile r7 = ay4.d.a().i(r5);
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
