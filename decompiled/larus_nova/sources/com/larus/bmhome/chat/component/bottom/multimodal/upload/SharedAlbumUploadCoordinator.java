package com.larus.bmhome.chat.component.bottom.multimodal.upload;

import android.net.Uri;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.upload.ResourceUploader;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import ic8.m0;
import ic8.n0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import yc9.n1;

/* JADX INFO: loaded from: classes25.dex */
public final class SharedAlbumUploadCoordinator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SharedAlbumUploadCoordinator f300145a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f300146b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f300147c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<b, c> f300148d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, c> f300149e = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f300150a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f300151b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f300150a == r101.f300150a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f300151b, r101.f300151b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f300150a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            String r102 = this.f300151b;
            if (r102 != null) goto L9;
            int r103 = 0;
        L11:
            return r101 + r103;
        L9:
            r103 = r102.hashCode();
            goto L11
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "CancelDecision(handled=" + this.f300150a + ", underlyingIdentifierToCancel=" + this.f300151b + ')';
        }

        public a(boolean r100, String r101) {
            this.f300150a = r100;
            this.f300151b = r101;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f300152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f300153b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f300154c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ns8.b f300155d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f300152a, r101.f300152a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f300153b, r101.f300153b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f300154c, r101.f300154c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f300155d, r101.f300155d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f300152a.hashCode() * 31) + this.f300153b.hashCode()) * 31) + this.f300154c.hashCode()) * 31;
            ns8.b r101 = this.f300155d;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "ShareKey(uploadTaskShareTag=" + this.f300152a + ", conversationId=" + this.f300153b + ", uri=" + this.f300154c + ", processConfig=" + this.f300155d + ')';
        }

        public b(String r100, String r101, String r102, ns8.b r103) {
            Intrinsics.checkNotNullParameter(r100, "uploadTaskShareTag");
            Intrinsics.checkNotNullParameter(r101, "conversationId");
            Intrinsics.checkNotNullParameter(r102, "uri");
            this.f300152a = r100;
            this.f300153b = r101;
            this.f300154c = r102;
            this.f300155d = r103;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f300156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f300157b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Job f300158c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LinkedHashMap<String, d> f300159d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f300160e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Boolean f300161f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public n0 f300162g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Long f300163h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public mr9.l f300164i;

        public c(b r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "leaderIdentifier");
            this.f300156a = r100;
            this.f300157b = r101;
            this.f300159d = new LinkedHashMap();
            this.f300160e = r101;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q f300165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public n0 f300166b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f300167c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f300165a, r101.f300165a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f300166b, r101.f300166b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f300167c, r101.f300167c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f300165a.hashCode() * 31;
            n0 r101 = this.f300166b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f300167c;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Subscriber(param=" + this.f300165a + ", processResult=" + this.f300166b + ", originalRemoteDeleteFlag=" + this.f300167c + ')';
        }

        public d(q r100) {
            Map<String, String> r101 = r100.f300235e.getExtra();
            if (r101 == null) goto L5;
            String r102 = r101.get("disable_remote_delete");
        L6:
            Intrinsics.checkNotNullParameter(r100, "param");
            this.f300165a = r100;
            this.f300166b = null;
            this.f300167c = r102;
            return;
        L5:
            r102 = null;
            goto L6
        }

        public final void a(boolean r100) {
            Map<String, String> r101 = this.f300165a.f300235e.getExtra();
            if (r101 != null) goto L5;
            r101 = MapsKt.emptyMap();
        L5:
            Map<String, String> r102 = MapsKt.toMutableMap(r101);
            if (r100 == false) goto L11;
            String r103 = this.f300167c;
            if (r103 != null) goto L10;
            r102.remove("disable_remote_delete");
        L12:
            UplinkFileEntity r104 = this.f300165a.f300235e;
            if ((!r102.isEmpty()) == true) goto L16;
            r102 = null;
        L16:
            r104.setExtra(r102);
            return;
        L10:
            r102.put("disable_remote_delete", r103);
            goto L12
        L11:
            r102.put("disable_remote_delete", "1");
            goto L12
        }
    }

    public static final class e implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f300168a;

        public e(c r100) {
            Intrinsics.checkNotNullParameter(r100, "task");
            this.f300168a = r100;
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.m
        public final void c(boolean r100) {
            Object r101 = SharedAlbumUploadCoordinator.f300147c;
            monitor-enter(r101);
            this.f300168a.f300161f = Boolean.valueOf(r100);     // Catch: Throwable -> L13
            List r102 = CollectionsKt.toList(this.f300168a.f300159d.values());     // Catch: Throwable -> L13
            monitor-exit(r101);
            FLogger.f375446a.i("SharedAlbumUpload", "shared upload intercept result, leader=" + this.f300168a.f300157b + ", intercept=" + r100 + ", subscribers=" + r102.size());
            Iterator r103 = r102.iterator();
        L8:
            if (r103.hasNext() == false) goto L10;
            ((d) r103.next()).f300165a.f300233c.c(r100);
            goto L8
        L10:
            if (r100 == false) goto L19;
            SharedAlbumUploadCoordinator r104 = SharedAlbumUploadCoordinator.f300145a;
            SharedAlbumUploadCoordinator.a(this.f300168a);
            return;
        L19:
            return;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.m
        public final void d(n0 r100) {
            Intrinsics.checkNotNullParameter(r100, "processResult");
            Object r101 = SharedAlbumUploadCoordinator.f300147c;
            monitor-enter(r101);
            c r102 = this.f300168a;     // Catch: Throwable -> L33
            r102.f300162g = r100;     // Catch: Throwable -> L33
            Collection<d> r103 = r102.f300159d.values();     // Catch: Throwable -> L33
            ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));     // Catch: Throwable -> L33
            Iterator<T> r105 = r103.iterator();     // Catch: Throwable -> L33
        L6:
            if (r105.hasNext() == false) goto L9;
            d r106 = (d) r105.next();     // Catch: Throwable -> L33
            SharedAlbumUploadCoordinator r107 = SharedAlbumUploadCoordinator.f300145a;     // Catch: Throwable -> L33
            n0 r108 = SharedAlbumUploadCoordinator.e(r100);     // Catch: Throwable -> L33
            r106.f300166b = r108;     // Catch: Throwable -> L33
            r104.add(TuplesKt.to(r106, r108));     // Catch: Throwable -> L33
            goto L6
        L9:
            monitor-exit(r101);
            FLogger r109 = FLogger.f375446a;
            StringBuilder r110 = new StringBuilder("shared upload preprocess result, leader=");
            r110.append(this.f300168a.f300157b);
            r110.append(", success=");
            ProcessFileResultCode r111 = r100.f489244b;
            boolean r112 = false;
            if (r111 != null) goto L13;
        L15:
            boolean r113 = false;
        L16:
            r110.append(r113);
            r110.append(", subscribers=");
            r110.append(r104.size());
            r109.i("SharedAlbumUpload", r110.toString());
            Iterator r114 = r104.iterator();
        L18:
            if (r114.hasNext() == false) goto L20;
            Pair r115 = (Pair) r114.next();
            d r116 = (d) r115.component1();
            n0 r117 = (n0) r115.component2();
            SharedAlbumUploadCoordinator r118 = SharedAlbumUploadCoordinator.f300145a;
            SharedAlbumUploadCoordinator.f(this.f300168a, r116);
            r116.f300165a.f300233c.d(r117);
            goto L18
        L20:
            ProcessFileResultCode r119 = r100.f489244b;
            if (r119 != null) goto L23;
        L25:
            if (r112 == false) goto L31;
            m0 r120 = r100.f489243a;
            if (r120 == null) goto L29;
            String r121 = r120.f489227e;
        L30:
            if (r121 == null) goto L31;
            return;
        L29:
            r121 = null;
        L31:
            SharedAlbumUploadCoordinator r122 = SharedAlbumUploadCoordinator.f300145a;
            SharedAlbumUploadCoordinator.a(this.f300168a);
            return;
        L23:
            if (r119.isSuccess() != true) goto L25;
            r112 = true;
            goto L25
        L13:
            if (r111.isSuccess() != true) goto L15;
            r113 = true;
        L33:
            th = move-exception;
            throw th;
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.n
        public final void a(long r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "fileIdentifier");
            Object r102 = SharedAlbumUploadCoordinator.f300147c;
            monitor-enter(r102);
            c r103 = this.f300168a;     // Catch: Throwable -> L14
            r103.f300163h = Long.valueOf(r100);     // Catch: Throwable -> L14
            List r104 = CollectionsKt.toList(this.f300168a.f300159d.values());     // Catch: Throwable -> L14
            monitor-exit(r102);
            Iterator r105 = r104.iterator();
        L8:
            if (r105.hasNext() == false) goto L13;
            q r106 = ((d) r105.next()).f300165a;
            m r107 = r106.f300233c;
            String r108 = r106.f300235e.getFileIdentifier();
            if (r108 != null) goto L12;
            r108 = "";
        L12:
            r107.a(r100, r108);
            goto L8
        L13:
            return;
        L14:
            th = move-exception;
            throw th;
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.n
        public final void b(mr9.l r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "uploadResult");
            Intrinsics.checkNotNullParameter(r101, "fileIdentifier");
            Object r102 = SharedAlbumUploadCoordinator.f300147c;
            monitor-enter(r102);
            c r103 = this.f300168a;     // Catch: Throwable -> L11
            r103.f300164i = r100;     // Catch: Throwable -> L11
            List r104 = CollectionsKt.toList(r103.f300159d.values());     // Catch: Throwable -> L11
            monitor-exit(r102);
            FLogger.f375446a.i("SharedAlbumUpload", "shared upload success, leader=" + this.f300168a.f300157b + ", resourceId=" + r100.f515024c + ", subscribers=" + r104.size());
            Iterator r105 = r104.iterator();
        L8:
            if (r105.hasNext() == false) goto L10;
            d r106 = (d) r105.next();
            SharedAlbumUploadCoordinator r107 = SharedAlbumUploadCoordinator.f300145a;
            c r108 = this.f300168a;
            Intrinsics.checkNotNull(r106);
            SharedAlbumUploadCoordinator.d(r108, r106, r100);
            goto L8
        L10:
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.n
        public final void e(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "fileIdentifier");
            SharedAlbumUploadCoordinator r103 = SharedAlbumUploadCoordinator.f300145a;
            SharedAlbumUploadCoordinator.b(this.f300168a, r100, r102);
        }
    }

    public static final class f extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f300169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f300170b;

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            if ((r101 instanceof CancellationException) == true) goto L6;
            FLogger.f375446a.e("SharedAlbumUpload", "shared upload failed before callback, identifier=" + this.f300169a, r101);
            SharedAlbumUploadCoordinator r102 = SharedAlbumUploadCoordinator.f300145a;
            SharedAlbumUploadCoordinator.b(this.f300170b, r101.getMessage(), null);
            return;
        }

        public f(CoroutineExceptionHandler.Key r100, String r101, c r102) {
            this.f300169a = r101;
            this.f300170b = r102;
            super(r100);
        }
    }

    public SharedAlbumUploadCoordinator() {
    }

    static {
        f300145a = new SharedAlbumUploadCoordinator();
        f300146b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f300147c = new Object();
        f300148d = new LinkedHashMap();
        f300149e = new LinkedHashMap();
    }

    public static final void a(c r100) {
        Object r101 = f300147c;
        monitor-enter(r101);
        h(r100);     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static a c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        Object r102 = f300147c;
        monitor-enter(r102);
        c r103 = f300149e.remove(r100);     // Catch: Throwable -> L42
        int r104 = 0;
        if (r103 != null) goto L7;
        a r105 = new a(false, null);     // Catch: Throwable -> L42
    L31:
        monitor-exit(r102);
        Job r106 = (Job) r101.element;
        if (r106 == null) goto L36;
        Job.DefaultImpls.cancel$default(r106, null, 1, null);
    L36:
        if (r105.f300150a == true) goto L38;
        return r105;
    L38:
        if (r104 <= 0) goto L40;
        FLogger.f375446a.i("SharedAlbumUpload", "remove subscriber, keep shared upload, identifier=" + r100 + ", remaining=" + r104);
    L41:
        return r105;
    L40:
        FLogger.f375446a.i("SharedAlbumUpload", "remove last subscriber, identifier=" + r100);
        goto L41
    L7:
        d r107 = r103.f300159d.remove(r100);     // Catch: Throwable -> L42
        int r108 = r103.f300159d.size();     // Catch: Throwable -> L42
        if ((!r103.f300159d.isEmpty()) == true) goto L10;
        g(r103);     // Catch: Throwable -> L42
        Job r109 = r103.f300158c;     // Catch: Throwable -> L42
        if (r109 == null) goto L18;
        Job r110 = r109;
    L20:
        if (Boolean.valueOf(r110.isCompleted()).booleanValue() == true) goto L22;
        T r111 = r110;
    L23:
        r101.element = r111;     // Catch: Throwable -> L42
        String r112 = r103.f300157b;     // Catch: Throwable -> L42
        if (r103.f300164i != null) goto L26;
        r104 = 1;
    L26:
        if (r104 != 0) goto L29;
        r112 = null;
    L29:
        r105 = new a(true, r112);     // Catch: Throwable -> L42
    L30:
        r104 = r108;
        goto L31
    L22:
        r111 = 0;
        goto L23
    L18:
        Intrinsics.throwUninitializedPropertyAccessException("submissionJob");     // Catch: Throwable -> L42
        r110 = null;
        goto L20
    L10:
        if (Intrinsics.areEqual(r103.f300160e, r100) == false) goto L14;
        if (r107 == null) goto L13;
        r107.a(false);     // Catch: Throwable -> L42
    L13:
        Map.Entry r113 = (Map.Entry) CollectionsKt.first(r103.f300159d.entrySet());     // Catch: Throwable -> L42
        String r114 = (String) r113.getKey();     // Catch: Throwable -> L42
        d r115 = (d) r113.getValue();     // Catch: Throwable -> L42
        Intrinsics.checkNotNullParameter(r114, "<set-?>");     // Catch: Throwable -> L42
        r103.f300160e = r114;     // Catch: Throwable -> L42
        r115.a(true);     // Catch: Throwable -> L42
    L14:
        r105 = new a(true, null);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        throw th;
    }

    public static n0 e(n0 r100) {
        m0 r101 = r100.f489243a;
        m0 r102 = null;
        if (r101 == null) goto L6;
        r102 = m0.a(r101, null, null, null, 16383);
    L6:
        return new n0(r102, r100.f489244b);
    }

    public static void g(c r100) {
        Map<b, c> r101 = f300148d;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        if (r102.get(r100.f300156a) != r100) goto L6;
        r101.remove(r100.f300156a);
        return;
    }

    public static void h(c r100) {
        g(r100);
        Iterator<Map.Entry<String, d>> r101 = r100.f300159d.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Map.Entry<String, d> r102 = r101.next();
        String r103 = r102.getKey();
        d r104 = r102.getValue();
        Map<String, c> r105 = f300149e;
        if (((LinkedHashMap) r105).get(r103) != r100) goto L8;
        r105.remove(r103);
    L8:
        r104.a(true);
        goto L4
    L9:
        r100.f300159d.clear();
    }

    public static void f(c r100, d r101) {
        if (n1.e(r101.f300165a.f300235e) == true) goto L5;
        return;
    L5:
        String r102 = r101.f300165a.f300235e.getFileIdentifier();
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        if (Intrinsics.areEqual(r102, r100.f300157b) == false) goto L11;
        return;
    L11:
        mr9.e r103 = com.larus.bmhome.upload.h.f314760a.query(r100.f300157b);
        if (r103 == null) goto L15;
        com.larus.bmhome.upload.h.a(r102, r103, "SharedAlbumUpload");
        return;
    }

    public static final void b(c r100, String r101, String r102) {
        Object r103 = f300147c;
        monitor-enter(r103);
        List r104 = CollectionsKt.toList(r100.f300159d.values());     // Catch: Throwable -> L14
        h(r100);     // Catch: Throwable -> L14
        monitor-exit(r103);
        FLogger.f375446a.e("SharedAlbumUpload", "shared upload failed, leader=" + r100.f300157b + ", code=" + r102 + ", subscribers=" + r104.size() + ", message=" + r101);
        Iterator r105 = r104.iterator();
    L8:
        if (r105.hasNext() == false) goto L13;
        d r106 = (d) r105.next();
        String r107 = r106.f300165a.f300235e.getFileIdentifier();
        if (r107 != null) goto L12;
        r107 = "";
    L12:
        r106.f300165a.f300233c.e(r101, r107, r102);
        goto L8
    L13:
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public static void d(c r100, d r101, mr9.l r102) {
        String r103 = r101.f300165a.f300235e.getFileIdentifier();
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        Object r104 = f300147c;
        monitor-enter(r104);
        Map<String, c> r105 = f300149e;     // Catch: Throwable -> L40
        if (((LinkedHashMap) r105).get(r103) != r100) goto L10;
        r105.remove(r103);     // Catch: Throwable -> L40
    L10:
        d r106 = r100.f300159d.remove(r103);     // Catch: Throwable -> L40
        d r107 = r106;     // Catch: Throwable -> L40
        if (r100.f300159d.isEmpty() == false) goto L13;
        g(r100);     // Catch: Throwable -> L40
    L13:
        d r108 = r106;     // Catch: Throwable -> L40
        monitor-exit(r104);
        if (r108 != null) goto L17;
        return;
    L17:
        String r109 = r102.f515024c;
        if (r109 == null) goto L38;
        boolean r110 = false;
        if (r109.length() <= 0) goto L22;
        boolean r111 = true;
    L23:
        if (r111 == true) goto L26;
        r109 = null;
    L26:
        if (r109 == null) goto L38;
        ResourceCenter.f313541a.getClass();
        Intrinsics.checkNotNullParameter(r103, LocationMonitorConst.IDENTIFIER);
        Intrinsics.checkNotNullParameter(r109, "resourceId");
        if (r103.length() != 0) goto L30;
        boolean r112 = true;
    L31:
        if (r112 == true) goto L38;
        if (r109.length() != 0) goto L35;
        r110 = true;
    L35:
        if (r110 == true) goto L38;
        ResourceCenter.f313545e.put(r103, r109);
        goto L38
    L30:
        r112 = false;
        goto L31
    L22:
        r111 = false;
    L38:
        FLogger.f375446a.i("SharedAlbumUpload", "dispatch shared upload result, identifier=" + r103 + ", resourceId=" + r102.f515024c + ", resourceOwner=" + Intrinsics.areEqual(r103, r100.f300160e));
        r108.f300165a.f300233c.b(r102, r103);
        return;
    L40:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [T, com.larus.bmhome.chat.component.bottom.multimodal.upload.SharedAlbumUploadCoordinator$c, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r2v18, types: [T, com.larus.bmhome.chat.component.bottom.multimodal.upload.SharedAlbumUploadCoordinator$c, java.lang.Object] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object i(q r210, ns8.b r211, Function3<? super q, ? super ns8.b, ? super Continuation<? super Unit>, ? extends Object> r212, Function0<Unit> r213, Continuation<? super Boolean> r214) {
        if ((r214 instanceof SharedAlbumUploadCoordinator$submit$1) == false) goto L7;
        SharedAlbumUploadCoordinator$submit$1 r100 = (SharedAlbumUploadCoordinator$submit$1) r214;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        SharedAlbumUploadCoordinator$submit$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        String r106 = (String) r102.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L14
    L139:
        if (JobKt.isActive(r102.getContext()) == true) goto L144;
        String r107 = c(r106).f300151b;
        if (r107 == null) goto L144;
        ResourceUploader r108 = ResourceUploader.f314736a;
        ResourceUploader.b(r107, ResourceUploader.a.C4107a.f314738a);
    L144:
        return Boxing.boxBoolean(true);
    L14:
        th = th;
    L148:
        if (JobKt.isActive(r102.getContext()) == true) goto L152;
        String r109 = c(r106).f300151b;
        if (r109 == null) goto L152;
        ResourceUploader r110 = ResourceUploader.f314736a;
        ResourceUploader.b(r109, ResourceUploader.a.C4107a.f314738a);
    L152:
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r103);
        String r111 = r210.f300240j;
        if (Intrinsics.areEqual(r111, "photo_picker_attachment") == true) goto L22;
    L57:
        b r112 = null;
    L59:
        if (r112 == null) goto L61;
        String r113 = r210.f300235e.getFileIdentifier();
        if (r113 != null) goto L65;
    L72:
        r113 = UUID.randomUUID().toString();
        r210.f300235e.setFileIdentifier(r113);
    L73:
        final String r114 = r113;
        if (r213 == null) goto L76;
        r213.invoke();
    L76:
        Ref.ObjectRef r115 = new Ref.ObjectRef();
        Ref.ObjectRef r116 = new Ref.ObjectRef();
        d r117 = new d(r210);
        Object r118 = f300147c;
        monitor-enter(r118);
        Map<b, c> r119 = f300148d;     // Catch: Throwable -> L153
        c r120 = (c) ((LinkedHashMap) r119).get(r112);     // Catch: Throwable -> L153
        if (r120 != null) goto L81;
        ?? r121 = new c(r112, r114);     // Catch: Throwable -> L153
        Job r122 = BuildersKt.launch(f300146b, new f(CoroutineExceptionHandler.Key, r114, r121), CoroutineStart.LAZY, new SharedAlbumUploadCoordinator$submit$replay$1$task$1$1(r212, r210, r121, r211, null));     // Catch: Throwable -> L153
        r122.invokeOnCompletion(new p(r114));     // Catch: Throwable -> L153
        Intrinsics.checkNotNullParameter(r122, "<set-?>");     // Catch: Throwable -> L153
        r121.f300158c = r122;     // Catch: Throwable -> L153
        r119.put(r112, (c) r121);     // Catch: Throwable -> L153
        r115.element = r121;     // Catch: Throwable -> L153
        ?? r123 = r121;
    L82:
        r116.element = r123;     // Catch: Throwable -> L153
        r117.a(r123.f300159d.isEmpty());     // Catch: Throwable -> L153
        r123.f300159d.put(r114, r117);     // Catch: Throwable -> L153
        f300149e.put(r114, (c) r123);     // Catch: Throwable -> L153
        Boolean r124 = r123.f300161f;     // Catch: Throwable -> L153
        n0 r125 = r123.f300162g;     // Catch: Throwable -> L153
        Long r126 = r123.f300163h;     // Catch: Throwable -> L153
        mr9.l r127 = r123.f300164i;     // Catch: Throwable -> L153
        int r128 = r123.f300159d.size();     // Catch: Throwable -> L153
        monitor-exit(r118);
        m r129 = r210.f300233c;
        if ((r129 instanceof com.larus.bmhome.chat.component.bottom.multimodal.upload.a) == false) goto L87;
        com.larus.bmhome.chat.component.bottom.multimodal.upload.a r130 = (com.larus.bmhome.chat.component.bottom.multimodal.upload.a) r129;
    L88:
        if (r130 != null) goto L90;
    L94:
        if (r124 == null) goto L96;
        r129.c(r124.booleanValue());
    L96:
        if (r125 == null) goto L102;
        n0 r131 = e(r125);
        T r132 = r116.element;
        if (r132 != 0) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("joinedTask");
        c r133 = null;
    L101:
        f(r133, r117);
        r117.f300166b = r131;
        r210.f300233c.d(r131);
        goto L102
    L100:
        r133 = (c) r132;
    L102:
        if (r126 == null) goto L104;
        r210.f300233c.a(r126.longValue(), r114);
    L104:
        if (r127 == null) goto L110;
        T r134 = r116.element;
        if (r134 != 0) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("joinedTask");
        c r135 = null;
    L109:
        d(r135, r117, r127);
        goto L110
    L108:
        r135 = (c) r134;
    L110:
        c r136 = (c) r115.element;
        if (r136 != null) goto L121;
        FLogger r137 = FLogger.f375446a;
        StringBuilder r138 = new StringBuilder("join shared upload, identifier=");
        r138.append(r114);
        r138.append(", subscribers=");
        r138.append(r128);
        r138.append(", replayPreprocess=");
        if (r125 == null) goto L115;
        boolean r139 = true;
    L116:
        r138.append(r139);
        r138.append(", replayUpload=");
        if (r127 == null) goto L119;
        boolean r140 = true;
    L120:
        r138.append(r140);
        r137.i("SharedAlbumUpload", r138.toString());
    L160:
        T r141 = r116.element;     // Catch: Throwable -> L145
        if (r141 != 0) goto L129;
        Intrinsics.throwUninitializedPropertyAccessException("joinedTask");     // Catch: Throwable -> L145
        c r142 = null;
    L130:
        Job r143 = r142.f300158c;     // Catch: Throwable -> L145
        if (r143 == null) goto L133;
        Job r144 = r143;
    L134:
        r102.L$0 = r114;     // Catch: Throwable -> L145
        r102.label = 1;     // Catch: Throwable -> L145
        if (r144.join(r102) != r104) goto L137;
        return r104;
    L137:
        r106 = r114;
        goto L139
    L133:
        Intrinsics.throwUninitializedPropertyAccessException("submissionJob");     // Catch: Throwable -> L145
        r144 = null;
        goto L134
    L129:
        r142 = (c) r141;     // Catch: Throwable -> L145
    L145:
        th = th;
        r106 = r114;
        goto L148
    L119:
        r140 = false;
        goto L120
    L115:
        r139 = false;
        goto L116
    L121:
        FLogger.f375446a.i("SharedAlbumUpload", "start shared upload, identifier=" + r114 + ", subscribers=" + r128);
        Job r145 = r136.f300158c;
        if (r145 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("submissionJob");
        r145 = null;
    L125:
        Boxing.boxBoolean(r145.start());
        goto L160
    L90:
        if (r115.element == 0) goto L92;
        boolean r146 = true;
    L93:
        r130.f300194x = r146;
        goto L94
    L92:
        r146 = false;
        goto L93
    L87:
        r130 = null;
        goto L88
    L81:
        r123 = r120;
    L153:
        th = move-exception;
        throw th;
    L65:
        if (r113.length() <= 0) goto L67;
        boolean r147 = true;
    L68:
        if (r147 == true) goto L71;
        r113 = null;
    L71:
        if (r113 != null) goto L73;
    L67:
        r147 = false;
        goto L68
    L61:
        return Boxing.boxBoolean(false);
    L22:
        if (z2.f365865a.fastAlbumSingleUploadAttachmentSyncEnable() == true) goto L25;
        String r148 = "setting_disabled";
    L55:
        if (r148 == null) goto L58;
        FLogger.f375446a.i("SharedAlbumUpload", "skip shared upload, identifier=" + r210.f300235e.getFileIdentifier() + ", reason=" + r148);
        goto L57
    L58:
        r112 = new b(r111, r210.f300231a, String.valueOf(r210.f300235e.getUri()), r211);
        goto L59
    L25:
        if (r210.f300232b == true) goto L28;
        r148 = "not_multi_file";
        goto L55
    L28:
        if (r210.f300236f == false) goto L31;
        r148 = "skipped_attachment";
        goto L55
    L31:
        if (n1.d(r210.f300235e) == false) goto L33;
    L35:
        if (r211 != null) goto L37;
    L39:
        boolean r149 = false;
    L40:
        if (r149 == false) goto L42;
        r148 = "process_skip_upload";
        goto L55
    L42:
        Uri r150 = r210.f300235e.getUri();
        if (r150 == null) goto L45;
        String r151 = r150.toString();
    L46:
        if (r151 != null) goto L48;
    L51:
        boolean r152 = true;
    L52:
        if (r152 == false) goto L54;
        r148 = "empty_uri";
        goto L55
    L54:
        r148 = null;
        goto L55
    L48:
        if (r151.length() == 0) goto L51;
        r152 = false;
        goto L52
    L45:
        r151 = null;
        goto L46
    L37:
        if (r211.f520353c != true) goto L39;
        r149 = true;
        goto L40
    L33:
        if (n1.e(r210.f300235e) == true) goto L35;
        r148 = "unsupported_media_type";
    L7:
        r100 = new SharedAlbumUploadCoordinator$submit$1(this, r214);
        goto L8
    }
}
