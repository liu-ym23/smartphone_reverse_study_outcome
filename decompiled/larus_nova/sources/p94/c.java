package p94;

import android.text.TextUtils;
import com.bytedance.bdp.appbase.context.service.operate.sync.ResultType;
import java.lang.Enum;

/* JADX INFO: loaded from: classes11.dex */
public final class c<DATA, ERROR extends Enum<ERROR>> extends p94.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f528301e = 0;

    public static final class a {
    }

    static {
    }

    @Override // p94.a
    public final String a() {
        String r100 = super.a();
        if (TextUtils.isEmpty(r100) == true) goto L5;
        return r100;
    L5:
        ResultType r101 = ResultType.OK;
        return "custom error not found";
    }

    public c(ResultType r100, String r101, Throwable r102) {
        super(r100, r101, r102);
    }
}
