package com.larus.bmhome.taskskill.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.bmhome.taskskill.SkillComponent;
import com.larus.bmhome.taskskill.l2;
import com.larus.common.apphost.AppHost;
import com.larus.dispatcher.api.AllDeviceResponse;
import com.larus.dispatcher.api.GetAllDevicesRepo;
import com.larus.flowskill.impl.databinding.LayoutPcConnectionStatusBinding;
import com.larus.im.internal.jni.bean.DispatchCommand;
import com.larus.im.internal.jni.bean.DispatchCommandBody;
import com.larus.im.internal.jni.bean.DispatchCommandPayload;
import com.larus.im.internal.jni.bean.DispatchErrorCode;
import com.larus.im.internal.jni.bean.OmniDispatchCommandRequest;
import com.larus.im.internal.legacy.NativeCmdServiceImpl;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes26.dex */
public final class PcConnectionStatusManager {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f314593k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleOwner f314594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.bmhome.taskskill.view.c f314595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f314596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Integer, Long> f314597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LayoutPcConnectionStatusBinding f314598e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public bs8.a f314599f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f314600g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData<com.larus.bmhome.taskskill.view.b> f314601h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f314602i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PcConnectionStatusManager$lifecycleObserver$1 f314603j;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f314604a = null;

        static {
            int[] r100 = new int[PcConnectionStatusAction.values().length];
            r100[PcConnectionStatusAction.RetryGetAllDevices.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[PcConnectionStatusAction.RequestAuthorizedPermission.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f314604a = r100;
        }
    }

    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f314605a;

        public c(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f314605a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f314605a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f314605a.invoke(r100);
        }
    }

    static {
    }

    public final void e(com.larus.bmhome.taskskill.view.b r100) {
        FLogger.f375446a.d("PcConnectionStatusManager", "[updateHeader] connectionStatus = " + r100);
        if (this.f314595b.b().a() == true) goto L6;
        return;
    L6:
        if (r100 != null) goto L9;
        this.f314595b.c("", null);
        return;
    L9:
        AppHost.Companion r101 = AppHost.f326268a;
        if (NetworkUtils.isNetworkAvailable(r101.getApplication()) == true) goto L14;
        this.f314595b.c(r101.getApplication().getString(R.string.larus_internet_connection_failed), null);
        return;
    L14:
        if (Intrinsics.areEqual(r100, com.larus.bmhome.taskskill.view.b.C4106b.f314626a) == false) goto L17;
        this.f314595b.c(b(R.drawable.larus_ic_pc_connection_dot_connecting, true), null);
        return;
    L17:
        if (Intrinsics.areEqual(r100, com.larus.bmhome.taskskill.view.b.d.f314628a) == false) goto L20;
        com.larus.bmhome.taskskill.view.c r102 = this.f314595b;
        r102.c(r102.a(), Integer.valueOf(R.drawable.larus_ic_localpc_dark));
        return;
    L20:
        if (Intrinsics.areEqual(r100, com.larus.bmhome.taskskill.view.b.a.f314625a) == false) goto L22;
        this.f314595b.c(b(R.drawable.larus_ic_pc_connection_dot_connected, false), null);
        return;
    L22:
        this.f314595b.c(b(R.drawable.larus_ic_pc_connection_dot_connecting, false), null);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.bmhome.taskskill.view.PcConnectionStatusManager$lifecycleObserver$1] */
    public PcConnectionStatusManager(LifecycleOwner r100, SkillComponent.k r101) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "dependency");
        this.f314594a = r100;
        this.f314595b = r101;
        this.f314597d = new LinkedHashMap();
        this.f314596c = SystemClock.elapsedRealtime();
        this.f314601h = new MutableLiveData();
        this.f314603j = new PcConnectionStatusManager$lifecycleObserver$1(this);
    }

    public final CharSequence b(int r110, boolean r111) {
        bs8.a r100 = this.f314599f;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.f20296a;
    L6:
        String r103 = "";
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        String r104 = r102.toString();
        if (r111 == true) goto L12;
        String[] r105 = new String[2];
        r105[0] = r104;
        String r106 = this.f314595b.V7();
        if (r106 == null) goto L25;
        r103 = r106;
    L25:
        r105[1] = r103;
        List r107 = CollectionsKt.listOf(r105);
        ArrayList r108 = new ArrayList();
        Iterator r109 = r107.iterator();
    L27:
        if (r109.hasNext() == false) goto L31;
        Object r112 = r109.next();
        if ((!StringsKt.isBlank((String) r112)) == false) goto L27;
        r108.add(r112);
        goto L27
    L31:
        String r113 = CollectionsKt.joinToString$default(r108, " · ", null, null, 0, null, null, 62, null);
    L32:
        ViewGroup r114 = this.f314595b.getContainerView();
        if (r114 == null) goto L36;
        Context r115 = r114.getContext();
        if (r115 == null) goto L36;
    L37:
        int r116 = r115.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_6, r115, R.dimen.larus_dp_6));
        Drawable r117 = ContextCompat.getDrawable(r115, r110);
        if (r117 != null) goto L40;
        return r113;
    L40:
        r117.setBounds(0, 0, r116 + 0, r116);
        SpannableStringBuilder r118 = new SpannableStringBuilder();
        r118.append(" ");
        r118.setSpan(new ya9.b(r117, 0), 0, 1, 33);
        r118.append(" ");
        r118.append(r113);
        return r118;
    L36:
        r115 = AppHost.f326268a.getApplication();
        goto L37
    L12:
        if ((!StringsKt.isBlank(r104)) == true) goto L15;
        r104 = null;
    L15:
        if (r104 == null) goto L17;
        r101 = r104.concat(" · ");
    L17:
        if (r101 == null) goto L20;
        r103 = r101;
    L20:
        r113 = AppHost.f326268a.getApplication().getString(R.string.larus_local_agent_placeholder_connecting_cn, new Object[]{r103});
        goto L32
    L5:
        r102 = null;
        goto L6
    }

    public final void c(bs8.a r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "caller");
        FLogger r102 = FLogger.f375446a;
        r102.i("PcConnectionStatusManager", "[updateAgentTaskParam][" + r101 + "] new agentTaskParam: " + r100 + ", old agentTaskParam: " + this.f314599f);
        e(this.f314601h.getValue());
        if (Intrinsics.areEqual(this.f314599f, r100) == false) goto L5;
        return;
    L5:
        this.f314599f = r100;
        this.f314600g++;
        this.f314595b.g();
        r102.i("PcConnectionStatusManager", "[initConnectionStatus] current agentTaskParam: " + this.f314599f);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f314594a), null, null, new PcConnectionStatusManager$initConnectionStatus$1(this, this.f314600g, null), 3, null);
    }

    public final void d(AllDeviceResponse r210, boolean r211) {
        bs8.a r100 = this.f314599f;
        String r101 = "";
        String r110 = null;
        if (r100 == null) goto L70;
        Integer r102 = r100.f20298c;
        boolean r103 = true;
        if (r102 == null) goto L11;
        if (r102.intValue() == 1) goto L70;
    L11:
        if (r210 != null) goto L16;
        if (r211 == false) goto L14;
        FLogger.f375446a.i("PcConnectionStatusManager", "[updateConnectionStatus] device request failed, converge to not found");
        this.f314595b.e("PcConnectionStatusManager.doWhenDeviceNotFound");
        this.f314601h.postValue(com.larus.bmhome.taskskill.view.b.d.f314628a);
        return;
    L14:
        FLogger.f375446a.i("PcConnectionStatusManager", "[updateConnectionStatus] devicesInfo is null, keep pending");
        this.f314601h.postValue(com.larus.bmhome.taskskill.view.b.C4106b.f314626a);
        return;
    L16:
        String r111 = l2.d(r100, r210);
        String r104 = r100.f20300e;
        int r112 = 0;
        if (r104 != null) goto L19;
    L22:
        boolean r105 = true;
    L23:
        if (r105 == false) goto L31;
        if (r111 != null) goto L26;
    L29:
        if (r103 == true) goto L31;
        this.f314599f = bs8.a.a(r100, null, null, r111, null, null, 111);
        this.f314595b.f(r111);
        goto L31
    L26:
        if (StringsKt.isBlank(r111) == true) goto L29;
        r103 = false;
    L31:
        bs8.h r106 = this.f314595b.b();
        bs8.a r107 = this.f314599f;
        String r108 = r106.f20307a;
        Intrinsics.checkNotNullParameter(r108, "conversationId");
        com.larus.bmhome.taskskill.view.b r109 = d.a(new bs8.h(r108, r107), r210, new e());
        FLogger r113 = FLogger.f375446a;
        r113.i("PcConnectionStatusManager", "[updateConnectionStatus] resolved status=" + r109);
        com.larus.bmhome.taskskill.view.b.d r114 = com.larus.bmhome.taskskill.view.b.d.f314628a;
        if (Intrinsics.areEqual(r109, r114) == false) goto L34;
        this.f314595b.e("PcConnectionStatusManager.doWhenDeviceNotFound");
        this.f314601h.postValue(r114);
        return;
    L34:
        com.larus.bmhome.taskskill.view.b.e r115 = com.larus.bmhome.taskskill.view.b.e.f314629a;
        if (Intrinsics.areEqual(r109, r115) == false) goto L37;
        this.f314595b.e("PcConnectionStatusManager.doWhenDeviceOffline");
        this.f314601h.postValue(r115);
        return;
    L37:
        com.larus.bmhome.taskskill.view.b.c r116 = com.larus.bmhome.taskskill.view.b.c.f314627a;
        if (Intrinsics.areEqual(r109, r116) == false) goto L40;
        this.f314595b.e("PcConnectionStatusManager.doWhenNeedUpgrade");
        this.f314601h.postValue(r116);
        return;
    L40:
        com.larus.bmhome.taskskill.view.b.a r117 = com.larus.bmhome.taskskill.view.b.a.f314625a;
        if (Intrinsics.areEqual(r109, r117) == false) goto L43;
        this.f314595b.d();
        this.f314601h.postValue(r117);
        return;
    L43:
        com.larus.bmhome.taskskill.view.b.g r118 = com.larus.bmhome.taskskill.view.b.g.f314631a;
        if (Intrinsics.areEqual(r109, r118) == false) goto L60;
        this.f314595b.e("PcConnectionStatusManager.doWhenDeviceNotControl");
        this.f314601h.postValue(r118);
        String r119 = l2.d(this.f314599f, null);
        GetAllDevicesRepo r120 = GetAllDevicesRepo.f330842a;
        Integer r121 = GetAllDevicesRepo.c(r119);
        if (r121 == null) goto L48;
        r112 = r121.intValue();
    L48:
        StringBuilder r122 = new StringBuilder("[sendPermissionControlCommand] start, localPcDeviceId=");
        r122.append(r119);
        r122.append(", deviceName=");
        bs8.a r123 = this.f314599f;
        if (r123 == null) goto L51;
        r110 = r123.f20296a;
    L51:
        r122.append(r110);
        r113.i("PcConnectionStatusManager", r122.toString());
        NativeCmdServiceImpl r124 = com.larus.im.d.b();
        if (r119 != null) goto L54;
        String r125 = "";
    L55:
        DispatchCommand r126 = DispatchCommand.DEVICE_ENABLE_CONTROL_REQUEST;
        String r127 = UUID.randomUUID().toString();
        DispatchCommandBody r128 = null;
        DispatchErrorCode r129 = null;
        if (r119 != null) goto L58;
        String r212 = "";
    L59:
        r124.sendDispatchCommand(new OmniDispatchCommandRequest(r125, r112, new DispatchCommandPayload(r126, r127, r128, r129, r212, null, 0, null, null, TTVideoEngineInterface.PLAYER_OPTION_USE_FALLBACK_API, null)), new o());
        return;
    L58:
        r212 = r119;
        goto L59
    L54:
        r125 = r119;
        goto L55
    L60:
        com.larus.bmhome.taskskill.view.b.f r130 = com.larus.bmhome.taskskill.view.b.f.f314630a;
        if (Intrinsics.areEqual(r109, r130) == false) goto L63;
        this.f314595b.e("PcConnectionStatusManager.doWhenDeviceNotAuthorized");
        this.f314601h.postValue(r130);
        return;
    L63:
        com.larus.bmhome.taskskill.view.b.C4106b r131 = com.larus.bmhome.taskskill.view.b.C4106b.f314626a;
        if (Intrinsics.areEqual(r109, r131) == false) goto L66;
        this.f314601h.postValue(r131);
        return;
    L66:
        if (r109 != null) goto L69;
        return;
    L69:
        throw new NoWhenBranchMatchedException();
    L19:
        if (StringsKt.isBlank(r104) == true) goto L22;
        r105 = false;
    L70:
        LayoutPcConnectionStatusBinding r132 = this.f314598e;
        if (r132 == null) goto L81;
        PcConnectionStatusView r133 = r132.f343579a;
        if (r133 == null) goto L81;
        com.larus.bmhome.taskskill.view.b.a r134 = com.larus.bmhome.taskskill.view.b.a.f314625a;
        bs8.a r135 = this.f314599f;
        if (r135 == null) goto L77;
        r110 = r135.f20296a;
    L77:
        if (r110 == null) goto L80;
        r101 = r110;
    L80:
        r133.D(d.b(r134, r101));
    L81:
        this.f314595b.g();
    }

    public final void a(String r100, String r101, boolean r102) {
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        if (StringsKt.isBlank(r100) == true) goto L12;
        if (r102 == false) goto L8;
    L10:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f314594a), null, null, new PcConnectionStatusManager$authorizeDevice$1(r100, r101, this, null), 3, null);
        return;
    L8:
        if (StringsKt.isBlank(r101) == false) goto L10;
    L12:
        FLogger.f375446a.w("PcConnectionStatusManager", "[authorizeDevice] invalid params, targetDeviceId=" + r100 + ", ticketBlank=" + StringsKt.isBlank(r101));
    }
}
