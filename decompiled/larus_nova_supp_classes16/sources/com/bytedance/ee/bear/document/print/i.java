package com.bytedance.ee.bear.document.print;

import android.webkit.ValueCallback;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i<T> implements SingleOnSubscribe {
    public final /* synthetic */ vv4.k a;

    public static final class a<T> implements ValueCallback {
        public final /* synthetic */ SingleEmitter<Boolean> a;

        public a(SingleEmitter<Boolean> r1) {
            this.a = r1;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r8) {
            String r9 = (String) r8;
            if (this.a.isDisposed() == true) goto L33;
            boolean r2 = true;
            if (r9 != null) goto L8;
        L11:
            boolean r4 = true;
        L12:
            if (r4 == false) goto L29;
            this.a.tryOnError(new JSONException("comment state is empty"));
            return;
        L29:
            JSONObject r5 = new JSONObject(r9);     // Catch: JSONException -> L25
            String r10 = r5.optString("status");     // Catch: JSONException -> L25
            int r6 = r5.optInt("renderedCommentCount", -1);     // Catch: JSONException -> L25
            if (Intrinsics.areEqual(r10, "ready") == false) goto L23;
            if (r6 < 0) goto L23;
            tt5.a.h("PrintExportCoordinator", "query comment state from JSB success, rendered=" + r6);     // Catch: JSONException -> L25
            SingleEmitter<Boolean> r11 = this.a;     // Catch: JSONException -> L25
            if (r6 > 0) goto L22;
            r2 = false;
        L22:
            r11.onSuccess(Boolean.valueOf(r2));     // Catch: JSONException -> L25
        L28:
            return;
        L23:
            this.a.tryOnError(new IllegalStateException("comment state unavailable, status=" + r10));     // Catch: JSONException -> L25
        L25:
            e = move-exception;
            this.a.tryOnError(e);
            return;
        L8:
            if (StringsKt.isBlank(r9) == true) goto L11;
            r4 = false;
            goto L12
        }
    }

    public i(vv4.k r1) {
        this.a = r1;
    }

    public final void subscribe(SingleEmitter<Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "emitter");
        this.a.l("lark.biz.comment.getCommentState", new JSONObject(), new a(r5));     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        r5.tryOnError(e);
    }
}
