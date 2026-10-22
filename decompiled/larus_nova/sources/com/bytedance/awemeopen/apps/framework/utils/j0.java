package com.bytedance.awemeopen.apps.framework.utils;

import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;

/* JADX INFO: loaded from: classes14.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f197718a = 0;

    public static final class a {
        public static String a(int r100) {
            if (r100 >= 10) goto L6;
            return "0" + r100;
        L6:
            return String.valueOf(r100);
        }

        public static String b(int r100) {
            if (r100 >= 3600) goto L6;
            return a(r100 / 60) + ':' + a(r100 % 60);
        L6:
            return a(r100 / AnnouncementViewModel.HOUR_DURATION) + ':' + b(r100 % AnnouncementViewModel.HOUR_DURATION);
        }
    }

    static {
    }
}
