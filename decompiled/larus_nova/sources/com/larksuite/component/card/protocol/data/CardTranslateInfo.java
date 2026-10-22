package com.larksuite.component.card.protocol.data;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\b\"\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/larksuite/component/card/protocol/data/CardTranslateInfo;", "Ljava/io/Serializable;", "translateLanguage", "", "translateShowType", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTranslateLanguage", "()Ljava/lang/String;", "getTranslateShowType", "setTranslateShowType", "(Ljava/lang/String;)V", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardTranslateInfo implements Serializable {
    public static final a Companion = null;
    public static final String RENDER_TYPE_ORIGIN = "renderOriginal";
    public static final String RENDER_TYPE_ORIGIN_WITH_TRANSLATION = "renderOriginalWithTranslation";
    public static final String RENDER_TYPE_TRANSLATION = "renderTranslation";
    private final String translateLanguage;
    private String translateShowType;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final String getTranslateLanguage() {
        return this.translateLanguage;
    }

    public final String getTranslateShowType() {
        return this.translateShowType;
    }

    public final void setTranslateShowType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.translateShowType = r100;
    }

    public CardTranslateInfo(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "translateLanguage");
        Intrinsics.checkNotNullParameter(r101, "translateShowType");
        this.translateLanguage = r100;
        this.translateShowType = r101;
    }
}
