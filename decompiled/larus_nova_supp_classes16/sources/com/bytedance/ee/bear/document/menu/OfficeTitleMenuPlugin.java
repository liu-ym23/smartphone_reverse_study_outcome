package com.bytedance.ee.bear.document.menu;

import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.plugin.permapply.OfficePermApplyPlugin;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.document.y5;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import y15.h;
import z15.e;
import z15.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfficeTitleMenuPlugin extends DocumentPluginV3 implements ITitleMenuPlugin<ChameleonPluginHost> {
    public static final String FEED_ID = "MESSAGE";
    public static final String MORE_ID = "MORE_OPERATE";
    public static final String SHARE_ID = "SHARE";
    private static final String TAG = "TitleMenuPlugin";
    private final f highPriorityInterceptor;
    private a titleMenuHandler;
    private ITitleMenuPlugin.b titleMenuListener;

    public class a extends h<MenuData> {
        public final /* synthetic */ OfficeTitleMenuPlugin g;

        /* JADX WARN: Multi-variable type inference failed */
        public a(OfficeTitleMenuPlugin r1, DocumentPluginV3 r2, vo5.a r3) {
            this.g = r1;
            super(r2.getHost().getContext(), r3);
        }
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public int getAIIconIndex() {
        int r4 = -1;
        a r5 = this.titleMenuHandler;     // Catch: Exception -> L11
        if (r5 == null) goto L13;
        List<MenuItem> r6 = r5.c;     // Catch: Exception -> L11
        if (Arrays.asList(new String[]{"CREATION_AI", "CREATION_AI_ANIMATION", "DOUBAO_AI"}).contains(((MenuItem) ListProtector.get(r6, r6.size() - 2)).getId()) == false) goto L8;
        r4 = 2;
        goto L13
    L8:
        if (Arrays.asList(new String[]{"CREATION_AI", "CREATION_AI_ANIMATION", "DOUBAO_AI"}).contains(((MenuItem) ListProtector.get(r6, r6.size() - 3)).getId()) == false) goto L13;
        r4 = 3;
    L13:
        tt5.a.h(TAG, "getAIIconPadding ret" + r4);
        return r4;
    L11:
        e = move-exception;
        tt5.a.e(TAG, "getAIIconPadding exception", e, false);
        goto L13
    }

    public int getAIIconPadding() {
        int r4 = 37;
        a r5 = this.titleMenuHandler;     // Catch: Exception -> L11
        if (r5 == null) goto L13;
        List<MenuItem> r6 = r5.c;     // Catch: Exception -> L11
        if (Arrays.asList(new String[]{"CREATION_AI", "CREATION_AI_ANIMATION", "DOUBAO_AI"}).contains(((MenuItem) ListProtector.get(r6, r6.size() - 2)).getId()) == true) goto L13;
        if (Arrays.asList(new String[]{"CREATION_AI", "CREATION_AI_ANIMATION", "DOUBAO_AI"}).contains(((MenuItem) ListProtector.get(r6, r6.size() - 3)).getId()) == false) goto L13;
        r4 = 74;
    L13:
        tt5.a.h(TAG, "getAIIconPadding ret" + r4);
        return r4;
    L11:
        e = move-exception;
        tt5.a.e(TAG, "getAIIconPadding exception", e, false);
        goto L13
    }

    public OfficeTitleMenuPlugin() {
        this.highPriorityInterceptor = new f();
    }

    private y3 getOfficeDocMetaData() {
        return getDocumentMetadata();
    }

    public String getPluginId() {
        return y5.c;
    }

    public static /* synthetic */ f access$100(OfficeTitleMenuPlugin r0) {
        return r0.highPriorityInterceptor;
    }

    private List<ITitleMenuPlugin.a> buildTitleMenuItemStates(List<MenuItem> r5) {
        if (r5 == null) goto L16;
        if (r5.isEmpty() == true) goto L16;
        ArrayList r0 = new ArrayList(r5.size());
        Iterator<MenuItem> r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L14;
        MenuItem r1 = r6.next();
        if (r1 == null) goto L8;
        r0.add(new ITitleMenuPlugin.a(r1.getId(), r1.isEnable()));
        goto L8
    L14:
        return Collections.unmodifiableList(r0);
    L16:
        return Collections.emptyList();
    }

    private boolean dispatchTitleMenuClick(String r5) {
        ITitleMenuPlugin.b r0 = this.titleMenuListener;
        if (r0 != null) goto L10;
        return false;
    L10:
        r0.onTitleMenuClick(r5);     // Catch: Throwable -> L7
        return false;
    L7:
        th = move-exception;
        tt5.a.e(TAG, "dispatchTitleMenuClick failed, menuId = " + r5, th, false);
        return false;
    }

    private void dispatchTitleMenusUpdated(List<MenuItem> r4) {
        ITitleMenuPlugin.b r0 = this.titleMenuListener;
        if (r0 != null) goto L10;
        return;
    L10:
        r0.a(buildTitleMenuItemStates(r4));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        tt5.a.e(TAG, "dispatchTitleMenusUpdated failed", th, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setAssociatedNoPermMenus(List<MenuItem> r1) {
        OfficePermApplyPlugin r2 = (OfficePermApplyPlugin) findPlugin(OfficePermApplyPlugin.class);
    }

    public void getBridgeHandlers(Map<String, i<?>> r5) {
        ChameleonPluginHost r0 = getHost();
        if (r0 != null) goto L12;
        tt5.a.d(TAG, "getBridgeHandlers fail: host is null");
        return;
    L12:
        vo5.a r1 = r0.getUserComponent();     // Catch: Throwable -> L8
    L10:
        a r2 = new a(this, this, r1);
        this.titleMenuHandler = r2;
        r5.put("biz.navigation.setMenu", r2);
        return;
    L8:
        th = move-exception;
        tt5.a.e(TAG, "get userComponentDelegate fail", th, false);
        r1 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setMenus(List<MenuItem> r3) {
        setAssociatedNoPermMenus(r3);
        TitleBar r0 = getTitleBar();
        if (r0 == null) goto L6;
        r0.j(r3, TitleBar.MenuType.Right);
        return;
    }

    @Override // com.bytedance.ee.bear.document.menu.ITitleMenuPlugin
    public void setTitleMenuListener(ITitleMenuPlugin.b r1) {
        this.titleMenuListener = r1;
        if (r1 == null) goto L8;
        a r2 = this.titleMenuHandler;
        if (r2 == null) goto L9;
        dispatchTitleMenusUpdated(r2.c);
        return;
    L9:
        return;
    }

    public static /* synthetic */ void access$000(OfficeTitleMenuPlugin r0, List r1) {
        r0.dispatchTitleMenusUpdated(r1);
    }

    public static /* synthetic */ boolean access$200(OfficeTitleMenuPlugin r0, String r1) {
        return r0.dispatchTitleMenuClick(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$300(OfficeTitleMenuPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public void onAttachToUIContainer(ChameleonPluginHost r2, t r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r2, r3);
        f r4 = this.highPriorityInterceptor;
        r4.getClass();
        Intrinsics.checkNotNullParameter(this, "plugin");
        Iterator<e> r5 = r4.a.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().a(r2, this);
        goto L4
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r2, t r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r2, r3);
        f r4 = this.highPriorityInterceptor;
        r4.getClass();
        Intrinsics.checkNotNullParameter(this, "plugin");
        Iterator<e> r5 = r4.a.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().b(r2, this);
        goto L4
    }

    @Override // com.bytedance.ee.bear.document.menu.ITitleMenuPlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.document.menu.ITitleMenuPlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }
}
