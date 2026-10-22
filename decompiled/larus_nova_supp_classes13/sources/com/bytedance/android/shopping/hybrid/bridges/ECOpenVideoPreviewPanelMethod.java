package com.bytedance.android.shopping.hybrid.bridges;

import android.content.Context;
import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.core.utils.Json;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.shopping.order.PreviewPanelFragment;
import com.bytedance.android.shopping.order.PublishUtil;
import com.bytedance.android.shopping.order.PublishUtil$getSilentPublishModelObservable$1;
import com.bytedance.android.shopping.order.PublishUtil$getSynthesizedVideoObservable$1;
import com.bytedance.android.shopping.utils.j;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/hybrid/bridges/ECOpenVideoPreviewPanelMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECOpenVideoPreviewPanelMethod extends ECBaseBridgeMethod {
    public static final /* synthetic */ int e = 0;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.shopping.order.a {
        public final /* synthetic */ ECOpenVideoPreviewPanelMethod a;

        @Override // com.bytedance.android.shopping.order.a
        public final void a() {
            ECOpenVideoPreviewPanelMethod.e(this.a, 0, "成功", 4);
        }

        @Override // com.bytedance.android.shopping.order.a
        public final void b() {
            ECOpenVideoPreviewPanelMethod.e(this.a, 1, null, 6);
        }

        @Override // com.bytedance.android.shopping.order.a
        public final void onFailed() {
            Intrinsics.checkNotNullParameter("publish failed", "msg");
            ECOpenVideoPreviewPanelMethod.e(this.a, -1, "publish failed", 4);
        }

        public b(ECOpenVideoPreviewPanelMethod r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final String getName() {
        return "openCommentPostPannel";
    }

    public ECOpenVideoPreviewPanelMethod() {
    }

    public final void c(JSONObject r48, ECBaseBridgeMethod.a r49) {
        Intrinsics.checkNotNullParameter(r48, "params");
        Intrinsics.checkNotNullParameter(r49, "iReturn");
        Lazy r3 = ECAppInfoService.a;
        if (ECAppInfoService.j() == true) goto L5;
        r49.onFailed(-1, "only support douyin");
    L5:
        JSONObject r4 = r48.optJSONObject("comment_info");
        if (r4 != null) goto L9;
        JSONObject r1 = new JSONObject();
        r1.put("code", -1);
        Unit r5 = Unit.INSTANCE;
        r49.a(r1);
        e(this, -1, "传参错误", 4);
        return;
    L9:
        ArrayList r8 = new ArrayList();
        JSONArray r10 = r4.optJSONArray("comments");     // Catch: JSONException -> L20
        if (r10 == null) goto L21;
        Iterator r11 = ((ArrayList) com.bytedance.android.shopping.hybrid.a.a(r10)).iterator();     // Catch: JSONException -> L20
    L14:
        if (r11.hasNext() == false) goto L21;
        Object r12 = r11.next();     // Catch: JSONException -> L20
        int r13 = dg3.a.l;     // Catch: JSONException -> L20
        if ((r12 instanceof HashMap) == true) goto L18;
        r12 = null;
    L18:
        r8.add(dg3.a.C0190a.a((HashMap) r12));     // Catch: JSONException -> L20
    L21:
        long r14 = r4.optLong("anonymous");
        long r15 = r4.optLong("rank_shop");
        long r16 = r4.optLong("rank_logistic");
        JSONObject r6 = r48.optJSONObject("post_material");
        if (r6 != null) goto L25;
        JSONObject r2 = new JSONObject();
        r2.put("code", -1);
        Unit r7 = Unit.INSTANCE;
        r49.a(r2);
        e(this, -1, "传参错误", 4);
        return;
    L25:
        final String r9 = r6.optString("video_path");
        if (r9 != null) goto L28;
        r9 = "";
    L28:
        final ArrayList r17 = new ArrayList();
        JSONArray r18 = r6.optJSONArray("image_path");     // Catch: JSONException -> L38
        if (r18 == null) goto L40;
        Iterator r19 = ((ArrayList) com.bytedance.android.shopping.hybrid.a.a(r18)).iterator();     // Catch: JSONException -> L38
    L33:
        if (r19.hasNext() == false) goto L40;
        Object r20 = r19.next();     // Catch: JSONException -> L38
        if ((r20 instanceof String) == false) goto L33;
        r17.add(r20);     // Catch: JSONException -> L38
    L40:
        if (r8.isEmpty() == false) goto L43;
        JSONObject r21 = new JSONObject();
        r21.put("code", -1);
        Unit r22 = Unit.INSTANCE;
        r49.a(r21);
        return;
    L43:
        dg3.a r23 = (dg3.a) ListProtector.get(r8, 0);
        tl.a r24 = new tl.a(r23.a, r23.b, r23.c, Long.valueOf(r15), Long.valueOf(r16), r23.e, 1984);
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r25 = r8.iterator();
    L45:
        if (r25.hasNext() == false) goto L47;
        dg3.a r26 = (dg3.a) r25.next();
        Long r27 = r26.a;
        Iterator r110 = r25;
        Long r28 = r23.b;
        dg3.a r111 = r23;
        String r29 = r26.c;
        Long r35 = Long.valueOf(r15);
        Long r36 = Long.valueOf(r16);
        long r112 = r15;
        Long r113 = r26.e;
        Json r114 = Json.b;
        long r210 = r16;
        long r211 = r14;
        r0.add(new cg3.f(r27, r28, r29, r35, r36, r113, r114.b(r26.f), r114.b(r26.g), Long.valueOf(r14), r26.d, r26.h, r26.i, r26.j, r26.k, 114688));
        r25 = r110;
        r23 = r111;
        r15 = r112;
        r16 = r210;
        r14 = r211;
        goto L45
    L47:
        Long r30 = Long.valueOf(CastLongProtector.parseLong(r.a.getCurrentUserId()));
        String r31 = com.bytedance.android.ec.sdk.helper.d.b.getIECHostAppInfo().getAppId();
        if (r31 == null) goto L50;
        long r32 = CastLongProtector.parseLong(r31);
    L51:
        cg3.g r33 = new cg3.g(r30, Long.valueOf(r32), 12L, r0);
        boolean r34 = r48.optBoolean("is_hide_panel");
        boolean r37 = r48.optBoolean("is_silent_post");
        final boolean r212 = r48.optBoolean("publish_support_image");
        if (r34 == false) goto L59;
        if (r37 == false) goto L58;
        final cg3.f r38 = (cg3.f) CollectionsKt.firstOrNull(r0);
        if (r38 == null) goto L73;
        Handler r39 = PublishUtil.a;
        final Context r115 = getContext();
        Intrinsics.checkNotNullParameter(r17, "imagePaths");
        Intrinsics.checkNotNullParameter(r9, "videoPath");
        Intrinsics.checkNotNullParameter(r38, "postCommentInfo");
        final String r116 = r9;
        Disposable r40 = Observable.zip(Observable.create(new PublishUtil$getSilentPublishModelObservable$1(r115, r17, r116, r38, r212)), PublishUtil.d(r33, r24, null, null), new e(this, r33)).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this), new g(this));
        int r41 = j.a;
        j.a(getContext(), r40);
    L73:
        JSONObject r42 = new JSONObject();
        r42.put("code", 0);
        Unit r43 = Unit.INSTANCE;
        r49.a(r42);
        return;
    L58:
        Handler r44 = PublishUtil.a;
        final Context r45 = getContext();
        Intrinsics.checkNotNullParameter(r17, "images");
        Intrinsics.checkNotNullParameter(r9, "video");
        Disposable r46 = Observable.zip(Observable.create(new PublishUtil$getSynthesizedVideoObservable$1(r45, r17, r9)), PublishUtil.d(r33, r24, null, null), new com.bytedance.android.shopping.hybrid.bridges.b(this, r33)).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), new d(this));
        int r47 = j.a;
        j.a(getContext(), r46);
        goto L73
    L59:
        FragmentActivity r50 = getContext();
        b r51 = new b(this);
        if ((r50 instanceof FragmentActivity) == true) goto L62;
        FragmentActivity r52 = null;
    L63:
        FragmentActivity r53 = r52;
        if (r53 == null) goto L73;
        FragmentManager r54 = r53.getSupportFragmentManager();
        if (r54 == null) goto L73;
        int r55 = PreviewPanelFragment.y;
        Intrinsics.checkNotNullParameter(r9, "videoMaterial");
        Intrinsics.checkNotNullParameter(r17, "imageMaterial");
        Intrinsics.checkNotNullParameter(r24, "shareInfoRequestParam");
        Intrinsics.checkNotNullParameter(r33, "postCommentRequestParam");
        Intrinsics.checkNotNullParameter(r51, "cb");
        PreviewPanelFragment r56 = new PreviewPanelFragment();
        r56.d = r51;
        r56.f = r9;
        r56.g = r17;
        r56.v = r24;
        r56.w = r33;
        r56.x = r50;
        LandscapeRestrictionOperation r57 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r56, null, r57);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r54, r56, r57) == true) goto L73;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L75
    L72:
        r56.show(r54, null);
        goto L73
    L62:
        r52 = r50;
        goto L63
    L50:
        r32 = 0;
        goto L51
    }

    public static void d(int r3, String r4, cg3.d r5) {
        JSONObject r0 = new JSONObject();
        r0.put("code", r3);
        r0.put("msg", r4);
        if (r5 != null) goto L8;
    L5:
        vi.a r6 = com.bytedance.android.ec.sdk.helper.d.b.getIECHostAppInfo();
        JSONObject r7 = new JSONObject();
        r7.put("eventName", "ecPostCommentResponse");
        r7.put("data", r0);
        Unit r8 = Unit.INSTANCE;
        r6.d(r7);
        return;
    L8:
        r0.put("data", new JSONObject(u0.d(r5)));     // Catch: Exception -> L7
        goto L5
    }

    public static /* synthetic */ void e(ECOpenVideoPreviewPanelMethod r0, int r1, String r2, int r3) {
        if ((r3 & 2) == 0) goto L5;
        r2 = "";
    L5:
        r0.getClass();
        d(r1, r2, null);
    }
}
