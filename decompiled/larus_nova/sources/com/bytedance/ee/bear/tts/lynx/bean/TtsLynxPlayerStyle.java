package com.bytedance.ee.bear.tts.lynx.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/tts/lynx/bean/TtsLynxPlayerStyle;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FULLSCREEN", "MODAL", "FLOAT_VIEW", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TtsLynxPlayerStyle extends Enum<TtsLynxPlayerStyle> {
    public static final a Companion = null;
    public static final TtsLynxPlayerStyle FLOAT_VIEW = null;
    public static final TtsLynxPlayerStyle FULLSCREEN = null;
    public static final TtsLynxPlayerStyle MODAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TtsLynxPlayerStyle[] f239627a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f239628b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<TtsLynxPlayerStyle> getEntries() {
        return f239628b;
    }

    static {
        TtsLynxPlayerStyle r100 = new TtsLynxPlayerStyle("FULLSCREEN", 0, 0);
        FULLSCREEN = r100;
        TtsLynxPlayerStyle r101 = new TtsLynxPlayerStyle("MODAL", 1, 1);
        MODAL = r101;
        TtsLynxPlayerStyle r102 = new TtsLynxPlayerStyle("FLOAT_VIEW", 2, 2);
        FLOAT_VIEW = r102;
        TtsLynxPlayerStyle[] r103 = {r100, r101, r102};
        f239627a = r103;
        f239628b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static TtsLynxPlayerStyle[] values() {
        return (TtsLynxPlayerStyle[]) f239627a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final TtsLynxPlayerStyle from(int r100) {
        Companion.getClass();
        TtsLynxPlayerStyle[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        TtsLynxPlayerStyle r104 = r101[r103];
        if (r104.getValue() != r100) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L15;
        r103 = r103 + 1;
        goto L3
    L15:
        return r104;
    L7:
        r105 = false;
        goto L8
    L11:
        return null;
    }

    public static TtsLynxPlayerStyle valueOf(String r100) {
        return (TtsLynxPlayerStyle) r27.a.a(TtsLynxPlayerStyle.class, r100);
    }

    public TtsLynxPlayerStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
