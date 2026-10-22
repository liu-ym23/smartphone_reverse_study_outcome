package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingMapReadHelper$readFromCache$2", f = "MmRecordingMapReadHelper.kt", i = {0}, l = {63}, m = "invokeSuspend", n = {SimplayerImageStrategy.RESULT_BITMAP}, s = {"L$0"})
public final class MmRecordingMapReadHelper$readFromCache$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super JSONObject>, Object> {
    final /* synthetic */ boolean $isDarkMode;
    Object L$0;
    int label;
    final /* synthetic */ MmRecordingMapReadHelper this$0;

    public MmRecordingMapReadHelper$readFromCache$2(boolean r100, MmRecordingMapReadHelper r101, Continuation<? super MmRecordingMapReadHelper$readFromCache$2> r102) {
        this.$isDarkMode = r100;
        this.this$0 = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MmRecordingMapReadHelper$readFromCache$2(this.$isDarkMode, this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super JSONObject> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super JSONObject> r101) {
        return ((MmRecordingMapReadHelper$readFromCache$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        JSONObject r102 = null;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        Bitmap r103 = (Bitmap) this.L$0;
        ResultKt.throwOnFailure(r110);
    L37:
        JSONObject r111 = (JSONObject) r110;
        if (r111 == null) goto L44;
        boolean r104 = this.$isDarkMode;
        MmRecordingMapReadHelper r105 = this.this$0;
        if (r104 == false) goto L42;
        r105.f435007b = r111;
    L43:
        r102 = r111;
        goto L44
    L42:
        r105.f435008c = r111;
    L44:
        r103.recycle();
        return r102;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        if (this.$isDarkMode == false) goto L11;
        JSONObject r112 = this.this$0.f435007b;
    L12:
        if (r112 == null) goto L15;
        lvb.a.e(this.this$0.f435006a, "[readFromCache] use cache");
        return r112;
    L15:
        Application r113 = LarkContext.getApplication();
        if (this.$isDarkMode == false) goto L18;
        String r106 = "mm_map_snapshot_dark.png";
    L19:
        Intrinsics.checkNotNull(r113);
        PolarisFileWrapper r107 = new PolarisFileWrapper(MmRecordingMapUtilKt.c(r113), r106);
        if (r107.exists() == true) goto L22;
    L53:
        lvb.a.e(this.this$0.f435006a, "[readFromCache] bitmapFile not exist or empty: " + r107.getAbsolutePath());
        return null;
    L22:
        if (r107.length() == 0) goto L53;
        BitmapFactory.Options r114 = new BitmapFactory.Options();
        r114.inPreferredConfig = Bitmap.Config.RGB_565;
        PolarisFileInputStreamWrapper r108 = new PolarisFileInputStreamWrapper(r107);
        Bitmap r115 = BitmapFactory.decodeStream(r108, null, r114);     // Catch: Throwable -> L48
        CloseableKt.closeFinally(r108, null);
        if (r115 != null) goto L29;
    L46:
        lvb.a.b(this.this$0.f435006a, "[readFromCache] bitmap is invalid");
        return null;
    L29:
        if (r115.getWidth() <= 0) goto L46;
        if (r115.getHeight() <= 0) goto L46;
        lvb.a.e(this.this$0.f435006a, "[readFromCache] bitmap:" + r115.getWidth() + Permission.EXECUTE + r115.getHeight() + ", isDarkMode=" + this.$isDarkMode);
        MmRecordingMapReadHelper r109 = this.this$0;
        this.L$0 = r115;
        this.label = 1;
        Object r116 = MmRecordingMapReadHelper.a(r109, r115, this);
        if (r116 != r100) goto L36;
        return r100;
    L36:
        r103 = r115;
        r110 = r116;
    L48:
        th = move-exception;
        throw th;     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        CloseableKt.closeFinally(r108, th);
        throw th;
    L18:
        r106 = "mm_map_snapshot_light.png";
        goto L19
    L11:
        r112 = this.this$0.f435008c;
        goto L12
    }
}
