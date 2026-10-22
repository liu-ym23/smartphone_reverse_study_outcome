package com.larus.dora.impl.device.settings.unbind;

import com.byted.cast.common.TeaEventTrack;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.core.UnbindAndResetResult;
import com.larus.dora.impl.device.settings.gesture.DoraGGestureSettingsRepository;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000bJ\n\u0010\f\u001a\u0004\u0018\u00010\u0000H&j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\r"}, d2 = {"Lcom/larus/dora/impl/device/settings/unbind/DoraUnbindStep;", "", "<init>", "(Ljava/lang/String;I)V", "API", "RESET", "CLEAR", "step", "Lcom/larus/dora/impl/device/settings/unbind/DoraUnbindState;", "device", "Lcom/bytedance/dora/device/DoraDevice;", "(Lcom/bytedance/dora/device/DoraDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", TeaEventTrack.ACTION_DRAMA_NEXT, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract enum DoraUnbindStep extends Enum<DoraUnbindStep> {
    public static final DoraUnbindStep API = null;
    public static final DoraUnbindStep CLEAR = null;
    public static final DoraUnbindStep RESET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraUnbindStep[] f334936a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f334937b = null;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0016¨\u0006\b"}, d2 = {"com/larus/dora/impl/device/settings/unbind/DoraUnbindStep.API", "Lcom/larus/dora/impl/device/settings/unbind/DoraUnbindStep;", "step", "Lcom/larus/dora/impl/device/settings/unbind/DoraUnbindState;", "device", "Lcom/bytedance/dora/device/DoraDevice;", "(Lcom/bytedance/dora/device/DoraDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", TeaEventTrack.ACTION_DRAMA_NEXT, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class API extends DoraUnbindStep {

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f334938a = null;

            static {
                int[] r100 = new int[UnbindAndResetResult.values().length];
                r100[UnbindAndResetResult.SERVER_UNBIND_NETWORK_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r100[UnbindAndResetResult.SERVER_UNBIND_UNKNOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r100[UnbindAndResetResult.SERVER_UNBIND_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r100[UnbindAndResetResult.SUCCESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r100[UnbindAndResetResult.SPP_DISCONNECT_FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                f334938a = r100;
            }
        }

        @Override // com.larus.dora.impl.device.settings.unbind.DoraUnbindStep
        public DoraUnbindStep next() {
            return DoraUnbindStep.RESET;
        }

        public API(String r100, int r101) {
            super(r100, r101, null);
        }

        @Override // com.larus.dora.impl.device.settings.unbind.DoraUnbindStep
        public Object step(DoraDevice r100, Continuation<? super DoraUnbindState> r101) {
            if ((r101 instanceof DoraUnbindStep$API$step$1) == false) goto L7;
            DoraUnbindStep$API$step$1 r102 = (DoraUnbindStep$API$step$1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r102.label;
            if (r106 == 0) goto L14;
            if (r106 != 1) goto L13;
            ResultKt.throwOnFailure(r104);
        L17:
            int r107 = a.f334938a[((UnbindAndResetResult) r104).ordinal()];
            if (r107 == 1) goto L33;
            if (r107 == 2) goto L36;
            if (r107 == 3) goto L36;
            if (r107 == 4) goto L35;
            if (r107 != 5) goto L29;
            return DoraUnbindState.SPP_DISCONNECT_FAILED;
        L29:
            throw new NoWhenBranchMatchedException();
        L35:
            return DoraUnbindState.UNBIND_SUCCESS;
        L36:
            return DoraUnbindState.SERVER_UNBIND_FAILED;
        L33:
            return DoraUnbindState.SERVER_UNBIND_NETWORK_ERROR;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r104);
            kj4.a.g();
            r102.label = 1;
            r104 = DoraAdapterExtKt.D(r100, r102);
            if (r104 != r105) goto L17;
            return r105;
        L7:
            r102 = new DoraUnbindStep$API$step$1(this, r101);
            goto L8
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0016¨\u0006\b"}, d2 = {"com/larus/dora/impl/device/settings/unbind/DoraUnbindStep.CLEAR", "Lcom/larus/dora/impl/device/settings/unbind/DoraUnbindStep;", "step", "Lcom/larus/dora/impl/device/settings/unbind/DoraUnbindState;", "device", "Lcom/bytedance/dora/device/DoraDevice;", "(Lcom/bytedance/dora/device/DoraDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", TeaEventTrack.ACTION_DRAMA_NEXT, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CLEAR extends DoraUnbindStep {
        @Override // com.larus.dora.impl.device.settings.unbind.DoraUnbindStep
        public DoraUnbindStep next() {
            return null;
        }

        public CLEAR(String r100, int r101) {
            super(r100, r101, null);
        }

        @Override // com.larus.dora.impl.device.settings.unbind.DoraUnbindStep
        public Object step(DoraDevice r100, Continuation<? super DoraUnbindState> r101) {
            if ((r101 instanceof DoraUnbindStep$CLEAR$step$1) == false) goto L7;
            DoraUnbindStep$CLEAR$step$1 r102 = (DoraUnbindStep$CLEAR$step$1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r102.label;
            if (r106 == 0) goto L16;
            if (r106 == 1) goto L15;
            if (r106 != 2) goto L14;
            ResultKt.throwOnFailure(r104);
        L23:
            return DoraUnbindState.UNBIND_SUCCESS;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            r100 = (DoraDevice) r102.L$0;
            ResultKt.throwOnFailure(r104);
        L19:
            kj4.a r107 = kj4.a.g();
            r102.L$0 = null;
            r102.label = 2;
            if (DoraAdapterExtKt.f(r107, r100) != r105) goto L23;
            return r105;
        L16:
            ResultKt.throwOnFailure(r104);
            DoraGGestureSettingsRepository.f334370a.b(r100.f204389mac);
            kj4.a r108 = kj4.a.g();
            r102.L$0 = r100;
            r102.label = 1;
            if (DoraAdapterExtKt.R(r108, true) != r105) goto L19;
            return r105;
        L7:
            r102 = new DoraUnbindStep$CLEAR$step$1(this, r101);
            goto L8
        }
    }

    public DoraUnbindStep() {
        throw null;
    }

    public static EnumEntries<DoraUnbindStep> getEntries() {
        return f334937b;
    }

    public abstract DoraUnbindStep next();

    public abstract Object step(DoraDevice r100, Continuation<? super DoraUnbindState> r101);

    static {
        API r100 = new API("API", 0);
        API = r100;
        final String r101 = "RESET";
        final int r102 = 1;
        DoraUnbindStep r103 = new RESET(r101, r102);
        RESET = r103;
        CLEAR r104 = new CLEAR("CLEAR", 2);
        CLEAR = r104;
        DoraUnbindStep[] r105 = {r100, r103, r104};
        f334936a = r105;
        f334937b = EnumEntriesKt.enumEntries(r105);
    }

    public static DoraUnbindStep[] values() {
        return (DoraUnbindStep[]) f334936a.clone();
    }

    public static DoraUnbindStep valueOf(String r100) {
        return (DoraUnbindStep) r27.a.a(DoraUnbindStep.class, r100);
    }

    public DoraUnbindStep(String r100, int r101, DefaultConstructorMarker r102) {
        super(r100, r101);
    }
}
