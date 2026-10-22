package f39;

import com.ixigua.lib.track.TrackParams;
import com.larus.doc.impl.audio.DocAudioComponent;
import com.larus.doc.sdk.api.VoiceInputFrom;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class f implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocAudioComponent f475418a;

    public /* synthetic */ f(DocAudioComponent r100) {
        this.f475418a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r110) {
        DocAudioComponent r100 = this.f475418a;
        int r111 = ((Integer) r110).intValue();
        int r101 = DocAudioComponent.f331058x;
        FLogger.f375446a.i("DocAudioComponent", "stop voiceInput, length:" + r111);
        String r102 = m39.a.f511797a;
        long r103 = r100.f331069v;
        String r104 = r100.f331070w;
        Intrinsics.checkNotNullParameter("ai_doc_detail", "currentPage");
        Intrinsics.checkNotNullParameter(r104, "enterFrom");
        int r105 = !Intrinsics.areEqual(r104, VoiceInputFrom.TOOL_BAR_LONG_PRESS) ? 1 : 0;
        String r106 = m39.a.f511797a;
        String r107 = m39.a.f511798b;
        Integer r108 = m39.a.f511799c;
        if (r111 <= 0) goto L5;
        int r109 = 1;
    L6:
        String r112 = m39.a.f511800d;
        Integer r113 = 1;
        Integer r114 = Integer.valueOf(r105);
        Long r115 = Long.valueOf(r103);
        Integer r116 = Integer.valueOf(r111);
        Integer r117 = Integer.valueOf(r109);
        JSONObject r118 = new JSONObject();
        Intrinsics.checkNotNullParameter(r118, "params");
        if (r113 != null) goto L33;
    L11:
        if (r112 == null) goto L13;
        r118.put("click_from", r112);     // Catch: JSONException -> L9
    L13:
        if (r114 == null) goto L15;
        r118.put("is_handsfree_speak", r114.intValue());     // Catch: JSONException -> L9
    L15:
        if (r106 == null) goto L17;
        r118.put("page_token", r106);     // Catch: JSONException -> L9
    L17:
        if (r107 == null) goto L19;
        r118.put("artifact_meta_id", r107);     // Catch: JSONException -> L9
    L19:
        if (r108 == null) goto L21;
        r118.put("resource_type", r108.intValue());     // Catch: JSONException -> L9
    L21:
        r118.put("current_page", "ai_doc_detail");     // Catch: JSONException -> L9
        if (r115 == null) goto L24;
        r118.put("speak_duration", r115.longValue());     // Catch: JSONException -> L9
    L24:
        if (r116 == null) goto L26;
        r118.put("content_length", r116.intValue());     // Catch: JSONException -> L9
    L26:
        r118.put("end_method", "click");     // Catch: JSONException -> L9
        if (r117 == null) goto L31;
        r118.put("success", r117.intValue());     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        FLogger.f375446a.e("DocumentEventHelper", "error in DocumentEventHelper mobFinishSpeakInput: " + e.getLocalizedMessage());
    L31:
        TrackParams r119 = new TrackParams().merge(r118);
        by7.a r120 = new by7.a("finish_speak_input");
        r120.f21463a.merge(r119);
        r120.b();
        r100.f331069v = 0;
        return Unit.INSTANCE;
    L33:
        r118.put("is_ai_doc", r113.intValue());     // Catch: JSONException -> L9
        goto L11
    L5:
        r109 = 0;
        goto L6
    }
}
