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
@ProtoMessage("webcast.api.battle.RivalsRecommendResponse.PKSubTab")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPkSubTabFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/y7;", "", "name$delegate", "Ljava/lang/Object;", "getName", "()Ljava/lang/String;", "name", "", "selected$delegate", "getSelected", "()Z", "selected", "Lcom/bytedance/android/livesdk/link/model/IPkSubTabKeyFlexImpl;", "key$delegate", "getKey", "()Lcom/bytedance/android/livesdk/link/model/IPkSubTabKeyFlexImpl;", "key", "", "Lcom/bytedance/android/livesdk/link/model/IPanelAreaFlexImpl;", "areas$delegate", "getAreas", "()Ljava/util/List;", "areas", "trackingInfo$delegate", "getTrackingInfo", "trackingInfo", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IPkSubTabFlexImpl extends FlexModelBase<y7> implements y7, vh7.h {

    @SerializedName("areas")
    protected List<IPanelAreaFlexImpl> _$$areas;

    @SerializedName("key")
    protected IPkSubTabKeyFlexImpl _$$key;

    @SerializedName("name")
    protected String _$$name;

    @SerializedName("selected")
    protected boolean _$$selected;

    @SerializedName("event_tracking_info")
    protected String _$$trackingInfo;

    public IPkSubTabFlexImpl() {
        super(y7.class);
        this._$$selected = false;
    }

    public IPkSubTabFlexImpl(am3.g r8) {
        super(y7.class);
        this._$$areas = new ArrayList();
        setThreadSafe(false);
        long r1 = r8.c();
        boolean r3 = false;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L21;
        am3.g.a r5 = decodeExtensionFields(r4, r8);
        if (r4 != 1) goto L8;
        this._$$key = new IPkSubTabKeyFlexImpl(r8);
        goto L3
    L8:
        if (r4 != 2) goto L10;
        this._$$name = am3.h.c(r8);
        goto L3
    L10:
        if (r4 != 3) goto L12;
        this._$$selected = am3.h.a(r8);
        r3 = r3 | true;
        goto L3
    L12:
        if (r4 != 4) goto L14;
        this._$$areas.add(new IPanelAreaFlexImpl(r8));
        goto L3
    L14:
        if (r4 != 5) goto L15;
        this._$$trackingInfo = am3.h.c(r8);
        goto L3
    L15:
        am3.h.d(r5, r8);
        goto L3
    L21:
        r8.d(r1);
        setThreadSafe(true);
        if ((r3 & true) == true) goto L43;
        this._$$selected = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.y7
    public /* bridge */ /* synthetic */ IPkSubTabKey getKey() {
        return getKey();
    }

    @Override // com.bytedance.android.livesdk.link.model.y7
    public final List<IPanelAreaFlexImpl> getAreas() {
        return this._$$areas;
    }

    @Override // com.bytedance.android.livesdk.link.model.y7
    public final String getName() {
        return this._$$name;
    }

    @Override // com.bytedance.android.livesdk.link.model.y7
    public final boolean getSelected() {
        return this._$$selected;
    }

    @Override // com.bytedance.android.livesdk.link.model.y7
    public final String getTrackingInfo() {
        return this._$$trackingInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.y7
    public final IPkSubTabKeyFlexImpl getKey() {
        return this._$$key;
    }
}
