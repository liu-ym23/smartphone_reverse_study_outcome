package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.EditorInfo;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/text/input/internal/LocaleListHelper;", "", "<init>", "()V", "setHintLocales", "", "editorInfo", "Landroid/view/inputmethod/EditorInfo;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LocaleListHelper {
    public static final int $stable = 0;
    public static final LocaleListHelper INSTANCE = null;

    static {
        INSTANCE = new LocaleListHelper();
    }

    private LocaleListHelper() {
    }

    public final void setHintLocales(EditorInfo r3, LocaleList r4) {
        if (Intrinsics.areEqual(r4, LocaleList.Companion.getEmpty()) == false) goto L5;
        r3.hintLocales = null;
        return;
    L5:
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        r0.add(((Locale) r5.next()).getPlatformLocale());
        goto L7
    L9:
        java.util.Locale[] r6 = (java.util.Locale[]) r0.toArray(new java.util.Locale[0]);
        r3.hintLocales = new android.os.LocaleList((java.util.Locale[]) Arrays.copyOf(r6, r6.length));
    }
}
