package com.obric.assistant.window.materials;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/window/materials/BlurSceneType;", "", "<init>", "(Ljava/lang/String;I)V", "WINDOW", "VIEW", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BlurSceneType extends Enum<BlurSceneType> {
    public static final BlurSceneType VIEW = null;
    public static final BlurSceneType WINDOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BlurSceneType[] f394928a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f394929b = null;

    public static EnumEntries<BlurSceneType> getEntries() {
        return f394929b;
    }

    static {
        BlurSceneType r100 = new BlurSceneType("WINDOW", 0);
        WINDOW = r100;
        BlurSceneType r101 = new BlurSceneType("VIEW", 1);
        VIEW = r101;
        BlurSceneType[] r102 = {r100, r101};
        f394928a = r102;
        f394929b = EnumEntriesKt.enumEntries(r102);
    }

    public static BlurSceneType[] values() {
        return (BlurSceneType[]) f394928a.clone();
    }

    public static BlurSceneType valueOf(String r100) {
        return (BlurSceneType) a.a(BlurSceneType.class, r100);
    }

    public BlurSceneType(String r100, int r101) {
        super(r100, r101);
    }
}
