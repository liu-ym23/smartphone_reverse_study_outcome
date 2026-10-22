package com.ss.android.lark.picker.base.view.binder;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.collection.SieveCacheKt;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.lark.pb.search.v2.ExplanationTag;
import com.bytedance.lark.pb.search.v2.ResultSourceType;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.larksuite.component.ui.tag.b;
import com.larksuite.component.ui.tag.f;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.larus.nova.R;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.PickerBaseModuleDependency;
import com.ss.android.lark.picker.base.utils.SearchCommonFgUtils;
import com.ss.android.lark.picker.base.utils.UiUtil;
import com.ss.android.lark.picker.base.view.ChatterChatViewHolder;
import com.ss.android.lark.picker.base.view.SearchResultView;
import com.ss.android.lark.picker.base.view.avatar.AvatarHelperKt;
import com.ss.android.lark.picker.base.view.avatar.ExternalTargetAvatarProviderStore;
import com.ss.android.lark.picker.base.view.avataritem.AvatarItemView;
import com.ss.android.lark.picker.base.view.binder.bridge.DefaultItemViewBridgeFactory;
import com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge;
import com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridgeFactory;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.e;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import uz7.a;
import v3c.c;
import v3c.g;
import y9c.d;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \\*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\\B!\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ%\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00028\u00002\u0006\u00109\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010:J\u001f\u0010;\u001a\u00020<2\u0006\u00108\u001a\u00028\u00002\b\u0010=\u001a\u0004\u0018\u00010>H\u0002¢\u0006\u0002\u0010?J\u001b\u0010@\u001a\u0002052\u0006\u00109\u001a\u00020A2\u0006\u00108\u001a\u00028\u0000¢\u0006\u0002\u0010BJ\u001b\u0010C\u001a\u0002052\u0006\u00109\u001a\u00020A2\u0006\u00108\u001a\u00028\u0000¢\u0006\u0002\u0010BJ\u001d\u0010D\u001a\u0002052\u0006\u00109\u001a\u00020A2\u0006\u00108\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010BJ\u001d\u0010E\u001a\u0002052\u0006\u00109\u001a\u00020A2\u0006\u00108\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010BJ%\u0010F\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00109\u001a\u00020A2\u0006\u00108\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010GJ\b\u0010H\u001a\u00020$H\u0016J%\u0010I\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00109\u001a\u00020A2\u0006\u00108\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010GJ\b\u0010J\u001a\u00020$H\u0016J\u0015\u0010K\u001a\u00020$2\u0006\u00108\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010LJ\u001b\u0010M\u001a\u0002052\u0006\u00108\u001a\u00028\u00002\u0006\u00109\u001a\u00020A¢\u0006\u0002\u0010NJ\u0013\u0010O\u001a\u00020$2\u0006\u00108\u001a\u00028\u0000¢\u0006\u0002\u0010LJ\u000e\u0010P\u001a\u0002052\u0006\u00102\u001a\u00020$J\u0006\u0010Q\u001a\u00020$J\u000e\u0010R\u001a\u0002052\u0006\u00103\u001a\u00020$J\u0006\u0010S\u001a\u00020$J\u0010\u0010T\u001a\u00020$2\u0006\u00108\u001a\u00020\u0002H\u0004J\u0016\u0010U\u001a\u0002052\u0006\u00109\u001a\u00020A2\u0006\u0010V\u001a\u00020WJ\u0015\u0010X\u001a\u00020$2\u0006\u00108\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010LJ\b\u0010Y\u001a\u000205H\u0016J\u000e\u0010Z\u001a\u0002052\u0006\u0010[\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001b\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b\u001e\u0010\u0017R\u001b\u0010 \u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0019\u001a\u0004\b!\u0010\u0017R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R$\u00100\u001a\u00020$2\u0006\u0010/\u001a\u00020$8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u0010%\"\u0004\b1\u0010'R\u000e\u00102\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/CommonBinder;", "D", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "Lcom/ss/android/lark/picker/base/view/binder/BaseViewBinder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mContext", "Landroid/content/Context;", "mOnItemClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "mItemViewBridgeFactory", "Lcom/ss/android/lark/picker/base/view/binder/bridge/IItemViewBridgeFactory;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;Lcom/ss/android/lark/picker/base/view/binder/bridge/IItemViewBridgeFactory;)V", "fgUtils", "Lcom/ss/android/lark/picker/base/utils/SearchCommonFgUtils;", "getFgUtils", "()Lcom/ss/android/lark/picker/base/utils/SearchCommonFgUtils;", "setFgUtils", "(Lcom/ss/android/lark/picker/base/utils/SearchCommonFgUtils;)V", "adapterClickHandler", "officialDocTag", "Lcom/larksuite/component/ui/tag/IconTag;", "getOfficialDocTag", "()Lcom/larksuite/component/ui/tag/IconTag;", "officialDocTag$delegate", "Lkotlin/Lazy;", "privateModeTag", "getPrivateModeTag", "privateModeTag$delegate", "secretTag", "getSecretTag", "secretTag$delegate", "onCallTag", "getOnCallTag", "onCallTag$delegate", "isBindTagWithDynamicTag", "", "()Z", "setBindTagWithDynamicTag", "(Z)V", "forceRefreshNotifyItemChangedOnUnconsumedClick", "getForceRefreshNotifyItemChangedOnUnconsumedClick", "setForceRefreshNotifyItemChangedOnUnconsumedClick", ChameleonOpenTracker.Stage.RENDER, "Lcom/ss/android/lark/search/dto/ISearchDynamicRender;", "getRender", "()Lcom/ss/android/lark/search/dto/ISearchDynamicRender;", "value", "isFold", "setFold", "disableRightViewHolder", "disableExtraInfoSummary", "bind", "", "position", "", "data", "holder", "(ILcom/ss/android/lark/search/dto/info/SearchBaseInfo;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "buildCheckBoxModel", "Lcom/ss/android/lark/search/dto/bindermodel/CheckBoxModel;", "businessCheckResult", "Lcom/ss/android/lark/picker/base/view/SearchResultView$CheckBoxBindStatus;", "(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;Lcom/ss/android/lark/picker/base/view/SearchResultView$CheckBoxBindStatus;)Lcom/ss/android/lark/search/dto/bindermodel/CheckBoxModel;", "bindDynamicTag", "Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;", "(Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;)V", "bindExtraInfoSummary", "bindAvatar", "bindBadge", "bindTag", "(ILcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;)V", "needBindDynamicTag", "bindOthers", "needBindSubTitle", "needBindSummary", "(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;)Z", "bindSingle", "(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;)V", "isExternal", "setDisableRightViewHolder", "isDisableRightViewHolder", "setDisableExtraInfoSummary", "isDisableExtraInfoSummary", "isChatPreviewDisabled", "avatarAttachRightView", "view", "Landroid/view/View;", "checkDisable", "onDisableClickHandler", "setAdapterClickHandler", "onItemClickHandler", "Companion", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CommonBinder<D extends SearchBaseInfo> extends BaseViewBinder<D, RecyclerView.ViewHolder> {
    public static final Companion Companion = null;
    private static final String TAG = "LarkSearch.Common.CommonBinder";
    private g adapterClickHandler;
    private boolean disableExtraInfoSummary;
    private boolean disableRightViewHolder;
    private SearchCommonFgUtils fgUtils;
    private boolean forceRefreshNotifyItemChangedOnUnconsumedClick;
    private boolean isBindTagWithDynamicTag;
    private final Context mContext;
    private final IItemViewBridgeFactory mItemViewBridgeFactory;
    private final g mOnItemClickHandler;
    private final Lazy officialDocTag$delegate;
    private final Lazy onCallTag$delegate;
    private final Lazy privateModeTag$delegate;
    private final c render;
    private final Lazy secretTag$delegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/CommonBinder$Companion;", "", "<init>", "()V", "TAG", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[ExplanationTag.TagStyle.values().length];
            r100[ExplanationTag.TagStyle.SHIELD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[ExplanationTag.TagStyle.CRYPTO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[ExplanationTag.TagStyle.HELP_DESK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[ExplanationTag.TagStyle.TEXT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[ExplanationTag.TagStyle.OFFICIAL_DOC.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            $EnumSwitchMapping$0 = r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public void bindOthers(int r100, ChatterChatViewHolder r101, D r102) {
        Intrinsics.checkNotNullParameter(r101, "holder");
        Intrinsics.checkNotNullParameter(r102, "data");
    }

    public void bindTag(int r100, ChatterChatViewHolder r101, D r102) {
        Intrinsics.checkNotNullParameter(r101, "holder");
        Intrinsics.checkNotNullParameter(r102, "data");
    }

    public boolean checkDisable(D r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return false;
    }

    public boolean needBindSubTitle() {
        return true;
    }

    public boolean needBindSummary(D r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return true;
    }

    public void onDisableClickHandler() {
    }

    private final b getOfficialDocTag() {
        return (b) this.officialDocTag$delegate.getValue();
    }

    private final b getOnCallTag() {
        return (b) this.onCallTag$delegate.getValue();
    }

    private final b getPrivateModeTag() {
        return (b) this.privateModeTag$delegate.getValue();
    }

    private final b getSecretTag() {
        return (b) this.secretTag$delegate.getValue();
    }

    public final boolean isFold() {
        return this.render.isFold();
    }

    public final SearchCommonFgUtils getFgUtils() {
        return this.fgUtils;
    }

    public final boolean getForceRefreshNotifyItemChangedOnUnconsumedClick() {
        return this.forceRefreshNotifyItemChangedOnUnconsumedClick;
    }

    public final c getRender() {
        return this.render;
    }

    public final boolean isBindTagWithDynamicTag() {
        return this.isBindTagWithDynamicTag;
    }

    public final boolean isDisableExtraInfoSummary() {
        return this.disableExtraInfoSummary;
    }

    public final boolean isDisableRightViewHolder() {
        return this.disableRightViewHolder;
    }

    public boolean needBindDynamicTag() {
        return this.isBindTagWithDynamicTag;
    }

    public static final /* synthetic */ g access$getAdapterClickHandler$p(CommonBinder r100) {
        return r100.adapterClickHandler;
    }

    public static final /* synthetic */ g access$getMOnItemClickHandler$p(CommonBinder r100) {
        return r100.mOnItemClickHandler;
    }

    public final boolean isChatPreviewDisabled(SearchBaseInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return ExternalTargetAvatarProviderStore.INSTANCE.requiresProvider(r100);
    }

    public final boolean isExternal(D r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (PickerBaseModuleDependency.getDependency().isCustomer() == false) goto L5;
    L9:
        return false;
    L5:
        if (PickerBaseModuleDependency.getDependency().isSimpleTenant() == true) goto L9;
        if (r100.isCrossTenant() == false) goto L9;
        return true;
    }

    public final void setAdapterClickHandler(g r100) {
        Intrinsics.checkNotNullParameter(r100, "onItemClickHandler");
        this.adapterClickHandler = r100;
    }

    public final void setBindTagWithDynamicTag(boolean r100) {
        this.isBindTagWithDynamicTag = r100;
    }

    public final void setDisableExtraInfoSummary(boolean r100) {
        this.disableExtraInfoSummary = r100;
    }

    public final void setDisableRightViewHolder(boolean r100) {
        this.disableRightViewHolder = r100;
    }

    public final void setFgUtils(SearchCommonFgUtils r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fgUtils = r100;
    }

    public final void setFold(boolean r100) {
        this.render.setFold(r100);
    }

    public final void setForceRefreshNotifyItemChangedOnUnconsumedClick(boolean r100) {
        this.forceRefreshNotifyItemChangedOnUnconsumedClick = r100;
    }

    private final void bindBadge(ChatterChatViewHolder r210, D r211) {
        int r100 = 0;
        if (r211.isShowBadge() == true) goto L5;
    L97:
        AvatarItemView r101 = r210.getAvatarItemView().getItem();
        vz7.b r102 = new vz7.b();
        r102.f557743i = false;
        r101.badge(r102);
        return;
    L5:
        if (r211.getNewMsgCount() <= 0) goto L97;
        AvatarItemView r103 = r210.getAvatarItemView().getItem();
        vz7.c r104 = new vz7.c(this.mContext);
        String r105 = String.valueOf(r211.getNewMsgCount());
        Intrinsics.checkNotNullParameter(r105, "text");
        r104.f557745b = r105;
        if (r211.isRemind() == false) goto L9;
        r104.f557746c = 1;
    L10:
        vz7.b r106 = new vz7.b();
        float r107 = j08.b.a(r104.f557744a, r104.f557750g);
        String r108 = r104.f557745b;
        r106.f557735a = r108;
        r106.f557736b = r107;
        int r109 = r108.length();
        if (r109 != 1) goto L13;
        char r110 = 3;
    L16:
        com.larksuite.component.ui.imageview.b r111 = new com.larksuite.component.ui.imageview.b();
        String r112 = r104.f557745b;
        if (Intrinsics.areEqual(r111.f284188b, r112) == true) goto L19;
        r111.f284189c = -1.0f;
        r111.f284188b = r112;
    L19:
        int r113 = e.f483540a;
        r111.f284187a.setTypeface(e.a(r104.f557744a));
        Context r114 = r104.f557744a;
        float r115 = r104.f557750g;
        Intrinsics.checkNotNullParameter(r114, PerfLog.PARAM_KEY_CONTEXT_ID);
        float r116 = j08.b.a(r114, 5.5f);
        float r117 = j08.b.a(r114, 2.0f);
        float r118 = j08.b.a(r114, 2.0f);
        float r119 = r115 / 12.0f;
        float r120 = j08.b.a(r114, r115);
        long r121 = r104.f557748e;
        if (SieveCacheKt.NodeMetaAndPreviousMask <= r121) goto L22;
    L24:
        boolean r212 = false;
    L26:
        if (r212 == false) goto L28;
        int r122 = (int) r121;
    L36:
        r106.f557739e = r122;
        long r123 = r104.f557749f;
        if (SieveCacheKt.NodeMetaAndPreviousMask <= r123) goto L39;
    L41:
        boolean r124 = false;
    L42:
        if (r124 == false) goto L44;
        int r125 = (int) r123;
    L55:
        if (r110 != 0) goto L64;
        boolean r126 = r104.f557747d;
        GradientDrawable r127 = new GradientDrawable();
        r127.setColor(r125);
        r127.setShape(0);
        if (r126 == false) goto L59;
        float r128 = r118 * r119;
    L60:
        r127.setStroke((int) r128, -1);
        r127.setCornerRadius(j08.b.a(r114, 10.0f) * r119);
        float r129 = 2;
        float r130 = r128 * r129;
        float r131 = (r116 * r119) * r129;
        r127.setSize((int) (((21.0f * r119) + r130) + r131), (int) (((16.0f * r119) + r130) + r131));
        Drawable r132 = AppCompatResources.getDrawable(r114, R.drawable.badge_etc);
        if (r132 == null) goto L63;
        r132.setTint(r122);
    L63:
        ScaleDrawable r133 = new ScaleDrawable(r132, 17, 1.0f, 1.0f);
        r133.setLevel((int) (10000 * r119));
        int r134 = (r127.getIntrinsicWidth() / 2) - (r133.getIntrinsicWidth() / 2);
        int r135 = (r127.getIntrinsicHeight() / 2) - (r133.getIntrinsicHeight() / 2);
        LayerDrawable r136 = new LayerDrawable(new Drawable[]{r127, r133});
        r136.setLayerInset(1, r134, r135, r134, r135);
        Drawable r137 = r136;
    L96:
        r106.f557740f = r137;
        r106.f557738d = 0.0f;
        r106.f557737c = 0.0f;
        r106.f557741g = 1;
        r103.badge(r106);
        return;
    L59:
        r128 = 0.0f;
        goto L60
    L64:
        boolean r138 = r104.f557747d;
        Intrinsics.checkNotNullParameter(r111, "helper");
        if (r111.f284187a.getTextSize() != r120) goto L67;
        boolean r139 = true;
    L68:
        if (r139 == true) goto L70;
        r111.f284187a.setTextSize(r120);
        r111.f284189c = -1.0f;
        r111.f284190d = -1.0f;
    L70:
        GradientDrawable r140 = new GradientDrawable();
        r140.setColor(r125);
        if (r110 != 1) goto L73;
    L75:
        r100 = 1;
    L76:
        r140.setShape(r100);
        if (r100 != 0) goto L79;
        r140.setCornerRadius(j08.b.a(r114, 10.0f) * r119);
    L79:
        if (r138 == false) goto L81;
        float r141 = 1.5f * r119;
    L82:
        r140.setStroke((int) j08.b.a(r114, r141), -1);
        if (r110 != 1) goto L87;
        r119 = r119 * 0.8f;
        if (Intrinsics.areEqual(r111.f284188b, "0") == true) goto L87;
        r111.f284189c = -1.0f;
        r111.f284188b = "0";
    L87:
        float r142 = r111.a();
        float r143 = r111.f284190d;
        if (r143 > 0.0f) goto L92;
        Paint.FontMetrics r144 = r111.f284187a.getFontMetrics();
        r143 = r144.descent - r144.ascent;
    L92:
        if (r100 != 1) goto L94;
        float r145 = 2;
        float r146 = Math.max(((r142 / r145) + (r116 * r119)) + r141, ((r143 / r145) + (r117 * r119)) + r141) * r145;
        float r147 = r146;
    L95:
        r140.setSize((int) r146, (int) r147);
        r137 = r140;
        goto L96
    L94:
        float r148 = 2;
        float r149 = r141 * r148;
        float r150 = (r142 + ((r116 * r119) * r148)) + r149;
        r147 = r149 + (r143 + ((r117 * r119) * r148));
        r146 = r150;
        goto L95
    L81:
        r141 = 0.0f;
        goto L82
    L73:
        if (r110 == 3) goto L75;
    L67:
        r139 = false;
        goto L68
    L44:
        Context r151 = r104.f557744a;
        int r152 = r104.f557746c;
        if (r152 == 0) goto L52;
        if (r152 != 1) goto L48;
        int r153 = ContextCompat.getColor(r151, R.color.lkui_R500);
    L53:
        r125 = r153;
        goto L55
    L48:
        if (r152 == 2) goto L50;
        r153 = ContextCompat.getColor(r151, R.color.lkui_N400);
        goto L53
    L50:
        r153 = ContextCompat.getColor(r151, R.color.lkui_R100);
        goto L53
    L52:
        r153 = ContextCompat.getColor(r151, R.color.lkui_N400);
        goto L53
    L39:
        if (r123 > SieveCacheKt.NodeLinkMask) goto L41;
        r124 = true;
        goto L42
    L28:
        int r154 = r104.f557746c;
        if (r154 == 0) goto L35;
        if (r154 == 1) goto L34;
        if (r154 == 2) goto L33;
        r122 = ContextCompat.getColor(r104.f557744a, R.color.lkui_N00);
        goto L36
    L33:
        r122 = ContextCompat.getColor(r104.f557744a, R.color.lkui_R500);
        goto L36
    L34:
        r122 = ContextCompat.getColor(r104.f557744a, R.color.lkui_N00);
        goto L36
    L35:
        r122 = ContextCompat.getColor(r104.f557744a, R.color.lkui_N00);
        goto L36
    L22:
        if (r121 > SieveCacheKt.NodeLinkMask) goto L24;
        r212 = true;
        goto L26
    L13:
        if (r109 <= 1) goto L15;
        r110 = 2;
        goto L16
    L15:
        r110 = 1;
        goto L16
    L9:
        r104.f557746c = 0;
        goto L10
    }

    private final w3c.b buildCheckBoxModel(D r100, SearchResultView.CheckBoxBindStatus r101) {
        w3c.b r102 = new w3c.b();
        r102.f558225c = isMultiple();
        if (checkDisable(r100) == false) goto L6;
        r102.f558224b = false;
    L13:
        return r102;
    L6:
        if (r100.isRequired() == false) goto L8;
        r102.f558223a = true;
        r102.f558224b = false;
        goto L13
    L8:
        if (r101 != null) goto L10;
    L12:
        r102.f558223a = r100.isSelected();
        r102.f558224b = true;
        goto L13
    L10:
        if (r101.isConsume() == false) goto L12;
        r102.f558223a = r101.isChecked();
        r102.f558224b = r101.isEnabled();
        goto L13
    }

    public final void avatarAttachRightView(ChatterChatViewHolder r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, "view");
        if (isDisableRightViewHolder() == false) goto L5;
        return;
    L5:
        AvatarItemView.attachRightView$default(r100.getAvatarItemView().getItem(), r101, false, false, 6, null);
    }

    public void bindAvatar(ChatterChatViewHolder r100, D r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, "data");
        if (AvatarHelperKt.bindExternalTargetAvatar(r100.getAvatarItemView().getItem().getAvatarView(), r101) == false) goto L5;
        return;
    L5:
        AvatarItemView r102 = r100.getAvatarItemView().getItem();
        a.C7948a r103 = new a.C7948a();
        r103.b(r101.getAvatarKey());
        r103.f(r101.getId());
        r102.avatar(new a(r103));
    }

    public final void bindDynamicTag(ChatterChatViewHolder r100, D r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, "data");
        LarkNameTag.c r102 = new LarkNameTag.c(this.mContext);
        List<ExplanationTag> r103 = r101.getExplanationTags();
        if (r103 == null) goto L41;
        Iterator<T> r104 = r103.iterator();
    L6:
        if (r104.hasNext() == false) goto L41;
        ExplanationTag r105 = (ExplanationTag) r104.next();
        ExplanationTag.TagStyle r106 = r105.tag_style;
        if (r106 == null) goto L9;
        int r107 = WhenMappings.$EnumSwitchMapping$0[r106.ordinal()];
        if (r107 != 1) goto L13;
        r102.c(getPrivateModeTag(), true);
        goto L6
    L13:
        if (r107 != 2) goto L15;
        r102.c(getSecretTag(), true);
        goto L6
    L15:
        if (r107 != 3) goto L17;
        r102.c(getOnCallTag(), true);
        goto L6
    L17:
        if (r107 != 4) goto L19;
        String r108 = r105.tag_type;
        if (r108 == null) goto L37;
        boolean r109 = false;
        if (r108.length() != 0) goto L27;
        boolean r110 = true;
    L28:
        if (r110 == true) goto L64;
        String r111 = r105.text;
        if (r111 == null) goto L65;
        if (r111.length() != 0) goto L34;
        r109 = true;
    L34:
        if (r109 == true) goto L66;
        int r112 = f.f284457g;
        f.a r113 = new f.a();
        UDTagsDrawable.TagColorSet r114 = UiUtil.Companion.getColorResByTagType(r105.tag_type);
        r113.f284465b = 50;
        r113.f284467d = r105.text;
        r113.f284468e = r114.getTextColorRes();
        r113.f284470g = r114.getBackgroundColorRes();
        r102.d(new f(r113), true);
        goto L6
    L66:
        return;
    L65:
        return;
    L64:
        return;
    L27:
        r110 = false;
        goto L28
    L37:
        return;
    L19:
        if (r107 != 5) goto L20;
        r102.b(getOfficialDocTag(), true);
        goto L6
    L20:
        return;
    L9:
        return;
    L41:
        r100.getAvatarItemView().getItem().setTag(r102);
    }

    public final void bindExtraInfoSummary(ChatterChatViewHolder r100, D r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, "data");
        if (r101.getExtraInfoSummary() != null) goto L5;
        return;
    L5:
        if (r101.getExtraInfoSummary().getExtraInfoList().isEmpty() == true) goto L10;
        r100.getAvatarItemView().getItem().setExtraInfoSummary(r101.getExtraInfoSummary(), r101.getType());
        return;
    }

    public final void bindSingle(D r100, ChatterChatViewHolder r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "holder");
        if (isSingleChoice(r100) == false) goto L6;
        ImageView r102 = new ImageView(this.mContext);
        r102.setPadding(0, 0, d.a(10), 0);
        r102.setImageDrawable(UDIconUtils.getIconDrawable(r102.getContext(), R.drawable.ud_icon_list_check_colorful, d.c(r102.getContext(), R.color.primary_fill_default)));
        AvatarItemView.attachRightView$default(r101.getAvatarItemView().getItem(), r102, false, false, 6, null);
        return;
    }

    public CommonBinder(Context r100, g r101, IItemViewBridgeFactory r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "mOnItemClickHandler");
        Intrinsics.checkNotNullParameter(r102, "mItemViewBridgeFactory");
        this.mContext = r100;
        this.mOnItemClickHandler = r101;
        this.mItemViewBridgeFactory = r102;
        this.fgUtils = new SearchCommonFgUtils();
        this.officialDocTag$delegate = LazyKt.lazy(CommonBinder$officialDocTag$2.INSTANCE);
        this.privateModeTag$delegate = LazyKt.lazy(new CommonBinder$privateModeTag$2(this));
        this.secretTag$delegate = LazyKt.lazy(new CommonBinder$secretTag$2(this));
        this.onCallTag$delegate = LazyKt.lazy(new CommonBinder$onCallTag$2(this));
        this.render = PickerBaseModuleDependency.getDependency().makeDynamicRender(r100);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.BaseViewBinder
    public void bind(final int r110, final D r111, final RecyclerView.ViewHolder r112) {
        Intrinsics.checkNotNullParameter(r111, "data");
        Intrinsics.checkNotNullParameter(r112, "holder");
        final IItemViewBridge r100 = this.mItemViewBridgeFactory.obtain(r112);
        if (r100 != null) goto L5;
        return;
    L5:
        r100.reset();
        if ((r112 instanceof ChatterChatViewHolder) == false) goto L37;
        ChatterChatViewHolder r101 = (ChatterChatViewHolder) r112;
        r101.getAvatarItemView().getItem().resetAllViews();
        bindAvatar(r101, r111);
        bindBadge(r101, r111);
        bindTitle(r111, r101, true);
        String r102 = r111.getRenderDSL();
        if (r102 != null) goto L10;
    L13:
        boolean r103 = true;
    L15:
        if (r103 == true) goto L23;
        if (needBindDynamicTag() == false) goto L23;
        Log.i(TAG, "render with renderDSL");
        View r104 = this.render.parseTemplate(r111.getRenderDSL(), r111.getRenderData(), r111.getId());
        if (r104 == null) goto L29;
        r101.getAvatarItemView().getItem().addViewToRender(r104);
    L29:
        if (r111.getSourceType() == ResultSourceType.LOCAL) goto L33;
        if (r111.getSourceType() == ResultSourceType.NET) goto L33;
    L35:
        bindTag(r110, r101, r111);
    L36:
        bindOthers(r110, r101, r111);
        bindSingle(r111, r101);
    L38:
        SearchResultView.IOnBusinessConsumeItem r105 = getMOnBusinessConsumeItem();
        if (r105 == null) goto L41;
        SearchResultView.CheckBoxBindStatus r106 = r105.onBusinessBindItemCheckBox(r111);
    L42:
        final w3c.b r107 = buildCheckBoxModel(r111, r106);
        if (r107.f558224b == false) goto L45;
        r100.showMask(false);
    L46:
        r100.checkState(r107);
        r100.setOnItemClickListener(new CommonBinder$bind$clickListener$1(this, r111, r100, r107, r112, r110));
        return;
    L45:
        r100.showMask(true);
        int r108 = DesktopUtil.f420394a;
        goto L46
    L41:
        r106 = null;
    L33:
        if (needBindDynamicTag() == false) goto L35;
        Log.i(TAG, "bindTag with dynamic tag");
        bindDynamicTag(r101, r111);
    L23:
        if (needBindSubTitle() == false) goto L26;
        bindSubTitle(r111, r101);
    L26:
        if (needBindSummary(r111) == false) goto L29;
        bindSummary(r111, r101);
        goto L29
    L10:
        if (StringsKt.isBlank(r102) == true) goto L13;
        r103 = false;
        goto L15
    L37:
        r100.bindData(r111);
        goto L38
    }

    public /* synthetic */ CommonBinder(Context r100, g r101, IItemViewBridgeFactory r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = new DefaultItemViewBridgeFactory();
    L5:
        this(r100, r101, r102);
    }
}
