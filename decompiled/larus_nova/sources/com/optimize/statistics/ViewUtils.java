package com.optimize.statistics;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.LruCache;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes34.dex */
public class ViewUtils {
    private static final int LIMIT_CONTENT = 20;
    private static final int TAG_BANNERS = 84159247;
    private static Set<Integer> mBlackListId;
    private static SparseArray<String> mIdMap;
    private static LruCache<Class, String> sClassNameCache;

    public ViewUtils() {
    }

    private static String encryptContent(String r100) {
        return r100;
    }

    private static int getResourcePackageId(int r100) {
        return (r100 >>> 24) & 255;
    }

    static {
        sClassNameCache = new LruCache(100);
    }

    private static Activity findActivity(Context r100) {
        if ((r100 instanceof ContextWrapper) == true) goto L6;
        return null;
    L6:
        ContextWrapper r101 = (ContextWrapper) r100;
        if ((r101 instanceof Activity) == true) goto L13;
        r100 = r101.getBaseContext();
        if ((r100 instanceof ContextWrapper) == true) goto L6;
        return null;
    L13:
        return (Activity) r101;
    }

    private static String getFallbackIdString(int r100) {
        return "#" + Integer.toHexString(r100);
    }

    public static String getSimpleClassName(Class r100) {
        String r101 = sClassNameCache.get(r100);
        if (TextUtils.isEmpty(r101) == false) goto L8;
        r101 = r100.getSimpleName();
        if (TextUtils.isEmpty(r101) == false) goto L7;
        r101 = "Anonymous";
    L7:
        sClassNameCache.put(r100, r101);
    L8:
        return r101;
    }

    public static String getViewInfo(View r110) {
        ArrayList r100 = null;
        if (r110 != null) goto L5;
        return null;
    L5:
        Activity r101 = findActivity(r110.getContext());
        if (r101 != null) goto L8;
        return null;
    L8:
        ArrayList r102 = new ArrayList(8);
        ViewParent r103 = r110.getParent();
        r102.add(r110);
    L10:
        if ((r103 instanceof ViewGroup) == false) goto L12;
        r102.add((ViewGroup) r103);
        r103 = r103.getParent();
        goto L10
    L12:
        int r104 = r102.size() - 1;
        View r105 = (View) ListProtector.get(r102, r104);
        WindowHelper.init();
        String r106 = WindowHelper.getSubWindowPrefix(r105);
        if (WindowHelper.isDecorView(r105) == true) goto L20;
        if ((r105.getParent() instanceof View) == true) goto L20;
        r106 = r106 + HTTP.URL_DEFAULT + getSimpleClassName(r105.getClass());
        String r107 = getIdName(r105, false);
        if (r107 == null) goto L20;
        r106 = r106 + "#" + r107;
    L20:
        if ((r105 instanceof ViewGroup) == false) goto L74;
        ViewGroup r108 = (ViewGroup) r105;
        int r109 = r104 - 1;
        String r111 = r106;
    L22:
        if (r109 < 0) goto L74;
        View r112 = (View) ListProtector.get(r102, r109);
        String r113 = getSimpleClassName(r112.getClass());
        int r114 = r108.indexOfChild(r112);
        if (ClassHelper.instanceOfAndroidXViewPager(r108) == false) goto L27;
        r114 = ((ViewPager) r108).getCurrentItem();
    L38:
        if ((r108 instanceof ExpandableListView) == false) goto L53;
        ExpandableListView r115 = (ExpandableListView) r108;
        long r116 = r115.getExpandableListPosition(r114);
        ArrayList r117 = r102;
        if (ExpandableListView.getPackedPositionType(r116) == 2) goto L42;
        int r118 = ExpandableListView.getPackedPositionGroup(r116);
        int r119 = ExpandableListView.getPackedPositionChild(r116);
        if (r119 == (-1)) goto L50;
        if (r100 != null) goto L49;
        r100 = new ArrayList(4);
    L49:
        r100.add(String.valueOf(r118));
        r100.add(String.valueOf(r119));
        String r120 = r106 + "/ELVG[" + r118 + "]/ELVC[" + r119 + "]/" + r113 + "[0]";
        String r121 = r111 + "/ELVG[-]/ELVC[-]/" + r113 + "[0]";
    L69:
        r106 = r120;
        r111 = r121;
    L71:
        if ((r112 instanceof ViewGroup) == false) goto L74;
        r108 = (ViewGroup) r112;
        r109 = r109 - 1;
        r102 = r117;
        goto L22
    L50:
        if (r100 != null) goto L52;
        r100 = new ArrayList(4);
    L52:
        r100.add(String.valueOf(r118));
        r120 = r106 + "/ELVG[" + r118 + "]/" + r113 + "[0]";
        r121 = r111 + "/ELVG[-]/" + r113 + "[0]";
        goto L69
    L42:
        if (r114 >= r115.getHeaderViewsCount()) goto L44;
        r120 = r106 + "/ELH[" + r114 + "]/" + r113 + "[0]";
        r121 = r111 + "/ELH[" + r114 + "]/" + r113 + "[0]";
        goto L69
    L44:
        int r122 = r114 - (r115.getCount() - r115.getFooterViewsCount());
        r120 = r106 + "/ELF[" + r122 + "]/" + r113 + "[0]";
        r121 = r111 + "/ELF[" + r122 + "]/" + r113 + "[0]";
        goto L69
    L53:
        r117 = r102;
        if (isListView(r108) == false) goto L64;
        Object r123 = r108.getTag(TAG_BANNERS);
        if ((r123 instanceof List) == false) goto L60;
        List r124 = (List) r123;
        if (r124.size() <= 0) goto L60;
        r114 = calcBannerItemPosition(r124, r114);
        truncateContent((String) ListProtector.get(r124, r114));
    L60:
        if (r100 != null) goto L62;
        r100 = new ArrayList(4);
    L62:
        r100.add(String.valueOf(r114));
        r111 = r111 + HTTP.URL_DEFAULT + r113 + "[-]";
        r106 = r106 + HTTP.URL_DEFAULT + r113 + "[" + r114 + "]";
        goto L71
    L64:
        if (ClassHelper.instanceofAndroidXSwipeRefreshLayout(r108) == false) goto L66;
    L68:
        r120 = r106 + HTTP.URL_DEFAULT + r113 + "[0]";
        r121 = r111 + HTTP.URL_DEFAULT + r113 + "[0]";
        goto L69
    L66:
        if (ClassHelper.instanceOfSupportSwipeRefreshLayout(r108) == true) goto L68;
        r120 = r106 + HTTP.URL_DEFAULT + r113 + "[" + r114 + "]";
        r121 = r111 + HTTP.URL_DEFAULT + r113 + "[" + r114 + "]";
        goto L69
    L27:
        if (ClassHelper.instanceOfSupportViewPager(r108) == false) goto L30;
        r114 = ((ViewPager) r108).getCurrentItem();
        goto L38
    L30:
        if ((r108 instanceof AdapterView) == false) goto L33;
        r114 = r114 + ((AdapterView) r108).getFirstVisiblePosition();
        goto L38
    L33:
        if (ClassHelper.instanceOfRecyclerView(r108) == false) goto L38;
        int r125 = getChildAdapterPositionInRecyclerView(r112, r108);
        if (r125 < 0) goto L38;
        r114 = r125;
    L74:
        String r126 = r101.getClass().getSimpleName();
        return r126 + HTTP.URL_DEFAULT + r106 + "[" + getIdStringQuietly(r126, r110.getContext().getResources(), r110.getId()) + "]";
    }

    public static boolean isListView(View r100) {
        if ((r100 instanceof AdapterView) == false) goto L5;
    L14:
        return true;
    L5:
        if (ClassHelper.instanceOfAndroidXRecyclerView(r100) == true) goto L14;
        if (ClassHelper.instanceOfAndroidXViewPager(r100) == true) goto L14;
        if (ClassHelper.instanceOfSupportRecyclerView(r100) == true) goto L14;
        if (ClassHelper.instanceOfSupportViewPager(r100) == true) goto L14;
        return false;
    }

    public static String truncateContent(String r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if (TextUtils.isEmpty(r100) == true) goto L11;
        if (r100.length() <= 20) goto L11;
        r100 = r100.substring(0, 20);
    L11:
        return encryptContent(r100);
    }

    public static int calcBannerItemPosition(List r100, int r101) {
        return r101 % r100.size();
    }

    private static int getChildAdapterPositionInRecyclerView(View r100, ViewGroup r101) {
        if (ClassHelper.instanceOfAndroidXRecyclerView(r101) == false) goto L7;
        return ((RecyclerView) r101).getChildAdapterPosition(r100);
    L7:
        if (ClassHelper.instanceOfSupportRecyclerView(r101) == false) goto L13;
        return ((RecyclerView) r101).getChildAdapterPosition(r100);
    L11:
        return ((RecyclerView) r101).getChildPosition(r100);
    L13:
        if (ClassHelper.sHasCustomRecyclerView == true) goto L19;
        return -1;
    L19:
        return ClassHelper.invokeCRVGetChildAdapterPositionMethod(r101, r100);
    }

    public static String getIdName(View r100, boolean r101) {
        if (r101 == false) goto L6;
        return null;
    L6:
        if (mIdMap != null) goto L9;
        mIdMap = new SparseArray();
    L9:
        if (mBlackListId != null) goto L11;
        mBlackListId = new HashSet();
    L11:
        int r102 = r100.getId();
        if (r102 > 2130706432) goto L14;
    L21:
        return null;
    L14:
        if (mBlackListId.contains(Integer.valueOf(r102)) == true) goto L21;
        String r103 = mIdMap.get(r102);
        if (r103 == null) goto L22;
        return r103;
    L22:
        String r104 = r100.getResources().getResourceEntryName(r102);     // Catch: Exception -> L20
        mIdMap.put(r102, r104);     // Catch: Exception -> L20
        return r104;
    L20:
        mBlackListId.add(Integer.valueOf(r102));
        goto L21
    }

    public static String getIdString(Resources r100, int r101) throws Resources.NotFoundException {
        if (r100 != null) goto L6;
        return getFallbackIdString(r101);
    L6:
        if (getResourcePackageId(r101) == 127) goto L8;
        String r102 = r100.getResourcePackageName(r101);
        String r103 = ":";
    L9:
        String r104 = r100.getResourceTypeName(r101);
        String r105 = r100.getResourceEntryName(r101);
        StringBuilder r106 = new StringBuilder(((((r102.length() + 1) + r103.length()) + r104.length()) + 1) + r105.length());
        r106.append("@");
        r106.append(r102);
        r106.append(r103);
        r106.append(r104);
        r106.append(HTTP.URL_DEFAULT);
        r106.append(r105);
        return r106.toString();
    L8:
        r102 = "";
        r103 = "";
        goto L9
    }

    public static String getIdStringQuietly(Object r100, Resources r101, int r102) {
        return getIdString(r101, r102);
    L4:
        String r103 = getFallbackIdString(r102);
        Objects.toString(r100);
        return r103;
    }
}
