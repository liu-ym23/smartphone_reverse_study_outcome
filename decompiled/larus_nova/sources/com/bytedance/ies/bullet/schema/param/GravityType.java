package com.bytedance.ies.bullet.schema.param;

import androidx.core.view.GravityCompat;
import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/schema/param/GravityType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "", "clientValue", "I", "getClientValue", "()I", "CENTER", "BOTTOM", "RIGHT", GXAnimation.STATE_END, "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum GravityType extends Enum<GravityType> {
    public static final GravityType BOTTOM = null;
    public static final GravityType CENTER = null;
    public static final GravityType END = null;
    public static final GravityType RIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GravityType[] f247731a = null;
    private final int clientValue;
    private final String value;

    public static GravityType valueOf(String r100) {
        return (GravityType) a.a(GravityType.class, r100);
    }

    public static GravityType[] values() {
        return (GravityType[]) f247731a.clone();
    }

    static {
        GravityType r100 = new GravityType("CENTER", 0, "center", 17);
        CENTER = r100;
        GravityType r101 = new GravityType("BOTTOM", 1, "bottom", 80);
        BOTTOM = r101;
        GravityType r102 = new GravityType("RIGHT", 2, "right", 5);
        RIGHT = r102;
        GravityType r103 = new GravityType(GXAnimation.STATE_END, 3, "end", GravityCompat.END);
        END = r103;
        f247731a = new GravityType[]{r100, r101, r102, r103};
    }

    public final int getClientValue() {
        return this.clientValue;
    }

    public final String getValue() {
        return this.value;
    }

    public GravityType(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.value = r102;
        this.clientValue = r103;
    }
}
