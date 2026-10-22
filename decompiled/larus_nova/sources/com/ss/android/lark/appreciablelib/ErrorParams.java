package com.ss.android.lark.appreciablelib;

import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\bM\b\u0086\b\u0018\u00002\u00020\u0001B]\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010B¯\u0001\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f\u0012\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f\u0012\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f¢\u0006\u0002\u0010\u0019BÁ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0014\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f\u0012\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f\u0012\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0014¢\u0006\u0002\u0010\u001cJ\t\u0010N\u001a\u00020\u0003HÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u0010@J\t\u0010P\u001a\u00020\u0014HÆ\u0003J\u0017\u0010Q\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fHÆ\u0003J\u0017\u0010R\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fHÆ\u0003J\u0017\u0010S\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fHÆ\u0003J\t\u0010T\u001a\u00020\u0014HÆ\u0003J\t\u0010U\u001a\u00020\u0005HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u0010W\u001a\u00020\u0007HÆ\u0003J\t\u0010X\u001a\u00020\tHÆ\u0003J\t\u0010Y\u001a\u00020\u0014HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u000bHÆ\u0003JØ\u0001\u0010]\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u00142\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u0014HÆ\u0001¢\u0006\u0002\u0010^J\u0013\u0010_\u001a\u00020\u00162\b\u0010`\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010a\u001a\u00020\u0014HÖ\u0001J\t\u0010b\u001a\u00020\u000bHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010\u001b\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\"\"\u0004\b.\u0010$R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R(\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00108\"\u0004\b<\u0010:R(\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00108\"\u0004\b>\u0010:R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u0010C\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010*\"\u0004\bE\u0010,R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010*\"\u0004\bK\u0010,R\u001a\u0010\u001a\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\"\"\u0004\bM\u0010$¨\u0006c"}, d2 = {"Lcom/ss/android/lark/appreciablelib/ErrorParams;", "", "biz", "Lcom/ss/android/lark/appreciablelib/Biz;", "scene", "Lcom/ss/android/lark/appreciablelib/Scene;", "errorType", "Lcom/ss/android/lark/appreciablelib/ErrorType;", "errorLevel", "Lcom/ss/android/lark/appreciablelib/ErrorLevel;", "userAction", "", "page", "errorMessage", "extra", "", "(Lcom/ss/android/lark/appreciablelib/Biz;Lcom/ss/android/lark/appreciablelib/Scene;Lcom/ss/android/lark/appreciablelib/ErrorType;Lcom/ss/android/lark/appreciablelib/ErrorLevel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "event", "Lcom/ss/android/lark/appreciablelib/Event;", "errorCode", "", "needNet", "", "extraMetric", "extraCategory", "(Lcom/ss/android/lark/appreciablelib/Biz;Lcom/ss/android/lark/appreciablelib/Scene;Lcom/ss/android/lark/appreciablelib/Event;Lcom/ss/android/lark/appreciablelib/ErrorType;Lcom/ss/android/lark/appreciablelib/ErrorLevel;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "version", "errorStatus", "(Lcom/ss/android/lark/appreciablelib/Biz;Lcom/ss/android/lark/appreciablelib/Scene;Lcom/ss/android/lark/appreciablelib/Event;Lcom/ss/android/lark/appreciablelib/ErrorType;Lcom/ss/android/lark/appreciablelib/ErrorLevel;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;ILjava/util/Map;Ljava/util/Map;Ljava/util/Map;I)V", "getBiz", "()Lcom/ss/android/lark/appreciablelib/Biz;", "setBiz", "(Lcom/ss/android/lark/appreciablelib/Biz;)V", "getErrorCode", "()I", "setErrorCode", "(I)V", "getErrorLevel", "()Lcom/ss/android/lark/appreciablelib/ErrorLevel;", "setErrorLevel", "(Lcom/ss/android/lark/appreciablelib/ErrorLevel;)V", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "getErrorStatus", "setErrorStatus", "getErrorType", "()Lcom/ss/android/lark/appreciablelib/ErrorType;", "setErrorType", "(Lcom/ss/android/lark/appreciablelib/ErrorType;)V", "getEvent", "()Lcom/ss/android/lark/appreciablelib/Event;", "setEvent", "(Lcom/ss/android/lark/appreciablelib/Event;)V", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "getExtraCategory", "setExtraCategory", "getExtraMetric", "setExtraMetric", "getNeedNet", "()Ljava/lang/Boolean;", "setNeedNet", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getPage", "setPage", "getScene", "()Lcom/ss/android/lark/appreciablelib/Scene;", "setScene", "(Lcom/ss/android/lark/appreciablelib/Scene;)V", "getUserAction", "setUserAction", "getVersion", "setVersion", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/ss/android/lark/appreciablelib/Biz;Lcom/ss/android/lark/appreciablelib/Scene;Lcom/ss/android/lark/appreciablelib/Event;Lcom/ss/android/lark/appreciablelib/ErrorType;Lcom/ss/android/lark/appreciablelib/ErrorLevel;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;ILjava/util/Map;Ljava/util/Map;Ljava/util/Map;I)Lcom/ss/android/lark/appreciablelib/ErrorParams;", "equals", "other", "hashCode", "toString", "appreciablelib_release"}, k = 1, mv = {1, 1, 15})
public final class ErrorParams {
    private Biz biz;
    private int errorCode;
    private ErrorLevel errorLevel;
    private String errorMessage;
    private int errorStatus;
    private ErrorType errorType;
    private Event event;
    private Map<String, ? extends Object> extra;
    private Map<String, ? extends Object> extraCategory;
    private Map<String, ? extends Object> extraMetric;
    private Boolean needNet;
    private String page;
    private Scene scene;
    private String userAction;
    private int version;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ErrorParams copy$default(ErrorParams r110, Biz r111, Scene r112, Event r113, ErrorType r210, ErrorLevel r211, int r212, String r213, String r214, String r215, Boolean r216, int r217, Map r218, Map r219, Map r310, int r311, int r312, Object r313) {
        if ((r312 & 1) == 0) goto L5;
        Biz r100 = r110.biz;
    L7:
        if ((r312 & 2) == 0) goto L9;
        Scene r101 = r110.scene;
    L11:
        if ((r312 & 4) == 0) goto L13;
        Event r102 = r110.event;
    L15:
        if ((r312 & 8) == 0) goto L17;
        ErrorType r103 = r110.errorType;
    L19:
        if ((r312 & 16) == 0) goto L21;
        ErrorLevel r104 = r110.errorLevel;
    L23:
        if ((r312 & 32) == 0) goto L25;
        int r105 = r110.errorCode;
    L27:
        if ((r312 & 64) == 0) goto L29;
        String r106 = r110.userAction;
    L31:
        if ((r312 & 128) == 0) goto L33;
        String r107 = r110.page;
    L35:
        if ((r312 & 256) == 0) goto L37;
        String r114 = r110.errorMessage;
    L39:
        if ((r312 & 512) == 0) goto L41;
        Boolean r115 = r110.needNet;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        int r116 = r110.version;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        Map r117 = r110.extra;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        Map r118 = r110.extraMetric;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        Map r119 = r110.extraCategory;
    L59:
        if ((r312 & 16384) == 0) goto L61;
        int r108 = r110.errorStatus;
    L63:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r114, r115, r116, r117, r118, r119, r108);
    L61:
        r108 = r311;
        goto L63
    L57:
        r119 = r310;
        goto L59
    L53:
        r118 = r219;
        goto L55
    L49:
        r117 = r218;
        goto L51
    L45:
        r116 = r217;
        goto L47
    L41:
        r115 = r216;
        goto L43
    L37:
        r114 = r215;
        goto L39
    L33:
        r107 = r214;
        goto L35
    L29:
        r106 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final Biz component1() {
        return this.biz;
    }

    public final Boolean component10() {
        return this.needNet;
    }

    public final int component11() {
        return this.version;
    }

    public final Map<String, Object> component12() {
        return this.extra;
    }

    public final Map<String, Object> component13() {
        return this.extraMetric;
    }

    public final Map<String, Object> component14() {
        return this.extraCategory;
    }

    public final int component15() {
        return this.errorStatus;
    }

    public final Scene component2() {
        return this.scene;
    }

    public final Event component3() {
        return this.event;
    }

    public final ErrorType component4() {
        return this.errorType;
    }

    public final ErrorLevel component5() {
        return this.errorLevel;
    }

    public final int component6() {
        return this.errorCode;
    }

    public final String component7() {
        return this.userAction;
    }

    public final String component8() {
        return this.page;
    }

    public final String component9() {
        return this.errorMessage;
    }

    public final ErrorParams copy(Biz r110, Scene r111, Event r210, ErrorType r211, ErrorLevel r212, int r213, String r214, String r215, String r216, Boolean r217, int r218, Map<String, ? extends Object> r219, Map<String, ? extends Object> r310, Map<String, ? extends Object> r311, int r312) {
        return new ErrorParams(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
    L47:
        return true;
    L5:
        if ((r100 instanceof ErrorParams) == false) goto L46;
        ErrorParams r101 = (ErrorParams) r100;
        if (Intrinsics.areEqual(this.biz, r101.biz) == false) goto L46;
        if (Intrinsics.areEqual(this.scene, r101.scene) == false) goto L46;
        if (Intrinsics.areEqual(this.event, r101.event) == false) goto L46;
        if (Intrinsics.areEqual(this.errorType, r101.errorType) == false) goto L46;
        if (Intrinsics.areEqual(this.errorLevel, r101.errorLevel) == false) goto L46;
        if (this.errorCode != r101.errorCode) goto L19;
        boolean r102 = true;
    L20:
        if (r102 == false) goto L46;
        if (Intrinsics.areEqual(this.userAction, r101.userAction) == false) goto L46;
        if (Intrinsics.areEqual(this.page, r101.page) == false) goto L46;
        if (Intrinsics.areEqual(this.errorMessage, r101.errorMessage) == false) goto L46;
        if (Intrinsics.areEqual(this.needNet, r101.needNet) == false) goto L46;
        if (this.version != r101.version) goto L32;
        boolean r103 = true;
    L33:
        if (r103 == false) goto L46;
        if (Intrinsics.areEqual(this.extra, r101.extra) == false) goto L46;
        if (Intrinsics.areEqual(this.extraMetric, r101.extraMetric) == false) goto L46;
        if (Intrinsics.areEqual(this.extraCategory, r101.extraCategory) == false) goto L46;
        if (this.errorStatus != r101.errorStatus) goto L43;
        boolean r104 = true;
    L44:
        if (r104 == false) goto L46;
    L43:
        r104 = false;
        goto L44
    L32:
        r103 = false;
        goto L33
    L19:
        r102 = false;
    L46:
        return false;
    }

    public int hashCode() {
        Biz r100 = this.biz;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Scene r104 = this.scene;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Event r107 = this.event;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ErrorType r110 = this.errorType;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        ErrorLevel r113 = this.errorLevel;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (((r112 + r114) * 31) + this.errorCode) * 31;
        String r116 = this.userAction;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.page;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.errorMessage;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.needNet;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (((r124 + r126) * 31) + this.version) * 31;
        Map<String, ? extends Object> r128 = this.extra;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Map<String, ? extends Object> r131 = this.extraMetric;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        Map<String, ? extends Object> r134 = this.extraCategory;
        if (r134 == null) goto L50;
        r101 = r134.hashCode();
    L50:
        return ((r133 + r101) * 31) + this.errorStatus;
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ErrorParams(biz=" + this.biz + ", scene=" + this.scene + ", event=" + this.event + ", errorType=" + this.errorType + ", errorLevel=" + this.errorLevel + ", errorCode=" + this.errorCode + ", userAction=" + this.userAction + ", page=" + this.page + ", errorMessage=" + this.errorMessage + ", needNet=" + this.needNet + ", version=" + this.version + ", extra=" + this.extra + ", extraMetric=" + this.extraMetric + ", extraCategory=" + this.extraCategory + ", errorStatus=" + this.errorStatus + ")";
    }

    public final Biz getBiz() {
        return this.biz;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final ErrorLevel getErrorLevel() {
        return this.errorLevel;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final int getErrorStatus() {
        return this.errorStatus;
    }

    public final ErrorType getErrorType() {
        return this.errorType;
    }

    public final Event getEvent() {
        return this.event;
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final Map<String, Object> getExtraCategory() {
        return this.extraCategory;
    }

    public final Map<String, Object> getExtraMetric() {
        return this.extraMetric;
    }

    public final Boolean getNeedNet() {
        return this.needNet;
    }

    public final String getPage() {
        return this.page;
    }

    public final Scene getScene() {
        return this.scene;
    }

    public final String getUserAction() {
        return this.userAction;
    }

    public final int getVersion() {
        return this.version;
    }

    public final void setBiz(Biz r100) {
        this.biz = r100;
    }

    public final void setErrorCode(int r100) {
        this.errorCode = r100;
    }

    public final void setErrorLevel(ErrorLevel r100) {
        this.errorLevel = r100;
    }

    public final void setErrorMessage(String r100) {
        this.errorMessage = r100;
    }

    public final void setErrorStatus(int r100) {
        this.errorStatus = r100;
    }

    public final void setErrorType(ErrorType r100) {
        this.errorType = r100;
    }

    public final void setEvent(Event r100) {
        this.event = r100;
    }

    public final void setExtra(Map<String, ? extends Object> r100) {
        this.extra = r100;
    }

    public final void setExtraCategory(Map<String, ? extends Object> r100) {
        this.extraCategory = r100;
    }

    public final void setExtraMetric(Map<String, ? extends Object> r100) {
        this.extraMetric = r100;
    }

    public final void setNeedNet(Boolean r100) {
        this.needNet = r100;
    }

    public final void setPage(String r100) {
        this.page = r100;
    }

    public final void setScene(Scene r100) {
        this.scene = r100;
    }

    public final void setUserAction(String r100) {
        this.userAction = r100;
    }

    public final void setVersion(int r100) {
        this.version = r100;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "格式更新 https://bytedance.feishu.cn/docs/doccnxWkTEi4U8Yx6dZdSGFdKkd", replaceWith = @ReplaceWith(expression = "\"replace with new ErrorParams\"", imports = {}))
    public ErrorParams(Biz r110, Scene r111, ErrorType r112, ErrorLevel r113, String r114, String r210, String r211, Map<String, ? extends Object> r212) {
        this(r110, r111, null, r112, r113, -1, r114, r210, r211, Boolean.TRUE, r212, null, null);
    }

    public /* synthetic */ ErrorParams(Biz r110, Scene r111, ErrorType r112, ErrorLevel r113, String r114, String r115, String r116, Map r117, int r118, DefaultConstructorMarker r210) {
        if ((r118 & 128) == 0) goto L5;
        Map r100 = null;
    L6:
        this(r110, r111, r112, r113, r114, r115, r116, r100);
        return;
    L5:
        r100 = r117;
        goto L6
    }

    public ErrorParams(Biz r110, Scene r210, Event r211, ErrorType r212, ErrorLevel r213, int r214, String r215, String r216, String r217, Boolean r218, Map<String, ? extends Object> r219, Map<String, ? extends Object> r310, Map<String, ? extends Object> r311) {
        this(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, 1, r219, r310, r311, 0, 16384, null);
    }

    public /* synthetic */ ErrorParams(Biz r110, Scene r111, Event r210, ErrorType r211, ErrorLevel r212, int r213, String r214, String r215, String r216, Boolean r217, Map r218, Map r219, Map r310, int r311, DefaultConstructorMarker r312) {
        if ((r311 & 64) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r311 & 128) == 0) goto L9;
        String r113 = null;
    L11:
        if ((r311 & 256) == 0) goto L13;
        String r114 = null;
    L15:
        if ((r311 & 1024) == 0) goto L17;
        Map r115 = null;
    L19:
        if ((r311 & 2048) == 0) goto L21;
        Map r116 = null;
    L23:
        if ((r311 & 4096) == 0) goto L25;
        Map r117 = null;
    L26:
        this(r110, r111, r210, r211, r212, r213, r112, r113, r114, r217, r115, r116, r117);
        return;
    L25:
        r117 = r310;
        goto L26
    L21:
        r116 = r219;
        goto L23
    L17:
        r115 = r218;
        goto L19
    L13:
        r114 = r216;
        goto L15
    L9:
        r113 = r215;
        goto L11
    L5:
        r112 = r214;
        goto L7
    }

    public ErrorParams(Biz r100, Scene r101, Event r102, ErrorType r103, ErrorLevel r104, int r105, String r106, String r107, String r108, Boolean r110, int r111, Map<String, ? extends Object> r112, Map<String, ? extends Object> r113, Map<String, ? extends Object> r114, int r115) {
        this.biz = r100;
        this.scene = r101;
        this.event = r102;
        this.errorType = r103;
        this.errorLevel = r104;
        this.errorCode = r105;
        this.userAction = r106;
        this.page = r107;
        this.errorMessage = r108;
        this.needNet = r110;
        this.version = r111;
        this.extra = r112;
        this.extraMetric = r113;
        this.extraCategory = r114;
        this.errorStatus = r115;
    }

    public /* synthetic */ ErrorParams(Biz r210, Scene r211, Event r212, ErrorType r213, ErrorLevel r214, int r215, String r216, String r217, String r218, Boolean r219, int r310, Map r311, Map r312, Map r313, int r314, int r315, DefaultConstructorMarker r316) {
        if ((r315 & 64) == 0) goto L5;
        String r110 = null;
    L7:
        if ((r315 & 128) == 0) goto L9;
        String r111 = null;
    L11:
        if ((r315 & 256) == 0) goto L13;
        String r112 = null;
    L15:
        if ((r315 & 1024) == 0) goto L17;
        int r113 = 1;
    L19:
        if ((r315 & 2048) == 0) goto L21;
        Map r114 = null;
    L23:
        if ((r315 & 4096) == 0) goto L25;
        Map r115 = null;
    L27:
        if ((r315 & 8192) == 0) goto L29;
        Map r116 = null;
    L31:
        if ((r315 & 16384) == 0) goto L33;
        int r117 = 0;
    L34:
        this(r210, r211, r212, r213, r214, r215, r110, r111, r112, r219, r113, r114, r115, r116, r117);
        return;
    L33:
        r117 = r314;
        goto L34
    L29:
        r116 = r313;
        goto L31
    L25:
        r115 = r312;
        goto L27
    L21:
        r114 = r311;
        goto L23
    L17:
        r113 = r310;
        goto L19
    L13:
        r112 = r218;
        goto L15
    L9:
        r111 = r217;
        goto L11
    L5:
        r110 = r216;
        goto L7
    }
}
