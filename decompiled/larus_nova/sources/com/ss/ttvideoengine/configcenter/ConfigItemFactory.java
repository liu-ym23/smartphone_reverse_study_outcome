package com.ss.ttvideoengine.configcenter;

import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.FeatureManager;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;

/* JADX INFO: loaded from: classes34.dex */
public class ConfigItemFactory {
    private static final String TAG = "ConfigItemFactory";

    public ConfigItemFactory() {
    }

    public static boolean isCommonPlayerOption(int r100) {
        if (r100 >= 40000) goto L5;
    L7:
        return false;
    L5:
        if (r100 >= 50000) goto L7;
        return true;
    }

    public ConfigItem createIntOption(int r110, int r111) {
        if (isCommonPlayerOption(r110) == false) goto L7;
        return new PlayerConfigItem(r110, Integer.valueOf(r111), 1);
    L7:
        if (r110 == 0) goto L317;
        if (r110 == 1) goto L579;
        if (r110 == 2) goto L578;
        if (r110 != 160) goto L14;
    L312:
        EngineConfigItem r100 = new EngineConfigItem(r110, Integer.valueOf(r111), 1);
    L577:
        return r100;
    L14:
        if (r110 == 161) goto L312;
        if (r110 == 183) goto L576;
        if (r110 == 184) goto L575;
        if (r110 != 207) goto L22;
        if (r111 >= 0) goto L574;
    L308:
        return null;
    L574:
        return new PlayerConfigItem(159, Integer.valueOf(r111), 1);
    L22:
        if (r110 == 208) goto L572;
        switch(r110) {
            case 9: goto L571;
            case 11: goto L570;
            case 24: goto L569;
            case 25: goto L568;
            case 26: goto L567;
            case 27: goto L312;
            case 28: goto L312;
            case 85: goto L312;
            case 101: goto L566;
            case 110: goto L312;
            case 118: goto L565;
            case 120: goto L564;
            case 198: goto L563;
            case 200: goto L562;
            case 250: goto L561;
            case 255: goto L560;
            case 256: goto L559;
            case 257: goto L558;
            case 258: goto L557;
            case 299: goto L308;
            case 302: goto L288;
            case 310: goto L556;
            case 311: goto L555;
            case 312: goto L312;
            case 313: goto L312;
            case 314: goto L554;
            case 321: goto L553;
            case 323: goto L552;
            case 324: goto L551;
            case 329: goto L278;
            case 330: goto L549;
            case 331: goto L548;
            case 332: goto L547;
            case 333: goto L546;
            case 334: goto L312;
            case 335: goto L312;
            case 339: goto L545;
            case 340: goto L544;
            case 343: goto L543;
            case 356: goto L542;
            case 357: goto L541;
            case 358: goto L540;
            case 370: goto L539;
            case 371: goto L538;
            case 400: goto L312;
            case 401: goto L537;
            case 402: goto L536;
            case 403: goto L312;
            case 410: goto L312;
            case 415: goto L535;
            case 417: goto L534;
            case 419: goto L312;
            case 420: goto L533;
            case 421: goto L532;
            case 422: goto L531;
            case 423: goto L530;
            case 424: goto L312;
            case 425: goto L312;
            case 427: goto L312;
            case 431: goto L529;
            case 450: goto L312;
            case 473: goto L528;
            case 474: goto L527;
            case 475: goto L526;
            case 476: goto L525;
            case 478: goto L524;
            case 481: goto L523;
            case 482: goto L522;
            case 483: goto L521;
            case 484: goto L520;
            case 485: goto L519;
            case 486: goto L312;
            case 487: goto L312;
            case 488: goto L518;
            case 489: goto L312;
            case 490: goto L517;
            case 491: goto L241;
            case 492: goto L312;
            case 493: goto L312;
            case 495: goto L515;
            case 496: goto L514;
            case 497: goto L312;
            case 498: goto L513;
            case 499: goto L512;
            case 500: goto L312;
            case 501: goto L312;
            case 502: goto L312;
            case 503: goto L312;
            case 507: goto L312;
            case 508: goto L511;
            case 509: goto L510;
            case 511: goto L232;
            case 512: goto L509;
            case 515: goto L508;
            case 516: goto L507;
            case 517: goto L506;
            case 518: goto L505;
            case 519: goto L312;
            case 520: goto L312;
            case 525: goto L312;
            case 536: goto L312;
            case 537: goto L312;
            case 541: goto L504;
            case 542: goto L312;
            case 543: goto L503;
            case 544: goto L312;
            case 548: goto L502;
            case 550: goto L501;
            case 551: goto L500;
            case 552: goto L499;
            case 557: goto L498;
            case 558: goto L312;
            case 559: goto L497;
            case 560: goto L496;
            case 561: goto L495;
            case 562: goto L494;
            case 563: goto L493;
            case 564: goto L492;
            case 565: goto L491;
            case 566: goto L490;
            case 567: goto L489;
            case 568: goto L488;
            case 569: goto L487;
            case 570: goto L486;
            case 571: goto L312;
            case 572: goto L485;
            case 573: goto L312;
            case 575: goto L484;
            case 576: goto L483;
            case 577: goto L482;
            case 578: goto L481;
            case 579: goto L480;
            case 580: goto L479;
            case 581: goto L478;
            case 582: goto L477;
            case 583: goto L312;
            case 584: goto L312;
            case 585: goto L476;
            case 586: goto L475;
            case 587: goto L312;
            case 588: goto L312;
            case 591: goto L474;
            case 592: goto L473;
            case 593: goto L472;
            case 594: goto L471;
            case 595: goto L470;
            case 597: goto L469;
            case 598: goto L468;
            case 600: goto L312;
            case 601: goto L312;
            case 602: goto L467;
            case 603: goto L312;
            case 606: goto L312;
            case 607: goto L466;
            case 608: goto L465;
            case 609: goto L464;
            case 610: goto L463;
            case 611: goto L462;
            case 613: goto L461;
            case 620: goto L460;
            case 650: goto L312;
            case 652: goto L312;
            case 656: goto L312;
            case 657: goto L179;
            case 658: goto L459;
            case 661: goto L312;
            case 663: goto L312;
            case 664: goto L458;
            case 665: goto L457;
            case 666: goto L456;
            case 668: goto L179;
            case 669: goto L455;
            case 670: goto L454;
            case 671: goto L312;
            case 675: goto L453;
            case 677: goto L452;
            case 678: goto L451;
            case 679: goto L450;
            case 680: goto L449;
            case 681: goto L312;
            case 682: goto L312;
            case 683: goto L448;
            case 685: goto L447;
            case 686: goto L446;
            case 687: goto L445;
            case 688: goto L444;
            case 700: goto L443;
            case 703: goto L442;
            case 705: goto L441;
            case 706: goto L440;
            case 707: goto L312;
            case 711: goto L312;
            case 712: goto L312;
            case 714: goto L439;
            case 717: goto L438;
            case 721: goto L312;
            case 742: goto L312;
            case 744: goto L437;
            case 746: goto L436;
            case 747: goto L435;
            case 800: goto L434;
            case 801: goto L312;
            case 850: goto L433;
            case 851: goto L432;
            case 852: goto L431;
            case 853: goto L430;
            case 854: goto L429;
            case 855: goto L428;
            case 856: goto L427;
            case 857: goto L140;
            case 858: goto L426;
            case 859: goto L425;
            case 860: goto L424;
            case 861: goto L423;
            case 862: goto L422;
            case 863: goto L421;
            case 864: goto L420;
            case 950: goto L312;
            case 951: goto L312;
            case 952: goto L419;
            case 953: goto L418;
            case 954: goto L417;
            case 955: goto L416;
            case 956: goto L415;
            case 958: goto L414;
            case 959: goto L413;
            case 962: goto L412;
            case 963: goto L411;
            case 976: goto L410;
            case 977: goto L409;
            case 978: goto L408;
            case 979: goto L407;
            case 980: goto L406;
            case 981: goto L405;
            case 982: goto L312;
            case 983: goto L404;
            case 984: goto L403;
            case 985: goto L402;
            case 986: goto L401;
            case 987: goto L400;
            case 988: goto L399;
            case 989: goto L398;
            case 990: goto L397;
            case 991: goto L396;
            case 992: goto L395;
            case 993: goto L394;
            case 994: goto L393;
            case 995: goto L392;
            case 996: goto L391;
            case 998: goto L390;
            case 1070: goto L389;
            case 1073: goto L388;
            case 1100: goto L387;
            case 1101: goto L386;
            case 1105: goto L385;
            case 1110: goto L384;
            case 1111: goto L383;
            case 1112: goto L382;
            case 1113: goto L381;
            case 1114: goto L380;
            case 1115: goto L379;
            case 1117: goto L378;
            case 1118: goto L377;
            case 1119: goto L376;
            case 1120: goto L375;
            case 1121: goto L374;
            case 1122: goto L373;
            case 1123: goto L372;
            case 1124: goto L371;
            case 1125: goto L370;
            case 1126: goto L369;
            case 1127: goto L368;
            case 1128: goto L367;
            case 1129: goto L366;
            case 1130: goto L312;
            case 1134: goto L365;
            case 1200: goto L364;
            case 1202: goto L363;
            case 1209: goto L362;
            case 1210: goto L361;
            case 1211: goto L360;
            case 1212: goto L359;
            case 1213: goto L358;
            case 1214: goto L357;
            case 1215: goto L356;
            case 1216: goto L355;
            case 1217: goto L354;
            case 1218: goto L312;
            case 1219: goto L312;
            case 1220: goto L353;
            case 1221: goto L352;
            case 1222: goto L351;
            case 1223: goto L350;
            case 1224: goto L349;
            case 1281: goto L348;
            case 1300: goto L347;
            case 1301: goto L312;
            case 1302: goto L346;
            case 1400: goto L345;
            case 1401: goto L344;
            case 1402: goto L312;
            case 1404: goto L343;
            case 1405: goto L342;
            case 1406: goto L341;
            case 1414: goto L312;
            case 1504: goto L340;
            case 4001: goto L339;
            case 4002: goto L338;
            case 4003: goto L337;
            case 4004: goto L312;
            case 4005: goto L336;
            case 4007: goto L335;
            case 4008: goto L334;
            case 4009: goto L312;
            case 4010: goto L312;
            case 4014: goto L312;
            case 4016: goto L312;
            case 4017: goto L333;
            case 4018: goto L332;
            case 4022: goto L312;
            case 4023: goto L331;
            case 4024: goto L330;
            case 5000: goto L312;
            case 5010: goto L312;
            default: goto L25;
        };
    L25:
        switch(r110) {
            case 16: goto L329;
            case 17: goto L312;
            case 18: goto L312;
            case 19: goto L312;
            default: goto L26;
        };
    L26:
        switch(r110) {
            case 32: goto L328;
            case 33: goto L312;
            case 34: goto L327;
            default: goto L27;
        };
    L27:
        switch(r110) {
            case 36: goto L326;
            case 37: goto L312;
            case 38: goto L325;
            default: goto L28;
        };
    L28:
        switch(r110) {
            case 202: goto L324;
            case 203: goto L555;
            case 204: goto L323;
            case 205: goto L322;
            default: goto L29;
        };
    L29:
        switch(r110) {
            case 213: goto L321;
            case 214: goto L320;
            case 215: goto L319;
            case 216: goto L318;
            default: goto L30;
        };
    L30:
        TTVideoEngineLog.w(TAG, "unknown option key: " + r110 + ", value: " + r111);
        goto L308
    L318:
        return new PlayerConfigItem(97, Integer.valueOf(r111), 1);
    L319:
        return new PlayerConfigItem(88, Integer.valueOf(r111), 1);
    L320:
        return new PlayerConfigItem(199, Integer.valueOf(r111), 1);
    L321:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, Integer.valueOf(r111), 1);
    L322:
        return new PlayerConfigItem(134, Integer.valueOf(r111), 1);
    L323:
        return new PlayerConfigItem(96, Integer.valueOf(r111), 1);
    L324:
        return new PlayerConfigItem(110, Integer.valueOf(r111), 1);
    L325:
        return new PlayerConfigItem(209, Integer.valueOf(r111), 1, 1);
    L326:
        return new PlayerConfigItem(208, Integer.valueOf(r111), 1, 1);
    L327:
        return new PlayerConfigItem(206, Integer.valueOf(r111), 1, 1);
    L328:
        return new PlayerConfigItem(193, Integer.valueOf(r111), 1, 1);
    L329:
        return new PlayerConfigItem(83, Integer.valueOf(r111), 1);
    L140:
        if (r111 < 0) goto L308;
        if (r111 >= 200) goto L145;
        r111 = 200;
    L145:
        r100 = new EngineConfigItem(r110, Integer.valueOf(r111), 1);
        goto L577
    L179:
        if (r111 <= 0) goto L308;
        r100 = new EngineConfigItem(r110, Integer.valueOf(r111), 1);
        goto L577
    L241:
        if (r111 < 0) goto L308;
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_PREPARE_CACHE_MS, Integer.valueOf(r111), 1);
    L330:
        return new PlayerConfigItem(4010, Integer.valueOf(r111), 1);
    L331:
        return new PlayerConfigItem(4009, Integer.valueOf(r111), 1);
    L332:
        return new PlayerConfigItem(4008, Integer.valueOf(r111), 1);
    L333:
        return new PlayerConfigItem(581, Integer.valueOf(r111), 1);
    L334:
        return new PlayerConfigItem(4006, Integer.valueOf(r111), 1, -1);
    L335:
        return new PlayerConfigItem(4006, Integer.valueOf(r111), 1, -1);
    L336:
        return new PlayerConfigItem(4005, Integer.valueOf(r111), 1);
    L337:
        return new PlayerConfigItem(4003, Integer.valueOf(r111), 1);
    L338:
        return new PlayerConfigItem(4002, Integer.valueOf(r111), 1);
    L339:
        return new PlayerConfigItem(4001, Integer.valueOf(r111), 1);
    L340:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NOTIFY_RENDER_EXCEPTION, Integer.valueOf(r111), 1);
    L341:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_EXTERN_VOICE_OUTPUT_FORMAT, Integer.valueOf(r111), 1, -1);
    L342:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_ALLOW_ALL_EXTENSIONS, Integer.valueOf(r111), 1, -1);
    L343:
        return new PlayerConfigItem(1902, Integer.valueOf(r111), 1);
    L344:
        return new PlayerConfigItem(1901, Integer.valueOf(r111), 1);
    L345:
        return new PlayerConfigItem(1900, Integer.valueOf(r111), 1);
    L346:
        return new PlayerConfigItem(1802, Integer.valueOf(r111), 1, -1);
    L347:
        return new PlayerConfigItem(1800, Integer.valueOf(r111), 1);
    L348:
        return new PlayerConfigItem(480, Integer.valueOf(r111), 1);
    L349:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_ANRENDER_REFRESH_SURFACE, Integer.valueOf(r111), 1);
    L350:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_OPTIMIZE_DASH_SEEK, Integer.valueOf(r111), 1);
    L351:
        return new PlayerConfigItem(1086, Integer.valueOf(r111), 1);
    L352:
        return new PlayerConfigItem(1098, Integer.valueOf(r111), 1);
    L353:
        return new PlayerConfigItem(1084, Integer.valueOf(r111), 1);
    L354:
        return new PlayerConfigItem(1096, Integer.valueOf(r111), 1);
    L355:
        return new PlayerConfigItem(1094, Integer.valueOf(r111), 1);
    L356:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PRELOAD_GEAR, Integer.valueOf(r111), 1);
    L357:
        return new PlayerConfigItem(1079, Integer.valueOf(r111), 1);
    L358:
        return new PlayerConfigItem(1076, Integer.valueOf(r111), 1);
    L359:
        return new PlayerConfigItem(1075, Integer.valueOf(r111), 1);
    L360:
        return new PlayerConfigItem(1074, Integer.valueOf(r111), 1);
    L361:
        return new PlayerConfigItem(1072, Integer.valueOf(r111), 1);
    L362:
        return new PlayerConfigItem(1071, Integer.valueOf(r111), 1);
    L363:
        return new PlayerConfigItem(1052, Integer.valueOf(r111), 1);
    L364:
        return new PlayerConfigItem(1050, Integer.valueOf(r111), 1);
    L365:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_FALLBACK_IN_MAX_INSTANCE_ERR, Integer.valueOf(r111), 1);
    L366:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_CODEC_MAX_USED_COUNT, Integer.valueOf(r111), 1);
    L367:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_CODEC_HISTORY_LENGTH, Integer.valueOf(r111), 1);
    L368:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_DISCARD_CODEC_STRATEGY2, Integer.valueOf(r111), 1);
    L369:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_DISCARD_CODEC_STRATEGY1, Integer.valueOf(r111), 1);
    L370:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_CODECPOOL_VERSION, Integer.valueOf(r111), 1);
    L371:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_AND_GRAPH_MERGE, Integer.valueOf(r111), 1);
    L372:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_GRAPH_REFACTOR, Integer.valueOf(r111), 1);
    L373:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_REC_BUFFER_TYPE, Integer.valueOf(r111), 1);
    L374:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_USER_EXIT_TIME, Integer.valueOf(r111), 1);
    L375:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_MC_RENDER_HANDLE_SAR, Integer.valueOf(r111), 1);
    L376:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_NUMS_IN_MEDIACODEC, Integer.valueOf(r111), 1);
    L377:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_MEDIACODEC_PIPELINE_CTL, Integer.valueOf(r111), 1);
    L378:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_OPTIMIZE_HWDEC2SWDEC, Integer.valueOf(r111), 1);
    L379:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_EXTEND_CODEC_NUMS, Integer.valueOf(r111), 1);
    L380:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_CODECPOOL_SUPPORT_DYNAMIC_EXTEND, Integer.valueOf(r111), 1);
    L381:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_DEATH_TIMEOUT_MS, Integer.valueOf(r111), 1);
    L382:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_DEATH_CHECK_INTERVAL_MS, Integer.valueOf(r111), 1);
    L383:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_MEDIA_CODEC_DEATH_CHECK, Integer.valueOf(r111), 1);
    L384:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_CREATE_AUDIOTRACK_EARLY, Integer.valueOf(r111), 1);
    L385:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_FLUSH_WHEN_SETSURFACE, Integer.valueOf(r111), 1);
    L386:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_START_PLAY_SYNC, Integer.valueOf(r111), 1);
    L387:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_ASYNC_SET_WINDOW, Integer.valueOf(r111), 1);
    L388:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_USE_TARGET_WINDOW, Integer.valueOf(r111), 1);
    L389:
        return new PlayerConfigItem(1070, Integer.valueOf(r111), 1);
    L390:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_QUERY_ADAPTIVE_PLAYBACK, Integer.valueOf(r111), 1);
    L391:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_REC_BUFFER_THRESH, Integer.valueOf(r111), 1);
    L392:
        return new PlayerConfigItem(1048, Integer.valueOf(r111), 1);
    L393:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_CALIBRATION_AUDIO_TYPE, Integer.valueOf(r111), 1);
    L394:
        return new PlayerConfigItem(1047, Integer.valueOf(r111), 1);
    L395:
        return new PlayerConfigItem(1049, Integer.valueOf(r111), 1);
    L396:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_AUTO_DISCONNECTED_CPU, Integer.valueOf(r111), 1);
    L397:
        return new PlayerConfigItem(1046, Integer.valueOf(r111), 1);
    L398:
        return new PlayerConfigItem(1045, Integer.valueOf(r111), 1);
    L399:
        return new PlayerConfigItem(1044, Integer.valueOf(r111), 1);
    L400:
        return new PlayerConfigItem(1043, Integer.valueOf(r111), 1);
    L401:
        return new PlayerConfigItem(1041, Integer.valueOf(r111), 1);
    L402:
        return new PlayerConfigItem(1040, Integer.valueOf(r111), 1);
    L403:
        return new PlayerConfigItem(1063, Integer.valueOf(r111), 1);
    L404:
        return new PlayerConfigItem(1039, Integer.valueOf(r111), 1);
    L405:
        return new PlayerConfigItem(1038, Integer.valueOf(r111), 1);
    L406:
        return new PlayerConfigItem(1035, Integer.valueOf(r111), 1);
    L407:
        return new PlayerConfigItem(1009, Integer.valueOf(r111), 1);
    L408:
        return new PlayerConfigItem(1008, Integer.valueOf(r111), 1);
    L409:
        return new PlayerConfigItem(1007, Integer.valueOf(r111), 1);
    L410:
        return new PlayerConfigItem(1034, Integer.valueOf(r111), 1);
    L411:
        return new PlayerConfigItem(475, Integer.valueOf(r111), 1);
    L412:
        return new PlayerConfigItem(1036, Integer.valueOf(r111), 1);
    L413:
        return new PlayerConfigItem(1020, Integer.valueOf(r111), 1);
    L414:
        return new PlayerConfigItem(1005, Integer.valueOf(r111), 1);
    L415:
        return new PlayerConfigItem(1003, Integer.valueOf(r111), 1, -1);
    L416:
        return new PlayerConfigItem(1000, Integer.valueOf(r111), 1);
    L417:
        return new PlayerConfigItem(985, Integer.valueOf(r111), 1);
    L418:
        return new PlayerConfigItem(982, Integer.valueOf(r111), 1);
    L419:
        return new PlayerConfigItem(952, Integer.valueOf(r111), 1);
    L420:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_HW_DYNAMICDROPPING_CHECKCOUNT, Integer.valueOf(r111), 1);
    L421:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_HW_DYNAMICFRAMEDROPPING_CHECKPERIOD, Integer.valueOf(r111), 1);
    L422:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_HW_DYNAMICFRAMEDROPPING_MULTIPLE, Integer.valueOf(r111), 1);
    L423:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_HW_ENABLE_DYNAMICFRAMEDROPPING, Integer.valueOf(r111), 1);
    L424:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_HW_SETMAXFPS, Integer.valueOf(r111), 1);
    L425:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SUBTITLE_LAZY_LOADING, Integer.valueOf(r111), 1);
    L426:
        return new PlayerConfigItem(1601, Integer.valueOf(r111), 1);
    L427:
        return new PlayerConfigItem(1057, Integer.valueOf(r111), 1);
    L428:
        return new PlayerConfigItem(1056, Integer.valueOf(r111), 1);
    L429:
        return new PlayerConfigItem(1055, Integer.valueOf(r111), 1);
    L430:
        return new PlayerConfigItem(1014, Integer.valueOf(r111), 1);
    L431:
        return new PlayerConfigItem(1012, Integer.valueOf(r111), 1);
    L432:
        return new PlayerConfigItem(1011, Integer.valueOf(r111), 1);
    L433:
        return new PlayerConfigItem(1010, Integer.valueOf(r111), 1);
    L434:
        return new PlayerConfigItem(570, Integer.valueOf(r111), 1, 1);
    L435:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_OPTIMIZE_SEEK_CLK, Integer.valueOf(r111), 1);
    L436:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_OPTIMIZE_INACCURATE_START, Integer.valueOf(r111), 1);
    L437:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIOTRACK_CONTENTTYPE, Integer.valueOf(r111), 1);
    L438:
        return new PlayerConfigItem(678, Integer.valueOf(r111), 1);
    L439:
        return new PlayerConfigItem(672, Integer.valueOf(r111), 1);
    L440:
        return new PlayerConfigItem(1004, Integer.valueOf(r111), 1);
    L441:
        return new PlayerConfigItem(666, Integer.valueOf(r111), 1);
    L442:
        return new PlayerConfigItem(904, Integer.valueOf(r111), 1, -1);
    L443:
        return new PlayerConfigItem(960, Integer.valueOf(r111), 1, 1);
    L444:
        return new PlayerConfigItem(677, Integer.valueOf(r111), 1);
    L445:
        return new PlayerConfigItem(676, Integer.valueOf(r111), 1);
    L446:
        return new PlayerConfigItem(675, Integer.valueOf(r111), 1);
    L447:
        return new PlayerConfigItem(674, Integer.valueOf(r111), 1);
    L448:
        return new PlayerConfigItem(673, Integer.valueOf(r111), 1);
    L449:
        return new PlayerConfigItem(224, Integer.valueOf(r111), 1, 1);
    L450:
        return new PlayerConfigItem(855, Integer.valueOf(r111), 1, 1);
    L451:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_OPT_SUB_SEARCH, Integer.valueOf(r111), 1);
    L452:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_THREAD_SAFE_REF, Integer.valueOf(r111), 1);
    L453:
        return new PlayerConfigItem(660, Integer.valueOf(r111), 1, -1);
    L454:
        return new PlayerConfigItem(257, Integer.valueOf(r111), 1);
    L455:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_OPT_SUB_FIRST_LOAD_TIME, Integer.valueOf(r111), 1);
    L456:
        return new PlayerConfigItem(348, Integer.valueOf(r111), 1);
    L457:
        return new PlayerConfigItem(654, Integer.valueOf(r111), 1);
    L458:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEBUG_UI_NOTIFY, Integer.valueOf(r111), 1);
    L459:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLUSH_SEEK, Integer.valueOf(r111), 1);
    L460:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC, Integer.valueOf(r111), 1, -1);
    L461:
        return new PlayerConfigItem(333, Integer.valueOf(r111), 1);
    L462:
        return new PlayerConfigItem(5003, Integer.valueOf(r111), 1);
    L463:
        return new PlayerConfigItem(539, Integer.valueOf(r111), 1);
    L464:
        return new PlayerConfigItem(538, Integer.valueOf(r111), 1);
    L465:
        return new PlayerConfigItem(537, Integer.valueOf(r111), 1);
    L466:
        return new PlayerConfigItem(536, Integer.valueOf(r111), 1);
    L467:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, Integer.valueOf(r111), 1);
    L468:
        return new PlayerConfigItem(598, Integer.valueOf(r111), 1);
    L469:
        return new PlayerConfigItem(322, Integer.valueOf(r111), 1);
    L470:
        return new PlayerConfigItem(595, Integer.valueOf(r111), 1);
    L471:
        return new PlayerConfigItem(594, Integer.valueOf(r111), 1);
    L472:
        return new PlayerConfigItem(593, Integer.valueOf(r111), 1);
    L473:
        return new PlayerConfigItem(592, Integer.valueOf(r111), 1);
    L474:
        return new PlayerConfigItem(591, Integer.valueOf(r111), 1);
    L475:
        return new PlayerConfigItem(587, Integer.valueOf(r111), 1);
    L476:
        return new PlayerConfigItem(582, Integer.valueOf(r111), 1);
    L477:
        return new PlayerConfigItem(664, Integer.valueOf(r111), 1);
    L478:
        return new PlayerConfigItem(580, Integer.valueOf(r111), 1, -1);
    L479:
        return new PlayerConfigItem(576, Integer.valueOf(r111), 1);
    L480:
        return new PlayerConfigItem(575, Integer.valueOf(r111), 1);
    L481:
        return new PlayerConfigItem(574, Integer.valueOf(r111), 1);
    L482:
        return new PlayerConfigItem(573, Integer.valueOf(r111), 1);
    L483:
        return new PlayerConfigItem(572, Integer.valueOf(r111), 1);
    L484:
        return new PlayerConfigItem(571, Integer.valueOf(r111), 1);
    L485:
        return new PlayerConfigItem(164, Integer.valueOf(r111), 1);
    L486:
        return new PlayerConfigItem(568, Integer.valueOf(r111), 1);
    L487:
        return new PlayerConfigItem(854, Integer.valueOf(r111), 1);
    L488:
        return new PlayerConfigItem(853, Integer.valueOf(r111), 1);
    L489:
        return new PlayerConfigItem(566, Integer.valueOf(r111), 1);
    L490:
        return new PlayerConfigItem(565, Integer.valueOf(r111), 1);
    L491:
        return new PlayerConfigItem(564, Integer.valueOf(r111), 1);
    L492:
        return new PlayerConfigItem(563, Integer.valueOf(r111), 1);
    L493:
        return new PlayerConfigItem(562, Integer.valueOf(r111), 1);
    L494:
        return new PlayerConfigItem(561, Integer.valueOf(r111), 1);
    L495:
        return new PlayerConfigItem(560, Integer.valueOf(r111), 1);
    L496:
        return new PlayerConfigItem(559, Integer.valueOf(r111), 1);
    L497:
        return new PlayerConfigItem(558, Integer.valueOf(r111), 1);
    L498:
        return new PlayerConfigItem(557, Integer.valueOf(r111), 1);
    L499:
        return new PlayerConfigItem(552, Integer.valueOf(r111), 1);
    L500:
        return new PlayerConfigItem(551, Integer.valueOf(r111), 1);
    L501:
        return new PlayerConfigItem(550, Integer.valueOf(r111), 1);
    L502:
        return new PlayerConfigItem(830, Integer.valueOf(r111), 1, 1);
    L503:
        return new PlayerConfigItem(542, Integer.valueOf(r111), 1);
    L504:
        return new PlayerConfigItem(371, Integer.valueOf(r111), 1, 1);
    L505:
        return new PlayerConfigItem(299, Integer.valueOf(r111), 1, 1);
    L506:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX, Integer.valueOf(r111), 1, 1);
    L507:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_BUFFER_LIMIT, Integer.valueOf(r111), 1);
    L508:
        return new PlayerConfigItem(515, Integer.valueOf(r111), 1, 1);
    L509:
        return new PlayerConfigItem(751, Integer.valueOf(r111), 1, -1);
    L232:
        if (FeatureManager.hasPermission(FeatureManager.SUBTITLE_MASK) == true) goto L234;
        TTVideoEngineLog.e(TAG, "set int option failed key:" + r110 + " value:" + r111);
        goto L308
    L234:
        r100 = new EngineConfigItem(r110, Integer.valueOf(r111), 1);
        goto L577
    L510:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE, Integer.valueOf(r111), 1);
    L511:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_GET_CACHE_TIMESTAMP, Integer.valueOf(r111), 1);
    L512:
        return new PlayerConfigItem(613, Integer.valueOf(r111), 1, -1);
    L513:
        return new PlayerConfigItem(146, Integer.valueOf(r111), 1, 1);
    L514:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_OPEN_TIMEOUT, Integer.valueOf(r111), 1, 1);
    L515:
        return new PlayerConfigItem(288, Integer.valueOf(r111), 1, 1);
    L517:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_FRC_LEVEL, Integer.valueOf(r111), 1);
    L518:
        return new PlayerConfigItem(401, Integer.valueOf(r111), 1, -1);
    L519:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS, Integer.valueOf(r111), 1, -1);
    L520:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC, Integer.valueOf(r111), 1);
    L521:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_READ_MODE, Integer.valueOf(r111), 1, 1);
    L522:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_POST_PREPARE, Integer.valueOf(r111), 1);
    L523:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_DELAY_BUFFERING_UPDATE, Integer.valueOf(r111), 1);
    L524:
        return new PlayerConfigItem(262, Integer.valueOf(r111), 1, 1);
    L525:
        return new PlayerConfigItem(256, Integer.valueOf(r111), 1);
    L526:
        return new PlayerConfigItem(260, Integer.valueOf(r111), 1, 1);
    L527:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME, Integer.valueOf(r111), 1, 1);
    L528:
        return new PlayerConfigItem(258, Integer.valueOf(r111), 1, 1);
    L529:
        return new PlayerConfigItem(253, Integer.valueOf(r111), 1);
    L530:
        return new PlayerConfigItem(244, Integer.valueOf(r111), 1, 1);
    L531:
        return new PlayerConfigItem(243, Integer.valueOf(r111), 1, 1);
    L532:
        return new PlayerConfigItem(242, Integer.valueOf(r111), 1, 1);
    L533:
        return new PlayerConfigItem(241, Integer.valueOf(r111), 1, 1);
    L534:
        return new PlayerConfigItem(185, Integer.valueOf(r111), 1);
    L535:
        return new PlayerConfigItem(94, Integer.valueOf(r111), 1);
    L536:
        return new PlayerConfigItem(143, Integer.valueOf(r111), 1, 1);
    L537:
        return new PlayerConfigItem(184, Integer.valueOf(r111), 1, -1);
    L538:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_OPEN_VOICE_IN_PREPARE, Integer.valueOf(r111), 1);
    L539:
        return new PlayerConfigItem(370, Integer.valueOf(r111), 1, 1);
    L540:
        return new PlayerConfigItem(358, Integer.valueOf(r111), 1);
    L541:
        return new PlayerConfigItem(1160, Integer.valueOf(r111), 1, -1);
    L542:
        return new PlayerConfigItem(1159, Integer.valueOf(r111), 1, -1);
    L543:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_TYPE, Integer.valueOf(r111), 1, -1);
    L544:
        return new PlayerConfigItem(98, Integer.valueOf(r111), 1);
    L545:
        return new PlayerConfigItem(280, Integer.valueOf(r111), 1, -1);
    L546:
        return new PlayerConfigItem(254, Integer.valueOf(r111), 1, -1);
    L547:
        return new PlayerConfigItem(400, Integer.valueOf(r111), 1, -1);
    L548:
        return new PlayerConfigItem(248, Integer.valueOf(r111), 1);
    L549:
        return new PlayerConfigItem(247, Integer.valueOf(r111), 1);
    L278:
        if (FeatureManager.hasPermission("volume_balance") == true) goto L550;
        TTVideoEngineLog.e(TAG, "set int option failed key:" + r110 + " value:" + r111);
        goto L308
    L550:
        return new PlayerConfigItem(302, Integer.valueOf(r111), 1, 1);
    L551:
        return new PlayerConfigItem(215, Integer.valueOf(r111), 1, -1);
    L552:
        return new PlayerConfigItem(216, Integer.valueOf(r111), 1, -1);
    L553:
        return new PlayerConfigItem(301, Integer.valueOf(r111), 1);
    L554:
        return new PlayerConfigItem(312, Integer.valueOf(r111), 1);
    L555:
        return new PlayerConfigItem(95, Integer.valueOf(r111), 1);
    L556:
        return new PlayerConfigItem(230, Integer.valueOf(r111), 1, -1);
    L288:
        if (FeatureManager.hasPermission(FeatureManager.PCDN) == true) goto L290;
        TTVideoEngineLog.e(TAG, "set int option failed key:" + r110 + " value:" + r111);
        goto L308
    L290:
        r100 = new EngineConfigItem(r110, Integer.valueOf(r111), 1);
        goto L577
    L557:
        return new PlayerConfigItem(101, Integer.valueOf(r111), 1, -1);
    L558:
        return new PlayerConfigItem(99, Integer.valueOf(r111), 1, -1);
    L559:
        return new PlayerConfigItem(989, Integer.valueOf(r111), 1, 1);
    L560:
        return new PlayerConfigItem(255, Integer.valueOf(r111), 1, 1);
    L561:
        return new PlayerConfigItem(250, Integer.valueOf(r111), 1, 1);
    L562:
        return new PlayerConfigItem(86, Integer.valueOf(r111 * 1000), 1);
    L563:
        return new PlayerConfigItem(201, Integer.valueOf(r111), 1);
    L564:
        return new PlayerConfigItem(90, Integer.valueOf(r111), 1, -1);
    L565:
        return new PlayerConfigItem(86, Integer.valueOf(r111), 1);
    L566:
        return new PlayerConfigItem(189, Integer.valueOf(r111), 1);
    L567:
        return new PlayerConfigItem(154, Integer.valueOf(r111), 1, 1);
    L568:
        return new PlayerConfigItem(138, Integer.valueOf(r111), 1, 1);
    L569:
        return new PlayerConfigItem(137, Integer.valueOf(r111), 1, 1);
    L570:
        return new PlayerConfigItem(81, Integer.valueOf(r111), 1);
    L571:
        return new PlayerConfigItem(67, Integer.valueOf(r111), 1);
    L572:
        return new PlayerConfigItem(192, Integer.valueOf(r111), 1);
    L575:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, Integer.valueOf(r111), 1);
    L576:
        return new PlayerConfigItem(183, Integer.valueOf(r111), 1);
    L578:
        return new PlayerConfigItem(38, Integer.valueOf(r111), 1);
    L579:
        return new PlayerConfigItem(37, Integer.valueOf(r111), 1);
    L317:
        return new PlayerConfigItem(24, Integer.valueOf(r111), 1, -1);
    }

    public ConfigItem createFloatOption(int r100, float r101) {
        if (isCommonPlayerOption(r100) == false) goto L7;
        return new PlayerConfigItem(r100, Float.valueOf(r101), 3);
    L7:
        switch(r100) {
            case 325: goto L26;
            case 326: goto L41;
            case 327: goto L40;
            case 328: goto L39;
            default: goto L8;
        };
    L8:
        switch(r100) {
            case 344: goto L38;
            case 345: goto L37;
            case 346: goto L36;
            case 347: goto L35;
            case 348: goto L34;
            case 349: goto L33;
            case 350: goto L32;
            case 351: goto L31;
            case 352: goto L30;
            case 353: goto L29;
            case 354: goto L28;
            default: goto L9;
        };
    L9:
        switch(r100) {
            case 527: goto L35;
            case 528: goto L35;
            case 529: goto L35;
            default: goto L10;
        };
    L10:
        TTVideoEngineLog.w(TAG, "unknown option key: " + r100 + ", value: " + r101);
        return null;
    L28:
        return new PlayerConfigItem(1157, Float.valueOf(r101), 3, -1);
    L29:
        return new PlayerConfigItem(1156, Float.valueOf(r101), 3, -1);
    L30:
        return new PlayerConfigItem(1155, Float.valueOf(r101), 3, -1);
    L31:
        return new PlayerConfigItem(1154, Float.valueOf(r101), 3, -1);
    L32:
        return new PlayerConfigItem(1153, Float.valueOf(r101), 3, -1);
    L33:
        return new PlayerConfigItem(1152, Float.valueOf(r101), 3, -1);
    L34:
        return new PlayerConfigItem(1151, Float.valueOf(r101), 3, -1);
    L35:
        return new EngineConfigItem(r100, Float.valueOf(r101), 3);
    L36:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_AE_SRC_PEAK, Float.valueOf(r101), 3, -1);
    L37:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_AE_SRC_LUFS, Float.valueOf(r101), 3, -1);
    L38:
        return new PlayerConfigItem(MediaPlayer.MEDIA_PLAYER_OPTION_AE_TAR_LUFS, Float.valueOf(r101), 3, -1);
    L39:
        return new PlayerConfigItem(306, Float.valueOf(r101), 3, -1);
    L40:
        return new PlayerConfigItem(305, Float.valueOf(r101), 3, -1);
    L41:
        return new PlayerConfigItem(304, Float.valueOf(r101), 3, -1);
    L26:
        return new PlayerConfigItem(303, Float.valueOf(r101), 3, -1);
    }

    public ConfigItem createLongOption(int r100, long r101) {
        if (isCommonPlayerOption(r100) == false) goto L7;
        return new PlayerConfigItem(r100, Long.valueOf(r101), 2);
    L7:
        if (r100 == 709) goto L10;
        TTVideoEngineLog.w(TAG, "unknown option key: " + r100 + ", value: " + r101);
        return null;
    L10:
        return new PlayerConfigItem(668, Long.valueOf(r101), 2);
    }

    public ConfigItem createStringOption(int r100, String r101) {
        if (isCommonPlayerOption(r100) == false) goto L7;
        return new PlayerConfigItem(r100, r101, 4);
    L7:
        if (r100 == 355) goto L27;
        if (r100 == 531) goto L32;
        if (r100 == 662) goto L31;
        if (r100 == 1000) goto L32;
        if (r100 == 360) goto L30;
        if (r100 == 361) goto L29;
        switch(r100) {
            case 538: goto L32;
            case 539: goto L32;
            case 540: goto L32;
            default: goto L19;
        };
    L19:
        switch(r100) {
            case 545: goto L32;
            case 546: goto L32;
            case 547: goto L32;
            default: goto L20;
        };
    L20:
        switch(r100) {
            case 1410: goto L32;
            case 1411: goto L32;
            case 1412: goto L32;
            default: goto L21;
        };
    L21:
        TTVideoEngineLog.w(TAG, "unknown option key: " + r100 + ", value: " + r101);
        return null;
    L29:
        return new PlayerConfigItem(1162, r101, 4, -1);
    L30:
        return new PlayerConfigItem(1161, r101, 4, -1);
    L31:
        return new PlayerConfigItem(202, r101, 4, -1);
    L32:
        return new EngineConfigItem(r100, r101, 4);
    L27:
        return new PlayerConfigItem(1158, r101, 4, -1);
    }
}
