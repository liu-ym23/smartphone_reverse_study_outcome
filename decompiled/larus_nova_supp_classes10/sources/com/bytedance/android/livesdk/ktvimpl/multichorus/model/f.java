package com.bytedance.android.livesdk.ktvimpl.multichorus.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b%\u0010&R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/f;", "", "", "updateType", "I", "e", "()I", "setUpdateType", "(I)V", "Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/g;", "startSingMultiChorusContent", "Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/g;", "d", "()Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/g;", "setStartSingMultiChorusContent", "(Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/g;)V", "Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/c;", "joinMultiChorusContent", "Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/c;", "b", "()Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/c;", "setJoinMultiChorusContent", "(Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/c;)V", "Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/d;", "leaveMultiChorusContent", "Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/d;", "c", "()Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/d;", "setLeaveMultiChorusContent", "(Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/d;)V", "Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/b;", "finishMultiChorusContent", "Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/b;", "a", "()Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/b;", "setFinishMultiChorusContent", "(Lcom/bytedance/android/livesdk/ktvimpl/multichorus/model/b;)V", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class f implements h {

    @SerializedName("finish_multi_chorus_content")
    protected b finishMultiChorusContent;

    @SerializedName("join_multi_chorus_content")
    protected c joinMultiChorusContent;

    @SerializedName("leave_multi_chorus_content")
    protected d leaveMultiChorusContent;

    @SerializedName("start_sing_multi_chorus_content")
    protected g startSingMultiChorusContent;

    @SerializedName("msg_type")
    protected int updateType;

    public static final class a {
    }

    static {
    }

    public f() {
    }

    public final b a() {
        return this.finishMultiChorusContent;
    }

    public final c b() {
        return this.joinMultiChorusContent;
    }

    public final d c() {
        return this.leaveMultiChorusContent;
    }

    public final g d() {
        return this.startSingMultiChorusContent;
    }

    public final int e() {
        return this.updateType;
    }

    public f(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L21;
        if (r2 != 1) goto L8;
        this.updateType = r5.i();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.startSingMultiChorusContent = new g(r5);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.joinMultiChorusContent = new c(r5);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.leaveMultiChorusContent = new d(r5);
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this.finishMultiChorusContent = new b(r5);
        goto L3
    L15:
        am3.h.e(r5);
        goto L3
    L21:
        r5.d(r0);
    }
}
