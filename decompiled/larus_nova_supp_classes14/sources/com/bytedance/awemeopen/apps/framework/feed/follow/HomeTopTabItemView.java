package com.bytedance.awemeopen.apps.framework.feed.follow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.awemeopen.apps.framework.feed.follow.util.DuxBadgeView;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0002:\u0001\u0012B'\b\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u0007R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/follow/HomeTopTabItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "Lcom/bytedance/awemeopen/apps/framework/feed/follow/d;", "", "getExpectTabWidth", "getContentViewWidth", "", "getCurrentTabId", "textSize", "", "setTextSize", "color", "setTextColor", "tab", "setText", "getText", "Lcom/bytedance/awemeopen/apps/framework/feed/follow/util/DuxBadgeView;", "a", "Lcom/bytedance/awemeopen/apps/framework/feed/follow/util/DuxBadgeView;", "getBadgeView", "()Lcom/bytedance/awemeopen/apps/framework/feed/follow/util/DuxBadgeView;", "setBadgeView", "(Lcom/bytedance/awemeopen/apps/framework/feed/follow/util/DuxBadgeView;)V", "badgeView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class HomeTopTabItemView extends ConstraintLayout implements d {
    public DuxBadgeView a;
    public final TextView b;
    public final View c;

    public static final class a {
    }

    static {
    }

    public HomeTopTabItemView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public HomeTopTabItemView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.d
    public String getCurrentTabId() {
        return "";
    }

    private final int getContentViewWidth() {
        TextView r0 = this.b;
        int r1 = r0.getWidth();
        if (r1 > 0) goto L10;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        if (r2 == null) goto L7;
        r1 = r2.width;
    L8:
        if (r1 > 0) goto L10;
        r1 = r0.getMeasuredWidth();
        goto L10
    L7:
        r1 = 0;
    L10:
        if (r1 > 0) goto L13;
        return -1;
    L13:
        return r1;
    }

    private final int getExpectTabWidth() {
        TextView r0 = this.b;
        int r1 = getContentViewWidth();
        if (r1 > 0) goto L6;
        return -1;
    L6:
        ViewGroup.MarginLayoutParams r2 = null;
        if (r0 == null) goto L9;
        ViewGroup.LayoutParams r3 = r0.getLayoutParams();
    L11:
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L13;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
    L14:
        int r5 = 0;
        if (r4 == null) goto L17;
        int r6 = r4.leftMargin;
    L18:
        int r7 = r1 + r6;
        if (r0 == null) goto L21;
        ViewGroup.LayoutParams r8 = r0.getLayoutParams();
    L23:
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
        r2 = (ViewGroup.MarginLayoutParams) r8;
    L25:
        if (r2 == null) goto L28;
        r5 = r2.rightMargin;
    L28:
        return r7 + r5;
    L21:
        r8 = null;
        goto L23
    L17:
        r6 = 0;
        goto L18
    L13:
        r4 = null;
        goto L14
    L9:
        r3 = null;
        goto L11
    }

    public final String getText() {
        return this.b.getText().toString();
    }

    public final DuxBadgeView getBadgeView() {
        return this.a;
    }

    public final void setBadgeView(DuxBadgeView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tab");
        this.b.setText(r2);
    }

    public final void setTextColor(int r2) {
        this.b.setTextColor(r2);
    }

    public final void setTextSize(int r3) {
        this.b.setTextSize(0, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HomeTopTabItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131561518, this, true);
        this.b = (TextView) findViewById(2131391646);
        this.c = findViewById(2131392597);
        this.a = (DuxBadgeView) ((ViewStub) findViewById(2131392596)).inflate().findViewById(2131388016);
    }

    public /* synthetic */ HomeTopTabItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
