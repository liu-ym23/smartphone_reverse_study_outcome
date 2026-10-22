package com.larus.uaigc.createpage.component.digitalavatar;

import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.InstructionInputManager;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import com.larus.home.impl.sdk.l1;
import com.larus.network.http.y;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.video.VideoPortraitConfig;
import com.larus.platform.service.AccountService;
import com.larus.uaigc.api.AIReplicaApi;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes4.dex */
public final class DigitalAvatarInfoManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DigitalAvatarInfoManager f371542a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final StateFlowImpl f371543b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final StateFlowImpl f371544c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f371545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f371546e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f371547f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f371548g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Boolean f371549h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static com.larus.uaigc.api.a f371550i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final StateFlowImpl f371551j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final StateFlowImpl f371552k = null;

    public DigitalAvatarInfoManager() {
    }

    static {
        f371542a = new DigitalAvatarInfoManager();
        f371543b = j1.a(null);
        f371544c = j1.a(0);
        StateFlowImpl r100 = j1.a(null);
        f371551j = r100;
        f371552k = r100;
        CopyOnWriteArraySet<com.larus.bmhome.chat.a> r101 = InstructionInputManager.f296961a;
        v r102 = new v();
        Intrinsics.checkNotNullParameter(r102, "actionbarChangeListener");
        InstructionInputManager.f296961a.add(r102);
        AccountService.f365697a.E(new w());
    }

    public static ey9.a f() {
        com.larus.uaigc.api.a r100 = f371550i;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.i();
    }

    public static boolean g() {
        Boolean r100 = f371549h;
        if (r100 != null) goto L56;
        com.larus.uaigc.api.a r101 = f371550i;
        String r102 = "";
        if (r101 == null) goto L9;
        String r103 = r101.b();
        if (r103 == null) goto L9;
    L11:
        if (r103.length() <= 0) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == false) goto L17;
        f371549h = Boolean.TRUE;
        return true;
    L17:
        e0 r105 = AuthModelDelegate.f297134b.e().getValue();
        z0 r106 = null;
        Object r107 = null;
        if (r105 == null) goto L22;
        LaunchInfo r108 = r105.f297186a;
        if (r108 == null) goto L22;
        String r109 = r108.W();
    L23:
        if (r109 == null) goto L26;
        r102 = r109;
    L26:
        List<z0> r110 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).f(r102);
        if (r110 == null) goto L43;
        Iterator<T> r111 = r110.iterator();
    L30:
        if (r111.hasNext() == false) goto L42;
        Object r112 = r111.next();
        com.larus.bmhome.actionbar.model.r r113 = ((z0) r112).f295621q;
        if (r113 == null) goto L39;
        Integer r114 = r113.f295408a;
        if (r114 == null) goto L39;
        if (r114.intValue() != 11) goto L39;
        boolean r115 = true;
    L40:
        if (r115 == false) goto L30;
        r107 = r112;
    L39:
        r115 = false;
    L42:
        r106 = (z0) r107;
    L43:
        if (r106 == null) goto L57;
        Integer r116 = r106.f295611g;
        int r117 = ActionBarExecutionType.OPEN_BY_SCHEMA.getValue();
        if (r116 != null) goto L48;
    L49:
        f371549h = Boolean.TRUE;
        return true;
    L48:
        if (r116.intValue() != r117) goto L49;
        return false;
    L57:
        return false;
    L22:
        r109 = null;
        goto L23
    L13:
        r104 = false;
    L9:
        r103 = "";
        goto L11
    L56:
        return r100.booleanValue();
    }

    public static boolean h() {
        return o0.d((String) f371543b.getValue());
    }

    public static void k() {
        StateFlowImpl r100 = f371544c;
        if (g() == true) goto L6;
        int r101 = 0;
    L9:
        r100.setValue(Integer.valueOf(r101));
        return;
    L6:
        if (i() == false) goto L8;
        r101 = 1;
        goto L9
    L8:
        r101 = 2;
        goto L9
    }

    public static String e() {
        if (i() == false) goto L9;
        String r100 = f371547f;
        if (r100 == null) goto L7;
        return r100;
    L7:
        return f371545d;
    L9:
        return f371545d;
    }

    public static boolean i() {
        if (g() == false) goto L14;
        CharSequence r100 = (CharSequence) f371543b.getValue();
        if (r100 != null) goto L7;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == false) goto L15;
        return true;
    L15:
        return false;
    L7:
        if (r100.length() == 0) goto L10;
        r101 = false;
        goto L11
    L14:
        return false;
    }

    public static boolean j() {
        if (g() == true) goto L5;
        return false;
    L5:
        if (i() == true) goto L20;
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r100 == null) goto L13;
        r100.H();
        VideoPortraitConfig r101 = l1.f346198a.a();
        if (r101 == null) goto L13;
        if (r101.getEnableVideoAvatar() != true) goto L13;
        boolean r102 = true;
    L14:
        if (r102 == true) goto L16;
        return false;
    L16:
        if (f() != null) goto L22;
        return true;
    L22:
        return false;
    L13:
        r102 = false;
        goto L14
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(Continuation<? super String> r100) {
        if ((r100 instanceof DigitalAvatarInfoManager$fetchAiReplicaIpaMainUrl$1) == false) goto L7;
        DigitalAvatarInfoManager$fetchAiReplicaIpaMainUrl$1 r101 = (DigitalAvatarInfoManager$fetchAiReplicaIpaMainUrl$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L17:
        com.larus.network.http.a r106 = (com.larus.network.http.a) r103;
        String r107 = null;
        if ((r106 instanceof y) == false) goto L52;
        y r108 = (y) r106;
        com.larus.uaigc.api.a r109 = (com.larus.uaigc.api.a) r108.f360135b;
        f371550i = r109;
        int r110 = 0;
        if (r109 == null) goto L24;
        Integer r111 = r109.e();
        if (r111 == null) goto L24;
        r110 = RangesKt.coerceAtLeast(r111.intValue(), 0);
    L24:
        com.larus.uaigc.api.a r112 = (com.larus.uaigc.api.a) r108.f360135b;
        if (r112 == null) goto L33;
        List<ey9.k> r113 = r112.g();
        if (r113 == null) goto L33;
        ey9.k r114 = (ey9.k) CollectionsKt.getOrNull(r113, r110);
        if (r114 == null) goto L33;
        String r115 = r114.c();
        if (r115 == null) goto L33;
        f371546e = r115;
    L33:
        com.larus.uaigc.api.a r116 = (com.larus.uaigc.api.a) r108.f360135b;
        if (r116 == null) goto L51;
        List<ey9.k> r117 = r116.g();
        if (r117 == null) goto L51;
        ey9.k r118 = (ey9.k) CollectionsKt.getOrNull(r117, r110);
        if (r118 == null) goto L51;
        String r119 = r118.d();
        if (r119 == null) goto L51;
        f371545d = r119;
        com.larus.uaigc.api.a r120 = (com.larus.uaigc.api.a) r108.f360135b;
        if (r120 == null) goto L44;
        String r121 = r120.d();
    L45:
        if (r121 == null) goto L50;
        StateFlowImpl r122 = f371543b;
        com.larus.uaigc.api.a r123 = (com.larus.uaigc.api.a) r108.f360135b;
        if (r123 == null) goto L49;
        r107 = r123.d();
    L49:
        r122.setValue(r107);
    L50:
        f371550i = (com.larus.uaigc.api.a) r108.f360135b;
        r107 = r119;
        goto L51
    L44:
        r121 = null;
    L51:
        f371551j.setValue(f371550i);
    L52:
        return r107;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        AIReplicaApi.Companion r124 = AIReplicaApi.f370258a;
        r101.label = 1;
        r124.getClass();
        r103 = AIReplicaApi.Companion.a("", r101);
        if (r103 != r104) goto L17;
        return r104;
    L7:
        r101 = new DigitalAvatarInfoManager$fetchAiReplicaIpaMainUrl$1(this, r100);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object b(Continuation<? super Integer> r100) {
        if ((r100 instanceof DigitalAvatarInfoManager$fetchAiReplicaModel$1) == false) goto L7;
        DigitalAvatarInfoManager$fetchAiReplicaModel$1 r101 = (DigitalAvatarInfoManager$fetchAiReplicaModel$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L17:
        com.larus.network.http.a r106 = (com.larus.network.http.a) r103;
        if ((r106 instanceof y) == false) goto L22;
        com.larus.uaigc.api.a r107 = (com.larus.uaigc.api.a) ((y) r106).f360135b;
        f371550i = r107;
        if (r107 == null) goto L22;
        return Boxing.boxInt(r107.f());
    L22:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        AIReplicaApi.Companion r108 = AIReplicaApi.f370258a;
        r101.label = 1;
        r108.getClass();
        r103 = AIReplicaApi.Companion.a("", r101);
        if (r103 != r104) goto L17;
        return r104;
    L7:
        r101 = new DigitalAvatarInfoManager$fetchAiReplicaModel$1(this, r100);
        goto L8
    }

    public static /* synthetic */ Object d(DigitalAvatarInfoManager r100, Continuation r101) {
        return r100.c("", r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object c(String r100, Continuation<? super String> r101) {
        if ((r101 instanceof DigitalAvatarInfoManager$fetchWhiteTUrl$1) == false) goto L7;
        DigitalAvatarInfoManager$fetchWhiteTUrl$1 r102 = (DigitalAvatarInfoManager$fetchWhiteTUrl$1) r101;
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
        com.larus.network.http.a r107 = (com.larus.network.http.a) r104;
        String r108 = null;
        if ((r107 instanceof y) == false) goto L48;
        y r109 = (y) r107;
        com.larus.uaigc.api.a r110 = (com.larus.uaigc.api.a) r109.f360135b;
        f371550i = r110;
        if (r110 == null) goto L47;
        String r111 = r110.d();
        if (r111 == null) goto L47;
        f371543b.setValue(r111);
        com.larus.uaigc.api.a r112 = (com.larus.uaigc.api.a) r109.f360135b;
        int r113 = 0;
        if (r112 == null) goto L28;
        Integer r114 = r112.e();
        if (r114 == null) goto L28;
        r113 = RangesKt.coerceAtLeast(r114.intValue(), 0);
    L28:
        com.larus.uaigc.api.a r115 = (com.larus.uaigc.api.a) r109.f360135b;
        if (r115 == null) goto L37;
        List<ey9.k> r116 = r115.g();
        if (r116 == null) goto L37;
        ey9.k r117 = (ey9.k) CollectionsKt.getOrNull(r116, r113);
        if (r117 == null) goto L37;
        String r118 = r117.d();
        if (r118 == null) goto L37;
        f371545d = r118;
    L37:
        com.larus.uaigc.api.a r119 = (com.larus.uaigc.api.a) r109.f360135b;
        if (r119 == null) goto L46;
        List<ey9.k> r120 = r119.g();
        if (r120 == null) goto L46;
        ey9.k r121 = (ey9.k) CollectionsKt.getOrNull(r120, r113);
        if (r121 == null) goto L46;
        String r122 = r121.c();
        if (r122 == null) goto L46;
        f371546e = r122;
    L46:
        f371550i = (com.larus.uaigc.api.a) r109.f360135b;
        f371542a.getClass();
        k();
        r108 = r111;
    L47:
        f371551j.setValue(f371550i);
    L48:
        return r108;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        AIReplicaApi.Companion r123 = AIReplicaApi.f370258a;
        r102.label = 1;
        r123.getClass();
        r104 = AIReplicaApi.Companion.a(r100, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new DigitalAvatarInfoManager$fetchWhiteTUrl$1(this, r101);
        goto L8
    }
}
