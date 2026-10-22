package s30;

import com.bytedance.android.live.browser.schema.core.RedirectRuleSettingsHandler;
import com.bytedance.android.live.schema.api.WebcastRedirectReportInfo;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements com.bytedance.android.live.schema.api.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile com.bytedance.android.live.browser.schema.core.c f540423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f540424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.live.browser.schema.core.strategy.d f540425c;

    public static final class a {
    }

    /* JADX INFO: renamed from: s30.b$b, reason: collision with other inner class name */
    public static final class C7561b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebcastRedirectReportInfo f540426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.schema.api.b f540427b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1 f540428c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function3 f540429d;

        public C7561b(WebcastRedirectReportInfo r100, com.bytedance.android.live.schema.api.b r101, Function1 r102, Function3 r103) {
            this.f540426a = r100;
            this.f540427b = r101;
            this.f540428c = r102;
            this.f540429d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f540426a.a("ugsettings_exist", "1");
            com.bytedance.android.live.schema.api.a r101 = new RedirectRuleSettingsHandler((com.bytedance.android.live.browser.schema.core.c) r100, this.f540426a).a(this.f540427b.f100495c);
            if (r101 == null) goto L5;
            this.f540426a.a("get_type", "local");
            this.f540428c.invoke(r101);
            return;
        L5:
            Unit r102 = (Unit) this.f540429d.invoke(1001, "UG Settings exists", Boolean.FALSE);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebcastRedirectReportInfo f540430a;

        public c(WebcastRedirectReportInfo r100) {
            this.f540430a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            WebcastRedirectReportInfo r102 = this.f540430a;
            r102.a("ugsettings_exist", "0");
            r102.a("rule_type", "-1");
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f540431a = null;

        static {
            f540431a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            com.bytedance.android.live.browser.schema.core.c r101 = (com.bytedance.android.live.browser.schema.core.c) r100;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function3 f540432a;

        public e(Function3 r100) {
            this.f540432a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            if ((r101 instanceof TimeoutException) == false) goto L5;
            com.bytedance.android.live.schema.api.utils.a.b("UGSettingsInterceptor", "UG Settings timeout", null);
            this.f540432a.invoke(1001, "UG Settings timeout", Boolean.FALSE);
            return;
        L5:
            String r102 = r101.getMessage();
            String r103 = "UG Settings not exists";
            if (r102 != null) goto L8;
            r102 = "UG Settings not exists";
        L8:
            com.bytedance.android.live.schema.api.utils.a.b("UGSettingsInterceptor", r102, null);
            Function3 r104 = this.f540432a;
            String r105 = r101.getMessage();
            if (r105 == null) goto L12;
            r103 = r105;
        L12:
            r104.invoke(1001, r103, Boolean.FALSE);
        }
    }

    static {
    }

    public b(com.bytedance.android.live.browser.schema.core.strategy.d r100) {
        Intrinsics.checkNotNullParameter(r100, "strategyRegister");
        this.f540425c = r100;
        this.f540424b = new Object();
    }

    @Override // com.bytedance.android.live.schema.api.c
    public final void c(com.bytedance.android.live.schema.api.b r100, WebcastRedirectReportInfo r101, Function1<? super com.bytedance.android.live.schema.api.a, Unit> r102, Function3<? super Integer, ? super String, ? super Boolean, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r101, "reportInfo");
        Intrinsics.checkNotNullParameter(r102, "success");
        Intrinsics.checkNotNullParameter(r103, "fail");
        if (com.bytedance.android.live.core.setting.c.f65267a.getValue().booleanValue() == true) goto L5;
    L8:
        r101.a("schema_source", "ugsettings");
        com.bytedance.android.live.schema.api.utils.a.a("UGSettingsInterceptor", "request ugsettings, key data.common_info.extra.sjb_schema");
        Observable.concat(CollectionsKt.listOf(new Observable[]{Observable.create(new s30.e(this, r101)), Observable.create(new s30.d(this, r101)), Observable.create(new s30.c(this, r101))})).firstOrError().timeout(10, TimeUnit.SECONDS).doOnSuccess(new C7561b(r101, r100, r102, r103)).doOnError(new c(r101)).subscribe(d.f540431a, new e(r103));
        return;
    L5:
        if (Intrinsics.areEqual(r100, com.bytedance.android.live.schema.api.utils.b.f100507a) == false) goto L8;
        r103.invoke(1001, "UG Settings skip", Boolean.FALSE);
        com.bytedance.android.live.schema.api.utils.a.a("UGSettingsInterceptor", "UG Settings skip");
    }
}
