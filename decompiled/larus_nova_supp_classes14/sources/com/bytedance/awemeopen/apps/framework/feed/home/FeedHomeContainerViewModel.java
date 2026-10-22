package com.bytedance.awemeopen.apps.framework.feed.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.awemeopen.apps.framework.framework.AosViewModel;
import com.bytedance.awemeopen.apps.framework.framework.livedata.DiscardFirstValueLiveData;
import com.bytedance.awemeopen.export.api.pageconfig.feedhome.FeedsHomePageConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0005J\u000e\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\fR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u001e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 ¨\u0006)"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/home/FeedHomeContainerViewModel;", "Lcom/bytedance/awemeopen/apps/framework/framework/AosViewModel;", "()V", "_selectedIndex", "Lcom/bytedance/awemeopen/apps/framework/framework/livedata/DiscardFirstValueLiveData;", "", "_startEnteringToProfile", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/awemeopen/apps/framework/feed/home/FeedHomeContainerViewModel$EnterProfileStyle;", "deliveredHiddenChangedState", "", "getDeliveredHiddenChangedState", "()Lcom/bytedance/awemeopen/apps/framework/framework/livedata/DiscardFirstValueLiveData;", "enableSwipeLeft", "getEnableSwipeLeft", "enableSwipeRight", "getEnableSwipeRight", "feedsHomePageConfig", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/FeedsHomePageConfig;", "getFeedsHomePageConfig", "()Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/FeedsHomePageConfig;", "setFeedsHomePageConfig", "(Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/FeedsHomePageConfig;)V", "isMultiTab", "()Z", "setMultiTab", "(Z)V", "scrollable", "getScrollable", "selectedIndex", "Landroidx/lifecycle/LiveData;", "getSelectedIndex", "()Landroidx/lifecycle/LiveData;", "startEnteringToProfile", "getStartEnteringToProfile", "updatePage", "", "v", "updateStartEnteringToProfile", "style", "EnterProfileStyle", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FeedHomeContainerViewModel extends AosViewModel {
    private DiscardFirstValueLiveData<Integer> _selectedIndex;
    private MutableLiveData<EnterProfileStyle> _startEnteringToProfile;
    private final DiscardFirstValueLiveData<Boolean> deliveredHiddenChangedState;
    private final DiscardFirstValueLiveData<Boolean> enableSwipeLeft;
    private final DiscardFirstValueLiveData<Boolean> enableSwipeRight;
    private FeedsHomePageConfig feedsHomePageConfig;
    private boolean isMultiTab;
    private final DiscardFirstValueLiveData<Boolean> scrollable;
    private final LiveData<Integer> selectedIndex;
    private final LiveData<EnterProfileStyle> startEnteringToProfile;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/home/FeedHomeContainerViewModel$EnterProfileStyle;", "", "DraggingToEnter", "ClickUserNameToEnter", "ClickHeadToEnter", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final enum EnterProfileStyle extends Enum<EnterProfileStyle> {
        public static final EnterProfileStyle ClickHeadToEnter = null;
        public static final EnterProfileStyle ClickUserNameToEnter = null;
        public static final EnterProfileStyle DraggingToEnter = null;
        public static final /* synthetic */ EnterProfileStyle[] a = null;

        public static EnterProfileStyle valueOf(String r1) {
            return (EnterProfileStyle) a.a(EnterProfileStyle.class, r1);
        }

        public static EnterProfileStyle[] values() {
            return (EnterProfileStyle[]) a.clone();
        }

        static {
            EnterProfileStyle r0 = new EnterProfileStyle("DraggingToEnter", 0);
            DraggingToEnter = r0;
            EnterProfileStyle r1 = new EnterProfileStyle("ClickUserNameToEnter", 1);
            ClickUserNameToEnter = r1;
            EnterProfileStyle r3 = new EnterProfileStyle("ClickHeadToEnter", 2);
            ClickHeadToEnter = r3;
            a = new EnterProfileStyle[]{r0, r1, r3};
        }

        public EnterProfileStyle(String r1, int r2) {
            super(r1, r2);
        }
    }

    public FeedHomeContainerViewModel() {
        DiscardFirstValueLiveData<Integer> r0 = new DiscardFirstValueLiveData(0);
        this._selectedIndex = r0;
        this.selectedIndex = r0;
        this.deliveredHiddenChangedState = new DiscardFirstValueLiveData(Boolean.FALSE);
        Boolean r1 = Boolean.TRUE;
        this.scrollable = new DiscardFirstValueLiveData(r1);
        this.enableSwipeRight = new DiscardFirstValueLiveData(r1);
        this.enableSwipeLeft = new DiscardFirstValueLiveData(r1);
        MutableLiveData<EnterProfileStyle> r2 = new MutableLiveData();
        this._startEnteringToProfile = r2;
        this.startEnteringToProfile = r2;
    }

    public final DiscardFirstValueLiveData<Boolean> getDeliveredHiddenChangedState() {
        return this.deliveredHiddenChangedState;
    }

    public final DiscardFirstValueLiveData<Boolean> getEnableSwipeLeft() {
        return this.enableSwipeLeft;
    }

    public final DiscardFirstValueLiveData<Boolean> getEnableSwipeRight() {
        return this.enableSwipeRight;
    }

    public final FeedsHomePageConfig getFeedsHomePageConfig() {
        return this.feedsHomePageConfig;
    }

    public final DiscardFirstValueLiveData<Boolean> getScrollable() {
        return this.scrollable;
    }

    public final LiveData<Integer> getSelectedIndex() {
        return this.selectedIndex;
    }

    public final LiveData<EnterProfileStyle> getStartEnteringToProfile() {
        return this.startEnteringToProfile;
    }

    public final boolean isMultiTab() {
        return this.isMultiTab;
    }

    public final void setFeedsHomePageConfig(FeedsHomePageConfig r1) {
        this.feedsHomePageConfig = r1;
    }

    public final void setMultiTab(boolean r1) {
        this.isMultiTab = r1;
    }

    public final void updatePage(int r2) {
        this._selectedIndex.setValue(Integer.valueOf(r2));
    }

    public final void updateStartEnteringToProfile(EnterProfileStyle r2) {
        Intrinsics.checkNotNullParameter(r2, "style");
        this._startEnteringToProfile.setValue(r2);
    }
}
