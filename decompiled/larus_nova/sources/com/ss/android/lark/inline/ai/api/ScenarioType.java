package com.ss.android.lark.inline.ai.api;

import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/ScenarioType;", "", "int", "", "<init>", "(Ljava/lang/String;II)V", "getInt", "()I", "UNKNOWN", "IM", ServiceType.DOC, "Sheet", "Base", "VC", "Calendar", "Email", "Meego", "OpenWebContainer", "Search", "Slides", "GroupChat", "P2PChat", "Board", "PDFView", "WikiSpace", "VoiceInput", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ScenarioType extends Enum<ScenarioType> {
    public static final ScenarioType Base = null;
    public static final ScenarioType Board = null;
    public static final ScenarioType Calendar = null;
    public static final ScenarioType Doc = null;
    public static final ScenarioType Email = null;
    public static final ScenarioType GroupChat = null;
    public static final ScenarioType IM = null;
    public static final ScenarioType Meego = null;
    public static final ScenarioType OpenWebContainer = null;
    public static final ScenarioType P2PChat = null;
    public static final ScenarioType PDFView = null;
    public static final ScenarioType Search = null;
    public static final ScenarioType Sheet = null;
    public static final ScenarioType Slides = null;
    public static final ScenarioType UNKNOWN = null;
    public static final ScenarioType VC = null;
    public static final ScenarioType VoiceInput = null;
    public static final ScenarioType WikiSpace = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScenarioType[] f426811a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f426812b = null;

    /* JADX INFO: renamed from: int, reason: not valid java name */
    private final int f118int;

    public static EnumEntries<ScenarioType> getEntries() {
        return f426812b;
    }

    static {
        ScenarioType r100 = new ScenarioType("UNKNOWN", 0, -1);
        UNKNOWN = r100;
        ScenarioType r101 = new ScenarioType("IM", 1, 0);
        IM = r101;
        ScenarioType r102 = new ScenarioType(ServiceType.DOC, 2, 1);
        Doc = r102;
        ScenarioType r103 = new ScenarioType("Sheet", 3, 2);
        Sheet = r103;
        ScenarioType r104 = new ScenarioType("Base", 4, 3);
        Base = r104;
        ScenarioType r105 = new ScenarioType("VC", 5, 4);
        VC = r105;
        ScenarioType r110 = new ScenarioType("Calendar", 6, 5);
        Calendar = r110;
        ScenarioType r111 = new ScenarioType("Email", 7, 6);
        Email = r111;
        ScenarioType r112 = new ScenarioType("Meego", 8, 7);
        Meego = r112;
        ScenarioType r113 = new ScenarioType("OpenWebContainer", 9, 8);
        OpenWebContainer = r113;
        ScenarioType r114 = new ScenarioType("Search", 10, 9);
        Search = r114;
        ScenarioType r115 = new ScenarioType("Slides", 11, 10);
        Slides = r115;
        ScenarioType r106 = new ScenarioType("GroupChat", 12, 11);
        GroupChat = r106;
        ScenarioType r107 = new ScenarioType("P2PChat", 13, 12);
        P2PChat = r107;
        ScenarioType r108 = new ScenarioType("Board", 14, 13);
        Board = r108;
        ScenarioType r109 = new ScenarioType("PDFView", 15, 14);
        PDFView = r109;
        ScenarioType r116 = new ScenarioType("WikiSpace", 16, 15);
        WikiSpace = r116;
        ScenarioType r117 = new ScenarioType("VoiceInput", 17, 16);
        VoiceInput = r117;
        ScenarioType[] r118 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117};
        f426811a = r118;
        f426812b = EnumEntriesKt.enumEntries(r118);
    }

    public static ScenarioType[] values() {
        return (ScenarioType[]) f426811a.clone();
    }

    public final int getInt() {
        return this.f118int;
    }

    public static ScenarioType valueOf(String r100) {
        return (ScenarioType) a.a(ScenarioType.class, r100);
    }

    public ScenarioType(String r100, int r101, int r102) {
        super(r100, r101);
        this.f118int = r102;
    }
}
