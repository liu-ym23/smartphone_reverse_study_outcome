package com.bytedance.android.livesdk.ktvimpl.multichorus.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/b;", "", "Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/e;", "commonContent", "Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/e;", "a", "()Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/e;", "setCommonContent", "(Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/e;)V", "", "finishReason", "I", "b", "()I", "setFinishReason", "(I)V", "", "toast", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setToast", "(Ljava/lang/String;)V", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b implements h {

    @SerializedName("common")
    protected e commonContent;

    @SerializedName("finish_reason")
    protected int finishReason;

    @SerializedName("toast")
    protected String toast;

    public b() {
    }

    public final e a() {
        return this.commonContent;
    }

    public final int b() {
        return this.finishReason;
    }

    public final String c() {
        return this.toast;
    }

    public b(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        if (r2 != 1) goto L8;
        this.commonContent = new e(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.finishReason = r5.i();
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.toast = am3.h.c(r5);
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
    }
}
