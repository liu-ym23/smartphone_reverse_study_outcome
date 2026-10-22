package lta;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f510716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f510717b = null;

    public static class a extends pta.e<SharedPreferences> {
        public a() {
        }

        @Override // pta.e
        public final SharedPreferences a(Object[] r100) {
            return ((Context) r100[0]).getSharedPreferences("ug_install_settings_pref", 0);
        }
    }

    static {
        f510717b = new a();
    }
}
