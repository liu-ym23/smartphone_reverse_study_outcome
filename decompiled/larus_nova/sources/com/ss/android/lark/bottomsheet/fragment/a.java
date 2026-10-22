package com.ss.android.lark.bottomsheet.fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, c> f410710a;

    /* JADX INFO: renamed from: com.ss.android.lark.bottomsheet.fragment.a$a, reason: collision with other inner class name */
    public static final class C4772a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f410711a;

        public b() {
            this(false);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.f410711a == ((b) r100).f410711a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f410711a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "FragmentConfig(statusBarImmersive=" + this.f410711a + ')';
        }

        public b(boolean r100) {
            this.f410711a = r100;
        }
    }

    public interface c {
        void a(Fragment r100);

        Integer b();

        void c(Context r100, Bundle r101);

        String clazz();

        b config();

        BottomSheetFrameFragment f();
    }

    static {
    }

    public a() {
        this.f410710a = new HashMap();
    }

    public final Pair<BottomSheetFrameFragment, b> a(Bundle r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.getBoolean("key_bottom_sheet_container_start") == true) goto L9;
        Log.e("BottomSheetFactory", "not start as bottom sheet style");
        return null;
    L9:
        String r101 = r100.getString("key_bottom_sheet_content_class");
        if (r101 != null) goto L13;
        Log.e("BottomSheetFactory", "load component class is null, no start target");
        return null;
    L13:
        c r102 = (c) ((HashMap) this.f410710a).get(r101);
        if (r102 != null) goto L17;
        Log.e("BottomSheetFactory", "loader is null, no start target");
        return null;
    L17:
        Bundle r103 = r100.getBundle("key_content_biz_bundle");
        if (r103 != null) goto L21;
        Log.e("BottomSheetFactory", "load target bundle is null, no start data");
        return null;
    L21:
        BottomSheetFrameFragment r104 = r102.f();
        r104.setArguments(r103);
        return TuplesKt.to(r104, r102.config());
    }
}
