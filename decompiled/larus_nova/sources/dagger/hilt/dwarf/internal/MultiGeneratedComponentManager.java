package dagger.hilt.dwarf.internal;

/* JADX INFO: loaded from: classes41.dex */
public interface MultiGeneratedComponentManager<KEY, COMPONENT, PAYLOAD> {
    COMPONENT destroyComponent(KEY r100);

    COMPONENT findComponent(KEY r100);

    COMPONENT generatedComponent(KEY r100, PAYLOAD r101);
}
