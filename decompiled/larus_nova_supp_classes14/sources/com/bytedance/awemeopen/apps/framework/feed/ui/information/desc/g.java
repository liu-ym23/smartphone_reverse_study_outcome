package com.bytedance.awemeopen.apps.framework.feed.ui.information.desc;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.awemeopen.apps.framework.feed.desc.FeedLongDescAnimator;
import com.bytedance.awemeopen.apps.framework.feed.mix.y;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.FeedSeekBarHelper;
import com.bytedance.awemeopen.bizmodels.feed.video.TextExtraStruct;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g extends BaseElement<s, t, com.bytedance.awemeopen.apps.framework.feed.ui.information.desc.a, jz3.a> {
    public final com.bytedance.awemeopen.apps.framework.framework.viewpager.o g;
    public CharSequence h;
    public boolean i;
    public boolean j;
    public boolean k;
    public r14.c l;
    public a m;

    public static final class a implements FeedSeekBarHelper.c {
        public final /* synthetic */ g a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.FeedSeekBarHelper.c
        public final void a(float r6) {
            final g r0 = this.a;
            if (r0.i == false) goto L5;
            return;
        L5:
            int r1 = this.b;
            if (r1 != 0) goto L12;
            Runnable r7 = new f(r0);
            c04.i.b();
            Handler r2 = c04.i.b;
            if (r2 == null) goto L10;
            r2.post(r7);
        L10:
            this.a.i = true;
            return;
        L12:
            float r3 = r1;
            if (this.c == 2) goto L15;
            long r4 = r0.g.getWatchDuration();
            if (this.c == 1) goto L25;
            return;
        L25:
            if (r4 <= (this.b * ECDraweeView.SQUARE)) goto L32;
            final g r8 = this.a;
            Runnable r5 = new e(r8);
            c04.i.b();
            Handler r9 = c04.i.b;
            if (r9 == null) goto L29;
            r9.post(r5);
        L29:
            this.a.i = true;
            return;
        L32:
            return;
        L15:
            if (r6 >= r3) goto L17;
            return;
        L17:
            Runnable r10 = new d(r0);
            c04.i.b();
            Handler r11 = c04.i.b;
            if (r11 == null) goto L20;
            r11.post(r10);
        L20:
            this.a.i = true;
        }

        public a(g r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.a b() {
        return new s();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b c() {
        return new t();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c d() {
        return new q(getContext(), g(), h());
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void k() {
        Objects.toString(this.h);
        this.k = true;
        t r0 = h();
        CharSequence r1 = this.h;
        r14.c r2 = this.l;
        if (r2 == null) goto L5;
        List r3 = r2.N();
    L6:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "desc");
        r0.a.b(new t.a(r1, r3));
        q();
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void m() {
        Objects.toString(this.h);
        h().c.b(Unit.INSTANCE);
        this.k = false;
        this.i = false;
        a r0 = this.m;
        if (r0 == null) goto L5;
        this.g.removePlayDurationChangeListener(r0);
    L5:
        this.m = null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void n() {
        Objects.toString(this.h);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void o() {
        FeedLongDescAnimator.d(FeedLongDescAnimator.a);
        FeedLongDescAnimator.d(FeedLongDescAnimator.c);
        FeedLongDescAnimator.d(FeedLongDescAnimator.b);
        Objects.toString(this.h);
        h().e.b(Unit.INSTANCE);
        this.i = false;
        this.j = false;
        this.l = null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void onCreate() {
        s r0 = g();
        Observer<Unit> r1 = new b(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        r0.a.a(r1);
        s r2 = g();
        Observer<Unit> r3 = new c(this);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "observer");
        r2.b.a(r3);
    }

    public final void q() {
        if (this.k == true) goto L5;
        return;
    L5:
        if (this.j == false) goto L30;
        r14.c r0 = this.l;
        if (r0 == null) goto L27;
        String r1 = r0.u();
        if (r1 != null) goto L12;
        return;
    L12:
        if (r1.length() != 0) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == false) goto L24;
        return;
    L24:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L21
        JSONObject r4 = new JSONObject(r1);     // Catch: Throwable -> L21
        int r5 = r4.optInt("auto_expand_text", 0);     // Catch: Throwable -> L21
        int r6 = r4.optInt("auto_expand_value", 0);     // Catch: Throwable -> L21
        if (r5 <= 0) goto L29;
        a r7 = new a(this, r6, r5);     // Catch: Throwable -> L21
        this.m = r7;     // Catch: Throwable -> L21
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r8 = this.g;     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L21
        r8.addPlayDurationChangeListener(r7);     // Catch: Throwable -> L21
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
        return;
    L29:
        return;
    L21:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L14:
        r2 = false;
        goto L15
    L27:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d e() {
        return com.bytedance.awemeopen.apps.framework.feed.ui.information.b.i;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void l(jz3.a r10) {
        jz3.a r11 = r10;
        Intrinsics.checkNotNullParameter(r11, "data");
        p();
        r14.c r12 = r11.a;
        if (r12.V() == true) goto L26;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        List r0 = r12.k();
        if (r0 == null) goto L26;
        if ((!r0.isEmpty()) == false) goto L26;
        r14.m r1 = (r14.m) ListProtector.get(r0, 0);
        if (r1 == null) goto L26;
        if (TextUtils.isEmpty(r1.a()) == true) goto L26;
        StringBuilder r4 = new StringBuilder("#");
        r4.append(r1.a());
        r4.append(" ");
        TextExtraStruct r6 = new TextExtraStruct();
        r6.setType(1);
        r6.setHashTagName(r1.a());
        r6.setStart(0);
        r6.setCid(r1.b());
        r6.setEnd(r4.length());
        if (r12.p() != null) goto L15;
        String r7 = "";
    L17:
        if (StringsKt.contains$default(r7, "#" + r1.a(), false, 2, null) == true) goto L26;
        r4.append(r12.p());
        r12.f0(r4.toString());
        int r2 = r6.getEnd() - r6.getStart();
        List r5 = r12.N();
        if (r5 == null) goto L24;
        Iterator r8 = r5.iterator();
    L22:
        if (r8.hasNext() == false) goto L25;
        TextExtraStruct r9 = (TextExtraStruct) r8.next();
        r9.setStart(r9.getStart() + r2);
        r9.setEnd(r9.getEnd() + r2);
    L25:
        r5.add(r6);
        goto L26
    L24:
        r5 = new ArrayList();
        r12.i0(r5);
        goto L25
    L15:
        r7 = r12.p();
    L26:
        List r3 = r12.N();
        if (r3 == null) goto L46;
        Iterator r13 = r3.iterator();
    L30:
        if (r13.hasNext() == false) goto L46;
        TextExtraStruct r14 = (TextExtraStruct) r13.next();
        if (r14 == null) goto L30;
        if (r14.getStart() >= 0) goto L36;
        r14.setStart(0);
    L36:
        int r15 = r14.getEnd();
        String r16 = r12.p();
        if (r16 != null) goto L40;
        r16 = "";
    L40:
        if (r15 <= r16.length()) goto L30;
        String r17 = r12.p();
        if (r17 != null) goto L44;
        r17 = "";
    L44:
        r14.setEnd(r17.length());
    L46:
        if (f().a() == false) goto L48;
        CharSequence r18 = y.a(r12);
    L49:
        this.h = r18;
        Objects.toString(r18);
        this.l = r12;
        this.j = true;
        q();
        return;
    L48:
        r18 = r12.p();
        goto L49
    }

    public g(Context r2, com.bytedance.awemeopen.apps.framework.framework.viewpager.o r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "vm");
        super(r2);
        this.g = r3;
        this.h = "";
    }
}
