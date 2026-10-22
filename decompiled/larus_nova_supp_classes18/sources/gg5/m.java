package gg5;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.feed.v2.FeedPluginV2;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Stage;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageConfig;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageResultBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.framework.utils.CollectionUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m extends gn4.a {
    public final com.bytedance.ee.bear.middleground.feed.export.bean.j c;
    public final MutableLiveData<List<Notice<?>>> d;
    public final MutableLiveData<MessageConfig> e;
    public final MutableLiveData<Integer> f;
    public final MutableLiveData<Boolean> g;
    public boolean h;
    public MutableLiveData i;
    public e j;
    public final uf5.o k;
    public final MutableLiveData<Boolean> l;
    public boolean m;
    public final vf5.b n;

    public final MessageConfig d() {
        return (MessageConfig) this.e.getValue();
    }

    public final List<Notice<?>> e() {
        MutableLiveData r0 = this.i;
        if (r0 == null) goto L11;
        if (r0.getValue() == null) goto L11;
        if (((MessageResultBean.Data) this.i.getValue()).getNoticeList() == null) goto L11;
        return ((MessageResultBean.Data) this.i.getValue()).getNoticeList();
    L11:
        return new ArrayList();
    }

    public final void f() {
        List<Notice<?>> r0 = e();
        if (CollectionUtils.isNotEmpty(r0) == false) goto L6;
        this.d.setValue(new ArrayList(r0));
        return;
    }

    public final void g(List<String> r11) {
        if (r11.size() != 0) goto L6;
        tt5.a.h("PanelViewModelV2", "size is 0");
        return;
    L6:
        long r2 = SystemClock.elapsedRealtimeNanos();
        tt5.a.h("PanelViewModelV2", "readMessages:" + r2);
        tt5.a.h("PanelViewModelV2", "readMessage messageResultBean != null");
        List<Notice<?>> r0 = e();     // Catch: Exception -> L18
        Iterator<String> r4 = r11.iterator();     // Catch: Exception -> L18
    L9:
        if (r4.hasNext() == false) goto L16;
        String r5 = r4.next();     // Catch: Exception -> L18
        Iterator<Notice<?>> r6 = r0.iterator();     // Catch: Exception -> L18
    L12:
        if (r6.hasNext() == false) goto L9;
        Notice<?> r7 = r6.next();     // Catch: Exception -> L18
        if (TextUtils.equals(r5, r7.getNoticeId()) == false) goto L12;
        tt5.a.h("PanelViewModelV2", "local readMessage: " + r5 + " " + r7.getNoticeTime());     // Catch: Exception -> L18
        r7.setReadStatus(1);     // Catch: Exception -> L18
        goto L9
    L16:
        tt5.a.h("PanelViewModelV2", "end readMessages:" + (SystemClock.elapsedRealtimeNanos() - r2));     // Catch: Exception -> L18
        this.c.e(r11);     // Catch: Exception -> L18
        f();     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        tt5.a.f("PanelViewModelV2", e, false);
    }

    public final void h(boolean r3) {
        tt5.a.h("PanelViewModelV2", "setFirstUpdateData:" + r3);
        this.m = r3;
    }

    /* JADX WARN: Type inference failed for: r7v13, types: [androidx.lifecycle.Observer, gg5.e] */
    public m(l15.l r7, MessageConfig r8, LifecycleOwner r9, vf5.b r10) {
        this.d = new MutableLiveData();
        MutableLiveData<MessageConfig> r0 = new MutableLiveData(new MessageConfig());
        this.e = r0;
        MutableLiveData<Integer> r1 = new MutableLiveData();
        this.f = r1;
        this.g = new MutableLiveData();
        boolean r2 = false;
        this.h = false;
        this.l = new MutableLiveData();
        this.m = true;
        this.c = r7;
        r0.setValue(r8);
        this.n = r10;
        this.k = new uf5.o();
        bg5.a.p();
        uf5.r r11 = bg5.a.b;
        if (r11 == null) goto L5;
        Boolean.valueOf(r11.k).booleanValue();
    L5:
        com.bytedance.ee.util.ui.m.b(bg5.a.l, 30000);
        bg5.a.a(DocFeed$Value$Stage.CHECK_PERMISSION);
        NetService.f r12 = new NetService.f("/api/message/get_message.v3/");
        ((NetService.e) r12).c = 1;
        HashMap r13 = new HashMap();
        r13.put(ResourceData.KEY_OBJ_TOKEN, d().getToken() + "");
        r13.put("obj_type", d().getDocumentType().b + "");
        r12.d(r13);
        NetService.d r14 = ((NetService) org.koin.java.a.a(NetService.class)).Vc(new ax4.a());
        if (r14 == null) goto L9;
        a(r14.a(r12).subscribe(new f(), new g(this)));
    L9:
        tt5.a.h("PanelViewModelV2", "feed panel start get data...");
        r1.setValue(1);
        FeedPluginV2.b r15 = (FeedPluginV2.b) r10;
        if (FeedPluginV2.access$700(r15.a) == true) goto L12;
    L17:
        MutableLiveData r16 = FeedPluginV2.access$800(r15.a).getFeedMessageLiveData();
        this.i = r16;
        e r17 = this.j;
        if (r17 == null) goto L20;
        r16.removeObserver(r17);
    L20:
        ?? r18 = new e(this);
        this.j = r18;
        this.i.observe(r9, r18);
        return;
    L12:
        if (FeedPluginV2.access$800(r15.a).getFeedMessageLiveData().getValue() != null) goto L17;
        if (FeedPluginV2.access$000(r15.a) == null) goto L16;
        r2 = ((a) FeedPluginV2.access$000(r15.a)).a().isOwner();
    L16:
        tt5.a.h("FeedPluginV2", "doc from is feed, fetch from rn");
        FeedPluginV2.access$900(r15.a).add(((com.bytedance.ee.bear.rn.g) org.koin.java.a.b(com.bytedance.ee.bear.rn.g.class, null, new l15.h(r15))).r(r2).map(new l15.i()).subscribe(new l15.j(r15), new l15.k()));
        goto L17
    }
}
