package com.larus.bmhome.chat.list.cell.nested_file;

import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.bean.AudioFileDetail;
import com.larus.bmhome.chat.bean.GetAudioFileDetailData;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class AttachmentUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AttachmentUtil f305408a = null;

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/network/http/HttpExtKt$httpPost2$2", "Lcom/google/gson/reflect/TypeToken;", "network_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<HashMap<String, ic8.g>> {
        public a() {
        }
    }

    static {
        f305408a = new AttachmentUtil();
    }

    public AttachmentUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object b(List<String> r100, Continuation<? super ic8.g> r110) {
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
        if ((r112 instanceof com.larus.network.http.y) == false) goto L25;
        String r106 = (String) CollectionsKt.firstOrNull(r100);
        if (r106 == null) goto L27;
        HashMap r113 = (HashMap) ((com.larus.network.http.y) r112).f360135b;
        if (r113 != null) goto L24;
        return null;
    L24:
        return (ic8.g) r113.get(r106);
    L27:
        return null;
    L25:
        boolean r107 = r112 instanceof com.larus.network.http.f;
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        JSONObject r108 = new JSONObject();
        r108.put("uris", new JSONArray(r100));
        r108.put("status_only", false);
        Map r109 = MapsKt.emptyMap();
        Type r114 = new a().getType();
        r103.L$0 = r100;
        r103.label = 1;
        r111 = HttpExtKt.m(ServiceType.FIRST_PART, r114, "/alice/resource/get_audio_parse_result", r108, r109, false, r103);
        if (r111 != r104) goto L17;
        return r104;
    L7:
        r101 = new AttachmentUtil$getAudioParseResult$1(this, r110);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(String r110, String r111, List<String> r112, Continuation<? super HashMap<String, AudioFileDetail>> r113) {
        if ((r113 instanceof AttachmentUtil$getAudioDetailUrl$1) == false) goto L7;
        AttachmentUtil$getAudioDetailUrl$1 r100 = (AttachmentUtil$getAudioDetailUrl$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        AttachmentUtil$getAudioDetailUrl$1 r114 = r100;
        Object r102 = r114.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r114.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L17:
        com.larus.network.http.a r105 = (com.larus.network.http.a) r102;
        if ((r105 instanceof com.larus.network.http.y) == false) goto L23;
        GetAudioFileDetailData r106 = (GetAudioFileDetailData) ((com.larus.network.http.y) r105).f360135b;
        if (r106 != null) goto L22;
        return null;
    L22:
        return r106.a();
    L23:
        boolean r107 = r105 instanceof com.larus.network.http.f;
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        JSONObject r108 = new JSONObject();
        r108.put("bot_id", r110);
        r108.put("user_id", r111);
        r108.put("uris", new JSONArray(r112));
        Unit r109 = Unit.INSTANCE;
        r114.label = 1;
        r102 = HttpExtKt.k(ServiceType.FIRST_PART, GetAudioFileDetailData.class, "/alice/resource/get_audio_file_detail", r108, null, null, false, null, null, null, r114, 1008);
        if (r102 != r103) goto L17;
        return r103;
    L7:
        r100 = new AttachmentUtil$getAudioDetailUrl$1(this, r113);
        goto L8
    }
}
