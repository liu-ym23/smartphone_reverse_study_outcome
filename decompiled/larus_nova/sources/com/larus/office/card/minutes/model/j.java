package com.larus.office.card.minutes.model;

import com.ixigua.lib.track.TrackParams;
import com.larus.audio.IAudioService;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.GeneralTaskParam;
import com.larus.office.card.minutes.view.t;
import com.larus.platform.api.z;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import nuc.v2;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
public final class j implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudioRecordCardLifecycleGuard f361497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f361498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f361499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ i f361500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ b f361501e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f361502f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ z f361503g;

    @Override // com.larus.platform.api.z
    public final void onSuccess(String r110) {
        Intrinsics.checkNotNullParameter(r110, "recordingId");
        this.f361497a.markStartSucceeded(this.f361498b);
        String r100 = this.f361499c;
        String r101 = null;
        if (r100 == null) goto L10;
        AtomicReference<String> r102 = i.f361494c;
    L6:
        if (r102.compareAndSet(r100, null) == true) goto L10;
        if (r102.get() == r100) goto L6;
    L10:
        IAudioService r103 = this.f361500d.f361496b;
        if (r103 == null) goto L13;
        r103.t(false);
    L13:
        FLogger.f375446a.i("AudioRecordStartCoordinator", "Start record success");
        i r104 = this.f361500d;
        Map<String, String> r105 = this.f361501e.j().getExt();
        r104.getClass();
        if (r105 == null) goto L16;
        String r106 = r105.get("action_bar_key");
    L18:
        if (Intrinsics.areEqual(r106, "coco_ai_simul_interpret") == true) goto L67;
        if (r105 != null) goto L22;
    L25:
        boolean r107 = true;
    L26:
        if (r107 == true) goto L59;
        String r108 = r105.get("selected_skills");
        if (r108 != null) goto L31;
    L49:
        boolean r109 = false;
    L50:
        if (r109 == true) goto L58;
        GeneralTaskParam r111 = (GeneralTaskParam) zd9.i.a(r105.get("general_task_param"), GeneralTaskParam.Companion.serializer());
        if (r111 == null) goto L59;
        List<String> r112 = r111.getSelectedSkills();
        if (r112 == null) goto L59;
        if (r112.contains("doubao-record") != true) goto L59;
    L58:
        boolean r113 = true;
    L60:
        if (r113 == false) goto L62;
        String r114 = "moa skill";
    L69:
        String r115 = this.f361501e.j().getSenderId();
        String r116 = this.f361501e.j().getMessageId();
        String r117 = this.f361501e.j().getConversationId();
        String r118 = com.larus.im.bean.message.a.r(this.f361501e.j());
        if (r118 != null) goto L72;
    L75:
        boolean r119 = true;
    L77:
        if ((true ^ r119) == false) goto L79;
        r101 = r118;
    L79:
        if (r101 != null) goto L81;
        r101 = "0";
    L81:
        String r120 = com.larus.im.bean.message.a.s(this.f361501e.j());
        if (r120 != null) goto L84;
        r120 = "";
    L84:
        String r121 = this.f361502f;
        JSONObject r122 = new JSONObject();
        Intrinsics.checkNotNullParameter(r122, "params");
        if (r110 != null) goto L100;
    L87:
        r122.put("feishu_record_enter_method", r114);     // Catch: Exception -> L96
        if (r115 == null) goto L90;
        r122.put("bot_id", r115);     // Catch: Exception -> L96
    L90:
        if (r116 == null) goto L92;
        r122.put(MusicAppletPage.KEY_MESSAGE_ID, r116);     // Catch: Exception -> L96
    L92:
        if (r117 == null) goto L94;
        r122.put("conversation_id", r117);     // Catch: Exception -> L96
    L94:
        r122.put("current_page", "chat");     // Catch: Exception -> L96
        r122.put("is_general_agent", tx9.l.d(r101));     // Catch: Exception -> L96
        r122.put("chat_id", r120);     // Catch: Exception -> L96
        r122.put("mic_status", "open");     // Catch: Exception -> L96
        r122.putOpt("record_scene", r121);     // Catch: Exception -> L96
    L98:
        TrackParams r123 = new TrackParams().merge(r122);
        by7.a r124 = new by7.a("feishu_recording_start");
        r124.f21463a.merge(r123);
        r124.b();
        i.c(this.f361500d, this.f361501e, "result", 0, "success", r110, 32);
        this.f361503g.onSuccess(r110);
        return;
    L96:
        e = move-exception;
        FLogger.f375446a.e("AudioRecordEventHelper", e.getMessage(), e);
        goto L98
    L100:
        r122.put("feishu_record_id", r110);     // Catch: Exception -> L96
        goto L87
    L72:
        if (r118.length() == 0) goto L75;
        r119 = false;
        goto L77
    L62:
        if (r105 == null) goto L64;
        String r125 = r105.get("action_bar_key");
    L66:
        if (Intrinsics.areEqual(r125, "coco_record") == true) goto L67;
        r114 = "other";
        goto L69
    L64:
        r125 = null;
        goto L66
    L31:
        if (r108.length() <= 0) goto L33;
        boolean r126 = true;
    L34:
        if (r126 == true) goto L37;
        r108 = null;
    L37:
        if (r108 == null) goto L49;
        kuc.a.f(StringCompanionObject.INSTANCE);
        List r127 = zd9.i.b(r108, v2.f520790a);
        if (r127 != null) goto L42;
    L44:
        boolean r128 = false;
    L45:
        if (r128 == false) goto L47;
    L48:
        r109 = true;
        goto L50
    L47:
        if (StringsKt.contains$default(r108, "doubao-record", false, 2, null) == false) goto L49;
    L42:
        if (r127.contains("doubao-record") != true) goto L44;
        r128 = true;
        goto L45
    L33:
        r126 = false;
    L59:
        r113 = false;
        goto L60
    L22:
        if (r105.isEmpty() == true) goto L25;
        r107 = false;
    L67:
        r114 = "actionbar_skill_click";
        goto L69
    L16:
        r106 = null;
        goto L18
    }

    @Override // com.larus.platform.api.z
    public final void onFail(int r100, String r110) {
        this.f361497a.markStartFailed(this.f361498b);
        String r101 = this.f361499c;
        if (r101 == null) goto L10;
        AtomicReference<String> r102 = i.f361494c;
    L6:
        if (r102.compareAndSet(r101, null) == true) goto L10;
        if (r102.get() == r101) goto L6;
    L10:
        IAudioService r103 = this.f361500d.f361496b;
        if (r103 == null) goto L13;
        r103.t(false);
    L13:
        FLogger.f375446a.i("AudioRecordStartCoordinator", "Start record failed, errorCode=" + r100 + ", errorMsg=" + r110);
        this.f361503g.onFail(r100, r110);
        i.c(this.f361500d, this.f361501e, "result", Integer.valueOf(r100), r110, null, 48);
    }

    public j(AudioRecordCardLifecycleGuard r100, String r101, String r102, i r103, b r104, String r105, t r106) {
        this.f361497a = r100;
        this.f361498b = r101;
        this.f361499c = r102;
        this.f361500d = r103;
        this.f361501e = r104;
        this.f361502f = r105;
        this.f361503g = r106;
    }
}
