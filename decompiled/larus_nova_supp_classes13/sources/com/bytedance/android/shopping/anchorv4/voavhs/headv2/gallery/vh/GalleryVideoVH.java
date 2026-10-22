package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh;

import android.app.Activity;
import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.GestureDetector;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LiveData;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.host.api.player.HeaderCtrLynxPendant;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityCacheScene;
import com.bytedance.android.shopping.anchorv4.containers.GalleryViewerParams;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.base.VideoComponentScene;
import com.bytedance.android.shopping.anchorv4.video.base.BasePdVideoView;
import com.bytedance.android.shopping.anchorv4.video.base.BasePdpVideoView;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderPendantLynx;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.GalleryFromType;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.GalleryViewModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.h;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i0;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.j0;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.m;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.s;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.z0;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.VideoProgressBar;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.n;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.google.gson.JsonObject;
import j83.j;
import j83.k;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/vh/GalleryVideoVH;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionViewHolder;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/j0;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/vh/g;", "Lcom/bytedance/android/shopping/anchorv4/video/base/bridge/intf/callback/c;", "Lfj/e;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GalleryVideoVH extends TransitionViewHolder implements j0, g, com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c, fj.e {
    public static final /* synthetic */ int s = 0;
    public final x73.a a;
    public final FrameLayout b;
    public final View c;
    public final FrameLayout d;
    public final View e;
    public final View f;
    public final ECDraweeView g;
    public final View h;
    public final View i;
    public boolean j;
    public boolean k;
    public final j83.a l;
    public final a m;
    public Integer n;
    public final Lazy o;
    public final View p;
    public final l q;
    public final Function1<Integer, Unit> r;

    public static final class a extends com.bytedance.android.shopping.anchorv4.video.d {
        public final /* synthetic */ GalleryVideoVH i;
        public final /* synthetic */ String j;
        public final /* synthetic */ com.bytedance.android.shopping.anchorv4.video.f k;

        public final boolean e() {
            return GalleryVideoVH.T3(this.i).isMute();
        }

        public final Object getPlayer() {
            return GalleryVideoVH.T3(this.i).getPlayer();
        }

        public final boolean isPlaying() {
            return GalleryVideoVH.T3(this.i).isPlaying();
        }

        public final boolean g(boolean r3) {
            if (r3 == GalleryVideoVH.T3(this.i).isMute()) goto L7;
            GalleryVideoVH.T3(this.i).f(r3, false);
            this.i.l.e();
            return true;
        L7:
            return true;
        }

        public final Boolean j(Boolean r3, boolean r4) {
            if (Intrinsics.areEqual(this.j, "head_video") == false) goto L11;
            l r0 = this.i.q;
            if (r0 == null) goto L9;
            i0 r1 = r0.h;
            if (r1 == null) goto L9;
            return Boolean.valueOf(r1.m0(r3, r4));
        L9:
            return null;
        L11:
            l r5 = this.i.q;
            if (r5 == null) goto L19;
            GalleryViewModel r6 = r5.f;
            if (r6 == null) goto L19;
            Boolean r7 = r6.getVideoManualMuteState();
            if (r7 == null) goto L19;
            r4 = r7.booleanValue();
        L19:
            return Boolean.valueOf(r4);
        }

        public final void n(boolean r2, boolean r3) {
            super.n(r2, r3);
            if (r3 == true) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(this.j, "head_video") == false) goto L13;
            l r4 = this.i.q;
            if (r4 == null) goto L14;
            i0 r5 = r4.h;
            if (r5 == null) goto L15;
            r5.w0(r2);
            return;
        L15:
            return;
        L14:
            return;
        }

        public a(GalleryVideoVH r8, String r9, com.bytedance.android.shopping.anchorv4.video.f r10, String r11, com.bytedance.android.shopping.anchorv4.video.f r12) {
            this.i = r8;
            this.j = r9;
            this.k = r10;
            super(r11, r12, null, true, true, 12);
        }
    }

    public static final class b implements k {
        public final /* synthetic */ GalleryVideoVH a;

        @Override // j83.k
        public final void a() {
            boolean r0 = !GalleryVideoVH.T3(this.a).isMute();
            GalleryVideoVH.T3(this.a).f(r0, false);
            l r2 = this.a.q;
            if (r2 == null) goto L7;
            GalleryViewModel r3 = r2.f;
            if (r3 == null) goto L7;
            r3.setVideoManualMuteState(Boolean.valueOf(r0));
        L7:
            a r4 = this.a.m;
            if (r4 == null) goto L10;
            r4.n(r0, true);
        L10:
            GalleryVideoVH r1 = this.a;
            l r5 = r1.q;
            if (r5 == null) goto L16;
            m r6 = r5.g;
            if (r6 == null) goto L17;
            r6.h(r1.getAdapterPosition(), r0);
            return;
        L17:
            return;
        }

        @Override // j83.k
        public final void b() {
            GalleryVideoVH r0 = this.a;
            GalleryVideoVH.U3(r0, !GalleryVideoVH.T3(r0).isPlaying());
        }

        public b(GalleryVideoVH r1) {
            this.a = r1;
        }
    }

    public static final class c implements k73.d {
        public final /* synthetic */ GalleryVideoVH a;

        public final boolean isMuted() {
            return GalleryVideoVH.T3(this.a).isMute();
        }

        public final boolean isPlaying() {
            return GalleryVideoVH.T3(this.a).isPlaying();
        }

        public c(GalleryVideoVH r1) {
            this.a = r1;
        }
    }

    public final void B0() {
    }

    public final void P1(boolean r1) {
    }

    public final void R2() {
    }

    public final com.bytedance.android.shopping.anchorv4.video.f W3() {
        return (com.bytedance.android.shopping.anchorv4.video.f) this.o.getValue();
    }

    public final void y(boolean r1) {
    }

    public final void y3(String r1) {
    }

    public final void E3() {
        j83.a r0 = this.l;
        r0.h(null);
        r0.a.d(0.0f);
        r0.b.setVisibility(8);
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b r1 = r0.g;
        if (r1 == null) goto L5;
        r1.j0();
    L5:
        a r2 = this.m;
        if (r2 == null) goto L10;
        com.bytedance.android.shopping.anchorv4.video.f r3 = ((com.bytedance.android.shopping.anchorv4.video.d) r2).d;
        if (r3 == null) goto L10;
        com.bytedance.android.shopping.anchorv4.video.f.a.a(r3, r2, false, true, 2);
    L10:
        l r4 = this.q;
        if (r4 == null) goto L19;
        m r5 = r4.g;
        if (r5 == null) goto L20;
        int r6 = getAdapterPosition();
        x73.a r7 = this.a;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L17:
        r5.j(r6, r7.a(), true);
        return;
    L20:
        return;
    }

    public final void S() {
        j83.a r0 = this.l;
        int r1 = j83.a.u;
        r0.h(null);
        a r2 = this.m;
        if (r2 == null) goto L7;
        com.bytedance.android.shopping.anchorv4.video.f r3 = ((com.bytedance.android.shopping.anchorv4.video.d) r2).d;
        if (r3 == null) goto L7;
        com.bytedance.android.shopping.anchorv4.video.f.a.b(r3, r2, true, 2);
    L7:
        com.bytedance.android.shopping.anchorv4.video.f r4 = W3();
        if (r4 == null) goto L10;
        r4.d(true);
    L10:
        l r5 = this.q;
        if (r5 == null) goto L15;
        m r6 = r5.g;
        if (r6 == null) goto L15;
        r6.i(getAdapterPosition(), true ^ this.k);
    L15:
        this.g.setVisibility(8);
    }

    public final boolean X3() {
        l r0 = this.q;
        if (r0 == null) goto L9;
        GalleryViewModel r1 = r0.f;
        if (r1 == null) goto L9;
        LiveData<Boolean> r2 = r1.isMoreVideoExpanded();
        if (r2 == null) goto L9;
        Boolean r3 = (Boolean) r2.getValue();
    L11:
        return Intrinsics.areEqual(r3, Boolean.TRUE);
    L9:
        r3 = null;
        goto L11
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g
    public final void Y2() {
        if (this.j == false) goto L9;
        x73.a r0 = this.a;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L7:
        r0.startPlay();
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g
    public final void Z0() {
        x73.a r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L6:
        if (r0.isPlaying() == false) goto L15;
        l r1 = this.q;
        if (r1 == null) goto L15;
        m r2 = r1.g;
        if (r2 == null) goto L15;
        int r3 = getAdapterPosition();
        x73.a r4 = this.a;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L14:
        r2.j(r3, r4.a(), false);
    L15:
        x73.a r5 = this.a;
        if (r5 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L18:
        r5.release();
    }

    public final void Z2() {
        j83.a r0 = this.l;
        int r1 = j83.a.u;
        r0.h(null);
        a r2 = this.m;
        if (r2 == null) goto L7;
        com.bytedance.android.shopping.anchorv4.video.f r3 = ((com.bytedance.android.shopping.anchorv4.video.d) r2).d;
        if (r3 == null) goto L7;
        com.bytedance.android.shopping.anchorv4.video.f.a.b(r3, r2, true, 2);
    L7:
        com.bytedance.android.shopping.anchorv4.video.f r4 = W3();
        if (r4 == null) goto L10;
        r4.d(true);
    L10:
        l r5 = this.q;
        if (r5 == null) goto L15;
        m r6 = r5.g;
        if (r6 == null) goto L15;
        r6.i(getAdapterPosition(), true ^ this.k);
    L15:
        this.g.setVisibility(8);
    }

    public final void e() {
        j83.a r0 = this.l;
        r0.h(null);
        r0.a.d(0.0f);
        r0.b.setVisibility(8);
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b r1 = r0.g;
        if (r1 == null) goto L5;
        r1.j0();
    L5:
        a r2 = this.m;
        if (r2 == null) goto L10;
        com.bytedance.android.shopping.anchorv4.video.f r3 = ((com.bytedance.android.shopping.anchorv4.video.d) r2).d;
        if (r3 == null) goto L10;
        com.bytedance.android.shopping.anchorv4.video.f.a.a(r3, r2, false, true, 2);
    L10:
        l r4 = this.q;
        if (r4 == null) goto L19;
        m r5 = r4.g;
        if (r5 == null) goto L20;
        int r6 = getAdapterPosition();
        x73.a r7 = this.a;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L17:
        r5.j(r6, r7.a(), true);
        return;
    L20:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g
    public final void onViewDetachedFromWindow() {
        Function1<Integer, Unit> r0 = this.r;
        if (r0 == null) goto L5;
        Unit r1 = (Unit) r0.invoke(this.n);
    L5:
        pausePlay();
    }

    public final void pausePlay() {
        x73.a r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L5:
        r0.pausePlay();
        this.l.h(Boolean.FALSE);
    }

    public final void startPlay() {
        x73.a r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L5:
        r0.startPlay();
        l r1 = this.q;
        if (r1 == null) goto L10;
        GalleryViewModel r2 = r1.f;
        if (r2 == null) goto L10;
        r2.setCurPlayingVideoPosition(getAdapterPosition());
    L10:
        this.l.h(Boolean.TRUE);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g
    public final void t0() {
        x73.a r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L5:
        this.j = r0.isPlaying();
        l r1 = this.q;
        boolean r2 = false;
        if (r1 == null) goto L35;
        Context r3 = r1.d;
        if ((r3 instanceof Activity) == true) goto L10;
        r3 = null;
    L10:
        Activity r4 = (Activity) r3;
        if (r4 != null) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 != true) goto L35;
        int r6 = getAdapterPosition();
        Integer r7 = (Integer) this.q.f.getSelectedPosition().getValue();
        if (r7 == null) goto L35;
        if (r6 != r7.intValue()) goto L35;
        x73.a r8 = this.a;
        if (r8 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L26:
        if (r8.getSharePlayer() == null) goto L28;
        r2 = true;
        goto L35
    L28:
        z0 r9 = this.q.a;
        boolean r10 = this.j;
        x73.a r11 = this.a;
        if (r11 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L31:
        int r12 = r11.getCurrentPosition();
        x73.a r13 = this.a;
        if (r13 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L34:
        r9.b = new h(r10, r12, r13.isMute());
        goto L35
    L13:
        if (r4.isFinishing() != true) goto L15;
        r5 = true;
    L35:
        if (r2 == true) goto L38;
        pausePlay();
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.j0
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.d S3() {
        return V3();
    }

    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.d V3() {
        if (i.a() == true) goto L5;
    L9:
        boolean r0 = false;
    L10:
        if (r0 == false) goto L12;
        View r1 = this.d;
    L14:
        return new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.d(r1, true, false, false, 24);
    L12:
        r1 = this.c;
        goto L14
    L5:
        if (this.d.getChildCount() <= 0) goto L9;
        if (this.d.isShown() == false) goto L9;
        r0 = true;
        goto L10
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.j0
    public final void o0() {
        View r0 = V3().a;
        if (r0 == null) goto L5;
        r0.setAlpha(1.0f);
    L5:
        View r1 = V3().a;
        if (r1 == null) goto L9;
        r1.setVisibility(0);
        return;
    }

    public final void H() {
        Z2();
    }

    public static final /* synthetic */ x73.a T3(GalleryVideoVH r1) {
        x73.a r2 = r1.a;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L5:
        return r2;
    }

    public final void Q(float r2) {
        this.l.c(r2);
    }

    public final void Y3(int r2) {
        if (getAdapterPosition() != r2) goto L14;
        l r3 = this.q;
        if (r3 != null) goto L7;
    L13:
        startPlay();
        return;
    L7:
        if (r3.a() != true) goto L13;
        com.bytedance.android.shopping.anchorv4.video.f r4 = W3();
        if (r4 != null) goto L11;
        return;
    L11:
        if (r4.i() != true) goto L20;
        startPlay();
        return;
    L20:
        return;
    L14:
        Function1<Integer, Unit> r5 = this.r;
        if (r5 == null) goto L17;
        Unit r6 = (Unit) r5.invoke(this.n);
    L17:
        pausePlay();
    }

    public final void Z3(boolean r4) {
        l r0 = this.q;
        if (r0 == null) goto L14;
        float r2 = 0.0f;
        if (X3() == false) goto L10;
        Integer r1 = (Integer) r0.f.getMoreVideoHeight().getValue();
        if (r1 == null) goto L9;
        r2 = r1.intValue();
    L9:
        r2 = -r2;
    L10:
        if (r4 == false) goto L12;
        this.e.animate().translationY(r2).setDuration(300).start();
        return;
    L12:
        this.e.animate().cancel();
        this.e.setTranslationY(r2);
        return;
    }

    public final void b(float r2) {
        this.l.c(r2);
    }

    public final void i2(boolean r5) {
        if (r5 == false) goto L18;
        j83.a r6 = this.l;
        int r3 = j83.a.u;
        r6.h(null);
        a r7 = this.m;
        if (r7 == null) goto L9;
        com.bytedance.android.shopping.anchorv4.video.f r1 = ((com.bytedance.android.shopping.anchorv4.video.d) r7).d;
        if (r1 == null) goto L9;
        com.bytedance.android.shopping.anchorv4.video.f.a.b(r1, r7, true, 2);
    L9:
        com.bytedance.android.shopping.anchorv4.video.f r8 = W3();
        if (r8 == null) goto L12;
        r8.d(true);
    L12:
        l r9 = this.q;
        if (r9 == null) goto L17;
        m r10 = r9.g;
        if (r10 == null) goto L17;
        r10.i(getAdapterPosition(), !this.k);
    L17:
        this.g.setVisibility(8);
        return;
    L18:
        j83.a r11 = this.l;
        int r4 = j83.a.u;
        r11.h(null);
        a r12 = this.m;
        if (r12 == null) goto L23;
        com.bytedance.android.shopping.anchorv4.video.f r13 = ((com.bytedance.android.shopping.anchorv4.video.d) r12).d;
        if (r13 == null) goto L23;
        com.bytedance.android.shopping.anchorv4.video.f.a.a(r13, r12, false, true, 2);
    L23:
        l r14 = this.q;
        if (r14 == null) goto L33;
        m r15 = r14.g;
        if (r15 == null) goto L34;
        int r0 = getAdapterPosition();
        x73.a r2 = this.a;
        if (r2 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L30:
        r15.j(r0, r2.a(), false);
        return;
    L34:
        return;
    }

    public final void m3(boolean r5) {
        j83.a r6 = this.l;
        int r0 = j83.a.u;
        r6.h(null);
        a r7 = this.m;
        if (r7 == null) goto L7;
        com.bytedance.android.shopping.anchorv4.video.f r1 = ((com.bytedance.android.shopping.anchorv4.video.d) r7).d;
        if (r1 == null) goto L7;
        com.bytedance.android.shopping.anchorv4.video.f.a.a(r1, r7, false, true, 2);
    L7:
        l r8 = this.q;
        if (r8 == null) goto L16;
        m r9 = r8.g;
        if (r9 == null) goto L17;
        int r2 = getAdapterPosition();
        x73.a r3 = this.a;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L14:
        r9.j(r2, r3.a(), false);
        return;
    L17:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g
    public final void onPageSelected(int r1) {
        Y3(r1);
    }

    public static final void U3(GalleryVideoVH r7, boolean r8) {
        if (r8 == false) goto L5;
        r7.k = true;
        r7.startPlay();
    L12:
        l r0 = r7.q;
        if (r0 == null) goto L22;
        m r1 = r0.g;
        if (r1 == null) goto L23;
        Map<String, Object> r3 = r1.b(r7.getAdapterPosition());
        if (r8 == false) goto L19;
        String r9 = "play";
    L20:
        r3.put("click_type", r9);
        Unit r10 = Unit.INSTANCE;
        m.d(r1, "pd_video_pause_click", r3, null, null, 60);
        return;
    L19:
        r9 = "pause";
        goto L20
    L23:
        return;
    L22:
        return;
    L5:
        r7.pausePlay();
        l r2 = r7.q;
        if (r2 == null) goto L12;
        if (r2.a() != true) goto L12;
        com.bytedance.android.shopping.anchorv4.video.f r4 = r7.W3();
        if (r4 == null) goto L12;
        r4.d(false);
        goto L12
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g
    public final void I3(int r31, com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b r32) {
        this.n = Integer.valueOf(r31);
        n r4 = null;
        if (r32 == null) goto L65;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r6 = r32.getPlayInfo();
        if (r6 == null) goto L65;
        x73.a r7 = this.a;
        if (r7 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L9:
        r7.i(r6, new com.bytedance.android.shopping.api.video.d(false, false, 0, 0, false, 511), r32.getSharePlayer());
        x73.a r8 = this.a;
        if (r8 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L12:
        a r9 = this.m;
        if (r9 == null) goto L19;
        com.bytedance.android.shopping.anchorv4.video.f r10 = ((com.bytedance.android.shopping.anchorv4.video.d) r9).d;
        if (r10 == null) goto L19;
        if (r10.h(r9) != true) goto L19;
        boolean r11 = true;
    L20:
        r8.f(r11, false);
        l r12 = this.q;
        if (r12 == null) goto L28;
        z0 r13 = r12.a;
        if (r13 == null) goto L28;
        SparseBooleanArray r14 = r13.a;
        if (r14 == null) goto L28;
        if (r14.get(r31) != true) goto L28;
    L48:
        j83.a r15 = this.l;
        r15.i = (int) (r6.a() / ((long) 1000));
        r15.l = Integer.valueOf(r31);
        r15.e();
        r15.h(null);
        r15.g();
        r15.f();
        GenericDraweeHierarchy r16 = this.g.getHierarchy();
        if (r16 == null) goto L51;
        r16.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
    L51:
        y.d(this.g, r6.f());
        x73.a r17 = this.a;
        if (r17 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L55:
        if (r17.isPlaying() == true) goto L63;
        x73.a r18 = this.a;
        if (r18 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L60:
        if (r18.getCurrentPosition() > 0) goto L63;
        this.g.setVisibility(0);
    L63:
        this.g.setVisibility(8);
    L28:
        l r19 = this.q;
        if (r19 == null) goto L35;
        z0 r20 = r19.a;
        if (r20 == null) goto L35;
        SparseBooleanArray r21 = r20.a;
        if (r21 == null) goto L35;
        r21.put(r31, true);
    L35:
        x73.a r22 = this.a;
        if (r22 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L39:
        if (r22.getSharePlayer() != null) goto L48;
        Integer r23 = r32.a();
        if (r23 == null) goto L48;
        int r24 = r23.intValue();
        if (r6.a() <= 0) goto L48;
        x73.a r25 = this.a;
        if (r25 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L47:
        r25.seek(r24 / r6.a());
    L19:
        r11 = false;
    L65:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L73;
        x73.a r26 = this.a;
        if (r26 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L69:
        r26.g(this);
        x73.a r27 = this.a;
        if (r27 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L72:
        r27.c(this);
    L80:
        Z3(false);
        l r5 = this.q;
        if (r5 == null) goto L92;
        GalleryViewModel r28 = r5.f;
        if (r28 == null) goto L92;
        if (r28.isFirstBind() != true) goto L92;
        this.q.f.setFirstBind(false);
        GalleryViewerParams r29 = this.q.j;
        if (r29 == null) goto L92;
        if (r29.getGalleryIndex() != r31) goto L92;
        Y3(r31);
    L92:
        if (i.a() == false) goto L179;
        Integer r1 = this.n;
        if (r1 == null) goto L107;
        int r2 = r1.intValue();
        l r30 = this.q;
        if (r30 == null) goto L104;
        GalleryViewModel r33 = r30.f;
        if (r33 == null) goto L104;
        LiveData<List<s>> r34 = r33.getFullThumbList();
        if (r34 == null) goto L104;
        List r35 = (List) r34.getValue();
        if (r35 == null) goto L104;
        s r3 = (s) CollectionsKt.getOrNull(r35, r2);
    L105:
        if (r3 == null) goto L107;
        boolean r36 = true;
    L108:
        String r37 = "1";
        if (r36 == false) goto L111;
        Object r38 = "1";
    L112:
        l r39 = this.q;
        if (r39 == null) goto L119;
        GalleryViewModel r40 = r39.f;
        if (r40 == null) goto L119;
        LiveData<Boolean> r41 = r40.isMoreVideoExpanded();
        if (r41 == null) goto L119;
        Boolean r42 = (Boolean) r41.getValue();
    L121:
        if (Intrinsics.areEqual(r42, Boolean.TRUE) == true) goto L124;
        r37 = "0";
    L124:
        j83.a r43 = this.l;
        l r44 = this.q;
        if (r44 == null) goto L129;
        i0 r45 = r44.h;
        if (r45 == null) goto L129;
        String r46 = r45.getSessionId();
    L130:
        if (r32 == null) goto L134;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r47 = r32.getPlayInfo();
        if (r47 == null) goto L134;
        String r48 = r47.j();
    L136:
        if (r32 == null) goto L140;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r49 = r32.getPlayInfo();
        if (r49 == null) goto L140;
        fj.f r50 = r49.d;
    L141:
        if (r50 == null) goto L167;
        HeaderCtrLynxPendant r110 = r50.b();
        if (r110 == null) goto L146;
        String r111 = r110.getLynxId();
    L147:
        HeaderCtrLynxPendant r112 = r50.b();
        if (r112 == null) goto L150;
        String r113 = r112.getLynxUrl();
    L151:
        HeaderCtrLynxPendant r114 = r50.b();
        if (r114 == null) goto L154;
        JsonObject r115 = r114.getLynxData();
    L155:
        HeaderPendantLynx r116 = new HeaderPendantLynx(r111, r113, r115, null, 8, null);
        HeaderCtrLynxPendant r117 = r50.a();
        if (r117 == null) goto L158;
        String r210 = r117.getLynxId();
    L159:
        HeaderCtrLynxPendant r118 = r50.a();
        if (r118 == null) goto L162;
        String r211 = r118.getLynxUrl();
    L163:
        HeaderCtrLynxPendant r51 = r50.a();
        if (r51 == null) goto L166;
        r4 = r51.getLynxData();
    L166:
        r4 = new n(r116, new HeaderPendantLynx(r210, r211, r4, null, 8, null));
        goto L167
    L162:
        r211 = null;
        goto L163
    L158:
        r210 = null;
        goto L159
    L154:
        r115 = null;
        goto L155
    L150:
        r113 = null;
        goto L151
    L146:
        r111 = null;
    L167:
        k73.b r119 = new k73.b(r46, r48, 0, r4, VideoComponentScene.HEAD_VIDEO_GALLERY.getScene(), MapsKt.mapOf(new Pair[]{TuplesKt.to("should_show_fold_icon", r38), TuplesKt.to("video_list_fold_status", r37), TuplesKt.to("video_list_height", "64")}), new c(this), false, 132);
        r43.getClass();
        Intrinsics.checkNotNullParameter(r119, "videoComponentInfo");
        dm.a.a("GalleryVideoVH").i("initVideoCtrlContainerComponent videoComponentInfo=" + r119);
        l r52 = r43.r;
        if (r52 == null) goto L180;
        Context r53 = r52.getContext();
        if (r53 != null) goto L173;
        return;
    L173:
        if (r43.g != null) goto L175;
        r43.g = new com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b(r53, r43.s, r119, new j83.c(r43));
    L175:
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b r54 = r43.g;
        if (r54 == null) goto L181;
        r54.i0(r119);
        return;
    L181:
        return;
    L180:
        return;
    L140:
        r50 = null;
    L134:
        r48 = null;
    L129:
        r46 = null;
    L119:
        r42 = null;
        goto L121
    L111:
        r38 = "0";
    L104:
        r3 = null;
    L107:
        r36 = false;
        goto L108
    L179:
        return;
    L73:
        x73.a r55 = this.a;
        if (r55 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L76:
        r55.j(this);
        x73.a r56 = this.a;
        if (r56 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L79:
        r56.l(this);
        goto L80
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GalleryVideoVH(View r28, l r29, Function1<? super Integer, Unit> r30) {
        Intrinsics.checkNotNullParameter(r28, "itemView");
        super(r28);
        this.p = r28;
        this.q = r29;
        this.r = r30;
        FrameLayout r0 = (FrameLayout) r28.findViewById(2131392283);
        this.b = r0;
        View r14 = r28.findViewById(2131377673);
        this.c = r14;
        FrameLayout r13 = (FrameLayout) r28.findViewById(2131392332);
        this.d = r13;
        View r9 = r28.findViewById(2131377672);
        this.e = r9;
        View r11 = r28.findViewById(2131364879);
        this.f = r11;
        this.g = r28.findViewById(2131376720);
        View r12 = r28.findViewById(2131377537);
        this.h = r12;
        View r10 = r28.findViewById(2131392472);
        this.i = r10;
        this.o = LazyKt.lazy(new GalleryVideoVH$pdpPlayStateManager$2(this));
        a r5 = null;
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L8;
        if (r29 == null) goto L12;
        Context r1 = r29.getContext();
        if (r1 == null) goto L12;
        BasePdpVideoView r2 = new BasePdpVideoView(r1, null, 6, 0);
    L13:
        r0.addView(r2, -1, -1);
        if (r2 == null) goto L16;
        this.a = r2;
    L16:
        com.bytedance.android.shopping.anchorv4.video.f r16 = W3();
        if (r29 != null) goto L19;
    L21:
        String r3 = "gallery";
    L22:
        String r17 = r3;
        if (r16 != null) goto L25;
        int r7 = 1;
    L26:
        this.m = r5;
        x73.a r4 = this.a;
        if (r4 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L29:
        j83.a r6 = new j83.a(r9, r4, r11, r12, r10, r29, r13, new b(this));
        this.l = r6;
        if (r29 == null) goto L35;
        Context r8 = r29.getContext();
        if (r8 == null) goto L35;
        r14.setOnTouchListener(new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.a(new GestureDetector(r8, new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.b(this))));
    L35:
        r6.m.setOnTouchListener(new j83.f(r6));
        r6.c.setOnClickListener(new j83.i(r6));
        r6.f();
        l r15 = r6.r;
        if (r15 == null) goto L38;
        r15.f.isMoreVideoExpanded().observe(r15.e, new j83.h(r6));
    L38:
        r6.g();
        l r18 = r6.r;
        if (r18 == null) goto L43;
        m r19 = r18.g;
        if (r19 == null) goto L43;
        Pair[] r20 = new Pair[r7];
        r20[0] = TuplesKt.to("is_show", Integer.valueOf(r6.b() ? 1 : 0));
        m.d(r19, "pdp_module_show", MapsKt.hashMapOf(r20), "more_video_button_show", "a1.b34986.c503191.d90177", 4);
    L43:
        VideoProgressBar.a(r6.a, new j(r6), true, Float.valueOf(q.a(4)), Integer.valueOf(com.bytedance.android.shopping.extensions.b.a(60)), 0, 0, 104);
        r6.d.setOnClickListener(new j83.d(r6));
        r6.e.setOnClickListener(new j83.e(r6));
        if (r6.d() == true) goto L52;
        r6.f.a();
        l r21 = r6.r;
        if (r21 == null) goto L50;
        Context r22 = r21.getContext();
        if (r22 == null) goto L50;
        GalleryFromType r23 = null;
        r6.f.b(r22, null, null);
    L51:
        ViewExtensionsKt.g(r6.p, 16.0f, 16.0f, 16.0f, 16.0f);
        r6.p.setBackgroundColor((int) 3658881059L);
    L53:
        r6.q.setBackground(new j83.g());
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L68;
        x73.a r24 = this.a;
        if (r24 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L58:
        AVScene r25 = AVScene.CONTENT_PRODUCT_DETAIL_GALLERY;
        a83.a r26 = new a83.a();
        if (r29 == null) goto L64;
        i0 r27 = r29.h;
        if (r27 == null) goto L64;
        r23 = r27.c();
    L64:
        if (r23 != GalleryFromType.MoreVideo) goto L66;
        PlayAbilityCacheScene r31 = PlayAbilityCacheScene.SCENE_MORE_VIDEO;
    L67:
        r24.k(r25, false, r26, r31);
    L72:
        if (r29 == null) goto L74;
        r29.f.getMoreVideoHeight().observe(r29.e, new d(this));
        r29.f.isMoreVideoExpanded().observe(r29.e, new e(this));
        r29.f.getBottomBarHeight().observe(r29.e, new f(this));
    L74:
        r28.addOnAttachStateChangeListener(new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.c(this));
        return;
    L66:
        r31 = PlayAbilityCacheScene.SCENE_GALLERY_VIDEO;
        goto L67
    L68:
        x73.a r32 = this.a;
        if (r32 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
    L71:
        r32.h(AVScene.CONTENT_PRODUCT_DETAIL_GALLERY, false);
    L50:
        r23 = null;
        goto L51
    L52:
        r23 = null;
        goto L53
    L25:
        r7 = 1;
        r5 = new a(this, r17, r16, r17, r16);
        goto L26
    L19:
        if (r29.a() != true) goto L21;
        r3 = "head_video";
    L12:
        r2 = null;
        goto L13
    L8:
        if (r29 == null) goto L12;
        Context r33 = r29.getContext();
        if (r33 == null) goto L12;
        r2 = new BasePdVideoView(r33, null);
        goto L13
    }
}
