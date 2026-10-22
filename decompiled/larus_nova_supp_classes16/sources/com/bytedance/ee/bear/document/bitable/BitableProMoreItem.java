package com.bytedance.ee.bear.document.bitable;

import android.content.Context;
import com.bytedance.ee.bear.BlockSimpleInfo;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0014J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/document/bitable/BitableProMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/ITextMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/BaseMoreItem;", "pluginHost", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "<init>", "(Lcom/bytedance/ee/bear/document/DocumentPluginHost;)V", "getId", "", "getIcon", "", "getIconTint", "getTitle", "onClick", "", "isFa", "", "moreInfo", "Lcom/bytedance/ee/bear/more/export/DocMoreInfo;", "isMatchPerceive", "Lcom/bytedance/ee/bear/more/export/IMoreInfo;", "isTemplate", "isVisible", "getStateTips", "onDisableClick", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableProMoreItem extends BaseMoreItem implements ITextMoreItem {
    public static final a Companion = null;
    private static final String TAG = "BitableProMoreItem";
    private final DocumentPluginHost pluginHost;

    public static final class a {
        public a() {
        }

        public static boolean a(boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8) {
            if (r3 == false) goto L6;
            if (r2 == true) goto L6;
            return false;
        L6:
            tt5.a.h(BitableProMoreItem.TAG, "isOwner = " + r5 + ", isFA = " + r6 + " ,isPro = " + r4 + ", isTemplateDoc = " + r2 + ", isWiki = " + r7 + ",isBitable = " + r8);
            if (r2 == true) goto L10;
            if (r5 == true) goto L10;
            if (r6 == true) goto L10;
            return false;
        L10:
            if (r8 == false) goto L14;
            return true;
        L14:
            return false;
        }
    }

    static {
        Companion = new a();
    }

    public int getIcon() {
        return 2131237723;
    }

    public int getIconTint() {
        return 2131102418;
    }

    public String getId() {
        return TAG;
    }

    public final /* synthetic */ MoreUiAction getMoreAction() {
        return ITextMoreItem.-CC.$default$getMoreAction(this);
    }

    public final /* synthetic */ String getUnableTips() {
        return ITextMoreItem.-CC.$default$getUnableTips(this);
    }

    public final /* synthetic */ boolean isEnable() {
        return ITextMoreItem.-CC.$default$isEnable(this);
    }

    public final /* synthetic */ boolean needShowBadge() {
        return ITextMoreItem.-CC.$default$needShowBadge(this);
    }

    public void onDisableClick() {
    }

    public String getStateTips() {
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("base.advanced_permission.role_inheritance") == false) goto L14;
        oj5.a r0 = getMoreInfo();
        if (r0 != null) goto L8;
        return "";
    L8:
        if ((r0 instanceof oj5.a) == true) goto L11;
        return "";
    L11:
        if (r0.A == false) goto L14;
        return getString(2131886238);
    L14:
        return "";
    }

    public void onClick() {
        Context r1 = getHost().getHostFragment().getContext();
        oj5.c r2 = getMoreInfo();
        if (r2 == null) goto L5;
        String r5 = r2.getToken();
    L6:
        oj5.a r3 = getMoreInfo();
        boolean r11 = r3 instanceof oj5.a;
        if (r11 == false) goto L9;
        ArrayList<BlockSimpleInfo> r4 = r3.B;
    L10:
        ArrayList<BlockSimpleInfo> r9 = r4;
        if (r11 == false) goto L13;
        ArrayList<BlockSimpleInfo> r6 = r3.C;
    L14:
        ArrayList<BlockSimpleInfo> r10 = r6;
        if (r3 == null) goto L18;
        String r7 = r3.t();
        if (r7 == null) goto L18;
    L19:
        String r8 = r7;
        boolean r12 = isTemplate(r3);
        if (r11 == true) goto L22;
    L24:
        boolean r13 = false;
    L25:
        if (r3 == null) goto L28;
        r3.isOwner();
    L28:
        if (r11 == false) goto L33;
        if (isFa(r3) == true) goto L33;
    L33:
        if (r3 == null) goto L35;
        String r14 = r3.a();
    L36:
        if (r1 == null) goto L43;
        if (r5 == null) goto L43;
        ((g) this.pluginHost.getHostAbility(g.class)).showBitableProFragment(r5, r8, false, new c(r12, r13, r14), r9, r10);
        getHost().a();
        if (r11 == false) goto L45;
        oj5.a r16 = r3;
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).c(new i(getHost().getHostFragment().getArguments(), r16.c, r16.getType(), false, r16.b(), "bitable_premium_permission_settings", "ccm_bitable_premium_permission_setting_view", "", "", r3 instanceof oj5.f, r16.k, r16.r, r16.isOwner(), r16.L()));
        return;
    L45:
        return;
    L43:
        tt5.a.k(TAG, "context is null or token is null");
        return;
    L35:
        r14 = null;
        goto L36
    L22:
        if (r3.A == false) goto L24;
        r13 = true;
    L18:
        r7 = "";
        goto L19
    L13:
        r6 = new ArrayList();
        goto L14
    L9:
        r4 = new ArrayList();
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    public String getTitle() {
        return getString(2131886197);
    }

    public boolean isVisible() {
        oj5.a r0 = getMoreInfo();
        boolean r1 = false;
        if (r0 != null) goto L5;
        return false;
    L5:
        boolean r2 = isTemplate(r0);
        boolean r3 = isMatchPerceive(r0);
        boolean r4 = r0 instanceof oj5.a;
        if (r4 == true) goto L8;
    L10:
        boolean r6 = false;
    L11:
        boolean r7 = r0.isOwner();
        if (r4 == true) goto L14;
    L16:
        boolean r8 = false;
    L18:
        if ((r0 instanceof oj5.f) == false) goto L20;
    L23:
        boolean r9 = true;
    L25:
        if (r0.getType() != sbb.e.i.b) goto L27;
        r1 = true;
    L27:
        Companion.getClass();
        return a.a(r2, r3, r6, r7, r8, r9, r1);
    L20:
        if (r0.getType() == sbb.e.n.b) goto L23;
        r9 = false;
        goto L25
    L14:
        if (isFa(r0) == false) goto L16;
        r8 = true;
        goto L18
    L8:
        if (r0.A == false) goto L10;
        r6 = true;
        goto L11
    }

    public BitableProMoreItem(DocumentPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        this.pluginHost = r2;
    }

    private final boolean isFa(oj5.a r8) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L7;
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).t(r8.c, r8, BizDomain.FileBizDomainCCM, "MANAGE_PERMISSION_META", r8.i.a).getAllow();
    L7:
        return r8.i.a.canManagePermissionMeta();
    }

    private final boolean isMatchPerceive(oj5.c r4) {
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).v(r4, r4.c().a, "PERCEIVE_CONTROL").booleanValue();
    }

    public final boolean isTemplate(oj5.c r2) {
        if (r2 != null) goto L5;
        tt5.a.h(TAG, "get isTemplate false, moreInfo is null");
        return false;
    L5:
        a r0 = Companion;
        int r3 = r2.getTemplateType();
        r0.getClass();
        return com.bytedance.ee.bear.templates.g.a(r3);
    }
}
