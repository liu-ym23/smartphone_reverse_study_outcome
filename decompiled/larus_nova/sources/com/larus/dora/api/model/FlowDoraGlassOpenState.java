package com.larus.dora.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/dora/api/model/FlowDoraGlassOpenState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CLOSE", "OPEN", "UNKNOWN", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowDoraGlassOpenState extends Enum<FlowDoraGlassOpenState> {
    public static final FlowDoraGlassOpenState CLOSE = null;
    public static final a Companion = null;
    public static final FlowDoraGlassOpenState OPEN = null;
    public static final FlowDoraGlassOpenState UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowDoraGlassOpenState[] f331750a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f331751b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static FlowDoraGlassOpenState a(int r100) {
            FlowDoraGlassOpenState[] r101 = FlowDoraGlassOpenState.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L11;
            FlowDoraGlassOpenState r104 = r101[r103];
            if (r104.getValue() != r100) goto L7;
            boolean r105 = true;
        L8:
            if (r105 == true) goto L12;
            r103 = r103 + 1;
        L12:
            if (r104 == null) goto L14;
            return r104;
        L14:
            return FlowDoraGlassOpenState.UNKNOWN;
        L7:
            r105 = false;
            goto L8
        L11:
            r104 = null;
            goto L12
        }
    }

    public static EnumEntries<FlowDoraGlassOpenState> getEntries() {
        return f331751b;
    }

    static {
        FlowDoraGlassOpenState r100 = new FlowDoraGlassOpenState("CLOSE", 0, 0);
        CLOSE = r100;
        FlowDoraGlassOpenState r101 = new FlowDoraGlassOpenState("OPEN", 1, 1);
        OPEN = r101;
        FlowDoraGlassOpenState r102 = new FlowDoraGlassOpenState("UNKNOWN", 2, -1);
        UNKNOWN = r102;
        FlowDoraGlassOpenState[] r103 = {r100, r101, r102};
        f331750a = r103;
        f331751b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static FlowDoraGlassOpenState[] values() {
        return (FlowDoraGlassOpenState[]) f331750a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FlowDoraGlassOpenState valueOf(String r100) {
        return (FlowDoraGlassOpenState) r27.a.a(FlowDoraGlassOpenState.class, r100);
    }

    public FlowDoraGlassOpenState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
