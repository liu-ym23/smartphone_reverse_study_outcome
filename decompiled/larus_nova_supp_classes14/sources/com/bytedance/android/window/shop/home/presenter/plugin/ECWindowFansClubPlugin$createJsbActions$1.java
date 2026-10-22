package com.bytedance.android.window.shop.home.presenter.plugin;

import com.android.ttcjpaysdk.base.ktextension.SharedPrefExtKt;
import com.bytedance.android.ec.window.base.shop.ECWindowBubblePrompt;
import com.bytedance.android.ec.window.base.shop.WindowFansClubBubbleConfig;
import com.bytedance.android.ec.window.base.shop.WindowFansClubInfo;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentServiceId;
import com.bytedance.ies.utility.SharedPrefHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECWindowFansClubPlugin$createJsbActions$1 extends FunctionReferenceImpl implements Function1<JSONObject, Unit> {
    public ECWindowFansClubPlugin$createJsbActions$1(ECWindowFansClubPlugin r8) {
        super(1, r8, ECWindowFansClubPlugin.class, "onFansClubRedPackClosed", "onFansClubRedPackClosed(Lorg/json/JSONObject;)V", 0);
    }

    public final void invoke(JSONObject r6) {
        Intrinsics.checkNotNullParameter(r6, "p1");
        ECWindowFansClubPlugin r0 = (ECWindowFansClubPlugin) ((CallableReference) this).receiver;
        List<String> r1 = ECWindowFansClubPlugin.i;
        r0.getClass();
        String r2 = r6.optString("sec_author_id");
        if (StringsKt.isBlank(r2) == false) goto L5;
        return;
    L5:
        if ((!Intrinsics.areEqual(r2, r0.f.getShopParam().getSecAuthorId())) == false) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r6.optString("component_type"), CommentServiceId.HOT_SPOT) == true) goto L11;
        return;
    L11:
        if (((SharedPrefHelper) r0.b.getValue()).f("window_fans_club_prompt_shown", false) == false) goto L13;
        r0.i();
        return;
    L13:
        ECWindowBubblePrompt r7 = new ECWindowBubblePrompt(r0.e);
        WindowFansClubInfo r3 = r0.f.getShopParam().getFansClubInfo();
        WindowFansClubBubbleConfig r4 = null;
        if (r3 == null) goto L16;
        String r5 = r3.getFansClubUrl();
    L17:
        WindowFansClubInfo r8 = r0.f.getShopParam().getFansClubInfo();
        if (r8 == null) goto L20;
        r4 = r8.getFansClubBubbleConfig();
    L20:
        r7.b(r5, r4, r0.h, ECWindowFansClubPlugin$showRedPackFollowPrompt$1.INSTANCE);
        r7.a(r0.h);
        SharedPrefExtKt.edit(((SharedPrefHelper) r0.b.getValue()).a, ECWindowFansClubPlugin$onFansClubRedPackClosed$1.INSTANCE);
        return;
    L16:
        r5 = null;
        goto L17
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
