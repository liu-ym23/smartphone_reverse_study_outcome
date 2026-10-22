package com.bytedance.android.shopping.mall.homepage.card.common;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.view.ECPredictHeightLayout;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.common.homepage.card.BigFontAdapter;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$CommonColorStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$CusTextStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$LayoutStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$ModuleDesc;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$Product;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$User;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ProductStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.TextBaseUIParams;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.mall.homepage.card.live.AdTagView;
import com.bytedance.android.shopping.mall.homepage.card.live.LiveCardModel;
import com.bytedance.android.shopping.mall.homepage.card.product.ProductTextView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.forest.utils.h;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import yj.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001#B\u0013\b\u0016\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cB\u001d\b\u0016\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001b\u0010\u001fB%\b\u0016\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\u001b\u0010\"J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bR\u001b\u0010\u000f\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u00108\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0018\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u0014¨\u0006$"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/common/BottomInfoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "hexColor", "", "setHotIconViewColorAndAlpha", "themeColor", "setContainerColor", "", "scale", "setViewScaleSize", "f", "Lkotlin/Lazy;", "getNameSize", "()F", "nameSize", "Landroid/widget/TextView;", "h", "Landroid/widget/TextView;", "getNameView", "()Landroid/widget/TextView;", "nameView", "i", "getRecReasonView", "recReasonView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BottomInfoView extends ConstraintLayout {
    public static final /* synthetic */ int p = 0;
    public CommonModel$ModuleDesc a;
    public CommonModel$ModuleDesc b;
    public CommonModel$ModuleDesc c;
    public CommonModel$LayoutStyle d;
    public float e;
    public final Lazy f;
    public final SimpleDraweeView g;
    public final TextView h;
    public final Lazy i;
    public final SimpleDraweeView j;
    public final SimpleDraweeView k;
    public final TextView l;
    public final HotTextContainerView m;
    public final ReturnRewardBtn n;
    public final AdTagView o;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006 "}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/common/BottomInfoView$Companion$ElementStyle;", "", "avatarDesc", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$ModuleDesc;", "hotDesc", "hotIcon", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;", "returnRewardDesc", "coinIconLayout", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$ModuleDesc;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$ModuleDesc;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$ModuleDesc;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;)V", "getAvatarDesc", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$ModuleDesc;", "getCoinIconLayout", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;", "getHotDesc", "getHotIcon", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;", "getReturnRewardDesc", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class ElementStyle {
            private final CommonModel$ModuleDesc avatarDesc;
            private final CommonModel$LayoutStyle coinIconLayout;
            private final CommonModel$ModuleDesc hotDesc;
            private final CommonModel$CommonColorStyle hotIcon;
            private final CommonModel$ModuleDesc returnRewardDesc;

            public ElementStyle() {
                this(null, null, null, null, null, 31, null);
            }

            public static /* synthetic */ ElementStyle copy$default(ElementStyle r3, CommonModel$ModuleDesc r4, CommonModel$ModuleDesc r5, CommonModel$CommonColorStyle r6, CommonModel$ModuleDesc r7, CommonModel$LayoutStyle r8, int r9, Object r10) {
                if ((r9 & 1) == 0) goto L6;
                r4 = r3.avatarDesc;
            L6:
                if ((r9 & 2) == 0) goto L8;
                r5 = r3.hotDesc;
            L8:
                CommonModel$ModuleDesc r11 = r5;
                if ((r9 & 4) == 0) goto L11;
                r6 = r3.hotIcon;
            L11:
                CommonModel$CommonColorStyle r0 = r6;
                if ((r9 & 8) == 0) goto L14;
                r7 = r3.returnRewardDesc;
            L14:
                CommonModel$ModuleDesc r1 = r7;
                if ((r9 & 16) == 0) goto L17;
                r8 = r3.coinIconLayout;
            L17:
                CommonModel$ModuleDesc r12 = r4;
                return r3.copy(r12, r11, r0, r1, r8);
            }

            public final CommonModel$ModuleDesc component1() {
                return this.avatarDesc;
            }

            public final CommonModel$ModuleDesc component2() {
                return this.hotDesc;
            }

            public final CommonModel$CommonColorStyle component3() {
                return this.hotIcon;
            }

            public final CommonModel$ModuleDesc component4() {
                return this.returnRewardDesc;
            }

            public final CommonModel$LayoutStyle component5() {
                return this.coinIconLayout;
            }

            public final ElementStyle copy(CommonModel$ModuleDesc r8, CommonModel$ModuleDesc r9, CommonModel$CommonColorStyle r10, CommonModel$ModuleDesc r11, CommonModel$LayoutStyle r12) {
                return new ElementStyle(r8, r9, r10, r11, r12);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof ElementStyle) == false) goto L16;
                ElementStyle r4 = (ElementStyle) r3;
                if (Intrinsics.areEqual(this.avatarDesc, r4.avatarDesc) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.hotDesc, r4.hotDesc) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.hotIcon, r4.hotIcon) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.returnRewardDesc, r4.returnRewardDesc) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.coinIconLayout, r4.coinIconLayout) == true) goto L25;
                return false;
            L25:
                return true;
            L16:
                return false;
            }

            public int hashCode() {
                CommonModel$ModuleDesc r0 = this.avatarDesc;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                CommonModel$ModuleDesc r4 = this.hotDesc;
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                int r6 = (r3 + r5) * 31;
                CommonModel$CommonColorStyle r7 = this.hotIcon;
                if (r7 == null) goto L13;
                int r8 = r7.hashCode();
            L14:
                int r9 = (r6 + r8) * 31;
                CommonModel$ModuleDesc r10 = this.returnRewardDesc;
                if (r10 == null) goto L17;
                int r11 = r10.hashCode();
            L18:
                int r12 = (r9 + r11) * 31;
                CommonModel$LayoutStyle r13 = this.coinIconLayout;
                if (r13 == null) goto L22;
                r1 = r13.hashCode();
            L22:
                return r12 + r1;
            L17:
                r11 = 0;
                goto L18
            L13:
                r8 = 0;
                goto L14
            L9:
                r5 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            public String toString() {
                return "ElementStyle(avatarDesc=" + this.avatarDesc + ", hotDesc=" + this.hotDesc + ", hotIcon=" + this.hotIcon + ", returnRewardDesc=" + this.returnRewardDesc + ", coinIconLayout=" + this.coinIconLayout + ")";
            }

            public final CommonModel$ModuleDesc getAvatarDesc() {
                return this.avatarDesc;
            }

            public final CommonModel$LayoutStyle getCoinIconLayout() {
                return this.coinIconLayout;
            }

            public final CommonModel$ModuleDesc getHotDesc() {
                return this.hotDesc;
            }

            public final CommonModel$CommonColorStyle getHotIcon() {
                return this.hotIcon;
            }

            public final CommonModel$ModuleDesc getReturnRewardDesc() {
                return this.returnRewardDesc;
            }

            public ElementStyle(CommonModel$ModuleDesc r1, CommonModel$ModuleDesc r2, CommonModel$CommonColorStyle r3, CommonModel$ModuleDesc r4, CommonModel$LayoutStyle r5) {
                this.avatarDesc = r1;
                this.hotDesc = r2;
                this.hotIcon = r3;
                this.returnRewardDesc = r4;
                this.coinIconLayout = r5;
            }

            public /* synthetic */ ElementStyle(CommonModel$ModuleDesc r5, CommonModel$ModuleDesc r6, CommonModel$CommonColorStyle r7, CommonModel$ModuleDesc r8, CommonModel$LayoutStyle r9, int r10, DefaultConstructorMarker r11) {
                if ((r10 & 1) == 0) goto L5;
                CommonModel$ModuleDesc r12 = null;
            L7:
                if ((r10 & 2) == 0) goto L9;
                CommonModel$ModuleDesc r1 = null;
            L11:
                if ((r10 & 4) == 0) goto L13;
                CommonModel$CommonColorStyle r2 = null;
            L15:
                if ((r10 & 8) == 0) goto L17;
                CommonModel$ModuleDesc r3 = null;
            L19:
                if ((r10 & 16) == 0) goto L21;
                CommonModel$LayoutStyle r13 = null;
            L22:
                this(r12, r1, r2, r3, r13);
                return;
            L21:
                r13 = r9;
                goto L22
            L17:
                r3 = r8;
                goto L19
            L13:
                r2 = r7;
                goto L15
            L9:
                r1 = r6;
                goto L11
            L5:
                r12 = r5;
                goto L7
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/common/BottomInfoView$Companion$Experiment;", "", "enlargeCover", "", "enableDarkModel", "coinLabelStyle", "", "showPeopleNewIcon", "(ZZIZ)V", "getCoinLabelStyle", "()I", "getEnableDarkModel", "()Z", "getEnlargeCover", "getShowPeopleNewIcon", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Experiment {
            private final int coinLabelStyle;
            private final boolean enableDarkModel;
            private final boolean enlargeCover;
            private final boolean showPeopleNewIcon;

            public Experiment() {
                this(false, false, 0, false, 15, null);
            }

            public static /* synthetic */ Experiment copy$default(Experiment r0, boolean r1, boolean r2, int r3, boolean r4, int r5, Object r6) {
                if ((r5 & 1) == 0) goto L6;
                r1 = r0.enlargeCover;
            L6:
                if ((r5 & 2) == 0) goto L9;
                r2 = r0.enableDarkModel;
            L9:
                if ((r5 & 4) == 0) goto L12;
                r3 = r0.coinLabelStyle;
            L12:
                if ((r5 & 8) == 0) goto L15;
                r4 = r0.showPeopleNewIcon;
            L15:
                return r0.copy(r1, r2, r3, r4);
            }

            public final boolean component1() {
                return this.enlargeCover;
            }

            public final boolean component2() {
                return this.enableDarkModel;
            }

            public final int component3() {
                return this.coinLabelStyle;
            }

            public final boolean component4() {
                return this.showPeopleNewIcon;
            }

            public final Experiment copy(boolean r2, boolean r3, int r4, boolean r5) {
                return new Experiment(r2, r3, r4, r5);
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof Experiment) == false) goto L14;
                Experiment r4 = (Experiment) r3;
                if (this.enlargeCover == r4.enlargeCover) goto L8;
                return false;
            L8:
                if (this.enableDarkModel == r4.enableDarkModel) goto L10;
                return false;
            L10:
                if (this.coinLabelStyle == r4.coinLabelStyle) goto L12;
                return false;
            L12:
                if (this.showPeopleNewIcon == r4.showPeopleNewIcon) goto L22;
                return false;
            L22:
                return true;
            L14:
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v3, types: [int] */
            /* JADX WARN: Type inference failed for: r0v7, types: [int] */
            /* JADX WARN: Type inference failed for: r0v8 */
            /* JADX WARN: Type inference failed for: r0v9 */
            /* JADX WARN: Type inference failed for: r1v0 */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v4 */
            /* JADX WARN: Type inference failed for: r2v5 */
            public int hashCode() {
                boolean r0 = this.enlargeCover;
                ?? r1 = 1;
                ?? r2 = r0;
                if (r0 == false) goto L5;
                r2 = 1;
            L5:
                int r3 = r2 * 31;
                boolean r4 = this.enableDarkModel;
                ?? r5 = r4;
                if (r4 == false) goto L8;
                r5 = 1;
            L8:
                int r6 = (((r3 + r5) * 31) + this.coinLabelStyle) * 31;
                boolean r7 = this.showPeopleNewIcon;
                if (r7 == true) goto L13;
                r1 = r7;
            L13:
                return r6 + r1;
            }

            public String toString() {
                return "Experiment(enlargeCover=" + this.enlargeCover + ", enableDarkModel=" + this.enableDarkModel + ", coinLabelStyle=" + this.coinLabelStyle + ", showPeopleNewIcon=" + this.showPeopleNewIcon + ")";
            }

            public final int getCoinLabelStyle() {
                return this.coinLabelStyle;
            }

            public final boolean getEnableDarkModel() {
                return this.enableDarkModel;
            }

            public final boolean getEnlargeCover() {
                return this.enlargeCover;
            }

            public final boolean getShowPeopleNewIcon() {
                return this.showPeopleNewIcon;
            }

            public Experiment(boolean r1, boolean r2, int r3, boolean r4) {
                this.enlargeCover = r1;
                this.enableDarkModel = r2;
                this.coinLabelStyle = r3;
                this.showPeopleNewIcon = r4;
            }

            public /* synthetic */ Experiment(boolean r2, boolean r3, int r4, boolean r5, int r6, DefaultConstructorMarker r7) {
                if ((r6 & 1) == 0) goto L6;
                r2 = false;
            L6:
                if ((r6 & 2) == 0) goto L9;
                r3 = false;
            L9:
                if ((r6 & 4) == 0) goto L12;
                r4 = 0;
            L12:
                if ((r6 & 8) == 0) goto L14;
                r5 = false;
            L14:
                this(r2, r3, r4, r5);
            }
        }
    }

    static {
    }

    private final float getNameSize() {
        return ((Number) this.f.getValue()).floatValue();
    }

    private final TextView getRecReasonView() {
        return (TextView) this.i.getValue();
    }

    public void R5() {
        Lazy r0 = HybridAppInfoService.a;
        if (HybridAppInfoService.i() == false) goto L5;
        this.h.setTextColor(ColorProtector.parseColor("#333333"));
        setHotIconViewColorAndAlpha("#73161823");
        this.l.setTextColor(ColorProtector.parseColor("#73161823"));
        this.m.a("#99161823");
        return;
    L5:
        this.h.setTextColor(ColorProtector.parseColor("#3E3E3E"));
        setHotIconViewColorAndAlpha("#57161823");
        this.l.setTextColor(ColorProtector.parseColor("#57161823"));
        this.m.a("#57161823");
    }

    public final void T5() {
        Lazy r0 = BigFontAdapter.a;
        BigFontAdapter.e(this.g, 6);
        BigFontAdapter.d(this.h);
        BigFontAdapter.e(this.j, 6);
        BigFontAdapter.d(this.l);
        ReturnRewardBtn r1 = this.n;
        r1.getClass();
        BigFontAdapter.d(r1.c);
    }

    public final TextView getNameView() {
        return this.h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2, types: [android.view.View, android.widget.LinearLayout, com.bytedance.android.shopping.api.mall.common.homepage.card.common.ECRoundedLinearLayout, com.bytedance.android.shopping.mall.homepage.card.common.ReturnRewardBtn] */
    /* JADX WARN: Type inference failed for: r8v4, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.mall.homepage.card.live.AdTagView] */
    public BottomInfoView(Context r15) {
        super(r15);
        this.e = 1.0f;
        this.f = LazyKt.lazy(BottomInfoView$nameSize$2.INSTANCE);
        SimpleDraweeView r16 = new SimpleDraweeView(getContext());
        r16.setId(ViewCompat.generateViewId());
        RoundingParams r0 = RoundingParams.fromCornersRadius(5.0f);
        r0.setRoundAsCircle(true);
        r16.getHierarchy().setRoundingParams(r0);
        r16.getHierarchy().setOverlayImage(new ColorDrawable(ColorProtector.parseColor("#0D000000")));
        Unit r1 = Unit.INSTANCE;
        this.g = r16;
        TextView r2 = new TextView(getContext());
        r2.setId(ViewCompat.generateViewId());
        ToolsKt.b(r2);
        r2.setIncludeFontPadding(false);
        r2.setMaxLines(1);
        r2.setTextSize(1, getNameSize());
        r2.setGravity(8388611);
        this.h = r2;
        this.i = LazyKt.lazy(new BottomInfoView$recReasonView$2(this));
        SimpleDraweeView r3 = new SimpleDraweeView(getContext());
        r3.setId(ViewCompat.generateViewId());
        r3.setImageResource(2131248023);
        this.j = r3;
        SimpleDraweeView r4 = new SimpleDraweeView(getContext());
        r4.setId(ViewCompat.generateViewId());
        this.k = r4;
        TextView r5 = new TextView(getContext());
        r5.setId(ViewCompat.generateViewId());
        r5.setTextSize(1, 11.0f);
        this.l = r5;
        HotTextContainerView r6 = new HotTextContainerView(getContext(), null, 6, 0);
        r6.setId(ViewCompat.generateViewId());
        this.m = r6;
        ?? r7 = new ReturnRewardBtn(getContext(), null);
        r7.setId(ViewCompat.generateViewId());
        r7.setRadius(UIUtils.dip2Px(r7.getContext(), 4.0f));
        this.n = r7;
        ?? r8 = new AdTagView(getContext());
        r8.setId(ViewCompat.generateViewId());
        r8.setVisibility(8);
        this.o = r8;
        ConstraintLayout.LayoutParams r11 = new ConstraintLayout.LayoutParams(0, b0.c(26));
        r11.leftToLeft = 0;
        r11.rightToRight = 0;
        ((ViewGroup.MarginLayoutParams) r11).topMargin = b0.c(8);
        r11.topToBottom = r16.getId();
        addView(r7, r11);
        ConstraintLayout.LayoutParams r9 = new ConstraintLayout.LayoutParams(b0.c(16), b0.c(16));
        r9.leftToLeft = 0;
        r9.topToTop = 0;
        r9.rightToLeft = r2.getId();
        ((ViewGroup.MarginLayoutParams) r9).rightMargin = b0.c(4);
        addView(r16, r9);
        ConstraintLayout.LayoutParams r10 = new ConstraintLayout.LayoutParams(-2, -2);
        r10.topToTop = r16.getId();
        r10.bottomToBottom = r16.getId();
        r10.rightToRight = 0;
        ((ViewGroup.MarginLayoutParams) r10).topMargin = b0.c(1);
        addView(r6, r10);
        ConstraintLayout.LayoutParams r12 = new ConstraintLayout.LayoutParams(-2, -2);
        r12.topToTop = r16.getId();
        r12.bottomToBottom = r16.getId();
        r12.rightToRight = 0;
        addView(r5, r12);
        ConstraintLayout.LayoutParams r13 = new ConstraintLayout.LayoutParams(b0.c(12), b0.c(12));
        r13.topToTop = r16.getId();
        r13.bottomToBottom = r16.getId();
        r13.rightToLeft = r6.getId();
        r13.leftToRight = r8.getId();
        ((ViewGroup.MarginLayoutParams) r13).rightMargin = b0.c(3);
        ((ViewGroup.MarginLayoutParams) r13).leftMargin = b0.c(6);
        b0.e(this);
        addView(r4, r13);
        ConstraintLayout.LayoutParams r14 = new ConstraintLayout.LayoutParams(b0.c(12), b0.c(12));
        r14.topToTop = r16.getId();
        r14.bottomToBottom = r16.getId();
        r14.rightToLeft = r5.getId();
        ((ViewGroup.MarginLayoutParams) r14).rightMargin = b0.c(3);
        r14.leftToRight = r8.getId();
        ((ViewGroup.MarginLayoutParams) r14).leftMargin = b0.c(4);
        b0.e(this);
        addView(r3, r14);
        ConstraintLayout.LayoutParams r17 = new ConstraintLayout.LayoutParams(-2, -2);
        r17.topToTop = r16.getId();
        r17.bottomToBottom = r16.getId();
        r17.rightToLeft = r3.getId();
        r17.leftToRight = r2.getId();
        ((ViewGroup.MarginLayoutParams) r17).leftMargin = b0.c(4);
        addView(r8, r17);
        ConstraintLayout.LayoutParams r18 = new ConstraintLayout.LayoutParams(0, -2);
        r18.leftToRight = r16.getId();
        r18.topToTop = r16.getId();
        r18.bottomToBottom = r16.getId();
        r18.rightToLeft = r8.getId();
        addView(r2, r18);
        TextView r19 = getRecReasonView();
        ConstraintLayout.LayoutParams r20 = new ConstraintLayout.LayoutParams(-2, -2);
        r20.topToTop = r16.getId();
        r20.bottomToBottom = r16.getId();
        r20.rightToRight = 0;
        addView(r19, r20);
    }

    public static Pair S5(String r3) {
        if (r3 == null) goto L6;
        String r0 = r3.substring(1, 3);
        return new Pair(Integer.valueOf(ColorProtector.parseColor("#" + r3.substring(3))), Float.valueOf(CastIntegerProtector.parseInt(r0, CharsKt.checkRadix(16)) / 255.0f));
    L6:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    private final void setHotIconViewColorAndAlpha(String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (StringsKt.startsWith$default(r5, "#", false, 2, null) == false) goto L19;
    L11:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        return;
    L7:
        if (r5.length() != 9) goto L9;
        Pair r6 = S5(r5);     // Catch: Exception -> L11
        this.j.setColorFilter(((Number) r6.getFirst()).intValue());     // Catch: Exception -> L11
        this.j.setAlpha(((Number) r6.getSecond()).floatValue());     // Catch: Exception -> L11
    L14:
        return;
    L9:
        this.j.setColorFilter(Color.parseColor(r5));     // Catch: Exception -> L11
        this.j.setAlpha(1.0f);     // Catch: Exception -> L11
        goto L14
    }

    public final void V5(boolean r2) {
        if (r2 == false) goto L10;
        ViewGroup.LayoutParams r3 = this.o.getLayoutParams();
        if ((r3 instanceof ConstraintLayout.LayoutParams) == true) goto L6;
        r3 = null;
    L6:
        ConstraintLayout.LayoutParams r4 = (ConstraintLayout.LayoutParams) r3;
        if (r4 == null) goto L9;
        r4.rightToLeft = this.j.getId();
    L9:
        b0.e(this.k);
        b0.e(this.m);
        this.j.setVisibility(0);
        this.l.setVisibility(0);
        return;
    L10:
        this.j.setVisibility(8);
        this.l.setVisibility(8);
    }

    public final void Y5(boolean r2) {
        if (r2 == false) goto L10;
        b0.n(this.k);
        b0.n(this.m);
        ViewGroup.LayoutParams r3 = this.o.getLayoutParams();
        if ((r3 instanceof ConstraintLayout.LayoutParams) == true) goto L6;
        r3 = null;
    L6:
        ConstraintLayout.LayoutParams r4 = (ConstraintLayout.LayoutParams) r3;
        if (r4 == null) goto L9;
        r4.rightToLeft = this.k.getId();
    L9:
        b0.e(this.j);
        b0.e(this.l);
        return;
    L10:
        b0.e(this.k);
        b0.e(this.m);
    }

    public final void setContainerColor(String r2) {
        Intrinsics.checkNotNullParameter(r2, "themeColor");
        this.n.setRewardLayoutBackground(r2);
    }

    public final void setViewScaleSize(float r18) {
        this.e = r18;
        SimpleDraweeView r1 = this.g;
        CommonModel$ModuleDesc r2 = this.a;
        if (r2 == null) goto L5;
        CommonModel$LayoutStyle r3 = r2.getLayoutStyle();
    L6:
        ToolsKt.A(r1, r18, r3, Integer.valueOf(b0.c(16)), Integer.valueOf(b0.c(16)), null, null, Integer.valueOf(b0.c(4)), null, false, null, 944);
        TextView r4 = this.h;
        CommonModel$ModuleDesc r5 = this.a;
        if (r5 == null) goto L12;
        CommonModel$CusTextStyle r6 = r5.getTextStyle();
        if (r6 == null) goto L12;
        Number r7 = r6.getFontSize();
        if (r7 == null) goto L12;
    L13:
        r4.setTextSize(1, r7.intValue() * r18);
        SimpleDraweeView r8 = this.j;
        CommonModel$ModuleDesc r9 = this.b;
        if (r9 == null) goto L16;
        CommonModel$LayoutStyle r10 = r9.getLayoutStyle();
    L17:
        ToolsKt.A(r8, r18, r10, Integer.valueOf(b0.c(12)), Integer.valueOf(b0.c(12)), Integer.valueOf(b0.c(4)), null, Integer.valueOf(b0.c(3)), null, false, null, 928);
        TextView r11 = this.l;
        CommonModel$ModuleDesc r12 = this.b;
        if (r12 == null) goto L24;
        CommonModel$CusTextStyle r13 = r12.getTextStyle();
        if (r13 == null) goto L24;
        Integer r14 = r13.getFontSize();
        if (r14 == null) goto L24;
        int r15 = r14.intValue();
    L25:
        r11.setTextSize(1, r15 * r18);
        ECPredictHeightLayout r16 = this.n;
        CommonModel$ModuleDesc r17 = this.c;
        if (r17 == null) goto L28;
        CommonModel$LayoutStyle r19 = r17.getLayoutStyle();
    L29:
        ToolsKt.A(r16, r18, r19, null, Integer.valueOf(b0.c(26)), null, Integer.valueOf(b0.c(8)), null, null, false, null, 980);
        HotTextContainerView r20 = this.m;
        r20.a.setTextSize(1, 10 * r18);
        r20.b.setTextSize(1, 8 * r18);
        r20.c.setTextSize(1, 11 * r18);
        CommonModel$ModuleDesc r21 = this.c;
        if (r21 == null) goto L36;
        CommonModel$LayoutStyle r22 = r21.getLayoutStyle();
        if (r22 == null) goto L36;
        Double r23 = r22.getRadius();
        if (r23 == null) goto L36;
        float r24 = (float) r23.doubleValue();
    L37:
        this.n.setRadius(b0.c(Float.valueOf(r24)) * r18);
        this.n.setViewScale(r18);
        return;
    L36:
        r24 = 4.0f;
        goto L37
    L28:
        r19 = null;
    L24:
        r15 = 11;
        goto L25
    L16:
        r10 = null;
    L12:
        r7 = Float.valueOf(getNameSize());
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.view.View, android.widget.LinearLayout, com.bytedance.android.shopping.api.mall.common.homepage.card.common.ECRoundedLinearLayout, com.bytedance.android.shopping.mall.homepage.card.common.ReturnRewardBtn] */
    /* JADX WARN: Type inference failed for: r7v4, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.mall.homepage.card.live.AdTagView] */
    public BottomInfoView(Context r14, AttributeSet r15) {
        super(r14, r15);
        this.e = 1.0f;
        this.f = LazyKt.lazy(BottomInfoView$nameSize$2.INSTANCE);
        SimpleDraweeView r16 = new SimpleDraweeView(getContext());
        r16.setId(ViewCompat.generateViewId());
        RoundingParams r17 = RoundingParams.fromCornersRadius(5.0f);
        r17.setRoundAsCircle(true);
        r16.getHierarchy().setRoundingParams(r17);
        r16.getHierarchy().setOverlayImage(new ColorDrawable(ColorProtector.parseColor("#0D000000")));
        Unit r18 = Unit.INSTANCE;
        this.g = r16;
        TextView r19 = new TextView(getContext());
        r19.setId(ViewCompat.generateViewId());
        ToolsKt.b(r19);
        r19.setIncludeFontPadding(false);
        r19.setMaxLines(1);
        r19.setTextSize(1, getNameSize());
        r19.setGravity(8388611);
        this.h = r19;
        this.i = LazyKt.lazy(new BottomInfoView$recReasonView$2(this));
        SimpleDraweeView r2 = new SimpleDraweeView(getContext());
        r2.setId(ViewCompat.generateViewId());
        r2.setImageResource(2131248023);
        this.j = r2;
        SimpleDraweeView r3 = new SimpleDraweeView(getContext());
        r3.setId(ViewCompat.generateViewId());
        this.k = r3;
        TextView r4 = new TextView(getContext());
        r4.setId(ViewCompat.generateViewId());
        r4.setTextSize(1, 11.0f);
        this.l = r4;
        HotTextContainerView r5 = new HotTextContainerView(getContext(), null, 6, 0);
        r5.setId(ViewCompat.generateViewId());
        this.m = r5;
        ?? r6 = new ReturnRewardBtn(getContext(), null);
        r6.setId(ViewCompat.generateViewId());
        r6.setRadius(UIUtils.dip2Px(r6.getContext(), 4.0f));
        this.n = r6;
        ?? r7 = new AdTagView(getContext());
        r7.setId(ViewCompat.generateViewId());
        r7.setVisibility(8);
        this.o = r7;
        ConstraintLayout.LayoutParams r10 = new ConstraintLayout.LayoutParams(0, b0.c(26));
        r10.leftToLeft = 0;
        r10.rightToRight = 0;
        ((ViewGroup.MarginLayoutParams) r10).topMargin = b0.c(8);
        r10.topToBottom = r16.getId();
        addView(r6, r10);
        ConstraintLayout.LayoutParams r8 = new ConstraintLayout.LayoutParams(b0.c(16), b0.c(16));
        r8.leftToLeft = 0;
        r8.topToTop = 0;
        r8.rightToLeft = r19.getId();
        ((ViewGroup.MarginLayoutParams) r8).rightMargin = b0.c(4);
        addView(r16, r8);
        ConstraintLayout.LayoutParams r9 = new ConstraintLayout.LayoutParams(-2, -2);
        r9.topToTop = r16.getId();
        r9.bottomToBottom = r16.getId();
        r9.rightToRight = 0;
        ((ViewGroup.MarginLayoutParams) r9).topMargin = b0.c(1);
        addView(r5, r9);
        ConstraintLayout.LayoutParams r0 = new ConstraintLayout.LayoutParams(-2, -2);
        r0.topToTop = r16.getId();
        r0.bottomToBottom = r16.getId();
        r0.rightToRight = 0;
        addView(r4, r0);
        ConstraintLayout.LayoutParams r1 = new ConstraintLayout.LayoutParams(b0.c(12), b0.c(12));
        r1.topToTop = r16.getId();
        r1.bottomToBottom = r16.getId();
        r1.rightToLeft = r5.getId();
        r1.leftToRight = r7.getId();
        ((ViewGroup.MarginLayoutParams) r1).rightMargin = b0.c(3);
        ((ViewGroup.MarginLayoutParams) r1).leftMargin = b0.c(6);
        b0.e(this);
        addView(r3, r1);
        ConstraintLayout.LayoutParams r11 = new ConstraintLayout.LayoutParams(b0.c(12), b0.c(12));
        r11.topToTop = r16.getId();
        r11.bottomToBottom = r16.getId();
        r11.rightToLeft = r4.getId();
        ((ViewGroup.MarginLayoutParams) r11).rightMargin = b0.c(3);
        r11.leftToRight = r7.getId();
        ((ViewGroup.MarginLayoutParams) r11).leftMargin = b0.c(4);
        b0.e(this);
        addView(r2, r11);
        ConstraintLayout.LayoutParams r12 = new ConstraintLayout.LayoutParams(-2, -2);
        r12.topToTop = r16.getId();
        r12.bottomToBottom = r16.getId();
        r12.rightToLeft = r2.getId();
        r12.leftToRight = r19.getId();
        ((ViewGroup.MarginLayoutParams) r12).leftMargin = b0.c(4);
        addView(r7, r12);
        ConstraintLayout.LayoutParams r13 = new ConstraintLayout.LayoutParams(0, -2);
        r13.leftToRight = r16.getId();
        r13.topToTop = r16.getId();
        r13.bottomToBottom = r16.getId();
        r13.rightToLeft = r7.getId();
        addView(r19, r13);
        TextView r110 = getRecReasonView();
        ConstraintLayout.LayoutParams r20 = new ConstraintLayout.LayoutParams(-2, -2);
        r20.topToTop = r16.getId();
        r20.bottomToBottom = r16.getId();
        r20.rightToRight = 0;
        addView(r110, r20);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.view.View, android.widget.LinearLayout, com.bytedance.android.shopping.api.mall.common.homepage.card.common.ECRoundedLinearLayout, com.bytedance.android.shopping.mall.homepage.card.common.ReturnRewardBtn] */
    /* JADX WARN: Type inference failed for: r6v4, types: [android.view.View, android.widget.TextView, com.bytedance.android.shopping.mall.homepage.card.live.AdTagView] */
    public BottomInfoView(Context r13, AttributeSet r14, int r15) {
        super(r13, r14, r15);
        this.e = 1.0f;
        this.f = LazyKt.lazy(BottomInfoView$nameSize$2.INSTANCE);
        SimpleDraweeView r16 = new SimpleDraweeView(getContext());
        r16.setId(ViewCompat.generateViewId());
        RoundingParams r17 = RoundingParams.fromCornersRadius(5.0f);
        r17.setRoundAsCircle(true);
        r16.getHierarchy().setRoundingParams(r17);
        r16.getHierarchy().setOverlayImage(new ColorDrawable(ColorProtector.parseColor("#0D000000")));
        Unit r18 = Unit.INSTANCE;
        this.g = r16;
        TextView r19 = new TextView(getContext());
        r19.setId(ViewCompat.generateViewId());
        ToolsKt.b(r19);
        r19.setIncludeFontPadding(false);
        r19.setMaxLines(1);
        r19.setTextSize(1, getNameSize());
        r19.setGravity(8388611);
        this.h = r19;
        this.i = LazyKt.lazy(new BottomInfoView$recReasonView$2(this));
        SimpleDraweeView r1 = new SimpleDraweeView(getContext());
        r1.setId(ViewCompat.generateViewId());
        r1.setImageResource(2131248023);
        this.j = r1;
        SimpleDraweeView r2 = new SimpleDraweeView(getContext());
        r2.setId(ViewCompat.generateViewId());
        this.k = r2;
        TextView r3 = new TextView(getContext());
        r3.setId(ViewCompat.generateViewId());
        r3.setTextSize(1, 11.0f);
        this.l = r3;
        HotTextContainerView r4 = new HotTextContainerView(getContext(), null, 6, 0);
        r4.setId(ViewCompat.generateViewId());
        this.m = r4;
        ?? r5 = new ReturnRewardBtn(getContext(), null);
        r5.setId(ViewCompat.generateViewId());
        r5.setRadius(UIUtils.dip2Px(r5.getContext(), 4.0f));
        this.n = r5;
        ?? r6 = new AdTagView(getContext());
        r6.setId(ViewCompat.generateViewId());
        r6.setVisibility(8);
        this.o = r6;
        ConstraintLayout.LayoutParams r9 = new ConstraintLayout.LayoutParams(0, b0.c(26));
        r9.leftToLeft = 0;
        r9.rightToRight = 0;
        ((ViewGroup.MarginLayoutParams) r9).topMargin = b0.c(8);
        r9.topToBottom = r16.getId();
        addView(r5, r9);
        ConstraintLayout.LayoutParams r7 = new ConstraintLayout.LayoutParams(b0.c(16), b0.c(16));
        r7.leftToLeft = 0;
        r7.topToTop = 0;
        r7.rightToLeft = r19.getId();
        ((ViewGroup.MarginLayoutParams) r7).rightMargin = b0.c(4);
        addView(r16, r7);
        ConstraintLayout.LayoutParams r8 = new ConstraintLayout.LayoutParams(-2, -2);
        r8.topToTop = r16.getId();
        r8.bottomToBottom = r16.getId();
        r8.rightToRight = 0;
        ((ViewGroup.MarginLayoutParams) r8).topMargin = b0.c(1);
        addView(r4, r8);
        ConstraintLayout.LayoutParams r110 = new ConstraintLayout.LayoutParams(-2, -2);
        r110.topToTop = r16.getId();
        r110.bottomToBottom = r16.getId();
        r110.rightToRight = 0;
        addView(r3, r110);
        ConstraintLayout.LayoutParams r111 = new ConstraintLayout.LayoutParams(b0.c(12), b0.c(12));
        r111.topToTop = r16.getId();
        r111.bottomToBottom = r16.getId();
        r111.rightToLeft = r4.getId();
        r111.leftToRight = r6.getId();
        ((ViewGroup.MarginLayoutParams) r111).rightMargin = b0.c(3);
        ((ViewGroup.MarginLayoutParams) r111).leftMargin = b0.c(6);
        b0.e(this);
        addView(r2, r111);
        ConstraintLayout.LayoutParams r112 = new ConstraintLayout.LayoutParams(b0.c(12), b0.c(12));
        r112.topToTop = r16.getId();
        r112.bottomToBottom = r16.getId();
        r112.rightToLeft = r3.getId();
        ((ViewGroup.MarginLayoutParams) r112).rightMargin = b0.c(3);
        r112.leftToRight = r6.getId();
        ((ViewGroup.MarginLayoutParams) r112).leftMargin = b0.c(4);
        b0.e(this);
        addView(r1, r112);
        ConstraintLayout.LayoutParams r113 = new ConstraintLayout.LayoutParams(-2, -2);
        r113.topToTop = r16.getId();
        r113.bottomToBottom = r16.getId();
        r113.rightToLeft = r1.getId();
        r113.leftToRight = r19.getId();
        ((ViewGroup.MarginLayoutParams) r113).leftMargin = b0.c(4);
        addView(r6, r113);
        ConstraintLayout.LayoutParams r114 = new ConstraintLayout.LayoutParams(0, -2);
        r114.leftToRight = r16.getId();
        r114.topToTop = r16.getId();
        r114.bottomToBottom = r16.getId();
        r114.rightToLeft = r6.getId();
        addView(r19, r114);
        TextView r115 = getRecReasonView();
        ConstraintLayout.LayoutParams r116 = new ConstraintLayout.LayoutParams(-2, -2);
        r116.topToTop = r16.getId();
        r116.bottomToBottom = r16.getId();
        r116.rightToRight = 0;
        addView(r115, r116);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void U5(CommonModel$Product r46, CommonModel$User r47, final LiveCardModel.Live r48, boolean r49, Companion.Experiment r50, Companion.ElementStyle r51, a r52) {
        Intrinsics.checkNotNullParameter(r46, "product");
        Intrinsics.checkNotNullParameter(r47, "user");
        Intrinsics.checkNotNullParameter(r50, "experiment");
        Intrinsics.checkNotNullParameter(r51, "elementStyle");
        R5();
        this.a = r51.getAvatarDesc();
        this.b = r51.getHotDesc();
        this.c = r51.getReturnRewardDesc();
        this.d = r51.getCoinIconLayout();
        this.g.setImageURI(r47.getAvatar());
        this.h.setText(r47.getNickname());
        if (r46.isReturnRewardContainerVisible() == false) goto L43;
        this.n.setVisibility(0);
        ReturnRewardBtn r8 = this.n;
        String r0 = r46.getRewardText();
        CommonModel$ModuleDesc r9 = this.c;
        if (r9 == null) goto L7;
        CommonModel$CusTextStyle r10 = r9.getTextStyle();
    L8:
        CommonModel$LayoutStyle r11 = this.d;
        CommonData.MarketingData r4 = r46.getMarketingData();
        if (r4 == null) goto L11;
        String r5 = r4.getReturnRewardIcon();
    L12:
        int r12 = r50.getCoinLabelStyle();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r0, "rewardDes");
        if (h.a(r5) == false) goto L15;
        b0.n(r8.e);
        r8.e.setImageURI(r5);
    L16:
        ProductTextView r6 = r8.c;
        if (r10 == null) goto L20;
        String r17 = r10.getColor();
        if (r17 == null) goto L20;
    L21:
        String r24 = r17;
        if (r10 == null) goto L26;
        Integer r18 = r10.getFontWeight();
        if (r18 == null) goto L26;
        int r19 = r18.intValue();
    L27:
        Integer r26 = Integer.valueOf(r19);
        if (r12 <= 0) goto L30;
        String r28 = "DouyinNumberABC-Medium";
    L31:
        r6.y(new TextBaseUIParams(r0, new ProductStyle(null, null, r24, null, r26, null, r28, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, 2031531, null)));
        if (r10 != null) goto L232;
    L42:
        r8.g = r10;
        r8.h = r11;
        r8.setViewScale(r8.f);
        int r7 = 8;
    L44:
        if (r49 == false) goto L46;
        this.o.setVisibility(0);
    L49:
        ?? r13 = 1;
    L50:
        IHybridHostService r1 = com.bytedance.android.ec.hybrid.a.h();
        if (r1 == null) goto L57;
        i r2 = r1.getIHybridHostAppInfo();
        if (r2 == null) goto L57;
        if (r2.isNightMode() != r13) goto L57;
        boolean r14 = true;
    L58:
        CommonModel$ModuleDesc r3 = r51.getAvatarDesc();
        if (r3 == null) goto L70;
        CommonModel$CusTextStyle r15 = r3.getTextStyle();
        if (r15 == null) goto L70;
        if (r50.getEnableDarkModel() == false) goto L66;
        if (r14 == false) goto L66;
        String r16 = r15.getColorDark();
    L68:
        if (h.a(r16) == false) goto L70;
        this.h.setTextColor(ColorProtector.parseColor(r16));
    L66:
        r16 = r15.getColor();
    L70:
        Function0<Result<? extends Unit>> r20 = new BottomInfoView$handleHot$useNewHotIcon$1(this, r48);
        if (r50.getEnlargeCover() == false) goto L73;
        String r21 = "#FFFFFF";
    L74:
        int r110 = h.a;
        if (r48 == null) goto L77;
        String r111 = r48.getNewHotDesc();
    L79:
        if (h.a(r111) == false) goto L91;
        if (r48 == null) goto L82;
        String r112 = r48.getNewHotIcon();
    L84:
        if (h.a(r112) == false) goto L91;
        Y5(r13);
        if (r48 == null) goto L90;
        CharSequence r113 = r48.getNewHotDesc();
        if (r113 == null) goto L90;
        HotTextContainerView r114 = this.m;
        r114.getClass();
        Intrinsics.checkNotNullParameter(r113, "t");
        r114.c.setText(r113);
        this.m.a(r21);
    L90:
        r20.invoke();
        String r115 = null;
    L153:
        if (r52 == null) goto L189;
        String r22 = r52.a;
        String r23 = r52.b;
        if (r22 != null) goto L158;
    L161:
        boolean r116 = true;
    L162:
        if (r116 == true) goto L188;
        if (r23 != null) goto L165;
    L168:
        boolean r117 = true;
    L169:
        if (r117 == true) goto L188;
        CommonModel$CommonColorStyle r25 = r51.getHotIcon();
        if (r25 == null) goto L181;
        String r27 = r25.getColorLight();
        if (r27 == null) goto L181;
        if (r27.length() <= 0) goto L178;
        boolean r118 = true;
    L179:
        if (r118 == false) goto L181;
    L182:
        this.j.setImageURI(UriProtector.parse(r23));
        this.l.setText(r22);
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L185
        this.l.setTextColor(Color.parseColor(r27));     // Catch: Throwable -> L185
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L185
    L187:
        b0.n(this.j);
        b0.n(this.l);
    L185:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L187
    L178:
        r118 = false;
    L181:
        r27 = "#FFFFFF";
        goto L182
    L165:
        if (r23.length() == 0) goto L168;
        r117 = false;
    L188:
        b0.e(this.j);
        b0.e(this.l);
        goto L189
    L158:
        if (r22.length() == 0) goto L161;
        r116 = false;
    L189:
        int r31 = h.a;
        if (r48 == null) goto L192;
        String r119 = r48.getRecReason();
    L194:
        if (h.a(r119) == false) goto L212;
        this.j.setVisibility(8);
        this.l.setVisibility(8);
        ConstraintLayout.LayoutParams r32 = getRecReasonView().getLayoutParams();
        if (r32 == null) goto L211;
        ConstraintLayout.LayoutParams r33 = r32;
        ViewGroup.LayoutParams r34 = this.h.getLayoutParams();
        if (r34 == null) goto L209;
        ViewGroup.LayoutParams r35 = (ConstraintLayout.LayoutParams) r34;
        r33.leftToRight = this.h.getId();
        ((ConstraintLayout.LayoutParams) r35).rightToLeft = getRecReasonView().getId();
        if (r50.getEnlargeCover() == false) goto L202;
        getRecReasonView().setTextColor(ColorProtector.parseColor("#FFFFFF"));
        ((ViewGroup.MarginLayoutParams) r33).leftMargin = b0.c(4);
    L203:
        this.h.setLayoutParams(r35);
        TextView r36 = getRecReasonView();
        if (r48 == null) goto L206;
        String r120 = r48.getRecReason();
    L207:
        r36.setText(r120);
        getRecReasonView().setVisibility(0);
    L215:
        ToolsKt.A(this.g, 0.0f, null, null, null, null, 0, null, null, false, null, 991);
        if (r50.getEnlargeCover() == false) goto L222;
        GenericDraweeHierarchy r37 = this.g.getHierarchy();
        if (r37 == null) goto L227;
        RoundingParams r38 = r37.getRoundingParams();
        if (r38 == null) goto L227;
        r38.setBorder(ColorProtector.parseColor("#33FFFFFF"), 2.0f);
    L227:
        setViewScaleSize(this.e);
        return;
    L222:
        GenericDraweeHierarchy r39 = this.g.getHierarchy();
        if (r39 == null) goto L227;
        RoundingParams r40 = r39.getRoundingParams();
        if (r40 == null) goto L227;
        r40.setBorder(0, 0.0f);
        goto L227
    L206:
        r120 = r115;
        goto L207
    L202:
        getRecReasonView().setTextColor(ColorProtector.parseColor("#A17254"));
        ((ViewGroup.MarginLayoutParams) r33).leftMargin = b0.c(8);
        goto L203
    L209:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L211:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L212:
        ViewGroup.LayoutParams r41 = this.h.getLayoutParams();
        if (r41 == null) goto L230;
        ViewGroup.LayoutParams r42 = (ConstraintLayout.LayoutParams) r41;
        ((ConstraintLayout.LayoutParams) r42).rightToLeft = this.o.getId();
        this.h.setLayoutParams(r42);
        getRecReasonView().setVisibility(8);
        goto L215
    L230:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L192:
        r119 = r115;
        goto L194
    L82:
        r112 = null;
    L91:
        if (r48 == null) goto L93;
        String r121 = r48.getHotNum();
    L94:
        if (r121 == null) goto L96;
        Integer r122 = StringsKt.toIntOrNull(r121);
    L97:
        if (r122 != null) goto L99;
    L108:
        r115 = null;
        String r43 = "";
    L110:
        if (r43.length() != 0) goto L112;
        boolean r44 = true;
    L113:
        if (r44 == false) goto L115;
        V5(false);
        Y5(false);
        goto L153
    L115:
        if (r48 == null) goto L117;
        String r123 = r48.getNewHotIcon();
    L119:
        if (h.a(r123) == false) goto L129;
        if (r48 == null) goto L130;
        String r45 = r48.getNewHotIcon();
        if (r45 == null) goto L130;
        if (r45.length() <= 0) goto L126;
        boolean r124 = true;
    L127:
        if (r124 == false) goto L130;
        this.j.setImageURI(UriProtector.parse(r45));
        goto L130
    L126:
        r124 = false;
    L130:
        V5(r13);
        this.l.setText(r43);
        CommonModel$ModuleDesc r53 = r51.getHotDesc();
        if (r53 == null) goto L140;
        CommonModel$CusTextStyle r54 = r53.getTextStyle();
        if (r54 == null) goto L140;
        if (r50.getEnableDarkModel() == false) goto L138;
        if (r14 == false) goto L138;
        String r55 = r54.getColorDark();
    L139:
        ToolsKt.w(this.l, r55);
    L138:
        r55 = r54.getColor();
    L140:
        CommonModel$CommonColorStyle r56 = r51.getHotIcon();
        if (r56 == null) goto L151;
        if (r50.getEnableDarkModel() == false) goto L146;
        if (r14 == false) goto L146;
        String r57 = r56.getColorDark();
    L148:
        if (h.a(r57) == false) goto L151;
        setHotIconViewColorAndAlpha(r57);
    L146:
        r57 = r56.getColorLight();
    L151:
        if (r50.getShowPeopleNewIcon() == false) goto L153;
        this.j.setImageResource(2131248024);
        goto L153
    L129:
        this.j.setImageResource(2131248023);
        goto L130
    L117:
        r123 = r115;
        goto L119
    L112:
        r44 = false;
        goto L113
    L99:
        if (r122.intValue() == 0) goto L108;
        if (r122.intValue() >= 10000) goto L104;
        r43 = String.valueOf(r122.intValue());
        r115 = null;
        goto L110
    L104:
        DecimalFormat r58 = new DecimalFormat();
        r58.setMaximumFractionDigits(r13);
        r58.setGroupingSize(0);
        r58.setRoundingMode(RoundingMode.FLOOR);
        String r59 = r58.format(((double) r122.intValue()) / 10000.0d);
        r115 = null;
        if (StringsKt.endsWith$default(r59, ".0", false, 2, null) == false) goto L107;
        r59 = r59.substring(0, r59.length() - 2);
    L107:
        r43 = r59 + 19975;
        goto L110
    L96:
        r122 = null;
        goto L97
    L93:
        r121 = null;
        goto L94
    L77:
        r111 = null;
        goto L79
    L73:
        r21 = "#73161823";
    L57:
        r14 = false;
        goto L58
    L46:
        this.o.setVisibility(r7);
        if (r48 != null) goto L49;
        r13 = 1;
        ToolsKt.A(this.h, 0.0f, null, null, null, null, null, 0, null, false, null, 959);
        goto L50
    L232:
        String r60 = r10.getBackgroundColor();     // Catch: Exception -> L40
        if (r60 != null) goto L36;
    L231:
        goto L42
    L36:
        if (h.a(r10.getBackgroundColorTo()) == false) goto L38;
        b0.j(r8.d, new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor(r60), Color.parseColor(r10.getBackgroundColorTo())}));     // Catch: Exception -> L40
        goto L231
    L38:
        r8.d.setBackgroundColor(Color.parseColor(r60));     // Catch: Exception -> L40
    L40:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        goto L42
    L30:
        r28 = null;
    L26:
        r19 = 400;
    L20:
        r17 = "#FFFFFFFF";
        goto L21
    L15:
        b0.e(r8.e);
        goto L16
    L11:
        r5 = null;
        goto L12
    L7:
        r10 = null;
        goto L8
    L43:
        r7 = 8;
        this.n.setVisibility(8);
        goto L44
    }
}
