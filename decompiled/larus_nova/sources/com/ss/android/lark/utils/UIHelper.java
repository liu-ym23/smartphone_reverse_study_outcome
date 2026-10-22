package com.ss.android.lark.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public class UIHelper {
    private static final String TAG = "UIHelper";

    public UIHelper() {
    }

    public static String getAppName() {
        return getString(R.string.Lark_App_Name);
    }

    public static Context getContext() {
        return LarkContext.getApplication();
    }

    public static Resources getResources() {
        return UIUtils.getResources(getContext());
    }

    public static int dp2px(float r100) {
        return UIUtils.dp2px(getContext(), r100);
    }

    public static int getColor(int r100) {
        return UIUtils.getColor(getContext(), r100);
    }

    public static int getDimens(int r100) {
        return UIUtils.getDimens(getContext(), r100);
    }

    public static Drawable getDrawable(int r100) {
        return UIUtils.getDrawable(getContext(), r100);
    }

    public static String getString(int r100) {
        if (LarkContext.getApplication() != null) goto L7;
        Log.e(TAG, "getString before application context injected");
        return "";
    L7:
        return UIUtils.getString(getContext(), r100);
    }

    public static String[] getStringArray(int r100) {
        return UIUtils.getStringArray(getContext(), r100);
    }

    public static int getWindowWidth(Context r100) {
        return DeviceUtils.getScreenWidth(r100);
    }

    public static View inflate(int r100) {
        return UIUtils.inflate(getContext(), r100);
    }

    public static String mustacheFormat(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        HashMap r101 = new HashMap(1);
        r101.put("APP_DISPLAY_NAME", getString(R.string.Lark_App_Name));
        return com.samskivert.mustache.e.a().b().a(r100).b(r101);
    L8:
        e = move-exception;
        Log.e(TAG, e.getMessage());
        return r100;
    }

    public static int px2dp(float r100) {
        return UIUtils.px2dp(getContext(), r100);
    }

    public static float sp2px(float r100) {
        return UIUtils.sp2px(getContext(), r100);
    }

    public static String mustacheFormat(int r100) {
        return mustacheFormat(UIUtils.getString(getContext(), r100));
    }

    public static String getQuantityString(int r100, int r101) {
        return UIUtils.getQuantityString(getContext(), r100, r101);
    }

    public static String getString(int r100, Object... r101) throws Resources.NotFoundException {
        return UIUtils.getString(getContext(), r100, r101);
    }

    public static View inflate(int r100, ViewGroup r101) {
        return UIUtils.inflate(getContext(), r100, r101);
    }

    public static String mustacheFormat(int r100, Map<String, String> r101) {
        String r102 = UIUtils.getString(getContext(), r100);
        if (TextUtils.isEmpty(r102) == false) goto L5;
    L11:
        return r102;
    L5:
        if (CollectionUtils.isEmpty(r101) == true) goto L11;
        return com.samskivert.mustache.e.a().b().a(r102).b(r101);
    L9:
        e = move-exception;
        Log.e(TAG, e.getMessage());
        goto L11
    }

    public static String mustacheFormat(String r100, Map<String, String> r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L11:
        return r100;
    L5:
        if (CollectionUtils.isEmpty(r101) == true) goto L11;
        return com.samskivert.mustache.e.a().b().a(r100).b(r101);
    L9:
        e = move-exception;
        Log.e(TAG, e.getMessage());
        goto L11
    }

    public static String mustacheFormat(int r100, String r101, String r102) {
        String r103 = UIUtils.getString(getContext(), r100);
        if (r101 == null) goto L11;
        if (r102 == null) goto L11;
        HashMap r104 = new HashMap(1);
        r104.put(r101, r102);
        return com.samskivert.mustache.e.a().b().a(r103).b(r104);
    L9:
        e = move-exception;
        Log.e(TAG, e.getMessage());
    L11:
        return r103;
    }

    public static String mustacheFormat(String r100, String r101, String r102) {
        if (r101 == null) goto L10;
        if (r102 == null) goto L10;
        HashMap r103 = new HashMap(1);
        r103.put(r101, r102);
        return com.samskivert.mustache.e.a().b().a(r100).b(r103);
    L8:
        e = move-exception;
        Log.e(TAG, e.getMessage());
    L10:
        return r100;
    }
}
