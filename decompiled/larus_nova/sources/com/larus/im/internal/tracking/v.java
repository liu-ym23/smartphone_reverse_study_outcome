package com.larus.im.internal.tracking;

import android.os.SystemClock;
import androidx.collection.LruCache;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.im.internal.database.entity.MessageEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<String, a> f350494a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f350495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f350496b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f350497c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f350498d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f350499e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f350500f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f350501g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f350502h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f350503i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f350504j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f350505k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f350506l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f350507m;

        public a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.MSGID);
            this.f350495a = r100;
            this.f350496b = false;
            this.f350497c = 0;
            this.f350498d = 0;
            this.f350499e = 0;
            this.f350500f = 0;
            this.f350501g = 0;
            this.f350502h = 0;
            this.f350503i = 0;
            this.f350504j = 0;
            this.f350505k = 0;
            this.f350506l = 0;
            this.f350507m = 0;
        }
    }

    static {
        f350494a = new LruCache(5);
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        a r101 = f350494a.get(r100);
        if (r101 == null) goto L9;
        long r102 = SystemClock.elapsedRealtime();
        r101.f350503i++;
        long r103 = r101.f350501g;
        if (r103 == 0) goto L7;
        r101.f350502h += r102 - r103;
    L7:
        r101.f350501g = r102;
        return;
    }

    public static void a(String r100, MessageEntity r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "msg");
        long r102 = SystemClock.elapsedRealtime();
        String r103 = r101.getMessageId();
        if (r103 != null) goto L5;
        return;
    L5:
        LruCache<String, a> r104 = f350494a;
        a r105 = r104.get(r103);
        if (r105 != null) goto L15;
        r105 = new a(r100, r103);
        String r106 = r101.getThinkingContent();
        if (r106 != null) goto L10;
    L13:
        boolean r107 = true;
    L14:
        r105.f350496b = !r107;
        r105.f350497c = com.larus.im.internal.database.utils.k.e(r101);
        r104.put(r103, r105);
        goto L15
    L10:
        if (r106.length() == 0) goto L13;
        r107 = false;
    L15:
        r105.f350500f++;
        long r108 = r105.f350498d;
        if (r108 == 0) goto L18;
        r105.f350499e += r102 - r108;
    L18:
        r105.f350498d = r102;
    }
}
