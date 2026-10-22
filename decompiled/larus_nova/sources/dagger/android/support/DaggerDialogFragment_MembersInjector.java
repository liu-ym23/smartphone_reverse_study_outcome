package dagger.android.support;

import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes41.dex */
public final class DaggerDialogFragment_MembersInjector implements MembersInjector<DaggerDialogFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

    public DaggerDialogFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> r100) {
        this.androidInjectorProvider = r100;
    }

    public static MembersInjector<DaggerDialogFragment> create(Provider<DispatchingAndroidInjector<Object>> r100) {
        return new DaggerDialogFragment_MembersInjector(r100);
    }

    /* JADX INFO: renamed from: injectMembers, reason: avoid collision after fix types in other method */
    public void injectMembers2(DaggerDialogFragment r100) {
        injectAndroidInjector(r100, this.androidInjectorProvider.get());
    }

    @Override // dagger.MembersInjector
    public /* bridge */ /* synthetic */ void injectMembers(DaggerDialogFragment r100) {
        injectMembers2(r100);
    }

    public static void injectAndroidInjector(DaggerDialogFragment r100, DispatchingAndroidInjector<Object> r101) {
        r100.androidInjector = r101;
    }
}
