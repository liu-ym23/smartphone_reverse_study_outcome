package com.larus.common.mssdk.api;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import r09.b;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\bg\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0007H&J\b\u0010\u0010\u001a\u00020\u0007H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0007H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\u0014\u001a\u00020\u0007H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&¨\u0006\u0017"}, d2 = {"Lcom/larus/common/mssdk/api/ISecPrivacyService;", "", "initPrivacy", "", "base", "Landroid/content/Context;", "isPrivacyProcess", "", "updateIsFirstStartMark", "isFirstStart", "registerPrivacyReceiver", PerfLog.PARAM_KEY_CONTEXT_ID, "checkFirstStartAsyncTaskInit", "taskName", "", "isFirstInstallStarting", "checkAgreed", "notifyAgree", "result", "sendKillMySelfBroadcast", "privacyNotifyStartEventDelay", "privacyUpdateIsFirstStartMark", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ISecPrivacyService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f326368a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f326369a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Lazy<ISecPrivacyService> f326370b = null;

        public a() {
        }

        static {
            f326369a = new a();
            f326370b = LazyKt.lazy(new b());
        }

        public static ISecPrivacyService a() {
            return f326370b.getValue();
        }
    }

    static {
        f326368a = a.f326369a;
    }

    boolean a();

    void b(Context r100);

    void c(Context r100);

    void d();

    void e();

    boolean f(String r100);

    void g(Context r100);

    boolean h();

    void i(boolean r100);

    boolean j();
}
