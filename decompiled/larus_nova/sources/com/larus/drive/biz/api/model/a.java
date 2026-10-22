package com.larus.drive.biz.api.model;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f341027k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f341028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f341029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f341030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DriveFileType f341031d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f341032e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DriveUploadStatus f341033f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f341034g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Long f341035h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Long f341036i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final JSONObject f341037j;

    /* JADX INFO: renamed from: com.larus.drive.biz.api.model.a$a, reason: collision with other inner class name */
    public static final class C4298a {
        public static a a(JSONObject r110) {
            Integer r100 = null;
            if (r110 != null) goto L5;
            return null;
        L5:
            Object r101 = r110.opt("item_id");
            if ((r101 instanceof String) == false) goto L8;
            String r102 = (String) r101;
        L9:
            if (r102 != null) goto L11;
            return null;
        L11:
            Object r103 = r110.opt("task_id");
            if ((r103 instanceof String) == false) goto L14;
            String r104 = (String) r103;
        L15:
            if (r104 != null) goto L17;
            return null;
        L17:
            Object r105 = r110.opt("file_name");
            if ((r105 instanceof String) == false) goto L20;
            String r106 = (String) r105;
        L21:
            if (r106 != null) goto L23;
            return null;
        L23:
            DriveFileType.a r107 = DriveFileType.Companion;
            Object r108 = r110.opt("file_type");
            if ((r108 instanceof String) == false) goto L26;
            String r109 = (String) r108;
        L27:
            if (r109 != null) goto L29;
            return null;
        L29:
            r107.getClass();
            DriveFileType r111 = DriveFileType.a.a(r109);
            String r112 = r110.optString("parent_drive_token", "");
            DriveUploadStatus.a r113 = DriveUploadStatus.Companion;
            Object r114 = r110.opt("status");
            if ((r114 instanceof String) == false) goto L32;
            String r115 = (String) r114;
        L33:
            if (r115 != null) goto L35;
            return null;
        L35:
            r113.getClass();
            Intrinsics.checkNotNullParameter(r115, "value");
            Iterator<DriveUploadStatus> r116 = DriveUploadStatus.getEntries().iterator();
        L37:
            if (r116.hasNext() == false) goto L41;
            DriveUploadStatus r117 = r116.next();
            if (Intrinsics.areEqual(r117.getValue(), r115) == false) goto L37;
        L42:
            DriveUploadStatus r118 = r117;
            if (StringsKt.isBlank(r102) == false) goto L45;
        L59:
            return null;
        L45:
            if (StringsKt.isBlank(r104) == true) goto L59;
            if (StringsKt.isBlank(r106) == true) goto L59;
            if (r111 == null) goto L59;
            if (r118 == null) goto L59;
            Intrinsics.checkNotNull(r112);
            if (r110.has("error_tip_res_id") == false) goto L54;
            r100 = Integer.valueOf(r110.optInt("error_tip_res_id"));
        L54:
            Integer r119 = r100;
            Long r120 = Long.valueOf(r110.optLong("bytes_total"));
            Long r121 = Long.valueOf(r110.optLong("bytes_transferred"));
            JSONObject r122 = r110.optJSONObject("event_params");
            if (r122 != null) goto L58;
            r122 = new JSONObject();
        L58:
            return new a(r102, r104, r106, r111, r112, r118, r119, r120, r121, r122);
        L41:
            r117 = null;
            goto L42
        L32:
            r115 = null;
            goto L33
        L26:
            r109 = null;
            goto L27
        L20:
            r106 = null;
            goto L21
        L14:
            r104 = null;
            goto L15
        L8:
            r102 = null;
            goto L9
        }
    }

    static {
    }

    public final a a() {
        return new a(this.f341028a, this.f341029b, this.f341030c, this.f341031d, this.f341032e, this.f341033f, this.f341034g, this.f341035h, this.f341036i, this.f341037j);
    }

    public final int hashCode() {
        Long r100 = this.f341035h;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f341036i;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((((((((((((r103 + r105) * 31) + this.f341028a.hashCode()) * 31) + this.f341029b.hashCode()) * 31) + this.f341030c.hashCode()) * 31) + this.f341031d.hashCode()) * 31) + this.f341032e.hashCode()) * 31) + this.f341033f.hashCode()) * 31;
        Integer r107 = this.f341034g;
        if (r107 == null) goto L13;
        int r108 = r107.intValue();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f341035h;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.f341036i;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(a.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larus.drive.biz.api.model.DriveUploadItem");
        a r102 = (a) r100;
        if (Intrinsics.areEqual(this.f341028a, r102.f341028a) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f341029b, r102.f341029b) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.f341030c, r102.f341030c) == true) goto L22;
        return false;
    L22:
        if (this.f341031d == r102.f341031d) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.f341032e, r102.f341032e) == true) goto L28;
        return false;
    L28:
        if (this.f341033f == r102.f341033f) goto L31;
        return false;
    L31:
        if (Intrinsics.areEqual(this.f341034g, r102.f341034g) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f341035h, r102.f341035h) == true) goto L37;
        return false;
    L37:
        if (Intrinsics.areEqual(this.f341036i, r102.f341036i) == true) goto L39;
        return false;
    L39:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public a(String r100, String r101, String r102, DriveFileType r103, String r104, DriveUploadStatus r105, Integer r106, Long r107, Long r110, JSONObject r111) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, "fileName");
        Intrinsics.checkNotNullParameter(r103, "fileType");
        Intrinsics.checkNotNullParameter(r104, "parentDriveToken");
        Intrinsics.checkNotNullParameter(r105, "status");
        Intrinsics.checkNotNullParameter(r111, "eventParams");
        this.f341028a = r100;
        this.f341029b = r101;
        this.f341030c = r102;
        this.f341031d = r103;
        this.f341032e = r104;
        this.f341033f = r105;
        this.f341034g = r106;
        this.f341035h = r107;
        this.f341036i = r110;
        this.f341037j = r111;
    }
}
