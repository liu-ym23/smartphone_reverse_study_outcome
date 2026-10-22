package dagger.hilt.android.dwarf;

import dagger.hilt.internal.GeneratedComponentManager;

/* JADX INFO: loaded from: classes41.dex */
public interface DwarfComponentProvider<T> extends GeneratedComponentManager<T> {

    /* JADX INFO: renamed from: dagger.hilt.android.dwarf.DwarfComponentProvider$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<T> {
        public static Object $default$generatedComponent(DwarfComponentProvider r100) {
            return r100.provideComponent();
        }
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    T generatedComponent();

    T provideComponent();
}
