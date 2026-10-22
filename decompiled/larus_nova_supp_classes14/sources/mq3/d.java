package mq3;

import com.bytedance.android.ec.window.base.utils.g;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements c {
    public Long a;
    public Integer b;
    public String c;
    public String d;
    public String e;
    public String f;

    @Override // mq3.c
    public final String getClickedProducts() {
        List r0 = g.a;
        return CollectionsKt.joinToString$default(g.b, ",", null, null, 0, null, null, 62, null);
    }

    public d() {
        this.c = "";
    }

    @Override // mq3.c
    public final String getChildCategory() {
        return this.f;
    }

    @Override // mq3.c
    public final Integer getSort() {
        return this.b;
    }

    @Override // mq3.c
    public final Long getSortType() {
        return this.a;
    }

    @Override // mq3.c
    public final String getTargetCategory() {
        return this.d;
    }

    @Override // mq3.c
    public final String getTargetFilterType() {
        return this.c;
    }

    @Override // mq3.c
    public final String getTargetSubCategory() {
        return this.e;
    }
}
