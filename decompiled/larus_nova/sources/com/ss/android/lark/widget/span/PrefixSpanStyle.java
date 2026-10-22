package com.ss.android.lark.widget.span;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/widget/span/PrefixSpanStyle;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", EffectConstants.NORMAL, "FULL_SCREEN", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PrefixSpanStyle extends Enum<PrefixSpanStyle> {
    public static final PrefixSpanStyle FULL_SCREEN = null;
    public static final PrefixSpanStyle NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PrefixSpanStyle[] f448598a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f448599b = null;
    private final int value;

    public static EnumEntries<PrefixSpanStyle> getEntries() {
        return f448599b;
    }

    static {
        PrefixSpanStyle r100 = new PrefixSpanStyle(EffectConstants.NORMAL, 0, 0);
        NORMAL = r100;
        PrefixSpanStyle r101 = new PrefixSpanStyle("FULL_SCREEN", 1, 1);
        FULL_SCREEN = r101;
        PrefixSpanStyle[] r102 = {r100, r101};
        f448598a = r102;
        f448599b = EnumEntriesKt.enumEntries(r102);
    }

    public static PrefixSpanStyle[] values() {
        return (PrefixSpanStyle[]) f448598a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static PrefixSpanStyle valueOf(String r100) {
        return (PrefixSpanStyle) r27.a.a(PrefixSpanStyle.class, r100);
    }

    public PrefixSpanStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
