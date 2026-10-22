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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        public final /* synthetic */ BottomMenuPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(BottomMenuPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r7, m r8) {
            BottomMenuData r9 = (BottomMenuData) r7;
            tt5.a.h(BottomMenuPlugin.TAG, "ShowBottomMenuHandler()...");
            if (r9 == null) goto L25;
            BottomMenuPlugin r0 = this.a;
            BottomMenuPlugin.access$setCurrentItems$p(r0, r9.getItems());
            com.bytedance.ee.bear.widgets.a r2 = new com.bytedance.ee.bear.widgets.a(BottomMenuPlugin.access$getActivity(r0));
            Iterator<T> r1 = r9.getItems().iterator();
        L6:
            if (r1.hasNext() == false) goto L11;
            BottomMenuData.Item r3 = (BottomMenuData.Item) r1.next();
            if (r3.getStyle() == 1) goto L9;
            r2.g(r3.getText(), new com.bytedance.ee.bear.document.bottommenu.b(r0, r8, r3));
            goto L6
        L9:
            r2.i(r3.getText(), new com.bytedance.ee.bear.document.bottommenu.a(r0, r8, r3));
            goto L6
        L11:
            String r4 = r9.getTitle();
            if (r4 == null) goto L15;
            r2.k(r4);
        L15:
            if (r9.getShowCancel() == false) goto L17;
            r2.b(new c(r0, r8));
        L17:
            r2.q();
            BottomMenuPlugin.access$setActionSheet$p(r0, r2);
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public BottomMenuPlugin() {
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(BottomMenuPlugin r0) {
        return r0.getActivity();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put(BIZ_UTIL_SHOW_BOTTOM_MENU, new b(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r3) {
        super.onConfigurationChanged(r3);
        if (ForsetiHelper.s(((DocumentPluginHost) getHost()).getHostFragment()) == true) goto L5;
        return;
    L5:
        if (n.C(getContext()) == true) goto L7;
        return;
    L7:
        if (ku5.c.k(getContext()) == true) goto L24;
        List<BottomMenuData.Item> r4 = this.currentItems;
        List<BottomMenuData.Item> r0 = r4;
        if (r0 != null) goto L11;
    L14:
        boolean r1 = true;
    L15:
        if (r1 == false) goto L17;
        return;
    L17:
        if (Intrinsics.areEqual(((BottomMenuData.Item) ListProtector.get(r4, 0)).getId(), "ChooseCover") == false) goto L26;
        com.bytedance.ee.bear.widgets.a r5 = this.actionSheet;
        if (r5 == null) goto L27;
        r5.n();
        return;
    L27:
        return;
    L26:
        return;
    L11:
        if (r0.isEmpty() == true) goto L14;
        r1 = false;
        goto L15
    }

    public static final /* synthetic */ void access$setActionSheet$p(BottomMenuPlugin r0, com.bytedance.ee.bear.widgets.a r1) {
        r0.actionSheet = r1;
    }

    public static final /* synthetic */ void access$setCurrentItems$p(BottomMenuPlugin r0, List r1) {
        r0.currentItems = r1;
    }

    private final void handleResult(m r3, String r4) {
        if (r3 == null) goto L5;
        JSONObject r0 = new JSONObject();
        r0.put("id", r4);
        r3.b(r0);
        return;
    }

    public static final /* synthetic */ void access$handleResult(BottomMenuPlugin r0, m r1, String r2) {
        r0.handleResult(r1, r2);
    }
}
