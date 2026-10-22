package com.bytedance.android.shopping.commentv3.data;

import com.bytedance.android.shopping.commentv3.utils.InteractionPerfMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0001\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/FetchFrom;", "", "", "getPerfMobKey", "", "needUpdateTagVisibility", "needScrollToFirst", "isLatest", "", "monitorInteractionStart", "needFetchTab", "", "refreshStartTime", "J", "", "from", "I", "getFrom", "()I", "setFrom", "(I)V", "Companion", "a", "SKU_SWITCH", "TAB_CLICK", "LOAD_MORE", "RE_SORT", "INIT", "FETCH_ALL", "REMOVE_NPS", "LIKE_CLICKED", "FUSION", "OTHER", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FetchFrom extends Enum<FetchFrom> {
    public static final a Companion = null;
    public static final FetchFrom FETCH_ALL = null;
    public static final FetchFrom FUSION = null;
    public static final FetchFrom INIT = null;
    public static final FetchFrom LIKE_CLICKED = null;
    public static final FetchFrom LOAD_MORE = null;
    public static final FetchFrom OTHER = null;
    public static final FetchFrom REMOVE_NPS = null;
    public static final FetchFrom RE_SORT = null;
    public static final FetchFrom SKU_SWITCH = null;
    public static final FetchFrom TAB_CLICK = null;
    public static final /* synthetic */ FetchFrom[] a = null;
    private int from;
    private final long refreshStartTime;

    public static final class a {
        public a() {
        }

        public static FetchFrom a(int r2) {
            FetchFrom r0 = FetchFrom.SKU_SWITCH;
            if (r2 == r0.getFrom()) goto L28;
            FetchFrom r1 = FetchFrom.TAB_CLICK;
            if (r2 == r1.getFrom()) goto L29;
            FetchFrom r3 = FetchFrom.LOAD_MORE;
            if (r2 == r3.getFrom()) goto L30;
            FetchFrom r4 = FetchFrom.RE_SORT;
            if (r2 == r4.getFrom()) goto L31;
            FetchFrom r5 = FetchFrom.INIT;
            if (r2 == r5.getFrom()) goto L32;
            FetchFrom r6 = FetchFrom.FETCH_ALL;
            if (r2 == r6.getFrom()) goto L33;
            FetchFrom r7 = FetchFrom.REMOVE_NPS;
            if (r2 == r7.getFrom()) goto L34;
            FetchFrom r8 = FetchFrom.FUSION;
            if (r2 != r8.getFrom()) goto L27;
            return r8;
        L27:
            return FetchFrom.OTHER;
        L34:
            return r7;
        L33:
            return r6;
        L32:
            return r5;
        L31:
            return r4;
        L30:
            return r3;
        L29:
            return r1;
        L28:
            return r0;
        }
    }

    public static FetchFrom valueOf(String r1) {
        return (FetchFrom) r27.a.a(FetchFrom.class, r1);
    }

    public static FetchFrom[] values() {
        return (FetchFrom[]) a.clone();
    }

    static {
        FetchFrom r1 = new FetchFrom("SKU_SWITCH", 0, 1);
        SKU_SWITCH = r1;
        FetchFrom r2 = new FetchFrom("TAB_CLICK", 1, 2);
        TAB_CLICK = r2;
        FetchFrom r3 = new FetchFrom("LOAD_MORE", 2, 3);
        LOAD_MORE = r3;
        FetchFrom r4 = new FetchFrom("RE_SORT", 3, 4);
        RE_SORT = r4;
        FetchFrom r5 = new FetchFrom("INIT", 4, 5);
        INIT = r5;
        FetchFrom r6 = new FetchFrom("FETCH_ALL", 5, 6);
        FETCH_ALL = r6;
        FetchFrom r7 = new FetchFrom("REMOVE_NPS", 6, 7);
        REMOVE_NPS = r7;
        FetchFrom r8 = new FetchFrom("LIKE_CLICKED", 7, 8);
        LIKE_CLICKED = r8;
        FetchFrom r9 = new FetchFrom("FUSION", 8, 9);
        FUSION = r9;
        FetchFrom r10 = new FetchFrom("OTHER", 9, 20);
        OTHER = r10;
        a = new FetchFrom[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
        Companion = new a();
    }

    public final String getPerfMobKey() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.from);
        r0.append('-');
        r0.append(this.refreshStartTime);
        return r0.toString();
    }

    public final boolean needFetchTab() {
        int r0 = this.from;
        if (r0 != SKU_SWITCH.from) goto L5;
    L14:
        return true;
    L5:
        if (r0 == INIT.from) goto L14;
        if (r0 == FETCH_ALL.from) goto L14;
        if (r0 == OTHER.from) goto L14;
        if (r0 == FUSION.from) goto L14;
        return false;
    }

    public final boolean needScrollToFirst() {
        int r0 = this.from;
        if (r0 != LOAD_MORE.from) goto L5;
    L8:
        return false;
    L5:
        if (r0 == REMOVE_NPS.from) goto L8;
        return true;
    }

    public final boolean needUpdateTagVisibility() {
        int r0 = this.from;
        if (r0 != LOAD_MORE.from) goto L5;
    L8:
        return false;
    L5:
        if (r0 == REMOVE_NPS.from) goto L8;
        return true;
    }

    public final int getFrom() {
        return this.from;
    }

    public final void monitorInteractionStart(boolean r6) {
        InteractionTypeEnum.Companion.getClass();
        Intrinsics.checkNotNullParameter(this, "refreshFrom");
        int r0 = getFrom();
        if (r0 != TAB_CLICK.getFrom()) goto L6;
        String r7 = InteractionTypeEnum.CLICK_IMPRESSION.getType();
    L18:
        InteractionPerfMonitor.a r1 = InteractionPerfMonitor.j;
        String r2 = getPerfMobKey();
        r1.getClass();
        InteractionPerfMonitor r3 = InteractionPerfMonitor.a.a(r2);
        Intrinsics.checkNotNullParameter(r7, "interactionType");
        Intrinsics.checkNotNullParameter("", "interactionContent");
        r3.c = System.currentTimeMillis();
        r3.a = r7;
        r3.b = "";
        return;
    L6:
        if (r0 != SKU_SWITCH.getFrom()) goto L9;
        r7 = InteractionTypeEnum.CLICK_SKU.getType();
        goto L18
    L9:
        if (r0 != RE_SORT.getFrom()) goto L15;
        if (r6 == false) goto L12;
        InteractionTypeEnum r8 = InteractionTypeEnum.CLICK_LATEST_BTN;
    L13:
        r7 = r8.getType();
        goto L18
    L12:
        r8 = InteractionTypeEnum.CLICK_COMPLEX_BTN;
        goto L13
    L15:
        if (r0 != LOAD_MORE.getFrom()) goto L17;
        r7 = InteractionTypeEnum.LOAD_MORE.getType();
        goto L18
    L17:
        r7 = "";
        goto L18
    }

    public final void setFrom(int r1) {
        this.from = r1;
    }

    public FetchFrom(String r1, int r2, int r3) {
        super(r1, r2);
        this.from = r3;
        this.refreshStartTime = System.currentTimeMillis();
    }

    public static /* synthetic */ void monitorInteractionStart$default(FetchFrom r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.monitorInteractionStart(r1);
    }
}
