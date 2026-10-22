package com.bytedance.ee.bear.document.render.node;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/document/render/node/RenderStage;", "", "<init>", "(Ljava/lang/String;I)V", "RENDERING", "RENDER_CACHE_START", "RENDER_CACHE_END", "PULL_DATA_START", "PULL_DATA_END", "RENDER_DOC_START", "RENDER_DOC_END", "docs-document-sdk-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RenderStage extends Enum<RenderStage> {
    public static final RenderStage PULL_DATA_END = null;
    public static final RenderStage PULL_DATA_START = null;
    public static final RenderStage RENDERING = null;
    public static final RenderStage RENDER_CACHE_END = null;
    public static final RenderStage RENDER_CACHE_START = null;
    public static final RenderStage RENDER_DOC_END = null;
    public static final RenderStage RENDER_DOC_START = null;
    public static final /* synthetic */ RenderStage[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<RenderStage> getEntries() {
        return b;
    }

    static {
        RenderStage r0 = new RenderStage("RENDERING", 0);
        RENDERING = r0;
        RenderStage r1 = new RenderStage("RENDER_CACHE_START", 1);
        RENDER_CACHE_START = r1;
        RenderStage r3 = new RenderStage("RENDER_CACHE_END", 2);
        RENDER_CACHE_END = r3;
        RenderStage r5 = new RenderStage("PULL_DATA_START", 3);
        PULL_DATA_START = r5;
        RenderStage r7 = new RenderStage("PULL_DATA_END", 4);
        PULL_DATA_END = r7;
        RenderStage r9 = new RenderStage("RENDER_DOC_START", 5);
        RENDER_DOC_START = r9;
        RenderStage r11 = new RenderStage("RENDER_DOC_END", 6);
        RENDER_DOC_END = r11;
        RenderStage[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static RenderStage[] values() {
        return (RenderStage[]) a.clone();
    }

    public static RenderStage valueOf(String r1) {
        return (RenderStage) r27.a.a(RenderStage.class, r1);
    }

    public RenderStage(String r1, int r2) {
        super(r1, r2);
    }
}
