package wt9;

import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import mq9.i;
import mq9.k;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public d() {
    }

    public static mq9.d a() {
        AppHost.Companion r100 = AppHost.f326268a;
        return new mq9.d(4, new mq9.g(r100.getApplication().getString(R.string.larus_simplifyReplicaGen_title_createReplica), r100.getApplication().getString(R.string.larus_simplifyReplicaGen_desc_likenessVoice)), new i(r100.getApplication().getString(R.string.larus_simplifyReplicaGen_toast_reviewing), r100.getApplication().getString(R.string.larus_simplifyReplicaGen_instru_readNumber), r100.getApplication().getString(R.string.larus_simplifyReplicaGen_instru_readText), 2), new k(r100.getApplication().getString(R.string.larus_simplifyReplicaGen_toast_replicaReady), r100.getApplication().getString(R.string.larus_creation_replica_video_title_noFace), r100.getApplication().getString(R.string.larus_simplifyReplicaGen_title_wrongNumbers), r100.getApplication().getString(R.string.larus_simplifyReplicaGen_des_recordAgain), r100.getApplication().getString(R.string.larus_creation_replica_video_title_action_not_match), r100.getApplication().getString(R.string.larus_creation_replica_video_errToast_fail), r100.getApplication().getString(R.string.larus_creation_replica_video_err_complete_desc)));
    }
}
