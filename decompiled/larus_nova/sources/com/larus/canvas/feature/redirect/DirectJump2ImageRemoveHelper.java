package com.larus.canvas.feature.redirect;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.canvas.feature.CreationCanvasActivity;
import com.larus.canvas.feature.component.logic.helper.g;
import com.larus.canvas.service.bean.IImageInfo;
import com.larus.canvas.service.bean.NetworkImage;
import com.larus.nova.R;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.f;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.y0;
import java.io.File;
import java.io.Serializable;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import xy9.b;

/* JADX INFO: loaded from: classes26.dex */
public final class DirectJump2ImageRemoveHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DirectJump2ImageRemoveHelper f323747a = null;

    public static final class a implements xy9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f323748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AppCompatActivity f323749b;

        @Override // xy9.a
        public final void closePage() {
            this.f323748a.dismiss();
        }

        @Override // xy9.a
        public final void a(Bundle r100) {
            Intrinsics.checkNotNullParameter(r100, "bundle");
            Serializable r101 = r100.getSerializable("image_edit_data.with_mask");
            if ((r101 instanceof ImageEditDataWithMask) == false) goto L5;
            ImageEditDataWithMask r102 = (ImageEditDataWithMask) r101;
        L6:
            if (r102 == null) goto L10;
            ImageRemoveDialogResultReceiverViewModel r103 = (ImageRemoveDialogResultReceiverViewModel) new ViewModelProvider(this.f323749b).get(ImageRemoveDialogResultReceiverViewModel.class);
            if (r103 == null) goto L10;
            r103.onReceiveImageMaskResult(r102);
        L10:
            this.f323748a.dismiss();
            return;
        L5:
            r102 = null;
            goto L6
        }

        public a(b r100, AppCompatActivity r101) {
            this.f323748a = r100;
            this.f323749b = r101;
        }
    }

    static {
        f323747a = new DirectJump2ImageRemoveHelper();
    }

    public DirectJump2ImageRemoveHelper() {
    }

    public final Object a(AppCompatActivity r100, MediaAttachment r101, Continuation<? super Unit> r110) {
        if ((r110 instanceof DirectJump2ImageRemoveHelper$tryOpenImageRemoveDialog$3) == false) goto L7;
        DirectJump2ImageRemoveHelper$tryOpenImageRemoveDialog$3 r102 = (DirectJump2ImageRemoveHelper$tryOpenImageRemoveDialog$3) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L15;
        if (r105 != 1) goto L14;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L21
    L19:
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L28;
        FLogger.f375446a.e("DirectJump2ImageRemoveHelper", "show image remove dialog fail,info is " + r107.getMessage());
    L28:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r111);
        Bundle r108 = f.c(new Pair[]{TuplesKt.to("media_attachment", r101), TuplesKt.to("ignore_image_size_check", Boxing.boxBoolean(true))});
        b r112 = IUgcAIGCService.f373945a.E();
        r112.K00(r108, new a(r112, r100), R.style.larusImageRemoveDialogTheme, R.style.larus_image_remove_dialog_animation);
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L21
        FragmentManager r113 = r100.getSupportFragmentManager();     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r113);     // Catch: Throwable -> L21
        r112.show(r113, "ImageRemoveDialogFragment");     // Catch: Throwable -> L21
        FLogger.f375446a.i("DirectJump2ImageRemoveHelper", "canvas init show image remove dialog success");     // Catch: Throwable -> L21
        r102.label = 1;     // Catch: Throwable -> L21
        if (DelayKt.delay(500, r102) != r104) goto L19;
        return r104;
    L21:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r102 = new DirectJump2ImageRemoveHelper$tryOpenImageRemoveDialog$3(this, r110);
        goto L8
    }

    public final Object b(CreationCanvasActivity r210, Intent r211, Continuation r212) {
        AppCompatActivity r100 = r210;
        if ((r212 instanceof DirectJump2ImageRemoveHelper$tryOpenImageRemoveDialog$1) == false) goto L7;
        DirectJump2ImageRemoveHelper$tryOpenImageRemoveDialog$1 r101 = (DirectJump2ImageRemoveHelper$tryOpenImageRemoveDialog$1) r212;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        Long r106 = null;
        if (r105 == 0) goto L18;
        if (r105 == 1) goto L17;
        if (r105 == 2) goto L16;
        if (r105 == 3) goto L17;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        NetworkImage r107 = (NetworkImage) r101.L$1;
        AppCompatActivity r108 = (AppCompatActivity) r101.L$0;
        ResultKt.throwOnFailure(r103);
        NetworkImage r109 = r107;
        r100 = r108;
        Object r110 = r103;
    L53:
        File r111 = (File) r110;
        if (r111 == null) goto L67;
        String r112 = r109.f323822a;
        String r113 = r109.f323823b;
        String r114 = y0.k(Uri.fromFile(r111));
        Integer r115 = r109.f323824c;
        if (r115 == null) goto L58;
        Long r116 = Boxing.boxLong(r115.intValue());
    L59:
        Integer r117 = r109.f323825d;
        if (r117 == null) goto L62;
        Long r118 = Boxing.boxLong(r117.intValue());
    L63:
        MediaAttachment r119 = new MediaAttachment(r113, r112, new ImageUploadInfo(r116, r118), null, r114, null, null, null, null, null, null, null, 4072, null);
        DirectJump2ImageRemoveHelper r120 = f323747a;
        r101.L$0 = null;
        r101.L$1 = null;
        r101.label = 3;
        if (r120.a(r100, r119, r101) != r104) goto L67;
        return r104;
    L62:
        r118 = null;
        goto L63
    L58:
        r116 = null;
    L67:
        return Unit.INSTANCE;
    L17:
        ResultKt.throwOnFailure(r103);
        goto L67
    L18:
        ResultKt.throwOnFailure(r103);
        Bundle r121 = r211.getExtras();
        if (r121 == null) goto L67;
        if (r121.getInt("ai_beautify_id") != 3) goto L23;
        Bundle r122 = r211.getExtras();
        if (r122 == null) goto L27;
        IImageInfo r123 = (IImageInfo) r122.getParcelable("init_image_info");
    L29:
        if ((r123 instanceof NetworkImage) == false) goto L31;
        r109 = (NetworkImage) r123;
    L32:
        if (r109 == null) goto L67;
        if (o0.d(r109.f323826e) == false) goto L49;
        String r124 = r109.f323822a;
        String r125 = r109.f323823b;
        String r126 = r109.f323826e;
        if (r126 != null) goto L38;
        r126 = "";
    L38:
        String r127 = r126;
        Integer r128 = r109.f323824c;
        if (r128 == null) goto L41;
        Long r129 = Boxing.boxLong(r128.intValue());
    L42:
        Integer r130 = r109.f323825d;
        if (r130 == null) goto L45;
        r106 = Boxing.boxLong(r130.intValue());
    L45:
        MediaAttachment r131 = new MediaAttachment(r125, r124, new ImageUploadInfo(r129, r106), null, r127, null, null, null, null, null, null, null, 4072, null);
        DirectJump2ImageRemoveHelper r132 = f323747a;
        r101.label = 1;
        if (r132.a(r100, r131, r101) != r104) goto L67;
        return r104;
    L41:
        r129 = null;
        goto L42
    L49:
        if (o0.d(r109.f323823b) == false) goto L67;
        String r133 = r109.f323823b;
        r101.L$0 = r100;
        r101.L$1 = r109;
        r101.label = 2;
        r110 = g.b(r100, r133, r101);
        if (r110 != r104) goto L53;
        return r104;
    L31:
        r109 = null;
        goto L32
    L27:
        r123 = null;
        goto L29
    L23:
        return Unit.INSTANCE;
    L7:
        r101 = new DirectJump2ImageRemoveHelper$tryOpenImageRemoveDialog$1(this, r212);
        goto L8
    }
}
