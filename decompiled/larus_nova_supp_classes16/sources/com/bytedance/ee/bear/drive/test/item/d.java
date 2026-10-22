package com.bytedance.ee.bear.drive.test.item;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ c a;

    public d(c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        c r5 = this.a;
        r5.getClass();
        FileSelectConfig.f r0 = FileSelectConfig.filePickerBuilder();
        r0.a.fileSelectListener = new f(r5);
        FileSelectConfig r1 = r0.a();
        int r2 = com.bytedance.ee.bear.fileselector.d.a;
        Context r3 = r5.a.getBaseContext();
        FragmentManager r6 = r5.a.getSupportFragmentManager();
        Intrinsics.checkNotNull(r1);
        com.bytedance.ee.bear.fileselector.d.a.c(r3, r6, r1, "Test");
    }
}
