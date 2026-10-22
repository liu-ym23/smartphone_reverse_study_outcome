package com.bytedance.awemeopen.apps.framework.comment.view.diggbury.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.awemeopen.apps.framework.comment.view.a;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000f"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/view/diggbury/view/BuryView2;", "Lcom/bytedance/awemeopen/apps/framework/comment/view/diggbury/view/BaseDiggBuryFrameLayout;", "", "getRootViewId", "()I", "rootViewId", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class BuryView2 extends BaseDiggBuryFrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f194264f = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f194265d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f194266e;

    @Override // com.bytedance.awemeopen.apps.framework.comment.view.diggbury.view.BaseDiggBuryFrameLayout
    public int getRootViewId() {
        return R.layout.aweme_comment_bury_v2;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.view.diggbury.view.BaseDiggBuryFrameLayout
    public final void a() {
        super.a();
        this.f194265d = findViewById(R.id.bury_container);
        ImageView r100 = (ImageView) findViewById(R.id.bury_icon);
        this.f194266e = r100;
        if (r100 == null) goto L5;
        r100.setImageDrawable(a.a(false, getColorMode(), getContext()));
    L5:
        int r101 = x54.a.a(18);
        ImageView r102 = this.f194266e;
        ViewGroup.LayoutParams r103 = null;
        if (r102 == null) goto L8;
        ViewGroup.LayoutParams r104 = r102.getLayoutParams();
    L9:
        if (r104 == null) goto L12;
        r104.width = r101;
    L12:
        ImageView r105 = this.f194266e;
        if (r105 == null) goto L15;
        r103 = r105.getLayoutParams();
    L15:
        if (r103 == null) goto L19;
        r103.height = r101;
        return;
    L19:
        return;
    L8:
        r104 = null;
        goto L9
    }

    public BuryView2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public BuryView2(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public BuryView2(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
    }

    public final void b(boolean r100, boolean r101, long r102) {
        if (this.f194266e == null) goto L24;
        Context r103 = getContext();
        if (this.f194263c == r100) goto L10;
        ImageView r104 = this.f194266e;
        if (r104 == null) goto L10;
        r104.setImageDrawable(a.a(r100, getColorMode(), r103));
    L10:
        ImageView r105 = this.f194266e;
        if (r105 == null) goto L14;
        r105.setSelected(r100);
    L14:
        ImageView r106 = this.f194266e;
        if (r106 == null) goto L18;
        r106.setVisibility(0);
    L18:
        if (r101 == false) goto L22;
        final ImageView r107 = this.f194266e;
        if (r107 == null) goto L22;
        r107.animate().scaleX(0.8f).scaleY(0.8f).setDuration(80).withEndAction(new ry3.a(r107)).start();
    L22:
        setActive(r100);
        return;
    }
}
