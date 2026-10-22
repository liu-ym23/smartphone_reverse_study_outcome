package com.bytedance.lark.lark_bitable_android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/lark/lark_bitable_android/BaseAppPreloadResourceType;", "", "(Ljava/lang/String;I)V", "into", "Llark_bitable/proto/BaseAppPreloadResourceType;", "intoInt", "", "ClientVars", "Companion", "lark_bitable_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum BaseAppPreloadResourceType extends Enum<BaseAppPreloadResourceType> {
    public static final BaseAppPreloadResourceType ClientVars = null;
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BaseAppPreloadResourceType[] f252946a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f252947b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f252948a = null;

        static {
            int[] r100 = new int[BaseAppPreloadResourceType.values().length];
            r100[BaseAppPreloadResourceType.ClientVars.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f252948a = r100;
        }
    }

    public static EnumEntries<BaseAppPreloadResourceType> getEntries() {
        return f252947b;
    }

    public static BaseAppPreloadResourceType valueOf(String r100) {
        return (BaseAppPreloadResourceType) r27.a.a(BaseAppPreloadResourceType.class, r100);
    }

    public static BaseAppPreloadResourceType[] values() {
        return (BaseAppPreloadResourceType[]) f252946a.clone();
    }

    static {
        BaseAppPreloadResourceType r100 = new BaseAppPreloadResourceType();
        ClientVars = r100;
        BaseAppPreloadResourceType[] r101 = {r100};
        f252946a = r101;
        f252947b = EnumEntriesKt.enumEntries(r101);
        Companion = new a();
    }

    public BaseAppPreloadResourceType() {
        super("ClientVars", 0);
    }

    public final lark_bitable.proto.BaseAppPreloadResourceType into() {
        if (b.f252948a[ordinal()] != 1) goto L7;
        return lark_bitable.proto.BaseAppPreloadResourceType.VAR_BASE_APP_PRELOAD_RESOURCE_TYPE_CLIENT_VARS;
    L7:
        throw new NoWhenBranchMatchedException();
    }

    public final int intoInt() {
        if (b.f252948a[ordinal()] != 1) goto L7;
        return 0;
    L7:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final BaseAppPreloadResourceType fromInt(int r100) {
        Companion.getClass();
        if (r100 != 0) goto L7;
        return ClientVars;
    L7:
        throw new RuntimeException("Unmatched primitive enum value: BaseAppPreloadResourceType with ");
    }
}
