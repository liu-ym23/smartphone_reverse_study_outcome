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
@ProtoMessage("webcast.data.AnchorLinkmicEntranceInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b1\u00102R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR$\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR$\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001b\u0010\u001e\u001a\u00020\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010#\u001a\u0004\u0018\u00010\u001f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\"R\u001d\u0010&\u001a\u0004\u0018\u00010\u001f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010\"R\u001b\u0010)\u001a\u00020\u001f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u001b\u001a\u0004\b(\u0010\"R'\u00100\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u001b\u001a\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAnchorLinkmicEntranceInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/t;", "Lpy/k;", "icon", "Lpy/k;", "getIcon", "()Lpy/k;", "setIcon", "(Lpy/k;)V", "pk2LinkImage", "getPk2LinkImage", "setPk2LinkImage", "link2PkImage", "getLink2PkImage", "setLink2PkImage", "leadPkImage", "getLeadPkImage", "setLeadPkImage", "pkIcon", "getPkIcon", "setPkIcon", "anchorIcon", "getAnchorIcon", "setAnchorIcon", "", "panelType$delegate", "Ljava/lang/Object;", "getPanelType", "()I", "panelType", "", "text$delegate", "getText", "()Ljava/lang/String;", "text", "leadPkFreqKey$delegate", "getLeadPkFreqKey", "leadPkFreqKey", "wordType$delegate", "getWordType", "wordType", "", "", "Lcom/bytedance/android/livesdk/link/model/ILeadInfoFlexImpl;", "leadBubbleMap$delegate", "getLeadBubbleMap", "()Ljava/util/Map;", "leadBubbleMap", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IAnchorLinkmicEntranceInfoFlexImpl extends FlexModelBase<t> implements t, vh7.h {

    @SerializedName("button_lead")
    protected Map<Long, ILeadInfoFlexImpl> _$$leadBubbleMap;

    @SerializedName("lead_pk_freq_key")
    protected String _$$leadPkFreqKey;

    @SerializedName("panel_type")
    protected int _$$panelType;

    @SerializedName("text")
    protected String _$$text;

    @SerializedName("word_type")
    protected String _$$wordType;

    @SerializedName("anchor_icon")
    protected py.k anchorIcon;

    @SerializedName("icon")
    protected py.k icon;

    @SerializedName("lead_pk_image")
    protected py.k leadPkImage;

    @SerializedName("linkmic_to_pk_image")
    protected py.k link2PkImage;

    @SerializedName("pk_to_linkmic_image")
    protected py.k pk2LinkImage;

    @SerializedName("pk_icon")
    protected py.k pkIcon;

    public IAnchorLinkmicEntranceInfoFlexImpl() {
        super(t.class);
        this._$$wordType = "";
        this._$$leadBubbleMap = $defaultValue_leadBubbleMap$();
    }

    public final Map<Long, ILeadInfoFlexImpl> $defaultValue_leadBubbleMap$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    @Override // com.bytedance.android.livesdk.link.model.t
    public py.k getAnchorIcon() {
        return this.anchorIcon;
    }

    @Override // com.bytedance.android.livesdk.link.model.t
    public py.k getIcon() {
        return this.icon;
    }

    @Override // com.bytedance.android.livesdk.link.model.t
    public final Map<Long, ILeadInfoFlexImpl> getLeadBubbleMap() {
        return this._$$leadBubbleMap;
    }

    @Override // com.bytedance.android.livesdk.link.model.t
    public final String getLeadPkFreqKey() {
        return this._$$leadPkFreqKey;
    }

    @Override // com.bytedance.android.livesdk.link.model.t
    public py.k getLeadPkImage() {
        return this.leadPkImage;
    }

    @Override // com.bytedance.android.livesdk.link.model.t
    public py.k getLink2PkImage() {
        return this.link2PkImage;
    }

    @Override // com.bytedance.android.livesdk.link.model.t
    public final int getPanelType() {
        return this._$$panelType;
    }

    @Override // com.bytedance.android.livesdk.link.model.t
    public py.k getPk2LinkImage() {
        return this.pk2LinkImage;
    }

    @Override // com.bytedance.android.livesdk.link.model.t
    public py.k getPkIcon() {
        return this.pkIcon;
    }

    @Override // com.bytedance.android.livesdk.link.model.t
    public final String getText() {
        return this._$$text;
    }

    @Override // com.bytedance.android.livesdk.link.model.t
    public final String getWordType() {
        return this._$$wordType;
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object, py.k] */
    public IAnchorLinkmicEntranceInfoFlexImpl(am3.g r11) {
        super(t.class);
        this._$$leadBubbleMap = new HashMap();
        setThreadSafe(false);
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L35;
        am3.g.a r5 = decodeExtensionFields(r2, r11);
        switch(r2) {
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L31;
            case 5: goto L30;
            case 6: goto L29;
            case 7: goto L28;
            case 8: goto L27;
            case 9: goto L26;
            case 10: goto L25;
            case 11: goto L8;
            default: goto L7;
        };
    L8:
        long r6 = r11.c();
        Long r3 = null;
        ILeadInfoFlexImpl r7 = null;
    L9:
        int r8 = r11.f();
        if (r8 == (-1)) goto L17;
        if (r8 != 1) goto L13;
        r3 = Long.valueOf(r11.j());
        goto L9
    L13:
        if (r8 != 2) goto L14;
        r7 = new ILeadInfoFlexImpl(r11);
        goto L9
    L14:
        am3.h.e(r11);
        goto L9
    L17:
        r11.d(r6);
        Map<Long, ILeadInfoFlexImpl> r4 = this._$$leadBubbleMap;
        if (r3 == null) goto L24;
        if (r7 == null) goto L22;
        r4.put(r3, r7);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L25:
        this._$$wordType = am3.h.c(r11);
        goto L3
    L26:
        this.anchorIcon = vh7.f.a(r11, py.k.class);
        goto L3
    L27:
        this.pkIcon = vh7.f.a(r11, py.k.class);
        goto L3
    L28:
        this._$$leadPkFreqKey = am3.h.c(r11);
        goto L3
    L29:
        this.leadPkImage = vh7.f.a(r11, py.k.class);
        goto L3
    L30:
        this.link2PkImage = vh7.f.a(r11, py.k.class);
        goto L3
    L31:
        this.pk2LinkImage = vh7.f.a(r11, py.k.class);
        goto L3
    L32:
        this._$$text = am3.h.c(r11);
        goto L3
    L33:
        this.icon = vh7.f.a(r11, py.k.class);
        goto L3
    L34:
        this._$$panelType = r11.i();
        goto L3
    L7:
        am3.h.d(r5, r11);
        goto L3
    L35:
        r11.d(r0);
        setThreadSafe(true);
        if (this._$$wordType != null) goto L39;
        this._$$wordType = "";
    L39:
        if (this._$$leadBubbleMap != null) goto L79;
        this._$$leadBubbleMap = $defaultValue_leadBubbleMap$();
        return;
    }

    public void setAnchorIcon(py.k r1) {
        this.anchorIcon = r1;
    }

    public void setIcon(py.k r1) {
        this.icon = r1;
    }

    public void setLeadPkImage(py.k r1) {
        this.leadPkImage = r1;
    }

    public void setLink2PkImage(py.k r1) {
        this.link2PkImage = r1;
    }

    public void setPk2LinkImage(py.k r1) {
        this.pk2LinkImage = r1;
    }

    public void setPkIcon(py.k r1) {
        this.pkIcon = r1;
    }
}
