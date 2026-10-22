package mx4;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.toast.UDToast;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f {
    public final List<Integer> a;
    public final MutableLiveData<b> b;
    public final mx4.g c;
    public final mx4.h d;
    public final CompositeDisposable e;

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final int b;
        public final Document c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a * 31) + this.b) * 31;
            Document r1 = this.c;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "CurrentDoc(total=" + this.a + ", current=" + this.b + ", document=" + this.c + ')';
        }

        public b(int r1, int r2, Document r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ f a;

        public c(f r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            DocumentListInfo r3 = (DocumentListInfo) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            f.a(this.a, r3);
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ f a;

        public d(f r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Unit r5 = (Unit) r4;
            if (this.a.b() == true) goto L6;
            UDToast.a r6 = UDToast.build(eu5.b.a);
            r6.g("没有下一篇文档啦~");
            r6.b.d = -1;
            r6.h();
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public static final e<T> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r4) {
            tt5.a.e("DocAutoTestViewModel", "req.loadmore err", (Throwable) r4, false);
        }
    }

    /* JADX INFO: renamed from: mx4.f$f, reason: collision with other inner class name */
    public static final class C0259f<T, R> implements Function {
        public final /* synthetic */ f a;

        public C0259f(f r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            DocumentListInfo r3 = (DocumentListInfo) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            f.a(this.a, r3);
            return Unit.INSTANCE;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ f a;

        public g(f r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Unit r5 = (Unit) r4;
            if (this.a.b() == true) goto L6;
            UDToast.a r6 = UDToast.build(eu5.b.a);
            r6.g("没有下一篇文档啦~");
            r6.b.d = -1;
            r6.h();
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public static final h<T> a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final void accept(Object r4) {
            tt5.a.e("DocAutoTestViewModel", "req.pull err", (Throwable) r4, false);
        }
    }

    static {
    }

    public final boolean b() {
        mx4.g r0 = this.c;
        if ((r0.a + 1) < r0.b.size()) goto L5;
        boolean r1 = false;
    L6:
        if (r1 == false) goto L21;
        mx4.g r2 = this.c;
        Document r4 = null;
        if (r2.b.size() == 0) goto L18;
        int r3 = r2.a;
        if (r3 >= 0) goto L13;
        r2.a = 0;
    L15:
        if (r2.a >= r2.b.size()) goto L18;
        r4 = (Document) ListProtector.get(r2.b, r2.a);
        goto L18
    L13:
        r2.a = r3 + 1;
    L18:
        if (r4 == null) goto L21;
        this.b.setValue(new b(this.c.b.size(), this.c.a, r4));
        return true;
    L21:
        return false;
    L5:
        r1 = true;
        goto L6
    }

    public f() {
        this.a = CollectionsKt.mutableListOf(new Integer[]{Integer.valueOf(sbb.e.g.b), Integer.valueOf(sbb.e.h.b)});
        MutableLiveData<b> r0 = new MutableLiveData();
        this.b = r0;
        this.c = new mx4.g();
        this.d = new mx4.h();
        this.e = new CompositeDisposable();
        r0.setValue(new b(0, 0, null));
    }

    public final void c() {
        if (b() == false) goto L5;
        return;
    L5:
        tt5.a.h("DocAutoTestViewModel", "openNext fail. request data. ");
        if (this.c.f == false) goto L12;
        tt5.a.h("DocAutoTestViewModel", "openNext. loadmore. ");
        CompositeDisposable r0 = this.e;
        mx4.h r1 = this.d;
        mx4.g r2 = this.c;
        String r3 = r2.e;
        String r4 = r2.d;
        String r5 = r2.c;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "checkId");
        Intrinsics.checkNotNullParameter(r4, "nextId");
        Intrinsics.checkNotNullParameter(r5, "lastLabel");
        NetService.f r6 = r1.c;
        if (r6 != null) goto L10;
        Flowable r7 = Flowable.error(new Throwable("lastRequest is null. "));
    L11:
        r0.add(r7.map(new c(this)).subscribe(new d(this), e.a));
        return;
    L10:
        Intrinsics.checkNotNull(r6);
        r6.b("check_id", r3);
        NetService.f r8 = r1.c;
        Intrinsics.checkNotNull(r8);
        r8.b("check_id", r3);
        NetService.f r9 = r1.c;
        Intrinsics.checkNotNull(r9);
        r9.b("last_label", r5);
        r7 = r1.b.a(r1.c);
        goto L11
    L12:
        tt5.a.h("DocAutoTestViewModel", "openNext. init pull. ");
        String r10 = (String) new ml5.b("debug_config").a("folder_token", "");
        CompositeDisposable r11 = this.e;
        mx4.h r12 = this.d;
        r12.getClass();
        if (TextUtils.isEmpty(r10) == false) goto L15;
        NetService.f r13 = new NetService.f("/api/explorer/my/object/list/");
        r13.b("need_total", DiagramData$RESULT.SUCCESS);
        r13.b("length", "100");
    L16:
        r12.c = r13;
        r11.add(r12.b.a(r13).map(new C0259f(this)).subscribe(new g(this), h.a));
        return;
    L15:
        Intrinsics.checkNotNull(r10);
        NetService.f r14 = new NetService.f("/api/explorer/folder/children/");
        r14.b("need_path", DiagramData$RESULT.SUCCESS);
        r14.b("token", r10);
        r14.b("need_total", DiagramData$RESULT.SUCCESS);
        r14.b("length", "100");
        r13 = r14;
        goto L16
    }

    public static final void a(f r5, DocumentListInfo r6) {
        r5.getClass();
        ArrayList r0 = r6.getDocumentList();
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (r5.a.contains(Integer.valueOf(((Document) r3).getType())) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        r5.c.b.addAll(r1);
        mx4.g r4 = r5.c;
        String r7 = r6.getLastLabel();
        String r8 = "";
        if (r7 != null) goto L11;
        r7 = "";
    L11:
        r4.getClass();
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r4.c = r7;
        mx4.g r9 = r5.c;
        String r10 = r6.getNextId();
        if (r10 != null) goto L14;
        r10 = "";
    L14:
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r9.d = r10;
        mx4.g r11 = r5.c;
        String r12 = r6.getCheckId();
        if (r12 == null) goto L18;
        r8 = r12;
    L18:
        r11.getClass();
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r11.e = r8;
        mx4.g r13 = r5.c;
        r13.f = r6.isHasMore();
    }
}
