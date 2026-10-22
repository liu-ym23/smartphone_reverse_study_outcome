package com.bytedance.sdk.open.douyin.settings;

import android.content.Context;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.sdk.open.aweme.utils.IOUtils;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f269703d = "SettingsDao";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f269704e = "open";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f269705f = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f269706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f269707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f269708c;

    public e(Context r100) {
        this.f269706a = r100;
        File r101 = a(r100);
        this.f269707b = r101;
        this.f269708c = b.a(r101);
    }

    private File a(Context r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.getFilesDir(), "open/open.settings");
        if (r101.exists() == false) goto L8;
        return r101;
    L8:
        r101.getParentFile().mkdirs();     // Catch: Exception -> L7
        r101.createNewFile();     // Catch: Exception -> L7
    L6:
        return r101;
    }

    private boolean a(String r100) {
        if (this.f269708c.a(200) == true) goto L14;
        LogUtils.w(f269703d, new Object[]{"loadSettingsModel lock failed"});
        return false;
    L14:
        boolean r101 = IOUtils.writeStringToFile(this.f269707b.getAbsolutePath(), r100, XML.CHARSET_UTF8);     // Catch: Throwable -> L9 Exception -> L12
        this.f269708c.b();
        return r101;
    L12:
        this.f269708c.b();
        return false;
    L9:
        th = move-exception;
        this.f269708c.b();
        throw th;
    }

    private String d() {
        if (this.f269708c.a(200) == true) goto L18;
        LogUtils.w(f269703d, new Object[]{"read lock failed:"});
        return null;
    L18:
        String r100 = IOUtils.fromInputStream(new PolarisFileInputStreamWrapper(this.f269707b));     // Catch: Throwable -> L9 Exception -> L11
        this.f269708c.b();
        return r100;
    L11:
        e = move-exception;
        LogUtils.w(f269703d, new Object[]{"read", e});     // Catch: Throwable -> L9
        this.f269708c.b();
        return null;
    L9:
        th = move-exception;
        this.f269708c.b();
        throw th;
    }

    public boolean a() {
        return a("");
    }

    public boolean a(f r100) {
        return a(r100.g().toString());
    }

    public f b() {
        return new f(0, "", new JSONObject(), new JSONObject(), 0);
    }

    public f c() {
        String r100 = d();
        if (TextUtils.isEmpty(r100) == true) goto L5;
        f r101 = f.a(r100);
        if (r101 == null) goto L9;
        return r101;
    L9:
        return b();
    L5:
        return b();
    }
}
