package com.larus.avlink.gallery.database;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes25.dex */
public final class d implements com.larus.avlink.gallery.database.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f292427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.avlink.gallery.database.e f292428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.avlink.gallery.database.f f292429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.larus.avlink.gallery.database.g f292430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.larus.avlink.gallery.database.h f292431e;

    public class a implements Callable<List<com.larus.avlink.gallery.database.a>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f292432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f292433b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<com.larus.avlink.gallery.database.a> call2() throws Exception {
            Cursor r100 = DBUtil.query(this.f292433b.f292427a, this.f292432a, false, null);
            int r101 = CursorUtil.getColumnIndexOrThrow(r100, "id");     // Catch: Throwable -> L71
            int r102 = CursorUtil.getColumnIndexOrThrow(r100, AppConstants.BUNDLE_MEDIA_ID);     // Catch: Throwable -> L71
            int r103 = CursorUtil.getColumnIndexOrThrow(r100, "system_gallery_id");     // Catch: Throwable -> L71
            int r104 = CursorUtil.getColumnIndexOrThrow(r100, "file_name");     // Catch: Throwable -> L71
            int r105 = CursorUtil.getColumnIndexOrThrow(r100, "file_size");     // Catch: Throwable -> L71
            int r106 = CursorUtil.getColumnIndexOrThrow(r100, com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE);     // Catch: Throwable -> L71
            int r107 = CursorUtil.getColumnIndexOrThrow(r100, "width");     // Catch: Throwable -> L71
            int r110 = CursorUtil.getColumnIndexOrThrow(r100, "height");     // Catch: Throwable -> L71
            int r111 = CursorUtil.getColumnIndexOrThrow(r100, "duration");     // Catch: Throwable -> L71
            int r112 = CursorUtil.getColumnIndexOrThrow(r100, "out_video_width");     // Catch: Throwable -> L71
            int r113 = CursorUtil.getColumnIndexOrThrow(r100, "out_video_height");     // Catch: Throwable -> L71
            int r114 = CursorUtil.getColumnIndexOrThrow(r100, "output_video_crop");     // Catch: Throwable -> L71
            int r115 = CursorUtil.getColumnIndexOrThrow(r100, "create_time");     // Catch: Throwable -> L71
            int r108 = CursorUtil.getColumnIndexOrThrow(r100, "geo_location_info");     // Catch: Throwable -> L71
            int r116 = CursorUtil.getColumnIndexOrThrow(r100, "algorithm_type");     // Catch: Throwable -> L69
            int r117 = CursorUtil.getColumnIndexOrThrow(r100, "lifecycle_state");     // Catch: Throwable -> L69
            int r118 = CursorUtil.getColumnIndexOrThrow(r100, FlowNetworkIDLStub.OMNI_UPLOAD_FAILURE_STAGE_KEY);     // Catch: Throwable -> L69
            int r119 = CursorUtil.getColumnIndexOrThrow(r100, "failure_reason");     // Catch: Throwable -> L69
            int r210 = CursorUtil.getColumnIndexOrThrow(r100, "download_file_path");     // Catch: Throwable -> L69
            int r211 = CursorUtil.getColumnIndexOrThrow(r100, "temp_file_path");     // Catch: Throwable -> L69
            int r212 = CursorUtil.getColumnIndexOrThrow(r100, "unpack_dir_path");     // Catch: Throwable -> L69
            int r213 = CursorUtil.getColumnIndexOrThrow(r100, "processed_file_path");     // Catch: Throwable -> L69
            int r214 = CursorUtil.getColumnIndexOrThrow(r100, "final_file_path");     // Catch: Throwable -> L69
            int r215 = CursorUtil.getColumnIndexOrThrow(r100, "active_mask");     // Catch: Throwable -> L69
            int r216 = r108;
            ArrayList r109 = new ArrayList(r100.getCount());     // Catch: Throwable -> L69
        L5:
            if (r100.moveToNext() == false) goto L67;
            if (r100.isNull(r101) == false) goto L10;
            String r217 = null;
        L11:
            long r218 = r100.getLong(r102);     // Catch: Throwable -> L69
            if (r100.isNull(r103) == false) goto L14;
            Long r310 = null;
        L16:
            if (r100.isNull(r104) == false) goto L18;
            String r311 = null;
        L20:
            if (r100.isNull(r105) == false) goto L22;
            Long r312 = null;
        L24:
            if (r100.isNull(r106) == false) goto L26;
            String r313 = null;
        L27:
            int r314 = r100.getInt(r107);     // Catch: Throwable -> L69
            int r315 = r100.getInt(r110);     // Catch: Throwable -> L69
            long r316 = r100.getLong(r111);     // Catch: Throwable -> L69
            int r317 = r100.getInt(r112);     // Catch: Throwable -> L69
            int r410 = r100.getInt(r113);     // Catch: Throwable -> L69
            double r411 = r100.getDouble(r114);     // Catch: Throwable -> L69
            long r412 = r100.getLong(r115);     // Catch: Throwable -> L69
            int r120 = r216;
            if (r100.isNull(r120) == false) goto L31;
            String r413 = null;
        L30:
            int r510 = r116;
            int r121 = r101;
            if (r100.isNull(r510) == false) goto L36;
            String r414 = null;
        L35:
            int r511 = r117;
            int r415 = r100.getInt(r511);     // Catch: Throwable -> L69
            r118 = r118;
            if (r100.isNull(r118) == false) goto L40;
            Integer r416 = null;
        L42:
            if (r100.isNull(r119) == false) goto L44;
            String r417 = null;
        L46:
            if (r100.isNull(r210) == false) goto L48;
            String r512 = null;
        L50:
            if (r100.isNull(r211) == false) goto L52;
            String r513 = null;
        L54:
            if (r100.isNull(r212) == false) goto L56;
            String r514 = null;
        L58:
            if (r100.isNull(r213) == false) goto L60;
            String r515 = null;
        L62:
            if (r100.isNull(r214) == false) goto L64;
            String r516 = null;
        L65:
            int r517 = r100.getInt(r215);     // Catch: Throwable -> L69
            r215 = r215;
            r109.add(new com.larus.avlink.gallery.database.a(r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, r413, r414, r415, r416, r417, r512, r513, r514, r515, r516, r517));     // Catch: Throwable -> L69
            r101 = r121;
            r116 = r510;
            r117 = r511;
            r216 = r120;
            goto L5
        L64:
            r516 = r100.getString(r214);     // Catch: Throwable -> L69
            goto L65
        L60:
            r515 = r100.getString(r213);     // Catch: Throwable -> L69
            goto L62
        L56:
            r514 = r100.getString(r212);     // Catch: Throwable -> L69
            goto L58
        L52:
            r513 = r100.getString(r211);     // Catch: Throwable -> L69
            goto L54
        L48:
            r512 = r100.getString(r210);     // Catch: Throwable -> L69
            goto L50
        L44:
            r417 = r100.getString(r119);     // Catch: Throwable -> L69
            goto L46
        L40:
            r416 = Integer.valueOf(r100.getInt(r118));     // Catch: Throwable -> L69
            goto L42
        L36:
            r414 = r100.getString(r510);     // Catch: Throwable -> L69
            goto L35
        L31:
            r413 = r100.getString(r120);     // Catch: Throwable -> L69
            goto L30
        L26:
            r313 = r100.getString(r106);     // Catch: Throwable -> L69
            goto L27
        L22:
            r312 = Long.valueOf(r100.getLong(r105));     // Catch: Throwable -> L69
            goto L24
        L18:
            r311 = r100.getString(r104);     // Catch: Throwable -> L69
            goto L20
        L14:
            r310 = Long.valueOf(r100.getLong(r103));     // Catch: Throwable -> L69
            goto L16
        L10:
            r217 = r100.getString(r101);     // Catch: Throwable -> L69
            goto L11
        L67:
            r100.close();
            this.f292432a.release();
            return r109;
        L69:
            th = th;
            a r122 = this;
        L73:
            r100.close();
            r122.f292432a.release();
            throw th;
        L71:
            th = th;
            r122 = this;
            goto L73
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<com.larus.avlink.gallery.database.a> call() throws Exception {
            return call2();
        }

        public a(d r100, RoomSQLiteQuery r101) {
            this.f292433b = r100;
            this.f292432a = r101;
        }
    }

    public class b implements Callable<List<com.larus.avlink.gallery.database.a>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f292434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f292435b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<com.larus.avlink.gallery.database.a> call2() throws Exception {
            Cursor r100 = DBUtil.query(this.f292435b.f292427a, this.f292434a, false, null);
            int r101 = CursorUtil.getColumnIndexOrThrow(r100, "id");     // Catch: Throwable -> L71
            int r102 = CursorUtil.getColumnIndexOrThrow(r100, AppConstants.BUNDLE_MEDIA_ID);     // Catch: Throwable -> L71
            int r103 = CursorUtil.getColumnIndexOrThrow(r100, "system_gallery_id");     // Catch: Throwable -> L71
            int r104 = CursorUtil.getColumnIndexOrThrow(r100, "file_name");     // Catch: Throwable -> L71
            int r105 = CursorUtil.getColumnIndexOrThrow(r100, "file_size");     // Catch: Throwable -> L71
            int r106 = CursorUtil.getColumnIndexOrThrow(r100, com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE);     // Catch: Throwable -> L71
            int r107 = CursorUtil.getColumnIndexOrThrow(r100, "width");     // Catch: Throwable -> L71
            int r110 = CursorUtil.getColumnIndexOrThrow(r100, "height");     // Catch: Throwable -> L71
            int r111 = CursorUtil.getColumnIndexOrThrow(r100, "duration");     // Catch: Throwable -> L71
            int r112 = CursorUtil.getColumnIndexOrThrow(r100, "out_video_width");     // Catch: Throwable -> L71
            int r113 = CursorUtil.getColumnIndexOrThrow(r100, "out_video_height");     // Catch: Throwable -> L71
            int r114 = CursorUtil.getColumnIndexOrThrow(r100, "output_video_crop");     // Catch: Throwable -> L71
            int r115 = CursorUtil.getColumnIndexOrThrow(r100, "create_time");     // Catch: Throwable -> L71
            int r108 = CursorUtil.getColumnIndexOrThrow(r100, "geo_location_info");     // Catch: Throwable -> L71
            int r116 = CursorUtil.getColumnIndexOrThrow(r100, "algorithm_type");     // Catch: Throwable -> L69
            int r117 = CursorUtil.getColumnIndexOrThrow(r100, "lifecycle_state");     // Catch: Throwable -> L69
            int r118 = CursorUtil.getColumnIndexOrThrow(r100, FlowNetworkIDLStub.OMNI_UPLOAD_FAILURE_STAGE_KEY);     // Catch: Throwable -> L69
            int r119 = CursorUtil.getColumnIndexOrThrow(r100, "failure_reason");     // Catch: Throwable -> L69
            int r210 = CursorUtil.getColumnIndexOrThrow(r100, "download_file_path");     // Catch: Throwable -> L69
            int r211 = CursorUtil.getColumnIndexOrThrow(r100, "temp_file_path");     // Catch: Throwable -> L69
            int r212 = CursorUtil.getColumnIndexOrThrow(r100, "unpack_dir_path");     // Catch: Throwable -> L69
            int r213 = CursorUtil.getColumnIndexOrThrow(r100, "processed_file_path");     // Catch: Throwable -> L69
            int r214 = CursorUtil.getColumnIndexOrThrow(r100, "final_file_path");     // Catch: Throwable -> L69
            int r215 = CursorUtil.getColumnIndexOrThrow(r100, "active_mask");     // Catch: Throwable -> L69
            int r216 = r108;
            ArrayList r109 = new ArrayList(r100.getCount());     // Catch: Throwable -> L69
        L5:
            if (r100.moveToNext() == false) goto L67;
            if (r100.isNull(r101) == false) goto L10;
            String r217 = null;
        L11:
            long r218 = r100.getLong(r102);     // Catch: Throwable -> L69
            if (r100.isNull(r103) == false) goto L14;
            Long r310 = null;
        L16:
            if (r100.isNull(r104) == false) goto L18;
            String r311 = null;
        L20:
            if (r100.isNull(r105) == false) goto L22;
            Long r312 = null;
        L24:
            if (r100.isNull(r106) == false) goto L26;
            String r313 = null;
        L27:
            int r314 = r100.getInt(r107);     // Catch: Throwable -> L69
            int r315 = r100.getInt(r110);     // Catch: Throwable -> L69
            long r316 = r100.getLong(r111);     // Catch: Throwable -> L69
            int r317 = r100.getInt(r112);     // Catch: Throwable -> L69
            int r410 = r100.getInt(r113);     // Catch: Throwable -> L69
            double r411 = r100.getDouble(r114);     // Catch: Throwable -> L69
            long r412 = r100.getLong(r115);     // Catch: Throwable -> L69
            int r120 = r216;
            if (r100.isNull(r120) == false) goto L31;
            String r413 = null;
        L30:
            int r510 = r116;
            int r121 = r101;
            if (r100.isNull(r510) == false) goto L36;
            String r414 = null;
        L35:
            int r511 = r117;
            int r415 = r100.getInt(r511);     // Catch: Throwable -> L69
            r118 = r118;
            if (r100.isNull(r118) == false) goto L40;
            Integer r416 = null;
        L42:
            if (r100.isNull(r119) == false) goto L44;
            String r417 = null;
        L46:
            if (r100.isNull(r210) == false) goto L48;
            String r512 = null;
        L50:
            if (r100.isNull(r211) == false) goto L52;
            String r513 = null;
        L54:
            if (r100.isNull(r212) == false) goto L56;
            String r514 = null;
        L58:
            if (r100.isNull(r213) == false) goto L60;
            String r515 = null;
        L62:
            if (r100.isNull(r214) == false) goto L64;
            String r516 = null;
        L65:
            int r517 = r100.getInt(r215);     // Catch: Throwable -> L69
            r215 = r215;
            r109.add(new com.larus.avlink.gallery.database.a(r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, r413, r414, r415, r416, r417, r512, r513, r514, r515, r516, r517));     // Catch: Throwable -> L69
            r101 = r121;
            r116 = r510;
            r117 = r511;
            r216 = r120;
            goto L5
        L64:
            r516 = r100.getString(r214);     // Catch: Throwable -> L69
            goto L65
        L60:
            r515 = r100.getString(r213);     // Catch: Throwable -> L69
            goto L62
        L56:
            r514 = r100.getString(r212);     // Catch: Throwable -> L69
            goto L58
        L52:
            r513 = r100.getString(r211);     // Catch: Throwable -> L69
            goto L54
        L48:
            r512 = r100.getString(r210);     // Catch: Throwable -> L69
            goto L50
        L44:
            r417 = r100.getString(r119);     // Catch: Throwable -> L69
            goto L46
        L40:
            r416 = Integer.valueOf(r100.getInt(r118));     // Catch: Throwable -> L69
            goto L42
        L36:
            r414 = r100.getString(r510);     // Catch: Throwable -> L69
            goto L35
        L31:
            r413 = r100.getString(r120);     // Catch: Throwable -> L69
            goto L30
        L26:
            r313 = r100.getString(r106);     // Catch: Throwable -> L69
            goto L27
        L22:
            r312 = Long.valueOf(r100.getLong(r105));     // Catch: Throwable -> L69
            goto L24
        L18:
            r311 = r100.getString(r104);     // Catch: Throwable -> L69
            goto L20
        L14:
            r310 = Long.valueOf(r100.getLong(r103));     // Catch: Throwable -> L69
            goto L16
        L10:
            r217 = r100.getString(r101);     // Catch: Throwable -> L69
            goto L11
        L67:
            r100.close();
            this.f292434a.release();
            return r109;
        L69:
            th = th;
            b r122 = this;
        L73:
            r100.close();
            r122.f292434a.release();
            throw th;
        L71:
            th = th;
            r122 = this;
            goto L73
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<com.larus.avlink.gallery.database.a> call() throws Exception {
            return call2();
        }

        public b(d r100, RoomSQLiteQuery r101) {
            this.f292435b = r100;
            this.f292434a = r101;
        }
    }

    public class c implements Callable<List<com.larus.avlink.gallery.database.a>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f292436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f292437b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<com.larus.avlink.gallery.database.a> call2() throws Exception {
            Cursor r100 = DBUtil.query(this.f292437b.f292427a, this.f292436a, false, null);
            int r101 = CursorUtil.getColumnIndexOrThrow(r100, "id");     // Catch: Throwable -> L71
            int r102 = CursorUtil.getColumnIndexOrThrow(r100, AppConstants.BUNDLE_MEDIA_ID);     // Catch: Throwable -> L71
            int r103 = CursorUtil.getColumnIndexOrThrow(r100, "system_gallery_id");     // Catch: Throwable -> L71
            int r104 = CursorUtil.getColumnIndexOrThrow(r100, "file_name");     // Catch: Throwable -> L71
            int r105 = CursorUtil.getColumnIndexOrThrow(r100, "file_size");     // Catch: Throwable -> L71
            int r106 = CursorUtil.getColumnIndexOrThrow(r100, com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE);     // Catch: Throwable -> L71
            int r107 = CursorUtil.getColumnIndexOrThrow(r100, "width");     // Catch: Throwable -> L71
            int r110 = CursorUtil.getColumnIndexOrThrow(r100, "height");     // Catch: Throwable -> L71
            int r111 = CursorUtil.getColumnIndexOrThrow(r100, "duration");     // Catch: Throwable -> L71
            int r112 = CursorUtil.getColumnIndexOrThrow(r100, "out_video_width");     // Catch: Throwable -> L71
            int r113 = CursorUtil.getColumnIndexOrThrow(r100, "out_video_height");     // Catch: Throwable -> L71
            int r114 = CursorUtil.getColumnIndexOrThrow(r100, "output_video_crop");     // Catch: Throwable -> L71
            int r115 = CursorUtil.getColumnIndexOrThrow(r100, "create_time");     // Catch: Throwable -> L71
            int r108 = CursorUtil.getColumnIndexOrThrow(r100, "geo_location_info");     // Catch: Throwable -> L71
            int r116 = CursorUtil.getColumnIndexOrThrow(r100, "algorithm_type");     // Catch: Throwable -> L69
            int r117 = CursorUtil.getColumnIndexOrThrow(r100, "lifecycle_state");     // Catch: Throwable -> L69
            int r118 = CursorUtil.getColumnIndexOrThrow(r100, FlowNetworkIDLStub.OMNI_UPLOAD_FAILURE_STAGE_KEY);     // Catch: Throwable -> L69
            int r119 = CursorUtil.getColumnIndexOrThrow(r100, "failure_reason");     // Catch: Throwable -> L69
            int r210 = CursorUtil.getColumnIndexOrThrow(r100, "download_file_path");     // Catch: Throwable -> L69
            int r211 = CursorUtil.getColumnIndexOrThrow(r100, "temp_file_path");     // Catch: Throwable -> L69
            int r212 = CursorUtil.getColumnIndexOrThrow(r100, "unpack_dir_path");     // Catch: Throwable -> L69
            int r213 = CursorUtil.getColumnIndexOrThrow(r100, "processed_file_path");     // Catch: Throwable -> L69
            int r214 = CursorUtil.getColumnIndexOrThrow(r100, "final_file_path");     // Catch: Throwable -> L69
            int r215 = CursorUtil.getColumnIndexOrThrow(r100, "active_mask");     // Catch: Throwable -> L69
            int r216 = r108;
            ArrayList r109 = new ArrayList(r100.getCount());     // Catch: Throwable -> L69
        L5:
            if (r100.moveToNext() == false) goto L67;
            if (r100.isNull(r101) == false) goto L10;
            String r217 = null;
        L11:
            long r218 = r100.getLong(r102);     // Catch: Throwable -> L69
            if (r100.isNull(r103) == false) goto L14;
            Long r310 = null;
        L16:
            if (r100.isNull(r104) == false) goto L18;
            String r311 = null;
        L20:
            if (r100.isNull(r105) == false) goto L22;
            Long r312 = null;
        L24:
            if (r100.isNull(r106) == false) goto L26;
            String r313 = null;
        L27:
            int r314 = r100.getInt(r107);     // Catch: Throwable -> L69
            int r315 = r100.getInt(r110);     // Catch: Throwable -> L69
            long r316 = r100.getLong(r111);     // Catch: Throwable -> L69
            int r317 = r100.getInt(r112);     // Catch: Throwable -> L69
            int r410 = r100.getInt(r113);     // Catch: Throwable -> L69
            double r411 = r100.getDouble(r114);     // Catch: Throwable -> L69
            long r412 = r100.getLong(r115);     // Catch: Throwable -> L69
            int r120 = r216;
            if (r100.isNull(r120) == false) goto L31;
            String r413 = null;
        L30:
            int r510 = r116;
            int r121 = r101;
            if (r100.isNull(r510) == false) goto L36;
            String r414 = null;
        L35:
            int r511 = r117;
            int r415 = r100.getInt(r511);     // Catch: Throwable -> L69
            r118 = r118;
            if (r100.isNull(r118) == false) goto L40;
            Integer r416 = null;
        L42:
            if (r100.isNull(r119) == false) goto L44;
            String r417 = null;
        L46:
            if (r100.isNull(r210) == false) goto L48;
            String r512 = null;
        L50:
            if (r100.isNull(r211) == false) goto L52;
            String r513 = null;
        L54:
            if (r100.isNull(r212) == false) goto L56;
            String r514 = null;
        L58:
            if (r100.isNull(r213) == false) goto L60;
            String r515 = null;
        L62:
            if (r100.isNull(r214) == false) goto L64;
            String r516 = null;
        L65:
            int r517 = r100.getInt(r215);     // Catch: Throwable -> L69
            r215 = r215;
            r109.add(new com.larus.avlink.gallery.database.a(r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, r413, r414, r415, r416, r417, r512, r513, r514, r515, r516, r517));     // Catch: Throwable -> L69
            r101 = r121;
            r116 = r510;
            r117 = r511;
            r216 = r120;
            goto L5
        L64:
            r516 = r100.getString(r214);     // Catch: Throwable -> L69
            goto L65
        L60:
            r515 = r100.getString(r213);     // Catch: Throwable -> L69
            goto L62
        L56:
            r514 = r100.getString(r212);     // Catch: Throwable -> L69
            goto L58
        L52:
            r513 = r100.getString(r211);     // Catch: Throwable -> L69
            goto L54
        L48:
            r512 = r100.getString(r210);     // Catch: Throwable -> L69
            goto L50
        L44:
            r417 = r100.getString(r119);     // Catch: Throwable -> L69
            goto L46
        L40:
            r416 = Integer.valueOf(r100.getInt(r118));     // Catch: Throwable -> L69
            goto L42
        L36:
            r414 = r100.getString(r510);     // Catch: Throwable -> L69
            goto L35
        L31:
            r413 = r100.getString(r120);     // Catch: Throwable -> L69
            goto L30
        L26:
            r313 = r100.getString(r106);     // Catch: Throwable -> L69
            goto L27
        L22:
            r312 = Long.valueOf(r100.getLong(r105));     // Catch: Throwable -> L69
            goto L24
        L18:
            r311 = r100.getString(r104);     // Catch: Throwable -> L69
            goto L20
        L14:
            r310 = Long.valueOf(r100.getLong(r103));     // Catch: Throwable -> L69
            goto L16
        L10:
            r217 = r100.getString(r101);     // Catch: Throwable -> L69
            goto L11
        L67:
            r100.close();
            this.f292436a.release();
            return r109;
        L69:
            th = th;
            c r122 = this;
        L73:
            r100.close();
            r122.f292436a.release();
            throw th;
        L71:
            th = th;
            r122 = this;
            goto L73
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<com.larus.avlink.gallery.database.a> call() throws Exception {
            return call2();
        }

        public c(d r100, RoomSQLiteQuery r101) {
            this.f292437b = r100;
            this.f292436a = r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.gallery.database.d$d, reason: collision with other inner class name */
    public class CallableC3991d implements Callable<List<com.larus.avlink.gallery.database.a>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f292438a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f292439b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<com.larus.avlink.gallery.database.a> call2() throws Exception {
            Cursor r100 = DBUtil.query(this.f292439b.f292427a, this.f292438a, false, null);
            int r101 = CursorUtil.getColumnIndexOrThrow(r100, "id");     // Catch: Throwable -> L71
            int r102 = CursorUtil.getColumnIndexOrThrow(r100, AppConstants.BUNDLE_MEDIA_ID);     // Catch: Throwable -> L71
            int r103 = CursorUtil.getColumnIndexOrThrow(r100, "system_gallery_id");     // Catch: Throwable -> L71
            int r104 = CursorUtil.getColumnIndexOrThrow(r100, "file_name");     // Catch: Throwable -> L71
            int r105 = CursorUtil.getColumnIndexOrThrow(r100, "file_size");     // Catch: Throwable -> L71
            int r106 = CursorUtil.getColumnIndexOrThrow(r100, com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE);     // Catch: Throwable -> L71
            int r107 = CursorUtil.getColumnIndexOrThrow(r100, "width");     // Catch: Throwable -> L71
            int r110 = CursorUtil.getColumnIndexOrThrow(r100, "height");     // Catch: Throwable -> L71
            int r111 = CursorUtil.getColumnIndexOrThrow(r100, "duration");     // Catch: Throwable -> L71
            int r112 = CursorUtil.getColumnIndexOrThrow(r100, "out_video_width");     // Catch: Throwable -> L71
            int r113 = CursorUtil.getColumnIndexOrThrow(r100, "out_video_height");     // Catch: Throwable -> L71
            int r114 = CursorUtil.getColumnIndexOrThrow(r100, "output_video_crop");     // Catch: Throwable -> L71
            int r115 = CursorUtil.getColumnIndexOrThrow(r100, "create_time");     // Catch: Throwable -> L71
            int r108 = CursorUtil.getColumnIndexOrThrow(r100, "geo_location_info");     // Catch: Throwable -> L71
            int r116 = CursorUtil.getColumnIndexOrThrow(r100, "algorithm_type");     // Catch: Throwable -> L69
            int r117 = CursorUtil.getColumnIndexOrThrow(r100, "lifecycle_state");     // Catch: Throwable -> L69
            int r118 = CursorUtil.getColumnIndexOrThrow(r100, FlowNetworkIDLStub.OMNI_UPLOAD_FAILURE_STAGE_KEY);     // Catch: Throwable -> L69
            int r119 = CursorUtil.getColumnIndexOrThrow(r100, "failure_reason");     // Catch: Throwable -> L69
            int r210 = CursorUtil.getColumnIndexOrThrow(r100, "download_file_path");     // Catch: Throwable -> L69
            int r211 = CursorUtil.getColumnIndexOrThrow(r100, "temp_file_path");     // Catch: Throwable -> L69
            int r212 = CursorUtil.getColumnIndexOrThrow(r100, "unpack_dir_path");     // Catch: Throwable -> L69
            int r213 = CursorUtil.getColumnIndexOrThrow(r100, "processed_file_path");     // Catch: Throwable -> L69
            int r214 = CursorUtil.getColumnIndexOrThrow(r100, "final_file_path");     // Catch: Throwable -> L69
            int r215 = CursorUtil.getColumnIndexOrThrow(r100, "active_mask");     // Catch: Throwable -> L69
            int r216 = r108;
            ArrayList r109 = new ArrayList(r100.getCount());     // Catch: Throwable -> L69
        L5:
            if (r100.moveToNext() == false) goto L67;
            if (r100.isNull(r101) == false) goto L10;
            String r217 = null;
        L11:
            long r218 = r100.getLong(r102);     // Catch: Throwable -> L69
            if (r100.isNull(r103) == false) goto L14;
            Long r310 = null;
        L16:
            if (r100.isNull(r104) == false) goto L18;
            String r311 = null;
        L20:
            if (r100.isNull(r105) == false) goto L22;
            Long r312 = null;
        L24:
            if (r100.isNull(r106) == false) goto L26;
            String r313 = null;
        L27:
            int r314 = r100.getInt(r107);     // Catch: Throwable -> L69
            int r315 = r100.getInt(r110);     // Catch: Throwable -> L69
            long r316 = r100.getLong(r111);     // Catch: Throwable -> L69
            int r317 = r100.getInt(r112);     // Catch: Throwable -> L69
            int r410 = r100.getInt(r113);     // Catch: Throwable -> L69
            double r411 = r100.getDouble(r114);     // Catch: Throwable -> L69
            long r412 = r100.getLong(r115);     // Catch: Throwable -> L69
            int r120 = r216;
            if (r100.isNull(r120) == false) goto L31;
            String r413 = null;
        L30:
            int r510 = r116;
            int r121 = r101;
            if (r100.isNull(r510) == false) goto L36;
            String r414 = null;
        L35:
            int r511 = r117;
            int r415 = r100.getInt(r511);     // Catch: Throwable -> L69
            r118 = r118;
            if (r100.isNull(r118) == false) goto L40;
            Integer r416 = null;
        L42:
            if (r100.isNull(r119) == false) goto L44;
            String r417 = null;
        L46:
            if (r100.isNull(r210) == false) goto L48;
            String r512 = null;
        L50:
            if (r100.isNull(r211) == false) goto L52;
            String r513 = null;
        L54:
            if (r100.isNull(r212) == false) goto L56;
            String r514 = null;
        L58:
            if (r100.isNull(r213) == false) goto L60;
            String r515 = null;
        L62:
            if (r100.isNull(r214) == false) goto L64;
            String r516 = null;
        L65:
            int r517 = r100.getInt(r215);     // Catch: Throwable -> L69
            r215 = r215;
            r109.add(new com.larus.avlink.gallery.database.a(r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, r413, r414, r415, r416, r417, r512, r513, r514, r515, r516, r517));     // Catch: Throwable -> L69
            r101 = r121;
            r116 = r510;
            r117 = r511;
            r216 = r120;
            goto L5
        L64:
            r516 = r100.getString(r214);     // Catch: Throwable -> L69
            goto L65
        L60:
            r515 = r100.getString(r213);     // Catch: Throwable -> L69
            goto L62
        L56:
            r514 = r100.getString(r212);     // Catch: Throwable -> L69
            goto L58
        L52:
            r513 = r100.getString(r211);     // Catch: Throwable -> L69
            goto L54
        L48:
            r512 = r100.getString(r210);     // Catch: Throwable -> L69
            goto L50
        L44:
            r417 = r100.getString(r119);     // Catch: Throwable -> L69
            goto L46
        L40:
            r416 = Integer.valueOf(r100.getInt(r118));     // Catch: Throwable -> L69
            goto L42
        L36:
            r414 = r100.getString(r510);     // Catch: Throwable -> L69
            goto L35
        L31:
            r413 = r100.getString(r120);     // Catch: Throwable -> L69
            goto L30
        L26:
            r313 = r100.getString(r106);     // Catch: Throwable -> L69
            goto L27
        L22:
            r312 = Long.valueOf(r100.getLong(r105));     // Catch: Throwable -> L69
            goto L24
        L18:
            r311 = r100.getString(r104);     // Catch: Throwable -> L69
            goto L20
        L14:
            r310 = Long.valueOf(r100.getLong(r103));     // Catch: Throwable -> L69
            goto L16
        L10:
            r217 = r100.getString(r101);     // Catch: Throwable -> L69
            goto L11
        L67:
            r100.close();
            this.f292438a.release();
            return r109;
        L69:
            th = th;
            CallableC3991d r122 = this;
        L73:
            r100.close();
            r122.f292438a.release();
            throw th;
        L71:
            th = th;
            r122 = this;
            goto L73
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<com.larus.avlink.gallery.database.a> call() throws Exception {
            return call2();
        }

        public CallableC3991d(d r100, RoomSQLiteQuery r101) {
            this.f292439b = r100;
            this.f292438a = r101;
        }
    }

    public class e implements Callable<List<com.larus.avlink.gallery.database.a>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f292440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f292441b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<com.larus.avlink.gallery.database.a> call2() throws Exception {
            Cursor r100 = DBUtil.query(this.f292441b.f292427a, this.f292440a, false, null);
            int r101 = CursorUtil.getColumnIndexOrThrow(r100, "id");     // Catch: Throwable -> L71
            int r102 = CursorUtil.getColumnIndexOrThrow(r100, AppConstants.BUNDLE_MEDIA_ID);     // Catch: Throwable -> L71
            int r103 = CursorUtil.getColumnIndexOrThrow(r100, "system_gallery_id");     // Catch: Throwable -> L71
            int r104 = CursorUtil.getColumnIndexOrThrow(r100, "file_name");     // Catch: Throwable -> L71
            int r105 = CursorUtil.getColumnIndexOrThrow(r100, "file_size");     // Catch: Throwable -> L71
            int r106 = CursorUtil.getColumnIndexOrThrow(r100, com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE);     // Catch: Throwable -> L71
            int r107 = CursorUtil.getColumnIndexOrThrow(r100, "width");     // Catch: Throwable -> L71
            int r110 = CursorUtil.getColumnIndexOrThrow(r100, "height");     // Catch: Throwable -> L71
            int r111 = CursorUtil.getColumnIndexOrThrow(r100, "duration");     // Catch: Throwable -> L71
            int r112 = CursorUtil.getColumnIndexOrThrow(r100, "out_video_width");     // Catch: Throwable -> L71
            int r113 = CursorUtil.getColumnIndexOrThrow(r100, "out_video_height");     // Catch: Throwable -> L71
            int r114 = CursorUtil.getColumnIndexOrThrow(r100, "output_video_crop");     // Catch: Throwable -> L71
            int r115 = CursorUtil.getColumnIndexOrThrow(r100, "create_time");     // Catch: Throwable -> L71
            int r108 = CursorUtil.getColumnIndexOrThrow(r100, "geo_location_info");     // Catch: Throwable -> L71
            int r116 = CursorUtil.getColumnIndexOrThrow(r100, "algorithm_type");     // Catch: Throwable -> L69
            int r117 = CursorUtil.getColumnIndexOrThrow(r100, "lifecycle_state");     // Catch: Throwable -> L69
            int r118 = CursorUtil.getColumnIndexOrThrow(r100, FlowNetworkIDLStub.OMNI_UPLOAD_FAILURE_STAGE_KEY);     // Catch: Throwable -> L69
            int r119 = CursorUtil.getColumnIndexOrThrow(r100, "failure_reason");     // Catch: Throwable -> L69
            int r210 = CursorUtil.getColumnIndexOrThrow(r100, "download_file_path");     // Catch: Throwable -> L69
            int r211 = CursorUtil.getColumnIndexOrThrow(r100, "temp_file_path");     // Catch: Throwable -> L69
            int r212 = CursorUtil.getColumnIndexOrThrow(r100, "unpack_dir_path");     // Catch: Throwable -> L69
            int r213 = CursorUtil.getColumnIndexOrThrow(r100, "processed_file_path");     // Catch: Throwable -> L69
            int r214 = CursorUtil.getColumnIndexOrThrow(r100, "final_file_path");     // Catch: Throwable -> L69
            int r215 = CursorUtil.getColumnIndexOrThrow(r100, "active_mask");     // Catch: Throwable -> L69
            int r216 = r108;
            ArrayList r109 = new ArrayList(r100.getCount());     // Catch: Throwable -> L69
        L5:
            if (r100.moveToNext() == false) goto L67;
            if (r100.isNull(r101) == false) goto L10;
            String r217 = null;
        L11:
            long r218 = r100.getLong(r102);     // Catch: Throwable -> L69
            if (r100.isNull(r103) == false) goto L14;
            Long r310 = null;
        L16:
            if (r100.isNull(r104) == false) goto L18;
            String r311 = null;
        L20:
            if (r100.isNull(r105) == false) goto L22;
            Long r312 = null;
        L24:
            if (r100.isNull(r106) == false) goto L26;
            String r313 = null;
        L27:
            int r314 = r100.getInt(r107);     // Catch: Throwable -> L69
            int r315 = r100.getInt(r110);     // Catch: Throwable -> L69
            long r316 = r100.getLong(r111);     // Catch: Throwable -> L69
            int r317 = r100.getInt(r112);     // Catch: Throwable -> L69
            int r410 = r100.getInt(r113);     // Catch: Throwable -> L69
            double r411 = r100.getDouble(r114);     // Catch: Throwable -> L69
            long r412 = r100.getLong(r115);     // Catch: Throwable -> L69
            int r120 = r216;
            if (r100.isNull(r120) == false) goto L31;
            String r413 = null;
        L30:
            int r510 = r116;
            int r121 = r101;
            if (r100.isNull(r510) == false) goto L36;
            String r414 = null;
        L35:
            int r511 = r117;
            int r415 = r100.getInt(r511);     // Catch: Throwable -> L69
            r118 = r118;
            if (r100.isNull(r118) == false) goto L40;
            Integer r416 = null;
        L42:
            if (r100.isNull(r119) == false) goto L44;
            String r417 = null;
        L46:
            if (r100.isNull(r210) == false) goto L48;
            String r512 = null;
        L50:
            if (r100.isNull(r211) == false) goto L52;
            String r513 = null;
        L54:
            if (r100.isNull(r212) == false) goto L56;
            String r514 = null;
        L58:
            if (r100.isNull(r213) == false) goto L60;
            String r515 = null;
        L62:
            if (r100.isNull(r214) == false) goto L64;
            String r516 = null;
        L65:
            int r517 = r100.getInt(r215);     // Catch: Throwable -> L69
            r215 = r215;
            r109.add(new com.larus.avlink.gallery.database.a(r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, r413, r414, r415, r416, r417, r512, r513, r514, r515, r516, r517));     // Catch: Throwable -> L69
            r101 = r121;
            r116 = r510;
            r117 = r511;
            r216 = r120;
            goto L5
        L64:
            r516 = r100.getString(r214);     // Catch: Throwable -> L69
            goto L65
        L60:
            r515 = r100.getString(r213);     // Catch: Throwable -> L69
            goto L62
        L56:
            r514 = r100.getString(r212);     // Catch: Throwable -> L69
            goto L58
        L52:
            r513 = r100.getString(r211);     // Catch: Throwable -> L69
            goto L54
        L48:
            r512 = r100.getString(r210);     // Catch: Throwable -> L69
            goto L50
        L44:
            r417 = r100.getString(r119);     // Catch: Throwable -> L69
            goto L46
        L40:
            r416 = Integer.valueOf(r100.getInt(r118));     // Catch: Throwable -> L69
            goto L42
        L36:
            r414 = r100.getString(r510);     // Catch: Throwable -> L69
            goto L35
        L31:
            r413 = r100.getString(r120);     // Catch: Throwable -> L69
            goto L30
        L26:
            r313 = r100.getString(r106);     // Catch: Throwable -> L69
            goto L27
        L22:
            r312 = Long.valueOf(r100.getLong(r105));     // Catch: Throwable -> L69
            goto L24
        L18:
            r311 = r100.getString(r104);     // Catch: Throwable -> L69
            goto L20
        L14:
            r310 = Long.valueOf(r100.getLong(r103));     // Catch: Throwable -> L69
            goto L16
        L10:
            r217 = r100.getString(r101);     // Catch: Throwable -> L69
            goto L11
        L67:
            r100.close();
            this.f292440a.release();
            return r109;
        L69:
            th = th;
            e r122 = this;
        L73:
            r100.close();
            r122.f292440a.release();
            throw th;
        L71:
            th = th;
            r122 = this;
            goto L73
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<com.larus.avlink.gallery.database.a> call() throws Exception {
            return call2();
        }

        public e(d r100, RoomSQLiteQuery r101) {
            this.f292441b = r100;
            this.f292440a = r101;
        }
    }

    public class f implements Callable<com.larus.avlink.gallery.database.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f292442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f292443b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.larus.avlink.gallery.database.a call() throws Exception {
            f r100 = this;
            Cursor r101 = DBUtil.query(r100.f292443b.f292427a, r100.f292442a, false, null);
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
            com.larus.avlink.gallery.database.a r126 = null;
        L65:
            r101.close();
            this.f292442a.release();
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
            r126 = new com.larus.avlink.gallery.database.a(r210, r211, r212, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r413, r414, r415, r416, r417, r510, r511, r512, r101.getInt(r125));     // Catch: Throwable -> L67
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
            r100.f292442a.release();
            throw th;
        L69:
            th = th;
            goto L70
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ com.larus.avlink.gallery.database.a call() throws Exception {
            return call();
        }

        public f(d r100, RoomSQLiteQuery r101) {
            this.f292443b = r100;
            this.f292442a = r101;
        }
    }

    public class g implements Callable<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f292444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f292445b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            StringBuilder r100 = StringUtil.newStringBuilder();
            r100.append("DELETE FROM 'media_metadata_table' WHERE id IN (");
            StringUtil.appendPlaceholders(r100, this.f292444a.size());
            r100.append(")");
            String r101 = r100.toString();
            SupportSQLiteStatement r102 = this.f292445b.f292427a.compileStatement(r101);
            Iterator r103 = this.f292444a.iterator();
            int r104 = 1;
        L4:
            if (r103.hasNext() == false) goto L10;
            String r105 = (String) r103.next();
            if (r105 != null) goto L8;
            r102.bindNull(r104);
        L9:
            r104 = r104 + 1;
            goto L4
        L8:
            r102.bindString(r104, r105);
            goto L9
        L10:
            this.f292445b.f292427a.beginTransaction();
            Integer r106 = Integer.valueOf(r102.executeUpdateDelete());     // Catch: Throwable -> L14
            this.f292445b.f292427a.setTransactionSuccessful();     // Catch: Throwable -> L14
            this.f292445b.f292427a.endTransaction();
            return r106;
        L14:
            th = move-exception;
            this.f292445b.f292427a.endTransaction();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Integer call() throws Exception {
            return call();
        }

        public g(d r100, List r101) {
            this.f292445b = r100;
            this.f292444a = r101;
        }
    }

    public class h implements Callable<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.larus.avlink.gallery.database.a f292446a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f292447b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Long call() throws Exception {
            this.f292447b.f292427a.beginTransaction();
            long r100 = this.f292447b.f292428b.insertAndReturnId(this.f292446a);     // Catch: Throwable -> L6
            this.f292447b.f292427a.setTransactionSuccessful();     // Catch: Throwable -> L6
            Long r101 = Long.valueOf(r100);     // Catch: Throwable -> L6
            this.f292447b.f292427a.endTransaction();
            return r101;
        L6:
            th = move-exception;
            this.f292447b.f292427a.endTransaction();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Long call() throws Exception {
            return call();
        }

        public h(d r100, com.larus.avlink.gallery.database.a r101) {
            this.f292447b = r100;
            this.f292446a = r101;
        }
    }

    public class i implements Callable<List<Long>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f292448a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f292449b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<Long> call2() throws Exception {
            this.f292449b.f292427a.beginTransaction();
            List<Long> r100 = this.f292449b.f292429c.insertAndReturnIdsList(this.f292448a);     // Catch: Throwable -> L6
            this.f292449b.f292427a.setTransactionSuccessful();     // Catch: Throwable -> L6
            this.f292449b.f292427a.endTransaction();
            return r100;
        L6:
            th = move-exception;
            this.f292449b.f292427a.endTransaction();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<Long> call() throws Exception {
            return call2();
        }

        public i(d r100, List r101) {
            this.f292449b = r100;
            this.f292448a = r101;
        }
    }

    public class j implements Callable<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f292450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f292451b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            SupportSQLiteStatement r100 = this.f292451b.f292431e.acquire();
            String r101 = this.f292450a;
            if (r101 != null) goto L5;
            r100.bindNull(1);
        L6:
            this.f292451b.f292427a.beginTransaction();
            Integer r102 = Integer.valueOf(r100.executeUpdateDelete());     // Catch: Throwable -> L10
            this.f292451b.f292427a.setTransactionSuccessful();     // Catch: Throwable -> L10
            this.f292451b.f292427a.endTransaction();
            this.f292451b.f292431e.release(r100);
            return r102;
        L10:
            th = move-exception;
            this.f292451b.f292427a.endTransaction();
            this.f292451b.f292431e.release(r100);
            throw th;
        L5:
            r100.bindString(1, r101);
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Integer call() throws Exception {
            return call();
        }

        public j(d r100, String r101) {
            this.f292451b = r100;
            this.f292450a = r101;
        }
    }

    public class k implements Callable<List<com.larus.avlink.gallery.database.a>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f292452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f292453b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<com.larus.avlink.gallery.database.a> call2() throws Exception {
            Cursor r100 = DBUtil.query(this.f292453b.f292427a, this.f292452a, false, null);
            int r101 = CursorUtil.getColumnIndexOrThrow(r100, "id");     // Catch: Throwable -> L71
            int r102 = CursorUtil.getColumnIndexOrThrow(r100, AppConstants.BUNDLE_MEDIA_ID);     // Catch: Throwable -> L71
            int r103 = CursorUtil.getColumnIndexOrThrow(r100, "system_gallery_id");     // Catch: Throwable -> L71
            int r104 = CursorUtil.getColumnIndexOrThrow(r100, "file_name");     // Catch: Throwable -> L71
            int r105 = CursorUtil.getColumnIndexOrThrow(r100, "file_size");     // Catch: Throwable -> L71
            int r106 = CursorUtil.getColumnIndexOrThrow(r100, com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE);     // Catch: Throwable -> L71
            int r107 = CursorUtil.getColumnIndexOrThrow(r100, "width");     // Catch: Throwable -> L71
            int r110 = CursorUtil.getColumnIndexOrThrow(r100, "height");     // Catch: Throwable -> L71
            int r111 = CursorUtil.getColumnIndexOrThrow(r100, "duration");     // Catch: Throwable -> L71
            int r112 = CursorUtil.getColumnIndexOrThrow(r100, "out_video_width");     // Catch: Throwable -> L71
            int r113 = CursorUtil.getColumnIndexOrThrow(r100, "out_video_height");     // Catch: Throwable -> L71
            int r114 = CursorUtil.getColumnIndexOrThrow(r100, "output_video_crop");     // Catch: Throwable -> L71
            int r115 = CursorUtil.getColumnIndexOrThrow(r100, "create_time");     // Catch: Throwable -> L71
            int r108 = CursorUtil.getColumnIndexOrThrow(r100, "geo_location_info");     // Catch: Throwable -> L71
            int r116 = CursorUtil.getColumnIndexOrThrow(r100, "algorithm_type");     // Catch: Throwable -> L69
            int r117 = CursorUtil.getColumnIndexOrThrow(r100, "lifecycle_state");     // Catch: Throwable -> L69
            int r118 = CursorUtil.getColumnIndexOrThrow(r100, FlowNetworkIDLStub.OMNI_UPLOAD_FAILURE_STAGE_KEY);     // Catch: Throwable -> L69
            int r119 = CursorUtil.getColumnIndexOrThrow(r100, "failure_reason");     // Catch: Throwable -> L69
            int r210 = CursorUtil.getColumnIndexOrThrow(r100, "download_file_path");     // Catch: Throwable -> L69
            int r211 = CursorUtil.getColumnIndexOrThrow(r100, "temp_file_path");     // Catch: Throwable -> L69
            int r212 = CursorUtil.getColumnIndexOrThrow(r100, "unpack_dir_path");     // Catch: Throwable -> L69
            int r213 = CursorUtil.getColumnIndexOrThrow(r100, "processed_file_path");     // Catch: Throwable -> L69
            int r214 = CursorUtil.getColumnIndexOrThrow(r100, "final_file_path");     // Catch: Throwable -> L69
            int r215 = CursorUtil.getColumnIndexOrThrow(r100, "active_mask");     // Catch: Throwable -> L69
            int r216 = r108;
            ArrayList r109 = new ArrayList(r100.getCount());     // Catch: Throwable -> L69
        L5:
            if (r100.moveToNext() == false) goto L67;
            if (r100.isNull(r101) == false) goto L10;
            String r217 = null;
        L11:
            long r218 = r100.getLong(r102);     // Catch: Throwable -> L69
            if (r100.isNull(r103) == false) goto L14;
            Long r310 = null;
        L16:
            if (r100.isNull(r104) == false) goto L18;
            String r311 = null;
        L20:
            if (r100.isNull(r105) == false) goto L22;
            Long r312 = null;
        L24:
            if (r100.isNull(r106) == false) goto L26;
            String r313 = null;
        L27:
            int r314 = r100.getInt(r107);     // Catch: Throwable -> L69
            int r315 = r100.getInt(r110);     // Catch: Throwable -> L69
            long r316 = r100.getLong(r111);     // Catch: Throwable -> L69
            int r317 = r100.getInt(r112);     // Catch: Throwable -> L69
            int r410 = r100.getInt(r113);     // Catch: Throwable -> L69
            double r411 = r100.getDouble(r114);     // Catch: Throwable -> L69
            long r412 = r100.getLong(r115);     // Catch: Throwable -> L69
            int r120 = r216;
            if (r100.isNull(r120) == false) goto L31;
            String r413 = null;
        L30:
            int r510 = r116;
            int r121 = r101;
            if (r100.isNull(r510) == false) goto L36;
            String r414 = null;
        L35:
            int r511 = r117;
            int r415 = r100.getInt(r511);     // Catch: Throwable -> L69
            r118 = r118;
            if (r100.isNull(r118) == false) goto L40;
            Integer r416 = null;
        L42:
            if (r100.isNull(r119) == false) goto L44;
            String r417 = null;
        L46:
            if (r100.isNull(r210) == false) goto L48;
            String r512 = null;
        L50:
            if (r100.isNull(r211) == false) goto L52;
            String r513 = null;
        L54:
            if (r100.isNull(r212) == false) goto L56;
            String r514 = null;
        L58:
            if (r100.isNull(r213) == false) goto L60;
            String r515 = null;
        L62:
            if (r100.isNull(r214) == false) goto L64;
            String r516 = null;
        L65:
            int r517 = r100.getInt(r215);     // Catch: Throwable -> L69
            r215 = r215;
            r109.add(new com.larus.avlink.gallery.database.a(r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, r413, r414, r415, r416, r417, r512, r513, r514, r515, r516, r517));     // Catch: Throwable -> L69
            r101 = r121;
            r116 = r510;
            r117 = r511;
            r216 = r120;
            goto L5
        L64:
            r516 = r100.getString(r214);     // Catch: Throwable -> L69
            goto L65
        L60:
            r515 = r100.getString(r213);     // Catch: Throwable -> L69
            goto L62
        L56:
            r514 = r100.getString(r212);     // Catch: Throwable -> L69
            goto L58
        L52:
            r513 = r100.getString(r211);     // Catch: Throwable -> L69
            goto L54
        L48:
            r512 = r100.getString(r210);     // Catch: Throwable -> L69
            goto L50
        L44:
            r417 = r100.getString(r119);     // Catch: Throwable -> L69
            goto L46
        L40:
            r416 = Integer.valueOf(r100.getInt(r118));     // Catch: Throwable -> L69
            goto L42
        L36:
            r414 = r100.getString(r510);     // Catch: Throwable -> L69
            goto L35
        L31:
            r413 = r100.getString(r120);     // Catch: Throwable -> L69
            goto L30
        L26:
            r313 = r100.getString(r106);     // Catch: Throwable -> L69
            goto L27
        L22:
            r312 = Long.valueOf(r100.getLong(r105));     // Catch: Throwable -> L69
            goto L24
        L18:
            r311 = r100.getString(r104);     // Catch: Throwable -> L69
            goto L20
        L14:
            r310 = Long.valueOf(r100.getLong(r103));     // Catch: Throwable -> L69
            goto L16
        L10:
            r217 = r100.getString(r101);     // Catch: Throwable -> L69
            goto L11
        L67:
            r100.close();
            this.f292452a.release();
            return r109;
        L69:
            th = th;
            k r122 = this;
        L73:
            r100.close();
            r122.f292452a.release();
            throw th;
        L71:
            th = th;
            r122 = this;
            goto L73
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<com.larus.avlink.gallery.database.a> call() throws Exception {
            return call2();
        }

        public k(d r100, RoomSQLiteQuery r101) {
            this.f292453b = r100;
            this.f292452a = r101;
        }
    }

    public class l implements Callable<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f292454a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f292455b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            Cursor r100 = DBUtil.query(this.f292455b.f292427a, this.f292454a, false, null);
        L9:
            th = move-exception;
            r100.close();
            this.f292454a.release();
            throw th;
        L4:
            if (r100.moveToFirst() == false) goto L6;
            int r101 = Integer.valueOf(r100.getInt(0));     // Catch: Throwable -> L9
        L7:
            r100.close();
            this.f292454a.release();
            return r101;
        L6:
            r101 = 0;     // Catch: Throwable -> L9
            goto L7
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Integer call() throws Exception {
            return call();
        }

        public l(d r100, RoomSQLiteQuery r101) {
            this.f292455b = r100;
            this.f292454a = r101;
        }
    }

    public d(AlbumDatabase r100) {
        this.f292427a = r100;
        this.f292428b = new com.larus.avlink.gallery.database.e(r100);
        this.f292429c = new com.larus.avlink.gallery.database.f(r100);
        this.f292430d = new com.larus.avlink.gallery.database.g(r100);
        this.f292431e = new com.larus.avlink.gallery.database.h(r100);
    }

    @Override // com.larus.avlink.gallery.database.b
    public final int a(com.larus.avlink.gallery.database.a r100) {
        this.f292427a.assertNotSuspendingTransaction();
        this.f292427a.beginTransaction();
        int r101 = this.f292430d.handle(r100) + 0;     // Catch: Throwable -> L6
        this.f292427a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f292427a.endTransaction();
        return r101;
    L6:
        th = move-exception;
        this.f292427a.endTransaction();
        throw th;
    }

    @Override // com.larus.avlink.gallery.database.b
    public final Object f(Continuation<? super Integer> r100) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM 'media_metadata_table'", 0);
        CancellationSignal r102 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f292427a, false, r102, new l(this, r101), r100);
    }

    @Override // com.larus.avlink.gallery.database.b
    public final Object h(Continuation<? super List<com.larus.avlink.gallery.database.a>> r100) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT * FROM 'media_metadata_table' ORDER BY create_time DESC", 0);
        CancellationSignal r102 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f292427a, false, r102, new k(this, r101), r100);
    }

    @Override // com.larus.avlink.gallery.database.b
    public final Object b(com.larus.avlink.gallery.database.a r100, Continuation<? super Long> r101) {
        return CoroutinesRoom.execute(this.f292427a, true, new h(this, r100), r101);
    }

    @Override // com.larus.avlink.gallery.database.b
    public final Object c(List<String> r100, Continuation<? super Integer> r101) {
        return CoroutinesRoom.execute(this.f292427a, true, new g(this, r100), r101);
    }

    @Override // com.larus.avlink.gallery.database.b
    public final Object e(List<Long> r100, Continuation<? super List<com.larus.avlink.gallery.database.a>> r101) {
        StringBuilder r102 = StringUtil.newStringBuilder();
        r102.append("SELECT * FROM 'media_metadata_table' WHERE system_gallery_id IN (");
        int r103 = r100.size();
        StringUtil.appendPlaceholders(r102, r103);
        r102.append(")");
        RoomSQLiteQuery r104 = RoomSQLiteQuery.acquire(r102.toString(), r103 + 0);
        Iterator<Long> r105 = r100.iterator();
        int r106 = 1;
    L4:
        if (r105.hasNext() == false) goto L6;
        r104.bindLong(r106, r105.next().longValue());
        r106 = r106 + 1;
        goto L4
    L6:
        CancellationSignal r107 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f292427a, false, r107, new e(this, r104), r101);
    }

    @Override // com.larus.avlink.gallery.database.b
    public final Object g(List<com.larus.avlink.gallery.database.a> r100, Continuation<? super List<Long>> r101) {
        return CoroutinesRoom.execute(this.f292427a, true, new i(this, r100), r101);
    }

    @Override // com.larus.avlink.gallery.database.b
    public final Object i(int r100, Continuation<? super List<com.larus.avlink.gallery.database.a>> r101) {
        RoomSQLiteQuery r102 = RoomSQLiteQuery.acquire("SELECT * FROM 'media_metadata_table' WHERE lifecycle_state = ?", 1);
        r102.bindLong(1, r100);
        return CoroutinesRoom.execute(this.f292427a, false, DBUtil.createCancellationSignal(), new b(this, r102), r101);
    }

    @Override // com.larus.avlink.gallery.database.b
    public final Object j(String r100, Continuation<? super com.larus.avlink.gallery.database.a> r101) {
        RoomSQLiteQuery r102 = RoomSQLiteQuery.acquire("\n        SELECT *\n        FROM 'media_metadata_table'\n        WHERE download_file_path = ?\n        OR temp_file_path = ?\n        OR unpack_dir_path = ?\n        OR processed_file_path = ?\n        OR final_file_path = ?\n        ORDER BY create_time DESC\n        LIMIT 1\n    ", 5);
        if (r100 != null) goto L5;
        r102.bindNull(1);
    L7:
        if (r100 != null) goto L9;
        r102.bindNull(2);
    L11:
        if (r100 != null) goto L13;
        r102.bindNull(3);
    L15:
        if (r100 != null) goto L17;
        r102.bindNull(4);
    L18:
        if (r100 != null) goto L20;
        r102.bindNull(5);
    L21:
        CancellationSignal r103 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f292427a, false, r103, new f(this, r102), r101);
    L20:
        r102.bindString(5, r100);
        goto L21
    L17:
        r102.bindString(4, r100);
        goto L18
    L13:
        r102.bindString(3, r100);
        goto L15
    L9:
        r102.bindString(2, r100);
        goto L11
    L5:
        r102.bindString(1, r100);
        goto L7
    }

    @Override // com.larus.avlink.gallery.database.b
    public final Object k(String r100, ContinuationImpl r101) {
        RoomSQLiteQuery r102 = RoomSQLiteQuery.acquire("SELECT * FROM 'media_metadata_table' WHERE id = ?", 1);
        if (r100 != null) goto L5;
        r102.bindNull(1);
    L6:
        CancellationSignal r103 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.f292427a, false, r103, new com.larus.avlink.gallery.database.c(this, r102), r101);
    L5:
        r102.bindString(1, r100);
        goto L6
    }

    @Override // com.larus.avlink.gallery.database.b
    public final Object l(List<Integer> r100, Continuation<? super List<com.larus.avlink.gallery.database.a>> r101) {
        StringBuilder r102 = StringUtil.newStringBuilder();
        r102.append("SELECT * FROM 'media_metadata_table' WHERE lifecycle_state IN (");
        ArrayList r103 = (ArrayList) r100;
        int r104 = r103.size();
        StringUtil.appendPlaceholders(r102, r104);
        r102.append(")");
        RoomSQLiteQuery r105 = RoomSQLiteQuery.acquire(r102.toString(), r104 + 0);
        Iterator r106 = r103.iterator();
        int r107 = 1;
    L4:
        if (r106.hasNext() == false) goto L7;
        r105.bindLong(r107, ((Integer) r106.next()).intValue());
        r107 = r107 + 1;
        goto L4
    L7:
        return CoroutinesRoom.execute(this.f292427a, false, DBUtil.createCancellationSignal(), new c(this, r105), r101);
    }

    @Override // com.larus.avlink.gallery.database.b
    public final Object m(String r100, Continuation<? super Integer> r101) {
        return CoroutinesRoom.execute(this.f292427a, true, new j(this, r100), r101);
    }

    @Override // com.larus.avlink.gallery.database.b
    public final Object n(int r100, Continuation<? super List<com.larus.avlink.gallery.database.a>> r101) {
        RoomSQLiteQuery r102 = RoomSQLiteQuery.acquire("SELECT * FROM 'media_metadata_table' WHERE lifecycle_state < ?", 1);
        r102.bindLong(1, r100);
        return CoroutinesRoom.execute(this.f292427a, false, DBUtil.createCancellationSignal(), new CallableC3991d(this, r102), r101);
    }

    @Override // com.larus.avlink.gallery.database.b
    public final Object d(int r100, int r101, Continuation<? super List<com.larus.avlink.gallery.database.a>> r102) {
        RoomSQLiteQuery r103 = RoomSQLiteQuery.acquire("SELECT * FROM 'media_metadata_table' ORDER BY create_time DESC LIMIT ? OFFSET ?", 2);
        r103.bindLong(1, r101);
        r103.bindLong(2, r100);
        return CoroutinesRoom.execute(this.f292427a, false, DBUtil.createCancellationSignal(), new a(this, r103), r102);
    }
}
