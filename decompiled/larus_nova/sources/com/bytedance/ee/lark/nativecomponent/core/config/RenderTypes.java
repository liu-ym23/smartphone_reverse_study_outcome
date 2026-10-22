package com.bytedance.ee.lark.nativecomponent.core.config;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/lark/nativecomponent/core/config/RenderTypes;", "", "typeName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTypeName", "()Ljava/lang/String;", "LEGACY", "OVERLAY", "SANDWICH", "EMBED", "native-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RenderTypes extends Enum<RenderTypes> {
    public static final RenderTypes EMBED = null;
    public static final RenderTypes LEGACY = null;
    public static final RenderTypes OVERLAY = null;
    public static final RenderTypes SANDWICH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RenderTypes[] f242833a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f242834b = null;
    private final String typeName;

    public static EnumEntries<RenderTypes> getEntries() {
        return f242834b;
    }

    static {
        RenderTypes r100 = new RenderTypes("LEGACY", 0, "legacy");
        LEGACY = r100;
        RenderTypes r101 = new RenderTypes("OVERLAY", 1, "native_component_overlay");
        OVERLAY = r101;
        RenderTypes r102 = new RenderTypes("SANDWICH", 2, "native_component_sandwich");
        SANDWICH = r102;
        RenderTypes r103 = new RenderTypes("EMBED", 3, "native_component_embed");
        EMBED = r103;
        RenderTypes[] r104 = {r100, r101, r102, r103};
        f242833a = r104;
        f242834b = EnumEntriesKt.enumEntries(r104);
    }

    public static RenderTypes[] values() {
        return (RenderTypes[]) f242833a.clone();
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public static RenderTypes valueOf(String r100) {
        return (RenderTypes) a.a(RenderTypes.class, r100);
    }

    public RenderTypes(String r100, int r101, String r102) {
        super(r100, r101);
        this.typeName = r102;
    }
}
