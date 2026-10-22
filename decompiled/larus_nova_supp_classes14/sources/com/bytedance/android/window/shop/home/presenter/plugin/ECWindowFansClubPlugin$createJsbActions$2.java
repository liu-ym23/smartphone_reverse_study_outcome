package com.bytedance.android.window.shop.home.presenter.plugin;

import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentServiceId;
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
public final /* synthetic */ class ECWindowFansClubPlugin$createJsbActions$2 extends FunctionReferenceImpl implements Function1<JSONObject, Unit> {
    public ECWindowFansClubPlugin$createJsbActions$2(ECWindowFansClubPlugin r8) {
        super(1, r8, ECWindowFansClubPlugin.class, "onFansClubRedPackReceived", "onFansClubRedPackReceived(Lorg/json/JSONObject;)V", 0);
    }

    public final void invoke(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        ECWindowFansClubPlugin r0 = (ECWindowFansClubPlugin) ((CallableReference) this).receiver;
        List<String> r1 = ECWindowFansClubPlugin.i;
        r0.getClass();
        String r2 = r4.optString("sec_author_id");
        if (StringsKt.isBlank(r2) == false) goto L5;
        return;
    L5:
        if ((!Intrinsics.areEqual(r2, r0.f.getShopParam().getSecAuthorId())) == true) goto L10;
        r0.c = Intrinsics.areEqual(r4.optString("red_packet_type"), CommentServiceId.HOT_SPOT);
        r0.g.invoke(Boolean.FALSE);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
