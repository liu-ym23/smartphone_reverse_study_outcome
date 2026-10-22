package com.ss.android.lark.widget.table.newrefactor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tec.g;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\u0012\u001a\u00020\u000fH\u0002J\u0006\u0010\u0013\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u000fR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/widget/table/newrefactor/TableViewNew;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "tableDataView", "Landroid/widget/GridLayout;", "tableDataAdapter", "Lcom/ss/android/lark/widget/table/newrefactor/TableDataAdapter;", "scrollView", "Landroid/widget/ScrollView;", "setTableAdapter", "", "tableWidth", "", "setupTableDataView", "forceRefresh", "refresh", "Companion", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TableViewNew extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GridLayout f448908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f448909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScrollView f448910c;

    public static final class a {
    }

    static {
    }

    public TableViewNew(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        ScrollView r102 = new ScrollView(r100);
        this.f448910c = r102;
        setOrientation(1);
        this.f448908a = new GridLayout(r100);
        ViewGroup.LayoutParams r103 = new ViewGroup.LayoutParams(-1, -1);
        r102.setId(R.id.table_detail_vertical_scroll_view);
        r102.setLayoutParams(r103);
        r102.setVerticalScrollBarEnabled(false);
        addView(r102);
    }
}
