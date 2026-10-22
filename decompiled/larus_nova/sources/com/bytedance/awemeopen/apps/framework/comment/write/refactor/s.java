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

/* JADX INFO: loaded from: classes14.dex */
public final class s extends BaseInputPanel {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ViewGroup f194566r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Animator f194567s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f194568t;

    public final g C() {
        g r100 = this.f194500k;
        if (r100 == null) goto L5;
        Intrinsics.checkNotNull(r100);
    L30:
        g r101 = this.f194500k;
        if (r101 == null) goto L33;
        r101.f561865c = this.f194494e;
    L33:
        Intrinsics.checkNotNull(r101);
        return r101;
    L5:
        g r102 = new g(this.f194493d, this.f194495f);
        this.f194500k = r102;
        r102.f561865c = this.f194494e;
        m r103 = this.f194501l;
        iy3.a<?> r104 = r103.f194553a;
        r102.f561868f = r104;
        r103.f194553a = r104;
        String r105 = r103.f194554b;
        Intrinsics.checkNotNullParameter(r105, "scene");
        if (this.f194500k == null) goto L9;
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
    L9:
        m r106 = this.f194501l;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r106.f194554b = r105;
        m r107 = this.f194501l;
        r107.getClass();
        z(r107.f194555c);
        m r108 = this.f194501l;
        com.bytedance.awemeopen.apps.framework.comment.write.h r109 = r108.f194556d;
        g r110 = this.f194500k;
        if (r110 == null) goto L13;
        r110.f194548p = r109;
    L13:
        r108.f194556d = r109;
        com.bytedance.awemeopen.apps.framework.comment.write.i r111 = r108.f194557e;
        if (r110 == null) goto L17;
        r110.f194550r = r111;
    L17:
        r108.f194557e = r111;
        com.bytedance.awemeopen.apps.framework.comment.write.j r112 = r108.f194558f;
        if (r110 == null) goto L21;
        r110.f194549q = r112;
    L21:
        r108.f194558f = r112;
        String r113 = r108.f194559g;
        if (r110 == null) goto L25;
        r110.f194542j = r113;
    L25:
        r108.f194559g = r113;
        r108.getClass();
        bz3.b r114 = r108.f194560h;
        g r115 = this.f194500k;
        if (r115 == null) goto L29;
        r115.f194547o = r114;
    L29:
        this.f194501l.f194560h = r114;
        Intrinsics.checkNotNull(r115);
        goto L30
    }

    public final void E(boolean r100) {
        boolean r101 = true;
        AoLogger.b("write_comment", new Object[]{"updateOperationLayoutVisibility: " + r100});
        if (r100 == false) goto L41;
        ViewGroup r102 = this.f194566r;
        if (r102 == null) goto L8;
        r102.setVisibility(0);
    L8:
        CommentPanelParamViewModel.a r103 = CommentPanelParamViewModel.Companion;
        ViewModelStoreOwner r104 = this.f194495f.f195173e;
        r103.getClass();
        CommentPanelParamViewModel r105 = CommentPanelParamViewModel.a.a(r104);
        if (r105 == null) goto L13;
        r105.setMiniPanelIsShowed(true);
    L13:
        if (this.f194568t == true) goto L17;
        this.f194568t = true;
        com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.g.a r106 = com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.g.f194535m1;
        g r107 = this.f194500k;
        r106.getClass();
        com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.g r108 = com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.g.a.a(r107);
        if (r108 == null) goto L17;
        r108.o();
    L17:
        ViewGroup r109 = this.f194566r;
        if (r109 != null) goto L20;
    L22:
        boolean r110 = false;
    L23:
        if (r110 == false) goto L46;
        Animator r111 = this.f194567s;
        if (r111 != null) goto L27;
    L29:
        r101 = false;
    L30:
        if (r101 == false) goto L34;
        Animator r112 = this.f194567s;
        if (r112 == null) goto L34;
        r112.cancel();
    L34:
        ViewGroup r113 = this.f194566r;
        if (r113 == null) goto L38;
        r113.setAlpha(0.0f);
    L38:
        ObjectAnimator r114 = ObjectAnimator.ofFloat(this.f194566r, View.ALPHA, new float[]{0.0f, 1.0f}).setDuration(100);
        this.f194567s = r114;
        if (r114 == null) goto L47;
        r114.start();
        return;
    L47:
        return;
    L27:
        if (r111.isRunning() != true) goto L29;
    L46:
        return;
    L20:
        if (r109.getVisibility() != 8) goto L22;
        r110 = true;
        goto L23
    L41:
        ViewGroup r115 = this.f194566r;
        if (r115 == null) goto L49;
        r115.setVisibility(8);
        return;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.awemeopen.apps.framework.comment.write.refactor.BaseInputPanel, com.bytedance.awemeopen.apps.framework.comment.write.c
    public final void e(CommentMobParameters r100) {
        AoLogger.b("write_comment", new Object[]{"BaseKeyboardPanel#hide"});
        CommentKeyboardUtils.a(q(), this.f194493d);
        this.f194494e.T0();
        g r101 = this.f194500k;
        if (r101 == null) goto L7;
        com.bytedance.awemeopen.apps.framework.comment.write.j r102 = r101.f194549q;
        if (r102 == null) goto L7;
        r102.a(r100);
    L7:
        g r103 = this.f194500k;
        if (r103 == null) goto L11;
        r103.f194539g = false;
    L11:
        CommentInputContentViewModel.a r104 = CommentInputContentViewModel.Companion;
        ViewModelStoreOwner r105 = this.f194495f.f195173e;
        r104.getClass();
        CommentInputContentViewModel r106 = CommentInputContentViewModel.a.a(r105);
        if (r106 == null) goto L14;
        MutableLiveData<Boolean> r107 = r106.isKeyboardPanelShow();
    L15:
        if (r107 == null) goto L18;
        r107.setValue(Boolean.FALSE);
    L18:
        AoLogger.b("write_comment", new Object[]{"base onInputHide"});
        this.f194505p.f565403a.setValue((T) Boolean.TRUE);
        this.f194568t = false;
        return;
    L14:
        r107 = null;
        goto L15
    }

    public final void D(boolean r100, boolean r101) {
        AoLogger.b("write_comment", new Object[]{"Portrait#onKeyboardVisibleStateChanged, visible=" + r100 + ", isFloating=" + r101});
        if (r101 == false) goto L5;
        com.bytedance.awemeopen.apps.framework.comment.util.c.a(this.f194499j, CommentKeyboardUtils.b(false, false));
    L5:
        com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.g.a r102 = com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.g.f194535m1;
        g r103 = this.f194500k;
        r102.getClass();
        com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.g r104 = com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji.g.a.a(r103);
        g r105 = this.f194500k;
        if (r105 == null) goto L9;
        r105.f194539g = r100;
    L9:
        if (r100 == false) goto L16;
        if (r105 == null) goto L13;
        r105.f194540h = false;
    L13:
        if (r104 == null) goto L15;
        r104.m(false);
    L15:
        E(true);
        return;
    L16:
        if (r105 != null) goto L18;
    L20:
        boolean r106 = false;
    L21:
        if (r106 == false) goto L27;
        if (r104 == null) goto L24;
        r104.m(true);
    L24:
        E(false);
        return;
    L27:
        return;
    L18:
        if (r105.f194540h != true) goto L20;
        r106 = true;
        goto L21
    }

    public s(Context r100, com.bytedance.awemeopen.apps.framework.comment.write.d r101, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "keyboardView");
        Intrinsics.checkNotNullParameter(r102, "pageOwner");
        super(r100, r101, r102);
    }
}
