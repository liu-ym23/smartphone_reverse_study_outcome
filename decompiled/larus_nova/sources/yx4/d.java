package yx4;

import android.widget.FrameLayout;
import com.bytedance.ee.bear.dependency.LoadingLayoutScope;

/* JADX INFO: loaded from: classes16.dex */
public interface d {
    void attachLoadingView(FrameLayout r100);

    void detachLoadingView();

    LoadingLayoutScope getScope();

    void hideLoading();

    void showLoading();
}
