package com.bytedance.ies.bullet.forest;

import com.bytedance.env.api.AccessKeyType;
import com.bytedance.ies.bullet.kit.resourceloader.model.ResourceLoaderType;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f246735a = 0;

    /* JADX INFO: renamed from: com.bytedance.ies.bullet.forest.a$a, reason: collision with other inner class name */
    public static final class C3527a {

        /* JADX INFO: renamed from: com.bytedance.ies.bullet.forest.a$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C3528a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f246736a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ int[] f246737b = null;

            static {
                int[] r100 = new int[ResourceLoaderType.values().length];
                r100[ResourceLoaderType.PPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L15:
                r100[ResourceLoaderType.BOE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L6:
                f246736a = r100;
                int[] r101 = new int[AccessKeyType.values().length];
                r101[AccessKeyType.INHOUSE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
            L21:
                r101[AccessKeyType.BOE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
            L9:
                f246737b = r101;
            }
        }

        public static List a() {
            Boolean r100 = com.bytedance.ies.bullet.base.utils.c.f246325a;
            com.bytedance.env.api.d r101 = com.bytedance.ies.bullet.base.utils.c.a.b();
            ResourceLoaderType r102 = null;
            if (r101 == null) goto L5;
            AccessKeyType r103 = r101.a();
        L6:
            int r104 = -1;
            if (r103 != null) goto L9;
            int r105 = -1;
        L11:
            if (r105 == (-1)) goto L17;
            if (r105 == 1) goto L31;
            if (r105 == 2) goto L30;
            return CollectionsKt.listOf(new String[]{"5fb33cde3ebff01c8433ddc22aac0816", "c03e7f8feccb52c8e0f55f63b8025d0f", "6e5ea4687a1ae236f7677bed242a0bdd", "c772b372d999d01c25c1255e4d92ccad", "d8feacce0eae150c8140e5c435ccbbda", "37913fa91838dc5ccb399f24439d11c0"});
        L30:
            return CollectionsKt.listOf(new String[]{"68f927652a5370ec9f4ae1dbaf56fd85", "07467e91f0656ae9451e9beef41d1d87", "92549089bbfda222da88c565422ff344", "feb359d0564d243c06dbcf0c0446d372", "afe58e0f6709cd80a6524f309678f67d"});
        L31:
            return CollectionsKt.listOf(new String[]{"36723dc3e85a23e701d1697d57de07ed", "0e99390a97a5105f755f73fe564a63ad", "5436709938b15832912cf5322009c03d", "46c563b112f40133a95aa5596d83790b", "e1927d8fdbbf6786914e8ca27307104b", "aac7f74029c1c77d9beff78823e97382"});
        L17:
            a26.b r106 = com.bytedance.ies.bullet.kit.resourceloader.i.f246827d;
            if (r106 == null) goto L20;
            r102 = r106.getType();
        L20:
            if (r102 == null) goto L23;
            r104 = C3528a.f246736a[r102.ordinal()];
        L23:
            if (r104 == 1) goto L28;
            if (r104 == 2) goto L33;
            return CollectionsKt.listOf(new String[]{"5fb33cde3ebff01c8433ddc22aac0816", "c03e7f8feccb52c8e0f55f63b8025d0f", "6e5ea4687a1ae236f7677bed242a0bdd", "c772b372d999d01c25c1255e4d92ccad", "d8feacce0eae150c8140e5c435ccbbda", "37913fa91838dc5ccb399f24439d11c0"});
        L33:
            return CollectionsKt.listOf(new String[]{"68f927652a5370ec9f4ae1dbaf56fd85", "07467e91f0656ae9451e9beef41d1d87", "92549089bbfda222da88c565422ff344", "feb359d0564d243c06dbcf0c0446d372", "afe58e0f6709cd80a6524f309678f67d"});
        L28:
            return CollectionsKt.listOf(new String[]{"36723dc3e85a23e701d1697d57de07ed", "0e99390a97a5105f755f73fe564a63ad", "5436709938b15832912cf5322009c03d", "46c563b112f40133a95aa5596d83790b", "e1927d8fdbbf6786914e8ca27307104b", "aac7f74029c1c77d9beff78823e97382"});
        L9:
            r105 = C3528a.f246737b[r103.ordinal()];
            goto L11
        L5:
            r103 = null;
            goto L6
        }
    }

    static {
    }
}
