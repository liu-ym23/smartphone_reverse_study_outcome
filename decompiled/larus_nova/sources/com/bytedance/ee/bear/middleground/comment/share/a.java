package com.bytedance.ee.bear.middleground.comment.share;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SharePermissionViewModel f232178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<String> f232179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1<Map<String, SharePermissionViewModel.b>, Unit> f232180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Map<String, SharePermissionViewModel.b> f232181d;

    /* JADX WARN: Multi-variable type inference failed */
    public a(SharePermissionViewModel r100, List<String> r101, Function1<? super Map<String, SharePermissionViewModel.b>, Unit> r102, Map<String, SharePermissionViewModel.b> r103) {
        this.f232178a = r100;
        this.f232179b = r101;
        this.f232180c = r102;
        this.f232181d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        HashMap r101 = (HashMap) r100;
        Map<String, IDocUserPermission> r102 = this.f232178a.f232156f;
        Intrinsics.checkNotNull(r101);
        r102.putAll(r101);
        List<String> r103 = this.f232179b;
        Map<String, SharePermissionViewModel.b> r104 = this.f232181d;
        SharePermissionViewModel r105 = this.f232178a;
        Iterator<T> r106 = r103.iterator();
    L4:
        if (r106.hasNext() == false) goto L15;
        String r107 = (String) r106.next();
        IDocUserPermission r108 = (IDocUserPermission) r101.get(r107);
        if (r108 == null) goto L4;
        r105.getClass();
        if (r108.canRead() == false) goto L10;
    L13:
        boolean r109 = true;
    L14:
        r104.put(r107, new SharePermissionViewModel.b(r109, r105.e()));
        goto L4
    L10:
        if (r108.canPerceive() == true) goto L13;
        r109 = false;
        goto L14
    L15:
        this.f232180c.invoke(this.f232181d);
    }
}
