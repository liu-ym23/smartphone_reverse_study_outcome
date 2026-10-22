package vc8;

import com.bytedance.keva.Keva;
import com.larus.im.bean.message.MessageTag;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.o2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f554133a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f554134a = null;

        static {
            int[] r100 = new int[MessageTag.values().length];
            r100[MessageTag.MessageTag_Onboarding_FIRSTMEG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[MessageTag.MessageTag_Onboarding_WELCOMEBACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[MessageTag.MessageTag_Onboarding_LONG_TIME_NO_SEE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f554134a = r100;
        }
    }

    static {
        f554133a = Keva.getRepo(o2.f365782a.e(), 0);
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        f554133a.storeBoolean("1_on_boarding_tts_" + r100 + '_' + AccountService.f365697a.getSecUserId(), true);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        f554133a.storeString("need_show_change_icon_".concat(AccountService.f365697a.getUserId()), r100);
    }
}
