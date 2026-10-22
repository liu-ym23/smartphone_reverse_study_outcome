package com.bytedance.ee.bear.more.itemv2;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.DenyType;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DefaultDocUserPermission;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import jg5.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oj5.c;
import oj5.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\nH\u0002J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/more/itemv2/ApplyPermMoreItemV2;", "Lcom/bytedance/ee/bear/more/moreprotocol/BaseMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/ITextMoreItem;", "activity", "Landroidx/fragment/app/FragmentActivity;", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "getId", "", "getIcon", "", "getIconTint", "getStateTips", "onDisableClick", "", "getTitle", "isVisible", "", "isSupportType", ResourceData.KEY_TYPE, "isEnable", "getUnableTips", SendEventContainerMethodParamModel.EventKinds.onClick, "Companion", "features-more_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApplyPermMoreItemV2 extends BaseMoreItem implements ITextMoreItem {
    public static final a Companion = null;
    private static final String TAG = "ApplyPermMoreItemV2";
    private final FragmentActivity activity;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return 2131254056;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return 2131102418;
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
    public final /* synthetic */ boolean needShowBadge() {
        return ITextMoreItem.CC.$default$needShowBadge(this);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onDisableClick() {
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return CommonMoreItemId.APPLY_EDIT_PERMISSION.getId();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getUnableTips() {
        tt5.a.h(TAG, "getUnableTips");
        return getString(2131889703);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onClick() {
        getHost().a();
        c r0 = getMoreInfo();
        if (r0 != null) goto L39;
    L24:
        c r1 = getMoreInfo();
        if (r1 == null) goto L36;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (e.a.a.g() == false) goto L34;
        PermissionResponse r4 = ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).t(r1.getToken(), r1, BizDomain.FileBizDomainCCM, "EDIT", r1.c().a);
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (com.bytedance.ee.bear.middleground.permission.b.e() == false) goto L34;
        if (r4.getDenySource().getDenyType() != DenyType.AUDIT_CONTROL) goto L34;
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).o6(this.activity, r1.getToken(), r1.getType(), r1.getOwnerName(), sbb.e.c(r1.getType()));
        return;
    L34:
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).F0(this.activity, r1.getToken(), r1.getType(), r1.t(), r1.getOwnerName(), sbb.e.c(r1.getType()));
    L36:
        if ((getMoreInfo() instanceof oj5.a) == false) goto L41;
        c r2 = getMoreInfo();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.bytedance.ee.bear.more.export.DocMoreInfo");
        oj5.a r3 = (oj5.a) r2;
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).c(new i(getHost().getHostFragment().getArguments(), r3.c, r3.getType(), false, r3.b(), "permission_read_without_edit", "ccm_permission_read_without_edit_view", "", "", r3 instanceof f, r3.k, r3.r, r3.isOwner(), r3.L()));
        return;
    L41:
        return;
    L39:
        String r5 = sbb.e.c(r0.getType());     // Catch: Throwable -> L22
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L22
        r6.put("file_type", r5);     // Catch: Throwable -> L22
        boolean r7 = r0 instanceof f;     // Catch: Throwable -> L22
        int r8 = r0.getType();     // Catch: Throwable -> L22
        if (r7 == false) goto L8;
        String r9 = DocumentType.WIKI_NAME;
    L9:
        r6.put("module", r9);     // Catch: Throwable -> L22
        r6.put("file_id", du5.b.g(r0.getToken()));     // Catch: Throwable -> L22
        AccountService.Account r10 = ((h0) org.koin.java.a.a(h0.class)).G2();     // Catch: Throwable -> L22
        if (r10 != null) goto L12;
    L15:
        String r11 = "";
    L17:
        if (TextUtils.equals(r11, r0.a()) == true) goto L19;
        boolean r12 = true;
    L20:
        r6.put("file_is_cross_tenant", r12);     // Catch: Throwable -> L22
        r6.put("source", "more");     // Catch: Throwable -> L22
        r6.put("permission", "edit");     // Catch: Throwable -> L22
        ((d) org.koin.java.a.a(d.class)).a("click_authority_apply_btn", r6);     // Catch: Throwable -> L22
        tt5.a.b("MoreAnalytic", "eventName:click_authority_apply_btn, params:" + r6.toString());     // Catch: Throwable -> L22
        goto L24
    L19:
        r12 = false;
        goto L20
    L12:
        if (TextUtils.isEmpty(r10.uid) == true) goto L15;
        r11 = r10.uid;     // Catch: Throwable -> L22
        goto L17
    L8:
        r9 = sbb.e.c(r8);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        tt5.a.e("MoreAnalytic", "reportClickApplyPermission()...error:", th, false);
        goto L24
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(2131889249);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean isEnable() {
        c r0 = getMoreInfo();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.isSecretFileEdit() == false) goto L8;
        return false;
    L8:
        if (r0.c().a.getPermissionStatusCode() == 10046) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        c r6 = getMoreInfo();
        if (r6 != null) goto L6;
        return false;
    L6:
        if (isItemInvisibleByBenefit() == false) goto L9;
        return false;
    L9:
        if ((r6 instanceof oj5.a) == true) goto L11;
    L13:
        boolean r0 = r6.n();
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (e.a.a.g() == false) goto L16;
        r0 = ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).t(r6.getToken(), r6, BizDomain.FileBizDomainCCM, "EDIT", r6.c().a).getAllow();
    L16:
        boolean r1 = isSupportType(r6.getType());
        tt5.a.h(TAG, "isCanEdit:" + r0 + ", isSupportType:" + r1);
        if (r0 == true) goto L21;
        if (r1 == false) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L11:
        if ((((oj5.a) r6).i.a instanceof DefaultDocUserPermission) == false) goto L13;
        return false;
    }

    public ApplyPermMoreItemV2(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.activity = r2;
    }

    private final boolean isSupportType(int r2) {
        if (r2 != sbb.e.g.b) goto L5;
    L16:
        return true;
    L5:
        if (r2 == sbb.e.o.b) goto L16;
        if (r2 == sbb.e.h.b) goto L16;
        if (r2 == sbb.e.i.b) goto L16;
        if (r2 == sbb.e.l.b) goto L16;
        if (r2 == sbb.e.k.b) goto L16;
        return false;
    }
}
