package com.bytedance.ee.bear;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/SlidesPluginLevel;", "", "<init>", "(Ljava/lang/String;I)V", "DOUBAO_CHAT_INPUT", "BlockEditMenu", "Toolbar", "CustomHeader", "ImgViewer", "Comment", "docs-slides-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SlidesPluginLevel extends Enum<SlidesPluginLevel> {
    public static final SlidesPluginLevel BlockEditMenu = null;
    public static final SlidesPluginLevel Comment = null;
    public static final SlidesPluginLevel CustomHeader = null;
    public static final SlidesPluginLevel DOUBAO_CHAT_INPUT = null;
    public static final SlidesPluginLevel ImgViewer = null;
    public static final SlidesPluginLevel Toolbar = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SlidesPluginLevel[] f206184a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f206185b = null;

    public static EnumEntries<SlidesPluginLevel> getEntries() {
        return f206185b;
    }

    static {
        SlidesPluginLevel r100 = new SlidesPluginLevel("DOUBAO_CHAT_INPUT", 0);
        DOUBAO_CHAT_INPUT = r100;
        SlidesPluginLevel r101 = new SlidesPluginLevel("BlockEditMenu", 1);
        BlockEditMenu = r101;
        SlidesPluginLevel r102 = new SlidesPluginLevel("Toolbar", 2);
        Toolbar = r102;
        SlidesPluginLevel r103 = new SlidesPluginLevel("CustomHeader", 3);
        CustomHeader = r103;
        SlidesPluginLevel r104 = new SlidesPluginLevel("ImgViewer", 4);
        ImgViewer = r104;
        SlidesPluginLevel r105 = new SlidesPluginLevel("Comment", 5);
        Comment = r105;
        SlidesPluginLevel[] r110 = {r100, r101, r102, r103, r104, r105};
        f206184a = r110;
        f206185b = EnumEntriesKt.enumEntries(r110);
    }

    public static SlidesPluginLevel[] values() {
        return (SlidesPluginLevel[]) f206184a.clone();
    }

    public static SlidesPluginLevel valueOf(String r100) {
        return (SlidesPluginLevel) r27.a.a(SlidesPluginLevel.class, r100);
    }

    public SlidesPluginLevel(String r100, int r101) {
        super(r100, r101);
    }
}
