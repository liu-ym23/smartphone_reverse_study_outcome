package com.bytedance.badger.x;

import android.content.Context;
import android.os.Build;
import com.alipay.sdk.m.n.d;
import com.bm.badgervi.b;
import com.bytedance.badger.BadgerCore;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import kotlin.TypeCastException;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class r extends q {
    public r() {
    }

    public static String g() {
        BadgerCore.Companion.getClass();
        return com.bytedance.badger.j.b(6652161667115517076L);
    }

    public static String h() {
        String r100 = p.f199399f;
        if (r100 != null) goto L6;
        BadgerCore.Companion.getClass();
        return com.bytedance.badger.j.b(5819945665527921280L);
    L6:
        return r100;
    }

    @Override // com.bytedance.badger.x.q
    public final String c() {
        return ShortVideoSegments.KEY_PROP_PROVIDER;
    }

    @Override // com.bytedance.badger.x.q
    public final void d(Context r100) {
        if (p.f199398e == false) goto L5;
        return;
    L5:
        p.i();
    }

    @Override // com.bytedance.badger.x.q
    public final boolean e() {
        KeyStore r100 = KeyStore.getInstance(p.f199399f);
        r100.load(null);
        if (r100.getCertificate(g()) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.badger.x.q
    public final void f() {
        KeyStore r100 = KeyStore.getInstance(h());
        r100.load(null);
        r100.deleteEntry(g());
    }

    @Override // com.bytedance.badger.x.q
    public final String a() {
        KeyStore r100 = KeyStore.getInstance(h());
        r100.load(null);
        if (StringsKt.split$default(h(), new String[]{"."}, false, 0, 6, null).size() <= 1) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L19;
        Certificate[] r102 = r100.getCertificateChain(g());
        if (r102 == null) goto L18;
        if (r102.length != 0) goto L12;
        boolean r103 = true;
    L14:
        if ((!r103) == false) goto L18;
        JSONObject r104 = b.e((X509Certificate) r102[0]);
        BadgerCore.Companion.getClass();
        return JSONObjectProtectorUtils.getString(r104, com.bytedance.badger.j.b(3852863012899441828L));
    L12:
        r103 = false;
    L18:
        throw new IllegalStateException("certificates is null");
    L19:
        String r105 = g();
        BadgerCore.Companion.getClass();
        String r106 = com.bytedance.badger.j.b(7897631484142453971L);
        if (r106 == null) goto L28;
        Key r107 = r100.getKey(r105, r106.toCharArray());
        if (r107 == null) goto L26;
        return p.c(r107.getEncoded());
    L26:
        throw new IllegalStateException("key is null");
    L28:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.badger.x.q
    public final void b() {
        KeyStore.getInstance(h()).load(null);
        BadgerCore.Companion.getClass();
        String r100 = com.bytedance.badger.j.b(5819945665527921280L);
        boolean r101 = true;
        if (StringsKt.split$default(h(), new String[]{"."}, false, 0, 6, null).size() > 1) goto L6;
        r101 = false;
    L6:
        if (r101 == false) goto L8;
        r100 = h();
        int r102 = 16;
    L9:
        KeyPairGenerator r103 = KeyPairGenerator.getInstance(d.f25615a, r100);
        String r104 = g() + com.bytedance.badger.j.b(9130210732707849621L);
        if (Build.VERSION.SDK_INT < 23) goto L12;
        k r105 = new e(r104, r102);
    L13:
        r103.initialize(r105.a(new String[]{"SHA-256"}).c(new String[]{"PSS"}).b());
        r103.generateKeyPair();
        return;
    L12:
        r105 = new j(r104, r102);
        goto L13
    L8:
        r102 = 4;
        goto L9
    }
}
