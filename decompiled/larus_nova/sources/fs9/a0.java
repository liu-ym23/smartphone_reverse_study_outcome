package fs9;

import com.larus.platform.api.creation.UserCreation;
import com.larus.profile.api.bean.UserCreationModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a0 {
    public static final UserCreationModel a(UserCreationModel r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        UserCreationModel r101 = UserCreationModel.a(r100, new ArrayList());
        List<UserCreation> r102 = r101.b();
        if (r102 == null) goto L9;
        List<UserCreation> r103 = r100.b();
        if (r103 == null) goto L7;
        List<UserCreation> r104 = r103;
    L8:
        r102.addAll(r104);
        goto L9
    L7:
        r104 = new ArrayList();
    L9:
        return r101;
    }

    public static final boolean b(UserCreationModel r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        List<UserCreation> r101 = r100.b();
        if (r101 != null) goto L5;
        r101 = CollectionsKt.emptyList();
    L5:
        List<UserCreation> r102 = r101;
        if ((r102 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r103 = r102.iterator();
    L12:
        if (r103.hasNext() == false) goto L29;
        Integer r104 = ((UserCreation) r103.next()).f364989c;
        if (r104 != null) goto L17;
    L19:
        boolean r105 = false;
    L20:
        if (r105 == false) goto L12;
        return true;
    L17:
        if (r104.intValue() != 5) goto L19;
        r105 = true;
        goto L20
    L29:
        return false;
    L8:
        if (r102.isEmpty() == false) goto L10;
        return false;
    }

    public static final void c(UserCreationModel r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        List<UserCreation> r101 = r100.b();
        if (r101 == null) goto L8;
        UserCreation r102 = (UserCreation) CollectionsKt.firstOrNull(r101);
        if (r102 == null) goto L8;
        String r103 = r102.f364987a;
        if (r103 == null) goto L8;
    L9:
        r100.g(r103);
        return;
    L8:
        r103 = "";
        goto L9
    }
}
