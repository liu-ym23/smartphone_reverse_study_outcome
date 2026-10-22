package cs6;

import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f465186a = false;

    static {
        Boolean r100 = (Boolean) HostServiceUtilsKt.g0().a("nearby_refresh_close_in_handler", Boolean.TYPE, Boolean.TRUE);
        if (r100 == null) goto L5;
        boolean r101 = r100.booleanValue();
    L6:
        f465186a = r101;
        return;
    L5:
        r101 = true;
        goto L6
    }
}
