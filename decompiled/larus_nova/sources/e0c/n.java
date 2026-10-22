package e0c;

import androidx.lifecycle.ViewModel;
import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactory;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class n implements DwarfViewModelFactory.DwarfViewModelCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Provider<ViewModel>> f470671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f470672b;

    @Override // dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactory.DwarfViewModelCollector
    public final Map<String, Object> getDwarfViewModelAssistedMap() {
        return this.f470672b;
    }

    @Override // dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactory.DwarfViewModelCollector
    public final Map<String, Provider<ViewModel>> getDwarfViewModelMap() {
        return this.f470671a;
    }

    @Inject
    public n(Map<String, Provider<ViewModel>> r100, Map<String, Object> r101) {
        this.f470671a = r100;
        this.f470672b = r101;
    }
}
