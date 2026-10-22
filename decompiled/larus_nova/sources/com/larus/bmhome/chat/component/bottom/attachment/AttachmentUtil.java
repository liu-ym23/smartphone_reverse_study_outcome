package com.larus.bmhome.chat.component.bottom.attachment;

import com.google.gson.reflect.TypeToken;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class AttachmentUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AttachmentUtil f298080a = null;

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/network/http/HttpExtKt$httpPost2$2", "Lcom/google/gson/reflect/TypeToken;", "network_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<HashMap<String, ic8.g>> {
        public a() {
        }
    }

    static {
        f298080a = new AttachmentUtil();
    }

    public AttachmentUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(List<String> r100, Continuation<? super ic8.g> r110) {
        if ((r110 instanceof AttachmentUtil$getAudioParseResult$1) == false) goto L7;
        AttachmentUtil$getAudioParseResult$1 r101 = (AttachmentUtil$getAudioParseResult$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        AttachmentUtil$getAudioParseResult$1 r103 = r101;
        Object r111 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        r100 = (List) r103.L$0;
        ResultKt.throwOnFailure(r111);
    L17:
        com.larus.network.http.a r112 = (com.larus.network.http.a) r111;
        if ((r112 instanceof com.larus.network.http.y) == false) goto L24;
        String r106 = (String) CollectionsKt.firstOrNull(r100);
        if (r106 == null) goto L24;
        HashMap r113 = (HashMap) ((com.larus.network.http.y) r112).f360135b;
        if (r113 == null) goto L24;
        return (ic8.g) r113.get(r106);
    L24:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        JSONObject r107 = new JSONObject();
        r107.put("uris", new JSONArray(r100));
        r107.put("status_only", false);
        Map r108 = MapsKt.emptyMap();
        Type r114 = new a().getType();
        r103.L$0 = r100;
        r103.label = 1;
        r111 = HttpExtKt.m(ServiceType.FIRST_PART, r114, "/alice/resource/get_audio_parse_result", r107, r108, false, r103);
        if (r111 != r104) goto L17;
        return r104;
    L7:
        r101 = new AttachmentUtil$getAudioParseResult$1(this, r110);
        goto L8
    }
}
