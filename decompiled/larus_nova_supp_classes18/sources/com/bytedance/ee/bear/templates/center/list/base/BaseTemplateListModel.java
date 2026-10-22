package com.bytedance.ee.bear.templates.center.list.base;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.templates.center.TemplateCenterViewModel;
import com.bytedance.ee.bear.templates.data.TemplateGroupTab;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class BaseTemplateListModel implements p {
    public final FragmentActivity a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ BaseTemplateListModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ long e;

        public a(BaseTemplateListModel r1, String r2, int r3, boolean r4, long r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final Object apply(Object r11) {
            String r12 = (String) r11;
            Intrinsics.checkNotNullParameter(r12, "it");
            String r13 = (String) ((aw4.a) this.a.b.getValue()).get(r12);
            if (r13 != null) goto L5;
            r13 = "";
        L5:
            r r9 = new r(this.b, null, this.c, this.d, this.e, 34, 0);
            return Flowable.just((TemplateGroupTab) this.a.G5(1, r9, false).parse(r13));
        }
    }

    public static final class b<T, R> implements Function {
        public static final b<T, R> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r13) {
            Throwable r6 = (Throwable) r13;
            Intrinsics.checkNotNullParameter(r6, "it");
            return new TemplateGroupTab(1, new ArrayList(), false, false, null, r6, null, 0, false, 476, null);
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ BaseTemplateListModel a;
        public final /* synthetic */ r b;

        public c(BaseTemplateListModel r1, r r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r4) {
            Throwable r5 = (Throwable) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            return this.a.S7(this.b.c, 2, r5);
        }
    }

    public void create() {
    }

    public void destroy() {
    }

    public final TemplateCenterViewModel h() {
        return (TemplateCenterViewModel) this.d.getValue();
    }

    public FragmentActivity getActivity() {
        return this.a;
    }

    public BaseTemplateListModel(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a = r2;
        this.b = LazyKt.lazy(BaseTemplateListModel$cacheService$2.INSTANCE);
        this.c = LazyKt.lazy(BaseTemplateListModel$netService$2.INSTANCE);
        this.d = LazyKt.lazy(new BaseTemplateListModel$templateCenViewModel$2(this));
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.p
    public boolean L5(int r3) {
        if (r3 == 2) goto L5;
        return false;
    L5:
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("spacekit.mobile.template_docx", false) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final Flowable<TemplateGroupTab> o(r r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        NetService.c<TemplateGroupTab> r0 = G5(2, r3, true);
        return ((NetService) this.c.getValue()).Vc(r0).a(R3(r3)).onErrorReturn(new c(this, r3));
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.p
    public final Flowable t1(int r12) {
        Intrinsics.checkNotNullParameter("", "lastIndex");
        if ("".length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        String r1 = "0";
    L9:
        String r2 = getCacheKey() + '_' + r1 + '_' + r12;
        return Flowable.concat(k(r2, r12, -1, false), o(new r(r2, "", r12, false, 0, 56, 0))).observeOn(fo5.d.d());
    L8:
        r1 = "";
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.p
    public TemplateGroupTab S7(int r13, int r14, Throwable r15) {
        return new TemplateGroupTab(r14, new ArrayList(), false, false, null, r15, null, 0, false, 468, null);
    }

    @Override // com.bytedance.ee.bear.templates.center.list.base.p
    public Flowable<TemplateGroupTab> N7(String r1, int r2, long r3, int r5) {
        Intrinsics.checkNotNullParameter(r1, "lastIndex");
        return Flowable.just(S7(r2, 2, null));
    }

    public final Flowable<TemplateGroupTab> k(String r10, int r11, long r12, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "cacheKey");
        return Flowable.just(r10).observeOn(fo5.d.b()).flatMap(new a(this, r10, r11, r14, r12)).onErrorReturn(b.a);
    }
}
