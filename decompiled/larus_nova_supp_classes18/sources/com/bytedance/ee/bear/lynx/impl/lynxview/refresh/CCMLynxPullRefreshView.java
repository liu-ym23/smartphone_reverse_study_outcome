package com.bytedance.ee.bear.lynx.impl.lynxview.refresh;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.CircleRefreshHeader;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LoadMoreFooter;
import com.bytedance.ee.docsdk.impl.utils.keyboard.producer.BaseKeyboardHeightProducer;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import ge5.b;
import ge5.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0016\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0017J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0017J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0017J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0011H\u0014J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\bH\u0007J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\bH\u0007R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/lynx/impl/lynxview/refresh/CCMLynxPullRefreshView;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "mEnableRefresh", "", "mEnableLoadMore", "finishRefresh", "", "params", "Lcom/lynx/react/bridge/ReadableMap;", "finishLoadMore", "autoStartRefresh", "createView", "Landroid/content/Context;", "insertChild", "child", "Lcom/lynx/tasm/behavior/ui/LynxBaseUI;", "index", "", "removeChild", "needCustomLayout", "setEnableRefresh", "enable", "setEnableLoadMore", "Companion", "features-lynx-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CCMLynxPullRefreshView extends UIGroup<SmartRefreshLayout> {
    public boolean a;
    public boolean b;

    public static final class a {
    }

    static {
    }

    public final boolean needCustomLayout() {
        return true;
    }

    public CCMLynxPullRefreshView(LynxContext r1) {
        super(r1);
        this.a = true;
        this.b = true;
    }

    @LynxUIMethod
    public void autoStartRefresh(ReadableMap r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        tt5.a.h("CCMLynxPullRefreshView", "autoStartRefresh -> params = " + r4);
        ((LynxUI) this).mView.r(0, 300, 1.0f, false);
    }

    public final View createView(Context r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        this.a = true;
        this.b = true;
        SmartRefreshLayout r0 = new SmartRefreshLayout(r2);
        r0.setNestedScrollingEnabled(false);
        r0.A = this.a;
        r0.g(this.b);
        r0.W = new ge5.a(this);
        r0.i(new b(this));
        r0.p0 = new c(this);
        return r0;
    }

    @LynxUIMethod
    public void finishLoadMore(ReadableMap r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        tt5.a.h("CCMLynxPullRefreshView", "finishLoadMore -> params = " + r3);
        if (r3.getBoolean("has_more", true) == false) goto L5;
        ((LynxUI) this).mView.s();
        return;
    L5:
        ((LynxUI) this).mView.t();
    }

    @LynxUIMethod
    public void finishRefresh(ReadableMap r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        tt5.a.h("CCMLynxPullRefreshView", "finishRefresh -> params = " + r3);
        ((LynxUI) this).mView.h(true);
    }

    public final void removeChild(LynxBaseUI r2) {
        Intrinsics.checkNotNullParameter(r2, "child");
        if ((r2 instanceof LynxUI) == false) goto L6;
        ((LynxBaseUI) this).mChildren.remove(r2);
        return;
    }

    @LynxProp(defaultBoolean = BaseKeyboardHeightProducer.VISIBLE_TRUE, name = "enable-loadmore")
    public final void setEnableLoadMore(boolean r3) {
        tt5.a.b("CCMLynxPullRefreshView", "enable-loadmore:" + r3);
        this.b = r3;
        SmartRefreshLayout r0 = ((LynxUI) this).mView;
        if (r0 == null) goto L6;
        r0.g(r3);
        return;
    }

    @LynxProp(defaultBoolean = BaseKeyboardHeightProducer.VISIBLE_TRUE, name = "enable-refresh")
    public final void setEnableRefresh(boolean r3) {
        tt5.a.b("CCMLynxPullRefreshView", "enable-refresh:" + r3);
        this.a = r3;
        SmartRefreshLayout r0 = ((LynxUI) this).mView;
        if (r0 == null) goto L6;
        r0.A = r3;
        return;
    }

    public final void insertChild(LynxBaseUI r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "child");
        tt5.a.b("CCMLynxPullRefreshView", "insertChild " + r3 + ' ' + r4);
        onInsertChild(r3, r4);
        if ((r3 instanceof CCMLynxRefreshHeader) == false) goto L6;
        ((LynxUI) this).mView.G(new CircleRefreshHeader(getLynxContext()), d.a(60));
        return;
    L6:
        if ((r3 instanceof CCMLynxRefreshFooter) == false) goto L9;
        ((LynxUI) this).mView.F(new LoadMoreFooter(getLynxContext()), -2);
        return;
    L9:
        if ((r3 instanceof LynxUI) == false) goto L14;
        ((LynxUI) this).mView.E(((LynxUI) r3).getView());
        return;
    }
}
