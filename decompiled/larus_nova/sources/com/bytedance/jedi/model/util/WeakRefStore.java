package com.bytedance.jedi.model.util;

import androidx.exifinterface.media.ExifInterface;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/jedi/model/util/WeakRefStore;", "", ExifInterface.GPS_DIRECTION_TRUE, "<init>", "()V", "model_release"}, k = 1, mv = {1, 7, 1})
public final class WeakRefStore<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, WeakReference<T>> f251215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReferenceQueue<T> f251216b;

    public WeakRefStore() {
        this.f251215a = new ConcurrentHashMap();
        this.f251216b = new ReferenceQueue();
    }
}
