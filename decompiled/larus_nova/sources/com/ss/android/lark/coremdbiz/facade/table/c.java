package com.ss.android.lark.coremdbiz.facade.table;

import android.content.Context;
import com.bytedance.android.livesdk.gift.model.n;
import com.ss.android.lark.coremd.base.parse.e;
import com.ss.android.lark.coremd.base.parse.f;
import com.ss.android.lark.coremd.base.parse.g;
import com.ss.android.lark.coremd.base.parse.j;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import com.ss.android.lark.widget.light.layout.h;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<g> f420168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f420169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<f> f420170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.coremd.base.parse.b f420171d;

    @Override // com.ss.android.lark.coremdbiz.facade.table.a
    public final b a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        t9b.b r101 = t9b.b.f545143a;
        com.ss.android.lark.coremd.impl.parse.b.a r102 = t9b.b.a(r100);
        c(r102, new TableCellLayoutParserFactoryImpl$newParser$parserBuilder$1(this));
        return new b(new com.ss.android.lark.coremd.impl.parse.b(r102), this);
    }

    @Override // com.ss.android.lark.coremdbiz.facade.table.a
    public final TextLayoutBuilder b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        TextLayoutBuilder r101 = new TextLayoutBuilder();
        new h(r100, 0, 0, 0.0f, 8190).a(r101);
        return r101;
    }

    public static void c(com.ss.android.lark.coremd.impl.parse.b.a r100, Function0 r101) {
        e r102 = (e) r101.invoke();
        Iterator<T> r103 = r102.f419540a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r100.e((g) r103.next());
        goto L4
    L6:
        List<f> r104 = r102.f419542c;
        if (r104 == null) goto L12;
        Iterator<T> r105 = r104.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        r100.b((f) r105.next());
    L12:
        r100.c(r102.f419541b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(List<? extends g> r100, j r101, List<? extends f> r102, com.ss.android.lark.coremd.base.parse.b r103) {
        Intrinsics.checkNotNullParameter(r100, n.KEY_PLUGINS);
        Intrinsics.checkNotNullParameter(r101, "theme");
        Intrinsics.checkNotNullParameter(r103, "outerContext");
        this.f420168a = r100;
        this.f420169b = r101;
        this.f420170c = r102;
        this.f420171d = r103;
    }
}
