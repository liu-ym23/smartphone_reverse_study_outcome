package com.bytedance.bdlocation.log;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class Logger {
    public static final String TAG = "BDLocation";
    private static final LogPrinter sLogPrinter = null;
    private static final Map<Class<?>, Printer> sPrinters = null;

    public Logger() {
    }

    static {
        sPrinters = new ConcurrentHashMap();
        LogPrinter r100 = new LogPrinter();
        sLogPrinter = r100;
        addPrinter(r100);
    }

    public static void addPrinter(Printer r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Map<Class<?>, Printer> r101 = sPrinters;
        if (r101.containsKey(r100.getClass()) == true) goto L8;
        r101.put(r100.getClass(), r100);
        return;
    }

    public static void d(String r100) {
        d("BDLocation", r100);
    }

    public static void e(String r100) {
        e("BDLocation", r100);
    }

    public static void i(String r100) {
        i("BDLocation", r100);
    }

    public static void setEnabled(boolean r100) {
        sLogPrinter.setEnable(r100);
    }

    public static void v(String r100) {
        v("BDLocation", r100);
    }

    public static void w(String r100) {
        w("BDLocation", r100);
    }

    public static void d(String r100, String r101) {
        d(r100, r101, null);
    }

    public static void e(String r100, Throwable r101) {
        e("BDLocation", r100, r101);
    }

    public static void i(String r100, String r101) {
        i(r100, r101, null);
    }

    public static void v(String r100, String r101) {
        v(r100, r101, null);
    }

    public static void w(String r100, String r101) {
        w(r100, r101, null);
    }

    public static void e(String r100, String r101) {
        e(r100, r101, null);
    }

    public static void d(String r100, String r101, Throwable r102) {
        Iterator<Map.Entry<Class<?>, Printer>> r103 = sPrinters.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().getValue().d(r100, r101, r102);
        goto L4
    }

    public static void e(String r100, String r101, Throwable r102) {
        Iterator<Map.Entry<Class<?>, Printer>> r103 = sPrinters.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().getValue().e(r100, r101, r102);
        goto L4
    }

    public static void i(String r100, String r101, Throwable r102) {
        Iterator<Map.Entry<Class<?>, Printer>> r103 = sPrinters.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().getValue().i(r100, r101, r102);
        goto L4
    }

    public static void v(String r100, String r101, Throwable r102) {
        Iterator<Map.Entry<Class<?>, Printer>> r103 = sPrinters.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().getValue().v(r100, r101, r102);
        goto L4
    }

    public static void w(String r100, String r101, Throwable r102) {
        Iterator<Map.Entry<Class<?>, Printer>> r103 = sPrinters.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().getValue().w(r100, r101, r102);
        goto L4
    }
}
