package com.bytedance.ee.bear.wikiv2.sidebar.icon;

import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.larus.nova.R;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Triple;
import sbb.e;

/* JADX INFO: loaded from: classes18.dex */
public final class SidebarIcon {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<SidebarIcon> f241259b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Triple<Integer, Integer, Integer>> f241260a;

    public static final class a {
    }

    static {
        f241259b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, SidebarIcon$Companion$instance$2.INSTANCE);
    }

    public SidebarIcon() {
        this.f241260a = new HashMap();
        a();
    }

    public final void a() {
        Map<String, Triple<Integer, Integer, Integer>> r100 = this.f241260a;
        e r101 = e.f541304o;
        Boolean r102 = Boolean.TRUE;
        String r103 = va5.a.b(new Object[]{Integer.valueOf(r101.h()), r102, r102});
        Integer r110 = Integer.valueOf(R.drawable.ud_icon_file_docx_colorful);
        Integer r111 = Integer.valueOf(R.drawable.ud_icon_wiki_shortcutarrow_colorful);
        r100.put(r103, new Triple(r110, r111, 0));
        Map<String, Triple<Integer, Integer, Integer>> r104 = this.f241260a;
        Boolean r105 = Boolean.FALSE;
        r104.put(va5.a.b(new Object[]{Integer.valueOf(r101.h()), r102, r105}), new Triple(r110, r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r101.h()), r105, r102}), new Triple(r110, 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r101.h()), r105, r105}), new Triple(r110, 0, 0));
        Map<String, Triple<Integer, Integer, Integer>> r106 = this.f241260a;
        e r107 = e.f541296g;
        String r108 = va5.a.b(new Object[]{Integer.valueOf(r107.h()), r102, r102});
        Integer r112 = Integer.valueOf(R.drawable.ud_icon_file_doc_colorful);
        r106.put(r108, new Triple(r112, r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r107.h()), r102, r105}), new Triple(r112, r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r107.h()), r105, r102}), new Triple(r112, 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r107.h()), r105, r105}), new Triple(r112, 0, 0));
        Map<String, Triple<Integer, Integer, Integer>> r109 = this.f241260a;
        e r113 = e.f541297h;
        r109.put(va5.a.b(new Object[]{Integer.valueOf(r113.h()), r102, r102}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_sheet_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r113.h()), r102, r105}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_sheet_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r113.h()), r105, r102}), new Triple(Integer.valueOf(R.drawable.ud_icon_wiki_sheet_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r113.h()), r105, r105}), new Triple(Integer.valueOf(R.drawable.ud_icon_wiki_sheet_colorful), 0, 0));
        Map<String, Triple<Integer, Integer, Integer>> r114 = this.f241260a;
        e r115 = e.f541300k;
        String r116 = va5.a.b(new Object[]{Integer.valueOf(r115.h()), r102, r102});
        Integer r117 = Integer.valueOf(R.drawable.ud_icon_file_mindnote_colorful);
        r114.put(r116, new Triple(r117, r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r115.h()), r102, r105}), new Triple(r117, r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r115.h()), r105, r102}), new Triple(r117, 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r115.h()), r105, r105}), new Triple(r117, 0, 0));
        Map<String, Triple<Integer, Integer, Integer>> r118 = this.f241260a;
        e r119 = e.f541298i;
        String r120 = va5.a.b(new Object[]{Integer.valueOf(r119.h()), r102, r102});
        Integer r121 = Integer.valueOf(R.drawable.ud_icon_file_bitable_colorful);
        r118.put(r120, new Triple(r121, r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r119.h()), r102, r105}), new Triple(r121, r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r119.h()), r105, r102}), new Triple(r121, 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r119.h()), r105, r105}), new Triple(r121, 0, 0));
        Map<String, Triple<Integer, Integer, Integer>> r122 = this.f241260a;
        e r123 = e.f541302m;
        String r124 = va5.a.b(new Object[]{Integer.valueOf(r123.h()), r102, r102});
        Integer r125 = Integer.valueOf(R.drawable.ud_icon_wiki_slides_colorful);
        r122.put(r124, new Triple(r125, r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r123.h()), r102, r105}), new Triple(r125, r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r123.h()), r105, r102}), new Triple(r125, 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r123.h()), r105, r105}), new Triple(r125, 0, 0));
        Map<String, Triple<Integer, Integer, Integer>> r126 = this.f241260a;
        e r127 = e.f541294e;
        String r128 = va5.a.b(new Object[]{Integer.valueOf(r127.h()), r102, r102});
        Integer r129 = Integer.valueOf(R.drawable.ud_icon_wiki_unknow_colorful);
        r126.put(r128, new Triple(r129, r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r127.h()), r102, r105}), new Triple(r129, r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r127.h()), r105, r102}), new Triple(r129, 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r127.h()), r105, r105}), new Triple(r129, 0, 0));
        Map<String, Triple<Integer, Integer, Integer>> r130 = this.f241260a;
        e r131 = e.f541301l;
        String r132 = va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r102, "image"});
        Integer r133 = Integer.valueOf(R.drawable.ud_icon_file_image_colorful);
        r130.put(r132, new Triple(r133, r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r105, "image"}), new Triple(r133, r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r102, "image"}), new Triple(r133, 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r105, "image"}), new Triple(r133, 0, 0));
        Map<String, Triple<Integer, Integer, Integer>> r134 = this.f241260a;
        String r135 = va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r102, "video"});
        Integer r136 = Integer.valueOf(R.drawable.ud_icon_file_video_colorful);
        r134.put(r135, new Triple(r136, r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r105, "video"}), new Triple(r136, r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r102, "video"}), new Triple(r136, 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r105, "video"}), new Triple(r136, 0, 0));
        Map<String, Triple<Integer, Integer, Integer>> r137 = this.f241260a;
        String r138 = va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r102, ExportFileExtension.PDF});
        Integer r139 = Integer.valueOf(R.drawable.ud_icon_file_pdf_colorful);
        r137.put(r138, new Triple(r139, r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r105, ExportFileExtension.PDF}), new Triple(r139, r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r102, ExportFileExtension.PDF}), new Triple(r139, 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r105, ExportFileExtension.PDF}), new Triple(r139, 0, 0));
        Map<String, Triple<Integer, Integer, Integer>> r140 = this.f241260a;
        String r141 = va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r102, EffectConfiguration.KEY_SEARCH_WORD});
        Integer r142 = Integer.valueOf(R.drawable.ud_icon_file_word_colorful);
        r140.put(r141, new Triple(r142, r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r105, EffectConfiguration.KEY_SEARCH_WORD}), new Triple(r142, r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r102, EffectConfiguration.KEY_SEARCH_WORD}), new Triple(r142, 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r105, EffectConfiguration.KEY_SEARCH_WORD}), new Triple(r142, 0, 0));
        Map<String, Triple<Integer, Integer, Integer>> r143 = this.f241260a;
        String r144 = va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r102, "excel"});
        Integer r145 = Integer.valueOf(R.drawable.ud_icon_file_excel_colorful);
        r143.put(r144, new Triple(r145, r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r105, "excel"}), new Triple(r145, r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r102, "excel"}), new Triple(r145, 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r105, "excel"}), new Triple(r145, 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r102, "ppt"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ppt_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r105, "ppt"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ppt_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r102, "ppt"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ppt_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r105, "ppt"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ppt_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r102, "text"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_text_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r105, "text"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_text_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r102, "text"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_text_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r105, "text"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_text_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r102, "zip"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_zip_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r105, "zip"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_zip_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r102, "zip"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_zip_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r105, "zip"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_zip_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r102, "music"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_audio_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r105, "music"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_audio_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r102, "music"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_audio_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r105, "music"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_audio_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r102, "code"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_code_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r105, "code"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_code_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r102, "code"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_code_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r105, "code"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_code_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r102, "pages"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_pages_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r105, "pages"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_pages_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r102, "pages"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_pages_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r105, "pages"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_pages_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r102, "numbers"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_numbers_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r105, "numbers"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_numbers_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r102, "numbers"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_numbers_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r105, "numbers"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_numbers_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r102, "keys"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_keynote_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r105, "keys"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_keynote_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r102, "keys"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_keynote_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r105, "keys"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_keynote_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r102, "apk"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_android_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r105, "apk"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_android_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r102, "apk"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_android_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r105, "apk"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_android_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r102, "psd"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ps_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r105, "psd"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ps_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r102, "psd"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ps_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r105, "psd"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ps_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r102, "aep"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ae_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r105, "aep"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ae_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r102, "aep"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ae_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r105, "aep"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ae_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r102, "ai"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ai_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r105, "ai"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ai_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r102, "ai"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ai_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r105, "ai"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ai_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r102, "sketch"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_sketch_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r105, "sketch"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_sketch_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r102, "sketch"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_sketch_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r105, "sketch"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_sketch_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r102, "csv"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_csv_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r105, "csv"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_csv_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r102, "csv"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_csv_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r105, "csv"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_csv_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r102, "eml"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_eml_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r105, "eml"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_eml_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r102, "eml"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_eml_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r105, "eml"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_eml_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r102, "msg"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_msg_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r102, r105, "msg"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_msg_colorful), r111, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r102, "msg"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_msg_colorful), 0, 0));
        this.f241260a.put(va5.a.b(new Object[]{Integer.valueOf(r131.h()), r105, r105, "msg"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_msg_colorful), 0, 0));
    }
}
