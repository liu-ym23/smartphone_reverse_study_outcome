package com.larus.bmhome.chat.markdown.code;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class t0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<Keva> f307025d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy<Gson> f307026e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<ih8.b> f307027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData f307028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f307029c;

    public static final class a {
        public static String a(String r100, String r101) {
            boolean r102 = true;
            if (r100 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == true) goto L19;
            if (r101 != null) goto L12;
        L15:
            if (r102 == false) goto L18;
            return null;
        L18:
            return r100 + '_' + r101;
        L12:
            if (r101.length() == 0) goto L15;
            r102 = false;
            goto L15
        L19:
            return null;
        L5:
            if (r100.length() == 0) goto L8;
            r103 = false;
            goto L9
        }

        public static ih8.b b(String r100, String r101) {
            String r102 = a(r100, r101);
            if (r102 != null) goto L16;
            return null;
        L16:
            String r103 = t0.f307025d.getValue().getString(r102, "");     // Catch: Exception -> L13
            Intrinsics.checkNotNull(r103);     // Catch: Exception -> L13
            if (r103.length() != 0) goto L8;
            boolean r104 = true;
        L9:
            if (r104 == true) goto L18;
            return (ih8.b) t0.f307026e.getValue().fromJson(r103, ih8.b.class);
        L18:
            return null;
        L8:
            r104 = false;
        L13:
            e = move-exception;
            FLogger.f375446a.d("MarkdownCodePreviewer", "getCachedResponse error: " + e);
            return null;
        }
    }

    static {
        f307025d = LazyKt.lazy(new r0());
        f307026e = LazyKt.lazy(new s0());
    }

    public t0() {
        MutableLiveData<ih8.b> r100 = new MutableLiveData();
        this.f307027a = r100;
        this.f307028b = r100;
    }
}
