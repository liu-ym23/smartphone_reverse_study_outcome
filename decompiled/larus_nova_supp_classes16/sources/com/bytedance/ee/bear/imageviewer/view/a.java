package com.bytedance.ee.bear.imageviewer.view;

import android.view.View;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.bizwidget.shareview.i;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;
import com.bytedance.ee.bear.imageviewer.b0;
import com.bytedance.ee.bear.imageviewer.c3;
import com.bytedance.ee.bear.imageviewer.j3;
import com.bytedance.ee.bear.imageviewer.k3;
import com.bytedance.ee.bear.imageviewer.l3;
import com.bytedance.ee.bear.imageviewer.m3;
import com.bytedance.ee.bear.imageviewer.n3;
import com.bytedance.ee.bear.imageviewer.o3;
import com.bytedance.ee.bear.imageviewer.p3;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.vfs.VFSPath;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends i {
    public final /* synthetic */ ImageViewerShareDialogFragment a;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.imageviewer.view.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0192a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ShareType.values().length];
            r0[ShareType.Download.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[ShareType.Lark.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[ShareType.Wechat.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[ShareType.WechatMoments.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[ShareType.QQ.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[ShareType.Weibo.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[ShareType.More.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    public a(ImageViewerShareDialogFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.bizwidget.shareview.b
    public final boolean U10(final ShareItemModel r5) {
        Intrinsics.checkNotNullParameter(r5, "shareItem");
        ImageViewerShareDialogFragment.b r0 = this.a.l;
        if (r0 == null) goto L18;
        final c3.k r1 = (c3.k) r0;
        if (r5.getOnClickedListener() != null) goto L8;
        tt5.a.k("ImageViewer", "shareCustomItem(): onClickedListener is null");
    L17:
        boolean r6 = true;
    L19:
        if (r6 == true) goto L28;
    L27:
        return r6;
    L28:
        this.a.dismissAllowingStateLoss();     // Catch: Exception -> L23
    L23:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L27;
        d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L27
    L8:
        if (c3.J(r1.a.mC()) == false) goto L10;
        final c3 r3 = r1.a;
        r3.getClass();
        r3.X(new b0(r3, r5));
        goto L17
    L10:
        View r4 = r1.a.iF();
        r1.a.getClass();
        VFSPath r7 = c3.t(c3.u(r4));
        if (r7 == null) goto L14;
        Flowable r8 = Flowable.just(r7).subscribeOn(fo5.d.c());
        final c3 r9 = r1.a;
        Disposable r10 = r8.map(new j3(r9)).observeOn(fo5.d.d()).subscribe(new k3(r1, r5), new l3(r1));
        r1.a.Y.add(r10);
        goto L17
    L14:
        if (r1.a.j("shareCustomItem") == false) goto L17;
        c3 r11 = r1.a;
        final ImageData.Image r12 = (ImageData.Image) ListProtector.get(r11.C, r11.G);
        Disposable r13 = Flowable.just(r12.getRealSrc()).subscribeOn(fo5.d.c()).map(new m3(r1, r12)).map(new n3(r1)).observeOn(fo5.d.d()).subscribe(new o3(r1, r5), new p3(r1));
        r1.a.Y.add(r13);
        goto L17
    L18:
        r6 = false;
        goto L19
    }

    @Override // com.bytedance.ee.bear.bizwidget.shareview.b
    public final boolean Yl(ShareType r2) {
        Intrinsics.checkNotNullParameter(r2, "shareType");
        ImageViewerShareDialogFragment.b r0 = this.a.l;
        if (r0 != null) goto L7;
        return true;
    L7:
        return ((c3.k) r0).a(r2);
    }

    @Override // com.bytedance.ee.bear.bizwidget.shareview.b
    public final boolean rF(ShareItemModel r3) {
        Intrinsics.checkNotNullParameter(r3, "shareItem");
        ImageViewerShareDialogFragment.b r0 = this.a.l;
        if (r0 == null) goto L9;
        c3.k r1 = (c3.k) r0;
        if (r3.getType() != null) goto L7;
        ShareType r4 = ShareType.More;
    L11:
        return r1.a(r4);
    L7:
        r4 = r3.getType();
        goto L11
    L9:
        return true;
    }

    @Override // com.bytedance.ee.bear.bizwidget.shareview.i, com.bytedance.ee.bear.bizwidget.shareview.b
    public final void s10(ShareType r3) {
        Intrinsics.checkNotNullParameter(r3, "shareType");
        this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
    L10:
        switch(C0192a.a[r3.ordinal()]) {
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L12;
            case 4: goto L12;
            case 5: goto L12;
            case 6: goto L12;
            case 7: goto L12;
            default: goto L11;
        };
    L11:
        super.s10(r3);
        return;
    L12:
        ImageViewerShareDialogFragment.b r0 = this.a.l;
        if (r0 == null) goto L19;
        ((c3.k) r0).b(r3);
        return;
    L19:
        return;
    L5:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L10;
        d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }
}
