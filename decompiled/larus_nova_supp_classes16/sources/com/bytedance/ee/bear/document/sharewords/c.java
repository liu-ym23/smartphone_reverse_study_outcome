package com.bytedance.ee.bear.document.sharewords;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.ee.bear.bizwidget.shareview.ExternalShareMinaConfig;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemUtil;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.bizwidget.shareview.i;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c extends i {
    public final /* synthetic */ OfficeShareWordsDialogFragment a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ShareType.values().length];
            r0[ShareType.Lark.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[ShareType.CopyLink.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[ShareType.CopyText.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[ShareType.Wechat.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[ShareType.WechatMoments.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[ShareType.QQ.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[ShareType.Weibo.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[ShareType.More.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    @Override // com.bytedance.ee.bear.bizwidget.shareview.b
    public final boolean Yl(ShareType r2) {
        Intrinsics.checkNotNullParameter(r2, "shareType");
        return true;
    }

    @Override // com.bytedance.ee.bear.bizwidget.shareview.b
    public final boolean rF(ShareItemModel r2) {
        Intrinsics.checkNotNullParameter(r2, "shareItem");
        return true;
    }

    public c(OfficeShareWordsDialogFragment r1) {
        this.a = r1;
    }

    public static void a(OfficeShareWordsDialogFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.shareview.b
    public final boolean U10(ShareItemModel r10) {
        Intrinsics.checkNotNullParameter(r10, "shareItem");
        Context r0 = this.a.getContext();
        if (r0 == null) goto L16;
        OfficeShareWordsDialogFragment r1 = this.a;
        ShareItemModel.a r2 = r10.getOnClickedListener();
        Boolean r3 = null;
        if (r2 == null) goto L14;
        int r4 = OfficeShareWordsDialogFragment.w;
        String r5 = r1.ta0();
        Bundle r6 = r1.getArguments();
        if (r6 == null) goto L9;
        String r7 = r6.getString("arg_share_title");
    L10:
        Bundle r8 = r1.getArguments();
        int r9 = -1;
        if (r8 == null) goto L13;
        r9 = r8.getInt("arg_doc_type", -1);
    L13:
        r3 = Boolean.valueOf(r2.a(r0, r10, new com.bytedance.ee.bear.share.g(r5, ShareItemUtil.b(r0, r7, r9), r5, null)));
        goto L14
    L9:
        r7 = null;
    L14:
        if (r3 == null) goto L16;
        boolean r11 = r3.booleanValue();
    L17:
        if (r11 == false) goto L19;
        a(this.a);
    L19:
        return r11;
    L16:
        r11 = false;
        goto L17
    }

    @Override // com.bytedance.ee.bear.bizwidget.shareview.i, com.bytedance.ee.bear.bizwidget.shareview.b
    public final void s10(ShareType r6) {
        Intrinsics.checkNotNullParameter(r6, "shareType");
        switch(a.a[r6.ordinal()]) {
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L22;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L9;
            case 7: goto L9;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        super.s10(r6);
        return;
    L5:
        Context r7 = this.a.getContext();
        if (r7 != null) goto L8;
        return;
    L8:
        a(this.a);
        OfficeShareWordsDialogFragment r0 = this.a;
        int r3 = OfficeShareWordsDialogFragment.w;
        r0.getClass();
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).Y9().c(r7, r0.ta0(), null);
        return;
    L9:
        a(this.a);
        OfficeShareWordsDialogFragment r1 = this.a;
        int r4 = OfficeShareWordsDialogFragment.w;
        Context r5 = r1.getContext();
        if (r5 == null) goto L32;
        com.bytedance.ee.bear.share.e r2 = ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).Y9();
        if (r6 != ShareType.WechatMoments) goto L16;
        r1.sa0(r5);
        r2.getClass();
        km5.c.f(r5);
        return;
    L16:
        if (((ExternalShareMinaConfig) r1.v.getValue()).isShareChannelBanned(r6) == false) goto L18;
    L21:
        String r8 = r1.ta0();
        r2.getClass();
        km5.c.j(r5, r6, r8, null);
        return;
    L18:
        if (((ExternalShareMinaConfig) r1.v.getValue()).isShareDomainBanned(r6) == true) goto L21;
        String r9 = r1.ta0();
        r2.getClass();
        km5.c.i(r5, r6, r9, null);
        return;
    L32:
        return;
    L22:
        Context r10 = this.a.getContext();
        if (r10 != null) goto L25;
        return;
    L25:
        a(this.a);
        OfficeShareWordsDialogFragment r11 = this.a;
        int r12 = OfficeShareWordsDialogFragment.w;
        r11.sa0(r10);
    }
}
