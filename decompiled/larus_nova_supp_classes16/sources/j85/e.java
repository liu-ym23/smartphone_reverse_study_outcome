package j85;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceThirdPartyOpenEntity;
import com.bytedance.ee.bear.drive.core.fragment.UserContainerDriveMainFragment;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.bytedance.ee.bear.drive.module.nativepreview.model.FileBlockResModel;
import com.bytedance.ee.bear.drive.view.preview.media.DriveMediaDurationVm;
import com.bytedance.ee.drive.render.j;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.utils.LarkContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements g {
    public boolean a;

    public e() {
        this.a = false;
    }

    public static String d(Object r2) {
        if (r2 != null) goto L5;
        return "null";
    L5:
        return r2.getClass().getSimpleName() + "(" + r2.hashCode() + ")";
    }

    @Override // j85.g
    public final void a(String r11, boolean r12) {
        n85.b r0 = n85.b.a.a;
        FileBlockResModel r1 = r0.a.get(r11);
        if (r1 == null) goto L5;
        boolean r2 = r1.isIsFullScreen();
    L7:
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.docx.landscape_preview_file", false) == false) goto L12;
        if (r2 == false) goto L12;
        if (r12 == false) goto L12;
        tt5.a.h("FileBlockPreviewWrapper", "fragment is screenisFullScreen: " + r2 + "force: " + r12);
        return;
    L12:
        FileBlockResModel.NativeViewHolder r3 = null;
        if (r12 == false) goto L30;
        tt5.a.b("FileBlockResPoll", "updateNeedShow " + r0.a.get(r11));
        FileBlockResModel r5 = r0.a.get(r11);
        if (r5 == null) goto L17;
        r5.setNeedShow(false);
    L17:
        String r4 = r0.e.a(r0.a);
        Object r6 = "";
        if ("".equals(r4) == true) goto L23;
        FileBlockResModel r7 = r0.a.remove(r11);
        StringBuilder r8 = new StringBuilder("requireDelete success ");
        r8.append(du5.b.g(r4));
        r8.append(",");
        if (r7 == null) goto L22;
        r6 = r7.getOpenEntity();
    L22:
        r8.append(r6);
        tt5.a.b("FileBlockResPoll", r8.toString());
    L24:
        if (r7 == null) goto L28;
        FileBlockResModel.NativeViewHolder r9 = r7.getNativeViewHolder();
        if (r9 == null) goto L29;
        r9.release();
        tt5.a.b("FileBlockPreviewWrapper", "onBlockRemove enter2 release finish");
    L29:
        tt5.a.h("FileBlockPreviewWrapper", "onBlockRemove enter2 force = true, key=" + du5.b.g(r11) + ", " + d(r7) + ", " + d(r9));
        goto L30
    L28:
        r9 = null;
        goto L29
    L23:
        tt5.a.b("FileBlockResPoll", "requireDelete no need " + du5.b.g(r11));
        r7 = null;
    L30:
        if (r12 == true) goto L41;
        FileBlockResModel r13 = r0.a.get(r11);
        if (r13 == null) goto L39;
        r3 = r13.getNativeViewHolder();
        if (r3 == null) goto L39;
        DriveComponentRenderVM r10 = r3.getComponentRenderVM();
        if (r10 == null) goto L38;
        r10.notifyReleaseListener();
    L38:
        r3.release();
        tt5.a.h("FileBlockPreviewWrapper", "onBlockRemove enter2 delete directly");
    L39:
        r0.a.remove(r11);
        tt5.a.h("FileBlockPreviewWrapper", "onBlockRemove enter2 force = false, key=" + du5.b.g(r11) + ", " + d(r13) + ", " + d(r3));
        return;
    L41:
        return;
    L5:
        r2 = false;
        goto L7
    }

    @Override // j85.g
    public final FileBlockResModel.NativeViewHolder b(FragmentActivity r13, ViewGroup r14, SpaceThirdPartyOpenEntity r16, String r17, k85.a r18) {
        String r0 = d(r14);
        boolean r8 = true;
        if (r16 == null) goto L20;
        if (r13 == null) goto L20;
        if (r14 == null) goto L20;
        tt5.a.h("FileBlockPreviewWrapper", "onBlockCreate enter1 key=" + du5.b.g(r17) + ", " + r0);
        n85.b r9 = n85.b.a.a;
        FileBlockResModel r10 = r9.a.get(r17);
        if (r10 != null) goto L10;
        tt5.a.h("FileBlockPreviewWrapper", "onBlockCreate start create new view " + r0);
        FileBlockResModel.NativeViewHolder r1 = c(r14, r13, r16, r17, r18);
        FileBlockResModel r2 = new FileBlockResModel(r17, r16, r1);
        r2.setNeedShow(true);
        r9.f(r17, r2);
        return r1;
    L10:
        FileBlockResModel.NativeViewHolder r3 = r10.getNativeViewHolder();
        if (r3 != null) goto L13;
    L17:
        tt5.a.h("FileBlockPreviewWrapper", "onBlockCreate not likely to happen " + r0);
        FileBlockResModel.NativeViewHolder r4 = c(r14, r13, r16, r17, r18);
        r10.setNativeViewHolder(r4);
        r10.setNeedShow(true);
    L18:
        r9.f(r17, r10);
        return r4;
    L13:
        if (r3.getContainerView() == null) goto L17;
        View r5 = r3.getContainerView().get();
        if (r5 == null) goto L17;
        tt5.a.h("FileBlockPreviewWrapper", "onBlockCreate already cached " + d(r5) + ", " + r0 + ", " + r14.getChildCount());
        r10.setNeedShow(true);
        r10.setUpdateTime(System.currentTimeMillis());
        r4 = r3;
    L20:
        StringBuilder r6 = new StringBuilder("onBlockCreate something is empty entity:");
        if (r16 != null) goto L23;
        boolean r7 = true;
    L24:
        r6.append(r7);
        r6.append(", activity:");
        if (r13 == null) goto L28;
        r8 = false;
    L28:
        r6.append(r8);
        r6.append(", rootContainer:");
        r6.append(r0);
        tt5.a.d("FileBlockPreviewWrapper", r6.toString());
        return null;
    L23:
        r7 = false;
        goto L24
    }

    public final FileBlockResModel.NativeViewHolder c(ViewGroup r10, FragmentActivity r11, SpaceThirdPartyOpenEntity r12, String r13, k85.a r14) {
        FileBlockResModel.NativeViewHolder r7 = new FileBlockResModel.NativeViewHolder();
        boolean r0 = r12.isInVc();
        n85.b r1 = n85.b.a.a;
        WeakReference<f> r2 = r1.i;
        if (r2 == null) goto L7;
        f r3 = r2.get();
        if (r3 == null) goto L8;
    L9:
        if (r0 == false) goto L12;
        if (r3 == null) goto L12;
        UserContainerDriveMainFragment r4 = r3.a(r12);
    L16:
        Bundle r5 = r4.getArguments();
        if (r5 != null) goto L19;
        r5 = new Bundle();
    L19:
        PassportcConvention.f(r5, LarkContext.getApplication());
        r5.putParcelableArrayList("extra_drive_sdk_open_entity", new ArrayList(Collections.singletonList(r12)));
        boolean r8 = false;
        r5.putInt("extra_drive_sdk_open_index", 0);
        r5.putBoolean("vc_follow_mode", r0);
        if (r3 == null) goto L22;
        r5.putBinder("drive_touch_state_callback", r3.b());
    L22:
        r4.setArguments(r5);
        if (r11.toString().equals(r1.d) == true) goto L25;
        Long r6 = r1.b.get(r13);
        DriveMediaDurationVm r9 = (DriveMediaDurationVm) new ViewModelProvider(r11).get(DriveMediaDurationVm.class);
        r9.getExtraData().observe(r11, new d(r13));
        r1.b.put(r13, r6);
        r1.f = r9;
        r1.d = r11.toString();
    L25:
        Long r16 = r1.b.get(r13);
        DriveMediaDurationVm r17 = r1.f;
        if (r16 == null) goto L28;
        r17.setExtraData(r13, Long.valueOf(r16.longValue()));
    L28:
        r7.setFragment(r4);
        r7.setComponentHashCode(String.valueOf(r14.hashCode()));
        int r18 = View.generateViewId();
        if (r10.getId() != (-1)) goto L31;
        r10.setId(r18);
    L31:
        r10.setTag("block_place_holder");
        this.a = false;
        r7.setContainerView(new WeakReference(r10));
        if (r10.isAttachedToWindow() == false) goto L44;
        FragmentManager r19 = r1.d(r4, r11, r10);
        if (r19 == null) goto L36;
        r8 = true;
    L36:
        tt5.a.h("FileBlockPreviewWrapper", "isAttachedToWindow true， createView add directly, fragmentManager available: " + r8);
        r7.setFragmentManager(r19);
        if (r8 == false) goto L43;
        FragmentTransaction r110 = r19.beginTransaction();
        int r111 = r10.getId();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r110, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, r111) == true) goto L42;
        r110 = r110.add(r111, r4);
    L42:
        r110.commitAllowingStateLoss();
        DriveComponentRenderVM r112 = (DriveComponentRenderVM) new ViewModelProvider(r4, new ViewModelProvider.NewInstanceFactory()).get(DriveComponentRenderVM.class);
        r7.setComponentRenderVM(r112);
        r112.getLiveNativeComponentDelegate().postValue(r14);
    L45:
        return r7;
    L43:
        tt5.a.k("FileBlockPreviewWrapper", "isAttachedToWindow getFragmentManager null");
        goto L45
    L44:
        ViewTreeObserver r113 = r10.getViewTreeObserver();
        tt5.a.b("FileBlockPreviewWrapper", "isAttachedToWindow false， createView enter " + r12);
        r113.addOnPreDrawListener(new c(this, r10, r4, r11, r7, r14));
    L12:
        j r20 = ((com.bytedance.ee.drive.preview.f) org.koin.java.a.a(com.bytedance.ee.drive.preview.f.class)).U4(LarkContext.getApplication());
        UserContainerDriveMainFragment r21 = new UserContainerDriveMainFragment();
        Bundle r22 = r21.getArguments();
        if (r22 != null) goto L15;
        r22 = new Bundle();
    L15:
        r22.putString("drive_open_strategy_key", x75.a.b(r20));
        r21.setArguments(r22);
        r4 = r21;
    L8:
        tt5.a.d("FileBlockResPoll", "getFileBlockFollowWrapper is null!");
        goto L9
    L7:
        r3 = null;
        goto L8
    }
}
