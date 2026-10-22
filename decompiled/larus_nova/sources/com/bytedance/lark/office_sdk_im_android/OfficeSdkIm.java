package com.bytedance.lark.office_sdk_im_android;

import com.bytedance.common.wschannel.WsConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import office_sdk_im.proto.FuncParamsX0eb96a96bc04d5fb;
import office_sdk_im.proto.FuncParamsX9bb45bc1f44db3d7;
import office_sdk_im.proto.FuncParamsXa107628d4fee1944;
import office_sdk_im.proto.FuncParamsXb352c1b9784e5637;
import office_sdk_im.proto.FuncReturnX31709008a17eb2c2;
import office_sdk_im.proto.FuncReturnXb05c0e03c1bfe022;
import okio.ByteString;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014J\u0006\u0010\u000b\u001a\u00020\u0003J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/lark/office_sdk_im_android/OfficeSdkIm;", "Lcom/bytedance/lark/office_sdk_im_android/RustArcClass;", "pointer", "", "(J)V", "disableOfflinePush", "", WsConstants.KEY_PAYLOAD, "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "freeRustArcPtr", "", "into", "subscribeFeedSyncStatus", "notifier", "Lcom/bytedance/lark/office_sdk_im_android/FeedSyncStatusChangeNotifier;", "updateFeed", "Companion", "office_sdk_im_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class OfficeSdkIm extends RustArcClass {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\n"}, d2 = {"Lcom/bytedance/lark/office_sdk_im_android/OfficeSdkIm$Companion;", "", "()V", "new", "Lcom/bytedance/lark/office_sdk_im_android/OfficeSdkIm;", "uid", "Lkotlin/ULong;", "sdkSession", "new-PWzV0Is", "(JJ)Lcom/bytedance/lark/office_sdk_im_android/OfficeSdkIm;", "office_sdk_im_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        /* JADX INFO: renamed from: new-PWzV0Is, reason: not valid java name */
        public final OfficeSdkIm m8443newPWzV0Is(long r110, long r111) {
            MoltenFfiLibOfficeSdkIm.Companion r100 = MoltenFfiLibOfficeSdkIm.Companion;
            ByteString r101 = r100.buildExtra(new InvokeHookInfo("office_sdk_im", 6649334817224448856L, 1565317976, null, "new"));
            byte[] r102 = new FuncParamsXa107628d4fee1944(Long.valueOf(r110), Long.valueOf(r111), r101).encode();
            long r103 = r100.getRuntime$office_sdk_im_android_release();     // Catch: RuntimeException -> L6
            Intrinsics.checkNotNull(r102);     // Catch: RuntimeException -> L6
            byte[] r112 = r100.molten_ffi_office_sdk_im_call(r103, 0, 974955704570685125L, r102);     // Catch: RuntimeException -> L6
            Long r113 = FuncReturnX31709008a17eb2c2.ADAPTER.decode(r112).ret;
            Intrinsics.checkNotNull(r113);
            return new OfficeSdkIm(r113.longValue());
        L6:
            e = move-exception;
            if (e.getMessage() == null) goto L12;
            DefaultCallStatusErrorHandler r114 = DefaultCallStatusErrorHandler.INSTANCE;
            String r115 = e.getMessage();
            Intrinsics.checkNotNull(r115);
            throw r114.report$office_sdk_im_android_release(new UnhandledException(r115));
        L12:
            throw DefaultCallStatusErrorHandler.INSTANCE.report$office_sdk_im_android_release(new UnhandledException("Rust panic"));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.lark.office_sdk_im_android.OfficeSdkIm$disableOfflinePush$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.lark.office_sdk_im_android.OfficeSdkIm", f = "office_sdk_im.kt", i = {0, 0, 0}, l = {337}, m = "disableOfflinePush", n = {"this_$iv", "paramsBuf", "pointer"}, s = {"L$0", "L$1", "J$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ OfficeSdkIm this$0;

        public AnonymousClass1(OfficeSdkIm r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.disableOfflinePush(null, this);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    /* JADX INFO: renamed from: new-PWzV0Is, reason: not valid java name */
    public static final OfficeSdkIm m8442newPWzV0Is(long r100, long r101) {
        return Companion.m8443newPWzV0Is(r100, r101);
    }

    @Override // com.bytedance.lark.office_sdk_im_android.RustArcClass
    public void freeRustArcPtr() {
        MoltenFfiLibOfficeSdkIm.Companion r100 = MoltenFfiLibOfficeSdkIm.Companion;     // Catch: RuntimeException -> L4
        r100.molten_ffi_office_sdk_im_free(r100.getRuntime$office_sdk_im_android_release(), getPointer(), -7328696619233181696L);     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        if (e.getMessage() == null) goto L10;
        DefaultCallStatusErrorHandler r101 = DefaultCallStatusErrorHandler.INSTANCE;
        String r102 = e.getMessage();
        Intrinsics.checkNotNull(r102);
        throw r101.report$office_sdk_im_android_release(new UnhandledException(r102));
    L10:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$office_sdk_im_android_release(new UnhandledException("Rust panic"));
    }

    public final long into() {
        return getPointer();
    }

    public OfficeSdkIm(long r100) {
        super(r100);
    }

    public final byte[] subscribeFeedSyncStatus(FeedSyncStatusChangeNotifier r110) {
        Intrinsics.checkNotNullParameter(r110, "notifier");
    L3:
        long r100 = RustArcClass.access$getCallCounter$p(this).get();
        if (r100 == 0) goto L31;
        if (r100 == Long.MAX_VALUE) goto L29;
        if (RustArcClass.access$getCallCounter$p(this).compareAndSet(r100, 1 + r100) == false) goto L3;
        long r101 = RustArcClass.access$getPointer(this);     // Catch: Throwable -> L23
        MoltenFfiLibOfficeSdkIm.Companion r102 = MoltenFfiLibOfficeSdkIm.Companion;     // Catch: Throwable -> L23
        ByteString r103 = r102.buildExtra(new InvokeHookInfo("office_sdk_im", 6649334817224448856L, 1565317976, null, "subscribeFeedSyncStatus"));     // Catch: Throwable -> L23
        byte[] r111 = new FuncParamsX0eb96a96bc04d5fb(Office_sdk_imKt.into(r110), r103).encode();     // Catch: Throwable -> L23
        long r104 = r102.getRuntime$office_sdk_im_android_release();     // Catch: RuntimeException -> L16 Throwable -> L23
        Intrinsics.checkNotNull(r111);     // Catch: RuntimeException -> L16 Throwable -> L23
        byte[] r105 = r102.molten_ffi_office_sdk_im_call(r104, r101, -2313999847000230480L, r111);     // Catch: RuntimeException -> L16 Throwable -> L23
        ByteString r106 = FuncReturnXb05c0e03c1bfe022.ADAPTER.decode(r105).ret;     // Catch: Throwable -> L23
        Intrinsics.checkNotNull(r106);     // Catch: Throwable -> L23
        byte[] r107 = r106.toByteArray();     // Catch: Throwable -> L23
        if (RustArcClass.access$getCallCounter$p(this).decrementAndGet() != 0) goto L15;
        RustArcClass.access$freeRustArcPtr(this);
    L15:
        return r107;
    L16:
        e = move-exception;
        if (e.getMessage() == null) goto L22;
        DefaultCallStatusErrorHandler r108 = DefaultCallStatusErrorHandler.INSTANCE;     // Catch: Throwable -> L23
        String r109 = e.getMessage();     // Catch: Throwable -> L23
        Intrinsics.checkNotNull(r109);     // Catch: Throwable -> L23
        throw r108.report$office_sdk_im_android_release(new UnhandledException(r109));     // Catch: Throwable -> L23
    L22:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$office_sdk_im_android_release(new UnhandledException("Rust panic"));     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        if (RustArcClass.access$getCallCounter$p(this).decrementAndGet() != 0) goto L27;
        RustArcClass.access$freeRustArcPtr(this);
    L27:
        throw th;
    L29:
        throw new IllegalStateException(getClass().getSimpleName().concat(" call counter would overflow"));
    L31:
        throw new IllegalStateException(getClass().getSimpleName().concat(" object has already been destroyed"));
    }

    public final byte[] updateFeed(byte[] r110) {
        Intrinsics.checkNotNullParameter(r110, WsConstants.KEY_PAYLOAD);
    L3:
        long r100 = RustArcClass.access$getCallCounter$p(this).get();
        if (r100 == 0) goto L31;
        if (r100 == Long.MAX_VALUE) goto L29;
        if (RustArcClass.access$getCallCounter$p(this).compareAndSet(r100, 1 + r100) == false) goto L3;
        long r101 = RustArcClass.access$getPointer(this);     // Catch: Throwable -> L23
        MoltenFfiLibOfficeSdkIm.Companion r102 = MoltenFfiLibOfficeSdkIm.Companion;     // Catch: Throwable -> L23
        ByteString r103 = r102.buildExtra(new InvokeHookInfo("office_sdk_im", 6649334817224448856L, 1565317976, null, "updateFeed"));     // Catch: Throwable -> L23
        ByteString.a r104 = ByteString.Companion;     // Catch: Throwable -> L23
        byte[] r105 = Arrays.copyOf(r110, r110.length);     // Catch: Throwable -> L23
        r104.getClass();     // Catch: Throwable -> L23
        byte[] r111 = new FuncParamsX9bb45bc1f44db3d7(ByteString.a.c(r105), r103).encode();     // Catch: Throwable -> L23
        long r106 = r102.getRuntime$office_sdk_im_android_release();     // Catch: RuntimeException -> L16 Throwable -> L23
        Intrinsics.checkNotNull(r111);     // Catch: RuntimeException -> L16 Throwable -> L23
        byte[] r107 = r102.molten_ffi_office_sdk_im_call(r106, r101, 9155172561850273956L, r111);     // Catch: RuntimeException -> L16 Throwable -> L23
        ByteString r108 = FuncReturnXb05c0e03c1bfe022.ADAPTER.decode(r107).ret;     // Catch: Throwable -> L23
        Intrinsics.checkNotNull(r108);     // Catch: Throwable -> L23
        byte[] r109 = r108.toByteArray();     // Catch: Throwable -> L23
        if (RustArcClass.access$getCallCounter$p(this).decrementAndGet() != 0) goto L15;
        RustArcClass.access$freeRustArcPtr(this);
    L15:
        return r109;
    L16:
        e = move-exception;
        if (e.getMessage() == null) goto L22;
        DefaultCallStatusErrorHandler r112 = DefaultCallStatusErrorHandler.INSTANCE;     // Catch: Throwable -> L23
        String r113 = e.getMessage();     // Catch: Throwable -> L23
        Intrinsics.checkNotNull(r113);     // Catch: Throwable -> L23
        throw r112.report$office_sdk_im_android_release(new UnhandledException(r113));     // Catch: Throwable -> L23
    L22:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$office_sdk_im_android_release(new UnhandledException("Rust panic"));     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        if (RustArcClass.access$getCallCounter$p(this).decrementAndGet() != 0) goto L27;
        RustArcClass.access$freeRustArcPtr(this);
    L27:
        throw th;
    L29:
        throw new IllegalStateException(getClass().getSimpleName().concat(" call counter would overflow"));
    L31:
        throw new IllegalStateException(getClass().getSimpleName().concat(" object has already been destroyed"));
    }

    public final Object disableOfflinePush(byte[] r210, Continuation<? super byte[]> r211) {
        if ((r211 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r100 = (AnonymousClass1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L20;
        if (r104 != 1) goto L19;
        AnonymousClass1 r105 = (AnonymousClass1) r100.L$2;
        byte[] r106 = (byte[]) r100.L$1;
        RustArcClass r107 = (RustArcClass) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L14 RuntimeException -> L16
    L34:
        byte[] r108 = (byte[]) r102;     // Catch: Throwable -> L14 RuntimeException -> L16
        ByteString r109 = FuncReturnXb05c0e03c1bfe022.ADAPTER.decode(r108).ret;     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r109);     // Catch: Throwable -> L14
        byte[] r110 = r109.toByteArray();     // Catch: Throwable -> L14
        if (RustArcClass.access$getCallCounter$p(r107).decrementAndGet() != 0) goto L39;
        RustArcClass.access$freeRustArcPtr(r107);
    L39:
        return r110;
    L16:
        e = e;
    L43:
        if (e.getMessage() == null) goto L47;
        DefaultCallStatusErrorHandler r111 = DefaultCallStatusErrorHandler.INSTANCE;     // Catch: Throwable -> L14
        String r112 = e.getMessage();     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r112);     // Catch: Throwable -> L14
        throw r111.report$office_sdk_im_android_release(new UnhandledException(r112));     // Catch: Throwable -> L14
    L47:
        throw DefaultCallStatusErrorHandler.INSTANCE.report$office_sdk_im_android_release(new UnhandledException("Rust panic"));     // Catch: Throwable -> L14
    L14:
        th = th;
    L51:
        if (RustArcClass.access$getCallCounter$p(r107).decrementAndGet() != 0) goto L53;
        RustArcClass.access$freeRustArcPtr(r107);
    L53:
        throw th;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r102);
    L21:
        long r113 = RustArcClass.access$getCallCounter$p(this).get();
        if (r113 == 0) goto L57;
        if (r113 == Long.MAX_VALUE) goto L55;
        if (RustArcClass.access$getCallCounter$p(this).compareAndSet(r113, 1 + r113) == false) goto L21;
        long r114 = RustArcClass.access$getPointer(this);     // Catch: Throwable -> L48
        MoltenFfiLibOfficeSdkIm.Companion r115 = MoltenFfiLibOfficeSdkIm.Companion;     // Catch: Throwable -> L48
        ByteString r116 = r115.buildExtra(new InvokeHookInfo("office_sdk_im", 6649334817224448856L, 1565317976, null, "disableOfflinePush"));     // Catch: Throwable -> L48
        ByteString.a r117 = ByteString.Companion;     // Catch: Throwable -> L48
        byte[] r118 = Arrays.copyOf(r210, r210.length);     // Catch: Throwable -> L48
        r117.getClass();     // Catch: Throwable -> L48
        byte[] r119 = new FuncParamsXb352c1b9784e5637(ByteString.a.c(r118), r116).encode();     // Catch: Throwable -> L48
        r100.L$0 = this;     // Catch: RuntimeException -> L40 Throwable -> L48
        r100.L$1 = r119;     // Catch: RuntimeException -> L40 Throwable -> L48
        r100.L$2 = r100;     // Catch: RuntimeException -> L40 Throwable -> L48
        r100.J$0 = r114;     // Catch: RuntimeException -> L40 Throwable -> L48
        r100.label = 1;     // Catch: RuntimeException -> L40 Throwable -> L48
        SafeContinuation r120 = new SafeContinuation(IntrinsicsKt.intercepted(r100));     // Catch: RuntimeException -> L40 Throwable -> L48
        long r121 = new ContProxy(r120).into();     // Catch: RuntimeException -> L40 Throwable -> L48
        long r122 = r115.getRuntime$office_sdk_im_android_release();     // Catch: RuntimeException -> L40 Throwable -> L48
        Intrinsics.checkNotNull(r119);     // Catch: RuntimeException -> L40 Throwable -> L48
        r115.molten_ffi_office_sdk_im_async_call(r121, r122, r114, 545669569821391962L, r119);     // Catch: RuntimeException -> L40 Throwable -> L48
        r102 = r120.getOrThrow();     // Catch: RuntimeException -> L40 Throwable -> L48
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L31;
        DebugProbesKt.probeCoroutineSuspended(r100);     // Catch: RuntimeException -> L40 Throwable -> L48
    L31:
        if (r102 != r103) goto L33;
        return r103;
    L33:
        r107 = this;
    L40:
        e = e;
    L48:
        th = th;
        r107 = this;
        goto L51
    L55:
        throw new IllegalStateException(getClass().getSimpleName().concat(" call counter would overflow"));
    L57:
        throw new IllegalStateException(getClass().getSimpleName().concat(" object has already been destroyed"));
    L7:
        r100 = new AnonymousClass1(this, r211);
        goto L8
    }
}
