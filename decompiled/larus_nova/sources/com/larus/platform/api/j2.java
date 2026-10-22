package com.larus.platform.api;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.bmhome.chat.component.thirdpart.ThirdPartLogicComponent$doraAudioStateObserver$1;
import java.util.List;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes4.dex */
public interface j2 {
    void a(int r100);

    boolean b();

    boolean c();

    void d(int r100, int r101, Fragment r102, View r103, LifecycleCoroutineScope r104);

    int e(Context r100, List r101, LifecycleCoroutineScope r102, com.larus.bmhome.chat.component.thirdpart.d r103);

    void f(o r100);

    Deferred<Integer> g();

    int getProductId();

    Integer h();

    void i(boolean r100);

    boolean isDoraConnected();

    Deferred<Integer> j();

    void k(ThirdPartLogicComponent$doraAudioStateObserver$1 r100);

    Integer l();

    void m();

    void n(FragmentManager r100);

    Integer o(String r100);

    Integer q();

    Integer r();
}
