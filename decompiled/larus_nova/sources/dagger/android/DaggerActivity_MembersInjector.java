package dagger.android;

import dagger.MembersInjector;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes41.dex */
public final class DaggerActivity_MembersInjector implements MembersInjector<DaggerActivity> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

    public DaggerActivity_MembersInjector(Provider<DispatchingAndroidInjector<Object>> r100) {
        this.androidInjectorProvider = r100;
    }

    public static MembersInjector<DaggerActivity> create(Provider<DispatchingAndroidInjector<Object>> r100) {
        return new DaggerActivity_MembersInjector(r100);
    }

    /* JADX INFO: renamed from: injectMembers, reason: avoid collision after fix types in other method */
    public void injectMembers2(DaggerActivity r100) {
        injectAndroidInjector(r100, this.androidInjectorProvider.get());
    }

    @Override // dagger.MembersInjector
    public /* bridge */ /* synthetic */ void injectMembers(DaggerActivity r100) {
        injectMembers2(r100);
    }

    public static void injectAndroidInjector(DaggerActivity r100, DispatchingAndroidInjector<Object> r101) {
        r100.androidInjector = r101;
    }
}
