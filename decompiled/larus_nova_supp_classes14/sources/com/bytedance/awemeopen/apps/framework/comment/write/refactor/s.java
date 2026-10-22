package com.bytedance.awemeopen.apps.framework.comment.write.refactor;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.awemeopen.apps.framework.comment.api.statistics.CommentMobParameters;
import com.bytedance.awemeopen.apps.framework.comment.util.CommentKeyboardUtils;
import com.bytedance.awemeopen.apps.framework.comment.write.viewmodel.CommentInputContentViewModel;
import com.bytedance.awemeopen.apps.framework.comment.write.viewmodel.CommentPanelParamViewModel;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s extends BaseInputPanel {
    public ViewGroup r;
    public Animator s;
    public boolean t;

    public final g C() {
        g r0 = this.k;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
    L30:
        g r1 = this.k;
        if (r1 == null) goto L33;
        r1.c = this.e;
    L33:
        Intrinsics.checkNotNull(r1);
        return r1;
    L5:
        g r2 = new g(this.d, this.f);
        this.k = r2;
        r2.c = this.e;
        m r3 = this.l;
        iy3.a<?> r4 = r3.a;
        r2.f = r4;
        r3.a = r4;
        String r5 = r3.b;
        Intrinsics.checkNotNullParameter(r5, "scene");
        if (this.k == null) goto L9;
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
    L9:
        m r6 = this.l;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r6.b = r5;
        m r7 = this.l;
        r7.getClass();
        z(r7.c);
        m r8 = this.l;
        com.bytedance.awemeopen.apps.framework.comment.write.h r9 = r8.d;
        g r10 = this.k;
        if (r10 == null) goto L13;
        r10.p = r9;
    L13:
        r8.d = r9;
        com.bytedance.awemeopen.apps.framework.comment.write.i r11 = r8.e;
        if (r10 == null) goto L17;
        r10.r = r11;
    L17:
        r8.e = r11;
        com.bytedance.awemeopen.apps.framework.comment.write.j r12 = r8.f;
        if (r10 == null) goto L21;
        r10.q = r12;
    L21:
        r8.f = r12;
        String r13 = r8.g;
        if (r10 == null) goto L25;
        r10.j = r13;
    L25:
        r8.g = r13;
        r8.getClass();
        bz3.b r14 = r8.h;
        g r15 = this.k;
        if (r15 == null) goto L29;
        r15.o = r14;
    L29:
        this.l.h = r14;
        Intrinsics.checkNotNull(r15);
        goto L30
    }

    public final void E(boolean r5) {
        boolean r0 = true;
        AoLogger.b("write_comment", new Object[]{"updateOperationLayoutVisibility: " + r5});
        if (r5 == false) goto L41;
        ViewGroup r6 = this.r;
        if (r6 == null) goto L8;
        r6.setVisibility(0);
    L8:
        CommentPanelParamViewModel.a r7 = CommentPanelParamViewModel.Companion;
        ViewModelStoreOwner r2 = this.f.e;
        r7.getClass();
        CommentPanelParamViewModel r8 = CommentPanelParamViewModel.a.a(r2);
        if (r8 == null) goto L13;
        r8.setMiniPanelIsShowed(true);
    L13:
        if (this.t == true) goto L17;
        this.t = true;
        com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.g.a r9 = com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.g.m1;
        g r3 = this.k;
        r9.getClass();
        com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.g r10 = com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.g.a.a(r3);
        if (r10 == null) goto L17;
        r10.o();
    L17:
        ViewGroup r11 = this.r;
        if (r11 != null) goto L20;
    L22:
        boolean r12 = false;
    L23:
        if (r12 == false) goto L46;
        Animator r13 = this.s;
        if (r13 != null) goto L27;
    L29:
        r0 = false;
    L30:
        if (r0 == false) goto L34;
        Animator r14 = this.s;
        if (r14 == null) goto L34;
        r14.cancel();
    L34:
        ViewGroup r15 = this.r;
        if (r15 == null) goto L38;
        r15.setAlpha(0.0f);
    L38:
        ObjectAnimator r16 = ObjectAnimator.ofFloat(this.r, View.ALPHA, new float[]{0.0f, 1.0f}).setDuration(100);
        this.s = r16;
        if (r16 == null) goto L47;
        r16.start();
        return;
    L47:
        return;
    L27:
        if (r13.isRunning() != true) goto L29;
    L46:
        return;
    L20:
        if (r11.getVisibility() != 8) goto L22;
        r12 = true;
        goto L23
    L41:
        ViewGroup r17 = this.r;
        if (r17 == null) goto L49;
        r17.setVisibility(8);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.refactor.BaseInputPanel, com.bytedance.awemeopen.apps.framework.comment.write.c
    public final void e(CommentMobParameters r6) {
        AoLogger.b("write_comment", new Object[]{"BaseKeyboardPanel#hide"});
        CommentKeyboardUtils.a(q(), this.d);
        this.e.T0();
        g r1 = this.k;
        if (r1 == null) goto L7;
        com.bytedance.awemeopen.apps.framework.comment.write.j r2 = r1.q;
        if (r2 == null) goto L7;
        r2.a(r6);
    L7:
        g r7 = this.k;
        if (r7 == null) goto L11;
        r7.g = false;
    L11:
        CommentInputContentViewModel.a r8 = CommentInputContentViewModel.Companion;
        ViewModelStoreOwner r3 = this.f.e;
        r8.getClass();
        CommentInputContentViewModel r9 = CommentInputContentViewModel.a.a(r3);
        if (r9 == null) goto L14;
        MutableLiveData<Boolean> r10 = r9.isKeyboardPanelShow();
    L15:
        if (r10 == null) goto L18;
        r10.setValue(Boolean.FALSE);
    L18:
        AoLogger.b("write_comment", new Object[]{"base onInputHide"});
        h r11 = this.p;
        r11.a.setValue(Boolean.TRUE);
        this.t = false;
        return;
    L14:
        r10 = null;
        goto L15
    }

    public final void D(boolean r5, boolean r6) {
        AoLogger.b("write_comment", new Object[]{"Portrait#onKeyboardVisibleStateChanged, visible=" + r5 + ", isFloating=" + r6});
        if (r6 == false) goto L5;
        com.bytedance.awemeopen.apps.framework.comment.util.c.a(this.j, CommentKeyboardUtils.b(false, false));
    L5:
        com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.g.a r7 = com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.g.m1;
        g r1 = this.k;
        r7.getClass();
        com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.g r8 = com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.g.a.a(r1);
        g r2 = this.k;
        if (r2 == null) goto L9;
        r2.g = r5;
    L9:
        if (r5 == false) goto L16;
        if (r2 == null) goto L13;
        r2.h = false;
    L13:
        if (r8 == null) goto L15;
        r8.m(false);
    L15:
        E(true);
        return;
    L16:
        if (r2 != null) goto L18;
    L20:
        boolean r9 = false;
    L21:
        if (r9 == false) goto L27;
        if (r8 == null) goto L24;
        r8.m(true);
    L24:
        E(false);
        return;
    L27:
        return;
    L18:
        if (r2.h != true) goto L20;
        r9 = true;
        goto L21
    }

    public s(Context r2, com.bytedance.awemeopen.apps.framework.comment.write.d r3, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r4) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "keyboardView");
        Intrinsics.checkNotNullParameter(r4, "pageOwner");
        super(r2, r3, r4);
    }
}
