package com.larus.chat.search.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBindings;
import com.larus.chat.search.common.databinding.LarusItemSearchHistoryBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import jz8.a;
import jz8.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/chat/search/common/view/SearchHistoryItemView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/chat/search/common/databinding/LarusItemSearchHistoryBinding;", "removeClickListener", "Landroid/view/View$OnClickListener;", "itemClickListener", "initAction", "", "initView", "bindText", "text", "", "setOnRemoveClickListener", "listener", "setOnItemClickListener", "common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchHistoryItemView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LarusItemSearchHistoryBinding f325450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View.OnClickListener f325451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View.OnClickListener f325452c;

    public SearchHistoryItemView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        LarusItemSearchHistoryBinding r101 = this.f325450a;
        if (r101 == null) goto L8;
        TextView r102 = r101.f325449c;
        if (r102 == null) goto L9;
        r102.setText(r100);
        return;
    L9:
        return;
    }

    public final void setOnItemClickListener(View.OnClickListener r100) {
        this.f325452c = r100;
    }

    public final void setOnRemoveClickListener(View.OnClickListener r100) {
        this.f325451b = r100;
    }

    public SearchHistoryItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LinearLayout.inflate(getContext(), R.layout.larus_item_search_history, this);
        int r102 = R.id.icon_delete;
        AppCompatImageView r103 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.icon_delete);
        if (r103 == null) goto L13;
        r102 = R.id.text;
        TextView r104 = (TextView) ViewBindings.findChildViewById(this, R.id.text);
        if (r104 == null) goto L13;
        this.f325450a = new LarusItemSearchHistoryBinding(this, r103, r104);
        setOnClickListener(new a(this));
        LarusItemSearchHistoryBinding r105 = this.f325450a;
        if (r105 == null) goto L14;
        AppCompatImageView r106 = r105.f325448b;
        if (r106 == null) goto L15;
        r106.setOnClickListener(new b(this));
        return;
    L15:
        return;
    L14:
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    }
}
