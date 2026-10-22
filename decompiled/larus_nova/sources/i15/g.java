package i15;

import com.bytedance.ee.util.info.AppInfoUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class g {
    public static int a(int r100) {
        if (Boolean.TRUE.equals(AppInfoUtils.f()) == false) goto L27;
        if (r100 != R.drawable.ud_icon_file_word_colorful) goto L8;
        return R.drawable.ud_icon_file_word_v2_colorful;
    L8:
        if (r100 != R.drawable.ud_icon_file_pdf_colorful) goto L11;
        return R.drawable.ud_icon_file_pdf_v2_colorful;
    L11:
        if (r100 != R.drawable.ud_icon_file_image_colorful) goto L14;
        return R.drawable.ud_icon_file_image_v2_colorful;
    L14:
        if (r100 != R.drawable.ud_icon_file_md_colorful) goto L17;
        return R.drawable.ud_icon_file_md_v2_colorful;
    L17:
        if (r100 != R.drawable.ud_icon_file_text_colorful) goto L20;
        return R.drawable.ud_icon_file_text_v2_colorful;
    L20:
        if (r100 != R.drawable.ud_icon_file_excel_colorful) goto L23;
        return R.drawable.ud_icon_file_excel_v2_colorful;
    L23:
        if (r100 != R.drawable.ud_icon_file_ppt_colorful) goto L34;
        return R.drawable.ud_icon_file_ppt_v2_colorful;
    L34:
        return r100;
    L27:
        return kac.a.b(r100);
    }
}
