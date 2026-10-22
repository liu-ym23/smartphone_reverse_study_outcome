package com.bytedance.awemeopen.apps.framework.comment.view.diggbury.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDelegate;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentColorMode;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!B\u001b\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\b\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b \u0010$B#\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\u0006\u0010%\u001a\u00020\u001a¢\u0006\u0004\b \u0010&R$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001a8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006'"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/view/diggbury/view/BaseDiggBuryFrameLayout;", "Landroid/widget/FrameLayout;", "", "Landroid/view/View;", "a", "Landroid/view/View;", "getMRootView", "()Landroid/view/View;", "setMRootView", "(Landroid/view/View;)V", "mRootView", "Lcom/bytedance/awemeopen/apps/framework/comment/api/constants/CommentColorMode;", "b", "Lcom/bytedance/awemeopen/apps/framework/comment/api/constants/CommentColorMode;", "getColorMode", "()Lcom/bytedance/awemeopen/apps/framework/comment/api/constants/CommentColorMode;", "setColorMode", "(Lcom/bytedance/awemeopen/apps/framework/comment/api/constants/CommentColorMode;)V", "colorMode", "", "c", "Z", "isActive", "()Z", "setActive", "(Z)V", "", "getRootViewId", "()I", "rootViewId", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public abstract class BaseDiggBuryFrameLayout extends FrameLayout {
    public View a;
    public CommentColorMode b;
    public boolean c;

    public abstract int getRootViewId();

    public void a() {
        this.a = FrameLayout.inflate(getContext(), getRootViewId(), this);
        setClipChildren(false);
        setClipToPadding(false);
    }

    public final CommentColorMode getColorMode() {
        return this.b;
    }

    public final View getMRootView() {
        return this.a;
    }

    public BaseDiggBuryFrameLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setActive(boolean r1) {
        this.c = r1;
    }

    public final void setColorMode(CommentColorMode r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void setMRootView(View r1) {
        this.a = r1;
    }

    public BaseDiggBuryFrameLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public BaseDiggBuryFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3, r4);
        int r5 = AppCompatDelegate.getDefaultNightMode();
        if (r5 != 1) goto L5;
        CommentColorMode r6 = CommentColorMode.MODE_LIGHT;
    L9:
        this.b = r6;
        a();
        return;
    L5:
        if (r5 == 2) goto L7;
        r6 = CommentColorMode.MODE_LIGHT_OR_DARK;
        goto L9
    L7:
        r6 = CommentColorMode.MODE_DARK;
        goto L9
    }
}
