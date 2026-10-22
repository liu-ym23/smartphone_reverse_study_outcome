package com.ss.android.lark.biz.im.api.extension.scroll;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public interface b {

    public static final class a {
        public static void a(String r100, ScrollEvent r101) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r101, "event");
        }

        public static void b(String r100, ScrollEvent r101) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r101, "event");
        }

        public static void c(String r100, ScrollEvent r101) {
            Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
            Intrinsics.checkNotNullParameter(r101, "event");
        }
    }

    void a(String r100, ScrollEvent r101);

    void b(String r100, ScrollEvent r101);

    void c(String r100, ScrollEvent r101);

    void d(String r100, ScrollEvent r101);

    void e(String r100, ScrollEvent r101);
}
