package com.larus.im.internal.protocol.bean;

import af9.q0;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DTileBuildType;
import com.amap.api.services.core.AMapException;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ee.bear.bitable.pro.AutomationRule;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.larus.im.internal.network.proto2.AvCmd;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.tencent.connect.common.Constants;
import java.lang.annotation.Annotation;
import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import nuc.i0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\bR\b\u0081\u0081\u0002\u0018\u0000 T2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001TB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bLj\u0002\bMj\u0002\bNj\u0002\bOj\u0002\bPj\u0002\bQj\u0002\bRj\u0002\bS¨\u0006U"}, d2 = {"Lcom/larus/im/internal/protocol/bean/IMCMD;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "IMCMD_NOT_USED", "IMCMD_COMMON", "SEND_MESSAGE", "SEND_MESSAGE_LIST", "NEW_MSG_NOTIFY", "FETCH_CHUNK_MESSAGE", "CHUNK_UPDATE", "PUll_CHAIN_MESSAGE", "PULL_SINGLE_CHAIN", "PULL_CMD_CHAIN", "MARK_CONVERSATION_READ", "CLEAR_MSG_CONTEXT", "CLEAR_MSG_HISTORY", "BATCH_UPDATE_MSG_STATUS", "FEEDBACK_MSG", "REGENERATE_MSG", "FIX_REGENERATE_MSG", "SWITCH_REGENERATE_MSG", "BREAK_MSG", "RETRY_BOT_REPLY_MSG", "MULTI_PUT_MESSAGE_IN", "MULTI_PUT_MESSAGE_OUT", "GET_CONVERSATION_INFO", "BATCH_GET_CONVERSATION_INFO", "OPERATE_CONVERSATION", "DELETE_USER_CONVERSATION", "DISSOLVE_CONVERSATION", "UPDATE_CONVERSATION", "ADD_CONVERSATION_PARTICIPANT", "DEL_CONVERSATION_PARTICIPANT", "DELETE_CONVERSATION_PARTICIPANT", "GET_CONVERSATION_PARTICIPANT", "UPDATE_CONVERSATION_NAME", "BATCH_GET_CONVERSATION_PARTICIPANTS", "UPDATE_CONVERSATION_PARTICIPANT", "BATCH_DEL_USER_CONV", "UPDATE_CREATE_SCENE", "OPERATE_CELL", "REPORT_CONSISTENCY_DATA", "CONVERSATION_OUT", "CONVERSATION_IN", "UPDATE_SECTION", "BATCH_VERIFY_CONVERSATION_CONSISTENCY", "UPDATE_CONVERSATION_PARTICIPANT_NOTIFY", "UPDATE_CONVERSATION_INFO_NOTIFY", "OPERATE_CONVERSATION_NOTIFY", "REFRESH_PARTICIPANT_INFO_NOTIFY", "UPDATE_CONVERSATION_NAME_NOTIFY", "CLEAR_MSG_CONTEXT_NOTIFY", "CLEAR_MSG_HISTORY_NOTIFY", "MARK_READ_NOTIFY", "RED_DOT_NOTIFY", "UPDATE_MSG_STATUS_NOTIFY", "UPDATE_MSG_NOTIFY", "SUGGEST_QUESTION_UPDATE_NOTIFY", "DELETE_USER_CONVERSATION_NOTIFY", "DELETE_PARTICIPANTS_NOTIFY", "FEEDBACK_MSG_NOTIFY", "PULL_MSG_NOTIFY", "FIX_REGENERATE_MSG_NOTIFY", "BREAK_STREAM_MSG_NOTIFY", "DISSOLVE_CONVERSATION_NOTIFY", "COLLECTION_MSG_NOTIFY", "BOT_REPLY_LOADING_UPDATE_NOTIFY", "CANCEL_FOLLOW_NOTIFY", "DELTA_UPDATE_CONVERSATION_INFO_NOTIFY", "USER_BAN", "USER_BAN_RELEASE", "USER_CONFIG_UPDATE", "NEED_LOCATION", "USER_PENALTY_CHANGE_NOTIFY", "CONVERSATION_PENALTY_CHANGE_NOTIFY", "CRON_JOB_EXECUTION_COMPLETED_NOTIFY", "CRON_JOB_UPDATE_NOTIFY", "AUTO_SPEAK", "REPLY_END", "MODIFY_MSG_EXT", "UPDATE_SECTION_NOTIFY", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum IMCMD extends Enum<IMCMD> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ IMCMD[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;

    @SerialName("4100")
    public static final IMCMD ADD_CONVERSATION_PARTICIPANT = null;

    @SerialName("4230")
    public static final IMCMD AUTO_SPEAK = null;

    @SerialName("4171")
    public static final IMCMD BATCH_DEL_USER_CONV = null;

    @SerialName(AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_OUT__NETWORK_NOT_WIFI__SCREEN_OFF)
    public static final IMCMD BATCH_GET_CONVERSATION_INFO = null;

    @SerialName("4160")
    public static final IMCMD BATCH_GET_CONVERSATION_PARTICIPANTS = null;

    @SerialName("2210")
    public static final IMCMD BATCH_UPDATE_MSG_STATUS = null;

    @SerialName("4240")
    public static final IMCMD BATCH_VERIFY_CONVERSATION_CONSISTENCY = null;

    @SerialName("50200")
    public static final IMCMD BOT_REPLY_LOADING_UPDATE_NOTIFY = null;

    @SerialName("2240")
    public static final IMCMD BREAK_MSG = null;

    @SerialName("50100")
    public static final IMCMD BREAK_STREAM_MSG_NOTIFY = null;

    @SerialName("50300")
    public static final IMCMD CANCEL_FOLLOW_NOTIFY = null;

    @SerialName("310")
    public static final IMCMD CHUNK_UPDATE = null;

    @SerialName(AbsBatteryStrategy.AppBg5mCombination.APP_BG_5M__CHARGE_OUT__NETWORK_WIFI__SCREEN_OFF)
    public static final IMCMD CLEAR_MSG_CONTEXT = null;

    @SerialName("50010")
    public static final IMCMD CLEAR_MSG_CONTEXT_NOTIFY = null;

    @SerialName("2202")
    public static final IMCMD CLEAR_MSG_HISTORY = null;

    @SerialName("50020")
    public static final IMCMD CLEAR_MSG_HISTORY_NOTIFY = null;

    @SerialName("50120")
    public static final IMCMD COLLECTION_MSG_NOTIFY = null;

    @SerialName("4210")
    public static final IMCMD CONVERSATION_IN = null;

    @SerialName("4200")
    public static final IMCMD CONVERSATION_OUT = null;

    @SerialName(AutomationRule.AUTOMATION_WORKFLOW_DELETE)
    public static final IMCMD CONVERSATION_PENALTY_CHANGE_NOTIFY = null;

    @SerialName("200001")
    public static final IMCMD CRON_JOB_EXECUTION_COMPLETED_NOTIFY = null;

    @SerialName("200002")
    public static final IMCMD CRON_JOB_UPDATE_NOTIFY = null;
    public static final a Companion = null;

    @SerialName("4111")
    public static final IMCMD DELETE_CONVERSATION_PARTICIPANT = null;

    @SerialName("50062")
    public static final IMCMD DELETE_PARTICIPANTS_NOTIFY = null;

    @SerialName("1121")
    public static final IMCMD DELETE_USER_CONVERSATION = null;

    @SerialName("50060")
    public static final IMCMD DELETE_USER_CONVERSATION_NOTIFY = null;

    @SerialName("51000")
    public static final IMCMD DELTA_UPDATE_CONVERSATION_INFO_NOTIFY = null;

    @SerialName("4110")
    public static final IMCMD DEL_CONVERSATION_PARTICIPANT = null;

    @SerialName("1122")
    public static final IMCMD DISSOLVE_CONVERSATION = null;

    @SerialName("50110")
    public static final IMCMD DISSOLVE_CONVERSATION_NOTIFY = null;

    @SerialName("2220")
    public static final IMCMD FEEDBACK_MSG = null;

    @SerialName("50070")
    public static final IMCMD FEEDBACK_MSG_NOTIFY = null;

    @SerialName("300")
    public static final IMCMD FETCH_CHUNK_MESSAGE = null;

    @SerialName("2231")
    public static final IMCMD FIX_REGENERATE_MSG = null;

    @SerialName("50090")
    public static final IMCMD FIX_REGENERATE_MSG_NOTIFY = null;

    @SerialName(AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_OUT__NETWORK_NOT_WIFI__SCREEN_ON)
    public static final IMCMD GET_CONVERSATION_INFO = null;

    @SerialName("4120")
    public static final IMCMD GET_CONVERSATION_PARTICIPANT = null;

    @SerialName(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ)
    public static final IMCMD IMCMD_COMMON = null;

    @SerialName("0")
    public static final IMCMD IMCMD_NOT_USED = null;

    @SerialName(AbsBatteryStrategy.AppBg5mCombination.APP_BG_5M__CHARGE_OUT__NETWORK_WIFI__SCREEN_ON)
    public static final IMCMD MARK_CONVERSATION_READ = null;

    @SerialName("50030")
    public static final IMCMD MARK_READ_NOTIFY = null;

    @SerialName("50041")
    public static final IMCMD MODIFY_MSG_EXT = null;

    @SerialName("2300")
    public static final IMCMD MULTI_PUT_MESSAGE_IN = null;

    @SerialName("2310")
    public static final IMCMD MULTI_PUT_MESSAGE_OUT = null;

    @SerialName("60020")
    public static final IMCMD NEED_LOCATION = null;

    @SerialName("200")
    public static final IMCMD NEW_MSG_NOTIFY = null;

    @SerialName("4173")
    public static final IMCMD OPERATE_CELL = null;

    @SerialName("1120")
    public static final IMCMD OPERATE_CONVERSATION = null;

    @SerialName("50003")
    public static final IMCMD OPERATE_CONVERSATION_NOTIFY = null;

    @SerialName(AMap3DTileBuildType.WALL)
    public static final IMCMD PULL_CMD_CHAIN = null;

    @SerialName("50080")
    public static final IMCMD PULL_MSG_NOTIFY = null;

    @SerialName(AMap3DTileBuildType.TRAFFIC_BUILDING)
    public static final IMCMD PULL_SINGLE_CHAIN = null;

    @SerialName(AMap3DTileBuildType.HOUSING)
    public static final IMCMD PUll_CHAIN_MESSAGE = null;

    @SerialName("50031")
    public static final IMCMD RED_DOT_NOTIFY = null;

    @SerialName("50004")
    public static final IMCMD REFRESH_PARTICIPANT_INFO_NOTIFY = null;

    @SerialName("2230")
    public static final IMCMD REGENERATE_MSG = null;

    @SerialName("50400")
    public static final IMCMD REPLY_END = null;

    @SerialName("4174")
    public static final IMCMD REPORT_CONSISTENCY_DATA = null;

    @SerialName("2250")
    public static final IMCMD RETRY_BOT_REPLY_MSG = null;

    @SerialName("100")
    public static final IMCMD SEND_MESSAGE = null;

    @SerialName(BDLocationException.ERROR_TMAP_CLIENT)
    public static final IMCMD SEND_MESSAGE_LIST = null;

    @SerialName("50050")
    public static final IMCMD SUGGEST_QUESTION_UPDATE_NOTIFY = null;

    @SerialName("2232")
    public static final IMCMD SWITCH_REGENERATE_MSG = null;

    @SerialName("1123")
    public static final IMCMD UPDATE_CONVERSATION = null;

    @SerialName("50002")
    public static final IMCMD UPDATE_CONVERSATION_INFO_NOTIFY = null;

    @SerialName("4150")
    public static final IMCMD UPDATE_CONVERSATION_NAME = null;

    @SerialName("50005")
    public static final IMCMD UPDATE_CONVERSATION_NAME_NOTIFY = null;

    @SerialName("4170")
    public static final IMCMD UPDATE_CONVERSATION_PARTICIPANT = null;

    @SerialName("50001")
    public static final IMCMD UPDATE_CONVERSATION_PARTICIPANT_NOTIFY = null;

    @SerialName("4172")
    public static final IMCMD UPDATE_CREATE_SCENE = null;

    @SerialName("50042")
    public static final IMCMD UPDATE_MSG_NOTIFY = null;

    @SerialName("50040")
    public static final IMCMD UPDATE_MSG_STATUS_NOTIFY = null;

    @SerialName("4300")
    public static final IMCMD UPDATE_SECTION = null;

    @SerialName("50600")
    public static final IMCMD UPDATE_SECTION_NOTIFY = null;

    @SerialName("60001")
    public static final IMCMD USER_BAN = null;

    @SerialName("60002")
    public static final IMCMD USER_BAN_RELEASE = null;

    @SerialName("60010")
    public static final IMCMD USER_CONFIG_UPDATE = null;

    @SerialName(AutomationRule.AUTOMATION_WORKFLOW_CREATE)
    public static final IMCMD USER_PENALTY_CHANGE_NOTIFY = null;
    public final int value;

    private static final /* synthetic */ IMCMD[] $values() {
        return new IMCMD[]{IMCMD_NOT_USED, IMCMD_COMMON, SEND_MESSAGE, SEND_MESSAGE_LIST, NEW_MSG_NOTIFY, FETCH_CHUNK_MESSAGE, CHUNK_UPDATE, PUll_CHAIN_MESSAGE, PULL_SINGLE_CHAIN, PULL_CMD_CHAIN, MARK_CONVERSATION_READ, CLEAR_MSG_CONTEXT, CLEAR_MSG_HISTORY, BATCH_UPDATE_MSG_STATUS, FEEDBACK_MSG, REGENERATE_MSG, FIX_REGENERATE_MSG, SWITCH_REGENERATE_MSG, BREAK_MSG, RETRY_BOT_REPLY_MSG, MULTI_PUT_MESSAGE_IN, MULTI_PUT_MESSAGE_OUT, GET_CONVERSATION_INFO, BATCH_GET_CONVERSATION_INFO, OPERATE_CONVERSATION, DELETE_USER_CONVERSATION, DISSOLVE_CONVERSATION, UPDATE_CONVERSATION, ADD_CONVERSATION_PARTICIPANT, DEL_CONVERSATION_PARTICIPANT, DELETE_CONVERSATION_PARTICIPANT, GET_CONVERSATION_PARTICIPANT, UPDATE_CONVERSATION_NAME, BATCH_GET_CONVERSATION_PARTICIPANTS, UPDATE_CONVERSATION_PARTICIPANT, BATCH_DEL_USER_CONV, UPDATE_CREATE_SCENE, OPERATE_CELL, REPORT_CONSISTENCY_DATA, CONVERSATION_OUT, CONVERSATION_IN, UPDATE_SECTION, BATCH_VERIFY_CONVERSATION_CONSISTENCY, UPDATE_CONVERSATION_PARTICIPANT_NOTIFY, UPDATE_CONVERSATION_INFO_NOTIFY, OPERATE_CONVERSATION_NOTIFY, REFRESH_PARTICIPANT_INFO_NOTIFY, UPDATE_CONVERSATION_NAME_NOTIFY, CLEAR_MSG_CONTEXT_NOTIFY, CLEAR_MSG_HISTORY_NOTIFY, MARK_READ_NOTIFY, RED_DOT_NOTIFY, UPDATE_MSG_STATUS_NOTIFY, UPDATE_MSG_NOTIFY, SUGGEST_QUESTION_UPDATE_NOTIFY, DELETE_USER_CONVERSATION_NOTIFY, DELETE_PARTICIPANTS_NOTIFY, FEEDBACK_MSG_NOTIFY, PULL_MSG_NOTIFY, FIX_REGENERATE_MSG_NOTIFY, BREAK_STREAM_MSG_NOTIFY, DISSOLVE_CONVERSATION_NOTIFY, COLLECTION_MSG_NOTIFY, BOT_REPLY_LOADING_UPDATE_NOTIFY, CANCEL_FOLLOW_NOTIFY, DELTA_UPDATE_CONVERSATION_INFO_NOTIFY, USER_BAN, USER_BAN_RELEASE, USER_CONFIG_UPDATE, NEED_LOCATION, USER_PENALTY_CHANGE_NOTIFY, CONVERSATION_PENALTY_CHANGE_NOTIFY, CRON_JOB_EXECUTION_COMPLETED_NOTIFY, CRON_JOB_UPDATE_NOTIFY, AUTO_SPEAK, REPLY_END, MODIFY_MSG_EXT, UPDATE_SECTION_NOTIFY};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    public static EnumEntries<IMCMD> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v80, types: [com.larus.im.internal.protocol.bean.IMCMD$a] */
    static {
        IMCMD_NOT_USED = new IMCMD("IMCMD_NOT_USED", 0, 0);
        IMCMD_COMMON = new IMCMD("IMCMD_COMMON", 1, 10);
        SEND_MESSAGE = new IMCMD("SEND_MESSAGE", 2, 100);
        SEND_MESSAGE_LIST = new IMCMD("SEND_MESSAGE_LIST", 3, 110);
        NEW_MSG_NOTIFY = new IMCMD("NEW_MSG_NOTIFY", 4, 200);
        FETCH_CHUNK_MESSAGE = new IMCMD("FETCH_CHUNK_MESSAGE", 5, 300);
        CHUNK_UPDATE = new IMCMD("CHUNK_UPDATE", 6, 310);
        PUll_CHAIN_MESSAGE = new IMCMD("PUll_CHAIN_MESSAGE", 7, 3000);
        PULL_SINGLE_CHAIN = new IMCMD("PULL_SINGLE_CHAIN", 8, 3100);
        PULL_CMD_CHAIN = new IMCMD("PULL_CMD_CHAIN", 9, 3300);
        MARK_CONVERSATION_READ = new IMCMD("MARK_CONVERSATION_READ", 10, 2100);
        CLEAR_MSG_CONTEXT = new IMCMD("CLEAR_MSG_CONTEXT", 11, 2101);
        CLEAR_MSG_HISTORY = new IMCMD("CLEAR_MSG_HISTORY", 12, AMapException.CODE_AMAP_CLIENT_NEARBY_NULL_RESULT);
        BATCH_UPDATE_MSG_STATUS = new IMCMD("BATCH_UPDATE_MSG_STATUS", 13, 2210);
        FEEDBACK_MSG = new IMCMD("FEEDBACK_MSG", 14, 2220);
        REGENERATE_MSG = new IMCMD("REGENERATE_MSG", 15, 2230);
        FIX_REGENERATE_MSG = new IMCMD("FIX_REGENERATE_MSG", 16, 2231);
        SWITCH_REGENERATE_MSG = new IMCMD("SWITCH_REGENERATE_MSG", 17, 2232);
        BREAK_MSG = new IMCMD("BREAK_MSG", 18, 2240);
        RETRY_BOT_REPLY_MSG = new IMCMD("RETRY_BOT_REPLY_MSG", 19, 2250);
        MULTI_PUT_MESSAGE_IN = new IMCMD("MULTI_PUT_MESSAGE_IN", 20, SpeechEngineDefines.MESSAGE_TYPE_CONNECTION_START);
        MULTI_PUT_MESSAGE_OUT = new IMCMD("MULTI_PUT_MESSAGE_OUT", 21, 2310);
        GET_CONVERSATION_INFO = new IMCMD("GET_CONVERSATION_INFO", 22, 1110);
        BATCH_GET_CONVERSATION_INFO = new IMCMD("BATCH_GET_CONVERSATION_INFO", 23, 1111);
        OPERATE_CONVERSATION = new IMCMD("OPERATE_CONVERSATION", 24, 1120);
        DELETE_USER_CONVERSATION = new IMCMD("DELETE_USER_CONVERSATION", 25, 1121);
        DISSOLVE_CONVERSATION = new IMCMD("DISSOLVE_CONVERSATION", 26, 1122);
        UPDATE_CONVERSATION = new IMCMD("UPDATE_CONVERSATION", 27, 1123);
        ADD_CONVERSATION_PARTICIPANT = new IMCMD("ADD_CONVERSATION_PARTICIPANT", 28, 4100);
        DEL_CONVERSATION_PARTICIPANT = new IMCMD("DEL_CONVERSATION_PARTICIPANT", 29, 4110);
        DELETE_CONVERSATION_PARTICIPANT = new IMCMD("DELETE_CONVERSATION_PARTICIPANT", 30, 4111);
        GET_CONVERSATION_PARTICIPANT = new IMCMD("GET_CONVERSATION_PARTICIPANT", 31, 4120);
        UPDATE_CONVERSATION_NAME = new IMCMD("UPDATE_CONVERSATION_NAME", 32, 4150);
        BATCH_GET_CONVERSATION_PARTICIPANTS = new IMCMD("BATCH_GET_CONVERSATION_PARTICIPANTS", 33, 4160);
        UPDATE_CONVERSATION_PARTICIPANT = new IMCMD("UPDATE_CONVERSATION_PARTICIPANT", 34, 4170);
        BATCH_DEL_USER_CONV = new IMCMD("BATCH_DEL_USER_CONV", 35, 4171);
        UPDATE_CREATE_SCENE = new IMCMD("UPDATE_CREATE_SCENE", 36, 4172);
        OPERATE_CELL = new IMCMD("OPERATE_CELL", 37, 4173);
        REPORT_CONSISTENCY_DATA = new IMCMD("REPORT_CONSISTENCY_DATA", 38, 4174);
        CONVERSATION_OUT = new IMCMD("CONVERSATION_OUT", 39, TTVideoEngineInterface.PLAYER_OPTION_DISABLE_THREAD_POOL_USING);
        CONVERSATION_IN = new IMCMD("CONVERSATION_IN", 40, 4210);
        UPDATE_SECTION = new IMCMD("UPDATE_SECTION", 41, 4300);
        BATCH_VERIFY_CONVERSATION_CONSISTENCY = new IMCMD("BATCH_VERIFY_CONVERSATION_CONSISTENCY", 42, 4240);
        UPDATE_CONVERSATION_PARTICIPANT_NOTIFY = new IMCMD("UPDATE_CONVERSATION_PARTICIPANT_NOTIFY", 43, TTVideoEngineInterface.ALGO_OPTION_INT_STOP_BACKGROUND);
        UPDATE_CONVERSATION_INFO_NOTIFY = new IMCMD("UPDATE_CONVERSATION_INFO_NOTIFY", 44, TTVideoEngineInterface.ALGO_OPTION_INT_STOP_TASK_END_PLAY);
        OPERATE_CONVERSATION_NOTIFY = new IMCMD("OPERATE_CONVERSATION_NOTIFY", 45, TTVideoEngineInterface.ALGO_OPTION_INT_CACHE_TIMESTAMP);
        REFRESH_PARTICIPANT_INFO_NOTIFY = new IMCMD("REFRESH_PARTICIPANT_INFO_NOTIFY", 46, TTVideoEngineInterface.ALGO_OPTION_INT_CHECK_EXITED_LC);
        UPDATE_CONVERSATION_NAME_NOTIFY = new IMCMD("UPDATE_CONVERSATION_NAME_NOTIFY", 47, TTVideoEngineInterface.ALGO_OPTION_INT_CHECK_ORIGIN_LC);
        CLEAR_MSG_CONTEXT_NOTIFY = new IMCMD("CLEAR_MSG_CONTEXT_NOTIFY", 48, TTVideoEngineInterface.ALGO_OPTION_PAUSE_IO_WHEN_REQ_END);
        CLEAR_MSG_HISTORY_NOTIFY = new IMCMD("CLEAR_MSG_HISTORY_NOTIFY", 49, 50020);
        MARK_READ_NOTIFY = new IMCMD("MARK_READ_NOTIFY", 50, 50030);
        RED_DOT_NOTIFY = new IMCMD("RED_DOT_NOTIFY", 51, 50031);
        UPDATE_MSG_STATUS_NOTIFY = new IMCMD("UPDATE_MSG_STATUS_NOTIFY", 52, 50040);
        UPDATE_MSG_NOTIFY = new IMCMD("UPDATE_MSG_NOTIFY", 53, 50042);
        SUGGEST_QUESTION_UPDATE_NOTIFY = new IMCMD("SUGGEST_QUESTION_UPDATE_NOTIFY", 54, 50050);
        DELETE_USER_CONVERSATION_NOTIFY = new IMCMD("DELETE_USER_CONVERSATION_NOTIFY", 55, 50060);
        DELETE_PARTICIPANTS_NOTIFY = new IMCMD("DELETE_PARTICIPANTS_NOTIFY", 56, 50062);
        FEEDBACK_MSG_NOTIFY = new IMCMD("FEEDBACK_MSG_NOTIFY", 57, 50070);
        PULL_MSG_NOTIFY = new IMCMD("PULL_MSG_NOTIFY", 58, TTVideoEngineInterface.ALGO_OPTION_USE_ENGINE_NETWORK_TIMEOUT);
        FIX_REGENERATE_MSG_NOTIFY = new IMCMD("FIX_REGENERATE_MSG_NOTIFY", 59, 50090);
        BREAK_STREAM_MSG_NOTIFY = new IMCMD("BREAK_STREAM_MSG_NOTIFY", 60, 50100);
        DISSOLVE_CONVERSATION_NOTIFY = new IMCMD("DISSOLVE_CONVERSATION_NOTIFY", 61, 50110);
        COLLECTION_MSG_NOTIFY = new IMCMD("COLLECTION_MSG_NOTIFY", 62, 50120);
        BOT_REPLY_LOADING_UPDATE_NOTIFY = new IMCMD("BOT_REPLY_LOADING_UPDATE_NOTIFY", 63, 50200);
        CANCEL_FOLLOW_NOTIFY = new IMCMD("CANCEL_FOLLOW_NOTIFY", 64, 50300);
        DELTA_UPDATE_CONVERSATION_INFO_NOTIFY = new IMCMD("DELTA_UPDATE_CONVERSATION_INFO_NOTIFY", 65, 51000);
        USER_BAN = new IMCMD("USER_BAN", 66, AvCmd.CommandEventType.SPEECH_ONLY_VALUE);
        USER_BAN_RELEASE = new IMCMD("USER_BAN_RELEASE", 67, 60002);
        USER_CONFIG_UPDATE = new IMCMD("USER_CONFIG_UPDATE", 68, 60010);
        NEED_LOCATION = new IMCMD("NEED_LOCATION", 69, 60020);
        USER_PENALTY_CHANGE_NOTIFY = new IMCMD("USER_PENALTY_CHANGE_NOTIFY", 70, 80001);
        CONVERSATION_PENALTY_CHANGE_NOTIFY = new IMCMD("CONVERSATION_PENALTY_CHANGE_NOTIFY", 71, 80002);
        CRON_JOB_EXECUTION_COMPLETED_NOTIFY = new IMCMD("CRON_JOB_EXECUTION_COMPLETED_NOTIFY", 72, 200001);
        CRON_JOB_UPDATE_NOTIFY = new IMCMD("CRON_JOB_UPDATE_NOTIFY", 73, 200002);
        AUTO_SPEAK = new IMCMD("AUTO_SPEAK", 74, 4230);
        REPLY_END = new IMCMD("REPLY_END", 75, 50400);
        MODIFY_MSG_EXT = new IMCMD("MODIFY_MSG_EXT", 76, 50041);
        UPDATE_SECTION_NOTIFY = new IMCMD("UPDATE_SECTION_NOTIFY", 77, 50600);
        IMCMD[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new q0());
    }

    public static IMCMD[] values() {
        return (IMCMD[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.internal.protocol.bean.IMCMD", values(), new String[]{"0", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, "100", BDLocationException.ERROR_TMAP_CLIENT, "200", "300", "310", AMap3DTileBuildType.HOUSING, AMap3DTileBuildType.TRAFFIC_BUILDING, AMap3DTileBuildType.WALL, AbsBatteryStrategy.AppBg5mCombination.APP_BG_5M__CHARGE_OUT__NETWORK_WIFI__SCREEN_ON, AbsBatteryStrategy.AppBg5mCombination.APP_BG_5M__CHARGE_OUT__NETWORK_WIFI__SCREEN_OFF, "2202", "2210", "2220", "2230", "2231", "2232", "2240", "2250", "2300", "2310", AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_OUT__NETWORK_NOT_WIFI__SCREEN_ON, AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_OUT__NETWORK_NOT_WIFI__SCREEN_OFF, "1120", "1121", "1122", "1123", "4100", "4110", "4111", "4120", "4150", "4160", "4170", "4171", "4172", "4173", "4174", "4200", "4210", "4300", "4240", "50001", "50002", "50003", "50004", "50005", "50010", "50020", "50030", "50031", "50040", "50042", "50050", "50060", "50062", "50070", "50080", "50090", "50100", "50110", "50120", "50200", "50300", "51000", "60001", "60002", "60010", "60020", AutomationRule.AUTOMATION_WORKFLOW_CREATE, AutomationRule.AUTOMATION_WORKFLOW_DELETE, "200001", "200002", "4230", "50400", "50041", "50600"}, new Annotation[][]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static IMCMD valueOf(String r100) {
        return (IMCMD) r27.a.a(IMCMD.class, r100);
    }

    private IMCMD(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
