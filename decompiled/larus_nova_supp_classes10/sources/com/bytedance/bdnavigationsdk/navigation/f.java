package com.bytedance.bdnavigationsdk.navigation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[NavigationTransport.TransportType.values().length];
            r0[NavigationTransport.TransportType.Walking.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[NavigationTransport.TransportType.Bicycling.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[NavigationTransport.TransportType.EBicycling.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[NavigationTransport.TransportType.Driving.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }
}
