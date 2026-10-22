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
import com.monitor.cloudmessage.consts.CloudControlInf;
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

/* JADX INFO: loaded from: classes16.dex */
public class OfficeTitleMenuPlugin extends DocumentPluginV3 implements ITitleMenuPlugin<ChameleonPluginHost> {
    public static final String FEED_ID = "MESSAGE";
    public static final String MORE_ID = "MORE_OPERATE";
    public static final String SHARE_ID = "SHARE";
    private static final String TAG = "TitleMenuPlugin";
    private final f highPriorityInterceptor;
    private a titleMenuHandler;
    private ITitleMenuPlugin.b titleMenuListener;

    public class a extends h<MenuData> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ OfficeTitleMenuPlugin f220250g;

        public a(OfficeTitleMenuPlugin r100, DocumentPluginV3 r101, vo5.a r102) {
            this.f220250g = r100;
            super(r101.getHost().getContext(), r102);
        }
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3, com.ss.android.lark.chameleon.AbsChameleonPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public int getAIIconIndex() {
        int r100 = -1;
        a r101 = this.titleMenuHandler;     // Catch: Exception -> L11
        if (r101 == null) goto L13;
        List<MenuItem> r102 = r101.f565655c;     // Catch: Exception -> L11
        if (Arrays.asList(new String[]{"CREATION_AI", "CREATION_AI_ANIMATION", "DOUBAO_AI"}).contains(((MenuItem) ListProtector.get(r102, r102.size() - 2)).getId()) == false) goto L8;
        r100 = 2;
        goto L13
    L8:
        if (Arrays.asList(new String[]{"CREATION_AI", "CREATION_AI_ANIMATION", "DOUBAO_AI"}).contains(((MenuItem) ListProtector.get(r102, r102.size() - 3)).getId()) == false) goto L13;
        r100 = 3;
    L13:
        tt5.a.h(TAG, "getAIIconPadding ret" + r100);
        return r100;
    L11:
        e = move-exception;
        tt5.a.e(TAG, "getAIIconPadding exception", e, false);
        goto L13
    }

    public int getAIIconPadding() {
        int r100 = 37;
        a r101 = this.titleMenuHandler;     // Catch: Exception -> L11
        if (r101 == null) goto L13;
        List<MenuItem> r102 = r101.f565655c;     // Catch: Exception -> L11
        if (Arrays.asList(new String[]{"CREATION_AI", "CREATION_AI_ANIMATION", "DOUBAO_AI"}).contains(((MenuItem) ListProtector.get(r102, r102.size() - 2)).getId()) == true) goto L13;
        if (Arrays.asList(new String[]{"CREATION_AI", "CREATION_AI_ANIMATION", "DOUBAO_AI"}).contains(((MenuItem) ListProtector.get(r102, r102.size() - 3)).getId()) == false) goto L13;
        r100 = 74;
    L13:
        tt5.a.h(TAG, "getAIIconPadding ret" + r100);
        return r100;
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

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin
    public String getPluginId() {
        return y5.f222534c;
    }

    public static /* synthetic */ f access$100(OfficeTitleMenuPlugin r100) {
        return r100.highPriorityInterceptor;
    }

    private List<ITitleMenuPlugin.a> buildTitleMenuItemStates(List<MenuItem> r100) {
        if (r100 == null) goto L16;
        if (r100.isEmpty() == true) goto L16;
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<MenuItem> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L14;
        MenuItem r103 = r102.next();
        if (r103 == null) goto L8;
        r101.add(new ITitleMenuPlugin.a(r103.getId(), r103.isEnable()));
        goto L8
    L14:
        return Collections.unmodifiableList(r101);
    L16:
        return Collections.emptyList();
    }

    private boolean dispatchTitleMenuClick(String r100) {
        ITitleMenuPlugin.b r101 = this.titleMenuListener;
        if (r101 != null) goto L10;
        return false;
    L10:
        r101.onTitleMenuClick(r100);     // Catch: Throwable -> L7
        return false;
    L7:
        th = move-exception;
        tt5.a.e(TAG, "dispatchTitleMenuClick failed, menuId = " + r100, th, false);
        return false;
    }

    private void dispatchTitleMenusUpdated(List<MenuItem> r100) {
        ITitleMenuPlugin.b r101 = this.titleMenuListener;
        if (r101 != null) goto L10;
        return;
    L10:
        r101.a(buildTitleMenuItemStates(r100));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        tt5.a.e(TAG, "dispatchTitleMenusUpdated failed", th, false);
    }

    private void setAssociatedNoPermMenus(List<MenuItem> r100) {
        OfficePermApplyPlugin r101 = (OfficePermApplyPlugin) findPlugin(OfficePermApplyPlugin.class);
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        ChameleonPluginHost r101 = getHost();
        if (r101 != null) goto L12;
        tt5.a.d(TAG, "getBridgeHandlers fail: host is null");
        return;
    L12:
        vo5.a r102 = r101.getUserComponent();     // Catch: Throwable -> L8
    L10:
        a r103 = new a(this, this, r102);
        this.titleMenuHandler = r103;
        r100.put("biz.navigation.setMenu", r103);
        return;
    L8:
        th = move-exception;
        tt5.a.e(TAG, "get userComponentDelegate fail", th, false);
        r102 = null;
        goto L10
    }

    public void setMenus(List<MenuItem> r100) {
        setAssociatedNoPermMenus(r100);
        TitleBar r101 = getTitleBar();
        if (r101 == null) goto L6;
        r101.j(r100, TitleBar.MenuType.Right);
        return;
    }

    @Override // com.bytedance.ee.bear.document.menu.ITitleMenuPlugin
    public void setTitleMenuListener(ITitleMenuPlugin.b r100) {
        this.titleMenuListener = r100;
        if (r100 == null) goto L8;
        a r101 = this.titleMenuHandler;
        if (r101 == null) goto L9;
        dispatchTitleMenusUpdated(r101.f565655c);
        return;
    L9:
        return;
    }

    public static /* synthetic */ void access$000(OfficeTitleMenuPlugin r100, List r101) {
        r100.dispatchTitleMenusUpdated(r101);
    }

    public static /* synthetic */ boolean access$200(OfficeTitleMenuPlugin r100, String r101) {
        return r100.dispatchTitleMenuClick(r101);
    }

    public static /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$300(OfficeTitleMenuPlugin r100, Class r101) {
        return r100.findPlugin(r101);
    }

    public void onAttachToUIContainer(ChameleonPluginHost r100, t r101) {
        super.onAttachToUIContainer(r100, r101);
        f r102 = this.highPriorityInterceptor;
        r102.getClass();
        Intrinsics.checkNotNullParameter(this, CloudControlInf.PLUGIN);
        Iterator<e> r103 = r102.f569668a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().a(r100, this);
        goto L4
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r100, t r101) {
        super.onDetachFromUIContainer(r100, r101);
        f r102 = this.highPriorityInterceptor;
        r102.getClass();
        Intrinsics.checkNotNullParameter(this, CloudControlInf.PLUGIN);
        Iterator<e> r103 = r102.f569668a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().b(r100, this);
        goto L4
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r100, t r101) {
        onAttachToUIContainer((ChameleonPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r100, t r101) {
        onDetachFromUIContainer((ChameleonPluginHost) r100, r101);
    }
}
