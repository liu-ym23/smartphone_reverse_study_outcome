package com.bytedance.android.shopping.deepfeed.slice.view.lottie;

import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.ec.store.utils.taskmanager.ExecutorType;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.Url;
import com.larus.apm.impl.protector.RunnableProtector;
import java.net.URI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DeepFeedLottieUrlLoader {
    public static final /* synthetic */ int a = 0;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bb\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0003\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/slice/view/lottie/DeepFeedLottieUrlLoader$DeepFeedLottieUrlApi;", "", "getRawJson", "Lcom/bytedance/retrofit2/Call;", "", "url", "maxLength", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface DeepFeedLottieUrlApi {
        @GET
        Call<String> getRawJson(@Url String r1, @MaxLength int r2);
    }

    public static final class a implements Runnable {
        public volatile Call<String> a;
        public final String b;
        public final Function1<String, Unit> c;
        public final Function1<Throwable, Unit> d;

        public final void a() {
            n r1 = n.a;     // Catch: Throwable -> L13
            int r2 = DeepFeedLottieUrlLoader.a;     // Catch: Throwable -> L13
            Call<String> r3 = ((DeepFeedLottieUrlApi) r1.create(DeepFeedLottieUrlLoader.a(this.b), DeepFeedLottieUrlApi.class)).getRawJson(this.b, Integer.MAX_VALUE);     // Catch: Throwable -> L13
            this.a = r3;     // Catch: Throwable -> L13
            SsResponse r4 = r3.execute();     // Catch: Throwable -> L13
            int r5 = r4.code();     // Catch: Throwable -> L13
            if (200 > r5) goto L12;
            if (299 < r5) goto L12;
            String r0 = (String) r4.body();     // Catch: Throwable -> L13
            if (r0 != null) goto L10;
            r0 = "";
        L10:
            this.c.invoke(r0);     // Catch: Throwable -> L13
            return;
        L12:
            throw new IllegalStateException("unexpected response code=" + r4.code());     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            this.d.invoke(th);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(String r2, Function1<? super String, Unit> r3, Function1<? super Throwable, Unit> r4) {
            Intrinsics.checkNotNullParameter(r2, "url");
            Intrinsics.checkNotNullParameter(r3, "onSuccess");
            Intrinsics.checkNotNullParameter(r4, "onFailure");
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public DeepFeedLottieUrlLoader() {
    }

    static {
    }

    public static final String a(String r2) {
        URI r0 = new URI(r2);
        String r3 = r0.getScheme();
        if (r3 == null) goto L11;
        String r1 = r0.getAuthority();
        if (r1 == null) goto L9;
        return r3 + "://" + r1 + '/';
    L9:
        throw new IllegalArgumentException("authority is null");
    L11:
        throw new IllegalArgumentException("scheme is null");
    }

    public static a b(String r1, Function1 r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r1, "url");
        Intrinsics.checkNotNullParameter(r2, "onSuccess");
        Intrinsics.checkNotNullParameter(r3, "onFailure");
        final a r0 = new a(r1, r2, r3);
        int r4 = com.bytedance.android.ec.store.utils.taskmanager.c.c;
        com.bytedance.android.ec.store.utils.taskmanager.c.b.a.a(ExecutorType.IO, new DeepFeedLottieUrlLoader$loadRawJsonFromUrl$1(r0));
        return r0;
    }
}
