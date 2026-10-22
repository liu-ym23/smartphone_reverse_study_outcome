package com.bytedance.ee.bear.drive.view.preview.video.aisummary;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u000e\u0010\f\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\rJ\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\rH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\rH\u0002J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007H\u0014R\u0012\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/drive/view/preview/video/aisummary/OnlyPortraitFrameLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lastRequestedOrientation", "Ljava/lang/Integer;", "enableLockPortrait", "", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "enable", "handleConfigurationChange", "isPortrait", "revertOrientation", "lockPortrait", "setRequestOrientation", "activity", "Landroidx/fragment/app/FragmentActivity;", "orientation", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class OnlyPortraitFrameLayout extends FrameLayout {

    public static final class a {
    }

    static {
    }

    public OnlyPortraitFrameLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OnlyPortraitFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        int r101 = 0;
        if (r100 == null) goto L7;
        boolean r102 = true;
        if (r100.orientation != 1) goto L7;
    L8:
        if (r102 == true) goto L11;
        r101 = 8;
    L11:
        setVisibility(r101);
        return;
    L7:
        r102 = false;
        goto L8
    }

    public OnlyPortraitFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Context r103 = getContext();
        if ((r103 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r104 = (FragmentActivity) r103;
    L6:
        int r105 = 0;
        if (r104 == null) goto L12;
        boolean r106 = true;
        if (r104.getResources().getConfiguration().orientation != 1) goto L12;
    L13:
        if (r106 == true) goto L16;
        r105 = 8;
    L16:
        setVisibility(r105);
        return;
    L12:
        r106 = false;
        goto L13
    L5:
        r104 = null;
        goto L6
    }

    public /* synthetic */ OnlyPortraitFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
