package com.larksuite.component.universe_design.tab;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0000X\u0081\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/larksuite/component/universe_design/tab/UDTabItem;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "title", "", "getTitle$universe_ui_tab_release", "()Ljava/lang/CharSequence;", "icon", "Landroid/graphics/drawable/Drawable;", "getIcon$universe_ui_tab_release", "()Landroid/graphics/drawable/Drawable;", "customView", "", "getCustomView$universe_ui_tab_release", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "universe-ui-tab_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UDTabItem extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f285257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f285258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f285259c;

    public final Integer getCustomView$universe_ui_tab_release() {
        return this.f285259c;
    }

    public final Drawable getIcon$universe_ui_tab_release() {
        return this.f285258b;
    }

    public final CharSequence getTitle$universe_ui_tab_release() {
        return this.f285257a;
    }

    public UDTabItem(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public UDTabItem(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.icon, R.attr.layout, R.attr.text});
        this.f285257a = r102.getText(2);
        this.f285258b = r102.getDrawable(0);
        this.f285259c = Integer.valueOf(r102.getResourceId(1, 0));
        r102.recycle();
    }
}
