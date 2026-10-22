package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.im.LinkMicArmies.UserArmies")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\r\u0010\u000eR7\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkMicArmiesMessage_IUserArmiesFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/w4$b;", "", "Lcom/bytedance/android/livesdk/link/model/w4$b$b;", "<set-?>", "userArmies$delegate", "Ljava/lang/Object;", "getUserArmies", "()Ljava/util/List;", "setUserArmies", "(Ljava/util/List;)V", "userArmies", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkMicArmiesMessage_IUserArmiesFlexImpl extends FlexModelBase<w4.b> implements w4.b, vh7.h {

    @SerializedName("user_armies")
    protected List<? extends w4.b.InterfaceC0057b> _$$userArmies;

    public ILinkMicArmiesMessage_IUserArmiesFlexImpl() {
        super(w4.b.class);
        this._$$userArmies = $defaultValue_userArmies$();
    }

    public ILinkMicArmiesMessage_IUserArmiesFlexImpl(am3.g r6) {
        super(w4.b.class);
        this._$$userArmies = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L9;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L7;
        this._$$userArmies.add(vh7.f.a(r6, w4.b.InterfaceC0057b.class));
        goto L3
    L7:
        am3.h.d(r3, r6);
        goto L3
    L9:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$userArmies.isEmpty() == false) goto L19;
        this._$$userArmies = $defaultValue_userArmies$();
        return;
    }

    public final List<w4.b.InterfaceC0057b> $defaultValue_userArmies$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.link.model.w4.b
    public final List<w4.b.InterfaceC0057b> getUserArmies() {
        return this._$$userArmies;
    }

    @Override // com.bytedance.android.livesdk.link.model.w4.b
    public final void setUserArmies(List<? extends w4.b.InterfaceC0057b> r1) {
        this._$$userArmies = r1;
    }
}
