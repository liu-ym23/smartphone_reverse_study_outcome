package hs4;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.filter.view.ddui.step.a f486965a;

    public a(Context r100, com.bytedance.ee.bear.bitable.filter.view.ddui.step.a r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        this.f486965a = r101;
    }

    public final void c(String r100, Object r101) {
        JSONObject r102 = new JSONObject();
        r102.put2("text", r101);
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("options", r102);
        com.bytedance.ee.bear.bitable.filter.view.ddui.step.a r104 = this.f486965a;
        if (r104 == null) goto L6;
        r104.Gs(r100, r103);
        return;
    }
}
