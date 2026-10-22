package com.bytedance.kmp.ec.yata.view.render.tree;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.recyclerview.widget.RecyclerView;
import ba6.d;
import ba6.f;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.j;
import com.bytedance.android.ecom.arch.slice.render.p;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.kmp.ec.yata.common.error.YataErrorManager;
import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import com.bytedance.kmp.ec.yata.common.render.TreeType;
import com.bytedance.kmp.ec.yata.view.render.controller.manager.exposure.AbsExposureHelper;
import com.bytedance.kmp.ec.yata.view.render.controller.manager.exposure.RecyclerViewExposureHelper;
import com.bytedance.kmp.ec.yata.view.render.controller.manager.exposure.ViewExposureManager;
import com.bytedance.kmp.ec.yata.view.render.controller.manager.exposure.i;
import com.bytedance.kmp.ec.yata.view.render.controller.recyclerview.BodyContainerController;
import com.bytedance.kmp.ec.yata.view.render.controller.viewgroup.LinearContainerController;
import com.bytedance.kmp.ec.yata.view.render.delegate.EmptyViewRenderDelegate;
import com.bytedance.kmp.ec.yata.view.render.delegate.RenderDelegateManager;
import com.bytedance.kmp.ec.yata.view.render.delegate.g;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import ha6.e;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class RenderTreeManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.view.c f252102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewExposureManager f252103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RenderDelegateManager f252104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ContainerViewDispatcher f252105d;

    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RenderTreeManager f252106a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        }

        public a(RenderTreeManager r100) {
            this.f252106a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            d r101 = e.a(r100);
            if (r101 != null) goto L5;
            return;
        L5:
            g r102 = this.f252106a.f252102a.d();
            r102.getClass();
            Intrinsics.checkNotNullParameter(r101, "node");
            Iterator<T> r103 = r102.f252017a.iterator();
        L7:
            if (r103.hasNext() == false) goto L9;
            ((com.bytedance.kmp.ec.yata.view.render.delegate.e) r103.next()).e(r101);
            goto L7
        }
    }

    public static final class b implements com.bytedance.android.ecom.arch.slice.render.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RenderTreeManager f252107a;

        public b(RenderTreeManager r100) {
            this.f252107a = r100;
        }

        @Override // com.bytedance.android.ecom.arch.slice.render.d
        public final void a(j r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            r r101 = r100.f50673a;
            String r102 = null;
            if (r101 == null) goto L5;
            View r103 = r101.f50701c;
        L7:
            if (r100.f50676d == false) goto L11;
            if (r103 == null) goto L11;
            Intrinsics.checkNotNullParameter(r103, "<this>");
            r103.setTag(R.id.android_yata_view_load_success, Boolean.TRUE);
            this.f252107a.f252103b.b(r103);
        L11:
            if (r100.f50676d == false) goto L31;
            if (r103 != null) goto L32;
            YataErrorManager r104 = this.f252107a.f252102a.f251821d;
            com.bytedance.kmp.ec.yata.common.error.d r105 = com.bytedance.kmp.ec.yata.common.error.c.a();
            r105.c("check_exposure_view_null");
            r105.d("Slice回调异常 返回创建View成功，但是View为null");
            r r106 = r100.f50673a;
            if (r106 == null) goto L18;
            SlcTemplateContext r107 = r106.f50700b;
            if (r107 == null) goto L18;
            String r108 = r107.n();
        L19:
            r105.m("template_name", r108);
            r r109 = r100.f50673a;
            if (r109 == null) goto L29;
            SlcTemplateContext r110 = r109.f50700b;
            if (r110 == null) goto L29;
            p r111 = r110.f50236x;
            if (r111 == null) goto L26;
            r102 = r111.f50691a;
        L26:
            if (r102 != null) goto L29;
            r102 = "";
        L29:
            r105.m("template_url", r102);
            r104.c(r105);
            return;
        L18:
            r108 = null;
            goto L19
        L32:
            return;
        L31:
            return;
        L5:
            r103 = null;
            goto L7
        }
    }

    public final void b() {
        Iterator r100 = ((LinkedHashMap) this.f252103b.f251866d).values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        AbsExposureHelper r101 = (AbsExposureHelper) r100.next();
        r101.getClass();
        r101.a("onPopupDidShow");
        goto L4
    }

    public final View a(ba6.b r100) {
        View r101 = this.f252104c.b(r100).b(r100, new b(this));
        if (r101 != null) goto L5;
        int r102 = EmptyViewRenderDelegate.f252008b;
        Context r103 = this.f252102a.f251818a;
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        r101 = new Space(r103);
    L5:
        r101.addOnAttachStateChangeListener(new a(this));
        return r101;
    }

    public final void d(View r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "node");
        r100.setTag(R.id.android_yata_view_node, r101);
        String r102 = r101.d();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "nodeKey");
        r100.setTag(R.id.android_yata_view_key, r102);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(this, "data");
        r100.setTag(R.id.android_yata_node_render_tree_manager, this);
        this.f252104c.b(r101.getContainer()).d(r100, r101);
        ((com.bytedance.kmp.ec.yata.view.render.tree.b) this.f252102a.f251831n.getValue()).e(r100, r101.a());
        g r103 = this.f252102a.d();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r101, "renderNode");
        Iterator<T> r104 = r103.f252017a.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((com.bytedance.kmp.ec.yata.view.render.delegate.e) r104.next()).d(r101);
        goto L4
    }

    public RenderTreeManager(TreeType r100, com.bytedance.kmp.ec.yata.view.c r101, ViewExposureManager r102) {
        Intrinsics.checkNotNullParameter(r100, "treeType");
        Intrinsics.checkNotNullParameter(r101, "viewWrapper");
        Intrinsics.checkNotNullParameter(r102, "viewExposureManager");
        this.f252102a = r101;
        this.f252103b = r102;
        this.f252104c = (RenderDelegateManager) r101.f251827j.getValue();
        this.f252105d = new ContainerViewDispatcher(r101, this);
    }

    public final void e(final View r100, ba6.g r110, final d r111) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r110, "storeData");
        Intrinsics.checkNotNullParameter(r111, "renderNode");
        if ((r111 instanceof f) == false) goto L18;
        com.bytedance.kmp.ec.yata.view.c r101 = this.f252102a;
        f r102 = (f) r111;
        ViewExposureManager r103 = this.f252103b;
        Function0<Unit> r104 = new RenderTreeManager$updateView$1(this, r100, r111);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r105 = r100.getTag(R.id.android_yata_nesting_render_tree_manager);
        if ((r105 instanceof RenderTreeManager) == false) goto L7;
        RenderTreeManager r106 = (RenderTreeManager) r105;
    L8:
        if (r106 != null) goto L10;
        r106 = new RenderTreeManager(TreeType.NESTING_TREE, r101, r103);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r106, "data");
        r100.setTag(R.id.android_yata_nesting_render_tree_manager, r106);
    L10:
        Iterator r107 = ((LinkedHashMap) r102.i().e()).entrySet().iterator();
    L12:
        if (r107.hasNext() == false) goto L17;
        Iterator r112 = ((Iterable) ((Map.Entry) r107.next()).getValue()).iterator();
    L15:
        if (r112.hasNext() == false) goto L12;
        String r108 = (String) r112.next();
        com.bytedance.kmp.ec.yata.view.render.slicewidget.yata.a r109 = r101.f251828k;
        r109.getClass();
        Intrinsics.checkNotNullParameter(r108, "nodeKey");
        Intrinsics.checkNotNullParameter(r110, "storeData");
        Intrinsics.checkNotNullParameter(r106, "treeManager");
        r109.f252095a.put(r108, new com.bytedance.kmp.ec.yata.view.render.slicewidget.yata.d(r110, r106));
        goto L15
    L17:
        r104.invoke();
        return;
    L7:
        r106 = null;
        goto L8
    L18:
        d(r100, r111);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <VG extends ViewGroup> void c(String r110, final VG r111, com.bytedance.kmp.ec.yata.view.render.controller.common.a<VG> r112, com.bytedance.kmp.ec.yata.view.render.controller.manager.exposure.e r113) {
        Intrinsics.checkNotNullParameter(r110, "containerPosition");
        Intrinsics.checkNotNullParameter(r111, "viewGroup");
        Intrinsics.checkNotNullParameter(r113, "exposureCheckConfig");
        ContainerViewDispatcher r100 = this.f252105d;
        boolean r101 = false;
        com.bytedance.kmp.ec.yata.view.render.controller.manager.exposure.e r102 = new com.bytedance.kmp.ec.yata.view.render.controller.manager.exposure.e(0);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "containerPosition");
        Intrinsics.checkNotNullParameter(r111, "viewGroup");
        Intrinsics.checkNotNullParameter(r102, "exposureCheckConfig");
        if (r112 == null) goto L5;
    L11:
        if (r112 != null) goto L13;
        String r114 = YaTaLog.f251436a;
        YaTaLog.d("ContainerViewDispatcher", new ContainerViewDispatcher$registerContainerController$1(r111));
        YataErrorManager r115 = r100.f252098a.f251821d;
        int r103 = com.bytedance.kmp.ec.yata.common.error.c.f251397a;
        com.bytedance.kmp.ec.yata.common.error.d r104 = new com.bytedance.kmp.ec.yata.common.error.d(3101, "VIEW_POSITION_CONTAINER_NOT_FOUND");
        r104.e();
        r104.c("containerPosition-" + r110);
        r104.h("controller null:" + r110);
        r104.d("不支持容器" + r110 + "对应的View类型");
        r115.c(r104);
    L14:
        if (r101 == false) goto L25;
        ViewExposureManager r116 = this.f252103b;
        r116.getClass();
        Intrinsics.checkNotNullParameter(r110, "position");
        Intrinsics.checkNotNullParameter(r111, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r113, "exposureCheckConfig");
        if (r116.f251866d.containsKey(r111) == false) goto L18;
        String r117 = YaTaLog.f251436a;
        YaTaLog.b("ViewExposureManager", "重复注册容器 Position=" + r110);
        return;
    L18:
        if ((r111 instanceof RecyclerView) == false) goto L21;
        RecyclerViewExposureHelper r105 = new RecyclerViewExposureHelper(r116.f251863a + '-' + r110, r116.f251864b, r113, (RecyclerView) r111, r116.f251870h);
        r116.f251866d.put(r111, r105);
        r116.f251867e.put(r110, r105);
        return;
    L21:
        if ((r111 instanceof LinearLayout) == false) goto L27;
        i r106 = new i(r116.f251863a + '-' + r110, r116.f251864b, r113, (LinearLayout) r111, r116.f251870h);
        r116.f251866d.put(r111, r106);
        r116.f251867e.put(r110, r106);
        return;
    L27:
        return;
    L25:
        return;
    L13:
        r100.f252101d.put(r110, r112);
        com.bytedance.kmp.ec.yata.view.c r107 = r100.f252098a;
        Intrinsics.checkNotNullParameter(r111, "viewGroup");
        Intrinsics.checkNotNullParameter(r107, "viewWrapper");
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r112.f251843b = r107;
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r112.f251844c = r111;
        r112.c();
        r101 = true;
        goto L14
    L5:
        if ((r111 instanceof LinearLayout) == false) goto L8;
        r112 = new LinearContainerController(r110);
        goto L11
    L8:
        if ((r111 instanceof RecyclerView) == false) goto L10;
        r112 = new BodyContainerController();
        goto L11
    L10:
        r112 = null;
        goto L11
    }
}
