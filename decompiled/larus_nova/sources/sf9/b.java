package sf9;

import com.larus.im.internal.delegate.w;
import com.larus.im.service.audio.cmd.TriggerMode;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f541744a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f541745a = null;

        static {
            int[] r100 = new int[TriggerMode.values().length];
            r100[TriggerMode.HELLO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L55:
            r100[TriggerMode.HELLO_NEW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L67:
            r100[TriggerMode.WAIT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L41:
            r100[TriggerMode.HANGUP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L43:
            r100[TriggerMode.AUTH_DENY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L51:
            r100[TriggerMode.AUTH_SUCCESS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L61:
            r100[TriggerMode.ONBOARDING_START.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L47:
            r100[TriggerMode.CONTINUE_TYPE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L28
        L57:
            r100[TriggerMode.ANCS_SUMMARY.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L59:
            r100[TriggerMode.IMAGE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L30
        L39:
            r100[TriggerMode.INTERVIEW_IMAGE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L31
        L53:
            r100[TriggerMode.CLIENT_SUMMON_NOTICE.ordinal()] = 12;     // Catch: NoSuchFieldError -> L32
        L65:
            r100[TriggerMode.SUGGEST.ordinal()] = 13;     // Catch: NoSuchFieldError -> L33
        L37:
            r100[TriggerMode.DORA_E_BOT_ACTIVE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L34
        L45:
            r100[TriggerMode.QUERY_WHEN_SILENCE.ordinal()] = 15;     // Catch: NoSuchFieldError -> L35
        L63:
            r100[TriggerMode.FULL_TEXT_QUERY.ordinal()] = 16;     // Catch: NoSuchFieldError -> L36
        L19:
            f541745a = r100;
        }
    }

    static {
    }

    public static boolean a(TriggerMode r100) {
        return CollectionsKt.contains(CollectionsKt.mutableListOf(new TriggerMode[]{TriggerMode.HELLO, TriggerMode.WAIT, TriggerMode.HANGUP, TriggerMode.AUTH_DENY, TriggerMode.AUTH_SUCCESS, TriggerMode.ONBOARDING_START, TriggerMode.CONTINUE_TYPE, TriggerMode.CLIM_IN_STARTED, TriggerMode.CLIM_IN_END, TriggerMode.INTERPRET_ASR_STARTED, TriggerMode.ANCS_SUMMARY, TriggerMode.DOWNLINK_QUOTA_EXCEEDED}), r100);
    }

    public static Integer b(TriggerMode r100) {
        if (r100 != null) goto L4;
        int r101 = -1;
    L5:
        switch(r101) {
            case 1: goto L27;
            case 2: goto L22;
            case 3: goto L42;
            case 4: goto L41;
            case 5: goto L40;
            case 6: goto L39;
            case 7: goto L38;
            case 8: goto L37;
            case 9: goto L36;
            case 10: goto L35;
            case 11: goto L34;
            case 12: goto L33;
            case 13: goto L32;
            case 14: goto L31;
            case 15: goto L30;
            case 16: goto L29;
            default: goto L6;
        };
    L6:
        return null;
    L29:
        return 99;
    L30:
        return 101;
    L31:
        return 100;
    L32:
        return 17;
    L33:
        return 16;
    L34:
        return 22;
    L35:
        return 14;
    L36:
        return 13;
    L37:
        return 12;
    L38:
        return 8;
    L39:
        return 6;
    L40:
        return 5;
    L41:
        return 4;
    L42:
        return 2;
    L22:
        if (w.g() != 0) goto L24;
        int r102 = 19;
    L43:
        return Integer.valueOf(r102);
    L24:
        r102 = 18;
        goto L43
    L27:
        return 1;
    L4:
        r101 = a.f541745a[r100.ordinal()];
        goto L5
    }
}
