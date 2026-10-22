package gu3;

import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.apm.util.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements zt3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zt3.a f482765a;

    public class a implements hu3.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f482766a;

        public a(c r100) {
            this.f482766a = r100;
        }

        @Override // hu3.b
        public final void a(JSONObject r100) {
            c r101 = this.f482766a;
            r101.getClass();
            JSONObject r102 = r100.optJSONObject("performance_modules");
            if (r102 == null) goto L31;
            JSONObject r103 = r102.optJSONObject(UploadTypeInf.DISK);
            if (r103 != null) goto L9;
            return;
        L9:
            if (xu3.a.a() == false) goto L11;
            av3.b.a("APM-Disk", "parseConfig:" + r103);
        L11:
            zt3.a r104 = new zt3.a();
            boolean r105 = false;
            if (r103.optInt("enable_upload", 0) != 1) goto L14;
            r105 = true;
        L14:
            r104.f573580l = r105;
            if (r103.optInt("dump_threshold") <= 0) goto L18;
            r104.f573569a = (((long) r103.optInt("dump_threshold")) * 1024) * 1024;
        L18:
            if (r103.optInt("abnormal_folder_size") <= 0) goto L20;
            r104.f573570b = (((long) r103.optInt("abnormal_folder_size")) * 1024) * 1024;
        L20:
            r104.f573571c = ((long) r103.optInt("abnormal_file_size", 100)) * 1024;
            if (r103.optInt("dump_top_count") <= 0) goto L23;
            r104.f573572d = r103.optInt("dump_top_count");
        L23:
            r104.f573573e = r103.optInt("dump_outdated_count", 50);
            r104.f573574f = r103.optInt("dump_top_file_count", 20);
            r104.f573575g = r103.optInt("dump_exception_dir_count", 50);
            if (r103.optInt("outdated_days") <= 0) goto L26;
            r104.f573576h = ((long) r103.optInt("outdated_days")) * 86400000;
        L26:
            r104.f573577i = o.c(r103, "disk_customed_paths");
            r104.f573578j = o.b(r103, "ignored_relative_paths");
            r104.f573579k = o.b(r103, "compliance_relative_paths");
            r101.f482765a = r104;
            if (xu3.a.a() == false) goto L29;
            av3.b.a("APM-Disk", "parseConfig:" + r103);
        L29:
            yt3.a.f569045e.b(r101.f482765a);
            return;
        }
    }

    public c() {
        hu3.a.a().b();
        hu3.a.a().c(new a(this));
    }

    @Override // zt3.b
    public final zt3.a getConfig() {
        return this.f482765a;
    }
}
