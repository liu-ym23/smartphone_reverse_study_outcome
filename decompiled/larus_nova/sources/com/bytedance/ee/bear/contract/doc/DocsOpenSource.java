package com.bytedance.ee.bear.contract.doc;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.util.io.NonProguard;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public final enum DocsOpenSource extends Enum<DocsOpenSource> implements NonProguard {
    private static final /* synthetic */ DocsOpenSource[] $VALUES = null;
    public static final DocsOpenSource base_instruction_docx = null;
    public static final DocsOpenSource calendar = null;
    public static final DocsOpenSource chat_tab = null;
    public static final DocsOpenSource comment = null;
    public static final DocsOpenSource db_preload = null;
    public static final DocsOpenSource doc_component = null;
    public static final DocsOpenSource docs_feed = null;
    public static final DocsOpenSource docs_feed_push = null;
    public static final DocsOpenSource from_parent_docs = null;
    public static final DocsOpenSource template_preview = null;
    public static final DocsOpenSource unknown = null;

    /* JADX INFO: renamed from: vc, reason: collision with root package name */
    public static final DocsOpenSource f216966vc = null;

    static {
        DocsOpenSource r100 = new DocsOpenSource(ThumbGlideUrl.SOURCE_VC, 0);
        f216966vc = r100;
        DocsOpenSource r101 = new DocsOpenSource("calendar", 1);
        calendar = r101;
        DocsOpenSource r102 = new DocsOpenSource("docs_feed", 2);
        docs_feed = r102;
        DocsOpenSource r103 = new DocsOpenSource("template_preview", 3);
        template_preview = r103;
        DocsOpenSource r104 = new DocsOpenSource("chat_tab", 4);
        chat_tab = r104;
        DocsOpenSource r105 = new DocsOpenSource("docs_feed_push", 5);
        docs_feed_push = r105;
        DocsOpenSource r110 = new DocsOpenSource("db_preload", 6);
        db_preload = r110;
        DocsOpenSource r111 = new DocsOpenSource("from_parent_docs", 7);
        from_parent_docs = r111;
        DocsOpenSource r112 = new DocsOpenSource("comment", 8);
        comment = r112;
        DocsOpenSource r113 = new DocsOpenSource("base_instruction_docx", 9);
        base_instruction_docx = r113;
        DocsOpenSource r114 = new DocsOpenSource("unknown", 10);
        unknown = r114;
        DocsOpenSource r115 = new DocsOpenSource("doc_component", 11);
        doc_component = r115;
        $VALUES = new DocsOpenSource[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
    }

    public static DocsOpenSource[] values() {
        return (DocsOpenSource[]) $VALUES.clone();
    }

    public static DocsOpenSource valueOf(String r100) {
        return (DocsOpenSource) a.a(DocsOpenSource.class, r100);
    }

    private DocsOpenSource(String r100, int r101) {
        super(r100, r101);
    }
}
