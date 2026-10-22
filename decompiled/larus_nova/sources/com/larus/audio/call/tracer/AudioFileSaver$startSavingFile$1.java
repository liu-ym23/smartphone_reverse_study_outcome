package com.larus.audio.call.tracer;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
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

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.audio.call.tracer.AudioFileSaver$startSavingFile$1", f = "AudioFileSaver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AudioFileSaver$startSavingFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $data;
    final /* synthetic */ String $roomId;
    final /* synthetic */ int $type;
    int label;
    final /* synthetic */ AudioFileSaver this$0;

    public AudioFileSaver$startSavingFile$1(String r100, int r101, AudioFileSaver r102, byte[] r103, Continuation<? super AudioFileSaver$startSavingFile$1> r104) {
        this.$roomId = r100;
        this.$type = r101;
        this.this$0 = r102;
        this.$data = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AudioFileSaver$startSavingFile$1(this.$roomId, this.$type, this.this$0, this.$data, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AudioFileSaver$startSavingFile$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L55;
        ResultKt.throwOnFailure(r100);
        String r101 = this.$roomId;
        boolean r102 = false;
        if (r101 != null) goto L7;
    L10:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        String r104 = this.$type + '_' + this.this$0.f289617a;
    L15:
        FileOutputStream r105 = (FileOutputStream) ((LinkedHashMap) this.this$0.f289620d).get(r104);
        if (r105 == null) goto L56;
    L40:
        File r106 = (File) ((LinkedHashMap) this.this$0.f289621e).get(r104);     // Catch: Exception -> L50
        if (r106 != null) goto L45;
        return Unit.INSTANCE;
    L45:
        if (AudioFileSaver.a(this.this$0, r104, r106, this.$data.length) == false) goto L47;
        r105.write(this.$data);     // Catch: Exception -> L50
        AudioFileSaver.c(this.this$0, r104, r106, this.$data.length);     // Catch: Exception -> L50
    L53:
        return Unit.INSTANCE;
    L47:
        return Unit.INSTANCE;
    L56:
        String r107 = this.$roomId;     // Catch: Exception -> L50
        if (r107 != null) goto L20;
    L21:
        r102 = true;
    L22:
        if (r102 == false) goto L24;
        AudioFileSaver r108 = this.this$0;     // Catch: Exception -> L50
        String r109 = AudioFileSaver.b(r108, this.$type, r108.f289617a);     // Catch: Exception -> L50
    L25:
        if (r109 == null) goto L27;
        PolarisFileWrapper r110 = new PolarisFileWrapper(r109);     // Catch: Exception -> L50
        File r111 = r110.getParentFile();     // Catch: Exception -> L50
        if (r111 == null) goto L32;
        Boxing.boxBoolean(r111.mkdirs());     // Catch: Exception -> L50
    L32:
        if (r110.exists() == false) goto L37;
        if (this.$type != 11) goto L37;
        r110.delete();     // Catch: Exception -> L50
    L37:
        if (r110.exists() == true) goto L39;
        r110.createNewFile();     // Catch: Exception -> L50
    L39:
        r105 = new PolarisFileOutputStreamWrapper(r110, true);     // Catch: Exception -> L50
        this.this$0.f289620d.put(r104, r105);     // Catch: Exception -> L50
        this.this$0.f289621e.put(r104, r110);     // Catch: Exception -> L50
        this.this$0.f289622f.put(r104, Boxing.boxLong(r110.length()));     // Catch: Exception -> L50
        com.larus.audio.call.util.e.f289645a.i(this.this$0.f289619c, "dump in doubao is " + r110);     // Catch: Exception -> L50
        goto L40
    L27:
        return Unit.INSTANCE;
    L24:
        r109 = AudioFileSaver.b(this.this$0, this.$type, "room_" + this.$roomId);     // Catch: Exception -> L50
        goto L25
    L20:
        if (r107.length() != 0) goto L22;
    L50:
        e = move-exception;
        com.larus.audio.call.util.e.f289645a.e(this.this$0.f289619c, "[startSavingFile] error=" + e.getMessage());
        goto L53
    L14:
        r104 = this.$type + '_' + this.$roomId;
        goto L15
    L7:
        if (r101.length() == 0) goto L10;
        r103 = false;
        goto L12
    L55:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
