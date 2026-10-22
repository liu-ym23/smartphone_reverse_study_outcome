package com.larus.avatar.impl.scan.utils;

import com.ixigua.lib.track.TrackParams;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import tx9.r0;

/* JADX INFO: loaded from: classes23.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f291135a = 0;

    static {
    }

    public d() {
    }

    public static void a(String r100, String r101, String r102, long r103, String r110) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r102, "reason");
        if (r101 != null) goto L5;
        r101 = "null";
    L5:
        r0.e(r100, r102, r101, r103, r110);
    }

    public static void b(TraceFragment r100, String r101, String r102, String r103, String r104) {
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "replicaCreateId");
        Intrinsics.checkNotNullParameter(r103, "recordingStep");
        Intrinsics.checkNotNullParameter(r105, "params");
        boolean r106 = IUgcAIGCService.f373945a.v();
        Intrinsics.checkNotNullParameter(r102, "replicaCreateId");
        Intrinsics.checkNotNullParameter(r103, "recordingStep");
        Intrinsics.checkNotNullParameter(r105, "params");
        r105.putOpt("enter_method", r101);     // Catch: JSONException -> L9
        r105.putOpt("replica_create_id", r102);     // Catch: JSONException -> L9
        if (r106 == false) goto L6;
        int r107 = 1;
    L7:
        r105.putOpt("is_has_replica", Integer.valueOf(r107));     // Catch: JSONException -> L9
        r105.putOpt("recording_step", r103);     // Catch: JSONException -> L9
        r105.putOpt("click_from", r104);     // Catch: JSONException -> L9
    L11:
        TrackParams r108 = new TrackParams().merge(r105);
        by7.a r109 = new by7.a("replica_video_record_page_action");
        if (r100 == null) goto L14;
        r109.f21464b = r100;
    L14:
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L6:
        r107 = 0;
    L9:
        e = move-exception;
        FLogger.f375446a.e("mobLeaveCreateReplicaPage", "error is " + e.getLocalizedMessage());
        goto L11
    }
}
