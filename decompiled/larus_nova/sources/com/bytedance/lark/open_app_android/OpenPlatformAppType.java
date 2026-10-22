package com.bytedance.lark.open_app_android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/bytedance/lark/open_app_android/OpenPlatformAppType;", "", "(Ljava/lang/String;I)V", "into", "Lopen_app/proto/OpenPlatformAppType;", "intoInt", "", "GadgetApp", "WebApp", "Companion", "open_app_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum OpenPlatformAppType extends Enum<OpenPlatformAppType> {
    public static final a Companion = null;
    public static final OpenPlatformAppType GadgetApp = null;
    public static final OpenPlatformAppType WebApp = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenPlatformAppType[] f253410a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f253411b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f253412a = null;

        static {
            int[] r100 = new int[OpenPlatformAppType.values().length];
            r100[OpenPlatformAppType.GadgetApp.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[OpenPlatformAppType.WebApp.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f253412a = r100;
        }
    }

    public static EnumEntries<OpenPlatformAppType> getEntries() {
        return f253411b;
    }

    public static OpenPlatformAppType valueOf(String r100) {
        return (OpenPlatformAppType) r27.a.a(OpenPlatformAppType.class, r100);
    }

    public static OpenPlatformAppType[] values() {
        return (OpenPlatformAppType[]) f253410a.clone();
    }

    static {
        OpenPlatformAppType r100 = new OpenPlatformAppType("GadgetApp", 0);
        GadgetApp = r100;
        OpenPlatformAppType r101 = new OpenPlatformAppType("WebApp", 1);
        WebApp = r101;
        OpenPlatformAppType[] r102 = {r100, r101};
        f253410a = r102;
        f253411b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public final open_app.proto.OpenPlatformAppType into() {
        int r100 = b.f253412a[ordinal()];
        if (r100 == 1) goto L10;
        if (r100 != 2) goto L8;
        return open_app.proto.OpenPlatformAppType.VAR_OPEN_PLATFORM_APP_TYPE_WEB_APP;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return open_app.proto.OpenPlatformAppType.VAR_OPEN_PLATFORM_APP_TYPE_GADGET_APP;
    }

    public final int intoInt() {
        int r100 = b.f253412a[ordinal()];
        if (r100 != 1) goto L5;
        return 0;
    L5:
        if (r100 != 2) goto L8;
        return 1;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final OpenPlatformAppType fromInt(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L10;
        if (r100 != 1) goto L8;
        return WebApp;
    L8:
        throw new RuntimeException("Unmatched primitive enum value: OpenPlatformAppType with ");
    L10:
        return GadgetApp;
    }

    public OpenPlatformAppType(String r100, int r101) {
        super(r100, r101);
    }
}
