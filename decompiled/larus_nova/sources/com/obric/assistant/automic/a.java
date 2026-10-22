package com.obric.assistant.automic;

import com.obric.assistant.voice.ContentScene;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.obric.assistant.automic.a$a, reason: collision with other inner class name */
    public static final class C4592a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f385854a = null;

        static {
            int[] r100 = new int[ContentScene.values().length];
            r100[ContentScene.OAUTO_CALL_USER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[ContentScene.COMPLEX_ASK_USER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[ContentScene.PRIORITY_NOTIFICATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[ContentScene.AI_ACTIVE_ASK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[ContentScene.UNKNOWN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f385854a = r100;
        }
    }

    static {
    }

    public static String a(ContentScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        int r101 = b.f385854a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return "oauto_automic";
    L5:
        if (r101 != 2) goto L7;
        return "oautopro_automic";
    L7:
        if (r101 != 3) goto L9;
        return "high_priority_notification";
    L9:
        if (r101 != 4) goto L11;
        return "ai_active_ask";
    L11:
        if (r101 != 5) goto L14;
        return "";
    L14:
        throw new NoWhenBranchMatchedException();
    }
}
