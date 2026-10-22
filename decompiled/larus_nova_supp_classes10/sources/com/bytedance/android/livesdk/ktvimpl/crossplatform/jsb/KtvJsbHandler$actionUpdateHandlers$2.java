package com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb;

import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.bdlocation.exception.BDLocationException;
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
final /* synthetic */ class KtvJsbHandler$actionUpdateHandlers$2 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public KtvJsbHandler$actionUpdateHandlers$2(b r8) {
        super(1, r8, b.class, "pauseMusic", "pauseMusic(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r9) {
        Intrinsics.checkNotNullParameter(r9, "p1");
        b r10 = (b) ((CallableReference) this).receiver;
        int r0 = b.g;
        r10.getClass();
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvJsbHandler", "pauseMusic");
        JsonObject r1 = new JsonObject();
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b r11 = r10.c();
        if (r11 == null) goto L5;
        r11.pause();
    L5:
        int r12 = g.a;
        KtvComponentOrderedSongDataContext r13 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r13 == null) goto L8;
        MusicPanel r14 = r13.getKtvPublicFirstOrderedSong();
    L9:
        JSONObject r6 = new JSONObject();
        if (r14 == null) goto L14;
        KtvMusic r2 = r14.a;
        if (r2 == null) goto L14;
        Object r3 = Long.valueOf(r2.getMId());
    L15:
        r6.put("music_id", r3);
        String r4 = "";
        if (r14 == null) goto L21;
        KtvMusic r5 = r14.a;
        if (r5 == null) goto L21;
        String r7 = r5.getMTitle();
        if (r7 == null) goto L21;
    L22:
        r6.put("music_name", r7);
        if (r14 == null) goto L30;
        InteractiveSongUserInfo r15 = r14.f();
        if (r15 == null) goto L30;
        String r16 = String.valueOf(r15.getId());
        if (r16 == null) goto L30;
        r4 = r16;
    L30:
        r6.put("order_user_id", r4);
        int r17 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.JoinChorus, "MusicPause", 0, null, r6, 88);
        return r1;
    L21:
        r7 = "";
    L14:
        r3 = BDLocationException.ERROR_TIMEOUT;
        goto L15
    L8:
        r14 = null;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
