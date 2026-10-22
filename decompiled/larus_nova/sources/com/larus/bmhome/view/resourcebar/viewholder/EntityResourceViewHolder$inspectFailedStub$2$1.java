package com.larus.bmhome.view.resourcebar.viewholder;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBindings;
import com.larus.chat.common.databinding.LarusFileResourceInspectFailedLayoutBinding;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class EntityResourceViewHolder$inspectFailedStub$2$1 extends FunctionReferenceImpl implements Function1<View, LarusFileResourceInspectFailedLayoutBinding> {
    public static final EntityResourceViewHolder$inspectFailedStub$2$1 INSTANCE = null;

    static {
        INSTANCE = new EntityResourceViewHolder$inspectFailedStub$2$1();
    }

    public EntityResourceViewHolder$inspectFailedStub$2$1() {
        super(1, LarusFileResourceInspectFailedLayoutBinding.class, "bind", "bind(Landroid/view/View;)Lcom/larus/chat/common/databinding/LarusFileResourceInspectFailedLayoutBinding;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final LarusFileResourceInspectFailedLayoutBinding invoke2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        FrameLayout r101 = (FrameLayout) r100;
        AppCompatTextView r102 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.file_resource_inspect_failed_txt);
        if (r102 == null) goto L7;
        return new LarusFileResourceInspectFailedLayoutBinding(r101, r101, r102);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(R.id.file_resource_inspect_failed_txt)));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ LarusFileResourceInspectFailedLayoutBinding invoke(View r100) {
        return invoke2(r100);
    }
}
