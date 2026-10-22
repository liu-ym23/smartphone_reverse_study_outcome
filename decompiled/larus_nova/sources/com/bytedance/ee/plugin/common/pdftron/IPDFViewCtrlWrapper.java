package com.bytedance.ee.plugin.common.pdftron;

import android.graphics.RectF;
import android.view.View;
import com.bytedance.ee.plugin.common.pdftron.wrapper.Annot;
import com.bytedance.ee.plugin.common.pdftron.wrapper.Page;
import com.bytedance.ee.plugin.common.pdftron.wrapper.Quad;
import com.bytedance.ee.plugin.common.pdftron.wrapper.QuadPoint;
import com.bytedance.ee.plugin.common.pdftron.wrapper.Rect;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public interface IPDFViewCtrlWrapper {

    public interface DocumentDownloadListener {
        public static final int STATE_FAILED = 2;
        public static final int STATE_FINISHED = 3;
        public static final int STATE_PAGE = 1;

        void onDownloadEvent(int r100, int r101, int r102, int r103, String r104);
    }

    public interface DocumentLoadListener {
        void onDocumentLoaded();
    }

    public interface OnContentScrollChangeListener {
        void onScrollChange(View r100, int r101, int r102, int r103, int r104);
    }

    public interface PageChangeListener {
        void onPageChange(int r100, int r101, int r102);
    }

    public interface ThumbAsyncListener {
        void onThumbReceived(int r100, int[] r101, int r102, int r103);
    }

    void addContentScrollListener(OnContentScrollChangeListener r100);

    void addDocumentDownloadListener(DocumentDownloadListener r100);

    void addDocumentLoadListener(DocumentLoadListener r100);

    void addPageChangeListener(PageChangeListener r100);

    void addThumbAsyncListener(ThumbAsyncListener r100);

    void annotPushBack(Page r100, Annot r101);

    void annotPushFront(Page r100, Annot r101);

    void annotRemove(Page r100, Annot r101);

    void cancelAllThumbRequests();

    Quad convertToCommonQuad(int r100, QuadPoint r101, float r102, float r103);

    RectF convertToCommonRect(Rect r100, int r101, float r102, float r103);

    Rect convertToPDFRect(RectF r100, int r101, float r102, float r103);

    Rect convertToPDFRectOffsetCropBox(RectF r100, int r101, float r102, float r103, Page r104) throws Throwable;

    Annot createHighlight(Rect r100, Quad[] r101, int r102, float r103, float r104, int r105);

    Annot createPageSquare(int r100, int r101);

    Annot createSquare(Rect r100, int r101);

    boolean docLock(boolean r100, Runnable r101);

    boolean docLockRead(Runnable r100);

    void docUnlock();

    void docUnlockRead();

    int getCurrentPage();

    IFindTextOverlayWrapper getFindTextOverlay();

    int getIndex(Page r100);

    View getPDFViewCtrlView();

    Page getPage(int r100);

    Page getPage(Annot r100);

    int getPageCount();

    QuadPoint getQuadPoint(Annot r100, int r101);

    int getQuadPointCount(Annot r100);

    Rect getRect(Annot r100);

    void getThumbAsync(int r100);

    IToolManagerWrapper getToolManager();

    String getUniqueID(Annot r100);

    int getViewCanvasHeight();

    boolean hasChangesSinceSnapshot();

    void hideAnnotation(Annot r100);

    boolean initStdSecurityHandler(String r100, String r101) throws Throwable;

    int initStdSecurityHandlerWithErrorCode(String r100, String r101) throws Throwable;

    int initStdSecurityHandlerWithSetDocIfNeeded(String r100, String r101) throws Throwable;

    boolean isPageValid(Page r100);

    boolean isViewerZoomed();

    void loadLocalFile(String r100);

    void manageOOM();

    void onPause();

    void onResume();

    void openUrlAsync(String r100, String r101, String r102, boolean r103);

    void openUrlAsync(String r100, String r101, String r102, boolean r103, Map<String, String> r104);

    void purgeMemoryDueToOOM();

    void refreshAppearance(Annot r100);

    void release();

    void removeDocumentLoadListener(DocumentLoadListener r100);

    void removePageChangeListener(PageChangeListener r100);

    void removeThumbAsyncListener(ThumbAsyncListener r100);

    void requestRendering();

    void scrollToAnnotRect(Annot r100, int r101);

    void setCurrentPage(int r100);

    void setOpacity(Annot r100, double r101);

    void setPDFViewCtrlTouchFlag(boolean r100) throws Throwable;

    void setUniqueID(Annot r100, String r101);

    void setZoom(double r100);

    void showAnnotation(Annot r100);

    void update(Annot r100);

    void updatePageLayout();
}
