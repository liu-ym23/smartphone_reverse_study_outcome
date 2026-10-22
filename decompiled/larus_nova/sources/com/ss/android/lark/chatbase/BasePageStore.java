package com.ss.android.lark.chatbase;

import android.text.TextUtils;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.biz.im.api.a1;
import com.ss.android.lark.biz.im.api.w0;
import com.ss.android.lark.chat.base.model.dispatch.ActionDispatcher;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.core.model.ObservableMappedArrayList;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageFoldDetail;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageStreamStatus;
import com.ss.android.lark.im.sdk.utils.ImSdkMessageUtils;
import com.ss.android.lark.log.Log;
import f5b.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import w4b.d0;
import x4b.a;

/* JADX INFO: loaded from: classes35.dex */
public abstract class BasePageStore<T extends f5b.b, PageData extends x4b.a<T>> extends com.ss.android.lark.chatbase.model.c<String, T, PageData, com.ss.android.lark.chat.core.model.d<T>> implements ActionDispatcher.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ObservableMappedArrayList<String, T> f416843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f416844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f416845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Integer> f416846e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile AtomicInteger f416847f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final v f416848g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c<T> f416849h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<j<T>> f416850i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<i<T>> f416851j;

    public static class a<T extends f5b.b> implements hya.a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f416852a;

        public a(T r100) {
            this.f416852a = r100;
        }

        @Override // hya.a
        public final Object a(Object r100) {
            f5b.b r101 = (f5b.b) r100;
            return this.f416852a;
        }
    }

    public static class b<T extends f5b.b> implements ObservableMappedArrayList.b<String, T> {
        public b() {
        }

        public final Object a(Object r100) {
            return ((f5b.b) r100).getId();
        }
    }

    public interface c<T> {
        void a();

        void b(List<T> r100);

        void c(List<T> r100);
    }

    public static abstract class d<T extends f5b.b> implements hya.a<T> {
        public d() {
        }

        public abstract T b(T r100);

        @Override // hya.a
        public final Object a(Object r100) {
            f5b.b r101 = (f5b.b) r100;
            if (r101 != null) goto L7;
            return null;
        L7:
            return b(r101);
        }
    }

    public static class e implements hya.b<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f416853a;

        @Override // hya.b
        public final /* bridge */ /* synthetic */ String b() {
            return null;
        }

        @Override // hya.b
        public final String a() {
            return this.f416853a;
        }

        public e(String r100) {
            this.f416853a = r100;
        }
    }

    public boolean D() {
        return true;
    }

    public boolean E(T r100) {
        return true;
    }

    public void H(n5b.a r100) {
    }

    public abstract void J();

    public abstract void K();

    public void L(w0 r100) {
    }

    public void M(a1 r100) {
    }

    public abstract int t(T r100);

    public abstract int v(T r100);

    public abstract String x();

    public MessageInfo y() {
        return null;
    }

    public void I() {
        this.f416843b.clear();
        ((ArrayList) this.f416846e).clear();
        this.f416844c = Integer.MAX_VALUE;
        this.f416845d = Integer.MIN_VALUE;
    }

    public final k N() {
        return new k(this, this.f416890a);
    }

    public final List<T> s() {
        this.f416843b.acquireReadAccess();
        ArrayList r100 = new ArrayList(this.f416843b);
        this.f416843b.releaseReadAccess();
        return r100;
    }

    @Override // com.ss.android.lark.chatbase.model.c
    public final List d() {
        return this.f416843b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A(PageData r100) {
        c();
        this.f416843b.beginUpdate();
        I();
        List<T> r101 = r(r100.f562457a);
        this.f416843b.addAll(r101);
        List<Integer> r102 = this.f416846e;
        ArrayList r103 = (ArrayList) r102;
        r103.addAll(r100.f562459c);
        z(r101, r100);
        R("init", r100);
        this.f416843b.finishUpdate();
        F("init", r100);
    }

    public final boolean B(T r100) {
        if (v(r100) >= this.f416845d) goto L11;
        int r101 = this.f416843b.size();
        int r102 = Math.min(r101, 5);
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L11;
        T r104 = this.f416843b.get((r101 - 1) - r103);
        if (TextUtils.equals(r104.getcId(), r100.getcId()) == true) goto L8;
        r103 = r103 + 1;
        goto L5
    L8:
        Log.i(x(), "can not add, pre message has add in list, cid = " + r104.getcId());
        return true;
    L11:
        return false;
    }

    public boolean C(T r100) {
        if (r100.canShow() == false) goto L7;
        Message r101 = r100.getMessage();
        d0 r102 = b7b.b.f17988a;
        if (ImSdkMessageUtils.c(r101) == true) goto L7;
        return true;
    L7:
        return false;
    }

    public void G(final PageData r100) {
        this.f416890a.execute(new h(this, r100));
    }

    public final void Q(T r100) {
        MessageFoldDetail r101 = r100.getMessageFoldDetail();
        if (D() == false) goto L7;
        if (r101 == null) goto L8;
        this.f416845d = (int) Math.max(this.f416845d, r101.getLastMessagePosition());
        return;
    L8:
        return;
    }

    @Override // com.ss.android.lark.chat.base.model.dispatch.ActionDispatcher.a
    public final boolean a(com.ss.android.lark.chat.base.model.dispatch.a r100) {
        if ((r100 instanceof com.ss.android.lark.chat.base.model.dispatch.b) == false) goto L7;
        com.ss.android.lark.chat.base.model.dispatch.b r101 = (com.ss.android.lark.chat.base.model.dispatch.b) r100;
        e r102 = r101.f411762b;
        r101.setResult(this.f416843b.getItemByKey(new String[]{r102.f416853a, null}));
        return true;
    L7:
        if ((r100 instanceof com.ss.android.lark.chat.base.model.dispatch.e) == false) goto L10;
        final com.ss.android.lark.chat.base.model.dispatch.e r103 = (com.ss.android.lark.chat.base.model.dispatch.e) r100;
        this.f416890a.execute(new com.ss.android.lark.chatbase.d(this, r103));
        return true;
    L10:
        return false;
    }

    @Override // com.ss.android.lark.chatbase.model.c
    public final /* bridge */ /* synthetic */ void b(x4b.a r100) {
        k(r100);
    }

    @Override // com.ss.android.lark.chatbase.model.c
    public final /* bridge */ /* synthetic */ void e(x4b.a r100) {
        A(r100);
    }

    @Override // com.ss.android.lark.chatbase.model.c
    public final void f(x4b.a r100) {
        c();
        this.f416843b.beginUpdate();
        List<T> r101 = r(r100.f562457a);
        this.f416843b.addAll(0, r101);
        z(r101, r100);
        R("prependPage", r100);
        this.f416843b.finishUpdate();
        F("prependPage", r100);
    }

    public final void h(i<T> r100) {
        if (this.f416851j.contains(r100) == true) goto L6;
        this.f416851j.add(r100);
        return;
    }

    public final void i(j<T> r100) {
        if (((CopyOnWriteArrayList) this.f416850i).contains(r100) == true) goto L6;
        ((CopyOnWriteArrayList) this.f416850i).add(r100);
        return;
    }

    public void j(T r100) {
        this.f416843b.add(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k(PageData r100) {
        c();
        this.f416843b.beginUpdate();
        List<T> r101 = r(r100.f562457a);
        this.f416843b.addAll(r101);
        z(r101, r100);
        R("appendPage", r100);
        this.f416843b.finishUpdate();
        F("appendPage", r100);
    }

    public final void l(final List<hya.c<String, f5b.b>> r100) {
        this.f416890a.execute(new f(this, r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void m(List<hya.c<String, f5b.b>> r210) {
        BasePageStore<T, PageData> r100 = this;
        if (r210.isEmpty() == false) goto L5;
        return;
    L5:
        c();
        Log.i(x(), "batch update start");
        r100.f416843b.beginUpdate();
        ArrayList r101 = new ArrayList();
        Iterator<hya.c<String, f5b.b>> r102 = r210.iterator();
    L7:
        if (r102.hasNext() == false) goto L68;
        hya.c<String, f5b.b> r103 = r102.next();
        hya.b<String> r104 = r103.b();
        hya.a<f5b.b> r105 = r103.a();
        int r106 = r100.f416843b.getItemPosByKey(new String[]{r104.a(), r104.b()});
        if (r106 <= (-1)) goto L11;
        T r107 = r100.f416843b.get(r106);
    L12:
        f5b.b r108 = r105.a(r107);
        if (r108 != null) goto L15;
        r108 = null;
    L15:
        if (r108 == null) goto L7;
        if (r107 == null) goto L19;
        boolean r110 = true;
    L20:
        Log.d(x(), "isUpdateExistItem: " + r110);
        String r111 = "<this>";
        String r112 = "noTraceDelete";
        if (r110 == false) goto L41;
        boolean r113 = r108.isNoTraceDelete();
        boolean r114 = r100.C(r108);
        if (r113 == false) goto L25;
        r100.f416843b.remove(r106);
    L32:
        r102 = r102;
        r111 = "<this>";
    L40:
        r101.add(r108);
        BasePageStore<T, PageData> r109 = this;
    L59:
        if (TextUtils.isEmpty(r112) == true) goto L63;
        Intrinsics.checkNotNullParameter(r108, r111);
        if (kkb.a.a(r108.getMessage()) == true) goto L63;
        Log.i(x(), String.format("%s message： %s", new Object[]{r112, r108}));
    L63:
        Iterator r115 = ((CopyOnWriteArrayList) r109.f416850i).iterator();
    L65:
        if (r115.hasNext() == false) goto L67;
        ((j) r115.next()).a(r108);
        goto L65
    L67:
        r100 = r109;
        r102 = r102;
        goto L7
    L25:
        if (r114 == true) goto L27;
        r100.f416843b.remove(r106);
        Collections.synchronizedSet(new HashSet());
        Message r116 = r108.getMessage();
        if (r116 == null) goto L39;
        d0 r117 = b7b.b.f17988a;
        if (ImSdkMessageUtils.c(r116) == false) goto L39;
        long r118 = ChatCoreModule.a().getSettingDependency().a();
        long r119 = r116.getBurnTime();
        long r120 = r116.getCreateTime() * 1000;
        long r121 = r116.getBurnLife() * 1000;
        String r122 = TimeZone.getDefault().getDisplayName(false, 0);
        StringBuilder r123 = new StringBuilder("logMsgBurned --> ");
        r123.append(" msgId = " + r116.getId() + " , isBurned = " + r116.isBurned() + " ,ntpTime = " + r118 + " ,burnTime = " + r119 + " ,msgCreateTime = " + r120 + " ,calLeftTime = " + (r119 - r118) + " ,burnLife = " + r121 + " ,timezone = " + r122 + " ,local with ntp offset = " + (System.currentTimeMillis() - r118));
        Log.i("secret_chat_tag", r123.toString());
    L39:
        r112 = "remove";
        goto L40
    L27:
        if (r100.o(r107, r108) == false) goto L31;
        r100.f416843b.set(r106, r108);
        r100.z(Collections.singletonList(r108), null);
        Intrinsics.checkNotNullParameter(r108, "<this>");
        r112 = "update";
        if (kkb.a.a(r108.getMessage()) == true) goto L32;
        r100.S("update", r108);
        goto L32
    L31:
        r112 = String.format("can not replace, skip update。(%s, %s) - (%s, %s)", new Object[]{Long.valueOf(r107.getUpdateTime()), Boolean.valueOf(r107.isPreMessage()), Long.valueOf(r108.getUpdateTime()), Boolean.valueOf(r108.isPreMessage())});
        goto L32
    L41:
        r102 = r102;
        r111 = "<this>";
        r109 = this;
        List<T> r124 = r109.r(Collections.singletonList(r108));
        if (r109.n(r108) == true) goto L44;
        r112 = "can not append, skip update ";
    L54:
        if (r109.v(r108) <= r109.f416844c) goto L59;
        c<T> r125 = r109.f416849h;
        if (r125 == null) goto L59;
        r125.c(r124);
        goto L59
    L44:
        if (r108.isNoTraceDelete() == true) goto L54;
        if (CollectionUtils.isNotEmpty(r124) == false) goto L51;
        r109.j(r108);
        c<T> r126 = r109.f416849h;
        if (r126 == null) goto L51;
        r126.b(r124);
    L51:
        r109.z(Collections.singletonList(r108), null);
        r112 = "add";
        r109.S("add", r108);
        goto L54
    L19:
        r110 = false;
        goto L20
    L11:
        r107 = null;
        goto L12
    L68:
        BasePageStore<T, PageData> r127 = r100;
        if (r101.isEmpty() == true) goto L74;
        Iterator r128 = ((CopyOnWriteArrayList) r127.f416850i).iterator();
    L72:
        if (r128.hasNext() == false) goto L74;
        ((j) r128.next()).c(r101);
    L74:
        r127.f416843b.finishUpdate();
        Log.i(x(), "batch update end");
    }

    public boolean n(T r100) {
        if (r100.isPreMessage() == true) goto L5;
        int r101 = v(r100);
        if (this.f416844c != Integer.MAX_VALUE) goto L18;
        if (this.f416845d != Integer.MIN_VALUE) goto L18;
        if (this.f416847f.get() < r101) goto L25;
        return false;
    L25:
        return true;
    L18:
        if (r101 >= this.f416844c) goto L21;
        return false;
    L21:
        if (this.f416847f.get() <= this.f416845d) goto L26;
        return false;
    L26:
        return true;
    L5:
        if (B(r100) == false) goto L7;
        return false;
    L7:
        return true;
    }

    public void q(T r100) {
        Iterator r101 = ((CopyOnWriteArrayList) this.f416851j).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((i) r101.next()).a(r100);
        goto L4
    }

    public final List<T> r(List<T> r100) {
        c();
        if (CollectionUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L18;
        T r103 = r102.next();
        String r104 = r103.getId();
        if (C(r103) == false) goto L10;
        if (r103.isNoTraceDelete() == true) goto L13;
        if (this.f416843b.containsKey(new String[]{r104, r103.getcId()}) == true) goto L16;
        r101.add(r103);
        goto L7
    L16:
        Log.e(x(), "filter duplicate item:" + r104);
        goto L7
    L13:
        Log.e(x(), "filter noTraceDelete item:" + r104);
        goto L7
    L10:
        Log.e(x(), "filter invisible item:" + r104);
        goto L7
    L18:
        return r101;
    }

    public final T u(String r100) {
        return this.f416843b.getItemByKey(new String[]{r100});
    }

    public final List<T> w(Collection<String> r100) {
        return this.f416843b.getItemsByKey(r100);
    }

    public static boolean g(BasePageStore r100, f5b.b r101) {
        Log.d(r100.x(), "preProcessData: msgPosition is " + r101.getMessage().getPosition());
        if (r100.E(r101) == true) goto L5;
        Log.i(r100.x(), "preProcess data: failed to add data, id = " + r101.getId());
        return false;
    L5:
        r100.q(r101);
        return true;
    }

    public final void F(String r100, x4b.a<T> r101) {
        int r102 = this.f416843b.size();
        int r103 = 0;
        if (r102 <= 0) goto L5;
        int r104 = t(this.f416843b.get(0));
    L6:
        if (r102 <= 0) goto L8;
        r103 = t(this.f416843b.get(r102 - 1));
    L8:
        Log.i(x(), "DataStore " + r100 + ", size is:" + ((ArrayList) r101.f562457a).size() + "， current position range:[" + this.f416844c + ", " + this.f416845d + "], current badge range:[" + r104 + ", " + r103 + "]");
        return;
    L5:
        r104 = 0;
        goto L6
    }

    public final void O(final hya.b<String> r100, final hya.a<f5b.b> r101) {
        this.f416890a.execute(new com.ss.android.lark.chatbase.c(this, r100, r101));
    }

    public final void P(String r100, com.ss.android.lark.chatbase.model.c.b r101) {
        O(new e(r100), r101);
    }

    public final void R(String r100, x4b.a<T> r101) {
        int r102 = this.f416844c;
        int r103 = this.f416845d;
        List<T> r104 = r101.f562457a;
        List<Integer> r105 = r101.f562458b;
        Iterator r106 = ((ArrayList) r104).iterator();
    L4:
        if (r106.hasNext() == false) goto L9;
        f5b.b r107 = (f5b.b) r106.next();
        if (r107.isPreMessage() == true) goto L8;
        int r108 = v(r107);
        this.f416845d = Math.max(this.f416845d, r108);
        this.f416844c = Math.min(this.f416844c, r108);
    L8:
        Q(r107);
        goto L4
    L9:
        Iterator r109 = ((ArrayList) r105).iterator();
    L11:
        if (r109.hasNext() == false) goto L13;
        Integer r110 = (Integer) r109.next();
        this.f416845d = Math.max(this.f416845d, r110.intValue());
        this.f416844c = Math.min(this.f416844c, r110.intValue());
        goto L11
    L13:
        Log.i(x(), String.format("%s [%d-%d] -> [%d-%d]", new Object[]{r100, Integer.valueOf(r102), Integer.valueOf(r103), Integer.valueOf(this.f416844c), Integer.valueOf(this.f416845d)}));
    }

    public final void S(String r100, T r101) {
        if (r101.isPreMessage() == false) goto L5;
        return;
    L5:
        int r102 = this.f416844c;
        int r103 = this.f416845d;
        int r104 = v(r101);
        if (this.f416845d == Integer.MIN_VALUE) goto L8;
    L12:
        this.f416845d = Math.max(this.f416845d, r104);
    L13:
        Q(r101);
        Log.i(x(), String.format("%s [%d-%d] -> [%d-%d]", new Object[]{r100, Integer.valueOf(r102), Integer.valueOf(r103), Integer.valueOf(this.f416844c), Integer.valueOf(this.f416845d)}));
        return;
    L8:
        if (this.f416844c != Integer.MAX_VALUE) goto L12;
        this.f416845d = r104;
        this.f416844c = r104;
        c<T> r105 = this.f416849h;
        if (r105 == null) goto L13;
        r105.a();
        goto L13
    }

    public boolean o(T r100, T r101) {
        if (r101.isPreMessage() == false) goto L8;
        if (r100.isPreMessage() == true) goto L8;
        return false;
    L8:
        if (r101.isPreMessage() == true) goto L13;
        if (r100.isPreMessage() == false) goto L13;
        return true;
    L13:
        if (r101.isPreMessage() == true) goto L29;
        if (r100.isPreMessage() == true) goto L29;
        if (r101.getMessage().getStatus() == r100.getMessage().getStatus()) goto L19;
        return true;
    L19:
        MessageStreamStatus r102 = r100.getMessage().getStreamStatus();
        MessageStreamStatus r103 = MessageStreamStatus.Transport;
        if (r102 != r103) goto L29;
        if (r101.getMessage().getStreamStatus() == r103) goto L24;
        return true;
    L24:
        if (r101.getMessage().getStreamSequenceId() < r100.getMessage().getStreamSequenceId()) goto L34;
        return true;
    L34:
        return false;
    L29:
        if (r101.getUpdateTime() >= r100.getUpdateTime()) goto L31;
        return false;
    L31:
        if (r101.isIntermediateMessage() == true) goto L36;
        return true;
    L36:
        return false;
    }

    public final void p(Integer r100, IMessageListComponent.c r101) {
        c();
        Log.d(x(), "checkToClearDataStore: newFirstMsgPosition is " + r100 + " , position interval is [" + this.f416844c + "," + this.f416845d + "]");
        this.f416843b.beginUpdate();
        if (r100.intValue() != (-1)) goto L8;
        if (this.f416845d != Integer.MIN_VALUE) goto L8;
        Log.i(x(), "not clear data store: only have pre message");
    L27:
        this.f416843b.finishUpdate();
        return;
    L8:
        if (r100.intValue() < this.f416845d) goto L11;
        I();
        r101.a();
        Log.i(x(), "data store is cleared");
        goto L27
    L11:
        if (this.f416844c > r100.intValue()) goto L27;
        if (r100.intValue() >= this.f416845d) goto L27;
        int r102 = 0;
    L16:
        if (r102 >= this.f416843b.size()) goto L26;
        T r103 = this.f416843b.get(r102);
        int r104 = r103.getMessage().getPosition();
        if (D() == false) goto L23;
        if (r103.getMessageFoldDetail() == null) goto L23;
        r104 = (int) Math.max(r104, r103.getMessageFoldDetail().getLastMessagePosition());
    L23:
        if (r104 > r100.intValue()) goto L26;
        r102 = r102 + 1;
    L26:
        this.f416843b.removeRange(0, r102);
        this.f416844c = r100.intValue() + 1;
        r101.a();
        Log.i(x(), "data store is partially cleared from " + r100);
        goto L27
    }

    public final void z(List<T> r100, PageData r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f416850i).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((j) r102.next()).b(r100, r101);
        goto L4
    }

    public BasePageStore(v r100, x4b.d r101, c r102) {
        super(r101);
        this.f416844c = Integer.MAX_VALUE;
        this.f416845d = Integer.MIN_VALUE;
        this.f416846e = new ArrayList();
        this.f416847f = new AtomicInteger(-1);
        this.f416850i = new CopyOnWriteArrayList();
        this.f416851j = new CopyOnWriteArrayList();
        this.f416848g = r100;
        this.f416849h = r102;
        final b r103 = new b();
        final boolean r104 = DevEnvUtil.isDebugMode(ChatCoreModule.a().getContext());
        final boolean r105 = true;
        this.f416843b = (ObservableMappedArrayList<String, T>) new AnonymousClass1(this, r103, r105, r104);
        K();
        J();
    }
}
