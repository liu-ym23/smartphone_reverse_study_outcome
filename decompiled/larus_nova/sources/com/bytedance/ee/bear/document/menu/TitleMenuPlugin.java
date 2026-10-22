package com.bytedance.ee.bear.document.menu;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.e4;
import com.bytedance.ee.bear.document.permapply.PermApplyPlugin;
import com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import y15.c;
import z15.e;
import z15.f;

/* JADX INFO: loaded from: classes16.dex */
public class TitleMenuPlugin extends DocumentPluginV2 {
    public static final String FEED_ID = "MESSAGE";
    public static final String MORE_ID = "MORE_OPERATE";
    public static final String SHARE_ID = "SHARE";
    private static final String TAG = "TitleMenuPlugin";
    private final f highPriorityInterceptor;
    private a titleMenuHandler;

    public class a extends c<MenuData> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ TitleMenuPlugin f220251i;

        @Override // y15.c
        public final void e(List<MenuItem> r100) {
            super.e(r100);
            y3 r101 = ((e4) this.f220251i.getHostAbility(e4.class)).getDocumentMetadata();
            if (r101.allowCustomTitleMenu() == true) goto L5;
        L9:
            tt5.a.h(TitleMenuPlugin.TAG, "Custom title menu disabled");
            return;
        L5:
            if (r101.isAnnounceTemplatePreview() == true) goto L9;
            this.f220251i.setMenus(r100);
        }

        @Override // y15.c
        public final void c(MenuItem r100, View r101) {
            if (TitleMenuPlugin.access$000(this.f220251i).a(r100.getId(), this.f220251i, r101) == false) goto L5;
            return;
        L5:
            super.c(r100, r101);
            rz4.a r102 = (rz4.a) this.f220251i.getHostAbilityOrNull(rz4.a.class);
            if (r102 == null) goto L9;
            r102.onTitleMenuClick(r100.getId());
        L9:
            if ("SHARE".equals(r100.getId()) == false) goto L11;
        L14:
            BaseSelectionPlugin r103 = (BaseSelectionPlugin) TitleMenuPlugin.access$100(this.f220251i, BaseSelectionPlugin.class);
            if (r103 != null) goto L18;
            tt5.a.k(TitleMenuPlugin.TAG, "finish action mode failed, selectionPlugin == null");
            return;
        L18:
            tt5.a.b(TitleMenuPlugin.TAG, "clear selection by click title bar");
            r103.clearSelection();
            if (ForsetiHelper.s(this.f220251i.getHost().getHostFragment()) == false) goto L23;
            r103.jsClearDocxSelection();
            return;
        L23:
            return;
        L11:
            if ("MORE_OPERATE".equals(r100.getId()) == true) goto L14;
            if ("MESSAGE".equals(r100.getId()) == true) goto L14;
        }

        public a(TitleMenuPlugin r100, PluginHost r101, y3 r102) {
            this.f220251i = r100;
            super(r101.getContext(), r102, r101.getUserComponent());
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public int getAIIconIndex() {
        int r100 = -1;
        a r101 = this.titleMenuHandler;     // Catch: Exception -> L11
        if (r101 == null) goto L13;
        List<MenuItem> r102 = r101.f565636c;     // Catch: Exception -> L11
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
        List<MenuItem> r102 = r101.f565636c;     // Catch: Exception -> L11
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

    public TitleMenuPlugin() {
        this.highPriorityInterceptor = new f();
    }

    public static /* synthetic */ f access$000(TitleMenuPlugin r100) {
        return r100.highPriorityInterceptor;
    }

    private void setAssociatedNoPermMenus(List<MenuItem> r100) {
        PermApplyPlugin r101 = (PermApplyPlugin) findPlugin(PermApplyPlugin.class);
        if (r101 != null) goto L5;
        return;
    L5:
        if (getDocViewModel() != null) goto L7;
    L10:
        r101.setAssociatedNoPermMenus(null);
        return;
    L7:
        if (TextUtils.isEmpty(getDocViewModel().getAssociateAppUrl()) == true) goto L10;
        r101.setAssociatedNoPermMenus(r100);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        PluginHost r101 = getHost();
        if (r101 != null) goto L6;
        tt5.a.d(TAG, "getBridgeHandlers fail: host is null");
        return;
    L6:
        a r102 = new a(this, r101, getDocumentMetadata());
        this.titleMenuHandler = r102;
        r100.put("biz.navigation.setMenu", r102);
    }

    public void setMenus(List<MenuItem> r100) {
        setAssociatedNoPermMenus(r100);
        TitleBar r101 = getTitleBar();
        if (r101 == null) goto L6;
        r101.j(r100, TitleBar.MenuType.Right);
        return;
    }

    public static /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$100(TitleMenuPlugin r100, Class r101) {
        return r100.findPlugin(r101);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r100, t r101) {
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

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r100, t r101) {
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
}
