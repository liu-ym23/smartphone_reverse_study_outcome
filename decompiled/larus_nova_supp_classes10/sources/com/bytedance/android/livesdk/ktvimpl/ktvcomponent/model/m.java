package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/model/m;", "", "", "multiChorusEnable", "Ljava/lang/Boolean;", "a", "()Ljava/lang/Boolean;", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class m implements vh7.h {

    @SerializedName("open_audience_multi_chorus_switch")
    protected Boolean multiChorusEnable;

    public m() {
        this.multiChorusEnable = Boolean.FALSE;
    }

    public final Boolean a() {
        return this.multiChorusEnable;
    }

    public m(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.multiChorusEnable = Boolean.valueOf(am3.h.a(r5));
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r0);
        if (this.multiChorusEnable != null) goto L19;
        this.multiChorusEnable = Boolean.FALSE;
        return;
    }
}
