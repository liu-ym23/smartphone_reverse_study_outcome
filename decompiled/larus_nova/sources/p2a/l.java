package p2a;

import com.larus.audio.bean.GetMatchVoiceRequest;
import com.larus.audio.bean.RecommendScene;
import com.larus.voice_setting.UgcVoiceRecommendScene;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class l {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f527484a = null;

        static {
            int[] r100 = new int[RecommendScene.values().length];
            r100[RecommendScene.NULL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L57:
            r100[RecommendScene.BOT_FIRST_MET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L65:
            r100[RecommendScene.REAL_TIME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L41:
            r100[RecommendScene.CHAT_SETTING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L43:
            r100[RecommendScene.BOT_CREATE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
        L51:
            r100[RecommendScene.BOT_UPDATE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
        L59:
            r100[RecommendScene.ROUTER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L31
        L16:
            f527484a = r100;
            int[] r101 = new int[UgcVoiceRecommendScene.values().length];
            r101[UgcVoiceRecommendScene.NULL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L55:
            r101[UgcVoiceRecommendScene.BOT_FIRST_MET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L63:
            r101[UgcVoiceRecommendScene.REAL_TIME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L34
        L39:
            r101[UgcVoiceRecommendScene.CHAT_SETTING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L35
        L45:
            r101[UgcVoiceRecommendScene.BOT_CREATE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L36
        L53:
            r101[UgcVoiceRecommendScene.BOT_UPDATE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L37
        L61:
            r101[UgcVoiceRecommendScene.ROUTER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L38
            return;
        }
    }

    public static final k a(GetMatchVoiceRequest r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r100 = r110.f288717a;
        String r101 = r110.f288718b;
        String r102 = r110.f288719c;
        String r103 = r110.f288720d;
        long r104 = r110.f288721e;
        String r105 = r110.f288722f;
        RecommendScene r111 = r110.f288723g;
        Intrinsics.checkNotNullParameter(r111, "<this>");
        switch(a.f527484a[r111.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        UgcVoiceRecommendScene r112 = UgcVoiceRecommendScene.ROUTER;
    L14:
        return new k(r100, r101, r102, r103, r104, r105, r112);
    L7:
        r112 = UgcVoiceRecommendScene.BOT_UPDATE;
        goto L14
    L8:
        r112 = UgcVoiceRecommendScene.BOT_CREATE;
        goto L14
    L9:
        r112 = UgcVoiceRecommendScene.CHAT_SETTING;
        goto L14
    L10:
        r112 = UgcVoiceRecommendScene.REAL_TIME;
        goto L14
    L11:
        r112 = UgcVoiceRecommendScene.BOT_FIRST_MET;
        goto L14
    L12:
        r112 = UgcVoiceRecommendScene.NULL;
        goto L14
    L5:
        throw new NoWhenBranchMatchedException();
    }
}
