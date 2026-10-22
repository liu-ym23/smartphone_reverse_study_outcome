package com.bytedance.android.livesdk.ktvimpl.multichorus.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/KtvMultiChorusSyncData;", "", "Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/f;", "multiChorusUpdateMessage", "Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/f;", "getMultiChorusUpdateMessage", "()Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/f;", "setMultiChorusUpdateMessage", "(Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/f;)V", "<init>", "()V", "Companion", "a", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvMultiChorusSyncData implements h {
    public static final a Companion = null;
    public static final String SYNC_KEY = "KtvMultiChorusSyncData";

    @SerializedName("update_msg")
    protected f multiChorusUpdateMessage;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public KtvMultiChorusSyncData() {
    }

    public KtvMultiChorusSyncData(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.multiChorusUpdateMessage = new f(r5);
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r0);
    }

    public final f getMultiChorusUpdateMessage() {
        return this.multiChorusUpdateMessage;
    }

    public final void setMultiChorusUpdateMessage(f r1) {
        this.multiChorusUpdateMessage = r1;
    }
}
