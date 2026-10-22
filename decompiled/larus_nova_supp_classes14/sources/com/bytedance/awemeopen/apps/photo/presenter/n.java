package com.bytedance.awemeopen.apps.photo.presenter;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.awemeopen.apps.framework.comment.CommentListView;
import com.bytedance.awemeopen.apps.framework.comment.CommentPageParam;
import com.bytedance.awemeopen.apps.framework.comment.write.viewmodel.CommentCommonDataViewModel;
import com.bytedance.awemeopen.apps.framework.comment.write.viewmodel.CommentInputContentViewModel;
import com.bytedance.awemeopen.apps.photo.view.CustomCoordinatorLayout;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.bizmodels.utils.AwemeCheckUtilsKt;
import com.bytedance.awemeopen.export.api.picturedetail.AosPictureDetailConfig;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n extends f04.a<Unit> {
    public final a14.a d;
    public final CommentListView e;
    public final CustomCoordinatorLayout f;
    public final ViewGroup g;
    public final zz3.h h;
    public CommentCommonDataViewModel i;

    @Override // f04.a
    public final void k() {
        this.e.u();
    }

    public n(a14.a r2) {
        Intrinsics.checkNotNullParameter(r2, "pgParameters");
        super(r2.b);
        this.d = r2;
        this.e = (CommentListView) i(2131367388);
        this.f = (CustomCoordinatorLayout) i(2131368370);
        this.g = (ViewGroup) i(2131381794);
        this.h = new zz3.h();
    }

    @Override // f04.a
    public final void j(Unit r19) {
        Intrinsics.checkNotNullParameter(r19, "unit");
        CommentCommonDataViewModel.a r1 = CommentCommonDataViewModel.Companion;
        ViewModelStoreOwner r2 = this.d.e;
        r1.getClass();
        CommentCommonDataViewModel r3 = CommentCommonDataViewModel.a.a(r2);
        this.i = r3;
        if (r3 == null) goto L6;
        r3.setSceneId("graphic_detail_bottom_comment");
    L6:
        CommentCommonDataViewModel r4 = this.i;
        String r5 = "";
        if (r4 == null) goto L15;
        AosPictureDetailConfig r6 = this.d.c.getPageConfig();
        if (r6 == null) goto L13;
        String r7 = r6.getPreviousPage();
        if (r7 == null) goto L13;
    L14:
        r4.setPreviousPage(r7);
    L13:
        r7 = "";
    L15:
        CommentCommonDataViewModel r8 = this.i;
        if (r8 == null) goto L19;
        r8.setCurrentAweme(this.d.a);
    L19:
        zz3.h r9 = this.h;
        Observer<Long> r10 = new l(this);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "observer");
        r9.a.a(r10);
        CommentListView r11 = this.e;
        CommentPageParam r12 = new CommentPageParam();
        String r13 = this.d.a.c();
        Intrinsics.checkNotNullParameter(r13, "awemeId");
        r12.a = r13;
        r12.u = this.d.a.i();
        User r14 = this.d.a.f();
        if (r14 == null) goto L23;
        String r15 = r14.u();
        if (r15 == null) goto L23;
    L24:
        Intrinsics.checkNotNullParameter(r15, "authorOpenId");
        r12.b = r15;
        r12.c = !this.d.a.l();
        r14.j r16 = this.d.a.L();
        if (r16 == null) goto L27;
        long r17 = r16.c();
    L28:
        r12.d = r17;
        User r18 = this.d.a.f();
        if (r18 == null) goto L31;
        Integer r20 = Integer.valueOf(r18.n());
    L32:
        r12.e = r20;
        r12.f = Integer.valueOf(this.d.a.U() ? 1 : 0);
        r14.a0 r21 = this.d.a.d;
        if (r21 == null) goto L36;
        String r22 = r21.a();
        if (r22 == null) goto L36;
    L37:
        Intrinsics.checkNotNullParameter(r22, "imprId");
        r12.h = r22;
        String r23 = this.d.a.u();
        if (r23 == null) goto L41;
        r5 = r23;
    L41:
        Intrinsics.checkNotNullParameter(r5, "hostRawData");
        r12.k = r5;
        if (this.d.a.W() == false) goto L44;
        String r24 = "origin";
    L45:
        Intrinsics.checkNotNullParameter(r24, "groupSource");
        r12.i = r24;
        String r25 = this.d.c.sceneId();
        Intrinsics.checkNotNullParameter(r25, "eventType");
        r12.g = r25;
        r12.n = true;
        int r26 = com.bytedance.awemeopen.apps.framework.utils.e.c;
        r12.v = com.bytedance.awemeopen.apps.framework.utils.e.a.a(this.d.a);
        r11.t(r12, this.h);
        CommentListView r27 = this.e;
        Activity r110 = this.d.getActivity();
        a14.a r28 = this.d;
        r27.setPageOwner(new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b(r110, r28.b, this.f, r28.d, r28.e, null, 0, 224));
        zz3.h r29 = this.h;
        r14.j r30 = this.d.a.L();
        if (r30 == null) goto L48;
        long r31 = r30.c();
    L49:
        r29.b(r31);
        CommentInputContentViewModel.a r32 = CommentInputContentViewModel.Companion;
        ViewModelStoreOwner r33 = this.d.e;
        r32.getClass();
        CommentInputContentViewModel r34 = CommentInputContentViewModel.a.a(r33);
        if (r34 == null) goto L55;
        MutableLiveData<Integer> r35 = r34.getPublishSuccessLiveData();
        if (r35 == null) goto L56;
        r35.observe(this.d.d, new m(this));
        return;
    L56:
        return;
    L55:
        return;
    L48:
        Long r36 = 0L;
        AwemeCheckUtilsKt.a(r36, null, 3);
        r31 = r36.longValue();
        goto L49
    L44:
        r24 = "sdk";
    L36:
        r22 = "";
        goto L37
    L31:
        r20 = null;
        goto L32
    L27:
        r17 = 0;
    L23:
        r15 = "";
        goto L24
    }
}
