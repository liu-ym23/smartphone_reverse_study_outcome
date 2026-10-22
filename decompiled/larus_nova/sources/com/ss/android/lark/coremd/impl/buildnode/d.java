package com.ss.android.lark.coremd.impl.buildnode;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.ss.android.lark.coremd.base.buildnode.NodeDisplayType;
import com.ss.android.lark.coremd.facade.gennode.SpanToNodeMappers;
import com.ss.android.lark.coremd.utils.NodeBISUUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.appdownloader.ah.DevicePlans;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import u9b.e;
import v7b.q;
import v7b.s;
import v7b.v;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f419838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Class<?>, u9b.d<Object>> f419839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u9b.c f419840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public u9b.b f419841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f419842e;

    public static final class a implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f419843a;

        public final List<Class<?>> c() {
            return CollectionsKt.toList(this.f419843a.f419839b.keySet());
        }

        public a(d r100) {
            this.f419843a = r100;
        }

        public final boolean d(s r100) {
            Intrinsics.checkNotNullParameter(r100, "node");
            NodeDisplayType r101 = this.f419843a.f419841d.a(r100);
            if (r101 != NodeDisplayType.Block) goto L5;
        L8:
            return true;
        L5:
            if (r101 == NodeDisplayType.NonContainerBlock) goto L8;
            return false;
        }

        public final boolean e(s r100) {
            Intrinsics.checkNotNullParameter(r100, "node");
            NodeDisplayType r101 = this.f419843a.f419841d.a(r100);
            if (r101 != NodeDisplayType.Block) goto L5;
        L8:
            return true;
        L5:
            if (r101 == NodeDisplayType.InlineBlock) goto L8;
            return false;
        }

        @Override // com.ss.android.lark.coremd.impl.buildnode.b.a
        public final int a(s r100, s r101) {
            Intrinsics.checkNotNullParameter(r100, DevicePlans.DEVICE_PLAN_OPPO1);
            Intrinsics.checkNotNullParameter(r101, DevicePlans.DEVICE_PLAN_OPPO2);
            return this.f419843a.f419840c.a(r100, r101);
        }

        public final s f(Class<? extends Object> r100, Spanned r101, Object r102) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "spanned");
            Intrinsics.checkNotNullParameter(r102, "span");
            u9b.d<Object> r103 = this.f419843a.f419839b.get(r100);
            if (r103 != null) goto L7;
            return null;
        L7:
            return r103.b(this.f419843a.f419838a, r101, r102);
        }

        public final List<s> b(s r100, CharSequence r101, int r102, char[] r103) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            Intrinsics.checkNotNullParameter(r101, "text");
            Intrinsics.checkNotNullParameter(r103, "bisuBitmap");
            boolean r104 = true;
            int r105 = 0;
            if ((r100 instanceof q) == true) goto L5;
        L9:
            boolean r106 = false;
        L10:
            if (r106 == true) goto L12;
            NodeBISUUtils.f419961c.getClass();
            Intrinsics.checkNotNullParameter(r101, "content");
            Intrinsics.checkNotNullParameter(r103, "flags");
            if (r101.length() == 0) goto L17;
            r104 = false;
        L17:
            if (r104 == true) goto L44;
            LinkedList r107 = new LinkedList();
            int r108 = 0;
        L21:
            if (r105 >= r101.length()) goto L32;
        L23:
            if (r105 >= r101.length()) goto L30;
            if (r101.charAt(r105) != '\n') goto L30;
            if (r105 <= r108) goto L28;
            r107.addAll(NodeBISUUtils.a(r108 + r102, r101.subSequence(r108, r105), r103));
        L28:
            r107.add(new v());
            r105 = r105 + 1;
            r108 = r105;
        L30:
            if (r105 >= r101.length()) goto L21;
            r105 = r105 + 1;
            goto L21
        L32:
            if (r105 <= r108) goto L45;
            CharSequence r109 = r101.subSequence(r108, r105);
            r107.addAll(NodeBISUUtils.a(r108 + r102, r109, r103));
            return r107;
        L45:
            return r107;
        L44:
            return CollectionsKt.emptyList();
        L12:
            return CollectionsKt.emptyList();
        L5:
            if (r101.length() != 1) goto L9;
            if (r101.charAt(0) != 8203) goto L9;
            r106 = true;
            goto L10
        }
    }

    public d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f419838a = r100;
        this.f419839b = new ConcurrentHashMap();
        this.f419840c = new com.ss.android.lark.coremd.facade.gennode.b();
        this.f419841d = new com.ss.android.lark.coremd.facade.gennode.a(0);
        u9b.a.a(this, CollectionsKt.listOf(new u9b.d[]{SpanToNodeMappers.f419705b, SpanToNodeMappers.f419706c, SpanToNodeMappers.f419707d, SpanToNodeMappers.f419708e}));
        com.ss.android.lark.coremd.facade.gennode.b r101 = new com.ss.android.lark.coremd.facade.gennode.b();
        Intrinsics.checkNotNullParameter(r101, "handler");
        this.f419840c = r101;
        com.ss.android.lark.coremd.facade.gennode.a r102 = new com.ss.android.lark.coremd.facade.gennode.a(0);
        Intrinsics.checkNotNullParameter(r102, "displayTypeMapper");
        this.f419841d = r102;
        this.f419842e = new a(this);
    }

    @Override // u9b.e
    public final d a(u9b.d r100) {
        Intrinsics.checkNotNullParameter(r100, "spanNodeMapper");
        Class<?> r101 = r100.a();
        this.f419839b.put(r101, r100);
        return this;
    }

    public final s b(Object r100) {
        Spanned r101 = (Spanned) r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        SpannableStringBuilder r102 = new SpannableStringBuilder(r101);
        int r103 = 0;
        x9b.e[] r104 = (x9b.e[]) r102.getSpans(0, r102.length(), x9b.e.class);
        int r105 = r104.length;
    L3:
        if (r103 >= r105) goto L5;
        x9b.e r106 = r104[r103];
        r102.replace(r102.getSpanStart(r106), r102.getSpanEnd(r106), "");
        r103 = r103 + 1;
        goto L3
    L5:
        b r107 = b.f419831a;
        return b.a(r102, this.f419842e);
    }
}
