package p8c;

import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f528277a = null;

    /* JADX INFO: renamed from: p8c.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C7167a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f528278a = null;

        static {
            int[] r100 = new int[RichTextElement.RichTextTag.values().length];
            r100[RichTextElement.RichTextTag.AT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[RichTextElement.RichTextTag.ANCHOR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[RichTextElement.RichTextTag.TEXT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f528278a = r100;
        }
    }

    static {
        f528277a = new char[]{1847, 1846};
    }

    public static String a(String r100) {
        char[] r101 = f528277a;
        int r102 = 0;
    L4:
        if (r102 >= 2) goto L7;
        r100 = new Regex(String.valueOf(r101[r102])).replace(r100, "");
        r102 = r102 + 1;
        goto L4
    L7:
        return r100.toString();
    }

    @JvmStatic
    public static final void b(RichText r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        RichText.RichTextElements r101 = r100.getElements();
        if (r101 == null) goto L23;
        Map<String, RichTextElement> r102 = r101.getDictionary();
        if (r102 == null) goto L35;
        Iterator<Map.Entry<String, RichTextElement>> r103 = r102.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L36;
        RichTextElement r104 = r103.next().getValue();
        RichTextElement.RichTextTag r105 = r104.getTag();
        if (r105 != null) goto L12;
        int r106 = -1;
    L14:
        if (r106 != 1) goto L16;
        RichTextElement.AtProperty r107 = (RichTextElement.AtProperty) r104.getProperty();
        r107.setContent(a(r107.getContent()));
        goto L8
    L16:
        if (r106 != 2) goto L18;
        RichTextElement.AnchorProperty r108 = (RichTextElement.AnchorProperty) r104.getProperty();
        r108.setContent(a(r108.getContent()));
        r108.setHref(a(r108.getHref()));
        r108.setAndroidHref(a(r108.getAndroidHref()));
        goto L8
    L18:
        if (r106 != 3) goto L8;
        RichTextElement.TextProperty r109 = (RichTextElement.TextProperty) r104.getProperty();
        r109.setContent(a(r109.getContent()));
        goto L8
    L12:
        r106 = C7167a.f528278a[r105.ordinal()];
        goto L14
    L36:
        return;
    L35:
        return;
    }
}
