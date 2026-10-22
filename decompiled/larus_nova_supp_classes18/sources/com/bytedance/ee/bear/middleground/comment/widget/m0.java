package com.bytedance.ee.bear.middleground.comment.widget;

import android.text.SpannableStringBuilder;
import android.widget.TextView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m0 implements CommentTextView.c {
    public final /* synthetic */ db5.k[] a;
    public final /* synthetic */ CommentTextView b;
    public final /* synthetic */ un5.a.InterfaceC0318a c;
    public final /* synthetic */ List<String> d;
    public final /* synthetic */ Ref.ObjectRef<Integer> e;
    public final /* synthetic */ Integer f;

    public static final class a extends db5.i<db5.a> {
        public final /* synthetic */ Ref.ObjectRef<Integer> e;
        public final /* synthetic */ Integer f;

        public final un5.d f(TextView r2, bo4.a r3) {
            un5.d r4 = super.f(r2, r3);
            Object r5 = this.e.element;
            if (r5 != null) goto L5;
        L7:
            Intrinsics.checkNotNull(r4);
            return r4;
        L5:
            if (this.f == null) goto L7;
            r4.e = ((Number) r5).intValue();
            r4.f = this.f.intValue();
            r4.a();
            goto L7
        }

        public final un5.e g(db5.a r1, bo4.a r2) {
            un5.e r3 = super.g(r1, r2);
            Object r4 = this.e.element;
            if (r4 == null) goto L5;
            r3.b = ((Number) r4).intValue();
        L5:
            Intrinsics.checkNotNull(r3);
            return r3;
        }

        public final un5.h h(db5.a r1, db5.j r2) {
            un5.h r3 = super.h(r1, r2);
            Object r4 = this.e.element;
            if (r4 == null) goto L5;
            r3.b = ((Number) r4).intValue();
        L5:
            Intrinsics.checkNotNull(r3);
            return r3;
        }

        public final un5.h i(db5.a r1, bo4.a r2) {
            un5.h r3 = super.i(r1, r2);
            Object r4 = this.e.element;
            if (r4 == null) goto L5;
            r3.b = ((Number) r4).intValue();
        L5:
            Intrinsics.checkNotNull(r3);
            return r3;
        }

        public final un5.l j(db5.a r1, bo4.a r2) {
            un5.l r3 = super.j(r1, r2);
            Object r4 = this.e.element;
            if (r4 == null) goto L5;
            r3.b = ((Number) r4).intValue();
        L5:
            Intrinsics.checkNotNull(r3);
            return r3;
        }

        public final un5.d e(SpannableStringBuilder r1, bo4.a r2, int r3) {
            un5.d r4 = super.e(r1, r2, r3);
            Object r5 = this.e.element;
            if (r5 != null) goto L5;
        L7:
            Intrinsics.checkNotNull(r4);
            return r4;
        L5:
            if (this.f == null) goto L7;
            r4.e = ((Number) r5).intValue();
            r4.f = this.f.intValue();
            r4.a();
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(CommentTextView r1, un5.a.InterfaceC0318a r2, List<String> r3, Ref.ObjectRef<Integer> r4, Integer r5) {
            this.e = r4;
            this.f = r5;
            super(r1, r2, r3);
        }
    }

    @Override // com.bytedance.ee.bear.middleground.comment.widget.CommentTextView.c
    public final CharSequence a(CharSequence r9) {
        String r0 = r9.toString();
        if (r0 != null) goto L13;
        r0 = "";
    L13:
        db5.a r1 = new db5.d().c(r0);     // Catch: Throwable -> L10
        db5.k[] r2 = this.a;     // Catch: Throwable -> L10
        if (r2 == null) goto L8;
        r1.d = r2;     // Catch: Throwable -> L10
    L8:
        return new a(this.b, this.c, this.d, this.e, this.f).c(r1).a;
    L10:
        th = move-exception;
        tt5.a.l("Comment#RichTextInjector", "Failed to parse atContent!", th);
        return r9;
    }

    public m0(db5.k[] r1, CommentTextView r2, un5.a.InterfaceC0318a r3, List<String> r4, Ref.ObjectRef<Integer> r5, Integer r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
