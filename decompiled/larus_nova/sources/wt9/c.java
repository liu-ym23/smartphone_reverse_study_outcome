package wt9;

import com.larus.common.apphost.AppHost;
import com.larus.network.HttpConst;
import com.larus.nova.R;
import kotlin.collections.CollectionsKt;
import mq9.j;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public c() {
    }

    public static mq9.c a() {
        AppHost.Companion r100 = AppHost.f326268a;
        String r101 = r100.getApplication().getString(R.string.larus_create_replica_video_desc_prep);
        HttpConst.f359979a.getClass();
        return new mq9.c(5, new mq9.f(r101, HttpConst.f360010p0), new mq9.h(r100.getApplication().getString(R.string.larus_create_replica_video_desc_face_read), r100.getApplication().getString(R.string.larus_create_replica_video_desc_face_start_read), CollectionsKt.listOf(new String[]{r100.getApplication().getString(R.string.larus_best_wishes_1_cn), r100.getApplication().getString(R.string.larus_best_wishes_2_cn), r100.getApplication().getString(R.string.larus_best_wishes_3_cn), r100.getApplication().getString(R.string.larus_best_wishes_4_cn), r100.getApplication().getString(R.string.larus_best_wishes_5_cn), r100.getApplication().getString(R.string.larus_best_wishes_6_cn), r100.getApplication().getString(R.string.larus_best_wishes_7_cn), r100.getApplication().getString(R.string.larus_best_wishes_8_cn), r100.getApplication().getString(R.string.larus_best_wishes_9_cn), r100.getApplication().getString(R.string.larus_best_wishes_10_cn), r100.getApplication().getString(R.string.larus_best_wishes_11_cn), r100.getApplication().getString(R.string.larus_best_wishes_12_cn), r100.getApplication().getString(R.string.larus_best_wishes_13_cn), r100.getApplication().getString(R.string.larus_best_wishes_14_cn), r100.getApplication().getString(R.string.larus_best_wishes_15_cn), r100.getApplication().getString(R.string.larus_best_wishes_16_cn), r100.getApplication().getString(R.string.larus_best_wishes_17_cn), r100.getApplication().getString(R.string.larus_best_wishes_18_cn), r100.getApplication().getString(R.string.larus_best_wishes_19_cn), r100.getApplication().getString(R.string.larus_best_wishes_20_cn), r100.getApplication().getString(R.string.larus_best_wishes_21_cn), r100.getApplication().getString(R.string.larus_best_wishes_22_cn), r100.getApplication().getString(R.string.larus_best_wishes_23_cn), r100.getApplication().getString(R.string.larus_best_wishes_24_cn), r100.getApplication().getString(R.string.larus_best_wishes_25_cn), r100.getApplication().getString(R.string.larus_best_wishes_26_cn), r100.getApplication().getString(R.string.larus_best_wishes_27_cn), r100.getApplication().getString(R.string.larus_best_wishes_28_cn), r100.getApplication().getString(R.string.larus_best_wishes_29_cn), r100.getApplication().getString(R.string.larus_best_wishes_30_cn), r100.getApplication().getString(R.string.larus_best_wishes_31_cn), r100.getApplication().getString(R.string.larus_best_wishes_32_cn), r100.getApplication().getString(R.string.larus_best_wishes_33_cn), r100.getApplication().getString(R.string.larus_best_wishes_34_cn), r100.getApplication().getString(R.string.larus_best_wishes_35_cn), r100.getApplication().getString(R.string.larus_best_wishes_36_cn), r100.getApplication().getString(R.string.larus_best_wishes_37_cn), r100.getApplication().getString(R.string.larus_best_wishes_38_cn), r100.getApplication().getString(R.string.larus_best_wishes_39_cn), r100.getApplication().getString(R.string.larus_best_wishes_40_cn)}), 2, 2), new j(r100.getApplication().getString(R.string.larus_create_replica_video_desc_done), r100.getApplication().getString(R.string.larus_creation_replica_video_title_noFace), r100.getApplication().getString(R.string.larus_creation_replica_video_title_action_not_match), r100.getApplication().getString(R.string.larus_creation_replica_video_errToast_fail), r100.getApplication().getString(R.string.larus_creation_replica_video_err_complete_desc)));
    }
}
