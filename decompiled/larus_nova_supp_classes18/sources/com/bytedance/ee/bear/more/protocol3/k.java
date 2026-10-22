package com.bytedance.ee.bear.more.protocol3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.more.protocol3.panel.ItemUIStyle;
import com.bytedance.ee.bear.more.protocol3.panel.h0;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class k {
    public final String a;
    public k b;
    public h0 c;
    public ItemUIStyle d;

    public i d() {
        return null;
    }

    public abstract int e();

    public boolean f(k r1) {
        return false;
    }

    public k(String r2) {
        this.d = ItemUIStyle.FEISHU;
        this.a = r2;
    }

    public void a(View r2) {
        tt5.a.h("UIMoreItem", "UIMoreItem.bind. id=" + this.a);
    }

    public View c(ViewGroup r4) {
        return LayoutInflater.from(r4.getContext()).inflate(e(), r4, false);
    }

    public void b(View r1, List<Object> r2) {
        a(r1);
    }
}
