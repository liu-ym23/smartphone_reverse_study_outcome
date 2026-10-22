package com.larus.bmhome.chat.markdown.reference;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/markdown/reference/ToolType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SearchPlugin", "ScholarSearch", "LinkReader", "SearchPoi", "RoutePlan", "ImageAnalysis", "SearchImage", "TextSearchImage", "CodeRunning", "Default", "None", "BrowserControl", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ToolType extends Enum<ToolType> {
    public static final ToolType BrowserControl = null;
    public static final ToolType CodeRunning = null;
    public static final a Companion = null;
    public static final ToolType Default = null;
    public static final ToolType ImageAnalysis = null;
    public static final ToolType LinkReader = null;
    public static final ToolType None = null;
    public static final ToolType RoutePlan = null;
    public static final ToolType ScholarSearch = null;
    public static final ToolType SearchImage = null;
    public static final ToolType SearchPlugin = null;
    public static final ToolType SearchPoi = null;
    public static final ToolType TextSearchImage = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ToolType[] f307154a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f307155b = null;
    private final String value;

    public static final class a {
        public a() {
        }

        public static ToolType a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            ToolType[] r101 = ToolType.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            ToolType r104 = r101[r103];
            if (Intrinsics.areEqual(r104.getValue(), r100) == true) goto L9;
            r103 = r103 + 1;
        L9:
            if (r104 == null) goto L11;
            return r104;
        L11:
            return ToolType.SearchPlugin;
        L8:
            r104 = null;
            goto L9
        }
    }

    public static EnumEntries<ToolType> getEntries() {
        return f307155b;
    }

    static {
        ToolType r100 = new ToolType("SearchPlugin", 0, "SearchPlugin");
        SearchPlugin = r100;
        ToolType r101 = new ToolType("ScholarSearch", 1, "ScholarSearch");
        ScholarSearch = r101;
        ToolType r102 = new ToolType("LinkReader", 2, "LinkReader");
        LinkReader = r102;
        ToolType r103 = new ToolType("SearchPoi", 3, "PoiSearch");
        SearchPoi = r103;
        ToolType r104 = new ToolType("RoutePlan", 4, "RoutePlan");
        RoutePlan = r104;
        ToolType r105 = new ToolType("ImageAnalysis", 5, "ZoomIn");
        ImageAnalysis = r105;
        ToolType r110 = new ToolType("SearchImage", 6, "SearchImage");
        SearchImage = r110;
        ToolType r111 = new ToolType("TextSearchImage", 7, "TextSearchImage");
        TextSearchImage = r111;
        ToolType r112 = new ToolType("CodeRunning", 8, "CodeRunning");
        CodeRunning = r112;
        ToolType r113 = new ToolType("Default", 9, "Default");
        Default = r113;
        ToolType r114 = new ToolType("None", 10, "None");
        None = r114;
        ToolType r115 = new ToolType("BrowserControl", 11, "BrowserControl");
        BrowserControl = r115;
        ToolType[] r106 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
        f307154a = r106;
        f307155b = EnumEntriesKt.enumEntries(r106);
        Companion = new a();
    }

    public static ToolType[] values() {
        return (ToolType[]) f307154a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ToolType valueOf(String r100) {
        return (ToolType) r27.a.a(ToolType.class, r100);
    }

    public ToolType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
