package com.bytedance.android.livesdk.livecommerce.room.service;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.ECLiveEntranceMonitor;
import com.bytedance.android.ec.opt.asynctask.t;
import com.bytedance.android.livesdk.livecommerce.utils.ECCartMonitor;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 `2\u00020\u0001:\u0001aB\u000f\u0012\u0006\u0010\\\u001a\u00020[¢\u0006\u0004\b^\u0010_J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0016J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u0018\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J0\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\b\u0018\u00010\u001dH\u0016J\b\u0010 \u001a\u00020\u0006H\u0016J\b\u0010!\u001a\u00020\u0006H\u0016J&\u0010&\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010$\u001a\u0004\u0018\u00010\u00152\b\u0010%\u001a\u0004\u0018\u00010\u0015H\u0016J\u001e\u0010*\u001a\u00020\b2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020(\u0018\u00010'H\u0016J\b\u0010+\u001a\u00020\u0006H\u0016J(\u0010.\u001a\u00020\b2\b\u0010,\u001a\u0004\u0018\u00010\u00112\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\b\u0018\u00010\u001dH\u0016J\u0018\u0010/\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J,\u00101\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u00192\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\b0\u001dH\u0016J\u0010\u00103\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0006H\u0016J\u0018\u00106\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00062\u0006\u00105\u001a\u000204H\u0016J6\u0010<\u001a\u00020\b2\u0006\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u00020\u00152\b\u00109\u001a\u0004\u0018\u00010\u00152\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150:H\u0016J\u0012\u0010?\u001a\u00020\u00062\b\u0010>\u001a\u0004\u0018\u00010=H\u0016J\u0012\u0010C\u001a\u0004\u0018\u00010B2\u0006\u0010A\u001a\u00020@H\u0016J\n\u0010E\u001a\u0004\u0018\u00010DH\u0016J\"\u0010I\u001a\u00020\b2\u0006\u0010F\u001a\u00020\u00152\u0006\u0010G\u001a\u00020\f2\b\u0010H\u001a\u0004\u0018\u00010\u0015H\u0016J&\u0010L\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010J\u001a\u0004\u0018\u00010\u00152\b\u0010K\u001a\u0004\u0018\u00010\u0019H\u0016J\n\u0010N\u001a\u0004\u0018\u00010MH\u0016J\n\u0010P\u001a\u0004\u0018\u00010OH\u0016J\n\u0010R\u001a\u0004\u0018\u00010QH\u0016J\n\u0010T\u001a\u0004\u0018\u00010SH\u0016J\n\u0010V\u001a\u0004\u0018\u00010UH\u0016J\n\u0010X\u001a\u0004\u0018\u00010WH\u0016J\u0012\u0010Z\u001a\u0004\u0018\u00010\u00112\u0006\u0010Y\u001a\u00020\fH\u0016R\u0014\u0010\\\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]¨\u0006b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/service/CommerceServiceDelegate;", "Lcom/bytedance/android/ec/adapter/api/f;", "Lne/a;", "abilityEnv", "Lbl/a;", "covertLiveAbilityEnv", "", "isOpen", "", "switchFlashConfig", "callInjection", "updatePromotionList", "", "num", "notifyPromotionNum", "Landroid/content/Context;", "context", "Lorg/json/JSONObject;", "livePromotionListParams", "Landroidx/fragment/app/Fragment;", "showLivePromotionListFragment", "", "names", "ids", "chooseCategory", "Landroid/os/Bundle;", "bundle", "Landroidx/fragment/app/DialogFragment;", "showLiveFlashFragment", "Lkotlin/Function1;", "callback", "tryShowLiveFlashFragment", "enableFullLiveCommerce", "onBackPressed", "Landroid/app/Activity;", "activity", "enterFromMerge", "enterMethod", "onExistLiveSession", "", "", "params", "handleWebcastInRoomSchema", "isProductDetailPageExpanded", "message", "callBack", "sendMessage", "hookECOMLiveParams", "args", "tryShowSaasCouponDialog", "satisfyFreqControl", "showEnterRoomTicketExpandDialog", "Ljava/lang/Runnable;", "afterInterceptRunnable", "showExitRoomTicketExpandDialog", "roomId", "anchorId", "ecomLiveParams", "", "eventParmas", "roomEnter", "Lcom/bytedance/android/ec/adapter/api/c;", "playFragmentCreatedEnv", "initPlayFragmentEnv", "Lsd/a;", "parentAction", "Lsd/b;", "getLiveDrawerCommonFragment", "Lqd/a;", "getBuyNowService", "addressId", "addressType", "addressStrategyType", "setAddress", "businessName", "businessArgs", "setEnterRoomInfo", "Lme/a;", "getLiveBizWindowLayoutAbility", "Lme/c;", "getLiveBizWindowWidgetAbility", "Lme/b;", "getLiveBizWindowLogAbility", "Lpe/a;", "getECUserInfoService", "Lae/a;", "getECLiveReplayService", "Lzd/a;", "getECLiveLinkmicService", "count", "getLiveShoppingData", "Ltk/b;", "realService", "Ltk/b;", "<init>", "(Ltk/b;)V", "Companion", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommerceServiceDelegate implements com.bytedance.android.ec.adapter.api.f {
    public static final a Companion = null;
    public static final String TAG = "CommerceServiceDelegate";
    private final tk.b realService;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements qd.a {
        public b() {
        }
    }

    public static final class c implements ae.a {
        public final /* synthetic */ xk.b a;

        public c(xk.b r1) {
            this.a = r1;
        }
    }

    public static final class d implements pe.a {
        public d() {
        }
    }

    public static final class e extends me.a {
        public e() {
        }
    }

    public static final class f extends me.b {
        public f() {
        }
    }

    public static final class g extends me.c {
        public g() {
        }
    }

    public static final class h implements vk.c<vk.b> {

        public static final class a implements vk.b {
            public a() {
            }
        }

        public final a create() {
            return new a();
        }

        public h() {
        }
    }

    public static final class i implements zk.b {
        public final /* synthetic */ JSONObject a;

        public final String entryName() {
            JSONObject r0 = this.a;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.optString("entry_name");
        }

        public final String getCouponId() {
            JSONObject r0 = this.a;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.optString("coupon_id");
        }

        public i(JSONObject r1) {
            this.a = r1;
        }
    }

    static {
        Companion = new a();
    }

    public zd.a getECLiveLinkmicService() {
        return null;
    }

    public void callInjection() {
        this.realService.callInjection();
        ECLiveEntranceMonitor.trace$default("callInjection", TAG, false, 4, null);
        if (ECCartMonitor.b == true) goto L6;
        ECCartMonitor.b = true;
        t.b(new com.bytedance.android.livesdk.livecommerce.utils.h());
        return;
    }

    public boolean enableFullLiveCommerce() {
        return this.realService.enableFullLiveCommerce();
    }

    public qd.a getBuyNowService() {
        if (this.realService.getBuyNowService() != null) goto L7;
        return null;
    L7:
        return new b();
    }

    public ae.a getECLiveReplayService() {
        xk.b r0 = this.realService.getECLiveReplayService();
        if (r0 != null) goto L7;
        return null;
    L7:
        return new c(r0);
    }

    public pe.a getECUserInfoService() {
        if (this.realService.getECUserInfoService() != null) goto L7;
        return null;
    L7:
        return new d();
    }

    public me.a getLiveBizWindowLayoutAbility() {
        if (this.realService.getLiveBizWindowLayoutAbility() == null) goto L5;
        final e r0 = new e();
        new CommerceServiceDelegate$getLiveBizWindowLayoutAbility$$inlined$let$lambda$1(r0, this);
        return r0;
    L5:
        return null;
    }

    public me.b getLiveBizWindowLogAbility() {
        if (this.realService.getLiveBizWindowLogAbility() == null) goto L5;
        final f r0 = new f();
        new CommerceServiceDelegate$getLiveBizWindowLogAbility$$inlined$let$lambda$1(r0, this);
        return r0;
    L5:
        return null;
    }

    public me.c getLiveBizWindowWidgetAbility() {
        if (this.realService.getLiveBizWindowWidgetAbility() == null) goto L5;
        final g r0 = new g();
        new CommerceServiceDelegate$getLiveBizWindowWidgetAbility$$inlined$let$lambda$1(r0, this);
        return r0;
    L5:
        return null;
    }

    public boolean isProductDetailPageExpanded() {
        return this.realService.isProductDetailPageExpanded();
    }

    public boolean onBackPressed() {
        return this.realService.onBackPressed();
    }

    public void updatePromotionList() {
        this.realService.updatePromotionList();
    }

    public CommerceServiceDelegate(tk.b r2) {
        Intrinsics.checkNotNullParameter(r2, "realService");
        this.realService = r2;
    }

    private final bl.a covertLiveAbilityEnv(ne.a r6) {
        Function1 r1 = null;
        if (r6 == null) goto L5;
        String r2 = null;
        r6.getClass();
    L6:
        if (r6 == null) goto L8;
        String r3 = null;
        r6.getClass();
    L9:
        if (r6 == null) goto L11;
        String r4 = null;
        r6.getClass();
    L12:
        if (r6 == null) goto L15;
        r1 = null;
        r6.getClass();
    L15:
        return new bl.a(r2, r4, r3, r1);
    L11:
        r4 = null;
        goto L12
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public sd.b getLiveDrawerCommonFragment(sd.a r5) {
        Intrinsics.checkNotNullParameter(r5, "parentAction");
        Intrinsics.checkNotNullParameter("ec://liveDrawerCommonFragment", "path");
        HashMap r0 = new HashMap();
        h r2 = new h();
        Intrinsics.checkNotNullParameter(vk.b.class, "key");
        Intrinsics.checkNotNullParameter(r2, "value");
        r0.put(vk.b.class, r2);
        vk.d r1 = new vk.d("ec://liveDrawerCommonFragment");
        r1.a.putAll(r0);
        this.realService.e(r1);
        return null;
    }

    public JSONObject getLiveShoppingData(int r2) {
        return this.realService.getLiveShoppingData(r2);
    }

    public void handleWebcastInRoomSchema(Map<String, Object> r2) {
        this.realService.handleWebcastInRoomSchema(r2);
    }

    public boolean initPlayFragmentEnv(com.bytedance.android.ec.adapter.api.c r2) {
        return this.realService.i(r2);
    }

    public void notifyPromotionNum(int r2) {
        this.realService.notifyPromotionNum(r2);
    }

    public boolean showEnterRoomTicketExpandDialog(boolean r2) {
        return this.realService.showEnterRoomTicketExpandDialog(r2);
    }

    public void switchFlashConfig(boolean r2) {
        this.realService.switchFlashConfig(r2);
    }

    public static final /* synthetic */ bl.a access$covertLiveAbilityEnv(CommerceServiceDelegate r0, ne.a r1) {
        return r0.covertLiveAbilityEnv(r1);
    }

    public void chooseCategory(String r2, String r3) {
        this.realService.chooseCategory(r2, r3);
    }

    public void hookECOMLiveParams(String r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "bundle");
        this.realService.hookECOMLiveParams(r2, r3);
    }

    public void sendMessage(JSONObject r1, Function1<? super JSONObject, Unit> r2) {
        this.realService.g(r1);
    }

    public boolean showExitRoomTicketExpandDialog(boolean r2, Runnable r3) {
        Intrinsics.checkNotNullParameter(r3, "afterInterceptRunnable");
        return this.realService.showExitRoomTicketExpandDialog(r2, r3);
    }

    public DialogFragment showLiveFlashFragment(Context r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return this.realService.showLiveFlashFragment(r2, r3);
    }

    public Fragment showLivePromotionListFragment(Context r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return this.realService.k(r3, new i(r4));
    }

    public void onExistLiveSession(Activity r1, String r2, String r3) {
        this.realService.h(r1);
    }

    public void setAddress(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "addressId");
        this.realService.setAddress(r2, r3, r4);
    }

    public void setEnterRoomInfo(Context r1, String r2, Bundle r3) {
        this.realService.j(r2, r3);
    }

    public void tryShowLiveFlashFragment(Context r2, Bundle r3, Function1<? super DialogFragment, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.realService.tryShowLiveFlashFragment(r2, r3, r4);
    }

    public void tryShowSaasCouponDialog(Context r2, Bundle r3, Function1<? super JSONObject, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "args");
        Intrinsics.checkNotNullParameter(r4, "callBack");
        this.realService.tryShowSaasCouponDialog(r2, r3, r4);
    }

    public void roomEnter(String r2, String r3, String r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r2, "roomId");
        Intrinsics.checkNotNullParameter(r3, "anchorId");
        Intrinsics.checkNotNullParameter(r5, "eventParmas");
        this.realService.roomEnter(r2, r3, r4, r5);
    }
}
