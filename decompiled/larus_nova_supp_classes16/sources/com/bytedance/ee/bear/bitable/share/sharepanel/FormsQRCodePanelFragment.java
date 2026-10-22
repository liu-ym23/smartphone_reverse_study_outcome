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
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 C2\u00020\u0001:\u0002CDB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020)H\u0016J\u0014\u0010/\u001a\u00020)2\f\u00100\u001a\b\u0012\u0004\u0012\u00020)0,J&\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u001a\u00109\u001a\u00020)2\u0006\u0010:\u001a\u0002022\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u0010;\u001a\u00020)H\u0002J\u0010\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020>H\u0002J\b\u0010?\u001a\u00020)H\u0016J\b\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u00020)H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001e\u0010\u001f\u001a\u0004\u0018\u00010 8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u0004\u0018\u00010 8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u0016\u0010+\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/bytedance/ee/bear/bitable/share/sharepanel/FormsQRCodePanelFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "quitQRCodeFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getQuitQRCodeFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setQuitQRCodeFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "formsCoverFromXml", "getFormsCoverFromXml", "setFormsCoverFromXml", "baseIconFromXml", "getBaseIconFromXml", "setBaseIconFromXml", "formsTitleFromXml", "Landroid/widget/TextView;", "getFormsTitleFromXml", "()Landroid/widget/TextView;", "setFormsTitleFromXml", "(Landroid/widget/TextView;)V", "formsShareLinkQRCodeFromXml", "getFormsShareLinkQRCodeFromXml", "setFormsShareLinkQRCodeFromXml", "qrcodeHintTvFromXml", "getQrcodeHintTvFromXml", "setQrcodeHintTvFromXml", "brandHintFromXml", "getBrandHintFromXml", "setBrandHintFromXml", "saveQRCodeFromXml", "Landroid/widget/LinearLayout;", "getSaveQRCodeFromXml", "()Landroid/widget/LinearLayout;", "setSaveQRCodeFromXml", "(Landroid/widget/LinearLayout;)V", "mainContentFromXml", "getMainContentFromXml", "setMainContentFromXml", "clearFromXmlViewCache", "", "onDestroyView", "mOnSaveClickListener", "Lkotlin/Function0;", "mQRCodeBmpDisposable", "Lio/reactivex/disposables/Disposable;", "setOnSaveClickListener", "listener", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initView", "loadBannerAndMask", "uri", "", "onStart", "isFragmentStateValid", "", "onDestroy", "Companion", "FormsBannerModel", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FormsQRCodePanelFragment extends DialogFragment {
    public static final /* synthetic */ int o = 0;
    public AppCompatImageView d;
    public AppCompatImageView e;
    public AppCompatImageView f;
    public TextView g;
    public AppCompatImageView h;
    public TextView i;
    public TextView j;
    public LinearLayout k;
    public LinearLayout l;
    public Function0<Unit> m;
    public Disposable n;

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

        public FormsBannerModel(String r2, String r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "tableId");
            Intrinsics.checkNotNullParameter(r3, "viewId");
            Intrinsics.checkNotNullParameter(r4, "fileToken");
            Intrinsics.checkNotNullParameter(r5, "shareToken");
            this.tableId = r2;
            this.viewId = r3;
            this.fileToken = r4;
            this.shareToken = r5;
        }
    }

    public static final class a {
        public static FormsQRCodePanelFragment a(String r2, String r3, String r4, String r5, String r6) {
            Intrinsics.checkNotNullParameter(r2, "formsName");
            Intrinsics.checkNotNullParameter(r4, "formsShareUrl");
            Intrinsics.checkNotNullParameter(r5, "baseToken");
            Bundle r0 = new Bundle();
            r0.putString("base_token", r5);
            r0.putString("forms_name", r2);
            if (r3 == null) goto L5;
            r0.putString("forms_cover_img", r3);
        L5:
            r0.putString("forms_share_url", r4);
            if (r6 == null) goto L8;
            r0.putString("qrcode_hint", r6);
        L8:
            FormsQRCodePanelFragment r7 = new FormsQRCodePanelFragment();
            r7.setArguments(r0);
            return r7;
        }
    }

    static {
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.m = null;
        Disposable r0 = this.n;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.gravity = 80;
        r2.y = com.bytedance.ee.util.ui.k.e(r1.getContext());
        r2.windowAnimations = 2131951621;
        r1.setAttributes(r2);
        r1.setLayout(-1, -1);
        r1.setBackgroundDrawable(new ColorDrawable(0));
    L7:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).d(getDialog());
    }

    public FormsQRCodePanelFragment() {
    }

    public static final boolean S90(FormsQRCodePanelFragment r1) {
        if (r1.isAdded() == true) goto L5;
    L9:
        return false;
    L5:
        if (r1.isDetached() == true) goto L9;
        if (r1.getContext() == null) goto L9;
        return true;
    }

    public final void T90(String r5) {
        float r0 = UIUtils.dp2px(requireContext(), 16.0f);
        RequestBuilder r6 = Glide.with(requireContext()).load(r5).diskCacheStrategy(DiskCacheStrategy.ALL).transform(new Transformation[]{new CenterCrop(), new FourRoundedCorners(r0, r0, 0.0f, 0.0f)}).placeholder(kac.a.b(2131254464));
        View r1 = this.e;
        if (r1 != null) goto L9;
        View r2 = getView();
        if (r2 == null) goto L7;
        r1 = r2.findViewById(2131373210);
    L8:
        this.e = (AppCompatImageView) r1;
        goto L9
    L7:
        r1 = null;
    L9:
        r6.into((AppCompatImageView) r1);
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r10, r11);
        Unit r12 = "FormsQRCodePanelFragment";
        Bundle r0 = getArguments();
        View r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getString("forms_name");
    L6:
        Bundle r3 = getArguments();
        if (r3 == null) goto L9;
        String r4 = r3.getString("forms_cover_img");
    L10:
        Bundle r5 = getArguments();
        if (r5 == null) goto L13;
        String r6 = r5.getString("forms_share_url");
    L14:
        Bundle r7 = getArguments();
        if (r7 == null) goto L17;
        r7.getString("base_token");
    L17:
        Bundle r8 = getArguments();
        if (r8 == null) goto L20;
        String r9 = r8.getString("qrcode_hint");
    L21:
        View r13 = this.f;
        if (r13 != null) goto L28;
        View r14 = getView();
        if (r14 == null) goto L26;
        r13 = r14.findViewById(2131363977);
    L27:
        this.f = (AppCompatImageView) r13;
        goto L28
    L26:
        r13 = null;
    L28:
        AppCompatImageView r16 = (AppCompatImageView) r13;
        View r17 = this.j;
        if (r17 != null) goto L35;
        View r18 = getView();
        if (r18 == null) goto L33;
        r17 = r18.findViewById(2131364562);
    L34:
        this.j = (TextView) r17;
        goto L35
    L33:
        r17 = null;
    L35:
        s.a(r16, (TextView) r17);
        View r19 = this.d;
        if (r19 != null) goto L42;
        View r20 = getView();
        if (r20 == null) goto L40;
        r19 = r20.findViewById(2131383572);
    L41:
        this.d = (AppCompatImageView) r19;
        goto L42
    L40:
        r19 = null;
    L42:
        ((AppCompatImageView) r19).setOnClickListener(new f(this));
        if (r4 != null) goto L45;
    L56:
        View r110 = this.e;
        if (r110 != null) goto L63;
        View r111 = getView();
        if (r111 == null) goto L61;
        r110 = r111.findViewById(2131373210);
    L62:
        this.e = (AppCompatImageView) r110;
        goto L63
    L61:
        r110 = null;
    L63:
        ((AppCompatImageView) r110).setVisibility(8);
    L64:
        if (r2 == null) goto L73;
        View r112 = this.g;
        if (r112 != null) goto L72;
        View r113 = getView();
        if (r113 == null) goto L70;
        r112 = r113.findViewById(2131373212);
    L71:
        this.g = (TextView) r112;
        goto L72
    L70:
        r112 = null;
    L72:
        ((TextView) r112).setText(r2);
    L73:
        if (r6 == null) goto L75;
        Flowable.just("").map(new h(r6, UIUtils.dp2px(getContext(), 245.0f), UIUtils.dp2px(getContext(), 245.0f))).subscribeOn(fo5.d.c()).observeOn(fo5.d.d()).subscribe(new i(this), j.a);
    L75:
        if (r9 == null) goto L84;
        View r114 = this.i;
        if (r114 != null) goto L83;
        View r115 = getView();
        if (r115 == null) goto L81;
        r114 = r115.findViewById(2131383508);
    L82:
        this.i = (TextView) r114;
        goto L83
    L81:
        r114 = null;
    L83:
        ((TextView) r114).setText(r9);
    L84:
        View r116 = this.k;
        if (r116 != null) goto L90;
        View r117 = getView();
        if (r117 == null) goto L89;
        r1 = r117.findViewById(2131385086);
    L89:
        this.k = (LinearLayout) r1;
        r116 = r1;
    L90:
        ((LinearLayout) r116).setOnClickListener(new k(this));
        return;
    L45:
        if (TextUtils.isEmpty(r4) == true) goto L56;
        String r21 = UriProtector.getQueryParameter(UriProtector.parse(r4), "extra");     // Catch: Throwable -> L54
        if (TextUtils.isEmpty(r21) == false) goto L50;
        tt5.a.h("FormsQRCodePanelFragment", "cdnUrl=".concat(r4));     // Catch: Throwable -> L54
        T90(r4);     // Catch: Throwable -> L54
        r12 = Unit.INSTANCE;     // Catch: Throwable -> L54
    L92:
        goto L64
    L50:
        String r118 = JSON.parseObject(r21).getString("sharePerm");     // Catch: Throwable -> L54
        if (r118 == null) goto L92;
        FormsBannerModel r119 = (FormsBannerModel) JSON.parseObject(r118, FormsBannerModel.class);     // Catch: Throwable -> L54
        g r22 = new g(this);     // Catch: Throwable -> L54
        w85.a.C0319a r23 = new w85.a.C0319a();     // Catch: Throwable -> L54
        r23.a = true;     // Catch: Throwable -> L54
        r23.d = r4;     // Catch: Throwable -> L54
        r23.e = r119.getFileToken();     // Catch: Throwable -> L54
        r23.m = r21;     // Catch: Throwable -> L54
        r23.b = DownloadRequestInfo.DownloadType.COVER;     // Catch: Throwable -> L54
        r23.j = r22;     // Catch: Throwable -> L54
        r23.g = "bitable_image";     // Catch: Throwable -> L54
        ((w85.c) org.koin.java.a.c(w85.c.class, null, null, 6)).d(new w85.a(r23));     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        tt5.a.e(r12, "load formsBanner failed", th, false);
        Unit r120 = Unit.INSTANCE;
        goto L64
    L20:
        r9 = null;
        goto L21
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561152, r3, false);
    }
}
