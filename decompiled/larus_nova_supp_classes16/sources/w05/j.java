package w05;

import android.os.Parcelable;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.DocObjInfo;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.documentinfo.DocumentInfo;
import com.bytedance.ee.bear.document.q4;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.permission.doc.EditionUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IEditionUserPermission;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import jg5.k;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j implements i {
    public final MutableLiveData<DocumentInfo> a;
    public final MutableLiveData<DocPermission> b;
    public final MutableLiveData<DocumentInfo> c;
    public final MutableLiveData<EditionUserPermission> d;
    public final MutableLiveData<String> e;
    public final MutableLiveData<Throwable> f;
    public final MutableLiveData<BenefitStore> g;
    public Disposable h;
    public Boolean i;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ j a;

        public b(j r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            DocPermission r3 = (DocPermission) r2;
            if (r3 == null) goto L6;
            this.a.b.setValue(r3);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            tt5.a.d("DocumentInfoProviderImpl", "requestDocPermission eror");
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ j b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ String g;

        public d(String r1, j r2, String r3, int r4, boolean r5, boolean r6, String r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }

        public final void accept(Object r16) {
            DocumentInfo r17 = (DocumentInfo) r16;
            Intrinsics.checkNotNullParameter(r17, "documentInfo");
            tt5.a.h("DocumentInfoProviderImpl", "fetchDocumentInfo: onSuccess");
            if (TextUtils.isEmpty(this.a) == true) goto L5;
            r17.setSpaceId(String.valueOf(this.a));
        L5:
            j r1 = this.b;
            String r3 = r17.getTitle();
            r1.getClass();
            Intrinsics.checkNotNullParameter(r3, "docName");
            r1.e.setValue(r3);
            j r2 = this.b;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r17, "documentInfo");
            r2.a.setValue(r17);
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            if (jg5.e.a.a.g() == false) goto L8;
            int r0 = f35.b.a;
            f35.b.c(r17, "VIEW", BizDomain.FileBizDomainCCM);
        L9:
            String r9 = r17.getDocPermission().a.getReportJson();
            String r10 = r17.getDocPermission().b.getReportJson();
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).j0();
            k.a.a.e(this.c, this.d, "", this.e, r9, r10, this.f, "", "");
            j r4 = this.b;
            String r5 = this.g;
            r4.getClass();
            if (ForsetiHelper.u() == false) goto L19;
            String r6 = r17.getTitle();
            if (r6.length() != 0) goto L14;
            boolean r7 = true;
        L15:
            if (r7 == false) goto L17;
            r6 = sbb.e.a(eu5.b.a, r17.getType());
        L17:
            int r8 = com.bytedance.ee.bear.route.c.a;
            String r11 = com.bytedance.ee.bear.route.c.f(p.a().Z(r5));
            tt5.a.h("DocumentInfoProviderImpl", "requestDocumentInfo: token:" + du5.b.k(r11) + " originUrl:" + du5.b.k(r5));
            ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).Y3(com.bytedance.ee.bear.route.c.c(r11, r5, r6, r17.getIconInfo()));
            return;
        L14:
            r7 = false;
            goto L15
        L19:
            return;
        L8:
            this.b.i = Boolean.valueOf(r17.canRead());
            goto L9
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ j a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        public e(j r1, String r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r57) {
            Throwable r1 = (Throwable) r57;
            Intrinsics.checkNotNullParameter(r1, "throwable");
            tt5.a.d("DocumentInfoProviderImpl", "fetchDocumentInfo: onFailure" + r1);
            j r2 = this.a;
            r2.f.setValue(r1);
            r2.f.setValue(null);
            if ((r1 instanceof NetService.ServerErrorException) == false) goto L8;
            if (((NetService.ServerErrorException) r1).getCode() != 4) goto L8;
            this.a.i = Boolean.FALSE;
        L8:
            if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L15;
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            if (jg5.e.a.a.f() == false) goto L16;
            j r3 = this.a;
            String r9 = this.b;
            int r10 = this.c;
            r3.getClass();
            Intrinsics.checkNotNullParameter(r9, "objToken");
            if (r3.c.getValue() != null) goto L17;
            DocumentInfo r4 = new DocumentInfo(new DocMetaInfo(null, false, null, null, null, null, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -1, 63, null), new DocPermission(null, 3), new DocVersion(0, 1, null), null, r9, r10, null, 72, null);
            r4.setOfflineInfo(true);
            r3.c.setValue(r4);
            return;
        L17:
            return;
        L16:
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ j a;

        public f(j r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            EditionUserPermission r3 = (IEditionUserPermission) r2;
            if (r3 == null) goto L6;
            this.a.d.setValue(r3);
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public static final g<T> a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            tt5.a.d("DocumentInfoProviderImpl", "requestDocPermission eror");
        }
    }

    static {
    }

    public j() {
        this.a = new MutableLiveData();
        this.b = new MutableLiveData();
        this.c = new MutableLiveData();
        this.d = new MutableLiveData();
        this.e = new MutableLiveData();
        this.f = new MutableLiveData();
        this.g = new MutableLiveData(new BenefitStore("", MapsKt.emptyMap(), "", null, false, 24, null));
    }

    @Override // w05.i
    public final Boolean a() {
        return this.i;
    }

    @Override // w05.i
    public final MutableLiveData<Throwable> b() {
        return this.f;
    }

    @Override // w05.i
    public final MutableLiveData<DocPermission> c() {
        return this.b;
    }

    @Override // w05.i
    public final MutableLiveData<BenefitStore> f() {
        return this.g;
    }

    @Override // w05.i
    public final MutableLiveData<DocumentInfo> g() {
        return this.a;
    }

    @Override // w05.i
    public final MutableLiveData<DocumentInfo> h() {
        return this.c;
    }

    @Override // w05.i
    public final MutableLiveData<DocumentInfo> j() {
        return this.a;
    }

    @Override // w05.i
    public final MutableLiveData<DocumentInfo> k() {
        return this.c;
    }

    @Override // w05.i
    public final MutableLiveData<EditionUserPermission> l() {
        return this.d;
    }

    @Override // w05.i
    public final void i(String r4) {
        Intrinsics.checkNotNullParameter(r4, "objToken");
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().a(r4, sbb.e.o.b).subscribeOn(fo5.d.e()).observeOn(fo5.d.d()).subscribe(new b(this), c.a);
    }

    @Override // w05.i
    public final void e(String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "objToken");
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().getClass();
        wh5.d r0 = new wh5.d();
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        Intrinsics.checkNotNullParameter(r4, "token");
        Flowable.create(new wh5.g(r4, r5, r0), BackpressureStrategy.BUFFER).subscribeOn(fo5.d.e()).observeOn(fo5.d.d()).subscribe(new f(this), g.a);
    }

    @Override // w05.i
    public final void d(String r20, String r21, String r22, String r23, boolean r24, boolean r26, boolean r27) {
        String r0 = r20;
        Intrinsics.checkNotNullParameter(r23, "objToken");
        if (TextUtils.isEmpty(r20) == false) goto L7;
        tt5.a.d("DocumentInfoProviderImpl", "requestDocPermission : url is empty");
        return;
    L7:
        if (r21 != null) goto L9;
        String r7 = "";
    L11:
        if (p.a().v6(r0) == true) goto L13;
        tt5.a.d("DocumentInfoProviderImpl", "requestDocPermission : url illegal , url = " + du5.b.g(r20));
        return;
    L13:
        if (TextUtils.isEmpty(r20) == true) goto L15;
        int r5 = sbb.e.g(p.a().Z(r0).a);
    L16:
        int r10 = r5;
        if (lbb.a.a(r23) == false) goto L19;
        tt5.a.d("DocumentInfoProviderImpl", "requestDocPermission : url illegal , url = " + du5.b.g(r20));
        return;
    L19:
        tt5.a.h("DocumentInfoProviderImpl", "requestDocPermission()... type = " + r10 + "，objToken = " + du5.b.g(r23) + ", checkWiki = " + r27);
        if (r0 != null) goto L22;
        r0 = "";
    L22:
        int r3 = h.a;
        Intrinsics.checkNotNullParameter(r23, "objToken");
        Intrinsics.checkNotNullParameter(r0, "url");
        Intrinsics.checkNotNullParameter(r7, "originUrl");
        BearUrl r2 = p.a().Z(r7);
        String r4 = r2.b;
        Parcelable.Creator r6 = Document.CREATOR;
        if (lbb.a.a(r4) == false) goto L25;
        String r8 = r23;
    L27:
        if (lbb.a.a(r2.b) == false) goto L29;
        int r13 = r10;
    L30:
        Flowable r1 = Flowable.zip(t05.a.a(r23, r10), ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().a(r23, r10), ((w05.d) LarkContext.spiByDwarf(w05.d.class)).a(r23), new w05.g(r0, r23, r10));
        Flowable<DocObjInfo> r9 = u05.a.a(new q4(r8, r13, false, true, true, true, "obj_detail"), r27);
        tt5.a.h("DocumentInfoFetcher", "fetchDocumentInfo. type: " + r10 + ", objToken: " + du5.b.g(r23) + ", originToken: " + du5.b.g(r8) + ", checkWiki: " + r27);
        this.h = Flowable.zip(r1, r9, w05.f.a).observeOn(fo5.d.d()).subscribe(new d(r22, this, r23, r10, r26, r24, r7), new e(this, r23, r10));
        return;
    L29:
        r13 = sbb.e.e(r2.a).b;
        goto L30
    L25:
        r8 = r2.b;
        goto L27
    L15:
        r5 = sbb.e.g.b;
        goto L16
    L9:
        r7 = r21;
        goto L11
    }
}
