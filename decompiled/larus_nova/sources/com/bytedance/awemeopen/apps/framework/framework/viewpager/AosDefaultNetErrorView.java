package com.bytedance.awemeopen.apps.framework.framework.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/AosDefaultNetErrorView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public class AosDefaultNetErrorView extends FrameLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f197018d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DmtTextView f197019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DmtTextView f197020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DmtTextView f197021c;

    public final void b() {
        DmtTextView r100 = this.f197019a;
        if (r100 == null) goto L5;
        r100.setTextColor(getResources().getColor(R.color.aos_const_text_inverse2));
    L5:
        DmtTextView r101 = this.f197020b;
        if (r101 == null) goto L8;
        r101.setTextColor(getResources().getColor(R.color.aos_reverse_t_tertiary));
    L8:
        DmtTextView r102 = this.f197021c;
        if (r102 == null) goto L11;
        r102.setBackgroundResource(R.drawable.aos_dark_theme_bg_retry_button);
    L11:
        DmtTextView r103 = this.f197021c;
        if (r103 == null) goto L15;
        r103.setTextColor(getResources().getColor(R.color.aos_const_text_inverse2));
        return;
    }

    public final void c() {
        DmtTextView r100 = this.f197019a;
        if (r100 == null) goto L5;
        r100.setTextColor(getResources().getColor(R.color.aos_text_reverse));
    L5:
        DmtTextView r101 = this.f197020b;
        if (r101 == null) goto L8;
        r101.setTextColor(getResources().getColor(R.color.aos_text_reverse3));
    L8:
        DmtTextView r102 = this.f197021c;
        if (r102 == null) goto L11;
        r102.setBackgroundResource(R.drawable.aos_light_theme_bg_retry_button);
    L11:
        DmtTextView r103 = this.f197021c;
        if (r103 == null) goto L15;
        r103.setTextColor(getResources().getColor(R.color.aos_text_reverse));
        return;
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.aos_view_default_net_error_info, this, true);
        ImageView r100 = (ImageView) findViewById(R.id.image_info);
        this.f197019a = (DmtTextView) findViewById(R.id.title_info);
        this.f197020b = (DmtTextView) findViewById(R.id.content_info);
        this.f197021c = (DmtTextView) findViewById(R.id.retry_btn);
    }

    public AosDefaultNetErrorView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100);
        a();
    }

    public AosDefaultNetErrorView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101);
        a();
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        if (Intrinsics.areEqual(r100, this) == false) goto L9;
        if (r101 != 0) goto L10;
        DmtTextView r102 = this.f197021c;
        if (r102 == null) goto L11;
        r102.post(new a(this));
        return;
    L11:
        return;
    L10:
        return;
    }

    public AosDefaultNetErrorView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
        a();
    }
}
