package com.ss.lark.android.avatar.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.h0;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.StatusBarUtil;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.lark.android.avatar.launcher.AvatarPreviewLauncher;
import com.ss.lark.android.avatar.plugin.AvatarPluginManager;
import com.ss.lark.android.avatar.statistics.AvatarHit;
import com.ss.lark.android.avatar.updateapi.IUpdateAvatarAPI;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public class AvatarPreviewFragment extends BaseFragment {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f456691v = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f456692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FragmentActivity f456693e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bundle f456694f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AvatarPreviewPresenter f456695g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.ss.android.lark.widget.photopicker.animation.b f456696h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AvatarSource f456697i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f456698j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f456699k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f456700l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f456701m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f456702n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public AvatarPluginManager f456703o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AvatarPreviewLauncher.PreviewMode f456704p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f456705q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Bundle f456706r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f456707s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f456708t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final a f456709u;

    public class a implements AvatarPreviewView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AvatarPreviewFragment f456710a;

        public a(AvatarPreviewFragment r100) {
            this.f456710a = r100;
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f456711a = null;

        static {
            int[] r100 = new int[AvatarSource.values().length];
            f456711a = r100;
            r100[AvatarSource.PROFILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f456711a[AvatarSource.EDIT_ALIAS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        AvatarPreviewPresenter r100 = this.f456695g;
        if (r100 == null) goto L5;
        r100.destroy();
    L5:
        super.onDestroy();
    }

    public AvatarPreviewFragment() {
        this.f456700l = false;
        this.f456701m = false;
        this.f456702n = false;
        this.f456704p = AvatarPreviewLauncher.PreviewMode.CURRENT;
        this.f456707s = false;
        this.f456708t = false;
        this.f456709u = new a(this);
    }

    public static /* synthetic */ Context S90(AvatarPreviewFragment r100) {
        return r100.mContext;
    }

    public static /* synthetic */ Context T90(AvatarPreviewFragment r100) {
        return r100.mContext;
    }

    public static /* synthetic */ Context U90(AvatarPreviewFragment r100) {
        return r100.mContext;
    }

    public static /* synthetic */ Context V90(AvatarPreviewFragment r100) {
        return r100.mContext;
    }

    public static /* synthetic */ Context W90(AvatarPreviewFragment r100) {
        return r100.mContext;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        boolean r102 = false;
        if (r101 != null) goto L5;
        finish();
    L13:
        if (r102 == true) goto L15;
        return;
    L15:
        f r103 = new f(this);
        Context r104 = this.mContext;
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "dependency");
        WeakReference r105 = new WeakReference(r104);
        AvatarSource r106 = AvatarSource.MOMENTS;
        AvatarPreviewLauncher.PreviewMode r107 = AvatarPreviewLauncher.PreviewMode.CURRENT;
        AvatarSource r108 = this.f456697i;
        Intrinsics.checkNotNullParameter(r108, "source");
        AvatarPreviewLauncher.PreviewMode r109 = this.f456704p;
        Intrinsics.checkNotNullParameter(r109, "previewMode");
        this.f456703o = new AvatarPluginManager(new WeakReference(r105.get()), r108, r109, this.f456700l, r103);
        getLifecycle().addObserver(this.f456703o);
        return;
    L5:
        AvatarSource r110 = (AvatarSource) r101.getSerializable("avatar_source");
        this.f456697i = r110;
        if (r110 != null) goto L8;
        this.f456697i = AvatarSource.NONE;
    L8:
        AvatarSource r111 = AvatarSource.MOMENTS;
        this.f456698j = r101.getString("failed_upload_toast", UIHelper.getString(R.string.Lark_Legacy_UcropUploadingAvatarFail));
        this.f456700l = r101.getBoolean("is_default_avatar", false);
        this.f456701m = r101.getBoolean("is_square_crop", false);
        this.f456702n = r101.getBoolean("is_doubao_tenant", false);
        String r112 = r101.getString("preview_mode", AvatarPreviewLauncher.PreviewMode.CURRENT.name());
        this.f456704p = AvatarPreviewLauncher.PreviewMode.valueOf(r112);     // Catch: IllegalArgumentException -> L11
    L12:
        this.f456705q = r101.getString("last_avatar_key");
        this.f456706r = r101.getBundle("last_avatar_exit_animation_bundle");
        r102 = true;
    L11:
        Log.w("AvatarPreviewFragment", "Unsupported preview mode: " + r112);
        this.f456704p = AvatarPreviewLauncher.PreviewMode.CURRENT;
        goto L12
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        super.onViewCreated(r110, r111);
        Bundle r112 = getArguments();
        if (r112 != null) goto L5;
        finish();
        return;
    L5:
        Object r113 = h0.a.f285998a.a(r112.getString("key_photos_preview"));
        ArrayList r100 = new ArrayList();
        if ((r113 instanceof List) == false) goto L9;
        r100.addAll((List) r113);
    L9:
        if (this.f456704p == AvatarPreviewLauncher.PreviewMode.LAST) goto L11;
    L13:
        ArrayList r101 = r100;
        int r114 = b.f456711a[this.f456697i.ordinal()];
        boolean r102 = true;
        if (r114 != 1) goto L16;
        int r115 = 6;
    L20:
        Log.i("AvatarPreviewFragment", "resourceImage , photoItemType = " + r115);
        Iterator r103 = r101.iterator();
    L22:
        if (r103.hasNext() == false) goto L26;
        PhotoItem r104 = (PhotoItem) r103.next();
        if (r104 == null) goto L22;
        r104.setType(r115);
        this.f456699k = r104.getEntityId();
        goto L22
    L26:
        String r105 = r112.getString("extra_toolbar_text", "");
        IUpdateAvatarAPI r116 = (IUpdateAvatarAPI) r112.getSerializable("extra_updateapi");
        int r106 = r112.getInt("direct_pick_photo", 0);
        if (r106 == 0) goto L31;
        if (r116 == null) goto L31;
        AvatarPickView r117 = new AvatarPickView(this.mContext, r106, this.f456697i, this.f456701m, new g(this));
        AvatarPreviewPresenter r107 = new AvatarPreviewPresenter(getActivity(), new h(r116), r117);
        this.f456695g = r107;
        r107.f456713b = this.f456698j;
        r107.f456714c = this.f456697i;
        r107.create();
    L32:
        if (r102 == false) goto L35;
        return;
    L35:
        if (CollectionUtils.isEmpty(r101) == true) goto L43;
        if (r116 == null) goto L43;
        AvatarPreviewView r118 = new AvatarPreviewView(this.mContext, r101, r105, this.f456709u, this.f456697i, this.f456704p, this.f456705q, r116, this.f456698j, this.f456701m, this.f456702n);
        AvatarPreviewPresenter r119 = new AvatarPreviewPresenter(getActivity(), new h(r116), r118);
        this.f456695g = r119;
        r119.f456713b = this.f456698j;
        r119.f456714c = this.f456697i;
        r119.create();
        if (this.f456704p != AvatarPreviewLauncher.PreviewMode.CURRENT) goto L45;
        AvatarSource r120 = this.f456697i;
        Map<Object, s5c.e> r121 = AvatarHit.f456660a;
        Intrinsics.checkNotNullParameter(r120, "source");
        if (r120 != AvatarSource.SELF_AVATAR) goto L45;
        Statistics.sendEvent("profile_photo_setting_view");
    L45:
        if (this.f456704p != AvatarPreviewLauncher.PreviewMode.CURRENT) goto L56;
        AvatarSource r122 = this.f456697i;
        Map<Object, s5c.e> r123 = AvatarHit.f456660a;
        Intrinsics.checkNotNullParameter(r122, "source");
        if (r122 != AvatarSource.SELF_AVATAR) goto L57;
        Statistics.sendEvent("im_avatar_main_view");
        return;
    L57:
        return;
    L56:
        return;
    L43:
        finish();
    L31:
        r102 = false;
        goto L32
    L16:
        if (r114 == 2) goto L18;
        r115 = 4;
        goto L20
    L18:
        r115 = 3;
        goto L20
    L11:
        if (TextUtils.isEmpty(this.f456705q) == true) goto L13;
        r100 = new ArrayList();
        r100.add(gkc.c.a(this.f456705q, "0", this.f456697i));
        goto L13
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        if (r100 != 778) goto L15;
        if (r101 != 0) goto L15;
        if (r102 == null) goto L15;
        if (r102.getBooleanExtra("extra_exit_preview_flow", false) == false) goto L15;
        if (this.f456708t == true) goto L49;
        this.f456708t = true;
        finish();
        FragmentActivity r103 = this.f456693e;
        if (r103 == null) goto L48;
        r103.overridePendingTransition(0, 0);
        StatusBarUtil.showStatusBar(this.f456693e);
        return;
    L48:
        return;
    L49:
        return;
    L15:
        if (r100 != 778) goto L29;
        if (r101 != 777) goto L29;
        if (r102 == null) goto L29;
        if (this.f456695g == null) goto L29;
        String r104 = r102.getStringExtra("avatar_path");
        AvatarPreviewPresenter r105 = this.f456695g;
        v r106 = r105.getView();
        if (r106 != null) goto L24;
        return;
    L24:
        if (TextUtils.isEmpty(r104) == true) goto L51;
        PhotoItem r107 = gkc.c.a(r104, r106.getEntityId(), r105.f456714c);
        r106.T2();
        r105.I8(r107);
        r106.E7(false);
        return;
    L51:
        return;
    L29:
        if (r101 == (-1)) goto L31;
        if (r101 != 0) goto L57;
        if (r100 != 234) goto L58;
        finish();
        return;
    L58:
        return;
    L57:
        return;
    L31:
        if (r100 == 233) goto L33;
        if (r100 == 234) goto L33;
        return;
    L33:
        if (r102 != null) goto L35;
        finish();
        return;
    L35:
        ArrayList<String> r108 = r102.getStringArrayListExtra("SELECTED_PHOTOS");
        if (CollectionUtils.isEmpty(r108) == false) goto L38;
        Log.i(this.PARENT_TAG, "onActivityResult photos is empty");
        finish();
        return;
    L38:
        String r109 = (String) ListProtector.get(r108, 0);
        if (TextUtils.isEmpty(r109) == true) goto L55;
        v r110 = this.f456695g.getView();
        if (r110 == null) goto L59;
        r110.M1(r109);
        return;
    L59:
        return;
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        this.f456694f = r102;
        if (r102 == null) goto L5;
        r102.remove("android:support:fragments");
    L5:
        StatusBarUtil.hideStatusBar(getActivity());
        this.f456692d = r100.inflate(R.layout.avatar_layout_picker_fragment_photo_pager, r101, false);
        this.f456693e = getActivity();
        return this.f456692d;
    }
}
