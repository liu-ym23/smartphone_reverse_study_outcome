package q2a;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.audio.bean.VoiceListTabInfo;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f531469a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f531470b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f531471c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Map<String, ? extends List<VoiceListTabInfo>> f531472d;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00020\u0001¨\u0006\u0006"}, d2 = {"com/larus/voice_setting/voice/base/api/GetVoiceTabRepo$loadVoiceListTabInfoFromKeva$data$1$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "Lcom/larus/audio/bean/VoiceListTabInfo;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<Map<String, ? extends List<? extends VoiceListTabInfo>>> {
        public a() {
        }
    }

    public c() {
    }

    static {
        f531469a = new c();
        f531470b = LazyKt.lazy(new q2a.a());
        f531471c = LazyKt.lazy(new b());
    }

    public static Map a() {
        Object r100 = "";
        Map<String, ? extends List<VoiceListTabInfo>> r101 = f531472d;
        if (r101 == null) goto L40;
        return r101;
    L40:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L10
        f531469a.getClass();     // Catch: Throwable -> L10
        String r103 = ((Keva) f531470b.getValue()).getString("key_voice_list_tab_info", "");     // Catch: Throwable -> L10
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L10
    L12:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L16;
        FLogger.f375446a.e("GetVoiceTabRepo", "[loadVoiceListTabInfoFromKeva] read voice tab from keva failed", r105);
    L16:
        if (Result.m9455isFailureimpl(r104) == true) goto L19;
        r100 = r104;
    L19:
        String r106 = (String) r100;
        FLogger r107 = FLogger.f375446a;
        StringBuilder r108 = new StringBuilder("[loadVoiceListTabInfoFromKeva]: invoke sync dataStr isNotEmpty(");
        boolean r109 = false;
        if (r106.length() <= 0) goto L22;
        boolean r110 = true;
    L23:
        r108.append(r110);
        r108.append(')');
        r107.i("GetVoiceTabRepo", r108.toString());
        if (r106.length() <= 0) goto L26;
        r109 = true;
    L26:
        if (r109 == false) goto L39;
        f531469a.getClass();     // Catch: Throwable -> L29
        Object r111 = Result.m9449constructorimpl((Map) ((Gson) f531471c.getValue()).fromJson(r106, new a().getType()));     // Catch: Throwable -> L29
    L31:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 == null) goto L35;
        FLogger.f375446a.e("GetVoiceTabRepo", "[loadVoiceListTabInfoFromKeva] load voice tab from keva failed", r112);
    L35:
        if (Result.m9455isFailureimpl(r111) == false) goto L37;
        r111 = null;
    L37:
        f531472d = (Map) r111;
    L29:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L39:
        return f531472d;
    L22:
        r110 = false;
    L10:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }
}
