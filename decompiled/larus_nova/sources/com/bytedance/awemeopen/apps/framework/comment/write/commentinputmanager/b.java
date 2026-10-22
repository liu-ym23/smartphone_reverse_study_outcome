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
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes14.dex */
public final class b implements bz3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CmtInputPresenterManager f194425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ManagerContext f194426b;

    @Override // bz3.b
    public final void c() {
    }

    @Override // bz3.b
    public final void g() {
    }

    @Override // bz3.b
    public final void e() {
        CmtInputPresenterManager r100 = this.f194425a;
        if (r100 == null) goto L8;
        Iterator r101 = ((ArrayList) r100.f194405c).iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        ((a) r101.next()).G();
        goto L6
    L10:
        return;
    }

    @Override // bz3.b
    public Context getContext() {
        ManagerContext r100 = this.f194426b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getContext();
    }

    public b(hy3.b r100) {
        Intrinsics.checkNotNullParameter(r100, "commentInputParam");
        ManagerContext r101 = this.f194426b;
        if (r101 == null) goto L5;
        r101.getContext().getResources();
    L5:
        CmtInputPresenterManager r102 = new CmtInputPresenterManager(r100, this);
        hy3.b r103 = r102.f194403a;
        ManagerContext r104 = new ManagerContext(r103.f487630a.getActivity(), r102.f194403a.f487630a);
        r104.f194409g = r103;
        r104.f194410h = r102.f194404b;
        r104.f561867e = false;
        r102.f194406d = r104;
        this.f194426b = r104;
        this.f194425a = r102;
    }

    @Override // bz3.b
    public final void a(CommentMentionEditText r100) {
        ManagerContext r101 = this.f194426b;
        if (r101 == null) goto L8;
        cz3.a r102 = r101.f194414l;
        if (r102 == null) goto L9;
        r102.a(r100);
        return;
    L9:
        return;
    }

    @Override // bz3.b
    public final void b(CommentMentionEditText r100) {
        ManagerContext r101 = this.f194426b;
        if (r101 == null) goto L8;
        cz3.a r102 = r101.f194414l;
        if (r102 == null) goto L9;
        r102.s(r100, false);
        return;
    L9:
        return;
    }

    @Override // bz3.b
    public final void d(EmojiGifPresenter.a r100) {
        ManagerContext r101 = this.f194426b;
        if (r101 == null) goto L8;
        List<dz3.a> r102 = r101.f194412j;
        if (r102 == null) goto L9;
        ((ArrayList) r102).remove(r100);
        return;
    L9:
        return;
    }

    @Override // bz3.b
    public final void f(EmojiGifPresenter.b r100) {
        ManagerContext r101 = this.f194426b;
        if (r101 == null) goto L8;
        List<dz3.a> r102 = r101.f194412j;
        if (r102 == null) goto L9;
        ((ArrayList) r102).add(r100);
        return;
    L9:
        return;
    }

    @Override // bz3.b
    public final void h(CommentMentionEditText r100) {
        ManagerContext r101 = this.f194426b;
        if (r101 == null) goto L8;
        cz3.a r102 = r101.f194414l;
        if (r102 == null) goto L9;
        r102.y(r100);
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final b i(jy3.a r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        CmtInputPresenterManager r101 = this.f194425a;
        if (r101 != null) goto L5;
    L21:
        return this;
    L5:
        if (Intrinsics.areEqual(r100.getTag(), CommentConstants$PresenterTag.KEYBOARD) == false) goto L11;
        ManagerContext r102 = r101.f194406d;
        if (r102 == null) goto L21;
        g r103 = r102.f194417o;
        if (r103 == null) goto L21;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.comment.api.services.OnKeyBoardService");
        r103.g((jy3.d) r100);
        goto L21
    L11:
        Iterator r104 = ((ArrayList) r101.f194405c).iterator();
    L13:
        if (r104.hasNext() == false) goto L17;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(r100.getTag(), ((a) r105).f194420c) == false) goto L13;
    L18:
        a r106 = (a) r105;
        if (r106 == null) goto L21;
        r106.f194422e = r100;
        goto L21
    L17:
        r105 = null;
        goto L18
    }

    public final void j(String r100) {
        CmtInputPresenterManager r101 = this.f194425a;
        if (r101 == null) goto L60;
        Intrinsics.checkNotNullParameter(r100, "tag");
        Iterator r102 = ((ArrayList) r101.f194405c).iterator();
    L5:
        az3.a r103 = null;
        if (r102.hasNext() == false) goto L10;
        Object r104 = r102.next();
        if (Intrinsics.areEqual(((a) r104).f194420c, r100) == false) goto L5;
    L12:
        if (((a) r104) == null) goto L29;
        Intrinsics.checkNotNullParameter(r100, "tag");
        Iterator r105 = ((ArrayList) r101.f194405c).iterator();
    L15:
        if (r105.hasNext() == false) goto L19;
        Object r106 = r105.next();
        if (Intrinsics.areEqual(((a) r106).f194420c, r100) == false) goto L15;
    L20:
        a r107 = (a) r106;
        if (r107 == null) goto L29;
        r107.C();
        ((ArrayList) r101.f194405c).remove(r107);
        ManagerContext r108 = r101.f194406d;
        if (r108 == null) goto L29;
        hy3.b r109 = r108.f194409g;
        if (r109 == null) goto L29;
        Map<String, View> r110 = r109.f487633d;
        if (r110 == null) goto L29;
        View r111 = r110.remove(r100);
        goto L29
    L19:
        r106 = null;
    L29:
        d r112 = (d) r101.f194407e.getValue();
        ManagerContext r113 = r101.f194406d;
        Intrinsics.checkNotNull(r113);
        r112.getClass();
        Intrinsics.checkNotNullParameter(r113, "managerContext");
        Intrinsics.checkNotNullParameter(r100, "tag");
        switch(r100.hashCode()) {
            case -1514920366: goto L48;
            case -834306487: goto L45;
            case -537241352: goto L41;
            case -507768060: goto L37;
            case -165469273: goto L33;
            default: goto L51;
        };
    L51:
        if (r103 == null) goto L61;
        ((ArrayList) r101.f194405c).add(r103);
        return;
    L61:
        return;
    L33:
        if (r100.equals(CommentConstants$PresenterTag.EDIT) == false) goto L51;
        r103 = new cz3.c(r113, r100);
        goto L51
    L37:
        if (r100.equals(CommentConstants$PresenterTag.KEYBOARD) == false) goto L51;
        r103 = new k(r113, r100);
        goto L51
    L41:
        if (r100.equals(CommentConstants$PresenterTag.CHECKER) == false) goto L51;
        r103 = new j(r113, r100);
        goto L51
    L45:
        if (r100.equals(CommentConstants$PresenterTag.EMOJI) == false) goto L51;
        r103 = new f(r113, r100);
        goto L51
    L48:
        if (r100.equals(CommentConstants$PresenterTag.PUBLISH) == false) goto L51;
        r103 = new m(r113, r100);
        goto L51
    L10:
        r104 = null;
        goto L12
    }

    public final void k(boolean r100, String r101, CommentMobParameters r102) {
        ManagerContext r103 = this.f194426b;
        if (r103 == null) goto L7;
        Integer r104 = r103.a();
        if (r104 == null) goto L7;
        r104.intValue();
    L7:
        ManagerContext r105 = this.f194426b;
        n r106 = null;
        if (r105 == null) goto L12;
        g r107 = r105.f194417o;
        if (r107 == null) goto L12;
        com.bytedance.awemeopen.apps.framework.comment.write.g r108 = new com.bytedance.awemeopen.apps.framework.comment.write.g();
        r108.f194459a = null;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r108.f194460b = r100;
        r108.f194461c = r102;
        r107.l(r108);
    L12:
        ManagerContext r109 = this.f194426b;
        if (r109 == null) goto L19;
        WeakReference<n> r110 = com.bytedance.awemeopen.apps.framework.comment.write.f.f194458a;
        if (r110 == null) goto L17;
        r106 = r110.get();
    L17:
        r109.f561865c = r106;
        return;
    }

    public final void l(User r100, CommentMobParameters r101, com.bytedance.awemeopen.apps.framework.comment.write.g.a r102) {
        ManagerContext r103 = this.f194426b;
        if (r103 == null) goto L6;
        boolean r104 = r103.f561867e;
    L6:
        if (r103 == null) goto L10;
        Integer r105 = r103.a();
        if (r105 == null) goto L10;
        r105.intValue();
    L10:
        r102.getClass();
        r102.f194462a = r100;
        r102.f194464c = r101;
        com.bytedance.awemeopen.apps.framework.comment.write.g r106 = new com.bytedance.awemeopen.apps.framework.comment.write.g();
        if (r102.f194462a == null) goto L13;
        Application r107 = y54.a.a();
        User r108 = r102.f194462a;
        Intrinsics.checkNotNull(r108);
        String r109 = r107.getString(R.string.aos_comment_reply_comment, new Object[]{r108.t()});
    L14:
        r106.f194459a = r109;
        Intrinsics.checkNotNullParameter(r102.f194465d, "<set-?>");
        r106.f194460b = r102.f194463b;
        r106.f194461c = r102.f194464c;
        ManagerContext r110 = this.f194426b;
        if (r110 == null) goto L20;
        g r111 = r110.f194417o;
        if (r111 == null) goto L21;
        r111.l(r106);
        return;
    L21:
        return;
    L20:
        return;
    L13:
        r109 = null;
        goto L14
    }
}
