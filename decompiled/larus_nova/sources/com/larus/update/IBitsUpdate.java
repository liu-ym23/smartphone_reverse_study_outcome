package com.larus.update;

import com.larus.home.impl.u;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.Metadata;
import z1a.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/larus/update/IBitsUpdate;", "", "checkUpdate", "", "autoCheck", "", "manualUpdateEnable", "isUpdating", "getUpdatePackageDir", "", "getPackageCleanHandler", "Lcom/larus/disk/api/CacheHandler;", "addRequestProvider", ShortVideoSegments.KEY_PROP_PROVIDER, "Lcom/larus/update/IRequestTagHeaderProvider;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBitsUpdate {
    boolean b();

    i c();

    void checkUpdate(boolean r100);

    void d(u r100);

    String e();

    boolean isUpdating();
}
