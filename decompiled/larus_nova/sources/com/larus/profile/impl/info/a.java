package com.larus.profile.impl.info;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f366608c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f366609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f366610b;

    /* JADX INFO: renamed from: com.larus.profile.impl.info.a$a, reason: collision with other inner class name */
    public static final class C4475a {
        public static a a(Bundle r100, FragmentActivity r101) {
            cy9.a.f465949a.getClass();
            if (cy9.a.e(r100) == false) goto L5;
        L8:
            boolean r102 = true;
        L10:
            return new a(r102, cy9.a.h(r100));
        L5:
            if (cy9.a.d(r101) == true) goto L8;
            r102 = false;
            goto L10
        }
    }

    static {
    }

    public a(boolean r100, boolean r101) {
        this.f366609a = r100;
        this.f366610b = r101;
    }
}
