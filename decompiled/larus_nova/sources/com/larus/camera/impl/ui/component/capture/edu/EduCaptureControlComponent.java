package com.larus.camera.impl.ui.component.capture.edu;

import android.content.Context;
import android.net.Uri;
import com.baidu.platform.comapi.map.MapController;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.impl.ui.component.capture.CaptureControlComponent;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.album.AlbumSelectItem;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005H\u0014J\b\u0010\r\u001a\u00020\nH\u0014J&\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00052\u0006\u0010\u0012\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0013R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/larus/camera/impl/ui/component/capture/edu/EduCaptureControlComponent;", "Lcom/larus/camera/impl/ui/component/capture/CaptureControlComponent;", "<init>", "()V", "supportedCaptureMode", "", "", "getSupportedCaptureMode", "()Ljava/util/List;", "onHandlePictureSelected", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/platform/model/album/AlbumSelectItem;", "onHandleCapture", "interceptResultPageOpen", "", "outputParamList", "Lcom/larus/camera/api/params/OutputParam;", "isFromAlbum", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EduCaptureControlComponent extends CaptureControlComponent {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List<String> f321894v;

    @Override // com.larus.camera.impl.ui.component.capture.CaptureControlComponent
    public final void y() {
        FLogger.f375446a.i(CameraCaptureViewModel.TAG, "call onHandleCapture");
        CameraCaptureViewModel r100 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r100 != null) goto L5;
        return;
    L5:
        CameraCaptureViewModel.capturePhoto$default(r100, getContext(), !com.larus.camera.impl.utils.k.a(), new EduCaptureControlComponent$onHandleCapture$1(this), null, 8, null);
    }

    public EduCaptureControlComponent() {
        List<String> r100 = fx8.a.f479110a;
        this.f321894v = fx8.a.f479114e;
    }

    @Override // com.larus.camera.impl.ui.component.capture.CaptureControlComponent, com.larus.camera.impl.ui.component.capture.a
    public final List<String> d() {
        return this.f321894v;
    }

    @Override // com.larus.camera.impl.ui.component.capture.CaptureControlComponent
    public final void z(List<AlbumSelectItem> r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        FLogger.f375446a.i(CameraCaptureViewModel.TAG, "call onHandlePictureSelected");
        CameraCaptureViewModel r101 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.f321801e.getValue()).a();
        if (r101 != null) goto L5;
        return;
    L5:
        r101.openResultPageFromAlbum(getContext(), r100, new EduCaptureControlComponent$onHandlePictureSelected$1(this));
    }

    public static final Object B(EduCaptureControlComponent r100, List r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof EduCaptureControlComponent$interceptResultPageOpen$1) == false) goto L7;
        EduCaptureControlComponent$interceptResultPageOpen$1 r103 = (EduCaptureControlComponent$interceptResultPageOpen$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L29:
        return Boxing.boxBoolean(!((Boolean) r105).booleanValue());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        if (AppHost.f326268a.isOversea() == true) goto L17;
    L19:
        CameraCaptureViewModel r108 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) r100.f321801e.getValue()).a();
        if (r108 == null) goto L31;
        OutputParam r109 = (OutputParam) CollectionsKt.firstOrNull(r101);
        if (r109 == null) goto L32;
        Context r110 = r100.getContext();
        Uri r111 = y0.j(r109.getSrcAlbumUri());
        r103.label = 1;
        r105 = r108.eduImageIdentifyCheck(r110, r111, r109, r103);
        if (r105 != r106) goto L29;
        return r106;
    L32:
        return Boxing.boxBoolean(false);
    L31:
        return Boxing.boxBoolean(false);
    L17:
        if (((oq9.d) com.larus.camera.impl.utils.k.f322785a.getValue()).c() == true) goto L19;
        return Boxing.boxBoolean(false);
    L7:
        r103 = new EduCaptureControlComponent$interceptResultPageOpen$1(r100, r102);
        goto L8
    }
}
