package com.ss.android.lark.chat.entity.preview;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00132\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0012\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chat/entity/preview/DocType;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "SHEET", "BITABLE", PreloadConfigModel.VERSION_CHECK_TYPE_MINDNOTE, "FILE", "SLIDE", "WIKI", PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, "getNumber", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DocType extends Enum<DocType> implements Serializable {
    public static final DocType BITABLE = null;
    public static final a Companion = null;
    public static final DocType DOC = null;
    public static final DocType DOCX = null;
    public static final DocType FILE = null;
    public static final DocType MINDNOTE = null;
    public static final DocType SHEET = null;
    public static final DocType SLIDE = null;
    public static final DocType UNKNOWN = null;
    public static final DocType WIKI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DocType[] f415347a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415348b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static DocType a(int r100) {
            switch(r100) {
                case 0: goto L13;
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                default: goto L14;
            };
        L14:
            return DocType.UNKNOWN;
        L15:
            return DocType.DOCX;
        L16:
            return DocType.WIKI;
        L17:
            return DocType.SLIDE;
        L18:
            return DocType.FILE;
        L19:
            return DocType.MINDNOTE;
        L20:
            return DocType.BITABLE;
        L21:
            return DocType.SHEET;
        L22:
            return DocType.DOC;
        L13:
            return DocType.UNKNOWN;
        }
    }

    public static EnumEntries<DocType> getEntries() {
        return f415348b;
    }

    static {
        DocType r100 = new DocType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        DocType r101 = new DocType(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 1, 1);
        DOC = r101;
        DocType r102 = new DocType("SHEET", 2, 2);
        SHEET = r102;
        DocType r103 = new DocType("BITABLE", 3, 3);
        BITABLE = r103;
        DocType r104 = new DocType(PreloadConfigModel.VERSION_CHECK_TYPE_MINDNOTE, 4, 4);
        MINDNOTE = r104;
        DocType r105 = new DocType("FILE", 5, 5);
        FILE = r105;
        DocType r110 = new DocType("SLIDE", 6, 6);
        SLIDE = r110;
        DocType r111 = new DocType("WIKI", 7, 7);
        WIKI = r111;
        DocType r112 = new DocType(PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, 8, 8);
        DOCX = r112;
        DocType[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f415347a = r113;
        f415348b = EnumEntriesKt.enumEntries(r113);
        Companion = new a();
    }

    public static DocType[] values() {
        return (DocType[]) f415347a.clone();
    }

    public final int getNumber() {
        return this.value;
    }

    public final int getValue() {
        return this.value;
    }

    public static DocType valueOf(String r100) {
        return (DocType) r27.a.a(DocType.class, r100);
    }

    public DocType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
