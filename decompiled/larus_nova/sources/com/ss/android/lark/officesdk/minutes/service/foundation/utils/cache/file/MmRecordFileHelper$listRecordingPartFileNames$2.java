package com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file;

import com.ss.android.lark.vfs.VFSFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper$listRecordingPartFileNames$2", f = "MmRecordFileHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordFileHelper$listRecordingPartFileNames$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends String>>, Object> {
    final /* synthetic */ String $recordingId;
    final /* synthetic */ String $userId;
    int label;

    public MmRecordFileHelper$listRecordingPartFileNames$2(String r100, String r101, Continuation<? super MmRecordFileHelper$listRecordingPartFileNames$2> r102) {
        this.$userId = r100;
        this.$recordingId = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MmRecordFileHelper$listRecordingPartFileNames$2(this.$userId, this.$recordingId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super List<? extends String>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super List<String>> r101) {
        return ((MmRecordFileHelper$listRecordingPartFileNames$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r100);
        MmRecordFileHelper r101 = MmRecordFileHelper.f434037a;
        String r102 = this.$userId;
        String r103 = this.$recordingId;
        r101.getClass();
        VFSFile r104 = MmRecordFileHelper.f(r102, r103);
        if (r104.exists() == false) goto L24;
        if (r104.isDirectory() == false) goto L24;
        VFSFile[] r105 = r104.listFiles();
        if (r105 == null) goto L22;
        ArrayList r106 = new ArrayList();
        int r107 = r105.length;
        int r108 = 0;
    L12:
        if (r108 >= r107) goto L17;
        VFSFile r109 = r105[r108];
        if (r109.isFile() == false) goto L16;
        r106.add(r109);
    L16:
        r108 = r108 + 1;
        goto L12
    L17:
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator r111 = r106.iterator();
    L19:
        if (r111.hasNext() == false) goto L31;
        r110.add(((VFSFile) r111.next()).getName());
        goto L19
    L31:
        return r110;
    L22:
        return CollectionsKt.emptyList();
    L24:
        return CollectionsKt.emptyList();
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
