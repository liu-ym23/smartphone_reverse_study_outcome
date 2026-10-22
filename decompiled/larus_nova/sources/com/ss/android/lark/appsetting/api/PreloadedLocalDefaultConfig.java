package com.ss.android.lark.appsetting.api;

/* JADX INFO: loaded from: classes34.dex */
public final class PreloadedLocalDefaultConfig {
    public static boolean containsKey(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        switch(r100.hashCode()) {
            case -2003828575: goto L51;
            case -1682412610: goto L48;
            case -1615490725: goto L45;
            case -1607116380: goto L42;
            case -1531441486: goto L39;
            case -1077222986: goto L36;
            case -1038137149: goto L33;
            case -592337817: goto L30;
            case -508059438: goto L27;
            case 513613551: goto L24;
            case 778146689: goto L21;
            case 786882693: goto L18;
            case 832549236: goto L15;
            case 1020504126: goto L12;
            case 1199387415: goto L9;
            default: goto L53;
        };
    L53:
        return false;
    L9:
        if ("rust_throughput_experiment".equals(r100) == false) goto L53;
        return true;
    L12:
        if ("android_pad_config".equals(r100) == false) goto L53;
        return true;
    L15:
        if ("messenger_avatar_download_heic".equals(r100) == false) goto L53;
        return true;
    L18:
        if ("scs_psda_config".equals(r100) == false) goto L53;
        return true;
    L21:
        if ("lazy_load_fg_barrier_before_login".equals(r100) == false) goto L53;
        return true;
    L24:
        if ("feed_gc_fragment_config".equals(r100) == false) goto L53;
        return true;
    L27:
        if ("et_config".equals(r100) == false) goto L53;
        return true;
    L30:
        if ("perf_enter_chat_optimize".equals(r100) == false) goto L53;
        return true;
    L33:
        if ("lark_policy_engine_config".equals(r100) == false) goto L53;
        return true;
    L36:
        if ("performance_monitor_config".equals(r100) == false) goto L53;
        return true;
    L39:
        if ("settings_performance_metrics_config_v2".equals(r100) == false) goto L53;
        return true;
    L42:
        if ("messenger_video_passthrough".equals(r100) == false) goto L53;
        return true;
    L45:
        if ("release_eu_nc_feishu_biz_domain_config".equals(r100) == false) goto L53;
        return true;
    L48:
        if ("enableFeedOptimize".equals(r100) == false) goto L53;
        return true;
    L51:
        if ("launch_latency_optimise_first_stage".equals(r100) == false) goto L53;
        return true;
    }

    public static String getValue(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        switch(r100.hashCode()) {
            case -1615490725: goto L25;
            case -1531441486: goto L21;
            case -1038137149: goto L17;
            case -508059438: goto L13;
            case 1020504126: goto L9;
            default: goto L28;
        };
    L28:
        return null;
    L9:
        if ("android_pad_config".equals(r100) == false) goto L28;
        return "{\"pad_model_block_list\":[],\"pad_model_white_list\":[\"mi pad\",\"mi pad 3\"]}";
    L13:
        if ("et_config".equals(r100) == false) goto L28;
        return "{\"endpoints\":[\"https://internal-api.feishu.cn/collect/event/app/v1/\"],\"filter_status\":0}";
    L17:
        if ("lark_policy_engine_config".equals(r100) == false) goto L28;
        return "{\"policy_engine_enable_ip_fence_calculate\":true,\"enable_policy_engine\":true,\"policy_engine_pointcut_retry_delay\":5,\"policy_engine_unsupported_factor_map\":{\"IN_IP_FENCE\":[\"IN_IP_FENCE@WithCtx\\\\(IP_FENCE_LIST:\\\\s*\\\\{([^\\\\]]*)\\\\}\\\\)\"]},\"enable_index_factor_policy_type\":[\"FILE_PROTECT\"],\"use_rust_expression_engine\":true,\"policy_engine_fetch_policy_num\":20,\"policy_engine_enable_local_validate\":false,\"policy_engine_fast_pass_config\":{\"PC:CLIENT:ios:PointKey_IM_MSG_FILE_READ\":2,\"PC:CLIENT:android:PointKey_IM_MSG_FILE_READ\":2},\"disable_local_decision_pointcut_list\":[],\"policy_engine_local_validate_count_limit\":20,\"policy_engine_fetch_policy_interval\":300}";
    L21:
        if ("settings_performance_metrics_config_v2".equals(r100) == false) goto L28;
        return "{\"cacheSize\":500,\"reportCapacity\":100,\"filterFragment\":[\"com.ss.android.lark.framework.larkwidget.WidgetManager\",\"com.ss.android.lark.keyboard.plugin.tool.face.FaceKBPlugin$EmojiPageNewFragmentNoHitPoint\"],\"slidingWindow\":{\"windowSize\":1000,\"qpsThreshold\":200},\"bufferSize\":1000}";
    L25:
        if ("release_eu_nc_feishu_biz_domain_config".equals(r100) == false) goto L28;
        return "{\"tt_google_dns\":[\"\"],\"open_jssdk_config\":[\"mina.bytedance.com\"],\"ttwebview_settings_host\":[\"settings-bd.feishu.cn\"],\"knowledge_ai\":[\"ask.feishu.cn\"],\"docs_long\":[\"ccm-frontier.feishu.cn\"],\"docs_main_domain\":[\"feishu.cn\"],\"docs\":[\"docs.bytedance.net\",\"feishu.net\",\"larkoffice.com\",\"larkenterprise.com\"],\"vc_time_upgrade_link\":[\"https://applink.feishu.cn/client/csc/open?lk_unique=true&AppId=cli_a42fa85af0bd500b&ExtInfo=eyJjaGFubmVsSWQiOiI5MSIsImZlYXR1cmVLZXkiOiJ2aWRlb2NoYXQiLCJzb3VyY2UiOiI1In0=\"],\"docs_mg_brand_regex\":[\"\\\\.feishu\\\\.|\\\\.larksuite\\\\.\"],\"open_app_feed\":[\"open.feishu.cn\"],\"api\":[\"internal-api-lark-api.feishu.cn\"],\"mp_web_view_component\":[\"ttmopz.bytedance.com\"],\"applink_peer\":[\"applink.feishu.cn\",\"applink.larksuite.com\"],\"cdn\":[\"sf1-scmcdn-cn.feishucdn.com\",\"sf3-scmcdn-cn.feishucdn.com\",\"sf6-scmcdn-cn.feishucdn.com\"],\"passport_accounts\":[\"accounts.feishu.cn\"],\"file_web_office\":[\"weboffice.feishu-3rd-party-services.com\"],\"vc_web\":[\"vc.feishu.cn\"],\"drive\":[\"driveweb.bytedance.net\"],\"device\":[\"device-bd.feishu.cn\"],\"vc_terms_service_url\":[\"https://www.larksuite.com/{key}/user-terms-of-service\"],\"tns_report_feishu\":[\"tns.feishu.cn\"],\"docs_mg_frontier_v2\":[\"sg|ccm16-frontier-sg.feishu.cn,ccm-frontier-sg.feishu.cn\",\"us|ccm16-frontier-us.feishu.cn,ccm-frontier-us.feishu.cn\",\"jp|ccm16-frontier-jp.feishu.cn,ccm-frontier-jp.feishu.cn\",\"|ccm-frontier.feishu.cn,ccm-frontier.feishu.cn\"],\"ttnet_netlog\":[\"ttnet-log-bd.feishu.cn\"],\"url_youtube_iframe_url\":[\"https://www.youtube.com/embed/{}\"],\"vc_meeting_detail_customer\":[\"https://applink.feishu.cn/client/csc/open?lk_unique=true&AppId=cli_a42fa85af0bd500b&ExtInfo=eyJjaGFubmVsSWQiOiI5MSIsImZlYXR1cmVLZXkiOiJ2aWRlb2NoYXQiLCJzb3VyY2UiOiI1In0=\"],\"mail_node_page\":[\"www.feishu.cn\"],\"open_msg_card\":[\"internal-api.feishu.cn\"],\"long\":[\"msg-frontier.feishu.cn\"],\"tt_slardar_exception\":[\"slardar-bd.feishu.cn\"],\"apaas\":[\"feishuapp.cn\"],\"suite_security_link\":[\"security.feishu.cn\"],\"vc_meeting_url_domain_keys\":[\"vc.feishu.cn\",\"vc.feishu.net\",\"vc.larkoffice.com\",\"vc.larksuite.com\",\"vc.larkenterprise.com\",\"meetings.feishu.cn\",\"meetings.feishu.net\",\"meetings.larkoffice.com\",\"meetings.larksuite.com\",\"meeting.feishu.cn\",\"meeting.feishu.net\",\"meeting.larkoffice.com\",\"meeting.larksuite.com\",\"vc-us.feishu.cn\",\"vc-sg.feishu.cn\",\"vc-jp.feishu.cn\",\"vc-us.feishu.net\",\"vc-sg.feishu.net\",\"vc-jp.feishu.net\",\"vc-sg.larkenterprise.com\",\"vc-jp.larkenterprise.com\",\"vc-us.larkenterprise.com\",\"vc-us.larkoffice.com\",\"vc-sg.larkoffice.com\",\"vc-jp.larkoffice.com\",\"vc-cn.larksuite.com\",\"vc-sg.larksuite.com\",\"vc-jp.larksuite.com\",\"vc.anycross.com\"],\"tt_slardar\":[\"slardar-bd.feishu.cn\"],\"tt_et\":[\"mcs-bd.feishu.cn\"],\"tt_slardar_report_pc\":[\"slardar-bd.feishu.cn\"],\"suite_report\":[\"www.feishu.cn\"],\"feishu_test_rtc\":[\"rtc-access-test.bytedance.com\",\"rtc-access-test-hl.bytedance.com\",\"rtc-access-test.bytevcloud.com\"],\"email\":[\"m1.feishu.cn\"],\"rtc_frontier\":[\"rtc-access.bytedance.com\",\"rtc-access2-hl.bytedance.com\",\"rtc-access-ag.bytedance.com\"],\"suite_safetynet\":[\"internal-api.larksuite.com\"],\"docs_frontier\":[\"ccm-frontier.feishu.cn\",\"ccm-frontier.feishu.cn\"],\"tns_report\":[\"tns.feishu.cn\"],\"docs_home\":[\"www.feishu.cn\"],\"docs_fe_resource_hotfix\":[\"gecko-bd.feishu.cn\"],\"people\":[\"people.bytedance.net\"],\"vc_4k_upgrade_link\":[\"https://applink.feishu.cn/client/csc/open?lk_unique=true&AppId=cli_a42fa85af0bd500b&ExtInfo=eyJjaGFubmVsSWQiOiI5MSIsImZlYXR1cmVLZXkiOiJ2aWRlb2NoYXQiLCJzb3VyY2UiOiI1In0=\"],\"help_center\":[\"www.feishu.cn\"],\"vc_lab_platform_lark_host\":[\"https://effect-bd.larksuite.com\"],\"lark_test_pre_rtc\":[\"rtc-pre-access.larksuite.com\",\"rtcpc-pre-access-sg.larksuite.com\",\"rtcpc-pre-access-va.larksuite.com\"],\"admin_api\":[\"internal-api-lark-api.feishu.cn\"],\"mina\":[\"open.feishu.cn\"],\"tt_applog\":[\"device-bd.feishu.cn\"],\"long_rtc\":[\"lvcio.bytedance.com\"],\"open\":[\"open.feishu.cn\"],\"vc_privacy_policy_url\":[\"https://www.larksuite.com/{key}/privacy-policy\"],\"mp_applink\":[\"applink.feishu.cn\"],\"suite_tklog\":[\"internal-api-lark-file.feishu.cn\"],\"tt_dns_server_host\":[\"dig.bdurl.net\"],\"vc_1080p_upgrade_link\":[\"https://applink.feishu.cn/client/csc/open?lk_unique=true&AppId=cli_a42fa85af0bd500b&ExtInfo=eyJjaGFubmVsSWQiOiI5MSIsImZlYXR1cmVLZXkiOiJ2aWRlb2NoYXQiLCJzb3VyY2UiOiI1In0=\"],\"scs_data\":[\"internal-api-security.feishu.cn\"],\"docs_white_domain\":[\"feishu.cn\",\"feishu.net\",\"larksuite.com\",\"larkoffice.com\",\"larkenterprise.com\"],\"passport\":[\"passport.feishu.cn\"],\"contact\":[\"www.feishu.cn\"],\"feishu_test_gauss_rtc\":[\"rtc-gauss.bytedance.com\",\"rtc-gauss.bytevcloud.com\"],\"mock_gateway\":[\"loki-boe.bytedance.net\"],\"docs_mg_main_domain\":[\"feishu.cn\"],\"suite_android_hotfix\":[\"lark-plugin.bytedance.com\"],\"docs_fe_resource_url\":[\"gecko-bd.feishu.cn\"],\"mp_tt\":[\"slardar-bd.feishu.cn\"],\"tt_slardar_report\":[\"slardar-bd.feishu.cn\"],\"gecko\":[\"gecko-bd.feishu.cn\"],\"people_approvals\":[\"feishu.cn\"],\"directory_people_mode\":[\"smb.feishu.cn/smb-micro/\"],\"feishu_rtc\":[\"rtc-access.bytedance.com\",\"rtc-access2-hl.bytedance.com\",\"rtc-access-ag.bytedance.com\",\"rtcg-access.bytevcloud.com\"],\"larkai_correction\":[\"internal-api-space.feishu.cn\"],\"ttnet_httpdns\":[\"dig.bdurl.net\"],\"emm\":[],\"passport_captcha\":[\"internal-api.feishu.cn\"],\"suite_secsdk\":[\"internal-api-security.feishu.cn\"],\"mp_refer\":[\"tmaservice.developer.toutiao.com\"],\"privacy\":[\"www.feishu.cn\"],\"feishu_test_pre_rtc\":[\"rtc-pre-access.bytedance.com\",\"rtc-pre-access.bytevcloud.com\"],\"vod\":[],\"frontier_private_protocol\":[\"msg-frontier-pro.feishu.cn\"],\"email_sai\":[\"sai.bytedance.net\"],\"tt_graylog\":[\"internal-api.feishu.cn\"],\"lark_test_rtc\":[\"rtc-access-test.larksuite.com\"],\"internal_api\":[\"internal-api.feishu.cn\"],\"mail_node_api\":[\"api-eeft-mail.feishu.cn\"],\"ug_activity\":[\"activity.feishu.cn\"],\"vc_mm\":[\"meetings.feishu.cn\"],\"passport_accounts_nomg\":[\"accounts.feishu.cn\"],\"docs_cdn_domain\":[\"sf3-scmcdn2-cn.feishucdn.com\",\"sf1-scmcdn2-cn.feishucdn.com\",\"sf3-ccm1-cn.feishucdn.com\",\"sf6-scmcdn2-cn.feishucdn.com\"],\"tt_slardar_crash_host_ios\":[\"slardar-bd.feishu.cn\"],\"approval\":[\"approval.feishu.cn\",\"www.feishu.cn\"],\"security_allowlist\":[\"feishu-pre.cn\",\"feishu-pre.net\",\"larksuite-pre.com\",\"larkenterprise-pre.com\"],\"docs_mg_frontier\":[\"feishu|sg|ccm16-frontier-sg.feishu.cn,ccm-frontier-sg.feishu.cn\",\"feishu|us|ccm16-frontier-us.feishu.cn,ccm-frontier-us.feishu.cn\",\"feishu|jp|ccm16-frontier-jp.feishu.cn,ccm-frontier-jp.feishu.cn\",\"feishu||ccm-frontier.feishu.cn,ccm-frontier.feishu.cn\",\"larksuite|sg|ccm16-frontier-sg.larksuite.com,ccm-frontier-sg.larksuite.com\",\"larksuite|jp|ccm16-frontier-jp.larksuite.com,ccm-frontier-jp.larksuite.com\",\"larksuite||ccm16-frontier.larksuite.com,ccm-frontier.larksuite.com\"],\"docs_peer\":[\"feishu.cn/(space|wiki|docs|sheets|base|app|slides|mindnotes|file|drive|docx)\",\"larksuite.com/(space|wiki|docs|sheets|base|app|slides|mindnotes|file|drive|docx)\",\"docs.bytedance.net/(space|wiki|docs|sheets|base|app|slides|mindnotes|file|drive|docx)\",\"docs-staging.bytedance.net/(space|wiki|docs|sheets|base|app|slides|mindnotes|file|drive|docx)\",\"feishu.net/(space|wiki|docs|sheets|base|app|slides|mindnotes|file|drive|docx)\",\"larkenterprise.com/(space|wiki|docs|sheets|base|app|slides|mindnotes|file|drive|docx)\",\"larkoffice.com/(space|wiki|docs|sheets|base|app|slides|mindnotes|file|drive|docx)\"],\"vpn\":[],\"identifier_online\":[\"www.feishu.cn\"],\"passport_cookie\":[\"feishu.cn\",\"larksuite.com\",\"feishu.net\",\"larkoffice.com\",\"larkenterprise.com\"],\"efficiency_board\":[\"info-efficiency.larkoffice.com\"],\"passport_accounts_new\":[\"accounts.feishu.cn\"],\"mp_config\":[\"open.feishu.cn\"],\"guest_login\":[\"meetings.feishu.cn\"],\"ttpush\":[\"push-bd.feishu.cn\"],\"group_qr_code\":[\"lark.bytedance.net\"],\"email_bff\":[\"api-eeft-mail.feishu.cn\"],\"open_mg\":[\"open.feishu.cn\"],\"vc_lab_platform_feishu_host\":[\"https://effect-bd.feishu.cn\"],\"vc_meeting_url_path_keys\":[\"(^\\\\/j\\\\/[^\\\\/]*)[^\\\\/]$\",\"(^\\\\/w\\\\/[^\\\\/]*)[^\\\\/]$\",\"^\\\\/j\\\\/i$\",\"^\\\\/applink\\\\/meeting\\\\/join$\"],\"appbeta\":[\"appbeta-bd.feishu.cn\"],\"im_bw_preload_image\":[\"s1-imfile.feishucdn.com\"],\"applink\":[\"applink.feishu.cn\"],\"security_login_restriction\":[\"internal-api-security-tenant-probe.feishu.cn\"],\"suite_bdmssdk\":[\"internal-api-security.feishu.cn\"],\"docs_api\":[\"internal-api-space.feishu.cn\"],\"docs_feed\":[\"www.feishu.cn\"],\"open_appcenter_cardjump\":[\"open.feishu.cn\"],\"url_youtube_long_domain\":[\"www.youtube.com\",\"m.youtube.com\",\"youtube.net\",\"youtube.org\"],\"detect_docs_drive\":[\"internal-api-drive-stream.feishu.cn\"],\"feishu_pre_rtc\":[\"rtc-pre-access.bytedance.com\",\"rtc-pre-access.bytevcloud.com\"],\"open_app_interface\":[\"internal-api.feishu.cn\"],\"detect_docs_api\":[\"internal-api-space.feishu.cn\"],\"docs_mg_api_v2\":[\"sg|internal-api-space-sg.feishu.cn\",\"us|internal-api-space-us.feishu.cn\",\"jp|internal-api-space-jp.feishu.cn\",\"|internal-api-space.feishu.cn\"],\"open_applink_schema_enable_host\":[\"applink.feishu.cn\"],\"docs_drive\":[\"internal-api-drive-stream.feishu.cn\"],\"suite_main_domain\":[\"feishu.cn\",\"feishu.net\",\"larkoffice.com\",\"larkenterprise.com\"],\"cj_hongbao\":[\"pay-bd.feishu.cn\"],\"log\":[\"slardar-bd.feishu.cn\"],\"pano\":[\"oa.feishu.cn\"],\"core_pre_tab\":[\"www.feishu.cn\"],\"ems_oa\":[\"oa.feishu.cn\"],\"tt_abtest\":[\"abtest-bd.feishu.cn\"],\"docs_account_delete_notice\":[\"bytedance.feishu.cn\"],\"passport_page\":[\"login.feishu.cn\"],\"tt_tea\":[\"applog-bd.feishu.cn\"],\"open_appdetail\":[\"app.feishu.cn\"],\"file\":[\"internal-api-lark-file.feishu.cn\"],\"tns_report_lark\":[\"tns.larksuite.com\"],\"meego\":[\"project.larkenterprise.com\",\"project.feishu.cn\"],\"webim_main_domain\":[\"feishu.cn\"],\"mg_meego\":[\"meego.feishu.cn\"],\"open_moment\":[\"ee.bytedance.net\"],\"mail_cover_cdn_path\":[\"lf-larkemail.bytetos.com/obj/eden-cn\"],\"url_tiktok_domain\":[\"www.tiktok.com\",\"www.tiktok.in\",\"vt.tiktok.com\",\"vm.tiktok.com\"],\"csc_ocic\":[\"linkchat.feishu.cn\"],\"url_youtube_short_domain\":[\"youtu.be\"],\"ntp\":[\"ntp1.aliyun.com:123\",\"time1.cloud.tencent.com:123\",\"cn.ntp.org.cn:123\",\"edu.ntp.org.cn:123\"],\"docs_mg_api\":[\"feishu|sg|internal-api-space-sg.feishu.cn\",\"feishu|us|internal-api-space-us.feishu.cn\",\"feishu|jp|internal-api-space-jp.feishu.cn\",\"feishu||internal-api-space.feishu.cn\",\"larksuite|sg|internal-api-space-sg.larksuite.com\",\"larksuite|jp|internal-api-space-jp.larksuite.com\",\"larksuite||internal-api-space.larksuite.com\"],\"tt_cdn\":[\"sf1-scmcdn-cn.feishucdn.com/obj/feishu-static\",\"sf3-scmcdn-cn.feishucdn.com/obj/feishu-static\",\"sf6-scmcdn-cn.feishucdn.com/obj/feishu-static\"],\"vc_live_policy_url\":[\"https://meetings.feishu.cn/live/live-policy/{key}\"],\"open_api_login\":[\"mina.bytedance.com\"],\"sec_slardar_cdn\":[\"https://lf3-short.ibytedapm.com/slardar/fe/sdk-web/browser.cn.js\"],\"oapi\":[\"oapi.zjurl.cn\"],\"suite_admin_base\":[\"www.feishu.cn\"],\"email_smtp\":[\"smtp.feishu.cn\",\"465\"],\"url_youtube_cover_image\":[\"https://i.ytimg.com/vi/{}/hqdefault.jpg\"],\"email_imap\":[\"imap.feishu.cn\",\"993\"],\"lark_pre_rtc\":[\"rtc-pre-access.larksuite.com\",\"rtcpc-pre-access-sg.larksuite.com\",\"rtcpc-pre-access-va.larksuite.com\"],\"open_blockit_cdn_domain\":[\"sf6-scmcdn-cn.feishucdn.com\"],\"sec_slardar_report\":[\"slardar-bd.feishu.cn\"],\"suite_image_cdn\":[\"p1-ee.bytedimg.com\",\"p3-ee.bytedimg.com\",\"p9-ee.bytedimg.com\"],\"suite_admin\":[\"www.feishu.cn\"],\"mg_project\":[\"project.feishu.cn\"],\"docs_mg_geo_regex\":[\"\\\\.sg\\\\.|\\\\.us\\\\.|\\\\.jp\\\\.\"],\"ios_setup_mac_task\":[\"www.feishu.cn\"],\"tt_npth\":[\"slardar-bd.feishu.cn\"],\"open_appcenter3\":[\"internal-api.feishu.cn\"],\"open_pkm\":[\"open.feishu.cn\"],\"helpdesk\":[\"helpdesk.feishu.cn\"],\"open_appcenter2\":[\"mina.bytedance.com\"],\"open_appcenter1\":[\"mina.bytedance.com\"],\"httpdns\":[\"dig.feishu.cn\"],\"tt_slardar_load\":[\"mon.zijieapi.com\"],\"tt_tea_rust\":[\"mcs-bd.feishu.cn\"],\"rtc_decision\":[\"rtc.bytedance.com\",\"rtc-hl.bytedance.com\",\"rtcg.bytevcloud.com\"],\"lark_test_gauss_rtc\":[\"rtc-gauss.larksuite.com\"],\"lark_rtc\":[\"rtcg-access.larksuite.com\",\"rtcpcg-access-sg.larksuite.com\",\"rtcpcg-access-va.larksuite.com\"],\"urgent_helpdesk_domain\":[\"applink.feishu.cn\"],\"sec_tea_report\":[\"https://mcs-bd.feishu.cn\"],\"mail_node_page_v2\":[\"www.feishu.cn\"],\"vc_privacy\":[\"www.feishu.cn\"],\"tt_slardar_log_collect\":[\"internal-api.feishu.cn\"],\"open_appstore\":[\"app.feishu.cn\"],\"security_and_compliance\":[\"internal-api-security.feishu.cn\"],\"passport_turing\":[\"verify.zijieapi.com\"],\"sentry\":[\"internal-api-sentry.feishu.cn\"],\"security_web\":[\"security.feishu.cn\"],\"vc_num_upgrade_link\":[\"https://applink.feishu.cn/client/csc/open?lk_unique=true&AppId=cli_a42fa85af0bd500b&ExtInfo=eyJjaGFubmVsSWQiOiI5MSIsImZlYXR1cmVLZXkiOiJ2aWRlb2NoYXQiLCJzb3VyY2UiOiI1In0=\"],\"ttnet_tnc\":[\"dm.feishu.cn\",\"dm-lf.feishu.cn\",\"dm-hl.feishu.cn\"],\"group_more_collaborativelist\":[\"feishu.cn\"],\"basic_mode\":[\"www.feishu.cn\"],\"reaction_bucket_prex\":[\"sf1-scmcdn-cn.feishucdn.com/obj/lark-reaction-cn\",\"sf3-scmcdn-cn.feishucdn.com/obj/lark-reaction-cn\",\"sf6-scmcdn-cn.feishucdn.com/obj/lark-reaction-cn\"],\"tt_slardar_setting\":[\"slardar-bd.feishu.cn\"],\"help_document\":[\"bytedance.feishu.cn\"],\"lgw_csrf_domain\":[\"www.feishu.cn\"],\"vc_privacy_sound_url\":[\"https://www.feishu.cn/privacy-sound\"]}";
    }

    public PreloadedLocalDefaultConfig() {
    }
}
