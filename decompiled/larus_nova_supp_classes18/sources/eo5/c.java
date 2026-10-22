package eo5;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.templates.center.TemplateCenterViewModel;
import com.bytedance.ee.bear.templates.search.base.BasePresenter;
import com.bytedance.ee.bear.templates.search.base.BaseView;
import com.bytedance.ee.bear.templates.search.base.e;
import com.bytedance.ee.bear.templates.search.base.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends BasePresenter {
    public final Fragment l;
    public final a m;
    public final BaseView n;

    @Override // com.bytedance.ee.bear.templates.search.base.BasePresenter
    public final void create() {
        super.create();
        ((TemplateCenterViewModel) this.i.getValue()).getDeleteToken().observe(this.l, new b(this));
    }

    @Override // com.bytedance.ee.bear.templates.search.base.BasePresenter
    public final Fragment H8() {
        return this.l;
    }

    @Override // com.bytedance.ee.bear.templates.search.base.BasePresenter
    public final e I8() {
        return this.m;
    }

    @Override // com.bytedance.ee.bear.templates.search.base.BasePresenter
    public final f J8() {
        return this.n;
    }

    public c(Fragment r2, a r3, BaseView r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "model");
        Intrinsics.checkNotNullParameter(r4, "view");
        super(r2, r3, r4);
        this.l = r2;
        this.m = r3;
        this.n = r4;
    }
}
