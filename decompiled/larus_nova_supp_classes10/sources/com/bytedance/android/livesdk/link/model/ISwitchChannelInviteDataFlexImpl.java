package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.linkmic.SwitchChannelInviteResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R'\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\u00058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0011\u001a\u00020\u00048VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ISwitchChannelInviteDataFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/n9;", "", "", "", "notAllowMap$delegate", "Ljava/lang/Object;", "getNotAllowMap", "()Ljava/util/Map;", "notAllowMap", "isFailure$delegate", "isFailure", "()Z", "toast$delegate", "getToast", "()Ljava/lang/String;", "toast", "", "waitSec$delegate", "getWaitSec", "()J", "waitSec", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ISwitchChannelInviteDataFlexImpl extends FlexModelBase<n9> implements n9, vh7.h {

    @SerializedName("is_failure")
    protected boolean _$$isFailure;

    @SerializedName("open_not_allow_map")
    protected Map<String, Boolean> _$$notAllowMap;

    @SerializedName("toast")
    protected String _$$toast;

    @SerializedName("wait_sec")
    protected long _$$waitSec;

    public ISwitchChannelInviteDataFlexImpl() {
        super(n9.class);
        this._$$notAllowMap = $defaultValue_notAllowMap$();
        this._$$isFailure = false;
        this._$$toast = "";
    }

    public final Map<String, Boolean> $defaultValue_notAllowMap$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    @Override // com.bytedance.android.livesdk.link.model.n9
    public final Map<String, Boolean> getNotAllowMap() {
        return this._$$notAllowMap;
    }

    @Override // com.bytedance.android.livesdk.link.model.n9
    public final String getToast() {
        return this._$$toast;
    }

    @Override // com.bytedance.android.livesdk.link.model.n9
    public final long getWaitSec() {
        return this._$$waitSec;
    }

    @Override // com.bytedance.android.livesdk.link.model.n9
    public final boolean isFailure() {
        return this._$$isFailure;
    }

    public ISwitchChannelInviteDataFlexImpl(am3.g r13) {
        super(n9.class);
        this._$$notAllowMap = new HashMap();
        setThreadSafe(false);
        long r1 = r13.c();
        int r3 = 0;
    L3:
        int r4 = r13.f();
        if (r4 == (-1)) goto L33;
        am3.g.a r7 = decodeExtensionFields(r4, r13);
        if (r4 != 2) goto L8;
        this._$$isFailure = am3.h.a(r13);
        r3 = r3 | 1;
        goto L3
    L8:
        if (r4 != 3) goto L10;
        this._$$toast = am3.h.c(r13);
        goto L3
    L10:
        if (r4 != 4) goto L12;
        this._$$waitSec = r13.j();
        r3 = r3 | 2;
        goto L3
    L12:
        if (r4 != 5000) goto L13;
        long r9 = r13.c();
        String r5 = null;
        Boolean r8 = null;
    L15:
        int r11 = r13.f();
        if (r11 == (-1)) goto L22;
        if (r11 != 1) goto L18;
        r5 = am3.h.c(r13);
        goto L15
    L18:
        if (r11 != 2) goto L19;
        r8 = Boolean.valueOf(am3.h.a(r13));
        goto L15
    L19:
        am3.h.e(r13);
        goto L15
    L22:
        r13.d(r9);
        Map<String, Boolean> r6 = this._$$notAllowMap;
        if (r5 == null) goto L29;
        if (r8 == null) goto L27;
        r6.put(r5, r8);
        goto L3
    L27:
        throw new IllegalStateException("Value must not be null");
    L29:
        throw new IllegalStateException("Key must not be null");
    L13:
        am3.h.d(r7, r13);
        goto L3
    L33:
        r13.d(r1);
        setThreadSafe(true);
        if (this._$$notAllowMap != null) goto L37;
        this._$$notAllowMap = $defaultValue_notAllowMap$();
    L37:
        if ((r3 & 1) != 0) goto L40;
        this._$$isFailure = false;
    L40:
        if (this._$$toast != null) goto L69;
        this._$$toast = "";
        return;
    }
}
