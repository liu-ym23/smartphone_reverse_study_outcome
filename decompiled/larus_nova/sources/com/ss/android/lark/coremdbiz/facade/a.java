package com.ss.android.lark.coremdbiz.facade;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.ss.android.lark.coremd.facade.gennode.SpanToNodeMappers;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.span.InlineCodeCenterSpan;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C4949a f419975a = null;

    /* JADX INFO: renamed from: com.ss.android.lark.coremdbiz.facade.a$a, reason: collision with other inner class name */
    public static final class C4949a implements u9b.d<InlineCodeCenterSpan> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<InlineCodeCenterSpan> f419976a;

        public C4949a() {
            this.f419976a = InlineCodeCenterSpan.class;
        }

        @Override // u9b.d
        public final Class<InlineCodeCenterSpan> a() {
            return this.f419976a;
        }

        @Override // u9b.d
        public final s b(Context r100, Spanned r101, InlineCodeCenterSpan r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "spanned");
            InlineCodeCenterSpan r103 = r102;
            SpannableStringBuilder r104 = (SpannableStringBuilder) r101;
            return new v7b.d(r104.subSequence(r104.getSpanStart(r103), r104.getSpanEnd(r103)).toString());
        }
    }

    static {
        f419975a = new C4949a();
    }

    public static /* synthetic */ com.ss.android.lark.coremd.base.parse.j b() {
        t9b.e r100 = t9b.e.f545146a;
        return a(LarkMarkdownConfigKt$default$1.INSTANCE);
    }

    public static final List c() {
        Intrinsics.checkNotNullParameter(SpanToNodeMappers.f419704a, "<this>");
        return CollectionsKt.listOf(new u9b.d[]{SpanToNodeMappers.f419705b, SpanToNodeMappers.f419706c, SpanToNodeMappers.f419707d, SpanToNodeMappers.f419708e, f419975a});
    }

    public static final com.ss.android.lark.coremd.base.parse.j a(final Function2 r100) {
        Intrinsics.checkNotNullParameter(t9b.e.f545146a, "<this>");
        Intrinsics.checkNotNullParameter(r100, "action");
        return com.ss.android.lark.coremd.base.parse.l.a(LarkThemeExtend.f419998m, new LarkMarkdownConfigKt$default$2(r100));
    }
}
