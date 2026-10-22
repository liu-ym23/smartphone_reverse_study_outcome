package com.obric.assistant.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vda.d;
import vda.e;
import vda.f;
import w1a.b;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/data/ObricFloatChatPageData;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "pageState", "Lcom/obric/assistant/data/ObricFloatChatPageState;", "<init>", "(Lcom/obric/assistant/data/ObricFloatChatPageState;)V", "getPageState", "()Lcom/obric/assistant/data/ObricFloatChatPageState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricFloatChatPageData implements b {
    private static final String CHAT_WINDOW_SIMPLE_NAME = null;
    public static final a Companion = null;
    private static final String FULL_SCREEN_SIMPLE_NAME = null;
    private static final String HALF_WINDOW_SIMPLE_NAME = null;
    private static final String LANDSCAPE_FULL_WINDOW_SIMPLE_NAME = null;
    private static final com.obric.assistant.data.a UNKNOWN = null;
    private final ObricFloatChatPageState pageState;

    public static final class a {
        public a() {
        }

        public static boolean a(ObricFloatChatPageState r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            if ((r100 instanceof vda.a) == false) goto L5;
        L8:
            return true;
        L5:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        }

        public static boolean b(ObricFloatChatPageState r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            if ((r100 instanceof vda.b) == true) goto L5;
        L7:
            return false;
        L5:
            if (((vda.b) r100).f554260c == false) goto L7;
            return true;
        }

        public static boolean c(ObricFloatChatPageState r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            return r100 instanceof com.obric.assistant.data.a;
        }

        public static boolean d(ObricFloatChatPageState r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            if (a(r100) == false) goto L5;
        L10:
            return true;
        L5:
            if ((r100 instanceof d) == true) goto L10;
            if ((r100 instanceof f) == true) goto L10;
            return false;
        }

        public static boolean e(ObricFloatChatPageState r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            if ((r100 instanceof vda.b) == true) goto L5;
        L7:
            return false;
        L5:
            if (((vda.b) r100).f554259b == false) goto L7;
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ObricFloatChatPageData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ObricFloatChatPageData copy$default(ObricFloatChatPageData r100, ObricFloatChatPageState r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.pageState;
    L6:
        return r100.copy(r101);
    }

    public final ObricFloatChatPageState component1() {
        return this.pageState;
    }

    public final ObricFloatChatPageData copy(ObricFloatChatPageState r100) {
        Intrinsics.checkNotNullParameter(r100, "pageState");
        return new ObricFloatChatPageData(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricFloatChatPageData) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.pageState, ((ObricFloatChatPageData) r100).pageState) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.pageState.hashCode();
    }

    public String toString() {
        return "ObricFloatChatPageData(pageState=" + this.pageState + ')';
    }

    static {
        Companion = new a();
        UNKNOWN = com.obric.assistant.data.a.f389028a;
        CHAT_WINDOW_SIMPLE_NAME = vda.a.class.getSimpleName();
        HALF_WINDOW_SIMPLE_NAME = e.class.getSimpleName();
        FULL_SCREEN_SIMPLE_NAME = d.class.getSimpleName();
        LANDSCAPE_FULL_WINDOW_SIMPLE_NAME = f.class.getSimpleName();
    }

    public static final /* synthetic */ String access$getCHAT_WINDOW_SIMPLE_NAME$cp() {
        return CHAT_WINDOW_SIMPLE_NAME;
    }

    public static final /* synthetic */ String access$getFULL_SCREEN_SIMPLE_NAME$cp() {
        return FULL_SCREEN_SIMPLE_NAME;
    }

    public static final /* synthetic */ String access$getHALF_WINDOW_SIMPLE_NAME$cp() {
        return HALF_WINDOW_SIMPLE_NAME;
    }

    public static final /* synthetic */ String access$getLANDSCAPE_FULL_WINDOW_SIMPLE_NAME$cp() {
        return LANDSCAPE_FULL_WINDOW_SIMPLE_NAME;
    }

    public static final /* synthetic */ com.obric.assistant.data.a access$getUNKNOWN$cp() {
        return UNKNOWN;
    }

    public final ObricFloatChatPageState getPageState() {
        return this.pageState;
    }

    public ObricFloatChatPageData(ObricFloatChatPageState r100) {
        Intrinsics.checkNotNullParameter(r100, "pageState");
        this.pageState = r100;
    }

    public /* synthetic */ ObricFloatChatPageData(ObricFloatChatPageState r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = UNKNOWN;
    L5:
        this(r100);
    }
}
