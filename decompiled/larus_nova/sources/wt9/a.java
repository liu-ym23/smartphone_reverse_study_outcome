package wt9;

import com.larus.network.HttpConst;
import mq9.m;
import mq9.o;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public a() {
    }

    public static mq9.a a() {
        Float r110 = Float.valueOf(1.21875f);
        m r100 = new m(r110, "replica_modal_create_video_new_title", "replica_modal_create_video_new_desc", "replica_bottomsheet_select_agree_2", "replica_modal_create_video_new_btn", "#0066FF");
        m r101 = new m(r110, "replica_modal_create_video_existing_title", "replica_modal_create_video_existing_desc", "replica_modal_create_video_new_desc_terms", "replica_modal_create_video_new_btn", "#0066FF");
        HttpConst.f359979a.getClass();
        String r102 = HttpConst.f360006n0;
        String r103 = HttpConst.f360008o0;
        return new mq9.a(r100, r101, new o(r102, r103, r103, r102), new o(r102, r103, r103, r102));
    }
}
