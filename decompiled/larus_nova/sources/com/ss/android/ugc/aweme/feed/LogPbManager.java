package com.ss.android.ugc.aweme.feed;

import com.google.gson.Gson;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/feed/LogPbManager;", "", "<init>", "()V", "Companion", "SingletonHolder", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LogPbManager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f450809c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f450810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Gson f450811b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/feed/LogPbManager$Companion;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        public static LogPbManager a() {
            SingletonHolder.f450813b.getClass();
            return SingletonHolder.f450812a;
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/feed/LogPbManager$SingletonHolder;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SingletonHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LogPbManager f450812a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final SingletonHolder f450813b = null;

        private SingletonHolder() {
        }

        static {
            f450813b = new SingletonHolder();
            f450812a = new LogPbManager();
        }
    }

    static {
        f450809c = new Companion(0);
    }

    public LogPbManager() {
        this.f450810a = new ConcurrentHashMap();
        new ConcurrentHashMap();
        this.f450811b = new Gson();
    }
}
