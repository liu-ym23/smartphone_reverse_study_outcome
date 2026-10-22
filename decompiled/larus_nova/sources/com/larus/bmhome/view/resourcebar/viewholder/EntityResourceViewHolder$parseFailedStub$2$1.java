package com.larus.bmhome.view.resourcebar.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBindings;
import com.larus.chat.common.databinding.LarusFileResourceParseFailedLayoutBinding;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class EntityResourceViewHolder$parseFailedStub$2$1 extends FunctionReferenceImpl implements Function1<View, LarusFileResourceParseFailedLayoutBinding> {
    public static final EntityResourceViewHolder$parseFailedStub$2$1 INSTANCE = null;

    static {
        INSTANCE = new EntityResourceViewHolder$parseFailedStub$2$1();
    }

    public EntityResourceViewHolder$parseFailedStub$2$1() {
        super(1, LarusFileResourceParseFailedLayoutBinding.class, "bind", "bind(Landroid/view/View;)Lcom/larus/chat/common/databinding/LarusFileResourceParseFailedLayoutBinding;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final LarusFileResourceParseFailedLayoutBinding invoke2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        LinearLayout r101 = (LinearLayout) r100;
        int r102 = R.id.file_resource_parse_failed_icon;
        AppCompatImageView r103 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.file_resource_parse_failed_icon);
        if (r103 == null) goto L9;
        r102 = R.id.file_resource_parse_failed_txt;
        AppCompatTextView r104 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.file_resource_parse_failed_txt);
        if (r104 == null) goto L9;
        return new LarusFileResourceParseFailedLayoutBinding(r101, r101, r103, r104);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r102)));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ LarusFileResourceParseFailedLayoutBinding invoke(View r100) {
        return invoke2(r100);
    }
}
