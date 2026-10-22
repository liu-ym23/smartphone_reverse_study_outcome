package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils;

import android.content.Context;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import pl.droidsonroids.gif.d;
import pl.droidsonroids.gif.m;

/* JADX INFO: loaded from: classes36.dex */
public final class SpannableStringUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f429999a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f430000b = null;

    public static final class a implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<TextView> f430001a;

        public a(TextView r100) {
            Intrinsics.checkNotNullParameter(r100, "textView");
            this.f430001a = new WeakReference(r100);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable r100) {
            Intrinsics.checkNotNullParameter(r100, "who");
            TextView r101 = this.f430001a.get();
            if (r101 == null) goto L6;
            r101.invalidate();
            return;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable r100, Runnable r101) {
            Intrinsics.checkNotNullParameter(r100, "who");
            Intrinsics.checkNotNullParameter(r101, "what");
            TextView r102 = this.f430001a.get();
            if (r102 == null) goto L6;
            r102.removeCallbacks(r101);
            return;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "who");
            Intrinsics.checkNotNullParameter(r101, "what");
            TextView r103 = this.f430001a.get();
            if (r103 == null) goto L6;
            r103.postDelayed(r101, r102);
            return;
        }
    }

    public SpannableStringUtils() {
    }

    static {
        f429999a = LazyKt.lazy(SpannableStringUtils$sDotLoadingDrawable$2.INSTANCE);
        f430000b = LazyKt.lazy(SpannableStringUtils$sDotLoadingCallback$2.INSTANCE);
    }

    public static void c(Editable r100) {
        d(r100, com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.a.class, SpannableStringUtils$removeDotDrawable$1.INSTANCE);
        d(r100, SuffixAsrSpan.class, SpannableStringUtils$removeDotDrawable$2.INSTANCE);
    }

    public static SpannableStringBuilder b(Context r100, CharSequence r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        SpannableStringBuilder r103 = new SpannableStringBuilder(r101);
        int r104 = r103.length();
        int r105 = Math.max(Math.min(r102, r104), 0);
        r103.setSpan(new SuffixAsrSpan(UIUtils.getColor(r100, R.color.text_placeholder)), r105, r104, 33);
        return r103;
    }

    public static void d(Editable r100, Class r101, Function1 r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r103 = 0;
    L6:
        if (r103 >= r100.length()) goto L14;
        int r104 = r100.nextSpanTransition(r103, r100.length(), r101);
        Iterator r105 = ArrayIteratorKt.iterator(r100.getSpans(r103, r104, r101));
    L9:
        if (r105.hasNext() == false) goto L13;
        Object r106 = r105.next();
        if (((Boolean) r102.invoke(r106)).booleanValue() == false) goto L9;
        r100.removeSpan(r106);
    L15:
        if (r103 < 0) goto L22;
        r100.delete(r103, r103 + 1);
        return;
    L22:
        return;
    L13:
        r103 = r104;
        goto L6
    L14:
        r103 = -1;
        goto L15
    }

    public static void e(SpannableStringBuilder r100, String r110, SuffixAsrSpan r111) {
        Intrinsics.checkNotNullParameter(r100, "resultSpanBuilder");
        Intrinsics.checkNotNullParameter(r111, "colorSpan");
        int r101 = r100.length();
        if (r101 <= 0) goto L16;
        boolean r102 = false;
        int r103 = RangesKt.coerceAtLeast(r101 - 3, 0);
        if (r110 != null) goto L7;
    L8:
        r102 = true;
    L9:
        if (r102 == true) goto L13;
        int r104 = StringsKt.lastIndexOf$default(r100.toString(), r110, 0, false, 6, null);
        if (r104 == (-1)) goto L13;
        r103 = Math.max(r103, r104 + r110.length());
    L13:
        if (r103 >= r101) goto L17;
        r100.setSpan(r111, r103, r101, 33);
        return;
    L17:
        return;
    L7:
        if (r110.length() != 0) goto L9;
    }

    public static SpannableStringBuilder a(Context r100, SpannableStringBuilder r101, a r102, PorterDuffColorFilter r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "spannable");
        d r104 = (d) f429999a.getValue();
        if (r104 != null) goto L5;
        return r101;
    L5:
        if (r103 == null) goto L7;
        r104.setColorFilter(r103);
    L7:
        r101.append(" ");
        int r105 = r101.length();
        r101.append(" ");
        int r106 = r101.length();
        Lazy r107 = f430000b;
        ((m) r107.getValue()).a(r102);
        r104.setCallback((m) r107.getValue());
        r104.setBounds(0, UIUtils.dp2px(r100, 8.0f), UIUtils.dp2px(r100, 19.0f), UIUtils.dp2px(r100, 11.0f));
        r101.setSpan(new com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.a(r104), r105, r106, 33);
        return r101;
    }
}
