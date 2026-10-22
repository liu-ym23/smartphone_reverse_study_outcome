package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class v implements ObservableOnSubscribe<File> {
    public final /* synthetic */ b0 a;
    public final /* synthetic */ Context b;

    public static final class a implements ak2.f<String, String> {
        public final /* synthetic */ v a;
        public final /* synthetic */ ObservableEmitter b;

        public final Object getConfig() {
            Context r0 = this.a.b;
            if (r0 == null) goto L5;
            File r1 = r0.getExternalCacheDir();
        L6:
            if (r1 == null) goto L13;
            PolarisFileWrapper r2 = new PolarisFileWrapper(r1, "/live/ecscreenshot");
            if (r2.exists() == true) goto L16;
            if (r2.mkdirs() == true) goto L16;
            return r1.getAbsolutePath();
        L16:
            return r2.getAbsolutePath();
        L13:
            return "";
        L5:
            r1 = null;
            goto L6
        }

        public final void onChanged(Object r3) {
            String r4 = (String) r3;
            if (r4 != null) goto L5;
        L8:
            boolean r0 = true;
        L9:
            if (r0 == false) goto L11;
            this.b.tryOnError(new Exception("screenshotFolderPath is empty"));
            return;
        L11:
            Observable.create(new u(this, r4)).subscribeOn(Schedulers.io()).subscribe();
            return;
        L5:
            if (r4.length() == 0) goto L8;
            r0 = false;
            goto L9
        }

        public a(v r1, ObservableEmitter r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final void subscribe(ObservableEmitter<File> r3) throws Exception {
        Intrinsics.checkNotNullParameter(r3, "emitter");
        com.bytedance.android.livesdk.livecommerce.room.api.c r0 = this.a.g;
        if (r0 == null) goto L5;
        r0.i(new a(this, r3));
        return;
    L5:
        r3.tryOnError(new IllegalArgumentException("liveRoomProvider is null !!!"));
    }

    public v(b0 r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }
}
