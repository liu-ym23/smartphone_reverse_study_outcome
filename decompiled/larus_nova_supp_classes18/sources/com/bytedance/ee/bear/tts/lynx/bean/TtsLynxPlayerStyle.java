package com.bytedance.ee.bear.tts.lynx.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/tts/lynx/bean/TtsLynxPlayerStyle;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FULLSCREEN", "MODAL", "FLOAT_VIEW", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TtsLynxPlayerStyle extends Enum<TtsLynxPlayerStyle> {
    public static final a Companion = null;
    public static final TtsLynxPlayerStyle FLOAT_VIEW = null;
    public static final TtsLynxPlayerStyle FULLSCREEN = null;
    public static final TtsLynxPlayerStyle MODAL = null;
    public static final /* synthetic */ TtsLynxPlayerStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<TtsLynxPlayerStyle> getEntries() {
        return b;
    }

    static {
        TtsLynxPlayerStyle r0 = new TtsLynxPlayerStyle("FULLSCREEN", 0, 0);
        FULLSCREEN = r0;
        TtsLynxPlayerStyle r1 = new TtsLynxPlayerStyle("MODAL", 1, 1);
        MODAL = r1;
        TtsLynxPlayerStyle r3 = new TtsLynxPlayerStyle("FLOAT_VIEW", 2, 2);
        FLOAT_VIEW = r3;
        TtsLynxPlayerStyle[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static TtsLynxPlayerStyle[] values() {
        return (TtsLynxPlayerStyle[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final TtsLynxPlayerStyle from(int r6) {
        Companion.getClass();
        TtsLynxPlayerStyle[] r0 = values();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        TtsLynxPlayerStyle r4 = r0[r3];
        if (r4.getValue() != r6) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == true) goto L15;
        r3 = r3 + 1;
        goto L3
    L15:
        return r4;
    L7:
        r5 = false;
        goto L8
    L11:
        return null;
    }

    public static TtsLynxPlayerStyle valueOf(String r1) {
        return (TtsLynxPlayerStyle) r27.a.a(TtsLynxPlayerStyle.class, r1);
    }

    public TtsLynxPlayerStyle(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
