package l65;

import com.bytedance.ee.bear.drive.biz.preview.vc.connector.AbsFollowableContentProvider;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f507708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f507709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbsFollowableContentProvider f507710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<e> f507711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f507712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f507713f;

    public static final class a {
    }

    static {
    }

    public final <E extends com.bytedance.ee.bear.drive.biz.preview.vc.connector.e> E a(Class<E> r100) {
        AbsFollowableContentProvider r101 = this.f507710c;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Iterator r102 = ((ArrayList) r101.f223807b).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        E r103 = (E) r102.next();
        if (Intrinsics.areEqual(r103.getClass(), r100) == false) goto L4;
        return r103;
    L8:
        return null;
    }

    public f(i r100, int r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "vcFollowManager");
        CopyOnWriteArrayList r104 = new CopyOnWriteArrayList();
        this.f507711d = r104;
        this.f507708a = r100;
        this.f507709b = r101;
        int r105 = com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.f217038a;
        if (com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.C3093a.a(r101) == true) goto L5;
        AbsFollowableContentProvider r106 = new com.bytedance.ee.bear.drive.biz.preview.vc.connector.c(this, r102, r103);
    L8:
        this.f507710c = r106;
        tt5.a.h("CCMFollow_DriveFollowableContentManager", "init -> bizType= " + r101 + ", isBlockPreview= " + r102 + ", followableContentProvider= " + r106.getClass().getSimpleName());
        if (com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.C3093a.a(r101) == true) goto L11;
        r104.add(new e(ExportFileExtension.PDF, r106));
        r104.add(new e("DocComment", r106));
        return;
    L11:
        if (r102 == false) goto L13;
        r104.add(new e("DocxBoxPreview", r106));
        return;
    L13:
        tt5.a.h("CCMFollow_DriveFollowableContentManager", "initDelegate current is not block preview, run dynamic register");
        return;
    L5:
        if (r102 == true) goto L7;
        r106 = new com.bytedance.ee.bear.drive.biz.preview.vc.connector.a(this, r102, r103);
        goto L8
    L7:
        r106 = new com.bytedance.ee.bear.drive.biz.preview.vc.connector.b(this, r102, r103);
        goto L8
    }
}
