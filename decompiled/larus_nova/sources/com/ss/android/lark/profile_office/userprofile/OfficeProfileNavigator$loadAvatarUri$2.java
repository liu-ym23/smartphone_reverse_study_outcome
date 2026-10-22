package com.ss.android.lark.profile_office.userprofile;

import android.net.Uri;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.entity.AvatarImage;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileNavigator$loadAvatarUri$2", f = "OfficeProfileNavigator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class OfficeProfileNavigator$loadAvatarUri$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ int $height;
    final /* synthetic */ AvatarImage $previewModel;
    final /* synthetic */ int $width;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ g this$0;

    public OfficeProfileNavigator$loadAvatarUri$2(g r100, AvatarImage r101, int r102, int r103, Continuation<? super OfficeProfileNavigator$loadAvatarUri$2> r104) {
        this.this$0 = r100;
        this.$previewModel = r101;
        this.$width = r102;
        this.$height = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        OfficeProfileNavigator$loadAvatarUri$2 r102 = new OfficeProfileNavigator$loadAvatarUri$2(this.this$0, this.$previewModel, this.$width, this.$height, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super String> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super String> r101) {
        return ((OfficeProfileNavigator$loadAvatarUri$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        g r102 = this.this$0;
        AvatarImage r103 = this.$previewModel;
        int r104 = this.$width;
        int r105 = this.$height;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L11
        File r107 = ImageLoader.with(r102.f438929a).load(r103).diskCacheStrategy(DiskCacheStrategy.ALL).downloadOnly(r104, r105);     // Catch: Throwable -> L11
        if (r107 == null) goto L8;
        String r108 = Uri.fromFile(r107).toString();     // Catch: Throwable -> L11
    L9:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r109) == false) goto L17;
        return null;
    L17:
        return r109;
    L8:
        r108 = null;
    L11:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
