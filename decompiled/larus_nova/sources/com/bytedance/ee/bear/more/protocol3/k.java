package com.bytedance.ee.bear.more.protocol3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.more.protocol3.panel.ItemUIStyle;
import com.bytedance.ee.bear.more.protocol3.panel.h0;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f234901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k f234902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h0 f234903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ItemUIStyle f234904d;

    public i d() {
        return null;
    }

    public abstract int e();

    public boolean f(k r100) {
        return false;
    }

    public k(String r100) {
        this.f234904d = ItemUIStyle.FEISHU;
        this.f234901a = r100;
    }

    public void a(View r100) {
        tt5.a.h("UIMoreItem", "UIMoreItem.bind. id=" + this.f234901a);
    }

    public View c(ViewGroup r100) {
        return LayoutInflater.from(r100.getContext()).inflate(e(), r100, false);
    }

    public void b(View r100, List<Object> r101) {
        a(r100);
    }
}
