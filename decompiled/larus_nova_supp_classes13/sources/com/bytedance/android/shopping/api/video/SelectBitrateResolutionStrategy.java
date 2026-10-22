package com.bytedance.android.shopping.api.video;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006j\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/api/video/SelectBitrateResolutionStrategy;", "", "", "resolution", "I", "getResolution", "()I", "setResolution", "(I)V", "viewHeight", "getViewHeight", "viewWidth", "getViewWidth", "Companion", "a", "DEFAULT", "VIEW_SIZE_ADAPTION", "LOWEST", "HIGHEST", "LESS_RESOLUTION", "MORE_RESOLUTION", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SelectBitrateResolutionStrategy extends Enum<SelectBitrateResolutionStrategy> {
    public static final a Companion = null;
    public static final SelectBitrateResolutionStrategy DEFAULT = null;
    public static final SelectBitrateResolutionStrategy HIGHEST = null;
    public static final SelectBitrateResolutionStrategy LESS_RESOLUTION = null;
    public static final SelectBitrateResolutionStrategy LOWEST = null;
    public static final SelectBitrateResolutionStrategy MORE_RESOLUTION = null;
    public static final SelectBitrateResolutionStrategy VIEW_SIZE_ADAPTION = null;
    public static final /* synthetic */ SelectBitrateResolutionStrategy[] a = null;
    public static final Map<Integer, SelectBitrateResolutionStrategy> b = null;
    private int resolution;
    private final int viewHeight;
    private final int viewWidth;

    public static final class a {
        public a() {
        }
    }

    static {
        SelectBitrateResolutionStrategy r9 = new SelectBitrateResolutionStrategy("DEFAULT", 0, 0, 0, 0, 7, null);
        DEFAULT = r9;
        int r1 = 0;
        SelectBitrateResolutionStrategy r2 = new SelectBitrateResolutionStrategy("VIEW_SIZE_ADAPTION", 1, 0, 0, 0, 7, null);
        VIEW_SIZE_ADAPTION = r2;
        SelectBitrateResolutionStrategy r3 = new SelectBitrateResolutionStrategy("LOWEST", 2, 0, 0, 0, 7, null);
        LOWEST = r3;
        SelectBitrateResolutionStrategy r4 = new SelectBitrateResolutionStrategy("HIGHEST", 3, 0, 0, 0, 7, null);
        HIGHEST = r4;
        SelectBitrateResolutionStrategy r5 = new SelectBitrateResolutionStrategy("LESS_RESOLUTION", 4, 0, 0, 0, 7, null);
        LESS_RESOLUTION = r5;
        SelectBitrateResolutionStrategy r6 = new SelectBitrateResolutionStrategy("MORE_RESOLUTION", 5, 0, 0, 0, 7, null);
        MORE_RESOLUTION = r6;
        a = new SelectBitrateResolutionStrategy[]{r9, r2, r3, r4, r5, r6};
        Companion = new a();
        SelectBitrateResolutionStrategy[] r0 = values();
        LinkedHashMap r7 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r0.length), 16));
        int r8 = r0.length;
    L3:
        if (r1 >= r8) goto L5;
        SelectBitrateResolutionStrategy r10 = r0[r1];
        r7.put(Integer.valueOf(r10.ordinal()), r10);
        r1 = r1 + 1;
        goto L3
    L5:
        b = r7;
    }

    public SelectBitrateResolutionStrategy() {
        throw null;
    }

    public static SelectBitrateResolutionStrategy valueOf(String r1) {
        return (SelectBitrateResolutionStrategy) r27.a.a(SelectBitrateResolutionStrategy.class, r1);
    }

    public static SelectBitrateResolutionStrategy[] values() {
        return (SelectBitrateResolutionStrategy[]) a.clone();
    }

    public static final /* synthetic */ Map access$getMap$cp() {
        return b;
    }

    public final int getResolution() {
        return this.resolution;
    }

    public final int getViewHeight() {
        return this.viewHeight;
    }

    public final int getViewWidth() {
        return this.viewWidth;
    }

    public final void setResolution(int r1) {
        this.resolution = r1;
    }

    public SelectBitrateResolutionStrategy(String r2, int r3, int r4, int r5, int r6, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 1) == 0) goto L6;
        r4 = 0;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r5 = 0;
    L9:
        if ((r7 & 4) == 0) goto L11;
        r6 = 0;
    L11:
        super(r2, r3);
        this.resolution = r4;
        this.viewHeight = r5;
        this.viewWidth = r6;
    }
}
