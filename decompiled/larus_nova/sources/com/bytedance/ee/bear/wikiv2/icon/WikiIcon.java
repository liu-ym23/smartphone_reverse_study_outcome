package com.bytedance.ee.bear.wikiv2.icon;

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
public final class WikiIcon {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<WikiIcon> f240961b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Triple<Integer, Integer, Integer>> f240962a;

    public static final class a {
    }

    static {
        f240961b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, WikiIcon$Companion$instance$2.INSTANCE);
    }

    public WikiIcon() {
        this.f240962a = new HashMap();
        a();
    }

    public final void a() {
        Map<String, Triple<Integer, Integer, Integer>> r100 = this.f240962a;
        e r101 = e.f541304o;
        Boolean r102 = Boolean.TRUE;
        String r103 = va5.a.b(new Object[]{Integer.valueOf(r101.h()), r102, r102});
        Integer r110 = Integer.valueOf(R.drawable.ud_icon_file_docx_colorful);
        Integer r111 = Integer.valueOf(R.drawable.ud_icon_wiki_shortcutarrow_colorful);
        r100.put(r103, new Triple(r110, r111, 0));
        Map<String, Triple<Integer, Integer, Integer>> r104 = this.f240962a;
        Boolean r112 = Boolean.FALSE;
        String r105 = va5.a.b(new Object[]{Integer.valueOf(r101.h()), r102, r112});
        Integer r113 = Integer.valueOf(R.drawable.ud_icon_file_link_docx_shortcut_outlined);
        Integer r114 = Integer.valueOf(R.color.icon_n2);
        r104.put(r105, new Triple(r113, 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r101.h()), r112, r102}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_docx_colorful), 0, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r101.h()), r112, r112}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_link_docx_outlined), 0, r114));
        Map<String, Triple<Integer, Integer, Integer>> r106 = this.f240962a;
        e r107 = e.f541296g;
        r106.put(va5.a.b(new Object[]{Integer.valueOf(r107.h()), r102, r102}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_doc_colorful), r111, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r107.h()), r102, r112}), new Triple(Integer.valueOf(R.drawable.ud_icon_wiki_doc_shortcut_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r107.h()), r112, r102}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_doc_colorful), 0, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r107.h()), r112, r112}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_link_word_outlined), 0, r114));
        Map<String, Triple<Integer, Integer, Integer>> r108 = this.f240962a;
        e r109 = e.f541297h;
        r108.put(va5.a.b(new Object[]{Integer.valueOf(r109.h()), r102, r102}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_sheet_colorful), r111, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r109.h()), r102, r112}), new Triple(Integer.valueOf(R.drawable.ud_icon_wiki_sheet_shortcut_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r109.h()), r112, r102}), new Triple(Integer.valueOf(R.drawable.ud_icon_wiki_sheet_colorful), 0, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r109.h()), r112, r112}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_link_sheet_outlined), 0, r114));
        Map<String, Triple<Integer, Integer, Integer>> r115 = this.f240962a;
        e r116 = e.f541300k;
        r115.put(va5.a.b(new Object[]{Integer.valueOf(r116.h()), r102, r102}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_mindnote_colorful), r111, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r116.h()), r102, r112}), new Triple(Integer.valueOf(R.drawable.ud_icon_wiki_mindnote_shortcut_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r116.h()), r112, r102}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_mindnote_colorful), 0, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r116.h()), r112, r112}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_link_mindnote_outlined), 0, r114));
        Map<String, Triple<Integer, Integer, Integer>> r117 = this.f240962a;
        e r118 = e.f541298i;
        r117.put(va5.a.b(new Object[]{Integer.valueOf(r118.h()), r102, r102}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_bitable_colorful), r111, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r118.h()), r102, r112}), new Triple(Integer.valueOf(R.drawable.ud_icon_filelink_bitable_shortcut_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r118.h()), r112, r102}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_bitable_colorful), 0, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r118.h()), r112, r112}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_link_bitable_outlined), 0, r114));
        Map<String, Triple<Integer, Integer, Integer>> r119 = this.f240962a;
        e r120 = e.f541302m;
        r119.put(va5.a.b(new Object[]{Integer.valueOf(r120.h()), r102, r102}), new Triple(Integer.valueOf(R.drawable.ud_icon_wiki_slides_colorful), r111, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r120.h()), r102, r112}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_link_slides_shortcut_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r120.h()), r112, r102}), new Triple(Integer.valueOf(R.drawable.ud_icon_wiki_slides_colorful), 0, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r120.h()), r112, r112}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_link_slides_outlined), 0, r114));
        Map<String, Triple<Integer, Integer, Integer>> r121 = this.f240962a;
        e r122 = e.f541294e;
        r121.put(va5.a.b(new Object[]{Integer.valueOf(r122.h()), r102, r102}), new Triple(Integer.valueOf(R.drawable.ud_icon_wiki_unknow_colorful), r111, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r122.h()), r102, r112}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_link_unknow_shortcut_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r122.h()), r112, r102}), new Triple(Integer.valueOf(R.drawable.ud_icon_wiki_unknow_colorful), 0, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r122.h()), r112, r112}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_link_unknow_outlined), 0, r114));
        Map<String, Triple<Integer, Integer, Integer>> r123 = this.f240962a;
        e r124 = e.f541301l;
        r123.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r102, "image"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_image_colorful), r111, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r112, "image"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_link_image_shortcut_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r102, "image"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_image_colorful), 0, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r112, "image"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_link_image_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r102, "video"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_video_colorful), r111, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r112, "video"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_link_video_shortcut_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r102, "video"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_video_colorful), 0, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r112, "video"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_link_video_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r102, ExportFileExtension.PDF}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_pdf_colorful), r111, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r112, ExportFileExtension.PDF}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_link_pdf_shortcut_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r102, ExportFileExtension.PDF}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_pdf_colorful), 0, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r112, ExportFileExtension.PDF}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_link_pdf_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r102, EffectConfiguration.KEY_SEARCH_WORD}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_word_colorful), r111, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r112, EffectConfiguration.KEY_SEARCH_WORD}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_link_word2_shortcut_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r102, EffectConfiguration.KEY_SEARCH_WORD}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_word_colorful), 0, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r112, EffectConfiguration.KEY_SEARCH_WORD}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_link_word2_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r102, "excel"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_excel_colorful), r111, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r112, "excel"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_link_excel_shortcut_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r102, "excel"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_excel_colorful), 0, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r112, "excel"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_link_excel_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r102, "ppt"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ppt_colorful), r111, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r112, "ppt"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_link_ppt_shortcut_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r102, "ppt"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ppt_colorful), 0, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r112, "ppt"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_link_ppt_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r102, "text"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_text_colorful), r111, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r112, "text"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_link_text_shortcut_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r102, "text"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_text_colorful), 0, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r112, "text"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_link_text_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r102, "zip"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_zip_colorful), r111, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r112, "zip"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_link_zip_shortcut_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r102, "zip"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_zip_colorful), 0, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r112, "zip"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_link_zip_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r102, "music"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_audio_colorful), r111, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r112, "music"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_link_audio_shortcut_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r102, "music"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_audio_colorful), 0, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r112, "music"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_link_audio_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r102, "code"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_code_colorful), r111, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r112, "code"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_code_shortcut_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r102, "code"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_code_colorful), 0, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r112, "code"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_code_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r102, "pages"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_pages_colorful), r111, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r112, "pages"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_pages_shortcut_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r102, "pages"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_pages_colorful), 0, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r112, "pages"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_pages_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r102, "numbers"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_numbers_colorful), r111, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r112, "numbers"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_numbers_shortcut_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r102, "numbers"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_numbers_colorful), 0, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r112, "numbers"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_numbers_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r102, "keys"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_keynote_colorful), r111, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r112, "keys"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_keynote_shortcut_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r102, "keys"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_keynote_colorful), 0, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r112, "keys"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_keynote_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r102, "apk"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_android_colorful), r111, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r112, "apk"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_android_shortcut_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r102, "apk"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_android_colorful), 0, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r112, "apk"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_android_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r102, "psd"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ps_colorful), r111, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r112, "psd"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ps_shortcut_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r102, "psd"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ps_colorful), 0, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r112, "psd"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ps_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r102, "aep"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ae_colorful), r111, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r112, "aep"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ae_shortcut_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r102, "aep"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ae_colorful), 0, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r112, "aep"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ae_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r102, "ai"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ai_colorful), r111, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r112, "ai"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ai_shortcut_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r102, "ai"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ai_colorful), 0, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r112, "ai"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_ai_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r102, "sketch"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_sketch_colorful), r111, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r112, "sketch"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_sketch_shortcut_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r102, "sketch"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_sketch_colorful), 0, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r112, "sketch"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_sketch_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r102, "csv"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_csv_colorful), r111, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r112, "csv"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_csv_shortcut_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r102, "csv"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_csv_colorful), 0, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r112, "csv"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_csv_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r102, "eml"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_eml_colorful), r111, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r112, "eml"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_eml_shortcut_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r102, "eml"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_eml_colorful), 0, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r112, "eml"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_eml_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r102, "msg"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_msg_colorful), r111, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r102, r112, "msg"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_msg_shortcut_outlined), 0, r114));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r102, "msg"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_msg_colorful), 0, 0));
        this.f240962a.put(va5.a.b(new Object[]{Integer.valueOf(r124.h()), r112, r112, "msg"}), new Triple(Integer.valueOf(R.drawable.ud_icon_file_msg_outlined), 0, r114));
    }
}
