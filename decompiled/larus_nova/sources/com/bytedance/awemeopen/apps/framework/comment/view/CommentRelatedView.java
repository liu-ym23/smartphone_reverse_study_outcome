package com.bytedance.awemeopen.apps.framework.comment.view;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u0007"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/view/CommentRelatedView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "content", "", "update", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CommentRelatedView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f194191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f194192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f194193c;

    public static final class a {
    }

    static {
    }

    @Override // android.widget.TextView, android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        x(false);
        return super.onPreDraw();
    }

    public final void update(String r100) {
        this.f194191a = r100;
        if (r100 == null) goto L5;
        setText(r100);
        setContentDescription(r100);
    L5:
        x(true);
    }

    public final void x(boolean r100) {
        int r101 = this.f194193c;
        if (r101 > 0) goto L5;
        return;
    L5:
        if (r101 != this.f194192b) goto L8;
        if (r100 == true) goto L8;
        return;
    L8:
        setMaxLines(1);
        setSingleLine();
        getContext();
        throw null;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        this.f194193c = View.MeasureSpec.getSize(r100);
    }
}
