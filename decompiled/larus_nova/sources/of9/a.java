package of9;

import com.larus.im.internal.delegate.w;
import com.larus.im.service.audio.cmd.TriggerMode;
import fe9.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: of9.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C7046a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f523124a = null;

        static {
            int[] r100 = new int[TriggerMode.values().length];
            r100[TriggerMode.HELLO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L59:
            r100[TriggerMode.HELLO_NEW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L71:
            r100[TriggerMode.WAIT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L45:
            r100[TriggerMode.HANGUP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L47:
            r100[TriggerMode.AUTH_DENY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L55:
            r100[TriggerMode.AUTH_SUCCESS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L65:
            r100[TriggerMode.AUTH_FAILED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L51:
            r100[TriggerMode.ONBOARDING_START.ordinal()] = 8;     // Catch: NoSuchFieldError -> L29
        L61:
            r100[TriggerMode.CONTINUE_TYPE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L30
        L63:
            r100[TriggerMode.ANCS_SUMMARY.ordinal()] = 10;     // Catch: NoSuchFieldError -> L31
        L41:
            r100[TriggerMode.IMAGE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L32
        L57:
            r100[TriggerMode.INTERVIEW_IMAGE.ordinal()] = 12;     // Catch: NoSuchFieldError -> L33
        L69:
            r100[TriggerMode.CLIENT_SUMMON_NOTICE.ordinal()] = 13;     // Catch: NoSuchFieldError -> L34
        L39:
            r100[TriggerMode.SUGGEST.ordinal()] = 14;     // Catch: NoSuchFieldError -> L35
        L49:
            r100[TriggerMode.FULL_TEXT_QUERY.ordinal()] = 15;     // Catch: NoSuchFieldError -> L36
        L67:
            r100[TriggerMode.DORA_E_BOT_ACTIVE.ordinal()] = 16;     // Catch: NoSuchFieldError -> L37
        L43:
            r100[TriggerMode.QUERY_WHEN_SILENCE.ordinal()] = 17;     // Catch: NoSuchFieldError -> L38
        L20:
            f523124a = r100;
        }
    }

    public static final int a(TriggerMode r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        switch(C7046a.f523124a[r100.ordinal()]) {
            case 1: goto L24;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L12;
            case 11: goto L11;
            case 12: goto L10;
            case 13: goto L9;
            case 14: goto L8;
            case 15: goto L7;
            case 16: goto L6;
            case 17: goto L5;
            default: goto L4;
        };
    L4:
        e.f476626a.b("TriggerMode", "cannot map mode: " + r100 + '.');
        return 0;
    L5:
        return 101;
    L6:
        return 100;
    L7:
        return 99;
    L8:
        return 17;
    L9:
        return 16;
    L10:
        return 22;
    L11:
        return 14;
    L12:
        return 13;
    L13:
        return 12;
    L14:
        return 8;
    L15:
        return 7;
    L16:
        return 6;
    L17:
        return 5;
    L18:
        return 4;
    L19:
        return 2;
    L24:
        return 1;
    L21:
        if (w.g() != 0) goto L23;
        return 19;
    L23:
        return 18;
    }
}
