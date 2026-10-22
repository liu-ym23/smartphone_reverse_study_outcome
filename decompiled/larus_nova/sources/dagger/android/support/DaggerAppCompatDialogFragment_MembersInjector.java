package dagger.android.support;

import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes41.dex */
public final class DaggerAppCompatDialogFragment_MembersInjector implements MembersInjector<DaggerAppCompatDialogFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

    public DaggerAppCompatDialogFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> r100) {
        this.androidInjectorProvider = r100;
    }

    public static MembersInjector<DaggerAppCompatDialogFragment> create(Provider<DispatchingAndroidInjector<Object>> r100) {
        return new DaggerAppCompatDialogFragment_MembersInjector(r100);
    }

    /* JADX INFO: renamed from: injectMembers, reason: avoid collision after fix types in other method */
    public void injectMembers2(DaggerAppCompatDialogFragment r100) {
        injectAndroidInjector(r100, this.androidInjectorProvider.get());
    }

    @Override // dagger.MembersInjector
    public /* bridge */ /* synthetic */ void injectMembers(DaggerAppCompatDialogFragment r100) {
        injectMembers2(r100);
    }

    public static void injectAndroidInjector(DaggerAppCompatDialogFragment r100, DispatchingAndroidInjector<Object> r101) {
        r100.androidInjector = r101;
    }
}
