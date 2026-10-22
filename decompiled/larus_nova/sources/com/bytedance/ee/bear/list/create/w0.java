package com.bytedance.ee.bear.list.create;

import android.os.Bundle;
import com.bytedance.ee.bear.document.DocViewModel;
import com.ss.android.cert.manager.constants.EventConstant;

/* JADX INFO: loaded from: classes18.dex */
public final class w0 {
    public static Bundle a(iw4.b r100) {
        Bundle r101 = new Bundle();
        r101.putString(EventConstant.Key.MODULE, r100.f496187c);
        r101.putString("sub_module", r100.f496188d);
        r101.putString("src_module", r100.f496189e);
        r101.putString(DocViewModel.EXTRA_PARENT_TOKEN, r100.f496186b);
        return r101;
    }
}
