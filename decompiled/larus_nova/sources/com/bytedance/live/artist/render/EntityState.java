package com.bytedance.live.artist.render;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/live/artist/render/EntityState;", "", "Init", "Prepared", "Rendering", "WaitDestroy", "Destroyed", "artist"}, k = 1, mv = {1, 4, 0})
public final enum EntityState extends Enum<EntityState> {
    public static final EntityState Destroyed = null;
    public static final EntityState Init = null;
    public static final EntityState Prepared = null;
    public static final EntityState Rendering = null;
    public static final EntityState WaitDestroy = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EntityState[] f254825a = null;

    static {
        EntityState r100 = new EntityState("Init", 0);
        Init = r100;
        EntityState r101 = new EntityState("Prepared", 1);
        Prepared = r101;
        EntityState r102 = new EntityState("Rendering", 2);
        Rendering = r102;
        EntityState r103 = new EntityState("WaitDestroy", 3);
        WaitDestroy = r103;
        EntityState r104 = new EntityState("Destroyed", 4);
        Destroyed = r104;
        f254825a = new EntityState[]{r100, r101, r102, r103, r104};
    }

    public static EntityState valueOf(String r100) {
        return (EntityState) r27.a.a(EntityState.class, r100);
    }

    public static EntityState[] values() {
        return (EntityState[]) f254825a.clone();
    }

    public EntityState(String r100, int r101) {
        super(r100, r101);
    }
}
