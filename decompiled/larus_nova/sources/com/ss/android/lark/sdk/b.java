package com.ss.android.lark.sdk;

import com.byted.cast.common.CommonOptionConstants;
import com.bytedance.lark.pb.basic.v1.ErrorCode;
import com.larksuite.framework.callback.Entity.ErrorResult;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements ErrorResult.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f439869a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Integer, Integer> f439870b = null;

    public b() {
    }

    static {
        f439869a = new b();
        f439870b = MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(ErrorCode.General.getValue()), 10000), TuplesKt.to(Integer.valueOf(ErrorCode.SwitchingUser.getValue()), 10014), TuplesKt.to(Integer.valueOf(ErrorCode.RequestClientErr.getValue()), 10024), TuplesKt.to(Integer.valueOf(ErrorCode.RequestServerErr.getValue()), Integer.valueOf(CommonOptionConstants.OPTION_SET_SINK_DATA_LISTENER_AUDIO)), TuplesKt.to(Integer.valueOf(ErrorCode.Unauthorized.getValue()), 10001), TuplesKt.to(Integer.valueOf(ErrorCode.Forbidden.getValue()), 10002), TuplesKt.to(Integer.valueOf(ErrorCode.Gone.getValue()), 10006), TuplesKt.to(Integer.valueOf(ErrorCode.NotFound.getValue()), 10005), TuplesKt.to(Integer.valueOf(ErrorCode.Offline.getValue()), 10008), TuplesKt.to(Integer.valueOf(ErrorCode.NetworkLibraryError.getValue()), 10018), TuplesKt.to(Integer.valueOf(ErrorCode.Timeout.getValue()), 10009), TuplesKt.to(Integer.valueOf(ErrorCode.NotSupportDir.getValue()), 10003), TuplesKt.to(Integer.valueOf(ErrorCode.MediaTranscodeFail.getValue()), 10013), TuplesKt.to(Integer.valueOf(ErrorCode.MediaTranscodeCancel.getValue()), 10020), TuplesKt.to(Integer.valueOf(ErrorCode.MediaIOError.getValue()), 10021), TuplesKt.to(Integer.valueOf(ErrorCode.DatabaseNotInited.getValue()), 10029), TuplesKt.to(Integer.valueOf(ErrorCode.SendMessageTooOften.getValue()), 10022), TuplesKt.to(Integer.valueOf(ErrorCode.OnlineFailedAndGetLocalData.getValue()), 10017), TuplesKt.to(Integer.valueOf(ErrorCode.EventSharedInSyncing.getValue()), 10010), TuplesKt.to(Integer.valueOf(ErrorCode.InvalidCalendarEvent.getValue()), 10026), TuplesKt.to(Integer.valueOf(ErrorCode.AttendeeNumberExceedsLimit.getValue()), 10011), TuplesKt.to(Integer.valueOf(ErrorCode.UserNotInMeetingChat.getValue()), 10016), TuplesKt.to(Integer.valueOf(ErrorCode.TodoAssigneeNumberExceedsLimit.getValue()), 10027), TuplesKt.to(Integer.valueOf(ErrorCode.TodoFollowerNumberExceedsLimit.getValue()), 10028), TuplesKt.to(Integer.valueOf(ErrorCode.MailSwitchAccount.getValue()), 10023), TuplesKt.to(Integer.valueOf(ErrorCode.UploadInSufficient.getValue()), 10019), TuplesKt.to(Integer.valueOf(ErrorCode.DoubleBatchDownload.getValue()), 10030)});
    }
}
