package com.ss.android.lark.filedetail.impl.open;

import android.content.Context;
import com.ss.android.lark.filedetail.FileDetailModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hfb.b f421836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final hfb.b.InterfaceC6140b f421837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.filedetail.impl.detail.menu.d f421838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OpenFileInfo f421839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f421840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f421841f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f421842g;

    public j(Context r100, OpenFileInfo r101) {
        com.ss.android.lark.storage.a r102 = FileDetailModule.f421460a;
        hfb.b r103 = FileDetailModule.a.a();
        this.f421836a = r103;
        this.f421837b = r103.getAuditDependency();
        this.f421842g = false;
        this.f421840e = r100;
        this.f421839d = r101;
        this.f421841f = true;
        if (r101.isFromFolderManage == false) goto L5;
        hfb.b.d r104 = com.ss.android.lark.filedetail.impl.detail.menu.a.f421619a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f421838c = new com.ss.android.lark.filedetail.impl.detail.menu.b(r101, r100);
        return;
    L5:
        hfb.b.d r105 = com.ss.android.lark.filedetail.impl.detail.menu.a.f421619a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f421838c = new com.ss.android.lark.filedetail.impl.detail.menu.c(r101, r100);
    }
}
