package com.ss.ugc.live.sdk.msg.unify.business;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.android.livesdk.gift.model.n;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import com.ss.ugc.live.sdk.msg.dispatch.e;
import com.ss.ugc.live.sdk.msg.dispatch.g;
import com.ss.ugc.live.sdk.msg.dispatch.h;
import com.ss.ugc.live.sdk.msg.dispatch.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vlc.j;
import vlc.k;
import vlc.l;

/* JADX INFO: loaded from: classes36.dex */
public final class UnifyLiveMessageDispatcher implements e, h, k, imc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<tlc.d> f458318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<vlc.b> f458319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<j> f458320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseArray<Set<l>> f458321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, Set<l>> f458322e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ulc.a f458323f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final k f458324g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f458325h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<com.ss.ugc.live.sdk.msg.dispatch.a> f458326i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Set<String> f458327j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f458328k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f458329l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final g f458330m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.ss.ugc.live.sdk.msg.dispatch.b f458331n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final i f458332o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f458333p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final HashMap<String, bmc.a> f458334q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final long f458335r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.ss.ugc.live.sdk.msg.unify.business.a f458336s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final vlc.c f458337t;

    public static final class a {
    }

    public static final class b implements g {
        public b() {
        }

        @Override // com.ss.ugc.live.sdk.msg.dispatch.g
        public final int a(List<? extends tlc.d> r100, h r101) {
            Intrinsics.checkNotNullParameter(r100, "messages");
            Intrinsics.checkNotNullParameter(r101, "dispatcher");
            ArrayList r102 = (ArrayList) r100;
            Iterator r103 = r102.iterator();
        L4:
            if (r103.hasNext() == false) goto L7;
            r101.onMessage((tlc.d) r103.next());
            goto L4
        L7:
            return r102.size();
        }
    }

    static {
    }

    public final void j() {
        this.f458321d.clear();
        this.f458322e.clear();
        ((CopyOnWriteArrayList) this.f458320c).clear();
        ((CopyOnWriteArrayList) this.f458319b).clear();
        ((ArrayList) this.f458318a).clear();
        ((HashMap) this.f458332o.f458275b).clear();
    }

    @Override // imc.c
    public final void a(hmc.b r100) {
        Intrinsics.checkNotNullParameter(r100, "decodePacket");
        Object r101 = r100.f486059b;
        if ((r101 instanceof d) == true) goto L5;
        r101 = null;
    L5:
        d r102 = (d) r101;
        if (r102 == null) goto L11;
        List<tlc.d> r103 = r102.f458353b;
        if (r103 == null) goto L12;
        c(r103);
        return;
    L12:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.ArrayList] */
    @Override // com.ss.ugc.live.sdk.msg.dispatch.e
    public final void c(List<? extends tlc.d> r110) {
        List<? extends tlc.d> r100 = r110;
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        vlc.c r103 = this.f458337t;
        StringBuilder r104 = new StringBuilder("dispatch unify message: [service: ");
        r104.append(this.f458336s.f458345f);
        r104.append(", method: ");
        r104.append(this.f458336s.f458346g);
        r104.append(", roomId: ");
        r104.append(this.f458335r);
        r104.append("], messages: [");
        int r105 = com.ss.ugc.live.sdk.msg.utils.c.f458473a;
        if (r110 == null) goto L17;
        List<? extends tlc.d> r106 = r110;
        ?? r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator r108 = r106.iterator();
    L15:
        if (r108.hasNext() == false) goto L18;
        tlc.d r109 = (tlc.d) r108.next();
        r107.add(r109.getMessageMethod() + ':' + r109.getGeneralMessageType() + ':' + r109.getMessageId());
    L18:
        r104.append(TextUtils.join(",", (Iterable) r107));
        r104.append(']');
        com.ss.ugc.live.sdk.msg.utils.a.c(r103, r104.toString());
        if (r100 != null) goto L21;
    L24:
        if (r101 == true) goto L29;
        this.f458333p.obtainMessage(201, r110).sendToTarget();
        return;
    L29:
        return;
    L21:
        if (r100.isEmpty() == true) goto L24;
        r101 = false;
        goto L24
    L17:
        r107 = CollectionsKt.emptyList();
        goto L18
    L5:
        if (r100.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    public final void h(final tlc.d r100) {
        Function1<l, Unit> r101 = new UnifyLiveMessageDispatcher$dispatchMessage$1(this, r100);
        Set<l> r102 = this.f458321d.get(r100.getIntType());
        Set<l> r103 = r102;
        boolean r104 = false;
        if (r103 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == true) goto L14;
        Iterator<l> r106 = r102.iterator();
    L12:
        if (r106.hasNext() == false) goto L14;
        r101.invoke2(r106.next());
    L14:
        Set<l> r107 = this.f458322e.get(r100.getMessageMethod());
        Set<l> r108 = r107;
        if (r108 != null) goto L17;
    L18:
        r104 = true;
    L19:
        if (r104 == true) goto L24;
        Iterator<l> r109 = r107.iterator();
    L22:
        if (r109.hasNext() == false) goto L27;
        r101.invoke2(r109.next());
        goto L22
    L27:
        return;
    L24:
        return;
    L17:
        if (r108.isEmpty() == false) goto L19;
    L5:
        if (r103.isEmpty() == true) goto L8;
        r105 = false;
        goto L9
    }

    public final void m(l r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        int r101 = this.f458321d.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        Set<l> r103 = this.f458321d.valueAt(r102);
        if (r103 == null) goto L7;
        r103.remove(r100);
    L7:
        r102 = r102 + 1;
        goto L3
    L9:
        if ((!this.f458322e.isEmpty()) == false) goto L14;
        Iterator<Map.Entry<String, Set<l>>> r104 = this.f458322e.entrySet().iterator();
    L12:
        if (r104.hasNext() == false) goto L19;
        r104.next().getValue().remove(r100);
        goto L12
    L19:
        return;
    }

    @Override // com.ss.ugc.live.sdk.msg.dispatch.h
    public final void onMessage(tlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f458331n.f458271b++;
        r100.setConsumeTime(System.currentTimeMillis());
        if (r100.isFromFirstRequest() == true) goto L22;
        Iterator r101 = ((CopyOnWriteArrayList) this.f458319b).iterator();
    L7:
        if (r101.hasNext() == false) goto L22;
        vlc.b r102 = (vlc.b) r101.next();
        if (r102.onMessage(r100) == false) goto L7;
        Iterator r103 = ((CopyOnWriteArrayList) this.f458320c).iterator();
    L12:
        if (r103.hasNext() == false) goto L21;
        j r104 = (j) r103.next();
        if ((r102 instanceof ulc.b) == true) goto L16;
        vlc.b r105 = null;
    L17:
        ulc.b r106 = (ulc.b) r105;
        if (r106 == null) goto L20;
        r106.getName();
    L20:
        r104.I(r100);
        goto L12
    L16:
        r105 = r102;
        goto L17
    L21:
        boolean r107 = true;
    L23:
        if (r107 == false) goto L26;
        return;
    L26:
        if (com.ss.ugc.live.sdk.msg.utils.a.b(r100) == false) goto L28;
        this.f458332o.d(r100);
    L28:
        h(r100);
        return;
    L22:
        r107 = false;
        goto L23
    }

    public final void e(String r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "messageMethod");
        Intrinsics.checkNotNullParameter(r101, "listener");
        Set<l> r102 = this.f458322e.get(r100);
        if (r102 != null) goto L5;
        r102 = new CopyOnWriteArraySet();
        this.f458322e.put(r100, r102);
    L5:
        r102.add(r101);
    }

    public final void i(tlc.d r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.setIsInsert(true);
        r100.setReceiveTime(System.currentTimeMillis());
        r100.setEnqueueDispatchTime(System.currentTimeMillis());
        if (r101 == false) goto L7;
        h(r100);
        return;
    L7:
        onMessage(r100);
    }

    public final void k(int r100, l r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        Set<l> r102 = this.f458321d.get(r100);
        Set<l> r103 = r102;
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L12;
        r102.remove(r101);
        return;
    L12:
        return;
    L5:
        if (r103.isEmpty() == true) goto L8;
        r104 = false;
        goto L9
    }

    public final void l(String r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "messageMethod");
        Intrinsics.checkNotNullParameter(r101, "listener");
        Set<l> r102 = this.f458322e.get(r100);
        Set<l> r103 = r102;
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L12;
        r102.remove(r101);
        return;
    L12:
        return;
    L5:
        if (r103.isEmpty() == true) goto L8;
        r104 = false;
        goto L9
    }

    public final void n(boolean r100, int r101) {
        if (this.f458333p.hasMessages(202) == false) goto L5;
        return;
    L5:
        Message r102 = this.f458333p.obtainMessage(202, Integer.valueOf(r101));
        if (r100 == true) goto L8;
        this.f458333p.sendMessage(r102);
        return;
    L8:
        this.f458333p.sendMessageDelayed(r102, this.f458328k);
    }

    public final void f(String r100, l r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        if (r100 == null) goto L14;
        Set<l> r103 = this.f458322e.get(r100);
        if (r103 != null) goto L7;
        r103 = new CopyOnWriteArraySet();
        this.f458322e.put(r100, r103);
    L7:
        r103.add(r101);
        Map<String, xlc.b> r104 = this.f458332o.f458275b;
        HashMap r105 = (HashMap) r104;
        Object r106 = r105.get(i.a(r100, r102));
        if ((r106 instanceof tlc.d) == true) goto L10;
        r106 = null;
    L10:
        tlc.d r107 = (tlc.d) r106;
        if (r107 == null) goto L15;
        r101.onMessage(r107);
        return;
    L15:
        return;
    }

    @Override // vlc.k
    public final void b(long r110, int r111, int r112, long r113) {
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f458337t, "onMessageDuplicated, id: " + r110 + ", first from " + r111 + ", this from " + r112 + ", delay: " + r113);
        k r100 = this.f458324g;
        if (r100 == null) goto L6;
        r100.b(r110, r111, r112, r113);
        return;
    }

    public final void d(int r100, l r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        Set<l> r104 = this.f458321d.get(r100);
        if (r104 != null) goto L5;
        r104 = new CopyOnWriteArraySet();
        this.f458321d.put(r100, r104);
    L5:
        r104.add(r101);
        if (r102 == false) goto L11;
        tlc.d r105 = this.f458332o.c(r100, r103);
        if (r105 == null) goto L12;
        r101.onMessage(r105);
        return;
    L12:
        return;
    }

    public UnifyLiveMessageDispatcher(long r100, com.ss.ugc.live.sdk.msg.unify.business.a r101, st2.c r102, rt2.d r110, List r111) {
        Intrinsics.checkNotNullParameter(r101, "unifyBusinessConfig");
        Intrinsics.checkNotNullParameter(r102, "config");
        Intrinsics.checkNotNullParameter(r110, "unifyLogger");
        Intrinsics.checkNotNullParameter(r111, n.KEY_PLUGINS);
        this.f458335r = r100;
        this.f458336s = r101;
        this.f458337t = r110;
        this.f458318a = new ArrayList();
        CopyOnWriteArrayList r103 = new CopyOnWriteArrayList();
        this.f458319b = r103;
        CopyOnWriteArrayList r104 = new CopyOnWriteArrayList();
        this.f458320c = r104;
        this.f458321d = new SparseArray();
        this.f458322e = new HashMap();
        ulc.a r105 = new ulc.a(this, 512);
        this.f458323f = r105;
        this.f458325h = 1;
        List<com.ss.ugc.live.sdk.msg.dispatch.a> r106 = CollectionsKt.emptyList();
        if (r106 != null) goto L6;
        r106 = CollectionsKt.emptyList();
    L6:
        this.f458326i = r106;
        Set<String> r107 = r102.f543558c;
        if (r107 != null) goto L10;
        r107 = SetsKt.emptySet();
    L10:
        this.f458327j = r107;
        this.f458328k = 200;
        this.f458329l = AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME;
        this.f458330m = new b();
        this.f458331n = new com.ss.ugc.live.sdk.msg.dispatch.b(false);
        i r108 = new i(r100, r110);
        this.f458332o = r108;
        this.f458333p = new c(this, Looper.getMainLooper());
        this.f458334q = new HashMap();
        r103.add(r105);
        r103.add(r108);
        Collection r109 = r102.f543556a;
        if (r109 != null) goto L14;
        r109 = CollectionsKt.emptyList();
    L14:
        r103.addAll(r109);
        Collection r112 = r102.f543557b;
        if (r112 != null) goto L18;
        r112 = CollectionsKt.emptyList();
    L18:
        r104.addAll(r112);
        this.f458324g = null;
        Iterator r113 = r111.iterator();
    L20:
        if (r113.hasNext() == false) goto L22;
        bmc.a r114 = (bmc.a) r113.next();
        d(r114.dB(), r114, false, null);
        this.f458334q.put(r114.kM(), r114);
        goto L20
    }

    public static /* synthetic */ void g(UnifyLiveMessageDispatcher r100, int r101, l r102, boolean r103, int r104) {
        if ((r104 & 4) == 0) goto L5;
        r103 = false;
    L5:
        r100.d(r101, r102, r103, null);
    }
}
