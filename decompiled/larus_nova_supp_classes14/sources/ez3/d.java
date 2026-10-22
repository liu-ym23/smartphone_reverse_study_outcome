package ez3;

import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentColorMode;
import com.bytedance.awemeopen.apps.framework.comment.api.statistics.CommentMobParameters;
import com.bytedance.awemeopen.apps.framework.comment.widget.view.CommentMentionEditText;
import com.bytedance.awemeopen.apps.framework.comment.widget.view.MentionEditText;
import com.bytedance.awemeopen.apps.framework.comment.write.model.TextExtraStruct;
import com.bytedance.awemeopen.apps.framework.comment.write.refactor.BaseCmtInputPresenter;
import com.bytedance.awemeopen.apps.framework.comment.write.refactor.l;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.utils.o;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class d extends BaseCmtInputPresenter implements TextWatcher, e {
    public final com.bytedance.awemeopen.apps.framework.comment.write.refactor.g f;
    public CharSequence g;
    public CommentMentionEditText h;
    public DmtTextView i;
    public ViewGroup j;
    public TextView k;
    public ViewGroup l;
    public ViewGroup m;
    public boolean n;

    public static final class a implements CommentMentionEditText.b {
        public final /* synthetic */ d a;

        @Override // com.bytedance.awemeopen.apps.framework.comment.widget.view.CommentMentionEditText.b
        public final void a() {
            bz3.b r0 = this.a.f.o;
            if (r0 == null) goto L6;
            r0.g();
            return;
        }

        public a(h r1) {
            this.a = r1;
        }
    }

    public static final class b implements MentionEditText.c {
        public b() {
        }

        @Override // com.bytedance.awemeopen.apps.framework.comment.widget.view.MentionEditText.c
        public final void a() {
        }
    }

    public static final class c implements CommentMentionEditText.c {
        public c() {
        }

        @Override // com.bytedance.awemeopen.apps.framework.comment.widget.view.CommentMentionEditText.c
        public final void a() {
        }
    }

    /* JADX INFO: renamed from: ez3.d$d, reason: collision with other inner class name */
    public static final class C0121d extends o {
        public final /* synthetic */ d d;

        @Override // com.bytedance.awemeopen.apps.framework.utils.o
        public final void a() {
            e r0 = this.d.E();
            if (r0 == null) goto L6;
            r0.v("send_btn");
            return;
        }

        public C0121d(h r1) {
            this.d = r1;
            super(0);
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.refactor.BaseCmtInputPresenter
    public final void G() {
        this.n = true;
    }

    public abstract void J();

    @Override // az3.a
    public final void C() {
        bz3.b r0 = this.f.o;
        if (r0 == null) goto L6;
        r0.a(this.h);
        return;
    }

    @Override // ez3.e
    public final void h() {
        CommentMentionEditText r0 = this.h;
        if (r0 == null) goto L5;
        Editable r1 = r0.getText();
    L6:
        int r2 = 0;
        if (r1 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        boolean r4 = !r3;
        ViewGroup r5 = ((h) this).m;
        if (r5 == null) goto L20;
        if (r4 == true) goto L19;
        r2 = 8;
    L19:
        r5.setVisibility(r2);
    L20:
        com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.g.a r6 = com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.g.m1;
        com.bytedance.awemeopen.apps.framework.comment.write.refactor.g r7 = this.f;
        r6.getClass();
        com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.g r8 = com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.g.a.a(r7);
        if (r8 == null) goto L26;
        com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.a r9 = r8.f();
        if (r9 == null) goto L27;
        r9.b(r4);
        return;
    L27:
        return;
    L26:
        return;
    L9:
        if (r1.length() == 0) goto L12;
        r3 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    @Override // ez3.e
    public final CommentMentionEditText c() {
        return this.h;
    }

    public d(com.bytedance.awemeopen.apps.framework.comment.write.refactor.g r2) {
        Intrinsics.checkNotNullParameter(r2, "inputContext");
        super(r2);
        this.f = r2;
        this.n = true;
        LifecycleOwner r3 = r2.b.d;
        int r0 = xy3.a.a;
        xy3.a.c(e.class, this, r3);
    }

    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.EditText, com.bytedance.awemeopen.apps.framework.comment.widget.view.CommentMentionEditText] */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.awemeopen.apps.framework.comment.write.refactor.BaseCmtInputPresenter
    public void F(l r3) {
        Intrinsics.checkNotNullParameter(r3, "viewProvider");
        super.F(r3);
        View r4 = this.e;
        ?? r0 = 0;
        if (r4 == null) goto L5;
        ViewGroup r5 = (ViewGroup) r4.findViewById(2131367370);
    L6:
        this.l = r5;
        View r6 = this.e;
        if (r6 == null) goto L9;
        ViewGroup r7 = (ViewGroup) r6.findViewById(2131371401);
    L10:
        this.j = r7;
        View r8 = this.e;
        if (r8 == null) goto L13;
        ViewGroup r9 = (ViewGroup) r8.findViewById(2131367416);
    L14:
        this.m = r9;
        View r10 = this.e;
        if (r10 == null) goto L17;
        TextView r11 = (TextView) r10.findViewById(2131367417);
    L18:
        this.k = r11;
        View r12 = this.e;
        if (r12 == null) goto L21;
        DmtTextView r13 = (DmtTextView) r12.findViewById(2131393315);
    L22:
        this.i = r13;
        View r14 = this.e;
        if (r14 == null) goto L25;
        r0 = (CommentMentionEditText) r14.findViewById(2131367335);
    L25:
        this.h = r0;
        if (r0 == 0) goto L29;
        r0.setFocusable(true);
    L29:
        AppCompatEditText r15 = this.h;
        if (r15 == null) goto L33;
        r15.setOnFocusChangeListener(new ez3.a());
    L33:
        if (Build.VERSION.SDK_INT < 29) goto L38;
        AppCompatEditText r16 = this.h;
        if (r16 == null) goto L38;
        r16.setImportantForAutofill(2);
    L38:
        AppCompatEditText r17 = this.h;
        if (r17 == null) goto L41;
        final h r1 = (h) this;
        r17.setOnEditorActionListener(new ez3.b(r1));
    L41:
        CommentMentionEditText r18 = this.h;
        if (r18 == null) goto L44;
        r18.setOnPasteListener(new a((h) this));
    L44:
        CommentMentionEditText r19 = this.h;
        if (r19 == null) goto L48;
        r19.setMentionTextColor(ContextCompat.getColor(y54.a.a(), 2131100289));
    L48:
        CommentMentionEditText r20 = this.h;
        if (r20 == null) goto L52;
        r20.setOnMentionInputListener(new b());
    L52:
        AppCompatEditText r21 = this.h;
        if (r21 == null) goto L55;
        final h r2 = (h) this;
        r21.setOnClickListener(new ez3.c(r2));
    L55:
        CommentMentionEditText r22 = this.h;
        if (r22 == null) goto L58;
        r22.addTextChangedListener(this);
    L58:
        CommentMentionEditText r23 = this.h;
        if (r23 == null) goto L61;
        r23.setOnSelectionChangedListener(new c());
    L61:
        AppCompatEditText r24 = this.h;
        if (r24 == null) goto L65;
        r24.setHighlightColor(this.a.getContext().getResources().getColor(2131100234));
    L65:
        bz3.b r25 = this.f.o;
        if (r25 == null) goto L68;
        r25.h(this.h);
    L68:
        TextView r26 = this.k;
        if (r26 == null) goto L72;
        r26.setOnClickListener(new C0121d((h) this));
        return;
    L72:
        return;
    L21:
        r13 = null;
        goto L22
    L17:
        r11 = null;
        goto L18
    L13:
        r9 = null;
        goto L14
    L9:
        r7 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.refactor.BaseCmtInputPresenter
    public final void H(com.bytedance.awemeopen.apps.framework.comment.write.g r1) {
        if (r1 == null) goto L4;
        CharSequence r2 = r1.a;
    L5:
        this.g = r2;
        return;
    L4:
        r2 = null;
        goto L5
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r2) {
        CommentMentionEditText r3 = this.h;     // Catch: ArrayStoreException -> L4
        int r0 = com.bytedance.awemeopen.apps.framework.comment.util.b.a;     // Catch: ArrayStoreException -> L4
        com.bytedance.awemeopen.apps.framework.comment.util.b.a(r3, CommentColorMode.MODE_LIGHT);     // Catch: ArrayStoreException -> L4
    L5:
        J();
        bz3.b r4 = this.f.o;
        if (r4 == null) goto L8;
        r4.b(this.h);
    L8:
        h();
    }

    @Override // ez3.e
    public final void v(String r6) {
        Intrinsics.checkNotNullParameter(r6, "method");
        AoLogger.b("write_comment", new Object[]{"tryPublishComment: ".concat(r6)});
        CommentMentionEditText r0 = this.h;
        ArrayList<TextExtraStruct> r1 = null;
        if (r0 == null) goto L5;
        Editable r2 = r0.getText();
    L6:
        com.bytedance.awemeopen.apps.framework.comment.write.i r3 = this.f.r;
        if (r3 == null) goto L13;
        CommentMentionEditText r4 = this.h;
        if (r4 == null) goto L11;
        r1 = r4.e(new int[0]);
    L11:
        r3.d(r2, r1, r6, this.f.k);
        return;
    L13:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r8, int r9, int r10, int r11) {
        if (r8 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == false) goto L11;
        return;
    L11:
        if (this.n == false) goto L28;
        this.n = false;
        if (r9 != 0) goto L29;
        if (r10 != 0) goto L30;
        LinkedHashMap r2 = new LinkedHashMap();
        CommentMobParameters r13 = this.f.k;
        if (r13 == null) goto L19;
        String r14 = r13.getEnterFrom();
        if (r14 == null) goto L19;
    L20:
        r2.put("enter_from", r14);
        CommentMobParameters r15 = this.f.k;
        if (r15 == null) goto L24;
        String r16 = r15.getCommentCategory();
        if (r16 == null) goto L24;
    L25:
        r2.put("comment_category", r16);
        AosEventReporter.s(AosEventReporter.a, "text_typing", r2, null, null, null, 28);
        return;
    L24:
        r16 = "original";
    L19:
        r14 = "";
        goto L20
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L5:
        if (r8.length() == 0) goto L8;
        r12 = false;
        goto L9
    }
}
