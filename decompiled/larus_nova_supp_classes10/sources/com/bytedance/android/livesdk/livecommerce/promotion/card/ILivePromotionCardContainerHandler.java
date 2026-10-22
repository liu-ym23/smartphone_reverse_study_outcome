package com.bytedance.android.livesdk.livecommerce.promotion.card;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface ILivePromotionCardContainerHandler {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/ILivePromotionCardContainerHandler$ContainerPriority;", "", "LigoInitDataMap", "AddressInfo", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
    public static final enum ContainerPriority extends Enum<ContainerPriority> {
        public static final ContainerPriority AddressInfo = null;
        public static final ContainerPriority LigoInitDataMap = null;
        public static final /* synthetic */ ContainerPriority[] a = null;

        static {
            ContainerPriority r1 = new ContainerPriority("LigoInitDataMap", 0);
            LigoInitDataMap = r1;
            ContainerPriority r2 = new ContainerPriority("AddressInfo", 1);
            AddressInfo = r2;
            a = new ContainerPriority[]{r1, r2};
        }

        public static ContainerPriority valueOf(String r1) {
            return (ContainerPriority) r27.a.a(ContainerPriority.class, r1);
        }

        public static ContainerPriority[] values() {
            return (ContainerPriority[]) a.clone();
        }

        public ContainerPriority(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0014\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/ILivePromotionCardContainerHandler$Scene;", "", "ExplainPromotionBackground", "ExplainPromotionBackgroundRadius", "ExplainBarWaveIcon", "InstantRetailShopStepperTextColor", "InstantRetailShopStepperTextSize", "InstantRetailShopStepperAddEnabledImageUrl", "InstantRetailShopStepperAddDisabledImageUrl", "InstantRetailShopStepperSubImageUrl", "AddCartIconEnabled", "AddCartIconDisabled", "AddCartBtnBgEnabled", "AddCartBtnBgDisabled", "AddCartBtnLargeSize", "BuyBtnBgEnabled", "BuyBtnBgDisabled", "BuyBtnTextColor", "BuyBtnWidthSelfAdapt", "SimilarBtnBgEnabled", "SimilarBtnTextColorEnabled", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Scene extends Enum<Scene> {
        public static final Scene AddCartBtnBgDisabled = null;
        public static final Scene AddCartBtnBgEnabled = null;
        public static final Scene AddCartBtnLargeSize = null;
        public static final Scene AddCartIconDisabled = null;
        public static final Scene AddCartIconEnabled = null;
        public static final Scene BuyBtnBgDisabled = null;
        public static final Scene BuyBtnBgEnabled = null;
        public static final Scene BuyBtnTextColor = null;
        public static final Scene BuyBtnWidthSelfAdapt = null;
        public static final Scene ExplainBarWaveIcon = null;
        public static final Scene ExplainPromotionBackground = null;
        public static final Scene ExplainPromotionBackgroundRadius = null;
        public static final Scene InstantRetailShopStepperAddDisabledImageUrl = null;
        public static final Scene InstantRetailShopStepperAddEnabledImageUrl = null;
        public static final Scene InstantRetailShopStepperSubImageUrl = null;
        public static final Scene InstantRetailShopStepperTextColor = null;
        public static final Scene InstantRetailShopStepperTextSize = null;
        public static final Scene SimilarBtnBgEnabled = null;
        public static final Scene SimilarBtnTextColorEnabled = null;
        public static final /* synthetic */ Scene[] a = null;

        static {
            Scene r1 = new Scene("ExplainPromotionBackground", 0);
            ExplainPromotionBackground = r1;
            Scene r2 = new Scene("ExplainPromotionBackgroundRadius", 1);
            ExplainPromotionBackgroundRadius = r2;
            Scene r3 = new Scene("ExplainBarWaveIcon", 2);
            ExplainBarWaveIcon = r3;
            Scene r4 = new Scene("InstantRetailShopStepperTextColor", 3);
            InstantRetailShopStepperTextColor = r4;
            Scene r5 = new Scene("InstantRetailShopStepperTextSize", 4);
            InstantRetailShopStepperTextSize = r5;
            Scene r6 = new Scene("InstantRetailShopStepperAddEnabledImageUrl", 5);
            InstantRetailShopStepperAddEnabledImageUrl = r6;
            Scene r7 = new Scene("InstantRetailShopStepperAddDisabledImageUrl", 6);
            InstantRetailShopStepperAddDisabledImageUrl = r7;
            Scene r8 = new Scene("InstantRetailShopStepperSubImageUrl", 7);
            InstantRetailShopStepperSubImageUrl = r8;
            Scene r9 = new Scene("AddCartIconEnabled", 8);
            AddCartIconEnabled = r9;
            Scene r10 = new Scene("AddCartIconDisabled", 9);
            AddCartIconDisabled = r10;
            Scene r11 = new Scene("AddCartBtnBgEnabled", 10);
            AddCartBtnBgEnabled = r11;
            Scene r12 = new Scene("AddCartBtnBgDisabled", 11);
            AddCartBtnBgDisabled = r12;
            Scene r13 = new Scene("AddCartBtnLargeSize", 12);
            AddCartBtnLargeSize = r13;
            Scene r14 = new Scene("BuyBtnBgEnabled", 13);
            BuyBtnBgEnabled = r14;
            Scene r15 = new Scene("BuyBtnBgDisabled", 14);
            BuyBtnBgDisabled = r15;
            Scene r16 = new Scene("BuyBtnTextColor", 15);
            BuyBtnTextColor = r16;
            Scene r17 = new Scene("BuyBtnWidthSelfAdapt", 16);
            BuyBtnWidthSelfAdapt = r17;
            Scene r18 = new Scene("SimilarBtnBgEnabled", 17);
            SimilarBtnBgEnabled = r18;
            Scene r19 = new Scene("SimilarBtnTextColorEnabled", 18);
            SimilarBtnTextColorEnabled = r19;
            a = new Scene[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19};
        }

        public static Scene valueOf(String r1) {
            return (Scene) r27.a.a(Scene.class, r1);
        }

        public static Scene[] values() {
            return (Scene[]) a.clone();
        }

        public Scene(String r1, int r2) {
            super(r1, r2);
        }
    }

    void a();

    il2.a b(com.bytedance.android.btm.api.model.d r1);

    void c(String r1, int r2, boolean r3);

    void d();

    Map<String, Object> e(ContainerPriority r1);

    void f(ECUIPromotion r1);

    d g();

    boolean h(Decision r1);

    boolean i(ql.a r1, int r2, boolean r3);

    void j(String r1);

    void k(ql.a r1);

    Object l();

    void m();

    @Deprecated(message = "临时兼容，二期改为动态可配")
    <T> T n(Scene r1, KClass<T> r2, Context r3);

    com.bytedance.android.livesdk.livecommerce.largemode.b o();

    boolean p(View r1, ql.a r2);
}
