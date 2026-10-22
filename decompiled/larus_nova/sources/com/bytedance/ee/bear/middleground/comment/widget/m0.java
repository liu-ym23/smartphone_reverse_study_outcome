package com.bytedance.ee.bear.middleground.comment.widget;

import android.text.SpannableStringBuilder;
import android.widget.TextView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes18.dex */
public final class m0 implements CommentTextView.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ db5.k[] f232354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CommentTextView f232355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ un5.a.InterfaceC7903a f232356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List<String> f232357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Integer> f232358e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Integer f232359f;

    public static final class a extends db5.i<db5.a> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<Integer> f232360e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Integer f232361f;

        @Override // db5.i
        public final un5.d f(TextView r100, bo4.a r101) {
            un5.d r102 = super.f(r100, r101);
            Integer r103 = this.f232360e.element;
            if (r103 != null) goto L5;
        L7:
            Intrinsics.checkNotNull(r102);
            return r102;
        L5:
            if (this.f232361f == null) goto L7;
            r102.f550779e = r103.intValue();
            r102.f550780f = this.f232361f.intValue();
            r102.a();
            goto L7
        }

        @Override // db5.i
        public final un5.e g(db5.a r100, bo4.a r101) {
            un5.e r102 = super.g(r100, r101);
            Integer r103 = this.f232360e.element;
            if (r103 == null) goto L5;
            r102.f550773b = r103.intValue();
        L5:
            Intrinsics.checkNotNull(r102);
            return r102;
        }

        @Override // db5.i
        public final un5.h h(db5.a r100, db5.j r101) {
            un5.h r102 = super.h(r100, r101);
            Integer r103 = this.f232360e.element;
            if (r103 == null) goto L5;
            r102.f550773b = r103.intValue();
        L5:
            Intrinsics.checkNotNull(r102);
            return r102;
        }

        @Override // db5.i
        public final un5.h i(db5.a r100, bo4.a r101) {
            un5.h r102 = super.i(r100, r101);
            Integer r103 = this.f232360e.element;
            if (r103 == null) goto L5;
            r102.f550773b = r103.intValue();
        L5:
            Intrinsics.checkNotNull(r102);
            return r102;
        }

        @Override // db5.i
        public final un5.l j(db5.a r100, bo4.a r101) {
            un5.l r102 = super.j(r100, r101);
            Integer r103 = this.f232360e.element;
            if (r103 == null) goto L5;
            r102.f550773b = r103.intValue();
        L5:
            Intrinsics.checkNotNull(r102);
            return r102;
        }

        @Override // db5.i
        public final un5.d e(SpannableStringBuilder r100, bo4.a r101, int r102) {
            un5.d r103 = super.e(r100, r101, r102);
            Integer r104 = this.f232360e.element;
            if (r104 != null) goto L5;
        L7:
            Intrinsics.checkNotNull(r103);
            return r103;
        L5:
            if (this.f232361f == null) goto L7;
            r103.f550779e = r104.intValue();
            r103.f550780f = this.f232361f.intValue();
            r103.a();
            goto L7
        }

        public a(CommentTextView r100, un5.a.InterfaceC7903a r101, List<String> r102, Ref.ObjectRef<Integer> r103, Integer r104) {
            this.f232360e = r103;
            this.f232361f = r104;
            super(r100, r101, r102);
        }
    }

    @Override // com.bytedance.ee.bear.middleground.comment.widget.CommentTextView.c
    public final CharSequence a(CharSequence r100) {
        String r101 = r100.toString();
        if (r101 != null) goto L13;
        r101 = "";
    L13:
        db5.a r102 = new db5.d().c(r101);     // Catch: Throwable -> L10
        db5.k[] r103 = this.f232354a;     // Catch: Throwable -> L10
        if (r103 == null) goto L8;
        r102.f467807d = r103;     // Catch: Throwable -> L10
    L8:
        return new a(this.f232355b, this.f232356c, this.f232357d, this.f232358e, this.f232359f).c(r102).f467817a;
    L10:
        th = move-exception;
        tt5.a.l("Comment#RichTextInjector", "Failed to parse atContent!", th);
        return r100;
    }

    public m0(db5.k[] r100, CommentTextView r101, un5.a.InterfaceC7903a r102, List<String> r103, Ref.ObjectRef<Integer> r104, Integer r105) {
        this.f232354a = r100;
        this.f232355b = r101;
        this.f232356c = r102;
        this.f232357d = r103;
        this.f232358e = r104;
        this.f232359f = r105;
    }
}
