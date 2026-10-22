package com.larus.dora.impl.device.manage.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.common_ui.widget.roundlayout.RoundRelativeLayout;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.databinding.LarusItemDoraGDeviceManagementRecordMinutesBinding;
import com.larus.dora.impl.device.manage.LifecycleUIComponent;
import com.larus.dora.impl.device.manage.p0;
import com.larus.dora.impl.device.manage.t0;
import com.larus.nova.R;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 42\u00020\u0001:\u000245B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u001bH\u0002J\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u000fH\u0002J\u0018\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u000fH\u0002J\u0010\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u001aH\u0002J\u0010\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u000fH\u0002J\b\u00103\u001a\u00020\u001bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/larus/dora/impl/device/manage/holder/RecordMinutesUIComponent;", "Lcom/larus/dora/impl/device/manage/LifecycleUIComponent;", "<init>", "()V", "_binding", "Lcom/larus/dora/impl/databinding/LarusItemDoraGDeviceManagementRecordMinutesBinding;", "binding", "getBinding", "()Lcom/larus/dora/impl/databinding/LarusItemDoraGDeviceManagementRecordMinutesBinding;", "cardState", "Lcom/larus/dora/impl/device/manage/holder/RecordMinutesUIComponent$CardState;", "isOnlineRecording", "", "isOfflineRecording", "selectDeviceMac", "", "selectDeviceIsConnected", "Ljava/lang/Boolean;", "avLinkService", "Lcom/larus/avlink/api/IDoraAVLinkService;", "getAvLinkService", "()Lcom/larus/avlink/api/IDoraAVLinkService;", "avLinkService$delegate", "Lkotlin/Lazy;", "durationListener", "Lkotlin/Function1;", "", "", "recordingUpdateListener", "offlineRecordingUpdateListener", "onCreateAndSetupView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onBind", "data", "Lcom/larus/dora/impl/device/manage/DoraGDeviceManagementListItem;", "initView", "renderCurrentState", "source", "adjustViewState", "newState", "formatDuration", "seconds", "onDeviceSwitch", "event", "Lcom/larus/dora/impl/device/manage/DeviceSwitchEvent;", "reportClickEvent", "button", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "CardState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecordMinutesUIComponent extends LifecycleUIComponent {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f333804n = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusItemDoraGDeviceManagementRecordMinutesBinding f333805d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CardState f333806e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f333807f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f333808g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f333809h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Boolean f333810i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f333811j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final y f333812k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final z f333813l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a0 f333814m;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/device/manage/holder/RecordMinutesUIComponent$CardState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "ONLINE_RECORDING", "OFFLINE_RECORDING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CardState extends Enum<CardState> {
        public static final CardState IDLE = null;
        public static final CardState OFFLINE_RECORDING = null;
        public static final CardState ONLINE_RECORDING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CardState[] f333815a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f333816b = null;

        public static EnumEntries<CardState> getEntries() {
            return f333816b;
        }

        static {
            CardState r100 = new CardState("IDLE", 0);
            IDLE = r100;
            CardState r101 = new CardState("ONLINE_RECORDING", 1);
            ONLINE_RECORDING = r101;
            CardState r102 = new CardState("OFFLINE_RECORDING", 2);
            OFFLINE_RECORDING = r102;
            CardState[] r103 = {r100, r101, r102};
            f333815a = r103;
            f333816b = EnumEntriesKt.enumEntries(r103);
        }

        public static CardState[] values() {
            return (CardState[]) f333815a.clone();
        }

        public static CardState valueOf(String r100) {
            return (CardState) r27.a.a(CardState.class, r100);
        }

        public CardState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f333817a = null;

        static {
            int[] r100 = new int[CardState.values().length];
            r100[CardState.ONLINE_RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[CardState.OFFLINE_RECORDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[CardState.IDLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f333817a = r100;
        }
    }

    static {
    }

    public final IDoraAVLinkService h() {
        return (IDoraAVLinkService) this.f333811j.getValue();
    }

    public final LarusItemDoraGDeviceManagementRecordMinutesBinding i() {
        LarusItemDoraGDeviceManagementRecordMinutesBinding r100 = this.f333805d;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.dora.impl.device.manage.holder.y] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.dora.impl.device.manage.holder.z] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.dora.impl.device.manage.holder.a0] */
    public RecordMinutesUIComponent() {
        this.f333811j = LazyKt.lazy(new x());
        this.f333812k = new y(this);
        this.f333813l = new z(this);
        this.f333814m = new a0(this);
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void onDestroy() {
        super.onDestroy();
        IDoraAVLinkService r100 = h();
        if (r100 == null) goto L5;
        r100.y0(this.f333812k);
    L5:
        IDoraAVLinkService r101 = h();
        if (r101 == null) goto L8;
        r101.L0(this.f333813l);
    L8:
        IDoraAVLinkService r102 = h();
        if (r102 == null) goto L12;
        r102.g1(this.f333814m);
        return;
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void b(p0 r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Boolean r101 = null;
        if ((r100 instanceof t0) == false) goto L5;
        t0 r102 = (t0) r100;
    L6:
        if (r102 == null) goto L8;
        r101 = Boolean.valueOf(r102.f334013e);
    L8:
        this.f333810i = r101;
        IDoraAVLinkService r103 = h();
        boolean r104 = false;
        if (r103 != null) goto L11;
    L13:
        boolean r105 = false;
    L14:
        this.f333807f = r105;
        IDoraAVLinkService r106 = h();
        if (r106 != null) goto L17;
    L19:
        this.f333808g = r104;
        j("onBind");
        return;
    L17:
        if (r106.d() != true) goto L19;
        r104 = true;
        goto L19
    L11:
        if (r103.Y0() != true) goto L13;
        r105 = true;
        goto L14
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void e(com.larus.dora.impl.device.manage.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        com.larus.dora.impl.device.manage.c r101 = r100.f333694a;
        Boolean r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.f333707c;
    L6:
        this.f333809h = r103;
        if (r101 == null) goto L9;
        r102 = Boolean.valueOf(r101.f333710f);
    L9:
        this.f333810i = r102;
        j("onDeviceSwitch");
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void j(String r100) {
        if (this.f333807f == false) goto L6;
        CardState r101 = CardState.ONLINE_RECORDING;
    L9:
        g49.d.d("RecordMinutesUIComponent", "adjustViewState from " + r100 + ", state=" + r101);
        if (r101 != CardState.IDLE) goto L19;
        this.f333806e = r101;
        e1.o(i().f333398e);
        i().f333398e.setText("00:00:00");
        i().f333396c.cancelAnimation();
        e1.o(i().f333396c);
        e1.x(i().f333397d);
        i().f333395b.setText(R.string.larus_dora_g_device_start_record_cn);
        Boolean r102 = this.f333810i;
        if (r102 == null) goto L14;
        boolean r103 = r102.booleanValue();
    L15:
        if (r103 == false) goto L17;
        i().f333395b.setTextColorWithPress(ve8.d.a(R.color.larus_neutral_100, i().f333394a.getContext()));
        return;
    L17:
        i().f333395b.setTextColorWithPress(ve8.d.a(R.color.larus_neutral_transparent_3, i().f333394a.getContext()));
        return;
    L14:
        r103 = o59.a.k(DoraAdapterExtKt.h(kj4.a.g()));
        goto L15
    L19:
        if (this.f333806e == r101) goto L33;
        this.f333806e = r101;
        if (r101 != CardState.ONLINE_RECORDING) goto L24;
        e1.x(i().f333398e);
    L25:
        e1.x(i().f333396c);
        boolean r104 = v19.h.f552477a;
        if (v19.h.b(i().f333394a.getContext()) == false) goto L28;
        i().f333396c.addLottieOnCompositionLoadedListener(new w(this));
    L29:
        e1.o(i().f333397d);
        i().f333395b.setText(R.string.larus_dora_g_device_stop_record_cn);
        i().f333395b.setTextColorWithPress(ve8.d.a(R.color.larus_conditional_danger_50, i().f333394a.getContext()));
        return;
    L28:
        i().f333396c.playAnimation();
        goto L29
    L24:
        e1.o(i().f333398e);
        i().f333398e.setText("00:00:00");
        goto L25
    L33:
        return;
    L6:
        if (this.f333808g == false) goto L8;
        r101 = CardState.OFFLINE_RECORDING;
        goto L9
    L8:
        r101 = CardState.IDLE;
        goto L9
    }

    public final void k(String r100) {
        DoraBuryPointManager.f331862a.L("dora_card_click", MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, "device_management"), TuplesKt.to("card_content_type", "dora_voice_memos"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r100)}));
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final View c(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        View r102 = r100.inflate(R.layout.larus_item_dora_g_device_management_record_minutes, r101, false);
        int r103 = R.id.btn_start_record;
        RoundTextView r104 = (RoundTextView) ViewBindings.findChildViewById(r102, R.id.btn_start_record);
        if (r104 == null) goto L24;
        r103 = R.id.icon_recording;
        if (((ImageView) ViewBindings.findChildViewById(r102, R.id.icon_recording)) == null) goto L24;
        r103 = R.id.lottie_recording;
        LottieAnimationView r105 = (LottieAnimationView) ViewBindings.findChildViewById(r102, R.id.lottie_recording);
        if (r105 == null) goto L24;
        r103 = R.id.tv_recording_desc;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r102, R.id.tv_recording_desc);
        if (r106 == null) goto L24;
        r103 = R.id.tv_recording_time;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r102, R.id.tv_recording_time);
        if (r107 == null) goto L24;
        RoundRelativeLayout r108 = (RoundRelativeLayout) r102;
        this.f333805d = new LarusItemDoraGDeviceManagementRecordMinutesBinding(r108, r104, r105, r106, r107);
        IDoraAVLinkService r109 = h();
        if (r109 == null) goto L15;
        r109.t1(this.f333812k);
    L15:
        IDoraAVLinkService r110 = h();
        if (r110 == null) goto L18;
        r110.h1(this.f333813l);
    L18:
        IDoraAVLinkService r111 = h();
        if (r111 == null) goto L21;
        r111.T0(this.f333814m);
    L21:
        e1.d(i().f333394a, new q(this));
        e1.d(i().f333395b, new v(this));
        i().f333396c.setAnimation(com.larus.dora.impl.util.u.f338158a.b("larus_dora_record_minutes_wave"));
        return r108;
    L24:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
