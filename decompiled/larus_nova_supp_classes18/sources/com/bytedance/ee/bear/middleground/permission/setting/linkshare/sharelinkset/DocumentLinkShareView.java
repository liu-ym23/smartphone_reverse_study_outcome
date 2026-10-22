package com.bytedance.ee.bear.middleground.permission.setting.linkshare.sharelinkset;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.docshost.k;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import com.bytedance.ee.bear.middleground.permission.setting.linkshare.LinkShareItem;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.bear.widgets.universedesign.SimpleTagTextView;
import hi5.d;
import java.io.Serializable;
import java.util.HashMap;
import jg5.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ui5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0010\u00101\u001a\u0002022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u00104\u001a\u0002022\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u00105\u001a\u00020/J\u0016\u00106\u001a\u0002022\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/J\u0010\u00107\u001a\u0002022\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u00108\u001a\u0002022\u0006\u0010*\u001a\u00020+H\u0016J\b\u00109\u001a\u000202H\u0002J\b\u0010:\u001a\u000202H\u0002J\u0010\u0010;\u001a\u0002022\u0006\u0010<\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u0002022\u0006\u0010?\u001a\u00020/H\u0016J\u0010\u0010@\u001a\u00020/2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010A\u001a\u000202H\u0002J\n\u0010B\u001a\u0004\u0018\u00010CH\u0002J\n\u0010D\u001a\u0004\u0018\u00010)H\u0002J\u0018\u0010E\u001a\u0002022\u0006\u0010(\u001a\u00020)2\u0006\u0010@\u001a\u00020/H\u0002J\u0010\u0010F\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020/H\u0002J\u0010\u0010H\u001a\u0002022\u0006\u0010I\u001a\u00020/H\u0002J\b\u0010J\u001a\u00020/H\u0002R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00148FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001a8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u001a8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001e\u0010\"\u001a\u0004\u0018\u00010\u00148FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001e\u0010%\u001a\u0004\u0018\u00010\u000e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0010\"\u0004\b'\u0010\u0012R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/setting/linkshare/sharelinkset/DocumentLinkShareView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/permissionset/IDocPermSetInfo;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "linkShareIconFromXml", "Landroid/widget/ImageView;", "getLinkShareIconFromXml", "()Landroid/widget/ImageView;", "setLinkShareIconFromXml", "(Landroid/widget/ImageView;)V", "linkNewShareTagViewFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SimpleTagTextView;", "getLinkNewShareTagViewFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SimpleTagTextView;", "setLinkNewShareTagViewFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SimpleTagTextView;)V", "linkShareSubTitleFromXml", "Landroid/widget/TextView;", "getLinkShareSubTitleFromXml", "()Landroid/widget/TextView;", "setLinkShareSubTitleFromXml", "(Landroid/widget/TextView;)V", "linkShareTitleFromXml", "getLinkShareTitleFromXml", "setLinkShareTitleFromXml", "linkShareTagViewFromXml", "getLinkShareTagViewFromXml", "setLinkShareTagViewFromXml", "linkShareMoreFromXml", "getLinkShareMoreFromXml", "setLinkShareMoreFromXml", "docPermSetInfo", "Lcom/bytedance/ee/bear/middleground_permission_export/model/permissionset/DocPermSetInfo;", "publicPerm", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission;", "shareParams", "Lcom/bytedance/ee/bear/share/export/ShareParams;", "isPro", "", "isProAccessConfigBindRole", "init", "", "hasPullPerm", "setInfo", "showDivider", "setBitableProInfo", "setDocPermSetInfo", "setPublicPermission", "makePermInfoComple", "handleSyncedClick", "failToFetchPerm", "throwable", "", "setDivider", "show", "enablePermSet", "onClickView", "getTips", "", "getPermSetInfo", "updateDocUI", "getIconRes", "shareLinkEnable", "setCanClick", "clickable", "removeOrg", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocumentLinkShareView extends ConstraintLayout implements ej5.a {
    public ImageView a;
    public SimpleTagTextView b;
    public TextView c;
    public TextView d;
    public SimpleTagTextView e;
    public ImageView f;
    public DocPermSetInfo g;
    public IDocPublicPermission h;
    public ShareParams i;
    public boolean j;
    public boolean k;
    public boolean l;

    public static final class a extends t {
        public final /* synthetic */ DocumentLinkShareView c;

        public a(DocumentLinkShareView r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r3) {
            Toast.showFailureText(this.c.getContext(), this.c.getContext().getString(2131888342));
        }
    }

    public static final class b extends t {
        public final /* synthetic */ DocumentLinkShareView c;

        public b(DocumentLinkShareView r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r1) {
            DocumentLinkShareView.R5(this.c);
        }
    }

    @Override // ej5.a
    public void setDivider(boolean r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String getTips() {
        IDocPublicPermission r0 = this.h;
        boolean r1 = false;
        if (r0 == null) goto L8;
        if (r0.isLinkShareClose() == true) goto L8;
        r1 = true;
    L8:
        if (r1 == true) goto L10;
        return null;
    L10:
        if (this.j == true) goto L12;
        return null;
    L12:
        if (this.k == false) goto L16;
        Context r2 = getContext();
        if (r2 == null) goto L23;
        int r3 = 2131886154;
    L20:
        return r2.getString(r3);
    L23:
        return null;
    L16:
        r2 = getContext();
        if (r2 == null) goto L24;
        r3 = 2131886198;
        goto L20
    L24:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5() {
        DocPermSetInfo r6 = this.g;
        if (r6 == null) goto L62;
        IDocPublicPermission r0 = this.h;
        if (r0 == null) goto L63;
        Intrinsics.checkNotNull(r0);
        r6.c(r0);
        boolean r7 = true;
        this.l = true;
        setAlpha(1.0f);
        if (r6.b() == false) goto L10;
    L13:
        boolean r1 = true;
    L14:
        IDocPublicPermission r5 = r6.f.b;
        setCanClick(r1);
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        boolean r9 = e.a.a.a();
        if (r9 == true) goto L17;
    L26:
        boolean r11 = !r5.isLinkShareClose();
        ImageView r2 = getLinkShareIconFromXml();
        if (r11 == false) goto L29;
        int r3 = 2131255013;
    L30:
        r2.setImageResource(r3);
        int r4 = d.d(r5, r1, T5());
        if (r9 == false) goto L33;
        Context r8 = getContext();
        boolean r10 = r5.hasLinkPassword();
        r5.linkPassword();
        LinkShareItem r12 = d.c(r8, r10, r4, r6.getType());
    L34:
        int r13 = ji5.a.a;
        Intrinsics.checkNotNullParameter(r5, "publicPermission");
        if (r5.isSearchableTenant() == false) goto L37;
        int r14 = 1;
    L38:
        getLinkShareSubTitleFromXml().setVisibility(0);
        TextView r15 = getLinkShareSubTitleFromXml();
        if (r9 == false) goto L41;
        int r16 = qi5.b.a;
        Intrinsics.checkNotNull(r12);
        String r17 = qi5.b.a(r12, r14, T5(), r6, getContext(), Boolean.valueOf(r5.hasLinkPassword()));
    L42:
        r15.setText(r17);
        qi5.b.d(r11, getLinkShareTitleFromXml(), r6);
        if (r6.d == true) goto L45;
    L48:
        getLinkShareTagViewFromXml().setVisibility(8);
    L50:
        if (r6.getType() != 44) goto L52;
        getLinkShareMoreFromXml().setVisibility(8);
    L52:
        DocPermSetInfo r18 = this.g;
        if (r18 != null) goto L55;
    L57:
        r7 = false;
    L58:
        if (r7 == false) goto L64;
        setOnClickListener(new ki5.a(this));
        return;
    L64:
        return;
    L55:
        if (r18.getType() != 44) goto L57;
    L45:
        if (r6.f.b.isLinkSharePermTypeSinglePage() == false) goto L48;
        if (r9 == true) goto L48;
        getLinkShareTagViewFromXml().setVisibility(0);
        goto L50
    L41:
        int r19 = qi5.b.a;
        Intrinsics.checkNotNull(r12);
        r17 = qi5.b.c(r12, r14, T5(), r6, getContext(), r5);
        goto L42
    L37:
        r14 = 2;
        goto L38
    L33:
        r12 = d.b(getContext(), r5, r4, r6.getType());
        goto L34
    L29:
        r3 = 2131254029;
        goto L30
    L17:
        if (r6.d == true) goto L19;
    L23:
        AppCompatTextView r20 = getLinkNewShareTagViewFromXml();
        if (r20 == null) goto L26;
        r20.setVisibility(8);
        goto L26
    L19:
        if (r6.f.b.isLinkSharePermTypeSinglePage() == false) goto L23;
        AppCompatTextView r21 = getLinkNewShareTagViewFromXml();
        if (r21 == null) goto L26;
        r21.setVisibility(0);
        goto L26
    L10:
        if (r6.f.a.canManagePermissionMeta() == true) goto L13;
        r1 = false;
        goto L14
    L63:
        return;
    }

    public final boolean T5() {
        AccountService.Account r0 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (((k) org.koin.java.a.c(k.class, null, null, 6)).c() == false) goto L5;
    L8:
        return true;
    L5:
        if (c.b(r0) == true) goto L8;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SimpleTagTextView getLinkNewShareTagViewFromXml() {
        AppCompatTextView r0 = this.b;
        if (r0 != null) goto L6;
        r0 = findViewById(2131377950);
        this.b = (SimpleTagTextView) r0;
    L6:
        return (SimpleTagTextView) r0;
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
        KeyEvent.Callback r0 = this.f;
        if (r0 != null) goto L6;
        r0 = findViewById(2131377957);
        this.f = (ImageView) r0;
    L6:
        return (ImageView) r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TextView getLinkShareSubTitleFromXml() {
        KeyEvent.Callback r0 = this.c;
        if (r0 != null) goto L6;
        r0 = findViewById(2131377958);
        this.c = (TextView) r0;
    L6:
        return (TextView) r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SimpleTagTextView getLinkShareTagViewFromXml() {
        AppCompatTextView r0 = this.e;
        if (r0 != null) goto L6;
        r0 = findViewById(2131377959);
        this.e = (SimpleTagTextView) r0;
    L6:
        return (SimpleTagTextView) r0;
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

    private final DocPermSetInfo getPermSetInfo() {
        return this.g;
    }

    public DocumentLinkShareView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void R5(DocumentLinkShareView r6) {
        DocPermSetInfo r0 = r6.getPermSetInfo();
        if (r0 == null) goto L24;
        cj5.c.b r1 = new cj5.c.b();
        r1.a = r0.a;
        r1.b = r0.c;
        r1.c = r0.getType();
        ShareParams r2 = r6.i;
        String r3 = "";
        if (r2 == null) goto L8;
        String r4 = r2.getRealToken();
        if (r4 == null) goto L8;
    L9:
        r1.d = r4;
        ShareParams r5 = r6.i;
        if (r5 == null) goto L12;
        int r7 = r5.getRealType();
    L13:
        r1.e = r7;
        r1.f = r0.d;
        r1.g = r0.f.a.canManageContainerPermissionMeta();
        r1.h = r0.a();
        r1.i = false;
        r1.k = r6.getTips();
        r1.l = r0.e.getTenantName();
        int r8 = qi5.b.a;
        ShareParams r9 = r6.i;
        if (r9 == null) goto L19;
        String r10 = r9.getModule();
        if (r10 == null) goto L19;
        r3 = r10;
    L19:
        HashMap<String, Serializable> r11 = qi5.b.e(r3, r0);
        String r12 = null;
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).rb(r6.getContext(), r1, r11, null);
        String r13 = r0.c;
        int r14 = r0.getType();
        ShareParams r15 = r6.i;
        if (r15 == null) goto L22;
        r12 = r15.getModule();
    L22:
        PermissionAnalytic.q("click_linkshare_setting", r13, r14, r12);
        com.bytedance.ee.bear.middleground.permission.c.V("share_link", "ccm_permission_share_encrypted_link_view");
        return;
    L12:
        r7 = -1;
    L8:
        r4 = "";
        goto L9
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ej5.a
    public final void k2(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "throwable");
        if (this.l == false) goto L5;
        return;
    L5:
        setOnClickListener(new a(this));
    }

    @Override // ej5.a
    public void setDocPermSetInfo(DocPermSetInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "docPermSetInfo");
        this.g = r2;
        S5();
    }

    public final void setLinkNewShareTagViewFromXml(SimpleTagTextView r1) {
        this.b = r1;
    }

    public final void setLinkShareIconFromXml(ImageView r1) {
        this.a = r1;
    }

    public final void setLinkShareMoreFromXml(ImageView r1) {
        this.f = r1;
    }

    public final void setLinkShareSubTitleFromXml(TextView r1) {
        this.c = r1;
    }

    public final void setLinkShareTagViewFromXml(SimpleTagTextView r1) {
        this.e = r1;
    }

    public final void setLinkShareTitleFromXml(TextView r1) {
        this.d = r1;
    }

    @Override // ej5.a
    public void setPublicPermission(IDocPublicPermission r2) {
        Intrinsics.checkNotNullParameter(r2, "publicPerm");
        this.h = r2;
        S5();
    }

    public DocumentLinkShareView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DocumentLinkShareView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131564186, this);
        getLinkShareIconFromXml().setImageResource(2131255013);
        setAlpha(0.3f);
    }
}
