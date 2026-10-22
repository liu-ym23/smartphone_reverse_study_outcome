package com.ss.android.socialbase.downloader.utils;

import android.util.Pair;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadExtListener;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public class DownloadListenerUtils {
    private static final int RECEIVE_TYPE_DATA = 1;
    private static final int RECEIVE_TYPE_HEADER = 2;
    private static final int RECEIVE_TYPE_REQUEST_LOG = 3;
    private static final int RECEIVE_TYPE_SEGMENT_DATA = 4;

    public DownloadListenerUtils() {
    }

    public static void notifyReceiveHeader(Map<Integer, IDownloadListener> r100, DownloadInfo r110, List<Pair<String, String>> r111) {
        notifyReceive(2, r100, r110, 0, null, 0, r111, null);
    }

    public static void notifyReceiveRequestLog(Map<Integer, IDownloadListener> r100, DownloadInfo r110, String r111) {
        notifyReceive(3, r100, r110, 0, null, 0, null, r111);
    }

    private static void removeCallback(DownloadTask r100, ListenerType r101, IDownloadListener r102) {
        if (r100 == null) goto L5;
        r100.removeCallback(r101, r102);
        return;
    }

    public static void notifyReceiveData(Map<Integer, IDownloadListener> r100, DownloadInfo r110, byte[] r111, int r112) {
        notifyReceive(1, r100, r110, 0, r111, r112, null, null);
    }

    public static void notifyCancelListener(DownloadTask r100, DownloadInfo r101, Map<Integer, IDownloadListener> r102, ListenerType r103, boolean r104) {
        if (r104 == false) goto L9;
        Iterator<IDownloadListener> r105 = r102.values().iterator();
    L5:
        if (r105.hasNext() == false) goto L33;
        IDownloadListener r106 = r105.next();
        if (r106 == null) goto L5;
        r106.onCanceled(r101);
        r100.removeCallback(r103, r106);
        goto L5
    L33:
        return;
    L9:
        monitor-enter(r102);
        Iterator<IDownloadListener> r107 = r102.values().iterator();     // Catch: Throwable -> L18
    L12:
        if (r107.hasNext() == false) goto L16;
        IDownloadListener r108 = r107.next();     // Catch: Throwable -> L18
        if (r108 == null) goto L12;
        r108.onCanceled(r101);     // Catch: Throwable -> L18
        r100.removeCallback(r103, r108);     // Catch: Throwable -> L18
        goto L12
    L16:
        monitor-exit(r102);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public static void notifyReceiveSegmentData(Map<Integer, IDownloadListener> r100, DownloadInfo r110, long r111, byte[] r112, int r113) {
        notifyReceive(4, r100, r110, r111, r112, r113, null, null);
    }

    public static void notifyListener(int r100, Map<Integer, IDownloadListener> r101, boolean r102, DownloadInfo r103, BaseException r104, ListenerType r105, DownloadTask r106) {
        if (r102 == false) goto L99;
        if (r101 == null) goto L100;
    L54:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (r101.size() <= 0) goto L101;
        Iterator<IDownloadListener> r107 = r101.values().iterator();     // Catch: Throwable -> L54
    L8:
        if (r107.hasNext() == false) goto L102;
        IDownloadListener r108 = r107.next();     // Catch: Throwable -> L54
        if (r100 != (-7)) goto L13;
    L21:
        ((IDownloadGlobalThrottleService) DownloadServiceManager.getService(IDownloadGlobalThrottleService.class)).end(r106);     // Catch: Throwable -> L54
    L22:
        if (r108 == null) goto L8;
        if (r100 != 1) goto L26;
        r108.onPrepare(r103);     // Catch: Throwable -> L54
        goto L8
    L26:
        if (r100 != 2) goto L28;
        r108.onStart(r103);     // Catch: Throwable -> L54
        goto L8
    L28:
        if (r100 != 4) goto L30;
        r108.onProgress(r103);     // Catch: Throwable -> L54
        goto L8
    L30:
        if (r100 != 5) goto L32;
        r108.onRetry(r103, r104);     // Catch: Throwable -> L54
        goto L8
    L32:
        if (r100 != 6) goto L34;
        r108.onFirstStart(r103);     // Catch: Throwable -> L54
        goto L8
    L34:
        if (r100 != 11) goto L35;
        if ((r108 instanceof IDownloadExtListener) == false) goto L8;
        ((IDownloadExtListener) r108).onWaitingDownloadCompleteHandler(r103);     // Catch: Throwable -> L54
        goto L8
    L35:
        switch(r100) {
            case -7: goto L43;
            case -6: goto L41;
            case -5: goto L40;
            case -4: goto L39;
            case -3: goto L38;
            case -2: goto L40;
            case -1: goto L37;
            default: goto L8;
        };     // Catch: Throwable -> L54
    L37:
        r108.onFailed(r103, r104);     // Catch: Throwable -> L54
        removeCallback(r106, r105, r108);     // Catch: Throwable -> L54
        goto L8
    L38:
        r108.onSuccessed(r103);     // Catch: Throwable -> L54
        removeCallback(r106, r105, r108);     // Catch: Throwable -> L54
        goto L8
    L39:
        r108.onCanceled(r103);     // Catch: Throwable -> L54
        removeCallback(r106, r105, r108);     // Catch: Throwable -> L54
        goto L8
    L40:
        r108.onPause(r103);     // Catch: Throwable -> L54
        removeCallback(r106, r105, r108);     // Catch: Throwable -> L54
        goto L8
    L41:
        r108.onFirstSuccess(r103);     // Catch: Throwable -> L54
        goto L8
    L43:
        if ((r108 instanceof AbsDownloadListener) == false) goto L8;
        ((AbsDownloadListener) r108).onIntercept(r103);     // Catch: Throwable -> L54
        removeCallback(r106, r105, r108);     // Catch: Throwable -> L54
        goto L8
    L13:
        if (r100 == (-4)) goto L21;
        if (r100 == (-3)) goto L21;
        if (r100 == (-2)) goto L21;
        if (r100 == (-1)) goto L21;
    L102:
        return;
    L101:
        return;
    L100:
        return;
    }

    private static void notifyReceive(int r100, Map<Integer, IDownloadListener> r110, DownloadInfo r111, long r112, byte[] r113, int r114, List<Pair<String, String>> r115, String r116) {
        if (r110 == null) goto L48;
    L29:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (r110.size() <= 0) goto L49;
        Iterator<IDownloadListener> r101 = r110.values().iterator();     // Catch: Throwable -> L29
    L8:
        if (r101.hasNext() == false) goto L50;
        IDownloadListener r102 = r101.next();     // Catch: Throwable -> L29
        if (r102 == null) goto L8;
        if ((r102 instanceof AbsDownloadListener) == false) goto L8;
        if (r100 != 1) goto L17;
        ((AbsDownloadListener) r102).onReceiveData(r111, r113, r114);     // Catch: Throwable -> L29
        goto L8
    L17:
        if (r100 != 2) goto L19;
        ((AbsDownloadListener) r102).onReceiveHeader(r111, r115);     // Catch: Throwable -> L29
        goto L8
    L19:
        if (r100 == 3) goto L24;
        if (r100 != 4) goto L8;
        ((AbsDownloadListener) r102).onReceiveSegmentData(r111, r112, r113, r114);     // Catch: Throwable -> L29
        goto L8
    L24:
        ((AbsDownloadListener) r102).onReceiveRequestLog(r111, r116);     // Catch: Throwable -> L29
        goto L8
    L50:
        return;
    L49:
        return;
    }
}
