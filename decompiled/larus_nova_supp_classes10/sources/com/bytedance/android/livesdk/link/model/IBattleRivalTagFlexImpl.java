package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.BattleRivalTag")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001b\u0010\u0012\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0015\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u001b\u0010\u001a\u001a\u00020\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001d\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0011¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleRivalTagFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/IBattleRivalTag;", "Lpy/k;", "backgroundImage", "Lpy/k;", "getBackgroundImage", "()Lpy/k;", "setBackgroundImage", "(Lpy/k;)V", "iconImage", "getIconImage", "setIconImage", "", "content$delegate", "Ljava/lang/Object;", "getContent", "()Ljava/lang/String;", "content", "fontColor$delegate", "getFontColor", "fontColor", "", "tagType$delegate", "getTagType", "()I", "tagType", "tagDesc$delegate", "getTagDesc", "tagDesc", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleRivalTagFlexImpl extends FlexModelBase<IBattleRivalTag> implements IBattleRivalTag, vh7.h {

    @SerializedName("content")
    protected String _$$content;

    @SerializedName("font_color")
    protected String _$$fontColor;

    @SerializedName("tag_desc")
    protected String _$$tagDesc;

    @SerializedName("tag_type")
    protected int _$$tagType;

    @SerializedName("bg_image")
    protected py.k backgroundImage;

    @SerializedName("icon_image")
    protected py.k iconImage;

    public IBattleRivalTagFlexImpl() {
        super(IBattleRivalTag.class);
        this._$$content = "";
        this._$$fontColor = "";
        this._$$tagDesc = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleRivalTag
    public py.k getBackgroundImage() {
        return this.backgroundImage;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleRivalTag
    public final String getContent() {
        return this._$$content;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleRivalTag
    public final String getFontColor() {
        return this._$$fontColor;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleRivalTag
    public py.k getIconImage() {
        return this.iconImage;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleRivalTag
    public final String getTagDesc() {
        return this._$$tagDesc;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleRivalTag
    public final int getTagType() {
        return this._$$tagType;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    public IBattleRivalTagFlexImpl(am3.g r5) {
        super(IBattleRivalTag.class);
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L14;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this._$$tagDesc = am3.h.c(r5);
        goto L3
    L9:
        this._$$tagType = r5.i();
        goto L3
    L10:
        this._$$fontColor = am3.h.c(r5);
        goto L3
    L11:
        this._$$content = am3.h.c(r5);
        goto L3
    L12:
        this.iconImage = vh7.f.a(r5, py.k.class);
        goto L3
    L13:
        this.backgroundImage = vh7.f.a(r5, py.k.class);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L14:
        r5.d(r0);
        setThreadSafe(true);
        if (this._$$content != null) goto L18;
        this._$$content = "";
    L18:
        if (this._$$fontColor != null) goto L21;
        this._$$fontColor = "";
    L21:
        if (this._$$tagDesc != null) goto L40;
        this._$$tagDesc = "";
        return;
    }

    public void setBackgroundImage(py.k r1) {
        this.backgroundImage = r1;
    }

    public void setIconImage(py.k r1) {
        this.iconImage = r1;
    }
}
