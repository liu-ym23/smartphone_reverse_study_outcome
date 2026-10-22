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
@ProtoMessage("webcast.data.AnchorLinkmicAudioPunishInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007R#\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAudioPunishInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/z;", "", "schemaUrl$delegate", "Ljava/lang/Object;", "getSchemaUrl", "()Ljava/lang/String;", "schemaUrl", "content$delegate", "getContent", "content", "", "remainSeconds$delegate", "getRemainSeconds", "()J", "remainSeconds", "userId$delegate", "getUserId", "userId", "", "punishedLinkmicIdStrList$delegate", "getPunishedLinkmicIdStrList", "()Ljava/util/List;", "punishedLinkmicIdStrList", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IAudioPunishInfoFlexImpl extends FlexModelBase<z> implements z, vh7.h {

    @SerializedName("content")
    protected String _$$content;

    @SerializedName("punished_linkmic_id_str_list")
    protected List<String> _$$punishedLinkmicIdStrList;

    @SerializedName("remain_seconds")
    protected long _$$remainSeconds;

    @SerializedName("schema_url")
    protected String _$$schemaUrl;

    @SerializedName("user_open_id")
    protected String _$$userId;

    public IAudioPunishInfoFlexImpl() {
        super(z.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.z
    public final String getContent() {
        return this._$$content;
    }

    @Override // com.bytedance.android.livesdk.link.model.z
    public final List<String> getPunishedLinkmicIdStrList() {
        return this._$$punishedLinkmicIdStrList;
    }

    @Override // com.bytedance.android.livesdk.link.model.z
    public final long getRemainSeconds() {
        return this._$$remainSeconds;
    }

    @Override // com.bytedance.android.livesdk.link.model.z
    public final String getSchemaUrl() {
        return this._$$schemaUrl;
    }

    @Override // com.bytedance.android.livesdk.link.model.z
    public final String getUserId() {
        return this._$$userId;
    }

    public IAudioPunishInfoFlexImpl(am3.g r6) {
        super(z.class);
        this._$$punishedLinkmicIdStrList = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L21;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$schemaUrl = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$content = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$remainSeconds = r6.j();
        goto L3
    L12:
        if (r2 != 6) goto L14;
        this._$$punishedLinkmicIdStrList.add(am3.h.c(r6));
        goto L3
    L14:
        if (r2 != 5000) goto L15;
        this._$$userId = am3.h.c(r6);
        goto L3
    L15:
        am3.h.d(r3, r6);
        goto L3
    L21:
        r6.d(r0);
        setThreadSafe(true);
    }
}
