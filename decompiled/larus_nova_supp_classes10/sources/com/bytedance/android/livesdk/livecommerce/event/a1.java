package com.bytedance.android.livesdk.livecommerce.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a1 extends u0 {
    public static final /* synthetic */ int d = 0;

    public static final class a {
        public static String a(boolean r1, boolean r2, boolean r3) {
            if (r2 == false) goto L4;
            String r4 = "livesdk_list_tab_more_";
        L6:
            if (r3 == false) goto L8;
            String r5 = "anchor_";
        L9:
            String r6 = r4.concat(r5);
            StringBuilder r7 = new StringBuilder();
            r7.append(r6);
            if (r1 == false) goto L12;
            String r8 = "show";
        L13:
            r7.append(r8);
            return r7.toString();
        L12:
            r8 = "click";
            goto L13
        L8:
            r5 = "";
            goto L9
        L4:
            r4 = "livesdk_list_tab_";
            goto L6
        }
    }

    static {
    }

    public a1(boolean r2, boolean r3) {
        super(a.a(r2, true, r3));
        f("ecom_entrance_form", "live_list_card");
        f("anchor_id", l0.i("anchor_id"));
        f("enter_from_merge", l0.d());
        f("enter_method", l0.i("enter_method"));
        f("room_id", l0.i("room_id"));
        f("page_name", "live_list");
        f("source_page", l0.n());
        f("group_id", l0.i("group_id"));
        f("carrier_source", l0.d());
        f("source_method", l0.e());
    }
}
