package com.larus.chat.job.impl.page.edit;

import android.os.Bundle;
import com.larus.im.bean.job.AIJob;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class c0 {
    public static final AIJob b(Bundle r210) {
        AIJob r100 = null;
        if (r210 == null) goto L23;
        Bundle r101 = r210.getBundle("chat_job_snapshot");
        if (r101 == null) goto L23;
        String r102 = r101.getString("chat_job_snapshot_job_id");
        if (r102 == null) goto L23;
        if ((!StringsKt.isBlank(r102)) == false) goto L12;
        String r103 = r102;
    L13:
        if (r103 == null) goto L23;
        int r104 = r101.getInt("chat_job_snapshot_job_type");
        int r105 = r101.getInt("chat_job_snapshot_status");
        long r106 = r101.getLong("chat_job_snapshot_update_version");
        String r110 = r101.getString("chat_job_snapshot_conversation_id");
        long r111 = r101.getLong("chat_job_snapshot_create_time");
        long r112 = r101.getLong("chat_job_snapshot_update_time");
        String r107 = r101.getString("chat_job_snapshot_content");
        if (r107 != null) goto L17;
        String r113 = "";
    L18:
        String r108 = r101.getString("chat_job_snapshot_ext");
        if (r108 != null) goto L21;
        String r114 = "";
    L22:
        r100 = new AIJob(r103, r104, r105, r106, r110, r111, r112, r113, r114, r101.getString("chat_job_snapshot_local_job_id"), null, 1024, null);
        goto L23
    L21:
        r114 = r108;
        goto L22
    L17:
        r113 = r107;
        goto L18
    L12:
        r103 = null;
    L23:
        return r100;
    }

    public static final void a(Bundle r100, AIJob r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "job");
        Bundle r102 = new Bundle();
        r102.putString("chat_job_snapshot_job_id", r101.getJobId());
        r102.putInt("chat_job_snapshot_job_type", r101.getJobType());
        r102.putInt("chat_job_snapshot_status", r101.getStatus());
        r102.putLong("chat_job_snapshot_update_version", r101.getUpdateVersion());
        r102.putString("chat_job_snapshot_conversation_id", r101.getConversationId());
        r102.putLong("chat_job_snapshot_create_time", r101.getCreateTime());
        r102.putLong("chat_job_snapshot_update_time", r101.getUpdateTime());
        r102.putString("chat_job_snapshot_content", r101.getContent());
        r102.putString("chat_job_snapshot_ext", r101.getExt());
        r102.putString("chat_job_snapshot_local_job_id", r101.getLocalJobId());
        Unit r103 = Unit.INSTANCE;
        r100.putBundle("chat_job_snapshot", r102);
    }
}
