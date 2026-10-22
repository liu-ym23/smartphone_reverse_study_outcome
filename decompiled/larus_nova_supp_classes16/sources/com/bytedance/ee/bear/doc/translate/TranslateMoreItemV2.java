package com.bytedance.ee.bear.doc.translate;

import com.bytedance.ee.bear.doc.editmodeswitchplugin.EditModeSwitchPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class TranslateMoreItemV2 extends BaseMoreItem implements ITextMoreItem {
    public static final String KEY_IS_AT_VC = "is_at_vc";
    public static final String KEY_IS_WIKI = "is_wiki";
    public static final String KEY_TOKEN = "token";
    public static final String KEY_TYPE = "type";
    private static final String NAME = "translateV2";
    public static final String TAG = "TranslateMoreItemV2";
    private DocumentPluginHost pluginHost;

    public static /* synthetic */ void a(EditModeSwitchPlugin r0) {
        lambda$translate$1(r0);
    }

    public static /* synthetic */ void b(TranslatePlugin r0) {
        lambda$translate$0(r0);
    }

    public int getIcon() {
        return 2131256049;
    }

    public int getIconTint() {
        return 2131102418;
    }

    public String getId() {
        return NAME;
    }

    public final /* synthetic */ MoreUiAction getMoreAction() {
        return ITextMoreItem.-CC.$default$getMoreAction(this);
    }

    public String getStateTips() {
        return "";
    }

    public String getUnableTips() {
        return "";
    }

    public boolean isEnable() {
        return true;
    }

    public void onDisableClick() {
    }

    private void translate() {
        this.pluginHost.findPluginToDo(TranslatePlugin.class, new g());
        this.pluginHost.findPluginToDo(EditModeSwitchPlugin.class, new h());
    }

    public String getTitle() {
        return getString(2131889332);
    }

    public boolean isVisible() {
        oj5.c r0 = getMoreInfo();
        if (r0 != null) goto L7;
        tt5.a.k(TAG, "moreInfo == null");
        return false;
    L7:
        if (r0.m() == false) goto L9;
        return false;
    L9:
        TranslatePlugin r1 = (TranslatePlugin) this.pluginHost.findPlugin(TranslatePlugin.class);
        if (r1 != null) goto L12;
        return false;
    L12:
        if (r1.isEnableTranslate() == false) goto L16;
        return true;
    L16:
        return false;
    }

    public boolean needShowBadge() {
        if (shouldShowBadgeByBusiness() == true) goto L5;
    L7:
        return false;
    L5:
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).l(NAME) == false) goto L7;
        return true;
    }

    public void onClick() {
        translate();
        if ((getMoreInfo() instanceof oj5.a) == true) goto L5;
    L7:
        getHost().a();
        return;
    L5:
        if (org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class) == null) goto L7;
        oj5.a r0 = getMoreInfo();
        int r2 = r0.getType();
        int r1 = n.a;
        n.a.a(r0);
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).c(new com.bytedance.ee.bear.more.i(getHost().getHostFragment().getArguments(), r0.c, r0.getType(), false, r0.b(), "translate", "ccm_space_translate_view", "", "", r0 instanceof oj5.f, r0.k, r0.r, r0.isOwner(), r0.L()));
        ((com.bytedance.ee.bear.k) org.koin.java.a.a(com.bytedance.ee.bear.k.class)).q(r2, "translate", "ccm_space_translate_view", null, null, null);
        goto L7
    }

    public TranslateMoreItemV2(DocumentPluginHost r1) {
        this.pluginHost = r1;
    }

    private static /* synthetic */ void lambda$translate$0(TranslatePlugin r2) {
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).b(NAME);
        r2.translate();
    }

    private static /* synthetic */ void lambda$translate$1(EditModeSwitchPlugin r0) {
        r0.hideButton();
    }
}
