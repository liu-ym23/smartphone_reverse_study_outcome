package io.ktor.util;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public interface p {

    public static final class a {
        public static void a(p r100, Function2<? super String, ? super List<String>, Unit> r101) {
            Intrinsics.checkNotNullParameter(r101, ContainerPosition.BODY);
            Iterator<T> r102 = r100.entries().iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            Map.Entry r103 = (Map.Entry) r102.next();
            r101.invoke((String) r103.getKey(), (List) r103.getValue());
            goto L4
        }
    }

    List<String> a(String r100);

    boolean c();

    void d(Function2<? super String, ? super List<String>, Unit> r100);

    Set<Map.Entry<String, List<String>>> entries();

    String get(String r100);

    boolean isEmpty();

    Set<String> names();
}
