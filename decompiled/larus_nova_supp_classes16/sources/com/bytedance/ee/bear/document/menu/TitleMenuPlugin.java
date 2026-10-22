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
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import y15.c;
import z15.e;
import z15.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class TitleMenuPlugin extends DocumentPluginV2 {
    public static final String FEED_ID = "MESSAGE";
    public static final String MORE_ID = "MORE_OPERATE";
    public static final String SHARE_ID = "SHARE";
    private static final String TAG = "TitleMenuPlugin";
    private final f highPriorityInterceptor;
    private a titleMenuHandler;

    public class a extends c<MenuData> {
        public final /* synthetic */ TitleMenuPlugin i;

        @Override // y15.c
        public final void e(List<MenuItem> r3) {
            super.e(r3);
            y3 r0 = ((e4) this.i.getHostAbility(e4.class)).getDocumentMetadata();
            if (r0.allowCustomTitleMenu() == true) goto L5;
        L9:
            tt5.a.h(TitleMenuPlugin.TAG, "Custom title menu disabled");
            return;
        L5:
            if (r0.isAnnounceTemplatePreview() == true) goto L9;
            this.i.setMenus(r3);
        }

        @Override // y15.c
        public final void c(MenuItem r4, View r5) {
            if (TitleMenuPlugin.access$000(this.i).a(r4.getId(), this.i, r5) == false) goto L5;
            return;
        L5:
            super.c(r4, r5);
            rz4.a r6 = (rz4.a) this.i.getHostAbilityOrNull(rz4.a.class);
            if (r6 == null) goto L9;
            r6.onTitleMenuClick(r4.getId());
        L9:
            if ("SHARE".equals(r4.getId()) == false) goto L11;
        L14:
            BaseSelectionPlugin r7 = (BaseSelectionPlugin) TitleMenuPlugin.access$100(this.i, BaseSelectionPlugin.class);
            if (r7 != null) goto L18;
            tt5.a.k(TitleMenuPlugin.TAG, "finish action mode failed, selectionPlugin == null");
            return;
        L18:
            tt5.a.b(TitleMenuPlugin.TAG, "clear selection by click title bar");
            r7.clearSelection();
            if (ForsetiHelper.s(this.i.getHost().getHostFragment()) == false) goto L23;
            r7.jsClearDocxSelection();
            return;
        L23:
            return;
        L11:
            if ("MORE_OPERATE".equals(r4.getId()) == true) goto L14;
            if ("MESSAGE".equals(r4.getId()) == true) goto L14;
        }

        public a(TitleMenuPlugin r1, PluginHost r2, y3 r3) {
            this.i = r1;
            super(r2.getContext(), r3, r2.getUserComponent());
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
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

    public TitleMenuPlugin() {
        this.highPriorityInterceptor = new f();
    }

    public static /* synthetic */ f access$000(TitleMenuPlugin r0) {
        return r0.highPriorityInterceptor;
    }

    private void setAssociatedNoPermMenus(List<MenuItem> r3) {
        PermApplyPlugin r0 = (PermApplyPlugin) findPlugin(PermApplyPlugin.class);
        if (r0 != null) goto L5;
        return;
    L5:
        if (getDocViewModel() != null) goto L7;
    L10:
        r0.setAssociatedNoPermMenus(null);
        return;
    L7:
        if (TextUtils.isEmpty(getDocViewModel().getAssociateAppUrl()) == true) goto L10;
        r0.setAssociatedNoPermMenus(r3);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r4) {
        PluginHost r0 = getHost();
        if (r0 != null) goto L6;
        tt5.a.d(TAG, "getBridgeHandlers fail: host is null");
        return;
    L6:
        a r1 = new a(this, r0, getDocumentMetadata());
        this.titleMenuHandler = r1;
        r4.put("biz.navigation.setMenu", r1);
    }

    public void setMenus(List<MenuItem> r3) {
        setAssociatedNoPermMenus(r3);
        TitleBar r0 = getTitleBar();
        if (r0 == null) goto L6;
        r0.j(r3, TitleBar.MenuType.Right);
        return;
    }

    public static /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$100(TitleMenuPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r2, t r3) {
        super.onAttachToUIContainer(r2, r3);
        f r4 = this.highPriorityInterceptor;
        r4.getClass();
        Intrinsics.checkNotNullParameter(this, "plugin");
        Iterator<e> r5 = r4.a.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().a(r2, this);
        goto L4
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r2, t r3) {
        super.onDetachFromUIContainer(r2, r3);
        f r4 = this.highPriorityInterceptor;
        r4.getClass();
        Intrinsics.checkNotNullParameter(this, "plugin");
        Iterator<e> r5 = r4.a.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().b(r2, this);
        goto L4
    }
}
