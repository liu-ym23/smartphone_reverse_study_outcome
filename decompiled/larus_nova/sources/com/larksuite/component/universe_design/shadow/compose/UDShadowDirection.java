package com.larksuite.component.universe_design.shadow.compose;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larksuite/component/universe_design/shadow/compose/UDShadowDirection;", "", "x", "", "y", "<init>", "(Ljava/lang/String;III)V", "getX$universe_ui_shadow_release", "()I", "getY$universe_ui_shadow_release", "None", "Up", "Down", "Left", "Right", "universe-ui-shadow_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UDShadowDirection extends Enum<UDShadowDirection> {
    public static final UDShadowDirection Down = null;
    public static final UDShadowDirection Left = null;
    public static final UDShadowDirection None = null;
    public static final UDShadowDirection Right = null;
    public static final UDShadowDirection Up = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UDShadowDirection[] f285241a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f285242b = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final int f285243x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final int f285244y;

    public static EnumEntries<UDShadowDirection> getEntries() {
        return f285242b;
    }

    static {
        UDShadowDirection r100 = new UDShadowDirection("None", 0, 0, 0);
        None = r100;
        UDShadowDirection r101 = new UDShadowDirection("Up", 1, 0, -1);
        Up = r101;
        UDShadowDirection r102 = new UDShadowDirection("Down", 2, 0, 1);
        Down = r102;
        UDShadowDirection r103 = new UDShadowDirection("Left", 3, -1, 0);
        Left = r103;
        UDShadowDirection r104 = new UDShadowDirection("Right", 4, 1, 0);
        Right = r104;
        UDShadowDirection[] r105 = {r100, r101, r102, r103, r104};
        f285241a = r105;
        f285242b = EnumEntriesKt.enumEntries(r105);
    }

    public static UDShadowDirection[] values() {
        return (UDShadowDirection[]) f285241a.clone();
    }

    public final int getX$universe_ui_shadow_release() {
        return this.f285243x;
    }

    public final int getY$universe_ui_shadow_release() {
        return this.f285244y;
    }

    public static UDShadowDirection valueOf(String r100) {
        return (UDShadowDirection) r27.a.a(UDShadowDirection.class, r100);
    }

    public UDShadowDirection(String r100, int r101, int r102, int r103) {
        super(r100, r101);
        this.f285243x = r102;
        this.f285244y = r103;
    }
}
