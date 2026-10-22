package com.ss.android.lark.thirdshare.panel.content;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001,B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fB+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\u000eJ\u0016\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H\u0016J\u0018\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000bH\u0014R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00108FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00168FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010(\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/ss/android/lark/thirdshare/panel/content/DoubleLineShareView;", "Landroid/widget/FrameLayout;", "Lcom/ss/android/lark/thirdshare/panel/content/ShareView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "sharePagerFromXml", "Landroidx/viewpager2/widget/ViewPager2;", "getSharePagerFromXml", "()Landroidx/viewpager2/widget/ViewPager2;", "setSharePagerFromXml", "(Landroidx/viewpager2/widget/ViewPager2;)V", "sharePagerIndicatorFromXml", "Lcom/ss/android/lark/thirdshare/panel/content/PagerIndicator;", "getSharePagerIndicatorFromXml", "()Lcom/ss/android/lark/thirdshare/panel/content/PagerIndicator;", "setSharePagerIndicatorFromXml", "(Lcom/ss/android/lark/thirdshare/panel/content/PagerIndicator;)V", "adapter", "Lcom/ss/android/lark/thirdshare/panel/content/DoubleLineShareViewAdapter;", "onPageChangeListener", "Lcom/ss/android/lark/thirdshare/panel/content/DoubleLineShareView$OnPageChangeListener;", "getOnPageChangeListener", "()Lcom/ss/android/lark/thirdshare/panel/content/DoubleLineShareView$OnPageChangeListener;", "setOnPageChangeListener", "(Lcom/ss/android/lark/thirdshare/panel/content/DoubleLineShareView$OnPageChangeListener;)V", "setShareItems", "", "items", "", "Lcom/ss/android/lark/thirdshare/panel/content/ShareItemContent;", "lastMeasureWidth", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "OnPageChangeListener", "third-share-panel_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubleLineShareView extends FrameLayout implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewPager2 f441251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PagerIndicator f441252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DoubleLineShareViewAdapter f441253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f441254d;

    public interface a {
        void a();
    }

    public final a getOnPageChangeListener() {
        return null;
    }

    public final void setOnPageChangeListener(a r100) {
    }

    public final ViewPager2 getSharePagerFromXml() {
        KeyEvent.Callback r100 = this.f441251a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.share_pager);
        this.f441251a = (ViewPager2) r100;
    L6:
        return (ViewPager2) r100;
    }

    public final PagerIndicator getSharePagerIndicatorFromXml() {
        KeyEvent.Callback r100 = this.f441252b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.share_pager_indicator);
        this.f441252b = (PagerIndicator) r100;
    L6:
        return (PagerIndicator) r100;
    }

    public DoubleLineShareView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        DoubleLineShareViewAdapter r101 = new DoubleLineShareViewAdapter();
        this.f441253c = r101;
        LayoutInflater.from(getContext()).inflate(R.layout.view_double_line_share, this, true);
        c.R1.getClass();
        int r102 = (int) c.a.f441291d.toPixels(getContext());
        ViewPager2 r103 = getSharePagerFromXml();
        r103.setPadding(r102, 0, r102, 0);
        r103.setAdapter(r101);
        View r104 = r103.getChildAt(0);
        if (r104 != null) goto L5;
    L11:
        r101.registerAdapterDataObserver(new AnonymousClass2(this));
        getSharePagerFromXml().registerOnPageChangeCallback(new AnonymousClass3(this));
        return;
    L5:
        if ((r104 instanceof RecyclerView) == false) goto L7;
        RecyclerView r105 = (RecyclerView) r104;
    L8:
        if (r105 == null) goto L11;
        r105.setOverScrollMode(2);
        goto L11
    L7:
        r105 = null;
        goto L8
    }

    public void setShareItems(List<com.ss.android.lark.thirdshare.panel.content.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        ((ArrayList) this.f441253c.f441257a).clear();
        ArrayList r101 = (ArrayList) this.f441253c.f441257a;
        r101.addAll(r100);
        this.f441253c.notifyDataSetChanged();
    }

    public final void setSharePagerFromXml(ViewPager2 r100) {
        this.f441251a = r100;
    }

    public final void setSharePagerIndicatorFromXml(PagerIndicator r100) {
        this.f441252b = r100;
    }

    public DoubleLineShareView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        DoubleLineShareViewAdapter r102 = new DoubleLineShareViewAdapter();
        this.f441253c = r102;
        LayoutInflater.from(getContext()).inflate(R.layout.view_double_line_share, this, true);
        c.R1.getClass();
        int r103 = (int) c.a.f441291d.toPixels(getContext());
        ViewPager2 r104 = getSharePagerFromXml();
        r104.setPadding(r103, 0, r103, 0);
        r104.setAdapter(r102);
        View r105 = r104.getChildAt(0);
        if (r105 != null) goto L5;
    L11:
        r102.registerAdapterDataObserver(new AnonymousClass2(this));
        getSharePagerFromXml().registerOnPageChangeCallback(new AnonymousClass3(this));
        return;
    L5:
        if ((r105 instanceof RecyclerView) == false) goto L7;
        RecyclerView r106 = (RecyclerView) r105;
    L8:
        if (r106 == null) goto L11;
        r106.setOverScrollMode(2);
        goto L11
    L7:
        r106 = null;
        goto L8
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        c.R1.getClass();
        float r102 = c.a.f441289b.toPixels(getContext());
        int r103 = (int) Math.floor((((getMeasuredWidth() - getSharePagerFromXml().getPaddingLeft()) - getSharePagerFromXml().getPaddingRight()) + r102) / (((int) ShareItemView.f441274c.toPixels(getContext())) + r102));
        boolean r104 = true;
        int r105 = Math.max(r103, 1);
        DoubleLineShareViewAdapter r106 = this.f441253c;
        if (r106.f441258b != r105) goto L5;
    L16:
        int r107 = this.f441254d;
        if (r107 != 0) goto L19;
    L21:
        this.f441254d = getMeasuredWidth();
        return;
    L19:
        if (r107 == getMeasuredWidth()) goto L21;
        this.f441253c.notifyDataSetChanged();
        goto L21
    L5:
        if (((float) Math.ceil(((ArrayList) r106.f441257a).size() / r105)) == ((float) Math.ceil(((ArrayList) this.f441253c.f441257a).size() / this.f441253c.f441258b))) goto L8;
        r104 = false;
    L8:
        if (r104 == true) goto L13;
        DoubleLineShareViewAdapter r108 = this.f441253c;
        if (r108.f441258b == r105) goto L12;
        r108.f441258b = r105;
        r108.notifyDataSetChanged();
    L12:
        super.onMeasure(r100, r101);
        goto L16
    L13:
        DoubleLineShareViewAdapter r109 = this.f441253c;
        if (r109.f441258b == r105) goto L16;
        r109.f441258b = r105;
        r109.notifyDataSetChanged();
        goto L16
    }

    public DoubleLineShareView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        DoubleLineShareViewAdapter r103 = new DoubleLineShareViewAdapter();
        this.f441253c = r103;
        LayoutInflater.from(getContext()).inflate(R.layout.view_double_line_share, this, true);
        c.R1.getClass();
        int r104 = (int) c.a.f441291d.toPixels(getContext());
        ViewPager2 r105 = getSharePagerFromXml();
        r105.setPadding(r104, 0, r104, 0);
        r105.setAdapter(r103);
        View r106 = r105.getChildAt(0);
        if (r106 != null) goto L5;
    L11:
        r103.registerAdapterDataObserver(new AnonymousClass2(this));
        getSharePagerFromXml().registerOnPageChangeCallback(new AnonymousClass3(this));
        return;
    L5:
        if ((r106 instanceof RecyclerView) == false) goto L7;
        RecyclerView r107 = (RecyclerView) r106;
    L8:
        if (r107 == null) goto L11;
        r107.setOverScrollMode(2);
        goto L11
    L7:
        r107 = null;
        goto L8
    }
}
