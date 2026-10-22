package com.bytedance.locallife.photo.photodraweeview.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.ies.dmt.ui.widget.DmtTextView;
import com.bytedance.locallife.photo.internal.photodraweeview.IIndicatorView;
import com.bytedance.locallife.photo.internal.photodraweeview.transition.TransitionPagerAdapter;
import com.bytedance.locallife.photo.photodraweeview.PoiPhotoTransitionPagerAdapter;
import com.bytedance.locallife.photo.photodraweeview.b;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\tB'\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/locallife/photo/photodraweeview/indicator/CommonDecorateView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/locallife/photo/internal/photodraweeview/IIndicatorView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
public final class CommonDecorateView extends LinearLayout implements IIndicatorView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f262121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f262122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f262123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f262124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f262125e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<b> f262126f;

    @Override // com.bytedance.locallife.photo.internal.photodraweeview.IIndicatorView
    public final void onDataChanged(TransitionPagerAdapter<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
    }

    @Override // com.bytedance.locallife.photo.internal.photodraweeview.IIndicatorView
    public final void onDetach(int r100, TransitionPagerAdapter<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "adapter");
    }

    @Override // com.bytedance.locallife.photo.internal.photodraweeview.IIndicatorView
    public final void onPageSelected(int r100, boolean r101) {
    }

    @Override // com.bytedance.locallife.photo.internal.photodraweeview.IIndicatorView, com.bytedance.locallife.photo.internal.photodraweeview.transition.a
    public final void onTransitionChanged(int r100, float r101) {
    }

    public CommonDecorateView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final View a(int r100) {
        if (this.f262121a != null) goto L5;
        this.f262121a = new LinkedHashMap();
    L5:
        View r101 = this.f262121a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        Integer r103 = Integer.valueOf(r100);
        this.f262121a.put(r103, r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    @Override // com.bytedance.locallife.photo.internal.photodraweeview.IIndicatorView
    public final void onPageSelected(int r100) {
        if (this.f262124d > 0) goto L6;
        setVisibility(8);
        return;
    L6:
        View r101 = a(R.id.tv_index);
        View r102 = null;
        String r103 = null;
        if (r101 != null) goto L9;
        r101 = null;
    L9:
        DmtTextView r104 = (DmtTextView) r101;
        int r105 = 0;
        if (r104 == null) goto L13;
        StringCompanionObject r106 = StringCompanionObject.INSTANCE;
        r104.setText(String.format("%d/%d", Arrays.copyOf(new Object[]{Integer.valueOf(r100 + 1), Integer.valueOf(this.f262124d)}, 2)));
    L13:
        this.f262125e = r100;
        int r107 = r100 % this.f262124d;
        List<String> r108 = this.f262122b;
        if (r108 == null) goto L17;
        r105 = r108.size();
    L17:
        if (r107 < 0) goto L30;
        if (r107 >= r105) goto L30;
        View r109 = a(R.id.tv_title);
        if (r109 != null) goto L23;
        r109 = null;
    L23:
        DmtTextView r110 = (DmtTextView) r109;
        if (r110 == null) goto L40;
        List<String> r111 = this.f262122b;
        if (r111 == null) goto L29;
        r103 = (String) ListProtector.get(r111, r107);
    L29:
        r110.setText(r103);
        return;
    L40:
        return;
    L30:
        View r112 = a(R.id.tv_title);
        if (r112 == null) goto L34;
        r102 = r112;
    L34:
        DmtTextView r113 = (DmtTextView) r102;
        if (r113 == null) goto L41;
        r113.setText("");
        return;
    }

    @Override // com.bytedance.locallife.photo.internal.photodraweeview.IIndicatorView, com.bytedance.locallife.photo.internal.photodraweeview.transition.a
    public final void onTransitionBegin(int r100) {
        if (r100 != 0) goto L4;
    L8:
        setVisibility(8);
        return;
    L4:
        if (r100 == 1) goto L8;
        if (r100 == 3) goto L8;
    }

    @Override // com.bytedance.locallife.photo.internal.photodraweeview.IIndicatorView, com.bytedance.locallife.photo.internal.photodraweeview.transition.a
    public final void onTransitionEnd(int r100) {
        if (r100 != 0) goto L4;
    L6:
        setVisibility(0);
        return;
    L4:
        if (r100 == 2) goto L6;
    }

    public CommonDecorateView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // com.bytedance.locallife.photo.internal.photodraweeview.IIndicatorView
    public final void onAttach(int r100, TransitionPagerAdapter<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "adapter");
        List<b> r102 = null;
        if ((r101 instanceof PoiPhotoTransitionPagerAdapter) == false) goto L5;
        PoiPhotoTransitionPagerAdapter r103 = (PoiPhotoTransitionPagerAdapter) r101;
    L6:
        if (r103 == null) goto L8;
        r102 = r103.f262082b;
    L8:
        this.f262126f = r102;
        return;
    L5:
        r103 = null;
        goto L6
    }

    public CommonDecorateView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f262121a = new LinkedHashMap();
        PatternProtector.compile("^data:image/(.+?);base64,\\s*", 2);
        LayoutInflater.from(r100).inflate(R.layout.poi_layout_common_indicator_view, this);
    }

    public final void b(List r100, boolean r101, int r102, int r103) {
        this.f262122b = r100;
        this.f262123c = r101;
        this.f262124d = r102;
        this.f262125e = r103;
        boolean r104 = true;
        View r105 = null;
        if (r102 <= 1) goto L17;
        View r106 = a(R.id.tv_index);
        if (r106 != null) goto L7;
        r106 = null;
    L7:
        DmtTextView r107 = (DmtTextView) r106;
        if (r107 == null) goto L10;
        r107.setVisibility(0);
    L10:
        View r108 = a(R.id.tv_index);
        if (r108 != null) goto L13;
        r108 = null;
    L13:
        DmtTextView r109 = (DmtTextView) r108;
        if (r109 == null) goto L32;
        StringCompanionObject r110 = StringCompanionObject.INSTANCE;
        r109.setText(String.format("%d/%d", Arrays.copyOf(new Object[]{Integer.valueOf(this.f262125e + 1), Integer.valueOf(this.f262124d)}, 2)));
    L32:
        if (this.f262123c == false) goto L39;
        RelativeLayout.LayoutParams r111 = new RelativeLayout.LayoutParams(-2, -2);
        r111.addRule(9);
        r111.addRule(15);
        View r112 = a(R.id.tv_index);
        if (r112 != null) goto L36;
        r112 = null;
    L36:
        DmtTextView r113 = (DmtTextView) r112;
        if (r113 == null) goto L46;
        r113.setLayoutParams(r111);
    L46:
        View r114 = a(R.id.iv_download);
        if (r114 == null) goto L50;
        r114.setVisibility(8);
    L50:
        List<String> r115 = this.f262122b;
        if (r115 != null) goto L53;
        return;
    L53:
        if (this.f262125e < r115.size()) goto L56;
        r104 = false;
    L56:
        if (r104 == true) goto L59;
        r115 = null;
    L59:
        if (r115 == null) goto L72;
        String r116 = (String) ListProtector.get(r115, this.f262125e);
        if (r116 == null) goto L73;
        View r117 = a(R.id.tv_title);
        if (r117 == null) goto L66;
        r105 = r117;
    L66:
        DmtTextView r118 = (DmtTextView) r105;
        if (r118 == null) goto L74;
        r118.setText(r116);
        return;
    L74:
        return;
    L73:
        return;
    L72:
        return;
    L39:
        View r119 = a(R.id.tv_index);
        if (r119 != null) goto L42;
        r119 = null;
    L42:
        DmtTextView r120 = (DmtTextView) r119;
        if (r120 == null) goto L46;
        r120.setGravity(5);
        goto L46
    L17:
        View r121 = a(R.id.tv_index);
        if (r121 != null) goto L20;
        r121 = null;
    L20:
        DmtTextView r122 = (DmtTextView) r121;
        if (r122 == null) goto L24;
        r122.setVisibility(8);
    L24:
        if (this.f262123c == true) goto L32;
        List<String> r123 = this.f262122b;
        if (r123 == null) goto L28;
        int r124 = r123.size();
    L29:
        if (r124 > 0) goto L32;
        setVisibility(8);
        goto L32
    L28:
        r124 = 0;
        goto L29
    }
}
