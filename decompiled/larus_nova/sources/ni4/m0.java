package ni4;

import com.bytedance.creativex.mediaimport.repository.internal.main.GroupItemInternal;
import defpackage.DeepThinkTopHeaderComponent$runCollapseAnimation$2;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class m0 {
    public static final boolean c(ki4.d0 r100, ki4.b0 r101) {
        Intrinsics.checkNotNullParameter(r100, "materialRange");
        Intrinsics.checkNotNullParameter(r101, "materialCursor");
        if (ki4.c0.a(r100) == false) goto L8;
        if (r101.f503616b == false) goto L12;
    L10:
        return false;
    L12:
        return true;
    L8:
        if (r101.f503615a < (r100.f503621a + r100.f503622b)) goto L10;
        return true;
    }

    public static final <GROUP_ITEM, GROUP_ITEM_KEY> void b(ki4.r r100, Function1<? super ki4.r, ? extends List<? extends GROUP_ITEM_KEY>> r101, Function1<? super GROUP_ITEM_KEY, ? extends GROUP_ITEM> r102, Function3<? super ki4.r, ? super GROUP_ITEM_KEY, ? super GROUP_ITEM, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "groupItemKeysProvider");
        Intrinsics.checkNotNullParameter(r102, "groupItemProvider");
        Intrinsics.checkNotNullParameter(r103, "addToGroupItemBlock");
        Iterator<T> r104 = r101.invoke(r100).iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        DeepThinkTopHeaderComponent$runCollapseAnimation$2.a r105 = (Object) r104.next();
        GROUP_ITEM r106 = r102.invoke(r105);
        if (r106 == null) goto L4;
        r103.invoke(r100, r105, r106);
        goto L4
    }

    public static final <FOLDER_KEY, CATEGORY_TYPE, MAP_KEY> void a(final ki4.r r110, final ki4.m r111, Function1<? super ki4.b, GroupItemInternal> r112, final Class<? extends ki4.m> r113, final FOLDER_KEY r114, final CATEGORY_TYPE r115, final Map<MAP_KEY, GroupItemInternal> r116, final Function4<? super FOLDER_KEY, ? super CATEGORY_TYPE, ? super Class<? extends ki4.m>, ? super ki4.b, ? extends MAP_KEY> r117) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "groupStrategy");
        Intrinsics.checkNotNullParameter(r112, "groupItemProvider");
        Intrinsics.checkNotNullParameter(r113, "groupStrategyClazz");
        Intrinsics.checkNotNullParameter(r116, "changedGroups");
        Intrinsics.checkNotNullParameter(r117, "mapKeyProvider");
        b(r110, new j0(r111, r110), r112, new k0(r111, r117, r114, r115, r113, r116));
    }
}
