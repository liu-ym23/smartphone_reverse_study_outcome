package kac;

import android.util.SparseIntArray;
import com.larksuite.component.universe_design.icon.UDIconDrawableMapping;
import com.larus.nova.R;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, Integer> f502198a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Boolean f502199b;

    static {
        Integer r100 = Integer.valueOf(R.drawable.ud_icon_file_doc_colorful);
        Integer r101 = Integer.valueOf(R.drawable.ud_icon_file_doc_v2_mini_colorful);
        f502198a = MapsKt.mapOf(new Pair[]{TuplesKt.to(r100, r101), TuplesKt.to(Integer.valueOf(R.drawable.ud_icon_file_sheet_colorful), Integer.valueOf(R.drawable.ud_icon_file_sheet_v2_mini_colorful)), TuplesKt.to(Integer.valueOf(R.drawable.ud_icon_file_mindnote_colorful), Integer.valueOf(R.drawable.ud_icon_file_mindnote_v2_mini_colorful)), TuplesKt.to(Integer.valueOf(R.drawable.ud_icon_file_colorful), Integer.valueOf(R.drawable.ud_icon_file_otherfile_v2_mini_colorful)), TuplesKt.to(Integer.valueOf(R.drawable.ud_icon_file_bitable_colorful), Integer.valueOf(R.drawable.ud_icon_file_bitable_v2_mini_colorful)), TuplesKt.to(Integer.valueOf(R.drawable.ud_icon_file_docx_colorful), r101), TuplesKt.to(Integer.valueOf(R.drawable.ud_icon_wiki_doc_colorful), r101), TuplesKt.to(Integer.valueOf(R.drawable.ud_icon_wiki_slides_colorful), Integer.valueOf(R.drawable.ud_icon_file_slides_v2_mini_colorful)), TuplesKt.to(Integer.valueOf(R.drawable.ud_icon_file_form_colorful), Integer.valueOf(R.drawable.ud_icon_file_form_v2_mini_colorful))});
    }

    public static boolean a() {
        Boolean r100 = f502199b;
        if (r100 != null) goto L5;
        boolean r101 = false;
        r101 = FeatureGatingModule.getFeatureGatingService().isEnable("lark.icon_sync_doubao.main", false);     // Catch: Throwable -> L10
    L8:
        f502199b = Boolean.valueOf(r101);
        return r101;
    L5:
        return r100.booleanValue();
    }

    @JvmStatic
    public static final int b(int r100) {
        if (r100 != 0) goto L4;
        return r100;
    L4:
        if (a() == true) goto L7;
        return r100;
    L7:
        if (r100 != R.drawable.icon_folder_avatar) goto L10;
        int r101 = R.drawable.ud_icon_file_folder_colorful;
    L16:
        int r102 = ((SparseIntArray) UDIconDrawableMapping.f285037a.getValue()).get(r101, r101);
        if (r102 != 0) goto L19;
        return r100;
    L19:
        return r102;
    L10:
        if (r100 != R.drawable.ud_icon_file_link_docx_outlined) goto L13;
        r101 = R.drawable.ud_icon_file_link_word_outlined;
        goto L16
    L13:
        if (r100 != R.drawable.ud_icon_copy_as_image_outlined) goto L15;
        r101 = R.drawable.ud_icon_file_link_image_shortcut_outlined;
        goto L16
    L15:
        r101 = r100;
        goto L16
    }
}
