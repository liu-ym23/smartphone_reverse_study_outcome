package ida;

import com.obric.assistant.cocreationreview.modules.memory.MemoryReviewAudioTranscriptCode;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f489430a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f489431a = null;

        static {
            int[] r100 = new int[MemoryReviewAudioTranscriptCode.values().length];
            r100[MemoryReviewAudioTranscriptCode.EMPTY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MemoryReviewAudioTranscriptCode.OK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f489431a = r100;
        }
    }

    static {
    }

    public static String a(String r100, com.obric.assistant.cocreationreview.modules.memory.a r110) {
        Intrinsics.checkNotNullParameter(r100, "recordId");
        Intrinsics.checkNotNullParameter(r110, "bridge");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return null;
    L5:
        StringBuilder r101 = new StringBuilder();
        LinkedHashSet r102 = new LinkedHashSet();
        int r103 = 0;
        String r104 = null;
    L7:
        if (r103 >= 32) goto L48;
        hda.a r105 = r110.e(r100, r104);
        int r106 = a.f489431a[r105.f484626a.ordinal()];
        if (r106 == 1) goto L34;
        if (r106 != 2) goto L12;
        r101.append(r105.f484627b);
        if (r105.f484629d == false) goto L15;
        String r107 = r105.f484628c;
        if (r107 == null) goto L33;
        if ((!StringsKt.isBlank(r107)) == true) goto L25;
        r107 = null;
    L25:
        if (r107 == null) goto L33;
        if (Intrinsics.areEqual(r107, r104) == true) goto L33;
        if (r102.add(r107) == false) goto L33;
        r103 = r103 + 1;
        r104 = r107;
    L33:
        return null;
    L15:
        String r108 = r101.toString();
        if ((!StringsKt.isBlank(r108)) == true) goto L18;
        return null;
    L18:
        return r108;
    L12:
        return null;
    L34:
        String r109 = r101.toString();
        if ((!StringsKt.isBlank(r109)) == true) goto L37;
        return null;
    L37:
        return r109;
    L48:
        return null;
    }
}
