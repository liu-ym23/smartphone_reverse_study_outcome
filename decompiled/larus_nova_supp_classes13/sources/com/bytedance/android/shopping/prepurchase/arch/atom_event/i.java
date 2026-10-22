package com.bytedance.android.shopping.prepurchase.arch.atom_event;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0005R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/arch/atom_event/i;", "", "", "key", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "value", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {
    public static final /* synthetic */ int a = 0;

    @SerializedName("key")
    private final String key;

    @SerializedName("value")
    private final Object value;

    public static final class a {
        public static i a(Map r4) {
            Object r1 = null;
            if (r4 == null) goto L5;
            Object r2 = r4.get("key");
        L7:
            if ((r2 instanceof String) == false) goto L10;
            r1 = r2;
        L10:
            String r3 = (String) r1;
            if (r3 != null) goto L13;
            r3 = "";
        L13:
            if (r4 == null) goto L16;
            Object r5 = r4.get("value");
            if (r5 == null) goto L16;
        L18:
            return new i(r3, r5);
        L16:
            r5 = "null";
            goto L18
        L5:
            r2 = null;
            goto L7
        }
    }

    static {
    }

    public i() {
        this("", null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof i) == false) goto L10;
        i r4 = (i) r3;
        if (Intrinsics.areEqual(this.key, r4.key) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.value, r4.value) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.key;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Object r4 = this.value;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PDPStorageActionAtomEventParam(key=" + this.key + ", value=" + this.value + ")";
    }

    public final String a() {
        return this.key;
    }

    public final Object b() {
        return this.value;
    }

    public i(String r1, Object r2) {
        this.key = r1;
        this.value = r2;
    }
}
