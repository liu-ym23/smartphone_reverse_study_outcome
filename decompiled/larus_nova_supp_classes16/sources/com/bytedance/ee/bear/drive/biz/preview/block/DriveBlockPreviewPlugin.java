package com.bytedance.ee.bear.drive.biz.preview.block;

import android.R;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentFragment;
import com.bytedance.ee.bear.drive.biz.docplugin.AttachmentFollowVM;
import com.bytedance.ee.bear.drive.biz.preview.screen.DriveFullScreenVM;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.module.nativepreview.model.FileBlockResModel;
import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockPreviewVM;
import com.bytedance.ee.bear.drive.view.preview.block.DriveMainRootLayout;
import com.bytedance.ee.bear.drive.view.preview.media.DriveMediaDurationVm;
import com.bytedance.ee.bear.drive.view.preview.media.DriveMediaVM;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.slideback.SlideFrameLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 Q2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001QB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u0018H\u0016J\u0018\u0010*\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010+\u001a\u00020,H\u0017J\b\u0010-\u001a\u00020$H\u0002J\b\u0010.\u001a\u00020$H\u0002J\u0010\u0010/\u001a\u00020$2\u0006\u0010)\u001a\u00020\u0018H\u0002J\u0018\u00100\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010+\u001a\u00020,H\u0016J\b\u00101\u001a\u00020$H\u0002J\b\u00102\u001a\u00020$H\u0002J\b\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020\u0012H\u0002J\n\u00106\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u00107\u001a\u00020$2\u0006\u00108\u001a\u00020\u0012H\u0002J\b\u00109\u001a\u00020$H\u0002J\u0084\u0001\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00182\u0006\u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u00020\u00182\u0006\u0010B\u001a\u00020\u00182\u0006\u0010C\u001a\u00020\u00182\u0006\u0010D\u001a\u00020\u00182\u0006\u0010E\u001a\u00020\u00182\u0006\u0010F\u001a\u00020\u00182\u0006\u0010G\u001a\u00020\u00182\u0006\u0010H\u001a\u00020\u00182\n\b\u0002\u0010I\u001a\u0004\u0018\u00010JH\u0002J\u0014\u0010K\u001a\u0004\u0018\u00010\u00072\b\u0010L\u001a\u0004\u0018\u00010MH\u0002J\u0006\u0010N\u001a\u00020$J\u0006\u0010O\u001a\u00020$J\b\u0010P\u001a\u00020\u0012H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006R"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/block/DriveBlockPreviewPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "Lcom/bytedance/ee/bear/drive/biz/preview/block/IDriveBlockPreviewErrorAbility;", "<init>", "()V", "placeContentView", "Landroid/view/ViewGroup;", "mainRootLayout", "Lcom/bytedance/ee/bear/drive/view/preview/block/DriveMainRootLayout;", "showAnimSet", "Ljava/util/ArrayList;", "Landroid/animation/ValueAnimator;", "Lkotlin/collections/ArrayList;", "hideAnimSet", "blockTitleView", "Lcom/bytedance/ee/bear/drive/biz/preview/block/DriveBlockTitleView;", "enableSlideDown", "", "mainTitleBarRoot", "animating", "mVCFollowUUID", "", "middleLeftMargin", "", "getMiddleLeftMargin", "()I", "middleTopMargin", "getMiddleTopMargin", "mAttachmentFollowVM", "Lcom/bytedance/ee/bear/drive/biz/docplugin/AttachmentFollowVM;", "getMAttachmentFollowVM", "()Lcom/bytedance/ee/bear/drive/biz/docplugin/AttachmentFollowVM;", "setMAttachmentFollowVM", "(Lcom/bytedance/ee/bear/drive/biz/docplugin/AttachmentFollowVM;)V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onDetachFromHost", "dispatchToBlockHandler", "type", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "setBlockClickListener", "setSlideListener", "reportSlideEvent", "onDetachFromUIContainer", "handleDetachMainLayout", "cancelAnim", "getBlockLocation", "", "isFromBaseInstructionDocx", "findFullScreenAttachRoot", "handlePreviewStateAnim", "withCurrentState", "addMainViewToBlock", "startAnim", "dur", "", "layoutParam", "Landroid/widget/FrameLayout$LayoutParams;", "startW", "endW", "startH", "endH", "startTopMargin", "endTopMargin", "startLeftMargin", "endLeftMargin", "titleHStart", "titleHEnd", "listener", "Landroid/animation/Animator$AnimatorListener;", "findPlaceholderView", "parent", "Landroid/view/ViewParent;", "disableMultiTaskSlide", "enableMultiTaskSlide", "onBackPressed", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveBlockPreviewPlugin extends AbsDrivePlugin implements sa5.d, y55.a {
    public static final a Companion = null;
    public static final long ENTER_ANIM_DUR_STEP_1 = 200;
    public static final long ENTER_ANIM_DUR_STEP_2 = 100;
    public static final long EXIST_ANIM_DUR_STEP_1 = 200;
    public static final long EXIST_ANIM_DUR_STEP_2 = 150;
    public static final String TAG = "DriveBlockPreviewPlugin";
    private boolean animating;
    private DriveBlockTitleView blockTitleView;
    private boolean enableSlideDown;
    private ArrayList<ValueAnimator> hideAnimSet;
    public AttachmentFollowVM mAttachmentFollowVM;
    private String mVCFollowUUID;
    private DriveMainRootLayout mainRootLayout;
    private ViewGroup mainTitleBarRoot;
    private final int middleLeftMargin;
    private final int middleTopMargin;
    private ViewGroup placeContentView;
    private ArrayList<ValueAnimator> showAnimSet;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ DriveBlockPreviewPlugin a;

        public b(DriveBlockPreviewPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            tt5.a.h(DriveBlockPreviewPlugin.TAG, "handlePreviewStateAnim() LeftClick");
            DriveBlockPreviewPlugin.access$handlePreviewStateAnim(this.a, false);
        }
    }

    public static final class c extends com.bytedance.ee.util.ui.g.a {
        public final /* synthetic */ DriveBlockPreviewPlugin a;
        public final /* synthetic */ FrameLayout.LayoutParams b;
        public final /* synthetic */ ViewGroup c;
        public final /* synthetic */ int d;

        public static final class a extends com.bytedance.ee.util.ui.g.a {
            public final /* synthetic */ DriveBlockPreviewPlugin a;
            public final /* synthetic */ FrameLayout.LayoutParams b;

            public final void onAnimationCancel(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
                tt5.a.h(DriveBlockPreviewPlugin.TAG, "handlePreviewStateAnim() canceled ENTER_ANIM_DUR_STEP_2");
            }

            public final void onAnimationEnd(Animator r5) {
                Intrinsics.checkNotNullParameter(r5, "animation");
                tt5.a.h(DriveBlockPreviewPlugin.TAG, "handlePreviewStateAnim() done ENTER_ANIM_DUR_STEP_2");
                k75.a.i(this.a.getHost()).setBlockViewChanging(false);
                this.a.getHost().c.updatePreviewType(4);
                n85.b r0 = n85.b.a.a;
                String r2 = k75.a.d(this.a);
                r0.getClass();
                if (TextUtils.isEmpty(r2) == false) goto L5;
                String r3 = "";
            L7:
                if (TextUtils.isEmpty(r3) == true) goto L12;
                FileBlockResModel r1 = r0.a.get(r3);
                if (r1 == null) goto L12;
                r1.setFullScreen(true);
            L12:
                if (DriveBlockPreviewPlugin.access$isUIContainerDetached(this.a) == false) goto L15;
                tt5.a.h(DriveBlockPreviewPlugin.TAG, "handlePreviewStateAnim() done ENTER_ANIM_DUR_STEP_2 isUIContainerDetached");
                DriveBlockPreviewPlugin.access$handleDetachMainLayout(this.a);
                return;
            L15:
                FrameLayout.LayoutParams r6 = this.b;
                r6.width = -1;
                r6.height = -1;
                DriveMainRootLayout r7 = DriveBlockPreviewPlugin.access$getMainRootLayout$p(this.a);
                if (r7 == null) goto L18;
                r7.setLayoutParams(this.b);
            L18:
                ViewGroup r8 = DriveBlockPreviewPlugin.access$getMainTitleBarRoot$p(this.a);
                if (r8 == null) goto L21;
                r8.setVisibility(0);
            L21:
                DriveBlockTitleView r9 = DriveBlockPreviewPlugin.access$getBlockTitleView$p(this.a);
                if (r9 == null) goto L24;
                r9.setVisibility(8);
            L24:
                DriveMainRootLayout r10 = DriveBlockPreviewPlugin.access$getMainRootLayout$p(this.a);
                if (r10 == null) goto L27;
                r10.removeView(DriveBlockPreviewPlugin.access$getBlockTitleView$p(this.a));
            L27:
                DriveBlockPreviewPlugin.access$setAnimating$p(this.a, false);
                return;
            L5:
                r3 = (String) ((ConcurrentHashMap) r0.j).get(r2);
                goto L7
            }

            public a(DriveBlockPreviewPlugin r1, FrameLayout.LayoutParams r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        public static final class b implements Runnable {
            public final /* synthetic */ DriveMainRootLayout a;

            public b(DriveMainRootLayout r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ViewCompat.requestApplyInsets(this.a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            tt5.a.h(DriveBlockPreviewPlugin.TAG, "handlePreviewStateAnim() canceled ENTER_ANIM_DUR_STEP_1");
        }

        public final void onAnimationEnd(Animator r19) {
            Intrinsics.checkNotNullParameter(r19, "animation");
            tt5.a.h(DriveBlockPreviewPlugin.TAG, "handlePreviewStateAnim() done ENTER_ANIM_DUR_STEP_1 start ENTER_ANIM_DUR_STEP_2");
            DriveBlockPreviewPlugin r3 = this.a;
            FrameLayout.LayoutParams r6 = this.b;
            int r7 = this.c.getWidth() - (this.a.getMiddleLeftMargin() * 2);
            int r8 = this.c.getWidth();
            int r9 = this.c.getHeight() - (this.a.getMiddleTopMargin() * 2);
            int r10 = this.c.getHeight();
            int r11 = this.a.getMiddleTopMargin();
            int r13 = this.a.getMiddleLeftMargin();
            int r1 = this.d;
            ArrayList r2 = DriveBlockPreviewPlugin.access$startAnim(r3, 100, r6, r7, r8, r9, r10, r11, 0, r13, 0, r1, r1, new a(this.a, this.b));
            ArrayList r4 = DriveBlockPreviewPlugin.access$getShowAnimSet$p(this.a);
            if (r4 == null) goto L6;
            r4.addAll(r2);
            return;
        }

        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (ForsetiHelper.s(this.a.getHost().a) == false) goto L8;
            DriveMainRootLayout r3 = DriveBlockPreviewPlugin.access$getMainRootLayout$p(this.a);
            if (r3 == null) goto L9;
            r3.setFitsSystemWindows(true);
            r3.post(new b(r3));
            return;
        L9:
            return;
        }

        public c(DriveBlockPreviewPlugin r1, FrameLayout.LayoutParams r2, ViewGroup r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class d extends com.bytedance.ee.util.ui.g.a {
        public final /* synthetic */ DriveBlockPreviewPlugin a;
        public final /* synthetic */ FrameLayout.LayoutParams b;
        public final /* synthetic */ ViewGroup c;
        public final /* synthetic */ int[] d;
        public final /* synthetic */ int e;

        public static final class a extends com.bytedance.ee.util.ui.g.a {
            public final /* synthetic */ DriveBlockPreviewPlugin a;

            public a(DriveBlockPreviewPlugin r1) {
                this.a = r1;
            }

            public final void onAnimationCancel(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
                tt5.a.h(DriveBlockPreviewPlugin.TAG, "handlePreviewStateAnim() canceled EXIST_ANIM_DUR_STEP_2");
            }

            public final void onAnimationEnd(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
                tt5.a.h(DriveBlockPreviewPlugin.TAG, "handlePreviewStateAnim() done EXIST_ANIM_DUR_STEP_2");
                DriveBlockPreviewPlugin.access$addMainViewToBlock(this.a);
            }
        }

        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            tt5.a.h(DriveBlockPreviewPlugin.TAG, "handlePreviewStateAnim() canceled EXIST_ANIM_DUR_STEP_1");
        }

        public final void onAnimationEnd(Animator r21) {
            Intrinsics.checkNotNullParameter(r21, "animation");
            tt5.a.h(DriveBlockPreviewPlugin.TAG, "handlePreviewStateAnim() done EXIST_ANIM_DUR_STEP_1 start EXIST_ANIM_DUR_STEP_2");
            n85.b r1 = n85.b.a.a;
            String r2 = k75.a.d(this.a);
            r1.getClass();
            if (TextUtils.isEmpty(r2) == false) goto L5;
            String r3 = "";
        L7:
            if (TextUtils.isEmpty(r3) == true) goto L11;
            FileBlockResModel r4 = r1.a.get(r3);
            if (r4 == null) goto L11;
            r4.setFullScreen(false);
        L11:
            DriveBlockPreviewPlugin r5 = this.a;
            FrameLayout.LayoutParams r8 = this.b;
            int r9 = this.c.getWidth() - (this.a.getMiddleLeftMargin() * 2);
            ViewGroup r6 = DriveBlockPreviewPlugin.access$getPlaceContentView$p(this.a);
            Intrinsics.checkNotNull(r6);
            int r10 = r6.getWidth();
            int r11 = this.c.getHeight() - (this.a.getMiddleTopMargin() * 2);
            ViewGroup r7 = DriveBlockPreviewPlugin.access$getPlaceContentView$p(this.a);
            Intrinsics.checkNotNull(r7);
            ArrayList r12 = DriveBlockPreviewPlugin.access$startAnim(r5, 150, r8, r9, r10, r11, r7.getHeight(), this.a.getMiddleTopMargin(), this.d[1], this.a.getMiddleLeftMargin(), this.d[0], this.e, 0, new a(this.a));
            ArrayList r13 = DriveBlockPreviewPlugin.access$getHideAnimSet$p(this.a);
            if (r13 == null) goto L15;
            r13.addAll(r12);
            return;
        L15:
            return;
        L5:
            r3 = (String) ((ConcurrentHashMap) r1.j).get(r2);
            goto L7
        }

        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (ForsetiHelper.s(this.a.getHost().a) == false) goto L11;
            DriveMainRootLayout r3 = DriveBlockPreviewPlugin.access$getMainRootLayout$p(this.a);
            if (r3 == null) goto L7;
            r3.setPadding(0, 0, 0, 0);
        L7:
            DriveMainRootLayout r4 = DriveBlockPreviewPlugin.access$getMainRootLayout$p(this.a);
            if (r4 == null) goto L12;
            r4.setFitsSystemWindows(false);
            return;
        L12:
            return;
        }

        public d(DriveBlockPreviewPlugin r1, FrameLayout.LayoutParams r2, ViewGroup r3, int[] r4, int r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public static final class e extends u75.b.C0306b {
        public final /* synthetic */ DriveBlockPreviewPlugin a;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ DriveBlockPreviewPlugin a;

            public a(DriveBlockPreviewPlugin r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r2) {
                DriveBlockPreviewPlugin.access$handlePreviewStateAnim(this.a, false);
            }
        }

        public e(DriveBlockPreviewPlugin r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // u75.b.C0306b, u75.b.a
        public final <T> void a(InfoCode r5, T r6) {
            Intrinsics.checkNotNullParameter(r5, "code");
            if (r5 == InfoCode.FileInfoSuccess) goto L5;
            return;
        L5:
            if ((r6 instanceof w75.a) == false) goto L27;
            g85.f r7 = o75.b.a().getMimeTypeManager();
            DriveBlockPreviewPlugin r0 = this.a;
            w75.a r8 = (w75.a) r6;
            g85.b r9 = (g85.b) r7;
            if (r9.o(r8.c().k, null) == false) goto L9;
        L12:
            boolean r10 = true;
        L13:
            DriveBlockPreviewPlugin.access$setEnableSlideDown$p(r0, r10);
            if (DriveBlockPreviewPlugin.access$getEnableSlideDown$p(this.a) == false) goto L18;
            DriveBlockTitleView r11 = DriveBlockPreviewPlugin.access$getBlockTitleView$p(this.a);
            if (r11 == null) goto L24;
            r11.setForceGone(true);
        L24:
            DriveBlockPreviewPlugin.access$getMainRootLayout$p(this.a);
            tt5.a.h(DriveBlockPreviewPlugin.TAG, "FileInfoSuccess enableSlideDown=" + DriveBlockPreviewPlugin.access$getEnableSlideDown$p(this.a));
            return;
        L18:
            DriveBlockTitleView r12 = DriveBlockPreviewPlugin.access$getBlockTitleView$p(this.a);
            if (r12 == null) goto L21;
            r12.setVisibility(0);
        L21:
            DriveBlockTitleView r13 = DriveBlockPreviewPlugin.access$getBlockTitleView$p(this.a);
            if (r13 == null) goto L24;
            r13.setOnClickListener(new a(this.a));
            goto L24
        L9:
            if (r9.e(r8.c().k) == true) goto L12;
            r10 = false;
            goto L13
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ DriveBlockPreviewVM a;
        public final /* synthetic */ DriveBlockPreviewPlugin b;

        public f(DriveBlockPreviewVM r1, DriveBlockPreviewPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r3) {
            Integer r4 = (Integer) r3;
            tt5.a.h(DriveBlockPreviewPlugin.TAG, "livePreviewType() value=" + r4);
            if (r4 != null) goto L6;
        L14:
            if (r4 != null) goto L17;
            return;
        L17:
            if (r4.intValue() != 4) goto L27;
            this.a.getLiveBlockState().setValue(DriveBlockPreviewVM.BlockState.FULLSCREEN);
            DriveMainRootLayout r5 = DriveBlockPreviewPlugin.access$getMainRootLayout$p(this.b);
            if (r5 == null) goto L21;
            r5.setInBlock(false);
        L21:
            DriveMainRootLayout r6 = DriveBlockPreviewPlugin.access$getMainRootLayout$p(this.b);
            if (r6 == null) goto L24;
            r6.setClipToOutline(false);
        L24:
            KeyboardUtils.hideKeyboard(DriveBlockPreviewPlugin.access$getActivity(this.b));
            this.b.getMAttachmentFollowVM().getFileBlockState().setValue(Boolean.FALSE);
            return;
        L27:
            return;
        L6:
            if (r4.intValue() != 3) goto L14;
            this.a.getLiveBlockState().setValue(DriveBlockPreviewVM.BlockState.BLOCK);
            DriveMainRootLayout r7 = DriveBlockPreviewPlugin.access$getMainRootLayout$p(this.b);
            if (r7 == null) goto L10;
            r7.setInBlock(true);
        L10:
            DriveMainRootLayout r8 = DriveBlockPreviewPlugin.access$getMainRootLayout$p(this.b);
            if (r8 == null) goto L13;
            r8.setShowBorder(true);
        L13:
            this.b.getMAttachmentFollowVM().getFileBlockState().setValue(Boolean.TRUE);
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ DriveMediaDurationVm a;
        public final /* synthetic */ DriveBlockPreviewPlugin b;

        public g(DriveMediaDurationVm r1, DriveBlockPreviewPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r3) {
            DriveMediaDurationVm r0 = this.a;
            String r1 = k75.a.d(this.b);
            r0.setExtraData(r1, (Long) r3);
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ DriveMediaDurationVm a;
        public final /* synthetic */ DriveBlockPreviewPlugin b;
        public final /* synthetic */ DriveMediaVM c;

        public h(DriveMediaDurationVm r1, DriveBlockPreviewPlugin r2, DriveMediaVM r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onChanged(Object r4) {
            Map r5 = (Map) r4;
            MutableLiveData<Map<String, Long>> r0 = this.a.getExtraData();
            if (r0 == null) goto L5;
            r0.removeObservers(DriveBlockPreviewPlugin.access$getLifecycleOwner(this.b));
        L5:
            Long r6 = (Long) r5.get(k75.a.d(this.b));
            tt5.a.h(DriveBlockPreviewPlugin.TAG, "DriveMediaDurationVm#record position=" + r6);
            if (r6 == null) goto L9;
            this.c.getResumePosition().postValue(Long.valueOf(r6.longValue()));
            return;
        }
    }

    public static final class i<T> implements Observer {
        public final /* synthetic */ DriveBlockPreviewPlugin a;

        public i(DriveBlockPreviewPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            String r5 = (String) r4;
            String r0 = com.bytedance.ee.util.io.a.c(r5);
            DriveBlockTitleView r1 = DriveBlockPreviewPlugin.access$getBlockTitleView$p(this.a);
            if (r1 == null) goto L5;
            r1.setTitle(r5);
        L5:
            DriveBlockTitleView r6 = DriveBlockPreviewPlugin.access$getBlockTitleView$p(this.a);
            if (r6 == null) goto L8;
            r6.setIcon(rbb.b.e(r0));
        L8:
            g85.b r7 = (g85.b) o75.b.a().getMimeTypeManager();
            if (r7.e(r0) == false) goto L11;
            return;
        L11:
            if (r7.o(r0, null) == false) goto L13;
            return;
        L13:
            if (r7.j(r0, null) == true) goto L20;
            DriveBlockTitleView r8 = DriveBlockPreviewPlugin.access$getBlockTitleView$p(this.a);
            if (r8 == null) goto L21;
            r8.e.setBackgroundResource(2131234008);
            r8.b.setTextColor(com.bytedance.ee.util.ui.n.h(r8.getContext(), 2131106516));
            return;
        L21:
            return;
        }
    }

    public static final class j<T> implements Observer {
        public final /* synthetic */ DriveBlockPreviewPlugin a;

        public j(DriveBlockPreviewPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            DriveBlockPreviewPlugin.access$handlePreviewStateAnim(this.a, false);
        }
    }

    public static final class k<T> implements Observer {
        public final /* synthetic */ DriveBlockPreviewPlugin a;

        public k(DriveBlockPreviewPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L10;
            DriveBlockTitleView r3 = DriveBlockPreviewPlugin.access$getBlockTitleView$p(this.a);
            if (r3 == null) goto L7;
            r3.setForceGone(false);
        L7:
            DriveBlockTitleView r4 = DriveBlockPreviewPlugin.access$getBlockTitleView$p(this.a);
            if (r4 == null) goto L14;
            r4.setVisibility(0);
            return;
        L14:
            return;
        L10:
            DriveBlockTitleView r5 = DriveBlockPreviewPlugin.access$getBlockTitleView$p(this.a);
            if (r5 == null) goto L16;
            r5.setForceGone(true);
            return;
        }
    }

    public static final class l<T> implements Observer {
        public final /* synthetic */ DrivePluginHost a;
        public final /* synthetic */ DriveBlockPreviewPlugin b;

        public l(DrivePluginHost r1, DriveBlockPreviewPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r2) {
            Integer r3 = (Integer) r2;
            Integer r4 = (Integer) this.a.c.livePreviewType().getValue();
            if (r4 != null) goto L6;
            return;
        L6:
            if (r4.intValue() != 4) goto L9;
            DriveBlockPreviewPlugin.access$handlePreviewStateAnim(this.b, false);
            return;
        }
    }

    public static final class m implements View.OnClickListener {
        public final /* synthetic */ DriveBlockPreviewVM a;
        public final /* synthetic */ DriveBlockPreviewPlugin b;

        public m(DriveBlockPreviewVM r1, DriveBlockPreviewPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            Iterator<h95.a> r3 = this.a.getBlockClickInterceptors().iterator();
            if (r3.hasNext() == false) goto L6;
            r3.next().c();
            return;
        L6:
            DriveBlockPreviewPlugin.access$handlePreviewStateAnim(this.b, false);
        }
    }

    public static final class n implements DriveMainRootLayout.a {
        public final /* synthetic */ DriveBlockPreviewPlugin a;
        public final /* synthetic */ DriveFullScreenVM b;

        @Override // com.bytedance.ee.bear.drive.view.preview.block.DriveMainRootLayout.a
        public final boolean a(int r4) {
            if (r4 == 3) goto L5;
        L15:
            return false;
        L5:
            if (DriveBlockPreviewPlugin.access$getEnableSlideDown$p(this.a) == false) goto L15;
            com.bytedance.ee.bear.drive.biz.preview.screen.a r0 = (com.bytedance.ee.bear.drive.biz.preview.screen.a) this.b.getLiveFullScreen().getValue();
            if (r0 != null) goto L9;
        L11:
            boolean r1 = false;
        L12:
            if (r1 == true) goto L15;
            DriveBlockPreviewPlugin.access$handlePreviewStateAnim(this.a, false);
            DriveBlockPreviewPlugin.access$reportSlideEvent(this.a, r4);
            return true;
        L9:
            if (r0.a != true) goto L11;
            r1 = true;
            goto L12
        }

        public n(DriveBlockPreviewPlugin r1, DriveFullScreenVM r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class o implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ViewGroup.LayoutParams a;
        public final /* synthetic */ DriveBlockPreviewPlugin b;

        public o(ViewGroup.LayoutParams r1, DriveBlockPreviewPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            ViewGroup.LayoutParams r0 = this.a;
            if (r0 == null) goto L5;
            Object r4 = r3.getAnimatedValue();
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Int");
            r0.height = ((Integer) r4).intValue();
        L5:
            ViewGroup r5 = DriveBlockPreviewPlugin.access$getMainTitleBarRoot$p(this.b);
            if (r5 == null) goto L9;
            r5.setLayoutParams(this.a);
            return;
        }
    }

    public static final class p implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ FrameLayout.LayoutParams a;
        public final /* synthetic */ DriveBlockPreviewPlugin b;

        public p(FrameLayout.LayoutParams r1, DriveBlockPreviewPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            FrameLayout.LayoutParams r0 = this.a;
            Object r4 = r3.getAnimatedValue();
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Int");
            r0.topMargin = ((Integer) r4).intValue();
            DriveMainRootLayout r5 = DriveBlockPreviewPlugin.access$getMainRootLayout$p(this.b);
            if (r5 == null) goto L6;
            r5.setLayoutParams(this.a);
            return;
        }
    }

    public static final class q implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ FrameLayout.LayoutParams a;
        public final /* synthetic */ DriveBlockPreviewPlugin b;

        public q(FrameLayout.LayoutParams r1, DriveBlockPreviewPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            FrameLayout.LayoutParams r0 = this.a;
            Object r4 = r3.getAnimatedValue();
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Int");
            r0.leftMargin = ((Integer) r4).intValue();
            DriveMainRootLayout r5 = DriveBlockPreviewPlugin.access$getMainRootLayout$p(this.b);
            if (r5 == null) goto L6;
            r5.setLayoutParams(this.a);
            return;
        }
    }

    public static final class r implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ FrameLayout.LayoutParams a;
        public final /* synthetic */ DriveBlockPreviewPlugin b;

        public r(FrameLayout.LayoutParams r1, DriveBlockPreviewPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            Object r3 = r2.getAnimatedValue();
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Int");
            this.a.width = ((Integer) r3).intValue();
            DriveMainRootLayout r4 = DriveBlockPreviewPlugin.access$getMainRootLayout$p(this.b);
            if (r4 == null) goto L6;
            r4.setLayoutParams(this.a);
            return;
        }
    }

    public static final class s implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ FrameLayout.LayoutParams a;
        public final /* synthetic */ DriveBlockPreviewPlugin b;

        public s(FrameLayout.LayoutParams r1, DriveBlockPreviewPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            Object r3 = r2.getAnimatedValue();
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Int");
            this.a.height = ((Integer) r3).intValue();
            DriveMainRootLayout r4 = DriveBlockPreviewPlugin.access$getMainRootLayout$p(this.b);
            if (r4 == null) goto L6;
            r4.setLayoutParams(this.a);
            return;
        }
    }

    static {
        Companion = new a();
    }

    private final int[] getBlockLocation() {
        int[] r1 = {0, 0};
        ViewGroup r2 = this.placeContentView;
        if (r2 == null) goto L5;
        r2.getLocationOnScreen(r1);
    L5:
        int[] r0 = {0, 0};
        ViewGroup r3 = findFullScreenAttachRoot();
        if (r3 == null) goto L8;
        r3.getLocationOnScreen(r0);
    L8:
        int r4 = r0[1];
        r1[1] = r1[1] - r4;
        return r1;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void addMainViewToBlock() {
        DriveMainRootLayout r0 = this.mainRootLayout;
        ViewParent r1 = null;
        if (r0 == null) goto L5;
        ViewParent r2 = r0.getParent();
    L6:
        ViewGroup r3 = (ViewGroup) r2;
        DriveMainRootLayout r4 = this.mainRootLayout;
        if (r4 == null) goto L9;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
    L10:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r6 = (FrameLayout.LayoutParams) r5;
        if (r3 == null) goto L13;
        r3.removeView(this.mainRootLayout);
    L13:
        r6.topMargin = 0;
        r6.leftMargin = 0;
        r6.width = -1;
        r6.height = -1;
        ViewGroup r7 = this.placeContentView;
        if (r7 == null) goto L16;
        r7.addView(this.mainRootLayout, r6);
    L16:
        ViewGroup r8 = this.mainTitleBarRoot;
        if (r8 == null) goto L19;
        r8.setVisibility(8);
    L19:
        DriveBlockTitleView r9 = this.blockTitleView;
        if (r9 == null) goto L22;
        r9.setVisibility(0);
    L22:
        DriveBlockTitleView r10 = this.blockTitleView;
        if (r10 == null) goto L25;
        ViewParent r11 = r10.getParent();
    L26:
        if (r11 != null) goto L30;
        DriveMainRootLayout r12 = this.mainRootLayout;
        if (r12 == null) goto L30;
        r12.addView(this.blockTitleView);
    L30:
        getHost().c.updatePreviewType(3);
        k75.a.i(getHost()).setBlockViewChanging(false);
        this.animating = false;
        StringBuilder r13 = new StringBuilder("handlePreviewStateAnim() done EXIST_ANIM_DUR_STEP_2 mainRootLayoutParent=");
        DriveMainRootLayout r14 = this.mainRootLayout;
        if (r14 == null) goto L33;
        r1 = r14.getParent();
    L33:
        r13.append(r1);
        r13.append(" placeContentView=");
        r13.append(this.placeContentView);
        tt5.a.h(TAG, r13.toString());
        if (isUIContainerDetached() == false) goto L37;
        tt5.a.h(TAG, "handlePreviewStateAnim() done EXIST_ANIM_DUR_STEP_2 isUIContainerDetached");
        handleDetachMainLayout();
        return;
    L37:
        return;
    L25:
        r11 = null;
        goto L26
    L9:
        r5 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    private final void cancelAnim() {
        List r0 = this.showAnimSet;
        if (r0 != null) goto L6;
        r0 = CollectionsKt.emptyList();
    L6:
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((ValueAnimator) r1.next()).cancel();
        goto L8
    L10:
        ArrayList<ValueAnimator> r2 = this.showAnimSet;
        if (r2 == null) goto L13;
        r2.clear();
    L13:
        List r3 = this.hideAnimSet;
        if (r3 != null) goto L17;
        r3 = CollectionsKt.emptyList();
    L17:
        Iterator r4 = r3.iterator();
    L19:
        if (r4.hasNext() == false) goto L21;
        ((ValueAnimator) r4.next()).cancel();
        goto L19
    L21:
        ArrayList<ValueAnimator> r5 = this.hideAnimSet;
        if (r5 == null) goto L27;
        r5.clear();
        return;
    }

    private final void handleDetachMainLayout() {
        DriveMainRootLayout r0 = this.mainRootLayout;
        if (r0 == null) goto L5;
        ViewParent r1 = r0.getParent();
    L6:
        ViewGroup r2 = (ViewGroup) r1;
        tt5.a.k(TAG, "handleDetachMainLayout() mainRootLayoutParent=" + r2);
        if (r2 == null) goto L10;
        r2.removeView(this.mainRootLayout);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void setBlockClickListener() {
        DriveBlockPreviewVM r0 = (DriveBlockPreviewVM) viewModel(DriveBlockPreviewVM.class);
        DriveMainRootLayout r1 = this.mainRootLayout;
        if (r1 == null) goto L6;
        r1.setInterceptClickListener(new m(r0, this));
        return;
    }

    public final void disableMultiTaskSlide() {
        tt5.a.h(TAG, "disableMultiTaskSlide()...");
        FragmentActivity r0 = getActivity();
        ViewParent r2 = null;
        if (r0 == null) goto L5;
        View r1 = r0.findViewById(R.id.content);
    L6:
        if (r1 == null) goto L9;
        r2 = r1.getParent();
    L9:
        if ((r2 instanceof SlideFrameLayout) == false) goto L12;
        tt5.a.h(TAG, "SlideFrameLayout exist, setCanSlide = false");
        SlideFrameLayout r3 = r1.getParent();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.ss.android.lark.slideback.SlideFrameLayout");
        r3.setSlideable(false);
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void enableMultiTaskSlide() {
        tt5.a.h(TAG, "enableMultiTaskSlide()...");
        FragmentActivity r0 = getActivity();
        ViewParent r1 = null;
        if (r0 == null) goto L5;
        View r2 = r0.findViewById(R.id.content);
    L6:
        if (r2 == null) goto L9;
        r1 = r2.getParent();
    L9:
        if ((r1 instanceof SlideFrameLayout) == false) goto L12;
        SlideFrameLayout r3 = r2.getParent();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.ss.android.lark.slideback.SlideFrameLayout");
        r3.setSlideable(true);
        return;
    L12:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final AttachmentFollowVM getMAttachmentFollowVM() {
        AttachmentFollowVM r0 = this.mAttachmentFollowVM;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mAttachmentFollowVM");
        return null;
    }

    public DriveBlockPreviewPlugin() {
        this.mVCFollowUUID = "";
        this.middleLeftMargin = com.bytedance.ee.util.ui.n.d(24);
        this.middleTopMargin = com.bytedance.ee.util.ui.n.d(45);
    }

    private final ViewGroup findFullScreenAttachRoot() {
        if (getHost().c.getOpenEntity().isInVc() == false) goto L12;
        Fragment r0 = getHost().a.getParentFragment();
        if (r0 == null) goto L9;
        Fragment r1 = r0.getParentFragment();
        if (r1 == null) goto L9;
        Fragment r2 = r1.getParentFragment();
    L10:
        if (r2 == null) goto L12;
    L13:
        Fragment r3 = getHost().a.getParentFragment();
        if (r3 == null) goto L18;
        Fragment r4 = r3.getParentFragment();
        if (r4 == null) goto L18;
        View r5 = r4.getView();
    L19:
        ViewGroup r6 = (ViewGroup) r5;
        if (r6 == null) goto L22;
        int r7 = r6.getChildCount();
    L23:
        int r8 = 0;
    L24:
        if (r8 >= r7) goto L38;
        if (r6 == null) goto L27;
        View r9 = r6.getChildAt(r8);
    L29:
        if ((r9 instanceof ViewGroup) == false) goto L37;
        ViewGroup r10 = (ViewGroup) r9;
        if (r10.getId() != 2131382479) goto L33;
        boolean r11 = true;
    L34:
        if (r11 == false) goto L37;
        tt5.a.h(TAG, "findFullScreenAttachRoot() attachmentDocRoot not null");
        return r10;
    L33:
        r11 = false;
    L37:
        r8 = r8 + 1;
        goto L24
    L27:
        r9 = null;
    L38:
        tt5.a.h(TAG, "findFullScreenAttachRoot() use android.R.id.content");
        FragmentActivity r12 = getActivity();
        if (r12 != null) goto L41;
        return null;
    L41:
        return (ViewGroup) r12.findViewById(R.id.content);
    L22:
        r7 = 0;
    L18:
        r5 = null;
    L9:
        r2 = null;
    L12:
        if (isFromBaseInstructionDocx() == false) goto L38;
        goto L13
    }

    private final boolean isFromBaseInstructionDocx() {
        Fragment r0 = getHost().a.getParentFragment();
        DocsOpenSource r1 = null;
        if (r0 == null) goto L5;
        Fragment r2 = r0.getParentFragment();
    L7:
        if ((r2 instanceof DocumentFragment) == false) goto L9;
        DocumentFragment r3 = (DocumentFragment) r2;
    L10:
        if (r3 == null) goto L15;
        DocViewModel r4 = r3.H0();
        if (r4 == null) goto L15;
        r1 = r4.getOpenSource();
    L15:
        if (r1 != DocsOpenSource.base_instruction_docx) goto L17;
        return true;
    L17:
        return false;
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    private final void setSlideListener() {
        com.bytedance.ee.util.ui.n.v();
        DriveFullScreenVM r0 = (DriveFullScreenVM) new ViewModelProvider(getActivity()).get(DriveFullScreenVM.class);
        DriveMainRootLayout r1 = this.mainRootLayout;
        if (r1 == null) goto L6;
        r1.setSlideListener(new n(this, r0));
        return;
    }

    @Override // sa5.d
    public boolean onBackPressed() {
        Integer r0 = (Integer) getHost().c.livePreviewType().getValue();
        if (r0 != null) goto L6;
    L9:
        return false;
    L6:
        if (r0.intValue() != 4) goto L9;
        handlePreviewStateAnim(false);
        return true;
    }

    public final int getMiddleLeftMargin() {
        return this.middleLeftMargin;
    }

    public final int getMiddleTopMargin() {
        return this.middleTopMargin;
    }

    public static final /* synthetic */ void access$addMainViewToBlock(DriveBlockPreviewPlugin r0) {
        r0.addMainViewToBlock();
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DriveBlockPreviewPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ int[] access$getBlockLocation(DriveBlockPreviewPlugin r0) {
        return r0.getBlockLocation();
    }

    public static final /* synthetic */ DriveBlockTitleView access$getBlockTitleView$p(DriveBlockPreviewPlugin r0) {
        return r0.blockTitleView;
    }

    public static final /* synthetic */ boolean access$getEnableSlideDown$p(DriveBlockPreviewPlugin r0) {
        return r0.enableSlideDown;
    }

    public static final /* synthetic */ ArrayList access$getHideAnimSet$p(DriveBlockPreviewPlugin r0) {
        return r0.hideAnimSet;
    }

    public static final /* synthetic */ LifecycleOwner access$getLifecycleOwner(DriveBlockPreviewPlugin r0) {
        return r0.getLifecycleOwner();
    }

    public static final /* synthetic */ DriveMainRootLayout access$getMainRootLayout$p(DriveBlockPreviewPlugin r0) {
        return r0.mainRootLayout;
    }

    public static final /* synthetic */ ViewGroup access$getMainTitleBarRoot$p(DriveBlockPreviewPlugin r0) {
        return r0.mainTitleBarRoot;
    }

    public static final /* synthetic */ ViewGroup access$getPlaceContentView$p(DriveBlockPreviewPlugin r0) {
        return r0.placeContentView;
    }

    public static final /* synthetic */ ArrayList access$getShowAnimSet$p(DriveBlockPreviewPlugin r0) {
        return r0.showAnimSet;
    }

    public static final /* synthetic */ void access$handleDetachMainLayout(DriveBlockPreviewPlugin r0) {
        r0.handleDetachMainLayout();
    }

    public static final /* synthetic */ boolean access$isUIContainerDetached(DriveBlockPreviewPlugin r0) {
        return r0.isUIContainerDetached();
    }

    private final ViewGroup findPlaceholderView(ViewParent r3) {
        if ((r3 instanceof ViewGroup) == false) goto L9;
        ViewGroup r4 = (ViewGroup) r3;
        if (Intrinsics.areEqual("block_place_holder", r4.getTag()) == false) goto L8;
        return r4;
    L8:
        return findPlaceholderView(r4.getParent());
    L9:
        return null;
    }

    private final void handlePreviewStateAnim(boolean r22) {
        tt5.a.h(TAG, "handlePreviewStateAnim() withCurrentState=" + r22);
        if (this.placeContentView != null) goto L6;
        this.placeContentView = findPlaceholderView(getUIContainer().getContentView().getParent());
        tt5.a.h(TAG, "handlePreviewStateAnim() findPlaceholderView done");
    L6:
        if (this.placeContentView != null) goto L8;
    L86:
        tt5.a.h(TAG, "handlePreviewStateAnim() wrong state return, placeContentView=" + this.placeContentView + ", mainRootLayout=" + this.mainRootLayout + ", animating=" + this.animating);
        return;
    L8:
        if (this.mainRootLayout == null) goto L86;
        if (this.animating == true) goto L86;
        ViewGroup r3 = findFullScreenAttachRoot();
        if (r3 != null) goto L15;
        return;
    L15:
        tt5.a.h(TAG, "DriveBlockPreviewPlugin#findPlaceholderView placeContentView=" + this.placeContentView);
        this.animating = true;
        DriveMainRootLayout r4 = this.mainRootLayout;
        if (r4 == null) goto L18;
        r4.setShowBorder(false);
    L18:
        cancelAnim();
        k75.a.i((DrivePluginHost) getHost()).setBlockViewChanging(true);
        int[] r5 = getBlockLocation();
        int r13 = getResources().getDimensionPixelSize(2131166316);
        DriveMainRootLayout r6 = this.mainRootLayout;
        Intrinsics.checkNotNull(r6);
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r8 = (FrameLayout.LayoutParams) r7;
        DriveMainRootLayout r9 = this.mainRootLayout;
        if (r9 == null) goto L21;
        r9.setClipToOutline(true);
    L21:
        Integer r10 = (Integer) ((DrivePluginHost) getHost()).c.livePreviewType().getValue();
        String r11 = "preview";
        if (r10 != null) goto L25;
    L57:
        tt5.a.h(TAG, "handlePreviewStateAnim() start exist fullScreen");
        setBlockClickListener();
        DriveMainRootLayout r1 = this.mainRootLayout;
        if (r1 == null) goto L60;
        r1.setSlideListener(null);
    L60:
        enableMultiTaskSlide();
        Integer r2 = (Integer) ((DrivePluginHost) getHost()).c.livePreviewType().getValue();
        if (r2 != null) goto L64;
    L66:
        r11 = "card";
    L67:
        k75.a.c((DrivePluginHost) getHost()).p(((DrivePluginHost) getHost()).c.getFileModel(), "click_return", r11);
        ViewGroup r12 = this.mainTitleBarRoot;
        if (r12 == null) goto L70;
        r12.setVisibility(0);
    L70:
        if (r22 == false) goto L72;
        int r14 = r8.width;
    L73:
        int r16 = r14;
        if (r22 == false) goto L76;
        int r17 = r8.height;
    L77:
        int r18 = r17;
        if (r22 == false) goto L80;
        int r19 = r8.topMargin;
    L81:
        if (r22 == false) goto L83;
        int r110 = r8.leftMargin;
    L84:
        tt5.a.h(TAG, "handlePreviewStateAnim() start EXIST_ANIM_DUR_STEP_1");
        int r111 = r3.getWidth() - (this.middleLeftMargin * 2);
        int r0 = r3.getHeight();
        int r20 = this.middleTopMargin;
        this.hideAnimSet = startAnim(200, r8, r16, r111, r18, r0 - (r20 * 2), r19, r20, r110, this.middleLeftMargin, r13, r13, new d(this, r8, r3, r5, r13));
        return;
    L83:
        r110 = 0;
        goto L84
    L80:
        r19 = 0;
        goto L81
    L76:
        r17 = r3.getHeight();
        goto L77
    L72:
        r14 = r3.getWidth();
        goto L73
    L64:
        if (r2.intValue() != 4) goto L66;
    L25:
        if (r10.intValue() != 3) goto L57;
        tt5.a.h(TAG, "handlePreviewStateAnim() start fullScreen");
        r8.leftMargin = r5[0];
        r8.topMargin = r5[1];
        DriveMainRootLayout r21 = this.mainRootLayout;
        if (r21 == null) goto L29;
        ViewParent r23 = r21.getParent();
    L30:
        ViewGroup r24 = (ViewGroup) r23;
        tt5.a.h(TAG, "handlePreviewStateAnim() mainRootLayoutParent=" + r24);
        if (r24 == null) goto L33;
        r24.removeView(this.mainRootLayout);
    L33:
        r3.addView(this.mainRootLayout, r8);
        setSlideListener();
        disableMultiTaskSlide();
        DriveMainRootLayout r26 = this.mainRootLayout;
        if (r26 == null) goto L36;
        r26.removeView(this.blockTitleView);
    L36:
        ViewGroup r27 = this.mainTitleBarRoot;
        if (r27 == null) goto L39;
        r27.setVisibility(0);
    L39:
        DriveBlockTitleView r28 = this.blockTitleView;
        if (r28 == null) goto L42;
        r28.setVisibility(8);
    L42:
        DriveMainRootLayout r29 = this.mainRootLayout;
        if (r29 == null) goto L45;
        r29.setInterceptClickListener(null);
    L45:
        getUIContainer().getTitleBar().getTitleBarLayout().setLeftClickListener(new b(this));
        Integer r30 = (Integer) ((DrivePluginHost) getHost()).c.livePreviewType().getValue();
        if (r30 != null) goto L49;
    L51:
        r11 = "card";
    L52:
        com.bytedance.ee.bear.drive.report.c r31 = k75.a.c((DrivePluginHost) getHost());
        w75.a r32 = ((DrivePluginHost) getHost()).c.getFileModel();
        if (r32 != null) goto L55;
        r31.getClass();
    L56:
        tt5.a.h(TAG, "handlePreviewStateAnim() start ENTER_ANIM_DUR_STEP_1");
        ViewGroup r33 = this.placeContentView;
        Intrinsics.checkNotNull(r33);
        int r34 = r33.getWidth();
        int r112 = r3.getWidth() - (this.middleLeftMargin * 2);
        ViewGroup r36 = this.placeContentView;
        Intrinsics.checkNotNull(r36);
        int r113 = r36.getHeight();
        int r37 = r3.getHeight();
        int r114 = this.middleTopMargin;
        this.showAnimSet = startAnim(200, r8, r34, r112, r113, r37 - (r114 * 2), r5[1], r114, r5[0], this.middleLeftMargin, 0, r13, new c(this, r8, r3, r13));
        return;
    L55:
        HashMap<String, Object> r38 = r31.i(r32);
        r38.put("is_degraded", com.bytedance.ee.bear.drive.report.c.k(r31.g.a(r32.c().a)));
        r31.c(r32.c().a, r38);
        r38.put("diaplay", r11);
        r31.A("ccm_drive_page_view", r38);
        goto L56
    L49:
        if (r30.intValue() != 4) goto L51;
    L29:
        r23 = null;
        goto L30
    }

    private final void reportSlideEvent(int r7) {
        if (r7 != 3) goto L5;
        String r8 = "slide_down";
    L6:
        Integer r0 = (Integer) getHost().c.livePreviewType().getValue();
        if (r0 != null) goto L10;
    L12:
        String r1 = "card";
    L13:
        com.bytedance.ee.bear.drive.report.c r2 = k75.a.c(getHost());
        w75.a r3 = getHost().c.getFileModel();
        r2.getClass();
        HashMap<String, Object> r4 = new HashMap();
        r4.put("click", "slide");
        r4.put("diaplay", r1);
        r4.put("target", "none");
        r4.put("action_type", r8);
        r2.r(r3, r4);
        return;
    L10:
        if (r0.intValue() != 4) goto L12;
        r1 = "preview";
        goto L13
    L5:
        r8 = "slide_right";
        goto L6
    }

    @Override // y55.a
    public void dispatchToBlockHandler(int r6) {
        if (CollectionsKt.listOf(new Integer[]{1, 2, 3, 4, 5}).contains(Integer.valueOf(r6)) == false) goto L10;
        ((DriveBlockPreviewVM) viewModel(DriveBlockPreviewVM.class)).getBlockTitleViewVisibility().postValue(Boolean.TRUE);
        if (r6 != 4) goto L7;
        z55.c r7 = new z55.b();
    L8:
        r7.a(getHost().e());
        return;
    L7:
        r7 = new z55.a();
        goto L8
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r7) {
        Intrinsics.checkNotNullParameter(r7, "host");
        super.onAttachToHost(r7);
        tt5.a.h(TAG, "onAttachToHost()");
        Bundle r1 = r7.c.getArgs();     // Catch: Exception -> L12
        String r2 = "";
        if (r1 == null) goto L10;
        String r3 = r1.getString("vc_follow_uuid", "");     // Catch: Exception -> L12
        if (r3 == null) goto L10;
        r2 = r3;
    L10:
        this.mVCFollowUUID = r2;     // Catch: Exception -> L12
    L14:
        setMAttachmentFollowVM((AttachmentFollowVM) new ViewModelProvider(getActivity()).get(this.mVCFollowUUID, AttachmentFollowVM.class));
        DriveBlockPreviewVM r4 = (DriveBlockPreviewVM) viewModel(DriveBlockPreviewVM.class);
        DriveMediaVM r5 = (DriveMediaVM) viewModel(DriveMediaVM.class);
        r5.setAutoPlay(false);
        r7.c().c(new e(this));
        r7.c.livePreviewType().observe(getLifecycleOwner(), new f(r4, this));
        DriveMediaDurationVm r0 = (DriveMediaDurationVm) new ViewModelProvider(getActivity()).get(DriveMediaDurationVm.class);
        r5.getPlayPosition().observe(getLifecycleOwner(), new g(r0, this));
        MutableLiveData<Map<String, Long>> r6 = r0.getExtraData();
        if (r6 == null) goto L17;
        r6.observe(getLifecycleOwner(), new h(r0, this, r5));
    L17:
        this.blockTitleView = new DriveBlockTitleView(getActivity());
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(-1, y9c.d.a(getContext().getResources().getDimensionPixelSize(2131166311)));
        r8.gravity = 48;
        DriveBlockTitleView r9 = this.blockTitleView;
        if (r9 == null) goto L20;
        r9.setVisibility(8);
    L20:
        DriveBlockTitleView r10 = this.blockTitleView;
        if (r10 == null) goto L23;
        r10.setLayoutParams(r8);
    L23:
        r4.setBlockTitleView(this.blockTitleView);
        r7.c.liveFileName().observe(getLifecycleOwner(), new i(this));
        r4.getEnterFullScreen().observe(getLifecycleOwner(), new j(this));
        r4.getBlockTitleViewVisibility().observe(getLifecycleOwner(), new k(this));
        getMAttachmentFollowVM().getCloseCMD().observe(getLifecycleOwner(), new l(r7, this));
        r7.registerHostAbility(this);
        return;
    L12:
        e = move-exception;
        tt5.a.f("DriveComponent", e, false);
        goto L14
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onDetachFromHost(r2);
        r2.unregisterHostAbility(this);
    }

    public final void setMAttachmentFollowVM(AttachmentFollowVM r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mAttachmentFollowVM = r2;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$handlePreviewStateAnim(DriveBlockPreviewPlugin r0, boolean r1) {
        r0.handlePreviewStateAnim(r1);
    }

    public static final /* synthetic */ void access$reportSlideEvent(DriveBlockPreviewPlugin r0, int r1) {
        r0.reportSlideEvent(r1);
    }

    public static final /* synthetic */ void access$setAnimating$p(DriveBlockPreviewPlugin r0, boolean r1) {
        r0.animating = r1;
    }

    public static final /* synthetic */ void access$setEnableSlideDown$p(DriveBlockPreviewPlugin r0, boolean r1) {
        r0.enableSlideDown = r1;
    }

    public void onAttachToUIContainer(DrivePluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super.onAttachToUIContainer(r2, r3);
        this.mainRootLayout = (DriveMainRootLayout) findViewById(2131379453);
        setBlockClickListener();
        setSlideListener();
        DriveMainRootLayout r4 = this.mainRootLayout;
        if (r4 == null) goto L5;
        r4.setInBlock(true);
    L5:
        DriveBlockTitleView r5 = this.blockTitleView;
        if (r5 == null) goto L10;
        ViewParent r6 = r5.getParent();
        if (r6 == null) goto L10;
        ((ViewGroup) r6).removeView(this.blockTitleView);
    L10:
        DriveMainRootLayout r7 = this.mainRootLayout;
        if (r7 == null) goto L13;
        r7.addView(this.blockTitleView);
    L13:
        DriveMainRootLayout r8 = this.mainRootLayout;
        if (r8 == null) goto L16;
        r8.setClipToOutline(true);
    L16:
        ViewGroup r9 = (ViewGroup) findViewById(2131370319);
        this.mainTitleBarRoot = r9;
        if (r9 == null) goto L19;
        r9.setVisibility(8);
    L19:
        View r10 = findViewById(2131379452);
        if (r10 == null) goto L23;
        r10.setBackgroundColor(getResources().getColor(2131108722));
        return;
    }

    public void onDetachFromUIContainer(DrivePluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super.onDetachFromUIContainer(r2, r3);
        cancelAnim();
        if (r2.c.isInBlockState() == true) goto L6;
        handleDetachMainLayout();
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DrivePluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DrivePluginHost) r1, r2);
    }

    private final ArrayList<ValueAnimator> startAnim(long r18, FrameLayout.LayoutParams r20, int r21, int r22, int r23, int r24, int r26, int r27, int r28, int r29, int r210, int r30, Animator.AnimatorListener r31) {
        tt5.a.h(TAG, "startAnim() called with: dur = " + r18 + ", layoutParam = " + r20 + ", startW = " + r21 + ", endW = " + r22 + ", startH = " + r23 + ", endH = " + r24 + ", startTopMargin = " + r26 + ", endTopMargin = " + r27 + ", startLeftMargin = " + r28 + ", endLeftMargin = " + r29 + ", titleHStart = " + r210 + ", titleHEnd = " + r30 + ", listener = " + r31);
        ((DriveBlockPreviewVM) viewModel(DriveBlockPreviewVM.class)).getLiveBlockState().setValue(DriveBlockPreviewVM.BlockState.ANIMATING);
        ValueAnimator r5 = ObjectAnimator.ofInt(new int[]{r21, r22});
        ValueAnimator r6 = ObjectAnimator.ofInt(new int[]{r23, r24});
        ValueAnimator r7 = ObjectAnimator.ofInt(new int[]{r26, r27});
        ValueAnimator r8 = ObjectAnimator.ofInt(new int[]{r28, r29});
        ValueAnimator r9 = ObjectAnimator.ofInt(new int[]{r210, r30});
        r5.setDuration(r18);
        r6.setDuration(r18);
        r7.setDuration(r18);
        r8.setDuration(r18);
        r9.setDuration(r18);
        ViewGroup r1 = this.mainTitleBarRoot;
        if (r1 == null) goto L5;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
    L6:
        r9.addUpdateListener(new o(r2, this));
        r7.addUpdateListener(new p(r20, this));
        r8.addUpdateListener(new q(r20, this));
        r5.addUpdateListener(new r(r20, this));
        r6.addUpdateListener(new s(r20, this));
        if (r31 == null) goto L9;
        r6.addListener(r31);
    L9:
        List r0 = CollectionsKt.listOf(new ValueAnimator[]{r9, r7, r8, r5, r6});
        if (r210 == r30) goto L12;
        r9.start();
    L12:
        r7.start();
        r8.start();
        r5.start();
        r6.start();
        return new ArrayList(r0);
    L5:
        r2 = null;
        goto L6
    }

    public static final /* synthetic */ ArrayList access$startAnim(DriveBlockPreviewPlugin r0, long r1, FrameLayout.LayoutParams r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, Animator.AnimatorListener r14) {
        return r0.startAnim(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ ArrayList startAnim$default(DriveBlockPreviewPlugin r16, long r17, FrameLayout.LayoutParams r19, int r20, int r21, int r22, int r23, int r24, int r26, int r27, int r28, int r29, int r210, Animator.AnimatorListener r30, int r31, Object r32) {
        if ((r31 & 4096) == 0) goto L5;
        Animator.AnimatorListener r18 = null;
    L7:
        return r16.startAnim(r17, r19, r20, r21, r22, r23, r24, r26, r27, r28, r29, r210, r18);
    L5:
        r18 = r30;
        goto L7
    }
}
