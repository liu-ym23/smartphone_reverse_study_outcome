package com.larus.bmhome.chat.standarduikit.localfileblock.blockadapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.standarduikit.localfileblock.remote.PcRemoteFilePage;
import com.larus.bmhome.chat.standarduikit.localfileblock.remote.PcRemoteFileRepository;
import com.larus.bmhome.chat.standarduikit.localfileblock.view.PcLocalFileCardView;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.LocalFileBlock;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.platform.service.FlowDriveSdkService;
import com.larus.utils.logger.FLogger;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kc8.y;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class PcLocalFileBlockHolder extends jc8.b<c> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PcLocalFileCardView f309391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PcRemoteFilePage f309392e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f309393f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g f309394g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Job f309395h;

    @Override // jc8.b
    public final String c() {
        return "PcLocalFileBlockHolder";
    }

    public final void l() {
        f r100 = this.f309393f;
        if (r100 == null) goto L9;
        PcRemoteFilePage r101 = this.f309392e;
        if (r101 == null) goto L9;
        LiveData<PcRemoteFilePage.b> r102 = r101.getState();
        if (r102 == null) goto L9;
        r102.removeObserver(r100);
    L9:
        this.f309393f = null;
        this.f309392e = null;
        g r103 = this.f309394g;
        if (r103 == null) goto L12;
        PcRemoteFileRepository.f309447h.removeObserver(r103);
    L12:
        this.f309394g = null;
        Job r104 = this.f309395h;
        if (r104 == null) goto L15;
        Job.DefaultImpls.cancel$default(r104, null, 1, null);
    L15:
        this.f309395h = null;
    }

    @Override // jc8.b
    public final void i() {
        l();
        PcLocalFileCardView r100 = this.f309391d;
        if (r100 == null) goto L5;
        ExposeXTrackerExtKt.e(r100);
    L5:
        PcLocalFileCardView r101 = this.f309391d;
        if (r101 == null) goto L12;
        r101.f309478c = false;
        vl8.h r102 = r101.f309480e;
        if (r102 == null) goto L10;
        r101.removeCallbacks(r102);
    L10:
        r101.f309480e = null;
        r101.setOnClickListener(null);
        r101.f309476a.f358473b.setOnClickListener(null);
        r101.S5(false);
        r101.setContentDescription(null);
        return;
    }

    public PcLocalFileBlockHolder() {
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r100) {
        c r101 = (c) r100;
        Intrinsics.checkNotNullParameter(r101, "blockModel");
        return jc8.e.d(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v24, types: [androidx.lifecycle.Observer, com.larus.bmhome.chat.standarduikit.localfileblock.blockadapter.f] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.bmhome.chat.standarduikit.localfileblock.blockadapter.d, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.larus.bmhome.chat.standarduikit.localfileblock.blockadapter.e, kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r8v2, types: [androidx.lifecycle.Observer, com.larus.bmhome.chat.standarduikit.localfileblock.blockadapter.g] */
    @Override // jc8.b
    public final void g(jc8.a r210) {
        final c r100 = (c) r210;
        Intrinsics.checkNotNullParameter(r100, "blockModel");
        l();
        PcLocalFileCardView r101 = this.f309391d;
        if (r101 == null) goto L5;
        ExposeXTrackerExtKt.e(r101);
    L5:
        PcLocalFileCardView r102 = this.f309391d;
        if (r102 == null) goto L11;
        r102.f309478c = false;
        vl8.h r103 = r102.f309480e;
        if (r103 == null) goto L10;
        r102.removeCallbacks(r103);
    L10:
        r102.f309480e = null;
        r102.setOnClickListener(null);
        r102.f309476a.f358473b.setOnClickListener(null);
        r102.S5(false);
        r102.setContentDescription(null);
    L11:
        final com.larus.bmhome.chat.standarduikit.localfileblock.remote.g r110 = r100.o();
        if (r110 == null) goto L75;
        kc8.b r104 = (kc8.b) jc8.c.a(this, kc8.b.class);
        if (r104 == null) goto L17;
        y r111 = r104.f502425a;
    L18:
        final PcLocalFileCardView r112 = this.f309391d;
        if (r112 == null) goto L76;
        boolean r113 = FlowDriveSdkService.f365704a.o();
        if (r111 == null) goto L24;
        Fragment r114 = r111.f502620a;
    L25:
        if (r111 == null) goto L27;
        boolean r105 = Intrinsics.areEqual(r111.f502627h, Boolean.TRUE);
    L28:
        if (r105 == true) goto L35;
        if (r114 == null) goto L35;
        PcRemoteFilePage.a r106 = PcRemoteFilePage.Companion;
        if (r111 == null) goto L33;
        Function0<String> r107 = r111.f502625f;
    L34:
        r106.getClass();
        Intrinsics.checkNotNullParameter(r114, WidgetService.PARAM_FRAGMENT);
        PcRemoteFilePage r108 = (PcRemoteFilePage) new ViewModelProvider(r114).get(PcRemoteFilePage.class);
        PcRemoteFilePage.access$bind(r108, r114, r107);
        PcRemoteFilePage r109 = r108;
    L36:
        this.f309392e = r109;
        String r115 = r110.f309470d;
        if (r115 != null) goto L39;
        r115 = "";
    L39:
        String r116 = r115;
        String r117 = r110.f309471e;
        if (r109 == null) goto L48;
        LiveData<PcRemoteFilePage.b> r118 = r109.getState();
        if (r118 == null) goto L48;
        PcRemoteFilePage.b r119 = r118.getValue();
        if (r119 == null) goto L48;
        Map<String, String> r120 = r119.f309438b;
        if (r120 == null) goto L48;
        String r121 = r120.get(r110.f309467a);
    L49:
        if (r109 == null) goto L59;
        LiveData<PcRemoteFilePage.b> r122 = r109.getState();
        if (r122 == null) goto L59;
        PcRemoteFilePage.b r123 = r122.getValue();
        if (r123 == null) goto L59;
        com.larus.bmhome.chat.standarduikit.localfileblock.remote.g r124 = r123.f309437a;
        if (r124 == null) goto L59;
        if (com.larus.bmhome.chat.standarduikit.localfileblock.remote.d.a(r124, r110) != true) goto L59;
        boolean r125 = true;
    L60:
        boolean r126 = r125;
        String r127 = r121;
        final y r128 = r111;
        final PcRemoteFilePage r129 = r109;
        PcRemoteFilePage r130 = r109;
        final ?? r131 = new d(this, r100, r128, r112, r129, r110);
        Intrinsics.checkNotNullParameter(r116, "fileName");
        Intrinsics.checkNotNullParameter(r131, SendEventContainerMethodParamModel.EventKinds.onClick);
        r112.f309477b = r113;
        SimpleDraweeView r132 = r112.f309476a.f358476e;
        h19.b.f483542a.getClass();
        r132.setActualImageResource(h19.b.a(h19.b.d(r117)));
        r112.f309476a.f358478g.setText(r116);
        r112.U5(r127);
        r112.setOnClickListener(new vl8.i(r131));
        r112.f309476a.f358473b.setOnClickListener(new vl8.j(r131));
        vl8.h r133 = r112.f309480e;
        if (r133 == null) goto L63;
        r112.removeCallbacks(r133);
    L63:
        r112.f309480e = null;
        r112.S5(false);
        r112.T5(r126);
        if (r114 == null) goto L68;
        LiveData<LifecycleOwner> r134 = r114.getViewLifecycleOwnerLiveData();
        if (r134 == null) goto L68;
        LifecycleOwner r135 = r134.getValue();
    L69:
        if (r130 == null) goto L73;
        if (r135 == null) goto L73;
        final LifecycleOwner r136 = r135;
        final y r137 = r111;
        final ?? r138 = new e(r112, r136, r100, this, r137);
        ?? r139 = new f(r112, r110);
        r130.getState().observe(r135, r139);
        this.f309393f = r139;
        final LifecycleOwner r140 = r135;
        ?? r141 = new g(this, r110, r140, r112, r138);
        PcRemoteFileRepository.f309447h.observe(r135, r141);
        this.f309394g = r141;
        k(r110, r135, r112, r138);
        return;
    L73:
        return;
    L68:
        r135 = null;
    L59:
        r125 = false;
    L48:
        r121 = null;
        goto L49
    L33:
        r107 = null;
    L35:
        r109 = null;
        goto L36
    L27:
        r105 = false;
        goto L28
    L24:
        r114 = null;
        goto L25
    L76:
        return;
    L17:
        r111 = null;
        goto L18
    }

    @Override // jc8.b
    public final View h(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        PcLocalFileCardView r101 = new PcLocalFileCardView(r100.getContext());
        this.f309391d = r101;
        return r101;
    }

    public static final Object j(PcLocalFileBlockHolder r100, com.larus.bmhome.chat.standarduikit.localfileblock.remote.g r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof PcLocalFileBlockHolder$hasCachedFile$1) == false) goto L7;
        PcLocalFileBlockHolder$hasCachedFile$1 r103 = (PcLocalFileBlockHolder$hasCachedFile$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        boolean r108 = true;
        if (r107 == 0) goto L15;
        if (r107 != 1) goto L14;
        ResultKt.throwOnFailure(r105);     // Catch: Exception -> L21 CancellationException -> L26
    L19:
        if (r105 != null) goto L25;
    L23:
        r108 = false;
        goto L25
    L25:
        return Boxing.boxBoolean(r108);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r105);
        PcRemoteFileRepository r109 = PcRemoteFileRepository.f309440a;     // Catch: Exception -> L21 CancellationException -> L26
        r103.label = 1;     // Catch: Exception -> L21 CancellationException -> L26
        r105 = PcRemoteFileRepository.f(r101, r103);     // Catch: Exception -> L21 CancellationException -> L26
        if (r105 != r106) goto L19;
        return r106;
    L26:
        e = move-exception;
        throw e;
    L21:
        e = move-exception;
        FLogger.f375446a.w("PcLocalFileBlockHolder", "stage=cache_state_failed type=".concat(e.getClass().getSimpleName()));
    L7:
        r103 = new PcLocalFileBlockHolder$hasCachedFile$1(r100, r102);
        goto L8
    }

    public final void k(com.larus.bmhome.chat.standarduikit.localfileblock.remote.g r110, LifecycleOwner r111, PcLocalFileCardView r112, Function0<Unit> r113) {
        Job r100 = this.f309395h;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f309395h = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r111), null, null, new PcLocalFileBlockHolder$refreshCachedFile$1(r112, this, r110, r113, null), 3, null);
    }

    public final void m(c r100, y r101, PcLocalFileCardView r110, boolean r111) {
        boolean r102 = false;
        if (r101 == null) goto L5;
        boolean r103 = Intrinsics.areEqual(r101.f502627h, Boolean.TRUE);
    L6:
        if (r103 == false) goto L8;
        return;
    L8:
        com.larus.bmhome.chat.standarduikit.localfileblock.remote.g r104 = r100.o();
        PcRemoteFilePage r105 = this.f309392e;
        by7.e r106 = null;
        String r107 = "";
        if (r105 == null) goto L19;
        if (r104 == null) goto L12;
        String r108 = r104.f309467a;
    L13:
        if (r108 != null) goto L16;
        r108 = "";
    L16:
        if (r105.isSourceDeviceOffline(r108) != true) goto L19;
        r102 = true;
        goto L19
    L12:
        r108 = null;
    L19:
        if (r110.f309478c == false) goto L22;
        String r112 = "loading";
    L30:
        String r109 = com.larus.im.bean.message.a.s(r100.j());
        if (r109 != null) goto L33;
        r109 = "";
    L33:
        String r113 = r100.j().getMessageId();
        if (r113 != null) goto L36;
        r113 = "";
    L36:
        String r114 = r100.j().getConversationId();
        if (r114 != null) goto L39;
        r114 = "";
    L39:
        BlockContent r115 = r100.f498145a.getContent();
        if (r115 == null) goto L46;
        LocalFileBlock r116 = r115.getLocalFileBlock();
        if (r116 == null) goto L46;
        String r117 = r116.type;
        if (r117 == null) goto L46;
        String r118 = r117.toLowerCase(Locale.ROOT);
    L47:
        if (r118 == null) goto L50;
        r107 = r118;
    L50:
        if (r101 == null) goto L52;
        r106 = r101.f502622c;
    L52:
        JSONObject r119 = new JSONObject();
        Intrinsics.checkNotNullParameter(r119, "params");
        r119.putOpt("chat_id", r109);     // Catch: JSONException -> L55
        r119.putOpt(MusicAppletPage.KEY_MESSAGE_ID, r113);     // Catch: JSONException -> L55
        r119.putOpt("conversation_id", r114);     // Catch: JSONException -> L55
        r119.put("content_type", "file");     // Catch: JSONException -> L55
        r119.putOpt("content_sec_type", r107);     // Catch: JSONException -> L55
        r119.putOpt("status", r112);     // Catch: JSONException -> L55
        r119.putOpt("is_dispatch", "1");     // Catch: JSONException -> L55
    L58:
        if (r111 == false) goto L60;
        String r120 = "general_agent_artifact_result_card_click";
    L61:
        by7.a r121 = new by7.a(r120);
        if (r106 == null) goto L64;
        r121.f21464b = r106;
    L64:
        r121.f21463a.merge(new TrackParams().merge(r119));
        r121.b();
        return;
    L60:
        r120 = "general_agent_artifact_result_card_show";
    L55:
        e = move-exception;
        FLogger.f375446a.e("ArtifactResultCardEventHelper", "build artifact result card event failed", e);
    L46:
        r118 = null;
        goto L47
    L22:
        if (r110.f309477b == true) goto L24;
    L29:
        r112 = "disable";
        goto L30
    L24:
        if (r110.f309479d == true) goto L28;
        if (r111 == false) goto L29;
        if (r102 == true) goto L29;
    L28:
        r112 = "able";
        goto L30
    L5:
        r103 = false;
        goto L6
    }
}
