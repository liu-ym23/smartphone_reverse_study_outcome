package ru5;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;

/* JADX INFO: loaded from: classes19.dex */
public interface a {

    /* JADX INFO: renamed from: ru5.a$a, reason: collision with other inner class name */
    public interface InterfaceC7535a {
        LifecycleOwner a();

        <T extends ViewModel> T b(Class<T> r100);

        Context provideContext();
    }

    public interface b {
        void a(d r100, Boolean r101);
    }

    void a();
}
