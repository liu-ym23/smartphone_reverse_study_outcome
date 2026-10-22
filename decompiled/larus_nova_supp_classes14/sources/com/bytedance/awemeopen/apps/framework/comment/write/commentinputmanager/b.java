package com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager;

import android.app.Application;
import android.content.Context;
import android.view.View;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentConstants$PresenterTag;
import com.bytedance.awemeopen.apps.framework.comment.api.statistics.CommentMobParameters;
import com.bytedance.awemeopen.apps.framework.comment.widget.view.CommentMentionEditText;
import com.bytedance.awemeopen.apps.framework.comment.write.n;
import com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.EmojiGifPresenter;
import com.bytedance.awemeopen.bizmodels.profile.User;
import cz3.f;
import cz3.g;
import cz3.j;
import cz3.k;
import cz3.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements bz3.b {
    public final CmtInputPresenterManager a;
    public final ManagerContext b;

    @Override // bz3.b
    public final void c() {
    }

    @Override // bz3.b
    public final void g() {
    }

    @Override // bz3.b
    public final void e() {
        CmtInputPresenterManager r0 = this.a;
        if (r0 == null) goto L8;
        Iterator r1 = ((ArrayList) r0.c).iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((a) r1.next()).G();
        goto L6
    L10:
        return;
    }

    @Override // bz3.b
    public Context getContext() {
        ManagerContext r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getContext();
    }

    public b(hy3.b r5) {
        Intrinsics.checkNotNullParameter(r5, "commentInputParam");
        ManagerContext r0 = this.b;
        if (r0 == null) goto L5;
        r0.getContext().getResources();
    L5:
        CmtInputPresenterManager r1 = new CmtInputPresenterManager(r5, this);
        hy3.b r6 = r1.a;
        ManagerContext r2 = new ManagerContext(r6.a.getActivity(), r1.a.a);
        r2.g = r6;
        r2.h = r1.b;
        r2.e = false;
        r1.d = r2;
        this.b = r2;
        this.a = r1;
    }

    @Override // bz3.b
    public final void a(CommentMentionEditText r2) {
        ManagerContext r0 = this.b;
        if (r0 == null) goto L8;
        cz3.a r1 = r0.l;
        if (r1 == null) goto L9;
        r1.a(r2);
        return;
    L9:
        return;
    }

    @Override // bz3.b
    public final void b(CommentMentionEditText r3) {
        ManagerContext r0 = this.b;
        if (r0 == null) goto L8;
        cz3.a r1 = r0.l;
        if (r1 == null) goto L9;
        r1.s(r3, false);
        return;
    L9:
        return;
    }

    @Override // bz3.b
    public final void d(EmojiGifPresenter.a r2) {
        ManagerContext r0 = this.b;
        if (r0 == null) goto L8;
        List<dz3.a> r1 = r0.j;
        if (r1 == null) goto L9;
        ((ArrayList) r1).remove(r2);
        return;
    L9:
        return;
    }

    @Override // bz3.b
    public final void f(EmojiGifPresenter.b r2) {
        ManagerContext r0 = this.b;
        if (r0 == null) goto L8;
        List<dz3.a> r1 = r0.j;
        if (r1 == null) goto L9;
        ((ArrayList) r1).add(r2);
        return;
    L9:
        return;
    }

    @Override // bz3.b
    public final void h(CommentMentionEditText r2) {
        ManagerContext r0 = this.b;
        if (r0 == null) goto L8;
        cz3.a r1 = r0.l;
        if (r1 == null) goto L9;
        r1.y(r2);
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final b i(jy3.a r5) {
        Intrinsics.checkNotNullParameter(r5, "service");
        CmtInputPresenterManager r0 = this.a;
        if (r0 != null) goto L5;
    L21:
        return this;
    L5:
        if (Intrinsics.areEqual(r5.getTag(), CommentConstants$PresenterTag.KEYBOARD) == false) goto L11;
        ManagerContext r1 = r0.d;
        if (r1 == null) goto L21;
        g r2 = r1.o;
        if (r2 == null) goto L21;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.comment.api.services.OnKeyBoardService");
        r2.g((jy3.d) r5);
        goto L21
    L11:
        Iterator r3 = ((ArrayList) r0.c).iterator();
    L13:
        if (r3.hasNext() == false) goto L17;
        Object r4 = r3.next();
        if (Intrinsics.areEqual(r5.getTag(), ((a) r4).c) == false) goto L13;
    L18:
        a r6 = (a) r4;
        if (r6 == null) goto L21;
        r6.e = r5;
        goto L21
    L17:
        r4 = null;
        goto L18
    }

    public final void j(String r7) {
        CmtInputPresenterManager r0 = this.a;
        if (r0 == null) goto L60;
        Intrinsics.checkNotNullParameter(r7, "tag");
        Iterator r2 = ((ArrayList) r0.c).iterator();
    L5:
        az3.a r4 = null;
        if (r2.hasNext() == false) goto L10;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((a) r3).c, r7) == false) goto L5;
    L12:
        if (((a) r3) == null) goto L29;
        Intrinsics.checkNotNullParameter(r7, "tag");
        Iterator r5 = ((ArrayList) r0.c).iterator();
    L15:
        if (r5.hasNext() == false) goto L19;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((a) r6).c, r7) == false) goto L15;
    L20:
        a r8 = (a) r6;
        if (r8 == null) goto L29;
        r8.C();
        ((ArrayList) r0.c).remove(r8);
        ManagerContext r9 = r0.d;
        if (r9 == null) goto L29;
        hy3.b r10 = r9.g;
        if (r10 == null) goto L29;
        Map<String, View> r11 = r10.d;
        if (r11 == null) goto L29;
        View r12 = r11.remove(r7);
        goto L29
    L19:
        r6 = null;
    L29:
        d r13 = (d) r0.e.getValue();
        ManagerContext r14 = r0.d;
        Intrinsics.checkNotNull(r14);
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "managerContext");
        Intrinsics.checkNotNullParameter(r7, "tag");
        switch(r7.hashCode()) {
            case -1514920366: goto L48;
            case -834306487: goto L45;
            case -537241352: goto L41;
            case -507768060: goto L37;
            case -165469273: goto L33;
            default: goto L51;
        };
    L51:
        if (r4 == null) goto L61;
        ((ArrayList) r0.c).add(r4);
        return;
    L61:
        return;
    L33:
        if (r7.equals(CommentConstants$PresenterTag.EDIT) == false) goto L51;
        r4 = new cz3.c(r14, r7);
        goto L51
    L37:
        if (r7.equals(CommentConstants$PresenterTag.KEYBOARD) == false) goto L51;
        r4 = new k(r14, r7);
        goto L51
    L41:
        if (r7.equals(CommentConstants$PresenterTag.CHECKER) == false) goto L51;
        r4 = new j(r14, r7);
        goto L51
    L45:
        if (r7.equals(CommentConstants$PresenterTag.EMOJI) == false) goto L51;
        r4 = new f(r14, r7);
        goto L51
    L48:
        if (r7.equals(CommentConstants$PresenterTag.PUBLISH) == false) goto L51;
        r4 = new m(r14, r7);
        goto L51
    L10:
        r3 = null;
        goto L12
    }

    public final void k(boolean r5, String r6, CommentMobParameters r7) {
        ManagerContext r0 = this.b;
        if (r0 == null) goto L7;
        Integer r1 = r0.a();
        if (r1 == null) goto L7;
        r1.intValue();
    L7:
        ManagerContext r2 = this.b;
        n r3 = null;
        if (r2 == null) goto L12;
        g r4 = r2.o;
        if (r4 == null) goto L12;
        com.bytedance.awemeopen.apps.framework.comment.write.g r8 = new com.bytedance.awemeopen.apps.framework.comment.write.g();
        r8.a = null;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r8.b = r5;
        r8.c = r7;
        r4.l(r8);
    L12:
        ManagerContext r9 = this.b;
        if (r9 == null) goto L19;
        WeakReference<n> r10 = com.bytedance.awemeopen.apps.framework.comment.write.f.a;
        if (r10 == null) goto L17;
        r3 = r10.get();
    L17:
        r9.c = r3;
        return;
    }

    public final void l(User r4, CommentMobParameters r5, com.bytedance.awemeopen.apps.framework.comment.write.g.a r6) {
        ManagerContext r0 = this.b;
        if (r0 == null) goto L6;
        boolean r2 = r0.e;
    L6:
        if (r0 == null) goto L10;
        Integer r1 = r0.a();
        if (r1 == null) goto L10;
        r1.intValue();
    L10:
        r6.getClass();
        r6.a = r4;
        r6.c = r5;
        com.bytedance.awemeopen.apps.framework.comment.write.g r7 = new com.bytedance.awemeopen.apps.framework.comment.write.g();
        if (r6.a == null) goto L13;
        Application r8 = y54.a.a();
        User r3 = r6.a;
        Intrinsics.checkNotNull(r3);
        String r9 = r8.getString(2131894164, new Object[]{r3.t()});
    L14:
        r7.a = r9;
        Intrinsics.checkNotNullParameter(r6.d, "<set-?>");
        r7.b = r6.b;
        r7.c = r6.c;
        ManagerContext r10 = this.b;
        if (r10 == null) goto L20;
        g r11 = r10.o;
        if (r11 == null) goto L21;
        r11.l(r7);
        return;
    L21:
        return;
    L20:
        return;
    L13:
        r9 = null;
        goto L14
    }
}
