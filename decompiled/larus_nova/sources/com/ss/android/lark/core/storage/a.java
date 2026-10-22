package com.ss.android.lark.core.storage;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.dirs.h;
import com.suite.lark.platform.component.storage.file.dirs.l;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f419522a = false;

    static {
        f419522a = FeatureGatingModule.getFeatureGatingService().isEnable("im.messager.unistore.file.core_hz");
    }

    @JvmStatic
    public static final VFSPath a() {
        int r100 = h.f460642c;
        h r101 = h.a.a(com.larksuite.framework.utils.b.f285948a);
        r101.c(c());
        com.suite.lark.platform.component.storage.file.dirs.e r102 = new com.suite.lark.platform.component.storage.file.dirs.e();
        Intrinsics.checkNotNullParameter(r102, "pathProvider");
        return r101.a(r102).a();
    }

    @JvmStatic
    public static final VFSPath b() {
        int r100 = h.f460642c;
        h r101 = h.a.a(com.larksuite.framework.utils.b.f285948a);
        r101.c(c());
        l r102 = new l();
        Intrinsics.checkNotNullParameter(r102, "pathProvider");
        return r101.a(r102).a();
    }

    @JvmStatic
    public static final com.ss.android.lark.vfs.h c() {
        VFSFiles r100 = VFSFiles.f444819b;
        boolean r101 = f419522a;
        r100.getClass();
        return VFSFiles.b(r101);
    }
}
