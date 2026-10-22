package y2a;

import com.larus.audio.quality.AudioCheckerResult;
import com.larus.platform.service.g;
import com.larus.platform.service.o;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f565724a = 0;

    /* JADX INFO: renamed from: y2a.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C8299a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f565725a = null;

        static {
            int[] r100 = new int[AudioCheckerResult.values().length];
            r100[AudioCheckerResult.INTERNAL_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[AudioCheckerResult.NETWORK_ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[AudioCheckerResult.PASSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[AudioCheckerResult.SNR_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[AudioCheckerResult.WER_FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[AudioCheckerResult.INIT_CONFIG_ERROR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[AudioCheckerResult.INIT_METRIC_ERROR.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[AudioCheckerResult.AUDIO_RECORD_SILENCED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f565725a = r100;
        }
    }

    static {
    }

    public static void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        g.f365738a.monitorEventForSlardar("voice_settings_clone_end", r100, null, null);
        o.f365780a.reportEvent("voice_settings_clone_end", r100);
    }

    public static void b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        g.f365738a.monitorEventForSlardar("voice_settings_clone_sheet_end", r100, null, null);
        o.f365780a.reportEvent("voice_settings_clone_sheet_end", r100);
    }

    public static void c(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        g.f365738a.monitorEventForSlardar("voice_settings_clone_sheet_start", r100, null, null);
        o.f365780a.reportEvent("voice_settings_clone_sheet_start", r100);
    }
}
