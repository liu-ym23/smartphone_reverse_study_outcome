package com.obric.assistant.omnidetailpage.componment;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.Message;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0002J\u000e\u0010\u0017\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0082@¢\u0006\u0002\u0010\u0018J\u0012\u0010\u001b\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001aH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/omnidetailpage/componment/OmniDetailTrackComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/omnidetailpage/componment/IOmniDetailTrackAbility;", "<init>", "()V", "traceInfo", "Landroid/os/Bundle;", "hasReportedShow", "", "omniParam", "Lcom/obric/assistant/omnidetailpage/model/OmniDetailParam;", "getOmniParam", "()Lcom/obric/assistant/omnidetailpage/model/OmniDetailParam;", "omniParam$delegate", "Lkotlin/Lazy;", "onAttach", "", "onParentViewCreated", "reportItemClick", "itemName", "", "reportStopClick", "reportShowEvent", "getTraceInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findCurrentMessage", "Lcom/larus/im/bean/message/Message;", "getInstructionType", "message", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniDetailTrackComponent extends ComponentFeature implements e {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f390768k = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Bundle f390769h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f390770i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f390771j;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void B2() {
        if (this.f390770i == true) goto L7;
        this.f390770i = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new OmniDetailTrackComponent$reportShowEvent$1(this, null), 3, null);
        return;
    }

    public final ifa.e P2() {
        return (ifa.e) this.f390771j.getValue();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, e.class);
    }

    public OmniDetailTrackComponent() {
        this.f390771j = LazyKt.lazy(new b0(this));
    }

    @Override // com.obric.assistant.omnidetailpage.componment.e
    public final void Hy() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new OmniDetailTrackComponent$reportStopClick$1(this, null), 3, null);
    }

    public final Object L2(Continuation<? super Message> r100) {
        ifa.e r101 = P2();
        if (r101 == null) goto L17;
        String r102 = r101.f489680e;
        if (r102 == null) goto L17;
        if (r102.length() <= 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == true) goto L13;
        r102 = null;
    L13:
        if (r102 == null) goto L17;
        return BuildersKt.withContext(Dispatchers.getIO(), new OmniDetailTrackComponent$findCurrentMessage$2(r102, null), r100);
    L9:
        r103 = false;
    L17:
        return null;
    }

    public final String N2(Message r100) {
        ifa.e r101 = P2();
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.f489683h;
    L6:
        String r104 = "";
        if (r103 != null) goto L10;
        r103 = "";
    L10:
        if (r103.length() != 0) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == false) goto L28;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r106 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r106 == null) goto L20;
        String r107 = r106.getString("o_omni_instruction_type");
        if (r107 == null) goto L20;
        r104 = r107;
    L27:
        r103 = r104;
    L20:
        if (r100 == null) goto L24;
        Map<String, String> r108 = r100.getExt();
        if (r108 == null) goto L24;
        r102 = r108.get("o_omni_instruction_type");
    L24:
        if (r102 == null) goto L27;
        r104 = r102;
    L28:
        ifa.e r109 = P2();
        if (r109 == null) goto L31;
        r109.f489683h = r103;
    L31:
        return r103;
    L12:
        r105 = false;
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.obric.assistant.omnidetailpage.componment.e
    public final void ho(String r100) {
        Intrinsics.checkNotNullParameter(r100, "itemName");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new OmniDetailTrackComponent$reportItemClick$1(this, r100, null), 3, null);
    }

    public static final Object F2(OmniDetailTrackComponent r110, Continuation r111) {
        r110.getClass();
        if ((r111 instanceof OmniDetailTrackComponent$getTraceInfo$1) == false) goto L7;
        OmniDetailTrackComponent$getTraceInfo$1 r100 = (OmniDetailTrackComponent$getTraceInfo$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = false;
        String r105 = null;
        String r106 = "";
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        String r107 = (String) r100.L$3;
        String r108 = (String) r100.L$2;
        String r109 = (String) r100.L$1;
        Message r113 = (Message) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L59:
        List r114 = (List) r112;
        if (r114 == null) goto L62;
        String r115 = (String) CollectionsKt.firstOrNull(r114);
        String r116 = r108;
        String r117 = r109;
        String r118 = r107;
    L64:
        if (r115 != null) goto L66;
        String r119 = "";
    L67:
        Message r120 = r113;
    L68:
        ifa.e r121 = r110.P2();
        if (r121 == null) goto L71;
        String r122 = r121.f489682g;
    L72:
        if (r122 != null) goto L75;
        r122 = "";
    L75:
        if (r122.length() != 0) goto L77;
        r104 = true;
    L77:
        if (r104 == false) goto L85;
        if (r120 == null) goto L82;
        Map<String, String> r123 = r120.getExt();
        if (r123 == null) goto L82;
        r122 = r123.get("o_instruction_entry");
    L83:
        if (r122 != null) goto L85;
        r122 = "";
    L82:
        r122 = null;
    L85:
        r110.N2(r120);
        FLogger r124 = FLogger.f375446a;
        r124.i("OmniDetailTrackComponent", "instructionId = " + r117);
        r124.i("OmniDetailTrackComponent", "referenceMessageId = " + r116);
        r124.i("OmniDetailTrackComponent", "botId = ".concat(r119));
        r124.i("OmniDetailTrackComponent", "enterMethod = ".concat(r122));
        StringBuilder r125 = new StringBuilder("extra = ");
        if (r120 == null) goto L90;
        Map<String, String> r126 = r120.getExt();
        if (r126 == null) goto L90;
        String r127 = r126.toString();
    L91:
        r125.append(r127);
        r124.i("OmniDetailTrackComponent", r125.toString());
        Bundle r128 = new Bundle();
        if (r120 == null) goto L97;
        String r129 = com.larus.im.bean.message.a.x(r120);
        if (r129 == null) goto L97;
        r106 = r129;
    L97:
        r128.putString("log_id", r106);
        r128.putString("instruction_id", r117);
        r128.putString(MusicAppletPage.KEY_MESSAGE_ID, r116);
        r128.putString("bot_id", r119);
        r128.putString("enter_method", r122);
        r128.putString("device_id", com.larus.platform.service.o.f365780a.getDeviceId());
        ifa.e r130 = r110.P2();
        if (r130 == null) goto L100;
        r105 = r130.f489680e;
    L100:
        r128.putString("cur_msg_id", r105);
        r128.putString("action_type", r118);
        r110.f390769h = new Bundle(r128);
        return r128;
    L90:
        r127 = null;
        goto L91
    L71:
        r122 = null;
        goto L72
    L66:
        r119 = r115;
        goto L67
    L62:
        r120 = r113;
        r116 = r108;
        r117 = r109;
        r118 = r107;
    L63:
        r113 = r120;
        r115 = null;
        goto L64
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r112);
    L22:
        r120 = (Message) r112;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Bundle r131 = com.larus.ui.arch.component.internal.attach.a.b(r110, r110).getArguments();
        if (r131 == null) goto L26;
        r117 = r131.getString("task_id");
        if (r117 == null) goto L26;
    L29:
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Bundle r132 = com.larus.ui.arch.component.internal.attach.a.b(r110, r110).getArguments();
        if (r132 == null) goto L33;
        r116 = r132.getString("o_reference_msg_id");
        if (r116 == null) goto L33;
    L36:
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Bundle r133 = com.larus.ui.arch.component.internal.attach.a.b(r110, r110).getArguments();
        if (r133 == null) goto L40;
        r118 = r133.getString("action_type");
        if (r118 == null) goto L40;
    L41:
        ifa.e r134 = r110.P2();
        if (r134 == null) goto L44;
        r119 = r134.f489681f;
    L45:
        if (r119 != null) goto L48;
        r119 = "";
    L48:
        if (r119.length() != 0) goto L50;
        boolean r135 = true;
    L51:
        if (r135 == false) goto L68;
        if (r120 == null) goto L63;
        String r136 = r120.getConversationId();
        if (r136 == null) goto L63;
        r100.L$0 = r120;
        r100.L$1 = r117;
        r100.L$2 = r116;
        r100.L$3 = r118;
        r100.label = 2;
        Object r137 = ic8.n.b(r136, r100);
        if (r137 == r102) goto L104;
        r107 = r118;
        r109 = r117;
        r108 = r116;
        r113 = r120;
        r112 = r137;
        goto L59
    L104:
        return r102;
    L50:
        r135 = false;
        goto L51
    L44:
        r119 = null;
    L40:
        r118 = "";
    L33:
        if (r120 == null) goto L35;
        r116 = com.obric.assistant.utils.k.a(r120);
        goto L36
    L35:
        r116 = "";
    L26:
        if (r120 == null) goto L28;
        r117 = com.obric.assistant.utils.k.b(r120);
        goto L29
    L28:
        r117 = "";
        goto L29
    L16:
        ResultKt.throwOnFailure(r112);
        Bundle r138 = r110.f390769h;
        if (r138 != null) goto L102;
        r100.label = 1;
        r112 = r110.L2(r100);
        if (r112 != r102) goto L22;
        return r102;
    L102:
        return new Bundle(r138);
    L7:
        r100 = new OmniDetailTrackComponent$getTraceInfo$1(r110, r111);
        goto L8
    }
}
