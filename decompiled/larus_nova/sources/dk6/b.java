package dk6;

import com.bytedance.live.richcontent.engine.SpanRendClient;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f469021a = null;

    static {
        int[] r100 = new int[SpanRendClient.RendType.values().length];
        f469021a = r100;
        r100[SpanRendClient.RendType.ALL.ordinal()] = 1;
        r100[SpanRendClient.RendType.TEXT.ordinal()] = 2;
        r100[SpanRendClient.RendType.TEXT_AND_SYNC_RESOURCE.ordinal()] = 3;
        r100[SpanRendClient.RendType.RESOURCE.ordinal()] = 4;
    }
}
