package com.bytedance.awemeopen.apps.framework.comment.view.diggbury.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.awemeopen.apps.framework.comment.view.a;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000f"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/view/diggbury/view/BuryView2;", "Lcom/bytedance/awemeopen/apps/framework/comment/view/diggbury/view/BaseDiggBuryFrameLayout;", "", "getRootViewId", "()I", "rootViewId", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class BuryView2 extends BaseDiggBuryFrameLayout {
    public static final /* synthetic */ int f = 0;
    public View d;
    public ImageView e;

    @Override // com.bytedance.awemeopen.apps.framework.comment.view.diggbury.view.BaseDiggBuryFrameLayout
    public int getRootViewId() {
        return 2131558760;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.view.diggbury.view.BaseDiggBuryFrameLayout
    public final void a() {
        super.a();
        this.d = findViewById(2131364957);
        ImageView r0 = (ImageView) findViewById(2131364958);
        this.e = r0;
        if (r0 == null) goto L5;
        r0.setImageDrawable(a.a(false, getColorMode(), getContext()));
    L5:
        int r1 = x54.a.a(18);
        ImageView r2 = this.e;
        ViewGroup.LayoutParams r3 = null;
        if (r2 == null) goto L8;
        ViewGroup.LayoutParams r4 = r2.getLayoutParams();
    L9:
        if (r4 == null) goto L12;
        r4.width = r1;
    L12:
        ImageView r5 = this.e;
        if (r5 == null) goto L15;
        r3 = r5.getLayoutParams();
    L15:
        if (r3 == null) goto L19;
        r3.height = r1;
        return;
    L19:
        return;
    L8:
        r4 = null;
        goto L9
    }

    public BuryView2(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public BuryView2(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public BuryView2(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3, r4);
    }

    public final void b(boolean r3, boolean r4, long r5) {
        if (this.e == null) goto L24;
        Context r6 = getContext();
        if (this.c == r3) goto L10;
        ImageView r7 = this.e;
        if (r7 == null) goto L10;
        r7.setImageDrawable(a.a(r3, getColorMode(), r6));
    L10:
        ImageView r8 = this.e;
        if (r8 == null) goto L14;
        r8.setSelected(r3);
    L14:
        ImageView r9 = this.e;
        if (r9 == null) goto L18;
        r9.setVisibility(0);
    L18:
        if (r4 == false) goto L22;
        final ImageView r10 = this.e;
        if (r10 == null) goto L22;
        r10.animate().scaleX(0.8f).scaleY(0.8f).setDuration(80).withEndAction(new ry3.a(r10)).start();
    L22:
        setActive(r3);
        return;
    }
}
