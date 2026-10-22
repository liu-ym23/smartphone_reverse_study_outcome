package com.larus.bmhome.upload.audio;

import com.bytedance.apm.util.u;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import com.larus.utils.z;
import com.larus.voicecall.impl.component.picture.x;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f314751a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, l> f314752b = null;

    public g() {
    }

    static {
        f314751a = new g();
        f314752b = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object a(g r110, c r111, Function2 r112, e r210, Continuation r211) {
        r110.getClass();
        if ((r211 instanceof AudioResourceUploader$upload$1) == false) goto L7;
        AudioResourceUploader$upload$1 r100 = (AudioResourceUploader$upload$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r113 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        String r114 = "AudioImageUploader";
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        com.larus.network.http.a r104 = (com.larus.network.http.a) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r114 = "AudioImageUploader";
    L37:
        FLogger.f375446a.e(r114, "api(/alice/audio/upload_file) error, msg:" + ((com.larus.network.http.f) r104).f360157d);
    L44:
        return null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Function2 r105 = (Function2) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Object r106 = r102;
    L31:
        com.larus.network.http.a r107 = (com.larus.network.http.a) r106;
        if ((r107 instanceof com.larus.network.http.f) == false) goto L39;
        AsyncThrowable r108 = ((com.larus.network.http.f) r107).f360157d;
        r100.L$0 = r107;
        r100.label = 2;
        if (r105.invoke(r108, r100) == r113) goto L48;
        r104 = r107;
        goto L37
    L48:
        return r113;
    L39:
        if ((r107 instanceof y) == false) goto L44;
        FLogger.f375446a.d(r114, "api(/alice/audio/upload_file) success");
        T r109 = ((y) r107).f360135b;
        if ((r109 instanceof k) == false) goto L44;
        return (k) r109;
    L16:
        ResultKt.throwOnFailure(r102);
        String r115 = z.c(r111);
        if (r115 != null) goto L19;
    L22:
        boolean r116 = true;
    L23:
        if (r116 == false) goto L25;
    L43:
        FLogger.f375446a.e("AudioImageUploader", "input nothing!");
        goto L44
    L25:
        if (StringsKt.isBlank(r115) == true) goto L43;
        JSONObject r117 = new JSONObject(r115);
        f r118 = new f(r210);
        r100.L$0 = r112;
        r100.label = 1;
        Object r119 = HttpExtKt.k(ServiceType.AUDIO, i.class, "/alice/audio/upload_file", r117, null, null, false, null, null, r118, r100, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_TIMEOUT);
        if (r119 == r113) goto L47;
        r106 = r119;
        r105 = r112;
        goto L31
    L47:
        return r113;
    L19:
        if (r115.length() == 0) goto L22;
        r116 = false;
    L7:
        r100 = new AudioResourceUploader$upload$1(r110, r211);
        goto L8
    }

    public static Object b(List r100, String r110, String r111, x r112, com.larus.voicecall.impl.component.picture.y r113, Continuation r114) {
        AudioResourceUploader$upLoadImage$task$1 r101 = new AudioResourceUploader$upLoadImage$task$1(r110, r111, r100, r113, new d(), r112, null);
        if (u.a() == false) goto L8;
        Object r102 = BuildersKt.withContext(Dispatchers.getIO(), new AudioResourceUploader$upLoadImage$5(r101, null), r114);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r102;
    L13:
        return Unit.INSTANCE;
    L8:
        Object r103 = r101.invoke(r114);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        return r103;
    L12:
        return Unit.INSTANCE;
    }
}
