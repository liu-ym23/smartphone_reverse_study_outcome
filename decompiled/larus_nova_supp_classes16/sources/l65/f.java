package l65;

import com.bytedance.ee.bear.drive.biz.preview.vc.connector.AbsFollowableContentProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f {
    public final i a;
    public final int b;
    public final AbsFollowableContentProvider c;
    public final List<e> d;
    public e e;
    public e f;

    public static final class a {
    }

    static {
    }

    public final <E extends com.bytedance.ee.bear.drive.biz.preview.vc.connector.e> E a(Class<E> r4) {
        AbsFollowableContentProvider r0 = this.c;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "clazz");
        Iterator r1 = ((ArrayList) r0.b).iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        E r2 = (E) r1.next();
        if (Intrinsics.areEqual(r2.getClass(), r4) == false) goto L4;
        return r2;
    L8:
        return null;
    }

    public f(i r3, int r4, boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "vcFollowManager");
        CopyOnWriteArrayList r0 = new CopyOnWriteArrayList();
        this.d = r0;
        this.a = r3;
        this.b = r4;
        int r7 = com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.a;
        if (com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.C0037a.a(r4) == true) goto L5;
        AbsFollowableContentProvider r8 = new com.bytedance.ee.bear.drive.biz.preview.vc.connector.c(this, r5, r6);
    L8:
        this.c = r8;
        tt5.a.h("CCMFollow_DriveFollowableContentManager", "init -> bizType= " + r4 + ", isBlockPreview= " + r5 + ", followableContentProvider= " + r8.getClass().getSimpleName());
        if (com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.C0037a.a(r4) == true) goto L11;
        r0.add(new e("pdf", r8));
        r0.add(new e("DocComment", r8));
        return;
    L11:
        if (r5 == false) goto L13;
        r0.add(new e("DocxBoxPreview", r8));
        return;
    L13:
        tt5.a.h("CCMFollow_DriveFollowableContentManager", "initDelegate current is not block preview, run dynamic register");
        return;
    L5:
        if (r5 == true) goto L7;
        r8 = new com.bytedance.ee.bear.drive.biz.preview.vc.connector.a(this, r5, r6);
        goto L8
    L7:
        r8 = new com.bytedance.ee.bear.drive.biz.preview.vc.connector.b(this, r5, r6);
        goto L8
    }
}
