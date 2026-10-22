package com.ss.android.lark.usersetting.service.notification;

import aac.g;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.usersetting.base.UserSetting;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f444640b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<com.ss.android.lark.usersetting.service.notification.a, Object> f444641a;

    public class a implements aac.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f444642a;

        public a(b r100) {
            this.f444642a = r100;
        }

        @Override // aac.b.a
        public final void a(UserSetting r100, UserSetting r101) {
            b r102 = this.f444642a;
            r102.getClass();
            CoreThreadPool.getDefault().getFixedThreadPool().execute(new d(r102, r101));
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.usersetting.service.notification.b$b, reason: collision with other inner class name */
    public static class C5373b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f444643a = null;

        static {
            f444643a = new b();
        }
    }

    static {
        f444640b = new Object();
    }

    public b() {
        this.f444641a = new ConcurrentHashMap();
        a r100 = new a(this);
        g.d.f2395a.c(r100);
    }

    public final void a(IGetDataCallback r100) {
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new c(r100));
    }
}
