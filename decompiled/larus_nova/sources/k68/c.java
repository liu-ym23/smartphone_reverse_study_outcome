package k68;

import com.bytedance.flow_audio.api.tracer.TtsTracer;
import com.larus.audio.audiov3.task.sami.v2.b0;
import com.mammon.audiosdk.SAMICoreCallBackListener;
import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreServerEvent;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class c implements SAMICoreCallBackListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TtsTracer f501972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f501973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StringBuilder f501974c;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f501975a = null;

        static {
            int[] r100 = new int[SAMICoreCallBackEventType.values().length];
            r100[SAMICoreCallBackEventType.TTSSentenceStart.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[SAMICoreCallBackEventType.TTSSentenceEnd.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[SAMICoreCallBackEventType.TTSResponse.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[SAMICoreCallBackEventType.ChatResponse.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f501975a = r100;
        }
    }

    static {
    }

    public c() {
        this.f501974c = new StringBuilder();
    }

    @Override // com.mammon.audiosdk.SAMICoreCallBackListener
    public final void onMessageReceived(SAMICoreCallBackEventType r100, SAMICoreBlock r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "data");
        int r102 = b.f501975a[r100.ordinal()];
        if (r102 != 1) goto L5;
        return;
    L5:
        if (r102 == 2) goto L38;
        SAMICoreServerEvent r103 = null;
        if (r102 != 3) goto L9;
        Object r104 = ArraysKt.firstOrNull(r101.audioData);
        if ((r104 instanceof SAMICoreServerEvent) == false) goto L26;
        r103 = (SAMICoreServerEvent) r104;
    L26:
        if (r103 == null) goto L30;
        byte[] r105 = r103.binaryData;
        if (r105 == null) goto L30;
        int r106 = r105.length;
    L31:
        this.f501973b += (long) r106;
        TtsTracer r107 = this.f501972a;
        if (r107 == null) goto L43;
        r107.updateParams(new k68.a(this));
        return;
    L43:
        return;
    L30:
        r106 = 0;
        goto L31
    L9:
        if (r102 != 4) goto L44;
        Object r108 = ArraysKt.firstOrNull(r101.audioData);     // Catch: Exception -> L21
        if ((r108 instanceof SAMICoreServerEvent) == false) goto L14;
        r103 = (SAMICoreServerEvent) r108;     // Catch: Exception -> L21
    L14:
        if (r103 == null) goto L39;
        String r109 = r103.textMsg;     // Catch: Exception -> L21
        if (r109 == null) goto L40;
        this.f501974c.append(new JSONObject(r109).optString("raw_content"));     // Catch: Exception -> L21
        final int r110 = this.f501974c.length();     // Catch: Exception -> L21
        TtsTracer r111 = this.f501972a;     // Catch: Exception -> L21
        if (r111 == null) goto L41;
        r111.updateParams(new k68.b(r110));     // Catch: Exception -> L21
        Unit r112 = Unit.INSTANCE;     // Catch: Exception -> L21
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L21:
        e = move-exception;
        int r113 = c68.b.f22600a;
        c68.b.c("TtsRespChecker", this + " ChatResponse parse raw_content failed. " + b0.b(r101), e);
        Unit r114 = Unit.INSTANCE;
        return;
    L44:
        return;
    }
}
