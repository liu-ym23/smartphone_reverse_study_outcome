package com.bytedance.lark.lynxlib.behavior;

import android.content.Context;
import com.larus.nova.R;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public final class m implements y76.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f253260a;

    @Override // y76.a
    public final Map<String, String> a() {
        HashMap r100 = new HashMap();
        r100.put("cancel", this.f253260a.getString(R.string.lark_brand_cancel));
        r100.put("confirm", this.f253260a.getString(R.string.lark_brand_confirm));
        r100.put("wheel_text_bound_text", "");
        return r100;
    }

    public m(Context r100) {
        this.f253260a = r100;
    }
}
