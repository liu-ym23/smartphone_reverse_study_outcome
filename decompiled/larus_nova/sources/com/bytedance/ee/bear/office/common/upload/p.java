package com.bytedance.ee.bear.office.common.upload;

import com.bytedance.ee.bear.office.export.space.OfficeSpaceUploadSelection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class p extends za5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f235411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<List<OfficeSpaceUploadSelection>, Unit> f235412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f235413c;

    @Override // za5.b, za5.a
    public final void b() {
        tt5.a.h("OfficeUploadFileSelector", "file picker canceled");
        this.f235413c.invoke();
    }

    @Override // za5.b, za5.a
    public final void a(List<String> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "filePointerList");
        List r102 = CollectionsKt.distinct(r100);
        StringBuilder r103 = new StringBuilder("file picker selected, count=");
        r103.append(r102.size());
        r103.append(", isFileUseUri=");
        r103.append(r101);
        r103.append(", firstPointer=");
        o r104 = this.f235411a;
        String r105 = (String) CollectionsKt.firstOrNull(r102);
        r104.getClass();
        r103.append(o.d(r105));
        tt5.a.h("OfficeUploadFileSelector", r103.toString());
        Function1<List<OfficeSpaceUploadSelection>, Unit> r106 = this.f235412b;
        List r107 = r102;
        o r108 = this.f235411a;
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator r110 = r107.iterator();
    L4:
        if (r110.hasNext() == false) goto L6;
        r109.add(o.a(r108, (String) r110.next(), r101, null));
        goto L4
    L6:
        r106.invoke(r109);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p(o r100, Function1<? super List<OfficeSpaceUploadSelection>, Unit> r101, Function0<Unit> r102) {
        this.f235411a = r100;
        this.f235412b = r101;
        this.f235413c = r102;
    }
}
