package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.im.PKIconBubble")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b%\u0010&R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00158VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010!\u001a\u00020\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\f\u001a\u0004\b \u0010\u001dR\u001b\u0010$\u001a\u00020\u00158VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\f\u001a\u0004\b#\u0010\u0018¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPKIconBubbleFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/IPKIconBubble;", "Lpy/k;", "displayIcon", "Lpy/k;", "getDisplayIcon", "()Lpy/k;", "setDisplayIcon", "(Lpy/k;)V", "", "bubbleType$delegate", "Ljava/lang/Object;", "getBubbleType", "()I", "bubbleType", "Lcom/bytedance/android/live/base/model/message/a5;", "displayTest$delegate", "getDisplayTest", "()Lcom/bytedance/android/live/base/model/message/a5;", "displayTest", "", "schema$delegate", "getSchema", "()Ljava/lang/String;", "schema", "", "showTime$delegate", "getShowTime", "()J", "showTime", "showCount$delegate", "getShowCount", "showCount", "activityType$delegate", "getActivityType", "activityType", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IPKIconBubbleFlexImpl extends FlexModelBase<IPKIconBubble> implements IPKIconBubble, vh7.h {

    @SerializedName("activity_name")
    protected String _$$activityType;

    @SerializedName("bubble_type")
    protected int _$$bubbleType;

    @SerializedName("display_text")
    protected com.bytedance.android.live.base.model.message.a5 _$$displayTest;

    @SerializedName("schema")
    protected String _$$schema;

    @SerializedName("show_count")
    protected long _$$showCount;

    @SerializedName("show_time")
    protected long _$$showTime;

    @SerializedName("display_icon")
    protected py.k displayIcon;

    public IPKIconBubbleFlexImpl() {
        super(IPKIconBubble.class);
        this._$$displayTest = $defaultValue_displayTest$();
        this.displayIcon = (py.k) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(py.k.class);
        this._$$schema = "";
        this._$$activityType = "";
    }

    public final com.bytedance.android.live.base.model.message.a5 $defaultValue_displayTest$() {
        IPKIconBubble.Companion.getClass();
        return IPKIconBubble.a.a;
    }

    @Override // com.bytedance.android.livesdk.link.model.IPKIconBubble
    public final String getActivityType() {
        return this._$$activityType;
    }

    @Override // com.bytedance.android.livesdk.link.model.IPKIconBubble
    public final int getBubbleType() {
        return this._$$bubbleType;
    }

    @Override // com.bytedance.android.livesdk.link.model.IPKIconBubble
    public py.k getDisplayIcon() {
        return this.displayIcon;
    }

    @Override // com.bytedance.android.livesdk.link.model.IPKIconBubble
    public final com.bytedance.android.live.base.model.message.a5 getDisplayTest() {
        return this._$$displayTest;
    }

    @Override // com.bytedance.android.livesdk.link.model.IPKIconBubble
    public final String getSchema() {
        return this._$$schema;
    }

    @Override // com.bytedance.android.livesdk.link.model.IPKIconBubble
    public final long getShowCount() {
        return this._$$showCount;
    }

    @Override // com.bytedance.android.livesdk.link.model.IPKIconBubble
    public final long getShowTime() {
        return this._$$showTime;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    public IPKIconBubbleFlexImpl(am3.g r5) {
        super(IPKIconBubble.class);
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        this._$$showCount = r5.j();
        goto L3
    L9:
        this._$$showTime = r5.j();
        goto L3
    L10:
        this._$$activityType = am3.h.c(r5);
        goto L3
    L11:
        this._$$bubbleType = r5.i();
        goto L3
    L12:
        this._$$schema = am3.h.c(r5);
        goto L3
    L13:
        this._$$displayTest = vh7.f.a(r5, com.bytedance.android.live.base.model.message.a5.class);
        goto L3
    L14:
        this.displayIcon = vh7.f.a(r5, py.k.class);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L15:
        r5.d(r0);
        setThreadSafe(true);
        if (this._$$displayTest != null) goto L19;
        this._$$displayTest = $defaultValue_displayTest$();
    L19:
        if (this.displayIcon != null) goto L22;
        this.displayIcon = (py.k) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(py.k.class);
    L22:
        if (this._$$schema != null) goto L25;
        this._$$schema = "";
    L25:
        if (this._$$activityType != null) goto L46;
        this._$$activityType = "";
        return;
    }

    public void setDisplayIcon(py.k r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.displayIcon = r2;
    }
}
