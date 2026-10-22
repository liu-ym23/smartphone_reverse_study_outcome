package y71;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.room.api.report.ReportObject;
import com.bytedance.android.live.room.api.userinfo.event.ReportConstant$BusinessSource;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import zg1.u;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBaseUser f566572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IRoom f566573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f566574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f566575d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f566576e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public u f566577f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ReportObject f566578g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, String> f566579h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ReportConstant$BusinessSource f566580i;

    public a(ReportConstant$BusinessSource r100) {
        Intrinsics.checkNotNullParameter(r100, "businessSource");
        this.f566580i = r100;
    }

    public final void a(String r100) {
        if (r100 == null) goto L15;
        this.f566578g = ReportObject.valueOf(r100);     // Catch: IllegalArgumentException -> L6
        return;
    L6:
        e = move-exception;
        if (v.a() == true) goto L12;
        ALogger.e(a.class.getName(), e.getMessage());
        return;
    L12:
        throw new RuntimeException("无法从当前reportObject字符串: " + r100 + " 构造出ReportObject对象，请直接使用ReportObject.name生成string");
    }
}
