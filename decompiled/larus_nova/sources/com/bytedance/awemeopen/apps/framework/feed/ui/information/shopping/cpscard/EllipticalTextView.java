package com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.cpscard;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/information/shopping/cpscard/EllipticalTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "ellipticalWidth", "", "setEllipticalWidth", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class EllipticalTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f196471b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f196472a;

    public EllipticalTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100);
    }

    public final void setEllipticalWidth(int r100) {
        this.f196472a = r100;
        requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [T, java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r4v2, types: [T, java.lang.String] */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        float r102 = getPaint().measureText(getText().toString());
        int r103 = this.f196472a;
        if (r103 != 0) goto L5;
        r103 = (View.MeasureSpec.getSize(r100) - getPaddingLeft()) - getPaddingRight();
    L5:
        final Ref.ObjectRef r104 = new Ref.ObjectRef();
        r104.element = getText();
        float r105 = r103;
        if (r102 <= r105) goto L19;
        int r106 = getText().length();
    L9:
        if ((-1) >= r106) goto L15;
        ?? r107 = getText().subSequence(0, r106).toString() + "...";
        if (getPaint().measureText(r107) < r105) goto L12;
        r106 = r106 - 1;
        goto L9
    L12:
        r104.element = r107;
    L15:
        if (Intrinsics.areEqual(r104.element, getText()) == false) goto L17;
    L18:
        r104.element = "";
        goto L19
    L17:
        if (Intrinsics.areEqual(r104.element, "...") == true) goto L18;
    L19:
        post(new n(this, r104));
        super.onMeasure(r100, r101);
    }
}
