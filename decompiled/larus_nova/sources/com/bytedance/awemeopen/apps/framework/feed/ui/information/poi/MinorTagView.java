package com.bytedance.awemeopen.apps.framework.feed.ui.information.poi;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.awemeopen.apps.framework.base.view.HollowTextView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.bizmodels.feed.poi.MinorTag;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0010B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/information/poi/MinorTagView;", "Landroid/widget/FrameLayout;", "", "content", "", "setText", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/MinorTag;", "getData", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class MinorTagView extends FrameLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Typeface f196255i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AttributeSet f196256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f196257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MinorTag f196258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f196259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f196260e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextPaint f196261f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f196262g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final r f196263h;

    public static final class a {
    }

    public MinorTagView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MinorTagView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    static {
        f196255i = Typeface.create("sans-serif-medium", 0);
    }

    public final MinorTag getData() {
        return this.f196258c;
    }

    private final void setText(String r100) {
        View r101 = this.f196262g;
        if ((r101 instanceof DmtTextView) == false) goto L6;
        ((DmtTextView) r101).setText(r100);
        return;
    L6:
        if ((r101 instanceof HollowTextView) == false) goto L10;
        ((HollowTextView) r101).setText(r100);
        return;
    }

    public static String b(String r100, boolean r101) {
        if (r101 == true) goto L5;
        return r100;
    L5:
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.f196005q == false) goto L7;
        String r102 = " · ";
    L9:
        return r100 + r102;
    L7:
        r102 = "·";
        goto L9
    }

    public final void c(MinorTag r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f196258c = r100;
        this.f196260e = r101;
        this.f196259d = true;
        removeAllViews();
        Resources r102 = Resources.getSystem();
        int r103 = MathKt.roundToInt(TypedValue.applyDimension(2, 11, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics())));
        float r104 = r103;
        this.f196261f.setTextSize(r104);
        TextPaint r105 = this.f196261f;
        Typeface r106 = f196255i;
        r105.setTypeface(r106);
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.f196005q == false) goto L5;
    L7:
        DmtTextView r107 = new DmtTextView(getContext(), this.f196256a, this.f196257b);
        r107.setEllipsize(TextUtils.TruncateAt.END);
        r107.setSingleLine(true);
        r107.setGravity(16);
        r107.setTypeface(r106);
        r107.setBackgroundColor(0);
        r107.setMaxLines(1);
        r107.setEllipsize(TextUtils.TruncateAt.END);
        r107.setTextSize(0, r104);
        r107.setTextColor(ContextCompat.getColor(r107.getContext(), R.color.aos_uikit_const_ic_inverse3));
        r107.setText(b(r100.f198182a, r101));
        View r108 = r107;
    L8:
        this.f196262g = r108;
        addView(r108, new FrameLayout.LayoutParams(-2, -1));
        return;
    L5:
        if ((r100.f198184c instanceof com.bytedance.awemeopen.bizmodels.feed.poi.b.C2847b) == false) goto L7;
        HollowTextView.a r109 = new HollowTextView.a();
        r109.f193173a = r103;
        r109.f193174b = ContextCompat.getColor(getContext(), R.color.aos_const_text_inverse4);
        float r110 = 2;
        Resources r111 = Resources.getSystem();
        r109.f193175c = MathKt.roundToInt(TypedValue.applyDimension(1, r110, WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics())));
        r109.f193178f = true;
        r109.f193177e = true;
        r109.f193179g = true;
        r109.f193176d = true;
        HollowTextView r112 = new HollowTextView(getContext(), r109);
        Resources r113 = Resources.getSystem();
        int r114 = MathKt.roundToInt(TypedValue.applyDimension(1, r110, WindowDisplayMetricsOverride.apply(r113, r113.getDisplayMetrics())));
        r112.setPadding(r114, r114, r114, r114);
        r112.setText(b(r100.f198182a, r101));
        r108 = r112;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.awemeopen.apps.framework.feed.ui.information.poi.r] */
    public MinorTagView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f196256a = r101;
        this.f196257b = r102;
        this.f196261f = new TextPaint();
        this.f196263h = new r(this);
    }

    public static void a(final MinorTagView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        MinorTag r103 = r100.f196258c;
        if (r103 == null) goto L23;
        int r104 = r102 - r101;
        StringBuffer r105 = new StringBuffer();
        List<Pair<String, Integer>> r106 = r103.f198183b;
        int r107 = r106.size();
        Iterator<T> r108 = r106.iterator();
        int r109 = 0;
    L7:
        if (r108.hasNext() == false) goto L18;
        Object r110 = r108.next();
        int r111 = r109 + 1;
        if (r109 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        Pair r112 = (Pair) r110;
        String r113 = (String) r112.getFirst();
        int r114 = Math.min(((Number) r112.getSecond()).intValue(), r113.length());
        if (r104 <= 0) goto L16;
        if (r114 < 0) goto L16;
        if (r111 >= r107) goto L16;
        int r115 = r104 + 3;
        int r116 = Math.min(r113.length() - r114, r115);
        r105.append(r113.subSequence(0, r113.length() - r116));
        r105.append("...");
        r104 = r115 - r116;
    L17:
        r109 = r111;
    L16:
        r105.append(r113);
        goto L17
    L18:
        r100.setText(b(r105.toString(), r100.f196260e));
        r100.post(new s(r100));
        return;
    }

    public /* synthetic */ MinorTagView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r110, int r111) {
        super.onLayout(r100, r101, r102, r110, r111);
        View r103 = this.f196262g;
        if (r103 != null) goto L5;
        return;
    L5:
        if (r100 == false) goto L17;
        MinorTag r104 = this.f196258c;
        if (r104 != null) goto L10;
        return;
    L10:
        if (this.f196259d == true) goto L12;
        return;
    L12:
        if (this.f196261f.measureText(r104.f198182a) <= ((getMeasuredWidth() - r103.getPaddingStart()) - r103.getPaddingEnd())) goto L14;
        float r105 = getMeasuredWidth() - this.f196261f.measureText("...");
    L15:
        TextUtils.ellipsize(r104.f198182a, this.f196261f, r105, TextUtils.TruncateAt.END, false, this.f196263h);
        this.f196259d = false;
        return;
    L14:
        r105 = getMeasuredWidth();
        goto L15
    }
}
