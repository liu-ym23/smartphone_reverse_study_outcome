package yz5;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
public final class g extends f {

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"yz5/g$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "sdk_release"}, k = 1, mv = {1, 4, 0})
    public static final class a extends TypeToken<List<? extends String>> {
        public a() {
        }
    }

    @Override // yz5.f
    public final int b() {
        return 700;
    }

    @Override // yz5.f
    public final String c() {
        return "in";
    }

    public g() {
    }

    @Override // yz5.f
    public final Object a(Object r100, Object r101) {
        Type r102 = new a().getType();
        return Boolean.valueOf(((List) GsonProtectorUtils.fromJson(o.f569541a, String.valueOf(r101), r102)).contains(String.valueOf(r100)));
    }
}
