package com.larus.business.debug.base.audio.module;

import android.os.Handler;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.common.apphost.AppHost;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class TTSModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, ByteArrayOutputStream> f319994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, ByteArrayOutputStream> f319995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TTSModule$itemMap$1 f319996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f319997d;

    public final float a() {
        int r100 = q.f320007a;
        if (f.f320006b == true) goto L6;
        return 0.0f;
    L6:
        return f.a().getFloat("keva_dora_force_loudness", 0.0f);
    }

    public final float b() {
        int r100 = q.f320007a;
        if (f.f320006b == true) goto L6;
        return 0.0f;
    L6:
        return f.a().getFloat("keva_force_loudness", 0.0f);
    }

    public final String c() {
        int r100 = q.f320007a;
        boolean r101 = false;
        if (f.f320006b == false) goto L6;
        r101 = f.a().getBoolean("keva_loudness_dump_open", false);
    L6:
        String r102 = null;
        if (r101 == false) goto L16;
        File r103 = AppHost.f326268a.getApplication().getExternalFilesDir(null);
        if (r103 == null) goto L12;
        String r104 = r103.getAbsolutePath();
        if (r104 == null) goto L12;
    L13:
        StringBuilder r105 = new StringBuilder();
        r105.append(r104);
        String r106 = File.separator;
        r105.append(r106);
        r105.append("audio");
        r105.append(r106);
        r105.append("loudness");
        r105.append(r106);
        r102 = r105.toString();
        PolarisFileWrapper r107 = new PolarisFileWrapper(r102);
        if (r107.exists() == true) goto L16;
        r107.mkdirs();
    L12:
        r104 = "";
    L16:
        return r102;
    }

    public final boolean e() {
        int r100 = q.f320007a;
        if (f.f320006b == true) goto L6;
        return false;
    L6:
        return f.a().getBoolean("keva_force_new_algo", false);
    }

    public TTSModule() {
        this.f319994a = new LinkedHashMap();
        this.f319995b = new LinkedHashMap();
        this.f319996c = new TTSModule$itemMap$1();
        StringBuilder r100 = new StringBuilder();
        boolean r101 = AudioDebugUtil.f319980a;
        r100.append(AudioDebugUtil.f319981b);
        r100.append(File.separator);
        r100.append("tts_info.log");
        this.f319997d = r100.toString();
    }

    public final a68.c d(String r100) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        return (a68.c) this.f319996c.get(r100);
    }

    public final void g(final z58.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        boolean r101 = AudioDebugUtil.f319980a;
        Handler r102 = AudioDebugUtil.f319991l;
        if (r102 == null) goto L8;
        r102.post(new z(r100, this));
        return;
    }

    public final void j(String r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (AudioDebugUtil.f319980a == false) goto L8;
        this.f319994a.put(r100, new ByteArrayOutputStream());
        return;
    }

    public final void f(String r100, byte[] r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (AudioDebugUtil.f319980a == false) goto L10;
        ByteArrayOutputStream r102 = (ByteArrayOutputStream) ((LinkedHashMap) this.f319994a).get(r100);
        if (r102 == null) goto L11;
        r102.write(r101);
        return;
    L11:
        return;
    }

    public final void h(String r100, byte[] r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (AudioDebugUtil.f319980a == true) goto L8;
        return;
    L8:
        if (this.f319995b.containsKey(r100) == true) goto L10;
        this.f319995b.put(r100, new ByteArrayOutputStream());
    L10:
        ByteArrayOutputStream r102 = (ByteArrayOutputStream) ((LinkedHashMap) this.f319995b).get(r100);
        if (r102 == null) goto L14;
        r102.write(r101);
        return;
    }

    public final void i(final String r100, final String r101) {
        boolean r102 = AudioDebugUtil.f319980a;
        if (AudioDebugUtil.f319980a == true) goto L5;
        return;
    L5:
        Handler r103 = AudioDebugUtil.f319991l;
        if (r103 == null) goto L9;
        r103.post(new y(this, r100, r101));
        return;
    }
}
