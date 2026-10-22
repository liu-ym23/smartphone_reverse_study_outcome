package com.bytedance.ee.bear.tts.media;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/tts/media/TtsMediaRemoteAction;", "", "actionName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getActionName", "()Ljava/lang/String;", "FOREGROUND", "TERMINAL", "RESUME", "PAUSE", "PREVIOUS", "NEXT", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TtsMediaRemoteAction extends Enum<TtsMediaRemoteAction> {
    public static final a Companion = null;
    public static final TtsMediaRemoteAction FOREGROUND = null;
    public static final TtsMediaRemoteAction NEXT = null;
    public static final TtsMediaRemoteAction PAUSE = null;
    public static final TtsMediaRemoteAction PREVIOUS = null;
    public static final TtsMediaRemoteAction RESUME = null;
    public static final TtsMediaRemoteAction TERMINAL = null;
    public static final /* synthetic */ TtsMediaRemoteAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String actionName;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static TtsMediaRemoteAction a(String r5) {
            Intrinsics.checkNotNullParameter(r5, "actionName");
            TtsMediaRemoteAction[] r0 = TtsMediaRemoteAction.values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            TtsMediaRemoteAction r3 = r0[r2];
            if (Intrinsics.areEqual(r3.getActionName(), r5) == true) goto L12;
            r2 = r2 + 1;
            goto L3
        L12:
            return r3;
        L8:
            return null;
        }
    }

    @JvmStatic
    public static final TtsMediaRemoteAction from(String r1) {
        Companion.getClass();
        return a.a(r1);
    }

    public static EnumEntries<TtsMediaRemoteAction> getEntries() {
        return b;
    }

    static {
        TtsMediaRemoteAction r0 = new TtsMediaRemoteAction("FOREGROUND", 0, "lark.tts.action.foreground");
        FOREGROUND = r0;
        TtsMediaRemoteAction r1 = new TtsMediaRemoteAction("TERMINAL", 1, "lark.tts.action.terminal");
        TERMINAL = r1;
        TtsMediaRemoteAction r3 = new TtsMediaRemoteAction("RESUME", 2, "lark.tts.action.resume");
        RESUME = r3;
        TtsMediaRemoteAction r5 = new TtsMediaRemoteAction("PAUSE", 3, "lark.tts.action.pause");
        PAUSE = r5;
        TtsMediaRemoteAction r7 = new TtsMediaRemoteAction("PREVIOUS", 4, "lark.tts.action.previous");
        PREVIOUS = r7;
        TtsMediaRemoteAction r9 = new TtsMediaRemoteAction("NEXT", 5, "lark.tts.action.next");
        NEXT = r9;
        TtsMediaRemoteAction[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
        Companion = new a();
    }

    public static TtsMediaRemoteAction[] values() {
        return (TtsMediaRemoteAction[]) a.clone();
    }

    public final String getActionName() {
        return this.actionName;
    }

    public static TtsMediaRemoteAction valueOf(String r1) {
        return (TtsMediaRemoteAction) r27.a.a(TtsMediaRemoteAction.class, r1);
    }

    public TtsMediaRemoteAction(String r1, int r2, String r3) {
        super(r1, r2);
        this.actionName = r3;
    }
}
