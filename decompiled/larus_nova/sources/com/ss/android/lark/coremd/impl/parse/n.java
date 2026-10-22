package com.ss.android.lark.coremd.impl.parse;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import com.ss.android.lark.coremd.base.parse.TextFutureRunner;
import com.ss.android.lark.coremd.base.parse.s;
import com.ss.android.lark.coremd.base.parse.w;
import com.ss.android.lark.coremd.base.parse.x;
import com.ss.android.lark.coremd.base.parse.y;
import com.ss.android.lark.coremdbiz.facade.plugins.t;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class n implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v7b.s f419914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SpannableStringBuilder f419915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f419916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f419917d;

    public static final class a implements x.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<SpannableStringBuilder> f419918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final y f419919b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e f419920c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<com.ss.android.lark.coremd.base.parse.f> f419921d;

        @Override // com.ss.android.lark.coremd.base.parse.x.a
        public final void a() {
            SpannableStringBuilder r100 = this.f419918a.get();
            if (r100 == null) goto L6;
            r100.removeSpan(this.f419919b);
            return;
        }

        @Override // com.ss.android.lark.coremd.base.parse.x.a
        public final void b(v7b.s r100, Spannable r101) {
            Intrinsics.checkNotNullParameter(r100, "node");
            Intrinsics.checkNotNullParameter(r101, "text");
            Iterator<T> r102 = this.f419921d.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            ((com.ss.android.lark.coremd.base.parse.f) r102.next()).a(r100, r101);
            goto L4
        L6:
            e r103 = this.f419920c;
            y r104 = this.f419919b;
            r103.getClass();
            Intrinsics.checkNotNullParameter(r104, "span");
            Intrinsics.checkNotNullParameter(r101, "text");
            List r105 = CollectionsKt.toList(r103.f419883a.keySet());
            boolean r106 = false;
            if (r105.isEmpty() == false) goto L9;
            r103.f419884b.put(r104, r101);
            boolean r107 = false;
        L14:
            if (r107 == false) goto L26;
            SpannableStringBuilder r108 = this.f419918a.get();
            if (r108 == null) goto L27;
            int r109 = r108.getSpanStart(this.f419919b);
            int r110 = r108.getSpanEnd(this.f419919b);
            if (r109 < 0) goto L21;
            if (r109 > r110) goto L21;
            r106 = true;
        L21:
            if (r106 == false) goto L28;
            r108.replace(r109, r110, "");
            r108.insert(r109, r101);
            return;
        L28:
            return;
        L27:
            return;
        L26:
            return;
        L9:
            Iterator r111 = r105.iterator();
        L11:
            if (r111.hasNext() == false) goto L13;
            ((e.a) r111.next()).b(r104, r101);
            goto L11
        L13:
            r107 = true;
            goto L14
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(WeakReference<SpannableStringBuilder> r100, y r101, e r102, List<? extends com.ss.android.lark.coremd.base.parse.f> r103) {
            Intrinsics.checkNotNullParameter(r100, "builderRef");
            Intrinsics.checkNotNullParameter(r101, "futureSpan");
            Intrinsics.checkNotNullParameter(r102, "nodeHandle");
            Intrinsics.checkNotNullParameter(r103, "parseListeners");
            this.f419918a = r100;
            this.f419919b = r101;
            this.f419920c = r102;
            this.f419921d = r103;
        }
    }

    @Override // com.ss.android.lark.coremd.base.parse.s
    public final n a() {
        boolean r100 = false;
        if (this.f419915b.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return this;
    L8:
        Character r102 = StringsKt.lastOrNull(this.f419915b);
        if (r102 != null) goto L12;
    L13:
        Intrinsics.checkNotNullParameter("\n", "text");
        this.f419915b.append("\n");
        return this;
    L12:
        if (r102.charValue() != '\n') goto L13;
        int r103 = this.f419915b.length();
        x9b.f[] r104 = (x9b.f[]) this.f419915b.getSpans(r103, r103, x9b.f.class);
        Intrinsics.checkNotNull(r104);
        if (r104.length != 0) goto L19;
        r100 = true;
    L19:
        if ((!r100) == false) goto L21;
        Intrinsics.checkNotNullParameter("\n", "text");
        this.f419915b.append("\n");
    L21:
        return this;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.ss.android.lark.coremd.base.parse.s
    public final n b() {
        this.f419915b.append('\n');
        return this;
    }

    @Override // com.ss.android.lark.coremd.base.parse.s
    public final int length() {
        return this.f419915b.length();
    }

    public final String toString() {
        return this.f419915b.toString();
    }

    @Override // com.ss.android.lark.coremd.base.parse.s
    public final n d(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f419915b.append(r100);
        return this;
    }

    @Override // com.ss.android.lark.coremd.base.parse.s
    public final n g(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        int r101 = length();
        this.f419915b.append(r100);
        this.f419916c.c(this.f419915b, r101, length());
        return this;
    }

    @Override // com.ss.android.lark.coremd.base.parse.s
    public final String c(int r100, int r101) {
        return this.f419915b.subSequence(r100, r101).toString();
    }

    @Override // com.ss.android.lark.coremd.base.parse.s
    public final void e(CharSequence r100, t r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "future");
        int r102 = this.f419915b.length();
        this.f419915b.append(r100);
        int r103 = this.f419915b.length();
        y r104 = new y(new TextFutureRunner(r101));
        WeakReference r105 = new WeakReference(this.f419915b);
        d r106 = this.f419917d;
        a r107 = new a(r105, r104, r106.f419882i, r106.f419881h);
        this.f419916c.a(this.f419915b, r104, r102, r103, 33);
        Intrinsics.checkNotNullParameter(r107, "handle");
        TextFutureRunner r108 = r104.f419546a;
        r108.getClass();
        Intrinsics.checkNotNullParameter(r107, "handle");
        if (r108.f419527b.compareTo(TextFutureRunner.State.IDLE) > 0) goto L7;
        r108.f419527b = TextFutureRunner.State.RUNNING;
        r108.f419526a.a(new TextFutureRunner.a(r108, r107));
        return;
    }

    @Override // com.ss.android.lark.coremd.base.parse.s
    public final void i(int r100, int r101) {
        w.a.a(this.f419916c, this.f419915b, this.f419914a, r100, r101);
    }

    @Override // com.ss.android.lark.coremd.base.parse.s
    public final void f(int r100, int r101, int r102) {
        this.f419916c.e(this.f419915b, this.f419914a, r100, r101, r102);
    }

    @Override // com.ss.android.lark.coremd.base.parse.s
    public final void h(int r100, int r101, int r102) {
        this.f419916c.b(this.f419915b, this.f419914a, r100, r101, r102);
    }

    public n(v7b.s r100, SpannableStringBuilder r101, MarkdownSpanSetterImpl r102, d r103) {
        Intrinsics.checkNotNullParameter(r100, "node");
        Intrinsics.checkNotNullParameter(r101, "builder");
        Intrinsics.checkNotNullParameter(r102, "spanSetter");
        Intrinsics.checkNotNullParameter(r103, "parseContext");
        this.f419914a = r100;
        this.f419915b = r101;
        this.f419916c = r102;
        this.f419917d = r103;
    }

    @Override // com.ss.android.lark.coremd.base.parse.s
    public final void setSpan(Object r100, int r101, int r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "span");
        this.f419916c.a(this.f419915b, r100, r101, r110, r111);
    }
}
