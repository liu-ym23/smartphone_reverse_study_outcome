package wj5;

import android.text.TextUtils;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.DocObjInfo;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import io.reactivex.Flowable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends com.bytedance.ee.bear.more.protocol3.extension.u<oj5.a> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BearUrl f559985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final oj5.a f559986d;

    /* JADX INFO: renamed from: wj5.a$a, reason: collision with other inner class name */
    public static final class C8121a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.extension.u
    public final void a() {
        tt5.a.h("DocMoreInfoBehavior", "create.");
        e(this.f559986d);
        if (TextUtils.isEmpty(this.f559985c.f222572m) == false) goto L8;
        if (sbb.g.b(this.f559985c.a()) == false) goto L8;
        BearUrl r100 = this.f559985c;
    L12:
        int r101 = r100.a();
        String r102 = r100.f222561b;
        String r103 = this.f559985c.f222561b;
        if (r101 != 16) goto L15;
        boolean r104 = true;
    L16:
        Flowable<DocMetaInfo> r105 = ((com.bytedance.ee.bear.d) org.koin.java.a.c(com.bytedance.ee.bear.d.class, null, null, 6)).b(r102, r101);
        Flowable<DocObjInfo> r106 = ((com.bytedance.ee.bear.d) org.koin.java.a.c(com.bytedance.ee.bear.d.class, null, null, 6)).e(r102, r101);
        Flowable<DocPermission> r107 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().a(r102, r101);
        Flowable<DocVersion> r108 = ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).g(r102, r101);
        rc5.a r109 = (rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6);
        if (r104 == false) goto L19;
        String r110 = r102;
    L20:
        Flowable<Boolean> r111 = r109.S(r110);
        b(r105.subscribe(new c(this), d.f559989a));
        b(r106.subscribe(new e(this), f.f559991a));
        b(r107.subscribe(new g(this), h.f559993a));
        b(r108.subscribe(new i(this), j.f559995a));
        b(r111.observeOn(fo5.d.d()).subscribe(new k(this, r104, r102, r103, r101), b.f559987a));
        return;
    L19:
        r110 = r103;
        goto L20
    L15:
        r104 = false;
    L8:
        if (TextUtils.isEmpty(this.f559985c.f222572m) == true) goto L10;
        String r112 = this.f559985c.f222572m;
    L11:
        r100 = s45.p.a().Z(r112);
        goto L12
    L10:
        r112 = this.f559985c.f222564e;
        goto L11
    }

    public a(BearUrl r100, oj5.a r101) {
        Intrinsics.checkNotNullParameter(r100, "bearUrl");
        Intrinsics.checkNotNullParameter(r101, "initState");
        this.f559985c = r100;
        this.f559986d = r101;
    }
}
