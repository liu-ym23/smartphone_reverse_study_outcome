package com.larus.office.base.plugins.toolbar;

import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\"\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001BK\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0003\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(¨\u0006)"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/InsertNewBlockData;", "", "iconId", "", "key", "", "shouldShowInputMethodAfterClick", "", "backgroundColorId", "iconColorId", "useSrcImg", "bgDrawableRes", "<init>", "(Ljava/lang/String;IILjava/lang/String;ZIIZI)V", "getIconId", "()I", "setIconId", "(I)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getShouldShowInputMethodAfterClick", "()Z", "setShouldShowInputMethodAfterClick", "(Z)V", "getBackgroundColorId", "setBackgroundColorId", "getIconColorId", "setIconColorId", "getUseSrcImg", "setUseSrcImg", "getBgDrawableRes", "setBgDrawableRes", "h1", "h2", "h3", "orderedList", "unorderedList", "checkbox", "blockQuote", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InsertNewBlockData extends Enum<InsertNewBlockData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InsertNewBlockData[] f360809a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f360810b = null;
    public static final InsertNewBlockData blockQuote = null;
    public static final InsertNewBlockData checkbox = null;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public static final InsertNewBlockData f360811h1 = null;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public static final InsertNewBlockData f360812h2 = null;

    /* JADX INFO: renamed from: h3, reason: collision with root package name */
    public static final InsertNewBlockData f360813h3 = null;
    public static final InsertNewBlockData orderedList = null;
    public static final InsertNewBlockData unorderedList = null;
    private int backgroundColorId;
    private int bgDrawableRes;
    private int iconColorId;
    private int iconId;
    private String key;
    private boolean shouldShowInputMethodAfterClick;
    private boolean useSrcImg;

    public InsertNewBlockData() {
        throw null;
    }

    public static EnumEntries<InsertNewBlockData> getEntries() {
        return f360810b;
    }

    static {
        InsertNewBlockData r110 = new InsertNewBlockData("h1", 0, R.drawable.larus_doc_icon_h1, "h1", true, 0, R.color.neutral_100, false, 0, 96, null);
        f360811h1 = r110;
        InsertNewBlockData r100 = new InsertNewBlockData("h2", 1, R.drawable.larus_doc_icon_h2, "h2", true, 0, R.color.neutral_100, false, 0, 96, null);
        f360812h2 = r100;
        InsertNewBlockData r101 = new InsertNewBlockData("h3", 2, R.drawable.larus_doc_icon_h3, "h3", true, 0, R.color.neutral_100, false, 0, 96, null);
        f360813h3 = r101;
        InsertNewBlockData r102 = new InsertNewBlockData("orderedList", 3, R.drawable.larus_doc_icon_ordered_list, "orderedList", true, 0, R.color.neutral_100, false, 0, 96, null);
        orderedList = r102;
        InsertNewBlockData r103 = new InsertNewBlockData("unorderedList", 4, R.drawable.larus_doc_icon_unordered_list, "unorderedList", true, 0, R.color.neutral_100, false, 0, 96, null);
        unorderedList = r103;
        InsertNewBlockData r104 = new InsertNewBlockData("checkbox", 5, R.drawable.larus_doc_icon_checkbox_mark, "checkbox", true, 0, R.color.neutral_100, false, 0, 96, null);
        checkbox = r104;
        InsertNewBlockData r105 = new InsertNewBlockData("blockQuote", 6, R.drawable.larus_doc_icon_text_blockquote, "blockQuote", true, 0, R.color.neutral_100, false, 0, 96, null);
        blockQuote = r105;
        InsertNewBlockData[] r106 = {r110, r100, r101, r102, r103, r104, r105};
        f360809a = r106;
        f360810b = EnumEntriesKt.enumEntries(r106);
    }

    public static InsertNewBlockData[] values() {
        return (InsertNewBlockData[]) f360809a.clone();
    }

    public final int getBackgroundColorId() {
        return this.backgroundColorId;
    }

    public final int getBgDrawableRes() {
        return this.bgDrawableRes;
    }

    public final int getIconColorId() {
        return this.iconColorId;
    }

    public final int getIconId() {
        return this.iconId;
    }

    public final String getKey() {
        return this.key;
    }

    public final boolean getShouldShowInputMethodAfterClick() {
        return this.shouldShowInputMethodAfterClick;
    }

    public final boolean getUseSrcImg() {
        return this.useSrcImg;
    }

    public static InsertNewBlockData valueOf(String r100) {
        return (InsertNewBlockData) r27.a.a(InsertNewBlockData.class, r100);
    }

    public final void setBackgroundColorId(int r100) {
        this.backgroundColorId = r100;
    }

    public final void setBgDrawableRes(int r100) {
        this.bgDrawableRes = r100;
    }

    public final void setIconColorId(int r100) {
        this.iconColorId = r100;
    }

    public final void setIconId(int r100) {
        this.iconId = r100;
    }

    public final void setKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.key = r100;
    }

    public final void setShouldShowInputMethodAfterClick(boolean r100) {
        this.shouldShowInputMethodAfterClick = r100;
    }

    public final void setUseSrcImg(boolean r100) {
        this.useSrcImg = r100;
    }

    public InsertNewBlockData(String r100, int r101, int r102, String r103, boolean r104, int r105, int r106, boolean r107, int r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 4) == 0) goto L6;
        r104 = true;
    L6:
        if ((r111 & 8) == 0) goto L9;
        r105 = 0;
    L9:
        if ((r111 & 16) == 0) goto L12;
        r106 = 0;
    L12:
        if ((r111 & 32) == 0) goto L15;
        r107 = false;
    L15:
        if ((r111 & 64) == 0) goto L17;
        r110 = 0;
    L17:
        super(r100, r101);
        this.iconId = r102;
        this.key = r103;
        this.shouldShowInputMethodAfterClick = r104;
        this.backgroundColorId = r105;
        this.iconColorId = r106;
        this.useSrcImg = r107;
        this.bgDrawableRes = r110;
    }
}
