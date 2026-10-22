package jec;

import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumSet<RichTextElement.RichTextTag> f498841a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumSet<RichTextElement.RichTextTag> f498842b = null;

    /* JADX INFO: renamed from: jec.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C6429a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f498843a = null;

        static {
            int[] r100 = new int[RichTextElement.RichTextTag.values().length];
            r100[RichTextElement.RichTextTag.IMG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[RichTextElement.RichTextTag.AT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[RichTextElement.RichTextTag.ANCHOR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[RichTextElement.RichTextTag.MEDIA.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[RichTextElement.RichTextTag.AT_USER_GROUP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[RichTextElement.RichTextTag.MARKDOWN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f498843a = r100;
        }
    }

    static {
        RichTextElement.RichTextTag r100 = RichTextElement.RichTextTag.LI;
        RichTextElement.RichTextTag r101 = RichTextElement.RichTextTag.QUOTE;
        f498841a = EnumSet.of(r100, new RichTextElement.RichTextTag[]{RichTextElement.RichTextTag.UL, RichTextElement.RichTextTag.OL, RichTextElement.RichTextTag.CODE_BLOCK_V2, RichTextElement.RichTextTag.PARAGRAPH, RichTextElement.RichTextTag.IMG, RichTextElement.RichTextTag.MEDIA, r101, RichTextElement.RichTextTag.FIGURE, RichTextElement.RichTextTag.MARKDOWN});
        f498842b = EnumSet.of(r101, RichTextElement.RichTextTag.DOCS);
        EnumSet.of(RichTextElement.RichTextTag.TEXT, new RichTextElement.RichTextTag[]{RichTextElement.RichTextTag.AT, RichTextElement.RichTextTag.EMOTION, RichTextElement.RichTextTag.ANCHOR, RichTextElement.RichTextTag.MENTION, RichTextElement.RichTextTag.CODE, RichTextElement.RichTextTag.AT_USER_GROUP});
    }
}
