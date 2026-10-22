package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.linkmic.AutoMatchBanner")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAutoMatchBannerFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/a0;", "Lcom/bytedance/android/live/base/model/message/a5;", "mainText", "Lcom/bytedance/android/live/base/model/message/a5;", "getMainText", "()Lcom/bytedance/android/live/base/model/message/a5;", "setMainText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "subText", "getSubText", "setSubText", "buttonText", "getButtonText", "setButtonText", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IAutoMatchBannerFlexImpl extends FlexModelBase<a0> implements a0, vh7.h {

    @SerializedName("button_text")
    protected com.bytedance.android.live.base.model.message.a5 buttonText;

    @SerializedName("main_guide_text")
    protected com.bytedance.android.live.base.model.message.a5 mainText;

    @SerializedName("sub_guide_text")
    protected com.bytedance.android.live.base.model.message.a5 subText;

    public IAutoMatchBannerFlexImpl() {
        super(a0.class);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    public IAutoMatchBannerFlexImpl(am3.g r6) {
        super(a0.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.mainText = vh7.f.a(r6, com.bytedance.android.live.base.model.message.a5.class);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.subText = vh7.f.a(r6, com.bytedance.android.live.base.model.message.a5.class);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.buttonText = vh7.f.a(r6, com.bytedance.android.live.base.model.message.a5.class);
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.link.model.a0
    public com.bytedance.android.live.base.model.message.a5 getButtonText() {
        return this.buttonText;
    }

    @Override // com.bytedance.android.livesdk.link.model.a0
    public com.bytedance.android.live.base.model.message.a5 getMainText() {
        return this.mainText;
    }

    @Override // com.bytedance.android.livesdk.link.model.a0
    public com.bytedance.android.live.base.model.message.a5 getSubText() {
        return this.subText;
    }

    public void setButtonText(com.bytedance.android.live.base.model.message.a5 r1) {
        this.buttonText = r1;
    }

    public void setMainText(com.bytedance.android.live.base.model.message.a5 r1) {
        this.mainText = r1;
    }

    public void setSubText(com.bytedance.android.live.base.model.message.a5 r1) {
        this.subText = r1;
    }
}
