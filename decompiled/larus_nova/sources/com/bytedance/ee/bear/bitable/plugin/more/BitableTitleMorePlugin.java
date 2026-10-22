package com.bytedance.ee.bear.bitable.plugin.more;

import android.content.res.Configuration;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.app.BitableAppDocumentPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public class BitableTitleMorePlugin extends DocumentPlugin implements p {
    private static final String BIZ_BITABLE_BASE_MORE = "biz.bitable.baseMore";
    public static final String MENU_ID_BASE_MORE = "BASE_MORE";
    public static final String MENU_ID_BASE_MORE_PRO = "PRO";
    private static final String TAG = "BitableTitleMorePlugin";
    private boolean isPad;
    private boolean mIsLandscape;
    private g mMenuPanel;
    private b toShowMenusCallback;

    public class a implements i<BitableMoreModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableTitleMorePlugin f214929a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(BitableTitleMorePlugin r100) {
            this.f214929a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            BitableMoreModel r102 = (BitableMoreModel) r100;
            tt5.a.h(BitableTitleMorePlugin.TAG, "show base more, mIsLandscape:" + BitableTitleMorePlugin.access$100(this.f214929a));
            TitleBar r103 = BitableTitleMorePlugin.access$200(this.f214929a);
            if (r103 != null) goto L5;
            return;
        L5:
            if (BitableTitleMorePlugin.access$300(this.f214929a) != null) goto L10;
            FragmentActivity r104 = ((DocumentPluginHost) this.f214929a.getHost()).getActivity();
            if (com.bytedance.ee.util.ui.b.a(r104) == true) goto L9;
            tt5.a.d(BitableTitleMorePlugin.TAG, "show base more failed: host activity is unavailable");
            return;
        L9:
            BitableTitleMorePlugin.access$302(this.f214929a, new g(r104));
        L10:
            View r105 = r103.findMenuView(BitableTitleMorePlugin.MENU_ID_BASE_MORE);
            if ((this.f214929a.getHost() instanceof BitableAppDocumentPluginHost) == false) goto L13;
        L16:
            boolean r106 = true;
        L17:
            if (r106 == false) goto L21;
            View r107 = r103.findMenuView("menu_app_close");
            if (r107 == null) goto L21;
            r105 = r107;
        L21:
            if (r105 != null) goto L26;
            com.bytedance.ee.bear.bitable.plugin.more.a r108 = (com.bytedance.ee.bear.bitable.plugin.more.a) ((DocumentPluginHost) this.f214929a.getHost()).getHostAbilityOrNull(com.bytedance.ee.bear.bitable.plugin.more.a.class);
            if (r108 == null) goto L26;
            r105 = r108.getMorePanelAnchorView();
        L26:
            if (r102.hidden == true) goto L30;
            if (r105 != null) goto L30;
            tt5.a.d(BitableTitleMorePlugin.TAG, "show base more failed: anchor view is unavailable");
        L30:
            if (r102.hidden == false) goto L37;
            g r109 = BitableTitleMorePlugin.access$300(this.f214929a);
            com.larksuite.component.universe_design.menu.c r110 = r109.f214943d;
            if (r110 == null) goto L34;
            r110.a();
        L34:
            lk5.a r111 = r109.f214944e;
            if (r111 == null) goto L51;
            r111.dismiss();
            return;
        L51:
            return;
        L37:
            if (r105 == null) goto L53;
            g r112 = BitableTitleMorePlugin.access$300(this.f214929a);
            ArrayList<BitableMoreItemInfo> r113 = r102.normalPart;
            ArrayList<BitableMoreItemInfo> r114 = r102.undoRedo;
            r112.getClass();
            int r115 = f.f214937c;
            r112.f214941b = f.a.a(r113, r114);
            g r116 = BitableTitleMorePlugin.access$300(this.f214929a);
            c r117 = new c(r101);
            r116.getClass();
            Intrinsics.checkNotNullParameter(r117, "listener");
            r116.f214942c = r117;
            if (BitableTitleMorePlugin.access$400(this.f214929a) == false) goto L41;
        L47:
            BitableTitleMorePlugin.access$300(this.f214929a).b(r105);
            return;
        L41:
            if (BitableTitleMorePlugin.access$100(this.f214929a) == false) goto L47;
            BaseUnspecifiedOrientationPlugin r118 = (BaseUnspecifiedOrientationPlugin) BitableTitleMorePlugin.access$500(this.f214929a, BaseUnspecifiedOrientationPlugin.class);
            if (r118 == null) goto L45;
            r118.onOrientationSupportPanelShowing(this.f214929a);
        L46:
            BitableTitleMorePlugin.access$300(this.f214929a).f214946g = new d(this, r118);
            BitableTitleMorePlugin.access$602(this.f214929a, new com.bytedance.ee.bear.bitable.plugin.more.b(this, r105));
            return;
        L45:
            tt5.a.d(BitableTitleMorePlugin.TAG, "orientationPlugin is null, don't forcePortrait");
            goto L46
        L53:
            return;
        L13:
            if (((DocumentPluginHost) this.f214929a.getHost()).getHostAbilityOrNull(com.bytedance.ee.bear.bitable.app.chameleon.d.class) != null) goto L16;
            r106 = false;
            goto L17
        }
    }

    public interface b {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.document.orientation.p
    public boolean shouldDisableLandscape() {
        return true;
    }

    public BitableTitleMorePlugin() {
        this.isPad = ku5.c.k(LarkContext.getApplication());
    }

    public static /* synthetic */ boolean access$100(BitableTitleMorePlugin r100) {
        return r100.mIsLandscape;
    }

    public static /* synthetic */ TitleBar access$200(BitableTitleMorePlugin r100) {
        return r100.getTitleBar();
    }

    public static /* synthetic */ g access$300(BitableTitleMorePlugin r100) {
        return r100.mMenuPanel;
    }

    public static /* synthetic */ boolean access$400(BitableTitleMorePlugin r100) {
        return r100.isPad;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        r100.put(BIZ_BITABLE_BASE_MORE, new a(this));
    }

    public void onAttachToHost(DocumentPluginHost r100) {
        super.onAttachToHost(r100);
        y15.d.e(MENU_ID_BASE_MORE, R.drawable.ud_icon_more_outlined, R.color.facade_selector_icon_n1);
        y15.d.e(MENU_ID_BASE_MORE_PRO, R.drawable.ud_icon_bitable_authorization_outlined, R.color.facade_selector_icon_n1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        if (r100 == null) goto L26;
        int r101 = r100.orientation;
        if (r101 != 2) goto L8;
        Boolean r102 = Boolean.TRUE;
    L12:
        if (this.mMenuPanel != null) goto L14;
    L24:
        this.mIsLandscape = Boolean.TRUE.equals(r102);
        return;
    L14:
        if (this.mIsLandscape == r102.booleanValue()) goto L24;
        tt5.a.h(TAG, "dismiss menu panel by orientation changed, toShowMenusCallback:" + this.toShowMenusCallback);
        b r103 = this.toShowMenusCallback;
        if (r103 == null) goto L18;
        com.bytedance.ee.bear.bitable.plugin.more.b r104 = (com.bytedance.ee.bear.bitable.plugin.more.b) r103;
        a r105 = r104.f214930a;
        View r106 = r104.f214931b;
        r105.getClass();
        r106.getViewTreeObserver().addOnGlobalLayoutListener(new e(r105, r106));
        this.toShowMenusCallback = null;
        goto L24
    L18:
        g r107 = this.mMenuPanel;
        com.larksuite.component.universe_design.menu.c r108 = r107.f214943d;
        if (r108 == null) goto L21;
        r108.a();
    L21:
        lk5.a r109 = r107.f214944e;
        if (r109 == null) goto L24;
        r109.dismiss();
        goto L24
    L8:
        if (r101 != 1) goto L10;
        r102 = Boolean.FALSE;
        goto L12
    L10:
        r102 = null;
        goto L12
    }

    public void onDetachFromHost(DocumentPluginHost r100) {
        super.onDetachFromHost(r100);
        this.toShowMenusCallback = null;
        g r101 = this.mMenuPanel;
        if (r101 == null) goto L12;
        com.larksuite.component.universe_design.menu.c r102 = r101.f214943d;
        if (r102 == null) goto L7;
        r102.a();
    L7:
        r101.f214943d = null;
        lk5.a r103 = r101.f214944e;
        if (r103 == null) goto L10;
        r103.release();
    L10:
        r101.f214944e = null;
        r101.f214946g = null;
        r101.f214942c = null;
        this.mMenuPanel = null;
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((DocumentPluginHost) r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r100) {
        onDetachFromHost((DocumentPluginHost) r100);
    }

    public static /* synthetic */ g access$302(BitableTitleMorePlugin r100, g r101) {
        r100.mMenuPanel = r101;
        return r101;
    }

    public static /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$500(BitableTitleMorePlugin r100, Class r101) {
        return r100.findPlugin(r101);
    }

    public static /* synthetic */ b access$602(BitableTitleMorePlugin r100, b r101) {
        r100.toShowMenusCallback = r101;
        return r101;
    }
}
