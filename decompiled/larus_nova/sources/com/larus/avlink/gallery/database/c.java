package com.larus.avlink.gallery.database;

import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes25.dex */
public final class c implements Callable<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoomSQLiteQuery f292425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f292426b;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public a call() throws Exception {
        c r100 = this;
        Cursor r101 = DBUtil.query(r100.f292426b.f292427a, r100.f292425a, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "id");     // Catch: Throwable -> L69
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, AppConstants.BUNDLE_MEDIA_ID);     // Catch: Throwable -> L69
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, "system_gallery_id");     // Catch: Throwable -> L69
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "file_name");     // Catch: Throwable -> L69
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "file_size");     // Catch: Throwable -> L69
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE);     // Catch: Throwable -> L69
        int r108 = CursorUtil.getColumnIndexOrThrow(r101, "width");     // Catch: Throwable -> L69
        int r110 = CursorUtil.getColumnIndexOrThrow(r101, "height");     // Catch: Throwable -> L69
        int r111 = CursorUtil.getColumnIndexOrThrow(r101, "duration");     // Catch: Throwable -> L69
        int r112 = CursorUtil.getColumnIndexOrThrow(r101, "out_video_width");     // Catch: Throwable -> L69
        int r113 = CursorUtil.getColumnIndexOrThrow(r101, "out_video_height");     // Catch: Throwable -> L69
        int r114 = CursorUtil.getColumnIndexOrThrow(r101, "output_video_crop");     // Catch: Throwable -> L69
        int r115 = CursorUtil.getColumnIndexOrThrow(r101, "create_time");     // Catch: Throwable -> L69
        int r109 = CursorUtil.getColumnIndexOrThrow(r101, "geo_location_info");     // Catch: Throwable -> L69
        int r116 = CursorUtil.getColumnIndexOrThrow(r101, "algorithm_type");     // Catch: Throwable -> L67
        int r117 = CursorUtil.getColumnIndexOrThrow(r101, "lifecycle_state");     // Catch: Throwable -> L67
        int r118 = CursorUtil.getColumnIndexOrThrow(r101, FlowNetworkIDLStub.OMNI_UPLOAD_FAILURE_STAGE_KEY);     // Catch: Throwable -> L67
        int r119 = CursorUtil.getColumnIndexOrThrow(r101, "failure_reason");     // Catch: Throwable -> L67
        int r120 = CursorUtil.getColumnIndexOrThrow(r101, "download_file_path");     // Catch: Throwable -> L67
        int r121 = CursorUtil.getColumnIndexOrThrow(r101, "temp_file_path");     // Catch: Throwable -> L67
        int r122 = CursorUtil.getColumnIndexOrThrow(r101, "unpack_dir_path");     // Catch: Throwable -> L67
        int r123 = CursorUtil.getColumnIndexOrThrow(r101, "processed_file_path");     // Catch: Throwable -> L67
        int r124 = CursorUtil.getColumnIndexOrThrow(r101, "final_file_path");     // Catch: Throwable -> L67
        int r125 = CursorUtil.getColumnIndexOrThrow(r101, "active_mask");     // Catch: Throwable -> L67
        if (r101.moveToFirst() == true) goto L7;
        a r126 = null;
    L65:
        r101.close();
        this.f292425a.release();
        return r126;
    L7:
        if (r101.isNull(r102) == false) goto L9;
        String r210 = null;
    L10:
        long r211 = r101.getLong(r103);     // Catch: Throwable -> L67
        if (r101.isNull(r104) == false) goto L13;
        Long r212 = null;
    L15:
        if (r101.isNull(r105) == false) goto L17;
        String r310 = null;
    L19:
        if (r101.isNull(r106) == false) goto L21;
        Long r311 = null;
    L23:
        if (r101.isNull(r107) == false) goto L25;
        String r312 = null;
    L26:
        int r313 = r101.getInt(r108);     // Catch: Throwable -> L67
        int r314 = r101.getInt(r110);     // Catch: Throwable -> L67
        long r315 = r101.getLong(r111);     // Catch: Throwable -> L67
        int r316 = r101.getInt(r112);     // Catch: Throwable -> L67
        int r317 = r101.getInt(r113);     // Catch: Throwable -> L67
        double r318 = r101.getDouble(r114);     // Catch: Throwable -> L67
        long r410 = r101.getLong(r115);     // Catch: Throwable -> L67
        if (r101.isNull(r109) == false) goto L29;
        String r411 = null;
    L31:
        if (r101.isNull(r16) == false) goto L33;
        String r412 = null;
    L34:
        int r413 = r101.getInt(r117);     // Catch: Throwable -> L67
        if (r101.isNull(r118) == false) goto L37;
        Integer r414 = null;
    L39:
        if (r101.isNull(r19) == false) goto L41;
        String r415 = null;
    L43:
        if (r101.isNull(r20) == false) goto L45;
        String r416 = null;
    L47:
        if (r101.isNull(r21) == false) goto L49;
        String r417 = null;
    L51:
        if (r101.isNull(r22) == false) goto L53;
        String r510 = null;
    L55:
        if (r101.isNull(r23) == false) goto L57;
        String r511 = null;
    L59:
        if (r101.isNull(r24) == false) goto L61;
        String r512 = null;
    L62:
        r126 = new a(r210, r211, r212, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r413, r414, r415, r416, r417, r510, r511, r512, r101.getInt(r125));     // Catch: Throwable -> L67
        goto L65
    L61:
        r512 = r101.getString(r124);     // Catch: Throwable -> L67
        goto L62
    L57:
        r511 = r101.getString(r123);     // Catch: Throwable -> L67
        goto L59
    L53:
        r510 = r101.getString(r122);     // Catch: Throwable -> L67
        goto L55
    L49:
        r417 = r101.getString(r121);     // Catch: Throwable -> L67
        goto L51
    L45:
        r416 = r101.getString(r120);     // Catch: Throwable -> L67
        goto L47
    L41:
        r415 = r101.getString(r119);     // Catch: Throwable -> L67
        goto L43
    L37:
        r414 = Integer.valueOf(r101.getInt(r118));     // Catch: Throwable -> L67
        goto L39
    L33:
        r412 = r101.getString(r116);     // Catch: Throwable -> L67
        goto L34
    L29:
        r411 = r101.getString(r109);     // Catch: Throwable -> L67
        goto L31
    L25:
        r312 = r101.getString(r107);     // Catch: Throwable -> L67
        goto L26
    L21:
        r311 = Long.valueOf(r101.getLong(r106));     // Catch: Throwable -> L67
        goto L23
    L17:
        r310 = r101.getString(r105);     // Catch: Throwable -> L67
        goto L19
    L13:
        r212 = Long.valueOf(r101.getLong(r104));     // Catch: Throwable -> L67
        goto L15
    L9:
        r210 = r101.getString(r102);     // Catch: Throwable -> L67
    L67:
        th = th;
        r100 = this;
    L70:
        r101.close();
        r100.f292425a.release();
        throw th;
    L69:
        th = th;
        goto L70
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ a call() throws Exception {
        return call();
    }

    public c(d r100, RoomSQLiteQuery r101) {
        this.f292426b = r100;
        this.f292425a = r101;
    }
}
