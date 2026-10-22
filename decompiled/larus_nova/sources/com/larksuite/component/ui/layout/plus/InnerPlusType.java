package com.larksuite.component.ui.layout.plus;

import com.larksuite.component.ui.layout.ILKUILayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u0010"}, d2 = {"Lcom/larksuite/component/ui/layout/plus/InnerPlusType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "PER_MONITOR_RENDER", "ROUND_SHAPE", "HOVER_EVENT_DISALLOW", "createPlus", "Lcom/larksuite/component/ui/layout/plus/BaseInnerPlus;", "layout", "Lcom/larksuite/component/ui/layout/ILKUILayout;", "suite-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract enum InnerPlusType extends Enum<InnerPlusType> {
    public static final InnerPlusType HOVER_EVENT_DISALLOW = null;
    public static final InnerPlusType PER_MONITOR_RENDER = null;
    public static final InnerPlusType ROUND_SHAPE = null;
    public static final InnerPlusType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InnerPlusType[] f284234a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f284235b = null;
    private final int value;

    public InnerPlusType() {
        throw null;
    }

    public static EnumEntries<InnerPlusType> getEntries() {
        return f284235b;
    }

    public abstract BaseInnerPlus createPlus(ILKUILayout r100);

    static {
        final String r100 = "UNKNOWN";
        final int r101 = 0;
        InnerPlusType r102 = new UNKNOWN(r100, r101);
        UNKNOWN = r102;
        final String r103 = "PER_MONITOR_RENDER";
        final int r104 = 1;
        InnerPlusType r105 = new PER_MONITOR_RENDER(r103, r104);
        PER_MONITOR_RENDER = r105;
        final String r106 = "ROUND_SHAPE";
        final int r107 = 2;
        InnerPlusType r108 = new ROUND_SHAPE(r106, r107);
        ROUND_SHAPE = r108;
        final String r109 = "HOVER_EVENT_DISALLOW";
        final int r110 = 3;
        InnerPlusType r111 = new HOVER_EVENT_DISALLOW(r109, r110);
        HOVER_EVENT_DISALLOW = r111;
        InnerPlusType[] r112 = {r102, r105, r108, r111};
        f284234a = r112;
        f284235b = EnumEntriesKt.enumEntries(r112);
    }

    public static InnerPlusType[] values() {
        return (InnerPlusType[]) f284234a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static InnerPlusType valueOf(String r100) {
        return (InnerPlusType) r27.a.a(InnerPlusType.class, r100);
    }

    public InnerPlusType(String r100, int r101, int r102, DefaultConstructorMarker r103) {
        super(r100, r101);
        this.value = r102;
    }
}
