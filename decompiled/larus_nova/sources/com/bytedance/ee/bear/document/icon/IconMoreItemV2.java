package com.bytedance.ee.bear.document.icon;

import android.os.Bundle;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.larus.nova.R;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/document/icon/IconMoreItemV2;", "Lcom/bytedance/ee/bear/more/moreprotocol/BaseMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/ITextMoreItem;", "pluginHost", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "<init>", "(Lcom/bytedance/ee/bear/document/DocumentPluginHost;)V", "isEnable", "", "getIcon", "", "getIconTint", "getTitle", "", "getStateTips", "onDisableClick", "", SendEventContainerMethodParamModel.EventKinds.onClick, "getId", "getUnableTips", "isVisible", "needShowBadge", "openIconSetting", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IconMoreItemV2 extends BaseMoreItem implements ITextMoreItem {
    public static final a Companion = null;
    public static final String NAME = "iconV2";
    private static final Set<sbb.e> sSupportDocumentTypes = null;
    private final DocumentPluginHost pluginHost;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements com.bytedance.ee.bear.browser.plugin.g<IconPlugin> {
        public b() {
        }

        @Override // com.bytedance.ee.bear.browser.plugin.g
        public final void a(com.bytedance.ee.bear.browser.plugin.f r100) {
            IconPlugin r101 = (IconPlugin) r100;
            Intrinsics.checkNotNullParameter(r101, CloudControlInf.PLUGIN);
            r101.showIconSelectList();
            ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).b(IconMoreItemV2.NAME);
        }
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return R.drawable.ud_icon_emoji_outlined;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return R.color.icon_n1;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return NAME;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public final /* synthetic */ MoreUiAction getMoreAction() {
        return ITextMoreItem.CC.$default$getMoreAction(this);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getStateTips() {
        return "";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onDisableClick() {
    }

    static {
        Companion = new a();
        sSupportDocumentTypes = SetsKt.setOf(new sbb.e[]{sbb.e.f541296g, sbb.e.f541297h, sbb.e.f541300k});
    }

    private final void openIconSetting() {
        this.pluginHost.findPluginToDo(IconPlugin.class, new b());
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getUnableTips() {
        return this.pluginHost.getContext().getString(R.string.Doc_Doc_IconNoPermission);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        Set<sbb.e> r100 = sSupportDocumentTypes;
        oj5.c r101 = getMoreInfo();
        if (r101 == null) goto L5;
        int r102 = r101.getType();
    L6:
        boolean r103 = r100.contains(sbb.e.d(r102));
        boolean r104 = this.pluginHost.a().isType(sbb.e.f541303n);
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.i("spacekit.mobile.docs_diy_icon", false) == false) goto L12;
        if (r103 == false) goto L13;
        if (r104 == true) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    L12:
        return false;
    L5:
        r102 = sbb.e.f541296g.f541317b;
        goto L6
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean needShowBadge() {
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).l(NAME);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(R.string.Doc_Doc_IconSettings);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean isEnable() {
        oj5.c r100 = getMoreInfo();
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof oj5.b) == false) goto L8;
        return false;
    L8:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.f499003a.g() == false) goto L13;
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).v(r100, r100.c().f234419a, "EDIT").booleanValue();
    L13:
        return r100.n();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onClick() {
        getHost().a();
        openIconSetting();
        oj5.c r100 = getMoreInfo();
        if ((r100 instanceof oj5.a) == false) goto L6;
        com.bytedance.ee.bear.more.b r101 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);
        Bundle r102 = getHost().getHostFragment().getArguments();
        oj5.a r103 = (oj5.a) r100;
        r101.c(new i(r102, r103.f523532c, r103.getType(), false, r103.b(), "icon", "none", "", "", r100 instanceof oj5.f, r103.f523540k, r103.f523547r, r103.isOwner(), r103.L()));
        return;
    }

    public IconMoreItemV2(DocumentPluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        this.pluginHost = r100;
    }
}
