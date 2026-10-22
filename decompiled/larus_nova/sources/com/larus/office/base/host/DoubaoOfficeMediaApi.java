package com.larus.office.base.host;

import android.os.Bundle;
import android.os.Handler;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.camera.api.IFlowCamera;
import com.larus.platform.AlbumHelper;
import com.larus.platform.model.album.AlbumSelectItem;
import com.larus.platform.model.album.AlbumSettingConfig;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes29.dex */
public final class DoubaoOfficeMediaApi implements itb.e {

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0006\u0010\u0016\u001a\u00020\u0013J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\u0016\u0010\u001b\u001a\u00020\u00132\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u0013H\u0002J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u0013H\u0002J\u000e\u0010#\u001a\u0004\u0018\u00010\u001e*\u00020$H\u0002J\b\u0010%\u001a\u00020\u0013H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/office/base/host/DoubaoOfficeMediaApi$MediaBridgeFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "albumHelper", "Lcom/larus/platform/AlbumHelper;", "getAlbumHelper", "()Lcom/larus/platform/AlbumHelper;", "albumHelper$delegate", "Lkotlin/Lazy;", "mode", "", "config", "Lcom/ss/android/lark/officesdk/common/api/MediaPickConfig;", "callback", "Lcom/ss/android/lark/officesdk/common/api/MediaPickCallback;", "hasDelivered", "", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", EventVerify.TYPE_LAUNCH, "registerCameraResult", "registerAlbumResult", "startCamera", "startAlbum", "finishWithSuccess", "paths", "", "", "finishWithCancel", "finishWithError", "msg", "detachSelf", "toLocalPath", "Landroid/net/Uri;", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MediaBridgeFragment extends Fragment {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static itb.f f360515i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static itb.g f360516j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static int f360517k;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Lazy f360518d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f360519e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public itb.g f360520f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public itb.f f360521g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f360522h;

        public static final class a {
        }

        static {
        }

        public final void S90() {
            this.f360521g = null;
            FragmentActivity r100 = getActivity();
            if (r100 != null) goto L6;
            return;
        L6:
            if (r100.isFinishing() == false) goto L8;
            return;
        L8:
            if (r100.isDestroyed() == true) goto L22;
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L12
            Object r102 = Result.m9449constructorimpl(Integer.valueOf(r100.getSupportFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss()));     // Catch: Throwable -> L12
        L14:
            Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
            if (r103 == null) goto L21;
            FLogger.f375446a.w("DoubaoOfficeMediaApi", "detachSelf fail: " + r103.getMessage());
            return;
        L21:
            return;
        L12:
            th = move-exception;
            Result.Companion r104 = Result.Companion;
            r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L14
        }

        public final void T90() {
            if (this.f360522h == false) goto L5;
            return;
        L5:
            this.f360522h = true;
            itb.f r100 = this.f360521g;
            if (r100 == null) goto L8;
            r100.onCancel();
        L8:
            S90();
        }

        @Override // androidx.fragment.app.Fragment
        public final void onDestroy() {
            if (this.f360522h == true) goto L8;
            this.f360522h = true;
            itb.f r100 = this.f360521g;
            if (r100 == null) goto L7;
            r100.onCancel();
        L7:
            this.f360521g = null;
        L8:
            super.onDestroy();
        }

        public MediaBridgeFragment() {
            this.f360518d = LazyKt.lazy(new d());
            this.f360520f = new itb.g(0, false, false, false, 127);
        }

        public final void U90(String r100) {
            if (this.f360522h == false) goto L5;
            return;
        L5:
            this.f360522h = true;
            itb.f r101 = this.f360521g;
            if (r101 == null) goto L8;
            r101.onError(r100);
        L8:
            S90();
        }

        public final void V90(List<String> r100) {
            if (this.f360522h == false) goto L5;
            return;
        L5:
            this.f360522h = true;
            itb.f r101 = this.f360521g;
            if (r101 == null) goto L8;
            r101.onSuccess(r100);
        L8:
            S90();
        }

        @Override // androidx.fragment.app.Fragment
        public final void onCreate(Bundle r100) {
            super.onCreate(r100);
            this.f360519e = f360517k;
            itb.g r101 = f360516j;
            if (r101 != null) goto L5;
            r101 = new itb.g(0, false, false, false, 127);
        L5:
            this.f360520f = r101;
            this.f360521g = f360515i;
            f360515i = null;
            f360516j = null;
            IFlowCamera r102 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
            if (r102 == null) goto L8;
            r102.m(this, new b(this), new c(this));
        L8:
            AlbumHelper r103 = (AlbumHelper) this.f360518d.getValue();
            Function1<? super AlbumSelectItem, Unit> r104 = new e(this);
            Lazy<Handler> r105 = AlbumHelper.f364726e;
            r103.b(this, "album_helper", r104);
            ((AlbumHelper) this.f360518d.getValue()).d(this, "album_helper", new DoubaoOfficeMediaApi$MediaBridgeFragment$registerAlbumResult$2(this), new f(this));
        }
    }

    public static final class a {
    }

    static {
    }

    public DoubaoOfficeMediaApi() {
    }

    public static void X0(FragmentActivity r310, final MediaBridgeFragment r311) {
        String r100 = "office_media_bridge_" + UUID.randomUUID();
        FragmentTransaction r101 = r310.getSupportFragmentManager().beginTransaction();
        boolean r102 = false;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r101, r311, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r100, 0) == true) goto L6;
        r101 = r101.add(r311, r100);
    L6:
        r101.commitNowAllowingStateLoss();
        int r103 = r311.f360519e;
        if (r103 == 0) goto L14;
        if (r103 == 1) goto L10;
        r311.U90("unknown mode");
        return;
    L10:
        IFlowCamera r104 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r104 != null) goto L13;
        r311.U90("IFlowCamera service not found");
        return;
    L13:
        r104.r(r311, new hx8.a("doc", "CAPTURE_MODE_PHOTO", null, null, null, null, null, null, null, null, false, false, false, null, false, 0, false, null, null, false, 0, null, false, false, false, null, null, null, null, 1073738744), null);
        return;
    L14:
        AlbumSettingConfig.a r105 = new AlbumSettingConfig.a();
        r105.f365518d = RangesKt.coerceAtLeast(r311.f360520f.f495756a, 1);
        int r106 = r311.f360520f.f495756a;
        if (r106 <= 1) goto L17;
        boolean r107 = true;
    L18:
        r105.f365517c = r107;
        if (r106 > 1) goto L21;
        r102 = true;
    L21:
        r105.f365519e = r102;
        r105.f365522h = 4;
        AlbumHelper.f((AlbumHelper) r311.f360518d.getValue(), r311, r105.a(), new g(), new h(r311), null, null, 0, null, null, null, null, null, 3072);
        return;
    L17:
        r107 = false;
        goto L18
    }

    @Override // itb.e
    public final boolean M0(FragmentActivity r100, itb.g r101, itb.f r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        itb.f r104 = MediaBridgeFragment.f360515i;     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter(r101, "config");     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter(r102, "callback");     // Catch: Throwable -> L5
        MediaBridgeFragment.f360517k = 1;     // Catch: Throwable -> L5
        MediaBridgeFragment.f360516j = r101;     // Catch: Throwable -> L5
        MediaBridgeFragment.f360515i = r102;     // Catch: Throwable -> L5
        X0(r100, new MediaBridgeFragment());     // Catch: Throwable -> L5
        Object r105 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L5
    L7:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L15;
        FLogger.f375446a.e("DoubaoOfficeMediaApi", "takeByCamera failed: " + r106.getMessage(), r106);
        String r107 = r106.getMessage();
        if (r107 != null) goto L13;
        r107 = "takeByCamera failed";
    L13:
        r102.onError(r107);
        r105 = Boolean.FALSE;
    L15:
        return ((Boolean) r105).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // itb.e
    public final boolean f0(FragmentActivity r100, itb.g r101, itb.f r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        itb.f r104 = MediaBridgeFragment.f360515i;     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter(r101, "config");     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter(r102, "callback");     // Catch: Throwable -> L5
        MediaBridgeFragment.f360517k = 0;     // Catch: Throwable -> L5
        MediaBridgeFragment.f360516j = r101;     // Catch: Throwable -> L5
        MediaBridgeFragment.f360515i = r102;     // Catch: Throwable -> L5
        X0(r100, new MediaBridgeFragment());     // Catch: Throwable -> L5
        Object r105 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L5
    L7:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L15;
        FLogger.f375446a.e("DoubaoOfficeMediaApi", "pickFromAlbum failed: " + r106.getMessage(), r106);
        String r107 = r106.getMessage();
        if (r107 != null) goto L13;
        r107 = "pickFromAlbum failed";
    L13:
        r102.onError(r107);
        r105 = Boolean.FALSE;
    L15:
        return ((Boolean) r105).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
