package com.ss.android.lark.coremd.facade.gennode;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.ss.android.lark.coremd.impl.buildnode.ListItemBuildExtend;
import com.ss.android.lark.coremd.span.BlockQuoteSpan;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v7b.b0;
import v7b.i;
import v7b.q;
import v7b.s;
import x9b.g;

/* JADX INFO: loaded from: classes35.dex */
public final class SpanToNodeMappers {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SpanToNodeMappers f419704a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f419705b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f419706c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f419707d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f419708e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<u9b.d<? extends Object>> f419709f = null;

    public static final class a implements u9b.d<com.ss.android.lark.coremd.impl.buildnode.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<com.ss.android.lark.coremd.impl.buildnode.a> f419710a;

        public a() {
            this.f419710a = com.ss.android.lark.coremd.impl.buildnode.a.class;
        }

        @Override // u9b.d
        public final Class<com.ss.android.lark.coremd.impl.buildnode.a> a() {
            return this.f419710a;
        }

        @Override // u9b.d
        public final s b(Context r100, Spanned r101, com.ss.android.lark.coremd.impl.buildnode.a r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "spanned");
            com.ss.android.lark.coremd.impl.buildnode.a r103 = r102;
            SpannableStringBuilder r104 = (SpannableStringBuilder) r101;
            String r105 = r104.subSequence(r104.getSpanStart(r103), r104.getSpanEnd(r103)).toString();
            r103.getClass();
            Intrinsics.checkNotNullParameter(r105, "what");
            if (r103.f419830c == false) goto L5;
            boolean r106 = Intrinsics.areEqual(r105, r103.f419829b);
        L6:
            if (r106 == false) goto L9;
            s r107 = r103.f419828a;
            s r108 = r107.h();
            r108.f553567c.putAll(r107.f553567c);
            return r108;
        L9:
            return new b0(r105);
        L5:
            r106 = true;
            goto L6
        }
    }

    public static final class b implements u9b.d<y9b.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<y9b.a> f419711a;

        public b() {
            this.f419711a = y9b.a.class;
        }

        @Override // u9b.d
        public final Class<y9b.a> a() {
            return this.f419711a;
        }

        @Override // u9b.d
        public final s b(Context r100, Spanned r101, y9b.a r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "spanned");
            final y9b.a r103 = r102;
            final q r104 = new q();
            ListItemBuildExtend.a r105 = ListItemBuildExtend.f419820g;
            Function1<ListItemBuildExtend, Unit> r106 = new SpanToNodeMappers$list$1$1(r103, r104);
            r105.getClass();
            Intrinsics.checkNotNullParameter(r106, "action");
            r105.f419826c.b(r106);
            return r104;
        }
    }

    public static final class c implements u9b.d<BlockQuoteSpan> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<BlockQuoteSpan> f419712a;

        public c() {
            this.f419712a = BlockQuoteSpan.class;
        }

        @Override // u9b.d
        public final Class<BlockQuoteSpan> a() {
            return this.f419712a;
        }

        @Override // u9b.d
        public final s b(Context r100, Spanned r101, BlockQuoteSpan r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "spanned");
            return new v7b.b();
        }
    }

    public static final class d implements u9b.d<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<g> f419713a;

        public d() {
            this.f419713a = g.class;
        }

        @Override // u9b.d
        public final Class<g> a() {
            return this.f419713a;
        }

        @Override // u9b.d
        public final s b(Context r100, Spanned r101, g r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "spanned");
            return new i();
        }
    }

    public SpanToNodeMappers() {
    }

    static {
        f419704a = new SpanToNodeMappers();
        a r100 = new a();
        f419705b = r100;
        b r101 = new b();
        f419706c = r101;
        c r102 = new c();
        f419707d = r102;
        d r103 = new d();
        f419708e = r103;
        f419709f = CollectionsKt.listOf(new u9b.d[]{r100, r101, r102, r103});
    }
}
