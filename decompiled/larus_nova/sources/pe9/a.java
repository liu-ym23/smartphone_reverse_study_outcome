package pe9;

import com.larus.im.service.audio.cmd.ReplyEndType;
import com.larus.im.service.audio.cmd.ReplyStage;
import com.larus.im.service.audio.z0;
import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreServerEvent;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import pf9.f0;

/* JADX INFO: loaded from: classes30.dex */
public final class a extends d {

    /* JADX INFO: renamed from: pe9.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C7188a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f528722a = null;

        static {
            int[] r100 = new int[SAMICoreCallBackEventType.values().length];
            r100[SAMICoreCallBackEventType.TTSSentenceStart.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[SAMICoreCallBackEventType.TTSResponse.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[SAMICoreCallBackEventType.TTSSentenceEnd.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[SAMICoreCallBackEventType.TTSEnded.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f528722a = r100;
        }
    }

    public a() {
    }

    @Override // pe9.d
    public final List<z0.a> c(SAMICoreCallBackEventType r100, SAMICoreBlock r101, SAMICoreServerEvent r102, e r103) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        ArrayList r104 = new ArrayList();
        int r105 = C7188a.f528722a[r100.ordinal()];
        if (r105 != 1) goto L5;
        String r106 = b.f528723a;
        String r107 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        b.f528723a = r107;
        f0 r108 = d.b(r101, ReplyStage.Begin);
        if (r108 == null) goto L26;
        r104.add(r108);
    L26:
        fe9.a.f476620a.e("AudioReplyDownLinkMapper", "[mapDownLinkEvent] result:" + CollectionsKt.firstOrNull(r104));
        return r104;
    L5:
        if (r105 != 2) goto L7;
        f0 r109 = d.b(r101, ReplyStage.Update);
        if (r109 == null) goto L26;
        r104.add(r109);
        goto L26
    L7:
        if (r105 != 3) goto L9;
        String r110 = b.f528723a;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        b.f528723a = "";
        f0 r111 = d.b(r101, ReplyStage.End);
        if (r111 == null) goto L26;
        r104.add(r111);
        goto L26
    L9:
        if (r105 != 4) goto L26;
        z0.a r112 = d.a(ReplyEndType.Generated, r101);
        if (r112 == null) goto L14;
        r104.add(r112);
    L14:
        z0.a r113 = d.a(ReplyEndType.Pushed, r101);
        if (r113 == null) goto L26;
        r104.add(r113);
        goto L26
    }
}
