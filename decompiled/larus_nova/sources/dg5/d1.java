package dg5;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Stage;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageConfig;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageResultBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Triple;

/* JADX INFO: loaded from: classes18.dex */
public final class d1 extends gn4.a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static volatile long f468429r;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.ee.bear.middleground.feed.export.bean.g f468430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.ee.bear.middleground.feed.export.bean.i f468431d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MessageConfig f468432e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<Triple<List<MultiBean>, String, Boolean>> f468433f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData<Integer> f468434g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData<Boolean> f468435h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f468436i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f468437j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public MutableLiveData<Triple<String, List<MultiBean>, MessageResultBean>> f468438k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public MessageResultBean f468439l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Disposable f468440m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Disposable f468441n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final uf5.o f468442o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final MutableLiveData<Boolean> f468443p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f468444q;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f468445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f468446b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f468447c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f468448d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f468449e;

        public a(String r100, String r101, String r102, String r103, boolean r104) {
            this.f468445a = null;
            this.f468446b = null;
            this.f468447c = null;
            this.f468448d = null;
            this.f468449e = false;
            this.f468445a = r100;
            this.f468446b = r101;
            this.f468447c = r102;
            this.f468448d = r103;
            this.f468449e = r104;
        }
    }

    public final String e() {
        AccountService$Account r100 = ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class)).G2();
        if (r100 == null) goto L7;
        String r101 = r100.uid;
        if (r101 == null) goto L9;
        return r101;
    L9:
        return "";
    L7:
        return "";
    }

    public final boolean k() {
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("base.message_center.suite") == true) goto L5;
    L9:
        return false;
    L5:
        if (this.f468432e.getDocumentType() != sbb.e.f541298i) goto L9;
        if (this.f468432e.getFilterTimestamp() == null) goto L9;
        return true;
    }

    public final void d(FragmentActivity r100) {
        if (this.f468434g.getValue() != null) goto L5;
        return;
    L5:
        if (this.f468434g.getValue().intValue() != 3) goto L9;
        h(r100);
        tt5.a.h("PanelViewModel", "getDataFromRN");
        tt5.a.b("zxzxxx", "getDataFromRN");
        a(g(this.f468432e.isOwner(), "").subscribeOn(fo5.d.e()).observeOn(fo5.d.d()).subscribe(new o0(), new p0()));
        return;
    }

    public final void f(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L7;
        com.bytedance.ee.bear.middleground.feed.export.bean.i r101 = this.f468431d;
        if (r101 == null) goto L7;
        r101.a(r100);
        return;
    L7:
        tt5.a.d("PanelViewModel", "gotoProfile()... userid is empty or  feedListener is null");
    }

    public final void h(LifecycleOwner r100) {
        tt5.a.h("PanelViewModel", "feed panel start get data...");
        this.f468434g.setValue(1);
        MutableLiveData<Triple<String, List<MultiBean>, MessageResultBean>> r101 = uf5.l0.b().a(this.f468432e.getToken(), this.f468432e.getDocumentType().f541317b, this.f468432e.getFilterTimestamp());
        this.f468438k = r101;
        r101.observe(r100, new s0(this));
    }

    public final void i(final List r110) {
        if (r110.size() != 0) goto L6;
        tt5.a.h("PanelViewModel", "size is 0");
        return;
    L6:
        long r100 = SystemClock.elapsedRealtimeNanos();
        tt5.a.h("PanelViewModel", "readMessages:" + r100);
        if (this.f468439l == null) goto L22;
        tt5.a.h("PanelViewModel", "readMessage messageResultBean != null");
        List<MessageBean> r101 = this.f468439l.getData().getMessage();     // Catch: Exception -> L20
        Iterator r102 = r110.iterator();     // Catch: Exception -> L20
    L11:
        if (r102.hasNext() == false) goto L18;
        String r103 = (String) r102.next();     // Catch: Exception -> L20
        Iterator<MessageBean> r104 = r101.iterator();     // Catch: Exception -> L20
    L14:
        if (r104.hasNext() == false) goto L11;
        MessageBean r105 = r104.next();     // Catch: Exception -> L20
        if (Objects.equals(r103, r105.getMessageId()) == false) goto L14;
        tt5.a.h("PanelViewModel", "local readMessage: " + r103 + " " + r105.getCreateTime());     // Catch: Exception -> L20
        r105.setReadStatus(2);     // Catch: Exception -> L20
        goto L11
    L18:
        tt5.a.h("PanelViewModel", "end readMessages:" + (SystemClock.elapsedRealtimeNanos() - r100));     // Catch: Exception -> L20
        this.f468431d.g(r110);     // Catch: Exception -> L20
        l(this.f468439l);     // Catch: Exception -> L20
    L20:
        e = move-exception;
        tt5.a.f("PanelViewModel", e, false);
    L22:
        uf5.o r106 = this.f468442o;
        final String r107 = this.f468432e.getToken();
        final int r108 = this.f468432e.getDocumentType().f541317b;
        r106.getClass();
        Iterator r109 = r110.iterator();
    L24:
        if (r109.hasNext() == false) goto L26;
        String r111 = (String) r109.next();
        tt5.a.h("BadgeManager", "add read:" + r111);
        ((ConcurrentHashMap) r106.f549919a).put(r111, "");
        goto L24
    L26:
        Flowable.just("").subscribeOn(fo5.d.b()).map(new uf5.i()).map(new uf5.j(r107, r108, r110)).subscribe(new uf5.k(), new uf5.l());
    }

    public final void j(boolean r100) {
        tt5.a.h("PanelViewModel", "setFirstUpdateData:" + r100);
        this.f468444q = r100;
    }

    public final void l(MessageResultBean r100) {
        Flowable<MessageResultBean> r101 = Flowable.just(r100);
        c(this.f468440m);
        Disposable r102 = m(r101);
        this.f468440m = r102;
        a(r102);
    }

    public final Disposable m(Flowable<MessageResultBean> r100) {
        final uf5.l0 r101 = uf5.l0.b();
        final String r102 = this.f468432e.getToken();
        final int r103 = this.f468432e.getDocumentType().f541317b;
        final Long r104 = this.f468432e.getFilterTimestamp();
        r101.getClass();
        return r100.map(new uf5.x(r101, r102, r103, r104)).subscribeOn(fo5.d.a()).subscribe(new uf5.y(), new uf5.z());
    }

    public final Flowable<String> g(boolean r100, String r101) {
        Flowable<String> r102 = ((uf5.q0) this.f468430c).f549925a.h(r100, r101);
        if (r102 != null) goto L6;
        r102 = Flowable.error(new Throwable("comment sdk error, please check it"));
    L6:
        return r102.map(new k0(this));
    }

    /* JADX WARN: Type inference failed for: r9v1, types: [dg5.u0] */
    public d1(com.bytedance.ee.bear.middleground.feed.export.bean.g r100, final com.bytedance.ee.bear.middleground.feed.export.bean.i r101, final MessageConfig r102, LifecycleOwner r103) {
        this.f468433f = new MutableLiveData();
        this.f468434g = new MutableLiveData();
        this.f468435h = new MutableLiveData();
        this.f468436i = false;
        this.f468437j = false;
        this.f468443p = new MutableLiveData();
        this.f468444q = true;
        this.f468430c = r100;
        this.f468431d = r101;
        this.f468432e = r102;
        this.f468442o = new uf5.o();
        bg5.a.p();
        uf5.r r104 = bg5.a.f18946b;
        if (r104 == null) goto L5;
        Boolean.valueOf(r104.f549937k).booleanValue();
    L5:
        com.bytedance.ee.util.ui.m.b(bg5.a.f18956l, 30000);
        bg5.a.a(DocFeed$Value$Stage.CHECK_PERMISSION);
        NetService.e r105 = new NetService.f("/api/message/get_message.v3/");
        r105.f216906c = 1;
        HashMap r106 = new HashMap();
        r106.put("obj_token", this.f468432e.getToken() + "");
        r106.put("obj_type", this.f468432e.getDocumentType().f541317b + "");
        r105.d(r106);
        NetService.d r107 = ((NetService) org.koin.java.a.a(NetService.class)).Vc(new ax4.a());
        if (r107 == null) goto L9;
        a(r107.a(r105).subscribe(new q0(), new r0(this)));
    L9:
        h(r103);
        ?? r108 = new u0(this, r102, r101);
        uf5.q0 r109 = (uf5.q0) r100;
        r109.getClass();
        uf5.p0 r110 = new uf5.p0(r108);
        r109.getClass();
        r109.f549925a.f(r110);
    }
}
