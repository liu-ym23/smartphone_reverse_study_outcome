package com.bytedance.locallife.cube.preload;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/locallife/cube/preload/Type;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "FromLocal", "FromLocalAndUpdate", "ForceUpdate", "DownloadIfNotExist", "cube-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum Type extends Enum<Type> {
    public static final a Companion = null;
    public static final Type DownloadIfNotExist = null;
    public static final Type ForceUpdate = null;
    public static final Type FromLocal = null;
    public static final Type FromLocalAndUpdate = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Type[] f257259a = null;

    public static Type valueOf(String r100) {
        return (Type) r27.a.a(Type.class, r100);
    }

    public static Type[] values() {
        return (Type[]) f257259a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.locallife.cube.preload.Type$a] */
    static {
        Type r100 = new Type("FromLocal", 0);
        FromLocal = r100;
        Type r101 = new Type("FromLocalAndUpdate", 1);
        FromLocalAndUpdate = r101;
        Type r102 = new Type("ForceUpdate", 2);
        ForceUpdate = r102;
        Type r103 = new Type("DownloadIfNotExist", 3);
        DownloadIfNotExist = r103;
        f257259a = new Type[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public Type(String r100, int r101) {
        super(r100, r101);
    }
}
