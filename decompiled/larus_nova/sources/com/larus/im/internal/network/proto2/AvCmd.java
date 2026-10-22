package com.larus.im.internal.network.proto2;

import com.alibaba.gaiax.model.GXAnimation;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
public final class AvCmd {
    private static Descriptors.FileDescriptor descriptor;

    public static final enum AVCMD extends Enum<AVCMD> implements ProtocolMessageEnum {
        private static final /* synthetic */ AVCMD[] $VALUES = null;
        public static final AVCMD COMMAND_SIGNAL_DOWNLINK = null;
        public static final int COMMAND_SIGNAL_DOWNLINK_VALUE = 30001;
        public static final AVCMD COMMAND_SIGNAL_UPLINK = null;
        public static final int COMMAND_SIGNAL_UPLINK_VALUE = 10003;
        public static final AVCMD FILE_DOWNLINK = null;
        public static final int FILE_DOWNLINK_VALUE = 40001;
        public static final AVCMD FILE_UPLINK = null;
        public static final int FILE_UPLINK_VALUE = 10004;
        public static final AVCMD FINISH_SESSION = null;
        public static final int FINISH_SESSION_VALUE = 10002;
        public static final AVCMD QUERY_BEGIN = null;
        public static final int QUERY_BEGIN_VALUE = 20003;
        public static final AVCMD QUERY_END = null;
        public static final int QUERY_END_VALUE = 20005;
        public static final AVCMD QUERY_UPDATE = null;
        public static final int QUERY_UPDATE_VALUE = 20004;
        public static final AVCMD REPLY_BEGIN = null;
        public static final int REPLY_BEGIN_VALUE = 20006;
        public static final AVCMD REPLY_END = null;
        public static final int REPLY_END_VALUE = 20008;
        public static final AVCMD REPLY_UPDATE = null;
        public static final int REPLY_UPDATE_VALUE = 20007;
        public static final AVCMD SESSION_FINISHED = null;
        public static final int SESSION_FINISHED_VALUE = 20002;
        public static final AVCMD SESSION_STARTED = null;
        public static final int SESSION_STARTED_VALUE = 20001;
        public static final AVCMD START_SESSION = null;
        public static final int START_SESSION_VALUE = 10001;
        public static final AVCMD UNRECOGNIZED = null;
        public static final AVCMD UNUSED = null;
        public static final int UNUSED_VALUE = 0;
        private static final AVCMD[] VALUES = null;
        private static final Internal.EnumLiteMap<AVCMD> internalValueMap = null;
        private final int value;

        static {
            AVCMD r100 = new AVCMD("UNUSED", 0, 0);
            UNUSED = r100;
            AVCMD r101 = new AVCMD("START_SESSION", 1, 10001);
            START_SESSION = r101;
            AVCMD r102 = new AVCMD("FINISH_SESSION", 2, 10002);
            FINISH_SESSION = r102;
            AVCMD r103 = new AVCMD("COMMAND_SIGNAL_UPLINK", 3, 10003);
            COMMAND_SIGNAL_UPLINK = r103;
            AVCMD r104 = new AVCMD("FILE_UPLINK", 4, 10004);
            FILE_UPLINK = r104;
            AVCMD r105 = new AVCMD("SESSION_STARTED", 5, 20001);
            SESSION_STARTED = r105;
            AVCMD r110 = new AVCMD("SESSION_FINISHED", 6, 20002);
            SESSION_FINISHED = r110;
            AVCMD r111 = new AVCMD("QUERY_BEGIN", 7, 20003);
            QUERY_BEGIN = r111;
            AVCMD r112 = new AVCMD("QUERY_UPDATE", 8, 20004);
            QUERY_UPDATE = r112;
            AVCMD r113 = new AVCMD("QUERY_END", 9, 20005);
            QUERY_END = r113;
            AVCMD r114 = new AVCMD("REPLY_BEGIN", 10, 20006);
            REPLY_BEGIN = r114;
            AVCMD r106 = new AVCMD("REPLY_UPDATE", 11, 20007);
            REPLY_UPDATE = r106;
            AVCMD r107 = new AVCMD("REPLY_END", 12, 20008);
            REPLY_END = r107;
            AVCMD r108 = new AVCMD("COMMAND_SIGNAL_DOWNLINK", 13, 30001);
            COMMAND_SIGNAL_DOWNLINK = r108;
            AVCMD r109 = new AVCMD("FILE_DOWNLINK", 14, 40001);
            FILE_DOWNLINK = r109;
            AVCMD r115 = new AVCMD("UNRECOGNIZED", 15, -1);
            UNRECOGNIZED = r115;
            $VALUES = new AVCMD[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115};
            internalValueMap = new AnonymousClass1();
            VALUES = values();
        }

        public static AVCMD[] values() {
            return (AVCMD[]) $VALUES.clone();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) goto L7;
            return this.value;
        L7:
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return (Descriptors.EnumDescriptor) ListProtector.get(AvCmd.getDescriptor().getEnumTypes(), 0);
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return (Descriptors.EnumValueDescriptor) ListProtector.get(getDescriptor().getValues(), ordinal());
        }

        public static Internal.EnumLiteMap<AVCMD> internalGetValueMap() {
            return internalValueMap;
        }

        public static AVCMD forNumber(int r100) {
            if (r100 == 0) goto L40;
            if (r100 == 30001) goto L38;
            if (r100 == 40001) goto L36;
            switch(r100) {
                case 10001: goto L34;
                case 10002: goto L32;
                case 10003: goto L30;
                case 10004: goto L28;
                default: goto L8;
            };
        L8:
            switch(r100) {
                case 20001: goto L26;
                case 20002: goto L24;
                case 20003: goto L22;
                case 20004: goto L20;
                case 20005: goto L18;
                case 20006: goto L16;
                case 20007: goto L14;
                case 20008: goto L12;
                default: goto L9;
            };
        L9:
            return null;
        L12:
            return REPLY_END;
        L14:
            return REPLY_UPDATE;
        L16:
            return REPLY_BEGIN;
        L18:
            return QUERY_END;
        L20:
            return QUERY_UPDATE;
        L22:
            return QUERY_BEGIN;
        L24:
            return SESSION_FINISHED;
        L26:
            return SESSION_STARTED;
        L28:
            return FILE_UPLINK;
        L30:
            return COMMAND_SIGNAL_UPLINK;
        L32:
            return FINISH_SESSION;
        L34:
            return START_SESSION;
        L36:
            return FILE_DOWNLINK;
        L38:
            return COMMAND_SIGNAL_DOWNLINK;
        L40:
            return UNUSED;
        }

        public static AVCMD valueOf(Descriptors.EnumValueDescriptor r100) {
            if (r100.getType() != getDescriptor()) goto L11;
            if (r100.getIndex() != (-1)) goto L9;
            return UNRECOGNIZED;
        L9:
            return VALUES[r100.getIndex()];
        L11:
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        public static AVCMD valueOf(String r100) {
            return (AVCMD) a.a(AVCMD.class, r100);
        }

        public static AVCMD valueOf(int r100) {
            return forNumber(r100);
        }

        private AVCMD(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum ChatReplyType extends Enum<ChatReplyType> implements ProtocolMessageEnum {
        private static final /* synthetic */ ChatReplyType[] $VALUES = null;
        public static final ChatReplyType EMPTY = null;
        public static final int EMPTY_VALUE = 0;
        public static final ChatReplyType NORMAL = null;
        public static final int NORMAL_VALUE = 1;
        public static final ChatReplyType PLUGIN = null;
        public static final int PLUGIN_VALUE = 2;
        public static final ChatReplyType UNRECOGNIZED = null;
        private static final ChatReplyType[] VALUES = null;
        private static final Internal.EnumLiteMap<ChatReplyType> internalValueMap = null;
        private final int value;

        static {
            ChatReplyType r100 = new ChatReplyType("EMPTY", 0, 0);
            EMPTY = r100;
            ChatReplyType r101 = new ChatReplyType(EffectConstants.NORMAL, 1, 1);
            NORMAL = r101;
            ChatReplyType r102 = new ChatReplyType("PLUGIN", 2, 2);
            PLUGIN = r102;
            ChatReplyType r103 = new ChatReplyType("UNRECOGNIZED", 3, -1);
            UNRECOGNIZED = r103;
            $VALUES = new ChatReplyType[]{r100, r101, r102, r103};
            internalValueMap = new AnonymousClass1();
            VALUES = values();
        }

        public static ChatReplyType[] values() {
            return (ChatReplyType[]) $VALUES.clone();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) goto L7;
            return this.value;
        L7:
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return (Descriptors.EnumDescriptor) ListProtector.get(AvCmd.getDescriptor().getEnumTypes(), 5);
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return (Descriptors.EnumValueDescriptor) ListProtector.get(getDescriptor().getValues(), ordinal());
        }

        public static Internal.EnumLiteMap<ChatReplyType> internalGetValueMap() {
            return internalValueMap;
        }

        public static ChatReplyType forNumber(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return PLUGIN;
        L12:
            return NORMAL;
        L14:
            return EMPTY;
        }

        public static ChatReplyType valueOf(Descriptors.EnumValueDescriptor r100) {
            if (r100.getType() != getDescriptor()) goto L11;
            if (r100.getIndex() != (-1)) goto L9;
            return UNRECOGNIZED;
        L9:
            return VALUES[r100.getIndex()];
        L11:
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        public static ChatReplyType valueOf(String r100) {
            return (ChatReplyType) a.a(ChatReplyType.class, r100);
        }

        public static ChatReplyType valueOf(int r100) {
            return forNumber(r100);
        }

        private ChatReplyType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum ChildReplyType extends Enum<ChildReplyType> implements ProtocolMessageEnum {
        private static final /* synthetic */ ChildReplyType[] $VALUES = null;
        public static final ChildReplyType REPLY_SENTENCE = null;
        public static final int REPLY_SENTENCE_VALUE = 1;
        public static final ChildReplyType REPLY_TEXT = null;
        public static final int REPLY_TEXT_VALUE = 0;
        public static final ChildReplyType REPLY_THINK = null;
        public static final int REPLY_THINK_VALUE = 2;
        public static final ChildReplyType UNRECOGNIZED = null;
        private static final ChildReplyType[] VALUES = null;
        private static final Internal.EnumLiteMap<ChildReplyType> internalValueMap = null;
        private final int value;

        static {
            ChildReplyType r100 = new ChildReplyType("REPLY_TEXT", 0, 0);
            REPLY_TEXT = r100;
            ChildReplyType r101 = new ChildReplyType("REPLY_SENTENCE", 1, 1);
            REPLY_SENTENCE = r101;
            ChildReplyType r102 = new ChildReplyType("REPLY_THINK", 2, 2);
            REPLY_THINK = r102;
            ChildReplyType r103 = new ChildReplyType("UNRECOGNIZED", 3, -1);
            UNRECOGNIZED = r103;
            $VALUES = new ChildReplyType[]{r100, r101, r102, r103};
            internalValueMap = new AnonymousClass1();
            VALUES = values();
        }

        public static ChildReplyType[] values() {
            return (ChildReplyType[]) $VALUES.clone();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) goto L7;
            return this.value;
        L7:
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return (Descriptors.EnumDescriptor) ListProtector.get(AvCmd.getDescriptor().getEnumTypes(), 2);
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return (Descriptors.EnumValueDescriptor) ListProtector.get(getDescriptor().getValues(), ordinal());
        }

        public static Internal.EnumLiteMap<ChildReplyType> internalGetValueMap() {
            return internalValueMap;
        }

        public static ChildReplyType forNumber(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return REPLY_THINK;
        L12:
            return REPLY_SENTENCE;
        L14:
            return REPLY_TEXT;
        }

        public static ChildReplyType valueOf(Descriptors.EnumValueDescriptor r100) {
            if (r100.getType() != getDescriptor()) goto L11;
            if (r100.getIndex() != (-1)) goto L9;
            return UNRECOGNIZED;
        L9:
            return VALUES[r100.getIndex()];
        L11:
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        public static ChildReplyType valueOf(String r100) {
            return (ChildReplyType) a.a(ChildReplyType.class, r100);
        }

        public static ChildReplyType valueOf(int r100) {
            return forNumber(r100);
        }

        private ChildReplyType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum CommandEventType extends Enum<CommandEventType> implements ProtocolMessageEnum {
        private static final /* synthetic */ CommandEventType[] $VALUES = null;
        public static final CommandEventType AI_PROACTIVE_NOTIFY = null;
        public static final int AI_PROACTIVE_NOTIFY_VALUE = 27001;
        public static final CommandEventType ANCS_SUMMARY_TRIGGERED = null;
        public static final int ANCS_SUMMARY_TRIGGERED_VALUE = 23008;
        public static final CommandEventType ASR_NOISE_INFO = null;
        public static final int ASR_NOISE_INFO_VALUE = 20010;
        public static final CommandEventType ASR_SV_INFO = null;
        public static final int ASR_SV_INFO_VALUE = 20011;
        public static final CommandEventType AUDIO_ROUND_TRACE = null;
        public static final int AUDIO_ROUND_TRACE_VALUE = 80001;
        public static final CommandEventType AUTH_DENY_TRIGGERED = null;
        public static final int AUTH_DENY_TRIGGERED_VALUE = 21003;
        public static final CommandEventType AUTH_FAILED_TRIGGERED = null;
        public static final int AUTH_FAILED_TRIGGERED_VALUE = 23002;
        public static final CommandEventType AUTH_SUCCESS_TRIGGERED = null;
        public static final int AUTH_SUCCESS_TRIGGERED_VALUE = 21002;
        public static final CommandEventType CLIENT_INTENT = null;
        public static final CommandEventType CLIENT_INTENT_RESP = null;
        public static final int CLIENT_INTENT_RESP_VALUE = 14023;
        public static final int CLIENT_INTENT_VALUE = 14022;
        public static final CommandEventType CLIENT_SYNC = null;
        public static final int CLIENT_SYNC_VALUE = 80002;
        public static final CommandEventType CLIM_IN_END = null;
        public static final int CLIM_IN_END_VALUE = 22013;
        public static final CommandEventType CLIM_IN_STARTED = null;
        public static final int CLIM_IN_STARTED_VALUE = 22012;
        public static final CommandEventType COMMON_AUDIO_CONFIG = null;
        public static final int COMMON_AUDIO_CONFIG_VALUE = 20012;
        public static final CommandEventType COMMON_UNUSED = null;
        public static final int COMMON_UNUSED_VALUE = 0;
        public static final CommandEventType CONTINUE = null;
        public static final CommandEventType CONTINUE_RESP = null;
        public static final int CONTINUE_RESP_VALUE = 20004;
        public static final CommandEventType CONTINUE_TYPE_TRIGGERED = null;
        public static final int CONTINUE_TYPE_TRIGGERED_VALUE = 23007;
        public static final int CONTINUE_VALUE = 10005;
        public static final CommandEventType DOWNLINK_HANG_UP = null;
        public static final int DOWNLINK_HANG_UP_VALUE = 25003;
        public static final CommandEventType DOWNLINK_QUOTA_EXCEEDED = null;
        public static final int DOWNLINK_QUOTA_EXCEEDED_VALUE = 25005;
        public static final CommandEventType DOWNLINK_TRANSMIT_REPLY = null;
        public static final int DOWNLINK_TRANSMIT_REPLY_VALUE = 25004;
        public static final CommandEventType END_ASR = null;
        public static final int END_ASR_VALUE = 10006;
        public static final CommandEventType ENTER_DIALOGUE_RESP = null;
        public static final int ENTER_DIALOGUE_RESP_VALUE = 14020;
        public static final CommandEventType EXIT_DIALOGUE_RESP = null;
        public static final int EXIT_DIALOGUE_RESP_VALUE = 14021;
        public static final CommandEventType Enter_DIALOGUE = null;
        public static final int Enter_DIALOGUE_VALUE = 14010;
        public static final CommandEventType Exit_DIALOGUE = null;
        public static final int Exit_DIALOGUE_VALUE = 14011;
        public static final CommandEventType FINISH_LOADING = null;
        public static final int FINISH_LOADING_VALUE = 25002;
        public static final CommandEventType HANGUP_TRIGGERED = null;
        public static final int HANGUP_TRIGGERED_VALUE = 21005;
        public static final CommandEventType HELLO_TRIGGERED = null;
        public static final int HELLO_TRIGGERED_VALUE = 21001;
        public static final CommandEventType IMAGE_TRIGGERED = null;
        public static final int IMAGE_TRIGGERED_VALUE = 23010;
        public static final CommandEventType INTERPRET_ASR_STARTED = null;
        public static final int INTERPRET_ASR_STARTED_VALUE = 22014;
        public static final CommandEventType INTERPRET_FINISH = null;
        public static final int INTERPRET_FINISH_VALUE = 22015;
        public static final CommandEventType INTERRUPT = null;
        public static final int INTERRUPT_VALUE = 10001;
        public static final CommandEventType MODAL_SWITCHED = null;
        public static final int MODAL_SWITCHED_VALUE = 24004;
        public static final CommandEventType MUSIC_PLAYED_TRIGGERED = null;
        public static final int MUSIC_PLAYED_TRIGGERED_VALUE = 23005;
        public static final CommandEventType MUTE = null;
        public static final CommandEventType MUTE_RESP = null;
        public static final int MUTE_RESP_VALUE = 20001;
        public static final int MUTE_VALUE = 10002;
        public static final CommandEventType NOISY_TRIGGERED = null;
        public static final int NOISY_TRIGGERED_VALUE = 23001;
        public static final CommandEventType ONBOARDING_START_TRIGGERED = null;
        public static final int ONBOARDING_START_TRIGGERED_VALUE = 23003;
        public static final CommandEventType PAUSE = null;
        public static final CommandEventType PAUSE_RESP = null;
        public static final int PAUSE_RESP_VALUE = 20003;
        public static final int PAUSE_VALUE = 10004;
        public static final CommandEventType PING = null;
        public static final int PING_VALUE = 1;
        public static final CommandEventType PONG = null;
        public static final int PONG_VALUE = 2;
        public static final CommandEventType POST_BACK_AUDIO_CONFIG = null;
        public static final int POST_BACK_AUDIO_CONFIG_VALUE = 20006;
        public static final CommandEventType PreFetch = null;
        public static final int PreFetch_VALUE = 110102;
        public static final CommandEventType PreInterrupted = null;
        public static final int PreInterrupted_VALUE = 110101;
        public static final CommandEventType QueryRejected = null;
        public static final int QueryRejected_VALUE = 110103;
        public static final CommandEventType REQUEST_CHAT_TRIGGER = null;
        public static final int REQUEST_CHAT_TRIGGER_VALUE = 23009;
        public static final CommandEventType RETRY_NEW_ROUND = null;
        public static final int RETRY_NEW_ROUND_VALUE = 20007;
        public static final CommandEventType SCENE_SWITCHED = null;
        public static final int SCENE_SWITCHED_VALUE = 24002;
        public static final CommandEventType SEND_IMAGE = null;
        public static final int SEND_IMAGE_VALUE = 14001;
        public static final CommandEventType SPEECH_ENDED = null;
        public static final int SPEECH_ENDED_VALUE = 23012;
        public static final CommandEventType SPEECH_ONLY = null;
        public static final int SPEECH_ONLY_VALUE = 60001;
        public static final CommandEventType SPEECH_STARTED = null;
        public static final int SPEECH_STARTED_VALUE = 23011;
        public static final CommandEventType START_LOADING = null;
        public static final int START_LOADING_VALUE = 25001;
        public static final CommandEventType SWITCH_MODAL = null;
        public static final int SWITCH_MODAL_VALUE = 24003;
        public static final CommandEventType SWITCH_SCENE = null;
        public static final int SWITCH_SCENE_VALUE = 24001;
        public static final CommandEventType TIMEOUT_TRIGGERED = null;
        public static final int TIMEOUT_TRIGGERED_VALUE = 23006;
        public static final CommandEventType TRIGGER_ANCS_SUMMARY = null;
        public static final int TRIGGER_ANCS_SUMMARY_VALUE = 13008;
        public static final CommandEventType TRIGGER_AUTH_DENY = null;
        public static final int TRIGGER_AUTH_DENY_VALUE = 11003;
        public static final CommandEventType TRIGGER_AUTH_FAILED = null;
        public static final int TRIGGER_AUTH_FAILED_VALUE = 13002;
        public static final CommandEventType TRIGGER_AUTH_SUCCESS = null;
        public static final int TRIGGER_AUTH_SUCCESS_VALUE = 11002;
        public static final CommandEventType TRIGGER_CLIENT_SUMMON_NOTICE = null;
        public static final int TRIGGER_CLIENT_SUMMON_NOTICE_VALUE = 13012;
        public static final CommandEventType TRIGGER_CONTINUE_TYPE = null;
        public static final int TRIGGER_CONTINUE_TYPE_VALUE = 13007;
        public static final CommandEventType TRIGGER_DORA_E_BOT_ACTIVE = null;
        public static final int TRIGGER_DORA_E_BOT_ACTIVE_VALUE = 13016;
        public static final CommandEventType TRIGGER_FULL_TEXT_QUERY = null;
        public static final int TRIGGER_FULL_TEXT_QUERY_VALUE = 13099;
        public static final CommandEventType TRIGGER_HANGUP = null;
        public static final int TRIGGER_HANGUP_VALUE = 11005;
        public static final CommandEventType TRIGGER_HELLO = null;
        public static final int TRIGGER_HELLO_VALUE = 11001;
        public static final CommandEventType TRIGGER_IMAGE = null;
        public static final int TRIGGER_IMAGE_VALUE = 13010;
        public static final CommandEventType TRIGGER_INTERVIEW_INTERACT = null;
        public static final int TRIGGER_INTERVIEW_INTERACT_VALUE = 13014;
        public static final CommandEventType TRIGGER_INTERVIEW_PLAN = null;
        public static final int TRIGGER_INTERVIEW_PLAN_VALUE = 13013;
        public static final CommandEventType TRIGGER_INTERVIEW_SUMMARY = null;
        public static final int TRIGGER_INTERVIEW_SUMMARY_VALUE = 13015;
        public static final CommandEventType TRIGGER_MUSIC_PLAYED = null;
        public static final int TRIGGER_MUSIC_PLAYED_VALUE = 13005;
        public static final CommandEventType TRIGGER_NOISY = null;
        public static final int TRIGGER_NOISY_VALUE = 13001;
        public static final CommandEventType TRIGGER_ONBOARDING_START = null;
        public static final int TRIGGER_ONBOARDING_START_VALUE = 13003;
        public static final CommandEventType TRIGGER_QUERY_WHEN_SILENCE = null;
        public static final int TRIGGER_QUERY_WHEN_SILENCE_VALUE = 13017;
        public static final CommandEventType TRIGGER_QUOTA_LEAK_WARNING = null;
        public static final int TRIGGER_QUOTA_LEAK_WARNING_VALUE = 13100;
        public static final CommandEventType TRIGGER_REQUEST_CHAT = null;
        public static final int TRIGGER_REQUEST_CHAT_VALUE = 13009;
        public static final CommandEventType TRIGGER_SPEECH_HELLO_ECHO = null;
        public static final int TRIGGER_SPEECH_HELLO_ECHO_VALUE = 11011;
        public static final CommandEventType TRIGGER_SPEECH_HELLO_UP = null;
        public static final int TRIGGER_SPEECH_HELLO_UP_VALUE = 11010;
        public static final CommandEventType TRIGGER_SUGGEST_QUERY = null;
        public static final int TRIGGER_SUGGEST_QUERY_VALUE = 13011;
        public static final CommandEventType TRIGGER_TIMEOUT = null;
        public static final int TRIGGER_TIMEOUT_VALUE = 13006;
        public static final CommandEventType TRIGGER_VOICE_SELECTED = null;
        public static final int TRIGGER_VOICE_SELECTED_VALUE = 13004;
        public static final CommandEventType TRIGGER_WAIT = null;
        public static final int TRIGGER_WAIT_VALUE = 11004;
        public static final CommandEventType TTS_PLAYBACK_END = null;
        public static final int TTS_PLAYBACK_END_VALUE = 12004;
        public static final CommandEventType TTS_PLAYBACK_INTERRUPT = null;
        public static final int TTS_PLAYBACK_INTERRUPT_VALUE = 12005;
        public static final CommandEventType TTS_PLAYBACK_PAUSE = null;
        public static final int TTS_PLAYBACK_PAUSE_VALUE = 12006;
        public static final CommandEventType TTS_PLAYBACK_RESUME = null;
        public static final int TTS_PLAYBACK_RESUME_VALUE = 12007;
        public static final CommandEventType TTS_PLAYBACK_START = null;
        public static final int TTS_PLAYBACK_START_VALUE = 12003;
        public static final CommandEventType UNMUTE = null;
        public static final CommandEventType UNMUTE_RESP = null;
        public static final int UNMUTE_RESP_VALUE = 20002;
        public static final int UNMUTE_VALUE = 10003;
        public static final CommandEventType UNRECOGNIZED = null;
        public static final CommandEventType UPDATE_AUDIO_CONFIG = null;
        public static final int UPDATE_AUDIO_CONFIG_VALUE = 12002;
        public static final CommandEventType UPDATE_PERSONAL_CONTEXT = null;
        public static final int UPDATE_PERSONAL_CONTEXT_VALUE = 110002;
        public static final CommandEventType UPDATE_ROUND_CONTEXT = null;
        public static final int UPDATE_ROUND_CONTEXT_VALUE = 110001;
        public static final CommandEventType UPDATE_UI_CONTEXT = null;
        public static final CommandEventType UPDATE_UI_CONTEXT_RESP = null;
        public static final int UPDATE_UI_CONTEXT_RESP_VALUE = 22011;
        public static final int UPDATE_UI_CONTEXT_VALUE = 12001;
        public static final CommandEventType UPLINK_HANG_UP = null;
        public static final int UPLINK_HANG_UP_VALUE = 15001;
        public static final CommandEventType UPLINK_UPDATE_EXTENSION_TIME = null;
        public static final int UPLINK_UPDATE_EXTENSION_TIME_VALUE = 15002;
        private static final CommandEventType[] VALUES = null;
        public static final CommandEventType VIDEO_EXIT = null;
        public static final int VIDEO_EXIT_VALUE = 20005;
        public static final CommandEventType VIDEO_FACE_TOAST = null;
        public static final int VIDEO_FACE_TOAST_VALUE = 23013;
        public static final CommandEventType VOICE_SELECTED_TRIGGERED = null;
        public static final int VOICE_SELECTED_TRIGGERED_VALUE = 23004;
        public static final CommandEventType WAIT_TRIGGERED = null;
        public static final int WAIT_TRIGGERED_VALUE = 21004;
        public static final CommandEventType WakeUp_Reject = null;
        public static final int WakeUp_Reject_VALUE = 14002;
        public static final CommandEventType WakeUp_Success = null;
        public static final int WakeUp_Success_VALUE = 14003;
        private static final Internal.EnumLiteMap<CommandEventType> internalValueMap = null;
        private final int value;

        static {
            CommandEventType r100 = new CommandEventType("COMMON_UNUSED", 0, 0);
            COMMON_UNUSED = r100;
            CommandEventType r101 = new CommandEventType("PING", 1, 1);
            PING = r101;
            CommandEventType r102 = new CommandEventType("PONG", 2, 2);
            PONG = r102;
            CommandEventType r103 = new CommandEventType("INTERRUPT", 3, 10001);
            INTERRUPT = r103;
            CommandEventType r104 = new CommandEventType("MUTE", 4, 10002);
            MUTE = r104;
            CommandEventType r105 = new CommandEventType("UNMUTE", 5, 10003);
            UNMUTE = r105;
            CommandEventType r110 = new CommandEventType("PAUSE", 6, 10004);
            PAUSE = r110;
            CommandEventType r111 = new CommandEventType("CONTINUE", 7, 10005);
            CONTINUE = r111;
            CommandEventType r112 = new CommandEventType("END_ASR", 8, 10006);
            END_ASR = r112;
            CommandEventType r113 = new CommandEventType("TRIGGER_HELLO", 9, 11001);
            TRIGGER_HELLO = r113;
            CommandEventType r114 = new CommandEventType("TRIGGER_AUTH_SUCCESS", 10, 11002);
            TRIGGER_AUTH_SUCCESS = r114;
            CommandEventType r106 = new CommandEventType("TRIGGER_AUTH_DENY", 11, 11003);
            TRIGGER_AUTH_DENY = r106;
            CommandEventType r107 = new CommandEventType("TRIGGER_WAIT", 12, 11004);
            TRIGGER_WAIT = r107;
            CommandEventType r108 = new CommandEventType("TRIGGER_HANGUP", 13, 11005);
            TRIGGER_HANGUP = r108;
            CommandEventType r109 = new CommandEventType("TRIGGER_SPEECH_HELLO_UP", 14, 11010);
            TRIGGER_SPEECH_HELLO_UP = r109;
            CommandEventType r115 = new CommandEventType("TRIGGER_SPEECH_HELLO_ECHO", 15, 11011);
            TRIGGER_SPEECH_HELLO_ECHO = r115;
            CommandEventType r116 = new CommandEventType("UPDATE_UI_CONTEXT", 16, 12001);
            UPDATE_UI_CONTEXT = r116;
            CommandEventType r117 = new CommandEventType("UPDATE_AUDIO_CONFIG", 17, 12002);
            UPDATE_AUDIO_CONFIG = r117;
            CommandEventType r118 = new CommandEventType("TTS_PLAYBACK_START", 18, 12003);
            TTS_PLAYBACK_START = r118;
            CommandEventType r119 = new CommandEventType("TTS_PLAYBACK_END", 19, 12004);
            TTS_PLAYBACK_END = r119;
            CommandEventType r120 = new CommandEventType("TTS_PLAYBACK_INTERRUPT", 20, 12005);
            TTS_PLAYBACK_INTERRUPT = r120;
            CommandEventType r121 = new CommandEventType("TTS_PLAYBACK_PAUSE", 21, 12006);
            TTS_PLAYBACK_PAUSE = r121;
            CommandEventType r122 = new CommandEventType("TTS_PLAYBACK_RESUME", 22, TTS_PLAYBACK_RESUME_VALUE);
            TTS_PLAYBACK_RESUME = r122;
            CommandEventType r123 = new CommandEventType("TRIGGER_NOISY", 23, TRIGGER_NOISY_VALUE);
            TRIGGER_NOISY = r123;
            CommandEventType r124 = new CommandEventType("TRIGGER_AUTH_FAILED", 24, TRIGGER_AUTH_FAILED_VALUE);
            TRIGGER_AUTH_FAILED = r124;
            CommandEventType r125 = new CommandEventType("TRIGGER_ONBOARDING_START", 25, TRIGGER_ONBOARDING_START_VALUE);
            TRIGGER_ONBOARDING_START = r125;
            CommandEventType r126 = new CommandEventType("TRIGGER_VOICE_SELECTED", 26, 13004);
            TRIGGER_VOICE_SELECTED = r126;
            CommandEventType r127 = new CommandEventType("TRIGGER_MUSIC_PLAYED", 27, TRIGGER_MUSIC_PLAYED_VALUE);
            TRIGGER_MUSIC_PLAYED = r127;
            CommandEventType r128 = new CommandEventType("TRIGGER_TIMEOUT", 28, TRIGGER_TIMEOUT_VALUE);
            TRIGGER_TIMEOUT = r128;
            CommandEventType r129 = new CommandEventType("TRIGGER_CONTINUE_TYPE", 29, TRIGGER_CONTINUE_TYPE_VALUE);
            TRIGGER_CONTINUE_TYPE = r129;
            CommandEventType r130 = new CommandEventType("TRIGGER_ANCS_SUMMARY", 30, TRIGGER_ANCS_SUMMARY_VALUE);
            TRIGGER_ANCS_SUMMARY = r130;
            CommandEventType r131 = new CommandEventType("TRIGGER_REQUEST_CHAT", 31, TRIGGER_REQUEST_CHAT_VALUE);
            TRIGGER_REQUEST_CHAT = r131;
            CommandEventType r132 = new CommandEventType("TRIGGER_IMAGE", 32, TRIGGER_IMAGE_VALUE);
            TRIGGER_IMAGE = r132;
            CommandEventType r133 = new CommandEventType("TRIGGER_SUGGEST_QUERY", 33, TRIGGER_SUGGEST_QUERY_VALUE);
            TRIGGER_SUGGEST_QUERY = r133;
            CommandEventType r134 = new CommandEventType("TRIGGER_CLIENT_SUMMON_NOTICE", 34, TRIGGER_CLIENT_SUMMON_NOTICE_VALUE);
            TRIGGER_CLIENT_SUMMON_NOTICE = r134;
            CommandEventType r135 = new CommandEventType("TRIGGER_INTERVIEW_PLAN", 35, TRIGGER_INTERVIEW_PLAN_VALUE);
            TRIGGER_INTERVIEW_PLAN = r135;
            CommandEventType r136 = new CommandEventType("TRIGGER_INTERVIEW_INTERACT", 36, TRIGGER_INTERVIEW_INTERACT_VALUE);
            TRIGGER_INTERVIEW_INTERACT = r136;
            CommandEventType r137 = new CommandEventType("TRIGGER_INTERVIEW_SUMMARY", 37, TRIGGER_INTERVIEW_SUMMARY_VALUE);
            TRIGGER_INTERVIEW_SUMMARY = r137;
            CommandEventType r138 = new CommandEventType("TRIGGER_DORA_E_BOT_ACTIVE", 38, TRIGGER_DORA_E_BOT_ACTIVE_VALUE);
            TRIGGER_DORA_E_BOT_ACTIVE = r138;
            CommandEventType r139 = new CommandEventType("TRIGGER_QUERY_WHEN_SILENCE", 39, TRIGGER_QUERY_WHEN_SILENCE_VALUE);
            TRIGGER_QUERY_WHEN_SILENCE = r139;
            CommandEventType r140 = new CommandEventType("TRIGGER_FULL_TEXT_QUERY", 40, TRIGGER_FULL_TEXT_QUERY_VALUE);
            TRIGGER_FULL_TEXT_QUERY = r140;
            CommandEventType r141 = new CommandEventType("TRIGGER_QUOTA_LEAK_WARNING", 41, TRIGGER_QUOTA_LEAK_WARNING_VALUE);
            TRIGGER_QUOTA_LEAK_WARNING = r141;
            CommandEventType r142 = new CommandEventType("SEND_IMAGE", 42, 14001);
            SEND_IMAGE = r142;
            CommandEventType r143 = new CommandEventType("WakeUp_Reject", 43, WakeUp_Reject_VALUE);
            WakeUp_Reject = r143;
            CommandEventType r144 = new CommandEventType("WakeUp_Success", 44, WakeUp_Success_VALUE);
            WakeUp_Success = r144;
            CommandEventType r145 = new CommandEventType("Enter_DIALOGUE", 45, Enter_DIALOGUE_VALUE);
            Enter_DIALOGUE = r145;
            CommandEventType r146 = new CommandEventType("Exit_DIALOGUE", 46, Exit_DIALOGUE_VALUE);
            Exit_DIALOGUE = r146;
            CommandEventType r147 = new CommandEventType("ENTER_DIALOGUE_RESP", 47, ENTER_DIALOGUE_RESP_VALUE);
            ENTER_DIALOGUE_RESP = r147;
            CommandEventType r148 = new CommandEventType("EXIT_DIALOGUE_RESP", 48, EXIT_DIALOGUE_RESP_VALUE);
            EXIT_DIALOGUE_RESP = r148;
            CommandEventType r149 = new CommandEventType("CLIENT_INTENT", 49, CLIENT_INTENT_VALUE);
            CLIENT_INTENT = r149;
            CommandEventType r150 = new CommandEventType("CLIENT_INTENT_RESP", 50, CLIENT_INTENT_RESP_VALUE);
            CLIENT_INTENT_RESP = r150;
            CommandEventType r151 = new CommandEventType("UPLINK_HANG_UP", 51, UPLINK_HANG_UP_VALUE);
            UPLINK_HANG_UP = r151;
            CommandEventType r152 = new CommandEventType("UPLINK_UPDATE_EXTENSION_TIME", 52, UPLINK_UPDATE_EXTENSION_TIME_VALUE);
            UPLINK_UPDATE_EXTENSION_TIME = r152;
            CommandEventType r153 = new CommandEventType("MUTE_RESP", 53, 20001);
            MUTE_RESP = r153;
            CommandEventType r154 = new CommandEventType("UNMUTE_RESP", 54, 20002);
            UNMUTE_RESP = r154;
            CommandEventType r155 = new CommandEventType("PAUSE_RESP", 55, 20003);
            PAUSE_RESP = r155;
            CommandEventType r156 = new CommandEventType("CONTINUE_RESP", 56, 20004);
            CONTINUE_RESP = r156;
            CommandEventType r157 = new CommandEventType("VIDEO_EXIT", 57, 20005);
            VIDEO_EXIT = r157;
            CommandEventType r158 = new CommandEventType("POST_BACK_AUDIO_CONFIG", 58, 20006);
            POST_BACK_AUDIO_CONFIG = r158;
            CommandEventType r159 = new CommandEventType("RETRY_NEW_ROUND", 59, 20007);
            RETRY_NEW_ROUND = r159;
            CommandEventType r160 = new CommandEventType("ASR_NOISE_INFO", 60, 20010);
            ASR_NOISE_INFO = r160;
            CommandEventType r161 = new CommandEventType("ASR_SV_INFO", 61, 20011);
            ASR_SV_INFO = r161;
            CommandEventType r162 = new CommandEventType("COMMON_AUDIO_CONFIG", 62, 20012);
            COMMON_AUDIO_CONFIG = r162;
            CommandEventType r163 = new CommandEventType("HELLO_TRIGGERED", 63, 21001);
            HELLO_TRIGGERED = r163;
            CommandEventType r164 = new CommandEventType("AUTH_SUCCESS_TRIGGERED", 64, 21002);
            AUTH_SUCCESS_TRIGGERED = r164;
            CommandEventType r165 = new CommandEventType("AUTH_DENY_TRIGGERED", 65, AUTH_DENY_TRIGGERED_VALUE);
            AUTH_DENY_TRIGGERED = r165;
            CommandEventType r166 = new CommandEventType("WAIT_TRIGGERED", 66, WAIT_TRIGGERED_VALUE);
            WAIT_TRIGGERED = r166;
            CommandEventType r167 = new CommandEventType("HANGUP_TRIGGERED", 67, HANGUP_TRIGGERED_VALUE);
            HANGUP_TRIGGERED = r167;
            CommandEventType r168 = new CommandEventType("UPDATE_UI_CONTEXT_RESP", 68, UPDATE_UI_CONTEXT_RESP_VALUE);
            UPDATE_UI_CONTEXT_RESP = r168;
            CommandEventType r169 = new CommandEventType("CLIM_IN_STARTED", 69, CLIM_IN_STARTED_VALUE);
            CLIM_IN_STARTED = r169;
            CommandEventType r170 = new CommandEventType("CLIM_IN_END", 70, CLIM_IN_END_VALUE);
            CLIM_IN_END = r170;
            CommandEventType r171 = new CommandEventType("INTERPRET_ASR_STARTED", 71, INTERPRET_ASR_STARTED_VALUE);
            INTERPRET_ASR_STARTED = r171;
            CommandEventType r172 = new CommandEventType("INTERPRET_FINISH", 72, INTERPRET_FINISH_VALUE);
            INTERPRET_FINISH = r172;
            CommandEventType r173 = new CommandEventType("NOISY_TRIGGERED", 73, NOISY_TRIGGERED_VALUE);
            NOISY_TRIGGERED = r173;
            CommandEventType r174 = new CommandEventType("AUTH_FAILED_TRIGGERED", 74, AUTH_FAILED_TRIGGERED_VALUE);
            AUTH_FAILED_TRIGGERED = r174;
            CommandEventType r175 = new CommandEventType("ONBOARDING_START_TRIGGERED", 75, ONBOARDING_START_TRIGGERED_VALUE);
            ONBOARDING_START_TRIGGERED = r175;
            CommandEventType r176 = new CommandEventType("VOICE_SELECTED_TRIGGERED", 76, VOICE_SELECTED_TRIGGERED_VALUE);
            VOICE_SELECTED_TRIGGERED = r176;
            CommandEventType r177 = new CommandEventType("MUSIC_PLAYED_TRIGGERED", 77, MUSIC_PLAYED_TRIGGERED_VALUE);
            MUSIC_PLAYED_TRIGGERED = r177;
            CommandEventType r178 = new CommandEventType("TIMEOUT_TRIGGERED", 78, TIMEOUT_TRIGGERED_VALUE);
            TIMEOUT_TRIGGERED = r178;
            CommandEventType r179 = new CommandEventType("CONTINUE_TYPE_TRIGGERED", 79, CONTINUE_TYPE_TRIGGERED_VALUE);
            CONTINUE_TYPE_TRIGGERED = r179;
            CommandEventType r180 = new CommandEventType("ANCS_SUMMARY_TRIGGERED", 80, ANCS_SUMMARY_TRIGGERED_VALUE);
            ANCS_SUMMARY_TRIGGERED = r180;
            CommandEventType r181 = new CommandEventType("REQUEST_CHAT_TRIGGER", 81, REQUEST_CHAT_TRIGGER_VALUE);
            REQUEST_CHAT_TRIGGER = r181;
            CommandEventType r182 = new CommandEventType("IMAGE_TRIGGERED", 82, IMAGE_TRIGGERED_VALUE);
            IMAGE_TRIGGERED = r182;
            CommandEventType r183 = new CommandEventType("SPEECH_STARTED", 83, SPEECH_STARTED_VALUE);
            SPEECH_STARTED = r183;
            CommandEventType r184 = new CommandEventType("SPEECH_ENDED", 84, SPEECH_ENDED_VALUE);
            SPEECH_ENDED = r184;
            CommandEventType r185 = new CommandEventType("VIDEO_FACE_TOAST", 85, VIDEO_FACE_TOAST_VALUE);
            VIDEO_FACE_TOAST = r185;
            CommandEventType r186 = new CommandEventType("SWITCH_SCENE", 86, SWITCH_SCENE_VALUE);
            SWITCH_SCENE = r186;
            CommandEventType r187 = new CommandEventType("SCENE_SWITCHED", 87, SCENE_SWITCHED_VALUE);
            SCENE_SWITCHED = r187;
            CommandEventType r188 = new CommandEventType("SWITCH_MODAL", 88, SWITCH_MODAL_VALUE);
            SWITCH_MODAL = r188;
            CommandEventType r189 = new CommandEventType("MODAL_SWITCHED", 89, MODAL_SWITCHED_VALUE);
            MODAL_SWITCHED = r189;
            CommandEventType r190 = new CommandEventType("START_LOADING", 90, START_LOADING_VALUE);
            START_LOADING = r190;
            CommandEventType r191 = new CommandEventType("FINISH_LOADING", 91, FINISH_LOADING_VALUE);
            FINISH_LOADING = r191;
            CommandEventType r192 = new CommandEventType("DOWNLINK_HANG_UP", 92, DOWNLINK_HANG_UP_VALUE);
            DOWNLINK_HANG_UP = r192;
            CommandEventType r193 = new CommandEventType("DOWNLINK_TRANSMIT_REPLY", 93, DOWNLINK_TRANSMIT_REPLY_VALUE);
            DOWNLINK_TRANSMIT_REPLY = r193;
            CommandEventType r194 = new CommandEventType("DOWNLINK_QUOTA_EXCEEDED", 94, DOWNLINK_QUOTA_EXCEEDED_VALUE);
            DOWNLINK_QUOTA_EXCEEDED = r194;
            CommandEventType r195 = new CommandEventType("AI_PROACTIVE_NOTIFY", 95, AI_PROACTIVE_NOTIFY_VALUE);
            AI_PROACTIVE_NOTIFY = r195;
            CommandEventType r196 = new CommandEventType("SPEECH_ONLY", 96, SPEECH_ONLY_VALUE);
            SPEECH_ONLY = r196;
            CommandEventType r197 = new CommandEventType("AUDIO_ROUND_TRACE", 97, 80001);
            AUDIO_ROUND_TRACE = r197;
            CommandEventType r198 = new CommandEventType("CLIENT_SYNC", 98, 80002);
            CLIENT_SYNC = r198;
            CommandEventType r199 = new CommandEventType("UPDATE_ROUND_CONTEXT", 99, 110001);
            UPDATE_ROUND_CONTEXT = r199;
            CommandEventType r200 = new CommandEventType("UPDATE_PERSONAL_CONTEXT", 100, 110002);
            UPDATE_PERSONAL_CONTEXT = r200;
            CommandEventType r201 = new CommandEventType("PreInterrupted", 101, 110101);
            PreInterrupted = r201;
            CommandEventType r202 = new CommandEventType("PreFetch", 102, 110102);
            PreFetch = r202;
            CommandEventType r203 = new CommandEventType("QueryRejected", 103, QueryRejected_VALUE);
            QueryRejected = r203;
            CommandEventType r204 = new CommandEventType("UNRECOGNIZED", 104, -1);
            UNRECOGNIZED = r204;
            $VALUES = new CommandEventType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, r187, r188, r189, r190, r191, r192, r193, r194, r195, r196, r197, r198, r199, r200, r201, r202, r203, r204};
            internalValueMap = new AnonymousClass1();
            VALUES = values();
        }

        public static CommandEventType[] values() {
            return (CommandEventType[]) $VALUES.clone();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) goto L7;
            return this.value;
        L7:
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return (Descriptors.EnumDescriptor) ListProtector.get(AvCmd.getDescriptor().getEnumTypes(), 1);
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return (Descriptors.EnumValueDescriptor) ListProtector.get(getDescriptor().getValues(), ordinal());
        }

        public static Internal.EnumLiteMap<CommandEventType> internalGetValueMap() {
            return internalValueMap;
        }

        public static CommandEventType forNumber(int r100) {
            if (r100 == 0) goto L234;
            if (r100 == 1) goto L232;
            if (r100 == 2) goto L230;
            if (r100 == 11010) goto L228;
            if (r100 == 11011) goto L226;
            if (r100 == 13099) goto L224;
            if (r100 == 13100) goto L222;
            if (r100 == 14010) goto L220;
            if (r100 == 14011) goto L218;
            switch(r100) {
                case 10001: goto L216;
                case 10002: goto L214;
                case 10003: goto L212;
                case 10004: goto L210;
                case 10005: goto L208;
                case 10006: goto L206;
                default: goto L20;
            };
        L20:
            switch(r100) {
                case 11001: goto L204;
                case 11002: goto L202;
                case 11003: goto L200;
                case 11004: goto L198;
                case 11005: goto L196;
                default: goto L21;
            };
        L21:
            switch(r100) {
                case 12001: goto L194;
                case 12002: goto L192;
                case 12003: goto L190;
                case 12004: goto L188;
                case 12005: goto L186;
                case 12006: goto L184;
                case 12007: goto L182;
                default: goto L22;
            };
        L22:
            switch(r100) {
                case 13001: goto L180;
                case 13002: goto L178;
                case 13003: goto L176;
                case 13004: goto L174;
                case 13005: goto L172;
                case 13006: goto L170;
                case 13007: goto L168;
                case 13008: goto L166;
                case 13009: goto L164;
                case 13010: goto L162;
                case 13011: goto L160;
                case 13012: goto L158;
                case 13013: goto L156;
                case 13014: goto L154;
                case 13015: goto L152;
                case 13016: goto L150;
                case 13017: goto L148;
                case 15001: goto L146;
                case 15002: goto L144;
                case 20001: goto L142;
                case 20002: goto L140;
                case 20003: goto L138;
                case 20004: goto L136;
                case 20005: goto L134;
                case 20006: goto L132;
                case 20007: goto L130;
                case 20010: goto L128;
                case 20011: goto L126;
                case 20012: goto L124;
                case 21001: goto L122;
                case 21002: goto L120;
                case 21003: goto L118;
                case 21004: goto L116;
                case 21005: goto L114;
                case 22011: goto L112;
                case 22012: goto L110;
                case 22013: goto L108;
                case 22014: goto L106;
                case 22015: goto L104;
                case 23001: goto L102;
                case 23002: goto L100;
                case 23003: goto L98;
                case 23004: goto L96;
                case 23005: goto L94;
                case 23006: goto L92;
                case 23007: goto L90;
                case 23008: goto L88;
                case 23009: goto L86;
                case 23010: goto L84;
                case 23011: goto L82;
                case 23012: goto L80;
                case 23013: goto L78;
                case 24001: goto L76;
                case 24002: goto L74;
                case 24003: goto L72;
                case 24004: goto L70;
                case 25001: goto L68;
                case 25002: goto L66;
                case 25003: goto L64;
                case 25004: goto L62;
                case 25005: goto L60;
                case 27001: goto L58;
                case 60001: goto L56;
                case 80001: goto L54;
                case 80002: goto L52;
                case 110001: goto L50;
                case 110002: goto L48;
                case 110101: goto L46;
                case 110102: goto L44;
                case 110103: goto L42;
                default: goto L23;
            };
        L23:
            switch(r100) {
                case 14001: goto L40;
                case 14002: goto L38;
                case 14003: goto L36;
                default: goto L24;
            };
        L24:
            switch(r100) {
                case 14020: goto L34;
                case 14021: goto L32;
                case 14022: goto L30;
                case 14023: goto L28;
                default: goto L25;
            };
        L25:
            return null;
        L28:
            return CLIENT_INTENT_RESP;
        L30:
            return CLIENT_INTENT;
        L32:
            return EXIT_DIALOGUE_RESP;
        L34:
            return ENTER_DIALOGUE_RESP;
        L36:
            return WakeUp_Success;
        L38:
            return WakeUp_Reject;
        L40:
            return SEND_IMAGE;
        L42:
            return QueryRejected;
        L44:
            return PreFetch;
        L46:
            return PreInterrupted;
        L48:
            return UPDATE_PERSONAL_CONTEXT;
        L50:
            return UPDATE_ROUND_CONTEXT;
        L52:
            return CLIENT_SYNC;
        L54:
            return AUDIO_ROUND_TRACE;
        L56:
            return SPEECH_ONLY;
        L58:
            return AI_PROACTIVE_NOTIFY;
        L60:
            return DOWNLINK_QUOTA_EXCEEDED;
        L62:
            return DOWNLINK_TRANSMIT_REPLY;
        L64:
            return DOWNLINK_HANG_UP;
        L66:
            return FINISH_LOADING;
        L68:
            return START_LOADING;
        L70:
            return MODAL_SWITCHED;
        L72:
            return SWITCH_MODAL;
        L74:
            return SCENE_SWITCHED;
        L76:
            return SWITCH_SCENE;
        L78:
            return VIDEO_FACE_TOAST;
        L80:
            return SPEECH_ENDED;
        L82:
            return SPEECH_STARTED;
        L84:
            return IMAGE_TRIGGERED;
        L86:
            return REQUEST_CHAT_TRIGGER;
        L88:
            return ANCS_SUMMARY_TRIGGERED;
        L90:
            return CONTINUE_TYPE_TRIGGERED;
        L92:
            return TIMEOUT_TRIGGERED;
        L94:
            return MUSIC_PLAYED_TRIGGERED;
        L96:
            return VOICE_SELECTED_TRIGGERED;
        L98:
            return ONBOARDING_START_TRIGGERED;
        L100:
            return AUTH_FAILED_TRIGGERED;
        L102:
            return NOISY_TRIGGERED;
        L104:
            return INTERPRET_FINISH;
        L106:
            return INTERPRET_ASR_STARTED;
        L108:
            return CLIM_IN_END;
        L110:
            return CLIM_IN_STARTED;
        L112:
            return UPDATE_UI_CONTEXT_RESP;
        L114:
            return HANGUP_TRIGGERED;
        L116:
            return WAIT_TRIGGERED;
        L118:
            return AUTH_DENY_TRIGGERED;
        L120:
            return AUTH_SUCCESS_TRIGGERED;
        L122:
            return HELLO_TRIGGERED;
        L124:
            return COMMON_AUDIO_CONFIG;
        L126:
            return ASR_SV_INFO;
        L128:
            return ASR_NOISE_INFO;
        L130:
            return RETRY_NEW_ROUND;
        L132:
            return POST_BACK_AUDIO_CONFIG;
        L134:
            return VIDEO_EXIT;
        L136:
            return CONTINUE_RESP;
        L138:
            return PAUSE_RESP;
        L140:
            return UNMUTE_RESP;
        L142:
            return MUTE_RESP;
        L144:
            return UPLINK_UPDATE_EXTENSION_TIME;
        L146:
            return UPLINK_HANG_UP;
        L148:
            return TRIGGER_QUERY_WHEN_SILENCE;
        L150:
            return TRIGGER_DORA_E_BOT_ACTIVE;
        L152:
            return TRIGGER_INTERVIEW_SUMMARY;
        L154:
            return TRIGGER_INTERVIEW_INTERACT;
        L156:
            return TRIGGER_INTERVIEW_PLAN;
        L158:
            return TRIGGER_CLIENT_SUMMON_NOTICE;
        L160:
            return TRIGGER_SUGGEST_QUERY;
        L162:
            return TRIGGER_IMAGE;
        L164:
            return TRIGGER_REQUEST_CHAT;
        L166:
            return TRIGGER_ANCS_SUMMARY;
        L168:
            return TRIGGER_CONTINUE_TYPE;
        L170:
            return TRIGGER_TIMEOUT;
        L172:
            return TRIGGER_MUSIC_PLAYED;
        L174:
            return TRIGGER_VOICE_SELECTED;
        L176:
            return TRIGGER_ONBOARDING_START;
        L178:
            return TRIGGER_AUTH_FAILED;
        L180:
            return TRIGGER_NOISY;
        L182:
            return TTS_PLAYBACK_RESUME;
        L184:
            return TTS_PLAYBACK_PAUSE;
        L186:
            return TTS_PLAYBACK_INTERRUPT;
        L188:
            return TTS_PLAYBACK_END;
        L190:
            return TTS_PLAYBACK_START;
        L192:
            return UPDATE_AUDIO_CONFIG;
        L194:
            return UPDATE_UI_CONTEXT;
        L196:
            return TRIGGER_HANGUP;
        L198:
            return TRIGGER_WAIT;
        L200:
            return TRIGGER_AUTH_DENY;
        L202:
            return TRIGGER_AUTH_SUCCESS;
        L204:
            return TRIGGER_HELLO;
        L206:
            return END_ASR;
        L208:
            return CONTINUE;
        L210:
            return PAUSE;
        L212:
            return UNMUTE;
        L214:
            return MUTE;
        L216:
            return INTERRUPT;
        L218:
            return Exit_DIALOGUE;
        L220:
            return Enter_DIALOGUE;
        L222:
            return TRIGGER_QUOTA_LEAK_WARNING;
        L224:
            return TRIGGER_FULL_TEXT_QUERY;
        L226:
            return TRIGGER_SPEECH_HELLO_ECHO;
        L228:
            return TRIGGER_SPEECH_HELLO_UP;
        L230:
            return PONG;
        L232:
            return PING;
        L234:
            return COMMON_UNUSED;
        }

        public static CommandEventType valueOf(Descriptors.EnumValueDescriptor r100) {
            if (r100.getType() != getDescriptor()) goto L11;
            if (r100.getIndex() != (-1)) goto L9;
            return UNRECOGNIZED;
        L9:
            return VALUES[r100.getIndex()];
        L11:
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        public static CommandEventType valueOf(String r100) {
            return (CommandEventType) a.a(CommandEventType.class, r100);
        }

        public static CommandEventType valueOf(int r100) {
            return forNumber(r100);
        }

        private CommandEventType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum ReplyEndType extends Enum<ReplyEndType> implements ProtocolMessageEnum {
        private static final /* synthetic */ ReplyEndType[] $VALUES = null;
        public static final ReplyEndType GENERATED = null;
        public static final int GENERATED_VALUE = 0;
        public static final ReplyEndType NOREPLY = null;
        public static final int NOREPLY_VALUE = 2;
        public static final ReplyEndType PUSHED = null;
        public static final int PUSHED_VALUE = 1;
        public static final ReplyEndType UNRECOGNIZED = null;
        private static final ReplyEndType[] VALUES = null;
        private static final Internal.EnumLiteMap<ReplyEndType> internalValueMap = null;
        private final int value;

        static {
            ReplyEndType r100 = new ReplyEndType("GENERATED", 0, 0);
            GENERATED = r100;
            ReplyEndType r101 = new ReplyEndType("PUSHED", 1, 1);
            PUSHED = r101;
            ReplyEndType r102 = new ReplyEndType("NOREPLY", 2, 2);
            NOREPLY = r102;
            ReplyEndType r103 = new ReplyEndType("UNRECOGNIZED", 3, -1);
            UNRECOGNIZED = r103;
            $VALUES = new ReplyEndType[]{r100, r101, r102, r103};
            internalValueMap = new AnonymousClass1();
            VALUES = values();
        }

        public static ReplyEndType[] values() {
            return (ReplyEndType[]) $VALUES.clone();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) goto L7;
            return this.value;
        L7:
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return (Descriptors.EnumDescriptor) ListProtector.get(AvCmd.getDescriptor().getEnumTypes(), 4);
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return (Descriptors.EnumValueDescriptor) ListProtector.get(getDescriptor().getValues(), ordinal());
        }

        public static Internal.EnumLiteMap<ReplyEndType> internalGetValueMap() {
            return internalValueMap;
        }

        public static ReplyEndType forNumber(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return NOREPLY;
        L12:
            return PUSHED;
        L14:
            return GENERATED;
        }

        public static ReplyEndType valueOf(Descriptors.EnumValueDescriptor r100) {
            if (r100.getType() != getDescriptor()) goto L11;
            if (r100.getIndex() != (-1)) goto L9;
            return UNRECOGNIZED;
        L9:
            return VALUES[r100.getIndex()];
        L11:
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        public static ReplyEndType valueOf(String r100) {
            return (ReplyEndType) a.a(ReplyEndType.class, r100);
        }

        public static ReplyEndType valueOf(int r100) {
            return forNumber(r100);
        }

        private ReplyEndType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum ReplyStage extends Enum<ReplyStage> implements ProtocolMessageEnum {
        private static final /* synthetic */ ReplyStage[] $VALUES = null;
        public static final ReplyStage BEGIN = null;
        public static final int BEGIN_VALUE = 0;
        public static final ReplyStage END = null;
        public static final int END_VALUE = 2;
        public static final ReplyStage UNRECOGNIZED = null;
        public static final ReplyStage UPDATE = null;
        public static final int UPDATE_VALUE = 1;
        private static final ReplyStage[] VALUES = null;
        private static final Internal.EnumLiteMap<ReplyStage> internalValueMap = null;
        private final int value;

        static {
            ReplyStage r100 = new ReplyStage("BEGIN", 0, 0);
            BEGIN = r100;
            ReplyStage r101 = new ReplyStage("UPDATE", 1, 1);
            UPDATE = r101;
            ReplyStage r102 = new ReplyStage(GXAnimation.STATE_END, 2, 2);
            END = r102;
            ReplyStage r103 = new ReplyStage("UNRECOGNIZED", 3, -1);
            UNRECOGNIZED = r103;
            $VALUES = new ReplyStage[]{r100, r101, r102, r103};
            internalValueMap = new AnonymousClass1();
            VALUES = values();
        }

        public static ReplyStage[] values() {
            return (ReplyStage[]) $VALUES.clone();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) goto L7;
            return this.value;
        L7:
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return (Descriptors.EnumDescriptor) ListProtector.get(AvCmd.getDescriptor().getEnumTypes(), 3);
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return (Descriptors.EnumValueDescriptor) ListProtector.get(getDescriptor().getValues(), ordinal());
        }

        public static Internal.EnumLiteMap<ReplyStage> internalGetValueMap() {
            return internalValueMap;
        }

        public static ReplyStage forNumber(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return END;
        L12:
            return UPDATE;
        L14:
            return BEGIN;
        }

        public static ReplyStage valueOf(Descriptors.EnumValueDescriptor r100) {
            if (r100.getType() != getDescriptor()) goto L11;
            if (r100.getIndex() != (-1)) goto L9;
            return UNRECOGNIZED;
        L9:
            return VALUES[r100.getIndex()];
        L11:
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        public static ReplyStage valueOf(String r100) {
            return (ReplyStage) a.a(ReplyStage.class, r100);
        }

        public static ReplyStage valueOf(int r100) {
            return forNumber(r100);
        }

        private ReplyStage(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    private AvCmd() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite r100) {
    }

    static {
        Descriptors.FileDescriptor[] r100 = new Descriptors.FileDescriptor[0];
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\fav_cmd.proto\u0012$com.larus.im.internal.network.proto2*½\u0002\n\u0005AVCMD\u0012\n\n\u0006UNUSED\u0010\u0000\u0012\u0012\n\rSTART_SESSION\u0010\u0091N\u0012\u0013\n\u000eFINISH_SESSION\u0010\u0092N\u0012\u001a\n\u0015COMMAND_SIGNAL_UPLINK\u0010\u0093N\u0012\u0010\n\u000bFILE_UPLINK\u0010\u0094N\u0012\u0015\n\u000fSESSION_STARTED\u0010¡\u009c\u0001\u0012\u0016\n\u0010SESSION_FINISHED\u0010¢\u009c\u0001\u0012\u0011\n\u000bQUERY_BEGIN\u0010£\u009c\u0001\u0012\u0012\n\fQUERY_UPDATE\u0010¤\u009c\u0001\u0012\u000f\n\tQUERY_END\u0010¥\u009c\u0001\u0012\u0011\n\u000bREPLY_BEGIN\u0010¦\u009c\u0001\u0012\u0012\n\fREPLY_UPDATE\u0010§\u009c\u0001\u0012\u000f\n\tREPLY_END\u0010¨\u009c\u0001\u0012\u001d\n\u0017COMMAND_SIGNAL_DOWNLINK\u0010±ê\u0001\u0012\u0013\n\rFILE_DOWNLINK\u0010Á¸\u0002*×\u0013\n\u0010CommandEventType\u0012\u0011\n\rCOMMON_UNUSED\u0010\u0000\u0012\b\n\u0004PING\u0010\u0001\u0012\b\n\u0004PONG\u0010\u0002\u0012\u000e\n\tINTERRUPT\u0010\u0091N\u0012\t\n\u0004MUTE\u0010\u0092N\u0012\u000b\n\u0006UNMUTE\u0010\u0093N\u0012\n\n\u0005PAUSE\u0010\u0094N\u0012\r\n\bCONTINUE\u0010\u0095N\u0012\f\n\u0007END_ASR\u0010\u0096N\u0012\u0012\n\rTRIGGER_HELLO\u0010ùU\u0012\u0019\n\u0014TRIGGER_AUTH_SUCCESS\u0010úU\u0012\u0016\n\u0011TRIGGER_AUTH_DENY\u0010ûU\u0012\u0011\n\fTRIGGER_WAIT\u0010üU\u0012\u0013\n\u000eTRIGGER_HANGUP\u0010ýU\u0012\u001c\n\u0017TRIGGER_SPEECH_HELLO_UP\u0010\u0082V\u0012\u001e\n\u0019TRIGGER_SPEECH_HELLO_ECHO\u0010\u0083V\u0012\u0016\n\u0011UPDATE_UI_CONTEXT\u0010á]\u0012\u0018\n\u0013UPDATE_AUDIO_CONFIG\u0010â]\u0012\u0017\n\u0012TTS_PLAYBACK_START\u0010ã]\u0012\u0015\n\u0010TTS_PLAYBACK_END\u0010ä]\u0012\u001b\n\u0016TTS_PLAYBACK_INTERRUPT\u0010å]\u0012\u0017\n\u0012TTS_PLAYBACK_PAUSE\u0010æ]\u0012\u0018\n\u0013TTS_PLAYBACK_RESUME\u0010ç]\u0012\u0012\n\rTRIGGER_NOISY\u0010Ée\u0012\u0018\n\u0013TRIGGER_AUTH_FAILED\u0010Êe\u0012\u001d\n\u0018TRIGGER_ONBOARDING_START\u0010Ëe\u0012\u001b\n\u0016TRIGGER_VOICE_SELECTED\u0010Ìe\u0012\u0019\n\u0014TRIGGER_MUSIC_PLAYED\u0010Íe\u0012\u0014\n\u000fTRIGGER_TIMEOUT\u0010Îe\u0012\u001a\n\u0015TRIGGER_CONTINUE_TYPE\u0010Ïe\u0012\u0019\n\u0014TRIGGER_ANCS_SUMMARY\u0010Ðe\u0012\u0019\n\u0014TRIGGER_REQUEST_CHAT\u0010Ñe\u0012\u0012\n\rTRIGGER_IMAGE\u0010Òe\u0012\u001a\n\u0015TRIGGER_SUGGEST_QUERY\u0010Óe\u0012!\n\u001cTRIGGER_CLIENT_SUMMON_NOTICE\u0010Ôe\u0012\u001b\n\u0016TRIGGER_INTERVIEW_PLAN\u0010Õe\u0012\u001f\n\u001aTRIGGER_INTERVIEW_INTERACT\u0010Öe\u0012\u001e\n\u0019TRIGGER_INTERVIEW_SUMMARY\u0010×e\u0012\u001e\n\u0019TRIGGER_DORA_E_BOT_ACTIVE\u0010Øe\u0012\u001f\n\u001aTRIGGER_QUERY_WHEN_SILENCE\u0010Ùe\u0012\u001c\n\u0017TRIGGER_FULL_TEXT_QUERY\u0010«f\u0012\u001f\n\u001aTRIGGER_QUOTA_LEAK_WARNING\u0010¬f\u0012\u000f\n\nSEND_IMAGE\u0010±m\u0012\u0012\n\rWakeUp_Reject\u0010²m\u0012\u0013\n\u000eWakeUp_Success\u0010³m\u0012\u0013\n\u000eEnter_DIALOGUE\u0010ºm\u0012\u0012\n\rExit_DIALOGUE\u0010»m\u0012\u0018\n\u0013ENTER_DIALOGUE_RESP\u0010Äm\u0012\u0017\n\u0012EXIT_DIALOGUE_RESP\u0010Åm\u0012\u0012\n\rCLIENT_INTENT\u0010Æm\u0012\u0017\n\u0012CLIENT_INTENT_RESP\u0010Çm\u0012\u0013\n\u000eUPLINK_HANG_UP\u0010\u0099u\u0012!\n\u001cUPLINK_UPDATE_EXTENSION_TIME\u0010\u009au\u0012\u000f\n\tMUTE_RESP\u0010¡\u009c\u0001\u0012\u0011\n\u000bUNMUTE_RESP\u0010¢\u009c\u0001\u0012\u0010\n\nPAUSE_RESP\u0010£\u009c\u0001\u0012\u0013\n\rCONTINUE_RESP\u0010¤\u009c\u0001\u0012\u0010\n\nVIDEO_EXIT\u0010¥\u009c\u0001\u0012\u001c\n\u0016POST_BACK_AUDIO_CONFIG\u0010¦\u009c\u0001\u0012\u0015\n\u000fRETRY_NEW_ROUND\u0010§\u009c\u0001\u0012\u0014\n\u000eASR_NOISE_INFO\u0010ª\u009c\u0001\u0012\u0011\n\u000bASR_SV_INFO\u0010«\u009c\u0001\u0012\u0019\n\u0013COMMON_AUDIO_CONFIG\u0010¬\u009c\u0001\u0012\u0015\n\u000fHELLO_TRIGGERED\u0010\u0089¤\u0001\u0012\u001c\n\u0016AUTH_SUCCESS_TRIGGERED\u0010\u008a¤\u0001\u0012\u0019\n\u0013AUTH_DENY_TRIGGERED\u0010\u008b¤\u0001\u0012\u0014\n\u000eWAIT_TRIGGERED\u0010\u008c¤\u0001\u0012\u0016\n\u0010HANGUP_TRIGGERED\u0010\u008d¤\u0001\u0012\u001c\n\u0016UPDATE_UI_CONTEXT_RESP\u0010û«\u0001\u0012\u0015\n\u000fCLIM_IN_STARTED\u0010ü«\u0001\u0012\u0011\n\u000bCLIM_IN_END\u0010ý«\u0001\u0012\u001b\n\u0015INTERPRET_ASR_STARTED\u0010þ«\u0001\u0012\u0016\n\u0010INTERPRET_FINISH\u0010ÿ«\u0001\u0012\u0015\n\u000fNOISY_TRIGGERED\u0010Ù³\u0001\u0012\u001b\n\u0015AUTH_FAILED_TRIGGERED\u0010Ú³\u0001\u0012 \n\u001aONBOARDING_START_TRIGGERED\u0010Û³\u0001\u0012\u001e\n\u0018VOICE_SELECTED_TRIGGERED\u0010Ü³\u0001\u0012\u001c\n\u0016MUSIC_PLAYED_TRIGGERED\u0010Ý³\u0001\u0012\u0017\n\u0011TIMEOUT_TRIGGERED\u0010Þ³\u0001\u0012\u001d\n\u0017CONTINUE_TYPE_TRIGGERED\u0010ß³\u0001\u0012\u001c\n\u0016ANCS_SUMMARY_TRIGGERED\u0010à³\u0001\u0012\u001a\n\u0014REQUEST_CHAT_TRIGGER\u0010á³\u0001\u0012\u0015\n\u000fIMAGE_TRIGGERED\u0010â³\u0001\u0012\u0014\n\u000eSPEECH_STARTED\u0010ã³\u0001\u0012\u0012\n\fSPEECH_ENDED\u0010ä³\u0001\u0012\u0016\n\u0010VIDEO_FACE_TOAST\u0010å³\u0001\u0012\u0012\n\fSWITCH_SCENE\u0010Á»\u0001\u0012\u0014\n\u000eSCENE_SWITCHED\u0010Â»\u0001\u0012\u0012\n\fSWITCH_MODAL\u0010Ã»\u0001\u0012\u0014\n\u000eMODAL_SWITCHED\u0010Ä»\u0001\u0012\u0013\n\rSTART_LOADING\u0010©Ã\u0001\u0012\u0014\n\u000eFINISH_LOADING\u0010ªÃ\u0001\u0012\u0016\n\u0010DOWNLINK_HANG_UP\u0010«Ã\u0001\u0012\u001d\n\u0017DOWNLINK_TRANSMIT_REPLY\u0010¬Ã\u0001\u0012\u001d\n\u0017DOWNLINK_QUOTA_EXCEEDED\u0010\u00adÃ\u0001\u0012\u0019\n\u0013AI_PROACTIVE_NOTIFY\u0010ùÒ\u0001\u0012\u0011\n\u000bSPEECH_ONLY\u0010áÔ\u0003\u0012\u0017\n\u0011AUDIO_ROUND_TRACE\u0010\u0081ñ\u0004\u0012\u0011\n\u000bCLIENT_SYNC\u0010\u0082ñ\u0004\u0012\u001a\n\u0014UPDATE_ROUND_CONTEXT\u0010±Û\u0006\u0012\u001d\n\u0017UPDATE_PERSONAL_CONTEXT\u0010²Û\u0006\u0012\u0014\n\u000ePreInterrupted\u0010\u0095Ü\u0006\u0012\u000e\n\bPreFetch\u0010\u0096Ü\u0006\u0012\u0013\n\rQueryRejected\u0010\u0097Ü\u0006*E\n\u000eChildReplyType\u0012\u000e\n\nREPLY_TEXT\u0010\u0000\u0012\u0012\n\u000eREPLY_SENTENCE\u0010\u0001\u0012\u000f\n\u000bREPLY_THINK\u0010\u0002*,\n\nReplyStage\u0012\t\n\u0005BEGIN\u0010\u0000\u0012\n\n\u0006UPDATE\u0010\u0001\u0012\u0007\n\u0003END\u0010\u0002*6\n\fReplyEndType\u0012\r\n\tGENERATED\u0010\u0000\u0012\n\n\u0006PUSHED\u0010\u0001\u0012\u000b\n\u0007NOREPLY\u0010\u0002*2\n\rChatReplyType\u0012\t\n\u0005EMPTY\u0010\u0000\u0012\n\n\u0006NORMAL\u0010\u0001\u0012\n\n\u0006PLUGIN\u0010\u0002B'Z%code.byted.org/flow/alice_protocol/avb\u0006proto3"}, r100, new AnonymousClass1());
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static /* synthetic */ Descriptors.FileDescriptor access$002(Descriptors.FileDescriptor r100) {
        descriptor = r100;
        return r100;
    }

    public static void registerAllExtensions(ExtensionRegistry r100) {
        registerAllExtensions(r100);
    }
}
