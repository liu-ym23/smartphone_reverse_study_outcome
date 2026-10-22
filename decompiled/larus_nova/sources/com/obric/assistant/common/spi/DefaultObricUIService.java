package com.obric.assistant.common.spi;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0018\u0010\n\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0002\u0010\u0017J\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0012H\u0016J\b\u0010#\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020!H\u0016J\b\u0010%\u001a\u00020!H\u0016J\u0018\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u0012H\u0016J\u001c\u0010)\u001a\u00020\u00052\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+H\u0016J\u0018\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020-H\u0016J\b\u00101\u001a\u00020!H\u0016J\u0010\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020!H\u0016J\b\u00104\u001a\u00020!H\u0016J\u0010\u00105\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\bH\u0016¨\u00067"}, d2 = {"Lcom/obric/assistant/common/spi/DefaultObricUIService;", "Lcom/obric/assistant/common/spi/IObricUIService;", "<init>", "()V", "changeFontSizeToSP", "", "textViews", "", "Landroid/widget/TextView;", "([Landroid/widget/TextView;)V", "toSPBasedPixelSize", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "dpBasedPixelSize", "", "setChatRootBottomPadding", "chatRoot", "Landroid/view/View;", "navigationBarHeight", "getNavigationBarHeightFallback", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)Ljava/lang/Integer;", "getMentionPanelMaxHeight", "panelView", "currentMaxHeight", "(Landroid/view/View;I)Ljava/lang/Integer;", "onSideBarContentViewCreated", "contentView", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "isWindowLandscape", "", "actionMenuEntrance", "enableActionBarMenuFocusable", "enableInterceptSwitchMenuView", "enableInterceptSwitchMenuOutsideTouch", "applyResourceBarStyle", "viewType", "itemView", "setTagForBottomMenuIcon", "iconMap", "", "", "Landroid/widget/ImageView;", "applySuggestedActionBarStyle", "textView", "iconView", "disableSwDpOffline", "onEnterSelectMode", "isWindowHost", "isMultiTaskNewChatNavEntryEnabledWhenEnterprise", "setupInputPanelHeader", "Companion", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricUIService implements IObricUIService {

    public static final class a {
    }

    static {
    }

    public DefaultObricUIService() {
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final int b(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "chatRoot");
        return r101;
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final void ia(Map<String, ? extends ImageView> r100) {
        Intrinsics.checkNotNullParameter(r100, "iconMap");
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final boolean ja(View r100) {
        Intrinsics.checkNotNullParameter(r100, "actionMenuEntrance");
        return false;
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final Integer ka(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return null;
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final boolean la() {
        return false;
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final boolean ma() {
        return true;
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final void na(TextView... r100) {
        Intrinsics.checkNotNullParameter(r100, "textViews");
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final void oa(TextView r100, AppCompatImageView r101) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        Intrinsics.checkNotNullParameter(r101, "iconView");
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final void pa() {
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final void qa(ConstraintLayout r100, LifecycleOwner r101) {
        Intrinsics.checkNotNullParameter(r100, "contentView");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final boolean ra() {
        return false;
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final boolean sa() {
        return true;
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final void ta(int r100, View r101) {
        Intrinsics.checkNotNullParameter(r101, "itemView");
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final int ua(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return r101;
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final float va(Context r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return r101;
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final void wa(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "textView");
    }

    @Override // com.obric.assistant.common.spi.IObricUIService
    public final void xa(boolean r100) {
    }
}
