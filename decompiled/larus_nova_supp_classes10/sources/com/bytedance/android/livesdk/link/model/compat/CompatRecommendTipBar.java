package com.bytedance.android.livesdk.link.model.compat;

import am3.g;
import com.bytedance.android.livesdk.link.model.m8;
import com.bytedance.android.livesdk.link.model.t7;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0097D¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00038\u0016X\u0097D¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\n8\u0016X\u0097D¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/compat/CompatRecommendTipBar;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/m8;", "", "skinType", "J", "getSkinType", "()J", "setSkinType", "(J)V", "", "infoContent", "Ljava/lang/String;", "getInfoContent", "()Ljava/lang/String;", "countDown", "getCountDown", "Lcom/bytedance/android/livesdk/link/model/t7;", "action", "Lcom/bytedance/android/livesdk/link/model/t7;", "getAction", "()Lcom/bytedance/android/livesdk/link/model/t7;", "schemaUrl", "getSchemaUrl", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CompatRecommendTipBar extends FlexModelBase<m8> implements m8, h {

    @SerializedName("action")
    protected t7 action;

    @SerializedName("countdown")
    protected long countDown;

    @SerializedName("info_content_tpl")
    protected String infoContent;

    @SerializedName("scheme_url")
    protected String schemaUrl;
    private long skinType;

    public CompatRecommendTipBar() {
        super(m8.class);
        this.infoContent = "";
        this.schemaUrl = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.m8
    public t7 getAction() {
        return this.action;
    }

    @Override // com.bytedance.android.livesdk.link.model.m8
    public long getCountDown() {
        return this.countDown;
    }

    @Override // com.bytedance.android.livesdk.link.model.m8
    public String getInfoContent() {
        return this.infoContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.m8
    public String getSchemaUrl() {
        return this.schemaUrl;
    }

    public final long getSkinType() {
        return this.skinType;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.livesdk.link.model.t7, java.lang.Object] */
    public CompatRecommendTipBar(g r6) {
        super(m8.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L18;
        g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.infoContent = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.countDown = r6.j();
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.action = f.a(r6, t7.class);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this.schemaUrl = am3.h.c(r6);
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L18:
        r6.d(r0);
        setThreadSafe(true);
        if (this.infoContent != null) goto L22;
        this.infoContent = "";
    L22:
        if (this.schemaUrl != null) goto L40;
        this.schemaUrl = "";
        return;
    }

    public final void setSkinType(long r1) {
        this.skinType = r1;
    }
}
