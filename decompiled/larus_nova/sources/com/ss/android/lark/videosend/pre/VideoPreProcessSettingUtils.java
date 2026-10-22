package com.ss.android.lark.videosend.pre;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes38.dex */
public final class VideoPreProcessSettingUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PreConfig f444961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f444962b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f444963c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f444964d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f444965e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f444966f = null;

    public VideoPreProcessSettingUtils() {
    }

    static {
        f444962b = LazyKt.lazy(VideoPreProcessSettingUtils$preProcessRemoteSetting$2.INSTANCE);
        f444963c = LazyKt.lazy(VideoPreProcessSettingUtils$preConfig$2.INSTANCE);
        f444964d = LazyKt.lazy(VideoPreProcessSettingUtils$filterConfig$2.INSTANCE);
        f444965e = LazyKt.lazy(VideoPreProcessSettingUtils$preCompressConfig$2.INSTANCE);
        f444966f = LazyKt.lazy(VideoPreProcessSettingUtils$preRawConfig$2.INSTANCE);
    }
}
