package com.larus.apm.api;

import android.app.Application;
import android.content.Context;
import ec9.d0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import p48.d;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0003H&¨\u0006\u0014"}, d2 = {"Lcom/larus/apm/api/INpth;", "", "init", "", "baseCtx", "Landroid/content/Context;", "registerCrashCallback", "crashCallback", "Lcom/larus/apm/api/ICrashCallback;", "stopUpload", "stop", "", "goUpload", "startNpthLifecycleRecorder", "app", "Landroid/app/Application;", "maxLifeCycleCount", "", "enableGwpAsan", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface INpth {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f286945a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f286946a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Lazy<INpth> f286947b = null;

        public a() {
        }

        static {
            f286946a = new a();
            f286947b = LazyKt.lazy(new d());
        }
    }

    static {
        f286945a = a.f286946a;
    }

    void a(Application r100, int r101);

    void b(d0 r100);

    void c(boolean r100);

    void d();

    void init(Context r100);
}
