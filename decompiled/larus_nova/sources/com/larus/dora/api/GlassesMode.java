package com.larus.dora.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/api/GlassesMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ASSISTANT", "HEADPHONE", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GlassesMode extends Enum<GlassesMode> {
    public static final GlassesMode ASSISTANT = null;
    public static final a Companion = null;
    public static final GlassesMode HEADPHONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GlassesMode[] f331720a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f331721b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<GlassesMode> getEntries() {
        return f331721b;
    }

    static {
        GlassesMode r100 = new GlassesMode("ASSISTANT", 0, 0);
        ASSISTANT = r100;
        GlassesMode r101 = new GlassesMode("HEADPHONE", 1, 1);
        HEADPHONE = r101;
        GlassesMode[] r102 = {r100, r101};
        f331720a = r102;
        f331721b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static GlassesMode[] values() {
        return (GlassesMode[]) f331720a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static GlassesMode valueOf(String r100) {
        return (GlassesMode) r27.a.a(GlassesMode.class, r100);
    }

    public GlassesMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
