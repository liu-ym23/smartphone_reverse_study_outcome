package com.ss.android.lark.usersetting.service.badgestyle;

import aac.g;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.usersetting.base.UserSetting;
import com.ss.android.lark.usersetting.entity.BadgeStyle;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f444630c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<c, Object> f444631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<d, Object> f444632b;

    /* JADX INFO: renamed from: com.ss.android.lark.usersetting.service.badgestyle.a$a, reason: collision with other inner class name */
    public class C5372a implements aac.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f444633a;

        public C5372a(a r100) {
            this.f444633a = r100;
        }

        @Override // aac.b.a
        public final void a(UserSetting r100, UserSetting r101) {
            a r102 = this.f444633a;
            r102.getClass();
            CoreThreadPool.getDefault().getFixedThreadPool().execute(new com.ss.android.lark.usersetting.service.badgestyle.b(r102, r101, r100));
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f444634a = null;

        static {
            f444634a = new a();
        }
    }

    static {
        f444630c = new Object();
    }

    public a() {
        this.f444631a = new ConcurrentHashMap();
        this.f444632b = new ConcurrentHashMap();
        C5372a r100 = new C5372a(this);
        g.d.f2395a.c(r100);
    }

    public static void a(a r100, BadgeStyle r101, BadgeStyle r102) {
        r100.getClass();
        if (Objects.equals(r101, r102) == false) goto L5;
        Log.i("BadgeStyleService", "badge style is not changed");
        return;
    L5:
        Iterator r103 = ((ConcurrentHashMap) r100.f444631a).keySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        ((c) r103.next()).a();
        goto L7
    }

    public static void b(a r100, Boolean r101, Boolean r102) {
        if (r101 != r102) goto L4;
        r100.getClass();
        return;
    L4:
        Iterator r103 = ((ConcurrentHashMap) r100.f444632b).keySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        d r104 = (d) r103.next();
        r102.booleanValue();
        r104.a();
        goto L6
    }
}
