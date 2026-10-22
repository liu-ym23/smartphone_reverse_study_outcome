package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes42.dex */
public final class JvmBuiltInsCustomizerKt {
    private static final Name GET_FIRST_LIST_NAME = null;
    private static final Name GET_LAST_LIST_NAME = null;

    static {
        GET_FIRST_LIST_NAME = Name.identifier("getFirst");
        GET_LAST_LIST_NAME = Name.identifier("getLast");
    }

    public static final /* synthetic */ Name access$getGET_FIRST_LIST_NAME$p() {
        return GET_FIRST_LIST_NAME;
    }

    public static final /* synthetic */ Name access$getGET_LAST_LIST_NAME$p() {
        return GET_LAST_LIST_NAME;
    }
}
