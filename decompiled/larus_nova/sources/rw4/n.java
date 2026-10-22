package rw4;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;

/* JADX INFO: loaded from: classes16.dex */
public final class n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n f539701c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n f539702d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final n f539703e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final n f539704f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final n f539705g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final n f539706h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final n f539707i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final n f539708j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f539709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f539710b;

    static {
        f539701c = new n(DocumentType.DOCX_NAME);
        f539702d = new n(ExportFileExtension.PDF);
        f539703e = new n(DocumentType.DOCX_NAME, 0);
        f539704f = new n(ExportFileExtension.PDF, 0);
        f539705g = new n("xlsx");
        f539706h = new n(ExportFileExtension.PPTX);
        f539707i = new n("txt");
        f539708j = new n("md");
    }

    public final String toString() {
        return this.f539709a.toLowerCase();
    }

    public n(String r100) {
        this.f539709a = r100;
    }

    public n(String r100, int r101) {
        this.f539709a = r100;
        this.f539710b = true;
    }
}
