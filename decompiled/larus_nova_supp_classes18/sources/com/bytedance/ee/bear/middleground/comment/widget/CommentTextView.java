package com.bytedance.ee.bear.middleground.comment.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class CommentTextView extends AppCompatTextView {
    public String a;
    public c b;
    public b c;
    public d d;

    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ CommentTextView a;

        public a(CommentTextView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            d r3 = this.a.d;
            if (r3 == null) goto L15;
            monitor-enter(r3);
        L12:
            th = move-exception;
            throw th;
        L6:
            if (r3.b == false) goto L9;
            monitor-exit(r3);
            return;
        L9:
            r3.a.run();     // Catch: Throwable -> L12
            r3.b = true;     // Catch: Throwable -> L12
            monitor-exit(r3);
            return;
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [android.widget.TextView, com.bytedance.ee.bear.middleground.comment.widget.CommentTextView] */
        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            b r0 = this.a.c;
            if (r0 == null) goto L5;
            r0.onViewDetachedFromWindow(r2);
        L5:
            ?? r3 = this.a;
            r3.d = null;
            r3.c = null;
            r3.removeOnAttachStateChangeListener(this);
        }
    }

    public interface b extends View.OnAttachStateChangeListener {
        void G4(TextView r1);
    }

    public interface c {
        CharSequence a(CharSequence r1);
    }

    public static final class d {
        public final Runnable a;
        public boolean b;

        public d(h0 r2) {
            this.b = false;
            this.a = r2;
        }
    }

    public c getParser() {
        return this.b;
    }

    public String getRawString() {
        return this.a;
    }

    public CommentTextView(Context r1) {
        super(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.ee.bear.middleground.comment.widget.h0] */
    public void setAfterSetText(b r2) {
        this.c = r2;
        this.d = new d(new h0(this));
        if (isAttachedToWindow() == false) goto L16;
        d r3 = this.d;
        monitor-enter(r3);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (r3.b == false) goto L10;
        monitor-exit(r3);
        return;
    L10:
        r3.a.run();     // Catch: Throwable -> L13
        r3.b = true;     // Catch: Throwable -> L13
        monitor-exit(r3);
        return;
    L16:
        addOnAttachStateChangeListener(new a(this));
    }

    public void setParser(c r1) {
        this.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setRawString(String r5) {
        String r0 = "";
        String r1 = r0;
        if (r5 == null) goto L11;
        int r2 = yu5.b.a;
        CharSequence r6 = StringsKt.trim(r5, new char[]{'\n'});
        r1 = r0;
        if (r6 == null) goto L11;
        String r7 = r6.toString();
        r1 = r0;
        if (r7 == null) goto L11;
        r1 = r7;
    L11:
        this.a = r1;
        c r8 = this.b;
        CharSequence r3 = r1;
        if (r8 == null) goto L14;
        r3 = r8.a(r1);
    L14:
        setText(r3);
        b r9 = this.c;
        if (r9 == null) goto L18;
        r9.G4(this);
        return;
    }

    public CommentTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public CommentTextView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
