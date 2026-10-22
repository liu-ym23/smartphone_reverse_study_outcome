package es4;

import com.bytedance.ee.bear.bitable.fieldedit.model.FieldQueryOptionsModel;
import com.bytedance.ee.bear.bitable.fieldedit.view.edit.link.LinkFieldPropertyEditViewHolder;
import com.bytedance.ee.bear.bitable.filter.model.FilterInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements Function1<FilterInfo, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkFieldPropertyEditViewHolder f473771a;

    public c(LinkFieldPropertyEditViewHolder r100) {
        this.f473771a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(FilterInfo r100) {
        FieldQueryOptionsModel r101 = this.f473771a.f211451m;
        r101.setFilterInfo(r100);
        this.f473771a.C();
        return Unit.INSTANCE;
    }
}
