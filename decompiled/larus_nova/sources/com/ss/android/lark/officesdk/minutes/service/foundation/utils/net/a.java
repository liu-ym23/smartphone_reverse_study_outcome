package com.ss.android.lark.officesdk.minutes.service.foundation.utils.net;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmQuotaData;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmQuotaType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingPullSubtitlesResponse;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingSyncSubtitlesResponse;
import com.ss.android.lark.pb.videochat.GetLiveRecordingSettingResponse;
import com.ss.android.lark.pb.videochat.UpdateLiveRecordingSettingResponse;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes37.dex */
public interface a {
    Object a(String r100, MmQuotaType r101, MmRecordingSource r102, String r103, Continuation<? super Result<MmQuotaData>> r104);

    Object b(String r100, boolean r101, Continuation<? super Result<UpdateLiveRecordingSettingResponse>> r102);

    Object c(String r100, Continuation<? super Result<GetLiveRecordingSettingResponse>> r101);

    Object d(String r100, h r101, boolean r102, Continuation<? super Result<UpdateLiveRecordingSettingResponse>> r103);

    Object e(String r100, h r101, Continuation<? super Result<UpdateLiveRecordingSettingResponse>> r102);

    Object f(String r100, Continuation<? super Result<GetLiveRecordingSettingResponse>> r101);

    Object g(String r100, String r101, Long r102, boolean r103, long r104, boolean r105, Continuation<? super Result<MinutesRecordingPullSubtitlesResponse>> r106);

    Object h(String r100, boolean r101, String r102, Continuation<? super Result<MinutesRecordingSyncSubtitlesResponse>> r103);

    Object i(String r100, boolean r101, boolean r102, Continuation<? super Result<UpdateLiveRecordingSettingResponse>> r103);

    Object j(String r100, Continuation<? super Result<GetLiveRecordingSettingResponse>> r101);
}
