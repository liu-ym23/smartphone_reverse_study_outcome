package hkc;

import android.content.Context;
import android.net.Uri;
import android.util.Pair;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.larksuite.framework.utils.b;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import e0c.k;
import ikc.f;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import jkc.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class a implements c {

    /* JADX INFO: renamed from: hkc.a$a, reason: collision with other inner class name */
    public static final class C6160a {
    }

    static {
    }

    public a() {
    }

    public static c a() {
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L7;
        f.f490295a.f490294c.isLogin();
        return null;
    L7:
        return (c) k.a(b.f285948a, c.class);
    }

    @Override // jkc.c
    public final int o1() {
        c r100 = a();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.o1();
    }

    @Override // jkc.c
    public final InputStream D5(File r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        c r101 = a();
        if (r101 == null) goto L7;
        InputStream r102 = r101.D5(r100);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return new PolarisFileInputStreamWrapper(r100);
    }

    @Override // jkc.c
    public final Pair<Integer, String> Ec(String r100) {
        Intrinsics.checkNotNullParameter(r100, "decryptedPath");
        c r101 = a();
        if (r101 == null) goto L7;
        Pair<Integer, String> r102 = r101.Ec(r100);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return new Pair(-1, null);
    }

    @Override // jkc.c
    public final int Q9(File r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        c r101 = a();
        if (r101 != null) goto L7;
        return -1;
    L7:
        return r101.Q9(r100);
    }

    @Override // jkc.c
    public final Pair<Integer, String> m3(File r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        c r101 = a();
        if (r101 == null) goto L7;
        Pair<Integer, String> r102 = r101.m3(r100);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return new Pair(-1, null);
    }

    @Override // jkc.c
    public final Pair<Integer, String> Gd(Context r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r101, "uri");
        c r102 = a();
        if (r102 == null) goto L7;
        Pair<Integer, String> r103 = r102.Gd(r100, r101);
        if (r103 == null) goto L7;
        return r103;
    L7:
        return new Pair(-1, null);
    }

    @Override // jkc.c
    public final OutputStream p3(File r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "file");
        c r102 = a();
        if (r102 == null) goto L7;
        OutputStream r103 = r102.p3(r100, r101);
        if (r103 == null) goto L7;
        return r103;
    L7:
        return new PolarisFileOutputStreamWrapper(r100);
    }

    @Override // jkc.c
    public final void f5(String r100, long r101, String r102) {
        c r103 = a();
        if (r103 == null) goto L6;
        r103.f5(r100, r101, r102);
        return;
    }
}
