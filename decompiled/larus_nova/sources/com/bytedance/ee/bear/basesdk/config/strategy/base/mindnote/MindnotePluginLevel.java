package com.bytedance.ee.bear.basesdk.config.strategy.base.mindnote;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/basesdk/config/strategy/base/mindnote/MindnotePluginLevel;", "", "uiLevel", "", "<init>", "(Ljava/lang/String;II)V", "getUiLevel", "()I", "Toolbar", "At", "ImgViewer", "DiyIcon", "CustomHeader", "Comment", "Snapshot", "basesdk_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum MindnotePluginLevel extends Enum<MindnotePluginLevel> {
    public static final MindnotePluginLevel At = null;
    public static final MindnotePluginLevel Comment = null;
    public static final MindnotePluginLevel CustomHeader = null;
    public static final MindnotePluginLevel DiyIcon = null;
    public static final MindnotePluginLevel ImgViewer = null;
    public static final MindnotePluginLevel Snapshot = null;
    public static final MindnotePluginLevel Toolbar = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MindnotePluginLevel[] f206608a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f206609b = null;
    private final int uiLevel;

    public static EnumEntries<MindnotePluginLevel> getEntries() {
        return f206609b;
    }

    static {
        MindnotePluginLevel r100 = new MindnotePluginLevel("Toolbar", 0, 10000);
        Toolbar = r100;
        MindnotePluginLevel r101 = new MindnotePluginLevel("At", 1, 10010);
        At = r101;
        MindnotePluginLevel r102 = new MindnotePluginLevel("ImgViewer", 2, 10020);
        ImgViewer = r102;
        MindnotePluginLevel r103 = new MindnotePluginLevel("DiyIcon", 3, 10030);
        DiyIcon = r103;
        MindnotePluginLevel r104 = new MindnotePluginLevel("CustomHeader", 4, 10040);
        CustomHeader = r104;
        MindnotePluginLevel r105 = new MindnotePluginLevel("Comment", 5, 10050);
        Comment = r105;
        MindnotePluginLevel r110 = new MindnotePluginLevel("Snapshot", 6, 10060);
        Snapshot = r110;
        MindnotePluginLevel[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f206608a = r111;
        f206609b = EnumEntriesKt.enumEntries(r111);
    }

    public static MindnotePluginLevel[] values() {
        return (MindnotePluginLevel[]) f206608a.clone();
    }

    public final int getUiLevel() {
        return this.uiLevel;
    }

    public static MindnotePluginLevel valueOf(String r100) {
        return (MindnotePluginLevel) r27.a.a(MindnotePluginLevel.class, r100);
    }

    public MindnotePluginLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.uiLevel = r102;
    }
}
