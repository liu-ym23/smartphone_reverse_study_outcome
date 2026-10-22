package com.ss.android.lark;

import android.content.Context;
import com.larksuite.framework.thread.CoreThreadPool;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f408535a;

    /* JADX INFO: renamed from: com.ss.android.lark.a$a, reason: collision with other inner class name */
    public class C4738a implements b {
        public C4738a() {
        }

        @Override // com.ss.android.lark.a.b
        public final ScheduledExecutorService a() {
            return CoreThreadPool.getDefault().getScheduleThreadPool();
        }

        @Override // com.ss.android.lark.a.b
        public Context getContext() {
            return com.larksuite.framework.utils.b.f285948a;
        }
    }

    public interface b {
        ScheduledExecutorService a();

        Context getContext();
    }

    static {
        f408535a = new C4738a();
    }
}
