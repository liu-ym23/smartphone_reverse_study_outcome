package com.ss.android.lark.keyboard.edittext2.edittors.anchor.widecharurl;

import android.text.Spannable;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import hob.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d extends com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.b {

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.b, fob.f
    public final List<com.ss.android.lark.keyboard.edittext2.utils.b.a> a(Spannable r100) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        ArrayList r101 = new ArrayList();
        com.ss.android.lark.keyboard.edittext2.utils.b.e(r100, r101);
        if (r101.size() != 1) goto L6;
        return r101;
    L6:
        return super.a(r100);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.b, fob.f
    public final /* bridge */ /* synthetic */ hob.b b(com.ss.android.lark.keyboard.edittext2.utils.b.a r100) {
        return d(r100);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.b
    public final j d(com.ss.android.lark.keyboard.edittext2.utils.b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "parseInfo");
        if (r100.f429253d == false) goto L7;
        j r101 = new j(r100.f429250a);
        Map<String, Object> r102 = r101.f486306c;
        HashMap r103 = (HashMap) r102;
        r103.put("key::use::wide::character:regex", Boolean.TRUE);
        return r101;
    L7:
        return super.d(r100);
    }

    public d(fob.d<j> r100, eob.a r101) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        Intrinsics.checkNotNullParameter(r101, "editor");
        super(r100, r101);
    }
}
