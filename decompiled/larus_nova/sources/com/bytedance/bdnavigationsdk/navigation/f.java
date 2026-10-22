package com.bytedance.bdnavigationsdk.navigation;

/* JADX INFO: loaded from: classes10.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f200065a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f200066a = null;

        static {
            int[] r100 = new int[NavigationTransport.TransportType.values().length];
            r100[NavigationTransport.TransportType.Walking.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[NavigationTransport.TransportType.Bicycling.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[NavigationTransport.TransportType.EBicycling.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[NavigationTransport.TransportType.Driving.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f200066a = r100;
        }
    }

    static {
    }
}
