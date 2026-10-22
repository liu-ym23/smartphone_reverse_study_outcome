package com.bytedance.ee.bear.drive.view.preview.video.aisummary;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u000e\u0010\f\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\rJ\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\rH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\rH\u0002J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007H\u0014R\u0012\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/drive/view/preview/video/aisummary/OnlyPortraitFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lastRequestedOrientation", "Ljava/lang/Integer;", "enableLockPortrait", "", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "enable", "handleConfigurationChange", "isPortrait", "revertOrientation", "lockPortrait", "setRequestOrientation", "activity", "Landroidx/fragment/app/FragmentActivity;", "orientation", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class OnlyPortraitFrameLayout extends FrameLayout {

    public static final class a {
    }

    static {
    }

    public OnlyPortraitFrameLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OnlyPortraitFrameLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r3) {
        super.onConfigurationChanged(r3);
        int r0 = 0;
        if (r3 == null) goto L7;
        boolean r1 = true;
        if (r3.orientation != 1) goto L7;
    L8:
        if (r1 == true) goto L11;
        r0 = 8;
    L11:
        setVisibility(r0);
        return;
    L7:
        r1 = false;
        goto L8
    }

    public OnlyPortraitFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        FragmentActivity r5 = getContext();
        if ((r5 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r6 = r5;
    L6:
        int r7 = 0;
        if (r6 == null) goto L12;
        boolean r8 = true;
        if (r6.getResources().getConfiguration().orientation != 1) goto L12;
    L13:
        if (r8 == true) goto L16;
        r7 = 8;
    L16:
        setVisibility(r7);
        return;
    L12:
        r8 = false;
        goto L13
    L5:
        r6 = null;
        goto L6
    }

    public /* synthetic */ OnlyPortraitFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
