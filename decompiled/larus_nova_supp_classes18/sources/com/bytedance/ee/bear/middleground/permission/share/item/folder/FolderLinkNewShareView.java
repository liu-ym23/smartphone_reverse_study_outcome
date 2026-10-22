package com.bytedance.ee.bear.middleground.permission.share.item.folder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import cj5.b;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.docshost.k;
import com.bytedance.ee.bear.middleground.permission.setting.linkshare.LinkShareItem;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.FolderPermSetInfo;
import hi5.d;
import jg5.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.koin.java.a;
import pi5.f;
import ui5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0010H\u0002J\b\u0010\u001e\u001a\u00020\u0012H\u0002J\u0016\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J(\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u0010H\u0002J\b\u0010'\u001a\u00020\u0010H\u0002J\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u000eH\u0016J\b\u0010*\u001a\u00020\u001bH\u0016J\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u0010H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/share/item/folder/FolderLinkNewShareView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/ee/bear/middleground/permission/share/item/folder/IFolderSharePermissionInfo;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "permSetInfo", "Lcom/bytedance/ee/bear/middleground_permission_export/model/permissionset/FolderPermSetInfo;", "isShareRoot", "", "module", "", "linkShareIcon", "Landroid/widget/ImageView;", "linkShareSubTitle", "Landroid/widget/TextView;", "linkShareTitle", "linkShareMore", "linkShareTagView", "init", "", "getIconRes", "shareLinkEnable", "getHasPasswordStr", "setInfo", "updateFolderUI", "isShareFolderV2", "publicPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/IFolderPublicPermission;", "canPermSet", "setLinkShareTitleText", "enableShareLink", "removeOrg", "setFolderPermSetInfo", "folderPermSetInfo", "failToFetchPerm", "setCanCLick", "enable", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FolderLinkNewShareView extends ConstraintLayout implements f {
    public ImageView a;
    public TextView b;
    public TextView c;
    public ImageView d;

    /* JADX WARN: Multi-variable type inference failed */
    private final String getHasPasswordStr() {
        return getContext().getString(2131888761);
    }

    public FolderLinkNewShareView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    private final void setLinkShareTitleText(boolean r4) {
        ((b) a.c(b.class, null, null, 6)).getConfig();
        if (e.a.a.a() == false) goto L8;
        TextView r5 = this.c;
        if (r5 == null) goto L16;
        r5.setText(2131888767);
        return;
    L16:
        return;
    L8:
        if (r4 == false) goto L12;
        TextView r6 = this.c;
        if (r6 == null) goto L17;
        r6.setText(2131889104);
        return;
    L17:
        return;
    L12:
        TextView r7 = this.c;
        if (r7 == null) goto L19;
        r7.setText(2131889103);
        return;
    }

    public void setCanCLick(boolean r2) {
        ImageView r0 = this.d;
        if (r0 == null) goto L9;
        if (r2 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        return;
    L6:
        r3 = 8;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pi5.f
    public void setFolderPermSetInfo(FolderPermSetInfo r9) {
        Intrinsics.checkNotNullParameter(r9, "folderPermSetInfo");
        r9.b();
        IFolderPublicPermission r0 = r9.j.b;
        boolean r2 = true;
        if (r9.a() == false) goto L5;
    L8:
        boolean r10 = true;
    L9:
        boolean r1 = !r0.isLinkShareClose();
        ImageView r4 = this.a;
        if (r4 == null) goto L15;
        if (r1 == false) goto L13;
        int r5 = 2131255013;
    L14:
        r4.setImageResource(r5);
        goto L15
    L13:
        r5 = 2131254028;
    L15:
        AccountService.Account r6 = ((h0) a.c(h0.class, null, null, 6)).G2();
        if (((k) a.c(k.class, null, null, 6)).c() == false) goto L18;
    L21:
        int r11 = d.e(r0, r10, r2);
        ((b) a.c(b.class, null, null, 6)).getConfig();
        boolean r3 = e.a.a.a();
        if (r3 == false) goto L24;
        Context r7 = getContext();
        boolean r8 = r0.hasLinkPassword();
        r0.linkPassword();
        LinkShareItem r12 = d.c(r7, r8, r11, 0);
    L26:
        if (r12.getType() == 5) goto L30;
        if (r12.getType() == 7) goto L30;
    L37:
        TextView r13 = this.b;
        if (r13 == null) goto L40;
        r13.setText(r12.getDescription());
    L40:
        TextView r14 = this.b;
        if (r14 == null) goto L43;
        r14.setVisibility(0);
    L43:
        setLinkShareTitleText(r1);
        return;
    L30:
        if (r0.hasLinkPassword() == false) goto L37;
        TextView r15 = this.b;
        if (r15 == null) goto L40;
        if (r3 == false) goto L35;
        String r16 = getHasPasswordStr();
    L36:
        r15.setText(r16);
        goto L40
    L35:
        r16 = xo5.a.c(getContext(), 2131889681, "permType", getContext().getString(2131888224));
        goto L36
    L24:
        r12 = d.a(getContext(), r11, r0);
        goto L26
    L18:
        if (c.b(r6) == true) goto L21;
        r2 = false;
        goto L21
    L5:
        if (r9.j.a.canManagePermissionMeta(r9.a()) == true) goto L8;
        r10 = false;
        goto L9
    }

    public FolderLinkNewShareView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FolderLinkNewShareView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View r5 = LayoutInflater.from(r2).inflate(2131564186, this);
        this.a = (ImageView) r5.findViewById(2131377956);
        this.b = (TextView) r5.findViewById(2131377958);
        this.c = (TextView) r5.findViewById(2131377960);
        this.d = (ImageView) r5.findViewById(2131377957);
        TextView r6 = (TextView) r5.findViewById(2131377959);
        ImageView r7 = this.a;
        if (r7 == null) goto L6;
        r7.setImageResource(2131255013);
        return;
    }
}
