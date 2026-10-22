package com.ss.android.lark.search.ui.result.view.foldtag;

import android.content.Context;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y9c.d;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/search/ui/result/view/foldtag/DefaultFoldView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/ss/android/lark/search/ui/result/view/foldtag/IFoldView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "changeFoldState", "", "isFold", "", "asView", "Landroid/view/View;", "search-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultFoldView extends AppCompatImageView {
    public DefaultFoldView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        setBackgroundResource(R.drawable.search_recommend_tag_item_bg);
        setPadding(d.a(8), d.a(7), d.a(8), d.a(7));
    }
}
