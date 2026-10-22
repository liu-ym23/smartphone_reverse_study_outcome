package s53;

import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.anchorv3.comment.sku.viewmodel.CommentSkuViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CommentSkuViewModel f540711f;

    public c(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
    }

    public static final /* synthetic */ CommentSkuViewModel d0(c r100) {
        CommentSkuViewModel r101 = r100.f540711f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r101;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        this.f540711f = (CommentSkuViewModel) Y().g(CommentSkuViewModel.class);
        Z().b(R.id.sku_reset).f().setOnClickListener(new a(this));
        Z().b(R.id.sku_confirm).f().setOnClickListener(new b(this));
    }
}
