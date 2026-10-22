package com.obric.assistant.common.spi;

import android.content.Context;
import android.util.EventsUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import java.util.Map;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0005\"\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH&J\u0018\u0010\b\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH&J\u0017\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u0014H&¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H&J\u001f\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\tH&¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0010H&J\b\u0010!\u001a\u00020\u001fH&J\b\u0010\"\u001a\u00020\u001fH&J\b\u0010#\u001a\u00020\u001fH&J\u0018\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u0010H&J\u001c\u0010'\u001a\u00020\u00032\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)H&J\u0018\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020+H&J\b\u0010/\u001a\u00020\u001fH&J\u0010\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u001fH&J\b\u00102\u001a\u00020\u001fH&J\u0010\u00103\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0006H&¨\u00064"}, d2 = {"Lcom/obric/assistant/common/spi/IObricUIService;", XmlPullParser.NO_NAMESPACE, "changeFontSizeToSP", XmlPullParser.NO_NAMESPACE, "textViews", XmlPullParser.NO_NAMESPACE, "Landroid/widget/TextView;", "([Landroid/widget/TextView;)V", "toSPBasedPixelSize", XmlPullParser.NO_NAMESPACE, "context", "Landroid/content/Context;", "dpBasedPixelSize", XmlPullParser.NO_NAMESPACE, "setChatRootBottomPadding", "chatRoot", "Landroid/view/View;", "navigationBarHeight", "getNavigationBarHeightFallback", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)Ljava/lang/Integer;", "onSideBarContentViewCreated", "contentView", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "getMentionPanelMaxHeight", "panelView", "currentMaxHeight", "(Landroid/view/View;I)Ljava/lang/Integer;", "isWindowLandscape", XmlPullParser.NO_NAMESPACE, "actionMenuEntrance", "enableActionBarMenuFocusable", "enableInterceptSwitchMenuView", "enableInterceptSwitchMenuOutsideTouch", "applyResourceBarStyle", "viewType", "itemView", "setTagForBottomMenuIcon", "iconMap", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "Landroid/widget/ImageView;", "applySuggestedActionBarStyle", "textView", "iconView", "disableSwDpOffline", "onEnterSelectMode", "isWindowHost", "isMultiTaskNewChatNavEntryEnabledWhenEnterprise", "setupInputPanelHeader", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface IObricUIService {
    int b(View r1, int r2);

    void ia(Map<String, ? extends ImageView> r1);

    boolean ja(View r1);

    Integer ka(FragmentActivity r1);

    boolean la();

    boolean ma();

    void na(TextView... r1);

    void oa(TextView r1, AppCompatImageView r2);

    void pa();

    void qa(ConstraintLayout r1, LifecycleOwner r2);

    boolean ra();

    boolean sa();

    void ta(int r1, View r2);

    int ua(Context r1, int r2);

    float va(Context r1, float r2);

    void wa(TextView r1);

    void xa(boolean r1);
}
