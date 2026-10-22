package qx6;

import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f535136a = 0;

    static {
    }

    public d() {
    }

    public static final void a(String r100, String r101, String r102, String r103, String r104, String r105) {
        int r106 = com.bytedance.locallife.biz.mob.a.f256703c;
        Pair[] r107 = new Pair[7];
        r107[0] = TuplesKt.to("scene", "goods_detail");
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r107[1] = TuplesKt.to("detail_enter_page", r100);
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r107[2] = TuplesKt.to("detail_enter_method", r101);
        if (r102 != null) goto L11;
        r102 = "";
    L11:
        r107[3] = TuplesKt.to("enter_from", r102);
        if (r103 != null) goto L14;
        r103 = "";
    L14:
        r107[4] = TuplesKt.to("enter_method", r103);
        r107[5] = TuplesKt.to("status", r104);
        if (r105 != null) goto L17;
        r105 = "";
    L17:
        r107[6] = TuplesKt.to(UniContext.KEY_OF_BIZ_CODE, r105);
        com.bytedance.locallife.biz.mob.a.C3646a.c("life_biz_code_missing", MapsKt.mapOf(r107));
    }
}
