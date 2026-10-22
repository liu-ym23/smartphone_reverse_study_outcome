package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.battle.BattleGetPanelListResponse.AutoMatchInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b&\u0010'R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R+\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR+\u0010!\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR+\u0010%\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0006\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001c¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleGetPanelAutoMatchInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/h1;", "Lcom/bytedance/android/livesdk/link/model/i1;", "<set-?>", "config$delegate", "Ljava/lang/Object;", "getConfig", "()Lcom/bytedance/android/livesdk/link/model/i1;", "setConfig", "(Lcom/bytedance/android/livesdk/link/model/i1;)V", "config", "", "mainTitle$delegate", "getMainTitle", "()Ljava/lang/String;", "setMainTitle", "(Ljava/lang/String;)V", "mainTitle", "subTitle$delegate", "getSubTitle", "setSubTitle", "subTitle", "", "waitSec$delegate", "getWaitSec", "()J", "setWaitSec", "(J)V", "waitSec", "accelerateLimit$delegate", "getAccelerateLimit", "setAccelerateLimit", "accelerateLimit", "defaultWaitLimit$delegate", "getDefaultWaitLimit", "setDefaultWaitLimit", "defaultWaitLimit", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleGetPanelAutoMatchInfoFlexImpl extends FlexModelBase<h1> implements h1, vh7.h {

    @SerializedName("accelerate_limit")
    protected long _$$accelerateLimit;

    @SerializedName("config")
    protected i1 _$$config;

    @SerializedName("default_wait_limit")
    protected long _$$defaultWaitLimit;

    @SerializedName("main_title")
    protected String _$$mainTitle;

    @SerializedName("sub_title")
    protected String _$$subTitle;

    @SerializedName("wait_sec")
    protected long _$$waitSec;

    public IBattleGetPanelAutoMatchInfoFlexImpl() {
        super(h1.class);
        this._$$mainTitle = "";
        this._$$subTitle = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.h1, com.bytedance.android.livesdk.link.model.b0
    public /* bridge */ /* synthetic */ c0 getConfig() {
        return getConfig();
    }

    @Override // com.bytedance.android.livesdk.link.model.h1, af2.a
    public final long getAccelerateLimit() {
        return this._$$accelerateLimit;
    }

    @Override // com.bytedance.android.livesdk.link.model.h1, af2.a
    public final long getDefaultWaitLimit() {
        return this._$$defaultWaitLimit;
    }

    @Override // com.bytedance.android.livesdk.link.model.h1, af2.a
    public final String getMainTitle() {
        return this._$$mainTitle;
    }

    @Override // com.bytedance.android.livesdk.link.model.h1, af2.a
    public final String getSubTitle() {
        return this._$$subTitle;
    }

    @Override // com.bytedance.android.livesdk.link.model.h1, af2.a
    public final long getWaitSec() {
        return this._$$waitSec;
    }

    @Override // com.bytedance.android.livesdk.link.model.h1, com.bytedance.android.livesdk.link.model.b0
    public final i1 getConfig() {
        return this._$$config;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.livesdk.link.model.i1, java.lang.Object] */
    public IBattleGetPanelAutoMatchInfoFlexImpl(am3.g r6) {
        super(h1.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L24;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$mainTitle = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$subTitle = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$waitSec = r6.j();
        goto L3
    L12:
        if (r2 != 5) goto L14;
        this._$$accelerateLimit = r6.j();
        goto L3
    L14:
        if (r2 != 6) goto L16;
        this._$$config = vh7.f.a(r6, i1.class);
        goto L3
    L16:
        if (r2 != 7) goto L17;
        this._$$defaultWaitLimit = r6.j();
        goto L3
    L17:
        am3.h.d(r3, r6);
        goto L3
    L24:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$mainTitle != null) goto L28;
        this._$$mainTitle = "";
    L28:
        if (this._$$subTitle != null) goto L52;
        this._$$subTitle = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.h1
    public final void setAccelerateLimit(long r1) {
        this._$$accelerateLimit = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.h1
    public final void setConfig(i1 r1) {
        this._$$config = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.h1
    public final void setDefaultWaitLimit(long r1) {
        this._$$defaultWaitLimit = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.h1
    public final void setMainTitle(String r1) {
        this._$$mainTitle = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.h1
    public final void setSubTitle(String r1) {
        this._$$subTitle = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.h1, af2.a
    public final void setWaitSec(long r1) {
        this._$$waitSec = r1;
    }
}
