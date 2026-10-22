package com.bytedance.ee.bear.lynx.impl;

import com.larus.nova.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Pair<Integer, Integer>> f229870a = null;

    static {
        LinkedHashMap r100 = new LinkedHashMap();
        f229870a = r100;
        Integer r101 = Integer.valueOf(R.drawable.ud_icon_close_small_outlined);
        Integer r102 = Integer.valueOf(R.color.icon_n1);
        r100.put("ud_closeSmallOutlined_icon-n1", new Pair(r101, r102));
        Integer r103 = Integer.valueOf(R.drawable.ud_icon_list_check_bold_outlined);
        Integer r104 = Integer.valueOf(R.color.primary_fill_default);
        r100.put("ud_listCheckOutlined_primary-pri-500", new Pair(r103, r104));
        Integer r105 = Integer.valueOf(R.drawable.ud_icon_global_trianglesmall_outlined);
        Integer r106 = Integer.valueOf(R.color.icon_n2);
        r100.put("ud_globalTrianglesmallOutlined_icon-n2", new Pair(r105, r106));
        r100.put("ud_expandDownFilled_icon-n2", new Pair(Integer.valueOf(R.drawable.ud_icon_expand_down_filled), r106));
        r100.put("ud_addOutlined_icon-n2", new Pair(Integer.valueOf(R.drawable.ud_icon_add_outlined), r106));
        r100.put("ud_leftSmallCcmOutlined_icon-n1", new Pair(Integer.valueOf(R.drawable.ud_icon_left_small_ccm_outlined), r102));
        r100.put("ud_leftOutlined_icon-n1", new Pair(Integer.valueOf(R.drawable.ud_icon_left_outlined), r102));
        r100.put("ud_rightOutlined_icon-n3", new Pair(Integer.valueOf(R.drawable.ud_icon_right_outlined), r102));
        r100.put("ud_listCheckBoldOutlined_primary-pri-500", new Pair(r103, r104));
        r100.put("ud_searchOutlined_text-placeholder", new Pair(Integer.valueOf(R.drawable.ud_icon_search_outlined), Integer.valueOf(R.color.text_placeholder)));
        r100.put("ud_upOutlined_icon-n1", new Pair(Integer.valueOf(R.drawable.ud_icon_up_outlined), r102));
        r100.put("illustration_empty-neutral-no-schedule", new Pair(Integer.valueOf(R.drawable.ccm_empty_neutral_no_schedule), null));
    }
}
