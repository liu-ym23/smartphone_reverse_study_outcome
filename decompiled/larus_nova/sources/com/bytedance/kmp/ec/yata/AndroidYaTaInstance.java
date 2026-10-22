package com.bytedance.kmp.ec.yata;

import android.view.View;
import ba6.h;
import com.bytedance.kmp.ec.yata.common.biz.YataPageInfo;
import com.bytedance.kmp.ec.yata.common.biz.YataStoreWrapper;
import com.bytedance.kmp.ec.yata.common.biz.YataStoreWrapper$initStoreStateSubscribe$1;
import com.bytedance.kmp.ec.yata.common.biz.YataStoreWrapper$submitStoreData$1;
import com.bytedance.kmp.ec.yata.common.error.YataErrorManager;
import com.bytedance.kmp.ec.yata.common.error.d;
import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import com.bytedance.kmp.ec.yata.common.protocol.data.g;
import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import com.bytedance.kmp.ec.yata.store.core.RenderTreeStruct;
import com.bytedance.kmp.ec.yata.store.core.YataStore;
import com.bytedance.kmp.ec.yata.store.core.YataStoreData;
import com.bytedance.kmp.ec.yata.store.frontier.YataFrontierMessageDispatcher;
import com.bytedance.kmp.ec.yata.store.node.e;
import com.bytedance.kmp.ec.yata.view.c;
import com.bytedance.kmp.ec.yata.view.render.delegate.RenderDelegateManager;
import com.bytedance.kmp.ec.yata.view.render.screenmanager.main.MainScreenManager;
import com.bytedance.kmp.ec.yata.view.render.screenmanager.popup.PopupScreenManager;
import com.bytedance.kmp.ec.yata.view.render.tree.RenderTreeManager;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import v96.f;
import v96.i;

/* JADX INFO: loaded from: classes19.dex */
public final class AndroidYaTaInstance extends YataStoreWrapper {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.view.render.delegate.v2.a f251241p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final i f251242q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AndroidYaTaInstance f251243r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final c f251244s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f251245t;

    public static final class a implements fa6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AndroidYaTaInstance f251246a;

        public a(AndroidYaTaInstance r100) {
            this.f251246a = r100;
        }

        @Override // fa6.a
        public final com.bytedance.kmp.ec.yata.store.node.c a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "nodeKey");
            return this.f251246a.f251243r.o(r100);
        }
    }

    public final boolean J() {
        Intrinsics.checkNotNullParameter("keyBackTrigger", "trigger");
        String r100 = this.f251244s.f();
        Intrinsics.checkNotNullParameter("keyBackTrigger", "trigger");
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L53;
        List<RenderTreeStruct> r102 = r().f251748b;
        String r103 = null;
        if (r102 == null) goto L25;
        Iterator<T> r104 = r102.iterator();
    L15:
        if (r104.hasNext() == false) goto L19;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((RenderTreeStruct) r105).f251706a.f251774a, r100) == false) goto L15;
    L20:
        RenderTreeStruct r106 = (RenderTreeStruct) r105;
        if (r106 == null) goto L25;
        com.bytedance.kmp.ec.yata.store.node.a r107 = r106.f251706a;
        if (r107 == null) goto L25;
        e r108 = r107.f251779f;
    L26:
        if (r108 != null) goto L28;
        YataErrorManager r109 = f();
        d r110 = com.bytedance.kmp.ec.yata.common.error.c.f();
        r110.c("handleTopPopupTrigger_find_node_null");
        r110.l(r100);
        r110.d("triggerTopPopupEvent  " + r100 + "对应的节点数据找不到");
        r109.c(r110);
    L28:
        if (r108 == null) goto L34;
        p r111 = r108.f251788b;
        if (r111 == null) goto L34;
        Map<String, List<g>> r112 = r111.e();
        if (r112 == null) goto L34;
        List<g> r113 = r112.get("keyBackTrigger");
    L35:
        List<g> r114 = r113;
        if (r114 != null) goto L38;
    L41:
        boolean r115 = true;
    L43:
        if ((!r115) == false) goto L52;
        com.bytedance.kmp.ec.yata.event.common.e.a r116 = com.bytedance.kmp.ec.yata.event.common.e.f251660a;
        if (r108 == null) goto L47;
        r103 = r108.f251787a;
    L47:
        k().d(com.bytedance.kmp.ec.yata.event.common.e.a.b(r116, this, null, r103, "keyBackTrigger", null, null, null, false, null, 992));
        return true;
    L52:
        return false;
    L38:
        if (r114.isEmpty() == true) goto L41;
        r115 = false;
    L34:
        r113 = null;
        goto L35
    L19:
        r105 = null;
    L25:
        r108 = null;
        goto L26
    L53:
        return false;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }

    @Override // com.bytedance.kmp.ec.yata.common.biz.YataStoreWrapper
    public final void d() {
        super.d();
        c r100 = this.f251244s;
        r100.f251835r = true;
        r100.f251825h.b();
        ((RenderDelegateManager) r100.f251827j.getValue()).a();
    }

    public static final com.bytedance.kmp.ec.yata.shell.popup.b G(AndroidYaTaInstance r100) {
        return (com.bytedance.kmp.ec.yata.shell.popup.b) r100.f251245t.getValue();
    }

    public final <T> T I(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        c r101 = this.f251244s;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "clazz");
        RenderDelegateManager r102 = (RenderDelegateManager) r101.f251827j.getValue();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "clazz");
        T r103 = (T) ((LinkedHashMap) r102.f252011b).get(r100);
        if (r103 != null) goto L6;
        return null;
    L6:
        return r103;
    }

    public final View K(String r100) {
        Intrinsics.checkNotNullParameter(r100, "nodeKey");
        c r101 = this.f251244s;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "nodeKey");
        return ((com.bytedance.kmp.ec.yata.view.render.tree.b) r101.f251831n.getValue()).c(r100);
    }

    @Override // com.bytedance.kmp.ec.yata.common.biz.YataStoreWrapper
    @Deprecated(message = "触发节点View刷新")
    public final void w(String r100) {
        Intrinsics.checkNotNullParameter(r100, "nodeKey");
        c r101 = this.f251244s;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "nodeKey");
        Intrinsics.checkNotNullParameter(r100, "nodeKey");
        View r102 = ((com.bytedance.kmp.ec.yata.view.render.tree.b) r101.f251831n.getValue()).c(r100);
        if (r102 == null) goto L18;
        com.bytedance.kmp.ec.yata.store.node.b r103 = r101.f251823f.a(r100);
        RenderTreeManager r104 = null;
        if ((r103 instanceof ba6.d) == false) goto L8;
        ba6.d r105 = (ba6.d) r103;
    L9:
        if (r105 == null) goto L19;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        Object r106 = r102.getTag(R.id.android_yata_node_render_tree_manager);
        if ((r106 instanceof RenderTreeManager) == false) goto L14;
        r104 = (RenderTreeManager) r106;
    L14:
        if (r104 == null) goto L20;
        r104.e(r102, new com.bytedance.kmp.ec.yata.view.a(), r105);
        return;
    L20:
        return;
    L19:
        return;
    L8:
        r105 = null;
        goto L9
    }

    public static final void H(AndroidYaTaInstance r100, ba6.c r101, Function1 r102) {
        r100.getClass();
        if ((r101 instanceof com.bytedance.kmp.ec.yata.store.node.c) == false) goto L5;
        r102.invoke(r101);
        return;
    L5:
        YaTaLog.b("AndroidYaTaInstance", "IYataViewNodeObject must is IRenderObject");
        com.bytedance.kmp.ec.yata.store.node.c r103 = r100.f251243r.o(r101.d());
        if (r103 == null) goto L10;
        r102.invoke(r103);
        return;
    }

    @Override // com.bytedance.kmp.ec.yata.common.biz.YataStoreWrapper
    @Deprecated(message = "SDK内部API")
    public final void F(YataStoreData r100, RenderTreeStruct r101, List r102, YataStoreWrapper$submitStoreData$1 r103) {
        Intrinsics.checkNotNullParameter(r100, "storeData");
        Intrinsics.checkNotNullParameter(r103, "callback");
        c r104 = this.f251244s;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, "storeData");
        Intrinsics.checkNotNullParameter(r103, "callback");
        if (r102 == null) goto L7;
        PopupScreenManager r105 = r104.f251830m;
        if (r105 == null) goto L7;
        r105.b(r100, r102);
    L7:
        if (r101 != null) goto L9;
        h.a r106 = new h.a();
        Intrinsics.checkNotNullParameter(r106, "result");
        r103.a(r106);
        r103.b(r106);
        return;
    L9:
        MainScreenManager r107 = (MainScreenManager) r104.f251829l.getValue();
        com.bytedance.kmp.ec.yata.view.b r108 = new com.bytedance.kmp.ec.yata.view.b(r103, r104);
        r107.getClass();
        Intrinsics.checkNotNullParameter(r100, "storeData");
        Intrinsics.checkNotNullParameter(r101, "mainTree");
        RenderTreeManager r109 = (RenderTreeManager) r107.f252034b.getValue();
        r109.getClass();
        Intrinsics.checkNotNullParameter(r100, "storeData");
        Intrinsics.checkNotNullParameter(r101, "renderTree");
        r109.f252105d.update(r100, r101, new com.bytedance.kmp.ec.yata.view.render.tree.c(r108, r109, r100, r101));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [com.bytedance.kmp.ec.yata.common.biz.YataStoreWrapper$initStoreStateSubscribe$1] */
    public AndroidYaTaInstance(String r100, com.bytedance.kmp.ec.yata.common.init.c r110, YataPageInfo r111, com.bytedance.kmp.ec.yata.view.render.delegate.v2.a r112, f r113, i r114) {
        Intrinsics.checkNotNullParameter(r100, "bizCode");
        Intrinsics.checkNotNullParameter(r110, "switchConfig");
        Intrinsics.checkNotNullParameter(r111, "pageInfo");
        Intrinsics.checkNotNullParameter(r113, "originStoreAbility");
        Intrinsics.checkNotNullParameter(r114, "originViewAbility");
        super(r100, r110, r111, r113);
        this.f251241p = r112;
        this.f251242q = r114;
        this.f251243r = this;
        c r115 = new c(r114.getContext(), r100, r110, f(), r112, new a(this));
        this.f251244s = r115;
        this.f251245t = LazyKt.lazy(AndroidYaTaInstance$popupCallbackManager$2.INSTANCE);
        String r101 = YaTaLog.f251436a;
        YaTaLog.f251436a = this.f251340a;
        ((YataStore) this.f251351l.getValue()).a(new YataStoreWrapper$initStoreStateSubscribe$1(this));
        YataFrontierMessageDispatcher r102 = t();
        if (r102 == null) goto L5;
        r102.h(this);
    L5:
        B("pushPopup", new com.bytedance.kmp.ec.yata.shell.popup.e(this));
        B("popPopup", new com.bytedance.kmp.ec.yata.shell.popup.c(this));
        com.bytedance.kmp.ec.yata.view.render.delegate.e r103 = new AndroidYaTaInstance$handleViewWrapper$1(this);
        Intrinsics.checkNotNullParameter(r103, "callback");
        com.bytedance.kmp.ec.yata.view.render.delegate.g r116 = r115.d();
        r116.getClass();
        Intrinsics.checkNotNullParameter(r103, "callback");
        r116.f252017a.add(r103);
        com.bytedance.kmp.ec.yata.view.render.screenmanager.popup.a r104 = new AndroidYaTaInstance$handleViewWrapper$2(this);
        Intrinsics.checkNotNullParameter(r104, "callback");
        com.bytedance.kmp.ec.yata.view.render.screenmanager.popup.b r117 = r115.c();
        r117.getClass();
        Intrinsics.checkNotNullParameter(r104, "callback");
        r117.f252044a.add(r104);
    }
}
