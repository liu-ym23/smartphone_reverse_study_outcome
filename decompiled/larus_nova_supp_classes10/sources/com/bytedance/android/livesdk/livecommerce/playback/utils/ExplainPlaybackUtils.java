package com.bytedance.android.livesdk.livecommerce.playback.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.model.playback.ExplainPlaybackRequest;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import si2.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ExplainPlaybackUtils {
    public static final /* synthetic */ int a = 0;

    public static Context b() {
        return ECAppInfoService.e.getApplicationContext();
    }

    public static boolean d() {
        if (ECSettingKeys.D() != LiveReplayPageOptEnums.DEFAULT.getTrial()) goto L5;
        return true;
    L5:
        return false;
    }

    static {
    }

    public static FilterNullArrayList a(ExplainPlaybackRequest r11) {
        Intrinsics.checkNotNullParameter(r11, "requestParams");
        FilterNullArrayList r0 = new FilterNullArrayList();
        r0.add(new k("promotion_id", r11.getPromotionId()));
        String r2 = r11.getOriginFragmentId();
        if (r2 != null) goto L5;
        r2 = BDLocationException.ERROR_TIMEOUT;
    L5:
        r0.add(new k("fragment_id", r2));
        hh2.g r1 = hh2.f.a.a;
        boolean r3 = false;
        if (r1 == null) goto L10;
        Boolean r4 = r1.l();
        if (r4 == null) goto L10;
        boolean r5 = r4.booleanValue();
    L12:
        if (r5 == false) goto L14;
        r0.add(new k("author_id", BDLocationException.ERROR_TIMEOUT));
        r0.add(new k("author_open_id", r11.getAuthorId()));
    L15:
        r0.add(new k("room_id", r11.getRoomId()));
        r0.add(new k("source_page", r11.getSourcePage()));
        r0.add(new k("entrance_info", r11.getEntranceInfo()));
        r0.add(new k("carrier_source", r11.getCarrierSource()));
        r0.add(new k("need_adapt_addr", String.valueOf(r11.getNeedAdaptAddr())));
        r0.add(new k("modelType", String.valueOf(r11.getModelType())));
        String r6 = r11.getEnterScene();
        if (r6 != null) goto L18;
        r6 = "";
    L18:
        r0.add(new k("enter_scene", r6));
        if (d() == true) goto L27;
        r0.add(new k("need_room_replays", String.valueOf(r11.getEnableMultiCard())));
        r0.add(new k("is_first_page", String.valueOf(r11.isFirstPage())));
        r0.add(new k("page_size", String.valueOf(r11.getPageSize())));
        List r12 = r11.getPromotionIDs();
        List r7 = r12;
        if (r7 != null) goto L23;
    L24:
        r3 = true;
    L25:
        if (r3 == true) goto L27;
        r0.add(new k("promotion_ids", CollectionsKt.joinToString$default(r12, ",", null, null, 0, null, ExplainPlaybackUtils$convertInputParamsToCommentaryParams$1$1.INSTANCE, 30, null)));
        goto L27
    L23:
        if (r7.isEmpty() == false) goto L25;
    L27:
        return r0;
    L14:
        r0.add(new k("author_id", r11.getAuthorId()));
    L10:
        r5 = false;
        goto L12
    }

    public static boolean e(String r1) {
        return TextUtils.equals(r1, "search");
    }

    public static String c(Context r8, long r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        long r10 = r9 / ((long) 1000);
        long r0 = 60;
        long r2 = r10 % r0;
        long r11 = (r10 / r0) % r0;
        long r1 = 10;
        if (r2 >= r1) goto L5;
        String r3 = th.a.h(r8, 2131896464, new Object[]{Long.valueOf(r2)});
    L7:
        if (r11 >= r1) goto L9;
        String r12 = th.a.h(r8, 2131896464, new Object[]{Long.valueOf(r11)});
    L10:
        StringCompanionObject r13 = StringCompanionObject.INSTANCE;
        return String.format(th.a.g(r8, 2131896479), Arrays.copyOf(new Object[]{r12, r3}, 2));
    L9:
        r12 = String.valueOf(r11);
        goto L10
    L5:
        r3 = String.valueOf(r2);
        goto L7
    }
}
