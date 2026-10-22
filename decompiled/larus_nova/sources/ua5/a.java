package ua5;

import android.text.TextUtils;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.larus.nova.R;
import rbb.b;
import rbb.e;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends b {
    public static int h(String r100) {
        if (r100 == null) goto L4;
        r100 = r100.toLowerCase();
    L4:
        String[] r101 = e.f537005a;
        int r102 = r101.length;
        int r103 = 0;
        int r104 = 0;
    L5:
        if (r104 >= r102) goto L10;
        if (TextUtils.equals(r101[r104], r100) == true) goto L139;
        r104 = r104 + 1;
        goto L5
    L139:
        return kac.a.b(R.drawable.ud_icon_file_round_image_colorful);
    L10:
        String[] r105 = e.f537006b;
        int r106 = r105.length;
        int r107 = 0;
    L11:
        if (r107 >= r106) goto L16;
        if (TextUtils.equals(r105[r107], r100) == true) goto L140;
        r107 = r107 + 1;
        goto L11
    L140:
        return kac.a.b(R.drawable.ud_icon_file_round_video_colorful);
    L16:
        String[] r108 = e.f537007c;
        int r109 = r108.length;
        int r110 = 0;
    L17:
        if (r110 >= r109) goto L23;
        if (TextUtils.equals(r108[r110], r100) == true) goto L141;
        r110 = r110 + 1;
        goto L17
    L141:
        return kac.a.b(R.drawable.ud_icon_file_round_audio_colorful);
    L23:
        if (TextUtils.equals(ExportFileExtension.PDF, r100) == true) goto L142;
        String[] r111 = e.f537008d;
        int r112 = r111.length;
        int r113 = 0;
    L26:
        if (r113 >= r112) goto L31;
        if (TextUtils.equals(r111[r113], r100) == true) goto L143;
        r113 = r113 + 1;
        goto L26
    L143:
        return kac.a.b(R.drawable.ud_icon_file_round_text_colorful);
    L31:
        String[] r114 = e.f537009e;
        int r115 = r114.length;
        int r116 = 0;
    L33:
        if (r116 >= r115) goto L38;
        if (TextUtils.equals(r114[r116], r100) == true) goto L144;
        r116 = r116 + 1;
        goto L33
    L144:
        return kac.a.b(R.drawable.ud_icon_file_round_code_colorful);
    L38:
        String[] r117 = e.f537010f;
        int r118 = r117.length;
        int r119 = 0;
    L39:
        if (r119 >= r118) goto L44;
        if (TextUtils.equals(r117[r119], r100) == true) goto L145;
        r119 = r119 + 1;
        goto L39
    L145:
        return kac.a.b(R.drawable.ud_icon_file_round_word_colorful);
    L44:
        String[] r120 = e.f537011g;
        int r121 = r120.length;
        int r122 = 0;
    L45:
        if (r122 >= r121) goto L50;
        if (TextUtils.equals(r120[r122], r100) == true) goto L146;
        r122 = r122 + 1;
        goto L45
    L146:
        return kac.a.b(R.drawable.ud_icon_file_round_excel_colorful);
    L50:
        String[] r123 = e.f537012h;
        int r124 = r123.length;
        int r125 = 0;
    L51:
        if (r125 >= r124) goto L57;
        if (TextUtils.equals(r123[r125], r100) == true) goto L147;
        r125 = r125 + 1;
        goto L51
    L147:
        return kac.a.b(R.drawable.ud_icon_file_round_ppt_colorful);
    L57:
        if (TextUtils.equals("pages", r100) == false) goto L60;
        return kac.a.b(R.drawable.ud_icon_file_round_pages_colorful);
    L60:
        if (TextUtils.equals("numbers", r100) == true) goto L149;
        String[] r126 = e.f537013i;
        int r127 = r126.length;
        int r128 = 0;
    L63:
        if (r128 >= r127) goto L68;
        if (TextUtils.equals(r126[r128], r100) == true) goto L150;
        r128 = r128 + 1;
        goto L63
    L150:
        return kac.a.b(R.drawable.ud_icon_file_round_keynote_colorful);
    L68:
        String[] r129 = e.f537014j;
        int r130 = r129.length;
        int r131 = 0;
    L69:
        if (r131 >= r130) goto L74;
        if (TextUtils.equals(r129[r131], r100) == true) goto L151;
        r131 = r131 + 1;
        goto L69
    L151:
        return kac.a.b(R.drawable.ud_icon_file_round_zip_colorful);
    L74:
        String[] r132 = e.f537015k;
        int r133 = r132.length;
        int r134 = 0;
    L75:
        if (r134 >= r133) goto L83;
        if (TextUtils.equals(r132[r134], r100) == true) goto L79;
        r134 = r134 + 1;
        goto L75
    L79:
        if (kac.a.a() == false) goto L81;
        return R.drawable.ud_icon_file_round_md_v2_colorful;
    L81:
        return R.drawable.ud_icon_file_round_code_colorful;
    L83:
        String[] r135 = e.f537016l;
        int r136 = r135.length;
    L84:
        if (r103 >= r136) goto L90;
        if (TextUtils.equals(r135[r103], r100) == true) goto L154;
        r103 = r103 + 1;
        goto L84
    L154:
        return kac.a.b(R.drawable.ud_icon_file_round_ps_colorful);
    L90:
        if (TextUtils.equals("ipa", r100) == false) goto L93;
        return kac.a.b(R.drawable.ud_icon_file_round_ios_colorful);
    L93:
        if (TextUtils.equals("apk", r100) == false) goto L96;
        return kac.a.b(R.drawable.ud_icon_file_round_android_colorful);
    L96:
        if (TextUtils.equals("aep", r100) == false) goto L99;
        return kac.a.b(R.drawable.ud_icon_file_round_ae_colorful);
    L99:
        if (TextUtils.equals("ai", r100) == false) goto L102;
        return kac.a.b(R.drawable.ud_icon_file_round_ai_colorful);
    L102:
        if (TextUtils.equals("sketch", r100) == false) goto L105;
        return kac.a.b(R.drawable.ud_icon_file_round_sketch_colorful);
    L105:
        if (TextUtils.equals("csv", r100) == false) goto L108;
        return kac.a.b(R.drawable.ud_icon_file_round_csv_colorful);
    L108:
        if (TextUtils.equals("eml", r100) == false) goto L111;
        return kac.a.b(R.drawable.ud_icon_file_round_eml_colorful);
    L111:
        if (TextUtils.equals("msg", r100) == false) goto L114;
        return kac.a.b(R.drawable.ud_icon_file_round_msg_colorful);
    L114:
        return kac.a.b(R.drawable.ud_icon_wiki_otherfile_circle_colorful);
    L149:
        return kac.a.b(R.drawable.ud_icon_file_round_numbers_colorful);
    L142:
        return kac.a.b(R.drawable.ud_icon_file_round_pdf_colorful);
    }

    public static int i(int r100) {
        if (r100 != sbb.e.f541296g.f541317b) goto L6;
        return kac.a.b(R.drawable.ud_icon_file_round_doc_colorful);
    L6:
        if (r100 != sbb.e.f541297h.f541317b) goto L9;
        return kac.a.b(R.drawable.ud_icon_file_round_sheet_colorful);
    L9:
        if (r100 != sbb.e.f541298i.f541317b) goto L12;
        return kac.a.b(R.drawable.ud_icon_file_round_bitable_colorful);
    L12:
        if (r100 != sbb.e.f541300k.f541317b) goto L15;
        return kac.a.b(R.drawable.ud_icon_file_round_mindnote_colorful);
    L15:
        if (r100 != sbb.e.f541302m.f541317b) goto L18;
        return kac.a.b(R.drawable.ud_icon_wiki_slides_circle_colorful);
    L18:
        if (r100 != sbb.e.f541304o.f541317b) goto L21;
        return kac.a.b(R.drawable.ud_icon_file_round_docx_colorful);
    L21:
        if (r100 != sbb.e.f541295f.f541317b) goto L24;
        return kac.a.b(R.drawable.ud_icon_file_folder_colorful);
    L24:
        if (r100 != sbb.e.f541314y.f541317b) goto L27;
        return kac.a.b(R.drawable.ud_icon_syncedblock_colorful);
    L27:
        if (r100 == sbb.e.f541309t.f541317b) goto L33;
        if (r100 == sbb.e.f541310u.f541317b) goto L33;
        return kac.a.b(R.drawable.ud_icon_file_round_unknow_colorful);
    L33:
        return kac.a.b(R.drawable.ud_icon_file_miaoda_colorful);
    }

    public static int j(int r100, String r101) {
        String r102 = va5.a.a(r101);
        if (r100 != sbb.e.f541301l.f541317b) goto L7;
        return h(com.bytedance.ee.util.io.a.c(r102));
    L7:
        return i(r100);
    }

    public static int k(int r100, String r101) {
        if (r100 != sbb.e.f541301l.f541317b) goto L7;
        return h(com.bytedance.ee.util.io.a.c(r101));
    L7:
        return i(r100);
    }

    public static int l(int r100, String r101) {
        String r102 = va5.a.a(r101);
        if (r100 != sbb.e.f541301l.f541317b) goto L7;
        return b.e(com.bytedance.ee.util.io.a.c(r102));
    L7:
        return b.c(r100, null);
    }
}
