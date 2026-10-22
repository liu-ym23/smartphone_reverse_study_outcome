package yt1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public interface m {

    public static final class a {
        public static void a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "reason");
        }
    }

    void a(com.bytedance.android.livesdk.dslservice.a r100, boolean r101, String r102);

    void b(String r100, String r101, Throwable r102);

    void onFetchSuccess();
}
