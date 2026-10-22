package dagger.android;

import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes41.dex */
public final class DaggerFragment_MembersInjector implements MembersInjector<DaggerFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

    public DaggerFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> r100) {
        this.androidInjectorProvider = r100;
    }

    public static MembersInjector<DaggerFragment> create(Provider<DispatchingAndroidInjector<Object>> r100) {
        return new DaggerFragment_MembersInjector(r100);
    }

    /* JADX INFO: renamed from: injectMembers, reason: avoid collision after fix types in other method */
    public void injectMembers2(DaggerFragment r100) {
        injectAndroidInjector(r100, this.androidInjectorProvider.get());
    }

    @Override // dagger.MembersInjector
    public /* bridge */ /* synthetic */ void injectMembers(DaggerFragment r100) {
        injectMembers2(r100);
    }

    public static void injectAndroidInjector(DaggerFragment r100, DispatchingAndroidInjector<Object> r101) {
        r100.androidInjector = r101;
    }
}
