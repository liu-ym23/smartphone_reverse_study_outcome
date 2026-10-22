package com.bytedance.ee.bear.document;

/* JADX INFO: loaded from: classes16.dex */
public final enum DocumentWebClientPriority extends Enum<DocumentWebClientPriority> {
    public static final DocumentWebClientPriority Normal = null;
    public static final DocumentWebClientPriority Router = null;
    public static final DocumentWebClientPriority Template = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DocumentWebClientPriority[] f218599a = null;

    static {
        DocumentWebClientPriority r100 = new DocumentWebClientPriority("Template", 0);
        Template = r100;
        DocumentWebClientPriority r101 = new DocumentWebClientPriority("Normal", 1);
        Normal = r101;
        DocumentWebClientPriority r102 = new DocumentWebClientPriority("Router", 2);
        Router = r102;
        f218599a = new DocumentWebClientPriority[]{r100, r101, r102};
    }

    public static DocumentWebClientPriority[] values() {
        return (DocumentWebClientPriority[]) f218599a.clone();
    }

    public static DocumentWebClientPriority valueOf(String r100) {
        return (DocumentWebClientPriority) r27.a.a(DocumentWebClientPriority.class, r100);
    }

    public DocumentWebClientPriority(String r100, int r101) {
        super(r100, r101);
    }
}
