package com.obric.assistant.chat;

import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.tts.TtsSwitchMode;
import com.obric.assistant.wakeup.bluetooth_headset.api.BlueDeviceConnectState;
import com.obric.assistant.wakeup.bluetooth_headset.api.BlueDeviceSwitchState;
import com.obric.assistant.wakeup.bluetooth_headset.api.BlueProductIdEnum;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Map;
import java.util.UUID;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes4.dex */
public final class ObricChatTtsIconManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static TtsSwitchMode f386581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static TtsSwitchMode f386582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final UUID f386583c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final StateFlowImpl f386584d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final StateFlowImpl f386585e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final MutableSharedFlow<Long> f386586f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final StateFlowImpl f386587g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Map<BlueIcon, Integer[]> f386588h = null;

    /* JADX INFO: renamed from: com.obric.assistant.chat.ObricChatTtsIconManager$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.chat.ObricChatTtsIconManager$1", f = "ObricChatTtsIconManager.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.obric.assistant.chat.ObricChatTtsIconManager$1$a */
        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<T> f386589a = null;

            static {
                f386589a = new a();
            }

            public a() {
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object r100, Continuation r101) {
                TtsSwitchMode r102 = (TtsSwitchMode) r100;
                FLogger.f375446a.i("ObricChatTtsIconManager", "RECV MODE ----->  " + r102);
                ObricChatTtsIconManager.f386585e.setValue(Boxing.boxInt(r102.getIndex()));
                Unit r103 = Unit.INSTANCE;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return r103;
            }
        }

        public AnonymousClass1(Continuation<? super AnonymousClass1> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L6;
            ResultKt.throwOnFailure(r100);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            StateFlowImpl r103 = ObricChatTtsIconManager.f386584d;
            FlowCollector r104 = a.f386589a;
            this.label = 1;
            if (r103.collect(r104, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.chat.ObricChatTtsIconManager$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.chat.ObricChatTtsIconManager$2", f = "ObricChatTtsIconManager.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.obric.assistant.chat.ObricChatTtsIconManager$2$a */
        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<T> f386590a = null;

            static {
                f386590a = new a();
            }

            public a() {
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object r100, Continuation r101) {
                vha.a r102 = (vha.a) r100;
                FLogger.f375446a.i("ObricChatTtsIconManager", "RECV DORA CHANGED ----->  " + r102);
                if ((r102 instanceof vha.a.C8007a) == false) goto L10;
                Object r103 = ObricChatTtsIconManager.f386586f.emit(Boxing.boxLong(System.currentTimeMillis()), r101);
                if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
                return r103;
            L8:
                return Unit.INSTANCE;
            L10:
                throw new NoWhenBranchMatchedException();
            }
        }

        public AnonymousClass2(Continuation<? super AnonymousClass2> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L6;
            ResultKt.throwOnFailure(r100);
        L16:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            CoWakeupApi r103 = uha.a.a();
            if (r103 == null) goto L18;
            MutableSharedFlow r104 = r103.d();
            if (r104 == null) goto L18;
            FlowCollector r105 = a.f386590a;
            this.label = 1;
            if (r104.collect(r105, this) != r101) goto L16;
            return r101;
        L18:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/chat/ObricChatTtsIconManager$BlueDeviceType;", "", "index", "", "str", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getIndex", "()I", "getStr", "()Ljava/lang/String;", "FALLBACK_SPEAKER", "HEADSET", "DORA_LITE", "COMMON", "DORA_H_FREE_CLIP2", "DORA_H_FREE_BUDS_PRO5", "WATCH", "BAND", "CARKIT", "LOUDSPEAKER", "HEADPHONES", "GLASSES", "DORA_G", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BlueDeviceType extends Enum<BlueDeviceType> {
        public static final BlueDeviceType BAND = null;
        public static final BlueDeviceType CARKIT = null;
        public static final BlueDeviceType COMMON = null;
        public static final BlueDeviceType DORA_G = null;
        public static final BlueDeviceType DORA_H_FREE_BUDS_PRO5 = null;
        public static final BlueDeviceType DORA_H_FREE_CLIP2 = null;
        public static final BlueDeviceType DORA_LITE = null;
        public static final BlueDeviceType FALLBACK_SPEAKER = null;
        public static final BlueDeviceType GLASSES = null;
        public static final BlueDeviceType HEADPHONES = null;
        public static final BlueDeviceType HEADSET = null;
        public static final BlueDeviceType LOUDSPEAKER = null;
        public static final BlueDeviceType WATCH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BlueDeviceType[] f386591a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f386592b = null;
        private final int index;
        private final String str;

        public static EnumEntries<BlueDeviceType> getEntries() {
            return f386592b;
        }

        static {
            BlueDeviceType r100 = new BlueDeviceType("FALLBACK_SPEAKER", 0, -1, "not any bluetooth device , usually unknown device or something! Fallback ");
            FALLBACK_SPEAKER = r100;
            BlueDeviceType r101 = new BlueDeviceType("HEADSET", 1, 0, "3rd party bluetooth headset hfp");
            HEADSET = r101;
            BlueDeviceType r102 = new BlueDeviceType("DORA_LITE", 2, 1, "dora / ola friend / ola lite");
            DORA_LITE = r102;
            BlueDeviceType r103 = new BlueDeviceType("COMMON", 3, 2, "3rd party bluetooth device");
            COMMON = r103;
            BlueDeviceType r104 = new BlueDeviceType("DORA_H_FREE_CLIP2", 4, 3, "dora-free_clip2");
            DORA_H_FREE_CLIP2 = r104;
            BlueDeviceType r105 = new BlueDeviceType("DORA_H_FREE_BUDS_PRO5", 5, 4, "dora-free_buds_pro5");
            DORA_H_FREE_BUDS_PRO5 = r105;
            BlueDeviceType r110 = new BlueDeviceType("WATCH", 6, 5, "watch device");
            WATCH = r110;
            BlueDeviceType r111 = new BlueDeviceType("BAND", 7, 6, "band device");
            BAND = r111;
            BlueDeviceType r112 = new BlueDeviceType("CARKIT", 8, 7, "carkit / device in the car");
            CARKIT = r112;
            BlueDeviceType r113 = new BlueDeviceType("LOUDSPEAKER", 9, 8, "soundbox or loud speaker");
            LOUDSPEAKER = r113;
            BlueDeviceType r114 = new BlueDeviceType("HEADPHONES", 10, 9, "headphone");
            HEADPHONES = r114;
            BlueDeviceType r106 = new BlueDeviceType("GLASSES", 11, 10, "glasses");
            GLASSES = r106;
            BlueDeviceType r107 = new BlueDeviceType("DORA_G", 12, 11, "dora g glasses");
            DORA_G = r107;
            BlueDeviceType[] r108 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107};
            f386591a = r108;
            f386592b = EnumEntriesKt.enumEntries(r108);
        }

        public static BlueDeviceType[] values() {
            return (BlueDeviceType[]) f386591a.clone();
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getStr() {
            return this.str;
        }

        public static BlueDeviceType valueOf(String r100) {
            return (BlueDeviceType) r27.a.a(BlueDeviceType.class, r100);
        }

        public BlueDeviceType(String r100, int r101, int r102, String r103) {
            super(r100, r101);
            this.index = r102;
            this.str = r103;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/chat/ObricChatTtsIconManager$BlueIcon;", "", RXScreenCaptureService.KEY_INDEX, "", "<init>", "(Ljava/lang/String;II)V", "getI", "()I", "ON", "OFF", "BLACK", "SUBSCRIBE", "GREY_DEFAULT", "GREY_DARK", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BlueIcon extends Enum<BlueIcon> {
        public static final BlueIcon BLACK = null;
        public static final BlueIcon GREY_DARK = null;
        public static final BlueIcon GREY_DEFAULT = null;
        public static final BlueIcon OFF = null;
        public static final BlueIcon ON = null;
        public static final BlueIcon SUBSCRIBE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BlueIcon[] f386593a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f386594b = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int f386595i;

        public static EnumEntries<BlueIcon> getEntries() {
            return f386594b;
        }

        static {
            BlueIcon r100 = new BlueIcon("ON", 0, 0);
            ON = r100;
            BlueIcon r101 = new BlueIcon("OFF", 1, 1);
            OFF = r101;
            BlueIcon r102 = new BlueIcon("BLACK", 2, 2);
            BLACK = r102;
            BlueIcon r103 = new BlueIcon("SUBSCRIBE", 3, 3);
            SUBSCRIBE = r103;
            BlueIcon r104 = new BlueIcon("GREY_DEFAULT", 4, 4);
            GREY_DEFAULT = r104;
            BlueIcon r105 = new BlueIcon("GREY_DARK", 5, 5);
            GREY_DARK = r105;
            BlueIcon[] r110 = {r100, r101, r102, r103, r104, r105};
            f386593a = r110;
            f386594b = EnumEntriesKt.enumEntries(r110);
        }

        public static BlueIcon[] values() {
            return (BlueIcon[]) f386593a.clone();
        }

        public final int getI() {
            return this.f386595i;
        }

        public static BlueIcon valueOf(String r100) {
            return (BlueIcon) r27.a.a(BlueIcon.class, r100);
        }

        public BlueIcon(String r100, int r101, int r102) {
            super(r100, r101);
            this.f386595i = r102;
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f386596a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f386597b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f386598c = null;

        static {
            int[] r100 = new int[TtsSwitchMode.values().length];
            r100[TtsSwitchMode.BuildInMicMode.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L43:
            r100[TtsSwitchMode.BluetoothMicMode.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L6:
            f386596a = r100;
            int[] r101 = new int[BlueDeviceConnectState.values().length];
            r101[BlueDeviceConnectState.NA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L55:
            r101[BlueDeviceConnectState.CONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L47:
            r101[BlueDeviceConnectState.DISCONNECTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L11:
            f386597b = r101;
            int[] r102 = new int[BlueDeviceSwitchState.values().length];
            r102[BlueDeviceSwitchState.OFF.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L13:
            f386598c = r102;
            int[] r103 = new int[BlueProductIdEnum.values().length];
            r103[BlueProductIdEnum.GLASS_DORA_G.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L49:
            r103[BlueProductIdEnum.GLASS_DORA_G2.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L35:
            r103[BlueProductIdEnum.HEADSET_OLA_FRIEND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L51:
            r103[BlueProductIdEnum.HEADSET_HW_FREEBUDS_PRO5_1.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L39:
            r103[BlueProductIdEnum.HEADSET_HW_FREEBUDS_PRO5_2.ordinal()] = 5;     // Catch: NoSuchFieldError -> L31
        L41:
            r103[BlueProductIdEnum.HEADSET_HW_FREECLIP2.ordinal()] = 6;     // Catch: NoSuchFieldError -> L32
            return;
        }
    }

    static {
        TtsSwitchMode r100 = TtsSwitchMode.InitMode;
        f386581a = r100;
        f386582b = r100;
        f386583c = UUID.randomUUID();
        f386584d = kotlinx.coroutines.flow.j1.a(r100);
        f386585e = kotlinx.coroutines.flow.j1.a(Integer.valueOf(r100.getIndex()));
        f386586f = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        f386587g = kotlinx.coroutines.flow.j1.a(Boolean.TRUE);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), null, null, new AnonymousClass1(null), 3, null);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), null, null, new AnonymousClass2(null), 3, null);
        f386588h = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(BlueIcon.ON, new Integer[]{Integer.valueOf(R.drawable.obric_tts_bluetooth_icon_on), Integer.valueOf(R.drawable.obric_oladance_earphone_on), Integer.valueOf(R.drawable.obric_tts_bluetooth_common_on), Integer.valueOf(R.drawable.obric_freeclip2_earphone_on), Integer.valueOf(R.drawable.obric_freebuds_pro5_earphone_on), Integer.valueOf(R.drawable.obric_tts_bluetooth_watch_on), Integer.valueOf(R.drawable.obric_tts_bluetooth_band_on), Integer.valueOf(R.drawable.obric_tts_bluetooth_car_on), Integer.valueOf(R.drawable.obric_tts_bluetooth_speaker_on), Integer.valueOf(R.drawable.obric_tts_bluetooth_headphone_on), Integer.valueOf(R.drawable.obric_tts_bluetooth_glasses_on), Integer.valueOf(R.drawable.obric_tts_bluetooth_dorag_on)}), TuplesKt.to(BlueIcon.OFF, new Integer[]{Integer.valueOf(R.drawable.obric_tts_bluetooth_icon_off), Integer.valueOf(R.drawable.obric_oladance_earphone_off), Integer.valueOf(R.drawable.obric_tts_bluetooth_common_off), Integer.valueOf(R.drawable.obric_freeclip2_earphone_off), Integer.valueOf(R.drawable.obric_freebuds_pro5_earphone_off), Integer.valueOf(R.drawable.obric_tts_bluetooth_watch_off), Integer.valueOf(R.drawable.obric_tts_bluetooth_band_off), Integer.valueOf(R.drawable.obric_tts_bluetooth_car_off), Integer.valueOf(R.drawable.obric_tts_bluetooth_speaker_off), Integer.valueOf(R.drawable.obric_tts_bluetooth_headphone_off), Integer.valueOf(R.drawable.obric_tts_bluetooth_glasses_off), Integer.valueOf(R.drawable.obric_tts_bluetooth_dorag_off)}), TuplesKt.to(BlueIcon.BLACK, new Integer[]{Integer.valueOf(R.drawable.obric_tts_bluetooth_icon_on_black), Integer.valueOf(R.drawable.obric_oladance_earphone_on_black), Integer.valueOf(R.drawable.obric_tts_bluetooth_common_black), Integer.valueOf(R.drawable.obric_freeclip2_earphone_on_black), Integer.valueOf(R.drawable.obric_freebuds_pro5_earphone_on_black), Integer.valueOf(R.drawable.obric_tts_bluetooth_watch_on_black), Integer.valueOf(R.drawable.obric_tts_bluetooth_band_on_black), Integer.valueOf(R.drawable.obric_tts_bluetooth_car_on_black), Integer.valueOf(R.drawable.obric_tts_bluetooth_speaker_on_black), Integer.valueOf(R.drawable.obric_tts_bluetooth_headphone_on_black), Integer.valueOf(R.drawable.obric_tts_bluetooth_glasses_on_black), Integer.valueOf(R.drawable.obric_tts_bluetooth_dorag_on_black)}), TuplesKt.to(BlueIcon.SUBSCRIBE, new Integer[]{Integer.valueOf(R.drawable.obric_tts_bluetooth_icon_on_subscribe), Integer.valueOf(R.drawable.obric_oladance_earphone_on_subscribe), Integer.valueOf(R.drawable.obric_tts_bluetooth_common_subscribe), Integer.valueOf(R.drawable.obric_freeclip2_earphone_on_subscribe), Integer.valueOf(R.drawable.obric_freebuds_pro5_earphone_on_subscribe), Integer.valueOf(R.drawable.obric_tts_bluetooth_watch_on_subscribe), Integer.valueOf(R.drawable.obric_tts_bluetooth_band_on_subscribe), Integer.valueOf(R.drawable.obric_tts_bluetooth_car_on_subscribe), Integer.valueOf(R.drawable.obric_tts_bluetooth_speaker_on_subscribe), Integer.valueOf(R.drawable.obric_tts_bluetooth_headphone_on_subscribe), Integer.valueOf(R.drawable.obric_tts_bluetooth_glasses_on_subscribe), Integer.valueOf(R.drawable.obric_tts_bluetooth_dorag_on_subscribe)}), TuplesKt.to(BlueIcon.GREY_DEFAULT, new Integer[]{Integer.valueOf(R.drawable.obric_tts_bluetooth_icon_in_dora_by_default), Integer.valueOf(R.drawable.obric_oladance_earphone_on_in_dora), Integer.valueOf(R.drawable.obric_tts_bluetooth_common_grey_default), Integer.valueOf(R.drawable.obric_freeclip2_earphone_on_in_dora), Integer.valueOf(R.drawable.obric_freebuds_pro5_earphone_on_in_dora), Integer.valueOf(R.drawable.obric_tts_bluetooth_watch_in_dora_by_default), Integer.valueOf(R.drawable.obric_tts_bluetooth_band_in_dora_by_default), Integer.valueOf(R.drawable.obric_tts_bluetooth_car_in_dora_by_default), Integer.valueOf(R.drawable.obric_tts_bluetooth_speaker_in_dora_by_default), Integer.valueOf(R.drawable.obric_tts_bluetooth_headphone_in_dora_by_default), Integer.valueOf(R.drawable.obric_tts_bluetooth_glasses_in_dora_by_default), Integer.valueOf(R.drawable.obric_tts_bluetooth_dorag_on_in_dora_by_default)}), TuplesKt.to(BlueIcon.GREY_DARK, new Integer[]{Integer.valueOf(R.drawable.obric_tts_bluetooth_icon_in_dora_in_dark), Integer.valueOf(R.drawable.obric_oladance_earphone_on_in_dora_dark), Integer.valueOf(R.drawable.obric_tts_bluetooth_common_grey_dark), Integer.valueOf(R.drawable.obric_freeclip2_earphone_on_in_dora_dark), Integer.valueOf(R.drawable.obric_freebuds_pro5_earphone_on_in_dora_dark), Integer.valueOf(R.drawable.obric_tts_bluetooth_watch_in_dora_in_dark), Integer.valueOf(R.drawable.obric_tts_bluetooth_band_in_dora_in_dark), Integer.valueOf(R.drawable.obric_tts_bluetooth_car_in_dora_in_dark), Integer.valueOf(R.drawable.obric_tts_bluetooth_speaker_in_dora_in_dark), Integer.valueOf(R.drawable.obric_tts_bluetooth_headphone_in_dora_in_dark), Integer.valueOf(R.drawable.obric_tts_bluetooth_glasses_in_dora_in_dark), Integer.valueOf(R.drawable.obric_tts_bluetooth_dorag_on_in_dora_dark)})});
    }

    public static boolean a() {
        IBluetoothHeadSetAPI r100 = tha.c.a();
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.h() != true) goto L7;
    L8:
        FLogger.f375446a.d("ObricChatTtsIconManager", "isA2dpConnected " + r101);
        return r101;
    L7:
        r101 = false;
        goto L8
    }

    public static boolean b() {
        IBluetoothHeadSetAPI r100 = tha.c.a();
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.a() != true) goto L7;
    L8:
        FLogger.f375446a.d("ObricChatTtsIconManager", "isHeadsetConnected " + r101);
        return r101;
    L7:
        r101 = false;
        goto L8
    }

    public static void c(TtsSwitchMode r110) {
        Intrinsics.checkNotNullParameter(r110, "mode");
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("switchTo mode ");
        r101.append(r110);
        r101.append(" , and current Mode is ");
        r101.append(f386581a);
        r101.append(" ttsChecked ");
        IObricChatService.f386556a.getClass();
        IObricChatService r102 = IObricChatService.a.a();
        if (r102 == null) goto L5;
        Boolean r103 = Boolean.valueOf(r102.k());
    L6:
        r101.append(r103);
        r101.append(' ');
        r100.i("ObricChatTtsIconManager", r101.toString());
        TtsSwitchMode r104 = f386581a;
        if (r104 != r110) goto L10;
        r100.i("ObricChatTtsIconManager", "switchTo mode " + r110 + " , same mode , not continue !!");
        return;
    L10:
        f386582b = r104;
        f386581a = r110;
        int r105 = a.f386596a[r110.ordinal()];
        if (r105 != 1) goto L13;
        com.obric.assistant.t1 r106 = com.obric.assistant.t1.f393353a;
        int r107 = r106.s("tts_play_mode_restore_build_in_mic");
        int r108 = r106.s("tts_play_mode_bluetooth_mic_switch");
        IObricChatService r111 = IObricChatService.a.a();
        if (r111 == null) goto L40;
        boolean r112 = r111.k();
    L41:
        if (r108 != (-1)) goto L43;
    L45:
        r100.i("ObricChatTtsIconManager", "switchTo mode BUILD IN MODE , value is buildIn? " + r107 + "  bluetooth? " + r108 + "  ttsEnable? " + r112);
        if (r107 == (-1)) goto L56;
        if (r107 == 0) goto L50;
        if (r107 == 1) goto L56;
    L62:
        BuildersKt.runBlocking$default(null, new ObricChatTtsIconManager$switchTo$1(r110, null), 1, null);
        return;
    L50:
        if (r112 == false) goto L54;
        r100.i("ObricChatTtsIconManager", "switchTo mode A2 set ttsEnable to false");
        IObricChatService r109 = IObricChatService.a.a();
        if (r109 == null) goto L55;
        r109.n(false);
    L55:
        r100.i("ObricChatTtsIconManager", "switchTo mode A3");
        goto L62
    L54:
        r100.i("ObricChatTtsIconManager", "switchTo mode A2 do nothing");
    L56:
        if (r112 == true) goto L60;
        r100.i("ObricChatTtsIconManager", "switchTo mode A0 set TTS to true caused by the ttsEnable is false ,need change it ");
        IObricChatService r113 = IObricChatService.a.a();
        if (r113 == null) goto L61;
        r113.n(true);
    L61:
        r100.i("ObricChatTtsIconManager", "switchTo mode A1");
        goto L62
    L60:
        r100.i("ObricChatTtsIconManager", "switchTo mode A0 do nothing");
        goto L61
    L43:
        if (f386582b != TtsSwitchMode.BluetoothMicMode) goto L45;
        r106.C("tts_play_mode_bluetooth_mic_switch", r112);
        goto L45
    L40:
        r112 = false;
        goto L41
    L13:
        if (r105 != 2) goto L62;
        com.obric.assistant.t1 r114 = com.obric.assistant.t1.f393353a;
        int r115 = r114.s("tts_play_mode_bluetooth_mic_switch");
        IObricChatService r116 = IObricChatService.a.a();
        if (r116 == null) goto L18;
        boolean r117 = r116.k();
    L19:
        r114.C("tts_play_mode_restore_build_in_mic", r117);
        r100.i("ObricChatTtsIconManager", "switchTo mode BLUETOOTH MODE blueSwitch " + r115 + " ,  current tts " + r117);
        if (r115 == (-1)) goto L31;
        if (r115 == 0) goto L24;
        if (r115 == 1) goto L31;
    L24:
        if (r117 == false) goto L29;
        IObricChatService r118 = IObricChatService.a.a();
        if (r118 == null) goto L28;
        r118.n(false);
    L28:
        r100.i("ObricChatTtsIconManager", "switchTo mode B2 set TTS to false");
    L30:
        r100.i("ObricChatTtsIconManager", "switchTo mode B3");
        goto L62
    L29:
        r100.i("ObricChatTtsIconManager", "switchTo mode B2 do nothing");
    L31:
        if (r117 == false) goto L33;
        r100.i("ObricChatTtsIconManager", "switchTo mode B0 do nothing");
    L36:
        r100.i("ObricChatTtsIconManager", "switchTo mode B1");
        goto L62
    L33:
        r100.i("ObricChatTtsIconManager", "switchTo mode B0 set TTS to true");
        IObricChatService r119 = IObricChatService.a.a();
        if (r119 == null) goto L36;
        r119.n(true);
        goto L36
    L18:
        r117 = false;
        goto L19
    L5:
        r103 = null;
        goto L6
    }
}
