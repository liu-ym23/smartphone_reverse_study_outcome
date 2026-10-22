package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ErrorCode extends Enum<ErrorCode> implements WireEnum {
    private static final /* synthetic */ ErrorCode[] $VALUES = null;
    public static final ProtoAdapter<ErrorCode> ADAPTER = null;
    public static final ErrorCode AbandonedUnderStartUpControl = null;
    public static final ErrorCode Accepted = null;
    public static final ErrorCode ActionAppCardVersionNotMatch = null;
    public static final ErrorCode ActionContentVersionNotMatch = null;
    public static final ErrorCode ActionLocalActionNotFound = null;
    public static final ErrorCode ActionMessageTypeInvalid = null;
    public static final ErrorCode ActionSDKCardEntityActionError = null;
    public static final ErrorCode ActionSDKCardVersionNotMatch = null;
    public static final ErrorCode ActionTranslationActionNotFound = null;
    public static final ErrorCode AttendeeNumberExceedsLimit = null;
    public static final ErrorCode BrokenLoginInvariant = null;
    public static final ErrorCode CalendarFieldInvalid = null;
    public static final ErrorCode CalendarNotFound = null;
    public static final ErrorCode CalendarNotWritable = null;
    public static final ErrorCode CalendarQueueClosed = null;
    public static final ErrorCode CatchUnwindError = null;
    public static final ErrorCode CcharToRstrError = null;
    public static final ErrorCode ChunkyUploadCancelled = null;
    public static final ErrorCode ChunkyUploadFailed = null;
    public static final ErrorCode ClientProtobufDecodeError = null;
    public static final ErrorCode CryptoError = null;
    public static final ErrorCode DataIsNotImage = null;
    public static final ErrorCode DatabaseNotInited = null;
    public static final ErrorCode DefaultFsUnitFetchFailed = null;
    public static final ErrorCode DisableEncryptEvent = null;
    public static final ErrorCode DoubleBatchDownload = null;
    public static final ErrorCode DozeMode = null;
    public static final ErrorCode DupLoginWithDifferentTenantID = null;
    public static final ErrorCode EditMessageDeniedByTimeLimit = null;
    public static final ErrorCode EncryptedChatUnableToSendContactAdmin = null;
    public static final ErrorCode EventFieldInvalid = null;
    public static final ErrorCode EventNotFound = null;
    public static final ErrorCode EventNotFoundedInDb = null;
    public static final ErrorCode EventNotWritable = null;
    public static final ErrorCode EventReadSyncDoneError = null;
    public static final ErrorCode EventReadSyncSDKDoneError = null;
    public static final ErrorCode EventSharedInSyncing = null;
    public static final ErrorCode EventWriteSDKSaveError = null;
    public static final ErrorCode EventWriteSyncAttendeeNotMatchError = null;
    public static final ErrorCode EventWriteSyncDoneError = null;
    public static final ErrorCode EventWriteSyncEventNotMatchError = null;
    public static final ErrorCode EventWriteSyncNoneEventError = null;
    public static final ErrorCode EventWriteSyncSDKDoneError = null;
    public static final ErrorCode ExceedMaxVisibleCalNum = null;
    public static final ErrorCode ExclusiveChatServiceError = null;
    public static final ErrorCode Forbidden = null;
    public static final ErrorCode FormatEmpty = null;
    public static final ErrorCode FrequencyLimit = null;
    public static final ErrorCode General = null;
    public static final ErrorCode GetAvatarFutFailed = null;
    public static final ErrorCode GetAvatarRequestFailed = null;
    public static final ErrorCode GetDeviceConfigBeforeSet = null;
    public static final ErrorCode GetFastestDownloadUrlFailed = null;
    public static final ErrorCode Gone = null;
    public static final ErrorCode InvalidCalendarEvent = null;
    public static final ErrorCode InvalidDataFormat = null;
    public static final ErrorCode InvalidTimeRange = null;
    public static final ErrorCode InvokeUserCmdWhenLogin = null;
    public static final ErrorCode IoError = null;
    public static final ErrorCode IoNotFound = null;
    public static final ErrorCode IoPermissionDenied = null;
    public static final ErrorCode IoStorageFull = null;
    public static final ErrorCode IsFeedSyncing = null;
    public static final ErrorCode KnowledgeAIShowMessage = null;
    public static final ErrorCode LoginWithoutTenantID = null;
    public static final ErrorCode LoginWithoutUserInfo = null;
    public static final ErrorCode MailBasicPermissionDisabled = null;
    public static final ErrorCode MailCanNotSendExternal = null;
    public static final ErrorCode MailDraftAttachmentTooLarge = null;
    public static final ErrorCode MailDraftHasBeenDeleted = null;
    public static final ErrorCode MailDraftHasBeenSent = null;
    public static final ErrorCode MailDraftSendQuotaExceeded = null;
    public static final ErrorCode MailDraftSubmissionFailed = null;
    public static final ErrorCode MailSwitchAccount = null;
    public static final ErrorCode MailSwitchPrimaryAccountInvalid = null;
    public static final ErrorCode MailTriAccountCreateAuthFailed = null;
    public static final ErrorCode MailTriAccountCreateRepeatedAddress = null;
    public static final ErrorCode MailTriAccountTaskCancelled = null;
    public static final ErrorCode MailTriAccountUpdateDiffAddress = null;
    public static final ErrorCode MediaIOError = null;
    public static final ErrorCode MediaTranscodeCancel = null;
    public static final ErrorCode MediaTranscodeFail = null;
    public static final ErrorCode NetworkLibraryError = null;
    public static final ErrorCode NewEventNotSyncToServer = null;
    public static final ErrorCode NoLeanModeAuthority = null;
    public static final ErrorCode NoSelfPrimaryCalendar = null;
    public static final ErrorCode NoUserList = null;
    public static final ErrorCode NotFound = null;
    public static final ErrorCode NotReady = null;
    public static final ErrorCode NotSupportDir = null;
    public static final ErrorCode Offline = null;
    public static final ErrorCode OnlineFailedAndGetLocalData = null;
    public static final ErrorCode OperationToPendingDeleteFeed = null;
    public static final ErrorCode OptimisticQueueCancelError = null;
    public static final ErrorCode PartialDownloadInitError = null;
    public static final ErrorCode PathEmpty = null;
    public static final ErrorCode PathTraversal = null;
    public static final ErrorCode ProtobufDecodeError = null;
    public static final ErrorCode ProtobufIOError = null;
    public static final ErrorCode ProtobufMessageNotInitialized = null;
    public static final ErrorCode ProtobufUtf8Error = null;
    public static final ErrorCode ProtobufWireError = null;
    public static final ErrorCode RecvTimeout = null;
    public static final ErrorCode RecvTimeoutDisconnected = null;
    public static final ErrorCode RequestClientErr = null;
    public static final ErrorCode RequestFrequencyLimited = null;
    public static final ErrorCode RequestServerErr = null;
    public static final ErrorCode ResourceKeyNotFound = null;
    public static final ErrorCode SaveAvatarError = null;
    public static final ErrorCode SavingEventInvalid = null;
    public static final ErrorCode SecCheckInfraFailed = null;
    public static final ErrorCode SecretChatMyChatCorrupt = null;
    public static final ErrorCode SecretChatMyKeyOutdated = null;
    public static final ErrorCode SecretChatOtherKeyOutdated = null;
    public static final ErrorCode SecurityBizCodeMissing = null;
    public static final ErrorCode SecurityDataMissing = null;
    public static final ErrorCode SecurityJsonParsingFailed = null;
    public static final ErrorCode SecurityParamMissing = null;
    public static final ErrorCode SecurityPolicySDKDisplayFetchTimeout = null;
    public static final ErrorCode SecurityPolicySDKDisplayModelMissing = null;
    public static final ErrorCode SendMessageMissDependentChannel = null;
    public static final ErrorCode SendMessageTooOften = null;
    public static final ErrorCode SerializationError = null;
    public static final ErrorCode ServerProtobufDecodeError = null;
    public static final ErrorCode ShareAllFailure = null;
    public static final ErrorCode StreamUploadNeedRetry = null;
    public static final ErrorCode StreamUploadResponseEmpty = null;
    public static final ErrorCode SwiftUploadFailed = null;
    public static final ErrorCode SwitchToFrozenUser = null;
    public static final ErrorCode SwitchingUser = null;
    public static final ErrorCode TimeBlockNotFound = null;
    public static final ErrorCode Timeout = null;
    public static final ErrorCode TodoAssigneeNumberExceedsLimit = null;
    public static final ErrorCode TodoFollowerNumberExceedsLimit = null;
    public static final ErrorCode TransmitAllFailure = null;
    public static final ErrorCode TransmitPartialFailure = null;
    public static final ErrorCode Unauthorized = null;
    public static final ErrorCode UnexpectedIllegalValue = null;
    public static final ErrorCode UnexpectedNoneValue = null;
    public static final ErrorCode Unknown = null;
    public static final ErrorCode UnregisteredCMD = null;
    public static final ErrorCode UploadFileOnOffline = null;
    public static final ErrorCode UploadFolderOnOffline = null;
    public static final ErrorCode UploadInSufficient = null;
    public static final ErrorCode UserContainerIdMismatchErr = null;
    public static final ErrorCode UserContainerNotReadyErr = null;
    public static final ErrorCode UserIdVerificationErr = null;
    public static final ErrorCode UserNotInMeetingChat = null;
    public static final ErrorCode VcE2EEEnDecryptError = null;
    public static final ErrorCode VerificationFailed = null;
    public final Boolean deprecated;
    private final int value;

    static {
        ErrorCode r100 = new ErrorCode("General", 0, 100000, null);
        General = r100;
        ErrorCode r101 = new ErrorCode("SwitchingUser", 1, 100001, null);
        SwitchingUser = r101;
        ErrorCode r102 = new ErrorCode("SwitchToFrozenUser", 2, 100002, null);
        SwitchToFrozenUser = r102;
        ErrorCode r103 = new ErrorCode("RequestClientErr", 3, 100011, null);
        RequestClientErr = r103;
        ErrorCode r104 = new ErrorCode("RequestServerErr", 4, 100012, null);
        RequestServerErr = r104;
        ErrorCode r105 = new ErrorCode("Unauthorized", 5, 100013, null);
        Unauthorized = r105;
        ErrorCode r110 = new ErrorCode("Forbidden", 6, 100014, null);
        Forbidden = r110;
        ErrorCode r111 = new ErrorCode("Gone", 7, 100015, null);
        Gone = r111;
        ErrorCode r112 = new ErrorCode("NotFound", 8, 100016, null);
        NotFound = r112;
        ErrorCode r113 = new ErrorCode("AbandonedUnderStartUpControl", 9, 100017, null);
        AbandonedUnderStartUpControl = r113;
        ErrorCode r114 = new ErrorCode("Accepted", 10, 100018, null);
        Accepted = r114;
        ErrorCode r106 = new ErrorCode("UserIdVerificationErr", 11, 100030, null);
        UserIdVerificationErr = r106;
        ErrorCode r107 = new ErrorCode("BrokenLoginInvariant", 12, 100031, null);
        BrokenLoginInvariant = r107;
        ErrorCode r108 = new ErrorCode("InvokeUserCmdWhenLogin", 13, 100032, null);
        InvokeUserCmdWhenLogin = r108;
        ErrorCode r109 = new ErrorCode("LoginWithoutTenantID", 14, 100033, null);
        LoginWithoutTenantID = r109;
        ErrorCode r115 = new ErrorCode("DupLoginWithDifferentTenantID", 15, 100034, null);
        DupLoginWithDifferentTenantID = r115;
        ErrorCode r116 = new ErrorCode("LoginWithoutUserInfo", 16, 100035, null);
        LoginWithoutUserInfo = r116;
        ErrorCode r117 = new ErrorCode("GetDeviceConfigBeforeSet", 17, 100036, null);
        GetDeviceConfigBeforeSet = r117;
        ErrorCode r118 = new ErrorCode("UnregisteredCMD", 18, 100037, null);
        UnregisteredCMD = r118;
        ErrorCode r119 = new ErrorCode("UserContainerIdMismatchErr", 19, 100038, null);
        UserContainerIdMismatchErr = r119;
        ErrorCode r120 = new ErrorCode("UserContainerNotReadyErr", 20, 100039, null);
        UserContainerNotReadyErr = r120;
        ErrorCode r121 = new ErrorCode("Offline", 21, 100052, null);
        Offline = r121;
        ErrorCode r122 = new ErrorCode("NetworkLibraryError", 22, 100053, null);
        NetworkLibraryError = r122;
        ErrorCode r123 = new ErrorCode("Timeout", 23, 100054, null);
        Timeout = r123;
        ErrorCode r124 = new ErrorCode("DozeMode", 24, 100055, null);
        DozeMode = r124;
        ErrorCode r125 = new ErrorCode("FrequencyLimit", 25, 100056, null);
        FrequencyLimit = r125;
        ErrorCode r126 = new ErrorCode("NotReady", 26, 100057, null);
        NotReady = r126;
        ErrorCode r127 = new ErrorCode("NotSupportDir", 27, 100101, null);
        NotSupportDir = r127;
        Boolean r128 = Boolean.TRUE;
        ErrorCode r129 = new ErrorCode("MediaTranscodeFail", 28, 100151, r128);
        MediaTranscodeFail = r129;
        ErrorCode r130 = new ErrorCode("MediaTranscodeCancel", 29, 100152, r128);
        MediaTranscodeCancel = r130;
        ErrorCode r131 = new ErrorCode("MediaIOError", 30, 100153, r128);
        MediaIOError = r131;
        ErrorCode r132 = new ErrorCode("DatabaseNotInited", 31, 100201, null);
        DatabaseNotInited = r132;
        ErrorCode r133 = new ErrorCode("IoError", 32, 100300, null);
        IoError = r133;
        ErrorCode r134 = new ErrorCode("IoNotFound", 33, 100301, null);
        IoNotFound = r134;
        ErrorCode r135 = new ErrorCode("IoPermissionDenied", 34, 100302, null);
        IoPermissionDenied = r135;
        ErrorCode r136 = new ErrorCode("IoStorageFull", 35, 100303, null);
        IoStorageFull = r136;
        ErrorCode r137 = new ErrorCode("ProtobufDecodeError", 36, 100400, null);
        ProtobufDecodeError = r137;
        ErrorCode r138 = new ErrorCode("ClientProtobufDecodeError", 37, 100401, null);
        ClientProtobufDecodeError = r138;
        ErrorCode r139 = new ErrorCode("ServerProtobufDecodeError", 38, 100402, null);
        ServerProtobufDecodeError = r139;
        ErrorCode r140 = new ErrorCode("ProtobufIOError", 39, 100403, null);
        ProtobufIOError = r140;
        ErrorCode r141 = new ErrorCode("ProtobufWireError", 40, 100404, null);
        ProtobufWireError = r141;
        ErrorCode r142 = new ErrorCode("ProtobufUtf8Error", 41, 100405, null);
        ProtobufUtf8Error = r142;
        ErrorCode r143 = new ErrorCode("ProtobufMessageNotInitialized", 42, 100406, null);
        ProtobufMessageNotInitialized = r143;
        ErrorCode r144 = new ErrorCode("CryptoError", 43, 100501, null);
        CryptoError = r144;
        ErrorCode r145 = new ErrorCode("SecretChatMyChatCorrupt", 44, 100600, null);
        SecretChatMyChatCorrupt = r145;
        ErrorCode r146 = new ErrorCode("SecretChatMyKeyOutdated", 45, 100601, null);
        SecretChatMyKeyOutdated = r146;
        ErrorCode r147 = new ErrorCode("SecretChatOtherKeyOutdated", 46, 100602, null);
        SecretChatOtherKeyOutdated = r147;
        ErrorCode r148 = new ErrorCode("SendMessageTooOften", 47, 101001, null);
        SendMessageTooOften = r148;
        ErrorCode r149 = new ErrorCode("OnlineFailedAndGetLocalData", 48, 101002, null);
        OnlineFailedAndGetLocalData = r149;
        ErrorCode r150 = new ErrorCode("SendMessageMissDependentChannel", 49, 101003, null);
        SendMessageMissDependentChannel = r150;
        ErrorCode r151 = new ErrorCode("EventSharedInSyncing", 50, 102001, null);
        EventSharedInSyncing = r151;
        ErrorCode r152 = new ErrorCode("InvalidCalendarEvent", 51, 102002, null);
        InvalidCalendarEvent = r152;
        ErrorCode r153 = new ErrorCode("AttendeeNumberExceedsLimit", 52, 102003, null);
        AttendeeNumberExceedsLimit = r153;
        ErrorCode r154 = new ErrorCode("UserNotInMeetingChat", 53, 102004, null);
        UserNotInMeetingChat = r154;
        ErrorCode r155 = new ErrorCode("ExceedMaxVisibleCalNum", 54, 102005, null);
        ExceedMaxVisibleCalNum = r155;
        ErrorCode r156 = new ErrorCode("EventWriteSyncDoneError", 55, 102006, null);
        EventWriteSyncDoneError = r156;
        ErrorCode r157 = new ErrorCode("EventWriteSyncSDKDoneError", 56, 102007, null);
        EventWriteSyncSDKDoneError = r157;
        ErrorCode r158 = new ErrorCode("EventWriteSDKSaveError", 57, 102008, null);
        EventWriteSDKSaveError = r158;
        ErrorCode r159 = new ErrorCode("EventReadSyncDoneError", 58, 102009, null);
        EventReadSyncDoneError = r159;
        ErrorCode r160 = new ErrorCode("EventReadSyncSDKDoneError", 59, 102010, null);
        EventReadSyncSDKDoneError = r160;
        ErrorCode r161 = new ErrorCode("DisableEncryptEvent", 60, 102011, null);
        DisableEncryptEvent = r161;
        ErrorCode r162 = new ErrorCode("EventWriteSyncNoneEventError", 61, 102012, null);
        EventWriteSyncNoneEventError = r162;
        ErrorCode r163 = new ErrorCode("EventWriteSyncEventNotMatchError", 62, 102013, null);
        EventWriteSyncEventNotMatchError = r163;
        ErrorCode r164 = new ErrorCode("EventWriteSyncAttendeeNotMatchError", 63, 102014, null);
        EventWriteSyncAttendeeNotMatchError = r164;
        ErrorCode r165 = new ErrorCode("EventNotFoundedInDb", 64, 102015, null);
        EventNotFoundedInDb = r165;
        ErrorCode r166 = new ErrorCode("EventFieldInvalid", 65, 102016, null);
        EventFieldInvalid = r166;
        ErrorCode r167 = new ErrorCode("SavingEventInvalid", 66, 102017, null);
        SavingEventInvalid = r167;
        ErrorCode r168 = new ErrorCode("EventNotFound", 67, 102018, null);
        EventNotFound = r168;
        ErrorCode r169 = new ErrorCode("EventNotWritable", 68, 102019, null);
        EventNotWritable = r169;
        ErrorCode r170 = new ErrorCode("NewEventNotSyncToServer", 69, 102020, null);
        NewEventNotSyncToServer = r170;
        ErrorCode r171 = new ErrorCode("CalendarNotFound", 70, 102100, null);
        CalendarNotFound = r171;
        ErrorCode r172 = new ErrorCode("CalendarNotWritable", 71, 102101, null);
        CalendarNotWritable = r172;
        ErrorCode r173 = new ErrorCode("CalendarFieldInvalid", 72, 102102, null);
        CalendarFieldInvalid = r173;
        ErrorCode r174 = new ErrorCode("NoSelfPrimaryCalendar", 73, 102103, null);
        NoSelfPrimaryCalendar = r174;
        ErrorCode r175 = new ErrorCode("RequestFrequencyLimited", 74, 102200, null);
        RequestFrequencyLimited = r175;
        ErrorCode r176 = new ErrorCode("InvalidTimeRange", 75, 102201, null);
        InvalidTimeRange = r176;
        ErrorCode r177 = new ErrorCode("UnexpectedNoneValue", 76, 102202, null);
        UnexpectedNoneValue = r177;
        ErrorCode r178 = new ErrorCode("UnexpectedIllegalValue", 77, 102203, null);
        UnexpectedIllegalValue = r178;
        ErrorCode r179 = new ErrorCode("CalendarQueueClosed", 78, 102204, null);
        CalendarQueueClosed = r179;
        ErrorCode r180 = new ErrorCode("TimeBlockNotFound", 79, 102300, null);
        TimeBlockNotFound = r180;
        ErrorCode r181 = new ErrorCode("TodoAssigneeNumberExceedsLimit", 80, 103001, null);
        TodoAssigneeNumberExceedsLimit = r181;
        ErrorCode r182 = new ErrorCode("TodoFollowerNumberExceedsLimit", 81, 103002, null);
        TodoFollowerNumberExceedsLimit = r182;
        ErrorCode r183 = new ErrorCode("InvalidDataFormat", 82, 103003, null);
        InvalidDataFormat = r183;
        ErrorCode r184 = new ErrorCode("SerializationError", 83, 103004, null);
        SerializationError = r184;
        ErrorCode r185 = new ErrorCode("MailSwitchAccount", 84, 104001, null);
        MailSwitchAccount = r185;
        ErrorCode r186 = new ErrorCode("MailTriAccountUpdateDiffAddress", 85, 104002, null);
        MailTriAccountUpdateDiffAddress = r186;
        ErrorCode r187 = new ErrorCode("MailTriAccountCreateRepeatedAddress", 86, 104003, null);
        MailTriAccountCreateRepeatedAddress = r187;
        ErrorCode r188 = new ErrorCode("MailTriAccountCreateAuthFailed", 87, 104004, null);
        MailTriAccountCreateAuthFailed = r188;
        ErrorCode r189 = new ErrorCode("MailTriAccountTaskCancelled", 88, 104005, null);
        MailTriAccountTaskCancelled = r189;
        ErrorCode r190 = new ErrorCode("MailBasicPermissionDisabled", 89, 104006, null);
        MailBasicPermissionDisabled = r190;
        ErrorCode r191 = new ErrorCode("MailSwitchPrimaryAccountInvalid", 90, 104007, null);
        MailSwitchPrimaryAccountInvalid = r191;
        ErrorCode r192 = new ErrorCode("MailDraftHasBeenDeleted", 91, 104010, null);
        MailDraftHasBeenDeleted = r192;
        ErrorCode r193 = new ErrorCode("MailDraftHasBeenSent", 92, 104011, null);
        MailDraftHasBeenSent = r193;
        ErrorCode r194 = new ErrorCode("MailCanNotSendExternal", 93, 104020, null);
        MailCanNotSendExternal = r194;
        ErrorCode r195 = new ErrorCode("MailDraftSendQuotaExceeded", 94, 104021, null);
        MailDraftSendQuotaExceeded = r195;
        ErrorCode r196 = new ErrorCode("MailDraftAttachmentTooLarge", 95, 104022, null);
        MailDraftAttachmentTooLarge = r196;
        ErrorCode r197 = new ErrorCode("MailDraftSubmissionFailed", 96, 104023, null);
        MailDraftSubmissionFailed = r197;
        ErrorCode r198 = new ErrorCode("UploadInSufficient", 97, 105001, null);
        UploadInSufficient = r198;
        ErrorCode r199 = new ErrorCode("DoubleBatchDownload", 98, 105002, null);
        DoubleBatchDownload = r199;
        ErrorCode r200 = new ErrorCode("GetFastestDownloadUrlFailed", 99, 105008, r128);
        GetFastestDownloadUrlFailed = r200;
        ErrorCode r201 = new ErrorCode("PartialDownloadInitError", 100, 105009, r128);
        PartialDownloadInitError = r201;
        ErrorCode r202 = new ErrorCode("VerificationFailed", 101, 105010, null);
        VerificationFailed = r202;
        ErrorCode r203 = new ErrorCode("ResourceKeyNotFound", 102, 105011, null);
        ResourceKeyNotFound = r203;
        ErrorCode r204 = new ErrorCode("StreamUploadNeedRetry", 103, 105012, null);
        StreamUploadNeedRetry = r204;
        ErrorCode r205 = new ErrorCode("StreamUploadResponseEmpty", 104, 105013, null);
        StreamUploadResponseEmpty = r205;
        ErrorCode r206 = new ErrorCode("Unknown", 105, 105400, null);
        Unknown = r206;
        ErrorCode r207 = new ErrorCode("GetAvatarRequestFailed", 106, 105401, r128);
        GetAvatarRequestFailed = r207;
        ErrorCode r208 = new ErrorCode("PathEmpty", 107, 105402, null);
        PathEmpty = r208;
        ErrorCode r209 = new ErrorCode("RecvTimeout", 108, 105403, null);
        RecvTimeout = r209;
        ErrorCode r210 = new ErrorCode("RecvTimeoutDisconnected", 109, 105404, null);
        RecvTimeoutDisconnected = r210;
        ErrorCode r211 = new ErrorCode("CatchUnwindError", 110, 105405, null);
        CatchUnwindError = r211;
        ErrorCode r212 = new ErrorCode("FormatEmpty", 111, 105406, null);
        FormatEmpty = r212;
        ErrorCode r213 = new ErrorCode("DefaultFsUnitFetchFailed", 112, 105408, r128);
        DefaultFsUnitFetchFailed = r213;
        ErrorCode r214 = new ErrorCode("DataIsNotImage", 113, 105409, null);
        DataIsNotImage = r214;
        ErrorCode r215 = new ErrorCode("SaveAvatarError", 114, 105410, null);
        SaveAvatarError = r215;
        ErrorCode r216 = new ErrorCode("GetAvatarFutFailed", 115, 105411, r128);
        GetAvatarFutFailed = r216;
        ErrorCode r217 = new ErrorCode("CcharToRstrError", 116, 105407, null);
        CcharToRstrError = r217;
        ErrorCode r218 = new ErrorCode("ChunkyUploadCancelled", 117, 105003, null);
        ChunkyUploadCancelled = r218;
        ErrorCode r219 = new ErrorCode("ChunkyUploadFailed", 118, 105004, null);
        ChunkyUploadFailed = r219;
        ErrorCode r220 = new ErrorCode("UploadFileOnOffline", 119, 105005, null);
        UploadFileOnOffline = r220;
        ErrorCode r221 = new ErrorCode("UploadFolderOnOffline", 120, 105006, null);
        UploadFolderOnOffline = r221;
        ErrorCode r222 = new ErrorCode("SwiftUploadFailed", 121, 105007, r128);
        SwiftUploadFailed = r222;
        ErrorCode r223 = new ErrorCode("PathTraversal", 122, 105015, null);
        PathTraversal = r223;
        ErrorCode r224 = new ErrorCode("TransmitPartialFailure", 123, 105500, null);
        TransmitPartialFailure = r224;
        ErrorCode r225 = new ErrorCode("TransmitAllFailure", 124, 105501, null);
        TransmitAllFailure = r225;
        ErrorCode r226 = new ErrorCode("ShareAllFailure", 125, 105502, null);
        ShareAllFailure = r226;
        ErrorCode r227 = new ErrorCode("EncryptedChatUnableToSendContactAdmin", 126, 105503, null);
        EncryptedChatUnableToSendContactAdmin = r227;
        ErrorCode r228 = new ErrorCode("ExclusiveChatServiceError", 127, 105504, null);
        ExclusiveChatServiceError = r228;
        ErrorCode r229 = new ErrorCode("EditMessageDeniedByTimeLimit", 128, 1005600, null);
        EditMessageDeniedByTimeLimit = r229;
        ErrorCode r230 = new ErrorCode("VcE2EEEnDecryptError", 129, 107001, null);
        VcE2EEEnDecryptError = r230;
        ErrorCode r231 = new ErrorCode("OptimisticQueueCancelError", 130, 107002, null);
        OptimisticQueueCancelError = r231;
        ErrorCode r232 = new ErrorCode("ActionContentVersionNotMatch", 131, 108001, null);
        ActionContentVersionNotMatch = r232;
        ErrorCode r233 = new ErrorCode("ActionLocalActionNotFound", 132, 108002, null);
        ActionLocalActionNotFound = r233;
        ErrorCode r234 = new ErrorCode("ActionMessageTypeInvalid", 133, 108003, null);
        ActionMessageTypeInvalid = r234;
        ErrorCode r235 = new ErrorCode("ActionTranslationActionNotFound", 134, 108004, null);
        ActionTranslationActionNotFound = r235;
        ErrorCode r236 = new ErrorCode("ActionAppCardVersionNotMatch", 135, 108005, null);
        ActionAppCardVersionNotMatch = r236;
        ErrorCode r237 = new ErrorCode("ActionSDKCardVersionNotMatch", 136, 108006, null);
        ActionSDKCardVersionNotMatch = r237;
        ErrorCode r238 = new ErrorCode("ActionSDKCardEntityActionError", 137, 108007, null);
        ActionSDKCardEntityActionError = r238;
        ErrorCode r239 = new ErrorCode("OperationToPendingDeleteFeed", 138, 111001, null);
        OperationToPendingDeleteFeed = r239;
        ErrorCode r240 = new ErrorCode("NoUserList", 139, 111002, null);
        NoUserList = r240;
        ErrorCode r241 = new ErrorCode("NoLeanModeAuthority", 140, 170001, null);
        NoLeanModeAuthority = r241;
        ErrorCode r242 = new ErrorCode("IsFeedSyncing", 141, 170002, null);
        IsFeedSyncing = r242;
        ErrorCode r243 = new ErrorCode("SecCheckInfraFailed", 142, 180001, null);
        SecCheckInfraFailed = r243;
        ErrorCode r244 = new ErrorCode("SecurityParamMissing", 143, 190000, null);
        SecurityParamMissing = r244;
        ErrorCode r245 = new ErrorCode("SecurityBizCodeMissing", 144, 190001, null);
        SecurityBizCodeMissing = r245;
        ErrorCode r246 = new ErrorCode("SecurityDataMissing", 145, 190002, null);
        SecurityDataMissing = r246;
        ErrorCode r247 = new ErrorCode("SecurityJsonParsingFailed", 146, 190003, null);
        SecurityJsonParsingFailed = r247;
        ErrorCode r248 = new ErrorCode("SecurityPolicySDKDisplayModelMissing", 147, 190004, null);
        SecurityPolicySDKDisplayModelMissing = r248;
        ErrorCode r249 = new ErrorCode("SecurityPolicySDKDisplayFetchTimeout", 148, 190005, null);
        SecurityPolicySDKDisplayFetchTimeout = r249;
        ErrorCode r250 = new ErrorCode("KnowledgeAIShowMessage", 149, 200001, null);
        KnowledgeAIShowMessage = r250;
        $VALUES = new ErrorCode[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, r187, r188, r189, r190, r191, r192, r193, r194, r195, r196, r197, r198, r199, r200, r201, r202, r203, r204, r205, r206, r207, r208, r209, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r220, r221, r222, r223, r224, r225, r226, r227, r228, r229, r230, r231, r232, r233, r234, r235, r236, r237, r238, r239, r240, r241, r242, r243, r244, r245, r246, r247, r248, r249, r250};
        ADAPTER = ProtoAdapter.newEnumAdapter(ErrorCode.class);
    }

    public static ErrorCode[] values() {
        return (ErrorCode[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ErrorCode fromValue(int r100) {
        switch(r100) {
            case 100000: goto L313;
            case 100001: goto L311;
            case 100002: goto L309;
            default: goto L3;
        };
    L3:
        switch(r100) {
            case 100011: goto L307;
            case 100012: goto L305;
            case 100013: goto L303;
            case 100014: goto L301;
            case 100015: goto L299;
            case 100016: goto L297;
            case 100017: goto L295;
            case 100018: goto L293;
            default: goto L4;
        };
    L4:
        switch(r100) {
            case 100030: goto L291;
            case 100031: goto L289;
            case 100032: goto L287;
            case 100033: goto L285;
            case 100034: goto L283;
            case 100035: goto L281;
            case 100036: goto L279;
            case 100037: goto L277;
            case 100038: goto L275;
            case 100039: goto L273;
            default: goto L5;
        };
    L5:
        switch(r100) {
            case 100052: goto L271;
            case 100053: goto L269;
            case 100054: goto L267;
            case 100055: goto L265;
            case 100056: goto L263;
            case 100057: goto L261;
            default: goto L6;
        };
    L6:
        switch(r100) {
            case 100101: goto L259;
            case 100201: goto L257;
            case 100501: goto L255;
            case 102001: goto L253;
            case 102002: goto L251;
            case 102003: goto L249;
            case 102004: goto L247;
            case 102005: goto L245;
            case 102006: goto L243;
            case 102007: goto L241;
            case 102008: goto L239;
            case 102009: goto L237;
            case 102010: goto L235;
            case 102011: goto L233;
            case 102012: goto L231;
            case 102013: goto L229;
            case 102014: goto L227;
            case 102015: goto L225;
            case 102016: goto L223;
            case 102017: goto L221;
            case 102018: goto L219;
            case 102019: goto L217;
            case 102020: goto L215;
            case 102100: goto L213;
            case 102101: goto L211;
            case 102102: goto L209;
            case 102103: goto L207;
            case 102200: goto L205;
            case 102201: goto L203;
            case 102202: goto L201;
            case 102203: goto L199;
            case 102204: goto L197;
            case 102300: goto L195;
            case 103001: goto L193;
            case 103002: goto L191;
            case 103003: goto L189;
            case 103004: goto L187;
            case 104001: goto L185;
            case 104002: goto L183;
            case 104003: goto L181;
            case 104004: goto L179;
            case 104005: goto L177;
            case 104006: goto L175;
            case 104007: goto L173;
            case 104010: goto L171;
            case 104011: goto L169;
            case 104020: goto L167;
            case 104021: goto L165;
            case 104022: goto L163;
            case 104023: goto L161;
            case 105001: goto L159;
            case 105002: goto L157;
            case 105003: goto L155;
            case 105004: goto L153;
            case 105005: goto L151;
            case 105006: goto L149;
            case 105007: goto L147;
            case 105008: goto L145;
            case 105009: goto L143;
            case 105010: goto L141;
            case 105011: goto L139;
            case 105012: goto L137;
            case 105013: goto L135;
            case 105015: goto L133;
            case 105400: goto L131;
            case 105401: goto L129;
            case 105402: goto L127;
            case 105403: goto L125;
            case 105404: goto L123;
            case 105405: goto L121;
            case 105406: goto L119;
            case 105407: goto L117;
            case 105408: goto L115;
            case 105409: goto L113;
            case 105410: goto L111;
            case 105411: goto L109;
            case 105500: goto L107;
            case 105501: goto L105;
            case 105502: goto L103;
            case 105503: goto L101;
            case 105504: goto L99;
            case 107001: goto L97;
            case 107002: goto L95;
            case 108001: goto L93;
            case 108002: goto L91;
            case 108003: goto L89;
            case 108004: goto L87;
            case 108005: goto L85;
            case 108006: goto L83;
            case 108007: goto L81;
            case 111001: goto L79;
            case 111002: goto L77;
            case 170001: goto L75;
            case 170002: goto L73;
            case 180001: goto L71;
            case 190000: goto L69;
            case 190001: goto L67;
            case 190002: goto L65;
            case 190003: goto L63;
            case 190004: goto L61;
            case 190005: goto L59;
            case 200001: goto L57;
            case 1005600: goto L55;
            default: goto L7;
        };
    L7:
        switch(r100) {
            case 100151: goto L53;
            case 100152: goto L51;
            case 100153: goto L49;
            default: goto L8;
        };
    L8:
        switch(r100) {
            case 100300: goto L47;
            case 100301: goto L45;
            case 100302: goto L43;
            case 100303: goto L41;
            default: goto L9;
        };
    L9:
        switch(r100) {
            case 100400: goto L39;
            case 100401: goto L37;
            case 100402: goto L35;
            case 100403: goto L33;
            case 100404: goto L31;
            case 100405: goto L29;
            case 100406: goto L27;
            default: goto L10;
        };
    L10:
        switch(r100) {
            case 100600: goto L25;
            case 100601: goto L23;
            case 100602: goto L21;
            default: goto L11;
        };
    L11:
        switch(r100) {
            case 101001: goto L19;
            case 101002: goto L17;
            case 101003: goto L15;
            default: goto L12;
        };
    L12:
        return null;
    L15:
        return SendMessageMissDependentChannel;
    L17:
        return OnlineFailedAndGetLocalData;
    L19:
        return SendMessageTooOften;
    L21:
        return SecretChatOtherKeyOutdated;
    L23:
        return SecretChatMyKeyOutdated;
    L25:
        return SecretChatMyChatCorrupt;
    L27:
        return ProtobufMessageNotInitialized;
    L29:
        return ProtobufUtf8Error;
    L31:
        return ProtobufWireError;
    L33:
        return ProtobufIOError;
    L35:
        return ServerProtobufDecodeError;
    L37:
        return ClientProtobufDecodeError;
    L39:
        return ProtobufDecodeError;
    L41:
        return IoStorageFull;
    L43:
        return IoPermissionDenied;
    L45:
        return IoNotFound;
    L47:
        return IoError;
    L49:
        return MediaIOError;
    L51:
        return MediaTranscodeCancel;
    L53:
        return MediaTranscodeFail;
    L55:
        return EditMessageDeniedByTimeLimit;
    L57:
        return KnowledgeAIShowMessage;
    L59:
        return SecurityPolicySDKDisplayFetchTimeout;
    L61:
        return SecurityPolicySDKDisplayModelMissing;
    L63:
        return SecurityJsonParsingFailed;
    L65:
        return SecurityDataMissing;
    L67:
        return SecurityBizCodeMissing;
    L69:
        return SecurityParamMissing;
    L71:
        return SecCheckInfraFailed;
    L73:
        return IsFeedSyncing;
    L75:
        return NoLeanModeAuthority;
    L77:
        return NoUserList;
    L79:
        return OperationToPendingDeleteFeed;
    L81:
        return ActionSDKCardEntityActionError;
    L83:
        return ActionSDKCardVersionNotMatch;
    L85:
        return ActionAppCardVersionNotMatch;
    L87:
        return ActionTranslationActionNotFound;
    L89:
        return ActionMessageTypeInvalid;
    L91:
        return ActionLocalActionNotFound;
    L93:
        return ActionContentVersionNotMatch;
    L95:
        return OptimisticQueueCancelError;
    L97:
        return VcE2EEEnDecryptError;
    L99:
        return ExclusiveChatServiceError;
    L101:
        return EncryptedChatUnableToSendContactAdmin;
    L103:
        return ShareAllFailure;
    L105:
        return TransmitAllFailure;
    L107:
        return TransmitPartialFailure;
    L109:
        return GetAvatarFutFailed;
    L111:
        return SaveAvatarError;
    L113:
        return DataIsNotImage;
    L115:
        return DefaultFsUnitFetchFailed;
    L117:
        return CcharToRstrError;
    L119:
        return FormatEmpty;
    L121:
        return CatchUnwindError;
    L123:
        return RecvTimeoutDisconnected;
    L125:
        return RecvTimeout;
    L127:
        return PathEmpty;
    L129:
        return GetAvatarRequestFailed;
    L131:
        return Unknown;
    L133:
        return PathTraversal;
    L135:
        return StreamUploadResponseEmpty;
    L137:
        return StreamUploadNeedRetry;
    L139:
        return ResourceKeyNotFound;
    L141:
        return VerificationFailed;
    L143:
        return PartialDownloadInitError;
    L145:
        return GetFastestDownloadUrlFailed;
    L147:
        return SwiftUploadFailed;
    L149:
        return UploadFolderOnOffline;
    L151:
        return UploadFileOnOffline;
    L153:
        return ChunkyUploadFailed;
    L155:
        return ChunkyUploadCancelled;
    L157:
        return DoubleBatchDownload;
    L159:
        return UploadInSufficient;
    L161:
        return MailDraftSubmissionFailed;
    L163:
        return MailDraftAttachmentTooLarge;
    L165:
        return MailDraftSendQuotaExceeded;
    L167:
        return MailCanNotSendExternal;
    L169:
        return MailDraftHasBeenSent;
    L171:
        return MailDraftHasBeenDeleted;
    L173:
        return MailSwitchPrimaryAccountInvalid;
    L175:
        return MailBasicPermissionDisabled;
    L177:
        return MailTriAccountTaskCancelled;
    L179:
        return MailTriAccountCreateAuthFailed;
    L181:
        return MailTriAccountCreateRepeatedAddress;
    L183:
        return MailTriAccountUpdateDiffAddress;
    L185:
        return MailSwitchAccount;
    L187:
        return SerializationError;
    L189:
        return InvalidDataFormat;
    L191:
        return TodoFollowerNumberExceedsLimit;
    L193:
        return TodoAssigneeNumberExceedsLimit;
    L195:
        return TimeBlockNotFound;
    L197:
        return CalendarQueueClosed;
    L199:
        return UnexpectedIllegalValue;
    L201:
        return UnexpectedNoneValue;
    L203:
        return InvalidTimeRange;
    L205:
        return RequestFrequencyLimited;
    L207:
        return NoSelfPrimaryCalendar;
    L209:
        return CalendarFieldInvalid;
    L211:
        return CalendarNotWritable;
    L213:
        return CalendarNotFound;
    L215:
        return NewEventNotSyncToServer;
    L217:
        return EventNotWritable;
    L219:
        return EventNotFound;
    L221:
        return SavingEventInvalid;
    L223:
        return EventFieldInvalid;
    L225:
        return EventNotFoundedInDb;
    L227:
        return EventWriteSyncAttendeeNotMatchError;
    L229:
        return EventWriteSyncEventNotMatchError;
    L231:
        return EventWriteSyncNoneEventError;
    L233:
        return DisableEncryptEvent;
    L235:
        return EventReadSyncSDKDoneError;
    L237:
        return EventReadSyncDoneError;
    L239:
        return EventWriteSDKSaveError;
    L241:
        return EventWriteSyncSDKDoneError;
    L243:
        return EventWriteSyncDoneError;
    L245:
        return ExceedMaxVisibleCalNum;
    L247:
        return UserNotInMeetingChat;
    L249:
        return AttendeeNumberExceedsLimit;
    L251:
        return InvalidCalendarEvent;
    L253:
        return EventSharedInSyncing;
    L255:
        return CryptoError;
    L257:
        return DatabaseNotInited;
    L259:
        return NotSupportDir;
    L261:
        return NotReady;
    L263:
        return FrequencyLimit;
    L265:
        return DozeMode;
    L267:
        return Timeout;
    L269:
        return NetworkLibraryError;
    L271:
        return Offline;
    L273:
        return UserContainerNotReadyErr;
    L275:
        return UserContainerIdMismatchErr;
    L277:
        return UnregisteredCMD;
    L279:
        return GetDeviceConfigBeforeSet;
    L281:
        return LoginWithoutUserInfo;
    L283:
        return DupLoginWithDifferentTenantID;
    L285:
        return LoginWithoutTenantID;
    L287:
        return InvokeUserCmdWhenLogin;
    L289:
        return BrokenLoginInvariant;
    L291:
        return UserIdVerificationErr;
    L293:
        return Accepted;
    L295:
        return AbandonedUnderStartUpControl;
    L297:
        return NotFound;
    L299:
        return Gone;
    L301:
        return Forbidden;
    L303:
        return Unauthorized;
    L305:
        return RequestServerErr;
    L307:
        return RequestClientErr;
    L309:
        return SwitchToFrozenUser;
    L311:
        return SwitchingUser;
    L313:
        return General;
    }

    public static ErrorCode valueOf(String r100) {
        return (ErrorCode) a.a(ErrorCode.class, r100);
    }

    private ErrorCode(String r100, int r101, int r102, Boolean r103) {
        super(r100, r101);
        this.value = r102;
        this.deprecated = r103;
    }
}
