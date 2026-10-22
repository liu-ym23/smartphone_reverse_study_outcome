package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdk.gift.model.IRichText;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.BattleLinkerInviteMessageExtra.AcceptTip")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R(\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleInviteAcceptTipFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/l1;", "", "Lcom/bytedance/android/livesdk/gift/model/IRichText;", "content", "Ljava/util/List;", "getContent", "()Ljava/util/List;", "setContent", "(Ljava/util/List;)V", "Lpy/k;", "bgImage", "Lpy/k;", "getBgImage", "()Lpy/k;", "setBgImage", "(Lpy/k;)V", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleInviteAcceptTipFlexImpl extends FlexModelBase<l1> implements l1, vh7.h {

    @SerializedName("bg_img")
    protected py.k bgImage;

    @SerializedName("content")
    protected List<? extends IRichText> content;

    public IBattleInviteAcceptTipFlexImpl() {
        super(l1.class);
        this.content = com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
        this.bgImage = (py.k) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(py.k.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.l1
    public py.k getBgImage() {
        return this.bgImage;
    }

    @Override // com.bytedance.android.livesdk.link.model.l1
    public List<IRichText> getContent() {
        return this.content;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    public IBattleInviteAcceptTipFlexImpl(am3.g r6) {
        super(l1.class);
        this.content = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.content.add(vh7.f.a(r6, IRichText.class));
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.bgImage = vh7.f.a(r6, py.k.class);
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
        if (this.content.isEmpty() == false) goto L16;
        this.content = com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    L16:
        if (this.bgImage != null) goto L28;
        this.bgImage = (py.k) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(py.k.class);
        return;
    }

    public void setBgImage(py.k r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.bgImage = r2;
    }

    public void setContent(List<? extends IRichText> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.content = r2;
    }
}
