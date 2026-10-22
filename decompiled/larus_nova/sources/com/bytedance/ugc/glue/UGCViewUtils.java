package com.bytedance.ugc.glue;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes22.dex */
public final class UGCViewUtils {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static a f272382a;

        public static a a() {
            if (f272382a != null) goto L8;
            int r100 = ep7.a.f473437a;
            if (f272382a != null) goto L8;
            f272382a = new a();
        L8:
            return f272382a;
        }

        public a() {
        }

        public Activity getActivity(View r100) {
            Activity r101 = null;
        L3:
            if (r100 == null) goto L11;
            r101 = getActivity(r100.getContext());
            if (r101 != null) goto L11;
            Object r102 = r100.getParent();
            if ((r102 instanceof View) == true) goto L9;
            r100 = null;
            goto L3
        L9:
            r100 = (View) r102;
        L11:
            return r101;
        }

        public Activity getActivity(Context r100) {
            if ((r100 instanceof Activity) == true) goto L5;
            return null;
        L5:
            return (Activity) r100;
        }
    }

    public UGCViewUtils() {
    }

    public static Activity getActivity(Context r100) {
        return a.a().getActivity(r100);
    }

    public static String getDiggText(int r100) {
        a.a().getClass();
        return String.valueOf(String.valueOf(r100));
    }

    public static String getDisplayNum(int r100) {
        a r101 = a.a();
        String r102 = String.valueOf(r100);
        r101.getClass();
        return String.valueOf(r102);
    }

    public static FragmentActivity getFragmentActivity(View r100) {
        Activity r101 = getActivity(r100);
        if ((r101 instanceof FragmentActivity) == true) goto L5;
        return null;
    L5:
        return (FragmentActivity) r101;
    }

    public static Activity getActivity(View r100) {
        return a.a().getActivity(r100);
    }

    public static String getDisplayNum(String r100) {
        a.a().getClass();
        return String.valueOf(r100);
    }
}
