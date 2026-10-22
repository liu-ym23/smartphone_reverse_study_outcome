package com.bytedance.ee.bear.drive.core.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.biz.preview.screen.DriveFullScreenVM;
import com.bytedance.ee.bear.drive.core.adapter.DrivePreviewFragmentAdapter;
import com.bytedance.ee.bear.drive.core.ai.DriveAiInteractionVM;
import com.bytedance.ee.bear.drive.core.thumbnail.GalleryThumbnailView;
import com.bytedance.ee.bear.drive.core.thumbnail.ThumbnailTrackerLayoutManager;
import com.bytedance.ee.bear.drive.view.preview.block.DriveMainRootLayout;
import com.bytedance.ee.bear.drive.view.preview.imageviewer.DrivePreviewViewPager;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001>B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\"\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020 H\u0016J\u001a\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u001eH\u0002J\n\u0010(\u001a\u0004\u0018\u00010)H\u0002J\b\u0010*\u001a\u00020 H\u0002J\u0010\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020-H\u0014J\n\u0010.\u001a\u0004\u0018\u00010-H\u0002J\b\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u000200H\u0002J\u0010\u00102\u001a\u00020 2\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020 2\u0006\u00106\u001a\u00020\u001eH\u0016J\"\u00107\u001a\u00020 2\u0006\u00108\u001a\u0002042\u0006\u00109\u001a\u0002042\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u0004\u0018\u00010=R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/bytedance/ee/bear/drive/core/fragment/DriveMainFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/facade/common/ActivityResultHandler;", "<init>", "()V", "mViewPager", "Lcom/bytedance/ee/bear/drive/view/preview/imageviewer/DrivePreviewViewPager;", "mMainRootLayout", "Lcom/bytedance/ee/bear/drive/view/preview/block/DriveMainRootLayout;", "mTitleBar", "Lcom/bytedance/ee/bear/browser/plugin/TitleBar;", "mOnlineOpenEntities", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/contract/drive/sdk/entity/open/BaseOpenEntity;", "Lkotlin/collections/ArrayList;", "mAiSequence", "", "mThumbnailOverlayController", "Lcom/bytedance/ee/bear/drive/core/fragment/DrivePreviewThumbnailOverlayController;", "mMediaImmersiveController", "Lcom/bytedance/ee/bear/drive/core/fragment/DriveMediaImmersiveController;", "mOverlayContainerCoordinator", "Lcom/bytedance/ee/bear/drive/core/fragment/DrivePreviewOverlayContainerCoordinator;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "onDestroy", "initView", "rootView", "registerDriveMainHostAbilities", "arguments", "getCurrentAiPageSnapshot", "Lcom/bytedance/ee/bear/drive/core/ai/DrivePreviewAiPageSnapshot;", "unregisterDriveMainHostAbilities", "installProductHostAbilities", "openStrategy", "Lcom/bytedance/ee/drive/render/IDriveOpenStrategy;", "getOpenStrategy", "isMediaImmersivePreviewEnabled", "", "isDrivePreviewThumbnailEnabled", "notifyAttachmentEntity", "position", "", "onSaveInstanceState", "outState", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "getCurrentPreviewFragment", "Lcom/bytedance/ee/bear/drive/core/fragment/DrivePreviewFragment;", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DriveMainFragment extends BaseFragment implements sa5.a {
    public static final /* synthetic */ int l = 0;
    public DrivePreviewViewPager e;
    public DriveMainRootLayout f;
    public ArrayList<BaseOpenEntity> g;
    public long h;
    public r i;
    public d j;
    public k k;

    public static final class a {
        @JvmStatic
        public static UserContainerDriveMainFragment a(com.bytedance.ee.drive.render.j r4, ArrayList r5, int r6, l65.g r7, Bundle r8) {
            Intrinsics.checkNotNullParameter(r4, "openStrategy");
            Intrinsics.checkNotNullParameter(r5, "openEntities");
            UserContainerDriveMainFragment r0 = new UserContainerDriveMainFragment();
            Bundle r1 = new Bundle();
            PassportcConvention.f(r1, LarkContext.getApplication());
            if (r8 == null) goto L5;
            r1.putAll(r8);
        L5:
            if (r7 == null) goto L17;
            boolean r2 = true;
            r1.putBoolean("vc_follow_mode", true);
            r1.putString("vc_follow_meeting_id", r7.b);
            r1.putString("vc_follow_uuid", r7.e);
            r1.putBinder("drive_uistate_callback", r7.c);
            r1.putBoolean("vc_follow_refresh", r7.a);
            if (r5.size() <= r6) goto L10;
            if (r6 < 0) goto L10;
            boolean r9 = ((BaseOpenEntity) ListProtector.get(r5, r6)).isInVc();
        L12:
            if (r7.d == true) goto L16;
            if (r9 == true) goto L16;
            r2 = false;
        L16:
            r1.putBoolean("vc_follow_attachment", r2);
        L10:
            r9 = false;
        L17:
            r1.putParcelableArrayList("extra_drive_sdk_open_entity", r5);
            r1.putInt("extra_drive_sdk_open_index", r6);
            r1.putString("drive_open_strategy_key", x75.a.b(r4));
            r0.setArguments(r1);
            return r0;
        }
    }

    static {
    }

    public void W90(com.bytedance.ee.drive.render.j r2) {
        Intrinsics.checkNotNullParameter(r2, "openStrategy");
    }

    public final DrivePreviewFragment U90() {
        DrivePreviewViewPager r0 = this.e;
        Object r1 = null;
        if (r0 == null) goto L15;
        if (r0 == null) goto L6;
        PagerAdapter r2 = r0.getAdapter();
    L7:
        if (r2 == null) goto L16;
        DrivePreviewViewPager r3 = this.e;
        if (r3 == null) goto L13;
        PagerAdapter r4 = r3.getAdapter();
        if (r4 == null) goto L13;
        ViewPager r5 = this.e;
        Intrinsics.checkNotNull(r5);
        DrivePreviewViewPager r6 = this.e;
        Intrinsics.checkNotNull(r6);
        r1 = r4.instantiateItem(r5, r6.getCurrentItem());
    L13:
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.ee.bear.drive.core.fragment.DrivePreviewFragment");
        return (DrivePreviewFragment) r1;
    L16:
        return null;
    L6:
        r2 = null;
        goto L7
    L15:
        return null;
    }

    public final void onDestroyView() {
        r r0 = this.i;
        if (r0 != null) goto L5;
    L23:
        this.i = null;
        d r1 = this.j;
        if (r1 != null) goto L26;
    L35:
        this.j = null;
        k r2 = this.k;
        if (r2 != null) goto L38;
    L51:
        this.k = null;
        com.bytedance.ee.drive.render.j r3 = V90();
        if (r3 == null) goto L56;
        com.bytedance.ee.drive.render.m r4 = r3.d();
        if (r4 == null) goto L56;
        r4.a(t75.i.class);
    L56:
        super.onDestroyView();
        return;
    L38:
        if (r2.n == true) goto L51;
        r2.n = true;
        r2.l.clear();
        r2.l.addAll(r2.j);
        r2.o = r2.l.isEmpty();
        r2.d(true);
        r2.r.clear();
        r2.s.clear();
        Iterator<T> r5 = r2.t.iterator();
    L42:
        if (r5.hasNext() == false) goto L44;
        Object r6 = r5.next();
        Function2<Object, Boolean, Unit> r7 = r2.h;
        Intrinsics.checkNotNull(r6);
        r7.invoke(r6, Boolean.FALSE);
        goto L42
    L44:
        r2.t.clear();
        r2.i = null;
        r2.p = null;
        r2.e();
        n r8 = r2.z;
        if (r8 == null) goto L51;
        if (r2.A == false) goto L50;
        r2.a.getContext().getApplicationContext().unregisterComponentCallbacks(r8);
        r2.A = false;
    L50:
        r2.z = null;
        goto L51
    L26:
        if (r1.t == true) goto L35;
        r1.h();
        r1.t = true;
        f r9 = r1.q;
        if (r9 == null) goto L35;
        ViewGroup r10 = (ViewGroup) r1.b.findViewById(2131370319);
        if (r10 == null) goto L34;
        r10.removeOnLayoutChangeListener(r9);
    L34:
        r1.q = null;
        goto L35
    L5:
        if (r0.k == true) goto L23;
        r0.k = true;
        r0.j.clear();
        com.bytedance.ee.bear.drive.core.thumbnail.b r11 = r0.g;
        if (r11 == null) goto L19;
        Runnable r12 = r11.i;
        if (r12 == null) goto L12;
        r11.a.removeCallbacks(r12);
    L12:
        r11.i = null;
        r11.b.removeOnPageChangeListener(r11.h);
        ThumbnailTrackerLayoutManager r13 = r11.d;
        r13.getClass();
        tt5.a.h("ThumbnailTrackerLayoutManager", "[reset]: ");
        r13.e = false;
        r13.s().a.clear();
        r13.s().b.clear();
        ((ArrayList) r13.s().c).clear();
        int r14 = r13.c;
        if (r14 == (-1)) goto L15;
        r13.b = r14;
    L15:
        int r16 = Math.min(Math.max(0, r13.b), r13.getItemCount() - 1);
        r13.b = r16;
        r13.a = r16;
        r13.c = -1;
        RecyclerView r17 = r13.g;
        if (r17 == null) goto L18;
        r17.removeOnScrollListener(r13.i);
    L18:
        r13.h.attachToRecyclerView(null);
        r13.g = null;
        r13.l = null;
        r13.m = null;
        r11.a.setAdapter(null);
        r11.a.removeItemDecoration(r11.f);
        r11.e.c.e();
    L19:
        r0.g = null;
        r0.h = false;
        r0.b(false);
        FrameLayout r18 = (FrameLayout) r0.a.findViewById(2131370333);
        if (r18 == null) goto L22;
        r18.removeAllViews();
    L22:
        r0.f = null;
        r0.a();
        tt5.a.h("DriveThumbnailOverlay", "thumbnailOverlay release");
        goto L23
    }

    public final com.bytedance.ee.drive.render.j V90() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        ConcurrentHashMap<String, com.bytedance.ee.drive.render.j> r1 = x75.a.a;
        String r2 = r0.getString("drive_open_strategy_key");
    L7:
        return x75.a.a(r2);
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onDestroy() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        ConcurrentHashMap<String, com.bytedance.ee.drive.render.j> r1 = x75.a.a;
        String r2 = r0.getString("drive_open_strategy_key");
    L6:
        FragmentActivity r3 = getActivity();
        if (r2 == null) goto L22;
        if (r3 == null) goto L22;
        if (r3.isFinishing() == false) goto L12;
    L15:
        ConcurrentHashMap<String, com.bytedance.ee.drive.render.j> r4 = x75.a.a;
        if (r2.length() != 0) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == true) goto L22;
        x75.a.a.remove(r2);
        goto L22
    L18:
        r5 = false;
        goto L19
    L12:
        if (isRemoving() == false) goto L22;
        if (r3.isChangingConfigurations() == false) goto L15;
    L22:
        super.onDestroy();
        return;
    L5:
        r2 = null;
        goto L6
    }

    public DriveMainFragment() {
    }

    public final void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        super.onSaveInstanceState(r3);
        DrivePreviewViewPager r0 = this.e;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        r3.putInt("view_pager_last_item_index", r0.getCurrentItem());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v38, types: [android.view.ViewGroup, com.bytedance.ee.bear.drive.core.thumbnail.GalleryThumbnailView] */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r7v17, types: [android.view.View, android.view.ViewGroup, com.bytedance.ee.bear.drive.core.thumbnail.GalleryThumbnailView] */
    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r24, Bundle r26) {
        Intrinsics.checkNotNullParameter(r24, "view");
        super.onViewCreated(r24, r26);
        this.e = (DrivePreviewViewPager) r24.findViewById(2131370322);
        this.f = (DriveMainRootLayout) r24.findViewById(2131379453);
        Bundle r12 = getArguments();
        if (r12 != null) goto L5;
        tt5.a.d("DriveSdk", "initView() getArguments is null...");
        return;
    L5:
        final ArrayList<BaseOpenEntity> r14 = r12.getParcelableArrayList("extra_drive_sdk_open_entity");
        if (r14 != null) goto L8;
        tt5.a.d("DriveSdk", "initView() getArguments onlineOpenEntities is null");
        return;
    L8:
        int r2 = r12.getInt("extra_drive_sdk_open_index", 0);
        if (r26 == null) goto L12;
        r2 = r26.getInt("view_pager_last_item_index", r2);
        tt5.a.h("DriveSdk", "initView() savedInstanceState index = " + r2);
    L12:
        if (r2 >= 0) goto L15;
        int r9 = 0;
    L18:
        DriveMainRootLayout r1 = this.f;
        if (r1 == null) goto L21;
        r1.setTouchEventCallback(r12);
    L21:
        this.g = r14;
        DrivePreviewViewPager r8 = this.e;
        if (r8 != null) goto L24;
        tt5.a.d("DriveSdk", "initView() viewPager is null");
        return;
    L24:
        FragmentActivity r3 = getActivity();
        if (r3 != null) goto L27;
        tt5.a.d("DriveSdk", "initView() activity is null");
        return;
    L27:
        DriveFullScreenVM r16 = (DriveFullScreenVM) new ViewModelProvider(r3).get(DriveFullScreenVM.class);
        DriveAiInteractionVM r17 = (DriveAiInteractionVM) new ViewModelProvider(this).get(DriveAiInteractionVM.class);
        DriveMediaImmersiveVM r6 = (DriveMediaImmersiveVM) new ViewModelProvider(r3).get(DriveMediaImmersiveVM.class);
        r6.resolveFromEntry(r14);
        com.bytedance.ee.drive.render.j r4 = V90();
        if (r4 == null) goto L36;
        com.bytedance.ee.drive.render.k r5 = r4.b();
        if (r5 == null) goto L36;
        com.bytedance.ee.drive.render.k.c r7 = r5.d();
        if (r7 == null) goto L36;
        if (r7.a != true) goto L36;
        boolean r18 = true;
    L37:
        com.bytedance.ee.drive.render.j r10 = V90();
        if (r10 == null) goto L46;
        com.bytedance.ee.drive.render.k r11 = r10.b();
        if (r11 == null) goto L46;
        com.bytedance.ee.drive.render.k.c r13 = r11.d();
        if (r13 == null) goto L46;
        if (r13.b != true) goto L46;
        boolean r19 = true;
    L47:
        int r22 = r9;
        this.j = new d(r3, r24, getViewLifecycleOwner(), r8, r6, r18, new DriveMainFragment$initView$1(r14), new DriveMainFragment$initView$2(r14), new DriveMainFragment$initView$3(this));
        if (r19 == false) goto L50;
        r r20 = new r(r24, getViewLifecycleOwner(), r16, r8, r14, new DriveMainFragment$initView$4(this));
    L51:
        this.i = r20;
        this.k = new k(r24, getViewLifecycleOwner(), r16, r17, new DriveMainFragment$initView$5(this), new DriveMainFragment$initView$6(this), new DriveMainFragment$initView$7(this), new DriveMainFragment$initView$8(this), new DriveMainFragment$initView$9(this));
        d r21 = this.j;
        if (r21 != null) goto L54;
    L66:
        d r23 = this.j;
        if (r23 == null) goto L69;
        r23.j = r22;
        r23.l();
    L69:
        k r27 = this.k;
        if (r27 != null) goto L72;
    L75:
        k r28 = this.k;
        if (r28 != null) goto L78;
        tt5.a.k("DriveSdk", "registerDriveMainHostAbilities skipped: coordinator null");
    L84:
        com.bytedance.ee.drive.render.j r29 = V90();
        if (r29 == null) goto L87;
        W90(r29);
    L88:
        DrivePreviewFragmentAdapter r30 = new DrivePreviewFragmentAdapter(r12, getChildFragmentManager(), r14);
        DrivePreviewViewPager r31 = this.e;
        if (r31 == null) goto L91;
        r31.setAdapter(r30);
    L91:
        DrivePreviewViewPager r32 = this.e;
        if (r32 == null) goto L94;
        r32.setCurrentItem(r22, false);
    L94:
        r r33 = this.i;
        if (r33 == null) goto L156;
        if (r33.k == false) goto L99;
        tt5.a.k("DriveThumbnailOverlay", "thumbnailOverlay attach skipped: released");
        goto L156
    L99:
        int r34 = com.bytedance.ee.bear.drive.core.thumbnail.a.a;
        List<BaseOpenEntity> r36 = r33.d;
        if (r36 != null) goto L103;
        r36 = CollectionsKt.emptyList();
    L103:
        if (r36.size() > 1) goto L105;
        tt5.a.h("DrivePreviewThumbnailConfig", "shouldShow false: entityCount=" + r36.size());
    L111:
        boolean r37 = false;
    L125:
        if (r37 == true) goto L127;
        tt5.a.h("DriveThumbnailOverlay", "thumbnailOverlay attach skipped: shouldShow=false itemCount=" + r33.d.size());
        goto L156
    L127:
        GalleryThumbnailView r38 = r33.f;
        ?? r39 = r38;
        if (r38 != null) goto L134;
        FrameLayout r40 = (FrameLayout) r33.a.findViewById(2131370333);
        if (r40 != 0) goto L133;
        r39 = 0;
        goto L134
    L133:
        int r41 = r33.a.getResources().getDimensionPixelSize(2131166319);
        int r42 = r33.a.getResources().getDimensionPixelSize(2131166320);
        int r43 = r33.a.getResources().getDimensionPixelSize(2131166317);
        ?? r44 = new GalleryThumbnailView(r33.a.getContext(), null, 6, 0);
        r44.setId(2131370321);
        r44.setVisibility(0);
        r44.setOverScrollMode(2);
        r44.setHorizontalFadingEdgeEnabled(true);
        r44.setBackgroundColor(r44.getResources().getColor(2131106784));
        r44.setFadingEdgeLength(r41);
        r44.setPadding(r41, r42, r41, r43);
        r44.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r40.addView(r44);
        r33.f = r44;
        tt5.a.h("DriveThumbnailOverlay", "thumbnailOverlay ensureBar childCount=" + r40.getChildCount());
        r39 = r44;
    L134:
        if (r39 != 0) goto L136;
        tt5.a.k("DriveThumbnailOverlay", "thumbnailOverlay attach failed: slotMissing");
        goto L156
    L136:
        com.bytedance.ee.bear.drive.core.thumbnail.b r46 = r33.g;
        if (r46 != null) goto L153;
        com.bytedance.ee.bear.drive.core.thumbnail.b r47 = new com.bytedance.ee.bear.drive.core.thumbnail.b(r39, r33.c, r33.d);
        r47.a.setClipToPadding(false);
        r47.a.setClipChildren(false);
        r47.a.setHasFixedSize(true);
        r47.a.setItemAnimator(null);
        r47.a.addItemDecoration(r47.f);
        r47.a.setAdapter(r47.e);
        ThumbnailTrackerLayoutManager r48 = r47.d;
        r48.j = new com.bytedance.ee.bear.drive.core.thumbnail.e(r47);
        r48.k = new com.bytedance.ee.bear.drive.core.thumbnail.c(r47);
        RecyclerView r49 = r47.a;
        if (r49 != null) goto L142;
    L147:
        r47.b.addOnPageChangeListener(r47.h);
        Runnable r50 = r47.i;
        if (r50 == null) goto L150;
        r47.a.removeCallbacks(r50);
    L150:
        com.bytedance.ee.bear.drive.core.thumbnail.d r51 = new com.bytedance.ee.bear.drive.core.thumbnail.d(r47, r22);
        r47.i = r51;
        r47.a.post(r51);
        r33.g = r47;
    L154:
        r33.h = true;
        r33.c();
        r33.a();
        r39.post(new s(r33));
        StringBuilder r52 = new StringBuilder("thumbnailOverlay attach success shown=");
        r52.append(!r33.i);
        r52.append(" itemCount=");
        r52.append(r33.d.size());
        tt5.a.h("DriveThumbnailOverlay", r52.toString());
        goto L156
    L142:
        if (r48.getOrientation() != 0) goto L144;
        boolean r53 = true;
    L145:
        if (r53 == false) goto L152;
        tt5.a.h("ThumbnailTrackerLayoutManager", "[attach]: selectedPosition = " + r22);
        r48.g = r49;
        r48.b = RangesKt.coerceAtLeast(0, r22);
        r48.c = r22;
        r49.setLayoutManager(r48);
        r48.h.attachToRecyclerView(r49);
        r49.addOnScrollListener(r48.i);
        goto L147
    L152:
        throw new IllegalStateException("Check failed.".toString());
    L144:
        r53 = false;
        goto L145
    L153:
        r46.a(r22, false);
        goto L154
    L105:
        BaseOpenEntity r54 = (BaseOpenEntity) CollectionsKt.getOrNull(r36, r22);
        if (r54 != null) goto L109;
        tt5.a.k("DrivePreviewThumbnailConfig", "shouldShow false: invalidPosition=" + r22 + " entityCount=" + r36.size());
        goto L111
    L109:
        if (r54.isInVc() == false) goto L112;
        tt5.a.h("DrivePreviewThumbnailConfig", "shouldShow false: vc");
        goto L111
    L112:
        List<BaseOpenEntity> r56 = r36;
        if ((r56 instanceof Collection) == true) goto L115;
    L117:
        Iterator<T> r57 = r56.iterator();
    L119:
        if (r57.hasNext() == false) goto L123;
        BaseOpenEntity r58 = (BaseOpenEntity) r57.next();
        j.a.getClass();
        if (j.b(j.d(r58)) == true) goto L119;
        r37 = false;
    L124:
        tt5.a.h("DrivePreviewThumbnailConfig", "shouldShow result=" + r37 + " token=" + du5.b.k(r54.getFileId()));
    L123:
        r37 = true;
        goto L124
    L115:
        if (r56.isEmpty() == false) goto L117;
    L156:
        if (r14.size() > 1) goto L158;
        DrivePreviewViewPager r59 = this.e;
        Intrinsics.checkNotNull(r59);
        r59.setEnableSwipe(false);
    L158:
        this.g = r14;
        DrivePreviewViewPager r60 = this.e;
        if (r60 == null) goto L169;
        r60.addOnPageChangeListener(new DriveMainFragment$initView$11(this, r14));
        return;
    L169:
        return;
    L87:
        tt5.a.k("DriveSdk", "installProductHostAbilities skipped: openStrategy null");
        goto L88
    L78:
        ConcurrentHashMap<String, com.bytedance.ee.drive.render.j> r61 = x75.a.a;
        com.bytedance.ee.drive.render.j r62 = x75.a.a(r12.getString("drive_open_strategy_key"));
        if (r62 == null) goto L81;
        com.bytedance.ee.drive.render.m r63 = r62.d();
    L82:
        if (r63 == null) goto L84;
        r63.c(t75.i.class, new c(r28, r12, this));
        goto L84
    L81:
        r63 = null;
        goto L82
    L72:
        if (r27.n == false) goto L74;
        tt5.a.h("DriveSdk", "updateBottomOverlayInset skipped: released");
        goto L75
    L74:
        r27.j();
        goto L75
    L54:
        if (r21.s == true) goto L66;
        if (r21.t == true) goto L66;
        r21.s = true;
        ViewGroup r64 = (ViewGroup) r21.b.findViewById(2131370319);
        if (r64 == null) goto L65;
        f r66 = r21.q;
        if (r66 != null) goto L64;
        r66 = new f(r21);
        r21.q = r66;
    L64:
        r64.removeOnLayoutChangeListener(r66);
        r64.addOnLayoutChangeListener(r66);
    L65:
        r21.e.getLiveMimeTypeCategory().observe(r21.c, new e(r21));
        r21.l();
        goto L66
    L50:
        tt5.a.h("DriveSdk", "initView() thumbnailOverlay skipped: thumbnailDisabled");
        r20 = null;
    L46:
        r19 = false;
    L36:
        r18 = false;
        goto L37
    L15:
        if (r2 < r14.size()) goto L17;
        r2 = r14.size() - 1;
    L17:
        r9 = r2;
        goto L18
    }

    @Override // sa5.a
    public final void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        DrivePreviewFragment r0 = U90();
        if (r0 == null) goto L6;
        r0.onActivityResult(r2, r3, r4);
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131560209, r3, false);
    }
}
