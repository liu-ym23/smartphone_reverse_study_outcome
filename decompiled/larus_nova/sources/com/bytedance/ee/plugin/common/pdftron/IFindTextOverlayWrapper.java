package com.bytedance.ee.plugin.common.pdftron;

import android.view.View;

/* JADX INFO: loaded from: classes19.dex */
public interface IFindTextOverlayWrapper {

    public interface FindTextCallback {
        void onFindTextTaskCancelled();

        void onFindTextTaskFinished(int r100);

        void onFindTextTaskProgressUpdated(boolean r100, int r101, int r102);

        void onFindTextTaskStarted();
    }

    public interface FindTextTaskHolder {
        void cancel();
    }

    void cancelFindTask();

    FindTextTaskHolder executeFindText(String r100, FindTextCallback r101);

    View getFindTextOverlayView();

    void gotoNextSearch();

    void gotoPreviousSearch();

    void onExitSearch();
}
