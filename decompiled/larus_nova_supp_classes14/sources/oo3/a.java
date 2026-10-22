package oo3;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final Type a = null;

    /* JADX INFO: renamed from: oo3.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"oo3/a$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-radio-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class C0151a extends TypeToken<List<? extends Integer>> {
        public C0151a() {
        }
    }

    static {
        Type r0 = new C0151a().getType();
        Intrinsics.checkNotNull(r0);
        a = r0;
    }
}
