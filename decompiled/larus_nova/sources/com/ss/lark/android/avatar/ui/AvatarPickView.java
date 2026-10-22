package com.ss.lark.android.avatar.ui;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import butterknife.BindView;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.ui.ViewPagerWithoutScroll;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.image.uploader.config.ConfigManager;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public class AvatarPickView implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v.a f456678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f456679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AvatarCropFragment f456680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CustomFragmentAdapter f456681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f456682e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public UDDialog f456683f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f456684g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f456685h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f456686i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AvatarSource f456687j;

    @BindView(9215)
    ViewPagerWithoutScroll mMainVP;

    @BindView(9216)
    ViewGroup mPhotoPagerFooterFL;

    public interface a {
        boolean a();

        void b(v r100);

        void c();

        void d();

        String getEntityId();

        void setResult(int r100, Intent r101);

        FragmentManager y1();
    }

    @Override // com.ss.lark.android.avatar.ui.v
    public final void D5() {
    }

    @Override // com.ss.lark.android.avatar.ui.v
    public final void E7(boolean r100) {
    }

    @Override // com.ss.lark.android.avatar.ui.v
    public final void J5() {
    }

    @Override // com.ss.lark.android.avatar.ui.v
    public final void T2() {
    }

    @Override // com.ss.lark.android.avatar.ui.v
    public final boolean U5() {
        return false;
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // com.ss.lark.android.avatar.ui.v
    public final boolean i3() {
        return false;
    }

    @Override // com.ss.lark.android.avatar.ui.v
    public final void j5(String r100) {
    }

    @Override // com.ss.lark.android.avatar.ui.v
    public final void p8(PhotoItem r100) {
    }

    @Override // com.ss.lark.android.avatar.ui.v
    public final void O4() {
        LKUIToast.show(this.f456684g, R.drawable.modify_avatar_success, R.string.Lark_Legacy_UcropAvatarSucc);
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        this.f456679b.b(this);
        this.f456681d = new CustomFragmentAdapter(this.f456679b.y1());
        if (this.f456680c != null) goto L13;
        float r100 = ConfigManager.f().a();
        int r101 = ckc.a.f24078a;
        Intrinsics.checkNotNullParameter("lark.enable.avatar.square.crop", AppConstants.APP_FG);
        boolean r102 = false;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.enable.avatar.square.crop", false) == true) goto L7;
    L9:
        if (r102 == false) goto L11;
        float r103 = 1.0f;
    L12:
        AvatarCropFragment r104 = new AvatarCropFragment(r102, r100, r103);
        this.f456680c = r104;
        e r105 = new e(this);
        Intrinsics.checkNotNullParameter(r105, "cropCallback");
        r104.f456672h = r105;
        goto L13
    L11:
        r103 = -1.0f;
        goto L12
    L7:
        if (this.f456686i == false) goto L9;
        r102 = true;
    L13:
        this.f456681d.f(this.f456680c);
        this.mMainVP.setAdapter(this.f456681d);
        this.mMainVP.setOffscreenPageLimit(this.f456681d.getCount() - 1);
        this.mMainVP.setPageMargin(UIHelper.dp2px(5.0f));
        int r106 = this.f456685h;
        if (r106 != 2) goto L16;
        this.f456682e = 2;
        this.f456679b.d();
    L18:
        this.mPhotoPagerFooterFL.setVisibility(8);
        UIUtils.setStatusBarTransparent(this.f456684g);
        this.f456683f = new w(new w.a(UIHelper.getString(R.string.Lark_Legacy_Uploading))).a(this.f456684g);
        return;
    L16:
        if (r106 != 1) goto L18;
        this.f456682e = 1;
        this.f456679b.c();
        goto L18
    }

    @Override // com.ss.lark.android.avatar.ui.v
    public final String getEntityId() {
        return this.f456679b.getEntityId();
    }

    @Override // com.ss.lark.android.avatar.ui.v
    public final void q5() {
        if (this.f456679b.a() == false) goto L6;
        this.f456683f.hide();
        return;
    }

    @Override // com.ss.lark.android.avatar.ui.v
    public final void w1() {
        if (this.f456679b.a() == false) goto L13;
        UDDialog r100 = this.f456683f;
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
    public final void D8(String r100) {
        LKUIToast.show(this.f456684g, r100);
    }

    @Override // com.ss.lark.android.avatar.ui.v
    public final void M1(String r100) {
        AvatarCropFragment r101 = this.f456680c;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "path");
        r101.f456675k = r100;
        AvatarCropFragment r102 = this.f456680c;
        r102.S90(r102.f456675k);
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f456678a = (v.a) r100;
    }

    @Override // com.ss.lark.android.avatar.ui.v
    public final void z5(String r100) {
        com.larksuite.component.ui.dialog.d r101 = new com.larksuite.component.ui.dialog.d(this.f456684g);
        r101.h(r100);
        r101.a(R.id.lkui_dialog_btn_right, R.string.Lark_Avatar_No_Permission_IKnow, null);
        r101.i();
    }

    public AvatarPickView(Context r100, int r101, AvatarSource r102, boolean r103, g r104) {
        this.f456682e = -1;
        this.f456679b = r104;
        this.f456685h = r101;
        this.f456684g = r100;
        this.f456687j = r102;
        AvatarSource r105 = AvatarSource.MOMENTS;
        this.f456686i = r103;
    }
}
