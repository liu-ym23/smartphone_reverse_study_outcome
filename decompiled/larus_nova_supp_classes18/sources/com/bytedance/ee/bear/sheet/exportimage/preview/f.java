package com.bytedance.ee.bear.sheet.exportimage.preview;

import android.content.ClipData;
import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.supervisor.token.Token;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements Runnable {
    public final /* synthetic */ SheetImagePreviewFragment a;

    public f(SheetImagePreviewFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ClipData r0 = ClipData.newPlainText(null, this.a.p);     // Catch: Throwable -> L6
        if (((fu5.a) org.koin.java.a.a(fu5.a.class)).h(r0, new Token("LARK-PSDA-ccm_android_sheet_card_mode_copy_text")) == false) goto L9;
        Context r1 = this.a.getContext();     // Catch: Throwable -> L6
        Context r2 = this.a.getContext();     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L6
        Toast.showSuccessTextWithMargin(r1, r2.getResources().getText(2131887614), 0);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
