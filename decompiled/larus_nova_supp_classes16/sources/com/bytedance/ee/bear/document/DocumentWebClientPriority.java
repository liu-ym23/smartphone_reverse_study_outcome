package com.bytedance.ee.bear.document;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum DocumentWebClientPriority extends Enum<DocumentWebClientPriority> {
    public static final DocumentWebClientPriority Normal = null;
    public static final DocumentWebClientPriority Router = null;
    public static final DocumentWebClientPriority Template = null;
    public static final /* synthetic */ DocumentWebClientPriority[] a = null;

    static {
        DocumentWebClientPriority r0 = new DocumentWebClientPriority("Template", 0);
        Template = r0;
        DocumentWebClientPriority r1 = new DocumentWebClientPriority("Normal", 1);
        Normal = r1;
        DocumentWebClientPriority r3 = new DocumentWebClientPriority("Router", 2);
        Router = r3;
        a = new DocumentWebClientPriority[]{r0, r1, r3};
    }

    public static DocumentWebClientPriority[] values() {
        return (DocumentWebClientPriority[]) a.clone();
    }

    public static DocumentWebClientPriority valueOf(String r1) {
        return (DocumentWebClientPriority) r27.a.a(DocumentWebClientPriority.class, r1);
    }

    public DocumentWebClientPriority(String r1, int r2) {
        super(r1, r2);
    }
}
