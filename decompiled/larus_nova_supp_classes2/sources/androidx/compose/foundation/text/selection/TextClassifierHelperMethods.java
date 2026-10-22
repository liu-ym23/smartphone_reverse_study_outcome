package androidx.compose.foundation.text.selection;

import android.content.Context;
import android.os.LocaleList;
import android.text.TextUtils;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassificationContext;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import androidx.compose.ui.text.intl.Locale;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0011\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0000¢\u0006\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/text/selection/TextClassifierHelperMethods;", "", "<init>", "()V", "createTextClassificationSession", "Landroid/view/textclassifier/TextClassifier;", "context", "Landroid/content/Context;", "selectedTextType", "Landroidx/compose/foundation/text/selection/SelectedTextType;", "toAndroidLocaleList", "Landroid/os/LocaleList;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "hasLegacyAssistItem", "", "Landroid/view/textclassifier/TextClassification;", "hasLegacyAssistItem$foundation_release", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextClassifierHelperMethods {
    public static final int $stable = 0;
    public static final TextClassifierHelperMethods INSTANCE = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[SelectedTextType.values().length];
            r0[SelectedTextType.EditableText.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[SelectedTextType.StaticText.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        INSTANCE = new TextClassifierHelperMethods();
    }

    private TextClassifierHelperMethods() {
    }

    public final boolean hasLegacyAssistItem$foundation_release(TextClassification r2) {
        if (r2.getIcon() != null) goto L7;
        if (TextUtils.isEmpty(r2.getLabel()) == false) goto L7;
    L11:
        return false;
    L7:
        if (r2.getIntent() == null) goto L9;
    L12:
        return true;
    L9:
        if (r2.getOnClickListener() == null) goto L11;
        goto L11
    }

    public final LocaleList toAndroidLocaleList(androidx.compose.ui.text.intl.LocaleList r3) {
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.add(((Locale) r4.next()).getPlatformLocale());
        goto L4
    L6:
        java.util.Locale[] r5 = (java.util.Locale[]) r0.toArray(new java.util.Locale[0]);
        return new LocaleList((java.util.Locale[]) Arrays.copyOf(r5, r5.length));
    }

    public final TextClassifier createTextClassificationSession(Context r3, SelectedTextType r4) {
        TextClassificationManager r0 = (TextClassificationManager) r3.getSystemService(TextClassificationManager.class);
        int r5 = WhenMappings.$EnumSwitchMapping$0[r4.ordinal()];
        if (r5 != 1) goto L5;
        String r6 = "edittext";
    L11:
        return r0.createTextClassificationSession(new TextClassificationContext.Builder(r3.getPackageName(), r6).build());
    L5:
        if (r5 != 2) goto L8;
        r6 = "textview";
        goto L11
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
