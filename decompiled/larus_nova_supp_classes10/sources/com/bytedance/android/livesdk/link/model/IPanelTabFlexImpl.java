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
@ProtoMessage("webcast.api.battle.PanelTab")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0011\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\u001b\u0010\u0016\u001a\u00020\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPanelTabFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/p7;", "", "tabName$delegate", "Ljava/lang/Object;", "getTabName", "()Ljava/lang/String;", "tabName", "", "Lcom/bytedance/android/livesdk/link/model/IBattlePanelFlexImpl;", "list$delegate", "getList", "()Ljava/util/List;", "list", "tagText$delegate", "getTagText", "tagText", "", "tagVersion$delegate", "getTagVersion", "()J", "tagVersion", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IPanelTabFlexImpl extends FlexModelBase<p7> implements p7, vh7.h {

    @SerializedName("list")
    protected List<IBattlePanelFlexImpl> _$$list;

    @SerializedName("tab_name")
    protected String _$$tabName;

    @SerializedName("tag_text")
    protected String _$$tagText;

    @SerializedName("tag_version")
    protected long _$$tagVersion;

    public IPanelTabFlexImpl() {
        super(p7.class);
        this._$$tabName = "";
        this._$$list = $defaultValue_list$();
        this._$$tagText = "";
    }

    public final List<IBattlePanelFlexImpl> $defaultValue_list$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.link.model.p7
    public final List<IBattlePanelFlexImpl> getList() {
        return this._$$list;
    }

    @Override // com.bytedance.android.livesdk.link.model.p7
    public final String getTabName() {
        return this._$$tabName;
    }

    @Override // com.bytedance.android.livesdk.link.model.p7
    public final String getTagText() {
        return this._$$tagText;
    }

    @Override // com.bytedance.android.livesdk.link.model.p7
    public final long getTagVersion() {
        return this._$$tagVersion;
    }

    public IPanelTabFlexImpl(am3.g r6) {
        super(p7.class);
        this._$$list = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L18;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$tabName = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$list.add(new IBattlePanelFlexImpl(r6));
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$tagText = am3.h.c(r6);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this._$$tagVersion = r6.j();
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L18:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$tabName != null) goto L22;
        this._$$tabName = "";
    L22:
        if (this._$$list.isEmpty() == false) goto L25;
        this._$$list = $defaultValue_list$();
    L25:
        if (this._$$tagText != null) goto L43;
        this._$$tagText = "";
        return;
    }
}
