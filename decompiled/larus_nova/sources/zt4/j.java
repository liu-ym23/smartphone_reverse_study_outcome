package zt4;

import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.core.viewmodel.BitableViewModel;
import com.bytedance.ee.bear.bitable.load.BitableSceneType;
import com.bytedance.ee.bear.bitable.statistic.business.openfile.fastadd.BitableOpenFastAddRecordMonitor;
import com.bytedance.ee.bear.contract.NetService;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import se6.u;

/* JADX INFO: loaded from: classes15.dex */
public final class j extends zt4.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f573603e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<JSONObject> f573604f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f573605g;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f573606a;

        public b(j r100) {
            this.f573606a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            BitableViewModel.OriginServerResponse r101 = (BitableViewModel.OriginServerResponse) r100;
            j r102 = this.f573606a;
            r102.getClass();
            tt5.a.h("NetRecordDataLoader", "handlePrefetchEndMonitor");
            if (r102.f573581a.o() != BitableSceneType.ShareRecord) goto L6;
            r102.f573581a.v("POINT_SHARE_RECORD_PREFETCH_END", System.currentTimeMillis());
        L6:
            if (r102.f573581a.o() != BitableSceneType.AddRecord) goto L11;
            String r103 = r102.f573581a.getTraceId();
            if (r103 == null) goto L11;
            BitableOpenFastAddRecordMonitor.c(r103, System.currentTimeMillis(), MapsKt.emptyMap());
        L11:
            if (r101 == null) goto L13;
            String r104 = r101.getData();
        L14:
            if (r104 == null) goto L16;
            j r105 = this.f573606a;
            JSONObject r106 = new JSONObject();
            r106.put2("data", r104);
            j.j(r105, r106);
            return;
        L16:
            j r107 = this.f573606a;
            JSONObject r108 = new JSONObject();
            r108.put2("error", "request record meta receive null value");
            j.j(r107, r108);
            this.f573606a.k("request record meta receive null value", -1);
            return;
        L13:
            r104 = null;
            goto L14
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f573607a;

        public c(j r100) {
            this.f573607a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            tt5.a.e("NetRecordDataLoader", "asyncFetchItemViewMeta failed ", r101, false);
            String r102 = "request record meta occurs exception";
            if ((r101 instanceof NetService.ServerErrorException) == false) goto L9;
            j r103 = this.f573607a;
            JSONObject r104 = new JSONObject();
            NetService.ServerErrorException r105 = (NetService.ServerErrorException) r101;
            r104.put2("code", Integer.valueOf(r105.getCode()));
            String r106 = r105.getMessage();
            if (r106 == null) goto L8;
            r102 = r106;
        L8:
            r104.put2("error", r102);
            j.j(r103, r104);
            this.f573607a.k("request record fail: " + r105.getMsg(), r105.getCode());
            return;
        L9:
            j r107 = this.f573607a;
            JSONObject r108 = new JSONObject();
            String r109 = r101.getMessage();
            if (r109 != null) goto L12;
            r109 = "request record meta occurs exception";
        L12:
            r108.put2("error", r109);
            j.j(r107, r108);
            j r110 = this.f573607a;
            String r111 = r101.getMessage();
            if (r111 == null) goto L16;
            r102 = r111;
        L16:
            r110.k(r102, -1);
        }
    }

    static {
    }

    @Override // zt4.a
    public final boolean f() {
        return true;
    }

    @Override // zt4.a
    public final boolean g() {
        if (this.f573605g.compareAndSet(false, true) == true) goto L6;
        tt5.a.d("NetRecordDataLoader", "loadResourceInMainLoop hasStartFetch");
        return true;
    L6:
        String r100 = this.f573581a.getPluginHost().a().getToken();
        BitableSceneType r101 = this.f573581a.o();
        BitableSceneType r102 = BitableSceneType.ShareRecord;
        if (r101 != r102) goto L10;
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;
        String r104 = String.format("/api/bitable/%s/share/record", Arrays.copyOf(new Object[]{r100}, 1));
    L13:
        tt5.a.h("NetRecordDataLoader", "handlePrefetchStartMonitor");
        if (this.f573581a.o() != r102) goto L17;
        this.f573581a.v("POINT_SHARE_RECORD_PREFETCH_BEGIN", System.currentTimeMillis());
    L17:
        if (this.f573581a.o() != BitableSceneType.AddRecord) goto L22;
        String r105 = this.f573581a.getTraceId();
        if (r105 == null) goto L22;
        BitableOpenFastAddRecordMonitor.a(r105, System.currentTimeMillis());
    L22:
        if (r104 != null) goto L25;
        this.f573605g.set(false);
        tt5.a.d("NetRecordDataLoader", "loadResourceInMainLoop api is null");
        return true;
    L25:
        this.f573603e.add(((NetService) k.a(LarkContext.getApplication(), NetService.class)).Vc(new BitableViewModel.b()).a(new NetService.f(r104)).subscribe(new b(this), new c(this)));
        return true;
    L10:
        if (this.f573581a.o() != BitableSceneType.AddRecord) goto L12;
        StringCompanionObject r106 = StringCompanionObject.INSTANCE;
        r104 = String.format(BitableViewModel.GET_FAST_ADD_RECORD_META_DATA, Arrays.copyOf(new Object[]{r100}, 1));
        goto L13
    L12:
        r104 = null;
        goto L13
    }

    @Override // zt4.a
    public final void i() {
        this.f573603e.clear();
    }

    public j(com.bytedance.ee.bear.bitable.load.e r100, com.bytedance.ee.bear.bitable.load.f r101) {
        Intrinsics.checkNotNullParameter(r100, "loadContext");
        Intrinsics.checkNotNullParameter(r101, "loadControl");
        super(r100, r101);
        this.f573603e = new CompositeDisposable();
        this.f573604f = new MutableLiveData();
        this.f573605g = new AtomicBoolean(false);
    }

    public static final void j(j r100, JSONObject r101) {
        r100.getClass();
        if (u.a() == false) goto L5;
        r100.f573604f.setValue(r101);
        return;
    L5:
        r100.f573604f.postValue(r101);
    }

    public final void k(String r110, int r111) {
        String r100 = this.f573581a.getTraceId();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        tu4.b.i(r100, Long.valueOf(System.currentTimeMillis()), MapsKt.mapOf(new Pair[]{TuplesKt.to("reason", r110), TuplesKt.to("code", Integer.valueOf(r111)), TuplesKt.to("msg", r110)}));
        if (this.f573581a.o() != BitableSceneType.AddRecord) goto L12;
        String r101 = this.f573581a.getTraceId();
        if (r101 != null) goto L10;
        return;
    L10:
        BitableOpenFastAddRecordMonitor.b(r101, System.currentTimeMillis(), MapsKt.mapOf(new Pair[]{TuplesKt.to("reason", r110), TuplesKt.to("code", Integer.valueOf(r111)), TuplesKt.to("msg", r110)}));
        return;
    }
}
