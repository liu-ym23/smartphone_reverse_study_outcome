package com.bytedance.ee.bear.widgets.universedesign;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/widgets/universedesign/SimpleTagTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mTagsDrawable", "Lcom/larksuite/component/universe_design/tag/UDTagsDrawable;", "text", "", "init", "", "setText", "colorSet", "Lcom/larksuite/component/universe_design/tag/UDTagsDrawable$TagColorSet;", "onCreateTag", "Lcom/larksuite/component/universe_design/tag/UDTagsDrawable$TagModel;", "updateUDTagsDrawable", "tagModel", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SimpleTagTextView extends AppCompatTextView {
    public String a;

    public SimpleTagTextView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public SimpleTagTextView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 2131953449);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x(String r2, UDTagsDrawable.TagColorSet r3) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "colorSet");
        this.a = r2;
        UDTagsDrawable.d.a r4 = new UDTagsDrawable.d.a(getContext());
        r4.c = this.a;
        r4.c(r3);
        UDTagsDrawable.d r5 = r4.b();
        UDTagsDrawable.a r6 = new UDTagsDrawable.a(getContext());
        r6.a(r5);
        UDTagsDrawable r7 = r6.b();
        if (r7 == null) goto L6;
        r7.d(this);
        return;
    }

    public SimpleTagTextView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        String r7 = "";
        this.a = "";
        if (r5 == null) goto L10;
        TypedArray r8 = r4.obtainStyledAttributes(r5, new int[]{2130974495});
        String r9 = r8.getString(0);
        if (r9 == null) goto L8;
        r7 = r9;
    L8:
        x(r7, UDTagsDrawable.TagColorSet.BLUE);
        r8.recycle();
        return;
    }
}
