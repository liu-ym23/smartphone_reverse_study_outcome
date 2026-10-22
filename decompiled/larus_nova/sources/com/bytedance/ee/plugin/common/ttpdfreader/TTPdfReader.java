package com.bytedance.ee.plugin.common.ttpdfreader;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.util.SizeF;
import android.util.SparseArray;
import android.view.View;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public abstract class TTPdfReader {

    public interface Listener {
        void onError(int r100, Bundle r101);

        void onInfo(int r100, Bundle r101);

        void onReport(String r100, JSONObject r101);
    }

    public TTPdfReader() {
    }

    public void SetImageLoader(IReaderImageLoader r100) {
    }

    public void clearMarks() {
    }

    public void clearSelection() {
    }

    public abstract void close();

    public void drawSnapshot(Canvas r100) {
    }

    public abstract int findFirstVisiblePage();

    public int getCurrentPage() {
        return -1;
    }

    public abstract float getCurrentPageOffset(int r100);

    public abstract float getDocTotalLength();

    public float getMaxScale() {
        return 1.0f;
    }

    public float getMinScale() {
        return 1.0f;
    }

    public abstract SizeF getPageResolution(int r100);

    public abstract SizeF getPageSize(int r100);

    public float getScale() {
        return 1.0f;
    }

    public abstract List<Bookmark> getTableOfContents();

    public int getTotalPage() {
        return 0;
    }

    public abstract String getVersion();

    public abstract View getView();

    public abstract PagePart loadPageSync(int r100, float r101, float r102, RectF r103, boolean r104, boolean r105) throws Exception;

    public void markAreas(String r100, int r101, List<RectF> r102, int r103, int r104, int r105, boolean r106, boolean r107) {
    }

    public void markText(String r100, CharRange r101, int r102, boolean r103, boolean r104) {
    }

    public abstract void open(Uri r100, String r101, String r102);

    public void refresh() {
    }

    public void removeMark(String r100) {
    }

    public void scrollXY(int r100, int r101) {
    }

    public abstract void scrollY(int r100, float r101);

    public void selectSearchResult(int r100) {
    }

    public void setContentLoader(IReaderContentLoader r100) {
    }

    public void setListener(Listener r100) {
    }

    public void setMarkClient(IReaderMarkClient r100) {
    }

    public abstract void setMaxScale(float r100);

    public abstract void setMinScale(float r100);

    public abstract void setOptions(SparseArray<String> r100);

    public void setPageErrorTips(String r100) {
    }

    public void setScale(float r100) {
    }

    public void setSearchClient(IReaderSearchClient r100) {
    }

    public void setSelectionClient(IReaderSelectionClient r100) {
    }

    public void setStreamingDownloader(IStreamingDownloader r100) {
    }

    public void startSearch(String r100, boolean r101) {
    }

    public void stopSearch() {
    }

    public void turnTo(int r100) {
    }

    public boolean updateAreaMarkStyle(String r100, int r101, int r102, int r103) {
        return false;
    }

    public void updateBackgroundStatus(boolean r100) {
    }
}
