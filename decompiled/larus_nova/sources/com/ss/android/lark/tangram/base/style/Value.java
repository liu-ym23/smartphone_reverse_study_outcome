package com.ss.android.lark.tangram.base.style;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0011\u001a\u00020\u0000J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ&\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001bJ\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/tangram/base/style/Value;", "Ljava/io/Serializable;", "valueType", "Lcom/ss/android/lark/tangram/base/style/ValueType;", "value", "", "<init>", "(Lcom/ss/android/lark/tangram/base/style/ValueType;Ljava/lang/Float;)V", "getValueType", "()Lcom/ss/android/lark/tangram/base/style/ValueType;", "setValueType", "(Lcom/ss/android/lark/tangram/base/style/ValueType;)V", "getValue", "()Ljava/lang/Float;", "setValue", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "clone", "equals", "", "other", "", "hashCode", "", "component1", "component2", "copy", "(Lcom/ss/android/lark/tangram/base/style/ValueType;Ljava/lang/Float;)Lcom/ss/android/lark/tangram/base/style/Value;", "toString", "", "Companion", "tangram-component_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Value implements Serializable {
    public static final a Companion = null;
    private Float value;
    private ValueType valueType;

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public static Value a() {
            Object[] r100 = 0 == true ? 1 : 0;
            return new Value(null, r100, 3, 0 == true ? 1 : 0);
        }

        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Value() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ Value copy$default(Value r100, ValueType r101, Float r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.valueType;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.value;
    L9:
        return r100.copy(r101, r102);
    }

    @JvmStatic
    /* JADX INFO: renamed from: default, reason: not valid java name */
    public static final Value m8658default() {
        Companion.getClass();
        return a.a();
    }

    public final ValueType component1() {
        return this.valueType;
    }

    public final Float component2() {
        return this.value;
    }

    public final Value copy(ValueType r100, Float r101) {
        return new Value(r100, r101);
    }

    public String toString() {
        return "Value(valueType=" + this.valueType + ", value=" + this.value + ')';
    }

    public final Value clone() {
        ValueType.a r100 = ValueType.Companion;
        ValueType r101 = this.valueType;
        if (r101 == null) goto L5;
        int r102 = r101.getValue();
    L6:
        r100.getClass();
        return new Value(ValueType.a.a(r102), this.value);
    L5:
        r102 = 0;
        goto L6
    }

    public int hashCode() {
        ValueType r100 = this.valueType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Float r104 = this.value;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final Float getValue() {
        return this.value;
    }

    public final ValueType getValueType() {
        return this.valueType;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(Value.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.tangram.base.style.Value");
        Value r102 = (Value) r100;
        if (this.valueType == r102.valueType) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.value, r102.value) == true) goto L18;
        return false;
    L18:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void setValue(Float r100) {
        this.value = r100;
    }

    public final void setValueType(ValueType r100) {
        this.valueType = r100;
    }

    public Value(ValueType r100, Float r101) {
        this.valueType = r100;
        this.value = r101;
    }

    public /* synthetic */ Value(ValueType r100, Float r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = ValueType.AUTO;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = Float.valueOf(0.0f);
    L8:
        this(r100, r101);
    }
}
