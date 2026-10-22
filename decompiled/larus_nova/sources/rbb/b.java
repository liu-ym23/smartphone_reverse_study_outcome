package rbb;

import android.text.TextUtils;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes35.dex */
public class b {
    public static int g() {
        boolean r100 = mbb.c.f512807a;
        return kac.a.b(R.drawable.ud_icon_file_sharefolder_colorful);
    }

    public static int b(String r110) {
        if (TextUtils.isEmpty(r110) == false) goto L5;
        return R.color.ud_N100;
    L5:
        String[] r100 = e.f537005a;
        int r101 = r100.length;
        int r102 = 0;
        int r103 = 0;
    L6:
        if (r103 >= r101) goto L12;
        if (TextUtils.equals(r100[r103], r110) == true) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        return R.color.ud_Y50;
    L12:
        String[] r104 = e.f537006b;
        int r105 = r104.length;
        int r106 = 0;
    L14:
        if (r106 >= r105) goto L22;
        if (TextUtils.equals(r104[r106], r110) == true) goto L18;
        r106 = r106 + 1;
        goto L14
    L18:
        if (kac.a.a() == false) goto L20;
        return R.color.ud_W50;
    L20:
        return R.color.ud_B50;
    L22:
        String[] r107 = e.f537007c;
        int r108 = r107.length;
        int r109 = 0;
    L24:
        if (r109 >= r108) goto L33;
        if (TextUtils.equals(r107[r109], r110) == true) goto L28;
        r109 = r109 + 1;
        goto L24
    L28:
        if (kac.a.a() == false) goto L30;
        return R.color.ud_W50;
    L30:
        return R.color.ud_G50;
    L33:
        if (TextUtils.equals(ExportFileExtension.PDF, r110) == false) goto L36;
        return R.color.ud_R50;
    L36:
        String[] r111 = e.f537008d;
        int r112 = r111.length;
        int r113 = 0;
    L37:
        if (r113 >= r112) goto L42;
        if (TextUtils.equals(r111[r113], r110) == true) goto L40;
        r113 = r113 + 1;
        goto L37
    L40:
        return R.color.ud_B50;
    L42:
        String[] r114 = e.f537009e;
        int r115 = r114.length;
        int r116 = 0;
    L43:
        if (r116 >= r115) goto L51;
        if (TextUtils.equals(r114[r116], r110) == true) goto L47;
        r116 = r116 + 1;
        goto L43
    L47:
        if (kac.a.a() == false) goto L49;
        return R.color.ud_G50;
    L49:
        return R.color.ud_B50;
    L51:
        String[] r117 = e.f537010f;
        int r118 = r117.length;
        int r119 = 0;
    L52:
        if (r119 >= r118) goto L57;
        if (TextUtils.equals(r117[r119], r110) == true) goto L55;
        r119 = r119 + 1;
        goto L52
    L55:
        return R.color.ud_B50;
    L57:
        String[] r120 = e.f537011g;
        int r121 = r120.length;
        int r122 = 0;
    L58:
        if (r122 >= r121) goto L63;
        if (TextUtils.equals(r120[r122], r110) == true) goto L61;
        r122 = r122 + 1;
        goto L58
    L61:
        return R.color.ud_G50;
    L63:
        String[] r123 = e.f537012h;
        int r124 = r123.length;
        int r125 = 0;
    L65:
        if (r125 >= r124) goto L71;
        if (TextUtils.equals(r123[r125], r110) == true) goto L68;
        r125 = r125 + 1;
        goto L65
    L68:
        return R.color.ud_O50;
    L71:
        if (TextUtils.equals("pages", r110) == false) goto L74;
        return R.color.ud_O50;
    L74:
        if (TextUtils.equals("numbers", r110) == false) goto L76;
        return R.color.ud_G50;
    L76:
        String[] r126 = e.f537013i;
        int r127 = r126.length;
        int r128 = 0;
    L77:
        if (r128 >= r127) goto L82;
        if (TextUtils.equals(r126[r128], r110) == true) goto L80;
        r128 = r128 + 1;
        goto L77
    L80:
        return R.color.ud_B50;
    L82:
        String[] r129 = e.f537014j;
        int r130 = r129.length;
        int r131 = 0;
    L83:
        if (r131 >= r130) goto L91;
        if (TextUtils.equals(r129[r131], r110) == true) goto L87;
        r131 = r131 + 1;
        goto L83
    L87:
        if (kac.a.a() == false) goto L89;
        return R.color.ud_W50;
    L89:
        return R.color.ud_B50;
    L91:
        String[] r132 = e.f537015k;
        int r133 = r132.length;
        int r134 = 0;
    L92:
        if (r134 >= r133) goto L97;
        if (TextUtils.equals(r132[r134], r110) == true) goto L95;
        r134 = r134 + 1;
        goto L92
    L95:
        return R.color.ud_B50;
    L97:
        String[] r135 = e.f537016l;
        int r136 = r135.length;
    L98:
        if (r102 >= r136) goto L104;
        if (TextUtils.equals(r135[r102], r110) == true) goto L101;
        r102 = r102 + 1;
        goto L98
    L101:
        return R.color.ud_B50;
    L104:
        if (TextUtils.equals("ipa", r110) == false) goto L107;
        return R.color.ud_B50;
    L107:
        if (TextUtils.equals("apk", r110) == false) goto L110;
        return R.color.ud_G50;
    L110:
        if (TextUtils.equals("aep", r110) == false) goto L114;
        return R.color.ud_P50;
    L114:
        if (TextUtils.equals("ai", r110) == false) goto L117;
        return R.color.ud_O50;
    L117:
        if (TextUtils.equals("sketch", r110) == false) goto L120;
        return R.color.ud_O50;
    L120:
        if (TextUtils.equals("csv", r110) == false) goto L123;
        return R.color.ud_G50;
    L123:
        if (TextUtils.equals("eml", r110) == false) goto L126;
        return R.color.ud_B50;
    L126:
        if (TextUtils.equals("msg", r110) == false) goto L128;
        return R.color.ud_B50;
    L128:
        return R.color.ud_N100;
    }

    public static int d(int r100) {
        if (r100 != sbb.e.f541296g.f541317b) goto L7;
        return kac.a.b(R.drawable.ud_icon_wiki_doc_shortcut_outlined);
    L7:
        if (r100 != sbb.e.f541297h.f541317b) goto L11;
        return kac.a.b(R.drawable.ud_icon_wiki_sheet_shortcut_outlined);
    L11:
        if (r100 != sbb.e.f541298i.f541317b) goto L15;
        return kac.a.b(R.drawable.ud_icon_filelink_bitable_shortcut_outlined);
    L15:
        if (r100 != sbb.e.f541300k.f541317b) goto L19;
        return R.drawable.ud_icon_wiki_mindnote_shortcut_outlined;
    L19:
        if (r100 != sbb.e.f541302m.f541317b) goto L23;
        return kac.a.b(R.drawable.ud_icon_file_link_slides_shortcut_outlined);
    L23:
        if (r100 != sbb.e.f541304o.f541317b) goto L27;
        return kac.a.b(R.drawable.ud_icon_file_link_docx_shortcut_outlined);
    L27:
        if (r100 == sbb.e.f541309t.f541317b) goto L34;
        if (r100 == sbb.e.f541310u.f541317b) goto L34;
        return kac.a.b(R.drawable.ud_icon_file_link_unknow_shortcut_outlined);
    L34:
        return kac.a.b(R.drawable.ud_icon_file_link_otherfile_shortcut_outlined);
    }

    public static int e(String r100) {
        if (r100 == null) goto L4;
        r100 = r100.toLowerCase();
    L4:
        mbb.f r101 = mbb.c.f512808b;
        if (r101 == null) goto L9;
        Integer r102 = r101.a(r100);
        if (r102 == null) goto L9;
        Integer r103 = Integer.valueOf(kac.a.b(r102.intValue()));
    L10:
        if (r103 != null) goto L12;
    L15:
        String[] r104 = e.f537005a;
        int r105 = r104.length;
        int r106 = 0;
        int r107 = 0;
    L16:
        if (r107 >= r105) goto L22;
        if (TextUtils.equals(r104[r107], r100) == true) goto L20;
        r107 = r107 + 1;
        goto L16
    L20:
        return kac.a.b(R.drawable.ud_icon_file_image_colorful);
    L22:
        String[] r108 = e.f537006b;
        int r109 = r108.length;
        int r110 = 0;
    L23:
        if (r110 >= r109) goto L29;
        if (TextUtils.equals(r108[r110], r100) == true) goto L27;
        r110 = r110 + 1;
        goto L23
    L27:
        return kac.a.b(R.drawable.ud_icon_file_video_colorful);
    L29:
        String[] r111 = e.f537007c;
        int r112 = r111.length;
        int r113 = 0;
    L30:
        if (r113 >= r112) goto L37;
        if (TextUtils.equals(r111[r113], r100) == true) goto L34;
        r113 = r113 + 1;
        goto L30
    L34:
        return kac.a.b(R.drawable.ud_icon_file_audio_colorful);
    L37:
        if (TextUtils.equals(ExportFileExtension.PDF, r100) == true) goto L39;
        String[] r114 = e.f537008d;
        int r115 = r114.length;
        int r116 = 0;
    L41:
        if (r116 >= r115) goto L47;
        if (TextUtils.equals(r114[r116], r100) == true) goto L45;
        r116 = r116 + 1;
        goto L41
    L45:
        return kac.a.b(R.drawable.ud_icon_file_text_colorful);
    L47:
        String[] r117 = e.f537009e;
        int r118 = r117.length;
        int r119 = 0;
    L49:
        if (r119 >= r118) goto L55;
        if (TextUtils.equals(r117[r119], r100) == true) goto L53;
        r119 = r119 + 1;
        goto L49
    L53:
        return kac.a.b(R.drawable.ud_icon_file_code_colorful);
    L55:
        String[] r120 = e.f537010f;
        int r121 = r120.length;
        int r122 = 0;
    L56:
        if (r122 >= r121) goto L62;
        if (TextUtils.equals(r120[r122], r100) == true) goto L60;
        r122 = r122 + 1;
        goto L56
    L60:
        return kac.a.b(R.drawable.ud_icon_file_word_colorful);
    L62:
        String[] r123 = e.f537011g;
        int r124 = r123.length;
        int r125 = 0;
    L63:
        if (r125 >= r124) goto L69;
        if (TextUtils.equals(r123[r125], r100) == true) goto L67;
        r125 = r125 + 1;
        goto L63
    L67:
        return kac.a.b(R.drawable.ud_icon_file_excel_colorful);
    L69:
        String[] r126 = e.f537012h;
        int r127 = r126.length;
        int r128 = 0;
    L70:
        if (r128 >= r127) goto L77;
        if (TextUtils.equals(r126[r128], r100) == true) goto L74;
        r128 = r128 + 1;
        goto L70
    L74:
        return kac.a.b(R.drawable.ud_icon_file_ppt_colorful);
    L77:
        if (TextUtils.equals("pages", r100) == false) goto L81;
        return kac.a.b(R.drawable.ud_icon_file_pages_colorful);
    L81:
        if (TextUtils.equals("numbers", r100) == true) goto L83;
        String[] r129 = e.f537013i;
        int r130 = r129.length;
        int r131 = 0;
    L85:
        if (r131 >= r130) goto L91;
        if (TextUtils.equals(r129[r131], r100) == true) goto L89;
        r131 = r131 + 1;
        goto L85
    L89:
        return kac.a.b(R.drawable.ud_icon_file_keynote_colorful);
    L91:
        String[] r132 = e.f537014j;
        int r133 = r132.length;
        int r134 = 0;
    L92:
        if (r134 >= r133) goto L98;
        if (TextUtils.equals(r132[r134], r100) == true) goto L96;
        r134 = r134 + 1;
        goto L92
    L96:
        return kac.a.b(R.drawable.ud_icon_file_zip_colorful);
    L98:
        String[] r135 = e.f537015k;
        int r136 = r135.length;
        int r137 = 0;
    L99:
        if (r137 >= r136) goto L107;
        if (TextUtils.equals(r135[r137], r100) == true) goto L103;
        r137 = r137 + 1;
        goto L99
    L103:
        if (kac.a.a() == false) goto L172;
        return R.drawable.ud_icon_file_md_v2_colorful;
    L172:
        return R.drawable.ud_icon_file_code_colorful;
    L107:
        String[] r138 = e.f537016l;
        int r139 = r138.length;
    L108:
        if (r106 >= r139) goto L115;
        if (TextUtils.equals(r138[r106], r100) == true) goto L112;
        r106 = r106 + 1;
        goto L108
    L112:
        return kac.a.b(R.drawable.ud_icon_file_ps_colorful);
    L115:
        if (TextUtils.equals("ipa", r100) == false) goto L119;
        return kac.a.b(R.drawable.ud_icon_file_ios_colorful);
    L119:
        if (TextUtils.equals("apk", r100) == false) goto L123;
        return kac.a.b(R.drawable.ud_icon_file_android_colorful);
    L123:
        if (TextUtils.equals("aep", r100) == false) goto L127;
        return kac.a.b(R.drawable.ud_icon_file_ae_colorful);
    L127:
        if (TextUtils.equals("ai", r100) == false) goto L131;
        return kac.a.b(R.drawable.ud_icon_file_ai_colorful);
    L131:
        if (TextUtils.equals("sketch", r100) == false) goto L135;
        return kac.a.b(R.drawable.ud_icon_file_sketch_colorful);
    L135:
        if (TextUtils.equals("csv", r100) == false) goto L139;
        return kac.a.b(R.drawable.ud_icon_file_csv_colorful);
    L139:
        if (TextUtils.equals("eml", r100) == false) goto L143;
        return kac.a.b(R.drawable.ud_icon_file_eml_colorful);
    L143:
        if (TextUtils.equals("msg", r100) == false) goto L147;
        return kac.a.b(R.drawable.ud_icon_file_msg_colorful);
    L147:
        return kac.a.b(R.drawable.ud_icon_wiki_otherfile_colorful);
    L83:
        return kac.a.b(R.drawable.ud_icon_file_numbers_colorful);
    L39:
        return kac.a.b(R.drawable.ud_icon_file_pdf_colorful);
    L12:
        if (r103.intValue() == 0) goto L15;
        return r103.intValue();
    L9:
        r103 = null;
        goto L10
    }

    public static int f(String r100) {
        if (r100 == null) goto L4;
        r100 = r100.toLowerCase();
    L4:
        mbb.g r101 = mbb.c.f512809c;
        if (r101 == null) goto L9;
        Integer r102 = r101.a(r100);
        if (r102 == null) goto L9;
        Integer r103 = Integer.valueOf(kac.a.b(r102.intValue()));
    L10:
        if (r103 != null) goto L12;
    L15:
        String[] r104 = e.f537005a;
        int r105 = r104.length;
        int r106 = 0;
        int r107 = 0;
    L16:
        if (r107 >= r105) goto L22;
        if (TextUtils.equals(r104[r107], r100) == true) goto L20;
        r107 = r107 + 1;
        goto L16
    L20:
        return kac.a.b(R.drawable.ud_icon_file_link_image_outlined);
    L22:
        String[] r108 = e.f537006b;
        int r109 = r108.length;
        int r110 = 0;
    L23:
        if (r110 >= r109) goto L29;
        if (TextUtils.equals(r108[r110], r100) == true) goto L27;
        r110 = r110 + 1;
        goto L23
    L27:
        return kac.a.b(R.drawable.ud_icon_file_link_video_outlined);
    L29:
        String[] r111 = e.f537007c;
        int r112 = r111.length;
        int r113 = 0;
    L30:
        if (r113 >= r112) goto L37;
        if (TextUtils.equals(r111[r113], r100) == true) goto L34;
        r113 = r113 + 1;
        goto L30
    L34:
        return kac.a.b(R.drawable.ud_icon_file_link_audio_outlined);
    L37:
        if (TextUtils.equals(ExportFileExtension.PDF, r100) == true) goto L39;
        String[] r114 = e.f537008d;
        int r115 = r114.length;
        int r116 = 0;
    L41:
        if (r116 >= r115) goto L47;
        if (TextUtils.equals(r114[r116], r100) == true) goto L45;
        r116 = r116 + 1;
        goto L41
    L45:
        return kac.a.b(R.drawable.ud_icon_file_link_text_outlined);
    L47:
        String[] r117 = e.f537009e;
        int r118 = r117.length;
        int r119 = 0;
    L49:
        if (r119 >= r118) goto L55;
        if (TextUtils.equals(r117[r119], r100) == true) goto L53;
        r119 = r119 + 1;
        goto L49
    L53:
        return kac.a.b(R.drawable.ud_icon_file_code_outlined);
    L55:
        String[] r120 = e.f537010f;
        int r121 = r120.length;
        int r122 = 0;
    L56:
        if (r122 >= r121) goto L62;
        if (TextUtils.equals(r120[r122], r100) == true) goto L60;
        r122 = r122 + 1;
        goto L56
    L60:
        return kac.a.b(R.drawable.ud_icon_file_link_word2_outlined);
    L62:
        String[] r123 = e.f537011g;
        int r124 = r123.length;
        int r125 = 0;
    L63:
        if (r125 >= r124) goto L69;
        if (TextUtils.equals(r123[r125], r100) == true) goto L67;
        r125 = r125 + 1;
        goto L63
    L67:
        return kac.a.b(R.drawable.ud_icon_file_link_excel_outlined);
    L69:
        String[] r126 = e.f537012h;
        int r127 = r126.length;
        int r128 = 0;
    L70:
        if (r128 >= r127) goto L77;
        if (TextUtils.equals(r126[r128], r100) == true) goto L74;
        r128 = r128 + 1;
        goto L70
    L74:
        return kac.a.b(R.drawable.ud_icon_file_link_ppt_outlined);
    L77:
        if (TextUtils.equals("pages", r100) == false) goto L81;
        return kac.a.b(R.drawable.ud_icon_file_pages_outlined);
    L81:
        if (TextUtils.equals("numbers", r100) == true) goto L83;
        String[] r129 = e.f537013i;
        int r130 = r129.length;
        int r131 = 0;
    L85:
        if (r131 >= r130) goto L91;
        if (TextUtils.equals(r129[r131], r100) == true) goto L89;
        r131 = r131 + 1;
        goto L85
    L89:
        return kac.a.b(R.drawable.ud_icon_file_keynote_outlined);
    L91:
        String[] r132 = e.f537014j;
        int r133 = r132.length;
        int r134 = 0;
    L92:
        if (r134 >= r133) goto L98;
        if (TextUtils.equals(r132[r134], r100) == true) goto L96;
        r134 = r134 + 1;
        goto L92
    L96:
        return kac.a.b(R.drawable.ud_icon_file_link_zip_outlined);
    L98:
        String[] r135 = e.f537015k;
        int r136 = r135.length;
        int r137 = 0;
    L99:
        if (r137 >= r136) goto L107;
        if (TextUtils.equals(r135[r137], r100) == true) goto L103;
        r137 = r137 + 1;
        goto L99
    L103:
        if (kac.a.a() == false) goto L172;
        return R.drawable.ud_icon_file_md_v2_outlined;
    L172:
        return R.drawable.ud_icon_file_code_outlined;
    L107:
        String[] r138 = e.f537016l;
        int r139 = r138.length;
    L108:
        if (r106 >= r139) goto L115;
        if (TextUtils.equals(r138[r106], r100) == true) goto L112;
        r106 = r106 + 1;
        goto L108
    L112:
        return kac.a.b(R.drawable.ud_icon_file_ps_outlined);
    L115:
        if (TextUtils.equals("ipa", r100) == false) goto L119;
        return kac.a.b(R.drawable.ud_icon_file_ios_outlined);
    L119:
        if (TextUtils.equals("apk", r100) == false) goto L123;
        return kac.a.b(R.drawable.ud_icon_file_android_outlined);
    L123:
        if (TextUtils.equals("aep", r100) == false) goto L127;
        return kac.a.b(R.drawable.ud_icon_file_ae_outlined);
    L127:
        if (TextUtils.equals("ai", r100) == false) goto L131;
        return kac.a.b(R.drawable.ud_icon_file_ai_outlined);
    L131:
        if (TextUtils.equals("sketch", r100) == false) goto L135;
        return kac.a.b(R.drawable.ud_icon_file_sketch_outlined);
    L135:
        if (TextUtils.equals("csv", r100) == false) goto L139;
        return kac.a.b(R.drawable.ud_icon_file_csv_outlined);
    L139:
        if (TextUtils.equals("eml", r100) == false) goto L143;
        return kac.a.b(R.drawable.ud_icon_file_eml_outlined);
    L143:
        if (TextUtils.equals("msg", r100) == false) goto L147;
        return kac.a.b(R.drawable.ud_icon_file_msg_outlined);
    L147:
        return kac.a.b(R.drawable.ud_icon_file_link_otherfile_outlined);
    L83:
        return kac.a.b(R.drawable.ud_icon_file_numbers_outlined);
    L39:
        return kac.a.b(R.drawable.ud_icon_file_link_pdf_outlined);
    L12:
        if (r103.intValue() == 0) goto L15;
        return r103.intValue();
    L9:
        r103 = null;
        goto L10
    }

    public static int a(int r100, Long r101) {
        if (r100 != sbb.e.f541296g.f541317b) goto L5;
    L38:
        return R.color.ud_B50;
    L5:
        if (r100 == sbb.e.f541304o.f541317b) goto L38;
        if (r100 == sbb.e.f541314y.f541317b) goto L38;
        if (r100 != sbb.e.f541297h.f541317b) goto L14;
        return R.color.ud_G50;
    L14:
        if (r100 != sbb.e.f541298i.f541317b) goto L20;
        if (kac.a.a() == false) goto L39;
        return R.color.ud_P50;
    L39:
        return R.color.ud_N100;
    L20:
        if (r100 != sbb.e.f541300k.f541317b) goto L23;
        return R.color.ud_W50;
    L23:
        if (r100 != sbb.e.f541302m.f541317b) goto L27;
        return R.color.ud_O50;
    L27:
        if (r100 != sbb.e.f541309t.f541317b) goto L35;
        if (r101 != null) goto L30;
    L32:
        return R.color.ud_W50;
    L30:
        if (r101.longValue() != 147) goto L32;
        return R.color.ud_B50;
    L35:
        if (r100 != sbb.e.f541310u.f541317b) goto L37;
        return R.color.ud_W50;
    L37:
        return R.color.ud_N100;
    }

    public static int c(int r100, Long r101) {
        mbb.d r102 = mbb.c.f512810d;
        if (r102 == null) goto L7;
        Integer r103 = r102.a(r100, r101);
        if (r103 == null) goto L7;
        Integer r104 = Integer.valueOf(kac.a.b(r103.intValue()));
    L8:
        if (r104 == null) goto L14;
        if (r104.intValue() == 0) goto L14;
        return kac.a.b(r104.intValue());
    L14:
        if (r100 != sbb.e.f541296g.f541317b) goto L18;
        return kac.a.b(R.drawable.ud_icon_file_doc_colorful);
    L18:
        if (r100 != sbb.e.f541297h.f541317b) goto L22;
        return kac.a.b(R.drawable.ud_icon_wiki_sheet_colorful);
    L22:
        if (r100 != sbb.e.f541298i.f541317b) goto L30;
        if (idb.f.a().isEnable("ccm.bitable.use_new_gradation_logo_enable") == false) goto L27;
        return R.drawable.ud_icon_logo_gradient_base_colorful;
    L27:
        return R.drawable.purple_base;
    L30:
        if (r100 != sbb.e.f541300k.f541317b) goto L34;
        return kac.a.b(R.drawable.ud_icon_file_mindnote_colorful);
    L34:
        if (r100 != sbb.e.f541302m.f541317b) goto L38;
        return kac.a.b(R.drawable.ud_icon_wiki_slides_colorful);
    L38:
        if (r100 != sbb.e.f541304o.f541317b) goto L42;
        return kac.a.b(R.drawable.ud_icon_file_docx_colorful);
    L42:
        if (r100 != sbb.e.f541314y.f541317b) goto L46;
        return kac.a.b(R.drawable.ud_icon_syncedblock_colorful);
    L46:
        if (r100 != sbb.e.f541309t.f541317b) goto L55;
        if (r101 == null) goto L53;
        if (r101.longValue() != 147) goto L53;
        return kac.a.b(R.drawable.ud_icon_file_website_colorful);
    L53:
        return kac.a.b(R.drawable.ud_icon_file_miaoda_colorful);
    L55:
        if (r100 != sbb.e.f541310u.f541317b) goto L59;
        return kac.a.b(R.drawable.ud_icon_file_miaoda_colorful);
    L59:
        return kac.a.b(R.drawable.ud_icon_wiki_otherfile_circle_colorful);
    L7:
        r104 = null;
        goto L8
    }
}
