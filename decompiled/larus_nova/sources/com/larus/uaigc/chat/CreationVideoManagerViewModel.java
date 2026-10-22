package com.larus.uaigc.chat;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes31.dex */
public final class CreationVideoManagerViewModel implements kh8.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f370387j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f370388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, View> f370389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, Integer> f370390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f370391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f370392e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f370393f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableSharedFlow<Unit> f370394g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap<String, Boolean> f370395h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f370396i;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f370397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f370398b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Rect f370399c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f370400d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f370397a, r101.f370397a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f370398b, r101.f370398b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f370399c, r101.f370399c) == true) goto L18;
            return false;
        L18:
            if (this.f370400d == r101.f370400d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f370397a.hashCode() * 31) + this.f370398b.hashCode()) * 31) + this.f370399c.hashCode()) * 31) + this.f370400d;
        }

        public final String toString() {
            return "VisibleVideo(vid=" + this.f370397a + ", view=" + this.f370398b + ", visibleRect=" + this.f370399c + ", verticalGap=" + this.f370400d + ')';
        }

        public b(String r100, View r101, Rect r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "vid");
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "visibleRect");
            this.f370397a = r100;
            this.f370398b = r101;
            this.f370399c = r102;
            this.f370400d = r103;
        }
    }

    static {
    }

    @Override // kh8.a
    public final void g() {
        BuildersKt.launch$default(this.f370388a, Dispatchers.getMain().getImmediate(), null, new CreationVideoManagerViewModel$onCreationPagerExit$1(this, null), 2, null);
    }

    @Override // kh8.a
    public final MutableSharedFlow h() {
        return (MutableSharedFlow) this.f370392e.getValue();
    }

    @Override // kh8.a
    public final MutableSharedFlow i() {
        return (MutableSharedFlow) this.f370393f.getValue();
    }

    @Override // kh8.a
    public final String b() {
        return this.f370391d;
    }

    public CreationVideoManagerViewModel(CoroutineScope r110) {
        Intrinsics.checkNotNullParameter(r110, "viewModelScope");
        this.f370388a = r110;
        this.f370389b = new ConcurrentHashMap();
        this.f370390c = new ConcurrentHashMap();
        this.f370392e = LazyKt.lazy(new l());
        this.f370393f = LazyKt.lazy(new m());
        this.f370394g = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.f370395h = new HashMap();
        BuildersKt.launch$default(r110, Dispatchers.getMain().getImmediate(), null, new CreationVideoManagerViewModel$bindObservers$1(this, null), 2, null);
        this.f370396i = LazyKt.lazy(new n());
    }

    public static Rect l(View r100) {
        boolean r101 = true;
        if (r100.isAttachedToWindow() == true) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
        return null;
    L13:
        if (r100.getWidth() > 0) goto L15;
    L18:
        if (r101 == false) goto L20;
        return null;
    L20:
        Rect r103 = new Rect();
        if (r100.getGlobalVisibleRect(r103) == true) goto L23;
        return null;
    L23:
        return r103;
    L15:
        if (r100.getHeight() <= 0) goto L18;
        r101 = false;
        goto L18
    L5:
        if (r100.isShown() == false) goto L8;
        r102 = false;
        goto L10
    }

    public static RecyclerView m(View r100) {
        Object r101 = r100.getParent();
    L4:
        if ((r101 instanceof View) == false) goto L16;
        if ((r101 instanceof RecyclerView) == false) goto L15;
        RecyclerView r102 = (RecyclerView) r101;
        RecyclerView.LayoutManager r103 = r102.getLayoutManager();
        if (r103 == null) goto L12;
        boolean r104 = true;
        if (r103.canScrollHorizontally() != true) goto L12;
    L13:
        if (r104 == false) goto L15;
        return r102;
    L12:
        r104 = false;
    L15:
        r101 = ((View) r101).getParent();
        goto L4
    L16:
        return null;
    }

    @Override // kh8.a
    public final Integer a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "vid");
        return this.f370390c.get(r100);
    }

    @Override // kh8.a
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "vid");
        this.f370389b.remove(r100);
        FLogger.f375446a.i("CreationVideoManagerVM", "onMdVideoViewRecycle: vid=" + r100 + ", viewCount=" + this.f370389b.size());
    }

    @Override // kh8.a
    public final Object f(Continuation<? super Unit> r100) {
        FLogger.f375446a.i("CreationVideoManagerVM", "checkAutoPlay: curBindMdVideoView.size=" + this.f370389b.size());
        MutableSharedFlow<Unit> r101 = this.f370394g;
        Unit r102 = Unit.INSTANCE;
        Object r103 = r101.emit(r102, r100);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        return r103;
    L5:
        return r102;
    }

    public static final String k(final CreationVideoManagerViewModel r110, Map r111) {
        ArrayList r100 = new ArrayList();
        Iterator r101 = ((HashMap) r111).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L15;
        Map.Entry r102 = (Map.Entry) r101.next();
        String r103 = (String) r102.getKey();
        View r104 = (View) r102.getValue();
        Rect r105 = l(r104);
        if (r105 != null) goto L8;
        FLogger.f375446a.d("CreationVideoManagerVM", "bindObservers: vid=" + r103 + ", calVisibleRect=null");
    L10:
        b r106 = null;
    L12:
        if (r106 == null) goto L4;
        r100.add(r106);
        goto L4
    L8:
        long r107 = ((long) r105.width()) * ((long) r105.height());
        long r112 = ((long) r104.getMeasuredWidth()) * ((long) r104.getMeasuredHeight());
        long r113 = ((90 * r112) + ((long) 99)) / ((long) 100);
        FLogger.f375446a.d("CreationVideoManagerVM", "bindObservers: vid=" + r103 + ", visibleArea=" + r107 + ", totalArea=" + r112 + ", threshold=" + r113);
        if (r107 < r113) goto L10;
        r106 = new b(r103, r104, r105, Math.abs(r105.centerY() - (((Number) r110.f370396i.getValue()).intValue() / 2)));
        goto L12
    L15:
        if (r100.isEmpty() == true) goto L19;
        String r108 = r110.f370391d;
        b r109 = (b) CollectionsKt.minWithOrNull(r100, new q(new p(new o(new i()), r108)));
        if (r109 == null) goto L19;
        final RecyclerView r114 = m(r109.f370398b);
        if (r114 == null) goto L41;
        Rect r115 = l(r114);
        if (r115 == null) goto L26;
        final Integer r116 = Integer.valueOf(r115.centerX());
    L27:
        b r117 = (b) SequencesKt.minWithOrNull(SequencesKt.filter(CollectionsKt.asSequence(r100), new j(r110, r114)), new q(new p(new o(new k(r116)), r108)));
        if (r117 == null) goto L32;
        String r118 = r117.f370397a;
        if (r118 == null) goto L32;
    L34:
        return r118;
    L32:
        r118 = r109.f370397a;
        goto L34
    L26:
        r116 = null;
        goto L27
    L41:
        return r109.f370397a;
    L19:
        return null;
    }

    @Override // kh8.a
    public final void d(String r100, VideoPlayView r101) {
        Intrinsics.checkNotNullParameter(r100, "vid");
        if (r101 != null) goto L5;
        return;
    L5:
        this.f370389b.put(r100, r101);
        FLogger.f375446a.i("CreationVideoManagerVM", "onMdVideoViewBind: vid=" + r100 + ", viewCount=" + this.f370389b.size());
    }

    @Override // kh8.a
    public final void e(String r100, Integer r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        BuildersKt.launch$default(this.f370388a, Dispatchers.getMain().getImmediate(), null, new CreationVideoManagerViewModel$onVideoDetailExit$1(this, r100, null), 2, null);
        if (r101 == null) goto L8;
        r101.intValue();
        this.f370390c.put(r100, r101);
        return;
    }

    @Override // kh8.a
    public final void j(String r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        BuildersKt.launch$default(this.f370388a, Dispatchers.getMain().getImmediate(), null, new CreationVideoManagerViewModel$onPlayOrPauseByUser$1(this, r100, r101, null), 2, null);
    }
}
