package com.bytedance.android.shopping.hybrid.bridges;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import cg3.h;
import cg3.k;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.Json;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.shopping.order.PublishUtil;
import com.bytedance.android.shopping.order.PublishUtil$getStartVideoEditActivityObservable$1;
import com.bytedance.android.shopping.order.api.OrderApi;
import com.bytedance.android.shopping.utils.j;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/hybrid/bridges/ECOpenVideoEditorMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECOpenVideoEditorMethod extends ECBaseBridgeMethod {

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ ECOpenVideoEditorMethod a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ String[] c;

        public b(ECOpenVideoEditorMethod r1, Ref.ObjectRef r2, String[] r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object apply(Object r6) {
            h r7 = (h) r6;
            Intrinsics.checkNotNullParameter(r7, "shareInfoResponseDTO");
            Ref.ObjectRef r0 = this.b;
            r0.element = r7.a();
            Handler r1 = PublishUtil.a;
            final Context r2 = this.a.getContext();
            final Bundle r3 = new Bundle();
            Context r4 = this.a.getContext();
            if (r4 == null) goto L7;
            Context r5 = th.a.e(r4, true);
            if (r5 == null) goto L7;
            String r8 = r5.getString(2131913939);
        L8:
            r3.putString("share_tag", r8);
            cg3.e r9 = r7.a();
            String r10 = "";
            if (r9 == null) goto L12;
            String r11 = r9.c();
            if (r11 == null) goto L12;
        L13:
            r3.putString("share_title", r11);
            cg3.e r12 = r7.a();
            if (r12 == null) goto L19;
            String r13 = r12.b();
            if (r13 == null) goto L19;
            r10 = r13;
        L19:
            r3.putString("share_content", r10);
            r3.putStringArray("media_path", this.c);
            Unit r14 = Unit.INSTANCE;
            Intrinsics.checkNotNullParameter(r3, "bundle");
            return Observable.create(new PublishUtil$getStartVideoEditActivityObservable$1(r2, r3));
        L12:
            r11 = "";
        L7:
            r8 = null;
            goto L8
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ Ref.ObjectRef a;
        public final /* synthetic */ cg3.g b;
        public final /* synthetic */ cg3.f c;

        public c(Ref.ObjectRef r1, cg3.g r2, cg3.f r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter(r2, "editModel");
            this.a.element = r2;
            Handler r3 = PublishUtil.a;
            return PublishUtil.c(this.b, this.c);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ ECOpenVideoEditorMethod a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ cg3.f c;
        public final /* synthetic */ Ref.ObjectRef d;

        public d(ECOpenVideoEditorMethod r1, Ref.ObjectRef r2, cg3.f r3, Ref.ObjectRef r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r9) {
            cg3.d r10 = (cg3.d) r9;
            Handler r11 = PublishUtil.a;
            PublishUtil.e(this.a.getContext(), new k((cg3.e) this.b.element, this.c, null, null, this.d.element, new ECOpenVideoEditorMethod$handle$disposable$3$1(this)), true);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ ECOpenVideoEditorMethod a;

        public e(ECOpenVideoEditorMethod r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            ECOpenVideoEditorMethod.d(this.a, -1, "发布失败");
            ECExceptionMonitor.e((Throwable) r4);
        }
    }

    static {
    }

    public final String getName() {
        return "ec_openVideoPostEditer";
    }

    public ECOpenVideoEditorMethod() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.util.ArrayList, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v4 */
    public final void c(JSONObject r43, ECBaseBridgeMethod.a r44) {
        Intrinsics.checkNotNullParameter(r43, "params");
        Intrinsics.checkNotNullParameter(r44, "iReturn");
        Lazy r3 = ECAppInfoService.a;
        if (ECAppInfoService.j() == true) goto L5;
        r44.onFailed(-1, "only support douyin");
    L5:
        JSONObject r4 = r43.optJSONObject("comment_info");
        if (r4 != null) goto L9;
        JSONObject r1 = new JSONObject();
        r1.put("code", -1);
        Unit r5 = Unit.INSTANCE;
        r44.a(r1);
        return;
    L9:
        ArrayList r6 = new ArrayList();
        JSONArray r8 = r4.optJSONArray("comments");     // Catch: JSONException -> L20
        if (r8 == null) goto L21;
        Iterator r9 = ((ArrayList) com.bytedance.android.shopping.hybrid.a.a(r8)).iterator();     // Catch: JSONException -> L20
    L14:
        if (r9.hasNext() == false) goto L21;
        Object r10 = r9.next();     // Catch: JSONException -> L20
        int r11 = dg3.a.l;     // Catch: JSONException -> L20
        if ((r10 instanceof HashMap) == true) goto L18;
        r10 = null;
    L18:
        r6.add(dg3.a.C0190a.a((HashMap) r10));     // Catch: JSONException -> L20
    L21:
        long r12 = r4.optLong("anonymous");
        long r13 = r4.optLong("rank_shop");
        long r14 = r4.optLong("rank_logistic");
        JSONObject r2 = r43.optJSONObject("post_material");
        if (r2 != null) goto L25;
        JSONObject r7 = new JSONObject();
        r7.put("code", -1);
        Unit r15 = Unit.INSTANCE;
        r44.a(r7);
        return;
    L25:
        String r16 = r2.optString("video_path");
        if (r16 != null) goto L28;
        r16 = "";
    L28:
        ?? r17 = new ArrayList();
        JSONArray r18 = r2.optJSONArray("image_path");     // Catch: JSONException -> L38
        if (r18 == null) goto L40;
        Iterator r19 = ((ArrayList) com.bytedance.android.shopping.hybrid.a.a(r18)).iterator();     // Catch: JSONException -> L38
    L33:
        if (r19.hasNext() == false) goto L40;
        Object r110 = r19.next();     // Catch: JSONException -> L38
        if ((r110 instanceof String) == false) goto L33;
        r17.add(r110);     // Catch: JSONException -> L38
    L40:
        if (r16.length() != 0) goto L42;
        boolean r20 = true;
    L43:
        if (r20 == true) goto L46;
        List r21 = CollectionsKt.mutableListOf(new String[]{r16});
        r21.addAll(r17);
        r17 = r21;
    L46:
        Object[] r22 = ((Collection) r17).toArray(new String[0]);
        if (r22 == null) goto L63;
        String[] r23 = (String[]) r22;
        if (r6.isEmpty() == false) goto L52;
        JSONObject r24 = new JSONObject();
        r24.put("code", -1);
        Unit r25 = Unit.INSTANCE;
        r44.a(r24);
        return;
    L52:
        dg3.a r26 = (dg3.a) ListProtector.get(r6, 0);
        Long r27 = r26.a;
        Long r28 = r26.b;
        String r29 = r26.c;
        Long r210 = Long.valueOf(r13);
        Long r211 = Long.valueOf(r14);
        Long r30 = r26.e;
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r31 = r6.iterator();
    L54:
        if (r31.hasNext() == false) goto L56;
        dg3.a r112 = (dg3.a) r31.next();
        Long r0 = r112.a;
        String[] r41 = r23;
        Long r32 = r26.b;
        dg3.a r45 = r26;
        String r33 = r112.c;
        Long r212 = Long.valueOf(r13);
        Long r34 = Long.valueOf(r14);
        long r113 = r13;
        Long r114 = r112.e;
        Json r115 = Json.b;
        r111.add(new cg3.f(r0, r32, r33, r212, r34, r114, r115.b(r112.f), r115.b(r112.g), Long.valueOf(r12), r112.d, null, null, null, null, 130048));
        r31 = r31;
        r26 = r45;
        r13 = r113;
        r14 = r14;
        r23 = r41;
        goto L54
    L56:
        String[] r42 = r23;
        Long r35 = Long.valueOf(CastLongProtector.parseLong(r.a.getCurrentUserId()));
        String r36 = com.bytedance.android.ec.sdk.helper.d.b.getIECHostAppInfo().getAppId();
        if (r36 == null) goto L59;
        long r37 = CastLongProtector.parseLong(r36);
    L60:
        cg3.g r38 = new cg3.g(r35, Long.valueOf(r37), 12L, r111);
        cg3.f r39 = (cg3.f) CollectionsKt.firstOrNull(r111);
        Ref.ObjectRef r40 = new Ref.ObjectRef();
        r40.element = null;
        Ref.ObjectRef r46 = new Ref.ObjectRef();
        r46.element = null;
        Handler r47 = PublishUtil.a;
        OrderApi.a.getClass();
        Disposable r48 = OrderApi.a.a.getShareInfo(r27, r28, r29, r210, r211, r30, null, null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).flatMap(new b(this, r46, r42)).observeOn(Schedulers.io()).flatMap(new c(r40, r38, r39)).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r46, r39, r40), new e(this));
        int r49 = j.a;
        j.a(getContext(), r48);
        return;
    L59:
        r37 = 0;
        goto L60
    L63:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L42:
        r20 = false;
        goto L43
    }

    public static final void d(ECOpenVideoEditorMethod r2, int r3, String r4) {
        r2.getClass();
        JSONObject r5 = new JSONObject();
        r5.put("code", r3);
        r5.put("msg", r4);
        vi.a r6 = com.bytedance.android.ec.sdk.helper.d.b.getIECHostAppInfo();
        JSONObject r7 = new JSONObject();
        r7.put("eventName", "ecPostCommentResponse");
        r7.put("data", r5);
        Unit r8 = Unit.INSTANCE;
        r6.d(r7);
    }
}
