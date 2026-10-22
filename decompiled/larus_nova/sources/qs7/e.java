package qs7;

import android.text.TextUtils;
import android.util.Pair;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.dtf.face.config.OSSConfig;
import com.dtf.face.log.RecordService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes22.dex */
public final class e implements os7.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f534686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Pair<Integer, String>> f534687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f534688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c f534689d;

    @Override // os7.a.d
    public final void b(int r100, String r101, String r102) {
    }

    public e(c r100) {
        this.f534689d = r100;
        this.f534686a = "Z6004";
        this.f534687b = new ArrayList();
        this.f534688c = new HashSet();
    }

    @Override // os7.a.d
    public final void c(String[] r100) {
        RecordService.getInstance().recordEvent(2, "uploadFilesError", r100);
    }

    @Override // os7.a.d
    public final boolean a(int r110, String r111, String r112, String r113) {
        this.f534689d.getClass();
        if (r110 != 0) goto L5;
        String r100 = "Z6004";
    L14:
        this.f534686a = r100;
        ((ArrayList) this.f534687b).add(new Pair(Integer.valueOf(r110), HTTP.URL_DEFAULT + r111 + HTTP.URL_DEFAULT + r112));
        OSSConfig r114 = hs7.a.h().f();
        if (r112 == null) goto L22;
        if (r114 == null) goto L22;
        if (TextUtils.isEmpty(r114.chameleonFileNamePrefix) == true) goto L22;
        if (r112.startsWith(r114.chameleonFileNamePrefix) == false) goto L22;
        this.f534686a = "Z6005";
        ((HashSet) this.f534688c).add("Z6005");
    L23:
        RecordService.getInstance().recordEvent(4, "ossUploadFileError", new String[]{"idx", "" + r110, "fileName", r112, "errMsg", r113, "errCode", this.f534686a});
        if ("InvalidAccessKeyId".equalsIgnoreCase(r113) == false) goto L27;
        this.f534689d.f534678a.onError("Z6003", r113);
        return true;
    L27:
        return false;
    L22:
        ((HashSet) this.f534688c).add(this.f534686a);
        goto L23
    L5:
        if (r110 != 2) goto L7;
        r100 = "Z5113";
        goto L14
    L7:
        if (r110 != 1) goto L9;
        r100 = "Z5112";
        goto L14
    L9:
        if (r110 != 5) goto L11;
        r100 = "Z5114";
        goto L14
    L11:
        if (r110 != 6) goto L13;
        r100 = "Z5116";
        goto L14
    L13:
        r100 = "Z1012";
        goto L14
    }

    @Override // os7.a.d
    public final void d(int r100, int r101, String r102, String[] r103) {
        if (r103 == null) goto L6;
        RecordService.getInstance().recordEvent(2, "uploadFilesForValidate", r103);
    L6:
        if (TextUtils.isEmpty(r102) == false) goto L8;
        r102 = hs7.a.h().L;
    L8:
        hs7.a.h().f486988J = r102;
        if (r100 != r101) goto L13;
        RecordService.getInstance().recordEvent(2, "ossUploadFileSuccess", new String[]{"count", "" + r101});
        this.f534689d.f534678a.d();
        this.f534689d.f534681d.f534676d.getClass();
        Map<String, Object> r104 = this.f534689d.f534682e;
        if (r104 == null) goto L22;
        r104.put("ossErrorRetry", Boolean.FALSE);
    L22:
        this.f534689d.a();
        return;
    L13:
        RecordService.getInstance().recordEvent(2, "ossUploadFileFailed", new String[]{"count", "" + r101, "code", this.f534688c.toString()});
        c r105 = this.f534689d;
        if (r105.f534678a.c(r105, this.f534687b) == false) goto L18;
        this.f534689d.f534678a.onError(this.f534686a, null);
        return;
    L18:
        if (((HashSet) this.f534688c).contains("Z6004") == false) goto L22;
        this.f534689d.f534681d.f534676d.getClass();
        Map<String, Object> r106 = this.f534689d.f534682e;
        if (r106 == null) goto L22;
        r106.put("ossErrorRetry", Boolean.TRUE);
        goto L22
    }
}
