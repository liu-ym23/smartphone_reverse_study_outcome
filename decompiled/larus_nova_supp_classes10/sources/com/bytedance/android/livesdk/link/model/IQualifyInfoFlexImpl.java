package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.battle.RivalsRecommendResponse.RankSeasonInfo.QualifyInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0012\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001b\u0010\u0017\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IQualifyInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/f8;", "Lcom/bytedance/android/live/base/model/message/a5;", "desc", "Lcom/bytedance/android/live/base/model/message/a5;", "getDesc", "()Lcom/bytedance/android/live/base/model/message/a5;", "setDesc", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "", "count$delegate", "Ljava/lang/Object;", "getCount", "()J", "count", "targetCount$delegate", "getTargetCount", "targetCount", "", "title$delegate", "getTitle", "()Ljava/lang/String;", "title", "", "showProgress$delegate", "getShowProgress", "()Z", "showProgress", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IQualifyInfoFlexImpl extends FlexModelBase<f8> implements f8, vh7.h {

    @SerializedName("cur_count")
    protected long _$$count;

    @SerializedName("show_progress")
    protected boolean _$$showProgress;

    @SerializedName("target_count")
    protected long _$$targetCount;

    @SerializedName("title")
    protected String _$$title;

    @SerializedName("desc")
    protected com.bytedance.android.live.base.model.message.a5 desc;

    public IQualifyInfoFlexImpl() {
        super(f8.class);
        this.desc = (com.bytedance.android.live.base.model.message.a5) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(com.bytedance.android.live.base.model.message.a5.class);
        this._$$title = "";
        this._$$showProgress = false;
    }

    @Override // com.bytedance.android.livesdk.link.model.f8
    public final long getCount() {
        return this._$$count;
    }

    @Override // com.bytedance.android.livesdk.link.model.f8
    public com.bytedance.android.live.base.model.message.a5 getDesc() {
        return this.desc;
    }

    @Override // com.bytedance.android.livesdk.link.model.f8
    public final boolean getShowProgress() {
        return this._$$showProgress;
    }

    @Override // com.bytedance.android.livesdk.link.model.f8
    public final long getTargetCount() {
        return this._$$targetCount;
    }

    @Override // com.bytedance.android.livesdk.link.model.f8
    public final String getTitle() {
        return this._$$title;
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    public IQualifyInfoFlexImpl(am3.g r9) {
        super(f8.class);
        setThreadSafe(false);
        long r1 = r9.c();
        int r3 = 0;
    L3:
        int r4 = r9.f();
        if (r4 == (-1)) goto L20;
        am3.g.a r5 = decodeExtensionFields(r4, r9);
        if (r4 != 1) goto L8;
        this._$$count = r9.j();
        r3 = r3 | 1;
        goto L3
    L8:
        if (r4 != 2) goto L10;
        this._$$targetCount = r9.j();
        r3 = r3 | 2;
        goto L3
    L10:
        if (r4 != 3) goto L11;
        this.desc = vh7.f.a(r9, com.bytedance.android.live.base.model.message.a5.class);
        goto L3
    L11:
        if (r4 != 4) goto L13;
        this._$$title = am3.h.c(r9);
        goto L3
    L13:
        if (r4 != 5) goto L14;
        this._$$showProgress = am3.h.a(r9);
        r3 = r3 | 4;
        goto L3
    L14:
        am3.h.d(r5, r9);
        goto L3
    L20:
        r9.d(r1);
        setThreadSafe(true);
        if (this.desc != null) goto L24;
        this.desc = (com.bytedance.android.live.base.model.message.a5) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(com.bytedance.android.live.base.model.message.a5.class);
    L24:
        if (this._$$title != null) goto L27;
        this._$$title = "";
    L27:
        if ((r3 & 4) != 0) goto L48;
        this._$$showProgress = false;
        return;
    }

    public void setDesc(com.bytedance.android.live.base.model.message.a5 r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.desc = r2;
    }
}
