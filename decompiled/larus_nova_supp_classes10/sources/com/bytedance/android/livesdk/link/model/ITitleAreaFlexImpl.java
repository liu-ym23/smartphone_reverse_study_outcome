package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.battle.TitleArea")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ITitleAreaFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/v9;", "", "title$delegate", "Ljava/lang/Object;", "getTitle", "()Ljava/lang/String;", "title", "desc$delegate", "getDesc", "desc", "ruleUrl$delegate", "getRuleUrl", "ruleUrl", "Lcom/bytedance/android/livesdk/link/model/IButtonAreaFlexImpl;", "button$delegate", "getButton", "()Lcom/bytedance/android/livesdk/link/model/IButtonAreaFlexImpl;", "button", "Lcom/bytedance/android/livesdk/link/model/ICountDownFlexImpl;", "countDown$delegate", "getCountDown", "()Lcom/bytedance/android/livesdk/link/model/ICountDownFlexImpl;", "countDown", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ITitleAreaFlexImpl extends FlexModelBase<v9> implements v9, vh7.h {

    @SerializedName("button")
    protected IButtonAreaFlexImpl _$$button;

    @SerializedName("count_down")
    protected ICountDownFlexImpl _$$countDown;

    @SerializedName("desc")
    protected String _$$desc;

    @SerializedName("help_icon_url")
    protected String _$$ruleUrl;

    @SerializedName("title")
    protected String _$$title;

    public ITitleAreaFlexImpl() {
        super(v9.class);
    }

    public ITitleAreaFlexImpl(am3.g r6) {
        super(v9.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L21;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$title = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$desc = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$ruleUrl = am3.h.c(r6);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this._$$button = new IButtonAreaFlexImpl(r6);
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this._$$countDown = new ICountDownFlexImpl(r6);
        goto L3
    L15:
        am3.h.d(r3, r6);
        goto L3
    L21:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.link.model.v9
    public /* bridge */ /* synthetic */ p3 getButton() {
        return getButton();
    }

    @Override // com.bytedance.android.livesdk.link.model.v9
    public /* bridge */ /* synthetic */ b4 getCountDown() {
        return getCountDown();
    }

    @Override // com.bytedance.android.livesdk.link.model.v9
    public final String getDesc() {
        return this._$$desc;
    }

    @Override // com.bytedance.android.livesdk.link.model.v9
    public final String getRuleUrl() {
        return this._$$ruleUrl;
    }

    @Override // com.bytedance.android.livesdk.link.model.v9
    public final String getTitle() {
        return this._$$title;
    }

    @Override // com.bytedance.android.livesdk.link.model.v9
    public final IButtonAreaFlexImpl getButton() {
        return this._$$button;
    }

    @Override // com.bytedance.android.livesdk.link.model.v9
    public final ICountDownFlexImpl getCountDown() {
        return this._$$countDown;
    }
}
