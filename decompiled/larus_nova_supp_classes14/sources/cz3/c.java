package cz3;

import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentColorMode;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentPublishScene;
import com.bytedance.awemeopen.apps.framework.comment.api.statistics.CommentMobParameters;
import com.bytedance.awemeopen.apps.framework.comment.widget.view.CommentMentionEditText;
import com.bytedance.awemeopen.apps.framework.comment.widget.view.MentionEditText;
import com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.ManagerContext;
import com.bytedance.awemeopen.apps.framework.comment.write.viewmodel.CommentInputContentViewModel;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a<jy3.b> implements cz3.a {
    public MentionEditText g;
    public final List<EditText> h;
    public boolean i;
    public a j;

    public static final class a extends jy3.d {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        @Override // jy3.d
        public final void c(CommentMobParameters r4) {
            c r5 = this.a;
            MentionEditText r0 = r5.g;
            String r2 = null;
            if ((r0 instanceof MentionEditText) == true) goto L6;
            r0 = null;
        L6:
            if (r0 == null) goto L23;
            hy3.b r1 = r5.d.g;
            if (r1 == null) goto L11;
            r2 = r1.c;
        L11:
            if (Intrinsics.areEqual(r2, CommentPublishScene.VIDEO_BOTTOM_INPUT) == false) goto L23;
            Editable r3 = r0.getText();
            boolean r6 = false;
            if (r3 != null) goto L15;
        L20:
            if (r6 == false) goto L23;
            com.bytedance.awemeopen.apps.framework.comment.util.b.a(r5.g, CommentColorMode.MODE_DARK);
            goto L23
        L15:
            if (r3.length() <= 0) goto L17;
            boolean r7 = true;
        L18:
            if (r7 != true) goto L20;
            r6 = true;
            goto L20
        L17:
            r7 = false;
        L23:
            if (this.a.I() == null) goto L28;
            c r8 = this.a;
            AppCompatEditText r9 = r8.g;
            if (r9 == null) goto L29;
            r9.setText("" + String.valueOf(r8.I()));
            return;
        L29:
            return;
        }
    }

    @Override // az3.a
    public final void C() {
        a r0 = this.j;
        if (r0 == null) goto L8;
        g r1 = this.d.o;
        if (r1 == null) goto L9;
        r1.n(r0);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a
    public final void E() {
        a r0 = new a(this);
        this.j = r0;
        g r1 = this.d.o;
        if (r1 == null) goto L5;
        r1.g(r0);
    L5:
        Integer r2 = this.d.a();
        if (r2 != null) goto L9;
    L10:
        if (r2 != null) goto L13;
    L14:
        y(this.g);
    L15:
        AppCompatEditText r3 = this.g;
        if (r3 == null) goto L18;
        r3.setOnClickListener(new b(this));
    L18:
        AppCompatEditText r4 = this.g;
        if (r4 == null) goto L22;
        r4.setFocusable(false);
    L22:
        AppCompatEditText r5 = this.g;
        if (r5 == null) goto L26;
        r5.setFocusableInTouchMode(false);
    L26:
        AppCompatEditText r6 = this.g;
        if (r6 == null) goto L30;
        r6.setInputType(0);
    L30:
        K(this.g);
        return;
    L13:
        if (r2.intValue() == 22) goto L15;
    L9:
        if (r2.intValue() == 11) goto L15;
        goto L10
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a
    public final void G() {
        CommentInputContentViewModel r0 = (CommentInputContentViewModel) this.d.q.getValue();
        if (r0 == null) goto L6;
        r0.removeRecord(this.d.c(), false);
    L6:
        if (this.g == null) goto L21;
        Integer r1 = this.d.a();
        if (r1 != null) goto L11;
    L12:
        AppCompatEditText r2 = this.g;
        if (r2 == null) goto L15;
        r2.setText("");
    L15:
        Integer r3 = this.d.a();
        if (r3 != null) goto L19;
    L20:
        s(this.g, true);
        goto L21
    L19:
        if (r3.intValue() == 22) goto L21;
    L11:
        if (r1.intValue() == 22) goto L15;
    L21:
        this.d.getClass();
        jy3.b r4 = (jy3.b) this.e;
    }

    public final Editable I() {
        CommentInputContentViewModel r0 = (CommentInputContentViewModel) this.d.q.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getContent(this.d.c());
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a, az3.a
    public final /* bridge */ /* synthetic */ void A(com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a r1) {
        F((com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.c) r1);
    }

    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.widget.EditText, com.bytedance.awemeopen.apps.framework.comment.widget.view.MentionEditText] */
    /* JADX WARN: Type inference failed for: r2v5 */
    @Override // com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a
    public final void F(com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.c r2) {
        Intrinsics.checkNotNullParameter(r2, "viewProvider");
        Object r3 = r2.a(this.c);
        if ((r3 instanceof MentionEditText) == false) goto L5;
        ?? r4 = (MentionEditText) r3;
    L6:
        this.g = r4;
        if (this.a.e == true) goto L12;
        if (r4 == 0) goto L13;
        r4.setEllipsize(TextUtils.TruncateAt.END);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r4 = 0;
        goto L6
    }

    public final void J(String r6) {
        Intrinsics.checkNotNullParameter(r6, "clickType");
        boolean r2 = true;
        this.d.i = true;
        if (((jy3.b) this.e) == null) goto L5;
        Intrinsics.checkNotNullParameter(r6, "clickType");
    L5:
        i r1 = this.d.n;
        if (r1 != null) goto L8;
    L10:
        r2 = false;
    L11:
        if (r2 == false) goto L19;
        ManagerContext r3 = this.d;
        boolean r4 = r3.e;
        Integer r5 = r3.a();
        if (r5 == null) goto L16;
        r5.intValue();
    L16:
        CommentMobParameters.a r7 = new CommentMobParameters.a();
        Intrinsics.checkNotNullParameter(r6, "clickType");
        r7.a = r6;
        CommentMobParameters r8 = new CommentMobParameters(r7);
        g r0 = this.d.o;
        if (r0 == null) goto L19;
        com.bytedance.awemeopen.apps.framework.comment.write.g r9 = new com.bytedance.awemeopen.apps.framework.comment.write.g();
        r9.a = null;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r9.b = false;
        r9.c = r8;
        r0.l(r9);
    L19:
        jy3.b r10 = (jy3.b) this.e;
        return;
    L8:
        if (r1.w(this.g) != true) goto L10;
        goto L10
    }

    public final void K(EditText r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (this.a.e == true) goto L7;
        return;
    L7:
        if (r2.getText() != null) goto L9;
    L14:
        r2.setEllipsize(TextUtils.TruncateAt.END);
        return;
    L9:
        if (r2.getText().length() <= 0) goto L11;
        boolean r0 = true;
    L12:
        if (r0 == false) goto L14;
        r2.setEllipsize(null);
        return;
    L11:
        r0 = false;
        goto L12
    }

    @Override // cz3.a
    public final void a(CommentMentionEditText r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (((CopyOnWriteArrayList) this.h).contains(r2) == false) goto L9;
        ((CopyOnWriteArrayList) this.h).remove(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // cz3.a
    public final void y(MentionEditText r4) {
        if (r4 != 0) goto L4;
        return;
    L4:
        if (((CopyOnWriteArrayList) this.h).contains(r4) == false) goto L7;
        return;
    L7:
        if (this.g != null) goto L9;
    L20:
        ((CopyOnWriteArrayList) this.h).add(r4);
        return;
    L9:
        if (r4.getText() == null) goto L20;
        Editable r0 = r4.getText();
        MentionEditText r1 = this.g;
        Editable r2 = null;
        if (r1 == null) goto L13;
        Editable r3 = r1.getText();
    L15:
        if (Intrinsics.areEqual(r0, r3) == true) goto L20;
        MentionEditText r5 = this.g;
        if (r5 == null) goto L19;
        r2 = r5.getText();
    L19:
        r4.setText(r2);
        goto L20
    L13:
        r3 = null;
        goto L15
    }

    public c(ManagerContext r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "managerContext");
        Intrinsics.checkNotNullParameter(r3, "tag");
        super(r2, r3);
        H(cz3.a.class, this);
        r2.l = this;
        this.h = new CopyOnWriteArrayList();
    }

    @Override // cz3.a
    public final void s(MentionEditText r7, boolean r8) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (((CopyOnWriteArrayList) this.h).contains(r7) == true) goto L7;
        return;
    L7:
        if (this.i == false) goto L9;
        return;
    L9:
        this.i = true;
        Iterator r1 = ((CopyOnWriteArrayList) this.h).iterator();
    L10:
        boolean r3 = false;
        if (r1.hasNext() == false) goto L28;
        EditText r2 = (EditText) r1.next();
        if (r2 == r7) goto L10;
        if (Objects.equals(r2.getText(), r7.getText()) == true) goto L10;
        if (r8 == true) goto L27;
        if (r2.getText().toString().length() != 0) goto L20;
        boolean r4 = true;
    L21:
        if (r4 == false) goto L27;
        if (r7.getText().toString().length() != 0) goto L25;
        r3 = true;
    L25:
        if (r3 == false) goto L27;
    L20:
        r4 = false;
    L27:
        r2.setText(r7.getText());
        K(r2);
        goto L10
    L28:
        Editable r9 = r7.getText();
        if (this.d.c() == null) goto L33;
        CommentInputContentViewModel r10 = (CommentInputContentViewModel) this.d.q.getValue();
        if (r10 == null) goto L33;
        r10.putContent(this.d.c(), r9);
    L33:
        this.i = false;
        jy3.b r11 = (jy3.b) this.e;
    }
}
