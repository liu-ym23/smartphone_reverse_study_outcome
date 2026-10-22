package com.ss.android.lark.inline.ai;

import com.larus.nova.R;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Integer> f427240a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f427241b = 0;

    static {
        f427240a = MapsKt.mapOf(new Pair[]{TuplesKt.to("CcmEditContinueOutlined", Integer.valueOf(R.drawable.ud_icon_ccm_edit_continue_outlined)), TuplesKt.to("MaybeOutlined", Integer.valueOf(R.drawable.ud_icon_maybe_outlined)), TuplesKt.to("TodoOutlined", Integer.valueOf(R.drawable.ud_icon_todo_outlined)), TuplesKt.to("SlidesAnimationOutlined", Integer.valueOf(R.drawable.ud_icon_slides_animation_outlined)), TuplesKt.to("EffectsOutlined", Integer.valueOf(R.drawable.ud_icon_effects_outlined)), TuplesKt.to("AddexpandOutlined", Integer.valueOf(R.drawable.ud_icon_addexpand_outlined)), TuplesKt.to("AbbreviationOutlined", Integer.valueOf(R.drawable.ud_icon_abbreviation_outlined)), TuplesKt.to("EditDiscriptionOutlined", Integer.valueOf(R.drawable.ud_icon_edit_discription_outlined)), TuplesKt.to("NopictureFilled", Integer.valueOf(R.drawable.ud_icon_nopicture_filled)), TuplesKt.to("TranslateOutlined", Integer.valueOf(R.drawable.ud_icon_translate_outlined)), TuplesKt.to("AdminMultistageOutlined", Integer.valueOf(R.drawable.ud_icon_admin_multistage_outlined)), TuplesKt.to("EfficiencyOutlined", Integer.valueOf(R.drawable.ud_icon_efficiency_outlined)), TuplesKt.to("CcmEditOutlined", Integer.valueOf(R.drawable.ud_icon_ccm_edit_outlined)), TuplesKt.to("AddOutlined", Integer.valueOf(R.drawable.ud_icon_add_outlined)), TuplesKt.to("FileLinkFormOutlined", Integer.valueOf(R.drawable.ud_icon_file_link_form_outlined)), TuplesKt.to("TaskAddOutlined", Integer.valueOf(R.drawable.ud_icon_task_add_outlined)), TuplesKt.to("MoreOutlined", Integer.valueOf(R.drawable.ud_icon_more_outlined)), TuplesKt.to("HistoryOutlined", Integer.valueOf(R.drawable.ud_icon_history_outlined)), TuplesKt.to("DataSheetOutlined", Integer.valueOf(R.drawable.ud_icon_data_sheet_outlined))});
        f427241b = R.drawable.ud_icon_ccm_edit_continue_outlined;
    }

    public static int a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "icon");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L14;
        Integer r102 = f427240a.get(r100);
        if (r102 == null) goto L11;
        int r103 = r102.intValue();
    L13:
        return kac.a.b(r103);
    L11:
        r103 = f427241b;
        goto L13
    L14:
        return 0;
    L5:
        r101 = false;
        goto L6
    }
}
