package com.larus.office.base.permission;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.network.HttpConst;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
public final class OfficeRouterHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f360626a = 0;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/office/base/permission/OfficeRouterHelper$OfficeDocType;", "", "type", "", "docTypeValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getType", "()Ljava/lang/String;", "getDocTypeValue", "()I", PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, "SHEETS", "SLIDES", "BITABLE", "FILE", "UNKNOWN", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum OfficeDocType extends Enum<OfficeDocType> {
        public static final OfficeDocType BITABLE = null;
        public static final OfficeDocType DOCX = null;
        public static final OfficeDocType FILE = null;
        public static final OfficeDocType SHEETS = null;
        public static final OfficeDocType SLIDES = null;
        public static final OfficeDocType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ OfficeDocType[] f360627a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f360628b = null;
        private final int docTypeValue;
        private final String type;

        public static EnumEntries<OfficeDocType> getEntries() {
            return f360628b;
        }

        static {
            OfficeDocType r100 = new OfficeDocType(PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, 0, DocumentType.DOCX_NAME, 22);
            DOCX = r100;
            OfficeDocType r101 = new OfficeDocType("SHEETS", 1, "sheets", 3);
            SHEETS = r101;
            OfficeDocType r102 = new OfficeDocType("SLIDES", 2, "slides", 30);
            SLIDES = r102;
            OfficeDocType r103 = new OfficeDocType("BITABLE", 3, "base", 8);
            BITABLE = r103;
            OfficeDocType r104 = new OfficeDocType("FILE", 4, "file", 12);
            FILE = r104;
            OfficeDocType r105 = new OfficeDocType("UNKNOWN", 5, "unknown", -1);
            UNKNOWN = r105;
            OfficeDocType[] r110 = {r100, r101, r102, r103, r104, r105};
            f360627a = r110;
            f360628b = EnumEntriesKt.enumEntries(r110);
        }

        public static OfficeDocType[] values() {
            return (OfficeDocType[]) f360627a.clone();
        }

        public final int getDocTypeValue() {
            return this.docTypeValue;
        }

        public final String getType() {
            return this.type;
        }

        public static OfficeDocType valueOf(String r100) {
            return (OfficeDocType) r27.a.a(OfficeDocType.class, r100);
        }

        public OfficeDocType(String r100, int r101, String r102, int r103) {
            super(r100, r101);
            this.type = r102;
            this.docTypeValue = r103;
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f360629a = null;

        static {
            int[] r100 = new int[OfficeDocType.values().length];
            r100[OfficeDocType.DOCX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[OfficeDocType.SHEETS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[OfficeDocType.SLIDES.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[OfficeDocType.BITABLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[OfficeDocType.FILE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f360629a = r100;
        }
    }

    static {
        HttpConst.f359979a.getClass();
    }
}
