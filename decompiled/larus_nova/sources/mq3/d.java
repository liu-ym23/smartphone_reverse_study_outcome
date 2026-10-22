package mq3;

import com.bytedance.android.ec.window.base.utils.g;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f514808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f514809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f514810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f514811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f514812e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f514813f;

    @Override // mq3.c
    public final String getClickedProducts() {
        List<List<String>> r100 = g.f49727a;
        return CollectionsKt.joinToString$default(g.f49728b, ",", null, null, 0, null, null, 62, null);
    }

    public d() {
        this.f514810c = "";
    }

    @Override // mq3.c
    public final String getChildCategory() {
        return this.f514813f;
    }

    @Override // mq3.c
    public final Integer getSort() {
        return this.f514809b;
    }

    @Override // mq3.c
    public final Long getSortType() {
        return this.f514808a;
    }

    @Override // mq3.c
    public final String getTargetCategory() {
        return this.f514811d;
    }

    @Override // mq3.c
    public final String getTargetFilterType() {
        return this.f514810c;
    }

    @Override // mq3.c
    public final String getTargetSubCategory() {
        return this.f514812e;
    }
}
