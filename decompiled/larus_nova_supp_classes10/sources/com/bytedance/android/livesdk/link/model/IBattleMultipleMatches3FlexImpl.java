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
@ProtoMessage("webcast.data.MultipleMatches3")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R)\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleMultipleMatches3FlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/x1;", "", "", "Lcom/bytedance/android/livesdk/link/model/IBattleMultipleMatchesUserInfoFlexImpl;", "userInfoMap$delegate", "Ljava/lang/Object;", "getUserInfoMap", "()Ljava/util/Map;", "userInfoMap", "", "end$delegate", "getEnd", "()Z", "end", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleMultipleMatches3FlexImpl extends FlexModelBase<x1> implements x1, vh7.h {

    @SerializedName("end")
    protected boolean _$$end;

    @SerializedName("open_user_infos")
    protected Map<String, IBattleMultipleMatchesUserInfoFlexImpl> _$$userInfoMap;

    public IBattleMultipleMatches3FlexImpl() {
        super(x1.class);
        this._$$end = false;
    }

    public IBattleMultipleMatches3FlexImpl(am3.g r13) {
        super(x1.class);
        this._$$userInfoMap = new HashMap();
        setThreadSafe(false);
        long r1 = r13.c();
        boolean r3 = false;
    L3:
        int r4 = r13.f();
        if (r4 == (-1)) goto L28;
        am3.g.a r7 = decodeExtensionFields(r4, r13);
        if (r4 != 3) goto L8;
        this._$$end = am3.h.a(r13);
        r3 = r3 | true;
        goto L3
    L8:
        if (r4 != 5000) goto L9;
        long r8 = r13.c();
        String r5 = null;
        IBattleMultipleMatchesUserInfoFlexImpl r9 = null;
    L11:
        int r10 = r13.f();
        if (r10 == (-1)) goto L19;
        if (r10 != 1) goto L15;
        r5 = am3.h.c(r13);
        goto L11
    L15:
        if (r10 != 2) goto L16;
        r9 = new IBattleMultipleMatchesUserInfoFlexImpl(r13);
        goto L11
    L16:
        am3.h.e(r13);
        goto L11
    L19:
        r13.d(r8);
        Map<String, IBattleMultipleMatchesUserInfoFlexImpl> r6 = this._$$userInfoMap;
        if (r5 == null) goto L26;
        if (r9 == null) goto L24;
        r6.put(r5, r9);
        goto L3
    L24:
        throw new IllegalStateException("Value must not be null");
    L26:
        throw new IllegalStateException("Key must not be null");
    L9:
        am3.h.d(r7, r13);
        goto L3
    L28:
        r13.d(r1);
        setThreadSafe(true);
        if ((r3 & true) == true) goto L52;
        this._$$end = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.x1
    public final boolean getEnd() {
        return this._$$end;
    }

    @Override // com.bytedance.android.livesdk.link.model.x1
    public final Map<String, IBattleMultipleMatchesUserInfoFlexImpl> getUserInfoMap() {
        return this._$$userInfoMap;
    }
}
