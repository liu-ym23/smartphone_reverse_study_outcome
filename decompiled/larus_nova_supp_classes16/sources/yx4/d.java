package yx4;

import android.widget.FrameLayout;
import com.bytedance.ee.bear.dependency.LoadingLayoutScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface d {
    void attachLoadingView(FrameLayout r1);

    void detachLoadingView();

    LoadingLayoutScope getScope();

    void hideLoading();

    void showLoading();
}
