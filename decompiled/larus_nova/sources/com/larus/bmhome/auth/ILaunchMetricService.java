package com.larus.bmhome.auth;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/auth/ILaunchMetricService;", "", "report", "", "type", "", "stage", "success", "", "error", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ILaunchMetricService {

    public static final class a {
        public static /* synthetic */ void a(LaunchMetricDelegate r100, String r101, boolean r102, int r103) {
            if ((r103 & 4) == 0) goto L6;
            r102 = false;
        L6:
            if ((r103 & 8) == 0) goto L8;
            String r104 = "";
        L9:
            r100.a(r101, r102, r104);
            return;
        L8:
            r104 = null;
            goto L9
        }
    }

    void a(String r100, boolean r101, String r102);
}
