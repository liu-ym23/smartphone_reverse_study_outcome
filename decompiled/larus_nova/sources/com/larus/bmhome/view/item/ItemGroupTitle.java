package com.larus.bmhome.view.item;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/view/item/ItemGroupTitle;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemGroupTitle extends AppCompatTextView {
    public ItemGroupTitle(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        setTextSize(13.0f);
        setTextColor(ContextCompat.getColor(getContext(), c.b(R.attr.larus_neutral_70, getContext(), R.color.larus_neutral_70)));
        int r101 = i5.q();
        int r102 = i5.h();
        int r103 = i5.h();
        int r104 = getPaddingEnd();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + getClass().getSimpleName() + ",source:,start:" + r101 + ",top:" + r102 + ",end:" + r104 + ",bottom:" + r103);
        setPaddingRelative(r101, r102, r104, r103);
    }

    public ItemGroupTitle(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        setTextSize(13.0f);
        setTextColor(ContextCompat.getColor(getContext(), c.b(R.attr.larus_neutral_70, getContext(), R.color.larus_neutral_70)));
        int r102 = i5.q();
        int r103 = i5.h();
        int r104 = i5.h();
        int r105 = getPaddingEnd();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + getClass().getSimpleName() + ",source:,start:" + r102 + ",top:" + r103 + ",end:" + r105 + ",bottom:" + r104);
        setPaddingRelative(r102, r103, r105, r104);
    }

    public ItemGroupTitle(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        setTextSize(13.0f);
        setTextColor(ContextCompat.getColor(getContext(), c.b(R.attr.larus_neutral_70, getContext(), R.color.larus_neutral_70)));
        int r103 = i5.q();
        int r104 = i5.h();
        int r105 = i5.h();
        int r106 = getPaddingEnd();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + getClass().getSimpleName() + ",source:,start:" + r103 + ",top:" + r104 + ",end:" + r106 + ",bottom:" + r105);
        setPaddingRelative(r103, r104, r106, r105);
    }
}
