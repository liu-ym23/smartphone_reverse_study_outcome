package com.bytedance.awemeopen.apps.framework.comment.write;

import android.app.Activity;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.awemeopen.apps.framework.comment.write.viewmodel.CommentCommonDataViewModel;
import com.bytedance.awemeopen.apps.framework.comment.write.viewmodel.CommentInputContentViewModel;
import com.bytedance.awemeopen.infra.util.ToastUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class b {
    public String a;
    public Activity b;
    public CommentInputContentViewModel c;
    public CommentCommonDataViewModel d;

    public b() {
    }

    public abstract com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.b b();

    public abstract void d();

    public abstract void e();

    public static y24.d c() {
        d14.a r0 = b14.a.a;
        return b14.a.a(y24.d.class);
    }

    public final boolean a() {
        CommentCommonDataViewModel r0 = this.d;
        if (r0 == null) goto L9;
        r14.c r1 = r0.getCurrentAweme();
        if (r1 == null) goto L9;
        if (r1.a() == true) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L13;
        Activity r3 = this.b;
        Intrinsics.checkNotNull(r3);
        ToastUtils.b(r3, 2131894302);
        return false;
    L13:
        CommentCommonDataViewModel r4 = this.d;
        if (r4 == null) goto L22;
        r14.c r5 = r4.getCurrentAweme();
        if (r5 == null) goto L22;
        r14.e r6 = r5.m();
        if (r6 == null) goto L22;
        if (r6.a() != 1) goto L22;
        boolean r7 = true;
    L23:
        r14.c r8 = null;
        if (r7 == false) goto L33;
        y24.d r9 = c();
        CommentCommonDataViewModel r10 = this.d;
        if (r10 == null) goto L28;
        r14.c r11 = r10.getCurrentAweme();
    L29:
        Intrinsics.checkNotNull(r11);
        if (r9.E1(r11) == true) goto L33;
        Activity r12 = this.b;
        Intrinsics.checkNotNull(r12);
        ToastUtils.b(r12, 2131894301);
        return false;
    L28:
        r11 = null;
    L33:
        CommentCommonDataViewModel r13 = this.d;
        if (r13 == null) goto L42;
        r14.c r14 = r13.getCurrentAweme();
        if (r14 == null) goto L42;
        r14.e r15 = r14.m();
        if (r15 == null) goto L42;
        if (r15.a() != 2) goto L42;
        boolean r16 = true;
    L43:
        if (r16 == false) goto L51;
        y24.d r17 = c();
        CommentCommonDataViewModel r18 = this.d;
        if (r18 == null) goto L47;
        r8 = r18.getCurrentAweme();
    L47:
        Intrinsics.checkNotNull(r8);
        if (r17.M(r8) == true) goto L51;
        Activity r19 = this.b;
        Intrinsics.checkNotNull(r19);
        ToastUtils.b(r19, 2131894303);
        return false;
    L51:
        return true;
    L42:
        r16 = false;
    L22:
        r7 = false;
    L9:
        r2 = false;
        goto L10
    }

    public void f(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "pageOwner");
        this.b = r2.getActivity();
        CommentInputContentViewModel.a r4 = CommentInputContentViewModel.Companion;
        ViewModelStoreOwner r0 = r2.e;
        r4.getClass();
        this.c = CommentInputContentViewModel.a.a(r0);
        CommentCommonDataViewModel.a r5 = CommentCommonDataViewModel.Companion;
        ViewModelStoreOwner r6 = r2.e;
        r5.getClass();
        this.d = CommentCommonDataViewModel.a.a(r6);
    }
}
