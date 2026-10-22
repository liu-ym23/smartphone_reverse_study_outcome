package r2a;

import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.voice_setting.voice.bean.RequestType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<SpeakerVoice> f535834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f535835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f535836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RequestType f535837d;

    public e() {
        this(null, null, null, 31);
    }

    public e(List r100, Integer r101, Integer r102, int r103) {
        RequestType r104 = null;
        if ((r103 & 2) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 4) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 8) == 0) goto L12;
        r102 = null;
    L12:
        if ((r103 & 16) == 0) goto L14;
        r104 = RequestType.INIT;
    L14:
        Intrinsics.checkNotNullParameter(r104, "requestType");
        this.f535834a = r100;
        this.f535835b = r101;
        this.f535836c = r102;
        this.f535837d = r104;
    }
}
