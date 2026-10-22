package dagger.android.support;

import android.content.Context;
import androidx.fragment.app.Fragment;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
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

    public DaggerFragment(int r100) {
        super(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context r100) {
        AndroidSupportInjection.inject(this);
        super.onAttach(r100);
    }
}
