package dagger.android;

import android.app.Fragment;
import android.content.Context;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes41.dex */
public abstract class DaggerFragment extends Fragment implements HasAndroidInjector {

    @Inject
    DispatchingAndroidInjector<Object> androidInjector;

    public DaggerFragment() {
    }

    @Override // dagger.android.HasAndroidInjector
    public AndroidInjector<Object> androidInjector() {
        return this.androidInjector;
    }

    @Override // android.app.Fragment
    public void onAttach(Context r100) {
        AndroidInjection.inject(this);
        super.onAttach(r100);
    }
}
