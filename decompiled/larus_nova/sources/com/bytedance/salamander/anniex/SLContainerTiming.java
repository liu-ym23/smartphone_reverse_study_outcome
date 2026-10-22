package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/salamander/anniex/SLContainerTiming;", "", "", "value", "I", "getValue", "()I", "OpenTime", "ContainerInitStart", "ContainerInitEnd", "PrepareTemplateStart", "PrepareTemplateEnd", "PrepareGlobalPropsStart", "PrepareGlobalPropsEnd", "PrepareEngineStart", "PrepareEngineEnd", "EngineViewLoadStart", "EngineViewLoadEnd", "RequestSSRUrlStart", "RequestSSRUrlEnd", "RequestHydrateUrlStart", "RequestHydrateUrlEnd", "RenderSSRStart", "RenderSSREnd", "SSRHydrateStart", "SSRHydrateEnd", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum SLContainerTiming extends Enum<SLContainerTiming> {
    public static final SLContainerTiming ContainerInitEnd = null;
    public static final SLContainerTiming ContainerInitStart = null;
    public static final SLContainerTiming EngineViewLoadEnd = null;
    public static final SLContainerTiming EngineViewLoadStart = null;
    public static final SLContainerTiming OpenTime = null;
    public static final SLContainerTiming PrepareEngineEnd = null;
    public static final SLContainerTiming PrepareEngineStart = null;
    public static final SLContainerTiming PrepareGlobalPropsEnd = null;
    public static final SLContainerTiming PrepareGlobalPropsStart = null;
    public static final SLContainerTiming PrepareTemplateEnd = null;
    public static final SLContainerTiming PrepareTemplateStart = null;
    public static final SLContainerTiming RenderSSREnd = null;
    public static final SLContainerTiming RenderSSRStart = null;
    public static final SLContainerTiming RequestHydrateUrlEnd = null;
    public static final SLContainerTiming RequestHydrateUrlStart = null;
    public static final SLContainerTiming RequestSSRUrlEnd = null;
    public static final SLContainerTiming RequestSSRUrlStart = null;
    public static final SLContainerTiming SSRHydrateEnd = null;
    public static final SLContainerTiming SSRHydrateStart = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SLContainerTiming[] f267907a = null;
    private final int value;

    public static SLContainerTiming valueOf(String r100) {
        return (SLContainerTiming) r27.a.a(SLContainerTiming.class, r100);
    }

    public static SLContainerTiming[] values() {
        return (SLContainerTiming[]) f267907a.clone();
    }

    static {
        SLContainerTiming r100 = new SLContainerTiming("OpenTime", 0, 0);
        OpenTime = r100;
        SLContainerTiming r101 = new SLContainerTiming("ContainerInitStart", 1, 1);
        ContainerInitStart = r101;
        SLContainerTiming r102 = new SLContainerTiming("ContainerInitEnd", 2, 2);
        ContainerInitEnd = r102;
        SLContainerTiming r103 = new SLContainerTiming("PrepareTemplateStart", 3, 3);
        PrepareTemplateStart = r103;
        SLContainerTiming r104 = new SLContainerTiming("PrepareTemplateEnd", 4, 4);
        PrepareTemplateEnd = r104;
        SLContainerTiming r105 = new SLContainerTiming("PrepareGlobalPropsStart", 5, 5);
        PrepareGlobalPropsStart = r105;
        SLContainerTiming r110 = new SLContainerTiming("PrepareGlobalPropsEnd", 6, 6);
        PrepareGlobalPropsEnd = r110;
        SLContainerTiming r111 = new SLContainerTiming("PrepareEngineStart", 7, 7);
        PrepareEngineStart = r111;
        SLContainerTiming r112 = new SLContainerTiming("PrepareEngineEnd", 8, 8);
        PrepareEngineEnd = r112;
        SLContainerTiming r113 = new SLContainerTiming("EngineViewLoadStart", 9, 9);
        EngineViewLoadStart = r113;
        SLContainerTiming r114 = new SLContainerTiming("EngineViewLoadEnd", 10, 10);
        EngineViewLoadEnd = r114;
        SLContainerTiming r115 = new SLContainerTiming("RequestSSRUrlStart", 11, 11);
        RequestSSRUrlStart = r115;
        SLContainerTiming r106 = new SLContainerTiming("RequestSSRUrlEnd", 12, 12);
        RequestSSRUrlEnd = r106;
        SLContainerTiming r107 = new SLContainerTiming("RequestHydrateUrlStart", 13, 13);
        RequestHydrateUrlStart = r107;
        SLContainerTiming r108 = new SLContainerTiming("RequestHydrateUrlEnd", 14, 14);
        RequestHydrateUrlEnd = r108;
        SLContainerTiming r109 = new SLContainerTiming("RenderSSRStart", 15, 15);
        RenderSSRStart = r109;
        SLContainerTiming r116 = new SLContainerTiming("RenderSSREnd", 16, 16);
        RenderSSREnd = r116;
        SLContainerTiming r117 = new SLContainerTiming("SSRHydrateStart", 17, 17);
        SSRHydrateStart = r117;
        SLContainerTiming r118 = new SLContainerTiming("SSRHydrateEnd", 18, 18);
        SSRHydrateEnd = r118;
        f267907a = new SLContainerTiming[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118};
    }

    public final int getValue() {
        return this.value;
    }

    public SLContainerTiming(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
