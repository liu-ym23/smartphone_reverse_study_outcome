package com.bytedance.forest.postprocessor;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends ForestPostProcessor<Object> {
    public b() {
        super(false, 1, null);
    }

    @Override // com.bytedance.forest.postprocessor.ForestPostProcessor
    public final String getName() {
        return "fake";
    }

    @Override // com.bytedance.forest.postprocessor.ForestPostProcessor
    public final ProcessedData<Object> onProcess(ProcessableData r100) {
        throw new IllegalStateException("A fake processor can not be performed");
    }
}
