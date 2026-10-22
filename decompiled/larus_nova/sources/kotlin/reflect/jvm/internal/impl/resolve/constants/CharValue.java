package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.ss.android.cert.manager.constants.EventConstant;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: loaded from: classes42.dex */
public final class CharValue extends IntegerValueConstant<Character> {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public String toString() {
        return String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[]{Integer.valueOf(getValue().charValue()), getPrintablePart(getValue().charValue())}, 2));
    }

    public CharValue(char r100) {
        super(Character.valueOf(r100));
    }

    private final String getPrintablePart(char r100) {
        if (r100 != '\b') goto L6;
        return "\\b";
    L6:
        if (r100 != '\t') goto L9;
        return "\\t";
    L9:
        if (r100 != '\n') goto L12;
        return "\\n";
    L12:
        if (r100 != '\f') goto L15;
        return "\\f";
    L15:
        if (r100 != '\r') goto L18;
        return "\\r";
    L18:
        if (isPrintableUnicode(r100) == true) goto L27;
        return "?";
    L27:
        return String.valueOf(r100);
    }

    private final boolean isPrintableUnicode(char r100) {
        byte r101 = (byte) Character.getType(r100);
        if (r101 != 0) goto L5;
    L17:
        return false;
    L5:
        if (r101 == 13) goto L17;
        if (r101 == 14) goto L17;
        if (r101 == 15) goto L17;
        if (r101 == 16) goto L17;
        if (r101 == 18) goto L17;
        if (r101 == 19) goto L17;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public SimpleType getType(ModuleDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        return r100.getBuiltIns().getCharType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public /* bridge */ /* synthetic */ KotlinType getType(ModuleDescriptor r100) {
        return getType(r100);
    }
}
