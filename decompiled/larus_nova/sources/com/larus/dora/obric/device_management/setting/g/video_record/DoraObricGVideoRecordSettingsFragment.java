package com.larus.dora.obric.device_management.setting.g.video_record;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.dora.api.model.FlowDoraVideoRecordConfig;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.settings.media.MediaSettingsViewModel;
import com.larus.dora.impl.device.settings.media.a0;
import com.larus.nova.R;
import com.larus.utils.j0;
import com.lynx.textra.PlatformFontCaps;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 _2\u00020\u0001:\u0003]^_B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\"\u001a\u00020\u000fH\u0002J\b\u0010#\u001a\u00020\u000fH\u0002J\b\u0010$\u001a\u00020\u000fH\u0002J\b\u0010%\u001a\u00020\u001cH\u0002J\u0018\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)H\u0002J\u0014\u0010*\u001a\u00020\u001c*\u00020\u00132\u0006\u0010'\u001a\u00020\u0012H\u0002J\b\u0010+\u001a\u00020\u001cH\u0002J\b\u0010,\u001a\u00020\u001cH\u0002J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u0013H\u0002J\u0010\u0010/\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u0013H\u0002J\u0010\u00100\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u0013H\u0002J\u0014\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0302H\u0002J\u0014\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0302H\u0002JK\u00105\u001a\u00020\u001c\"\u0004\b\u0000\u001062\u0006\u0010.\u001a\u00020\u00132\u0012\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H603022\u0006\u00108\u001a\u0002H62\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u00020\u001c0:H\u0002¢\u0006\u0002\u0010;J\u0010\u0010<\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020)H\u0002J\u0010\u0010>\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020)H\u0002J\u0010\u0010@\u001a\u00020\u001c2\u0006\u0010A\u001a\u00020)H\u0002J&\u0010B\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020 2\u0006\u0010D\u001a\u00020 2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001c0FH\u0002J\n\u0010G\u001a\u0004\u0018\u00010HH\u0002J\u0018\u0010I\u001a\u00020)2\u0006\u0010J\u001a\u00020)2\u0006\u0010K\u001a\u00020)H\u0002J\u0010\u0010L\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0012H\u0002J\b\u0010M\u001a\u00020)H\u0002J\b\u0010N\u001a\u00020)H\u0002J\b\u0010O\u001a\u00020)H\u0002J\u0014\u0010P\u001a\u00020\u001c*\u00020\u00132\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010Q\u001a\u00020)2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010R\u001a\u00020)2\u0006\u0010(\u001a\u00020)H\u0002J\u001c\u0010S\u001a\u00020\u001c*\u00020T2\u0006\u0010(\u001a\u00020)2\u0006\u0010U\u001a\u00020)H\u0002J\f\u0010V\u001a\u00020\u001c*\u00020WH\u0002J\f\u0010X\u001a\u00020\u001c*\u00020YH\u0002J\f\u0010Z\u001a\u00020)*\u00020)H\u0002J\f\u0010[\u001a\u00020)*\u00020\\H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/g/video_record/DoraObricGVideoRecordSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "viewModel", "Lcom/larus/dora/impl/device/settings/media/MediaSettingsViewModel;", "getViewModel", "()Lcom/larus/dora/impl/device/settings/media/MediaSettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "contentContainer", "Landroid/widget/LinearLayout;", "activePopover", "Lcom/obric/oui/popover/v2/OPopover;", "pageMaskView", "Landroid/view/View;", "itemViews", "", "Lcom/larus/dora/obric/device_management/setting/g/video_record/DoraObricGVideoRecordSettingsFragment$VideoRecordSettingItem;", "Lcom/obric/oui/lisitem/OCardListItem;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "getCurrentPageName", "", "getPageMaskView", "buildContentView", "buildTitleBar", "buildScrollContent", "renderSettings", "buildSettingItem", MapController.ITEM_LAYER_TAG, "position", "", "bindDropEnd", "observeVideoRecordConfig", "bindCurrentConfig", "showResolutionMenu", "anchor", "showRatioMenu", "showDurationMenu", "buildRatioOptions", "", "Lcom/larus/dora/obric/device_management/setting/g/video_record/DoraObricGVideoRecordSettingsFragment$VideoRecordMenuOption;", "buildDurationOptions", "showMenu", ExifInterface.GPS_DIRECTION_TRUE, "options", "selectedValue", "onSelected", "Lkotlin/Function1;", "(Lcom/obric/oui/lisitem/OCardListItem;Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "updateResolution", "resolution", "updateRatio", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "updateDuration", "duration", "showConfirmDialog", "title", "msg", "onConfirm", "Lkotlin/Function0;", "currentVideoRecordConfig", "Lcom/larus/dora/api/model/FlowDoraVideoRecordConfig;", "resolveCardPosition", "index", "lastIndex", "titleFor", "resolveBackgroundColor", "resolveSecondaryTextColor", "resolvePrimaryTextColor", "applyCardStyle", "sectionTopPadding", "sectionBottomPadding", "applySectionCornerRadii", "Landroid/graphics/drawable/GradientDrawable;", "radiusDp", "applyValueTextStyle", "Lcom/obric/oui/text/OTextView;", "applyDropIconStyle", "Landroid/widget/ImageView;", "dp", CloudControlInf.SP, "", "VideoRecordSettingItem", "VideoRecordMenuOption", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricGVideoRecordSettingsFragment extends DoraBaseFragment {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final List<VideoRecordSettingItem> f340616k = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f340617f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f340618g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.obric.oui.popover.v2.c f340619h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f340620i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<VideoRecordSettingItem, OCardListItem> f340621j;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/g/video_record/DoraObricGVideoRecordSettingsFragment$VideoRecordSettingItem;", "", "<init>", "(Ljava/lang/String;I)V", "RESOLUTION", "RATIO", "DURATION", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum VideoRecordSettingItem extends Enum<VideoRecordSettingItem> {
        public static final VideoRecordSettingItem DURATION = null;
        public static final VideoRecordSettingItem RATIO = null;
        public static final VideoRecordSettingItem RESOLUTION = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VideoRecordSettingItem[] f340622a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f340623b = null;

        public static EnumEntries<VideoRecordSettingItem> getEntries() {
            return f340623b;
        }

        static {
            VideoRecordSettingItem r100 = new VideoRecordSettingItem("RESOLUTION", 0);
            RESOLUTION = r100;
            VideoRecordSettingItem r101 = new VideoRecordSettingItem("RATIO", 1);
            RATIO = r101;
            VideoRecordSettingItem r102 = new VideoRecordSettingItem("DURATION", 2);
            DURATION = r102;
            VideoRecordSettingItem[] r103 = {r100, r101, r102};
            f340622a = r103;
            f340623b = EnumEntriesKt.enumEntries(r103);
        }

        public static VideoRecordSettingItem[] values() {
            return (VideoRecordSettingItem[]) f340622a.clone();
        }

        public static VideoRecordSettingItem valueOf(String r100) {
            return (VideoRecordSettingItem) r27.a.a(VideoRecordSettingItem.class, r100);
        }

        public VideoRecordSettingItem(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f340624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f340625b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f340626c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f340624a, r101.f340624a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f340625b, r101.f340625b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f340626c, r101.f340626c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            T r100 = this.f340624a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = ((r102 * 31) + this.f340625b.hashCode()) * 31;
            String r104 = this.f340626c;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "VideoRecordMenuOption(value=" + this.f340624a + ", title=" + this.f340625b + ", subTitle=" + this.f340626c + ')';
        }

        public b(T r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "title");
            this.f340624a = r100;
            this.f340625b = r101;
            this.f340626c = r102;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f340627a = null;

        static {
            int[] r100 = new int[VideoRecordSettingItem.values().length];
            r100[VideoRecordSettingItem.RESOLUTION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[VideoRecordSettingItem.RATIO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[VideoRecordSettingItem.DURATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f340627a = r100;
        }
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "media_setting";
    }

    static {
        f340616k = CollectionsKt.listOf(new VideoRecordSettingItem[]{VideoRecordSettingItem.RESOLUTION, VideoRecordSettingItem.RATIO, VideoRecordSettingItem.DURATION});
    }

    public final MediaSettingsViewModel ca0() {
        return (MediaSettingsViewModel) this.f340617f.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        com.obric.oui.popover.v2.c r100 = this.f340619h;
        if (r100 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        r100.dismiss();
    L5:
        this.f340619h = null;
        this.f340618g = null;
        this.f340620i = null;
        ((LinkedHashMap) this.f340621j).clear();
        super.onDestroyView();
    }

    public DoraObricGVideoRecordSettingsFragment() {
        this.f340617f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MediaSettingsViewModel.class), new DoraObricGVideoRecordSettingsFragment$special$$inlined$activityViewModels$default$1(this), new DoraObricGVideoRecordSettingsFragment$special$$inlined$activityViewModels$default$2(this));
        this.f340621j = new LinkedHashMap();
    }

    public final void Z90() {
        FlowDoraVideoRecordConfig r100 = aa0();
        if (r100 != null) goto L5;
        return;
    L5:
        g49.d.d("DoraObricGVideoRecordSettingsFragment", "bind video record config = " + r100);
        OCardListItem r101 = (OCardListItem) ((LinkedHashMap) this.f340621j).get(VideoRecordSettingItem.RESOLUTION);
        if (r101 == null) goto L8;
        r101.k(ca0().getVideoQualityTxt(r100), ba0(96));
    L8:
        OCardListItem r102 = (OCardListItem) ((LinkedHashMap) this.f340621j).get(VideoRecordSettingItem.RATIO);
        if (r102 == null) goto L11;
        r102.k(ca0().getVideoAspectRatioTxt(Integer.valueOf(r100.f331757c)), ba0(96));
    L11:
        OCardListItem r103 = (OCardListItem) ((LinkedHashMap) this.f340621j).get(VideoRecordSettingItem.DURATION);
        if (r103 == null) goto L14;
        r103.k(ca0().getVideoDurationTxtByDur(r100.f331755a), ba0(96));
    L14:
        Iterator<T> r104 = f340616k.iterator();
    L16:
        if (r104.hasNext() == false) goto L23;
        OCardListItem r105 = (OCardListItem) ((LinkedHashMap) this.f340621j).get((VideoRecordSettingItem) r104.next());
        if (r105 == null) goto L16;
        OTextView r106 = r105.getEndDetail();
        if (r106 == null) goto L22;
        Y90(r106);
    L22:
        W90(r105.getTailIconView());
        goto L16
    }

    public final FlowDoraVideoRecordConfig aa0() {
        a0 r100 = ca0().getMediaVideoRecordConfig().getValue();
        if ((r100 instanceof a0.a) == false) goto L5;
        a0.a r101 = (a0.a) r100;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.f334820a;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        return this.f340620i;
    }

    public final void W90(ImageView r100) {
        r100.setImageTintList(ContextCompat.getColorStateList(r100.getContext(), R.color.oui_basic_text_3b));
        r100.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 == null) goto L5;
        r101.width = ba0(20);
        r101.height = ba0(20);
    L6:
        r100.setLayoutParams(r101);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void Y90(OTextView r100) {
        r100.setTextColor(v19.c.a(R.attr.larus_neutral_50, requireContext(), R.color.larus_neutral_50));
        r100.setTextSize(2, 14.0f);
        Resources r101 = getResources();
        TextViewCompat.setLineHeight(r100, (int) TypedValue.applyDimension(2, 18.0f, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics())));
    }

    public final int ba0(int r100) {
        Resources r101 = getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public final String fa0(VideoRecordSettingItem r100) {
        int r101 = c.f340627a[r100.ordinal()];
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L15;
        if (r101 != 3) goto L10;
        return getString(R.string.larus_dora_g_device_record_duration_cn);
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return getString(R.string.larus_dora_g_device_video_proportion_cn);
    L13:
        return getString(R.string.larus_dora_g_device_video_resolution_cn);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        LinearLayout r112 = this.f340618g;
        if (r112 == null) goto L55;
        ((LinkedHashMap) this.f340621j).clear();
        r112.removeAllViews();
        if (ca0().isSupportVideoCfg() == false) goto L53;
        Iterator<T> r100 = f340616k.iterator();
        int r101 = 0;
    L9:
        if (r100.hasNext() == false) goto L54;
        Object r102 = r100.next();
        int r103 = r101 + 1;
        if (r101 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        final VideoRecordSettingItem r104 = (VideoRecordSettingItem) r102;
        int r105 = CollectionsKt.getLastIndex(f340616k);
        if (r105 != 0) goto L16;
        int r106 = 0;
    L21:
        final OCardListItem r107 = new OCardListItem(requireContext(), null, 6, 0);
        this.f340621j.put(r104, r107);
        r107.setCardType(0);
        OCardListItem.h(r107, r106);
        r107.setShowCardBg(true);
        r107.p(false);
        r107.setTitle(fa0(r104));
        r107.s(true);
        r107.q(false);
        r107.setDefaultCustomEndView(3);
        r107.m(true);
        r107.k("", ba0(96));
        OTextView r108 = r107.getEndDetail();
        if (r108 == null) goto L24;
        Y90(r108);
    L24:
        r107.setTailIcon(R.drawable.oic_chevron_up_down);
        W90(r107.getTailIconView());
        r107.r(true);
        r107.setOnContentClickListener(new com.larus.dora.obric.device_management.setting.g.video_record.a(r104, this, r107));
        ViewGroup.LayoutParams r109 = r107.getCardContainer().getLayoutParams();
        if ((r109 instanceof ViewGroup.MarginLayoutParams) == false) goto L27;
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r109;
    L28:
        if (r113 == null) goto L30;
        r113.setMarginStart(0);
        r113.setMarginEnd(0);
        r113.leftMargin = 0;
        r113.rightMargin = 0;
        r107.getCardContainer().setLayoutParams(r113);
    L30:
        FrameLayout r114 = r107.getCardContainer();
        int r115 = ba0(8);
        if (r106 == 0) goto L34;
        if (r106 == 1) goto L34;
        int r116 = 0;
    L35:
        int r117 = ba0(8);
        if (r106 == 0) goto L39;
        if (r106 == 3) goto L39;
        int r118 = 0;
    L40:
        r114.setPadding(r115, r116, r117, r118);
        r107.getContentContainer().setPadding(0, 0, ba0(4), 0);
        r107.getTitleContainer().setGravity(16);
        r107.getTitleContainer().setPadding(ba0(12), ba0(5), ba0(8), ba0(5));
        OTextView r119 = r107.getTitleView();
        r119.setGravity(GravityCompat.START);
        r119.setMaxLines(1);
        r119.setTextSize(2, 16.0f);
        Resources r120 = getResources();
        TextViewCompat.setLineHeight(r119, (int) TypedValue.applyDimension(2, 22.0f, WindowDisplayMetricsOverride.apply(r120, r120.getDisplayMetrics())));
        r119.setTypeface(Typeface.create(Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0), 400, false));
        r107.o(false);
        Drawable r121 = r107.getCardContainer().getBackground();
        if ((r121 instanceof GradientDrawable) == false) goto L43;
        GradientDrawable r122 = (GradientDrawable) r121;
    L44:
        if (r122 == null) goto L46;
        X90(r122, r106, 20);
    L46:
        Drawable r123 = r107.getContentContainer().getBackground();
        if ((r123 instanceof GradientDrawable) == false) goto L49;
        GradientDrawable r124 = (GradientDrawable) r123;
    L50:
        if (r124 == null) goto L52;
        X90(r124, r106, 12);
    L52:
        r112.addView(r107);
        r101 = r103;
        goto L9
    L49:
        r124 = null;
        goto L50
    L43:
        r122 = null;
    L39:
        r118 = ba0(8);
    L34:
        r116 = ba0(8);
        goto L35
    L27:
        r113 = null;
        goto L28
    L16:
        if (r101 != 0) goto L18;
        r106 = 1;
        goto L21
    L18:
        if (r101 != r105) goto L20;
        r106 = 3;
        goto L21
    L20:
        r106 = 2;
    L54:
        Z90();
        goto L55
    L53:
        g49.d.d("DoraObricGVideoRecordSettingsFragment", "video record config is not supported");
    L55:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGVideoRecordSettingsFragment$observeVideoRecordConfig$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, Lifecycle.State.STARTED, null, this), 3, null);
    }

    public final void X90(GradientDrawable r110, int r111, int r112) {
        float r113 = ba0(r112);
        if (r111 != 0) goto L5;
        float[] r114 = {r113, r113, r113, r113, r113, r113, r113, r113};
    L11:
        r110.setCornerRadii(r114);
        return;
    L5:
        if (r111 == 1) goto L9;
        if (r111 == 3) goto L8;
        r114 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        goto L11
    L8:
        r114 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, r113, r113, r113, r113};
        goto L11
    L9:
        r114 = new float[]{r113, r113, r113, r113, 0.0f, 0.0f, 0.0f, 0.0f};
        goto L11
    }

    public final void da0(String r100, String r101, final Function0<Unit> r102) {
        int r103 = j49.a.f497373a;
        j49.a.i();
        com.obric.oui.dialog.v2.alert.g r104 = new com.obric.oui.dialog.v2.alert.g(requireContext());
        r104.f400717c = true;
        r104.f400759w = false;
        r104.f400746j = false;
        r104.f400744h = r100;
        r104.f400745i = r101;
        com.obric.oui.dialog.v2.alert.g.c(r104);
        int r105 = j0.f375426a;
        r104.e(j0.d(R.string.larus_dora_dialog_btn_cancel_cn), new com.larus.dora.obric.device_management.setting.g.video_record.b());
        r104.h(j0.d(R.string.larus_dora_g_device_action_confirm_cn), new com.larus.dora.obric.device_management.setting.g.video_record.c(r102));
        com.obric.oui.dialog.v2.alert.c r106 = r104.a();
        if (DialogLancet.shouldBlockDialogShow(r106) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r106);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r106);
        r106.show();
        DialogLancet.afterDialogShow(r106);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        Context r113 = requireContext();
        OFloatingTitleBar r114 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        r114.setClipChildren(false);
        r114.setClipToPadding(false);
        r114.setBackgroundColor(v19.c.a(R.attr.larus_base_1_overlay, requireContext(), R.color.larus_base_1_overlay));
        r114.setCenterTitle(getString(R.string.larus_dora_g_device_video_setting_cn));
        r114.R(false);
        OFloatingTitleBar.k(r114, null, 6).setOnClickListener(new g(this));
        Context r115 = requireContext();
        LinearLayout r100 = new LinearLayout(r115);
        r100.setOrientation(1);
        r100.setClipChildren(false);
        r100.setClipToPadding(false);
        r100.setPadding(ba0(12), ba0(16), ba0(12), ba0(24));
        this.f340618g = r100;
        NestedScrollView r101 = new NestedScrollView(r115);
        r101.setClipChildren(true);
        r101.setClipToPadding(false);
        r101.setOverScrollMode(2);
        r101.setFillViewport(true);
        r101.addView(this.f340618g, new ViewGroup.LayoutParams(-1, -2));
        return com.larus.dora.obric.utils.c.c(r113, r114, r101, v19.c.a(R.attr.larus_base_1_overlay, requireContext(), R.color.larus_base_1_overlay), new d(this));
    }

    public final <T> void ea0(final OCardListItem r110, List<b<T>> r111, T r210, final Function1<? super T, Unit> r211) {
        FragmentActivity r100 = getActivity();
        if (r100 != null) goto L5;
        return;
    L5:
        com.obric.oui.popover.v2.c r101 = this.f340619h;
        if (r101 == null) goto L8;
        PopupWindowLancet.handleDismissBeforeOrigin(r101);
        r101.dismiss();
    L8:
        OPopoverEntranceMenuView.Builder r102 = new OPopoverEntranceMenuView.Builder(requireContext());
        r102.f(OPopoverEntranceMenuView.WidthLevel.WIDTH_LEVEL_BROAD);
        r102.f402287h = true;
        r102.f402284e = 1;
        Iterator<T> r112 = r111.iterator();
    L10:
        if (r112.hasNext() == false) goto L12;
        final b r103 = (b) r112.next();
        r102.c(0, 0, 0, r103.f340625b, r103.f340626c, false, true, Intrinsics.areEqual(r103.f340624a, r210), new j(this, r211, r103));
        goto L10
    L12:
        OPopoverEntranceMenuView r104 = r102.e();
        r104.setBackgroundColor(ContextCompat.getColor(r104.getContext(), android.R.color.transparent));
        com.obric.oui.popover.v2.c.a r105 = new com.obric.oui.popover.v2.c.a(r100);
        Intrinsics.checkNotNullParameter(r104, "view");
        r105.f402418f = r104;
        r105.f402414b = true;
        r105.f402421i = true;
        r105.f402423k = true;
        r105.f402422j = true;
        r105.f402426n = true;
        r105.f402424l = true;
        final com.obric.oui.popover.v2.c r106 = r105.a();
        this.f340619h = r106;
        r110.getTailIconView().post(new k(r106, r110));
    }
}
