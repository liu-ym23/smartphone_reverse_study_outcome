package com.larus.kmp.voice_setting.voice.component;

import com.larus.kmp.voice_setting.voice.entry.VoiceActivityFragmentKind;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class z5 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f352664a = null;

        static {
            int[] r100 = new int[VoiceActivityFragmentKind.values().length];
            r100[VoiceActivityFragmentKind.SINGLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[VoiceActivityFragmentKind.DOUBLE_TAB.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f352664a = r100;
        }
    }

    public static final n4 a(d6 r110, long r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        return new n4(r111, r110.f352212a, r110.f352213b, r110.f352215d, r110.f352214c, r110.f352216e, r110.f352217f, r110.f352218g, r110.f352219h);
    }

    public static final List<m4> b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "editLabel");
        Intrinsics.checkNotNullParameter(r101, "deleteLabel");
        return CollectionsKt.listOf(new m4[]{new m4(VoiceDropdownMenuItemKind.EDIT, r100, false), new m4(VoiceDropdownMenuItemKind.DELETE, r101, true)});
    }
}
