package com.obric.assistant.upload;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/assistant/upload/Scene;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DEFAULT", "SCREEN_SEMANTIC", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Scene extends Enum<Scene> {
    public static final Scene DEFAULT = null;
    public static final Scene SCREEN_SEMANTIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Scene[] f393549a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f393550b = null;
    private final String value;

    public static EnumEntries<Scene> getEntries() {
        return f393550b;
    }

    static {
        Scene r100 = new Scene("DEFAULT", 0, "default");
        DEFAULT = r100;
        Scene r101 = new Scene("SCREEN_SEMANTIC", 1, "screen_semantic");
        SCREEN_SEMANTIC = r101;
        Scene[] r102 = {r100, r101};
        f393549a = r102;
        f393550b = EnumEntriesKt.enumEntries(r102);
    }

    public static Scene[] values() {
        return (Scene[]) f393549a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static Scene valueOf(String r100) {
        return (Scene) a.a(Scene.class, r100);
    }

    public Scene(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
