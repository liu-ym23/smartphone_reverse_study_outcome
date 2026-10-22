package uz5;

import com.bytedance.helios.sdk.region.FixSizeLinkedList;
import com.google.gson.reflect.TypeToken;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import e06.d;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jz5.h;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FixSizeLinkedList<Map<String, Object>> f552189a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Type f552190b = null;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002.\u0012*\u0012(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u00060\u00020\u0001¨\u0006\u0007"}, d2 = {"uz5/c$a", "Lcom/google/gson/reflect/TypeToken;", "", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "sdk_release"}, k = 1, mv = {1, 4, 0})
    public static final class a extends TypeToken<List<? extends HashMap<String, Object>>> {
        public a() {
        }
    }

    public static final class b implements uz5.a<Map<String, ? extends Object>> {
        public b() {
        }

        @Override // uz5.a
        public final void a() {
        }

        @Override // uz5.a
        public final void b(Object r100, boolean r101) {
            Map r102 = (Map) r100;
            if (r101 == false) goto L8;
            String r103 = e06.c.c(c.f552189a);
            h r104 = d.f470643a;
            h r105 = d.f470643a;
            if (r105 == null) goto L9;
            r105.putString(EffectConfiguration.KEY_REGION, r103);
            return;
        L9:
            return;
        }
    }

    static {
        Type r100 = new a().getType();
        f552190b = r100;
        h r101 = d.f470643a;
        String r102 = "";
        if (r101 == null) goto L7;
        String r103 = r101.getString(EffectConfiguration.KEY_REGION, "");
        if (r103 == null) goto L7;
        r102 = r103;
    L7:
        b r104 = new b();
        if (r102.length() != 0) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L13;
        FixSizeLinkedList<Map<String, Object>> r106 = new FixSizeLinkedList(20, r104, null, 4, null);
    L18:
        f552189a = r106;
        return;
    L13:
        List r107 = (List) e06.c.b(r102, r100);
        if (r107 != null) goto L17;
        r107 = CollectionsKt.emptyList();
    L17:
        r106 = new FixSizeLinkedList(20, r104, r107);
        goto L18
    L10:
        r105 = false;
        goto L11
    }
}
