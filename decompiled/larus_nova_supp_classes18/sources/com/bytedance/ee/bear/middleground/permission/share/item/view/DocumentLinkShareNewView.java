package com.bytedance.ee.bear.middleground.permission.share.item.view;

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
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import hi5.d;
import jg5.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ri5.a;
import ui5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\"\u001a\u00020\u001cH\u0002J\b\u0010#\u001a\u00020\u001fH\u0002J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010%\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u001fH\u0002J\u000e\u0010&\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u001fJ\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/share/item/view/DocumentLinkShareNewView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/ee/bear/middleground/permission/share/item/view/IDocSharePermissionInfo;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "docPermSetInfo", "Lcom/bytedance/ee/bear/middleground_permission_export/model/permissionset/DocPermSetInfo;", "publicPerm", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission;", "module", "", "linkShareIcon", "Landroid/widget/ImageView;", "linkNewShareTagView", "Landroid/widget/TextView;", "linkShareSubTitle", "linkShareTitle", "linkShareMore", "linkShareTagView", "init", "", "getIconRes", "shareLinkEnable", "", "setDocPermSetInfo", "setPublicPermission", "handlePermission", "removeOrg", "enablePermSet", "updateDocUI", "setInfo", "canClick", "enable", "failToFetchPerm", "throwable", "", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocumentLinkShareNewView extends ConstraintLayout implements a {
    public DocPermSetInfo a;
    public IDocPublicPermission b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public ImageView g;
    public TextView h;

    public final void setInfo(String r2) {
        Intrinsics.checkNotNullParameter(r2, "module");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5() {
        DocPermSetInfo r6 = this.a;
        if (r6 == null) goto L68;
        IDocPublicPermission r0 = this.b;
        if (r0 == null) goto L72;
        r6.c(r0);
        int r1 = 1;
        if (r6.b() == false) goto L10;
    L13:
        boolean r2 = true;
    L14:
        IDocPublicPermission r5 = this.b;
        if (r5 == null) goto L73;
        boolean r8 = !r5.isLinkShareClose();
        ((b) org.koin.java.a.c(b.class, null, null, 6)).getConfig();
        boolean r9 = e.a.a.a();
        if (r9 == true) goto L20;
    L29:
        ImageView r3 = this.c;
        if (r3 == null) goto L35;
        if (r8 == false) goto L33;
        int r4 = 2131255013;
    L34:
        r3.setImageResource(r4);
        goto L35
    L33:
        r4 = 2131254029;
    L35:
        int r7 = d.d(r5, r2, S5());
        if (r9 == true) goto L38;
    L40:
        LinkShareItem r10 = d.b(getContext(), r5, r7, r6.getType());
    L41:
        int r11 = ji5.a.a;
        Intrinsics.checkNotNullParameter(r5, "publicPermission");
        if (r5.isSearchableTenant() == true) goto L45;
        r1 = 2;
    L45:
        TextView r12 = this.e;
        if (r12 == null) goto L48;
        r12.setVisibility(0);
    L48:
        TextView r13 = this.e;
        if (r13 == null) goto L56;
        if (r9 == true) goto L52;
    L54:
        int r14 = qi5.b.a;
        Intrinsics.checkNotNull(r10);
        String r15 = qi5.b.c(r10, r1, S5(), r6, getContext(), r5);
    L55:
        r13.setText(r15);
        goto L56
    L52:
        if (r6.getType() == 28) goto L54;
        int r16 = qi5.b.a;
        Intrinsics.checkNotNull(r10);
        r15 = qi5.b.a(r10, r1, S5(), r6, getContext(), Boolean.valueOf(r5.hasLinkPassword()));
    L56:
        int r17 = qi5.b.a;
        qi5.b.d(r8, this.f, r6);
        if (r6.d == true) goto L59;
    L64:
        TextView r18 = this.h;
        if (r18 == null) goto L71;
        r18.setVisibility(8);
        return;
    L71:
        return;
    L59:
        if (r6.f.b.isLinkSharePermTypeSinglePage() == false) goto L64;
        if (r9 == true) goto L64;
        TextView r19 = this.h;
        if (r19 == null) goto L69;
        r19.setVisibility(0);
        return;
    L69:
        return;
    L38:
        if (r6.getType() == 28) goto L40;
        Context r20 = getContext();
        boolean r21 = r5.hasLinkPassword();
        r5.linkPassword();
        r10 = d.c(r20, r21, r7, r6.getType());
        goto L41
    L20:
        if (r6.d == true) goto L22;
    L26:
        TextView r22 = this.d;
        if (r22 == null) goto L29;
        r22.setVisibility(8);
        goto L29
    L22:
        if (r6.f.b.isLinkSharePermTypeSinglePage() == false) goto L26;
        TextView r23 = this.d;
        if (r23 == null) goto L29;
        r23.setVisibility(0);
        goto L29
    L73:
        return;
    L10:
        if (r6.f.a.canManagePermissionMeta() == true) goto L13;
        r2 = false;
        goto L14
    L72:
        return;
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

    public DocumentLinkShareNewView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // ri5.a
    public void setDocPermSetInfo(DocPermSetInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "docPermSetInfo");
        this.a = r2;
        R5();
    }

    @Override // ri5.a
    public void setPublicPermission(IDocPublicPermission r2) {
        Intrinsics.checkNotNullParameter(r2, "publicPerm");
        this.b = r2;
        R5();
    }

    public DocumentLinkShareNewView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DocumentLinkShareNewView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View r5 = LayoutInflater.from(r2).inflate(2131564186, this);
        this.c = (ImageView) r5.findViewById(2131377956);
        this.d = (TextView) r5.findViewById(2131377950);
        this.e = (TextView) r5.findViewById(2131377958);
        this.f = (TextView) r5.findViewById(2131377960);
        this.g = (ImageView) r5.findViewById(2131377957);
        this.h = (TextView) r5.findViewById(2131377959);
        ImageView r6 = this.c;
        if (r6 == null) goto L6;
        r6.setImageResource(2131255013);
        return;
    }
}
