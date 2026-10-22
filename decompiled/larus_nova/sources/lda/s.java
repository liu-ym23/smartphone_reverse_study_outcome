package lda;

import com.obric.assistant.cocreationreview.Vote;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class s {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f508831a = null;

        static {
            int[] r100 = new int[Vote.values().length];
            r100[Vote.UP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Vote.DOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f508831a = r100;
        }
    }

    public static final String a(String r100) {
        String r101 = StringsKt.replace$default(r100, "\n", "\\n", false, 4, null);
        if (r101.length() > 48) goto L6;
        return r101;
    L6:
        return StringsKt.take(r101, 48) + "...";
    }
}
