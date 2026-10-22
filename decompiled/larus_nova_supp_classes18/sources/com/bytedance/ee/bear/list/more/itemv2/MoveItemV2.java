package com.bytedance.ee.bear.list.more.itemv2;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.DocContainerInfo;
import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorScope;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DefaultDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.more.export.BizType;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import lc5.n;
import td5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MoveItemV2 extends BaseMoreItem implements ITextMoreItem {
    private static final String ID_MOVE = null;
    protected AccountService.Account mAccount;
    private final boolean mAllowWikiDestination;
    protected final Context mContext;
    protected Document mDocument;
    private final boolean mIsNetworkAvailable;
    private final String mModule;
    protected final String mParentToken;
    private final String mSource;

    public class a implements td5.a {
        public final /* synthetic */ SpaceSelectorBean a;
        public final /* synthetic */ MoveItemV2 b;

        @Override // td5.a
        public final boolean a(Document r3) {
            if (TextUtils.equals(this.b.mDocument.c, r3.c) == false) goto L6;
            return false;
        L6:
            if (this.a.g == false) goto L11;
            if (FolderVersion.isShareFolderV2(Integer.valueOf(r3.L1)) == true) goto L11;
            return false;
        L11:
            if (this.a.g == false) goto L13;
            return true;
        L13:
            if (FolderVersion.isShareFolderV2(Integer.valueOf(r3.L1)) == false) goto L17;
            return false;
        L17:
            return true;
        }

        public a(MoveItemV2 r1, SpaceSelectorBean r2) {
            this.b = r1;
            this.a = r2;
        }

        @Override // td5.a
        public final void b(Document r2, Context r3) {
            if (this.a.g == false) goto L8;
            if (FolderVersion.isShareFolderV2(Integer.valueOf(r2.L1)) == true) goto L8;
            Context r4 = this.b.mContext;
            Toast.showText(r4, r4.getString(2131887318));
        L8:
            if (this.a.g == false) goto L10;
            return;
        L10:
            if (FolderVersion.isShareFolderV2(Integer.valueOf(r2.L1)) == false) goto L14;
            Context r5 = this.b.mContext;
            Toast.showText(r5, r5.getString(2131887319));
            return;
        }
    }

    public static /* synthetic */ void a(Throwable r0) {
        lambda$getNodeToken$1(r0);
    }

    public static /* synthetic */ void b(MoveItemV2 r0, DocContainerInfo r1) {
        r0.lambda$getNodeToken$0(r1);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return 2131254940;
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
    public boolean needShowBadge() {
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onDisableClick() {
    }

    static {
        ID_MOVE = CommonMoreItemId.MOVE.getId();
    }

    public boolean enableUnorganized() {
        Document r0 = this.mDocument;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getType() == sbb.e.f.b) goto L7;
        return true;
    }

    public void getNodeToken() {
        if (TextUtils.isEmpty(this.mDocument.c) == true) goto L5;
        return;
    L5:
        if (this.mDocument.getType() == 0) goto L7;
        com.bytedance.ee.bear.d r0 = (com.bytedance.ee.bear.d) org.koin.java.a.a(com.bytedance.ee.bear.d.class);
        Document r1 = this.mDocument;
        r0.d(r1.d, r1.getType()).subscribe(new c(this), new d());
        return;
    L7:
        Document r2 = this.mDocument;
        r2.c = r2.d;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getUnableTips() {
        if (this.mContext != null) goto L7;
        return "";
    L7:
        if (j.a.a.getNetworkState().a() == true) goto L11;
        return getString(2131887951);
    L11:
        if ((getMoreInfo() instanceof oj5.a) == false) goto L20;
        oj5.d r0 = ((oj5.a) getMoreInfo()).H;
        if (r0 == null) goto L20;
        if (r0.a() == null) goto L20;
        if (r0.a().intValue() == BizType.Space.getValue()) goto L20;
        return this.mContext.getString(2131888787);
    L20:
        Context r1 = this.mContext;
        return xo5.a.c(r1, 2131887930, ResourceData.KEY_TYPE, t0.n(r1, this.mDocument.getType()));
    }

    public boolean isEnable() {
        if (j.a.a.getNetworkState().a() == true) goto L6;
        return false;
    L6:
        if (this.mDocument.getType() != sbb.e.f.b) goto L13;
        if (FolderVersion.isShareFolderV2(Integer.valueOf(this.mDocument.L1)) == true) goto L13;
        if (this.mDocument.Q1 == false) goto L13;
        return false;
    L13:
        if ((getMoreInfo() instanceof oj5.a) == false) goto L23;
        oj5.d r0 = ((oj5.a) getMoreInfo()).H;
        if (r0 == null) goto L23;
        if (r0.a() != null) goto L20;
        return true;
    L20:
        if (r0.a().intValue() != BizType.Space.getValue()) goto L24;
        return true;
    L24:
        return false;
    L23:
        return true;
    }

    public boolean isEnableApplyFolder() {
        if (qc5.a.b(this.mDocument.L1) == true) goto L5;
    L7:
        return false;
    L5:
        if (isSameTenant() == false) goto L7;
        return true;
    }

    public boolean isSameTenant() {
        return TextUtils.equals(this.mAccount.tenantId, this.mDocument.f);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onClick() {
        if (t0.b(this.mContext, this.mDocument, "move") == false) goto L5;
        return;
    L5:
        oj5.c r1 = getMoreInfo();
        if (this.mIsNetworkAvailable == true) goto L9;
        Context r2 = this.mContext;
        Toast.showFailureText(r2, r2.getString(2131887951), 0);
        return;
    L9:
        if (r1 == null) goto L15;
        if (((a4) org.koin.java.a.a(a4.class)).c(r1.getToken()) == false) goto L15;
        Context r3 = this.mContext;
        Toast.showFailureText(r3, r3.getString(2131887323), 0);
        return;
    L15:
        if ((r1 instanceof oj5.a) == false) goto L20;
        IDocPublicPermission r4 = ((oj5.a) r1).i.b;
        if ((r4 instanceof DefaultDocPublicPermission) == false) goto L19;
        boolean r5 = true;
    L21:
        SpaceSelectorBean r6 = getSpaceSelectorBean(r1, r5);
        SelectorConfig r7 = new SelectorConfig();
        r7.c(SelectorType.SPACE_MOVE_TO);
        if (r6.g == true) goto L24;
    L28:
        boolean r8 = false;
    L29:
        if (r8 == true) goto L31;
    L35:
        SelectorScope r9 = SelectorScope.SPACE_ONLY;
    L36:
        r7.a(r9);
        r7.b(getString(2131887781));
        r7.d = true;
        r7.g = DocUserPermission.USER_PERM_FULL_ACCESS;
        boolean r10 = r6.g;
        if (r10 == true) goto L39;
        r7.e = true;
    L39:
        if (r10 == false) goto L41;
    L44:
        boolean r11 = true;
    L45:
        r7.i = r11;
        r7.j = enableUnorganized();
        a r12 = new a(this, r6);
        SelectorConfig.a r13 = SelectorConfig.CREATOR;
        WeakReference<td5.a> r14 = new WeakReference(r12);
        r13.getClass();
        SelectorConfig.k = r14;
        f r15 = new f();
        r15.a = 2;
        if (ForsetiHelper.s(getHost().getHostFragment()) == false) goto L48;
        getHost().a();
    L48:
        navigationSelectorActivity(r7, r15, r6);
        lc5.f.l(new n((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), this.mAccount, "moveto", this.mDocument, this.mModule, this.mSource));
        if ((r1 instanceof oj5.b) == false) goto L55;
        oj5.b r16 = (oj5.b) r1;
        com.bytedance.ee.bear.more.b r17 = (com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class);
        Bundle r18 = getHost().getHostFragment().getArguments();
        String r19 = r1.getToken();
        int r20 = r1.getType();
        boolean r110 = FolderVersion.isShareFolder(r16.o.getOwnerType(), r16.p);
        String r111 = r1.b();
        if (r1.getType() != sbb.e.n.b) goto L53;
        boolean r112 = true;
    L54:
        r17.c(new i(r18, r19, r20, r110, r111, "move_to_folder", "ccm_space_add_to_folder_view", "", "", r112, false, r1.H(), r1.isOwner(), r1.L()));
    L62:
        if (ForsetiHelper.s(getHost().getHostFragment()) == true) goto L65;
        getHost().a();
        return;
    L65:
        return;
    L53:
        r112 = false;
        goto L54
    L55:
        if (r1 == null) goto L62;
        com.bytedance.ee.bear.more.b r21 = (com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class);
        Bundle r113 = getHost().getHostFragment().getArguments();
        String r114 = r1.getToken();
        int r22 = r1.getType();
        String r23 = r1.b();
        if (r1.getType() != sbb.e.n.b) goto L59;
        boolean r27 = true;
    L60:
        r21.c(new i(r113, r114, r22, false, r23, "move_to_folder", "ccm_space_add_to_folder_view", "", "", r27, false, r1.H(), r1.isOwner(), r1.L()));
        goto L62
    L59:
        r27 = false;
        goto L60
    L41:
        if (this.mDocument.getType() == sbb.e.f.b) goto L44;
        r11 = false;
        goto L45
    L31:
        if (isSameTenant() == false) goto L35;
        if (this.mAllowWikiDestination == false) goto L35;
        r9 = SelectorScope.ALL;
        goto L36
    L24:
        if (r6.a == sbb.e.f.b) goto L28;
        if (r6.j == true) goto L28;
        r8 = true;
        goto L29
    L19:
        r5 = r4.externalAccess();
        goto L21
    L20:
        r5 = false;
        goto L21
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem, com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem, com.bytedance.ee.bear.more.protocol3.b, com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem, com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public void create() {
        super.create();
        getNodeToken();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(2131889143);
    }

    public boolean isEnableApply() {
        return isSameTenant();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        if (isItemInvisibleByBenefit() == false) goto L5;
        return false;
    L5:
        Document r0 = this.mDocument;
        AccountService.Account r2 = this.mAccount;
        String[] r3 = t0.a;
        if (r0.n == false) goto L11;
        if (r2 == null) goto L11;
        if (TextUtils.equals(r0.e, r2.uid) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return ID_MOVE;
    }

    private void lambda$getNodeToken$0(DocContainerInfo r2) throws Exception {
        if (TextUtils.isEmpty(r2.getNode_token()) == true) goto L6;
        Document r0 = this.mDocument;
        r0.c = r2.getNode_token();
        getHostProvider().g();
        return;
    }

    private static void lambda$getNodeToken$1(Throwable r3) throws Exception {
        tt5.a.e(ID_MOVE, "get container info fail. ", r3, false);
    }

    public SpaceSelectorBean getSpaceSelectorBean(oj5.c r4, boolean r5) {
        SpaceSelectorBean r0 = new SpaceSelectorBean();
        r0.a(this.mDocument.d);
        String r1 = this.mDocument.c;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.d = r1;
        if (this.mDocument.getType() != 0) goto L5;
        String r2 = this.mDocument.d;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r0.d = r2;
        r0.l = this.mDocument.P1;
    L5:
        r0.c = this.mParentToken;
        r0.a = this.mDocument.getType();
        r0.g = FolderVersion.isShareFolderV2(Integer.valueOf(this.mDocument.L1));
        r0.j = NodeType.isShortcut(this.mDocument.M1);
        if (r4 != null) goto L8;
    L10:
        boolean r6 = false;
    L11:
        r0.i = r6;
        r0.h = r5;
        String r7 = this.mModule;
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r0.n = r7;
        String r8 = this.mSource;
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r0.m = r8;
        return r0;
    L8:
        if (r4.isOwner() == false) goto L10;
        r6 = true;
        goto L11
    }

    public void navigationSelectorActivity(SelectorConfig r8, f r9, SpaceSelectorBean r10) {
        ((com.bytedance.ee.bear.contract.route.parcelable.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.route.parcelable.f.class)).c(this.mContext, r8, r9, r10, null);
    }

    public MoveItemV2(Context r10, Document r11, AccountService.Account r12, boolean r13, String r14, String r15, String r16) {
        this(r10, r11, r12, r13, r14, r15, r16, true);
    }

    public MoveItemV2(Context r1, Document r2, AccountService.Account r3, boolean r4, String r5, String r6, String r7, boolean r8) {
        this.mContext = r1;
        this.mDocument = r2;
        this.mAccount = r3;
        this.mIsNetworkAvailable = r4;
        this.mParentToken = r5;
        this.mModule = r6;
        this.mSource = r7;
        this.mAllowWikiDestination = r8;
    }
}
