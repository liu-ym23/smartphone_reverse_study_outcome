package com.obric.assistant.settings;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/settings/ObricAppListMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "BLACK_LIST", "WHITE_LIST", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricAppListMode extends Enum<ObricAppListMode> {
    public static final ObricAppListMode BLACK_LIST = null;
    public static final a Companion = null;
    public static final ObricAppListMode WHITE_LIST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricAppListMode[] f391711a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f391712b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ObricAppListMode> getEntries() {
        return f391712b;
    }

    static {
        ObricAppListMode r100 = new ObricAppListMode("BLACK_LIST", 0, 0);
        BLACK_LIST = r100;
        ObricAppListMode r101 = new ObricAppListMode("WHITE_LIST", 1, 1);
        WHITE_LIST = r101;
        ObricAppListMode[] r102 = {r100, r101};
        f391711a = r102;
        f391712b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static ObricAppListMode[] values() {
        return (ObricAppListMode[]) f391711a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ObricAppListMode valueOf(String r100) {
        return (ObricAppListMode) r27.a.a(ObricAppListMode.class, r100);
    }

    public ObricAppListMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
