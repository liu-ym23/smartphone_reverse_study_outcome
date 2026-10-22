package com.obric.assistant.cocreationreview;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f387337a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f387338a = null;

        static {
            int[] r100 = new int[ModuleKey.values().length];
            r100[ModuleKey.PROACTIVE_AGENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[ModuleKey.SCREEN_MEMORY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[ModuleKey.AUDIO_MEMORY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[ModuleKey.AUTO_MEMORY_PRO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[ModuleKey.COLLECTION_MEMORY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[ModuleKey.PERSONAL_MEMORY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[ModuleKey.SEARCH_QA.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[ModuleKey.OMNI.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f387338a = r100;
        }
    }

    static {
    }

    public static int a(ModuleKey r100) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        switch(a.f387338a[r100.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        return 2;
    L7:
        return 3;
    L8:
        return 7;
    L9:
        return 8;
    L10:
        return 6;
    L11:
        return 5;
    L12:
        return 4;
    L13:
        return 1;
    L5:
        throw new NoWhenBranchMatchedException();
    }
}
