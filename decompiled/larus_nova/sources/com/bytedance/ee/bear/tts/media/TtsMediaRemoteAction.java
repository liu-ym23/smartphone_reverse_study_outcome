package com.bytedance.ee.bear.tts.media;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/tts/media/TtsMediaRemoteAction;", "", "actionName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getActionName", "()Ljava/lang/String;", "FOREGROUND", "TERMINAL", "RESUME", "PAUSE", "PREVIOUS", "NEXT", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TtsMediaRemoteAction extends Enum<TtsMediaRemoteAction> {
    public static final a Companion = null;
    public static final TtsMediaRemoteAction FOREGROUND = null;
    public static final TtsMediaRemoteAction NEXT = null;
    public static final TtsMediaRemoteAction PAUSE = null;
    public static final TtsMediaRemoteAction PREVIOUS = null;
    public static final TtsMediaRemoteAction RESUME = null;
    public static final TtsMediaRemoteAction TERMINAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TtsMediaRemoteAction[] f239651a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f239652b = null;
    private final String actionName;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static TtsMediaRemoteAction a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "actionName");
            TtsMediaRemoteAction[] r101 = TtsMediaRemoteAction.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            TtsMediaRemoteAction r104 = r101[r103];
            if (Intrinsics.areEqual(r104.getActionName(), r100) == true) goto L12;
            r103 = r103 + 1;
            goto L3
        L12:
            return r104;
        L8:
            return null;
        }
    }

    @JvmStatic
    public static final TtsMediaRemoteAction from(String r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static EnumEntries<TtsMediaRemoteAction> getEntries() {
        return f239652b;
    }

    static {
        TtsMediaRemoteAction r100 = new TtsMediaRemoteAction("FOREGROUND", 0, "lark.tts.action.foreground");
        FOREGROUND = r100;
        TtsMediaRemoteAction r101 = new TtsMediaRemoteAction("TERMINAL", 1, "lark.tts.action.terminal");
        TERMINAL = r101;
        TtsMediaRemoteAction r102 = new TtsMediaRemoteAction("RESUME", 2, "lark.tts.action.resume");
        RESUME = r102;
        TtsMediaRemoteAction r103 = new TtsMediaRemoteAction("PAUSE", 3, "lark.tts.action.pause");
        PAUSE = r103;
        TtsMediaRemoteAction r104 = new TtsMediaRemoteAction("PREVIOUS", 4, "lark.tts.action.previous");
        PREVIOUS = r104;
        TtsMediaRemoteAction r105 = new TtsMediaRemoteAction("NEXT", 5, "lark.tts.action.next");
        NEXT = r105;
        TtsMediaRemoteAction[] r110 = {r100, r101, r102, r103, r104, r105};
        f239651a = r110;
        f239652b = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
    }

    public static TtsMediaRemoteAction[] values() {
        return (TtsMediaRemoteAction[]) f239651a.clone();
    }

    public final String getActionName() {
        return this.actionName;
    }

    public static TtsMediaRemoteAction valueOf(String r100) {
        return (TtsMediaRemoteAction) r27.a.a(TtsMediaRemoteAction.class, r100);
    }

    public TtsMediaRemoteAction(String r100, int r101, String r102) {
        super(r100, r101);
        this.actionName = r102;
    }
}
