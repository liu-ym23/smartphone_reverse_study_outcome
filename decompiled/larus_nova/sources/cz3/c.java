package cz3;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
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

/* JADX INFO: loaded from: classes14.dex */
public final class c extends com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a<jy3.b> implements cz3.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MentionEditText f466017g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<EditText> f466018h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f466019i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f466020j;

    public static final class a extends jy3.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f466021a;

        public a(c r100) {
            this.f466021a = r100;
        }

        @Override // jy3.d
        public final void c(CommentMobParameters r100) {
            c r101 = this.f466021a;
            MentionEditText r102 = r101.f466017g;
            String r103 = null;
            if ((r102 instanceof MentionEditText) == true) goto L6;
            r102 = null;
        L6:
            if (r102 == null) goto L23;
            hy3.b r104 = r101.f194421d.f194409g;
            if (r104 == null) goto L11;
            r103 = r104.f487632c;
        L11:
            if (Intrinsics.areEqual(r103, CommentPublishScene.VIDEO_BOTTOM_INPUT) == false) goto L23;
            Editable r105 = r102.getText();
            boolean r106 = false;
            if (r105 != null) goto L15;
        L20:
            if (r106 == false) goto L23;
            com.bytedance.awemeopen.apps.framework.comment.util.b.a(r101.f466017g, CommentColorMode.MODE_DARK);
            goto L23
        L15:
            if (r105.length() <= 0) goto L17;
            boolean r107 = true;
        L18:
            if (r107 != true) goto L20;
            r106 = true;
            goto L20
        L17:
            r107 = false;
        L23:
            if (this.f466021a.I() == null) goto L28;
            c r108 = this.f466021a;
            MentionEditText r109 = r108.f466017g;
            if (r109 == null) goto L29;
            r109.setText("" + String.valueOf(r108.I()));
            return;
        L29:
            return;
        }
    }

    @Override // az3.a
    public final void C() {
        a r100 = this.f466020j;
        if (r100 == null) goto L8;
        g r101 = this.f194421d.f194417o;
        if (r101 == null) goto L9;
        r101.n(r100);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a
    public final void E() {
        a r100 = new a(this);
        this.f466020j = r100;
        g r101 = this.f194421d.f194417o;
        if (r101 == null) goto L5;
        r101.g(r100);
    L5:
        Integer r102 = this.f194421d.a();
        if (r102 != null) goto L9;
    L10:
        if (r102 != null) goto L13;
    L14:
        y(this.f466017g);
    L15:
        MentionEditText r103 = this.f466017g;
        if (r103 == null) goto L18;
        r103.setOnClickListener(new b(this));
    L18:
        MentionEditText r104 = this.f466017g;
        if (r104 == null) goto L22;
        r104.setFocusable(false);
    L22:
        MentionEditText r105 = this.f466017g;
        if (r105 == null) goto L26;
        r105.setFocusableInTouchMode(false);
    L26:
        MentionEditText r106 = this.f466017g;
        if (r106 == null) goto L30;
        r106.setInputType(0);
    L30:
        K(this.f466017g);
        return;
    L13:
        if (r102.intValue() == 22) goto L15;
    L9:
        if (r102.intValue() == 11) goto L15;
        goto L10
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a
    public final void G() {
        CommentInputContentViewModel r100 = (CommentInputContentViewModel) this.f194421d.f194419q.getValue();
        if (r100 == null) goto L6;
        r100.removeRecord(this.f194421d.c(), false);
    L6:
        if (this.f466017g == null) goto L21;
        Integer r101 = this.f194421d.a();
        if (r101 != null) goto L11;
    L12:
        MentionEditText r102 = this.f466017g;
        if (r102 == null) goto L15;
        r102.setText("");
    L15:
        Integer r103 = this.f194421d.a();
        if (r103 != null) goto L19;
    L20:
        s(this.f466017g, true);
        goto L21
    L19:
        if (r103.intValue() == 22) goto L21;
    L11:
        if (r101.intValue() == 22) goto L15;
    L21:
        this.f194421d.getClass();
        jy3.b r104 = (jy3.b) this.f194422e;
    }

    public final Editable I() {
        CommentInputContentViewModel r100 = (CommentInputContentViewModel) this.f194421d.f194419q.getValue();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getContent(this.f194421d.c());
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a, az3.a
    public final /* bridge */ /* synthetic */ void A(com.bytedance.awemeopen.apps.framework.comment.write.arch.ui.a r100) {
        F((com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.c) r100);
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a
    public final void F(com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.c r100) {
        Intrinsics.checkNotNullParameter(r100, "viewProvider");
        View r101 = r100.a(this.f194420c);
        if ((r101 instanceof MentionEditText) == false) goto L5;
        MentionEditText r102 = (MentionEditText) r101;
    L6:
        this.f466017g = r102;
        if (this.f16804a.f561867e == true) goto L12;
        if (r102 == null) goto L13;
        r102.setEllipsize(TextUtils.TruncateAt.END);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void J(String r100) {
        Intrinsics.checkNotNullParameter(r100, "clickType");
        boolean r101 = true;
        this.f194421d.f194411i = true;
        if (((jy3.b) this.f194422e) == null) goto L5;
        Intrinsics.checkNotNullParameter(r100, "clickType");
    L5:
        i r102 = this.f194421d.f194416n;
        if (r102 != null) goto L8;
    L10:
        r101 = false;
    L11:
        if (r101 == false) goto L19;
        ManagerContext r103 = this.f194421d;
        boolean r104 = r103.f561867e;
        Integer r105 = r103.a();
        if (r105 == null) goto L16;
        r105.intValue();
    L16:
        CommentMobParameters.a r106 = new CommentMobParameters.a();
        Intrinsics.checkNotNullParameter(r100, "clickType");
        r106.f194120a = r100;
        CommentMobParameters r107 = new CommentMobParameters(r106);
        g r108 = this.f194421d.f194417o;
        if (r108 == null) goto L19;
        com.bytedance.awemeopen.apps.framework.comment.write.g r109 = new com.bytedance.awemeopen.apps.framework.comment.write.g();
        r109.f194459a = null;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r109.f194460b = false;
        r109.f194461c = r107;
        r108.l(r109);
    L19:
        jy3.b r110 = (jy3.b) this.f194422e;
        return;
    L8:
        if (r102.w(this.f466017g) != true) goto L10;
        goto L10
    }

    public final void K(EditText r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f16804a.f561867e == true) goto L7;
        return;
    L7:
        if (r100.getText() != null) goto L9;
    L14:
        r100.setEllipsize(TextUtils.TruncateAt.END);
        return;
    L9:
        if (r100.getText().length() <= 0) goto L11;
        boolean r101 = true;
    L12:
        if (r101 == false) goto L14;
        r100.setEllipsize(null);
        return;
    L11:
        r101 = false;
        goto L12
    }

    @Override // cz3.a
    public final void a(CommentMentionEditText r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (((CopyOnWriteArrayList) this.f466018h).contains(r100) == false) goto L9;
        ((CopyOnWriteArrayList) this.f466018h).remove(r100);
        return;
    }

    @Override // cz3.a
    public final void y(MentionEditText r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (((CopyOnWriteArrayList) this.f466018h).contains(r100) == false) goto L7;
        return;
    L7:
        if (this.f466017g != null) goto L9;
    L20:
        ((CopyOnWriteArrayList) this.f466018h).add(r100);
        return;
    L9:
        if (r100.getText() == null) goto L20;
        Editable r101 = r100.getText();
        MentionEditText r102 = this.f466017g;
        Editable r103 = null;
        if (r102 == null) goto L13;
        Editable r104 = r102.getText();
    L15:
        if (Intrinsics.areEqual(r101, r104) == true) goto L20;
        MentionEditText r105 = this.f466017g;
        if (r105 == null) goto L19;
        r103 = r105.getText();
    L19:
        r100.setText(r103);
        goto L20
    L13:
        r104 = null;
        goto L15
    }

    public c(ManagerContext r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "managerContext");
        Intrinsics.checkNotNullParameter(r101, "tag");
        super(r100, r101);
        H(cz3.a.class, this);
        r100.f194414l = this;
        this.f466018h = new CopyOnWriteArrayList();
    }

    @Override // cz3.a
    public final void s(MentionEditText r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (((CopyOnWriteArrayList) this.f466018h).contains(r100) == true) goto L7;
        return;
    L7:
        if (this.f466019i == false) goto L9;
        return;
    L9:
        this.f466019i = true;
        Iterator r102 = ((CopyOnWriteArrayList) this.f466018h).iterator();
    L10:
        boolean r103 = false;
        if (r102.hasNext() == false) goto L28;
        EditText r104 = (EditText) r102.next();
        if (r104 == r100) goto L10;
        if (Objects.equals(r104.getText(), r100.getText()) == true) goto L10;
        if (r101 == true) goto L27;
        if (r104.getText().toString().length() != 0) goto L20;
        boolean r105 = true;
    L21:
        if (r105 == false) goto L27;
        if (r100.getText().toString().length() != 0) goto L25;
        r103 = true;
    L25:
        if (r103 == false) goto L27;
    L20:
        r105 = false;
    L27:
        r104.setText(r100.getText());
        K(r104);
        goto L10
    L28:
        Editable r106 = r100.getText();
        if (this.f194421d.c() == null) goto L33;
        CommentInputContentViewModel r107 = (CommentInputContentViewModel) this.f194421d.f194419q.getValue();
        if (r107 == null) goto L33;
        r107.putContent(this.f194421d.c(), r106);
    L33:
        this.f466019i = false;
        jy3.b r108 = (jy3.b) this.f194422e;
    }
}
