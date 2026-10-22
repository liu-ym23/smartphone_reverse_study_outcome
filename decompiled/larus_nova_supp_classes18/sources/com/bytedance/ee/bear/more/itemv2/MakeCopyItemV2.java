package com.bytedance.ee.bear.more.itemv2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.k;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorScope;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.DenyType;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UniBaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.bytedance.ee.bear.more.q;
import com.bytedance.ee.bear.more.view3.MoreFragmentV3;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.bear.wikiv2.selector.WikiSelectorBean;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import oj5.d;
import oj5.f;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\nJ\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u0006H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0006H\u0002J\b\u0010$\u001a\u00020\u001cH\u0016J\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010(\u001a\u00020&H\u0016J\b\u0010)\u001a\u00020&H\u0002J\b\u0010*\u001a\u00020\u0006H\u0016J\u0010\u0010+\u001a\u00020,2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001a\u0010-\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J\b\u00100\u001a\u00020&H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/bytedance/ee/bear/more/itemv2/MakeCopyItemV2;", "Lcom/bytedance/ee/bear/more/moreprotocol/BaseMoreItem;", "Lcom/bytedance/ee/bear/more/moreprotocol/ITextMoreItem;", "mActivity", "Landroid/app/Activity;", "module", "", "<init>", "(Landroid/app/Activity;Ljava/lang/String;)V", "activity", "(Landroid/app/Activity;)V", "getMActivity", "()Landroid/app/Activity;", "setMActivity", "getModule", "()Ljava/lang/String;", "setModule", "(Ljava/lang/String;)V", "cacheResp", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/PermissionResponse;", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getId", "getTitle", "getIcon", "", "getIconTint", "isEditionDoc", "", "moreInfo", "Lcom/bytedance/ee/bear/more/export/IMoreInfo;", "isVisible", "getUnableTips", "getMoreAction", "Lcom/bytedance/ee/bear/more/moreprotocol/MoreUiAction;", "getNoPermUnableTips", "isEnable", SendEventContainerMethodParamModel.EventKinds.onClick, "", "getToken", "onRelease", "dispose", "getStateTips", "getAdminResult", "Lcom/bytedance/ee/bear/middleground_permission_export/model/securepolicy/ValidateResult;", "getPermissionResponse", "docUserPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocUserPermission;", "onDisableClick", "Companion", "features-more_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MakeCopyItemV2 extends BaseMoreItem implements ITextMoreItem {
    public static final a Companion = null;
    public static final String TAG = "MakeCopyItemV2";
    private PermissionResponse cacheResp;
    private Activity mActivity;
    private CompositeDisposable mCompositeDisposable;
    private String module;

    public static final class a {
        public a() {
        }

        public static boolean a(int r1) {
            if (r1 != e.g.b) goto L5;
        L20:
            return true;
        L5:
            if (r1 == e.o.b) goto L20;
            if (r1 == e.h.b) goto L20;
            if (r1 == e.k.b) goto L20;
            if (r1 == e.i.b) goto L20;
            if (r1 == e.l.b) goto L20;
            if (r1 == e.m.b) goto L17;
        L19:
            return false;
        L17:
            if (c.a.a.g("ccm.mobile.slides_enabled") == false) goto L19;
            goto L19
        }
    }

    public static final class b implements td5.a {
        public final /* synthetic */ SpaceSelectorBean a;

        public b(SpaceSelectorBean r1) {
            this.a = r1;
        }

        @Override // td5.a
        public final boolean a(Document r4) {
            Intrinsics.checkNotNullParameter(r4, "destFolder");
            if (this.a.g == false) goto L8;
            FolderVersion.a r0 = FolderVersion.Companion;
            Integer r2 = Integer.valueOf(r4.L1);
            r0.getClass();
            if (FolderVersion.a.c(r2) == true) goto L8;
            return false;
        L8:
            if (this.a.g == true) goto L12;
            FolderVersion.a r1 = FolderVersion.Companion;
            Integer r5 = Integer.valueOf(r4.L1);
            r1.getClass();
            if (FolderVersion.a.c(r5) == false) goto L14;
            return false;
        L14:
            return true;
        L12:
            return true;
        }

        @Override // td5.a
        public final void b(Document r4, Context r5) {
            Intrinsics.checkNotNullParameter(r4, "destFolder");
            String r1 = null;
            if (this.a.g == false) goto L11;
            FolderVersion.a r0 = FolderVersion.Companion;
            Integer r2 = Integer.valueOf(r4.L1);
            r0.getClass();
            if (FolderVersion.a.c(r2) == true) goto L11;
            if (r5 == null) goto L8;
            String r3 = r5.getString(2131887316);
        L9:
            Toast.showText(r5, r3);
            goto L11
        L8:
            r3 = null;
        L11:
            if (this.a.g == true) goto L18;
            FolderVersion.a r6 = FolderVersion.Companion;
            Integer r7 = Integer.valueOf(r4.L1);
            r6.getClass();
            if (FolderVersion.a.c(r7) == false) goto L19;
            if (r5 == null) goto L16;
            r1 = r5.getString(2131887317);
        L16:
            Toast.showText(r5, r1);
            return;
        L19:
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return 2131254165;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return 2131102418;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getStateTips() {
        return "";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getUnableTips() {
        return "";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public final /* synthetic */ boolean needShowBadge() {
        return ITextMoreItem.CC.$default$needShowBadge(this);
    }

    private final void dispose() {
        if (this.mCompositeDisposable.isDisposed() == true) goto L6;
        this.mCompositeDisposable.clear();
        return;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return CommonMoreItemId.MAKE_COPY.getId();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public MoreUiAction getMoreAction() {
        MoreUiAction.MoreAction r0 = MoreUiAction.MoreAction.UNEAABLE_TIPS;
        if (j.a.a.getNetworkState().a() == false) goto L5;
        oj5.c r1 = getMoreInfo();
        if (r1 == null) goto L9;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        boolean r2 = jg5.e.a.a.g();
        PermissionResponse r5 = getPermissionResponse(r1, null);
        gj5.c r6 = getAdminResult(r1);
        if ((r1 instanceof oj5.a) == false) goto L15;
        ShareFolderUserPermission r7 = ((oj5.a) r1).t;
        if (r7 == null) goto L15;
        boolean r8 = r7.canCreateSubNode();
    L16:
        tt5.a.h(TAG, "moreInfo.isSecretFileCopy()" + r1.isSecretFileCopy());
        if (isItemDisabledByJSMsg() == true) goto L19;
    L21:
        if (r8 == false) goto L23;
        String r9 = "";
        if (r6.a == true) goto L32;
        if (r2 == true) goto L32;
        if (r6.b != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L57;
        return new MoreUiAction(r0, "");
    L57:
        return new MoreUiAction(r0, this.mActivity.getString(2131887246));
    L32:
        if (r2 == false) goto L38;
        if (((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).d(r5) == false) goto L38;
        return new MoreUiAction(MoreUiAction.MoreAction.PERM_PLATFORM_ACTION, "");
    L38:
        if (r1.isSecretFileCopy() == false) goto L43;
        if (r1.getType() != 12) goto L43;
        return new MoreUiAction(r0, this.mActivity.getString(2131889702));
    L43:
        if (r1.E() == false) goto L46;
        return new MoreUiAction(r0, this.mActivity.getString(2131889881));
    L46:
        if (isItemDisabledByJSMsg() == false) goto L55;
        if (TextUtils.isEmpty(getItemDisableReasonByJSMsg()) == true) goto L55;
        String r3 = getItemDisableReasonByJSMsg();
        if (r3 == null) goto L60;
        r9 = r3;
    L60:
        return new MoreUiAction(r0, r9);
    L55:
        return new MoreUiAction(r0, getNoPermUnableTips());
    L23:
        return new MoreUiAction(r0, this.mActivity.getString(2131887803));
    L19:
        if (r1.getType() != 8) goto L21;
        return new MoreUiAction(r0, this.mActivity.getString(2131886201));
    L15:
        r8 = true;
        goto L16
    L9:
        return new MoreUiAction(r0, getNoPermUnableTips());
    L5:
        return new MoreUiAction(r0, getString(2131887951));
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean isEnable() {
        if (j.a.a.getNetworkState().a() == true) goto L6;
        return false;
    L6:
        if (isItemDisabledByJSMsg() == false) goto L9;
        return false;
    L9:
        if ((getMoreInfo() instanceof oj5.a) == false) goto L27;
        oj5.c r0 = getMoreInfo();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.more.export.DocMoreInfo");
        oj5.a r1 = (oj5.a) r0;
        if (r1.p == true) goto L13;
    L15:
        a r2 = Companion;
        int r3 = r1.getType();
        r2.getClass();
        if (a.a(r3) == true) goto L18;
        return false;
    L18:
        boolean r4 = getAdminResult(r1).a;
        boolean r5 = r1.q();
        PermissionResponse r6 = getPermissionResponse(r1, r1.i.a);
        this.cacheResp = r6;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == true) goto L21;
        tt5.a.h(TAG, "adminCanCopy:" + r4 + ", ownerCanCopy:" + r5 + ", hasParentPermission:true");
        if (r4 == false) goto L28;
        if (r5 == false) goto L29;
        return true;
    L29:
        return false;
    L28:
        return false;
    L21:
        return ((ph5.c) org.koin.java.a.c(ph5.c.class, null, null, 6)).e(r6);
    L13:
        if (r1.q == false) goto L15;
        return false;
    L27:
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onClick() {
        oj5.c r1 = getMoreInfo();
        if (r1 != null) goto L6;
        Toast.cancelLoading();
        Toast.showFailureText(this.mActivity, 2131887802);
        return;
    L6:
        PermissionResponse r2 = this.cacheResp;
        if (r2 == null) goto L15;
        r2.getCallback().a(this.mActivity, r2);
        if (r2.getAllow() == true) goto L15;
        if (r2.getDenySource().getDenyType() == DenyType.USER_PERMISSION) goto L15;
        getHost().a();
        return;
    L15:
        if (TextUtils.isEmpty(r1.getTitle()) == false) goto L17;
        String r3 = ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).getDocumentDefaultName(this.mActivity, r1.getType());
    L18:
        er5.b r5 = (er5.b) org.koin.java.a.c(er5.b.class, null, null, 6);
        boolean r7 = false;
        if (Intrinsics.areEqual(this.module, "doc_detail") == true) goto L21;
    L23:
        boolean r6 = false;
    L25:
        if (r1.getType() == 8) goto L27;
    L33:
        boolean r8 = ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).B();
        FolderVersion.a r9 = FolderVersion.Companion;
        Integer r10 = Integer.valueOf(r1.C());
        r9.getClass();
        boolean r11 = FolderVersion.a.c(r10);
        boolean r12 = oj5.e.a(r1);
        WikiSelectorBean r15 = new WikiSelectorBean();
        if (r12 == false) goto L41;
        r15.i = r1.getToken();
        r15.j = r1.getType();
        f r13 = (f) r1;
        r15.d = r13.O;
        d r14 = r13.H;
        if (r14 == null) goto L39;
        String r16 = r14.d();
        if (r16 == null) goto L39;
    L40:
        r15.a = r16;
        r15.g = r3;
        r15.k = 0;
        r15.l = r13.p;
        r15.o = r13.isOwner();
    L39:
        r16 = "";
    L41:
        SpaceSelectorBean r17 = new SpaceSelectorBean();
        r17.a(getToken(r1));
        r17.a = r1.getType();
        r17.c = r1.x();
        String r18 = r1.b();
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r17.e = r18;
        Intrinsics.checkNotNull(r3);
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r17.f = r3;
        r17.g = r11;
        Intrinsics.checkNotNullParameter("innerpage_more", "<set-?>");
        r17.m = "innerpage_more";
        String r4 = this.module;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r17.n = r4;
        r17.i = r1.isOwner();
        if (r1.E() == false) goto L44;
        oj5.a r19 = (oj5.a) r1;
        r15.g = r19.g.getTitle();
        String r20 = r19.g.getTitle();
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        r17.f = r20;
    L44:
        SelectorConfig r110 = new SelectorConfig();
        r110.d = true;
        r110.g = 3026;
        r110.b(getString(2131889808));
        if (r12 == false) goto L47;
        r110.c(SelectorType.WIKI_MAKE_COPY_TO);
        r110.d = true;
        r110.c = false;
    L65:
        ((h) org.koin.java.a.c(h.class, null, null, 6)).setActivity(this.mActivity);
        if (ForsetiHelper.s(getHost().getHostFragment()) == false) goto L68;
        com.bytedance.ee.bear.contract.route.parcelable.f r111 = (com.bytedance.ee.bear.contract.route.parcelable.f) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.f.class, null, null, 6);
        MoreFragmentV3 r112 = getHost().getHostFragment();
        td5.f r113 = new td5.f();
        r113.a = 4;
        r113.e = 3026;
        r113.h = true;
        Unit r21 = Unit.INSTANCE;
        r111.a(r112, r110, r113, r17, r15);
    L70:
        if ((r1 instanceof oj5.a) == false) goto L83;
        Bundle r114 = getHost().getHostFragment().getArguments();
        if (r114 != null) goto L74;
    L76:
        if (r7 == false) goto L78;
        String r22 = "none";
    L79:
        oj5.a r23 = (oj5.a) r1;
        String r115 = r23.c;
        int r116 = r23.getType();
        String r117 = r23.b();
        com.bytedance.ee.bear.more.c.c(new i(r114, r115, r116, false, r117, "create_copy", r22, "", "", r1 instanceof f, r23.k, r23.r, r23.isOwner(), r23.L()));
        if (isEditionDoc(r1) == false) goto L84;
        ((k) org.koin.java.a.c(k.class, null, null, 6)).q(r23.getType(), "create_copy", "ccm_docs_page_view", null, null, null);
        return;
    L84:
        return;
    L78:
        r22 = "ccm_docs_page_view";
        goto L79
    L74:
        if (r114.getInt("more_scene", -1) != 0) goto L76;
        r7 = true;
        goto L76
    L83:
        return;
    L68:
        com.bytedance.ee.bear.contract.route.parcelable.f r118 = (com.bytedance.ee.bear.contract.route.parcelable.f) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.f.class, null, null, 6);
        Activity r119 = this.mActivity;
        td5.f r120 = new td5.f();
        r120.a = 4;
        r120.e = 3026;
        Unit r24 = Unit.INSTANCE;
        r118.c(r119, r110, r120, r17, r15);
        getHost().a();
        goto L70
    L47:
        r110.c(SelectorType.SPACE_MAKE_COPY_TO);
        if (r8 == false) goto L51;
        if (r11 == false) goto L51;
        SelectorScope r25 = SelectorScope.ALL;
    L52:
        r110.a(r25);
        if (r11 == true) goto L55;
    L57:
        boolean r26 = false;
    L58:
        r110.c = r26;
        if (r8 == false) goto L63;
        if (r11 == false) goto L63;
        boolean r27 = false;
    L64:
        r110.e = r27;
        r110.i = r8;
        b r28 = new b(r17);
        SelectorConfig.a r29 = SelectorConfig.CREATOR;
        WeakReference<td5.a> r30 = new WeakReference(r28);
        r29.getClass();
        SelectorConfig.k = r30;
    L63:
        r27 = true;
        goto L64
    L55:
        if (r1.x() == null) goto L57;
        r26 = true;
    L51:
        r25 = SelectorScope.SPACE_ONLY;
        goto L52
    L27:
        if (Intrinsics.areEqual(this.module, "lark_workspace_bitable_landing") == true) goto L30;
        if (r6 == false) goto L33;
    L30:
        if (r5.j() == false) goto L33;
        getHost().a();
        Activity r31 = this.mActivity;
        String r32 = r1.getToken();
        Intrinsics.checkNotNull(r3);
        r5.h(r31, r32, r3);
        return;
    L21:
        if (ForsetiHelper.k() == true) goto L23;
        r6 = true;
        goto L25
    L17:
        r3 = r1.getTitle();
        goto L18
    }

    private final String getNoPermUnableTips() {
        return getString(2131889698);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(2131889116);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        if (isItemInvisibleByBenefit() == false) goto L6;
        return false;
    L6:
        if (isItemInvisibleByJSMsg() == false) goto L9;
        return false;
    L9:
        if (isEditionDoc(getMoreInfo()) == true) goto L11;
        oj5.c r0 = getMoreInfo();
        if (r0 != null) goto L15;
        return false;
    L15:
        a r2 = Companion;
        int r3 = r0.getType();
        r2.getClass();
        if (a.a(r3) == true) goto L18;
        return false;
    L18:
        if (q.b(r0) == true) goto L24;
        PermissionResponse.a r4 = PermissionResponse.Companion;
        PermissionResponse r1 = getPermissionResponse(r0, r0.c().a);
        r4.getClass();
        if (PermissionResponse.a.e(r1) == false) goto L25;
        return true;
    L25:
        return false;
    L24:
        return false;
    L11:
        return c.a.a.f("ccm.workspace.mobile.copy_edtion_enable");
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onDisableClick() {
        oj5.c r0 = getMoreInfo();
        if (r0 != null) goto L5;
        return;
    L5:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L14;
        PermissionResponse r1 = this.cacheResp;
        if (r1 != null) goto L10;
        r1 = getPermissionResponse(r0, null);
    L10:
        ph5.e r2 = r1.getCallback();
        if (r2 == null) goto L17;
        r2.a(this.mActivity, r1);
        return;
    L17:
        return;
    L14:
        if (getAdminResult(r0).b != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L19;
        ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).c("CCM_CREATE_COPY", FileBizDomain.FileBizDomainCCM, r0.i(), getToken(r0));
        return;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem, com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public void onRelease() {
        super.onRelease();
        dispose();
    }

    public final Activity getMActivity() {
        return this.mActivity;
    }

    public final String getModule() {
        return this.module;
    }

    public MakeCopyItemV2(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this(r2, "");
    }

    private final gj5.c getAdminResult(oj5.c r5) {
        return ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g("CCM_CREATE_COPY", FileBizDomain.FileBizDomainCCM, r5.i(), getToken(r5));
    }

    private final String getToken(oj5.c r5) {
        if (oj5.e.a(r5) == false) goto L5;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ee.bear.more.export.WikiMoreInfo");
        String r0 = ((f) r5).O;
    L7:
        if ((r5 instanceof oj5.a) == true) goto L9;
        return r0;
    L9:
        if (isEditionDoc(r5) == true) goto L11;
        return r0;
    L11:
        return ((k) org.koin.java.a.c(k.class, null, null, 6)).s(r0, ((oj5.a) r5).n);
    L5:
        r0 = r5.getToken();
        goto L7
    }

    private final boolean isEditionDoc(oj5.c r4) {
        if (r4 != null) goto L4;
        return false;
    L4:
        if (r4.m() == true) goto L13;
        k r0 = (k) org.koin.java.a.c(k.class, null, null, 6);
        if ((r4 instanceof oj5.a) == false) goto L12;
        oj5.a r5 = (oj5.a) r4;
        return r0.p(r5.c, r5.n, r5.k);
    L12:
        return false;
    L13:
        return false;
    }

    public final void setMActivity(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mActivity = r2;
    }

    public final void setModule(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.module = r2;
    }

    public MakeCopyItemV2(Activity r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "mActivity");
        Intrinsics.checkNotNullParameter(r3, "module");
        this.mActivity = r2;
        this.module = r3;
        this.mCompositeDisposable = new CompositeDisposable();
    }

    private final PermissionResponse getPermissionResponse(oj5.c r14, IDocUserPermission r15) {
        UniBaseEntity r12 = new UniBaseEntity(getToken(r14), e.d(r14.i()), BizDomain.FileBizDomainCCM, r14.a(), r14.d(), null, null, null, null, 480, null);
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(r12, "CREATE_COPY"), new UserPermissionEntity(r15, null));
    }
}
