package com.bytedance.ee.bear.middleground.permission.setting.linkshare.sharelinkset;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.docshost.k;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.lynx.api.CCMLynxPageRouter;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import com.bytedance.ee.bear.middleground.permission.permission.folder.FolderPublicPermissionV3;
import com.bytedance.ee.bear.middleground.permission.setting.linkshare.LinkShareItem;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.FolderPermSetInfo;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.framework.utils.l0;
import hi5.d;
import java.util.HashMap;
import jg5.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ui5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0010\u0010%\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u001e\u0010'\u001a\u00020&2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010(\u001a\u00020\"J\b\u0010)\u001a\u00020&H\u0016J\u0010\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020 H\u0016J\b\u0010,\u001a\u00020&H\u0002J$\u0010-\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020/0.2\u0006\u0010#\u001a\u00020$2\u0006\u00100\u001a\u00020 H\u0002J\b\u00101\u001a\u00020 H\u0002J(\u00102\u001a\u00020&2\u0006\u00103\u001a\u00020\"2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u00107\u001a\u00020$H\u0002J\u0010\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\"H\u0002J\u0010\u0010:\u001a\u00020&2\u0006\u0010;\u001a\u00020\"H\u0002J\b\u0010<\u001a\u00020\"H\u0002J\u0010\u0010=\u001a\u00020&2\u0006\u0010>\u001a\u00020\"H\u0002R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00148FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u000e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00148FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/setting/linkshare/sharelinkset/FolderLinkShareView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/permissionset/IFolderPermSetInfo;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "linkShareIconFromXml", "Landroid/widget/ImageView;", "getLinkShareIconFromXml", "()Landroid/widget/ImageView;", "setLinkShareIconFromXml", "(Landroid/widget/ImageView;)V", "linkShareSubTitleFromXml", "Landroid/widget/TextView;", "getLinkShareSubTitleFromXml", "()Landroid/widget/TextView;", "setLinkShareSubTitleFromXml", "(Landroid/widget/TextView;)V", "linkShareMoreFromXml", "getLinkShareMoreFromXml", "setLinkShareMoreFromXml", "linkShareTitleFromXml", "getLinkShareTitleFromXml", "setLinkShareTitleFromXml", "permSetInfo", "Lcom/bytedance/ee/bear/middleground_permission_export/model/permissionset/FolderPermSetInfo;", "isShareRoot", "", "module", "", "init", "", "setInfo", "showDivider", "failToFetchPerm", "setFolderPermSetInfo", "folderPermSetInfo", "onClickView", "addReportParameters", "Ljava/util/HashMap;", "Ljava/io/Serializable;", "folderMoreInfo", "getPermSetInfo", "updateFolderUI", "isShareFolderV2", "publicPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/IFolderPublicPermission;", "canPermSet", "getHasPasswordStr", "getIconRes", "shareLinkEnable", "setCanClick", "clickable", "removeOrg", "setLinkShareTitleText", "enableShareLink", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FolderLinkShareView extends ConstraintLayout implements ej5.b {
    public ImageView a;
    public TextView b;
    public ImageView c;
    public TextView d;
    public FolderPermSetInfo e;
    public boolean f;
    public String g;

    public static final class a extends t {
        public final /* synthetic */ FolderLinkShareView c;

        public a(FolderLinkShareView r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r3) {
            Toast.showFailureText(this.c.getContext(), this.c.getContext().getString(2131888342));
        }
    }

    public static final class b extends t {
        public final /* synthetic */ FolderLinkShareView c;

        public b(FolderLinkShareView r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r1) {
            FolderLinkShareView.R5(this.c);
        }
    }

    private final FolderPermSetInfo getPermSetInfo() {
        FolderPermSetInfo r0 = this.e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new FolderPermSetInfo(0, null, null, 8191);
    }

    public final boolean S5() {
        AccountService.Account r0 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (((k) org.koin.java.a.c(k.class, null, null, 6)).c() == false) goto L5;
    L8:
        return true;
    L5:
        if (c.b(r0) == true) goto L8;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ImageView getLinkShareIconFromXml() {
        KeyEvent.Callback r0 = this.a;
        if (r0 != null) goto L6;
        r0 = findViewById(2131377956);
        this.a = (ImageView) r0;
    L6:
        return (ImageView) r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ImageView getLinkShareMoreFromXml() {
        KeyEvent.Callback r0 = this.c;
        if (r0 != null) goto L6;
        r0 = findViewById(2131377957);
        this.c = (ImageView) r0;
    L6:
        return (ImageView) r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TextView getLinkShareSubTitleFromXml() {
        KeyEvent.Callback r0 = this.b;
        if (r0 != null) goto L6;
        r0 = findViewById(2131377958);
        this.b = (TextView) r0;
    L6:
        return (TextView) r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TextView getLinkShareTitleFromXml() {
        KeyEvent.Callback r0 = this.d;
        if (r0 != null) goto L6;
        r0 = findViewById(2131377960);
        this.d = (TextView) r0;
    L6:
        return (TextView) r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String getHasPasswordStr() {
        return getContext().getString(2131888761);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ej5.b
    public final void s() {
        if (getAlpha() != 1.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        setOnClickListener(new a(this));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public FolderLinkShareView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void R5(FolderLinkShareView r10) {
        r10.getClass();
        HashMap r0 = new HashMap();
        String r1 = r10.getPermSetInfo().j.b.getOwnerTenantName();
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        boolean r2 = e.a.a.a();
        qi5.a r5 = qi5.a.a;
        String r6 = r10.getPermSetInfo().b;
        Integer r7 = Integer.valueOf(r10.getPermSetInfo().getType());
        r5.getClass();
        r0.put(ResourceData.KEY_URL, qi5.a.a(r6, r7));
        r0.put(ResourceData.KEY_TOKEN, r10.getPermSetInfo().c);
        r0.put(ResourceData.KEY_TYPE, Integer.valueOf(r10.getPermSetInfo().getType()));
        r0.put("spaceId", r10.getPermSetInfo().k);
        r0.put("isSpaceV2", Boolean.valueOf(r10.getPermSetInfo().b()));
        r0.put("isUserToC", Boolean.valueOf(r10.S5()));
        r0.put("customPasswordEnable", Boolean.valueOf(com.bytedance.ee.bear.middleground.permission.b.b()));
        r0.put("isOversea", Boolean.valueOf(!((b0) org.koin.java.a.c(b0.class, null, null, 6)).isChinaMainlandGeo()));
        r0.put("folderPasswordEnable", Boolean.valueOf(ui5.b.b()));
        r0.put("appDisplayName", r10.getContext().getString(2131890277));
        String r8 = r10.g;
        FolderPermSetInfo r9 = r10.getPermSetInfo();
        HashMap r11 = new HashMap();
        r11.put("file_id", du5.b.g(r9.c));
        r11.put("file_type", sbb.e.f.getType());
        r11.put("app_form", "none");
        r11.put("sub_file_type", Integer.valueOf(r9.getType()));
        r11.put("module", r8);
        r11.put("user_permission_folder", r9.j.a.getReportJson());
        IFolderPublicPermission r12 = r9.j.b;
        if ((r12 instanceof FolderPublicPermissionV3) == false) goto L5;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.permission.folder.FolderPublicPermissionV3");
        String r13 = ((FolderPublicPermissionV3) r12).reportJson();
    L6:
        r11.put("folder_permission", r13);
        if (r9.a() == false) goto L9;
        String r14 = "true";
    L10:
        r11.put("is_owner", r14);
        r0.put("statisticParams", r11);
        r0.put("tenantName", r1);
        r0.put("linkShareOptimizeFGEnable", Boolean.valueOf(r2));
        ((CCMLynxPageRouter) org.koin.java.a.c(CCMLynxPageRouter.class, null, null, 6)).c(r10.getContext(), CCMLynxPageRouter.PageType.LINK_SHARE_PERM_SET, new de5.a(l0.a().toString(), r0, new Bundle(), 20));
        PermissionAnalytic.q("click_linkshare_setting", r10.getPermSetInfo().c, r10.getPermSetInfo().getType(), r10.g);
        com.bytedance.ee.bear.middleground.permission.c.V("share_link", "ccm_permission_share_encrypted_link_view");
        return;
    L9:
        r14 = "false";
        goto L10
    L5:
        r13 = "";
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setCanClick(boolean r2) {
        if (r2 == false) goto L4;
        setOnClickListener(new b(this));
    L5:
        ImageView r0 = getLinkShareMoreFromXml();
        if (r2 == false) goto L8;
        int r3 = 0;
    L9:
        r0.setVisibility(r3);
        return;
    L8:
        r3 = 8;
        goto L9
    L4:
        setOnClickListener(null);
        goto L5
    }

    private final void setLinkShareTitleText(boolean r4) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (e.a.a.a() == false) goto L8;
        TextView r5 = getLinkShareTitleFromXml();
        if (r5 == null) goto L12;
        r5.setText(2131889105);
        return;
    L12:
        return;
    L8:
        if (r4 == false) goto L10;
        getLinkShareTitleFromXml().setText(2131889104);
        return;
    L10:
        getLinkShareTitleFromXml().setText(2131889103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ej5.b
    public void setFolderPermSetInfo(FolderPermSetInfo r8) {
        Intrinsics.checkNotNullParameter(r8, "folderPermSetInfo");
        this.e = r8;
        setAlpha(1.0f);
        boolean r0 = r8.b();
        IFolderPublicPermission r1 = r8.j.b;
        int r3 = 0;
        if (r8.a() == false) goto L5;
    L8:
        boolean r2 = true;
    L9:
        boolean r5 = this.f;
        if (r0 == false) goto L12;
        boolean r4 = r2;
    L16:
        setCanClick(r4);
        boolean r6 = !r1.isLinkShareClose();
        ImageView r7 = getLinkShareIconFromXml();
        if (r6 == false) goto L19;
        int r9 = 2131255013;
    L20:
        r7.setImageResource(r9);
        int r10 = d.e(r1, r2, S5());
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        boolean r11 = e.a.a.a();
        if (r11 == false) goto L23;
        Context r12 = getContext();
        boolean r13 = r1.hasLinkPassword();
        r1.linkPassword();
        LinkShareItem r14 = d.c(r12, r13, r10, 0);
    L25:
        if (r14.getType() == 5) goto L29;
        if (r14.getType() == 7) goto L29;
    L36:
        getLinkShareSubTitleFromXml().setText(r14.getDescription());
    L37:
        getLinkShareSubTitleFromXml().setVisibility(0);
        setLinkShareTitleText(r6);
        if (r8.j.b.showLinkShare() == true) goto L41;
        r3 = 8;
    L41:
        setVisibility(r3);
        return;
    L29:
        if (r1.hasLinkPassword() == false) goto L36;
        TextView r15 = getLinkShareSubTitleFromXml();
        if (r15 == null) goto L37;
        if (r11 == false) goto L34;
        String r16 = getHasPasswordStr();
    L35:
        r15.setText(r16);
        goto L37
    L34:
        r16 = xo5.a.c(getContext(), 2131889681, "permType", getContext().getString(2131888224));
        goto L35
    L23:
        r14 = d.a(getContext(), r10, r1);
        goto L25
    L19:
        r9 = 2131254028;
        goto L20
    L12:
        if (r2 == false) goto L15;
        if (r5 == false) goto L15;
        r4 = true;
    L15:
        r4 = false;
        goto L16
    L5:
        if (r8.j.a.canManagePermissionMeta(r8.a()) == true) goto L8;
        r2 = false;
        goto L9
    }

    public final void setLinkShareIconFromXml(ImageView r1) {
        this.a = r1;
    }

    public final void setLinkShareMoreFromXml(ImageView r1) {
        this.c = r1;
    }

    public final void setLinkShareSubTitleFromXml(TextView r1) {
        this.b = r1;
    }

    public final void setLinkShareTitleFromXml(TextView r1) {
        this.d = r1;
    }

    public FolderLinkShareView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FolderLinkShareView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.g = "";
        LayoutInflater.from(r2).inflate(2131564186, this);
        getLinkShareIconFromXml().setImageResource(2131255013);
        setAlpha(0.3f);
    }
}
