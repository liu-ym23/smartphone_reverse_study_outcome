package com.larus.business.markdown.api.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/business/markdown/api/model/MarkdownNodeModifyType;", "", "TRAILING_WHITESPACE_REMOVED", "TRAILING_PLACEHOLDER_REMOVED", "TRAILING_EMOJI_REMOVED", "LIST_TOKEN_REMOVED", "ASTERISK_TOKEN_REMOVED", "UNDERSCORE_TOKEN_REMOVED", "LATEX_PROCESSING_APPLIED", "markdown-api_release"}, k = 1, mv = {1, 7, 1})
public final enum MarkdownNodeModifyType extends Enum<MarkdownNodeModifyType> {
    public static final MarkdownNodeModifyType ASTERISK_TOKEN_REMOVED = null;
    public static final MarkdownNodeModifyType LATEX_PROCESSING_APPLIED = null;
    public static final MarkdownNodeModifyType LIST_TOKEN_REMOVED = null;
    public static final MarkdownNodeModifyType TRAILING_EMOJI_REMOVED = null;
    public static final MarkdownNodeModifyType TRAILING_PLACEHOLDER_REMOVED = null;
    public static final MarkdownNodeModifyType TRAILING_WHITESPACE_REMOVED = null;
    public static final MarkdownNodeModifyType UNDERSCORE_TOKEN_REMOVED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MarkdownNodeModifyType[] f320479a = null;

    public static MarkdownNodeModifyType valueOf(String r100) {
        return (MarkdownNodeModifyType) a.a(MarkdownNodeModifyType.class, r100);
    }

    public static MarkdownNodeModifyType[] values() {
        return (MarkdownNodeModifyType[]) f320479a.clone();
    }

    static {
        MarkdownNodeModifyType r100 = new MarkdownNodeModifyType("TRAILING_WHITESPACE_REMOVED", 0);
        TRAILING_WHITESPACE_REMOVED = r100;
        MarkdownNodeModifyType r101 = new MarkdownNodeModifyType("TRAILING_PLACEHOLDER_REMOVED", 1);
        TRAILING_PLACEHOLDER_REMOVED = r101;
        MarkdownNodeModifyType r102 = new MarkdownNodeModifyType("TRAILING_EMOJI_REMOVED", 2);
        TRAILING_EMOJI_REMOVED = r102;
        MarkdownNodeModifyType r103 = new MarkdownNodeModifyType("LIST_TOKEN_REMOVED", 3);
        LIST_TOKEN_REMOVED = r103;
        MarkdownNodeModifyType r104 = new MarkdownNodeModifyType("ASTERISK_TOKEN_REMOVED", 4);
        ASTERISK_TOKEN_REMOVED = r104;
        MarkdownNodeModifyType r105 = new MarkdownNodeModifyType("UNDERSCORE_TOKEN_REMOVED", 5);
        UNDERSCORE_TOKEN_REMOVED = r105;
        MarkdownNodeModifyType r110 = new MarkdownNodeModifyType("LATEX_PROCESSING_APPLIED", 6);
        LATEX_PROCESSING_APPLIED = r110;
        f320479a = new MarkdownNodeModifyType[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public MarkdownNodeModifyType(String r100, int r101) {
        super(r100, r101);
    }
}
