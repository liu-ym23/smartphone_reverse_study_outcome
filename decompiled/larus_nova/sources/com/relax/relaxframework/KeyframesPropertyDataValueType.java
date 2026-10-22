package com.relax.relaxframework;

import com.ss.android.ugc.effectmanager.common.EffectTypeConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/relax/relaxframework/KeyframesPropertyDataValueType;", "", "", "value", "I", "getValue", "()I", "Numeric", "Transform", EffectTypeConstants.TYPE_FILTER, "BoxShadow", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum KeyframesPropertyDataValueType extends Enum<KeyframesPropertyDataValueType> {
    public static final KeyframesPropertyDataValueType BoxShadow = null;
    public static final KeyframesPropertyDataValueType Filter = null;
    public static final KeyframesPropertyDataValueType Numeric = null;
    public static final KeyframesPropertyDataValueType Transform = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeyframesPropertyDataValueType[] f404753a = null;
    private final int value;

    public static KeyframesPropertyDataValueType valueOf(String r100) {
        return (KeyframesPropertyDataValueType) r27.a.a(KeyframesPropertyDataValueType.class, r100);
    }

    public static KeyframesPropertyDataValueType[] values() {
        return (KeyframesPropertyDataValueType[]) f404753a.clone();
    }

    static {
        KeyframesPropertyDataValueType r100 = new KeyframesPropertyDataValueType("Numeric", 0, 0);
        Numeric = r100;
        KeyframesPropertyDataValueType r101 = new KeyframesPropertyDataValueType("Transform", 1, 1);
        Transform = r101;
        KeyframesPropertyDataValueType r102 = new KeyframesPropertyDataValueType(EffectTypeConstants.TYPE_FILTER, 2, 2);
        Filter = r102;
        KeyframesPropertyDataValueType r103 = new KeyframesPropertyDataValueType("BoxShadow", 3, 3);
        BoxShadow = r103;
        f404753a = new KeyframesPropertyDataValueType[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public KeyframesPropertyDataValueType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
