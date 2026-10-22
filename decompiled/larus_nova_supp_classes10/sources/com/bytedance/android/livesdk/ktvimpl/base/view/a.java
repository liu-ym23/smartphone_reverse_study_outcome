package com.bytedance.android.livesdk.ktvimpl.base.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends com.bytedance.android.livesdk.common.b {
    public final c b;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.base.view.a$a, reason: collision with other inner class name */
    public static final class C0013a {
        public final c a;
        public final Context b;

        public final Context getContext() {
            return this.b;
        }

        public C0013a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.b = r2;
            this.a = new c(new ArrayList());
        }

        public final void a(Function2 r5) {
            Intrinsics.checkNotNullParameter(r5, "listener");
            c r0 = this.a;
            r0.c = new b(new SpannableString(s1.B(2131915442)), r5);
        }

        public final void b(int r3, Function2 r4) {
            Intrinsics.checkNotNullParameter(r4, "listener");
            String r5 = s1.B(r3);
            Intrinsics.checkNotNullParameter(r5, "itemText");
            Intrinsics.checkNotNullParameter(r4, "listener");
            this.a.b.add(new b(r5, r4));
        }
    }

    public static final class b {
        public final CharSequence a;
        public final Function2<Dialog, View, Unit> b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(CharSequence r2, Function2<? super Dialog, ? super View, Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "itemText");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c {
        public final b a;
        public final List<b> b;
        public b c;
        public final int d;
        public final float e;
        public final int f;
        public final int g;

        public c(List r5) {
            int r0 = s1.h(2131107190);
            int r1 = s1.f(56.0f);
            int r2 = s1.h(2131107772);
            Intrinsics.checkNotNullParameter(r5, "itemList");
            this.a = null;
            this.b = r5;
            this.c = null;
            this.d = r0;
            this.e = 15.0f;
            this.f = r1;
            this.g = r2;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ a b;
        public final /* synthetic */ b c;

        public d(TextView r1, a r2, b r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            Function2<Dialog, View, Unit> r4 = this.c.b;
            if (r4 == null) goto L6;
            Unit r5 = (Unit) r4.invoke(this.b, this.a);
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View b() {
        View r0 = new View(getContext());
        r0.setBackgroundResource(2131107190);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, s1.f(1.0f)));
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TextView a(b r5) {
        TextView r0 = new TextView(getContext());
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, this.b.f));
        r0.setGravity(17);
        r0.setTextSize(1, this.b.e);
        r0.setTextColor(this.b.g);
        r0.setText(r5.a);
        r0.setOnClickListener(new d(r0, this, r5));
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r6) {
        super/*android.app.Dialog*/.onCreate(r6);
        View r7 = LayoutInflater.from(getContext()).inflate(2131565426, null);
        if (r7 == null) goto L17;
        ViewGroup r8 = (ViewGroup) r7;
        b r0 = this.b.a;
        if (r0 == null) goto L7;
        TextView r2 = new TextView(getContext());
        r2.setLayoutParams(new ViewGroup.LayoutParams(-1, this.b.f));
        r2.setGravity(17);
        r2.setTextSize(1, this.b.e);
        r2.setTextColor(this.b.g);
        r2.setText(r0.a);
        r8.addView(r2);
        r8.addView(b());
    L7:
        Iterator<T> r1 = this.b.b.iterator();
    L9:
        if (r1.hasNext() == false) goto L11;
        r8.addView(a((b) r1.next()));
        r8.addView(b());
        goto L9
    L11:
        b r3 = this.b.c;
        if (r3 == null) goto L14;
        View r4 = new View(getContext());
        r4.setBackgroundColor(this.b.d);
        r4.setLayoutParams(new ViewGroup.LayoutParams(-1, s1.f(8.0f)));
        r8.addView(r4);
        r8.addView(a(r3));
    L14:
        Unit r5 = Unit.INSTANCE;
        setContentView(r8);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public a(Context r2, c r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        super(r2, true);
        this.b = r3;
    }
}
