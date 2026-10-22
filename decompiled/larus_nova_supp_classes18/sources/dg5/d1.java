package dg5;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Stage;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageConfig;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageResultBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Triple;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d1 extends gn4.a {
    public static volatile long r;
    public final com.bytedance.ee.bear.middleground.feed.export.bean.g c;
    public final com.bytedance.ee.bear.middleground.feed.export.bean.i d;
    public MessageConfig e;
    public final MutableLiveData<Triple<List<MultiBean>, String, Boolean>> f;
    public final MutableLiveData<Integer> g;
    public final MutableLiveData<Boolean> h;
    public boolean i;
    public boolean j;
    public MutableLiveData<Triple<String, List<MultiBean>, MessageResultBean>> k;
    public MessageResultBean l;
    public Disposable m;
    public Disposable n;
    public final uf5.o o;
    public final MutableLiveData<Boolean> p;
    public boolean q;

    public static class a {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final boolean e;

        public a(String r2, String r3, String r4, String r5, boolean r6) {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = false;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public final String e() {
        AccountService.Account r0 = ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class)).G2();
        if (r0 == null) goto L7;
        String r1 = r0.uid;
        if (r1 == null) goto L9;
        return r1;
    L9:
        return "";
    L7:
        return "";
    }

    public final boolean k() {
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("base.message_center.suite") == true) goto L5;
    L9:
        return false;
    L5:
        if (this.e.getDocumentType() != sbb.e.i) goto L9;
        if (this.e.getFilterTimestamp() == null) goto L9;
        return true;
    }

    public final void d(FragmentActivity r3) {
        if (this.g.getValue() != null) goto L5;
        return;
    L5:
        if (((Integer) this.g.getValue()).intValue() != 3) goto L9;
        h(r3);
        tt5.a.h("PanelViewModel", "getDataFromRN");
        tt5.a.b("zxzxxx", "getDataFromRN");
        a(g(this.e.isOwner(), "").subscribeOn(fo5.d.e()).observeOn(fo5.d.d()).subscribe(new o0(), new p0()));
        return;
    }

    public final void f(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L7;
        com.bytedance.ee.bear.middleground.feed.export.bean.i r0 = this.d;
        if (r0 == null) goto L7;
        r0.a(r2);
        return;
    L7:
        tt5.a.d("PanelViewModel", "gotoProfile()... userid is empty or  feedListener is null");
    }

    public final void h(LifecycleOwner r5) {
        tt5.a.h("PanelViewModel", "feed panel start get data...");
        this.g.setValue(1);
        MutableLiveData<Triple<String, List<MultiBean>, MessageResultBean>> r0 = uf5.l0.b().a(this.e.getToken(), this.e.getDocumentType().b, this.e.getFilterTimestamp());
        this.k = r0;
        r0.observe(r5, new s0(this));
    }

    public final void i(final List r10) {
        if (r10.size() != 0) goto L6;
        tt5.a.h("PanelViewModel", "size is 0");
        return;
    L6:
        long r2 = SystemClock.elapsedRealtimeNanos();
        tt5.a.h("PanelViewModel", "readMessages:" + r2);
        if (this.l == null) goto L22;
        tt5.a.h("PanelViewModel", "readMessage messageResultBean != null");
        List<MessageBean> r0 = this.l.getData().getMessage();     // Catch: Exception -> L20
        Iterator r4 = r10.iterator();     // Catch: Exception -> L20
    L11:
        if (r4.hasNext() == false) goto L18;
        String r5 = (String) r4.next();     // Catch: Exception -> L20
        Iterator<MessageBean> r6 = r0.iterator();     // Catch: Exception -> L20
    L14:
        if (r6.hasNext() == false) goto L11;
        MessageBean r7 = r6.next();     // Catch: Exception -> L20
        if (Objects.equals(r5, r7.getMessageId()) == false) goto L14;
        tt5.a.h("PanelViewModel", "local readMessage: " + r5 + " " + r7.getCreateTime());     // Catch: Exception -> L20
        r7.setReadStatus(2);     // Catch: Exception -> L20
        goto L11
    L18:
        tt5.a.h("PanelViewModel", "end readMessages:" + (SystemClock.elapsedRealtimeNanos() - r2));     // Catch: Exception -> L20
        this.d.g(r10);     // Catch: Exception -> L20
        l(this.l);     // Catch: Exception -> L20
    L20:
        e = move-exception;
        tt5.a.f("PanelViewModel", e, false);
    L22:
        uf5.o r1 = this.o;
        final String r3 = this.e.getToken();
        final int r8 = this.e.getDocumentType().b;
        r1.getClass();
        Iterator r9 = r10.iterator();
    L24:
        if (r9.hasNext() == false) goto L26;
        String r11 = (String) r9.next();
        tt5.a.h("BadgeManager", "add read:" + r11);
        ((ConcurrentHashMap) r1.a).put(r11, "");
        goto L24
    L26:
        Flowable.just("").subscribeOn(fo5.d.b()).map(new uf5.i()).map(new uf5.j(r3, r8, r10)).subscribe(new uf5.k(), new uf5.l());
    }

    public final void j(boolean r3) {
        tt5.a.h("PanelViewModel", "setFirstUpdateData:" + r3);
        this.q = r3;
    }

    public final void l(MessageResultBean r2) {
        Flowable<MessageResultBean> r3 = Flowable.just(r2);
        c(this.m);
        Disposable r4 = m(r3);
        this.m = r4;
        a(r4);
    }

    public final Disposable m(Flowable<MessageResultBean> r6) {
        final uf5.l0 r0 = uf5.l0.b();
        final String r1 = this.e.getToken();
        final int r2 = this.e.getDocumentType().b;
        final Long r3 = this.e.getFilterTimestamp();
        r0.getClass();
        return r6.map(new uf5.x(r0, r1, r2, r3)).subscribeOn(fo5.d.a()).subscribe(new uf5.y(), new uf5.z());
    }

    public final Flowable<String> g(boolean r2, String r3) {
        Flowable<String> r4 = ((uf5.q0) this.c).a.h(r2, r3);
        if (r4 != null) goto L6;
        r4 = Flowable.error(new Throwable("comment sdk error, please check it"));
    L6:
        return r4.map(new k0(this));
    }

    /* JADX WARN: Type inference failed for: r9v1, types: [dg5.u0] */
    public d1(com.bytedance.ee.bear.middleground.feed.export.bean.g r6, final com.bytedance.ee.bear.middleground.feed.export.bean.i r7, final MessageConfig r8, LifecycleOwner r9) {
        this.f = new MutableLiveData();
        this.g = new MutableLiveData();
        this.h = new MutableLiveData();
        this.i = false;
        this.j = false;
        this.p = new MutableLiveData();
        this.q = true;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.o = new uf5.o();
        bg5.a.p();
        uf5.r r1 = bg5.a.b;
        if (r1 == null) goto L5;
        Boolean.valueOf(r1.k).booleanValue();
    L5:
        com.bytedance.ee.util.ui.m.b(bg5.a.l, 30000);
        bg5.a.a(DocFeed$Value$Stage.CHECK_PERMISSION);
        NetService.f r2 = new NetService.f("/api/message/get_message.v3/");
        ((NetService.e) r2).c = 1;
        HashMap r0 = new HashMap();
        r0.put(ResourceData.KEY_OBJ_TOKEN, this.e.getToken() + "");
        r0.put("obj_type", this.e.getDocumentType().b + "");
        r2.d(r0);
        NetService.d r3 = ((NetService) org.koin.java.a.a(NetService.class)).Vc(new ax4.a());
        if (r3 == null) goto L9;
        a(r3.a(r2).subscribe(new q0(), new r0(this)));
    L9:
        h(r9);
        ?? r10 = new u0(this, r8, r7);
        uf5.q0 r11 = (uf5.q0) r6;
        r11.getClass();
        uf5.p0 r12 = new uf5.p0(r10);
        r11.getClass();
        r11.a.f(r12);
    }
}
