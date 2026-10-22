package com.ss.android.lark.inline.ai.api.citation;

import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/citation/CitationReferenceType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "Unknown", ServiceType.DOC, ServiceType.IM, "Lingo", "Helpdesk", "Outlink", "Minutes", "Comment", "Base", "Sheet", "Excel", "Mail", "People", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CitationReferenceType extends Enum<CitationReferenceType> {
    public static final CitationReferenceType Base = null;
    public static final CitationReferenceType Comment = null;
    public static final CitationReferenceType Doc = null;
    public static final CitationReferenceType Excel = null;
    public static final CitationReferenceType Helpdesk = null;
    public static final CitationReferenceType Lingo = null;
    public static final CitationReferenceType Mail = null;
    public static final CitationReferenceType Message = null;
    public static final CitationReferenceType Minutes = null;
    public static final CitationReferenceType Outlink = null;
    public static final CitationReferenceType People = null;
    public static final CitationReferenceType Sheet = null;
    public static final CitationReferenceType Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CitationReferenceType[] f426813a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f426814b = null;
    private final int type;

    public static EnumEntries<CitationReferenceType> getEntries() {
        return f426814b;
    }

    static {
        CitationReferenceType r100 = new CitationReferenceType("Unknown", 0, 0);
        Unknown = r100;
        CitationReferenceType r101 = new CitationReferenceType(ServiceType.DOC, 1, 1);
        Doc = r101;
        CitationReferenceType r102 = new CitationReferenceType(ServiceType.IM, 2, 2);
        Message = r102;
        CitationReferenceType r103 = new CitationReferenceType("Lingo", 3, 3);
        Lingo = r103;
        CitationReferenceType r104 = new CitationReferenceType("Helpdesk", 4, 4);
        Helpdesk = r104;
        CitationReferenceType r105 = new CitationReferenceType("Outlink", 5, 5);
        Outlink = r105;
        CitationReferenceType r110 = new CitationReferenceType("Minutes", 6, 6);
        Minutes = r110;
        CitationReferenceType r111 = new CitationReferenceType("Comment", 7, 7);
        Comment = r111;
        CitationReferenceType r112 = new CitationReferenceType("Base", 8, 8);
        Base = r112;
        CitationReferenceType r113 = new CitationReferenceType("Sheet", 9, 9);
        Sheet = r113;
        CitationReferenceType r114 = new CitationReferenceType("Excel", 10, 10);
        Excel = r114;
        CitationReferenceType r115 = new CitationReferenceType("Mail", 11, 11);
        Mail = r115;
        CitationReferenceType r106 = new CitationReferenceType("People", 12, 13);
        People = r106;
        CitationReferenceType[] r107 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
        f426813a = r107;
        f426814b = EnumEntriesKt.enumEntries(r107);
    }

    public static CitationReferenceType[] values() {
        return (CitationReferenceType[]) f426813a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static CitationReferenceType valueOf(String r100) {
        return (CitationReferenceType) a.a(CitationReferenceType.class, r100);
    }

    public CitationReferenceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
