package com.bytedance.ee.bear.middleground.permission.setting.linkshare.sharelinkset;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ee.bear.contract.AccountService$Account;
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
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.contact.base.statistics.InvHitPoint;
import com.ss.android.lark.utils.statistics.PerfLog;
import hi5.d;
import java.io.Serializable;
import java.util.HashMap;
import jg5.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ui5.c;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0010\u00101\u001a\u0002022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u00104\u001a\u0002022\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u00105\u001a\u00020/J\u0016\u00106\u001a\u0002022\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/J\u0010\u00107\u001a\u0002022\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u00108\u001a\u0002022\u0006\u0010*\u001a\u00020+H\u0016J\b\u00109\u001a\u000202H\u0002J\b\u0010:\u001a\u000202H\u0002J\u0010\u0010;\u001a\u0002022\u0006\u0010<\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u0002022\u0006\u0010?\u001a\u00020/H\u0016J\u0010\u0010@\u001a\u00020/2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010A\u001a\u000202H\u0002J\n\u0010B\u001a\u0004\u0018\u00010CH\u0002J\n\u0010D\u001a\u0004\u0018\u00010)H\u0002J\u0018\u0010E\u001a\u0002022\u0006\u0010(\u001a\u00020)2\u0006\u0010@\u001a\u00020/H\u0002J\u0010\u0010F\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020/H\u0002J\u0010\u0010H\u001a\u0002022\u0006\u0010I\u001a\u00020/H\u0002J\b\u0010J\u001a\u00020/H\u0002R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00148FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001a8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u001a8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001e\u0010\"\u001a\u0004\u0018\u00010\u00148FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001e\u0010%\u001a\u0004\u0018\u00010\u000e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0010\"\u0004\b'\u0010\u0012R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/setting/linkshare/sharelinkset/DocumentLinkShareView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/permissionset/IDocPermSetInfo;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "linkShareIconFromXml", "Landroid/widget/ImageView;", "getLinkShareIconFromXml", "()Landroid/widget/ImageView;", "setLinkShareIconFromXml", "(Landroid/widget/ImageView;)V", "linkNewShareTagViewFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SimpleTagTextView;", "getLinkNewShareTagViewFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SimpleTagTextView;", "setLinkNewShareTagViewFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SimpleTagTextView;)V", "linkShareSubTitleFromXml", "Landroid/widget/TextView;", "getLinkShareSubTitleFromXml", "()Landroid/widget/TextView;", "setLinkShareSubTitleFromXml", "(Landroid/widget/TextView;)V", "linkShareTitleFromXml", "getLinkShareTitleFromXml", "setLinkShareTitleFromXml", "linkShareTagViewFromXml", "getLinkShareTagViewFromXml", "setLinkShareTagViewFromXml", "linkShareMoreFromXml", "getLinkShareMoreFromXml", "setLinkShareMoreFromXml", "docPermSetInfo", "Lcom/bytedance/ee/bear/middleground_permission_export/model/permissionset/DocPermSetInfo;", "publicPerm", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission;", "shareParams", "Lcom/bytedance/ee/bear/share/export/ShareParams;", "isPro", "", "isProAccessConfigBindRole", "init", "", "hasPullPerm", "setInfo", "showDivider", "setBitableProInfo", "setDocPermSetInfo", "setPublicPermission", "makePermInfoComple", "handleSyncedClick", "failToFetchPerm", LynxError.LYNX_THROWABLE, "", "setDivider", "show", "enablePermSet", "onClickView", "getTips", "", "getPermSetInfo", "updateDocUI", "getIconRes", "shareLinkEnable", "setCanClick", "clickable", "removeOrg", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocumentLinkShareView extends ConstraintLayout implements ej5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f234190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SimpleTagTextView f234191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f234192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f234193d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SimpleTagTextView f234194e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f234195f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DocPermSetInfo f234196g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public IDocPublicPermission f234197h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ShareParams f234198i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f234199j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f234200k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f234201l;

    public static final class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DocumentLinkShareView f234202c;

        public a(DocumentLinkShareView r100) {
            this.f234202c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            Toast.showFailureText(this.f234202c.getContext(), this.f234202c.getContext().getString(R.string.Doc_Wiki_SeverError));
        }
    }

    public static final class b extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DocumentLinkShareView f234203c;

        public b(DocumentLinkShareView r100) {
            this.f234203c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            DocumentLinkShareView.R5(this.f234203c);
        }
    }

    @Override // ej5.a
    public void setDivider(boolean r100) {
    }

    private final String getTips() {
        IDocPublicPermission r100 = this.f234197h;
        boolean r101 = false;
        if (r100 == null) goto L8;
        if (r100.isLinkShareClose() == true) goto L8;
        r101 = true;
    L8:
        if (r101 == true) goto L10;
        return null;
    L10:
        if (this.f234199j == true) goto L12;
        return null;
    L12:
        if (this.f234200k == false) goto L16;
        Context r102 = getContext();
        if (r102 == null) goto L23;
        int r103 = R.string.Bitable_AdvancedPermission_Enabled_Desc;
    L20:
        return r102.getString(r103);
    L23:
        return null;
    L16:
        r102 = getContext();
        if (r102 == null) goto L24;
        r103 = R.string.Bitable_AdvancedPermission_SomeCantAccess_Desc;
        goto L20
    L24:
        return null;
    }

    public final void S5() {
        DocPermSetInfo r100 = this.f234196g;
        if (r100 == null) goto L62;
        IDocPublicPermission r101 = this.f234197h;
        if (r101 == null) goto L63;
        Intrinsics.checkNotNull(r101);
        r100.c(r101);
        boolean r102 = true;
        this.f234201l = true;
        setAlpha(1.0f);
        if (r100.b() == false) goto L10;
    L13:
        boolean r103 = true;
    L14:
        IDocPublicPermission r104 = r100.f234432f.f234420b;
        setCanClick(r103);
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        boolean r105 = e.a.f499003a.a();
        if (r105 == true) goto L17;
    L26:
        boolean r110 = !r104.isLinkShareClose();
        ImageView r106 = getLinkShareIconFromXml();
        if (r110 == false) goto L29;
        int r107 = R.drawable.ud_icon_link_copy_outlined;
    L30:
        r106.setImageResource(r107);
        int r108 = d.d(r104, r103, T5());
        if (r105 == false) goto L33;
        Context r109 = getContext();
        boolean r111 = r104.hasLinkPassword();
        r104.linkPassword();
        LinkShareItem r112 = d.c(r109, r111, r108, r100.getType());
    L34:
        int r113 = ji5.a.f499199a;
        Intrinsics.checkNotNullParameter(r104, "publicPermission");
        if (r104.isSearchableTenant() == false) goto L37;
        int r114 = 1;
    L38:
        getLinkShareSubTitleFromXml().setVisibility(0);
        TextView r115 = getLinkShareSubTitleFromXml();
        if (r105 == false) goto L41;
        int r116 = qi5.b.f533150a;
        Intrinsics.checkNotNull(r112);
        String r117 = qi5.b.a(r112, r114, T5(), r100, getContext(), Boolean.valueOf(r104.hasLinkPassword()));
    L42:
        r115.setText(r117);
        qi5.b.d(r110, getLinkShareTitleFromXml(), r100);
        if (r100.f234430d == true) goto L45;
    L48:
        getLinkShareTagViewFromXml().setVisibility(8);
    L50:
        if (r100.getType() != 44) goto L52;
        getLinkShareMoreFromXml().setVisibility(8);
    L52:
        DocPermSetInfo r118 = this.f234196g;
        if (r118 != null) goto L55;
    L57:
        r102 = false;
    L58:
        if (r102 == false) goto L64;
        setOnClickListener(new ki5.a(this));
        return;
    L64:
        return;
    L55:
        if (r118.getType() != 44) goto L57;
    L45:
        if (r100.f234432f.f234420b.isLinkSharePermTypeSinglePage() == false) goto L48;
        if (r105 == true) goto L48;
        getLinkShareTagViewFromXml().setVisibility(0);
        goto L50
    L41:
        int r119 = qi5.b.f533150a;
        Intrinsics.checkNotNull(r112);
        r117 = qi5.b.c(r112, r114, T5(), r100, getContext(), r104);
        goto L42
    L37:
        r114 = 2;
        goto L38
    L33:
        r112 = d.b(getContext(), r104, r108, r100.getType());
        goto L34
    L29:
        r107 = R.drawable.ud_icon_cancel_link_outlined;
        goto L30
    L17:
        if (r100.f234430d == true) goto L19;
    L23:
        SimpleTagTextView r120 = getLinkNewShareTagViewFromXml();
        if (r120 == null) goto L26;
        r120.setVisibility(8);
        goto L26
    L19:
        if (r100.f234432f.f234420b.isLinkSharePermTypeSinglePage() == false) goto L23;
        SimpleTagTextView r121 = getLinkNewShareTagViewFromXml();
        if (r121 == null) goto L26;
        r121.setVisibility(0);
        goto L26
    L10:
        if (r100.f234432f.f234419a.canManagePermissionMeta() == true) goto L13;
        r103 = false;
        goto L14
    L63:
        return;
    }

    public final boolean T5() {
        AccountService$Account r100 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (((k) org.koin.java.a.c(k.class, null, null, 6)).c() == false) goto L5;
    L8:
        return true;
    L5:
        if (c.b(r100) == true) goto L8;
        return false;
    }

    public final SimpleTagTextView getLinkNewShareTagViewFromXml() {
        KeyEvent.Callback r100 = this.f234191b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.linkNewShareTagView);
        this.f234191b = (SimpleTagTextView) r100;
    L6:
        return (SimpleTagTextView) r100;
    }

    public final ImageView getLinkShareIconFromXml() {
        KeyEvent.Callback r100 = this.f234190a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.linkShareIcon);
        this.f234190a = (ImageView) r100;
    L6:
        return (ImageView) r100;
    }

    public final ImageView getLinkShareMoreFromXml() {
        KeyEvent.Callback r100 = this.f234195f;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.linkShareMore);
        this.f234195f = (ImageView) r100;
    L6:
        return (ImageView) r100;
    }

    public final TextView getLinkShareSubTitleFromXml() {
        KeyEvent.Callback r100 = this.f234192c;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.linkShareSubTitle);
        this.f234192c = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final SimpleTagTextView getLinkShareTagViewFromXml() {
        KeyEvent.Callback r100 = this.f234194e;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.linkShareTagView);
        this.f234194e = (SimpleTagTextView) r100;
    L6:
        return (SimpleTagTextView) r100;
    }

    public final TextView getLinkShareTitleFromXml() {
        KeyEvent.Callback r100 = this.f234193d;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.linkShareTitle);
        this.f234193d = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    private final DocPermSetInfo getPermSetInfo() {
        return this.f234196g;
    }

    public DocumentLinkShareView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public static final void R5(DocumentLinkShareView r100) {
        DocPermSetInfo r101 = r100.getPermSetInfo();
        if (r101 == null) goto L24;
        cj5.c.b r102 = new cj5.c.b();
        r102.f23970a = r101.f234427a;
        r102.f23971b = r101.f234429c;
        r102.f23972c = r101.getType();
        ShareParams r103 = r100.f234198i;
        String r104 = "";
        if (r103 == null) goto L8;
        String r105 = r103.getRealToken();
        if (r105 == null) goto L8;
    L9:
        r102.f23973d = r105;
        ShareParams r106 = r100.f234198i;
        if (r106 == null) goto L12;
        int r107 = r106.getRealType();
    L13:
        r102.f23974e = r107;
        r102.f23975f = r101.f234430d;
        r102.f23976g = r101.f234432f.f234419a.canManageContainerPermissionMeta();
        r102.f23977h = r101.a();
        r102.f23978i = false;
        r102.f23980k = r100.getTips();
        r102.f23981l = r101.f234431e.getTenantName();
        int r108 = qi5.b.f533150a;
        ShareParams r109 = r100.f234198i;
        if (r109 == null) goto L19;
        String r110 = r109.getModule();
        if (r110 == null) goto L19;
        r104 = r110;
    L19:
        HashMap<String, Serializable> r111 = qi5.b.e(r104, r101);
        String r112 = null;
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).rb(r100.getContext(), r102, r111, null);
        String r113 = r101.f234429c;
        int r114 = r101.getType();
        ShareParams r115 = r100.f234198i;
        if (r115 == null) goto L22;
        r112 = r115.getModule();
    L22:
        PermissionAnalytic.q("click_linkshare_setting", r113, r114, r112);
        com.bytedance.ee.bear.middleground.permission.c.V(InvHitPoint.ShareMethod.SHARE_LINK, "ccm_permission_share_encrypted_link_view");
        return;
    L12:
        r107 = -1;
    L8:
        r105 = "";
        goto L9
    }

    private final void setCanClick(boolean r100) {
        if (r100 == false) goto L4;
        setOnClickListener(new b(this));
    L5:
        ImageView r101 = getLinkShareMoreFromXml();
        if (r100 == false) goto L8;
        int r102 = 0;
    L9:
        r101.setVisibility(r102);
        return;
    L8:
        r102 = 8;
        goto L9
    L4:
        setOnClickListener(null);
        goto L5
    }

    @Override // ej5.a
    public final void k2(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        if (this.f234201l == false) goto L5;
        return;
    L5:
        setOnClickListener(new a(this));
    }

    @Override // ej5.a
    public void setDocPermSetInfo(DocPermSetInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "docPermSetInfo");
        this.f234196g = r100;
        S5();
    }

    public final void setLinkNewShareTagViewFromXml(SimpleTagTextView r100) {
        this.f234191b = r100;
    }

    public final void setLinkShareIconFromXml(ImageView r100) {
        this.f234190a = r100;
    }

    public final void setLinkShareMoreFromXml(ImageView r100) {
        this.f234195f = r100;
    }

    public final void setLinkShareSubTitleFromXml(TextView r100) {
        this.f234192c = r100;
    }

    public final void setLinkShareTagViewFromXml(SimpleTagTextView r100) {
        this.f234194e = r100;
    }

    public final void setLinkShareTitleFromXml(TextView r100) {
        this.f234193d = r100;
    }

    @Override // ej5.a
    public void setPublicPermission(IDocPublicPermission r100) {
        Intrinsics.checkNotNullParameter(r100, "publicPerm");
        this.f234197h = r100;
        S5();
    }

    public DocumentLinkShareView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public DocumentLinkShareView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.permission_link_share_layout, this);
        getLinkShareIconFromXml().setImageResource(R.drawable.ud_icon_link_copy_outlined);
        setAlpha(0.3f);
    }
}
