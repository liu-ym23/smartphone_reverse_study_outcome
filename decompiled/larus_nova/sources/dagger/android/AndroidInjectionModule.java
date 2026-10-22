package dagger.android;

import dagger.Module;
import dagger.multibindings.Multibinds;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
@Module
public abstract class AndroidInjectionModule {
    private AndroidInjectionModule() {
    }

    @Multibinds
    public abstract Map<Class<?>, AndroidInjector.Factory<?>> classKeyedInjectorFactories();

    @Multibinds
    public abstract Map<String, AndroidInjector.Factory<?>> stringKeyedInjectorFactories();
}
