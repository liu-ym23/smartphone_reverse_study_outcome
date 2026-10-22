package com.larus.business.markdown.impl.markwon;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.business.markdown.api.depend.IMarkdownEnsureManagerKt;
import com.larus.business.markdown.impl.common.MarkdownConfigManager;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.noties.markwon.core.spans.CustomCitationSpan;
import io.noties.markwon.core.spans.CustomLinkSpan;
import io.noties.markwon.ext.tables.TableRowSpan2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class MarkwonContent implements lw8.l {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Object f320555n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SpannableStringBuilder f320556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f320557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f320558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f320559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final uvc.b f320560e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final lw8.h f320561f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<String, Integer> f320562g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f320563h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final WeakHashMap<View, List<psc.c>> f320564i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final WeakHashMap<View, List<com.larus.business.markdown.impl.markwon.core.spans.codeblock.f>> f320565j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final WeakHashMap<View, List<com.larus.business.markdown.impl.markwon.custom.title.b>> f320566k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f320567l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f320568m;

    public static final class Companion {
        public Companion() {
        }

        public static final String b(String r110) {
            Object r100 = MarkwonContent.f320555n;
            if (StringsKt.endsWith$default(r110, '\\', false, 2, null) == false) goto L5;
            String r101 = r110.substring(0, r110.length() - 1);
        L6:
            int r102 = StringsKt.lastIndexOf$default(r110, "\\(", 0, false, 6, null);
            int r111 = StringsKt.lastIndexOf$default(r110, ")", 0, false, 6, null);
            int r103 = StringsKt.lastIndexOf$default(r110, "\\[", 0, false, 6, null);
            int r104 = StringsKt.lastIndexOf$default(r110, "]", 0, false, 6, null);
            if (r111 >= r102) goto L12;
            if (r110 == null) goto L11;
            return r110.substring(0, r102);
        L11:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        L12:
            if (r104 >= r103) goto L18;
            if (r110 == null) goto L16;
            return r110.substring(0, r103);
        L16:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        L18:
            return r101;
        L5:
            r101 = r110;
            goto L6
        }

        public static final boolean a(Spanned r100, Class r101) {
            Object r102 = MarkwonContent.f320555n;
            boolean r103 = false;
            if (r100.getSpans(0, r100.length(), r101).length != 0) goto L6;
            r103 = true;
        L6:
            return !r103;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static final void e(TextView r100, Rect r101) {
            Object r102 = MarkwonContent.f320555n;
            if (r100 != 0) goto L6;
            return;
        L6:
            if ((r100 instanceof ow8.a) == false) goto L8;
            int r103 = ((ow8.a) r100).getMarkdownWidth();
        L9:
            if (r103 > 0) goto L11;
        L12:
            r103 = r100.getWidth();
        L13:
            int r104 = Math.max(0, (r103 - r100.getPaddingStart()) - r100.getPaddingEnd());
            r101.set(0, 0, r104, (r104 * 2) / 3);
            return;
        L11:
            if (r103 != Integer.MAX_VALUE) goto L13;
        L8:
            r103 = r100.getMaxWidth();
            goto L9
        }

        public static MarkwonContent j(MarkdownConfigManager r310, String r311) {
            Intrinsics.checkNotNullParameter(r310, "markdownConfigManager");
            Intrinsics.checkNotNullParameter(r311, "content");
            SpannableStringBuilder r100 = new SpannableStringBuilder(r311);
            gw8.c.f483071a.getClass();
            Application r101 = gw8.c.a.f483074c;
            if (r101 == null) goto L5;
            MarkwonStruct r102 = e.a(r101, r310, null, new lw8.d(com.larus.business.markdown.impl.common.utils.d.a(12), null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, 31), null);
        L7:
            return new MarkwonContent(r100, false, false, false, null, r102, null, true);
        L5:
            r102 = null;
            goto L7
        }

        public static Object k(MarkdownConfigManager r100, Function0 r101) {
            if (r100.b().j() == true) goto L16;
            Object r102 = MarkwonContent.f320555n;
            monitor-enter(r102);
            Object r103 = r101.invoke();     // Catch: Throwable -> L11
            monitor-exit(r102);
            return r103;
        L11:
            th = move-exception;
            throw th;
        L16:
            return r101.invoke();
        }

        public static final String c(String r100, boolean r101, MarkdownConfigManager r102) {
            Object r103 = MarkwonContent.f320555n;
            if (StringsKt.endsWith$default(r100, "\n", false, 2, null) == false) goto L5;
        L11:
            String r104 = r100.substring(0, r100.length() - 1);
        L13:
            if (r102.b().w() == false) goto L94;
            if (r101 == true) goto L95;
            StringBuilder r105 = new StringBuilder(r100);
            int r106 = com.larus.business.markdown.impl.common.a.f320522a;
            Intrinsics.checkNotNullParameter(r105, "source");
            int r107 = r105.length();
        L16:
            if (r107 <= 0) goto L66;
            r107 = r107 - 1;
            char r108 = r105.charAt(r107);
            if (r108 == ')') goto L19;
            if (r108 == '\n') goto L66;
            if (r108 == '(') goto L30;
            if (r108 == ']') goto L46;
            if (r108 != '[') goto L16;
            int r109 = r107 - 1;
            Character r110 = StringsKt.getOrNull(r105, r109);
            if (r110 == null) goto L64;
            if (r110.charValue() == '\\') goto L16;
        L64:
            r105.deleteCharAt(r107);
            com.larus.business.markdown.impl.common.a.b(r105, r109);
            goto L66
        L46:
            int r111 = r107 - 1;
            Character r112 = StringsKt.getOrNull(r105, r111);
            if (r112 == null) goto L52;
            if (r112.charValue() == '\\') goto L16;
        L52:
            int r113 = com.larus.business.markdown.impl.common.a.a(r105.toString(), r111);
            if (r113 < 0) goto L66;
            r105.delete(r107, r105.length());
            r105.deleteCharAt(r113);
            com.larus.business.markdown.impl.common.a.b(r105, r113 - 1);
            goto L66
        L30:
            int r114 = r107 - 1;
            Character r115 = StringsKt.getOrNull(r105, r114);
            if (r115 == null) goto L36;
            if (r115.charValue() == '\\') goto L16;
        L36:
            Character r116 = StringsKt.getOrNull(r105, r114);
            if (r116 == null) goto L16;
            if (r116.charValue() != ']') goto L16;
            int r117 = com.larus.business.markdown.impl.common.a.a(r105.toString(), r107 - 2);
            if (r117 < 0) goto L66;
            r105.delete(r114, r105.length());
            r105.deleteCharAt(r117);
            com.larus.business.markdown.impl.common.a.b(r105, r117 - 1);
            goto L66
        L19:
            Character r118 = StringsKt.getOrNull(r105, r107 - 1);
            if (r118 == null) goto L66;
            if (r118.charValue() == '\\') goto L16;
        L66:
            return r105.toString();
        L95:
            return r104;
        L94:
            return r104;
        L5:
            if (StringsKt.endsWith$default(r100, "\r", false, 2, null) == true) goto L11;
            if (StringsKt.endsWith$default(r100, "\r\n", false, 2, null) == false) goto L10;
            r104 = r100.substring(0, r100.length() - 2);
            goto L13
        L10:
            r104 = r100;
            goto L13
        }

        public static final void d(Context r100, int r101, Rect r102) {
            Object r103 = MarkwonContent.f320555n;
            if (r101 > 0) goto L5;
        L6:
            Resources r104 = r100.getResources();
            r101 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).widthPixels;
        L7:
            r102.set(0, 0, r101, (r101 * 2) / 3);
            return;
        L5:
            if (r101 != Integer.MAX_VALUE) goto L7;
            goto L6
        }

        @Deprecated(message = "尽量使用不包含TextView的同名类")
        public static MarkwonContent g(final MarkdownConfigManager r100, final ow8.a r101, final String r110, final boolean r111, final lw8.d r112, final Map r113) {
            Intrinsics.checkNotNullParameter(r100, "markdownConfigManager");
            Intrinsics.checkNotNullParameter(r110, "content");
            Intrinsics.checkNotNullParameter(r112, "customMarkDownInfo");
            return (MarkwonContent) k(r100, new MarkwonContent$Companion$create$1(r101, r100, r110, r111, r112, r113));
        }

        public static uvc.b i(final Context r110, final MarkdownConfigManager r111, final String r112, final boolean r113, final lw8.d r114, final lw8.h r115, final Function1 r116, final Function1 r117) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r111, "markdownConfigManager");
            Intrinsics.checkNotNullParameter(r112, "content");
            return (uvc.b) k(r111, new MarkwonContent$Companion$createNode$1(r115, r113, r110, r111, r114, r112, r117, r116));
        }

        public static MarkwonContent f(final Context r110, final MarkdownConfigManager r111, final int r112, final String r113, final boolean r114, final lw8.d r115, final lw8.h r116, final CharSequence r117, final Map r210) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r111, "markdownConfigManager");
            Intrinsics.checkNotNullParameter(r113, "content");
            Intrinsics.checkNotNullParameter(r115, "customMarkDownInfo");
            return (MarkwonContent) k(r111, new MarkwonContent$Companion$create$2(r116, r114, r110, r111, r112, r115, r210, r113, r117));
        }

        public static MarkwonContent h(final Context r110, final MarkdownConfigManager r111, final int r112, final uvc.b r113, final boolean r114, final lw8.d r115, final CharSequence r210, final Map r211, final lw8.h r212, final lw8.i r213, final Function1 r214) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r111, "markdownConfigManager");
            Intrinsics.checkNotNullParameter(r113, "node");
            Intrinsics.checkNotNullParameter(r115, "customMarkDownInfo");
            return (MarkwonContent) k(r111, new MarkwonContent$Companion$createFromNode$2(r212, r114, r110, r111, r112, r115, r211, r113, r213, r210, r214));
        }
    }

    static {
        new Companion();
        f320555n = new Object();
    }

    @Override // lw8.l
    public final List<lw8.g> c() {
        SpannableStringBuilder r100 = this.f320556a;
        return ArraysKt.toList(r100.getSpans(0, r100.length(), lw8.g.class));
    }

    @Override // lw8.l
    public final List<lw8.f> f() {
        SpannableStringBuilder r100 = this.f320556a;
        return ArraysKt.toList(r100.getSpans(0, r100.length(), lw8.f.class));
    }

    @Override // lw8.l
    public final HashMap<String, Integer> a() {
        return this.f320562g;
    }

    @Override // lw8.l
    public final SpannableStringBuilder e() {
        return this.f320556a;
    }

    @Override // lw8.l
    public final uvc.b getNode() {
        return this.f320560e;
    }

    public final void j(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        List<psc.c> r101 = this.f320564i.remove(r100);
        if (r101 == null) goto L8;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        psc.c r103 = (psc.c) r102.next();
        this.f320556a.removeSpan(r103);
        goto L6
    L10:
        return;
    }

    public final void k(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        List<com.larus.business.markdown.impl.markwon.core.spans.codeblock.f> r101 = this.f320565j.remove(r100);
        if (r101 == null) goto L27;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L27;
        com.larus.business.markdown.impl.markwon.core.spans.codeblock.f r103 = (com.larus.business.markdown.impl.markwon.core.spans.codeblock.f) r102.next();
        this.f320556a.removeSpan(r103);
    L27:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L13
        SpannableStringBuilder r105 = this.f320556a;     // Catch: Throwable -> L13
        int r106 = 0;
        Object[] r107 = r105.getSpans(0, r105.length(), TableRowSpan2.class);     // Catch: Throwable -> L13
        int r108 = r107.length;     // Catch: Throwable -> L13
    L9:
        if (r106 >= r108) goto L11;
        ((TableRowSpan2) r107[r106]).b(com.larus.business.markdown.impl.markwon.core.spans.codeblock.f.class);     // Catch: Throwable -> L13
        r106 = r106 + 1;     // Catch: Throwable -> L13
        goto L9
    L11:
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L30;
        Throwable r111 = r110.getCause();
        if (r111 == null) goto L32;
        String r112 = r110.getMessage();
        if (r112 == null) goto L33;
        com.larus.business.markdown.api.depend.c r113 = IMarkdownEnsureManagerKt.a();
        if (r113 == null) goto L31;
        r113.ensureNotReachHere(r111, r112);
        return;
    L31:
        return;
    L33:
        return;
    L32:
        return;
    L30:
        return;
    L13:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public final void l(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        List<com.larus.business.markdown.impl.markwon.custom.title.b> r101 = this.f320566k.remove(r100);
        if (r101 == null) goto L8;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        com.larus.business.markdown.impl.markwon.custom.title.b r103 = (com.larus.business.markdown.impl.markwon.custom.title.b) r102.next();
        this.f320556a.removeSpan(r103);
        goto L6
    L10:
        return;
    }

    @Override // lw8.l
    public final void b(Function0 r110, View.OnClickListener r111) {
        Intrinsics.checkNotNullParameter("f_link_type", "queryKey");
        Intrinsics.checkNotNullParameter("f_footnote", "queryValue");
        Intrinsics.checkNotNullParameter(r110, "callback");
        Intrinsics.checkNotNullParameter(r111, SendEventContainerMethodParamModel.EventKinds.onClick);
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L11
        SpannableStringBuilder r101 = this.f320556a;     // Catch: Throwable -> L11
        Object[] r102 = r101.getSpans(0, r101.length(), CustomLinkSpan.class);     // Catch: Throwable -> L11
        int r103 = r102.length;     // Catch: Throwable -> L11
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L9;
        CustomLinkSpan r112 = (CustomLinkSpan) r102[r104];     // Catch: Throwable -> L11
        if (StringsKt.lastIndexOf$default(r112.f492298b, "f_link_type=f_footnote", 0, false, 6, null) < 0) goto L8;
        r110.invoke();     // Catch: Throwable -> L11
        r112.f492293g = r111;     // Catch: Throwable -> L11
    L8:
        r104 = r104 + 1;     // Catch: Throwable -> L11
        goto L4
    L9:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // lw8.l
    public final void d(View r110, lw8.c r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        j(r110);
        SpannableStringBuilder r100 = this.f320556a;
        int r101 = 0;
        psc.d[] r102 = (psc.d[]) r100.getSpans(0, r100.length(), psc.d.class);
        ArrayList r103 = new ArrayList();
        int r104 = r102.length;
    L3:
        if (r101 >= r104) goto L5;
        psc.d r105 = r102[r101];
        int r106 = this.f320556a.getSpanStart(r105);
        int r107 = this.f320556a.getSpanEnd(r105);
        int r108 = this.f320556a.getSpanFlags(r105);
        psc.c r109 = new psc.c(r105, r111);
        r103.add(r109);
        this.f320556a.setSpan(r109, r106, r107, r108);
        r101 = r101 + 1;
        goto L3
    L5:
        this.f320564i.put(r110, r103);
    }

    @Override // lw8.l
    public final void g(View r110, final lw8.b r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        k(r110);
        int r100 = 0;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        SpannableStringBuilder r102 = this.f320556a;     // Catch: Throwable -> L8
        Object[] r103 = r102.getSpans(0, r102.length(), TableRowSpan2.class);     // Catch: Throwable -> L8
        int r104 = r103.length;     // Catch: Throwable -> L8
        int r105 = 0;
    L4:
        if (r105 >= r104) goto L6;
        ((TableRowSpan2) r103[r105]).h(CustomCitationSpan.class, new MarkwonContent$setCustomCitationSpansListener$1$1$1(r111));     // Catch: Throwable -> L8
        r105 = r105 + 1;     // Catch: Throwable -> L8
        goto L4
    L6:
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L21;
        Throwable r108 = r107.getCause();
        if (r108 == null) goto L21;
        String r109 = r107.getMessage();
        if (r109 == null) goto L21;
        com.larus.business.markdown.api.depend.c r112 = IMarkdownEnsureManagerKt.a();
        if (r112 == null) goto L21;
        r112.ensureNotReachHere(r108, r109);
    L21:
        SpannableStringBuilder r113 = this.f320556a;
        CustomCitationSpan[] r114 = (CustomCitationSpan[]) r113.getSpans(0, r113.length(), CustomCitationSpan.class);
        ArrayList r115 = new ArrayList();
        int r116 = r114.length;
    L22:
        if (r100 >= r116) goto L24;
        CustomCitationSpan r117 = r114[r100];
        int r118 = this.f320556a.getSpanStart(r117);
        int r119 = this.f320556a.getSpanEnd(r117);
        int r120 = this.f320556a.getSpanFlags(r117);
        com.larus.business.markdown.impl.markwon.core.spans.codeblock.f r121 = new com.larus.business.markdown.impl.markwon.core.spans.codeblock.f(r117, r111);
        r115.add(r121);
        this.f320556a.setSpan(r121, r118, r119, r120);
        r100 = r100 + 1;
        goto L22
    L24:
        this.f320565j.put(r110, r115);
        return;
    L8:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // lw8.l
    public final void h(View r110, gw8.a r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        l(r110);
        SpannableStringBuilder r100 = this.f320556a;
        int r101 = 0;
        com.larus.business.markdown.impl.markwon.custom.title.c[] r102 = (com.larus.business.markdown.impl.markwon.custom.title.c[]) r100.getSpans(0, r100.length(), com.larus.business.markdown.impl.markwon.custom.title.c.class);
        ArrayList r103 = new ArrayList();
        int r104 = r102.length;
    L3:
        if (r101 >= r104) goto L5;
        com.larus.business.markdown.impl.markwon.custom.title.c r105 = r102[r101];
        int r106 = this.f320556a.getSpanStart(r105);
        int r107 = this.f320556a.getSpanEnd(r105);
        int r108 = this.f320556a.getSpanFlags(r105);
        com.larus.business.markdown.impl.markwon.custom.title.b r109 = new com.larus.business.markdown.impl.markwon.custom.title.b(r105, r111);
        r103.add(r109);
        this.f320556a.setSpan(r109, r106, r107, r108);
        r101 = r101 + 1;
        goto L3
    L5:
        this.f320566k.put(r110, r103);
    }

    public static final void i(MarkwonContent r100, List r101, Class r110) {
        SpannableStringBuilder r102 = r100.f320556a;
        Object[] r111 = r102.getSpans(0, r102.length(), r110);
        int r103 = r111.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L14;
        int r105 = r100.f320556a.getSpanStart(r111[r104]);
        int r106 = r100.f320556a.getSpanEnd(r111[r104]);
        if (r105 < 0) goto L8;
        if (r105 > r106) goto L8;
        boolean r107 = true;
    L9:
        if (r107 == false) goto L13;
        if (r106 > r100.f320556a.length()) goto L13;
        Object r108 = r111[r104];
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type kotlin.Any");
        k r109 = new k(r108, r105, r106);
        ((ArrayList) r101).add(r109);
    L13:
        r104 = r104 + 1;
    L8:
        r107 = false;
        goto L9
    }

    public MarkwonContent(SpannableStringBuilder r100, boolean r101, boolean r102, boolean r103, uvc.b r104, lw8.h r105, HashMap r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r100, "markdown");
        this.f320556a = r100;
        this.f320557b = r101;
        this.f320558c = r102;
        this.f320559d = r103;
        this.f320560e = r104;
        this.f320561f = r105;
        this.f320562g = r106;
        this.f320563h = r107;
        this.f320564i = new WeakHashMap();
        this.f320565j = new WeakHashMap();
        this.f320566k = new WeakHashMap();
        this.f320567l = LazyKt.lazy(new MarkwonContent$readText$2(this));
        this.f320568m = LazyKt.lazy(new MarkwonContent$imageUrls$2(this));
    }
}
