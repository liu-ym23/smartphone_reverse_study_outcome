package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes42.dex */
public final class NameUtils {
    private static final String CONTEXT_RECEIVER_PREFIX = null;
    public static final NameUtils INSTANCE = null;
    private static final Regex SANITIZE_AS_JAVA_INVALID_CHARACTERS = null;

    private NameUtils() {
    }

    static {
        INSTANCE = new NameUtils();
        SANITIZE_AS_JAVA_INVALID_CHARACTERS = new Regex("[^\\p{L}\\p{Digit}]");
        CONTEXT_RECEIVER_PREFIX = "$context_receiver";
    }

    @JvmStatic
    public static final Name contextReceiverName(int r100) {
        return Name.identifier(CONTEXT_RECEIVER_PREFIX + '_' + r100);
    }

    @JvmStatic
    public static final String sanitizeAsJavaIdentifier(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return SANITIZE_AS_JAVA_INVALID_CHARACTERS.replace(r100, "_");
    }
}
