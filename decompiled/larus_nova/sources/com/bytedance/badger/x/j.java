package com.bytedance.badger.x;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import javax.security.auth.x500.X500Principal;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes47.dex */
public final class j extends k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String[] f199389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String[] f199390d;

    public j(String r100, int r101) {
        super(r100, r101);
    }

    @Override // com.bytedance.badger.x.k
    public final k a(String... r100) {
        this.f199389c = (String[]) Arrays.copyOf(r100, r100.length);
        return this;
    }

    @Override // com.bytedance.badger.x.k
    public final k c(String... r100) {
        this.f199390d = (String[]) Arrays.copyOf(r100, r100.length);
        return this;
    }

    @Override // com.bytedance.badger.x.k
    public final AlgorithmParameterSpec b() {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L39;
        Class<?> r102 = Class.forName("android.security.keystore.KeyGenParameterSpec");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L30;
        FastClassNotFoundHandler.a("android.security.keystore.KeyGenParameterSpec");     // Catch: Throwable -> L8
    L30:
        Class<?> r103 = Integer.TYPE;
        Class<?> r110 = Boolean.TYPE;
        Object r104 = r102.getConstructor(new Class[]{String.class, r103, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, r103, String[].class, String[].class, String[].class, String[].class, r110, r110, r103}).newInstance(new Object[]{this.f199391a, -1, null, null, null, null, null, null, null, null, Integer.valueOf(this.f199392b), this.f199389c, null, this.f199390d, null, Boolean.TRUE, Boolean.FALSE, -1});
        if (r104 == null) goto L35;
        return (AlgorithmParameterSpec) r104;
    L35:
        throw new TypeCastException("null cannot be cast to non-null type java.security.spec.AlgorithmParameterSpec");
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.security.keystore.KeyGenParameterSpec");
    L12:
        throw th;
    L39:
        r102 = Class.forName("android.security.keystore.KeyGenParameterSpec");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L30;
        FastClassNotFoundHandler.a("android.security.keystore.KeyGenParameterSpec");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.security.keystore.KeyGenParameterSpec");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        r102 = MiraPluginFix.forName("android.security.keystore.KeyGenParameterSpec");
        goto L30
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }
}
