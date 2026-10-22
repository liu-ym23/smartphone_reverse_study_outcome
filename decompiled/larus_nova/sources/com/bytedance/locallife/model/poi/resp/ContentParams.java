package com.bytedance.locallife.model.poi.resp;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\u0018\u0000 +2\u00020\u0001:\u0001,Bo\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b)\u0010*R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0016\u0010\u0005\"\u0004\b\u0017\u0010\u0007R$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0005\"\u0004\b\u001a\u0010\u0007R*\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0005\"\u0004\b%\u0010\u0007R$\u0010&\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\n\u001a\u0004\b'\u0010\f\"\u0004\b(\u0010\u000e¨\u0006-"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/ContentParams;", "Ljava/io/Serializable;", "", "isFolded", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setFolded", "(Ljava/lang/Boolean;)V", "", "truncatedText", "Ljava/lang/String;", "getTruncatedText", "()Ljava/lang/String;", "setTruncatedText", "(Ljava/lang/String;)V", "", "truncatedHeight", "Ljava/lang/Integer;", "getTruncatedHeight", "()Ljava/lang/Integer;", "setTruncatedHeight", "(Ljava/lang/Integer;)V", "isLongComment", "setLongComment", "singleLineFold", "getSingleLineFold", "setSingleLineFold", "Lkotlin/Function0;", "", "onSpanClick", "Lkotlin/jvm/functions/Function0;", "getOnSpanClick", "()Lkotlin/jvm/functions/Function0;", "setOnSpanClick", "(Lkotlin/jvm/functions/Function0;)V", "merchantIsLongComment", "getMerchantIsLongComment", "setMerchantIsLongComment", "merchantTruncatedText", "getMerchantTruncatedText", "setMerchantTruncatedText", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function0;Ljava/lang/Boolean;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class ContentParams implements Serializable {
    public static final a Companion = null;
    public static final long serialVersionUID = 1;
    private Boolean isFolded;
    private Boolean isLongComment;
    private Boolean merchantIsLongComment;
    private String merchantTruncatedText;
    private Function0<Unit> onSpanClick;
    private Boolean singleLineFold;
    private Integer truncatedHeight;
    private String truncatedText;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ContentParams() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public ContentParams(Boolean r110) {
        this(r110, null, null, null, null, null, null, null, 254, null);
    }

    public ContentParams(Boolean r110, String r111) {
        this(r110, r111, null, null, null, null, null, null, 252, null);
    }

    public ContentParams(Boolean r110, String r111, Integer r112) {
        this(r110, r111, r112, null, null, null, null, null, 248, null);
    }

    public ContentParams(Boolean r110, String r111, Integer r112, Boolean r113) {
        this(r110, r111, r112, r113, null, null, null, null, 240, null);
    }

    public ContentParams(Boolean r110, String r111, Integer r112, Boolean r113, Boolean r114) {
        this(r110, r111, r112, r113, r114, null, null, null, 224, null);
    }

    public ContentParams(Boolean r110, String r111, Integer r112, Boolean r113, Boolean r114, Function0<Unit> r115) {
        this(r110, r111, r112, r113, r114, r115, null, null, 192, null);
    }

    public ContentParams(Boolean r110, String r111, Integer r112, Boolean r113, Boolean r114, Function0<Unit> r115, Boolean r116) {
        this(r110, r111, r112, r113, r114, r115, r116, null, 128, null);
    }

    public final Boolean getMerchantIsLongComment() {
        return this.merchantIsLongComment;
    }

    public final String getMerchantTruncatedText() {
        return this.merchantTruncatedText;
    }

    public final Function0<Unit> getOnSpanClick() {
        return this.onSpanClick;
    }

    public final Boolean getSingleLineFold() {
        return this.singleLineFold;
    }

    public final Integer getTruncatedHeight() {
        return this.truncatedHeight;
    }

    public final String getTruncatedText() {
        return this.truncatedText;
    }

    public final Boolean isFolded() {
        return this.isFolded;
    }

    public final Boolean isLongComment() {
        return this.isLongComment;
    }

    public final void setFolded(Boolean r100) {
        this.isFolded = r100;
    }

    public final void setLongComment(Boolean r100) {
        this.isLongComment = r100;
    }

    public final void setMerchantIsLongComment(Boolean r100) {
        this.merchantIsLongComment = r100;
    }

    public final void setMerchantTruncatedText(String r100) {
        this.merchantTruncatedText = r100;
    }

    public final void setOnSpanClick(Function0<Unit> r100) {
        this.onSpanClick = r100;
    }

    public final void setSingleLineFold(Boolean r100) {
        this.singleLineFold = r100;
    }

    public final void setTruncatedHeight(Integer r100) {
        this.truncatedHeight = r100;
    }

    public final void setTruncatedText(String r100) {
        this.truncatedText = r100;
    }

    public ContentParams(Boolean r100, String r101, Integer r102, Boolean r103, Boolean r104, Function0<Unit> r105, Boolean r106, String r107) {
        this.isFolded = r100;
        this.truncatedText = r101;
        this.truncatedHeight = r102;
        this.isLongComment = r103;
        this.singleLineFold = r104;
        this.onSpanClick = r105;
        this.merchantIsLongComment = r106;
        this.merchantTruncatedText = r107;
    }

    public /* synthetic */ ContentParams(Boolean r110, String r111, Integer r112, Boolean r113, Boolean r114, Function0 r115, Boolean r116, String r117, int r118, DefaultConstructorMarker r119) {
        String r100 = null;
        if ((r118 & 1) == 0) goto L5;
        Boolean r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        Integer r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Boolean r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        Boolean r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Function0 r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Boolean r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
