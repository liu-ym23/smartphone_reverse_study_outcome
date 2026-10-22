package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h {
    public final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f a;
    public final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.q b;
    public final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.q c;
    public boolean d;
    public final k e;
    public final CommentUnifiedVoiceComponentAdvancedAdapter f;

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h
    public final void e() {
        i(false);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h
    public final boolean a() {
        return this.e.b();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h
    public final void d() {
        tt5.a.h("CommentVoice", "[controller] input dismissed");
        CommentUnifiedVoiceComponentAdvancedAdapter r0 = this.f;
        CommentUnifiedVoiceComponentAdvancedAdapter.a r1 = r0.h;
        if (r1 == null) goto L5;
        r0.e(r1, AdvancedVoiceFinishReason.DISMISS);
    L5:
        r0.s();
        this.e.b();
        k();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h
    public final void destroy() {
        tt5.a.h("CommentVoice", "[controller] destroy");
        CommentUnifiedVoiceComponentAdvancedAdapter r0 = this.f;
        CommentUnifiedVoiceComponentAdvancedAdapter.a r1 = r0.h;
        if (r1 == null) goto L5;
        r0.e(r1, AdvancedVoiceFinishReason.DESTROY);
    L5:
        r0.s();
        this.e.destroy();
        k();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h
    public final void g() {
        tt5.a.h("CommentVoice", "[controller] switch back to text bar");
        CommentUnifiedVoiceComponentAdvancedAdapter r0 = this.f;
        CommentUnifiedVoiceComponentAdvancedAdapter.a r1 = r0.h;
        if (r1 == null) goto L6;
        r0.e(r1, AdvancedVoiceFinishReason.CANCEL);
        r0.s();
    L6:
        this.e.b();
        k();
        Function0<Unit> r2 = this.a.p;
        if (r2 == null) goto L10;
        r2.invoke();
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h
    public final void h() {
        Function0<Boolean> r0 = this.a.H;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        tt5.a.h("CommentVoice", "[controller] primary voice click intercepted");
        return;
    L11:
        i(true);
        return;
    L5:
        if (((Boolean) r0.invoke()).booleanValue() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void k() {
        Function1<Boolean, Unit> r0 = this.a.q;
        if (r0 == null) goto L5;
        r0.invoke(Boolean.FALSE);
    L5:
        Function0<View> r1 = this.a.l;
        if (r1 == null) goto L8;
        View r2 = (View) r1.invoke();
    L10:
        if (this.b.b() == false) goto L12;
    L13:
        m(false);
    L14:
        l();
        boolean r3 = true;
        if (r2 != null) goto L17;
    L19:
        boolean r4 = false;
    L20:
        if (r4 == true) goto L27;
        if (r2 != null) goto L23;
    L25:
        r3 = false;
    L26:
        if (r3 == true) goto L27;
    L28:
        j(false);
        return;
    L23:
        if (r2.getVisibility() != 4) goto L25;
    L27:
        r2.setVisibility(8);
        goto L28
    L17:
        if (r2.getVisibility() != 0) goto L19;
        r4 = true;
        goto L20
    L12:
        if (this.c.b() == false) goto L14;
    L8:
        r2 = null;
        goto L10
    }

    public final void l() {
        Function0<List<View>> r0 = this.a.s;
        if (r0 == null) goto L5;
        List r1 = (List) r0.invoke();
    L6:
        if (r1 != null) goto L8;
        r1 = CollectionsKt.emptyList();
    L8:
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L9:
        boolean r4 = false;
        if (r3.hasNext() == false) goto L16;
        Object r5 = r3.next();
        if (((View) r5).getVisibility() != 4) goto L14;
        r4 = true;
    L14:
        if (r4 == false) goto L9;
        r2.add(r5);
        goto L9
    L16:
        Iterator r6 = r2.iterator();
    L18:
        if (r6.hasNext() == false) goto L20;
        ((View) r6.next()).setVisibility(0);
        goto L18
    L20:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public f(com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f r9) {
        t r0 = t.a;
        Intrinsics.checkNotNullParameter(r9, "ctx");
        Intrinsics.checkNotNullParameter(r0, "sessionFactory");
        this.a = r9;
        this.b = new com.bytedance.ee.bear.middleground.comment.audio.voiceinput.q();
        this.c = new com.bytedance.ee.bear.middleground.comment.audio.voiceinput.q();
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.o r1 = r9.I;
        if (r1 == null) goto L10;
        Function2<com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p, CharSequence, Unit> r6 = r9.J;
        if (r6 == null) goto L7;
        Function0<ViewGroup> r3 = r1.a;
        Function0<com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p> r4 = r1.b;
        Function1<com.bytedance.ee.bear.middleground.comment.audio.voiceinput.p, Boolean> r5 = r1.c;
        Function1<Boolean, Unit> r7 = r1.e;
        Intrinsics.checkNotNullParameter(r3, "overlayContainerProvider");
        Intrinsics.checkNotNullParameter(r4, "targetSnapshotProvider");
        Intrinsics.checkNotNullParameter(r5, "targetValidator");
        Intrinsics.checkNotNullParameter(r6, "onFinalText");
        r1 = new com.bytedance.ee.bear.middleground.comment.audio.voiceinput.o(r3, r4, r5, r6, r7);
    L7:
        this.e = r0.a(r9, r1);
        this.f = new CommentUnifiedVoiceComponentAdvancedAdapter(r9, new CommentUnifiedVoiceComponentController$advancedAdapter$1(this));
        return;
    L10:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void i(boolean r4) {
        StringBuilder r0 = new StringBuilder("[controller] enter simple voice, location=");
        r0.append(this.a.j);
        r0.append(", aside=");
        r0.append(this.a.x);
        r0.append(", ");
        CommentVoiceLog r1 = CommentVoiceLog.a;
        String r2 = this.a.g;
        r1.getClass();
        r0.append(CommentVoiceLog.d("fileId", r2));
        tt5.a.h("CommentVoice", r0.toString());
        if (r4 == false) goto L7;
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f r5 = this.a;
        com.bytedance.ee.bear.middleground.comment.uitls.h r3 = r5.f;
        if (r3 == null) goto L7;
        r3.k(r5.j);
    L7:
        boolean r6 = this.e.c();
        tt5.a.h("CommentVoice", "[controller] enter simple voice result=" + r6);
        if (r6 == true) goto L10;
        return;
    L10:
        Function0<Unit> r7 = this.a.C;
        if (r7 == null) goto L13;
        r7.invoke();
    L13:
        Function1<Boolean, Unit> r8 = this.a.q;
        if (r8 == null) goto L16;
        r8.invoke(Boolean.TRUE);
    L16:
        m(true);
        Function0<Unit> r9 = this.a.o;
        if (r9 == null) goto L20;
        r9.invoke();
        return;
    }

    public final void j(boolean r3) {
        if (this.d != r3) goto L5;
        return;
    L5:
        this.d = r3;
        tt5.a.h("CommentVoice", "[controller] voice bar showing=" + r3);
        Function1<Boolean, Unit> r0 = this.a.F;
        if (r0 == null) goto L8;
        r0.invoke(Boolean.valueOf(r3));
    L8:
        Function1<Boolean, Unit> r1 = this.a.G;
        if (r1 == null) goto L12;
        r1.invoke(Boolean.valueOf(r3));
        return;
    }

    public final void m(boolean r11) {
        Function0<View> r0 = this.a.l;
        List r1 = null;
        if (r0 == null) goto L5;
        View r2 = (View) r0.invoke();
    L7:
        if (r2 != null) goto L10;
        tt5.a.k("CommentVoice", "[controller] switch bars aborted: voiceBar is null");
        return;
    L10:
        Function0<List<View>> r3 = this.a.s;
        if (r3 == null) goto L13;
        r1 = (List) r3.invoke();
    L13:
        if (r1 != null) goto L15;
        r1 = CollectionsKt.emptyList();
    L15:
        List r4 = r1;
        Set r5 = CollectionsKt.toSet(r4);
        List r6 = CollectionsKt.createListBuilder();
        Function0<View> r7 = this.a.k;
        if (r7 == null) goto L20;
        View r8 = (View) r7.invoke();
        if (r8 == null) goto L20;
        r6.add(r8);
    L20:
        Function0<List<View>> r9 = this.a.r;
        if (r9 == null) goto L25;
        List r10 = (List) r9.invoke();
        if (r10 == null) goto L25;
        r6.addAll(r10);
    L25:
        List r12 = CollectionsKt.build(r6);
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.iterator();
    L27:
        if (r14.hasNext() == false) goto L32;
        Object r15 = r14.next();
        if (r5.contains((View) r15) == true) goto L27;
        r13.add(r15);
        goto L27
    L32:
        if (r11 == false) goto L42;
        this.b.a();
        Iterator r16 = r13.iterator();
    L35:
        if (r16.hasNext() == false) goto L37;
        this.b.d((View) r16.next(), 8);
        goto L35
    L37:
        this.c.a();
        Iterator r17 = r4.iterator();
    L39:
        if (r17.hasNext() == false) goto L41;
        this.c.d((View) r17.next(), 4);
        goto L39
    L41:
        r2.setVisibility(0);
        j(true);
    L43:
        tt5.a.h("CommentVoice", "[controller] switch bars showVoice=" + r11 + ", textViewCount=" + r13.size() + ", invisibleViewCount=" + r1.size());
        return;
    L42:
        r2.setVisibility(8);
        this.b.c(r13, 0);
        this.c.c(r4, 0);
        j(false);
        goto L43
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h
    public final boolean b(View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "event");
        return this.f.k(r2, r3);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h
    public final boolean c(View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "event");
        this.f.k(r2, r3);
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h
    public final boolean f(View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "event");
        return this.e.onTouch(r2, r3);
    }
}
