package zp9;

import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.PublisherCreation;
import com.larus.platform.api.creation.TplButtonType;
import com.larus.platform.api.creation.TplDetail;
import com.larus.platform.api.creation.TplInfo;
import com.larus.platform.api.creation.TplType;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.service.AccountService;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d {
    public static final String b(UserCreation r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        AuthorInfo r101 = r100.f364993g;
        if (r101 == null) goto L5;
        String r102 = r101.f364897b;
    L7:
        if (Intrinsics.areEqual(r102, AccountService.f365697a.getUserId()) == false) goto L9;
        return "self_created";
    L9:
        Integer r103 = r100.f364996j;
        if (r103 != null) goto L13;
    L14:
        Integer r104 = r100.f364996j;
        if (r104 == null) goto L22;
        if (r104 != null) goto L19;
    L27:
        return "others_created";
    L19:
        if (r104.intValue() != 3) goto L27;
    L25:
        return "default";
    L22:
        if (r100.f364988b == 1) goto L25;
    L13:
        if (r103.intValue() == 0) goto L22;
    L5:
        r102 = null;
        goto L7
    }

    public static final String c(UserCreation r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return y.a(r100.f364988b);
    }

    public static final String d(UserCreation r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return y.b(r100.f364988b);
    }

    public static final String e(UserCreation r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        CreationDynamicInfo r101 = r100.f364994h;
        if (r101 == null) goto L9;
        TplInfo r102 = r101.f364915e;
        if (r102 == null) goto L9;
        TplDetail r103 = r102.f364973b;
        if (r103 == null) goto L9;
        return r103.f364960b;
    L9:
        return null;
    }

    public static final boolean f(UserCreation r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return CollectionsKt.listOf(new Integer[]{7, 6, 9, 8, 10, 11, 12}).contains(Integer.valueOf(r100.f364988b));
    }

    public static final String a(UserCreation r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == false) goto L5;
        return "use_prompt";
    L5:
        CreationDynamicInfo r102 = r100.f364994h;
        if (r102 == null) goto L10;
        TplInfo r103 = r102.f364915e;
        if (r103 == null) goto L10;
        String r104 = r103.f364972a;
    L11:
        if (r104 == null) goto L31;
        int r105 = r104.hashCode();
        if (r105 != 3347807) goto L15;
        String r106 = TplType.MENU;
        if (r104.equals(TplType.MENU) == true) goto L30;
        return "use_prompt";
    L30:
        return r106;
    L15:
        if (r105 == 766630817) goto L23;
        if (r105 != 1430284143) goto L33;
        r106 = "change_picture";
        if (r104.equals("change_picture") == true) goto L30;
        return "use_prompt";
    L33:
        return "use_prompt";
    L23:
        if (r104.equals(TplType.AI_REPLICA) == false) goto L35;
        return TplButtonType.GEN_CREATE_AVATAR;
    L35:
        return "use_prompt";
    L31:
        return "use_prompt";
    L10:
        r104 = null;
        goto L11
    }

    public static final PublisherCreation g(UserCreation r110, String r210) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        int r100 = r110.f364988b;
        String r101 = r110.f364987a;
        CreationDynamicInfo r102 = r110.f364994h;
        if (r102 == null) goto L5;
        String r103 = r102.f364914d;
    L6:
        String r104 = r110.k();
        String r105 = r110.e();
        UserCreationRefContent r106 = r110.f365001o;
        if (r106 == null) goto L9;
        String r107 = HttpExtKt.p(r106);
    L11:
        return new PublisherCreation(r101, Integer.valueOf(r100), null, r103, r104, r105, r107, null, r210, true, null, null, null, null, 15492, null);
    L9:
        r107 = null;
        goto L11
    L5:
        r103 = null;
        goto L6
    }
}
