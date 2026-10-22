package com.larus.bot.impl.feature.edit.feature.autofill.model;

import com.google.gson.annotations.SerializedName;
import com.larus.bot.impl.bean.EnrichBotData;
import com.larus.im.bean.bot.CreationIdInfo;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001Bc\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/autofill/model/BotEnrichParam;", "Ljava/io/Serializable;", "name", "", "botLang", "needDesc", "", "needVoiceType", "bgImgPrompt", "enrichBotContent", "", "Lcom/larus/bot/impl/bean/EnrichBotData;", "creationIdInfo", "Lcom/larus/im/bean/bot/CreationIdInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Lcom/larus/im/bean/bot/CreationIdInfo;)V", "Ljava/lang/Boolean;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotEnrichParam implements Serializable {

    @SerializedName("bg_img_prompt")
    public final String bgImgPrompt;

    @SerializedName("bot_lang")
    public final String botLang;

    @SerializedName("creation_id_info")
    public final CreationIdInfo creationIdInfo;

    @SerializedName("data")
    public final List<EnrichBotData> enrichBotContent;

    @SerializedName("bot_name")
    public final String name;

    @SerializedName("need_desc")
    public final Boolean needDesc;

    @SerializedName("need_voice_type")
    public final Boolean needVoiceType;

    public BotEnrichParam() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public BotEnrichParam(String r100, String r101, Boolean r102, Boolean r103, String r104, List<EnrichBotData> r105, CreationIdInfo r106) {
        this.name = r100;
        this.botLang = r101;
        this.needDesc = r102;
        this.needVoiceType = r103;
        this.bgImgPrompt = r104;
        this.enrichBotContent = r105;
        this.creationIdInfo = r106;
    }

    public /* synthetic */ BotEnrichParam(String r100, String r101, Boolean r102, Boolean r110, String r111, List r112, CreationIdInfo r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        Boolean r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        Boolean r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        String r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        List r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        CreationIdInfo r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
