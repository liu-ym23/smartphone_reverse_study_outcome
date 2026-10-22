package com.bytedance.ee.bear.middleground.comment.widget;

import android.text.SpannableString;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.bear.utils.AtUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class RichTextInjector {
    public static final /* synthetic */ int a = 0;

    public static final class a implements CommentTextView.b {
        public final /* synthetic */ String a;
        public final /* synthetic */ Lazy<Unit> b;

        @Override // com.bytedance.ee.bear.middleground.comment.widget.CommentTextView.b
        public final void G4(TextView r9) {
            Intrinsics.checkNotNullParameter(r9, "textView");
            int r0 = RichTextInjector.a;
            String r1 = this.a;
            this.b.getValue();
            CharSequence r10 = r9.getText();
            if ((r10 instanceof SpannableString) == false) goto L5;
            SpannableString r11 = (SpannableString) r10;
        L6:
            if (r11 == null) goto L17;
            int r4 = 0;
            un5.d[] r12 = (un5.d[]) r11.getSpans(0, r11.length(), un5.d.class);
            if (r12 == null) goto L18;
            ArrayList r2 = new ArrayList();
            ArrayList r3 = new ArrayList();
            int r5 = r12.length;
        L12:
            if (r4 >= r5) goto L14;
            un5.d r6 = r12[r4];
            r2.add(r6.c);
            r3.add(AtUtils.d(r6.getType()));
            r4 = r4 + 1;
            goto L12
        L14:
            tt5.a.h("Comment#RichTextInjector", "add: tag:" + r1);
            ((com.bytedance.ee.bear.middleground_permission_export.model.h) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.h.class, null, null, 6)).b(r3, r2);
            return;
        L18:
            return;
        L17:
            return;
        L5:
            r11 = null;
            goto L6
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            if ((r2 instanceof TextView) == false) goto L6;
            this.b.getValue();
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            ((com.bytedance.ee.bear.middleground_permission_export.model.h) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.h.class, null, null, 6)).c(this.a);
        }

        public a(String r1, Lazy<Unit> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public RichTextInjector() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void a(final CommentTextView r8, List<String> r9, un5.a.InterfaceC0318a r10, db5.k[] r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "commentTextView");
        c(r8, r9, r10, r11, null, r12, 16);
        final String r13 = r8.getClass().getSimpleName() + '@' + r8.hashCode();
        r8.setAfterSetText(new a(r13, LazyKt.lazy(new RichTextInjector$inject$permissionInitializer$1(r8, r13))));
    }

    public static /* synthetic */ void b(CommentTextView r0, List r1, un5.a.InterfaceC0318a r2, boolean r3, int r4) {
        if ((r4 & 16) == 0) goto L5;
        r3 = false;
    L5:
        a(r0, r1, r2, null, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(CommentTextView r9, List r10, un5.a.InterfaceC0318a r11, db5.k[] r12, Integer r13, boolean r14, int r15) {
        if ((r15 & 8) == 0) goto L5;
        db5.k[] r3 = null;
    L7:
        if ((r15 & 16) == 0) goto L9;
        Integer r8 = null;
    L11:
        if ((r15 & 32) == 0) goto L13;
        r14 = false;
    L13:
        Intrinsics.checkNotNullParameter(r9, "commentTextView");
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        if (r8 == null) goto L16;
        r7.element = Integer.valueOf(ContextCompat.getColor(r9.getContext(), r8.intValue()));
    L16:
        m0 r16 = new m0(r3, r9, r11, r10, r7, r8);
        CommentTextView.c r17 = r16;
        if (r14 == false) goto L19;
        r17 = new v(r9, r16);
    L19:
        r9.setParser(r17);
        return;
    L9:
        r8 = r13;
        goto L11
    L5:
        r3 = r12;
        goto L7
    }
}
