package com.bytedance.ee.bear.doc.newresupdate.provider.interceptor;

import android.content.Context;
import com.bytedance.ee.bear.bitable.fieldedit.view.edit.modifiedtime.ModifiedTimeWatch;
import com.bytedance.ee.bear.contract.z;
import com.bytedance.ee.bear.doc.resupdate.EChannel;
import com.bytedance.ee.bear.doc.resupdate.d0;
import com.bytedance.ee.bear.doc.resupdate.e0;
import com.bytedance.ee.util.ui.j;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFile;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class h extends com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f217992e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f217993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public VFSFile f217994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f217995d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a
    public final e0 b() {
        tt5.a.h("AbsResourceInterceptor", "getResource, use specific");
        VFSFile[] r100 = e().listFiles();
        Intrinsics.checkNotNull(r100);
        String r101 = r100[0].getName();
    L11:
        e = move-exception;
        tt5.a.e("AbsResourceInterceptor", "getResource error", e, false);
        return a();
    L4:
        if (((z) org.koin.java.a.c(z.class, null, null, 6)).isDebugEnabled(this.f217993b) == true) goto L7;
    L9:
        return c(e(), r101, EChannel.DOCS_CHANNEL.toString());
    L7:
        if (f217992e == true) goto L9;
        j.c(new i(r101));     // Catch: Exception -> L11
        f217992e = true;     // Catch: Exception -> L11
        goto L9
    }

    @Override // com.bytedance.ee.bear.doc.newresupdate.provider.interceptor.a
    public final boolean d() {
        if (this.f217995d == true) goto L11;
        String[] r100 = e().list();
        if (r100 == null) goto L7;
        int r101 = r100.length;
    L8:
        if (r101 <= 0) goto L12;
        return true;
    L12:
        return false;
    L7:
        r101 = 0;
        goto L8
    L11:
        return false;
    }

    public final VFSFile e() {
        if (this.f217994c != null) goto L5;
        this.f217994c = d0.j(ModifiedTimeWatch.WATCH_TYPE_SPECIFIC);
    L5:
        VFSFile r100 = this.f217994c;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    public h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f217993b = r100;
        this.f217995d = ((Boolean) new ml5.b("debug_config").a("offline_disable_specific_res", Boolean.FALSE)).booleanValue();
    }
}
