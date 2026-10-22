package com.ss.android.lark.widget.codeblock.entity;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0003\u0011\u0012\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/widget/codeblock/entity/LineContent;", "Ljava/io/Serializable;", "<init>", "()V", "contents", "", "Lcom/ss/android/lark/widget/codeblock/entity/LineContent$Content;", "getContents", "()Ljava/util/List;", "setContents", "(Ljava/util/List;)V", "equals", "", "other", "", "hashCode", "", "Companion", "Content", "ContentType", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LineContent implements Serializable {
    public static final a Companion = null;
    public static final String ENTER = "\n";
    public static final String FOUR_SPACE = "    ";
    public static final String TABSPACE = "\t";
    private List<Content> contents;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/widget/codeblock/entity/LineContent$Content;", "Ljava/io/Serializable;", "<init>", "()V", "originText", "", "getOriginText", "()Ljava/lang/String;", "setOriginText", "(Ljava/lang/String;)V", "contentType", "Lcom/ss/android/lark/widget/codeblock/entity/LineContent$ContentType;", "getContentType", "()Lcom/ss/android/lark/widget/codeblock/entity/LineContent$ContentType;", "setContentType", "(Lcom/ss/android/lark/widget/codeblock/entity/LineContent$ContentType;)V", "style", "", "getStyle", "()Ljava/util/Map;", "setStyle", "(Ljava/util/Map;)V", "equals", "", "other", "", "hashCode", "", "getDisplayText", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Content implements Serializable {
        private ContentType contentType;
        private String originText;
        private Map<String, String> style;

        public int hashCode() {
            return Objects.hash(new Object[]{this.originText, this.contentType, this.style});
        }

        public final String getDisplayText() {
            if (StringsKt.startsWith$default(this.originText, "\t", false, 2, null) == false) goto L5;
            String r100 = StringsKt.replace$default(this.originText, "\t", LineContent.FOUR_SPACE, false, 4, null);
        L6:
            String r101 = r100;
            if (StringsKt.endsWith$default(r101, "\n", false, 2, null) == true) goto L9;
            return r101;
        L9:
            return StringsKt.replace$default(r101, "\n", "", false, 4, null);
        L5:
            r100 = this.originText;
            goto L6
        }

        public Content() {
            this.originText = "";
            this.contentType = ContentType.TEXT;
        }

        public final ContentType getContentType() {
            return this.contentType;
        }

        public final String getOriginText() {
            return this.originText;
        }

        public final Map<String, String> getStyle() {
            return this.style;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Content) == true) goto L8;
            return false;
        L8:
            Content r101 = (Content) r100;
            if (Intrinsics.areEqual(this.originText, r101.originText) == true) goto L11;
        L15:
            return false;
        L11:
            if (this.contentType != r101.contentType) goto L15;
            if (Intrinsics.areEqual(this.style, r101.style) == false) goto L15;
            return true;
        }

        public final void setContentType(ContentType r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.contentType = r100;
        }

        public final void setOriginText(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.originText = r100;
        }

        public final void setStyle(Map<String, String> r100) {
            this.style = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b9\b\u0086\u0081\u0002\u0018\u0000 ;2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001;B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:¨\u0006<"}, d2 = {"Lcom/ss/android/lark/widget/codeblock/entity/LineContent$ContentType;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", CardAdapter.TEXT, "KEYWORD", "BUILT_IN", "TYPE", "LITERAL", "NUMBER", "OPERATOR", "PUNCTUATION", "PROPERTY", "REGEXP", "STRING", "CHAR_ESCAPE", "SUBST", "SYMBOL", "CLASS", "FUNCTION", "VARIABLE", "VARIABLE_LANGUAGE", "VARIABLE_CONSTANT", "TITLE", "TITLE_CLASS", "TITLE_CLASS_INHERITED", "TITLE_FUNCTION", "TITLE_FUNCTION_INVOKE", "PARAMS", "COMMENT", "DOCTAG", "META", "META_PROMPT", "META_KEYWORD", "META_STRING", "SECTION", "TAG", "NAME", "ATTR", "ATTRIBUTE", "BULLET", "CODE", "EMPHASIS", "FORMULA", "LINK", "QUOTE", "SELECTOR_TAG", "SELECTOR_ID", "SELECTOR_CLASS", "SELECTOR_ATTR", "SELECTOR_PSEUDO", "TEMPLATE_TAG", "TEMPLATE_VARIABLE", "ADDITION", "DELETION", "Companion", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ContentType extends Enum<ContentType> {
        public static final ContentType ADDITION = null;
        public static final ContentType ATTR = null;
        public static final ContentType ATTRIBUTE = null;
        public static final ContentType BUILT_IN = null;
        public static final ContentType BULLET = null;
        public static final ContentType CHAR_ESCAPE = null;
        public static final ContentType CLASS = null;
        public static final ContentType CODE = null;
        public static final ContentType COMMENT = null;
        public static final a Companion = null;
        public static final ContentType DELETION = null;
        public static final ContentType DOCTAG = null;
        public static final ContentType EMPHASIS = null;
        public static final ContentType FORMULA = null;
        public static final ContentType FUNCTION = null;
        public static final ContentType KEYWORD = null;
        public static final ContentType LINK = null;
        public static final ContentType LITERAL = null;
        public static final ContentType META = null;
        public static final ContentType META_KEYWORD = null;
        public static final ContentType META_PROMPT = null;
        public static final ContentType META_STRING = null;
        public static final ContentType NAME = null;
        public static final ContentType NUMBER = null;
        public static final ContentType OPERATOR = null;
        public static final ContentType PARAMS = null;
        public static final ContentType PROPERTY = null;
        public static final ContentType PUNCTUATION = null;
        public static final ContentType QUOTE = null;
        public static final ContentType REGEXP = null;
        public static final ContentType SECTION = null;
        public static final ContentType SELECTOR_ATTR = null;
        public static final ContentType SELECTOR_CLASS = null;
        public static final ContentType SELECTOR_ID = null;
        public static final ContentType SELECTOR_PSEUDO = null;
        public static final ContentType SELECTOR_TAG = null;
        public static final ContentType STRING = null;
        public static final ContentType SUBST = null;
        public static final ContentType SYMBOL = null;
        public static final ContentType TAG = null;
        public static final ContentType TEMPLATE_TAG = null;
        public static final ContentType TEMPLATE_VARIABLE = null;
        public static final ContentType TEXT = null;
        public static final ContentType TITLE = null;
        public static final ContentType TITLE_CLASS = null;
        public static final ContentType TITLE_CLASS_INHERITED = null;
        public static final ContentType TITLE_FUNCTION = null;
        public static final ContentType TITLE_FUNCTION_INVOKE = null;
        public static final ContentType TYPE = null;
        public static final ContentType VARIABLE = null;
        public static final ContentType VARIABLE_CONSTANT = null;
        public static final ContentType VARIABLE_LANGUAGE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ContentType[] f445659a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f445660b = null;
        private final int number;

        public static final class a {
            public a() {
            }

            @JvmStatic
            public static ContentType a(int r100) {
                ContentType[] r101 = ContentType.values();
                if (r100 >= 0) goto L5;
            L7:
                boolean r102 = false;
            L8:
                if (r102 == false) goto L11;
                return r101[r100];
            L11:
                return ContentType.TEXT;
            L5:
                if (r100 >= r101.length) goto L7;
                r102 = true;
                goto L8
            }
        }

        @JvmStatic
        public static final ContentType fromValue(int r100) {
            Companion.getClass();
            return a.a(r100);
        }

        public static EnumEntries<ContentType> getEntries() {
            return f445660b;
        }

        static {
            ContentType r100 = new ContentType(CardAdapter.TEXT, 0, 0);
            TEXT = r100;
            ContentType r101 = new ContentType("KEYWORD", 1, 1);
            KEYWORD = r101;
            ContentType r102 = new ContentType("BUILT_IN", 2, 2);
            BUILT_IN = r102;
            ContentType r103 = new ContentType("TYPE", 3, 3);
            TYPE = r103;
            ContentType r104 = new ContentType("LITERAL", 4, 4);
            LITERAL = r104;
            ContentType r105 = new ContentType("NUMBER", 5, 5);
            NUMBER = r105;
            ContentType r106 = new ContentType("OPERATOR", 6, 6);
            OPERATOR = r106;
            ContentType r107 = new ContentType("PUNCTUATION", 7, 7);
            PUNCTUATION = r107;
            ContentType r108 = new ContentType("PROPERTY", 8, 8);
            PROPERTY = r108;
            ContentType r109 = new ContentType("REGEXP", 9, 9);
            REGEXP = r109;
            ContentType r110 = new ContentType("STRING", 10, 10);
            STRING = r110;
            ContentType r111 = new ContentType("CHAR_ESCAPE", 11, 11);
            CHAR_ESCAPE = r111;
            ContentType r112 = new ContentType("SUBST", 12, 12);
            SUBST = r112;
            ContentType r113 = new ContentType("SYMBOL", 13, 13);
            SYMBOL = r113;
            ContentType r114 = new ContentType("CLASS", 14, 14);
            CLASS = r114;
            ContentType r115 = new ContentType("FUNCTION", 15, 15);
            FUNCTION = r115;
            ContentType r116 = new ContentType("VARIABLE", 16, 16);
            VARIABLE = r116;
            ContentType r117 = new ContentType("VARIABLE_LANGUAGE", 17, 17);
            VARIABLE_LANGUAGE = r117;
            ContentType r118 = new ContentType("VARIABLE_CONSTANT", 18, 18);
            VARIABLE_CONSTANT = r118;
            ContentType r119 = new ContentType("TITLE", 19, 19);
            TITLE = r119;
            ContentType r120 = new ContentType("TITLE_CLASS", 20, 20);
            TITLE_CLASS = r120;
            ContentType r121 = new ContentType("TITLE_CLASS_INHERITED", 21, 21);
            TITLE_CLASS_INHERITED = r121;
            ContentType r122 = new ContentType("TITLE_FUNCTION", 22, 22);
            TITLE_FUNCTION = r122;
            ContentType r123 = new ContentType("TITLE_FUNCTION_INVOKE", 23, 23);
            TITLE_FUNCTION_INVOKE = r123;
            ContentType r124 = new ContentType("PARAMS", 24, 24);
            PARAMS = r124;
            ContentType r125 = new ContentType("COMMENT", 25, 25);
            COMMENT = r125;
            ContentType r126 = new ContentType("DOCTAG", 26, 26);
            DOCTAG = r126;
            ContentType r127 = new ContentType("META", 27, 27);
            META = r127;
            ContentType r128 = new ContentType("META_PROMPT", 28, 28);
            META_PROMPT = r128;
            ContentType r129 = new ContentType("META_KEYWORD", 29, 29);
            META_KEYWORD = r129;
            ContentType r130 = new ContentType("META_STRING", 30, 30);
            META_STRING = r130;
            ContentType r131 = new ContentType("SECTION", 31, 31);
            SECTION = r131;
            ContentType r132 = new ContentType("TAG", 32, 32);
            TAG = r132;
            ContentType r133 = new ContentType("NAME", 33, 33);
            NAME = r133;
            ContentType r134 = new ContentType("ATTR", 34, 34);
            ATTR = r134;
            ContentType r135 = new ContentType("ATTRIBUTE", 35, 35);
            ATTRIBUTE = r135;
            ContentType r136 = new ContentType("BULLET", 36, 36);
            BULLET = r136;
            ContentType r137 = new ContentType("CODE", 37, 37);
            CODE = r137;
            ContentType r138 = new ContentType("EMPHASIS", 38, 38);
            EMPHASIS = r138;
            ContentType r139 = new ContentType("FORMULA", 39, 39);
            FORMULA = r139;
            ContentType r140 = new ContentType("LINK", 40, 40);
            LINK = r140;
            ContentType r141 = new ContentType("QUOTE", 41, 41);
            QUOTE = r141;
            ContentType r142 = new ContentType("SELECTOR_TAG", 42, 42);
            SELECTOR_TAG = r142;
            ContentType r143 = new ContentType("SELECTOR_ID", 43, 43);
            SELECTOR_ID = r143;
            ContentType r144 = new ContentType("SELECTOR_CLASS", 44, 44);
            SELECTOR_CLASS = r144;
            ContentType r145 = new ContentType("SELECTOR_ATTR", 45, 45);
            SELECTOR_ATTR = r145;
            ContentType r146 = new ContentType("SELECTOR_PSEUDO", 46, 46);
            SELECTOR_PSEUDO = r146;
            ContentType r147 = new ContentType("TEMPLATE_TAG", 47, 47);
            TEMPLATE_TAG = r147;
            ContentType r148 = new ContentType("TEMPLATE_VARIABLE", 48, 48);
            TEMPLATE_VARIABLE = r148;
            ContentType r149 = new ContentType("ADDITION", 49, 49);
            ADDITION = r149;
            ContentType r150 = new ContentType("DELETION", 50, 50);
            DELETION = r150;
            ContentType[] r151 = {r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150};
            f445659a = r151;
            f445660b = EnumEntriesKt.enumEntries(r151);
            Companion = new a();
        }

        public static ContentType[] values() {
            return (ContentType[]) f445659a.clone();
        }

        public final int getNumber() {
            return this.number;
        }

        public static ContentType valueOf(String r100) {
            return (ContentType) r27.a.a(ContentType.class, r100);
        }

        public ContentType(String r100, int r101, int r102) {
            super(r100, r101);
            this.number = r102;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public LineContent() {
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.contents});
    }

    public final List<Content> getContents() {
        return this.contents;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LineContent) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.contents, ((LineContent) r100).contents);
    }

    public final void setContents(List<Content> r100) {
        this.contents = r100;
    }
}
