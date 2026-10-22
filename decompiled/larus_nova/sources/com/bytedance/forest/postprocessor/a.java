package com.bytedance.forest.postprocessor;

import com.bytedance.forest.model.Response;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends ForestPostProcessor<Response> {
    public a() {
        boolean r100 = false;
        this(r100, 1, null);
    }

    public abstract void onBuiltinProcess(Response r100);

    @Override // com.bytedance.forest.postprocessor.ForestPostProcessor
    public void onPostProcess$forest_release(ProcessableData r100) {
    }

    public a(boolean r100) {
        super(r100);
    }

    @Override // com.bytedance.forest.postprocessor.ForestPostProcessor
    public ProcessedData<Response> onProcess(ProcessableData r100) {
        Response r101 = r100.f244444o;
        onBuiltinProcess(r101);
        com.bytedance.forest.model.k r102 = r101.f244306h;
        int r103 = 1;
        if (r102 == null) goto L6;
        r103 = RangesKt.coerceAtLeast(r102.size(), 1);
    L6:
        return new ProcessedData(r103, r101);
    }

    public /* synthetic */ a(boolean r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = true;
    L5:
        this(r100);
    }
}
