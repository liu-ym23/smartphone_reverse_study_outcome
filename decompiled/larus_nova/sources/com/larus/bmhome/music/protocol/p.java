package com.larus.bmhome.music.protocol;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/music/protocol/TextConf;", "", "<init>", "()V", "headMoreTemplateText", "", "getHeadMoreTemplateText", "()Ljava/lang/String;", "tailMoreTemplateText", "getTailMoreTemplateText", "useTemplateText", "getUseTemplateText", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class p {

    @SerializedName("head_more_template_text")
    private final String headMoreTemplateText;

    @SerializedName("tail_more_template_text")
    private final String tailMoreTemplateText;

    @SerializedName("user_template_text")
    private final String useTemplateText;

    public p() {
        this.headMoreTemplateText = "";
        this.tailMoreTemplateText = "";
        this.useTemplateText = "";
    }
}
