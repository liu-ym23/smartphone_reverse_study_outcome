package com.bytedance.ee.bear.bitable.share.sharepanel;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.DialogFragment;
import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 C2\u00020\u0001:\u0002CDB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020)H\u0016J\u0014\u0010/\u001a\u00020)2\f\u00100\u001a\b\u0012\u0004\u0012\u00020)0,J&\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u001a\u00109\u001a\u00020)2\u0006\u0010:\u001a\u0002022\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u0010;\u001a\u00020)H\u0002J\u0010\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020>H\u0002J\b\u0010?\u001a\u00020)H\u0016J\b\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u00020)H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001e\u0010\u001f\u001a\u0004\u0018\u00010 8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u0004\u0018\u00010 8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u0016\u0010+\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/bytedance/ee/bear/bitable/share/sharepanel/FormsQRCodePanelFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "quitQRCodeFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getQuitQRCodeFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setQuitQRCodeFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "formsCoverFromXml", "getFormsCoverFromXml", "setFormsCoverFromXml", "baseIconFromXml", "getBaseIconFromXml", "setBaseIconFromXml", "formsTitleFromXml", "Landroid/widget/TextView;", "getFormsTitleFromXml", "()Landroid/widget/TextView;", "setFormsTitleFromXml", "(Landroid/widget/TextView;)V", "formsShareLinkQRCodeFromXml", "getFormsShareLinkQRCodeFromXml", "setFormsShareLinkQRCodeFromXml", "qrcodeHintTvFromXml", "getQrcodeHintTvFromXml", "setQrcodeHintTvFromXml", "brandHintFromXml", "getBrandHintFromXml", "setBrandHintFromXml", "saveQRCodeFromXml", "Landroid/widget/LinearLayout;", "getSaveQRCodeFromXml", "()Landroid/widget/LinearLayout;", "setSaveQRCodeFromXml", "(Landroid/widget/LinearLayout;)V", "mainContentFromXml", "getMainContentFromXml", "setMainContentFromXml", "clearFromXmlViewCache", "", "onDestroyView", "mOnSaveClickListener", "Lkotlin/Function0;", "mQRCodeBmpDisposable", "Lio/reactivex/disposables/Disposable;", "setOnSaveClickListener", "listener", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initView", "loadBannerAndMask", "uri", "", WidgetCostModule.TYPE_ON_START, "isFragmentStateValid", "", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "FormsBannerModel", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FormsQRCodePanelFragment extends DialogFragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f215375o = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AppCompatImageView f215376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AppCompatImageView f215377e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AppCompatImageView f215378f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f215379g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AppCompatImageView f215380h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f215381i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f215382j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LinearLayout f215383k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LinearLayout f215384l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Function0<Unit> f215385m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Disposable f215386n;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/share/sharepanel/FormsQRCodePanelFragment$FormsBannerModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "tableId", "", "viewId", "fileToken", "shareToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTableId", "()Ljava/lang/String;", "getViewId", "getFileToken", "getShareToken", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FormsBannerModel implements NonProguard {
        private final String fileToken;
        private final String shareToken;
        private final String tableId;
        private final String viewId;

        public final String getFileToken() {
            return this.fileToken;
        }

        public final String getShareToken() {
            return this.shareToken;
        }

        public final String getTableId() {
            return this.tableId;
        }

        public final String getViewId() {
            return this.viewId;
        }

        public FormsBannerModel(String r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "tableId");
            Intrinsics.checkNotNullParameter(r101, "viewId");
            Intrinsics.checkNotNullParameter(r102, "fileToken");
            Intrinsics.checkNotNullParameter(r103, "shareToken");
            this.tableId = r100;
            this.viewId = r101;
            this.fileToken = r102;
            this.shareToken = r103;
        }
    }

    public static final class a {
        public static FormsQRCodePanelFragment a(String r100, String r101, String r102, String r103, String r104) {
            Intrinsics.checkNotNullParameter(r100, "formsName");
            Intrinsics.checkNotNullParameter(r102, "formsShareUrl");
            Intrinsics.checkNotNullParameter(r103, "baseToken");
            Bundle r105 = new Bundle();
            r105.putString(BitableResourceData.KEY_BASE_TOKEN, r103);
            r105.putString("forms_name", r100);
            if (r101 == null) goto L5;
            r105.putString("forms_cover_img", r101);
        L5:
            r105.putString("forms_share_url", r102);
            if (r104 == null) goto L8;
            r105.putString("qrcode_hint", r104);
        L8:
            FormsQRCodePanelFragment r106 = new FormsQRCodePanelFragment();
            r106.setArguments(r105);
            return r106;
        }
    }

    static {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f215385m = null;
        Disposable r100 = this.f215386n;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f215376d = null;
        this.f215377e = null;
        this.f215378f = null;
        this.f215379g = null;
        this.f215380h = null;
        this.f215381i = null;
        this.f215382j = null;
        this.f215383k = null;
        this.f215384l = null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L7;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L7;
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r102.gravity = 80;
        r102.y = com.bytedance.ee.util.ui.k.e(r101.getContext());
        r102.windowAnimations = R.style.ActionSheetDialogAnimation;
        r101.setAttributes(r102);
        r101.setLayout(-1, -1);
        r101.setBackgroundDrawable(new ColorDrawable(0));
    L7:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).d(getDialog());
    }

    public FormsQRCodePanelFragment() {
    }

    public static final boolean S90(FormsQRCodePanelFragment r100) {
        if (r100.isAdded() == true) goto L5;
    L9:
        return false;
    L5:
        if (r100.isDetached() == true) goto L9;
        if (r100.getContext() == null) goto L9;
        return true;
    }

    public final void T90(String r100) {
        float r101 = UIUtils.dp2px(requireContext(), 16.0f);
        RequestBuilder r102 = Glide.with(requireContext()).load(r100).diskCacheStrategy(DiskCacheStrategy.ALL).transform(new Transformation[]{new CenterCrop(), new FourRoundedCorners(r101, r101, 0.0f, 0.0f)}).placeholder(kac.a.b(R.drawable.ud_icon_file_image_colorful));
        View r103 = this.f215377e;
        if (r103 != null) goto L9;
        View r104 = getView();
        if (r104 == null) goto L7;
        r103 = r104.findViewById(R.id.formsCover);
    L8:
        this.f215377e = (AppCompatImageView) r103;
        goto L9
    L7:
        r103 = null;
    L9:
        r102.into((AppCompatImageView) r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        String r112 = "FormsQRCodePanelFragment";
        Bundle r100 = getArguments();
        View r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getString("forms_name");
    L6:
        Bundle r103 = getArguments();
        if (r103 == null) goto L9;
        String r104 = r103.getString("forms_cover_img");
    L10:
        Bundle r105 = getArguments();
        if (r105 == null) goto L13;
        String r106 = r105.getString("forms_share_url");
    L14:
        Bundle r107 = getArguments();
        if (r107 == null) goto L17;
        r107.getString(BitableResourceData.KEY_BASE_TOKEN);
    L17:
        Bundle r108 = getArguments();
        if (r108 == null) goto L20;
        String r109 = r108.getString("qrcode_hint");
    L21:
        View r113 = this.f215378f;
        if (r113 != null) goto L28;
        View r114 = getView();
        if (r114 == null) goto L26;
        r113 = r114.findViewById(R.id.baseIcon);
    L27:
        this.f215378f = (AppCompatImageView) r113;
        goto L28
    L26:
        r113 = null;
    L28:
        AppCompatImageView r115 = (AppCompatImageView) r113;
        View r116 = this.f215382j;
        if (r116 != null) goto L35;
        View r117 = getView();
        if (r117 == null) goto L33;
        r116 = r117.findViewById(R.id.brandHint);
    L34:
        this.f215382j = (TextView) r116;
        goto L35
    L33:
        r116 = null;
    L35:
        s.a(r115, (TextView) r116);
        View r118 = this.f215376d;
        if (r118 != null) goto L42;
        View r119 = getView();
        if (r119 == null) goto L40;
        r118 = r119.findViewById(R.id.quitQRCode);
    L41:
        this.f215376d = (AppCompatImageView) r118;
        goto L42
    L40:
        r118 = null;
    L42:
        ((AppCompatImageView) r118).setOnClickListener(new f(this));
        if (r104 != null) goto L45;
    L56:
        View r120 = this.f215377e;
        if (r120 != null) goto L63;
        View r121 = getView();
        if (r121 == null) goto L61;
        r120 = r121.findViewById(R.id.formsCover);
    L62:
        this.f215377e = (AppCompatImageView) r120;
        goto L63
    L61:
        r120 = null;
    L63:
        ((AppCompatImageView) r120).setVisibility(8);
    L64:
        if (r102 == null) goto L73;
        View r122 = this.f215379g;
        if (r122 != null) goto L72;
        View r123 = getView();
        if (r123 == null) goto L70;
        r122 = r123.findViewById(R.id.formsTitle);
    L71:
        this.f215379g = (TextView) r122;
        goto L72
    L70:
        r122 = null;
    L72:
        ((TextView) r122).setText(r102);
    L73:
        if (r106 == null) goto L75;
        Flowable.just("").map(new h(r106, UIUtils.dp2px(getContext(), 245.0f), UIUtils.dp2px(getContext(), 245.0f))).subscribeOn(fo5.d.c()).observeOn(fo5.d.d()).subscribe(new i(this), j.f215449a);
    L75:
        if (r109 == null) goto L84;
        View r124 = this.f215381i;
        if (r124 != null) goto L83;
        View r125 = getView();
        if (r125 == null) goto L81;
        r124 = r125.findViewById(R.id.qrcodeHintTv);
    L82:
        this.f215381i = (TextView) r124;
        goto L83
    L81:
        r124 = null;
    L83:
        ((TextView) r124).setText(r109);
    L84:
        View r126 = this.f215383k;
        if (r126 != null) goto L90;
        View r127 = getView();
        if (r127 == null) goto L89;
        r101 = r127.findViewById(R.id.saveQRCode);
    L89:
        this.f215383k = (LinearLayout) r101;
        r126 = r101;
    L90:
        ((LinearLayout) r126).setOnClickListener(new k(this));
        return;
    L45:
        if (TextUtils.isEmpty(r104) == true) goto L56;
        String r128 = UriProtector.getQueryParameter(UriProtector.parse(r104), "extra");     // Catch: Throwable -> L54
        if (TextUtils.isEmpty(r128) == false) goto L50;
        tt5.a.h("FormsQRCodePanelFragment", "cdnUrl=".concat(r104));     // Catch: Throwable -> L54
        T90(r104);     // Catch: Throwable -> L54
        r112 = Unit.INSTANCE;     // Catch: Throwable -> L54
    L92:
        goto L64
    L50:
        String r129 = JSON.parseObject(r128).getString("sharePerm");     // Catch: Throwable -> L54
        r112 = r112;
        if (r129 == null) goto L92;
        FormsBannerModel r130 = (FormsBannerModel) JSON.parseObject(r129, FormsBannerModel.class);     // Catch: Throwable -> L54
        g r131 = new g(this);     // Catch: Throwable -> L54
        w85.a.C8081a r132 = new w85.a.C8081a();     // Catch: Throwable -> L54
        r132.f558639a = true;     // Catch: Throwable -> L54
        r132.f558642d = r104;     // Catch: Throwable -> L54
        r132.f558643e = r130.getFileToken();     // Catch: Throwable -> L54
        r132.f558651m = r128;     // Catch: Throwable -> L54
        r132.f558640b = DownloadRequestInfo.DownloadType.COVER;     // Catch: Throwable -> L54
        r132.f558648j = r131;     // Catch: Throwable -> L54
        r132.f558645g = "bitable_image";     // Catch: Throwable -> L54
        ((w85.c) org.koin.java.a.c(w85.c.class, null, null, 6)).d(new w85.a(r132));     // Catch: Throwable -> L54
        r112 = r112;
    L54:
        th = move-exception;
        tt5.a.e(r112, "load formsBanner failed", th, false);
        Unit r133 = Unit.INSTANCE;
        goto L64
    L20:
        r109 = null;
        goto L21
    L13:
        r106 = null;
        goto L14
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.forms_qrcode_panel_fragment, r101, false);
    }
}
