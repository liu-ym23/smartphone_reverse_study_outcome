package wd;

import android.view.View;

/* JADX INFO: loaded from: classes43.dex */
public interface e {
    View getView();

    void onHide();

    void onLoad();

    void onShow();

    boolean onTriggerAnimation(long r100);

    void onUnload();

    void onViewAttached(c r100);

    void onViewDetached();

    void onViewWillAttach(c r100);

    void onViewWillDetach();
}
