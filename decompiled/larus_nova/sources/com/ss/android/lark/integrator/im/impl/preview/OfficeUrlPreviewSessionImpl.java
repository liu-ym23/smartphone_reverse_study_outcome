package com.ss.android.lark.integrator.im.impl.preview;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.home.impl.sdk.office.FlowOfficeUrlPreviewHostService;
import com.larus.nova.R;
import com.larus.office.card.urlpreview.v1;
import com.ss.android.lark.biz.officesdk.im.preview.UrlPreviewCardType;
import com.ss.android.lark.biz.officesdk.im.preview.UrlPreviewRenderResult;
import com.ss.android.lark.chat.preview.service.impl.UrlPreviewService;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.Url;
import com.ss.android.lark.export.entity.preview.UrlPreviewBody;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeUrlPreviewSessionImpl implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UrlPreviewService f427983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.chat.preview.service.d f427984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final sza.b f427985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final sza.d f427986d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.ss.android.lark.integrator.im.impl.preview.c f427987e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.ss.android.lark.integrator.im.impl.preview.a f427988f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CoroutineScope f427989g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f427990h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ConcurrentHashMap<String, Long> f427991i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ConcurrentHashMap<c, b> f427992j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f427993k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f427994l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final e f427995m;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f427996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final UrlPreviewCardType f427997b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f427998c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f427999d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f428000e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f427996a, r101.f427996a) == true) goto L12;
            return false;
        L12:
            if (this.f427997b == r101.f427997b) goto L15;
            return false;
        L15:
            if (this.f427998c == r101.f427998c) goto L18;
            return false;
        L18:
            if (this.f427999d == r101.f427999d) goto L21;
            return false;
        L21:
            if (this.f428000e == r101.f428000e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f427996a.hashCode() * 31) + this.f427997b.hashCode()) * 31;
            long r101 = this.f427998c;
            return ((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f427999d) * 31) + this.f428000e;
        }

        public final String toString() {
            return "RenderBuildKey(previewId=" + this.f427996a + ", cardType=" + this.f427997b + ", generation=" + this.f427998c + ", entityVersion=" + this.f427999d + ", maxWidth=" + this.f428000e + ')';
        }

        public b(String r100, UrlPreviewCardType r101, long r102, int r103, int r104) {
            Intrinsics.checkNotNullParameter(r100, "previewId");
            Intrinsics.checkNotNullParameter(r101, "cardType");
            this.f427996a = r100;
            this.f427997b = r101;
            this.f427998c = r102;
            this.f427999d = r103;
            this.f428000e = r104;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f428001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final UrlPreviewCardType f428002b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f428001a, r101.f428001a) == true) goto L12;
            return false;
        L12:
            if (this.f428002b == r101.f428002b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f428001a.hashCode() * 31) + this.f428002b.hashCode();
        }

        public final String toString() {
            return "RenderSlotKey(previewId=" + this.f428001a + ", cardType=" + this.f428002b + ')';
        }

        public c(String r100, UrlPreviewCardType r101) {
            Intrinsics.checkNotNullParameter(r100, "previewId");
            Intrinsics.checkNotNullParameter(r101, "cardType");
            this.f428001a = r100;
            this.f428002b = r101;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f428003a;

        public d(String r100) {
            this.f428003a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            int r101 = FlowChatModule.f422022d;
            FlowChatModule.a.a().a().getBrowserDependency().openUrl(r100.getContext(), this.f428003a);
        }
    }

    static {
    }

    public final sza.e c() {
        int r100 = ((v1) ((kc9.a) this.f427985c).f502683a).f362039a.f361778b;
        sza.e r101 = new sza.e(r100);
        Object r102 = this.f427993k;
        monitor-enter(r102);
        Integer r103 = this.f427994l;     // Catch: Throwable -> L13
        if (r103 != null) goto L8;
    L9:
        this.f427987e.d();     // Catch: Throwable -> L13
        this.f427994l = Integer.valueOf(r100);     // Catch: Throwable -> L13
    L10:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r102);
        return r101;
    L8:
        if (r103.intValue() == r100) goto L10;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.integrator.im.impl.preview.h, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f427990h.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        com.ss.android.lark.chat.preview.service.d r100 = this.f427984b;
        e r101 = this.f427995m;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "listener");
        com.ss.android.lark.sdk.f.b(r100.f416310a, r101, com.ss.android.lark.chat.preview.service.c.f416309a);
        CoroutineScopeKt.cancel$default(this.f427989g, null, 1, null);
        this.f427991i.clear();
        this.f427992j.clear();
        com.ss.android.lark.integrator.im.impl.preview.c r102 = this.f427987e;
        Object r103 = r102.f428009a;
        monitor-enter(r103);
        r102.f428010b.clear();     // Catch: Throwable -> L10
        r102.f428011c.clear();     // Catch: Throwable -> L10
        r102.f428012d.clear();     // Catch: Throwable -> L10
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r103);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.integrator.im.impl.preview.h
    public final void J(List<String> r210) {
        Intrinsics.checkNotNullParameter(r210, "previewIds");
        if (this.f427990h.get() == false) goto L5;
        return;
    L5:
        c();
        List r100 = SequencesKt.toList(SequencesKt.distinct(SequencesKt.filter(CollectionsKt.asSequence(r210), OfficeUrlPreviewSessionImpl$pullPreview$validIds$1.INSTANCE)));
        if (r100.isEmpty() == false) goto L8;
        return;
    L8:
        List r101 = r100;
        Iterator r102 = r101.iterator();
    L10:
        if (r102.hasNext() == false) goto L22;
        String r103 = (String) r102.next();
        com.ss.android.lark.integrator.im.impl.preview.c r104 = this.f427987e;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, "previewId");
        Object r110 = r104.f428009a;
        monitor-enter(r110);
        LinkedHashMap<String, f> r111 = r104.f428010b;     // Catch: Throwable -> L19
        f r105 = r111.get(r103);     // Catch: Throwable -> L19
        if (r105 != null) goto L16;
        f.b r112 = new f.b(r103, r104.a(r103), new PreviewHangPoint(null, null, null, r103, false, false, null));     // Catch: Throwable -> L19
        r111.put(r103, r112);     // Catch: Throwable -> L19
        r105 = r112;
    L16:
        f r106 = r105;     // Catch: Throwable -> L19
        monitor-exit(r110);
    L19:
        th = move-exception;
        throw th;
    L22:
        ArrayList r107 = new ArrayList();
        Iterator r108 = r101.iterator();
    L24:
        if (r108.hasNext() == false) goto L36;
        String r109 = (String) r108.next();
        f r113 = this.f427987e.c(r109);
        if (r113 != null) goto L29;
    L33:
        Pair r114 = null;
    L34:
        if (r114 == null) goto L24;
        r107.add(r114);
        goto L24
    L29:
        if (r113.a() != null) goto L33;
        if (this.f427991i.putIfAbsent(r109, Long.valueOf(r113.b())) != null) goto L33;
        r114 = TuplesKt.to(r109, Long.valueOf(r113.b()));
        goto L34
    L36:
        final Map r115 = MapsKt.toMap(r107);
        SyncDataStrategy r116 = SyncDataStrategy.TRY_LOCAL;
        if (r115.isEmpty() == true) goto L55;
        List r117 = CollectionsKt.toList(r115.keySet());
        final Function0<Unit> r118 = new OfficeUrlPreviewSessionImpl$requestEntities$onFinished$1(r115, this);
        UrlPreviewService r119 = this.f427983a;     // Catch: Throwable -> L42
        IGetDataCallback<Map<String, ? extends UrlCardPreviewEntity>> r120 = new OfficeUrlPreviewSessionImpl$requestEntities$1(this, r115, r118);     // Catch: Throwable -> L42
        r119.getClass();     // Catch: Throwable -> L42
        UrlPreviewService.c(r117, r116, r120);     // Catch: Throwable -> L42
        return;
    L42:
        th = move-exception;
        r118.invoke();
        throw th;
    }

    public final long b(String r100) {
        com.ss.android.lark.integrator.im.impl.preview.c r101 = this.f427987e;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "previewId");
        Object r102 = r101.f428009a;
        monitor-enter(r102);
        long r103 = r101.a(r100);     // Catch: Throwable -> L7
        monitor-exit(r102);
        return r103;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.integrator.im.impl.preview.h
    public final void s(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "previewId");
        if (this.f427990h.get() == false) goto L5;
        return;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L19;
        com.ss.android.lark.integrator.im.impl.preview.c r101 = this.f427987e;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "previewId");
        Object r102 = r101.f428009a;
        monitor-enter(r102);
        r101.f428010b.remove(r100);     // Catch: Throwable -> L13
        r101.f428012d.remove(r100);     // Catch: Throwable -> L13
        r101.f428011c.put(r100, Long.valueOf(r101.a(r100) + 1));     // Catch: Throwable -> L13
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r102);
        this.f427991i.remove(r100);
        CollectionsKt.removeAll(this.f427992j.keySet(), new OfficeUrlPreviewSessionImpl$removePreview$1(r100));
        UrlPreviewService r104 = this.f427983a;
        List r105 = CollectionsKt.listOf(r100);
        r104.getClass();
        UrlPreviewService.a(r105);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void f(Map<String, UrlCardPreviewEntity> r110, Map<String, Long> r111) {
        if (this.f427990h.get() == false) goto L5;
        return;
    L5:
        if (r110.isEmpty() == true) goto L43;
        com.ss.android.lark.integrator.im.impl.preview.c r100 = this.f427987e;
        Object r101 = r100.f428009a;
        monitor-enter(r101);
        Set r102 = CollectionsKt.toSet(r100.f428010b.keySet());     // Catch: Throwable -> L28
        monitor-exit(r101);
        int r103 = c().f544108a;
        Iterator<Map.Entry<String, UrlCardPreviewEntity>> r112 = r110.entrySet().iterator();
    L13:
        if (r112.hasNext() == false) goto L27;
        Map.Entry<String, UrlCardPreviewEntity> r104 = r112.next();
        String r105 = r104.getKey();
        UrlCardPreviewEntity r106 = r104.getValue();
        if (r111 == null) goto L19;
        Long r107 = r111.get(r105);
        if (r107 == null) goto L19;
        long r108 = r107.longValue();
    L21:
        if (r102.contains(r105) == false) goto L13;
        if (b(r105) != r108) goto L13;
        if (this.f427987e.f(r105, r108, r106) == false) goto L13;
        e(r105, r108, r106, r103);
    L19:
        r108 = b(r105);
        goto L21
    L27:
        return;
    L28:
        th = move-exception;
        throw th;
    }

    public final UrlPreviewRenderResult d(String r100, UrlPreviewCardType r101, ViewGroup r110) {
        if (this.f427990h.get() == true) goto L5;
        int r102 = c().f544108a;
        f r103 = this.f427987e.c(r100);
        if (r103 == null) goto L9;
        UrlCardPreviewEntity r104 = r103.a();
        if (r104 == null) goto L13;
        t6c.d r105 = this.f427987e.b(r100, r101, r102);
        if (r105 != null) goto L18;
        e(r100, r103.b(), r104, r102);
        return UrlPreviewRenderResult.NO_RENDER;
    L18:
        boolean r106 = true;
        if (r110.getChildCount() == 0) goto L21;
        boolean r107 = true;
    L22:
        String r108 = null;
        if (r107 == false) goto L25;
        View r109 = r110.getChildAt(0);
    L61:
        Intrinsics.checkNotNull(r109);     // Catch: Exception -> L58
        r105.a(r109);     // Catch: Exception -> L58
        r105.f();     // Catch: Exception -> L58
        UrlPreviewBody r111 = r104.getPreviewBody();     // Catch: Exception -> L58
        if (r111 == null) goto L42;
        Url r112 = r111.getCardUrl();     // Catch: Exception -> L58
        if (r112 == null) goto L42;
        String r113 = r112.getAndroidUrl();     // Catch: Exception -> L58
        if (r113 == null) goto L42;
        if (r113.length() <= 0) goto L35;
        boolean r114 = true;
    L36:
        if (r114 == true) goto L39;
        r113 = null;
    L39:
        if (r113 == null) goto L42;
    L41:
        r108 = r113;
    L54:
        if (r108 == null) goto L57;
        r109.setOnClickListener(new d(r108));     // Catch: Exception -> L58
    L57:
        return UrlPreviewRenderResult.SUCCESS;
    L35:
        r114 = false;
    L42:
        UrlPreviewBody r115 = r104.getPreviewBody();     // Catch: Exception -> L58
        if (r115 == null) goto L54;
        Url r116 = r115.getCardUrl();     // Catch: Exception -> L58
        if (r116 == null) goto L54;
        r113 = r116.getUrl();     // Catch: Exception -> L58
        if (r113 == null) goto L54;
        if (r113.length() > 0) goto L52;
        r106 = false;
    L52:
        if (r106 == false) goto L54;
    L58:
        e = move-exception;
        Log.e("UrlPreviewSession", "render error.", e);
        return UrlPreviewRenderResult.RENDER_FAILED;
    L25:
        LKUIRoundableLayout r117 = new LKUIRoundableLayout(r110.getContext(), null, 6, 0);
        r117.setId(R.id.preview_root_view);
        r110.addView(r117);
        r109 = r117;
        goto L61
    L21:
        r107 = false;
        goto L22
    L13:
        return UrlPreviewRenderResult.NO_DATA;
    L9:
        return UrlPreviewRenderResult.NO_DATA;
    L5:
        return UrlPreviewRenderResult.NO_DATA;
    }

    @Override // com.ss.android.lark.integrator.im.impl.preview.h
    public final UrlPreviewRenderResult j0(String r100, UrlPreviewCardType r101, ViewGroup r102) {
        Intrinsics.checkNotNullParameter(r100, "previewId");
        Intrinsics.checkNotNullParameter(r101, "cardType");
        Intrinsics.checkNotNullParameter(r102, KtvSubElement.CONTAINER);
        if (this.f427990h.get() == true) goto L17;
        if (StringsKt.isBlank(r100) == true) goto L17;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L18;
        Log.e("UrlPreviewSession", "renderPreview must be called on the main thread");
        return UrlPreviewRenderResult.RENDER_FAILED;
    L18:
        return d(r100, r101, r102);
    L13:
        th = move-exception;
        Log.e("UrlPreviewSession", "render preview failed: " + th);
        return UrlPreviewRenderResult.RENDER_FAILED;
    L17:
        return UrlPreviewRenderResult.NO_DATA;
    }

    public final void e(String r210, long r211, UrlCardPreviewEntity r212, int r213) {
        UrlPreviewCardType[] r110 = UrlPreviewCardType.values();
        int r111 = r110.length;
        int r112 = 0;
    L3:
        if (r112 >= r111) goto L29;
        UrlPreviewCardType r100 = r110[r112];
        if (this.f427987e.b(r210, r100, r213) != null) goto L28;
        if (this.f427990h.get() == true) goto L28;
        b r101 = new b(r210, r100, r211, r212.getInlineEntity().getVersion(), r213);
        c r102 = new c(r101.f427996a, r101.f427997b);
    L11:
        if (this.f427990h.get() == true) goto L23;
        b r103 = this.f427992j.get(r102);
        if (Intrinsics.areEqual(r103, r101) == true) goto L23;
        if (r103 == null) goto L17;
    L19:
        if (r103 == null) goto L11;
        if (this.f427992j.replace(r102, r103, r101) == false) goto L11;
    L22:
        boolean r104 = true;
    L24:
        if (r104 == false) goto L28;
        c r105 = new c(r210, r100);
        BuildersKt.launch$default(this.f427989g, null, null, new OfficeUrlPreviewSessionImpl$scheduleRenderBuild$1(this, r212, r100, r213, r210, r211, r105, r101, null), 3, null);
        goto L28
    L17:
        if (this.f427992j.putIfAbsent(r102, r101) != null) goto L19;
    L23:
        r104 = false;
    L28:
        r112 = r112 + 1;
        goto L3
    }

    public OfficeUrlPreviewSessionImpl(UrlPreviewService r100, com.ss.android.lark.chat.preview.service.d r101, kc9.a r102, FlowOfficeUrlPreviewHostService.b r103, LifecycleOwner r104, Context r105) {
        Intrinsics.checkNotNullParameter(r100, "urlPreviewService");
        Intrinsics.checkNotNullParameter(r101, "urlPreviewPush");
        Intrinsics.checkNotNullParameter(r102, "renderConfigProvider");
        Intrinsics.checkNotNullParameter(r105, "renderContext");
        this.f427983a = r100;
        this.f427984b = r101;
        this.f427985c = r102;
        this.f427986d = r103;
        this.f427987e = new com.ss.android.lark.integrator.im.impl.preview.c();
        this.f427988f = new com.ss.android.lark.integrator.im.impl.preview.a(r105, r104);
        this.f427989g = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
        this.f427990h = new AtomicBoolean(false);
        this.f427991i = new ConcurrentHashMap();
        this.f427992j = new ConcurrentHashMap();
        this.f427993k = new Object();
        e r106 = new e(this);
        this.f427995m = r106;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r106, "listener");
        ArrayList<ucb.a> r107 = r101.f416310a;
        if (r107.isEmpty() == false) goto L13;
        monitor-enter(r107);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (r107.isEmpty() == false) goto L8;
        com.ss.android.lark.sdk.g.e.f439875a.b(Command.PUSH_PREVIEWS, new com.ss.android.lark.chat.preview.service.b(r101));     // Catch: Throwable -> L10
    L8:
        monitor-exit(r107);     // Catch: Throwable -> L10
    L13:
        r107.add(r106);
    }

    public static final boolean a(OfficeUrlPreviewSessionImpl r110, String r111, long r112, UrlCardPreviewEntity r113, UrlPreviewCardType r114, t6c.d r115, int r116) {
        Object r100 = r110.f427993k;
        monitor-enter(r100);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (r110.f427990h.get() == false) goto L7;
    L16:
        boolean r101 = false;
    L17:
        monitor-exit(r100);
        return r101;
    L7:
        if (r110.b(r111) != r112) goto L16;
        Integer r102 = r110.f427994l;     // Catch: Throwable -> L19
        if (r102 == null) goto L16;
        if (r102.intValue() != r116) goto L16;
        if (r110.f427987e.g(r111, r112, r113, r114, r115, r116) == false) goto L16;
        r101 = true;
        goto L17
    }
}
