package com.ss.android.ttapkdiffpatch;

import com.larus.utils.logger.FLogger;
import com.ss.android.ttapkdiffpatch.applier.ApplyPatchFailException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class SoLoadUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f449817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f449818b;

    public static final enum SharedObject extends Enum<SharedObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SharedObject[] f449819a = null;
        public static final SharedObject hpatchz = null;
        boolean isLoaded;
        private final String libName;

        static {
            SharedObject r100 = new SharedObject();
            hpatchz = r100;
            f449819a = new SharedObject[]{r100};
        }

        public SharedObject() {
            super("hpatchz", 0);
            this.isLoaded = false;
            this.libName = "hpatchz";
        }

        public static SharedObject[] values() {
            return (SharedObject[]) f449819a.clone();
        }

        public static /* synthetic */ String access$100(SharedObject r100) {
            return r100.libName;
        }

        public static SharedObject valueOf(String r100) {
            return (SharedObject) r27.a.a(SharedObject.class, r100);
        }
    }

    public static class a implements b {
        public a() {
        }

        @JvmStatic
        public static void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "libName");
            FLogger r101 = FLogger.f375446a;
            r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
            com.bytedance.librarian.a.c(r100);
            r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
        }
    }

    public SoLoadUtils() {
        this.f449818b = null;
        this.f449817a = new a();
    }

    public final void a(SharedObject r100) throws ApplyPatchFailException {
        b r101 = this.f449817a;
        b r102 = this.f449818b;
        if (r102 == null) goto L6;
        r101 = r102;
    L6:
        if (r100.isLoaded == false) goto L28;
        return;
    L28:
        String r103 = SharedObject.access$100(r100);     // Catch: Throwable -> L24
        ((a) r101).getClass();     // Catch: Throwable -> L24
        boolean r104 = false;
        a.a(r103);     // Catch: Throwable -> L13
        boolean r105 = true;
    L14:
        if (r105 == true) goto L22;
        a r106 = this.f449817a;     // Catch: Throwable -> L24
        String r107 = SharedObject.access$100(r100);     // Catch: Throwable -> L24
        r106.getClass();     // Catch: Throwable -> L24
        a.a(r107);     // Catch: Throwable -> L27
        r104 = true;
    L18:
        if (r104 == true) goto L22;
        throw new ApplyPatchFailException(2004, "load hpatch so failed");     // Catch: Throwable -> L24
    L22:
        r100.isLoaded = true;
        return;
    L13:
        r105 = false;
    L24:
        th = move-exception;
        throw new ApplyPatchFailException(2004, th);
    }
}
