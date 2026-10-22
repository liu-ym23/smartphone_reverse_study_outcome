package com.bytedance.awemeopen.apps.framework.feed.follow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.awemeopen.apps.framework.feed.follow.util.DuxBadgeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0002:\u0001\u0012B'\b\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u0007R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/follow/HomeTopTabItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "Lcom/bytedance/awemeopen/apps/framework/feed/follow/d;", "", "getExpectTabWidth", "getContentViewWidth", "", "getCurrentTabId", "textSize", "", "setTextSize", "color", "setTextColor", "tab", "setText", "getText", "Lcom/bytedance/awemeopen/apps/framework/feed/follow/util/DuxBadgeView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/awemeopen/apps/framework/feed/follow/util/DuxBadgeView;", "getBadgeView", "()Lcom/bytedance/awemeopen/apps/framework/feed/follow/util/DuxBadgeView;", "setBadgeView", "(Lcom/bytedance/awemeopen/apps/framework/feed/follow/util/DuxBadgeView;)V", "badgeView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class HomeTopTabItemView extends ConstraintLayout implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DuxBadgeView f194717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f194718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f194719c;

    public static final class a {
    }

    static {
    }

    public HomeTopTabItemView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public HomeTopTabItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.d
    public String getCurrentTabId() {
        return "";
    }

    private final int getContentViewWidth() {
        TextView r100 = this.f194718b;
        int r101 = r100.getWidth();
        if (r101 > 0) goto L10;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L7;
        r101 = r102.width;
    L8:
        if (r101 > 0) goto L10;
        r101 = r100.getMeasuredWidth();
        goto L10
    L7:
        r101 = 0;
    L10:
        if (r101 > 0) goto L13;
        return -1;
    L13:
        return r101;
    }

    private final int getExpectTabWidth() {
        TextView r100 = this.f194718b;
        int r101 = getContentViewWidth();
        if (r101 > 0) goto L6;
        return -1;
    L6:
        ViewGroup.MarginLayoutParams r102 = null;
        if (r100 == null) goto L9;
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
    L11:
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == false) goto L13;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
    L14:
        int r105 = 0;
        if (r104 == null) goto L17;
        int r106 = r104.leftMargin;
    L18:
        int r107 = r101 + r106;
        if (r100 == null) goto L21;
        ViewGroup.LayoutParams r108 = r100.getLayoutParams();
    L23:
        if ((r108 instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
        r102 = (ViewGroup.MarginLayoutParams) r108;
    L25:
        if (r102 == null) goto L28;
        r105 = r102.rightMargin;
    L28:
        return r107 + r105;
    L21:
        r108 = null;
        goto L23
    L17:
        r106 = 0;
        goto L18
    L13:
        r104 = null;
        goto L14
    L9:
        r103 = null;
        goto L11
    }

    public final String getText() {
        return this.f194718b.getText().toString();
    }

    public final DuxBadgeView getBadgeView() {
        return this.f194717a;
    }

    public final void setBadgeView(DuxBadgeView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f194717a = r100;
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        this.f194718b.setText(r100);
    }

    public final void setTextColor(int r100) {
        this.f194718b.setTextColor(r100);
    }

    public final void setTextSize(int r100) {
        this.f194718b.setTextSize(0, r100);
    }

    public HomeTopTabItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.homepage_common_view_toptab, this, true);
        this.f194718b = (TextView) findViewById(R.id.tv_toptab_title);
        this.f194719c = findViewById(R.id.view_stub_toptab_badge_stub);
        this.f194717a = (DuxBadgeView) ((ViewStub) findViewById(R.id.view_stub_toptab_badge)).inflate().findViewById(R.id.tab_dot_count_dux);
    }

    public /* synthetic */ HomeTopTabItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
