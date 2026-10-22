package com.bytedance.ee.bear.drive.report;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.a0;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.HashMap;
import java.util.Map;
import t85.e;
import t85.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static void a(a0 r33, c.b r34, c r36, a r37, DriveViewModel r38) {
        String r8 = "";
        switch(r33.a) {
            case 1: goto L144;
            case 2: goto L130;
            case 3: goto L104;
            case 4: goto L103;
            case 5: goto L102;
            case 6: goto L101;
            case 7: goto L100;
            case 8: goto L99;
            case 9: goto L98;
            case 10: goto L93;
            case 11: goto L92;
            case 12: goto L88;
            case 13: goto L86;
            case 14: goto L85;
            case 15: goto L81;
            case 16: goto L76;
            case 17: goto L74;
            case 18: goto L73;
            case 19: goto L66;
            case 20: goto L58;
            case 21: goto L104;
            case 22: goto L130;
            case 23: goto L57;
            case 24: goto L56;
            case 25: goto L55;
            case 26: goto L46;
            case 27: goto L42;
            case 28: goto L32;
            case 29: goto L27;
            case 30: goto L24;
            case 31: goto L21;
            case 32: goto L11;
            case 33: goto L5;
            default: goto L205;
        };
    L5:
        HashMap<String, Object> r0 = r33.b;
        if (r0 == null) goto L161;
        r37.r((String) r0.get("wps_stage"), r34.a, ((Integer) r33.b.get("wps_load_time")).intValue());     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        tt5.a.f("DrivePreviewReportUtils", e, false);
        return;
    L161:
        return;
    L11:
        HashMap<String, Object> r1 = r33.b;
        if (r1 == null) goto L163;
        String r2 = (String) r1.get("wps_stage");     // Catch: Exception -> L19
        int r3 = ((Integer) r33.b.get("wps_load_time")).intValue();     // Catch: Exception -> L19
        String r4 = r34.a;     // Catch: Exception -> L19
        r37.getClass();     // Catch: Exception -> L19
        if (r4 != null) goto L16;
        return;
    L16:
        if (r4.startsWith("local_") == true) goto L165;
        String r5 = a.c(r4, r2, 0);     // Catch: Exception -> L19
        r37.a.h(r5);     // Catch: Exception -> L19
        r37.a.j(r5, "start_time", String.valueOf(r3));     // Catch: Exception -> L19
        return;
    L165:
        return;
    L19:
        e = move-exception;
        tt5.a.f("DrivePreviewReportUtils", e, false);
        return;
    L163:
        return;
    L21:
        Map<? extends String, ? extends Object> r6 = r33.b;
        if (r6 == null) goto L167;
        String r7 = r34.a;
        String r9 = r34.b;
        r36.getClass();
        HashMap<String, Object> r10 = new HashMap();
        r10.putAll(r6);
        r10.put("target", "none");
        r36.a(r10);
        c.d(r10);
        r36.b(r10, r7, r9);
        r36.d.v("ccm_drive_page_click", r10);
        return;
    L167:
        return;
    L24:
        HashMap<String, Object> r11 = r33.b;
        if (r11 == null) goto L169;
        String r12 = r34.b;
        r37.getClass();
        HashMap r13 = new HashMap();
        r13.put("archive_file_type", r12);
        r13.putAll(r11);
        r37.a.n("ccm_drive_archive_extract_dev", r13);
        return;
    L169:
        return;
    L27:
        Object r14 = (Boolean) r33.b.get("is_fullscreen");
        if (((Integer) r38.livePreviewType().getValue()).intValue() != 4) goto L30;
        Object r16 = "preview";
    L31:
        w75.a r17 = r38.getFileModel();
        r36.getClass();
        HashMap<String, Object> r18 = new HashMap();
        r18.put("click", "media_fullscreen");
        r18.put("diaplay", r16);
        r18.put("target", "none");
        r18.put("is_fullscreen", r14);
        r36.r(r17, r18);
        return;
    L30:
        r16 = "card";
        goto L31
    L32:
        HashMap<String, Object> r19 = r33.b;
        if (r19 != null) goto L35;
        return;
    L35:
        if ((r19.get("quality") instanceof String) == true) goto L37;
        return;
    L37:
        if (((Integer) r38.livePreviewType().getValue()).intValue() != 4) goto L39;
        Object r20 = "preview";
    L40:
        Object r21 = (String) r33.b.get("quality");
        w75.a r22 = r38.getFileModel();
        r36.getClass();
        HashMap<String, Object> r23 = new HashMap();
        r23.put("click", "media_quanlity");
        r23.put("diaplay", r20);
        r23.put("target", "none");
        r23.put("quality", r21);
        r36.r(r22, r23);
        return;
    L39:
        r20 = "card";
        goto L40
    L46:
        String r24 = (String) r33.b.get("wps_stage");
        if ("wps_getInitial_data".equals(r24) == false) goto L50;
        r37.b(r34.a, "wps_getInitial_data", null);
        return;
    L50:
        if ("wps_load_template".equals(r24) == false) goto L53;
        r37.b(r34.a, "wps_load_template", null);
        return;
    L53:
        if ("wps_render".equals(r24) == false) goto L178;
        r37.b(r34.a, "wps_render", null);
        return;
    L178:
        return;
    L55:
        r37.q("wps_render", r34.a);
        return;
    L56:
        r37.q("wps_getInitial_data", r34.a);
        return;
    L57:
        r37.q("wps_load_template", r34.a);
        return;
    L58:
        HashMap<String, Object> r26 = r33.b;
        if (r26 == null) goto L183;
        String r27 = (String) r26.get(JSEventListener.ACTION);
        String r28 = r34.b;
        r36.getClass();
        HashMap r29 = new HashMap();
        r29.put(JSEventListener.ACTION, r27);
        h r30 = r36.h;
        if (r30 != null) goto L63;
    L65:
        r29.put("file_type", r28);
        r36.d.v("drive_enter_presentation", r29);
        return;
    L63:
        if (r30.a == false) goto L65;
        r29.put("app_from", "vc");
        goto L65
    L183:
        return;
    L66:
        HashMap<String, Object> r31 = r33.b;
        if (r31 != null) goto L69;
        return;
    L69:
        if ((r31.get("errorCode") instanceof Integer) == false) goto L160;
        r37.o(r34, ((Integer) r33.b.get("errorCode")).intValue(), 3);
        return;
    L160:
        return;
    L73:
        r36.getClass();
        r36.D(r34.a, r34.b, "zoom_in", "");
        return;
    L74:
        r36.getClass();
        r36.D(r34.a, r34.b, "zoom_out", "");
        return;
    L85:
        r36.getClass();
        r36.D(r34.a, r34.b, "click_file", "window");
        return;
    L86:
        r36.getClass();
        r36.D(r34.a, r34.b, "click_folder", "window");
        return;
    L92:
        r36.getClass();
        r36.D(r34.a, r34.b, "play", "video_play");
        return;
    L93:
        HashMap<String, Object> r32 = r33.b;
        Long r39 = (Long) r32.get("loadImageStartTime");
        long r110 = ((Long) r32.get("imageHeight")).longValue();
        long r111 = ((Long) r32.get("imageWidth")).longValue();
        String r40 = (String) r32.get("resultKey");
        String r41 = r34.a;
        String r42 = r34.b;
        long r43 = r34.c;
        long r44 = n.t();
        long r112 = n.v();
        String r113 = (String) r32.get("openMode");
        long r114 = System.currentTimeMillis() - r39.longValue();
        r37.getClass();
        HashMap r46 = new HashMap();
        e r47 = r37.c.a(r41);
        if (r47 == null) goto L97;
        r8 = r47.c();
    L97:
        r37.e(r46, r114, r41, r42, r43, r8);
        r46.put("image_height", Long.valueOf(r110));
        r46.put("image_width", Long.valueOf(r111));
        r46.put("screen_height", Long.valueOf(r44));
        r46.put("screen_width", Long.valueOf(r112));
        r46.put("open_mode", r113);
        r46.put("result_key", r40);
        tt5.a.b("DriveDevPerformanceReport", "reportImagePreviewEvent :  " + r46);
        r37.a.v("image_preview", r46);
        return;
    L98:
        r36.getClass();
        r36.D(r34.a, r34.b, "unmute", "toolbar");
        return;
    L99:
        r36.getClass();
        r36.D(r34.a, r34.b, "mute", "toolbar");
        return;
    L100:
        r36.getClass();
        r36.D(r34.a, r34.b, "pause", "audio_play");
        return;
    L101:
        r36.getClass();
        r36.D(r34.a, r34.b, "play", "audio_play");
        return;
    L102:
        r36.getClass();
        r36.D(r34.a, r34.b, "fast_rewind", "toolbar");
        return;
    L103:
        r36.getClass();
        r36.D(r34.a, r34.b, "fast_forward", "toolbar");
        return;
    L104:
        HashMap<String, Object> r48 = r33.b;
        if (r48 != null) goto L146;
        String r49 = "";
    L119:
        String r50 = r49;
        int r115 = -1;
    L121:
        if (TextUtils.isEmpty(r50) == false) goto L123;
    L125:
        String r51 = "DEC28";
    L126:
        String r52 = r51;
        if (r33.a != 21) goto L129;
        r37.n("dev_performance_drive_open_downgrade", "fail", "", r34.a, r115, r8, r50);
        return;
    L129:
        r37.m("nativeFail", r52, r34.a, r115, r8, r50);
        return;
    L123:
        if (r50.contains("Password required or incorrect password") == false) goto L125;
        r51 = "DEC29";
        goto L126
    L146:
        String r53 = (String) r48.get("open_type");     // Catch: Exception -> L115
        String r54 = (String) r33.b.get("error_message");     // Catch: Exception -> L113
        r115 = CastIntegerProtector.parseInt((String) r33.b.get("source_type"));     // Catch: Exception -> L111
        r8 = r53;
        r50 = r54;
    L111:
        e = e;
        r8 = r54;
    L117:
        tt5.a.f("DrivePreviewReportUtils", e, false);
        r49 = r8;
        r8 = r53;
    L113:
        e = e;
    L115:
        e = e;
        r53 = "";
        goto L117
    L130:
        HashMap<String, Object> r56 = r33.b;
        if (r56 != null) goto L150;
    L139:
        int r57 = -1;
    L141:
        if (r33.a != 22) goto L143;
        r37.n("dev_performance_drive_open_downgrade", "success", "", r34.a, r57, r8, "");
        return;
    L143:
        r37.m("success", "DEC0", r34.a, r57, r8, "");
        r37.q("file_preview", r34.a);
        return;
    L150:
        String r58 = (String) r56.get("open_type");     // Catch: Exception -> L137
        r57 = CastIntegerProtector.parseInt((String) r33.b.get("source_type"));     // Catch: Exception -> L135
        r8 = r58;
    L135:
        e = e;
        r8 = r58;
    L138:
        tt5.a.f("DrivePreviewReportUtils", e, false);
    L137:
        e = e;
        goto L138
    L144:
        r37.b(r34.a, "file_preview", null);
        return;
    L205:
        return;
    L42:
        if (((Integer) r38.livePreviewType().getValue()).intValue() != 4) goto L44;
        String r59 = "preview";
    L45:
        r36.p(r38.getFileModel(), "media_play", r59);
        return;
    L44:
        r59 = "card";
        goto L45
    L76:
        if (((Integer) r38.livePreviewType().getValue()).intValue() != 4) goto L78;
        String r60 = "preview";
    L79:
        r36.q(r38.getFileModel(), r60, "False");
        r36.D(r34.a, r34.b, "unmute", "toolbar");
        return;
    L78:
        r60 = "card";
        goto L79
    L81:
        if (((Integer) r38.livePreviewType().getValue()).intValue() != 4) goto L83;
        String r61 = "preview";
    L84:
        r36.q(r38.getFileModel(), r61, "True");
        r36.D(r34.a, r34.b, "mute", "toolbar");
        return;
    L83:
        r61 = "card";
        goto L84
    L88:
        if (((Integer) r38.livePreviewType().getValue()).intValue() != 4) goto L90;
        String r62 = "preview";
    L91:
        Long r63 = (Long) r33.b.get("play_time");
        w75.a r64 = r38.getFileModel();
        long r66 = r63.longValue();
        r36.getClass();
        HashMap<String, Object> r67 = new HashMap();
        r67.put("click", "media_time");
        r67.put("diaplay", r62);
        r67.put("target", "none");
        r36.s(r64, r67, r66);
        r36.D(r34.a, r34.b, "pause", "video_play");
        r36.p(r38.getFileModel(), "pause", r62);
        return;
    L90:
        r62 = "card";
        goto L91
    }
}
