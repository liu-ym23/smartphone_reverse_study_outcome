package com.google.common.util.concurrent;

import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class ThreadFactoryBuilder {

    @CheckForNull
    private ThreadFactory backingThreadFactory;

    @CheckForNull
    private Boolean daemon;

    @CheckForNull
    private String nameFormat;

    @CheckForNull
    private Integer priority;

    @CheckForNull
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;

    public ThreadFactoryBuilder() {
        this.nameFormat = null;
        this.daemon = null;
        this.priority = null;
        this.uncaughtExceptionHandler = null;
        this.backingThreadFactory = null;
    }

    public ThreadFactory build() {
        return doBuild(this);
    }

    private static ThreadFactory doBuild(ThreadFactoryBuilder r100) {
        final String r101 = r100.nameFormat;
        final Boolean r102 = r100.daemon;
        final Integer r103 = r100.priority;
        final Thread.UncaughtExceptionHandler r104 = r100.uncaughtExceptionHandler;
        ThreadFactory r105 = r100.backingThreadFactory;
        if (r105 != null) goto L6;
        r105 = Executors.defaultThreadFactory();
    L6:
        final ThreadFactory r106 = r105;
        if (r101 == null) goto L9;
        AtomicLong r107 = new AtomicLong(0);
    L10:
        final AtomicLong r108 = r107;
        return new AnonymousClass1(r106, r101, r108, r102, r103, r104);
    L9:
        r107 = null;
        goto L10
    }

    public ThreadFactoryBuilder setDaemon(boolean r100) {
        this.daemon = Boolean.valueOf(r100);
        return this;
    }

    public ThreadFactoryBuilder setNameFormat(String r100) {
        format(r100, new Object[]{0});
        this.nameFormat = r100;
        return this;
    }

    public ThreadFactoryBuilder setPriority(int r100) {
        boolean r101 = false;
        if (r100 < 1) goto L5;
        boolean r102 = true;
    L6:
        com.google.common.base.m.e(r102, "Thread priority (%s) must be >= %s", r100, 1);
        if (r100 > 10) goto L9;
        r101 = true;
    L9:
        com.google.common.base.m.e(r101, "Thread priority (%s) must be <= %s", r100, 10);
        this.priority = Integer.valueOf(r100);
        return this;
    L5:
        r102 = false;
        goto L6
    }

    public ThreadFactoryBuilder setThreadFactory(ThreadFactory r100) {
        r100.getClass();
        this.backingThreadFactory = r100;
        return this;
    }

    public ThreadFactoryBuilder setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler r100) {
        r100.getClass();
        this.uncaughtExceptionHandler = r100;
        return this;
    }

    public static /* synthetic */ String access$000(String r100, Object[] r101) {
        return format(r100, r101);
    }

    private static String format(String r100, Object... r101) {
        return String.format(Locale.ROOT, r100, r101);
    }
}
