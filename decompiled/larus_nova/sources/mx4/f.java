package mx4;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Integer> f516220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<b> f516221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final mx4.g f516222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final mx4.h f516223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f516224e;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f516225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f516226b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Document f516227c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f516225a == r101.f516225a) goto L12;
            return false;
        L12:
            if (this.f516226b == r101.f516226b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f516227c, r101.f516227c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f516225a * 31) + this.f516226b) * 31;
            Document r101 = this.f516227c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "CurrentDoc(total=" + this.f516225a + ", current=" + this.f516226b + ", document=" + this.f516227c + ')';
        }

        public b(int r100, int r101, Document r102) {
            this.f516225a = r100;
            this.f516226b = r101;
            this.f516227c = r102;
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f516228a;

        public c(f r100) {
            this.f516228a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            DocumentListInfo r101 = (DocumentListInfo) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            f.a(this.f516228a, r101);
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f516229a;

        public d(f r100) {
            this.f516229a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Unit r101 = (Unit) r100;
            if (this.f516229a.b() == true) goto L6;
            UDToast.a r102 = UDToast.build(eu5.b.f474075a);
            r102.g("没有下一篇文档啦~");
            r102.f285429b.f417630d = -1;
            r102.h();
            return;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e<T> f516230a = null;

        static {
            f516230a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.e("DocAutoTestViewModel", "req.loadmore err", (Throwable) r100, false);
        }
    }

    /* JADX INFO: renamed from: mx4.f$f, reason: collision with other inner class name */
    public static final class C6870f<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f516231a;

        public C6870f(f r100) {
            this.f516231a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            DocumentListInfo r101 = (DocumentListInfo) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            f.a(this.f516231a, r101);
            return Unit.INSTANCE;
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f516232a;

        public g(f r100) {
            this.f516232a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Unit r101 = (Unit) r100;
            if (this.f516232a.b() == true) goto L6;
            UDToast.a r102 = UDToast.build(eu5.b.f474075a);
            r102.g("没有下一篇文档啦~");
            r102.f285429b.f417630d = -1;
            r102.h();
            return;
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h<T> f516233a = null;

        static {
            f516233a = new h();
        }

        public h() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.e("DocAutoTestViewModel", "req.pull err", (Throwable) r100, false);
        }
    }

    static {
    }

    public final boolean b() {
        mx4.g r100 = this.f516222c;
        if ((r100.f516234a + 1) < r100.f516235b.size()) goto L5;
        boolean r101 = false;
    L6:
        if (r101 == false) goto L21;
        mx4.g r102 = this.f516222c;
        Document r103 = null;
        if (r102.f516235b.size() == 0) goto L18;
        int r104 = r102.f516234a;
        if (r104 >= 0) goto L13;
        r102.f516234a = 0;
    L15:
        if (r102.f516234a >= r102.f516235b.size()) goto L18;
        r103 = (Document) ListProtector.get(r102.f516235b, r102.f516234a);
        goto L18
    L13:
        r102.f516234a = r104 + 1;
    L18:
        if (r103 == null) goto L21;
        this.f516221b.setValue(new b(this.f516222c.f516235b.size(), this.f516222c.f516234a, r103));
        return true;
    L21:
        return false;
    L5:
        r101 = true;
        goto L6
    }

    public f() {
        this.f516220a = CollectionsKt.mutableListOf(new Integer[]{Integer.valueOf(sbb.e.f541296g.f541317b), Integer.valueOf(sbb.e.f541297h.f541317b)});
        MutableLiveData<b> r100 = new MutableLiveData();
        this.f516221b = r100;
        this.f516222c = new mx4.g();
        this.f516223d = new mx4.h();
        this.f516224e = new CompositeDisposable();
        r100.setValue(new b(0, 0, null));
    }

    public final void c() {
        if (b() == false) goto L5;
        return;
    L5:
        tt5.a.h("DocAutoTestViewModel", "openNext fail. request data. ");
        if (this.f516222c.f516239f == false) goto L12;
        tt5.a.h("DocAutoTestViewModel", "openNext. loadmore. ");
        CompositeDisposable r100 = this.f516224e;
        mx4.h r101 = this.f516223d;
        mx4.g r102 = this.f516222c;
        String r103 = r102.f516238e;
        String r104 = r102.f516237d;
        String r105 = r102.f516236c;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r103, "checkId");
        Intrinsics.checkNotNullParameter(r104, "nextId");
        Intrinsics.checkNotNullParameter(r105, "lastLabel");
        NetService.f r106 = r101.f516242c;
        if (r106 != null) goto L10;
        Flowable r107 = Flowable.error(new Throwable("lastRequest is null. "));
    L11:
        r100.add(r107.map(new c(this)).subscribe(new d(this), e.f516230a));
        return;
    L10:
        Intrinsics.checkNotNull(r106);
        r106.b(ComplianceConstants.ComplianceRequest.CHECK_ID, r103);
        NetService.f r108 = r101.f516242c;
        Intrinsics.checkNotNull(r108);
        r108.b(ComplianceConstants.ComplianceRequest.CHECK_ID, r103);
        NetService.f r109 = r101.f516242c;
        Intrinsics.checkNotNull(r109);
        r109.b("last_label", r105);
        r107 = r101.f516241b.a(r101.f516242c);
        goto L11
    L12:
        tt5.a.h("DocAutoTestViewModel", "openNext. init pull. ");
        String r110 = (String) new ml5.b("debug_config").a("folder_token", "");
        CompositeDisposable r111 = this.f516224e;
        mx4.h r112 = this.f516223d;
        r112.getClass();
        if (TextUtils.isEmpty(r110) == false) goto L15;
        NetService.f r113 = new NetService.f("/api/explorer/my/object/list/");
        r113.b("need_total", "1");
        r113.b("length", "100");
    L16:
        r112.f516242c = r113;
        r111.add(r112.f516241b.a(r113).map(new C6870f(this)).subscribe(new g(this), h.f516233a));
        return;
    L15:
        Intrinsics.checkNotNull(r110);
        NetService.f r114 = new NetService.f("/api/explorer/folder/children/");
        r114.b("need_path", "1");
        r114.b("token", r110);
        r114.b("need_total", "1");
        r114.b("length", "100");
        r113 = r114;
        goto L16
    }

    public static final void a(f r100, DocumentListInfo r101) {
        r100.getClass();
        ArrayList<Document> r102 = r101.getDocumentList();
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        Object r105 = r104.next();
        if (r100.f516220a.contains(Integer.valueOf(((Document) r105).getType())) == false) goto L4;
        r103.add(r105);
        goto L4
    L8:
        r100.f516222c.f516235b.addAll(r103);
        mx4.g r106 = r100.f516222c;
        String r107 = r101.getLastLabel();
        String r108 = "";
        if (r107 != null) goto L11;
        r107 = "";
    L11:
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r106.f516236c = r107;
        mx4.g r109 = r100.f516222c;
        String r110 = r101.getNextId();
        if (r110 != null) goto L14;
        r110 = "";
    L14:
        r109.getClass();
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r109.f516237d = r110;
        mx4.g r111 = r100.f516222c;
        String r112 = r101.getCheckId();
        if (r112 == null) goto L18;
        r108 = r112;
    L18:
        r111.getClass();
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r111.f516238e = r108;
        mx4.g r113 = r100.f516222c;
        r113.f516239f = r101.isHasMore();
    }
}
