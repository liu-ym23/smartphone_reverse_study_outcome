package com.ss.ugc.live.sdk.msg.unify.business;

import android.text.TextUtils;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.ugc.live.sdk.msg.dispatch.f;
import com.ss.ugc.live.sdk.msg.unify.j;
import im2.l;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements imc.d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f458338k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f458339l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.ss.ugc.live.sdk.msg.data.c f458340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f458341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f458342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f458343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f458344e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f458345f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f458346g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, String> f458347h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f f458348i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final amc.d f458349j;

    /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.unify.business.a$a, reason: collision with other inner class name */
    public static final class C5489a {
    }

    static {
    }

    @Override // imc.d
    public final byte[] a() {
        String r100 = this.f458341b;
        if (r100 != null) goto L7;
        r100 = "";
    L7:
        return r100.getBytes(Charsets.UTF_8);
    }

    @Override // imc.d
    public final Map<String, String> d() {
        HashMap r100 = new HashMap();
        com.ss.ugc.live.sdk.msg.data.c r101 = this.f458340a;
        if (r101 == null) goto L5;
        HashMap r102 = new HashMap();
        r102.put("im-trace-receive_count", String.valueOf(r101.f458240e));
        r102.put("im-trace-error_count", String.valueOf(r101.f458241f.size()));
        r102.put("im-trace-error_msg_ids", TextUtils.join(",", CollectionsKt.take(r101.f458241f, Math.max(0, 15))));
        r100.putAll(r102);
    L5:
        String r103 = this.f458341b;
        if (r103 == null) goto L8;
        String r104 = (String) r100.put("internal_ext", r103);
    L8:
        String r105 = this.f458342c;
        if (r105 == null) goto L11;
        String r106 = (String) r100.put(EffectConfiguration.KEY_CURSOR, r105);
    L11:
        String r107 = f458338k;
        if (r107 == null) goto L14;
        String r108 = (String) r100.put("live_cursor", r107);
    L14:
        String r109 = f458339l;
        if (r109 == null) goto L17;
        r100.put("wrds_preload_ext", r109);
    L17:
        return r100;
    }

    @Override // imc.d
    public final j b() {
        return this.f458343d;
    }

    @Override // imc.d
    public final b c() {
        return this.f458344e;
    }

    public a(int r100, int r101, Map r102, bmc.b r103, l r104) {
        Intrinsics.checkNotNullParameter(r102, "customParams");
        Intrinsics.checkNotNullParameter(r103, "messageDecoder");
        this.f458345f = r100;
        this.f458346g = r101;
        this.f458347h = r102;
        this.f458348i = r103;
        this.f458349j = r104;
        this.f458343d = new j(r100, r101, r102);
        this.f458344e = new b(this);
    }
}
