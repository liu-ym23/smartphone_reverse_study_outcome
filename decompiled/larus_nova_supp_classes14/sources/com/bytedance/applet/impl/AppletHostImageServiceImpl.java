package com.bytedance.applet.impl;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ai.bridge.service.ChooseImageCallback;
import com.bytedance.ai.bridge.service.ChooseImageRequest;
import com.bytedance.ai.bridge.service.IHostImageDepend;
import com.bytedance.ai.bridge.service.PreviewImageCallback;
import com.bytedance.ai.bridge.service.PreviewImageRequest;
import com.bytedance.ai.bridge.service.SaveImageCallback;
import com.bytedance.ai.bridge.service.SaveImageToPhotosAlbumRequest;
import com.larus.bmhome.bigimg.BigImagePhotoViewerDialog;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.camera.api.IFlowCamera;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.g3;
import com.larus.platform.model.album.AlbumSettingConfig;
import com.larus.platform.service.k2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AppletHostImageServiceImpl implements IHostImageDepend {

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.applet.impl.AppletHostImageServiceImpl$previewImage$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.applet.impl.AppletHostImageServiceImpl$previewImage$1", f = "AppletHostImageServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PreviewImageCallback $callback;
        final /* synthetic */ Context $context;
        final /* synthetic */ int $currentIndex;
        final /* synthetic */ PreviewImageRequest $request;
        final /* synthetic */ List<String> $urls;
        int label;

        public AnonymousClass1(Context r1, List<String> r2, PreviewImageRequest r3, int r4, PreviewImageCallback r5, Continuation<? super AnonymousClass1> r6) {
            this.$context = r1;
            this.$urls = r2;
            this.$request = r3;
            this.$currentIndex = r4;
            this.$callback = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass1(this.$context, this.$urls, this.$request, this.$currentIndex, this.$callback, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r19) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L15;
            ResultKt.throwOnFailure(r19);
            Context r3 = this.$context;
            List<String> r1 = this.$urls;
            ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
            Iterator<T> r2 = r1.iterator();
        L6:
            if (r2.hasNext() == false) goto L8;
            String r5 = (String) r2.next();
            r4.add(new com.larus.bmhome.bigimg.n1(r5, r5));
            goto L6
        L8:
            boolean r7 = true;
            uo8.k r6 = new uo8.k(MapsKt.mapOf(new Pair[]{TuplesKt.to("user_type", "jsb"), TuplesKt.to("enter_picture_method", "jsb"), TuplesKt.to("enter_from", "applet")}), null);
            if (this.$urls.size() > 1) goto L12;
            r7 = false;
        L12:
            com.larus.bmhome.bigimg.k.e(new BigImagePhotoViewerDialog(r3, r4, null, r6, r7, null, null, null, null, null, null, this.$request.getShowmenu(), this.$request.getShowmenu(), this.$request.getShowmenu(), 4064), this.$currentIndex);
            this.$callback.onSuccess();
            return Unit.INSTANCE;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public AppletHostImageServiceImpl() {
    }

    public final void chooseImage(ChooseImageRequest r9, ChooseImageCallback r10) {
        Intrinsics.checkNotNullParameter(r9, "request");
        Intrinsics.checkNotNullParameter(r10, "callback");
        FragmentActivity r1 = r9.getBridgeContext().getOwnerActivity();
        FragmentActivity r3 = null;
        if ((r1 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r2 = r1;
    L6:
        if (r2 != null) goto L10;
        FragmentActivity r4 = AppHost.a.a().getCurrentActivity();
        if ((r4 instanceof FragmentActivity) == false) goto L11;
        r3 = r4;
    L11:
        if (r3 != null) goto L13;
    L42:
        r10.onFail("no valid activity");
        return;
    L13:
        if (r3.isFinishing() == true) goto L42;
        if (r3.isDestroyed() == true) goto L42;
        List r5 = r9.getSourceType();
        boolean r6 = true;
        if (r5.contains("camera") == true) goto L20;
    L22:
        boolean r7 = false;
    L24:
        if (r5.contains("album") == true) goto L26;
    L28:
        r6 = false;
    L29:
        if (r7 == false) goto L38;
        IFlowCamera r11 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r11 != null) goto L33;
        FLogger.a.w("AppletHostImageServiceImpl", "IFlowCamera service not available");
        r10.onFail("camera service not available");
        return;
    L33:
        ChooseImageCallback r8 = CameraCallbackFragment.f;
        Intrinsics.checkNotNullParameter(r10, "callback");
        Intrinsics.checkNotNullParameter(r11, "camera");
        CameraCallbackFragment.f = r10;
        CameraCallbackFragment.g = r11;
        CameraCallbackFragment r12 = new CameraCallbackFragment();
        FragmentTransaction r13 = r3.getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r13, r12, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "camera_callback_fragment", 0) == true) goto L37;
        r13 = r13.add(r12, "camera_callback_fragment");
    L37:
        r13.commitAllowingStateLoss();
        r3.getSupportFragmentManager().executePendingTransactions();
        return;
    L38:
        if (r6 == false) goto L40;
        a(r3, r9.getCount(), r10);
        return;
    L40:
        a(r3, r9.getCount(), r10);
        return;
    L26:
        if (r5.contains("camera") == true) goto L28;
    L20:
        if (r5.contains("album") == true) goto L22;
        r7 = true;
        goto L24
    L10:
        r3 = r2;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public final void previewImage(PreviewImageRequest r13, PreviewImageCallback r14) {
        Intrinsics.checkNotNullParameter(r13, "request");
        Intrinsics.checkNotNullParameter(r14, "callback");
        List r3 = r13.getUrls();
        if (r3.isEmpty() == false) goto L6;
        r14.onFail("urls is empty");
        return;
    L6:
        FragmentActivity r0 = r13.getBridgeContext().getOwnerActivity();
        FragmentActivity r2 = null;
        if ((r0 instanceof FragmentActivity) == false) goto L9;
        FragmentActivity r1 = r0;
    L10:
        if (r1 != null) goto L14;
        FragmentActivity r4 = AppHost.a.a().getCurrentActivity();
        if ((r4 instanceof FragmentActivity) == false) goto L15;
        r1 = r4;
    L15:
        if (r2 != null) goto L17;
    L27:
        r14.onFail("no valid activity");
        return;
    L17:
        if (r2.isFinishing() == true) goto L27;
        if (r2.isDestroyed() == true) goto L27;
        if (r13.getCurrent() == null) goto L24;
        int r5 = RangesKt.coerceAtLeast(CollectionsKt.indexOf(r3, r13.getCurrent()), 0);
    L25:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(r2, r3, r13, r5, r14, null), 3, null);
        return;
    L24:
        r5 = 0;
    L14:
        r2 = r1;
        goto L15
    L9:
        r1 = null;
        goto L10
    }

    public final void saveImageToPhotosAlbum(SaveImageToPhotosAlbumRequest r9, final SaveImageCallback r10) {
        Intrinsics.checkNotNullParameter(r9, "request");
        Intrinsics.checkNotNullParameter(r10, "callback");
        String r2 = r9.getFilePath();
        if (StringsKt.isBlank(r2) == false) goto L6;
        r10.onFail("filePath is empty");
        return;
    L6:
        Application r11 = AppHost.a.getApplication();
        if (StringsKt.startsWith$default(r2, "http://", false, 2, null) == false) goto L9;
    L12:
        ImageSave.x(ImageSave.a, r2, null, new n(r10), null, false, 58);
        return;
    L9:
        if (StringsKt.startsWith$default(r2, "https://", false, 2, null) == true) goto L12;
        ImageSave.s(ImageSave.a, r11, r2, new o(r10));
    }

    public static void a(FragmentActivity r6, int r7, ChooseImageCallback r8) {
        AlbumSettingConfig.a r0 = new AlbumSettingConfig.a();
        boolean r1 = false;
        if (r7 <= 1) goto L5;
        boolean r3 = true;
    L6:
        r0.c = r3;
        r0.d = r7;
        r0.y = true;
        AlbumSettingConfig r2 = r0.a();
        ChooseImageCallback r4 = PhotoPickerResultFragment.g;
        Intrinsics.checkNotNullParameter(r8, "callback");
        PhotoPickerResultFragment.g = r8;
        PhotoPickerResultFragment r9 = new PhotoPickerResultFragment();
        Bundle r5 = new Bundle();
        r5.putInt("max_count", r7);
        r9.setArguments(r5);
        FragmentTransaction r10 = r6.getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r10, r9, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "photo_picker_result_fragment", 0) == true) goto L10;
        r10 = r10.add(r9, "photo_picker_result_fragment");
    L10:
        r10.commitAllowingStateLoss();
        r6.getSupportFragmentManager().executePendingTransactions();
        k2 r11 = k2.a;
        g3 r12 = k2.A();
        if (r12 == null) goto L13;
        r12.h(r6, r9.f, r2);
        return;
    L13:
        FLogger.a.w("AppletHostImageServiceImpl", "PhotoPicker service not available, fallback to system picker");
        Intent r13 = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        r13.setType("image/*");
        if (r7 <= 1) goto L16;
        r1 = true;
    L16:
        r13.putExtra("android.intent.extra.ALLOW_MULTIPLE", r1);
        ActivityResultLauncher<Intent> r14 = r9.f;
        if (r14 == null) goto L21;
        r14.launch(r13);
        return;
    L21:
        return;
    L5:
        r3 = false;
        goto L6
    }
}
