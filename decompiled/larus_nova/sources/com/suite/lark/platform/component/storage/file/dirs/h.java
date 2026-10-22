package com.suite.lark.platform.component.storage.file.dirs;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import java.io.File;
import java.util.ArrayList;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f460642c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f460643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.ss.android.lark.vfs.h f460644b;

    public static final class a {
        @JvmStatic
        public static h a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new h(r100);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ss.android.lark.vfs.h f460645a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final VFSPath f460646b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f460647c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final o6c.c f460648d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f460649e;

        public final VFSPath a() {
            String r100 = this.f460648d.toString();
            VFSPath r101 = this.f460646b.subPath(r100);
            String r102 = this.f460647c;
            if (r102 != null) goto L5;
        L7:
            VFSPath r103 = null;
        L8:
            if (r103 != null) goto L14;
            if (this.f460645a.C() == true) goto L24;
            r101 = this.f460645a.z(r101.getRealPath());
        L24:
            if (this.f460649e == false) goto L26;
            com.suite.lark.component.storage.ext.b.d(r101);
        L29:
            return r101;
        L26:
            VFSPath r104 = r101.getParent();
            if (r104 == null) goto L29;
            com.suite.lark.component.storage.ext.b.d(r104);
            goto L29
        L14:
            if (this.f460645a.C() == false) goto L17;
            com.ss.android.lark.storage.file.migration.c.a r105 = new com.ss.android.lark.storage.file.migration.c.a();
            String r106 = r103.getRealPath();
            Intrinsics.checkNotNullParameter(r106, "path");
            ((ArrayList) r105.f440993b).add(r106);
            String r107 = r101.getRealPath();
            Intrinsics.checkNotNullParameter(r107, MapBundleKey.MapObjKey.OBJ_DIR);
            r105.f440994c = r107;
            Intrinsics.checkNotNullParameter(r101.toUri(), "uri");
            com.ss.android.lark.storage.file.migration.d.d(r105.a());
            VFSFiles.f444819b.getClass();
            r101 = VFSFiles.b(true).z(r101.getRealPath());
            goto L24
        L17:
            if (this.f460649e == false) goto L20;
        L22:
            r101 = r103;
            goto L24
        L20:
            if (new PolarisFileWrapper(this.f460646b.getRealPath()).exists() == false) goto L22;
            r101 = this.f460645a.z(r101.getRealPath());
            goto L24
        L5:
            if (TextUtils.isEmpty(r102) == true) goto L7;
            VFSFiles.f444819b.getClass();
            r103 = VFSFiles.b(false).z(r102).subPath(r100);
            goto L8
        }

        public final void b(String r100) {
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L9:
            if (r101 == true) goto L12;
            this.f460648d.a(r100, false);
            this.f460649e = false;
            return;
        L12:
            return;
        L5:
            if (r100.length() == 0) goto L8;
            r101 = false;
            goto L9
        }

        public final void c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "domain");
            this.f460648d.a(r100, false);
        }

        public b(com.ss.android.lark.vfs.h r100, VFSPath r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "vfsFacade");
            Intrinsics.checkNotNullParameter(r101, "newUniPath");
            this.f460645a = r100;
            this.f460646b = r101;
            this.f460647c = r102;
            int r103 = o6c.c.f522230c;
            String r104 = File.separator;
            Intrinsics.checkNotNullParameter(r104, "separator");
            this.f460648d = new o6c.c(r104);
            this.f460649e = true;
        }
    }

    static {
    }

    public h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f460643a = r100;
        this.f460644b = com.ss.android.lark.vfs.d.a();
    }

    public final b a(UniPathProvider r100) {
        VFSPath r101 = r100.d(r100.b());
        String r102 = r100.a(this.f460643a);
        return new b(this.f460644b, r101, r102);
    }

    public final VFSPath b(UniPathProvider r100) {
        Intrinsics.checkNotNullParameter(r100, "pathProvider");
        return a(r100).a();
    }

    public final void c(com.ss.android.lark.vfs.h r100) {
        Intrinsics.checkNotNullParameter(r100, "vfsFacade");
        this.f460644b = r100;
    }
}
