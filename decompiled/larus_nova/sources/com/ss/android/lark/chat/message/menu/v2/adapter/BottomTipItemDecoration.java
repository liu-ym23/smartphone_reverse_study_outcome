package com.ss.android.lark.chat.message.menu.v2.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0001!B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J \u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\t2\u0006\u0010 \u001a\u00020\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/adapter/BottomTipItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "itemCount", "", "<init>", "(Landroid/content/Context;I)V", "tipLayout", "Landroid/text/Layout;", "topMargin", "leftDrawable", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "rightDrawable", "drawableWidth", "drawableHeight", "drawableHorizontalMargin", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDrawOver", "canvas", "Landroid/graphics/Canvas;", "getTipLayout", "parentWidth", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BottomTipItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f415671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f415672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Layout f415673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f415674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Drawable f415675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Drawable f415676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f415677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f415678h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f415679i;

    public static final class a {
    }

    static {
    }

    public final Layout h(int r100) {
        Layout r101 = this.f415673c;
        if (r101 == null) goto L5;
        return r101;
    L5:
        int r102 = UIUtils.getColor(this.f415671a, R.color.text_placeholder);
        String r103 = UIUtils.getString(this.f415671a, R.string.Lark_IM_MessageActionListEnd_Text);
        float r104 = UIUtils.sp2px(this.f415671a, 14.0f);
        int r105 = (r100 - (this.f415677g * 2)) - (this.f415679i * 2);
        TextLayoutBuilder r106 = new TextLayoutBuilder();
        r106.h(r103);
        r106.i(r102);
        r106.j((int) r104);
        r106.c(Layout.Alignment.ALIGN_CENTER);
        r106.f(r105);
        Layout r107 = r106.a();
        this.f415673c = r107;
        return r107;
    }

    public BottomTipItemDecoration(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f415671a = r100;
        this.f415672b = r101;
        this.f415674d = UIUtils.dp2px(r100, 32.0f);
        this.f415675e = UIUtils.getDrawable(r100, R.drawable.bg_no_more_left_divider);
        this.f415676f = UIUtils.getDrawable(r100, R.drawable.bg_no_more_right_divider);
        this.f415677g = UIUtils.dp2px(r100, 40.0f);
        this.f415678h = UIUtils.dp2px(r100, 1.0f);
        this.f415679i = UIUtils.dp2px(r100, 20.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas r100, RecyclerView r101, RecyclerView.State r110) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r110, "state");
        View r102 = r101.getChildAt(r101.getChildCount() - 1);
        if (r102 != null) goto L6;
        super.onDrawOver(r100, r101, r110);
        return;
    L6:
        Layout r103 = h(r101.getMeasuredWidth());
        if (r103 != null) goto L10;
        super.onDrawOver(r100, r101, r110);
        return;
    L10:
        r100.save();
        r100.translate(0.0f, r102.getBottom() + this.f415674d);
        int r104 = r101.getMeasuredWidth();
        int r111 = r103.getWidth();
        int r105 = r103.getHeight();
        int r106 = (r104 - r111) / 2;
        int r107 = this.f415678h;
        int r108 = (r105 - r107) / 2;
        int r109 = r106 - this.f415679i;
        int r112 = this.f415677g;
        int r113 = r109 - r112;
        this.f415675e.setBounds(r113, r108, r112 + r113, r107 + r108);
        this.f415675e.draw(r100);
        int r114 = (r111 + r106) + this.f415679i;
        this.f415676f.setBounds(r114, r108, this.f415677g + r114, this.f415678h + r108);
        this.f415676f.draw(r100);
        r100.translate(r106, 0.0f);
        r103.draw(r100);
        r100.restore();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        if (r102.getChildAdapterPosition(r101) >= (this.f415672b - 1)) goto L6;
        super.getItemOffsets(r100, r101, r102, r103);
        return;
    L6:
        Layout r104 = h(r102.getMeasuredWidth());
        if (r104 != null) goto L10;
        super.getItemOffsets(r100, r101, r102, r103);
        return;
    L10:
        r100.bottom = this.f415674d + r104.getHeight();
    }
}
