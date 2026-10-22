package com.larus.gallery.tracker;

import android.content.Context;
import android.graphics.drawable.Animatable;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.gallery.dialog.d0;
import com.larus.gallery.dialog.e0;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.image.loader.b0;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.p0;
import com.larus.utils.y0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes29.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f344049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f344050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f344051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f344052d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f344053e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SimpleDraweeView f344054f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f344055g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f344056h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ThumbnailTrackerLayoutManager f344057i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ThumbnailAdapter f344058j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Job f344059k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ConcurrentHashMap<String, DataSource<Void>> f344060l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final HashSet<String> f344061m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f344062n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f344063o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f344064p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Job f344065q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f344066r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f344067s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AtomicBoolean f344068t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f344069u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f344070v;

    public interface a {
        void a(boolean r100);

        void b();

        void c(String r100);

        void d(int r100);

        boolean isMuted();
    }

    public interface b {
        void a();

        boolean b();

        void c();

        com.larus.gallery.api.k d(int r100);

        void e(int r100, g r101);

        int getPageSize();
    }

    public static final class c extends BaseControllerListener<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f344071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f344072b;

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onSubmit(String r100, Object r101) {
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onRelease(String r100) {
            FLogger.f375446a.i(this.f344071a.f344056h, "updateCoverImage onRelease pos:" + this.f344072b);
            super.onRelease(r100);
            this.f344071a.f344068t.set(false);
        }

        public c(i r100, int r101) {
            this.f344071a = r100;
            this.f344072b = r101;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFailure(String r100, Throwable r101) {
            FLogger r102 = FLogger.f375446a;
            String r103 = this.f344071a.f344056h;
            StringBuilder r104 = new StringBuilder("updateCoverImage onFailure pos:");
            r104.append(this.f344072b);
            r104.append(" error:");
            if (r101 == null) goto L5;
            String r105 = r101.getMessage();
        L6:
            r104.append(r105);
            r102.i(r103, r104.toString());
            this.f344071a.f344068t.set(false);
            return;
        L5:
            r105 = null;
            goto L6
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            FLogger.f375446a.i(this.f344071a.f344056h, "updateCoverImage onFinalImageSet pos:" + this.f344072b);
            this.f344071a.f344068t.set(false);
        }
    }

    public final void b() {
        Job r100 = this.f344059k;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f344059k = null;
        if ((!this.f344060l.isEmpty()) == false) goto L19;
        Iterator<T> r101 = this.f344060l.values().iterator();     // Catch: Throwable -> L14
    L9:
        if (r101.hasNext() == false) goto L12;
        ((DataSource) r101.next()).close();     // Catch: Throwable -> L14
    L12:
        this.f344060l.clear();
        return;
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.f344063o == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.f344067s, r100) == false) goto L12;
        Job r101 = this.f344065q;
        if (r101 == null) goto L9;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L9:
        e("onImageOrVideoLoaded");
        this.f344063o = false;
        return;
    }

    public final void e(String r100) {
        FLogger.f375446a.i(this.f344056h, "setCoverImageGone from:".concat(r100));
        e1.o(this.f344054f);
    }

    public final void f(List<com.larus.gallery.api.k> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        ThumbnailAdapter r101 = this.f344058j;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "newItems");
        FLogger.f375446a.i(r101.f343993a, "setItems newItems.size: " + r100.size());
        ((ArrayList) r101.f343994b).clear();
        ((ArrayList) r101.f343994b).addAll(r100);
        r101.notifyDataSetChanged();
        return;
    }

    public final void g(final int r100) {
        com.larus.gallery.api.k r101 = this.f344052d.d(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        Map<String, String> r102 = cb9.a.f23099a;
        Intrinsics.checkNotNullParameter(r101, "data");
        String r103 = cb9.a.a(r101);
        if (r103 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == false) goto L15;
        r103 = "";
    L21:
        if (this.f344068t.get() == false) goto L23;
        return;
    L23:
        this.f344068t.set(true);
        this.f344067s = com.larus.gallery.api.l.a(r101);
        String r105 = p0.a(r103);
        if (r105 == null) goto L26;
        ImageLoaderKt.y(this.f344054f, r105, "common.photo_dialog_preview_tracker_bitmap", new h(this, r100), 4);
        return;
    L26:
        e("fetchDecodedImage_url_invalid");
        this.f344068t.set(false);
        return;
    L15:
        if (b0.c(y0.j(r103)) == false) goto L21;
        FLogger r106 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder("url is expired, url = ");
        r107.append(r103);
        r107.append(" return:");
        LinkedHashMap r108 = (LinkedHashMap) cb9.a.f23099a;
        r107.append((String) r108.get(r103));
        r106.i("GalleryUtils", r107.toString());
        String r109 = (String) r108.get(r103);
        if (r109 == null) goto L21;
        r103 = r109;
        goto L21
    L8:
        if (r103.length() == 0) goto L11;
        r104 = false;
        goto L12
    }

    public final void d(int r100, com.larus.gallery.api.k r101) {
        Intrinsics.checkNotNullParameter(r101, "data");
        ThumbnailAdapter r102 = this.f344058j;
        if (r102 == null) goto L17;
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        if (r100 >= 0) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == true) goto L13;
        FLogger.f375446a.w(r102.f343993a, "replaceItem out of bounds position:" + r100 + " size:" + ((ArrayList) r102.f343994b).size());
        return;
    L13:
        if (Intrinsics.areEqual(ListProtector.get(r102.f343994b, r100), r101) == true) goto L19;
        ListProtector.set(r102.f343994b, r100, r101);
        r102.notifyItemChanged(r100);
        return;
    L19:
        return;
    L7:
        if (r100 >= ((ArrayList) r102.f343994b).size()) goto L9;
        r103 = true;
        goto L10
    }

    /* JADX WARN: Type inference failed for: r13v0, types: [com.larus.gallery.tracker.e] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00e4 -> B:55:0x013a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00f1 -> B:55:0x013a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00f9 -> B:55:0x013a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0128 -> B:54:0x012d). Please report as a decompilation issue!!! */
    public static final Object a(i r110, int r111, int r112, int r210, Continuation r211) {
        i r100 = r110;
        r110.getClass();
        if ((r211 instanceof ThumbnailListController$prefetchWindow$1) == false) goto L7;
        ThumbnailListController$prefetchWindow$1 r101 = (ThumbnailListController$prefetchWindow$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        int r106 = r101.I$1;
        int r107 = r101.I$0;
        String r108 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L54:
        r100.f344060l.put(r108, (DataSource) r103);
        r100.f344061m.add(r108);
        i r109 = r100;
    L55:
        if (r106 == r107) goto L66;
        r106 = r106 + 1;
    L60:
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L30
        Object r114 = Result.m9449constructorimpl(r109.f344052d.d(r106));     // Catch: Throwable -> L30
    L33:
        if (Result.m9455isFailureimpl(r114) == false) goto L35;
        r114 = null;
    L35:
        com.larus.gallery.api.k r115 = (com.larus.gallery.api.k) r114;
        if (r115 == null) goto L55;
        r108 = com.larus.gallery.api.l.a(r115);
        if (r109.f344060l.containsKey(r108) == true) goto L55;
        if (r109.f344061m.contains(r108) == true) goto L55;
        String r116 = cb9.a.a(r115);
        if (r116 == null) goto L62;
        if (r116.length() == 0) goto L62;
        if (0 != 0) goto L55;
        ?? r117 = new e();
        r101.L$0 = r108;
        r101.I$0 = r107;
        r101.I$1 = r106;
        r101.label = 1;
        Object r118 = ImageLoaderKt.C(r116, "common.photo_dialog_preview_tracker", r109, r117, r101, 24);
        if (r118 == r104) goto L65;
        i r119 = r109;
        r103 = r118;
        r100 = r119;
        goto L54
    L65:
        return r104;
    L62:
        if (1 != 0) goto L55;
    L30:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L66:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        ThumbnailAdapter r121 = r100.f344058j;
        if (r121 == null) goto L59;
        int r122 = r121.getItemCount();
        if (r122 <= 0) goto L63;
        if (r210 >= 0) goto L21;
        Pair r123 = TuplesKt.to(Boxing.boxInt(RangesKt.coerceAtLeast(r111 - r100.f344055g, 0)), Boxing.boxInt(RangesKt.coerceAtLeast(r111 - 1, -1)));
    L22:
        r106 = ((Number) r123.component1()).intValue();
        int r124 = ((Number) r123.component2()).intValue();
        if (r106 > r124) goto L64;
        FLogger.f375446a.i(r100.f344056h, "[prefetchWindow] start:" + r106 + " end:" + r124);
        if (r106 > r124) goto L66;
        r107 = r124;
        r109 = r100;
        goto L60
    L64:
        return Unit.INSTANCE;
    L21:
        r123 = TuplesKt.to(Boxing.boxInt(r112 + 1), Boxing.boxInt(RangesKt.coerceAtMost(r112 + r100.f344055g, r122 - 1)));
        goto L22
    L63:
        return Unit.INSTANCE;
    L59:
        return Unit.INSTANCE;
    L7:
        r101 = new ThumbnailListController$prefetchWindow$1(r100, r211);
        goto L8
    }

    public i(Context r100, LifecycleCoroutineScope r101, GalleryThumbnailView r102, e0 r103, d0 r104, SimpleDraweeView r105, int r106) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "scope");
        Intrinsics.checkNotNullParameter(r102, "recyclerView");
        Intrinsics.checkNotNullParameter(r103, "dataProvider");
        Intrinsics.checkNotNullParameter(r104, "callbacks");
        Intrinsics.checkNotNullParameter(r105, "coverImage");
        this.f344049a = r100;
        this.f344050b = r101;
        this.f344051c = r102;
        this.f344052d = r103;
        this.f344053e = r104;
        this.f344054f = r105;
        this.f344055g = r106;
        this.f344056h = "ThumbnailListController";
        this.f344060l = new ConcurrentHashMap();
        this.f344061m = new HashSet();
        this.f344066r = -1;
        this.f344067s = "";
        this.f344068t = new AtomicBoolean(false);
    }
}
