package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockViewSwitchManager;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.RequestPasswordView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class t<T> implements Observer {
    public final /* synthetic */ PDFCtrlView a;

    public t(PDFCtrlView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        Integer r11 = (Integer) r10;
        if (r11 == null) goto L40;
        PDFContentView r0 = this.a.getPdfContentViewFromXml();
        ViewOwner r1 = this.a.j;
        ViewOwner r2 = null;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r1 = null;
    L8:
        int r4 = r11.intValue();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "viewOwner");
        tt5.a.h("PDFContentView", "showPasswordView, status: " + r4);
        boolean r7 = false;
        if (r0.a != null) goto L16;
        RequestPasswordView r5 = ((ii5.b) org.koin.java.a.c(ii5.b.class, null, null, 6)).b(r0.getContext());     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L12
    L14:
        r5.setVisibility(0);
        r5.setTips(2131888393);
        r5.setOnInputPasswordListener(new c(r0));
        r5.setTag("REQUEST_PASSWORD_VIEW_TAG");
        new DriveBlockViewSwitchManager(r1).a(new b(r5));
        r0.a = r5;
    L12:
        th = move-exception;
        tt5.a.e("PDFContentView", "create request password view failed", th, false);
        ii5.a r6 = ii5.a.a;
        RequestPasswordView r8 = new RequestPasswordView(r0.getContext());
        Intrinsics.checkNotNull(r8);
        r5 = r8;
    L16:
        if (r4 != 1) goto L20;
        ViewGroup r9 = (ViewGroup) r0.findViewById(2131392488);
        if (r9 == null) goto L29;
        r9.removeView(r0.a);
    L29:
        this.a.n();
        this.a.m();
        ViewOwner r3 = this.a.j;
        if (r3 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
    L33:
        MutableLiveData<Boolean> r12 = ((PreviewViewModel) r2.viewModel(PreviewViewModel.class)).liveInnerPasswordEncrypted;
        if (r11.intValue() == 1) goto L36;
        r7 = true;
    L36:
        r12.setValue(Boolean.valueOf(r7));
        return;
    L32:
        r2 = r3;
        goto L33
    L20:
        RequestPasswordView r13 = r0.a;
        if (r13 == null) goto L23;
        ViewParent r14 = r13.getParent();
    L24:
        if (r14 != null) goto L26;
        ((ViewGroup) r0.findViewById(2131392488)).addView(r0.a, new ViewGroup.LayoutParams(-1, -1));
        goto L29
    L26:
        RequestPasswordView r16 = r0.a;
        if (r16 == null) goto L29;
        Toast.showFailureText(r16.getContext(), r16.getResources().getString(2131888104), 0);
        r16.c();
        goto L29
    L23:
        r14 = null;
        goto L24
    }
}
