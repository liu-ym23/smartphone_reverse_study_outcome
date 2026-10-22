package com.larus.dora.impl;

import com.larus.dora.api.DoraEnableScope;
import com.larus.dora.api.DoraServerDeviceType;
import com.larus.dora.api.DoraServerResourceType;
import com.larus.dora.impl.resource.DoraResourceSource;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f338078a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f338079b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f338080c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f338081d = null;

    static {
        int[] r100 = new int[DoraServerDeviceType.values().length];
        r100[DoraServerDeviceType.G1.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
    L60:
        r100[DoraServerDeviceType.G2.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
    L6:
        f338078a = r100;
        int[] r101 = new int[DoraEnableScope.values().length];
        r101[DoraEnableScope.G1.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
    L54:
        r101[DoraEnableScope.G2.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
    L62:
        r101[DoraEnableScope.G_SERIES.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
    L11:
        f338079b = r101;
        int[] r102 = new int[DoraServerResourceType.values().length];
        r102[DoraServerResourceType.STRING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L30
    L46:
        r102[DoraServerResourceType.DRAWABLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L31
    L56:
        r102[DoraServerResourceType.LAYOUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L32
    L64:
        r102[DoraServerResourceType.RAW.ordinal()] = 4;     // Catch: NoSuchFieldError -> L33
    L42:
        r102[DoraServerResourceType.COLOR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L34
    L48:
        r102[DoraServerResourceType.XML.ordinal()] = 6;     // Catch: NoSuchFieldError -> L35
    L66:
        r102[DoraServerResourceType.DIMEN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L36
    L19:
        f338080c = r102;
        int[] r103 = new int[DoraResourceSource.values().length];
        r103[DoraResourceSource.APK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L37
    L58:
        r103[DoraResourceSource.LOCAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L38
    L68:
        r103[DoraResourceSource.CLOUD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L39
    L23:
        f338081d = r103;
    }
}
