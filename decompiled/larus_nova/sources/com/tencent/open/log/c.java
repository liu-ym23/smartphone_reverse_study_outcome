package com.tencent.open.log;

import com.ss.bytertc.engine.utils.LogUtil;
import com.tencent.connect.common.Constants;
import java.io.File;

/* JADX INFO: loaded from: classes31.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f461798a = 60;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f461799b = 60;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f461800c = "OpenSDK.Client.File.Tracer";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f461801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f461802e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f461803f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f461804g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f461805h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f461806i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f461807j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f461808k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f461809l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f461810m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static long f461811n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static String f461812o;

    static {
        StringBuilder r100 = new StringBuilder("Tencent");
        String r101 = File.separator;
        r100.append(r101);
        r100.append("msflogs");
        r100.append(r101);
        r100.append("com");
        r100.append(r101);
        r100.append("tencent");
        r100.append(r101);
        r100.append("mobileqq");
        r100.append(r101);
        f461801d = r100.toString();
        f461802e = ".log";
        f461803f = 8388608;
        f461804g = 262144;
        f461805h = 1024;
        f461806i = 10000;
        f461807j = "debug.file.blockcount";
        f461808k = "debug.file.keepperiod";
        f461809l = "debug.file.tracelevel";
        f461810m = 24;
        f461811n = 604800000;
        f461812o = Constants.APP_SPECIFIC_ROOT + r101 + LogUtil.DIR_TAIL;
    }
}
