package com.google.common.graph;

/* JADX INFO: loaded from: classes23.dex */
final enum GraphConstants$Presence extends Enum<GraphConstants$Presence> {
    public static final GraphConstants$Presence EDGE_EXISTS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GraphConstants$Presence[] f275553a = null;

    static {
        GraphConstants$Presence r100 = new GraphConstants$Presence();
        EDGE_EXISTS = r100;
        f275553a = new GraphConstants$Presence[]{r100};
    }

    public GraphConstants$Presence() {
        super("EDGE_EXISTS", 0);
    }

    public static GraphConstants$Presence[] values() {
        return (GraphConstants$Presence[]) f275553a.clone();
    }

    public static GraphConstants$Presence valueOf(String r100) {
        return (GraphConstants$Presence) r27.a.a(GraphConstants$Presence.class, r100);
    }
}
