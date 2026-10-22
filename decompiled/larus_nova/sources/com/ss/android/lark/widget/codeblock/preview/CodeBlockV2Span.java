package com.ss.android.lark.widget.codeblock.preview;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import com.ss.android.lark.widget.codeblock.process.CodeBlockV2ProcessParams;
import com.ss.android.lark.widget.light.span.k;
import com.ss.android.lark.widget.span.g;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public class CodeBlockV2Span extends g implements k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f445686f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<LineContent> f445687g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CodeBlockV2ProcessParams f445688h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f445689i;

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f445687g, this.f445688h});
    }

    public final Context getContext() {
        return this.f445686f;
    }

    @Override // com.ss.android.lark.widget.light.span.k
    public final void b(int r110) {
        if (r110 != this.f445688h.getWholeWidth()) goto L5;
        return;
    L5:
        CodeBlockV2ProcessParams r111 = CodeBlockV2ProcessParams.copy$default(this.f445688h, r110, 0, 0, 0, null, null, null, 126, null);
        CodeBlockV2Drawable r100 = new CodeBlockV2Drawable(this.f445686f, this.f445687g, r111);
        Intrinsics.checkNotNullParameter(r100, "drawable");
        this.f448678c = r100;
        this.f445688h = r111;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CodeBlockV2Span) == true) goto L8;
        return false;
    L8:
        CodeBlockV2Span r101 = (CodeBlockV2Span) r100;
        if (Intrinsics.areEqual(this.f445687g, r101.f445687g) == true) goto L11;
    L13:
        return false;
    L11:
        if (Intrinsics.areEqual(this.f445688h, r101.f445688h) == false) goto L13;
        return true;
    }

    public CodeBlockV2Span(Context r100, List<LineContent> r101, CodeBlockV2ProcessParams r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "lineContents");
        Intrinsics.checkNotNullParameter(r102, "params");
        super(new CodeBlockV2Drawable(r100, r101, r102));
        this.f445686f = r100;
        this.f445687g = r101;
        this.f445688h = r102;
        this.f445689i = LazyKt.lazy(new CodeBlockV2Span$realContent$2(this));
        this.f448680e = r103;
    }
}
