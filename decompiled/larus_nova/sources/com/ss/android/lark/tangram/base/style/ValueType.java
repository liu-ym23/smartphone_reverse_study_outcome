package com.ss.android.lark.tangram.base.style;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/tangram/base/style/ValueType;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "AUTO", "POINT", "PERCENTAGE", "Companion", "tangram-component_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ValueType extends Enum<ValueType> implements Serializable {
    public static final ValueType AUTO = null;
    public static final a Companion = null;
    public static final ValueType PERCENTAGE = null;
    public static final ValueType POINT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ValueType[] f441167a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f441168b = null;
    private int value;

    public static final class a {
        public a() {
        }

        public static ValueType a(int r100) {
            if (r100 == 0) goto L11;
            if (r100 == 1) goto L14;
            if (r100 == 2) goto L13;
            return ValueType.AUTO;
        L13:
            return ValueType.PERCENTAGE;
        L14:
            return ValueType.POINT;
        L11:
            return ValueType.AUTO;
        }
    }

    public static EnumEntries getEntries() {
        return f441168b;
    }

    static {
        ValueType r100 = new ValueType("AUTO", 0, 0);
        AUTO = r100;
        ValueType r101 = new ValueType("POINT", 1, 1);
        POINT = r101;
        ValueType r102 = new ValueType("PERCENTAGE", 2, 2);
        PERCENTAGE = r102;
        ValueType[] r103 = {r100, r101, r102};
        f441167a = r103;
        f441168b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static ValueType[] values() {
        return (ValueType[]) f441167a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ValueType valueOf(String r100) {
        return (ValueType) r27.a.a(ValueType.class, r100);
    }

    public final void setValue(int r100) {
        this.value = r100;
    }

    public ValueType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
