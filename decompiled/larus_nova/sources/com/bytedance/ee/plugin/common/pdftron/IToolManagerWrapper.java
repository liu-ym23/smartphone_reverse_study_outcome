package com.bytedance.ee.plugin.common.pdftron;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.bytedance.ee.plugin.common.pdftron.wrapper.Annot;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public interface IToolManagerWrapper {

    public interface AnnotationModificationListener {
        void annotationsCouldNotBeAdded(String r100);

        void onAnnotationsAdded(Map<Annot, Integer> r100);

        void onAnnotationsModified(Map<Annot, Integer> r100, Bundle r101);

        void onAnnotationsPreModify(Map<Annot, Integer> r100);

        void onAnnotationsPreRemove(Map<Annot, Integer> r100);

        void onAnnotationsRemoved(Map<Annot, Integer> r100);

        void onAnnotationsRemovedOnPage(int r100);

        void showCommentEditor(int r100, Annot r101);
    }

    public interface PreToolManagerListener {
        boolean onDoubleTap(MotionEvent r100);

        boolean onDown(MotionEvent r100);

        boolean onKeyUp(int r100, KeyEvent r101);

        void onLinkClick(int r100, int r101, String r102);

        boolean onLongPress(MotionEvent r100);

        void onLongPressConfirmed(int r100, float r101, float r102);

        void onMarkupSingleTab(Annot r100);

        boolean onMove(MotionEvent r100, MotionEvent r101, float r102, float r103);

        boolean onScale(float r100, float r101);

        boolean onScaleBegin(float r100, float r101);

        boolean onScaleEnd(float r100, float r101);

        void onScrollChanged(int r100, int r101, int r102, int r103);

        void onSingleTab();

        boolean onSingleTapConfirmed(MotionEvent r100);

        boolean onUp(MotionEvent r100);
    }

    public interface QuickMenuListener {
        public static final int ID_COPY = 1;
        public static final int ID_HIGHLIGHT = 2;

        boolean canComment();

        Map<String, String> getTitles();

        boolean onQuickMenuClicked(int r100, String r101);

        void onQuickMenuDismissed();

        void onQuickMenuShown();
    }

    void addAnnotationModificationListener(AnnotationModificationListener r100);

    void enableHighlight();

    void setPreToolManagerListener(PreToolManagerListener r100);

    void setQuickMenuListener(QuickMenuListener r100);
}
