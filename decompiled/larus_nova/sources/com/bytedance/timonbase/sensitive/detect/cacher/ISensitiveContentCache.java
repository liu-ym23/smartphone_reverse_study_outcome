package com.bytedance.timonbase.sensitive.detect.cacher;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public interface ISensitiveContentCache {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/timonbase/sensitive/detect/cacher/ISensitiveContentCache$Type;", "", "DEFAULT", "CLIPBOARD", HTTP.LOCATION, "STORAGE", "STORAGE_B", "STORAGE_KB", "STORAGE_MB", "STORAGE_FREE_B", "STORAGE_FREE_KB", "STORAGE_FREE_MB", "APPLIST", "FIRST_INSTALL_TIME", "LAST_UPDATE_TIME", "timonbase_release"}, k = 1, mv = {1, 4, 0})
    public static final enum Type extends Enum<Type> {
        public static final Type APPLIST = null;
        public static final Type CLIPBOARD = null;
        public static final Type DEFAULT = null;
        public static final Type FIRST_INSTALL_TIME = null;
        public static final Type LAST_UPDATE_TIME = null;
        public static final Type LOCATION = null;
        public static final Type STORAGE = null;
        public static final Type STORAGE_B = null;
        public static final Type STORAGE_FREE_B = null;
        public static final Type STORAGE_FREE_KB = null;
        public static final Type STORAGE_FREE_MB = null;
        public static final Type STORAGE_KB = null;
        public static final Type STORAGE_MB = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f270899a = null;

        static {
            Type r100 = new Type("DEFAULT", 0);
            DEFAULT = r100;
            Type r101 = new Type("CLIPBOARD", 1);
            CLIPBOARD = r101;
            Type r102 = new Type(HTTP.LOCATION, 2);
            LOCATION = r102;
            Type r103 = new Type("STORAGE", 3);
            STORAGE = r103;
            Type r104 = new Type("STORAGE_B", 4);
            STORAGE_B = r104;
            Type r105 = new Type("STORAGE_KB", 5);
            STORAGE_KB = r105;
            Type r106 = new Type("STORAGE_MB", 6);
            STORAGE_MB = r106;
            Type r107 = new Type("STORAGE_FREE_B", 7);
            STORAGE_FREE_B = r107;
            Type r108 = new Type("STORAGE_FREE_KB", 8);
            STORAGE_FREE_KB = r108;
            Type r109 = new Type("STORAGE_FREE_MB", 9);
            STORAGE_FREE_MB = r109;
            Type r110 = new Type("APPLIST", 10);
            APPLIST = r110;
            Type r111 = new Type("FIRST_INSTALL_TIME", 11);
            FIRST_INSTALL_TIME = r111;
            Type r112 = new Type("LAST_UPDATE_TIME", 12);
            LAST_UPDATE_TIME = r112;
            f270899a = new Type[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112};
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        public static Type[] values() {
            return (Type[]) f270899a.clone();
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    void a();
}
