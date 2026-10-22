package com.bytedance.geckox.logger;

import com.bytedance.iesgurd.core.ReportNode;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0007J\u001d\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0015J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\b\u0010\u0017\u001a\u00020\u000fH\u0007J\"\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\b\u0010\u001b\u001a\u00020\u000fH\u0007J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0007J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\"\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001aH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\u0007\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/geckox/logger/GeckoLogger;", "", "()V", "TAG", "", "defaultLogger", "Lcom/bytedance/geckox/logger/DefaultLogger;", "isDebug", "", "isDebug$annotations", "()Z", "loggerList", "", "Lcom/bytedance/geckox/logger/Logger;", "addLogger", "", "logger", "d", "name", "Lcom/bytedance/iesgurd/core/ReportNode;", "msg", "d$geckox_noasanRelease", "tag", "disable", "e", "tr", "", "enable", "removeLogger", "w", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
public final class GeckoLogger {
    public static final GeckoLogger INSTANCE = null;
    private static final String TAG = "gecko-debug-tag";
    private static final DefaultLogger defaultLogger = null;
    private static final List<Logger> loggerList = null;

    private GeckoLogger() {
    }

    @Deprecated(message = "")
    @JvmStatic
    public static final void disable() {
    }

    @Deprecated(message = "")
    @JvmStatic
    public static final void enable() {
    }

    public static final boolean isDebug() {
        return false;
    }

    @Deprecated(message = "")
    @JvmStatic
    public static /* synthetic */ void isDebug$annotations() {
    }

    static {
        INSTANCE = new GeckoLogger();
        loggerList = new CopyOnWriteArrayList();
        defaultLogger = new DefaultLogger();
    }

    @JvmStatic
    public static final void addLogger(Logger r100) {
        loggerList.add(r100);
    }

    @JvmStatic
    public static final void d(String r100) {
        List<Logger> r101 = loggerList;
        if (r101.size() != 0) goto L6;
        defaultLogger.d(TAG, new Object[]{r100});
        return;
    L6:
        Iterator<Logger> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r102.next().d(TAG, new Object[]{r100});
        goto L8
    }

    @JvmStatic
    public static final void removeLogger(Logger r100) {
        loggerList.remove(r100);
    }

    @JvmStatic
    public static final void w(String r100) {
        List<Logger> r101 = loggerList;
        if (r101.size() != 0) goto L6;
        defaultLogger.w(TAG, r100);
        return;
    L6:
        Iterator<Logger> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r102.next().w(TAG, r100);
        goto L8
    }

    @Deprecated(message = "")
    @JvmStatic
    public static final void d(String r100, String r101) {
        List<Logger> r102 = loggerList;
        if (r102.size() != 0) goto L6;
        defaultLogger.d(r100, new Object[]{r101});
        return;
    L6:
        Iterator<Logger> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r103.next().d(r100, new Object[]{r101});
        goto L8
    }

    @JvmStatic
    public static final void e(String r100, Throwable r101) {
        List<Logger> r102 = loggerList;
        if (r102.size() != 0) goto L6;
        defaultLogger.e(TAG, r100, r101);
        return;
    L6:
        Iterator<Logger> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r103.next().e(TAG, r100, r101);
        goto L8
    }

    @JvmStatic
    public static final void w(String r100, Throwable r101) {
        List<Logger> r102 = loggerList;
        if (r102.size() != 0) goto L6;
        defaultLogger.w(TAG, r100, r101);
        return;
    L6:
        Iterator<Logger> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r103.next().w(TAG, r100, r101);
        goto L8
    }

    public final void d$geckox_noasanRelease(ReportNode r100, String r101) {
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        String r103 = String.format("%s|xParam:{\"name\":\"%s\",\"message\":\"%s\"}", Arrays.copyOf(new Object[]{r100.getTag(), r100.getTag(), r101}, 3));
        List<Logger> r104 = loggerList;
        if (r104.size() != 0) goto L6;
        defaultLogger.d(TAG, new Object[]{r103});
        return;
    L6:
        Iterator<Logger> r105 = r104.iterator();
    L8:
        if (r105.hasNext() == false) goto L10;
        r105.next().d(TAG, new Object[]{r103});
        goto L8
    }

    @Deprecated(message = "")
    @JvmStatic
    public static final void w(String r100, String r101) {
        List<Logger> r102 = loggerList;
        if (r102.size() != 0) goto L6;
        defaultLogger.w(r100, r101);
        return;
    L6:
        Iterator<Logger> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r103.next().w(r100, r101);
        goto L8
    }

    @Deprecated(message = "")
    @JvmStatic
    public static final void e(String r100, String r101, Throwable r102) {
        List<Logger> r103 = loggerList;
        if (r103.size() != 0) goto L6;
        defaultLogger.e(r100, r101, r102);
        return;
    L6:
        Iterator<Logger> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        r104.next().e(r100, r101, r102);
        goto L8
    }

    @Deprecated(message = "")
    @JvmStatic
    public static final void w(String r100, String r101, Throwable r102) {
        List<Logger> r103 = loggerList;
        if (r103.size() != 0) goto L6;
        defaultLogger.w(r100, r101, r102);
        return;
    L6:
        Iterator<Logger> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        r104.next().w(r100, r101, r102);
        goto L8
    }
}
