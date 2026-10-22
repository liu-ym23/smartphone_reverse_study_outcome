package com.bytedance.awemeopen.apps.framework.comment.view;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u0007"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/view/CommentRelatedView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "content", "", "update", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CommentRelatedView extends AppCompatTextView {
    public String a;
    public int b;
    public int c;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onPreDraw() {
        x(false);
        return super/*android.widget.TextView*/.onPreDraw();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void update(String r2) {
        this.a = r2;
        if (r2 == null) goto L5;
        setText(r2);
        setContentDescription(r2);
    L5:
        x(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x(boolean r3) {
        int r0 = this.c;
        if (r0 > 0) goto L5;
        return;
    L5:
        if (r0 != this.b) goto L8;
        if (r3 == true) goto L8;
        return;
    L8:
        setMaxLines(1);
        setSingleLine();
        getContext();
        throw null;
    }

    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        this.c = View.MeasureSpec.getSize(r1);
    }
}
