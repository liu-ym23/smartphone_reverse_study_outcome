package com.bytedance.ee.plugin.common.ttreader;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public interface ITTReaderViewWrapper {
    public static final int ERROR_INVALID_PASSWORD = 2002;
    public static final String ERROR_MSG_KEY = "errmsg";
    public static final int ERROR_NO_READER = 2000;
    public static final int ERROR_OPEN_FAIL = 2001;
    public static final int INFO_BOOK_LOADED = 1000;
    public static final int INFO_CELL_SELECTED = 1003;
    public static final int INFO_LINK_EVENT = 1004;
    public static final int INFO_ON_SCROLL = 1007;
    public static final int INFO_ON_SINGLE_TAP = 1006;
    public static final int INFO_PAGE_CHANGED = 1001;
    public static final int INFO_PAGE_LOADED = 1009;
    public static final int INFO_REFRESH = 1008;
    public static final int INFO_SCALE_CHANGED = 1002;
    public static final int INFO_SCROLL_TO_DOCUMENT_TOP = 1005;
    public static final String LINK_DATA_KEY = "link";
    public static final int OPTION_PDF_ENABLE_DOUBLE_TAP = 3003;
    public static final int OPTION_PDF_SHOW_PAGE_NUMBER = 3000;
    public static final int OPTION_PDF_SPACE_COLOR = 3002;
    public static final int OPTION_PDF_SPACE_SIZE = 3001;
    public static final int OPTION_WORD_AUTO_SCALE_WHEN_OPEN = 3100;
    public static final int REPORT_ELAPSED_TIME = 4002;
    public static final int REPORT_OPEN_CONSUMING = 4001;
    public static final int REPORT_OPEN_FILE = 4000;
    public static final String SELECTION_KEY_FORMULA = "formula";
    public static final String SELECTION_KEY_VALUE = "value";

    public interface IReaderImageLoader {
        Bitmap load(String r100);
    }

    public interface Listener {
        void onError(int r100, Bundle r101);

        void onInfo(int r100, Bundle r101);

        void onReport(String r100, JSONObject r101);
    }

    void SetImageLoader(IReaderImageLoader r100);

    void closeBook();

    int getCurrentPage();

    float getMaxScale();

    float getMinScale();

    float getScale();

    View getTTReaderView();

    int getTotalPage();

    String getVersion();

    void openBook(Uri r100);

    void openBook(Uri r100, String r101);

    void openBook(Uri r100, String r101, String r102);

    void openBook(Uri r100, String r101, String r102, Map<String, String> r103);

    void openBook(String r100);

    void refresh();

    void resetOptions();

    void scrollXY(int r100, int r101);

    void setListener(Listener r100);

    void setOption(int r100, String r101);

    void setScale(float r100);

    void turnTo(int r100);
}
