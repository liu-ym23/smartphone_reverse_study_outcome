package com.larus.bot.impl.bean;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/larus/bot/impl/bean/EnrichBotData;", "Ljava/io/Serializable;", "contentSource", "", "operateType", "contentType", "content", "", "useInternet", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnrichBotData implements Serializable {

    @SerializedName("content")
    public List<String> content;

    @SerializedName(a.KEY_CONTENT_SOURCE)
    public String contentSource;

    @SerializedName("content_type")
    public String contentType;

    @SerializedName("operate_type")
    public String operateType;

    @SerializedName("use_internet")
    public Boolean useInternet;

    public EnrichBotData() {
        this(null, null, null, null, null, 31, null);
    }

    public EnrichBotData(String r100, String r101, String r102, List<String> r103, Boolean r104) {
        this.contentSource = r100;
        this.operateType = r101;
        this.contentType = r102;
        this.content = r103;
        this.useInternet = r104;
    }

    public /* synthetic */ EnrichBotData(String r100, String r101, String r102, List r103, Boolean r104, int r105, DefaultConstructorMarker r110) {
        String r106 = "";
        if ((r105 & 1) == 0) goto L5;
        String r111 = "";
    L7:
        if ((r105 & 2) == 0) goto L9;
        String r107 = "";
    L11:
        if ((r105 & 4) != 0) goto L15;
        r106 = r102;
    L15:
        if ((r105 & 8) == 0) goto L17;
        r103 = CollectionsKt.emptyList();
    L17:
        List r108 = r103;
        if ((r105 & 16) == 0) goto L20;
        r104 = Boolean.FALSE;
    L20:
        String r109 = r111;
        String r112 = r107;
        String r113 = r106;
        this(r109, r112, r113, r108, r104);
        return;
    L9:
        r107 = r101;
        goto L11
    L5:
        r111 = r100;
        goto L7
    }
}
