package com.bytedance.ee.bear.middleground.comment.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public class CommentTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f232295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f232296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f232297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f232298d;

    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentTextView f232299a;

        public a(CommentTextView r100) {
            this.f232299a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            d r101 = this.f232299a.f232298d;
            if (r101 == null) goto L15;
            monitor-enter(r101);
        L12:
            th = move-exception;
            throw th;
        L6:
            if (r101.f232301b == false) goto L9;
            monitor-exit(r101);
            return;
        L9:
            r101.f232300a.run();     // Catch: Throwable -> L12
            r101.f232301b = true;     // Catch: Throwable -> L12
            monitor-exit(r101);
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            b r101 = this.f232299a.f232297c;
            if (r101 == null) goto L5;
            r101.onViewDetachedFromWindow(r100);
        L5:
            CommentTextView r102 = this.f232299a;
            r102.f232298d = null;
            r102.f232297c = null;
            r102.removeOnAttachStateChangeListener(this);
        }
    }

    public interface b extends View.OnAttachStateChangeListener {
        void G4(TextView r100);
    }

    public interface c {
        CharSequence a(CharSequence r100);
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f232300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f232301b;

        public d(h0 r100) {
            this.f232301b = false;
            this.f232300a = r100;
        }
    }

    public c getParser() {
        return this.f232296b;
    }

    public String getRawString() {
        return this.f232295a;
    }

    public CommentTextView(Context r100) {
        super(r100);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.ee.bear.middleground.comment.widget.h0] */
    public void setAfterSetText(b r100) {
        this.f232297c = r100;
        this.f232298d = new d(new h0(this));
        if (isAttachedToWindow() == false) goto L16;
        d r101 = this.f232298d;
        monitor-enter(r101);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (r101.f232301b == false) goto L10;
        monitor-exit(r101);
        return;
    L10:
        r101.f232300a.run();     // Catch: Throwable -> L13
        r101.f232301b = true;     // Catch: Throwable -> L13
        monitor-exit(r101);
        return;
    L16:
        addOnAttachStateChangeListener(new a(this));
    }

    public void setParser(c r100) {
        this.f232296b = r100;
    }

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
    public void setRawString(String r100) {
        String r101 = "";
        String r102 = r101;
        if (r100 == null) goto L11;
        int r103 = yu5.b.f569227a;
        CharSequence r104 = StringsKt.trim(r100, new char[]{'\n'});
        r102 = r101;
        if (r104 == null) goto L11;
        String r105 = r104.toString();
        r102 = r101;
        if (r105 == null) goto L11;
        r102 = r105;
    L11:
        this.f232295a = r102;
        c r106 = this.f232296b;
        CharSequence r107 = r102;
        if (r106 == null) goto L14;
        r107 = r106.a(r102);
    L14:
        setText(r107);
        b r108 = this.f232297c;
        if (r108 == null) goto L18;
        r108.G4(this);
        return;
    }

    public CommentTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public CommentTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
