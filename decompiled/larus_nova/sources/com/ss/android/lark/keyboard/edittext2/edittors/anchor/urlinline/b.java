package com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline;

import android.text.Spannable;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import fob.f;
import hob.j;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class b extends f<j> {
    @Override // fob.f
    public List<com.ss.android.lark.keyboard.edittext2.utils.b.a> a(Spannable r100) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        ArrayList r101 = new ArrayList();
        com.ss.android.lark.keyboard.edittext2.utils.b.a(r100, r101);
        return r101;
    }

    @Override // fob.f
    public /* bridge */ /* synthetic */ hob.b b(com.ss.android.lark.keyboard.edittext2.utils.b.a r100) {
        return d(r100);
    }

    public j d(com.ss.android.lark.keyboard.edittext2.utils.b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "parseInfo");
        return new j(r100.f429250a);
    }

    public b(fob.d<j> r100, eob.a r101) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        Intrinsics.checkNotNullParameter(r101, "editor");
        super(r100, r101);
    }
}
