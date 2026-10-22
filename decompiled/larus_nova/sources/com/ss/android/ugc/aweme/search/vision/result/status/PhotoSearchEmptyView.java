package com.ss.android.ugc.aweme.search.vision.result.status;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.ies.dmt.ui.widget.DmtTextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/result/status/PhotoSearchEmptyView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PhotoSearchEmptyView extends LinearLayout {
    public PhotoSearchEmptyView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        LayoutInflater.from(getContext()).inflate(R.layout.search_photo_layout_default_with_pic, this, true);
        ImageView r101 = (ImageView) findViewById(R.id.iv_empty);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        if (r101 == null) goto L6;
        r101.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.photo_search_empty));     // Catch: Throwable -> L9
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L9
    L11:
        DmtTextView r104 = (DmtTextView) findViewById(R.id.tv_title);
        if (r104 == null) goto L14;
        r104.setText(R.string.search_commodity_photo_search_empty_title);
    L14:
        DmtTextView r105 = (DmtTextView) findViewById(R.id.tv_desc);
        if (r105 == null) goto L20;
        r105.setText(R.string.search_commodity_photo_search_empty_desc);
        return;
    L20:
        return;
    L6:
        r103 = null;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
