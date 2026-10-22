package com.bytedance.ee.bear.fileselector;

import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.bytedance.ee.bear.fileselector.bean.FileBean;
import com.bytedance.ee.util.io.FileUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class f implements itb.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileSelectConfig f226792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ itb.g f226793b;

    @Override // itb.f
    public final void onCancel() {
        g r100 = g.f226794a;
        FileSelectConfig r101 = this.f226792a;
        r100.getClass();
        g.b(r101);
    }

    @Override // itb.f
    public final void onError(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        tt5.a.k("OfficeMediaFileSelector", "selectFile failed: ".concat(r100));
        g r101 = g.f226794a;
        FileSelectConfig r102 = this.f226792a;
        r101.getClass();
        g.b(r102);
    }

    @Override // itb.f
    public final void onSuccess(List<String> r110) {
        Intrinsics.checkNotNullParameter(r110, "filePaths");
        za5.a r100 = this.f226792a.fileSelectListener;
        if (r100 == null) goto L25;
        g r101 = g.f226794a;
        boolean r102 = this.f226793b.f495761f;
        r101.getClass();
        ArrayList r103 = new ArrayList();
        Iterator<T> r111 = r110.iterator();
        int r104 = 0;
    L6:
        if (r111.hasNext() == false) goto L24;
        Object r105 = r111.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        String r107 = (String) r105;
        if (r107.length() != 0) goto L13;
        boolean r108 = true;
    L14:
        if (r108 == false) goto L16;
        tt5.a.k("OfficeMediaFileSelector", "buildFileBeans skip empty path");
        FileBean r109 = null;
    L21:
        if (r109 == null) goto L23;
        r103.add(r109);
    L23:
        r104 = r106;
        goto L6
    L16:
        PolarisFileWrapper r112 = new PolarisFileWrapper(r107);
        FileBean r113 = new FileBean();
        r113.setId(r104);
        r113.position = r104;
        r113.setPath(r107);
        r113.setMimeType(FileUtils.D(r107));
        if (r112.exists() == false) goto L19;
        long r114 = r112.length();
    L20:
        r113.setSize(r114);
        r113.setOrigin(r102);
        r109 = r113;
        goto L21
    L19:
        r114 = 0;
        goto L20
    L13:
        r108 = false;
        goto L14
    L24:
        r100.c(r103);
    L25:
        g r115 = g.f226794a;
        FileSelectConfig r116 = this.f226792a;
        r115.getClass();
        bb5.h r117 = r116.onDismissListener;
        if (r117 == null) goto L32;
        r117.onDismiss();
        return;
    }

    public f(FileSelectConfig r100, itb.g r101) {
        this.f226792a = r100;
        this.f226793b = r101;
    }
}
