package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import android.content.Context;
import com.ss.android.lark.coremd.facade.bizext.IMContextExtend;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f412527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f412528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.richtextmd.parse.ext.b f412529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<? extends com.ss.android.lark.coremd.base.parse.g> f412530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.ss.android.lark.coremd.base.parse.j f412531e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.ss.android.lark.coremd.base.parse.b f412532f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<? extends com.ss.android.lark.coremd.base.parse.f> f412533g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.ss.android.lark.widget.light.layout.h f412534h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f412527a, r101.f412527a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f412528b, r101.f412528b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f412529c, r101.f412529c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f412530d, r101.f412530d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f412531e, r101.f412531e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f412532f, r101.f412532f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f412533g, r101.f412533g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f412534h, r101.f412534h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((this.f412527a.hashCode() * 31) + this.f412528b.hashCode()) * 31) + this.f412529c.hashCode()) * 31) + this.f412530d.hashCode()) * 31) + this.f412531e.hashCode()) * 31) + this.f412532f.hashCode()) * 31) + this.f412533g.hashCode()) * 31) + this.f412534h.hashCode();
    }

    public final String toString() {
        return "TextLayoutRenderConfig(context=" + this.f412527a + ", uniqueId=" + this.f412528b + ", richTextParseConfig=" + this.f412529c + ", markdownPlugins=" + this.f412530d + ", markdownTheme=" + this.f412531e + ", markdownContext=" + this.f412532f + ", parseListeners=" + this.f412533g + ", textLayoutBuildConfig=" + this.f412534h + ')';
    }

    public final Context getContext() {
        return this.f412527a;
    }

    public final void a(com.ss.android.lark.coremd.base.parse.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f412532f = r100;
    }

    public n(Context r100, String r101, com.ss.android.lark.richtextmd.parse.ext.b r102, List<? extends com.ss.android.lark.coremd.base.parse.g> r103, com.ss.android.lark.coremd.base.parse.j r104, com.ss.android.lark.coremd.base.parse.b r105, List<? extends com.ss.android.lark.coremd.base.parse.f> r106, com.ss.android.lark.widget.light.layout.h r107) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uniqueId");
        Intrinsics.checkNotNullParameter(r102, "richTextParseConfig");
        Intrinsics.checkNotNullParameter(r103, "markdownPlugins");
        Intrinsics.checkNotNullParameter(r104, "markdownTheme");
        Intrinsics.checkNotNullParameter(r105, "markdownContext");
        Intrinsics.checkNotNullParameter(r106, "parseListeners");
        Intrinsics.checkNotNullParameter(r107, "textLayoutBuildConfig");
        this.f412527a = r100;
        this.f412528b = r101;
        this.f412529c = r102;
        this.f412530d = r103;
        this.f412531e = r104;
        this.f412532f = r105;
        this.f412533g = r106;
        this.f412534h = r107;
        com.ss.android.lark.coremd.ext.g.a(r105, IMContextExtend.A, new TextLayoutRenderConfig$applyTableConfig$1(this));
    }
}
