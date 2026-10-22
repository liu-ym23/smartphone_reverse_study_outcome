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
import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import jg5.k;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import s45.p;

/* JADX INFO: loaded from: classes16.dex */
public final class j implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<DocumentInfo> f557790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<DocPermission> f557791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<DocumentInfo> f557792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<EditionUserPermission> f557793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<String> f557794e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<Throwable> f557795f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData<BenefitStore> f557796g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f557797h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Boolean f557798i;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f557799a;

        public b(j r100) {
            this.f557799a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            DocPermission r101 = (DocPermission) r100;
            if (r101 == null) goto L6;
            this.f557799a.f557791b.setValue(r101);
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T> f557800a = null;

        static {
            f557800a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            tt5.a.d("DocumentInfoProviderImpl", "requestDocPermission eror");
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f557801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f557802b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f557803c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f557804d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f557805e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f557806f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f557807g;

        public d(String r100, j r101, String r102, int r103, boolean r104, boolean r105, String r106) {
            this.f557801a = r100;
            this.f557802b = r101;
            this.f557803c = r102;
            this.f557804d = r103;
            this.f557805e = r104;
            this.f557806f = r105;
            this.f557807g = r106;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            DocumentInfo r111 = (DocumentInfo) r110;
            Intrinsics.checkNotNullParameter(r111, "documentInfo");
            tt5.a.h("DocumentInfoProviderImpl", "fetchDocumentInfo: onSuccess");
            if (TextUtils.isEmpty(this.f557801a) == true) goto L5;
            r111.setSpaceId(String.valueOf(this.f557801a));
        L5:
            j r100 = this.f557802b;
            String r101 = r111.getTitle();
            r100.getClass();
            Intrinsics.checkNotNullParameter(r101, "docName");
            r100.f557794e.setValue(r101);
            j r102 = this.f557802b;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r111, "documentInfo");
            r102.f557790a.setValue(r111);
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            if (jg5.e.a.f499003a.g() == false) goto L8;
            int r103 = f35.b.f475390a;
            f35.b.c(r111, "VIEW", BizDomain.FileBizDomainCCM);
        L9:
            String r104 = r111.getDocPermission().f234419a.getReportJson();
            String r112 = r111.getDocPermission().f234420b.getReportJson();
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).j0();
            k.a.f499019a.e(this.f557803c, this.f557804d, "", this.f557805e, r104, r112, this.f557806f, "", "");
            j r105 = this.f557802b;
            String r106 = this.f557807g;
            r105.getClass();
            if (ForsetiHelper.u() == false) goto L19;
            String r107 = r111.getTitle();
            if (r107.length() != 0) goto L14;
            boolean r108 = true;
        L15:
            if (r108 == false) goto L17;
            r107 = sbb.e.a(eu5.b.f474075a, r111.getType());
        L17:
            int r109 = com.bytedance.ee.bear.route.c.f236659a;
            String r113 = com.bytedance.ee.bear.route.c.f(p.a().Z(r106));
            tt5.a.h("DocumentInfoProviderImpl", "requestDocumentInfo: token:" + du5.b.k(r113) + " originUrl:" + du5.b.k(r106));
            ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).Y3(com.bytedance.ee.bear.route.c.c(r113, r106, r107, r111.getIconInfo()));
            return;
        L14:
            r108 = false;
            goto L15
        L19:
            return;
        L8:
            this.f557802b.f557798i = Boolean.valueOf(r111.canRead());
            goto L9
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f557808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f557809b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f557810c;

        public e(j r100, String r101, int r102) {
            this.f557808a = r100;
            this.f557809b = r101;
            this.f557810c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r510) {
            Throwable r100 = (Throwable) r510;
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
            tt5.a.d("DocumentInfoProviderImpl", "fetchDocumentInfo: onFailure" + r100);
            j r101 = this.f557808a;
            r101.f557795f.setValue(r100);
            r101.f557795f.setValue(null);
            if ((r100 instanceof NetService.ServerErrorException) == false) goto L8;
            if (((NetService.ServerErrorException) r100).getCode() != 4) goto L8;
            this.f557808a.f557798i = Boolean.FALSE;
        L8:
            if (com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a() == true) goto L15;
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            if (jg5.e.a.f499003a.f() == false) goto L16;
            j r102 = this.f557808a;
            String r103 = this.f557809b;
            int r110 = this.f557810c;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r103, "objToken");
            if (r102.f557792c.getValue() != null) goto L17;
            DocumentInfo r104 = new DocumentInfo(new DocMetaInfo(null, false, null, null, null, null, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -1, 63, null), new DocPermission(null, 3), new DocVersion(0, 1, null), null, r103, r110, null, 72, null);
            r104.setOfflineInfo(true);
            r102.f557792c.setValue(r104);
            return;
        L17:
            return;
        L16:
            return;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f557811a;

        public f(j r100) {
            this.f557811a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            IEditionUserPermission r101 = (IEditionUserPermission) r100;
            if (r101 == null) goto L6;
            this.f557811a.f557793d.setValue((EditionUserPermission) r101);
            return;
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g<T> f557812a = null;

        static {
            f557812a = new g();
        }

        public g() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            tt5.a.d("DocumentInfoProviderImpl", "requestDocPermission eror");
        }
    }

    static {
    }

    public j() {
        this.f557790a = new MutableLiveData();
        this.f557791b = new MutableLiveData();
        this.f557792c = new MutableLiveData();
        this.f557793d = new MutableLiveData();
        this.f557794e = new MutableLiveData();
        this.f557795f = new MutableLiveData();
        this.f557796g = new MutableLiveData(new BenefitStore("", MapsKt.emptyMap(), "", null, false, 24, null));
    }

    @Override // w05.i
    public final Boolean a() {
        return this.f557798i;
    }

    @Override // w05.i
    public final MutableLiveData<Throwable> b() {
        return this.f557795f;
    }

    @Override // w05.i
    public final MutableLiveData<DocPermission> c() {
        return this.f557791b;
    }

    @Override // w05.i
    public final MutableLiveData<BenefitStore> f() {
        return this.f557796g;
    }

    @Override // w05.i
    public final MutableLiveData<DocumentInfo> g() {
        return this.f557790a;
    }

    @Override // w05.i
    public final MutableLiveData<DocumentInfo> h() {
        return this.f557792c;
    }

    @Override // w05.i
    public final MutableLiveData<DocumentInfo> j() {
        return this.f557790a;
    }

    @Override // w05.i
    public final MutableLiveData<DocumentInfo> k() {
        return this.f557792c;
    }

    @Override // w05.i
    public final MutableLiveData<EditionUserPermission> l() {
        return this.f557793d;
    }

    @Override // w05.i
    public final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "objToken");
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().a(r100, sbb.e.f541304o.f541317b).subscribeOn(fo5.d.e()).observeOn(fo5.d.d()).subscribe(new b(this), c.f557800a);
    }

    @Override // w05.i
    public final void e(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "objToken");
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().getClass();
        wh5.d r102 = new wh5.d();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        Intrinsics.checkNotNullParameter(r100, "token");
        Flowable.create(new wh5.g(r100, r101, r102), BackpressureStrategy.BUFFER).subscribeOn(fo5.d.e()).observeOn(fo5.d.d()).subscribe(new f(this), g.f557812a);
    }

    @Override // w05.i
    public final void d(String r210, String r211, String r212, String r213, boolean r214, boolean r215, boolean r216) {
        String r100 = r210;
        Intrinsics.checkNotNullParameter(r213, "objToken");
        if (TextUtils.isEmpty(r210) == false) goto L7;
        tt5.a.d("DocumentInfoProviderImpl", "requestDocPermission : url is empty");
        return;
    L7:
        if (r211 != null) goto L9;
        String r101 = "";
    L11:
        if (p.a().v6(r100) == true) goto L13;
        tt5.a.d("DocumentInfoProviderImpl", "requestDocPermission : url illegal , url = " + du5.b.g(r210));
        return;
    L13:
        if (TextUtils.isEmpty(r210) == true) goto L15;
        int r102 = sbb.e.g(p.a().Z(r100).f222560a);
    L16:
        int r110 = r102;
        if (lbb.a.a(r213) == false) goto L19;
        tt5.a.d("DocumentInfoProviderImpl", "requestDocPermission : url illegal , url = " + du5.b.g(r210));
        return;
    L19:
        tt5.a.h("DocumentInfoProviderImpl", "requestDocPermission()... type = " + r110 + "，objToken = " + du5.b.g(r213) + ", checkWiki = " + r216);
        if (r100 != null) goto L22;
        r100 = "";
    L22:
        int r103 = h.f557789a;
        Intrinsics.checkNotNullParameter(r213, "objToken");
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "originUrl");
        BearUrl r104 = p.a().Z(r101);
        String r105 = r104.f222561b;
        Parcelable.Creator<Document> r106 = Document.CREATOR;
        if (lbb.a.a(r105) == false) goto L25;
        String r107 = r213;
    L27:
        if (lbb.a.a(r104.f222561b) == false) goto L29;
        int r111 = r110;
    L30:
        Flowable r108 = Flowable.zip(t05.a.a(r213, r110), ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().a(r213, r110), ((w05.d) LarkContext.spiByDwarf(w05.d.class)).a(r213), new w05.g(r100, r213, r110));
        Flowable<DocObjInfo> r109 = u05.a.a(new q4(r107, r111, false, true, true, true, "obj_detail"), r216);
        tt5.a.h("DocumentInfoFetcher", "fetchDocumentInfo. type: " + r110 + ", objToken: " + du5.b.g(r213) + ", originToken: " + du5.b.g(r107) + ", checkWiki: " + r216);
        this.f557797h = Flowable.zip(r108, r109, w05.f.f557785a).observeOn(fo5.d.d()).subscribe(new d(r212, this, r213, r110, r215, r214, r101), new e(this, r213, r110));
        return;
    L29:
        r111 = sbb.e.e(r104.f222560a).f541317b;
        goto L30
    L25:
        r107 = r104.f222561b;
        goto L27
    L15:
        r102 = sbb.e.f541296g.f541317b;
        goto L16
    L9:
        r101 = r211;
        goto L11
    }
}
