package dagger.android;

import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes41.dex */
public final class DaggerApplication_MembersInjector implements MembersInjector<DaggerApplication> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

    public DaggerApplication_MembersInjector(Provider<DispatchingAndroidInjector<Object>> r100) {
        this.androidInjectorProvider = r100;
    }

    public static MembersInjector<DaggerApplication> create(Provider<DispatchingAndroidInjector<Object>> r100) {
        return new DaggerApplication_MembersInjector(r100);
    }

    /* JADX INFO: renamed from: injectMembers, reason: avoid collision after fix types in other method */
    public void injectMembers2(DaggerApplication r100) {
        injectAndroidInjector(r100, this.androidInjectorProvider.get());
    }

    @Override // dagger.MembersInjector
    public /* bridge */ /* synthetic */ void injectMembers(DaggerApplication r100) {
        injectMembers2(r100);
    }

    public static void injectAndroidInjector(DaggerApplication r100, DispatchingAndroidInjector<Object> r101) {
        r100.androidInjector = r101;
    }
}
