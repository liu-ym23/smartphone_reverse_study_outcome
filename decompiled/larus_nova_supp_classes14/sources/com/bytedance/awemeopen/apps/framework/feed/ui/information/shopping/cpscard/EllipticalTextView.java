package com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.cpscard;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/information/shopping/cpscard/EllipticalTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "ellipticalWidth", "", "setEllipticalWidth", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class EllipticalTextView extends AppCompatTextView {
    public static final /* synthetic */ int b = 0;
    public int a;

    public EllipticalTextView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setEllipticalWidth(int r1) {
        this.a = r1;
        requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r8, int r9) {
        float r0 = getPaint().measureText(getText().toString());
        int r1 = this.a;
        if (r1 != 0) goto L5;
        r1 = (View.MeasureSpec.getSize(r8) - getPaddingLeft()) - getPaddingRight();
    L5:
        final Ref.ObjectRef r2 = new Ref.ObjectRef();
        r2.element = getText();
        float r3 = r1;
        if (r0 <= r3) goto L19;
        int r4 = getText().length();
    L9:
        if ((-1) >= r4) goto L15;
        String r5 = getText().subSequence(0, r4).toString() + "...";
        if (getPaint().measureText(r5) < r3) goto L12;
        r4 = r4 - 1;
        goto L9
    L12:
        r2.element = r5;
    L15:
        if (Intrinsics.areEqual(r2.element, getText()) == false) goto L17;
    L18:
        r2.element = "";
        goto L19
    L17:
        if (Intrinsics.areEqual(r2.element, "...") == true) goto L18;
    L19:
        post(new n(this, r2));
        super.onMeasure(r8, r9);
    }
}
