package com.larus.bmhome.chat.standarduikit.fileblock.download;

import android.os.Build;
import com.ss.ttvideoengine.model.VideoRef;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.fileblock.download.FileCardDownloadDialogFragment$exportFileToSystemDownloads$2", f = "FileCardDownloadDialogFragment.kt", i = {}, l = {VideoRef.VALUE_VIDEO_REF_SUBTITLE_POSITION_X, 241}, m = "invokeSuspend", n = {}, s = {})
final class FileCardDownloadDialogFragment$exportFileToSystemDownloads$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $fileName;
    final /* synthetic */ File $localFile;
    int label;
    final /* synthetic */ FileCardDownloadDialogFragment this$0;

    public FileCardDownloadDialogFragment$exportFileToSystemDownloads$2(File r100, FileCardDownloadDialogFragment r101, String r102, Continuation<? super FileCardDownloadDialogFragment$exportFileToSystemDownloads$2> r103) {
        this.$localFile = r100;
        this.this$0 = r101;
        this.$fileName = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new FileCardDownloadDialogFragment$exportFileToSystemDownloads$2(this.$localFile, this.this$0, this.$fileName, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((FileCardDownloadDialogFragment$exportFileToSystemDownloads$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        ResultKt.throwOnFailure(r100);
    L23:
        boolean r103 = ((Boolean) r100).booleanValue();
    L25:
        return Boxing.boxBoolean(r103);
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
    L19:
        r103 = ((Boolean) r100).booleanValue();
        goto L25
    L10:
        ResultKt.throwOnFailure(r100);
        if (this.$localFile.exists() == true) goto L15;
        return Boxing.boxBoolean(false);
    L15:
        if (Build.VERSION.SDK_INT < 29) goto L20;
        FileCardDownloadDialogFragment r104 = this.this$0;
        File r105 = this.$localFile;
        String r106 = this.$fileName;
        this.label = 1;
        r100 = FileCardDownloadDialogFragment.T90(r104, r105, r106, this);
        if (r100 != r101) goto L19;
        return r101;
    L20:
        FileCardDownloadDialogFragment r107 = this.this$0;
        File r108 = this.$localFile;
        String r109 = this.$fileName;
        this.label = 2;
        r100 = FileCardDownloadDialogFragment.S90(r107, r108, r109, this);
        if (r100 != r101) goto L23;
        return r101;
    }
}
