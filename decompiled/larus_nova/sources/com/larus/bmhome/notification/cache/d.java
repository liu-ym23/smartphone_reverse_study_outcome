package com.larus.bmhome.notification.cache;

import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.chat.resp.NotificationList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Triple;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f313463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f313464b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static MutableLiveData<Triple<com.larus.network.http.a<NotificationList>, Boolean, Boolean>> f313465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f313466d = null;

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.bmhome.notification.cache.b] */
    static {
        f313464b = LazyKt.lazy(new a());
        f313466d = new b();
    }
}
