package com.ss.android.lark.movable;

import android.os.Looper;
import com.bytedance.lark.lark_markdown_render_android.Lark_markdown_renderKt;
import com.bytedance.lark.lark_markdown_render_android.MovableDocumentInfo;
import com.bytedance.lark.lark_markdown_render_android.MovableRenderConfig;
import com.bytedance.lark.lark_markdown_render_android.MovableRenderUrlPreviewInlines;
import com.ss.android.lark.movable.attatchment.l;
import com.ss.android.lark.movable.attatchment.m;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes36.dex */
public final class MovableMarkdownDocumentParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f432561a = 0;

    static {
    }

    public MovableMarkdownDocumentParser() {
    }

    public static h a(String r100, float r101, MovableRenderConfig r102, MovableRenderUrlPreviewInlines r103, Function2 r104) {
        float r105 = RangesKt.coerceAtLeast(r101, 0.0f);
        CopyOnWriteArrayList<Function2<String, Float, m>> r106 = l.f432640a;
        if (r104 == null) goto L20;
        l.f432640a.addIfAbsent(r104);
    L20:
        MovableDocumentInfo r107 = Lark_markdown_renderKt.ffiParseMarkdownForClient(r100, r105, r102, r103);     // Catch: Throwable -> L14
        if (r104 == null) goto L10;
        l.f432640a.remove(r104);
    L10:
        if (r107 != null) goto L22;
        return null;
    L22:
        return new h(r107, new d(r107.m8423getDocumentIdpVg5ArA()));
    L14:
        th = move-exception;
        CopyOnWriteArrayList<Function2<String, Float, m>> r108 = l.f432640a;
        if (r104 == null) goto L19;
        l.f432640a.remove(r104);
    L19:
        throw th;
    }

    public static Object b(String r100, float r110, MovableRenderConfig r111, MovableRenderUrlPreviewInlines r112, Function2 r113, Continuation r114) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L7;
        return BuildersKt.withContext(Dispatchers.getIO(), new MovableMarkdownDocumentParser$parseMarkdownForClient$2(r100, r110, r111, r112, r113, null), r114);
    L7:
        return a(r100, r110, r111, r112, r113);
    }

    public static /* synthetic */ Object c(String r100, float r101, MovableRenderConfig r110, MovableRenderUrlPreviewInlines r111, Continuation r112, int r113) {
        if ((r113 & 4) == 0) goto L5;
        MovableRenderConfig r102 = null;
    L7:
        if ((r113 & 8) == 0) goto L9;
        MovableRenderUrlPreviewInlines r103 = null;
    L11:
        return b(r100, r101, r102, r103, null, r112);
    L9:
        r103 = r111;
        goto L11
    L5:
        r102 = r110;
        goto L7
    }
}
