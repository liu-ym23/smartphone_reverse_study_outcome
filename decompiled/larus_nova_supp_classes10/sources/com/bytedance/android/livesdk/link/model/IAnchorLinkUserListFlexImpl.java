package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.linkmic.ListResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b-\u0010.R#\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\u0012R)\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001e\u001a\u00020\u00158VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0006\u001a\u0004\b!\u0010\"R\u001d\u0010(\u001a\u0004\u0018\u00010$8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0006\u001a\u0004\b&\u0010'R#\u0010,\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0006\u001a\u0004\b+\u0010\b¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAnchorLinkUserListFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/r;", "", "Lcom/bytedance/android/livesdk/link/model/IAnchorLinkUserExtensionImpl;", "linkUsers$delegate", "Ljava/lang/Object;", "getLinkUsers", "()Ljava/util/List;", "linkUsers", "Lcom/bytedance/android/livesdk/link/model/IBattleStatsMetaFlexImpl;", "battleStatsMeta$delegate", "getBattleStatsMeta", "()Lcom/bytedance/android/livesdk/link/model/IBattleStatsMetaFlexImpl;", "battleStatsMeta", "Lcom/bytedance/android/livesdk/link/model/ILinkStatsMetaFlexImpl;", "linkStatsMeta$delegate", "getLinkStatsMeta", "()Lcom/bytedance/android/livesdk/link/model/ILinkStatsMetaFlexImpl;", "linkStatsMeta", "", "", "Lcom/bytedance/android/livesdk/link/model/IRoomLinkerContentExtensionImpl;", "linkerContentMap$delegate", "getLinkerContentMap", "()Ljava/util/Map;", "linkerContentMap", "version$delegate", "getVersion", "()J", "version", "Lcom/bytedance/android/livesdk/link/model/IAnchorLinkUserList_IBizExtraExtensionImpl;", "bizExtra$delegate", "getBizExtra", "()Lcom/bytedance/android/livesdk/link/model/IAnchorLinkUserList_IBizExtraExtensionImpl;", "bizExtra", "Lcom/bytedance/android/livesdk/link/model/IAudioPunishInfoFlexImpl;", "audioPunishInfo$delegate", "getAudioPunishInfo", "()Lcom/bytedance/android/livesdk/link/model/IAudioPunishInfoFlexImpl;", "audioPunishInfo", "Lcom/bytedance/android/livesdk/link/model/IAIAssistantUserExtensionImpl;", "aiAssistantList$delegate", "getAiAssistantList", "aiAssistantList", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IAnchorLinkUserListFlexImpl extends FlexModelBase<r> implements r, vh7.h {

    @SerializedName("ai_assistants")
    protected List<IAIAssistantUserExtensionImpl> _$$aiAssistantList;

    @SerializedName("audio_punish_info")
    protected IAudioPunishInfoFlexImpl _$$audioPunishInfo;

    @SerializedName("battle_stats")
    protected IBattleStatsMetaFlexImpl _$$battleStatsMeta;

    @SerializedName("extra")
    protected IAnchorLinkUserList_IBizExtraExtensionImpl _$$bizExtra;

    @SerializedName("linker_stats")
    protected ILinkStatsMetaFlexImpl _$$linkStatsMeta;

    @SerializedName("user")
    protected List<IAnchorLinkUserExtensionImpl> _$$linkUsers;

    @SerializedName("linker_content_map")
    protected Map<Long, IRoomLinkerContentExtensionImpl> _$$linkerContentMap;

    @SerializedName("version")
    protected long _$$version;

    public IAnchorLinkUserListFlexImpl() {
        super(r.class);
        this._$$bizExtra = $defaultValue_bizExtra$();
    }

    public final IAnchorLinkUserList_IBizExtraExtensionImpl $defaultValue_bizExtra$() {
        return (IAnchorLinkUserList_IBizExtraExtensionImpl) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(IAnchorLinkUserList_IBizExtraExtensionImpl.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.r
    public /* bridge */ /* synthetic */ z getAudioPunishInfo() {
        return getAudioPunishInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.r
    public /* bridge */ /* synthetic */ c3 getBattleStatsMeta() {
        return getBattleStatsMeta();
    }

    @Override // com.bytedance.android.livesdk.link.model.r
    public /* bridge */ /* synthetic */ r.b getBizExtra() {
        return getBizExtra();
    }

    @Override // com.bytedance.android.livesdk.link.model.r
    public /* bridge */ /* synthetic */ s5 getLinkStatsMeta() {
        return getLinkStatsMeta();
    }

    @Override // com.bytedance.android.livesdk.link.model.r
    public final List<IAIAssistantUserExtensionImpl> getAiAssistantList() {
        return this._$$aiAssistantList;
    }

    @Override // com.bytedance.android.livesdk.link.model.r
    public final List<IAnchorLinkUserExtensionImpl> getLinkUsers() {
        return this._$$linkUsers;
    }

    @Override // com.bytedance.android.livesdk.link.model.r
    public final Map<Long, IRoomLinkerContentExtensionImpl> getLinkerContentMap() {
        return this._$$linkerContentMap;
    }

    @Override // com.bytedance.android.livesdk.link.model.r
    public final long getVersion() {
        return this._$$version;
    }

    @Override // com.bytedance.android.livesdk.link.model.r
    public final IAudioPunishInfoFlexImpl getAudioPunishInfo() {
        return this._$$audioPunishInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.r
    public final IBattleStatsMetaFlexImpl getBattleStatsMeta() {
        return this._$$battleStatsMeta;
    }

    @Override // com.bytedance.android.livesdk.link.model.r
    public final IAnchorLinkUserList_IBizExtraExtensionImpl getBizExtra() {
        return this._$$bizExtra;
    }

    @Override // com.bytedance.android.livesdk.link.model.r
    public final ILinkStatsMetaFlexImpl getLinkStatsMeta() {
        return this._$$linkStatsMeta;
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.Object, vh7.c] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, vh7.c] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object, vh7.c] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Object, vh7.c] */
    public IAnchorLinkUserListFlexImpl(am3.g r11) {
        super(r.class);
        this._$$linkUsers = new ArrayList();
        this._$$linkerContentMap = new HashMap();
        this._$$aiAssistantList = new ArrayList();
        setThreadSafe(false);
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L33;
        am3.g.a r5 = decodeExtensionFields(r2, r11);
        switch(r2) {
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L7;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L7;
            case 10: goto L8;
            default: goto L7;
        };
    L8:
        List r3 = this._$$aiAssistantList;
        vh7.e r4 = (IAIAssistantUserExtensionImpl) vh7.f.a(r11, com.bytedance.android.livesdk.link.model.bridge.d.class).castTo(IAIAssistantUserExtensionImpl.class);
    L32:
        r3.add(r4);
        goto L3
    L9:
        this._$$audioPunishInfo = new IAudioPunishInfoFlexImpl(r11);
        goto L3
    L10:
        this._$$bizExtra = (IAnchorLinkUserList_IBizExtraExtensionImpl) vh7.f.a(r11, com.bytedance.android.livesdk.link.model.bridge.e0.class).castTo(IAnchorLinkUserList_IBizExtraExtensionImpl.class);
        goto L3
    L11:
        this._$$version = r11.j();
        goto L3
    L12:
        this._$$linkStatsMeta = new ILinkStatsMetaFlexImpl(r11);
        goto L3
    L13:
        long r6 = r11.c();
        Long r7 = null;
        IRoomLinkerContentExtensionImpl r8 = null;
    L14:
        int r9 = r11.f();
        if (r9 == (-1)) goto L22;
        if (r9 != 1) goto L18;
        r7 = Long.valueOf(r11.j());
        goto L14
    L18:
        if (r9 != 2) goto L19;
        r8 = (IRoomLinkerContentExtensionImpl) vh7.f.a(r11, com.bytedance.android.livesdk.link.model.bridge.g2.class).castTo(IRoomLinkerContentExtensionImpl.class);
        goto L14
    L19:
        am3.h.e(r11);
        goto L14
    L22:
        r11.d(r6);
        Map<Long, IRoomLinkerContentExtensionImpl> r10 = this._$$linkerContentMap;
        if (r7 == null) goto L29;
        if (r8 == null) goto L27;
        r10.put(r7, r8);
        goto L3
    L27:
        throw new IllegalStateException("Value must not be null");
    L29:
        throw new IllegalStateException("Key must not be null");
    L30:
        this._$$battleStatsMeta = new IBattleStatsMetaFlexImpl(r11);
        goto L3
    L31:
        r3 = this._$$linkUsers;
        r4 = (IAnchorLinkUserExtensionImpl) vh7.f.a(r11, com.bytedance.android.livesdk.link.model.bridge.k.class).castTo(IAnchorLinkUserExtensionImpl.class);
        goto L32
    L7:
        am3.h.d(r5, r11);
        goto L3
    L33:
        r11.d(r0);
        setThreadSafe(true);
        if (this._$$bizExtra != null) goto L67;
        this._$$bizExtra = $defaultValue_bizExtra$();
        return;
    }
}
