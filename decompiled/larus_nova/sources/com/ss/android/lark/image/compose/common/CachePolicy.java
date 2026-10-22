package com.ss.android.lark.image.compose.common;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/image/compose/common/CachePolicy;", "", "<init>", "(Ljava/lang/String;I)V", "Enabled", "Disabled", "ReadOnly", "WriteOnly", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CachePolicy extends Enum<CachePolicy> {
    public static final CachePolicy Disabled = null;
    public static final CachePolicy Enabled = null;
    public static final CachePolicy ReadOnly = null;
    public static final CachePolicy WriteOnly = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CachePolicy[] f426250a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f426251b = null;

    public static EnumEntries<CachePolicy> getEntries() {
        return f426251b;
    }

    static {
        CachePolicy r100 = new CachePolicy("Enabled", 0);
        Enabled = r100;
        CachePolicy r101 = new CachePolicy("Disabled", 1);
        Disabled = r101;
        CachePolicy r102 = new CachePolicy("ReadOnly", 2);
        ReadOnly = r102;
        CachePolicy r103 = new CachePolicy("WriteOnly", 3);
        WriteOnly = r103;
        CachePolicy[] r104 = {r100, r101, r102, r103};
        f426250a = r104;
        f426251b = EnumEntriesKt.enumEntries(r104);
    }

    public static CachePolicy[] values() {
        return (CachePolicy[]) f426250a.clone();
    }

    public static CachePolicy valueOf(String r100) {
        return (CachePolicy) a.a(CachePolicy.class, r100);
    }

    public CachePolicy(String r100, int r101) {
        super(r100, r101);
    }
}
