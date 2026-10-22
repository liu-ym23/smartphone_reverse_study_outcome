package com.bytedance.ee.bear.document.bitable;

import android.content.Context;
import com.bytedance.ee.bear.BlockSimpleInfo;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.larus.nova.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0014J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/document/bitable/BitableProMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/ITextMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/BaseMoreItem;", "pluginHost", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "<init>", "(Lcom/bytedance/ee/bear/document/DocumentPluginHost;)V", "getId", "", "getIcon", "", "getIconTint", "getTitle", SendEventContainerMethodParamModel.EventKinds.onClick, "", "isFa", "", "moreInfo", "Lcom/bytedance/ee/bear/more/export/DocMoreInfo;", "isMatchPerceive", "Lcom/bytedance/ee/bear/more/export/IMoreInfo;", "isTemplate", "isVisible", "getStateTips", "onDisableClick", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableProMoreItem extends BaseMoreItem implements ITextMoreItem {
    public static final a Companion = null;
    private static final String TAG = "BitableProMoreItem";
    private final DocumentPluginHost pluginHost;

    public static final class a {
        public a() {
        }

        public static boolean a(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106) {
            if (r101 == false) goto L6;
            if (r100 == true) goto L6;
            return false;
        L6:
            tt5.a.h(BitableProMoreItem.TAG, "isOwner = " + r103 + ", isFA = " + r104 + " ,isPro = " + r102 + ", isTemplateDoc = " + r100 + ", isWiki = " + r105 + ",isBitable = " + r106);
            if (r100 == true) goto L10;
            if (r103 == true) goto L10;
            if (r104 == true) goto L10;
            return false;
        L10:
            if (r106 == false) goto L14;
            return true;
        L14:
            return false;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return R.drawable.icon_bitable_authorization;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return R.color.icon_n1;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return TAG;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public final /* synthetic */ MoreUiAction getMoreAction() {
        return ITextMoreItem.CC.$default$getMoreAction(this);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public final /* synthetic */ String getUnableTips() {
        return ITextMoreItem.CC.$default$getUnableTips(this);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public final /* synthetic */ boolean isEnable() {
        return ITextMoreItem.CC.$default$isEnable(this);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public final /* synthetic */ boolean needShowBadge() {
        return ITextMoreItem.CC.$default$needShowBadge(this);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onDisableClick() {
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getStateTips() {
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("base.advanced_permission.role_inheritance") == false) goto L14;
        oj5.c r100 = getMoreInfo();
        if (r100 != null) goto L8;
        return "";
    L8:
        if ((r100 instanceof oj5.a) == true) goto L11;
        return "";
    L11:
        if (((oj5.a) r100).A == false) goto L14;
        return getString(R.string.Bitable_AdvancedPermissions_Mobile_TurnedOn_Text);
    L14:
        return "";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onClick() {
        Context r100 = getHost().getHostFragment().getContext();
        oj5.c r101 = getMoreInfo();
        if (r101 == null) goto L5;
        String r102 = r101.getToken();
    L6:
        oj5.c r103 = getMoreInfo();
        boolean r110 = r103 instanceof oj5.a;
        if (r110 == false) goto L9;
        ArrayList<BlockSimpleInfo> r104 = ((oj5.a) r103).B;
    L10:
        ArrayList<BlockSimpleInfo> r105 = r104;
        if (r110 == false) goto L13;
        ArrayList<BlockSimpleInfo> r106 = ((oj5.a) r103).C;
    L14:
        ArrayList<BlockSimpleInfo> r111 = r106;
        if (r103 == null) goto L18;
        String r107 = r103.t();
        if (r107 == null) goto L18;
    L19:
        String r108 = r107;
        boolean r109 = isTemplate(r103);
        if (r110 == true) goto L22;
    L24:
        boolean r112 = false;
    L25:
        if (r103 == null) goto L28;
        r103.isOwner();
    L28:
        if (r110 == false) goto L33;
        if (isFa((oj5.a) r103) == true) goto L33;
    L33:
        if (r103 == null) goto L35;
        String r113 = r103.a();
    L36:
        if (r100 == null) goto L43;
        if (r102 == null) goto L43;
        ((g) this.pluginHost.getHostAbility(g.class)).showBitableProFragment(r102, r108, false, new c(r109, r112, r113), r105, r111);
        getHost().a();
        if (r110 == false) goto L45;
        oj5.a r114 = (oj5.a) r103;
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).c(new i(getHost().getHostFragment().getArguments(), r114.f523532c, r114.getType(), false, r114.b(), "bitable_premium_permission_settings", "ccm_bitable_premium_permission_setting_view", "", "", r103 instanceof oj5.f, r114.f523540k, r114.f523547r, r114.isOwner(), r114.L()));
        return;
    L45:
        return;
    L43:
        tt5.a.k(TAG, "context is null or token is null");
        return;
    L35:
        r113 = null;
        goto L36
    L22:
        if (((oj5.a) r103).A == false) goto L24;
        r112 = true;
    L18:
        r107 = "";
        goto L19
    L13:
        r106 = new ArrayList();
        goto L14
    L9:
        r104 = new ArrayList();
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(R.string.Bitable_AdvancedPermission_Setting);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        oj5.c r100 = getMoreInfo();
        boolean r101 = false;
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r102 = isTemplate(r100);
        boolean r103 = isMatchPerceive(r100);
        boolean r104 = r100 instanceof oj5.a;
        if (r104 == true) goto L8;
    L10:
        boolean r105 = false;
    L11:
        boolean r106 = r100.isOwner();
        if (r104 == true) goto L14;
    L16:
        boolean r107 = false;
    L18:
        if ((r100 instanceof oj5.f) == false) goto L20;
    L23:
        boolean r108 = true;
    L25:
        if (r100.getType() != sbb.e.f541298i.f541317b) goto L27;
        r101 = true;
    L27:
        Companion.getClass();
        return a.a(r102, r103, r105, r106, r107, r108, r101);
    L20:
        if (r100.getType() == sbb.e.f541303n.f541317b) goto L23;
        r108 = false;
        goto L25
    L14:
        if (isFa((oj5.a) r100) == false) goto L16;
        r107 = true;
        goto L18
    L8:
        if (((oj5.a) r100).A == false) goto L10;
        r105 = true;
        goto L11
    }

    public BitableProMoreItem(DocumentPluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        this.pluginHost = r100;
    }

    private final boolean isFa(oj5.a r100) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.f499003a.g() == false) goto L7;
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).t(r100.f523532c, r100, BizDomain.FileBizDomainCCM, "MANAGE_PERMISSION_META", r100.f523538i.f234419a).getAllow();
    L7:
        return r100.f523538i.f234419a.canManagePermissionMeta();
    }

    private final boolean isMatchPerceive(oj5.c r100) {
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).v(r100, r100.c().f234419a, "PERCEIVE_CONTROL").booleanValue();
    }

    public final boolean isTemplate(oj5.c r100) {
        if (r100 != null) goto L5;
        tt5.a.h(TAG, "get isTemplate false, moreInfo is null");
        return false;
    L5:
        a r101 = Companion;
        int r102 = r100.getTemplateType();
        r101.getClass();
        return com.bytedance.ee.bear.templates.g.a(r102);
    }
}
