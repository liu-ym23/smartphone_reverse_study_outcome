package com.bytedance.ee.bear.document.bottommenu;

import android.content.res.Configuration;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0002\u0016\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\t\u001a\u00020\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u000e0\fH\u0016J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/document/bottommenu/BottomMenuPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "actionSheet", "Lcom/bytedance/ee/bear/widgets/ActionSheet;", "currentItems", "", "Lcom/bytedance/ee/bear/document/bottommenu/BottomMenuData$Item;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onConfigurationChanged", "newConfiguration", "Landroid/content/res/Configuration;", "handleResult", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "id", "ShowBottomMenuHandler", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BottomMenuPlugin extends DocumentPlugin {
    private static final String BIZ_UTIL_SHOW_BOTTOM_MENU = "biz.util.showBottomMenu";
    public static final a Companion = null;
    private static final String TAG = "BottomMenuPlugin";
    private com.bytedance.ee.bear.widgets.a actionSheet;
    private List<BottomMenuData.Item> currentItems;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<BottomMenuData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomMenuPlugin f219167a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(BottomMenuPlugin r100) {
            this.f219167a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            BottomMenuData r102 = (BottomMenuData) r100;
            tt5.a.h(BottomMenuPlugin.TAG, "ShowBottomMenuHandler()...");
            if (r102 == null) goto L25;
            BottomMenuPlugin r103 = this.f219167a;
            BottomMenuPlugin.access$setCurrentItems$p(r103, r102.getItems());
            com.bytedance.ee.bear.widgets.a r104 = new com.bytedance.ee.bear.widgets.a(BottomMenuPlugin.access$getActivity(r103));
            Iterator<T> r105 = r102.getItems().iterator();
        L6:
            if (r105.hasNext() == false) goto L11;
            BottomMenuData.Item r106 = (BottomMenuData.Item) r105.next();
            if (r106.getStyle() == 1) goto L9;
            r104.g(r106.getText(), new com.bytedance.ee.bear.document.bottommenu.b(r103, r101, r106));
            goto L6
        L9:
            r104.i(r106.getText(), new com.bytedance.ee.bear.document.bottommenu.a(r103, r101, r106));
            goto L6
        L11:
            String r107 = r102.getTitle();
            if (r107 == null) goto L15;
            r104.k(r107);
        L15:
            if (r102.getShowCancel() == false) goto L17;
            r104.b(new c(r103, r101));
        L17:
            r104.q();
            BottomMenuPlugin.access$setActionSheet$p(r103, r104);
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public BottomMenuPlugin() {
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(BottomMenuPlugin r100) {
        return r100.getActivity();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        r100.put(BIZ_UTIL_SHOW_BOTTOM_MENU, new b(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        if (ForsetiHelper.s(((DocumentPluginHost) getHost()).getHostFragment()) == true) goto L5;
        return;
    L5:
        if (n.C(getContext()) == true) goto L7;
        return;
    L7:
        if (ku5.c.k(getContext()) == true) goto L24;
        List<BottomMenuData.Item> r101 = this.currentItems;
        List<BottomMenuData.Item> r102 = r101;
        if (r102 != null) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == false) goto L17;
        return;
    L17:
        if (Intrinsics.areEqual(((BottomMenuData.Item) ListProtector.get(r101, 0)).getId(), "ChooseCover") == false) goto L26;
        com.bytedance.ee.bear.widgets.a r104 = this.actionSheet;
        if (r104 == null) goto L27;
        r104.n();
        return;
    L27:
        return;
    L26:
        return;
    L11:
        if (r102.isEmpty() == true) goto L14;
        r103 = false;
        goto L15
    }

    public static final /* synthetic */ void access$setActionSheet$p(BottomMenuPlugin r100, com.bytedance.ee.bear.widgets.a r101) {
        r100.actionSheet = r101;
    }

    public static final /* synthetic */ void access$setCurrentItems$p(BottomMenuPlugin r100, List r101) {
        r100.currentItems = r101;
    }

    private final void handleResult(m r100, String r101) {
        if (r100 == null) goto L5;
        JSONObject r102 = new JSONObject();
        r102.put2("id", r101);
        r100.b(r102);
        return;
    }

    public static final /* synthetic */ void access$handleResult(BottomMenuPlugin r100, m r101, String r102) {
        r100.handleResult(r101, r102);
    }
}
