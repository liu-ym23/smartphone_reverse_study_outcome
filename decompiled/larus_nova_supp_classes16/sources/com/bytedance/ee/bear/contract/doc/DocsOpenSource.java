package com.bytedance.ee.bear.contract.doc;

import com.bytedance.ee.bear.document.offline.file.upload.FileUploadModel;
import com.bytedance.ee.util.io.NonProguard;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
    public static final DocsOpenSource vc = null;

    static {
        DocsOpenSource r0 = new DocsOpenSource("vc", 0);
        vc = r0;
        DocsOpenSource r1 = new DocsOpenSource("calendar", 1);
        calendar = r1;
        DocsOpenSource r3 = new DocsOpenSource("docs_feed", 2);
        docs_feed = r3;
        DocsOpenSource r5 = new DocsOpenSource("template_preview", 3);
        template_preview = r5;
        DocsOpenSource r7 = new DocsOpenSource("chat_tab", 4);
        chat_tab = r7;
        DocsOpenSource r9 = new DocsOpenSource("docs_feed_push", 5);
        docs_feed_push = r9;
        DocsOpenSource r11 = new DocsOpenSource("db_preload", 6);
        db_preload = r11;
        DocsOpenSource r13 = new DocsOpenSource("from_parent_docs", 7);
        from_parent_docs = r13;
        DocsOpenSource r16 = new DocsOpenSource(FileUploadModel.FROM_COMMENT, 8);
        comment = r16;
        DocsOpenSource r14 = new DocsOpenSource("base_instruction_docx", 9);
        base_instruction_docx = r14;
        DocsOpenSource r12 = new DocsOpenSource("unknown", 10);
        unknown = r12;
        DocsOpenSource r10 = new DocsOpenSource("doc_component", 11);
        doc_component = r10;
        $VALUES = new DocsOpenSource[]{r0, r1, r3, r5, r7, r9, r11, r13, r16, r14, r12, r10};
    }

    public static DocsOpenSource[] values() {
        return (DocsOpenSource[]) $VALUES.clone();
    }

    public static DocsOpenSource valueOf(String r1) {
        return (DocsOpenSource) a.a(DocsOpenSource.class, r1);
    }

    private DocsOpenSource(String r1, int r2) {
        super(r1, r2);
    }
}
