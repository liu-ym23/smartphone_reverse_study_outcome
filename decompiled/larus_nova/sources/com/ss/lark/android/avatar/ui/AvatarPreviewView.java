package com.ss.lark.android.avatar.ui;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.ui.ViewPagerWithoutScroll;
import com.larksuite.framework.utils.UIUtils;
import com.larksuite.framework.utils.h0;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.image.uploader.config.ConfigManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.ui.CommonTitleBarConstants;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.photo.preview.PhotoPagerFragment;
import com.ss.android.lark.widget.photopicker.animation.BaseData;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.lark.android.avatar.launcher.AvatarPreviewLauncher;
import com.ss.lark.android.avatar.statistics.AvatarHit;
import com.ss.lark.android.avatar.updateapi.IUpdateAvatarAPI;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public class AvatarPreviewView implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v.a f456723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f456724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PhotoPagerFragment f456725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AvatarCropFragment f456726d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CustomFragmentAdapter f456727e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AvatarSource f456728f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f456729g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f456730h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f456731i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f456732j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public UDDialog f456733k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList<PhotoItem> f456734l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f456735m;

    @BindView(9215)
    ViewPagerWithoutScroll mMainVP;

    @BindView(9216)
    ViewGroup mPhotoPagerFooterFL;

    @BindView(9518)
    CommonTitleBar mTitleBar;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Context f456736n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AvatarPreviewLauncher.PreviewMode f456737o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f456738p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final IUpdateAvatarAPI f456739q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f456740r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f456741s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final a f456742t;

    public class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AvatarPreviewView f456743a;

        public a(AvatarPreviewView r100) {
            this.f456743a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            this.f456743a.f456723a.B3();
        }
    }

    public interface b {
    }

    @Override // com.ss.lark.android.avatar.ui.v
    public final void D5() {
        this.f456741s = false;
    }

    @Override // com.ss.lark.android.avatar.ui.v
    public final void T2() {
        this.f456741s = false;
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // com.ss.lark.android.avatar.ui.v
    public final void O4() {
        LKUIToast.show(this.f456736n, R.drawable.modify_avatar_success, R.string.Lark_Legacy_UcropAvatarSucc);
    }

    @Override // com.ss.lark.android.avatar.ui.v
    public final boolean U5() {
        if (this.f456731i != 1) goto L6;
        E7(true);
        return true;
    L6:
        return false;
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        ButterKnife.bind(this, ((AvatarPreviewFragment.a) this.f456724b).f456710a.f456692d);
        this.f456727e = new CustomFragmentAdapter(((AvatarPreviewFragment.a) this.f456724b).f456710a.getChildFragmentManager());
        if (this.f456725c != null) goto L8;
        this.f456725c = PhotoPagerFragment.U90(this.f456734l, 0, true);
        if (i3() == true) goto L8;
        this.f456725c.f446536o = new l(this);
    L8:
        if (this.f456726d != null) goto L27;
        int r100 = ckc.a.f24078a;
        Intrinsics.checkNotNullParameter("lark.enable.avatar.square.crop", AppConstants.APP_FG);
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.enable.avatar.square.crop", false) == true) goto L12;
    L16:
        boolean r101 = false;
    L18:
        if (this.f456728f == AvatarSource.PROFILE) goto L22;
        if (r101 == true) goto L22;
        boolean r102 = false;
    L23:
        if (r101 == false) goto L25;
        float r103 = 1.0f;
    L26:
        AvatarCropFragment r104 = new AvatarCropFragment(r102, ConfigManager.f().a(), r103);
        this.f456726d = r104;
        o r105 = new o(this);
        Intrinsics.checkNotNullParameter(r105, "cropCallback");
        r104.f456672h = r105;
        goto L27
    L25:
        r103 = -1.0f;
    L22:
        r102 = true;
        goto L23
    L12:
        if (this.f456728f != AvatarSource.SELF_AVATAR) goto L14;
    L15:
        r101 = true;
        goto L18
    L14:
        if (this.f456729g == false) goto L16;
    L27:
        this.f456727e.f(this.f456725c);
        this.f456727e.f(this.f456726d);
        this.mMainVP.setAdapter(this.f456727e);
        this.mMainVP.setOffscreenPageLimit(this.f456727e.getCount() - 1);
        this.mMainVP.setPageMargin(UIHelper.dp2px(5.0f));
        E7(false);
        PhotoPagerFragment r106 = this.f456725c;
        PhotoPagerFragment.b r107 = new m(this);
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "listener");
        r106.f446534m = r107;
        this.mPhotoPagerFooterFL.removeAllViews();
        View r108 = UIHelper.inflate(R.layout.avatar_modify_operation_layout, this.mPhotoPagerFooterFL);
        TextView r109 = (TextView) r108.findViewById(R.id.modify_text_view);
        if (i3() == false) goto L30;
        r109.setText(this.f456735m);
    L31:
        r108.setOnClickListener(new p(this));
        this.mPhotoPagerFooterFL.setVisibility(0);
        if (this.f456728f != AvatarSource.EDIT_ALIAS) goto L35;
        View r110 = LayoutInflater.from(this.f456736n).inflate(R.layout.avatar_modify_operation_layout, this.mPhotoPagerFooterFL, false);
        TextView r111 = (TextView) r110.findViewById(R.id.modify_text_view);
        r111.setText(R.string.Lark_ProfileMemo_DeleteImage);
        r111.setTextColor(UDColorUtils.getColor(this.f456736n, R.color.function_danger_fill_default));
        r111.setOnClickListener(new n(this));
        this.mPhotoPagerFooterFL.addView(r110);
    L35:
        if (i3() == true) goto L37;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) this.mTitleBar.getLayoutParams();
        r112.topMargin = CommonTitleBar.getStatusBarHeight();
        this.mTitleBar.setLayoutParams(r112);
        this.mTitleBar.setBackgroundColor(UDColorUtils.getColor(this.f456736n, R.color.lkui_N1000));
        this.mTitleBar.setMainTitleColor(UDColorUtils.getColor(this.f456736n, R.color.lkui_N00));
        this.mTitleBar.setTitle(R.string.Lark_ProfilePhoto_Previous_Title);
        this.mTitleBar.setLeftImageResource(CommonTitleBarConstants.ICON_BACK, R.color.lkui_N00);
        this.mTitleBar.setLeftClickListener(new j(this));
        this.mTitleBar.setVisibility(0);
    L37:
        Map<Object, s5c.e> r113 = AvatarHit.f456660a;
        Statistics.sendEvent("picbrowser_view");     // Catch: Throwable -> L40
    L42:
        UIUtils.setStatusBarTransparent(this.f456736n);
        this.f456733k = new w(new w.a(UIHelper.getString(R.string.Lark_Legacy_Uploading))).a(this.f456736n);
        this.mPhotoPagerFooterFL.setLayoutTransition(new LayoutTransition());
        return;
    L40:
        th = move-exception;
        Log.e(th.getMessage());
        goto L42
    L30:
        r109.setText(R.string.Lark_ProfilePhoto_UseThis_Button);
        goto L31
    }

    @Override // com.ss.lark.android.avatar.ui.v
    public final String getEntityId() {
        return ((AvatarPreviewFragment.a) this.f456724b).f456710a.f456699k;
    }

    @Override // com.ss.lark.android.avatar.ui.v
    public final boolean i3() {
        if (this.f456737o != AvatarPreviewLauncher.PreviewMode.CURRENT) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.lark.android.avatar.ui.v
    public final void q5() {
        if (UIUtils.isActivityRunning(((AvatarPreviewFragment.a) this.f456724b).f456710a.f456693e) == false) goto L28;
        UDDialog r100 = this.f456733k;
        if (r100 == null) goto L23;
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r100);
        goto L23
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r102 == null) goto L20;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
        goto L20
    L9:
        if (Looper.myLooper() == r101.getLooper()) goto L11;
        r101.post(DialogLancet.createDismissRunnable(r100));
    L23:
        this.f456733k = new w(new w.a(UIHelper.getString(R.string.Lark_Legacy_Uploading))).a(this.f456736n);
        return;
    }

    @Override // com.ss.lark.android.avatar.ui.v
    public final void w1() {
        if (UIUtils.isActivityRunning(((AvatarPreviewFragment.a) this.f456724b).f456710a.f456693e) == false) goto L13;
        UDDialog r100 = this.f456733k;
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L11;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L11:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
    L8:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
        return;
    }

    @Override // com.ss.lark.android.avatar.ui.v
    public final void J5() {
        this.f456741s = i3();
    }

    @Override // com.ss.lark.android.avatar.ui.v
    public final void D8(String r100) {
        LKUIToast.show(this.f456736n, r100);
    }

    @Override // com.ss.lark.android.avatar.ui.v
    public final void E7(boolean r100) {
        this.mMainVP.setCurrentItem(0, r100);
        this.f456731i = 0;
        this.mPhotoPagerFooterFL.setVisibility(0);
    }

    @Override // com.ss.lark.android.avatar.ui.v
    public final void M1(String r100) {
        AvatarCropFragment r101 = this.f456726d;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "path");
        r101.f456675k = r100;
        ((AvatarPreviewFragment.a) this.f456724b).f456710a.getChildFragmentManager().beginTransaction().detach(this.f456726d).commitAllowingStateLoss();
        ((AvatarPreviewFragment.a) this.f456724b).f456710a.getChildFragmentManager().beginTransaction().attach(this.f456726d).commitAllowingStateLoss();
        this.mMainVP.setCurrentItem(1, false);
        this.mPhotoPagerFooterFL.setVisibility(8);
        this.f456731i = 1;
    }

    @Override // com.ss.lark.android.avatar.ui.v
    public final void j5(String r110) {
        if (this.f456739q != null) goto L5;
        return;
    L5:
        Activity r100 = Contexts.requireActivity(this.f456736n);
        AvatarPreviewFragment.a r101 = (AvatarPreviewFragment.a) this.f456724b;
        AvatarPreviewFragment r102 = r101.f456710a;
        CommonTitleBar r103 = this.mTitleBar;
        Bundle r104 = r102.getArguments();
        if (r104 == null) goto L14;
        cdc.d r105 = new cdc.d(AvatarPreviewFragment.T90(r101.f456710a), r104);
        if (r105.f23439c <= 0) goto L14;
        if (r105.f23440d <= 0) goto L14;
        Bundle r106 = r105.a();
    L15:
        IUpdateAvatarAPI r107 = this.f456739q;
        String r108 = this.f456740r;
        boolean r109 = this.f456730h;
        ArrayList r111 = new ArrayList();
        AvatarSource r112 = AvatarSource.SELF_AVATAR;
        r111.add(gkc.c.a(r110, "0", r112));
        AvatarPreviewLauncher.b r113 = new AvatarPreviewLauncher.b();
        r113.f456625b = r103;
        h0.a.f285998a.b("key_photos_preview", r111);
        r113.f456624a.putString("key_photos_preview", "key_photos_preview");
        r113.f456624a.putInt("current_item", 0);
        r113.f456626c = BaseData.AnimationType.TRANSLATE_ANIMATION;
        r113.f456624a.putBoolean("show_save", false);
        r113.f456624a.putString("failed_upload_toast", r108);
        r113.a(r112);
        AvatarPreviewLauncher.PreviewMode r114 = AvatarPreviewLauncher.PreviewMode.LAST;
        r113.f456624a.putString("preview_mode", r114.name());
        r113.f456624a.putString("last_avatar_key", r110);
        r113.f456624a.putBundle("last_avatar_exit_animation_bundle", r106);
        r113.b(r107);
        r113.f456624a.putBoolean("is_doubao_tenant", r109);
        r113.c(r100, r102, 778);
        return;
    L14:
        r106 = null;
        goto L15
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.ss.lark.android.avatar.ui.k, java.lang.Object] */
    @Override // com.ss.lark.android.avatar.ui.v
    public final void p8(final PhotoItem r100) {
        PhotoPagerFragment r101 = this.f456725c;
        if (r101.f446537p == true) goto L6;
        Log.e("AvatarPreviewView", "pager fragment is not created");
        return;
    L6:
        final PhotoItem r102 = r101.T90();
        if (r102 == null) goto L14;
        if (r100 != null) goto L11;
        return;
    L11:
        if (r102.equals(r100) == true) goto L15;
        final PhotoPagerFragment r103 = this.f456725c;
        final ?? r104 = new k(r102, r100);
        Intrinsics.checkNotNullParameter(r103, "<this>");
        Intrinsics.checkNotNullParameter(r104, "action");
        r103.getLifecycle().addObserver(new FragmentKtx$launchWhenStarted$1(r104, r103));
        return;
    L15:
        return;
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f456723a = (v.a) r100;
    }

    @Override // com.ss.lark.android.avatar.ui.v
    public final void z5(String r100) {
        com.larksuite.component.ui.dialog.d r101 = new com.larksuite.component.ui.dialog.d(this.f456736n);
        r101.h(r100);
        r101.a(R.id.lkui_dialog_btn_right, R.string.Lark_Avatar_No_Permission_IKnow, null);
        r101.i();
    }

    public AvatarPreviewView(Context r100, ArrayList r101, String r102, AvatarPreviewFragment.a r103, AvatarSource r104, AvatarPreviewLauncher.PreviewMode r105, String r106, IUpdateAvatarAPI r107, String r110, boolean r111, boolean r112) {
        this.f456731i = 0;
        this.f456732j = -1;
        this.f456742t = new a(this);
        this.f456724b = r103;
        this.f456734l = r101;
        this.f456735m = r102;
        this.f456736n = r100;
        this.f456728f = r104;
        this.f456737o = r105;
        this.f456738p = r106;
        this.f456739q = r107;
        this.f456740r = r110;
        this.f456729g = r111;
        this.f456730h = r112;
    }
}
