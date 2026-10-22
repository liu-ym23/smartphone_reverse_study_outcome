package com.bytedance.memory.upload;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.drive.config.fg.DriveVideoPlayConfig;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import ff7.g;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class MomDumpPartUploader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f265504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f265505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f265506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONObject f265507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final JSONObject f265508e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PolarisFileWrapper f265509f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f265510g;

    public static final enum State extends Enum<State> {
        public static final State FAILED = null;
        public static final State FILE_TOO_SMALL = null;
        public static final State SUCCESS = null;
        public static final State TCC_DROP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f265511a = null;

        static {
            State r100 = new State("SUCCESS", 0);
            SUCCESS = r100;
            State r101 = new State("TCC_DROP", 1);
            TCC_DROP = r101;
            State r102 = new State("FILE_TOO_SMALL", 2);
            FILE_TOO_SMALL = r102;
            State r103 = new State("FAILED", 3);
            FAILED = r103;
            f265511a = new State[]{r100, r101, r102, r103};
        }

        public static State[] values() {
            return (State[]) f265511a.clone();
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f265512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<Integer> f265513b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f265514c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f265515d;

        public a(boolean r100, List<Integer> r101, String r102, String r103) {
            this.f265512a = r100;
            this.f265513b = r101;
            this.f265514c = r102;
            this.f265515d = r103;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f265516a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f265517b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f265518c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f265519d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f265520e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f265521f;

        public b(String r100, long r101, long r102, int r103, String r104, String r105) {
            this.f265516a = r100;
            this.f265517b = r101;
            this.f265518c = r102;
            this.f265519d = r103;
            this.f265520e = r104;
            this.f265521f = r105;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f265522a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f265523b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f265524c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f265525d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f265526e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f265527f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f265528g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final List<Integer> f265529h;

        public final JSONObject b() throws JSONException {
            JSONObject r100 = new JSONObject();
            r100.put("upload_id", this.f265522a);
            r100.put("part_size", this.f265523b);
            r100.put("first_part_size", this.f265524c);
            r100.put("part_count", this.f265525d);
            r100.put("file_size", this.f265526e);
            r100.put("init_timestamp", this.f265527f);
            if (TextUtils.isEmpty(this.f265528g) == true) goto L5;
            r100.put("tos_url", this.f265528g);
        L5:
            JSONArray r101 = new JSONArray();
            List<Integer> r102 = this.f265529h;
            if (r102 != null) goto L8;
        L17:
            r100.put("uploaded_parts", r101);
            return r100;
        L8:
            if (((ArrayList) r102).isEmpty() == true) goto L17;
            ArrayList r103 = new ArrayList(this.f265529h);
            Collections.sort(r103);
            Iterator r104 = r103.iterator();
        L11:
            if (r104.hasNext() == false) goto L17;
            Integer r105 = (Integer) r104.next();
            if (r105 == null) goto L11;
            if (r105.intValue() <= 0) goto L11;
            r101.put(r105);
            goto L11
        }

        public c() {
            this.f265529h = new ArrayList();
        }

        public static c a(JSONObject r100) {
            c r101 = new c();
            r101.f265522a = r100.optString("upload_id", null);
            r101.f265523b = r100.optLong("part_size", 0);
            r101.f265524c = r100.optLong("first_part_size", 0);
            int r102 = 0;
            r101.f265525d = r100.optInt("part_count", 0);
            r101.f265526e = r100.optLong("file_size", 0);
            r101.f265527f = r100.optLong("init_timestamp", 0);
            r101.f265528g = r100.optString("tos_url", null);
            JSONArray r103 = r100.optJSONArray("uploaded_parts");
            if (r103 != null) goto L5;
        L12:
            return r101;
        L5:
            if (r102 >= r103.length()) goto L12;
            int r104 = r103.optInt(r102, -1);
            if (r104 <= 0) goto L11;
            List<Integer> r105 = r101.f265529h;
            ArrayList r106 = (ArrayList) r105;
            if (r106.contains(Integer.valueOf(r104)) == true) goto L11;
            List<Integer> r107 = r101.f265529h;
            ArrayList r108 = (ArrayList) r107;
            r108.add(Integer.valueOf(r104));
        L11:
            r102 = r102 + 1;
            goto L5
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final State f265530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f265531b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f265532c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f265533d;

        public d(State r100, String r101, String r102, boolean r103) {
            this.f265530a = r100;
            this.f265531b = r101;
            this.f265532c = r102;
            this.f265533d = r103;
        }
    }

    public final b e() {
        String r100 = this.f265505b + "/monitor/collect/c/mom_dump_collect_part/init";
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L20
        r101.put("header", this.f265507d);     // Catch: Throwable -> L20
        r101.put("data", this.f265508e);     // Catch: Throwable -> L20
        r101.put("file_size", this.f265506c.length());     // Catch: Throwable -> L20
        r101.put("part_size", DriveVideoPlayConfig.DEFAULT_BITRATE);     // Catch: Throwable -> L20
        ff7.b r102 = com.bytedance.apm.d.a(r100, r101.toString().getBytes("UTF-8"), null);     // Catch: Throwable -> L20
        if (r102 != null) goto L6;
    L19:
        return null;
    L6:
        if (r102.f476667a != 200) goto L19;
        byte[] r103 = r102.f476669c;     // Catch: Throwable -> L20
        if (r103 == null) goto L19;
        String r104 = new String(r103, "UTF-8");     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r104) == false) goto L13;
        return null;
    L13:
        JSONObject r105 = new JSONObject(r104);     // Catch: Throwable -> L20
        String r110 = r105.optString("real_message", "");     // Catch: Throwable -> L20
        JSONObject r106 = r105.optJSONObject("data");     // Catch: Throwable -> L20
        if (r106 != null) goto L18;
        return new b(null, 0, 0, 0, null, r110);
    L18:
        return new b(r106.optString("upload_id", null), r106.optLong("part_size", DriveVideoPlayConfig.DEFAULT_BITRATE), r106.optLong("first_part_size", 0), r106.optInt("part_count", 0), r106.optString("tos_url", null), r110);
    L20:
        th = move-exception;
        r17.c.a(th, "MomDumpPartUploader init error", new Object[0]);
        return null;
    }

    public final PolarisFileWrapper f() {
        File r100 = this.f265506c;
        if (r100 == null) goto L5;
        File r101 = r100.getParentFile();
    L6:
        if (r101 != null) goto L9;
        return null;
    L9:
        return new PolarisFileWrapper(r101, this.f265506c.getName() + ".momdump.partupload.state.json");
    L5:
        r101 = null;
        goto L6
    }

    public final d j() {
        File r100 = this.f265506c;     // Catch: Throwable -> L138
        if (r100 != null) goto L6;
    L133:
        d r101 = new d(State.FAILED, "", "invalid_file", false);     // Catch: Throwable -> L138
        if (this.f265509f.exists() == false) goto L137;
        this.f265509f.delete();
    L137:
        return r101;
    L6:
        if (r100.exists() == false) goto L133;
        if (this.f265506c.length() <= 0) goto L133;
        c r102 = i();     // Catch: Throwable -> L138
        if (r102 != null) goto L14;
    L38:
        boolean r103 = false;
    L39:
        String r104 = null;
        if (r103 == false) goto L67;
        x17.a r105 = x17.a.f562123j;     // Catch: Throwable -> L138
        r105.f562129f = r102.f265522a;     // Catch: Throwable -> L138
        r105.c("partsToUpload_hasinfo");     // Catch: Throwable -> L138
        this.f265510g = r102;     // Catch: Throwable -> L138
        String r106 = r102.f265522a;     // Catch: Throwable -> L138
        b r107 = new b(r106, r102.f265523b, r102.f265524c, r102.f265525d, r102.f265528g, "success");     // Catch: Throwable -> L138
        a r108 = d(r106);     // Catch: Throwable -> L138
        if (r108 != null) goto L44;
    L62:
        if (r108 != null) goto L64;
    L66:
        List<Integer> r109 = a(r102);     // Catch: Throwable -> L138
    L68:
        if (r107 != null) goto L103;
        r107 = e();     // Catch: Throwable -> L138
        if (r107 != null) goto L76;
        x17.a.f562123j.c("partsToUpload_doInit_null");     // Catch: Throwable -> L138
        d r110 = new d(State.FAILED, "", "init_failed", false);     // Catch: Throwable -> L138
        if (this.f265509f.exists() == false) goto L75;
        this.f265509f.delete();
    L75:
        return r110;
    L76:
        x17.a r111 = x17.a.f562123j;     // Catch: Throwable -> L138
        r111.f562129f = r107.f265516a;     // Catch: Throwable -> L138
        r111.c("partsToUpload_doInit");     // Catch: Throwable -> L138
        if ("tcc_drop".equals(r107.f265521f) == false) goto L84;
        c();     // Catch: Throwable -> L138
        d r112 = new d(State.TCC_DROP, "", r107.f265521f, false);     // Catch: Throwable -> L138
        if (this.f265509f.exists() == false) goto L82;
        this.f265509f.delete();
    L82:
        return r112;
    L84:
        if ("file_too_small".equals(r107.f265521f) == false) goto L95;
        c();     // Catch: Throwable -> L138
        boolean r113 = l();     // Catch: Throwable -> L138
        if (r113 == false) goto L88;
        State r114 = State.FILE_TOO_SMALL;     // Catch: Throwable -> L138
    L89:
        d r115 = new d(r114, null, r107.f265521f, r113);     // Catch: Throwable -> L138
        if (this.f265509f.exists() == false) goto L93;
        this.f265509f.delete();
    L93:
        return r115;
    L88:
        r114 = State.FAILED;     // Catch: Throwable -> L138
        goto L89
    L95:
        if ("success".equals(r107.f265521f) == true) goto L101;
        c();     // Catch: Throwable -> L138
        d r116 = new d(State.FAILED, "", r107.f265521f, false);     // Catch: Throwable -> L138
        if (this.f265509f.exists() == false) goto L100;
        this.f265509f.delete();
    L100:
        return r116;
    L101:
        c r117 = new c();     // Catch: Throwable -> L138
        r117.f265522a = r107.f265516a;     // Catch: Throwable -> L138
        r117.f265523b = r107.f265517b;     // Catch: Throwable -> L138
        r117.f265524c = r107.f265518c;     // Catch: Throwable -> L138
        r117.f265525d = r107.f265519d;     // Catch: Throwable -> L138
        r117.f265526e = this.f265506c.length();     // Catch: Throwable -> L138
        r117.f265527f = System.currentTimeMillis();     // Catch: Throwable -> L138
        r117.f265528g = r107.f265520e;     // Catch: Throwable -> L138
        this.f265510g = r117;     // Catch: Throwable -> L138
        n(r117);     // Catch: Throwable -> L138
        r109 = null;
    L103:
        if (k(r107, r109) == true) goto L109;
        d r118 = new d(State.FAILED, "", "upload_parts_failed", false);     // Catch: Throwable -> L138
        if (this.f265509f.exists() == false) goto L108;
        this.f265509f.delete();
    L108:
        return r118;
    L109:
        x17.a.f562123j.c("partsToUpload_confirmInfo");     // Catch: Throwable -> L138
        a r119 = b(r107);     // Catch: Throwable -> L138
        if (r119 != null) goto L112;
    L122:
        if (r119 != null) goto L124;
        String r120 = "confirm_failed";
    L125:
        if (r119 == null) goto L128;
        r104 = r119.f265514c;     // Catch: Throwable -> L138
    L128:
        d r121 = new d(State.FAILED, r104, r120, false);     // Catch: Throwable -> L138
        if (this.f265509f.exists() == false) goto L132;
        this.f265509f.delete();
    L132:
        return r121;
    L124:
        r120 = r119.f265515d;     // Catch: Throwable -> L138
        goto L125
    L112:
        if (r119.f265512a == false) goto L122;
        if ("success".equals(r119.f265515d) == false) goto L122;
        if (TextUtils.isEmpty(r119.f265514c) == true) goto L122;
        c();     // Catch: Throwable -> L138
        d r122 = new d(State.SUCCESS, r119.f265514c, r119.f265515d, false);     // Catch: Throwable -> L138
        if (this.f265509f.exists() == false) goto L121;
        this.f265509f.delete();
    L121:
        return r122;
    L64:
        if ("upload_expired".equals(r108.f265515d) == false) goto L66;
        c();     // Catch: Throwable -> L138
        this.f265510g = null;     // Catch: Throwable -> L138
        goto L67
    L44:
        if ("success".equals(r108.f265515d) == false) goto L62;
        if (r108.f265512a == false) goto L56;
        c();     // Catch: Throwable -> L138
        if (TextUtils.isEmpty(r108.f265514c) == true) goto L50;
        String r123 = r108.f265514c;     // Catch: Throwable -> L138
    L51:
        d r124 = new d(State.SUCCESS, r123, r108.f265515d, false);     // Catch: Throwable -> L138
        if (this.f265509f.exists() == false) goto L55;
        this.f265509f.delete();
    L55:
        return r124;
    L50:
        r123 = r102.f265528g;     // Catch: Throwable -> L138
        goto L51
    L56:
        List<Integer> r125 = r108.f265513b;     // Catch: Throwable -> L138
        if (r125 != null) goto L59;
    L61:
        r109 = a(r102);     // Catch: Throwable -> L138
        goto L68
    L59:
        if (r125.isEmpty() == true) goto L61;
        r109 = g(r108.f265513b, r102.f265525d);     // Catch: Throwable -> L138
    L67:
        r109 = null;
        r107 = null;
        goto L68
    L14:
        if (TextUtils.isEmpty(r102.f265522a) == true) goto L38;
        if (r102.f265525d <= 0) goto L38;
        if (r102.f265523b <= 0) goto L38;
        if (r102.f265524c <= 0) goto L38;
        if (r102.f265526e <= 0) goto L38;
        if (r102.f265527f <= 0) goto L38;
        File r126 = this.f265506c;     // Catch: Throwable -> L138
        if (r126 == null) goto L38;
        if (r126.exists() == false) goto L38;
        if (r102.f265526e != this.f265506c.length()) goto L38;
        if ((System.currentTimeMillis() - r102.f265527f) > 604800000) goto L38;
        r103 = true;
    L138:
        th = move-exception;
        r17.c.a(th, "MomDumpPartUploader upload error", new Object[0]);     // Catch: Throwable -> L144
        d r127 = new d(State.FAILED, "", th.getMessage(), false);     // Catch: Throwable -> L144
        if (this.f265509f.exists() == false) goto L143;
        this.f265509f.delete();
    L143:
        return r127;
    L144:
        th = move-exception;
        if (this.f265509f.exists() == false) goto L148;
        this.f265509f.delete();
    L148:
        throw th;
    }

    public final void c() {
        PolarisFileWrapper r100 = f();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.exists() == false) goto L9;
        r100.delete();
        return;
    }

    public final c i() {
        PolarisFileWrapper r100 = f();
        if (r100 != null) goto L5;
    L34:
        return null;
    L5:
        if (r100.exists() == false) goto L34;
        if (r100.isFile() == false) goto L34;
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L24
        StringBuilder r102 = new StringBuilder();     // Catch: Throwable -> L22
        byte[] r103 = new byte[4096];     // Catch: Throwable -> L22
    L12:
        int r104 = r101.read(r103);     // Catch: Throwable -> L22
        if (r104 == (-1)) goto L15;
        r102.append(new String(r103, 0, r104, "UTF-8"));     // Catch: Throwable -> L22
        goto L12
    L15:
        String r105 = r102.toString();     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r105) == true) goto L47;
        c r106 = c.a(new JSONObject(r105));     // Catch: Throwable -> L22
        r101.close();     // Catch: IOException -> L35
    L21:
        return r106;
    L47:
        r101.close();     // Catch: IOException -> L36
    L18:
        return null;
    L22:
        th = th;
    L41:
        r17.c.a(th, "MomDumpPartUploader read state error", new Object[0]);     // Catch: Throwable -> L30
        if (r101 != null) goto L51;
    L29:
        return null;
    L51:
        r101.close();     // Catch: IOException -> L37
    L30:
        th = move-exception;
        if (r101 != null) goto L43;
    L33:
        throw th;
    L43:
        r101.close();     // Catch: IOException -> L38
    L24:
        th = th;
        r101 = null;
        goto L41
    }

    public final boolean l() {
        ArrayList r100 = new ArrayList(1);     // Catch: Throwable -> L13
        r100.add(this.f265506c);     // Catch: Throwable -> L13
        HashMap r101 = new HashMap(2);     // Catch: Throwable -> L13
        r101.put("header", this.f265507d.toString());     // Catch: Throwable -> L13
        r101.put("data", this.f265508e.toString());     // Catch: Throwable -> L13
        x17.a r102 = x17.a.f562123j;     // Catch: Throwable -> L13
        String r103 = null;
        r102.f562129f = null;     // Catch: Throwable -> L13
        r102.c("upload_dump_singleupload");     // Catch: Throwable -> L13
        ff7.b r104 = com.bytedance.apm.d.f190522j.uploadFiles(this.f265504a, r100, r101);     // Catch: Throwable -> L13
        if (r104 != null) goto L6;
    L15:
        return false;
    L6:
        if (r104.f476667a != 200) goto L15;
        byte[] r105 = r104.f476669c;     // Catch: Throwable -> L13
        if (r105 == null) goto L11;
        r103 = new String(r105);     // Catch: Throwable -> L13
    L11:
        r17.c.b("uploadSingleFile message:" + r103 + " code:" + r104.f476667a, new Object[0]);     // Catch: Throwable -> L13
        return TextUtils.isEmpty(r103);
    L13:
        th = move-exception;
        r17.c.a(th, "MomDumpPartUploader single upload error", new Object[0]);
        goto L15
    }

    public static List a(c r100) {
        ArrayList r101 = new ArrayList();
        if (r100.f265525d <= 0) goto L14;
        int r102 = 1;
    L7:
        if (r102 > r100.f265525d) goto L14;
        List<Integer> r103 = r100.f265529h;
        if (r103 == null) goto L12;
        ArrayList r104 = (ArrayList) r103;
        if (r104.contains(Integer.valueOf(r102)) == false) goto L12;
    L13:
        r102 = r102 + 1;
    L12:
        r101.add(Integer.valueOf(r102));
    L14:
        return r101;
    }

    public final a b(b r100) {
        String r101 = r100.f265516a;
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return null;
    L5:
        a r102 = null;
        int r103 = 0;
    L7:
        if (r103 >= 5) goto L41;
        r102 = d(r101);
        if (r102 == null) goto L58;
        if ("upload_expired".equals(r102.f265515d) == true) goto L13;
        if ("success".equals(r102.f265515d) == false) goto L16;
        if (r102.f265512a == true) goto L41;
        List<Integer> r104 = r102.f265513b;
        if (r104 == null) goto L39;
        if (r104.isEmpty() == true) goto L39;
        ArrayList r105 = (ArrayList) g(r102.f265513b, r100.f265519d);
        if (r105.isEmpty() == true) goto L39;
        Iterator r106 = r105.iterator();
    L29:
        if (r106.hasNext() == false) goto L39;
        Integer r107 = (Integer) r106.next();
        if (r107 == null) goto L29;
        if (r107.intValue() <= 0) goto L29;
        if (m(r100, r107.intValue()) == true) goto L29;
        return new a(false, r102.f265513b, r102.f265514c, "reupload_part_failed");
    L39:
        r103 = r103 + 1;
        goto L7
    L16:
        x17.a.f562123j.c("upload_dump_parteupload_fail");
        goto L41
    L13:
        x17.a.f562123j.c("upload_dump_parteupload_fail_expired");
        goto L41
    L58:
        return null;
    L41:
        return r102;
    }

    public final a d(String r100) {
        String r101 = this.f265505b + "/monitor/collect/c/mom_dump_collect_part/confirm";
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L26
        r102.put("upload_id", r100);     // Catch: Throwable -> L26
        ff7.b r103 = com.bytedance.apm.d.a(r101, r102.toString().getBytes("UTF-8"), null);     // Catch: Throwable -> L26
        if (r103 != null) goto L6;
    L25:
        return null;
    L6:
        if (r103.f476667a != 200) goto L25;
        byte[] r104 = r103.f476669c;     // Catch: Throwable -> L26
        if (r104 == null) goto L25;
        String r105 = new String(r104, "UTF-8");     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r105) == false) goto L13;
        return null;
    L13:
        JSONObject r106 = new JSONObject(r105);     // Catch: Throwable -> L26
        String r107 = r106.optString("real_message", "");     // Catch: Throwable -> L26
        JSONObject r108 = r106.optJSONObject("data");     // Catch: Throwable -> L26
        if (r108 == null) goto L16;
        boolean r109 = r108.optBoolean(BitableAnalytic.SelectSceneClickType.COMPLETE, false);     // Catch: Throwable -> L26
        String r110 = r108.optString("tos_url", null);     // Catch: Throwable -> L26
        ArrayList r111 = new ArrayList();     // Catch: Throwable -> L26
        JSONArray r112 = r108.optJSONArray("missing_parts");     // Catch: Throwable -> L26
        if (r112 == null) goto L24;
        int r113 = 0;
    L21:
        if (r113 >= r112.length()) goto L24;
        r111.add(Integer.valueOf(r112.optInt(r113)));     // Catch: Throwable -> L26
        r113 = r113 + 1;     // Catch: Throwable -> L26
    L24:
        return new a(r109, r111, r110, r107);
    L16:
        return new a(false, null, null, r107);
    L26:
        th = move-exception;
        r17.c.a(th, "MomDumpPartUploader confirm error", new Object[0]);
        return null;
    }

    public final void n(c r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        PolarisFileWrapper r101 = f();
        if (r101 != null) goto L32;
        return;
    L32:
        byte[] r102 = r100.b().toString().getBytes("UTF-8");     // Catch: Throwable -> L14
        PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r101, false);     // Catch: Throwable -> L14
        r103.write(r102);     // Catch: Throwable -> L12
        r103.flush();     // Catch: Throwable -> L12
    L26:
        r103.close();     // Catch: IOException -> L24
        return;
    L37:
        return;
    L12:
        th = th;
    L28:
        r17.c.a(th, "MomDumpPartUploader write state error", new Object[0]);     // Catch: Throwable -> L20
        if (r103 != null) goto L26;
        return;
    L20:
        th = move-exception;
        if (r103 != null) goto L34;
    L23:
        throw th;
    L34:
        r103.close();     // Catch: IOException -> L25
    L14:
        th = th;
        r103 = null;
        goto L28
    }

    public static List g(List r100, int r101) {
        ArrayList r102 = new ArrayList();
        if (r100 == null) goto L20;
        if (r101 <= 0) goto L20;
        Iterator r103 = r100.iterator();
    L8:
        if (r103.hasNext() == false) goto L19;
        Integer r104 = (Integer) r103.next();
        if (r104 == null) goto L8;
        int r105 = r104.intValue();
        if (r105 <= 0) goto L8;
        if (r105 > r101) goto L8;
        if (r102.contains(Integer.valueOf(r105)) == true) goto L8;
        r102.add(Integer.valueOf(r105));
        goto L8
    L19:
        Collections.sort(r102);
    L20:
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.util.List] */
    public final boolean k(b r100, List<Integer> r101) {
        if (r100.f265519d > 0) goto L5;
    L35:
        return false;
    L5:
        if (r100.f265518c <= 0) goto L35;
        if (r100.f265517b <= 0) goto L35;
        if (TextUtils.isEmpty(r100.f265516a) == true) goto L35;
        if (r101 != null) goto L14;
    L19:
        ?? r102 = new ArrayList(r100.f265519d);
        int r103 = 1;
    L21:
        if (r103 > r100.f265519d) goto L23;
        r102.add(Integer.valueOf(r103));
        r103 = r103 + 1;
    L23:
        Iterator r104 = r102.iterator();
    L25:
        if (r104.hasNext() == false) goto L34;
        Integer r105 = (Integer) r104.next();
        if (r105 == null) goto L25;
        if (r105.intValue() <= 0) goto L25;
        if (m(r100, r105.intValue()) == true) goto L25;
        return false;
    L34:
        return true;
    L14:
        if (r101.isEmpty() == true) goto L19;
        r102 = g(r101, r100.f265519d);
        if (((ArrayList) r102).isEmpty() == false) goto L23;
        return true;
    }

    public final boolean m(b r110, int r111) {
        int r112 = 0;
    L4:
        if (r112 >= 3) goto L69;
        String r100 = r110.f265516a;
        long r101 = r110.f265518c;
        long r102 = r110.f265517b;
        String r113 = "";
        g r114 = com.bytedance.apm.d.f190522j.buildMultipartUpload(this.f265505b + "/monitor/collect/c/mom_dump_collect_part/upload", "UTF-8", false, null);     // Catch: Throwable -> L26
        r114.a("upload_id", r100);     // Catch: Throwable -> L26
        r114.a("part_number", String.valueOf(r111));     // Catch: Throwable -> L26
        h(r111, r101, r102);     // Catch: Throwable -> L26
        r114.b("file", this.f265509f, "application/octet-stream", Collections.emptyMap());     // Catch: Throwable -> L26
        HashMap<String, Object> r103 = new HashMap();     // Catch: Throwable -> L26
        r103.put("partNumber", Integer.valueOf(r111));     // Catch: Throwable -> L26
        x17.a.f562123j.b("upload_dump_parteupload", r103);     // Catch: Throwable -> L26
        r17.c.b("log upload_dump_parteupload_" + r111, new Object[0]);     // Catch: Throwable -> L26
        ff7.b r104 = r114.finish();     // Catch: Throwable -> L26
        if (r104 == null) goto L24;
        if (r104.f476667a != 200) goto L24;
        byte[] r105 = r104.f476669c;     // Catch: Throwable -> L26
        if (r105 == null) goto L24;
        String r106 = new String(r105, "UTF-8");     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r106) == true) goto L16;
        r113 = new JSONObject(r106).optString("real_message", "");     // Catch: Throwable -> L26
        if (this.f265509f.exists() == true) goto L30;
    L32:
        if ("success".equals(r113) == true) goto L33;
        if ("upload_expired".equals(r113) == true) goto L46;
        r112 = r112 + 1;
        Thread.sleep(((long) r112) * 1000);     // Catch: InterruptedException -> L50
    L50:
        ThreadMethodProxy.currentThread().interrupt();
        goto L4
    L46:
        return false;
    L33:
        c r107 = this.f265510g;
        if (r107 == null) goto L43;
        if (r111 <= 0) goto L43;
        if (r111 > 0) goto L40;
    L42:
        n(this.f265510g);
        goto L43
    L40:
        if (((ArrayList) r107.f265529h).contains(Integer.valueOf(r111)) == true) goto L42;
        ((ArrayList) r107.f265529h).add(Integer.valueOf(r111));
    L43:
        return true;
    L30:
        this.f265509f.delete();
        goto L32
    L16:
        if (this.f265509f.exists() == false) goto L32;
    L24:
        if (this.f265509f.exists() == false) goto L32;
    L26:
        th = move-exception;
        r17.c.a(th, "MomDumpPartUploader uploadSinglePart error, part=%d", new Object[]{Integer.valueOf(r111)});     // Catch: Throwable -> L51
        x17.a.f562123j.c("upload_dump_parteupload_fail");     // Catch: Throwable -> L51
        if (this.f265509f.exists() == false) goto L32;
    L51:
        th = move-exception;
        if (this.f265509f.exists() == false) goto L55;
        this.f265509f.delete();
    L55:
        throw th;
    L69:
        return false;
    }

    public final void h(int r100, long r101, long r110) throws IOException {
        if (r100 != 1) goto L5;
        r110 = r101;
        long r102 = 0;
    L7:
        if (r102 < 0) goto L42;
        if (r110 <= 0) goto L42;
        if (r102 >= this.f265506c.length()) goto L42;
        RandomAccessFile r103 = null;
        RandomAccessFile r104 = new RandomAccessFile(this.f265506c, "r");     // Catch: Throwable -> L32
        r104.seek(r102);     // Catch: Throwable -> L29
        PolarisFileOutputStreamWrapper r105 = new PolarisFileOutputStreamWrapper(this.f265509f, false);     // Catch: Throwable -> L29
        byte[] r111 = new byte[8192];     // Catch: Throwable -> L27
    L18:
        if (r110 <= 0) goto L23;
        int r106 = r104.read(r111, 0, (int) Math.min(8192, r110));     // Catch: Throwable -> L27
        if (r106 == (-1)) goto L23;
        r105.write(r111, 0, r106);     // Catch: Throwable -> L27
        r110 = r110 - ((long) r106);     // Catch: Throwable -> L27
    L23:
        r105.flush();     // Catch: Throwable -> L27
        r104.close();     // Catch: IOException -> L43
    L56:
        r105.close();     // Catch: IOException -> L44
        return;
    L62:
        return;
    L27:
        th = move-exception;
        PolarisFileOutputStreamWrapper r112 = r105;
        th = th;
    L31:
        r103 = r104;
    L34:
        if (r103 != null) goto L58;
    L38:
        if (r112 == null) goto L63;
        r112.close();     // Catch: IOException -> L45
        throw th;
    L64:
        throw th;
    L63:
        throw th;
    L58:
        r103.close();     // Catch: IOException -> L37
    L29:
        th = th;
        r112 = null;
    L32:
        th = th;
        r112 = null;
    L42:
        throw new IOException("invalid part range: part=" + r100);
    L5:
        r102 = r101 + ((((long) r100) - 2) * r110);
        goto L7
    }

    public MomDumpPartUploader(String r100, PolarisFileWrapper r101, JSONObject r102, JSONObject r103) throws Exception {
        this.f265504a = r100;
        this.f265506c = r101;
        this.f265507d = r102;
        this.f265508e = r103;
        this.f265505b = "https://" + new URL(r100).getAuthority();
        this.f265509f = new PolarisFileWrapper(r101.getParentFile(), r101.getName() + ".partupload.tmp");
    }
}
