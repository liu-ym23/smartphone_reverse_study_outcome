package dagger.android;

import android.app.DialogFragment;
import android.content.Context;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes41.dex */
public abstract class DaggerDialogFragment extends DialogFragment implements HasAndroidInjector {

    @Inject
    DispatchingAndroidInjector<Object> androidInjector;

    public DaggerDialogFragment() {
    }

    @Override // dagger.android.HasAndroidInjector
    public AndroidInjector<Object> androidInjector() {
        return this.androidInjector;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onAttach(Context r100) {
        AndroidInjection.inject(this);
        super.onAttach(r100);
    }
}
