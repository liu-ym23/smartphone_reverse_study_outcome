package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f436747a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f436748b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<String> f436749c = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f436750a = null;

        static {
            int[] r100 = new int[MmStandaloneAIInterpretationLanguageSide.values().length];
            r100[MmStandaloneAIInterpretationLanguageSide.SPOKEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MmStandaloneAIInterpretationLanguageSide.TARGET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f436750a = r100;
        }
    }

    static {
        f436747a = SetsKt.setOf(new String[]{"zhen", "zh_cn_en_us"});
        f436748b = SetsKt.setOf(new String[]{"zh", "zh_cn"});
        f436749c = SetsKt.setOf(new String[]{"en", "en_us"});
    }

    public static final boolean a(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (f436747a.contains(r100) == false) goto L6;
        return true;
    }

    public static final boolean b(String r110, String r111) {
        if (Intrinsics.areEqual(r110, r111) == false) goto L5;
        return true;
    L5:
        if (StringsKt.split$default(r110, new char[]{'_'}, false, 0, 6, null).contains(r111) == false) goto L7;
        return true;
    L7:
        if (StringsKt.split$default(r111, new char[]{'_'}, false, 0, 6, null).contains(r110) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static final boolean c(String r100, List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r101) {
        Intrinsics.checkNotNullParameter(r101, "spokenLanguages");
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((!r101.isEmpty()) == false) goto L24;
        List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r102 = r101;
        if ((r102 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r103 = r102.iterator();
    L13:
        if (r103.hasNext() == false) goto L10;
        if (Intrinsics.areEqual(((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r103.next()).f435126a, r100) == false) goto L13;
        boolean r104 = false;
    L17:
        if (r104 == false) goto L25;
        return true;
    L25:
        return false;
    L10:
        r104 = true;
        goto L17
    L9:
        if (r102.isEmpty() == false) goto L11;
    L24:
        return false;
    }

    public static final MmStandaloneAIInterpretationLanguageDisabledReason d(MmStandaloneAIInterpretationLanguageSide r100, String r101, String r102, String r103, Map<String, ? extends List<String>> r104, Map<String, ? extends List<String>> r105, List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r110) {
        Intrinsics.checkNotNullParameter(r100, "side");
        Intrinsics.checkNotNullParameter(r101, "candidateLanguageType");
        Intrinsics.checkNotNullParameter(r104, "spokenToTargetLanguageTypes");
        Intrinsics.checkNotNullParameter(r105, "targetToSpokenLanguageTypes");
        Intrinsics.checkNotNullParameter(r110, "spokenLanguages");
        if (a(r101) == false) goto L6;
        return null;
    L6:
        if (a(r102) == false) goto L8;
        return null;
    L8:
        if (a(r103) == false) goto L11;
        return null;
    L11:
        if (r100 == MmStandaloneAIInterpretationLanguageSide.TARGET) goto L13;
    L15:
        int[] r111 = a.f436750a;
        int r106 = r111[r100.ordinal()];
        if (r106 == 1) goto L21;
        if (r106 != 2) goto L20;
    L22:
        if (r102 != null) goto L25;
        return null;
    L25:
        if (b(r101, r102) == true) goto L27;
        int r107 = r111[r100.ordinal()];
        if (r107 == 1) goto L42;
        if (r107 != 2) goto L40;
        if ((!r104.isEmpty()) == false) goto L51;
        List<String> r108 = r104.get(r102);
        if (r108 != null) goto L37;
        r108 = CollectionsKt.emptyList();
    L37:
        if (r108.contains(r101) == false) goto L53;
        return null;
    L53:
        return MmStandaloneAIInterpretationLanguageDisabledReason.SOURCE_TO_TARGET_UNSUPPORTED;
    L51:
        return null;
    L40:
        throw new NoWhenBranchMatchedException();
    L42:
        if ((!r105.isEmpty()) == false) goto L54;
        List<String> r109 = r105.get(r102);
        if (r109 != null) goto L47;
        r109 = CollectionsKt.emptyList();
    L47:
        if (r109.contains(r101) == false) goto L49;
        return null;
    L49:
        return MmStandaloneAIInterpretationLanguageDisabledReason.TARGET_TO_SOURCE_UNSUPPORTED;
    L54:
        return null;
    L27:
        return MmStandaloneAIInterpretationLanguageDisabledReason.SAME_LANGUAGE;
    L20:
        throw new NoWhenBranchMatchedException();
    L21:
        r102 = r103;
        goto L22
    L13:
        if (c(r102, r110) == false) goto L15;
        return null;
    }
}
