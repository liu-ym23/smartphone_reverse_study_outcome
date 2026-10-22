package com.bytedance.ee.bear.document.render.node;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/document/render/node/RenderStage;", "", "<init>", "(Ljava/lang/String;I)V", "RENDERING", "RENDER_CACHE_START", "RENDER_CACHE_END", ChameleonOpenTracker.EventType.PULL_DATA_START, ChameleonOpenTracker.EventType.PULL_DATA_END, "RENDER_DOC_START", "RENDER_DOC_END", "docs-document-sdk-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RenderStage extends Enum<RenderStage> {
    public static final RenderStage PULL_DATA_END = null;
    public static final RenderStage PULL_DATA_START = null;
    public static final RenderStage RENDERING = null;
    public static final RenderStage RENDER_CACHE_END = null;
    public static final RenderStage RENDER_CACHE_START = null;
    public static final RenderStage RENDER_DOC_END = null;
    public static final RenderStage RENDER_DOC_START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RenderStage[] f221332a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f221333b = null;

    public static EnumEntries<RenderStage> getEntries() {
        return f221333b;
    }

    static {
        RenderStage r100 = new RenderStage("RENDERING", 0);
        RENDERING = r100;
        RenderStage r101 = new RenderStage("RENDER_CACHE_START", 1);
        RENDER_CACHE_START = r101;
        RenderStage r102 = new RenderStage("RENDER_CACHE_END", 2);
        RENDER_CACHE_END = r102;
        RenderStage r103 = new RenderStage(ChameleonOpenTracker.EventType.PULL_DATA_START, 3);
        PULL_DATA_START = r103;
        RenderStage r104 = new RenderStage(ChameleonOpenTracker.EventType.PULL_DATA_END, 4);
        PULL_DATA_END = r104;
        RenderStage r105 = new RenderStage("RENDER_DOC_START", 5);
        RENDER_DOC_START = r105;
        RenderStage r110 = new RenderStage("RENDER_DOC_END", 6);
        RENDER_DOC_END = r110;
        RenderStage[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f221332a = r111;
        f221333b = EnumEntriesKt.enumEntries(r111);
    }

    public static RenderStage[] values() {
        return (RenderStage[]) f221332a.clone();
    }

    public static RenderStage valueOf(String r100) {
        return (RenderStage) r27.a.a(RenderStage.class, r100);
    }

    public RenderStage(String r100, int r101) {
        super(r100, r101);
    }
}
