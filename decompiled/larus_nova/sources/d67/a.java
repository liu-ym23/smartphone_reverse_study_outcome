package d67;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import k67.b;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f467209a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f467210b;

    public a() {
    }

    static {
        f467209a = a.class.getSimpleName();
    }

    public static a d() {
        if (f467210b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f467210b != null) goto L9;
        f467210b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f467210b;
    }

    public static void a(Context r100, String r101) {
        int r102 = j67.a.b().deleteKey(r100, r101, new Bundle());
        j67.a.c();
        String r103 = f467209a;
        if (r102 != 0) goto L5;
        b.e(r103, "Deleted attest key successfully: " + r101);
        return;
    L5:
        b.c(r103, "Failed to delete attest key: " + r101 + ", ret: " + r102);
    }

    public static int b(Context r100, String r101, Bundle r102) {
        int r103 = j67.a.b().generateKeyPair(r100, r101, r102);
        j67.a.c();
        if (r103 == 0) goto L6;
        b.c(f467209a, "Generate key pair failed! ret:" + r103);
        return r103;
    L6:
        j67.a.c();
        return 0;
    }

    public static List c(Context r100, String r101, String r102, String r103, Bundle r104, Bundle r105) {
        String r106 = e67.a.c();
        boolean r107 = TextUtils.isEmpty(r106);
        String r108 = f467209a;
        if (r107 == false) goto L6;
        b.c(r108, "Request challenge failed!!");
        return new ArrayList();
    L6:
        b.a(r108, "Request challenge succeed! challenge:" + r106);
        int r109 = b(r100, r103, r104);
        j67.a.c();
        if (r109 == 0) goto L10;
        b.c(r108, "Generate attestation key pair failed! ret:" + r109);
        return new ArrayList();
    L10:
        String r110 = r106 + ":" + r102 + ":" + r101;
        if (r105 != null) goto L13;
        b.c(r108, "Attest bundle is null");
        List r111 = new ArrayList();
    L24:
        if (r111.isEmpty() == false) goto L27;
        b.c(r108, "attestKeyWithIds failed, delete keyAlias: " + r103);
        a(r100, r103);
        return new ArrayList();
    L27:
        return r111;
    L13:
        j67.a.b().f();
        r105.putString("challenge", r110);
        j67.a.c r112 = j67.a.b().keyAttestation(r100, r103, r105);
        int r113 = r112.f497528a;
        j67.a.c();
        if (r113 == 0) goto L16;
        b.c(r108, "Attest key with ids failed! ret:" + r112.f497528a);
        r111 = new ArrayList();
        goto L24
    L16:
        r111 = r112.f497529b;
        if (r111 != null) goto L19;
    L22:
        b.c(r108, "keyAttestation result certChain invalid for keyAlias=" + r103);
        r111 = new ArrayList();
        goto L24
    L19:
        if (r111.isEmpty() == true) goto L22;
        b.a(r108, "Attest key with ids succeed! keyAlias=" + r103 + ", cert chain size: " + r111.size());
        goto L24
    }
}
