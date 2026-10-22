package com.ss.android.lark.coremd.impl.parse;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements com.ss.android.lark.coremd.base.parse.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f419863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.ss.android.lark.coremd.base.parse.g> f419864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.coremd.base.parse.j f419865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<com.ss.android.lark.coremd.base.parse.f> f419866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l.a f419867e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public j f419868f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g f419869g;

    public static final class a implements com.ss.android.lark.coremd.base.parse.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f419870a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<com.ss.android.lark.coremd.base.parse.g> f419871b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.ss.android.lark.coremd.base.parse.j f419872c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<com.ss.android.lark.coremd.base.parse.f> f419873d;

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f419870a = r100;
            this.f419871b = new ArrayList();
            this.f419872c = com.ss.android.lark.coremd.base.parse.l.b();
            this.f419873d = new ArrayList();
        }

        public final a b(com.ss.android.lark.coremd.base.parse.f r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            ((ArrayList) this.f419873d).add(r100);
            return this;
        }

        public final a c(com.ss.android.lark.coremd.base.parse.j r100) {
            Intrinsics.checkNotNullParameter(r100, "theme");
            this.f419872c.getValues().putAll(r100.getValues());
            return this;
        }

        public final CharSequence d(s r100) {
            Intrinsics.checkNotNullParameter(r100, "node");
            Intrinsics.checkNotNullParameter(r100, "node");
            return a(r100, com.ss.android.lark.coremd.base.parse.b.f419537a);
        }

        public final a e(com.ss.android.lark.coremd.base.parse.g r100) {
            Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
            ((ArrayList) this.f419871b).add(r100);
            return this;
        }

        @Override // com.ss.android.lark.coremd.base.parse.d
        public final CharSequence a(s r100, com.ss.android.lark.coremd.base.parse.b r101) {
            Intrinsics.checkNotNullParameter(r100, "node");
            Intrinsics.checkNotNullParameter(r101, "markdownContext");
            return new b(this).a(r100, r101);
        }
    }

    public b(a r100) {
        this.f419863a = r100.f419870a;
        List<com.ss.android.lark.coremd.base.parse.g> r101 = r100.f419871b;
        this.f419864b = r101;
        this.f419865c = r100.f419872c;
        this.f419866d = r100.f419873d;
        this.f419869g = new g();
        Iterator r102 = ((ArrayList) r101).iterator();
    L3:
        g r103 = null;
        if (r102.hasNext() == false) goto L10;
        com.ss.android.lark.coremd.base.parse.g r104 = (com.ss.android.lark.coremd.base.parse.g) r102.next();
        g r105 = this.f419869g;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("clickRegistry");
    L9:
        r104.b(r103);
        goto L3
    L8:
        r103 = r105;
        goto L9
    L10:
        j.a r106 = new j.a();
        Iterator r107 = ((ArrayList) this.f419864b).iterator();
    L12:
        if (r107.hasNext() == false) goto L14;
        ((com.ss.android.lark.coremd.base.parse.g) r107.next()).c(r106);
        goto L12
    L14:
        this.f419868f = new j(r106.f419900a);
        this.f419867e = new l.a();
        Iterator r108 = ((ArrayList) this.f419864b).iterator();
    L16:
        if (r108.hasNext() == false) goto L21;
        com.ss.android.lark.coremd.base.parse.g r109 = (com.ss.android.lark.coremd.base.parse.g) r108.next();
        l.a r110 = this.f419867e;
        if (r110 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("visitorBuilder");
        r110 = null;
    L20:
        r109.a(r110);
        goto L16
    L21:
        c r111 = new c(this);
        Iterator r112 = ((ArrayList) this.f419864b).iterator();
    L23:
        if (r112.hasNext() == false) goto L25;
        ((com.ss.android.lark.coremd.base.parse.g) r112.next()).d(r111);
        goto L23
    }

    @Override // com.ss.android.lark.coremd.base.parse.d
    public final CharSequence a(s r110, com.ss.android.lark.coremd.base.parse.b r111) {
        Intrinsics.checkNotNullParameter(r110, "node");
        Intrinsics.checkNotNullParameter(r111, "markdownContext");
        Context r100 = this.f419863a;
        j r101 = this.f419868f;
        l.a r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("spanFactory");
        j r103 = null;
    L6:
        g r104 = this.f419869g;
        if (r104 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("clickRegistry");
        g r105 = null;
    L10:
        d r106 = new d(r111, r100, r103, r105, this.f419865c, this.f419866d);
        l.a r112 = this.f419867e;
        if (r112 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("visitorBuilder");
    L14:
        r102.getClass();
        Intrinsics.checkNotNullParameter(r106, PerfLog.PARAM_KEY_CONTEXT_ID);
        l r113 = new l(r102.f419911a, r106);
        Iterator r107 = ((ArrayList) this.f419866d).iterator();
    L16:
        if (r107.hasNext() == false) goto L18;
        ((com.ss.android.lark.coremd.base.parse.f) r107.next()).b(r106, r110);
        goto L16
    L18:
        r113.a(r110);
        SpannableStringBuilder r114 = r113.f419910e;
        int r115 = r114.length();
        Character r108 = StringsKt.lastOrNull(r114);
        if (r108 != null) goto L22;
    L31:
        Iterator r116 = ((ArrayList) this.f419866d).iterator();
    L33:
        if (r116.hasNext() == false) goto L35;
        ((com.ss.android.lark.coremd.base.parse.f) r116.next()).g(r106, r114);
        goto L33
    L35:
        return r114;
    L22:
        if (r108.charValue() != '\n') goto L31;
        int r109 = r115 - 1;
        if (r114.getSpans(r109, r115, x9b.a.class).length != 0) goto L27;
        boolean r117 = true;
    L29:
        if ((!r117) == true) goto L31;
        r114.replace(r109, r115, "");
        goto L31
    L27:
        r117 = false;
        goto L29
    L13:
        r102 = r112;
        goto L14
    L9:
        r105 = r104;
        goto L10
    L5:
        r103 = r101;
        goto L6
    }
}
