package d2b;

import android.text.TextUtils;
import com.larksuite.framework.thread.n;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.HashMap;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<String, a> f466576c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f466577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f466578b;

    /* JADX INFO: renamed from: d2b.a$a, reason: collision with other inner class name */
    public static final class C5620a {
        @JvmStatic
        public static a a(String r100) {
            if (r100 == null) goto L4;
            HashMap<String, a> r101 = a.f466576c;
            monitor-enter(r101);
            a r102 = r101.get(r100);     // Catch: Throwable -> L12
            if (r102 != null) goto L10;
            r102 = new a(r100);     // Catch: Throwable -> L12
            r101.put(r100, r102);     // Catch: Throwable -> L12
        L10:
            monitor-exit(r101);
            return r102;
        L12:
            th = move-exception;
            throw th;
        L4:
            return new a("");
        }
    }

    public interface b {
    }

    public interface c {
    }

    static {
        f466576c = new HashMap();
    }

    public final void b() {
        HashMap<String, a> r100 = f466576c;
        monitor-enter(r100);
        r100.clear();     // Catch: Throwable -> L7
        this.f466578b.shutdown();     // Catch: Throwable -> L7
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public a(String r100) {
        this.f466577a = r100;
        this.f466578b = PThreadExecutorsUtils.newScheduledThreadPool(1, new n("MsgSampleIssueTracker_" + r100));
    }

    public final void a(Chat r100, c r101, b r102) {
        Intrinsics.checkNotNullParameter(r101, "fetcher");
        Intrinsics.checkNotNullParameter(r102, "syncFetcher");
        if (TextUtils.isEmpty(this.f466577a) == true) goto L7;
        if (r100 == null) goto L8;
        Intrinsics.areEqual(this.f466577a, r100.getId());
        return;
    L8:
        return;
    }
}
