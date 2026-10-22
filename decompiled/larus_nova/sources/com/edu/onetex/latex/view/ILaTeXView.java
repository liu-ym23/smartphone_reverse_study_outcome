package com.edu.onetex.latex.view;

import android.content.Context;
import android.view.View;
import com.edu.onetex.latex.graphic.Graphics2D;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0007H&J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0007H&¨\u0006\u0011"}, d2 = {"Lcom/edu/onetex/latex/view/ILaTeXView;", "", "getAndroidView", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getViewHeight", "", "getViewWidth", "paintAndroidView", "", "graphics2D", "Lcom/edu/onetex/latex/graphic/Graphics2D;", "setX", "x", "setY", "y", "onetex_release"}, k = 1, mv = {1, 4, 2})
public interface ILaTeXView {
    View getAndroidView(Context r100);

    double getViewHeight();

    double getViewWidth();

    void paintAndroidView(Graphics2D r100);

    void setX(double r100);

    void setY(double r100);
}
