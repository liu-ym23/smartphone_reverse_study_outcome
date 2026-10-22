package com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb;

import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import xe2.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvJsbHandler$actionUpdateHandlers$9 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public KtvJsbHandler$actionUpdateHandlers$9(b r8) {
        super(1, r8, b.class, "downloadMusic", "downloadMusic(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r10) {
        Intrinsics.checkNotNullParameter(r10, "p1");
        b r0 = (b) ((CallableReference) this).receiver;
        int r1 = b.g;
        r0.getClass();
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvJsbHandler", "downloadMusic");
        r0.e.m(r10);
        JsonObject r11 = new JsonObject();
        int r2 = g.a;
        KtvComponentOrderedSongDataContext r3 = KtvComponentOrderedSongDataContext.Companion.getContext();
        Long r4 = null;
        if (r3 == null) goto L5;
        MusicPanel r5 = r3.getKtvPublicFirstOrderedSong();
    L6:
        if (r5 == null) goto L12;
        JSONObject r7 = new JSONObject();
        r7.put("music_id", r5.a.getMId());
        r7.put("music_name", r5.a.getTitle());
        InteractiveSongUserInfo r6 = r5.f();
        if (r6 == null) goto L11;
        r4 = Long.valueOf(r6.getId());
    L11:
        r7.put("order_user_id", String.valueOf(r4));
        int r8 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.JoinChorus, "StartDownloadMusic", 0, null, r7, 88);
    L12:
        return r11;
    L5:
        r5 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
