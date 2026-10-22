package com.ss.android.lark.keyboard.edittext2.widget;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ExceptionsKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class p extends SpannableStringBuilder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f429278c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet<Class<?>> f429279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f429280b;

    public static final class a {
    }

    public static final class b implements TextWatcher, SpanWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f429281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f429282b;

        public b(Object r100) {
            Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
            this.f429281a = r100;
            this.f429282b = new AtomicInteger(0);
        }

        public static boolean a(Object r100) {
            if (r100 != null) goto L5;
            return false;
        L5:
            h r101 = h.f429267a;
            Intrinsics.checkNotNullParameter(r100, "span");
            Set<Class<? extends CharacterStyle>> r102 = h.f429268b;
            if ((r102 instanceof Collection) == true) goto L8;
        L10:
            Iterator<T> r103 = r102.iterator();
        L12:
            if (r103.hasNext() == false) goto L21;
            if (((Class) r103.next()).isInstance(r100) == false) goto L12;
            return true;
        L21:
            return false;
        L8:
            if (r102.isEmpty() == false) goto L10;
            return false;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            Log.d("SpannableBuilderCompat", "afterTextChanged: called");
            Object r101 = this.f429281a;
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.text.TextWatcher");
            ((TextWatcher) r101).afterTextChanged(r100);
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
            Log.d("SpannableBuilderCompat", "beforeTextChanged: called");
            Object r104 = this.f429281a;
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.text.TextWatcher");
            ((TextWatcher) r104).beforeTextChanged(r100, r101, r102, r103);
        }

        @Override // android.text.SpanWatcher
        public final void onSpanAdded(Spannable r100, Object r101, int r102, int r103) {
            if (this.f429282b.get() > 0) goto L5;
        L7:
            Log.d("SpannableBuilderCompat", "onSpanAdded: called, span is " + r101);
            Object r104 = this.f429281a;
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.text.SpanWatcher");
            ((SpanWatcher) r104).onSpanAdded(r100, r101, r102, r103);
            return;
        L5:
            if (a(r101) == false) goto L7;
        }

        @Override // android.text.SpanWatcher
        public final void onSpanRemoved(Spannable r100, Object r101, int r102, int r103) {
            if (this.f429282b.get() > 0) goto L5;
        L7:
            Log.d("SpannableBuilderCompat", "onSpanRemoved: called");
            Object r104 = this.f429281a;
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.text.SpanWatcher");
            ((SpanWatcher) r104).onSpanRemoved(r100, r101, r102, r103);
            return;
        L5:
            if (a(r101) == false) goto L7;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            Log.d("SpannableBuilderCompat", "onTextChanged: called");
            Object r104 = this.f429281a;
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.text.TextWatcher");
            ((TextWatcher) r104).onTextChanged(r100, r101, r102, r103);
        }

        @Override // android.text.SpanWatcher
        public final void onSpanChanged(Spannable r110, Object r111, int r112, int r113, int r114, int r115) {
            if (this.f429282b.get() > 0) goto L5;
        L7:
            Object r100 = this.f429281a;
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.text.SpanWatcher");
            ((SpanWatcher) r100).onSpanChanged(r110, r111, r112, r113, r114, r115);
            return;
        L5:
            if (a(r111) == false) goto L7;
        }
    }

    static {
    }

    public final void a() {
        Iterator<T> r100 = this.f429280b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((b) r100.next()).f429282b.incrementAndGet();
        goto L4
    }

    public final void b() {
        Iterator<T> r100 = this.f429280b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((b) r100.next()).onTextChanged(this, 0, super.length(), super.length());
        goto L4
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final /* bridge */ int length() {
        return super.length();
    }

    public final Object c(Object r100) {
        if (r100 == null) goto L6;
        Class<?> r101 = r100.getClass();
        if (CollectionsKt.contains(this.f429279a, r101) == false) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L9;
        return r100;
    L9:
        Iterator<b> r103 = this.f429280b.iterator();
    L11:
        if (r103.hasNext() == false) goto L15;
        b r104 = r103.next();
        if (Intrinsics.areEqual(r104.f429281a, r100) == false) goto L11;
    L16:
        b r105 = r104;
        if (r105 != null) goto L20;
        return r100;
    L20:
        return r105;
    L15:
        r104 = null;
    L6:
        r102 = false;
        goto L7
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final /* bridge */ char charAt(int r100) {
        return super.charAt(r100);
    }

    public final Object e(Object r100) {
        if (r100 == null) goto L6;
        Class<?> r101 = r100.getClass();
        if (CollectionsKt.contains(this.f429279a, r101) == false) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L10;
        return r100;
    L10:
        if (r100 == null) goto L14;
        b r103 = new b(r100);
        this.f429280b.add(r103);
        return r103;
    L14:
        throw new IllegalArgumentException("Required value was null.".toString());
    L6:
        r102 = false;
        goto L7
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanEnd(Object r100) {
        return super.getSpanEnd(c(r100));
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanFlags(Object r100) {
        return super.getSpanFlags(c(r100));
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanStart(Object r100) {
        return super.getSpanStart(c(r100));
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void removeSpan(Object r100) {
        Object r101 = c(r100);
        if (Intrinsics.areEqual(r101, r100) == false) goto L5;
    L7:
        super.removeSpan(r101);
        return;
    L5:
        if ((r101 instanceof b) == false) goto L7;
        this.f429280b.remove(r101);
        goto L7
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final CharSequence subSequence(int r100, int r101) {
        return new p(this.f429279a, this, r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final <T> T[] getSpans(int r100, int r101, Class<T> r102) {
        if (CollectionsKt.contains(this.f429279a, r102) == false) goto L15;
        Object[] r103 = super.getSpans(r100, r101, b.class);
        ArrayList r104 = new ArrayList();
        int r105 = r103.length;
        int r106 = 0;
        int r107 = 0;
    L5:
        if (r107 >= r105) goto L10;
        Object r108 = r103[r107];
        if (Intrinsics.areEqual(((b) r108).f429281a.getClass(), r102) == false) goto L9;
        r104.add(r108);
    L9:
        r107 = r107 + 1;
        goto L5
    L10:
        Object r109 = Array.newInstance(r102, r104.size());
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type kotlin.Array<T of com.ss.android.lark.keyboard.edittext2.widget.RichTextSpannableBuilder.getSpans>");
        T[] r110 = (T[]) ((Object[]) r109);
        int r111 = r104.size();
    L11:
        if (r106 >= r111) goto L13;
        r110[r106] = ((b) ListProtector.get(r104, r106)).f429281a;
        r106 = r106 + 1;
        goto L11
    L13:
        return r110;
    L15:
        return (T[]) super.getSpans(r100, r101, r102);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int nextSpanTransition(int r100, int r101, Class<?> r102) {
        if (CollectionsKt.contains(this.f429279a, r102) == false) goto L6;
        r102 = b.class;
    L6:
        return super.nextSpanTransition(r100, r101, r102);
    }

    public p(HashSet<Class<?>> r100, CharSequence r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "watcherClasses");
        Intrinsics.checkNotNullParameter(r101, "text");
        super(r101, r102, r103);
        this.f429279a = r100;
        this.f429280b = new CopyOnWriteArrayList();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void setSpan(Object r100, int r101, int r102, int r103) {
        if (DevEnvUtil.isDevelopPackage(LarkContext.getApplication()) == false) goto L11;
        super.setSpan(e(r100), r101, r102, r103);
        return;
    L11:
        super.setSpan(e(r100), r101, r102, r103);     // Catch: IndexOutOfBoundsException -> L8
        return;
    L8:
        e = move-exception;
        Log.e("SpannableBuilderCompat", "setSpan: failed: " + ExceptionsKt.stackTraceToString(e));
        Log.e("SpannableBuilderCompat", e, true);
        setSpan(r100, Math.min(Math.max(0, r101), super.length()), Math.max(Math.min(r102, super.length()), 0), r103);
    }

    public final void d(int r110, int r111, CharSequence r112, int r210, int r211) {
        Intrinsics.checkNotNullParameter(r112, "tb");
        a();
        if (Intrinsics.areEqual(r112, this) == true) goto L35;
        h r100 = h.f429267a;
        Intrinsics.checkNotNullParameter(this, "spannable");
        ArrayList r101 = new ArrayList();
        long r102 = System.nanoTime();
        Object[] r103 = getSpans(r110, r111, Object.class);
        Intrinsics.checkNotNull(r103);
        int r104 = r103.length;
        int r113 = 0;
        boolean r114 = false;
    L5:
        boolean r115 = true;
        if (r113 >= r104) goto L30;
        Object r116 = r103[r113];
        Intrinsics.checkNotNull(r116);
        Set<Class<? extends Object>> r117 = h.f429270d;
        if ((r117 instanceof Collection) == true) goto L10;
    L12:
        Iterator<T> r118 = r117.iterator();
    L14:
        if (r118.hasNext() == false) goto L18;
        if (((Class) r118.next()).isInstance(r116) == false) goto L14;
        boolean r119 = true;
    L19:
        if (r119 == false) goto L29;
        int r120 = getSpanStart(r116);
        int r121 = getSpanEnd(r116);
        if (r110 > r120) goto L25;
        if (r121 > r111) goto L25;
    L26:
        if (r115 == false) goto L28;
        r101.add(r116);
    L28:
        r114 = r114 & r115;
    L25:
        r115 = false;
    L29:
        r113 = r113 + 1;
    L18:
        r119 = false;
        goto L19
    L10:
        if (r117.isEmpty() == false) goto L12;
    L30:
        if (r114 == false) goto L33;
        Log.i("SpannableBuilderCompat", "removeSpanOnReplace: cost " + (System.nanoTime() - r102));
    L33:
        if ((!r101.isEmpty()) == false) goto L35;
        setSpan(new i(r101, this), 0, super.length(), 18);
    L35:
        super.replace(r110, r111, r112, r210, r211);
        Iterator<b> r105 = this.f429280b.iterator();
    L37:
        if (r105.hasNext() == false) goto L39;
        r105.next().f429282b.decrementAndGet();
        goto L37
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int r100, int r101, CharSequence r102, int r103, int r104) {
        d(r100, r101, r102, r103, r104);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ SpannableStringBuilder replace(int r100, int r101, CharSequence r102, int r103, int r104) {
        d(r100, r101, r102, r103, r104);
        return this;
    }
}
