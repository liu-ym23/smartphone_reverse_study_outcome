package com.ss.android.lark.appreciablelib;

import android.app.Application;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ss.texturerender.VideoSurfaceTexture;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 [2\u00020\u0001:\u0002[\\B\u0007¢\u0006\u0004\bY\u0010ZJ\b\u0010\u0003\u001a\u00020\u0002H\u0002JL\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2*\u0010\u000e\u001a&\u0012\"\u0012 \u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000b0\nH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002Jh\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015H\u0002J>\u0010!\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u001f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010&\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$J\u000e\u0010)\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'J@\u00100\u001a\u00020\f2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\f2\b\u0010/\u001a\u0004\u0018\u00010\f2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u0015H\u0007J2\u00100\u001a\u00020\f2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u0002012\b\u0010/\u001a\u0004\u0018\u00010\f2\b\b\u0002\u00102\u001a\u00020\"J\u0092\u0001\u00100\u001a\u00020\f2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u0002012\b\u0010/\u001a\u0004\u0018\u00010\f2\b\b\u0002\u00102\u001a\u00020\"2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015J\u009c\u0001\u00100\u001a\u00020\f2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u0002012\b\u0010/\u001a\u0004\u0018\u00010\f2\b\b\u0002\u00102\u001a\u00020\"2\b\b\u0002\u00104\u001a\u0002032\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015J&\u00106\u001a\u00020\u00022\u0006\u00105\u001a\u00020\f2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u0015H\u0007Jn\u00106\u001a\u00020\u00022\u0006\u00105\u001a\u00020\f2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015J&\u00107\u001a\u00020\u00022\u0006\u00105\u001a\u00020\f2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u0015H\u0007Jn\u00107\u001a\u00020\u00022\u0006\u00105\u001a\u00020\f2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015J&\u00108\u001a\u00020\u00022\u0006\u00105\u001a\u00020\f2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u0015H\u0007J\u000e\u00108\u001a\u00020\u00022\u0006\u00105\u001a\u00020\fJn\u00108\u001a\u00020\u00022\u0006\u00105\u001a\u00020\f2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015Jz\u00108\u001a\u00020\u00022\u0006\u00105\u001a\u00020\f2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015Jv\u0010\u0012\u001a\u00020\u00022\u0006\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020$2\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015J\u0016\u0010;\u001a\u00020\u00022\u0006\u00105\u001a\u00020\f2\u0006\u0010:\u001a\u00020\fJ\u0016\u0010<\u001a\u00020\u00022\u0006\u00105\u001a\u00020\f2\u0006\u0010:\u001a\u00020\fJ\u000e\u0010>\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020=R\u0018\u0010?\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010B\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010CR\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010GR\u0014\u0010J\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u001c\u0010L\u001a\b\u0012\u0004\u0012\u00020\f0\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010N\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010P\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR³\u0001\u0010S\u001a\u009e\u0001\u0012H\u0012F\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r R*\"\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u000b0\u000b R*N\u0012H\u0012F\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r R*\"\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u000b0\u000b\u0018\u00010\u001f0\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010MR\u0016\u0010T\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR \u0010W\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00130V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010X¨\u0006]"}, d2 = {"Lcom/ss/android/lark/appreciablelib/AppreciableKit;", "", "", "scheduleClean", "Ljava/util/concurrent/ScheduledExecutorService;", "threadPool", "Lxva/c;", "staticProxy", "Lxva/b;", "logProxy", "", "Lcom/ss/android/lark/appreciablelib/CacheEvent;", "", "Lorg/json/JSONObject;", "cacheEventSet", "sendCacheEvent", "Lxva/f;", "params", "timeCost", "Lxva/e;", "cache", "", "latencyDetail", "extra", "extraMetric", "extraCategory", "updateCacheExtra", "Landroid/app/Application;", "application", "Lxva/a;", "config", "", "logBlackListSet", "init", "", "isFront", "", VideoSurfaceTexture.KEY_TIME, "updateAppForegroundState", "Lcom/ss/android/lark/appreciablelib/NetStatus;", "netStatus", "updateNetState", "Lcom/ss/android/lark/appreciablelib/Biz;", "biz", "Lcom/ss/android/lark/appreciablelib/Scene;", "scene", "event", "page", "start", "Lcom/ss/android/lark/appreciablelib/Event;", "needNet", "", "version", "key", "pause", "resume", "end", "latency", "latencyDetailKey", "spanStart", "spanEnd", "Lcom/ss/android/lark/appreciablelib/ErrorParams;", "error", "mApplication", "Landroid/app/Application;", "Ljava/util/concurrent/atomic/AtomicLong;", "mStartupTimestamp", "Ljava/util/concurrent/atomic/AtomicLong;", "mEnterForegroundTimeStamp", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mIsInBackground", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mNeedReportToTea", "Ljava/util/concurrent/atomic/AtomicInteger;", "mNetStatus", "Ljava/util/concurrent/atomic/AtomicInteger;", "mLogBlackListSet", "Ljava/util/Set;", "mMonitorThreadPool", "Ljava/util/concurrent/ScheduledExecutorService;", "mLogProxy", "Lxva/b;", "kotlin.jvm.PlatformType", "mCachedEvent", "mStaticsProxy", "Lxva/c;", "Ljava/util/concurrent/ConcurrentHashMap;", "mTimeCostCaches", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "appreciablelib_release"}, k = 1, mv = {1, 4, 0})
public final class AppreciableKit {
    private static final long CACHE_CLEAN_INTERVAL = 120000;
    public static final Companion Companion = null;
    public static final String SPAN_SUFFIX = "#span_suffix#";
    private static final String TAG = "AppreciableKit";
    private volatile Application mApplication;
    private Set<CacheEvent<String, JSONObject, JSONObject, JSONObject>> mCachedEvent;
    private final AtomicLong mEnterForegroundTimeStamp;
    private final AtomicBoolean mIsInBackground;
    private Set<String> mLogBlackListSet;
    private xva.b mLogProxy;
    private ScheduledExecutorService mMonitorThreadPool;
    private final AtomicBoolean mNeedReportToTea;
    private final AtomicInteger mNetStatus;
    private final AtomicLong mStartupTimestamp;
    private xva.c mStaticsProxy;
    private final ConcurrentHashMap<String, xva.e> mTimeCostCaches;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/appreciablelib/AppreciableKit$Companion;", "", "()V", "CACHE_CLEAN_INTERVAL", "", "SPAN_SUFFIX", "", "TAG", "getInstance", "Lcom/ss/android/lark/appreciablelib/AppreciableKit;", "appreciablelib_release"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        public final AppreciableKit getInstance() {
            AppreciableKit r100 = a.f408919a;
            return a.f408919a;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AppreciableKit f408919a = null;

        static {
            f408919a = new AppreciableKit();
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppreciableKit f408920a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ErrorParams f408921b;

        public b(AppreciableKit r100, ErrorParams r101) {
            this.f408920a = r100;
            this.f408921b = r101;
        }

        public final void a() {
            int r100 = xva.d.f565191a;
            AppreciableKit.access$getMApplication$p(this.f408920a);
            ErrorParams r101 = this.f408921b;
            long r102 = AppreciableKit.access$getMStartupTimestamp$p(this.f408920a).get();
            long r103 = AppreciableKit.access$getMEnterForegroundTimeStamp$p(this.f408920a).get();
            boolean r104 = AppreciableKit.access$getMIsInBackground$p(this.f408920a).get();
            int r105 = AppreciableKit.access$getMNetStatus$p(this.f408920a).get();
            boolean r106 = AppreciableKit.access$getMNeedReportToTea$p(this.f408920a).get();
            AppreciableKit.access$getMLogBlackListSet$p(this.f408920a);
            xva.b r107 = AppreciableKit.access$getMLogProxy$p(this.f408920a);
            xva.c r110 = AppreciableKit.access$getMStaticsProxy$p(this.f408920a);
            HashMap r111 = new HashMap();
            r111.put("biz", Integer.valueOf(r101.getBiz().getValue()));
            r111.put("scene", Integer.valueOf(r101.getScene().getValue()));
            r111.put("page", r101.getPage());
            r111.put("version", Integer.valueOf(r101.getVersion()));
            r111.put("error_type", Integer.valueOf(r101.getErrorType().getValue()));
            r111.put(IOnekeyLoginService.ResponseConstants.NET_STATUS, Integer.valueOf(r105));
            r111.put("need_net", r101.getNeedNet());
            JSONObject r108 = new JSONObject(r111);
            HashMap r112 = new HashMap();
            Event r113 = r101.getEvent();
            if (r113 == null) goto L5;
            String r114 = r113.name();
        L6:
            r112.put("event", r114);
            r112.put("error_message", r101.getErrorMessage());
            r112.put("error_code", Integer.valueOf(r101.getErrorCode()));
            r112.put("error_status", Integer.valueOf(r101.getErrorStatus()));
            r112.put("level", Integer.valueOf(r101.getErrorLevel().getValue()));
            r112.put("user_action", r101.getUserAction());
            JSONObject r115 = new JSONObject(r112);
            HashMap r116 = new HashMap();
            r116.put("since_latest_startup", Long.valueOf(System.currentTimeMillis() - r102));
            r116.put("since_latest_enter_foreground", Long.valueOf(System.currentTimeMillis() - r103));
            JSONObject r109 = new JSONObject();
            Map<String, Object> r117 = r101.getExtra();
            if (r117 == null) goto L9;
            r116.putAll(r117);
        L9:
            Iterator r118 = r116.entrySet().iterator();
        L11:
            if (r118.hasNext() == false) goto L13;
            Map.Entry r119 = (Map.Entry) r118.next();
            r109.put((String) r119.getKey(), r119.getValue());
            goto L11
        L13:
            Map<String, Object> r120 = r101.getExtraMetric();
            if (r120 != null) goto L16;
        L18:
            HashMap r121 = new HashMap();
            r121.put("is_in_background", Boolean.valueOf(r104));
            Map<String, Object> r122 = r101.getExtraCategory();
            if (r122 == null) goto L21;
            r121.putAll(r122);
        L21:
            r109.put("category", new JSONObject(r121));
            if (r106 == false) goto L43;
            StringBuilder r123 = new StringBuilder("appr_error_");
            Event r124 = r101.getEvent();
            if (r124 == null) goto L26;
            String r125 = r124.name();
        L27:
            r123.append(r125);
            String r126 = r123.toString();
            LinkedHashMap r127 = new LinkedHashMap();
            r127.putAll(r111);
            r112.remove("event");
            r127.putAll(r112);
            r127.putAll(r116);
            Map<String, Object> r128 = r101.getExtraMetric();
            if (r128 != null) goto L30;
        L32:
            r127.putAll(r121);
            JSONObject r129 = new JSONObject();
            LinkedHashMap r130 = new LinkedHashMap();
            Iterator r131 = r127.entrySet().iterator();
        L34:
            if (r131.hasNext() == false) goto L38;
            Map.Entry r132 = (Map.Entry) r131.next();
            if ((!TextUtils.isEmpty((CharSequence) r132.getKey())) == false) goto L34;
            r130.put(r132.getKey(), r132.getValue());
            goto L34
        L38:
            Iterator r133 = r130.entrySet().iterator();
        L40:
            if (r133.hasNext() == false) goto L42;
            Map.Entry r134 = (Map.Entry) r133.next();
            r129.put((String) r134.getKey(), r134.getValue());
            goto L40
        L42:
            r110.a(r126, r129);
            r107.d("MonitorEvent", "appreciable_log:error:tea:" + r126 + ", params size:" + r127.size());
            goto L43
        L30:
            if ((!r128.isEmpty()) == false) goto L32;
            r127.putAll(r128);
            goto L32
        L26:
            r125 = null;
        L43:
            JSONObject r135 = new JSONObject();
            r135.put("extra", r109);
            r110.b("appreciable_error", r108, r115, r135);
            r107.i("MonitorEvent", "appreciable_log:error:" + r101.getEvent() + ':' + r101.getBiz().name() + ':' + r101.getScene().name() + ':' + r101.getErrorCode() + ':' + r101.getErrorLevel().name() + ':' + r101.getNeedNet() + "=>[errorMessage=" + r101.getErrorMessage() + "][userAction=" + r101.getUserAction() + "][metric=[" + r115 + "]][category=[" + r108 + "]][extra=[" + r109 + "]]");
            return;
        L16:
            if ((!r120.isEmpty()) == false) goto L18;
            r109.put("metric", new JSONObject(r120));
            goto L18
        L5:
            r114 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements xva.b {
        public c() {
        }

        @Override // xva.b
        public final void d(String r100, String r101) {
        }

        @Override // xva.b
        public final void e(String r100, Throwable r101) {
        }

        @Override // xva.b
        public final void i(String r100, String r101) {
        }
    }

    public static final class d implements xva.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppreciableKit f408922a;

        public d(AppreciableKit r100) {
            this.f408922a = r100;
        }

        @Override // xva.c
        public final void a(String r100, JSONObject r110) {
            AppreciableKit.access$getMCachedEvent$p(this.f408922a).add(new CacheEvent(r100, r110, null, null, true));
        }

        @Override // xva.c
        public final void b(String r110, JSONObject r111, JSONObject r112, JSONObject r113) {
            if (r110 == null) goto L5;
            AppreciableKit.access$getMCachedEvent$p(this.f408922a).add(new CacheEvent(r110, r111, r112, r113, false, 16, null));
            return;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppreciableKit f408923a;

        public e(AppreciableKit r100) {
            this.f408923a = r100;
        }

        public final void a() {
            long r100 = System.currentTimeMillis();
            AppreciableKit.access$getMLogProxy$p(this.f408923a).i(AppreciableKit.TAG, "start clean, time is: " + r100);
            long r101 = r100 - 120000;
            Iterator r102 = AppreciableKit.access$getMTimeCostCaches$p(this.f408923a).entrySet().iterator();
            StringBuilder r103 = new StringBuilder();
        L4:
            if (r102.hasNext() == false) goto L8;
            Map.Entry r104 = (Map.Entry) r102.next();
            if (((xva.e) r104.getValue()).f565193b >= r101) goto L4;
            r102.remove();
            r103.append((String) r104.getKey());
            r103.append(",");
            goto L4
        L8:
            AppreciableKit.access$getMLogProxy$p(this.f408923a).i(AppreciableKit.TAG, "cache is out of date, key is: " + r103);
            AppreciableKit.access$scheduleClean(this.f408923a);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Set f408924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ xva.c f408925b;

        public f(Set r100, xva.c r101) {
            this.f408924a = r100;
            this.f408925b = r101;
        }

        public final void a() {
            Iterator r100 = this.f408924a.iterator();
        L4:
            if (r100.hasNext() == false) goto L9;
            CacheEvent r101 = (CacheEvent) r100.next();
            if (r101.isTeaEvent() == true) goto L7;
            this.f408925b.b((String) r101.getFirst(), (JSONObject) r101.getSecond(), (JSONObject) r101.getThird(), (JSONObject) r101.getForth());
            goto L4
        L7:
            this.f408925b.a((String) r101.getFirst(), (JSONObject) r101.getSecond());
            goto L4
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppreciableKit f408926a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ xva.f f408927b;

        public g(AppreciableKit r100, xva.f r101) {
            this.f408926a = r100;
            this.f408927b = r101;
        }

        public final void a() {
            int r100 = xva.d.f565191a;
            AppreciableKit.access$getMApplication$p(this.f408926a);
            xva.f r101 = this.f408927b;
            long r102 = AppreciableKit.access$getMStartupTimestamp$p(this.f408926a).get();
            long r103 = AppreciableKit.access$getMEnterForegroundTimeStamp$p(this.f408926a).get();
            int r104 = AppreciableKit.access$getMNetStatus$p(this.f408926a).get();
            boolean r105 = AppreciableKit.access$getMNeedReportToTea$p(this.f408926a).get();
            Set r106 = AppreciableKit.access$getMLogBlackListSet$p(this.f408926a);
            xva.b r107 = AppreciableKit.access$getMLogProxy$p(this.f408926a);
            xva.c r110 = AppreciableKit.access$getMStaticsProxy$p(this.f408926a);
            HashMap r111 = new HashMap();
            r111.put("biz", Integer.valueOf(r101.f565195a.getValue()));
            r111.put("scene", Integer.valueOf(r101.f565196b.getValue()));
            r111.put("page", r101.f565199e);
            r111.put("version", Integer.valueOf(r101.f565201g));
            r111.put("need_net", Boolean.valueOf(r101.f565200f));
            r111.put(IOnekeyLoginService.ResponseConstants.NET_STATUS, Integer.valueOf(r104));
            JSONObject r108 = new JSONObject(r111);
            HashMap r112 = new HashMap();
            r112.put("latency", Long.valueOf(r101.f565198d));
            r112.put("event", r101.f565197c);
            JSONObject r113 = new JSONObject(r112);
            ConcurrentHashMap<String, Object> r114 = r101.f565205k;
            LinkedHashMap r109 = new LinkedHashMap();
            Iterator<Map.Entry<String, Object>> r115 = r114.entrySet().iterator();
        L3:
            Set r116 = r106;
            if (r115.hasNext() == false) goto L9;
            Map.Entry<String, Object> r117 = r115.next();
            Iterator<Map.Entry<String, Object>> r118 = r115;
            JSONObject r210 = r108;
            xva.b r211 = r107;
            xva.c r212 = r110;
            if ((!StringsKt.endsWith$default(r117.getKey(), AppreciableKit.SPAN_SUFFIX, false, 2, null)) == false) goto L8;
            r109.put(r117.getKey(), r117.getValue());
        L8:
            r106 = r116;
            r115 = r118;
            r108 = r210;
            r107 = r211;
            r110 = r212;
            goto L3
        L9:
            JSONObject r213 = r108;
            xva.b r214 = r107;
            xva.c r215 = r110;
            boolean r119 = false;
            r113.put("latency_detail", new JSONObject(r109));
            JSONObject r120 = new JSONObject(r101.f565206l);
            HashMap r121 = new HashMap();
            r121.put("since_latest_startup", Long.valueOf(System.currentTimeMillis() - r102));
            r121.put("since_latest_enter_foreground", Long.valueOf(System.currentTimeMillis() - r103));
            r121.put("background_time", Long.valueOf(r101.f565203i));
            Iterator r122 = r121.entrySet().iterator();
        L11:
            if (r122.hasNext() == false) goto L13;
            Map.Entry r123 = (Map.Entry) r122.next();
            r120.put((String) r123.getKey(), r123.getValue());
            goto L11
        L13:
            ConcurrentHashMap<String, Object> r124 = r101.f565207m;
            if (r124 != null) goto L16;
        L18:
            ConcurrentHashMap<String, Object> r125 = r101.f565208n;
            if (r101.f565203i <= 0) goto L21;
            r119 = true;
        L21:
            r125.put("is_in_background", Boolean.valueOf(r119));
            ConcurrentHashMap<String, Object> r126 = r101.f565208n;
            if (r126 == null) goto L27;
            if ((!r126.isEmpty()) == false) goto L27;
            r120.put("category", new JSONObject(r126));
        L27:
            if (r105 == false) goto L39;
            String r127 = "appr_time_" + r101.f565197c;
            LinkedHashMap r128 = new LinkedHashMap();
            r128.putAll(r111);
            r112.remove("event");
            r128.putAll(r112);
            r128.putAll(r109);
            r128.putAll(r121);
            r128.putAll(r101.f565206l);
            r128.putAll(r101.f565207m);
            r128.putAll(r101.f565208n);
            JSONObject r129 = new JSONObject();
            LinkedHashMap r130 = new LinkedHashMap();
            Iterator r131 = r128.entrySet().iterator();
        L30:
            if (r131.hasNext() == false) goto L34;
            Map.Entry r132 = (Map.Entry) r131.next();
            if ((!TextUtils.isEmpty((CharSequence) r132.getKey())) == false) goto L30;
            r130.put(r132.getKey(), r132.getValue());
            goto L30
        L34:
            Iterator r133 = r130.entrySet().iterator();
        L36:
            if (r133.hasNext() == false) goto L38;
            Map.Entry r134 = (Map.Entry) r133.next();
            r129.put((String) r134.getKey(), r134.getValue());
            goto L36
        L38:
            xva.c r135 = r215;
            r135.a(r127, r129);
            xva.b r136 = r214;
            r136.d("MonitorEvent", "appreciable_log:latency:tea:" + r127 + ", params size:" + r128.size());
        L40:
            JSONObject r137 = new JSONObject();
            r137.put("extra", r120);
            r135.b("appreciable_loading_time", r213, r113, r137);
            if (r116.contains(r101.f565197c) == true) goto L54;
            r136.i("MonitorEvent", "appreciable_log:latency:" + r101.f565197c + ':' + r101.f565195a.name() + ':' + r101.f565196b.name() + ':' + r101.f565199e + "=>[latency=" + r101.f565198d + "][latency_detail=[" + r113.get("latency_detail") + "]][category=[" + r213 + "]][extra=[" + r120 + "]]");
            return;
        L54:
            return;
        L39:
            r136 = r214;
            r135 = r215;
            goto L40
        L16:
            if ((!r124.isEmpty()) == false) goto L18;
            r120.put("metric", new JSONObject(r124));
            goto L18
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final AppreciableKit getInstance() {
        return Companion.getInstance();
    }

    private final void scheduleClean() {
        this.mLogProxy.i(TAG, "schedule clean, time is: " + System.currentTimeMillis());
        this.mMonitorThreadPool.schedule(new e(this), 120000, TimeUnit.MILLISECONDS);
    }

    public AppreciableKit() {
        this.mStartupTimestamp = new AtomicLong(0);
        this.mEnterForegroundTimeStamp = new AtomicLong(0);
        this.mIsInBackground = new AtomicBoolean(false);
        this.mNeedReportToTea = new AtomicBoolean(false);
        this.mNetStatus = new AtomicInteger(NetStatus.EVALUATING.getValue());
        this.mLogBlackListSet = new HashSet();
        this.mMonitorThreadPool = new PThreadScheduledThreadPoolExecutor(1, new DefaultThreadFactory("ppreciableKit"));
        this.mLogProxy = new c();
        this.mCachedEvent = Collections.synchronizedSet(new HashSet());
        this.mStaticsProxy = new d(this);
        this.mTimeCostCaches = new ConcurrentHashMap();
    }

    public static final /* synthetic */ Application access$getMApplication$p(AppreciableKit r100) {
        return r100.mApplication;
    }

    public static final /* synthetic */ Set access$getMCachedEvent$p(AppreciableKit r100) {
        return r100.mCachedEvent;
    }

    public static final /* synthetic */ AtomicLong access$getMEnterForegroundTimeStamp$p(AppreciableKit r100) {
        return r100.mEnterForegroundTimeStamp;
    }

    public static final /* synthetic */ AtomicBoolean access$getMIsInBackground$p(AppreciableKit r100) {
        return r100.mIsInBackground;
    }

    public static final /* synthetic */ Set access$getMLogBlackListSet$p(AppreciableKit r100) {
        return r100.mLogBlackListSet;
    }

    public static final /* synthetic */ xva.b access$getMLogProxy$p(AppreciableKit r100) {
        return r100.mLogProxy;
    }

    public static final /* synthetic */ AtomicBoolean access$getMNeedReportToTea$p(AppreciableKit r100) {
        return r100.mNeedReportToTea;
    }

    public static final /* synthetic */ AtomicInteger access$getMNetStatus$p(AppreciableKit r100) {
        return r100.mNetStatus;
    }

    public static final /* synthetic */ AtomicLong access$getMStartupTimestamp$p(AppreciableKit r100) {
        return r100.mStartupTimestamp;
    }

    public static final /* synthetic */ xva.c access$getMStaticsProxy$p(AppreciableKit r100) {
        return r100.mStaticsProxy;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getMTimeCostCaches$p(AppreciableKit r100) {
        return r100.mTimeCostCaches;
    }

    public static final /* synthetic */ void access$scheduleClean(AppreciableKit r100) {
        r100.scheduleClean();
    }

    private final void timeCost(xva.f r100) {
        g r101 = new g(this, r100);
        this.mMonitorThreadPool.execute(r101);
    }

    public final void end(String r100) {
        end(r100, null, null, null, null);
    }

    public final void error(ErrorParams r100) {
        b r101 = new b(this, r100);
        this.mMonitorThreadPool.execute(r101);
    }

    public final void updateNetState(NetStatus r100) {
        this.mNetStatus.set(r100.getValue());
    }

    public static final /* synthetic */ void access$setMApplication$p(AppreciableKit r100, Application r101) {
        r100.mApplication = r101;
    }

    public static final /* synthetic */ void access$setMCachedEvent$p(AppreciableKit r100, Set r101) {
        r100.mCachedEvent = r101;
    }

    public static final /* synthetic */ void access$setMLogBlackListSet$p(AppreciableKit r100, Set r101) {
        r100.mLogBlackListSet = r101;
    }

    public static final /* synthetic */ void access$setMLogProxy$p(AppreciableKit r100, xva.b r101) {
        r100.mLogProxy = r101;
    }

    public static final /* synthetic */ void access$setMStaticsProxy$p(AppreciableKit r100, xva.c r101) {
        r100.mStaticsProxy = r101;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "格式更新 https://bytedance.feishu.cn/docs/doccnxWkTEi4U8Yx6dZdSGFdKkd", replaceWith = @ReplaceWith(expression = "\"replace with end(String, Map<String, String>?, Map<String, String>?, Map<String, String>?\"", imports = {}))
    public final void end(String r100, Map<String, String> r101) {
        xva.e r102 = this.mTimeCostCaches.get(r100);
        if (r102 == null) goto L9;
        updateCacheExtra(r102, null, r101, null, null);
        if (r102.f565194c == CacheStatus.PAUSED) goto L7;
        r102.f565192a.f565198d += System.currentTimeMillis() - r102.f565193b;
    L7:
        timeCost(r102.f565192a);
        this.mTimeCostCaches.remove(r100);
        r102.f565194c = CacheStatus.END;
        return;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "格式更新 https://bytedance.feishu.cn/docs/doccnxWkTEi4U8Yx6dZdSGFdKkd", replaceWith = @ReplaceWith(expression = "\"replace with pause(String, Map<String, String>?, Map<String, String>?, Map<String, String>?\"", imports = {}))
    public final void pause(String r100, Map<String, String> r101) {
        xva.e r102 = this.mTimeCostCaches.get(r100);
        if (r102 == null) goto L9;
        updateCacheExtra(r102, null, r101, null, null);
        CacheStatus r103 = r102.f565194c;
        CacheStatus r104 = CacheStatus.PAUSED;
        if (r103 == r104) goto L7;
        r102.f565192a.f565198d += System.currentTimeMillis() - r102.f565193b;
    L7:
        r102.f565194c = r104;
        return;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "格式更新 https://bytedance.feishu.cn/docs/doccnxWkTEi4U8Yx6dZdSGFdKkd", replaceWith = @ReplaceWith(expression = "\"replace with resume(String, Map<String, String>?, Map<String, String>?, Map<String, String>?\"", imports = {}))
    public final void resume(String r100, Map<String, String> r101) {
        xva.e r102 = this.mTimeCostCaches.get(r100);
        if (r102 == null) goto L9;
        updateCacheExtra(r102, null, r101, null, null);
        CacheStatus r103 = r102.f565194c;
        CacheStatus r104 = CacheStatus.PAUSED;
        if (r103 == r104) goto L7;
        r102.f565192a.f565198d += System.currentTimeMillis() - r102.f565193b;
    L7:
        r102.f565194c = r104;
        return;
    }

    public final void spanEnd(String r100, String r101) {
        xva.e r102 = this.mTimeCostCaches.get(r100);
        if (r102 == null) goto L10;
        Object r103 = r102.f565192a.f565205k.get(r101 + SPAN_SUFFIX);
        ConcurrentHashMap<String, Object> r104 = r102.f565192a.f565205k;
        if ((r103 instanceof Long) == false) goto L7;
        long r105 = System.currentTimeMillis();
        long r106 = ((Number) r103).longValue();
    L8:
        r104.put(r101, Long.valueOf(r105 - r106));
        r102.f565192a.f565205k.remove(r101 + SPAN_SUFFIX);
        return;
    L7:
        r105 = System.currentTimeMillis();
        r106 = r102.f565193b;
        goto L8
    }

    public final void spanStart(String r100, String r101) {
        xva.e r102 = this.mTimeCostCaches.get(r100);
        if (r102 == null) goto L6;
        updateCacheExtra(r102, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r101 + SPAN_SUFFIX, Long.valueOf(System.currentTimeMillis()))}), null, null, null);
        return;
    }

    public final void updateAppForegroundState(boolean r100, long r101) {
        if (r100 == false) goto L4;
        this.mEnterForegroundTimeStamp.set(r101);
    L4:
        this.mIsInBackground.set(!r100);
        Iterator<Map.Entry<String, xva.e>> r102 = this.mTimeCostCaches.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L12;
        Map.Entry<String, xva.e> r103 = r102.next();
        xva.f r104 = r103.getValue().f565192a;
        if (r100 == false) goto L10;
        r104.f565203i += r101 - r104.f565202h;
    L11:
        r104.f565204j = !r100;
        this.mLogProxy.d(TAG, "updateAppForegroundState：" + r103.getKey() + HTTP.URL_DEFAULT + r104.f565203i + HTTP.URL_DEFAULT + r104.f565204j);
        goto L6
    L10:
        r104.f565202h = r101;
        goto L11
    }

    private final void sendCacheEvent(ScheduledExecutorService r100, xva.c r101, xva.b r102, Set<CacheEvent<String, JSONObject, JSONObject, JSONObject>> r103) {
        r102.i(TAG, "sendCacheEvent:" + r103.size());
        r100.execute(new f(r103, r101));
        r103.clear();
    }

    private final void updateCacheExtra(xva.e r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102, Map<String, ? extends Object> r103, Map<String, ? extends Object> r104) {
        if (r101 != null) goto L15;
    L6:
        if (r102 == null) goto L8;
        r100.f565192a.f565206l.putAll(r102);     // Catch: Exception -> L4
    L8:
        if (r103 == null) goto L10;
        r100.f565192a.f565207m.putAll(r103);     // Catch: Exception -> L4
    L10:
        if (r104 == null) goto L17;
        r100.f565192a.f565208n.putAll(r104);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        this.mLogProxy.e(r100.f565192a.f565197c + " error!", e);
        return;
    L17:
        return;
    L15:
        r100.f565192a.f565205k.putAll(r101);     // Catch: Exception -> L4
        goto L6
    }

    public final void end(String r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r110, Map<String, ? extends Object> r111, Map<String, ? extends Object> r112) {
        end(r100, null, r101, r110, r111, r112);
    }

    public final void pause(String r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102, Map<String, ? extends Object> r110, Map<String, ? extends Object> r111) {
        xva.e r103 = this.mTimeCostCaches.get(r100);
        if (r103 == null) goto L9;
        updateCacheExtra(r103, r101, r102, r110, r111);
        CacheStatus r104 = r103.f565194c;
        CacheStatus r105 = CacheStatus.PAUSED;
        if (r104 == r105) goto L7;
        r103.f565192a.f565198d += System.currentTimeMillis() - r103.f565193b;
    L7:
        r103.f565194c = r105;
        return;
    }

    public final void resume(String r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102, Map<String, ? extends Object> r110, Map<String, ? extends Object> r111) {
        xva.e r103 = this.mTimeCostCaches.get(r100);
        if (r103 == null) goto L9;
        updateCacheExtra(r103, r101, r102, r110, r111);
        if (r103.f565194c != CacheStatus.PAUSED) goto L7;
        r103.f565193b = System.currentTimeMillis();
    L7:
        r103.f565194c = CacheStatus.RESUMED;
        return;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "格式更新 https://bytedance.feishu.cn/docs/doccnxWkTEi4U8Yx6dZdSGFdKkd", replaceWith = @ReplaceWith(expression = "\"replace with start(Biz, Scene, String, String?, Map<String, String>?, Map<String, String>?, Map<String, String>?\"", imports = {}))
    public final String start(Biz r110, Scene r111, String r112, String r210, Map<String, String> r211) {
        String r100 = UUID.randomUUID().toString();
        xva.e r101 = new xva.e(new xva.f(r110, r111, r112, r210, false, 0, 16320), System.currentTimeMillis(), CacheStatus.STARTED);
        updateCacheExtra(r101, null, r211, null, null);
        this.mTimeCostCaches.put(r100, r101);
        return r100;
    }

    public final String start(Biz r110, Scene r111, Event r112, String r113, boolean r114) {
        return start(r110, r111, r112, r113, r114, null, null, null, null);
    }

    public final void end(String r100, String r101, Map<String, ? extends Object> r110, Map<String, ? extends Object> r111, Map<String, ? extends Object> r112, Map<String, ? extends Object> r113) {
        xva.e r102 = this.mTimeCostCaches.get(r100);
        if (r102 == null) goto L18;
        updateCacheExtra(r102, r110, r111, r112, r113);
        long r114 = System.currentTimeMillis();
        if (r102.f565194c == CacheStatus.PAUSED) goto L7;
        r102.f565192a.f565198d += r114 - r102.f565193b;
    L7:
        xva.f r115 = r102.f565192a;
        boolean r116 = r115.f565204j;
        long r103 = r115.f565202h;
        if (r103 <= 0) goto L10;
        boolean r104 = true;
    L12:
        if ((r116 & r104) == false) goto L14;
        r115.f565203i += r114 - r103;
    L14:
        if (r101 == null) goto L16;
        r115.f565199e = r101;
    L16:
        timeCost(r115);
        this.mTimeCostCaches.remove(r100);
        r102.f565194c = CacheStatus.END;
        return;
    L10:
        r104 = false;
        goto L12
    }

    public final void init(Application r100, xva.a r101, ScheduledExecutorService r102, Set<String> r103, xva.b r104, xva.c r105) {
        this.mApplication = r100;
        this.mStartupTimestamp.set(r101.f565189a);
        this.mEnterForegroundTimeStamp.set(r101.f565189a);
        this.mNeedReportToTea.set(r101.f565190b);
        this.mMonitorThreadPool = r102;
        if (r103 == null) goto L5;
        this.mLogBlackListSet = r103;
    L5:
        this.mLogProxy = r104;
        this.mStaticsProxy = r105;
        sendCacheEvent(r102, r105, r104, this.mCachedEvent);
        scheduleClean();
    }

    public final void timeCost(String r100, long r101, Map<String, ? extends Object> r110, Map<String, ? extends Object> r111, Map<String, ? extends Object> r112, Map<String, ? extends Object> r113) {
        xva.e r102 = this.mTimeCostCaches.get(r100);
        if (r102 == null) goto L13;
        updateCacheExtra(r102, r110, r111, r112, r113);
        long r114 = System.currentTimeMillis();
        xva.f r115 = r102.f565192a;
        boolean r116 = r115.f565204j;
        long r103 = r115.f565202h;
        if (r103 <= 0) goto L7;
        boolean r104 = true;
    L9:
        if ((r116 & r104) == false) goto L11;
        r115.f565203i += r114 - r103;
    L11:
        r115.f565198d = r101;
        timeCost(r115);
        this.mTimeCostCaches.remove(r100);
        r102.f565194c = CacheStatus.END;
        return;
    L7:
        r104 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void end$default(AppreciableKit r100, String r101, Map r102, Map r110, Map r111, Map r112, int r113, Object r114) {
        if ((r113 & 2) == 0) goto L5;
        Map r103 = null;
    L7:
        if ((r113 & 4) == 0) goto L9;
        Map r104 = null;
    L11:
        if ((r113 & 8) == 0) goto L13;
        Map r105 = null;
    L15:
        if ((r113 & 16) == 0) goto L17;
        Map r106 = null;
    L18:
        r100.end(r101, r103, r104, r105, r106);
        return;
    L17:
        r106 = r112;
        goto L18
    L13:
        r105 = r111;
        goto L15
    L9:
        r104 = r110;
        goto L11
    L5:
        r103 = r102;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void pause$default(AppreciableKit r100, String r101, Map r102, Map r110, Map r111, Map r112, int r113, Object r114) {
        if ((r113 & 2) == 0) goto L5;
        Map r103 = null;
    L7:
        if ((r113 & 4) == 0) goto L9;
        Map r104 = null;
    L11:
        if ((r113 & 8) == 0) goto L13;
        Map r105 = null;
    L15:
        if ((r113 & 16) == 0) goto L17;
        Map r106 = null;
    L18:
        r100.pause(r101, r103, r104, r105, r106);
        return;
    L17:
        r106 = r112;
        goto L18
    L13:
        r105 = r111;
        goto L15
    L9:
        r104 = r110;
        goto L11
    L5:
        r103 = r102;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void resume$default(AppreciableKit r100, String r101, Map r102, Map r110, Map r111, Map r112, int r113, Object r114) {
        if ((r113 & 2) == 0) goto L5;
        Map r103 = null;
    L7:
        if ((r113 & 4) == 0) goto L9;
        Map r104 = null;
    L11:
        if ((r113 & 8) == 0) goto L13;
        Map r105 = null;
    L15:
        if ((r113 & 16) == 0) goto L17;
        Map r106 = null;
    L18:
        r100.resume(r101, r103, r104, r105, r106);
        return;
    L17:
        r106 = r112;
        goto L18
    L13:
        r105 = r111;
        goto L15
    L9:
        r104 = r110;
        goto L11
    L5:
        r103 = r102;
        goto L7
    }

    public static /* synthetic */ String start$default(AppreciableKit r100, Biz r101, Scene r102, Event r103, String r110, boolean r111, int r112, Object r113) {
        if ((r112 & 16) == 0) goto L5;
        boolean r104 = false;
    L7:
        return r100.start(r101, r102, r103, r110, r104);
    L5:
        r104 = r111;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void end$default(AppreciableKit r100, String r101, String r102, Map r103, Map r110, Map r111, Map r112, int r113, Object r114) {
        Map r104 = null;
        if ((r113 & 2) == 0) goto L5;
        String r105 = null;
    L7:
        if ((r113 & 4) == 0) goto L9;
        Map r106 = null;
    L11:
        if ((r113 & 8) == 0) goto L13;
        Map r107 = null;
    L15:
        if ((r113 & 16) == 0) goto L17;
        Map r108 = null;
    L19:
        if ((r113 & 32) != 0) goto L22;
        r104 = r112;
    L22:
        r100.end(r101, r105, r106, r107, r108, r104);
        return;
    L17:
        r108 = r111;
        goto L19
    L13:
        r107 = r110;
        goto L15
    L9:
        r106 = r103;
        goto L11
    L5:
        r105 = r102;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void timeCost$default(AppreciableKit r110, String r111, long r112, Map r113, Map r114, Map r115, Map r116, int r117, Object r118) {
        if ((r117 & 4) == 0) goto L5;
        Map r100 = null;
    L7:
        if ((r117 & 8) == 0) goto L9;
        Map r101 = null;
    L11:
        if ((r117 & 16) == 0) goto L13;
        Map r102 = null;
    L15:
        if ((r117 & 32) == 0) goto L17;
        Map r103 = null;
    L18:
        r110.timeCost(r111, r112, r100, r101, r102, r103);
        return;
    L17:
        r103 = r116;
        goto L18
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }

    public final String start(Biz r110, Scene r111, Event r112, String r113, boolean r114, Map<String, ? extends Object> r115, Map<String, ? extends Object> r116, Map<String, ? extends Object> r117, Map<String, ? extends Object> r210) {
        return start(r110, r111, r112, r113, r114, 1, r115, r116, r117, r210);
    }

    public final String start(Biz r110, Scene r111, Event r112, String r113, boolean r114, int r115, Map<String, ? extends Object> r116, Map<String, ? extends Object> r117, Map<String, ? extends Object> r210, Map<String, ? extends Object> r211) {
        String r100 = UUID.randomUUID().toString();
        xva.e r101 = new xva.e(new xva.f(r110, r111, r112.name(), r113, r114, r115, 16256), System.currentTimeMillis(), CacheStatus.STARTED);
        updateCacheExtra(r101, r116, r117, r210, r211);
        this.mTimeCostCaches.put(r100, r101);
        return r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String start$default(AppreciableKit r110, Biz r111, Scene r112, Event r113, String r114, boolean r115, Map r116, Map r117, Map r210, Map r211, int r212, Object r213) {
        if ((r212 & 16) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r212 & 32) == 0) goto L9;
        Map r101 = null;
    L11:
        if ((r212 & 64) == 0) goto L13;
        Map r102 = null;
    L15:
        if ((r212 & 128) == 0) goto L17;
        Map r118 = null;
    L19:
        if ((r212 & 256) == 0) goto L21;
        Map r119 = null;
    L23:
        return r110.start(r111, r112, r113, r114, r100, r101, r102, r118, r119);
    L21:
        r119 = r211;
        goto L23
    L17:
        r118 = r210;
        goto L19
    L13:
        r102 = r117;
        goto L15
    L9:
        r101 = r116;
        goto L11
    L5:
        r100 = r115;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String start$default(AppreciableKit r110, Biz r111, Scene r112, Event r113, String r114, boolean r115, int r116, Map r210, Map r211, Map r212, Map r213, int r214, Object r215) {
        if ((r214 & 16) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r214 & 32) == 0) goto L9;
        int r101 = 1;
    L11:
        if ((r214 & 64) == 0) goto L13;
        Map r102 = null;
    L15:
        if ((r214 & 128) == 0) goto L17;
        Map r117 = null;
    L19:
        if ((r214 & 256) == 0) goto L21;
        Map r118 = null;
    L23:
        if ((r214 & 512) == 0) goto L25;
        Map r119 = null;
    L27:
        return r110.start(r111, r112, r113, r114, r100, r101, r102, r117, r118, r119);
    L25:
        r119 = r213;
        goto L27
    L21:
        r118 = r212;
        goto L23
    L17:
        r117 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r116;
        goto L11
    L5:
        r100 = r115;
        goto L7
    }
}
