package com.ss.android.downloadlib.utils;

import com.ss.android.downloadlib.exception.TTDownloaderMonitor;

/* JADX INFO: loaded from: classes34.dex */
public class DownloadProgressOptHelper {
    private static final int PERCENT_HALF_VALUE = 50;

    /* JADX INFO: renamed from: com.ss.android.downloadlib.utils.DownloadProgressOptHelper$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class SingleTonHolder {
        private static DownloadProgressOptHelper INSTANCE;

        private SingleTonHolder() {
        }

        static {
            INSTANCE = new DownloadProgressOptHelper(null);
        }

        public static /* synthetic */ DownloadProgressOptHelper access$100() {
            return INSTANCE;
        }
    }

    private DownloadProgressOptHelper() {
    }

    public static DownloadProgressOptHelper getInstance() {
        return SingleTonHolder.access$100();
    }

    public /* synthetic */ DownloadProgressOptHelper(AnonymousClass1 r100) {
        this();
    }

    private int getLambertOptResult(int r100) {
        double r101 = r100;
        double r102 = r101 * 0.15d;
        return (int) ((LamberHelper.branchNeg1(r102 * Math.exp(7.5d - r102)) / 0.15d) + r101);
    L6:
        e = move-exception;
        TTDownloaderMonitor.inst().monitorException(e, "calculate lambert error");
        return r100;
    }

    private int getSecondHalfOptResultType1(int r100) {
        return (int) ((Math.pow(r100 - 50, 3.0d) * 4.0E-4d) + 50.0d);
    }

    private int getSecondHalfOptResultType2(int r100) {
        return (int) ((Math.pow(r100 - 50, 4.0d) * 8.0E-6d) + 50.0d);
    }

    private int getSecondHalfOptResultType3(int r100) {
        return (int) ((Math.pow(r100 - 50, 5.0d) * 1.6E-7d) + 50.0d);
    }

    private double getChangedBottomLogResult(double r100, double r101) {
        return Math.log(r100) / Math.log(r101);
    }

    public int getRandomStartPercent(int r100, int r101) {
        if (r100 != 1) goto L5;
        long r102 = (System.currentTimeMillis() % 3) + 2;
    L13:
        return (int) r102;
    L5:
        if (r100 != 2) goto L7;
        r102 = (System.currentTimeMillis() % 4) + 3;
        goto L13
    L7:
        if (r100 == 3) goto L9;
        TTDownloaderMonitor.inst().monitorException(false, null, "下发的随机起点进度策略错误，未命中任何策略");
        return r101;
    L9:
        r102 = (System.currentTimeMillis() % 5) + 4;
        goto L13
    }

    private int getLogOptResult(int r100, int r101, int r102, int r103) {
        if (r100 < 1) goto L13;
        if (r101 <= 1) goto L6;
        double r104 = r100;
        int r105 = 0;
    L8:
        if (r105 >= r101) goto L11;
        r104 = getChangedBottomLogResult(r104, r103) * ((double) r102);
        r105 = r105 + 1;
        goto L8
    L11:
        return (int) r104;
    L6:
        return (int) (getChangedBottomLogResult(r100, r103) * ((double) r102));
    L13:
        return r100;
    }

    private int getPieceOptResult(int r100, int r101, int r102, int r110) {
        if (r100 <= 0) goto L13;
        if (r100 > 50) goto L13;
        if (r101 == 1) goto L12;
        if (r101 == 2) goto L10;
        TTDownloaderMonitor.inst().monitorException(false, null, "分段函数的上半段未指定伪装策略");
        return r100;
    L10:
        return getLogOptResult(r100, r110, 50, 50);
    L12:
        return getSqrtOptResult(r100, 3, 5, 128);
    L13:
        if (r100 > 50) goto L15;
        return r100;
    L15:
        if (r100 >= 100) goto L28;
        if (r102 == 1) goto L26;
        if (r102 == 2) goto L24;
        if (r102 == 3) goto L22;
        TTDownloaderMonitor.inst().monitorException(false, null, "分段函数的下半段未指定伪装策略");
        return r100;
    L22:
        return getSecondHalfOptResultType3(r100);
    L24:
        return getSecondHalfOptResultType2(r100);
    L26:
        return getSecondHalfOptResultType1(r100);
    L28:
        return r100;
    }

    private int getSqrtOptResult(int r100, int r101, int r102, int r103) {
        if (r101 <= 1) goto L5;
        double r104 = r100;
        int r105 = 0;
    L7:
        if (r105 >= r101) goto L13;
        if (r105 != 0) goto L10;
        double r106 = Math.sqrt(r104 * ((double) r103));
    L11:
        r104 = r106 * ((double) r102);
        r105 = r105 + 1;
        goto L7
    L10:
        r106 = Math.sqrt(r104);
        goto L11
    L13:
        return (int) r104;
    L5:
        return (int) (Math.sqrt(r100 * r103) * ((double) r102));
    }

    public int getOptProgress(int r100, int r101, int r102, int r103, int r104, int r105) {
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L15;
        if (r100 == 4) goto L13;
        TTDownloaderMonitor.inst().monitorException(false, null, "下发的伪装策略无效，没有命中任何策略");
        return r101;
    L13:
        return getPieceOptResult(r101, r103, r104, r105);
    L15:
        return getLambertOptResult(r101);
    L17:
        return getLogOptResult(r101, r102, 50, 10);
    L19:
        return getSqrtOptResult(r101, r102, 10, 1);
    }
}
