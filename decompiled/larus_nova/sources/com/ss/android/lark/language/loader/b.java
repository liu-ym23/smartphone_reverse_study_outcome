package com.ss.android.lark.language.loader;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends c {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.language.loader.BaseLanguageLoader
    public final LinkedHashMap<Locale, Integer> b() {
        LinkedHashMap<Locale, Integer> r100 = new LinkedHashMap();
        Iterator r101 = ((Map) this.f431076b.getValue()).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Map.Entry r102 = (Map.Entry) r101.next();
        List r103 = StringsKt.split$default((CharSequence) r102.getKey(), new String[]{"-"}, false, 0, 6, null);
        if (r103.size() > 1) goto L7;
        r100.put(new Locale((String) ListProtector.get(r103, 0)), r102.getValue());
        goto L4
    L7:
        r100.put(new Locale((String) ListProtector.get(r103, 0), (String) ListProtector.get(r103, 1)), r102.getValue());
        goto L4
    L9:
        return r100;
    }

    public b(KVRepo r100) {
        Intrinsics.checkNotNullParameter(r100, "globalCoreKVRepo");
        super(r100);
    }
}
