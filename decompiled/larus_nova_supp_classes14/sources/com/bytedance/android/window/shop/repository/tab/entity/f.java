package com.bytedance.android.window.shop.repository.tab.entity;

import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.dto.b1;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class f implements QModel {
    public v a;
    public Integer b;
    public String c;
    public Map<String, ? extends Map<String, String>> d;
    public CardPosition e;
    public final fo.b f;
    public b1 g;
    public com.bytedance.android.ec.hybrid.list.entity.j h;
    public final int i;

    public String b() {
        return null;
    }

    public WindowV2ProductItemVO c() {
        return null;
    }

    public void d() {
    }

    public final int modelType() {
        return this.i;
    }

    public f(int r1) {
        this.i = r1;
        this.e = CardPosition.NORMAL;
        this.f = new fo.b();
    }
}
