package com.ss.android.lark.coremdbiz.facade.plugins.markdown;

import android.os.Looper;
import com.bytedance.lark.lark_markdown_render_android.MovableDocumentInfo;
import com.bytedance.lark.lark_markdown_render_android.MovableRenderConfig;
import com.bytedance.lark.lark_markdown_render_android.MovableRenderUrlPreviewInline;
import com.bytedance.lark.lark_markdown_render_android.MovableRenderUrlPreviewInlines;
import com.bytedance.lark.pb.basic.v1.ImageSetV2;
import com.ss.android.lark.coremd.impl.parse.j;
import com.ss.android.lark.coremd.impl.parse.l;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.movable.MovableMarkdownDocumentParser;
import com.ss.android.lark.movable.attatchment.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes35.dex */
public final class MarkdownPlugin implements com.ss.android.lark.coremd.base.parse.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f420111b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedHashMap<h, com.ss.android.lark.movable.h> f420112c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap<h, Deferred<com.ss.android.lark.movable.h>> f420113d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final CoroutineScope f420114e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final HashMap<a, Job> f420115f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f420116a;

    public static final class Companion {

        public static final class a implements Function2<String, Float, m> {
            public a() {
            }

            @Override // kotlin.jvm.functions.Function2
            public final m invoke(String r100, Float r101) {
                String r102 = r100;
                float r103 = r101.floatValue();
                Intrinsics.checkNotNullParameter(r102, "p1");
                return d.f420147a.a(r102, r103);
            }
        }

        public static void a() {
            LinkedHashMap<h, com.ss.android.lark.movable.h> r100 = MarkdownPlugin.f420112c;
            monitor-enter(r100);
            Log.d("MarkdownPlugin", "clear renderCache, size: " + r100.size());     // Catch: Throwable -> L11
            Iterator<T> r101 = r100.values().iterator();     // Catch: Throwable -> L11
        L6:
            if (r101.hasNext() == false) goto L8;
            ((com.ss.android.lark.movable.h) r101.next()).f432667b.a();     // Catch: Throwable -> L11
            goto L6
        L8:
            MarkdownPlugin.f420112c.clear();     // Catch: Throwable -> L11
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L11
            monitor-exit(r100);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public Companion() {
        }

        public static com.ss.android.lark.movable.h b(h r100) {
            LinkedHashMap<h, com.ss.android.lark.movable.h> r101 = MarkdownPlugin.f420112c;
            monitor-enter(r101);
            com.ss.android.lark.movable.h r102 = r101.get(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        public static void e(h r100, com.ss.android.lark.movable.h r101) {
            Intrinsics.checkNotNullParameter(r100, "renderKey");
            Intrinsics.checkNotNullParameter(r101, "parsedDocument");
            LinkedHashMap<h, com.ss.android.lark.movable.h> r102 = MarkdownPlugin.f420112c;
            monitor-enter(r102);
        L29:
            th = move-exception;
            throw th;
        L5:
            if (r102.containsKey(r100) == false) goto L18;
            StringBuilder r103 = new StringBuilder("putCachedDocument, docId: ");     // Catch: Throwable -> L29
            r103.append(UInt.m9590toStringimpl(r101.f432666a.m8423getDocumentIdpVg5ArA()));     // Catch: Throwable -> L29
            r103.append(", release id: ");     // Catch: Throwable -> L29
            com.ss.android.lark.movable.h r104 = r102.get(r100);     // Catch: Throwable -> L29
            if (r104 == null) goto L11;
            MovableDocumentInfo r105 = r104.f432666a;     // Catch: Throwable -> L29
            if (r105 == null) goto L11;
            UInt r106 = UInt.m9538boximpl(r105.m8423getDocumentIdpVg5ArA());     // Catch: Throwable -> L29
        L12:
            r103.append(r106);     // Catch: Throwable -> L29
            Log.d("MarkdownPlugin", r103.toString());     // Catch: Throwable -> L29
            com.ss.android.lark.movable.h r107 = r102.get(r100);     // Catch: Throwable -> L29
            if (r107 == null) goto L18;
            com.ss.android.lark.movable.d r108 = r107.f432667b;     // Catch: Throwable -> L29
            if (r108 == null) goto L18;
            r108.a();     // Catch: Throwable -> L29
        L11:
            r106 = null;
        L18:
            if (r102.size() < 20) goto L26;
            h r109 = (h) CollectionsKt.firstOrNull(r102.keySet());     // Catch: Throwable -> L29
            if (r109 == null) goto L26;
            com.ss.android.lark.movable.h r110 = r102.remove(r109);     // Catch: Throwable -> L29
            if (r110 == null) goto L26;
            com.ss.android.lark.movable.d r111 = r110.f432667b;     // Catch: Throwable -> L29
            if (r111 == null) goto L26;
            r111.a();     // Catch: Throwable -> L29
        L26:
            r102.put(r100, r101);     // Catch: Throwable -> L29
            Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L29
            monitor-exit(r102);
        }

        public static Object d(h r100, MovableRenderConfig r101, MovableRenderUrlPreviewInlines r110, Continuation r111) {
            com.ss.android.lark.movable.h r102 = b(r100);
            if (r102 == null) goto L5;
            return r102;
        L5:
            HashMap<h, Deferred<com.ss.android.lark.movable.h>> r103 = MarkdownPlugin.f420113d;
            monitor-enter(r103);
            Deferred<com.ss.android.lark.movable.h> r104 = r103.get(r100);     // Catch: Throwable -> L13
            if (r104 != null) goto L10;
            r104 = BuildersKt.async$default(MarkdownPlugin.f420114e, null, null, new MarkdownPlugin$Companion$parseAndCacheDocumentDedup$deferred$1$1(r100, r101, r110, null), 3, null);     // Catch: Throwable -> L13
            r103.put(r100, r104);     // Catch: Throwable -> L13
        L10:
            monitor-exit(r103);
            return r104.await(r111);
        L13:
            th = move-exception;
            throw th;
        }

        public final Object c(h r110, MovableRenderConfig r111, MovableRenderUrlPreviewInlines r112, Continuation<? super com.ss.android.lark.movable.h> r113) {
            if ((r113 instanceof MarkdownPlugin$Companion$parseAndCacheDocument$1) == false) goto L7;
            MarkdownPlugin$Companion$parseAndCacheDocument$1 r100 = (MarkdownPlugin$Companion$parseAndCacheDocument$1) r113;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            MarkdownPlugin$Companion$parseAndCacheDocument$1 r102 = r100;
            Object r114 = r102.result;
            Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r104 = r102.label;
            if (r104 == 0) goto L18;
            if (r104 != 1) goto L17;
            eab.e r115 = (eab.e) r102.L$1;
            h r116 = (h) r102.L$0;
            ResultKt.throwOnFailure(r114);     // Catch: Throwable -> L14
        L28:
            com.ss.android.lark.movable.h r117 = (com.ss.android.lark.movable.h) r114;     // Catch: Throwable -> L14
            if (r117 == null) goto L35;
            Companion r118 = MarkdownPlugin.f420111b;     // Catch: Throwable -> L14
            e(r116, r117);     // Catch: Throwable -> L14
            Log.d("MarkdownPlugin", "parseMarkdownForClient, docId: " + UInt.m9590toStringimpl(r117.f432666a.m8423getDocumentIdpVg5ArA()) + "，isMainThread：" + Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()));     // Catch: Throwable -> L14
            Map<String, ImageSetV2> r119 = r115.f471742k;
            if (r119 == null) goto L34;
            d r120 = d.f420147a;
            Intrinsics.checkNotNullParameter(r119, "sizeAttr");
            ((ArrayList) d.f420148b).remove(r119);
        L34:
            return r117;
        L35:
            Map<String, ImageSetV2> r121 = r115.f471742k;
            if (r121 == null) goto L52;
            d r122 = d.f420147a;
            Intrinsics.checkNotNullParameter(r121, "sizeAttr");
            ((ArrayList) d.f420148b).remove(r121);
            return null;
        L52:
            return null;
        L14:
            Throwable th10 = th;
            eab.e r123 = r115;
        L43:
            Map<String, ImageSetV2> r124 = r123.f471742k;
            if (r124 == null) goto L51;
            d r125 = d.f420147a;
            Intrinsics.checkNotNullParameter(r124, "sizeAttr");
            ((ArrayList) d.f420148b).remove(r124);
            throw th10;
        L51:
            throw th10;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            ResultKt.throwOnFailure(r114);
            if (r110.f420152a >= 20.0f) goto L21;
            Log.e("MarkdownPlugin", new Throwable());
        L21:
            r123 = r110.f420153b;
            String r105 = r123.f471741j;
            float r106 = r110.f420152a;
            Map<String, ImageSetV2> r107 = r123.f471742k;
            if (r107 == null) goto L47;
            d r108 = d.f420147a;
            Intrinsics.checkNotNullParameter(r107, "sizeAttr");
            ((ArrayList) d.f420148b).add(r107);
        L47:
            int r109 = MovableMarkdownDocumentParser.f432561a;     // Catch: Throwable -> L41
            a r126 = new a();     // Catch: Throwable -> L41
            r102.L$0 = r110;     // Catch: Throwable -> L41
            r102.L$1 = r123;     // Catch: Throwable -> L41
            r102.label = 1;     // Catch: Throwable -> L41
            Object r127 = MovableMarkdownDocumentParser.b(r105, r106, r111, r112, r126, r102);     // Catch: Throwable -> L41
            if (r127 != r103) goto L27;
            return r103;
        L27:
            r116 = r110;
            r115 = r123;
            r114 = r127;
        L41:
            th = move-exception;
            th10 = th;
        L7:
            r100 = new MarkdownPlugin$Companion$parseAndCacheDocument$1(this, r113);
            goto L8
        }
    }

    static {
        f420111b = new Companion();
        f420112c = new LinkedHashMap();
        f420113d = new HashMap();
        f420114e = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        f420115f = new HashMap();
    }

    public MarkdownPlugin() {
        this.f420116a = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public static String e(MovableRenderUrlPreviewInlines r100) {
        if (r100 == null) goto L6;
        List<MovableRenderUrlPreviewInline> r101 = r100.getItems();
        if (r101 == null) goto L6;
        String r102 = CollectionsKt.joinToString$default(r101, "\u001f", null, null, 0, null, MarkdownPlugin$toDigest$1.INSTANCE, 30, null);
    L7:
        if (r102 != null) goto L10;
        return "";
    L10:
        return r102;
    L6:
        r102 = null;
        goto L7
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void a(l.a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        r100.a(eab.e.class, new f());
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void b(com.ss.android.lark.coremd.impl.parse.g r100) {
        Intrinsics.checkNotNullParameter(r100, "registry");
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void c(j.a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        r100.a(eab.e.class, new e(this));
    }

    @Override // com.ss.android.lark.coremd.base.parse.g
    public final void d(com.ss.android.lark.coremd.impl.parse.c r100) {
        Intrinsics.checkNotNullParameter(r100, "registry");
    }
}
