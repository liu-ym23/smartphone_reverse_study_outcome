package com.bytedance.ee.bear.widgets.universedesign;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/widgets/universedesign/SimpleTagTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mTagsDrawable", "Lcom/larksuite/component/universe_design/tag/UDTagsDrawable;", "text", "", "init", "", "setText", "colorSet", "Lcom/larksuite/component/universe_design/tag/UDTagsDrawable$TagColorSet;", "onCreateTag", "Lcom/larksuite/component/universe_design/tag/UDTagsDrawable$TagModel;", "updateUDTagsDrawable", "tagModel", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SimpleTagTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f240348a;

    public SimpleTagTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public SimpleTagTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, R.style.SpaceTagTextView);
    }

    public final void x(String r100, UDTagsDrawable.TagColorSet r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "colorSet");
        this.f240348a = r100;
        UDTagsDrawable.d.a r102 = new UDTagsDrawable.d.a(getContext());
        r102.f285353c = this.f240348a;
        r102.c(r101);
        UDTagsDrawable.d r103 = r102.b();
        UDTagsDrawable.a r104 = new UDTagsDrawable.a(getContext());
        r104.a(r103);
        UDTagsDrawable r105 = r104.b();
        if (r105 == null) goto L6;
        r105.d(this);
        return;
    }

    public SimpleTagTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        String r103 = "";
        this.f240348a = "";
        if (r101 == null) goto L10;
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.text});
        String r105 = r104.getString(0);
        if (r105 == null) goto L8;
        r103 = r105;
    L8:
        x(r103, UDTagsDrawable.TagColorSet.BLUE);
        r104.recycle();
        return;
    }
}
