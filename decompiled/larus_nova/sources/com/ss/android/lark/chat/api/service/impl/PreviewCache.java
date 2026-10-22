package com.ss.android.lark.chat.api.service.impl;

import android.util.ArrayMap;
import com.bytedance.lark.pb.basic.v1.MessageLink;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes35.dex */
public final class PreviewCache {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy<PreviewCache> f411536f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f411537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, Map<String, UrlCardPreviewEntity>> f411538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, ArrayMap<String, MessageLink>> f411539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReentrantReadWriteLock f411540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<tya.a, Object> f411541e;

    public static final class a {
        public static PreviewCache a() {
            return PreviewCache.f411536f.getValue();
        }
    }

    static {
        f411536f = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, PreviewCache$Companion$INSTANCE$2.INSTANCE);
    }

    public PreviewCache() {
        this.f411537a = PThreadExecutorsUtils.newSingleThreadExecutor(new com.larksuite.framework.thread.n("thread-pool-message-preview-cache"));
        this.f411538b = new ConcurrentHashMap();
        this.f411539c = new ConcurrentHashMap();
        this.f411540d = new ReentrantReadWriteLock();
        this.f411541e = new ConcurrentHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v7, types: [T, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v3 */
    public final Map<String, Map<String, MessageLink>> a(Map<String, ? extends List<String>> r100) {
        this.f411540d.readLock().lock();     // Catch: Throwable -> L22
        Ref.ObjectRef r101 = new Ref.ObjectRef();     // Catch: Throwable -> L22
        if (r100 == null) goto L19;
        Iterator<Map.Entry<String, ? extends List<String>>> r102 = r100.entrySet().iterator();     // Catch: Throwable -> L22
    L6:
        if (r102.hasNext() == false) goto L19;
        Map.Entry<String, ? extends List<String>> r103 = r102.next();     // Catch: Throwable -> L22
        ArrayMap<String, MessageLink> r104 = this.f411539c.get(r103.getKey());     // Catch: Throwable -> L22
        List<String> r105 = r103.getValue();     // Catch: Throwable -> L22
        if (r104 == null) goto L6;
        LinkedHashMap r106 = new LinkedHashMap();     // Catch: Throwable -> L22
        Iterator<Map.Entry<String, MessageLink>> r107 = r104.entrySet().iterator();     // Catch: Throwable -> L22
    L11:
        if (r107.hasNext() == false) goto L15;
        Map.Entry<String, MessageLink> r108 = r107.next();     // Catch: Throwable -> L22
        if (r105.contains(r108.getKey()) == false) goto L11;
        r106.put(r108.getKey(), r108.getValue());     // Catch: Throwable -> L22
        goto L11
    L15:
        ConcurrentHashMap r109 = (ConcurrentHashMap) r101.element;     // Catch: Throwable -> L22
        ?? r110 = r109;
        if (r109 != null) goto L18;
        r110 = new ConcurrentHashMap();     // Catch: Throwable -> L22
    L18:
        r101.element = r110;     // Catch: Throwable -> L22
        ConcurrentHashMap r111 = (ConcurrentHashMap) r110;     // Catch: Throwable -> L22
        Map r112 = (Map) r110.put(r103.getKey(), r106);     // Catch: Throwable -> L22
    L19:
        Map<String, Map<String, MessageLink>> r113 = (Map) r101.element;     // Catch: Throwable -> L22
        this.f411540d.readLock().unlock();
        return r113;
    L22:
        th = move-exception;
        this.f411540d.readLock().unlock();
        throw th;
    }

    public final Map<String, Map<String, UrlCardPreviewEntity>> d(Map<String, ? extends List<String>> r100) {
        this.f411540d.readLock().lock();     // Catch: Throwable -> L19
        ConcurrentHashMap r101 = new ConcurrentHashMap();     // Catch: Throwable -> L19
        if (r100 == null) goto L17;
        Iterator<Map.Entry<String, ? extends List<String>>> r102 = r100.entrySet().iterator();     // Catch: Throwable -> L19
    L5:
        if (r102.hasNext() == false) goto L17;
        Map.Entry<String, ? extends List<String>> r103 = r102.next();     // Catch: Throwable -> L19
        String r104 = r103.getKey();     // Catch: Throwable -> L19
        Map<String, UrlCardPreviewEntity> r105 = this.f411538b.get(r104);     // Catch: Throwable -> L19
        List<String> r106 = r103.getValue();     // Catch: Throwable -> L19
        if (r105 == null) goto L5;
        LinkedHashMap r107 = new LinkedHashMap();     // Catch: Throwable -> L19
        Iterator<Map.Entry<String, UrlCardPreviewEntity>> r108 = r105.entrySet().iterator();     // Catch: Throwable -> L19
    L11:
        if (r108.hasNext() == false) goto L15;
        Map.Entry<String, UrlCardPreviewEntity> r109 = r108.next();     // Catch: Throwable -> L19
        if (r106.contains(r109.getKey()) == false) goto L11;
        r107.put(r109.getKey(), r109.getValue());     // Catch: Throwable -> L19
        goto L11
    L15:
        r101.put(r104, r107);     // Catch: Throwable -> L19
    L17:
        this.f411540d.readLock().unlock();
        return r101;
    L19:
        th = move-exception;
        this.f411540d.readLock().unlock();
        throw th;
    }

    public final boolean f(UrlCardPreviewEntity r100) {
        this.f411540d.writeLock().lock();     // Catch: Throwable -> L15
        UrlInlinePreviewEntity r101 = r100.getInlineEntity();     // Catch: Throwable -> L15
        boolean r102 = true;
        if (this.f411538b.get(r101.getSourceId()) != null) goto L7;
        ConcurrentHashMap<String, Map<String, UrlCardPreviewEntity>> r103 = this.f411538b;     // Catch: Throwable -> L15
        String r104 = r101.getSourceId();     // Catch: Throwable -> L15
        ArrayMap r105 = new ArrayMap();     // Catch: Throwable -> L15
        r105.put(r101.getPreviewId(), r100);     // Catch: Throwable -> L15
        r103.put(r104, r105);     // Catch: Throwable -> L15
    L5:
        this.f411540d.writeLock().unlock();
        return r102;
    L7:
        UrlCardPreviewEntity r106 = b(r101.getSourceId(), r101.getPreviewId());     // Catch: Throwable -> L15
        Map<String, UrlCardPreviewEntity> r107 = this.f411538b.get(r101.getSourceId());     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type android.util.ArrayMap<kotlin.String, com.ss.android.lark.export.entity.UrlCardPreviewEntity>");     // Catch: Throwable -> L15
        ArrayMap r108 = (ArrayMap) r107;     // Catch: Throwable -> L15
        if (r106 != null) goto L11;
        r108.put(r101.getPreviewId(), r100);     // Catch: Throwable -> L15
        goto L5
    L11:
        if (r100.compareTo2(r106) < 0) goto L14;
        r108.put(r101.getPreviewId(), r100);     // Catch: Throwable -> L15
        goto L5
    L14:
        r102 = false;
    L15:
        th = move-exception;
        this.f411540d.writeLock().unlock();
        throw th;
    }

    public final UrlCardPreviewEntity b(String r100, String r101) {
        this.f411540d.readLock().lock();     // Catch: Throwable -> L9
        Map<String, UrlCardPreviewEntity> r102 = this.f411538b.get(r100);     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        UrlCardPreviewEntity r103 = r102.get(r101);     // Catch: Throwable -> L9
    L7:
        this.f411540d.readLock().unlock();
        return r103;
    L6:
        r103 = null;
    L9:
        th = move-exception;
        this.f411540d.readLock().unlock();
        throw th;
    }

    public final Map<String, UrlCardPreviewEntity> c(String r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "previewIds");
        this.f411540d.readLock().lock();     // Catch: Throwable -> L16
        Map<String, UrlCardPreviewEntity> r102 = this.f411538b.get(r100);     // Catch: Throwable -> L16
        if (r102 != null) goto L7;
        this.f411540d.readLock().unlock();
        return null;
    L7:
        ArrayMap r103 = new ArrayMap();     // Catch: Throwable -> L16
        Iterator<T> r104 = r101.iterator();     // Catch: Throwable -> L16
    L9:
        if (r104.hasNext() == false) goto L14;
        String r105 = (String) r104.next();     // Catch: Throwable -> L16
        UrlCardPreviewEntity r106 = r102.get(r105);     // Catch: Throwable -> L16
        if (r106 == null) goto L9;
        r103.put(r105, r106);     // Catch: Throwable -> L16
        goto L9
    L14:
        this.f411540d.readLock().unlock();
        return r103;
    L16:
        th = move-exception;
        this.f411540d.readLock().unlock();
        throw th;
    }

    public final void e(Map r100, Map r101) {
        ConcurrentHashMap r102 = new ConcurrentHashMap();
        this.f411540d.writeLock().lock();     // Catch: Throwable -> L30
        if (r100 == null) goto L28;
        Iterator r103 = r100.entrySet().iterator();     // Catch: Throwable -> L30
    L6:
        if (r103.hasNext() == false) goto L28;
        Map.Entry r104 = (Map.Entry) r103.next();     // Catch: Throwable -> L30
        r102.put(r104.getKey(), new ArrayList());     // Catch: Throwable -> L30
        Iterator r105 = ((Map) r104.getValue()).entrySet().iterator();     // Catch: Throwable -> L30
    L10:
        if (r105.hasNext() == false) goto L6;
        Map.Entry r106 = (Map.Entry) r105.next();     // Catch: Throwable -> L30
        if (f((UrlCardPreviewEntity) r106.getValue()) == false) goto L10;
        ArrayList r107 = (ArrayList) r102.get(r104.getKey());     // Catch: Throwable -> L30
        if (r107 == null) goto L16;
        r107.add(r106.getKey());     // Catch: Throwable -> L30
    L16:
        String r108 = (String) r104.getKey();     // Catch: Throwable -> L30
        String r109 = (String) r106.getKey();     // Catch: Throwable -> L30
        if (r101 == null) goto L10;
        MessageLink r110 = (MessageLink) r101.get(r109);     // Catch: Throwable -> L30
        if (r110 == null) goto L10;
        if (this.f411539c.get(r108) == null) goto L23;
        ArrayMap<String, MessageLink> r111 = this.f411539c.get(r108);     // Catch: Throwable -> L30
        if (r111 == null) goto L10;
        r111.put(r109, r110);     // Catch: Throwable -> L30
        goto L10
    L23:
        ArrayMap<String, MessageLink> r112 = new ArrayMap();     // Catch: Throwable -> L30
        r112.put(r109, r110);     // Catch: Throwable -> L30
        this.f411539c.put(r108, r112);     // Catch: Throwable -> L30
    L28:
        this.f411540d.writeLock().unlock();
        this.f411537a.submit(new v0(this, r102));
        return;
    L30:
        th = move-exception;
        this.f411540d.writeLock().unlock();
        throw th;
    }
}
