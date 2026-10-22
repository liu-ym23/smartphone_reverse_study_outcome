package com.bytedance.ee.bear.document.print;

import android.webkit.ValueCallback;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class i<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ vv4.k f221184a;

    public static final class a<T> implements ValueCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SingleEmitter<Boolean> f221185a;

        public a(SingleEmitter<Boolean> r100) {
            this.f221185a = r100;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r100) {
            String r101 = (String) r100;
            if (this.f221185a.isDisposed() == true) goto L33;
            boolean r102 = true;
            if (r101 != null) goto L8;
        L11:
            boolean r103 = true;
        L12:
            if (r103 == false) goto L29;
            this.f221185a.tryOnError(new JSONException("comment state is empty"));
            return;
        L29:
            JSONObject r104 = new JSONObject(r101);     // Catch: JSONException -> L25
            String r105 = r104.optString("status");     // Catch: JSONException -> L25
            int r106 = r104.optInt("renderedCommentCount", -1);     // Catch: JSONException -> L25
            if (Intrinsics.areEqual(r105, "ready") == false) goto L23;
            if (r106 < 0) goto L23;
            tt5.a.h("PrintExportCoordinator", "query comment state from JSB success, rendered=" + r106);     // Catch: JSONException -> L25
            SingleEmitter<Boolean> r107 = this.f221185a;     // Catch: JSONException -> L25
            if (r106 > 0) goto L22;
            r102 = false;
        L22:
            r107.onSuccess(Boolean.valueOf(r102));     // Catch: JSONException -> L25
        L28:
            return;
        L23:
            this.f221185a.tryOnError(new IllegalStateException("comment state unavailable, status=" + r105));     // Catch: JSONException -> L25
        L25:
            e = move-exception;
            this.f221185a.tryOnError(e);
            return;
        L8:
            if (StringsKt.isBlank(r101) == true) goto L11;
            r103 = false;
            goto L12
        }
    }

    public i(vv4.k r100) {
        this.f221184a = r100;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        this.f221184a.l("lark.biz.comment.getCommentState", new JSONObject(), new a(r100));     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        r100.tryOnError(e);
    }
}
