package v2b;

import com.ss.android.lark.widget.richtext.RichTextElement;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes35.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f552779a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f552780a = null;

        static {
            int[] r100 = new int[RichTextElement.RichTextTag.values().length];
            r100[RichTextElement.RichTextTag.AT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[RichTextElement.RichTextTag.ANCHOR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[RichTextElement.RichTextTag.TEXT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f552780a = r100;
        }
    }

    static {
        f552779a = new char[]{1847, 1846};
    }

    public static String a(String r100) {
        char[] r101 = f552779a;
        int r102 = 0;
    L4:
        if (r102 >= 2) goto L7;
        r100 = new Regex(String.valueOf(r101[r102])).replace(r100, "");
        r102 = r102 + 1;
        goto L4
    L7:
        return r100.toString();
    }
}
