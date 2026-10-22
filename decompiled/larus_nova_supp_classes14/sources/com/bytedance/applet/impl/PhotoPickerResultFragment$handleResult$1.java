package com.bytedance.applet.impl;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ai.bridge.service.ChooseImageCallback;
import com.bytedance.ai.bridge.service.ChooseImageFileResult;
import com.bytedance.ai.bridge.service.ChooseImageResultData;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.impl.PhotoPickerResultFragment$handleResult$1", f = "AppletHostImageServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PhotoPickerResultFragment$handleResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChooseImageCallback $cb;
    final /* synthetic */ ContentResolver $contentResolver;
    final /* synthetic */ File $tempDir;
    final /* synthetic */ List<Uri> $uris;
    int label;
    final /* synthetic */ PhotoPickerResultFragment this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoPickerResultFragment$handleResult$1(List<? extends Uri> r1, ContentResolver r2, File r3, ChooseImageCallback r4, PhotoPickerResultFragment r5, Continuation<? super PhotoPickerResultFragment$handleResult$1> r6) {
        this.$uris = r1;
        this.$contentResolver = r2;
        this.$tempDir = r3;
        this.$cb = r4;
        this.this$0 = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new PhotoPickerResultFragment$handleResult$1(this.$uris, this.$contentResolver, this.$tempDir, this.$cb, this.this$0, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L47;
        ResultKt.throwOnFailure(r11);
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L32 Exception -> L34
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L32 Exception -> L34
        Iterator<Uri> r2 = this.$uris.iterator();     // Catch: Throwable -> L32 Exception -> L34
    L7:
        if (r2.hasNext() == false) goto L28;
        Uri r3 = r2.next();     // Catch: Throwable -> L32 Exception -> L34
        String r4 = this.$contentResolver.getType(r3);     // Catch: Throwable -> L32 Exception -> L34
        PolarisFileWrapper r6 = new PolarisFileWrapper(this.$tempDir, "image_" + System.currentTimeMillis() + '_' + r12.size() + '.' + p.a(r4));     // Catch: Throwable -> L32 Exception -> L34
        InputStream r5 = ContentResolverWrapper.openInputStream(this.$contentResolver, r3);     // Catch: Throwable -> L32 Exception -> L34
        if (r5 == null) goto L10;
        PolarisFileOutputStreamWrapper r7 = new PolarisFileOutputStreamWrapper(r6);     // Catch: Throwable -> L23
        ByteStreamsKt.copyTo$default(r5, r7, 0, 2, null);     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r7, null);     // Catch: Throwable -> L23
        CloseableKt.closeFinally(r5, null);     // Catch: Throwable -> L32 Exception -> L34
        r12.add(r6.getAbsolutePath());     // Catch: Throwable -> L32 Exception -> L34
        r1.add(new ChooseImageFileResult(r6.getAbsolutePath(), r6.length(), r4));     // Catch: Throwable -> L32 Exception -> L34
        goto L7
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);     // Catch: Throwable -> L32 Exception -> L34
        throw th;     // Catch: Throwable -> L32 Exception -> L34
    L10:
        FLogger.a.e("PhotoPickerResultFragment", "handleResult: openInputStream returned null for uri=" + r3);     // Catch: Throwable -> L32 Exception -> L34
        goto L7
    L28:
        ChooseImageCallback r8 = this.$cb;     // Catch: Throwable -> L32 Exception -> L34
        if (r8 == null) goto L31;
        r8.onSuccess(new ChooseImageResultData(r12, r1));     // Catch: Throwable -> L32 Exception -> L34
    L31:
        Handler r13 = new Handler(Looper.getMainLooper());
        final PhotoPickerResultFragment r0 = this.this$0;
        Runnable r9 = new b2(r0);
    L42:
        r13.post(r9);
        return Unit.INSTANCE;
    L32:
        th = move-exception;
        Handler r10 = new Handler(Looper.getMainLooper());
        final PhotoPickerResultFragment r14 = this.this$0;
        r10.post(new b2(r14));
        throw th;
    L34:
        e = move-exception;
        FLogger.a.e("PhotoPickerResultFragment", "handleResult error: " + e);     // Catch: Throwable -> L32
        ChooseImageCallback r15 = this.$cb;     // Catch: Throwable -> L32
        if (r15 == null) goto L41;
        String r16 = e.getMessage();     // Catch: Throwable -> L32
        if (r16 != null) goto L40;
        r16 = "choose image failed";
    L40:
        r15.onFail(r16);     // Catch: Throwable -> L32
    L41:
        r13 = new Handler(Looper.getMainLooper());
        final PhotoPickerResultFragment r17 = this.this$0;
        r9 = new b2(r17);
        goto L42
    L47:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
