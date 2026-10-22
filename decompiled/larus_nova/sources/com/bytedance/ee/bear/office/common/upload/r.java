package com.bytedance.ee.bear.office.common.upload;

import com.bytedance.ee.bear.fileselector.bean.FileBean;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceUploadSelection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class r extends za5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f235415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<List<OfficeSpaceUploadSelection>, Unit> f235416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f235417c;

    @Override // za5.b, za5.a
    public final void b() {
        tt5.a.h("OfficeUploadFileSelector", "media picker canceled");
        this.f235417c.invoke();
    }

    @Override // za5.b, za5.a
    public final void c(List<? extends FileBean> r100) {
        Intrinsics.checkNotNullParameter(r100, "fileList");
        StringBuilder r101 = new StringBuilder("media picker selected, count=");
        r101.append(r100.size());
        r101.append(", firstPath=");
        o r102 = this.f235415a;
        FileBean r103 = (FileBean) CollectionsKt.firstOrNull(r100);
        if (r103 == null) goto L5;
        String r104 = r103.getPath();
    L6:
        r102.getClass();
        r101.append(o.d(r104));
        tt5.a.h("OfficeUploadFileSelector", r101.toString());
        Function1<List<OfficeSpaceUploadSelection>, Unit> r105 = this.f235416b;
        o r106 = this.f235415a;
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r100.iterator();
    L8:
        if (r108.hasNext() == false) goto L20;
        String r109 = ((FileBean) r108.next()).getPath();
        if (r109 != null) goto L12;
    L17:
        OfficeSpaceUploadSelection r110 = null;
    L18:
        if (r110 == null) goto L8;
        r107.add(r110);
        goto L8
    L12:
        if ((!StringsKt.isBlank(r109)) == true) goto L15;
        r109 = null;
    L15:
        if (r109 == null) goto L17;
        r106.getClass();
        r110 = o.a(r106, r109, false, o.b(r109));
        goto L18
    L20:
        r105.invoke(r107);
        return;
    L5:
        r104 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public r(o r100, Function1<? super List<OfficeSpaceUploadSelection>, Unit> r101, Function0<Unit> r102) {
        this.f235415a = r100;
        this.f235416b = r101;
        this.f235417c = r102;
    }
}
