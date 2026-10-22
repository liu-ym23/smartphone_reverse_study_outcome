package com.bytedance.ies.bullet.ui.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/view/BulletTitleBar;", "Landroid/widget/FrameLayout;", "", "title", "", "setTitleIfMissing", "Landroid/view/View$OnClickListener;", "click", "setBackListener", "setCloseAllListener", "Landroid/view/View;", "b", "Landroid/view/View;", "getTitleBarRootView", "()Landroid/view/View;", "setTitleBarRootView", "(Landroid/view/View;)V", "titleBarRootView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public class BulletTitleBar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f248275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f248276b;

    public BulletTitleBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BulletTitleBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final View getTitleBarRootView() {
        return this.f248276b;
    }

    public final View a(int r100) {
        if (this.f248275a != null) goto L5;
        this.f248275a = new LinkedHashMap();
    L5:
        View r101 = this.f248275a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        Integer r103 = Integer.valueOf(r100);
        this.f248275a.put(r103, r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void setBackListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "click");
        ((AutoRTLImageView) a(R.id.iv_back)).setOnClickListener(r100);
    }

    public final void setCloseAllListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "click");
        ((AutoRTLImageView) a(R.id.iv_close_all)).setOnClickListener(r100);
    }

    public final void setTitleBarRootView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f248276b = r100;
    }

    public final void setTitleIfMissing(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        if (((TextView) a(R.id.tv_title)).getText().length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        ((TextView) a(R.id.tv_title)).setText(r100);
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public BulletTitleBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f248275a = new LinkedHashMap();
        this.f248276b = LayoutInflater.from(r100).inflate(R.layout.bullet_title_bar, this, true);
    }

    public /* synthetic */ BulletTitleBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
