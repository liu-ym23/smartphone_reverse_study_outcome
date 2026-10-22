package com.larus.livetutor.impl.rtc.interfaces;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.news.common.service.manager.IService;
import com.larus.livetutor.impl.rtc.api.RTCInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J,\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\u0010H&¨\u0006\u0012"}, d2 = {"Lcom/larus/livetutor/impl/rtc/interfaces/IRTCDebugService;", "Lcom/bytedance/news/common/service/manager/IService;", "openRTCDebugDialog", "", "rtcInfo", "Lcom/larus/livetutor/impl/rtc/api/RTCInfo;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "bizContent", "", "attachAudioDumpWidget", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "switchDump", "Lkotlin/Function1;", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IRTCDebugService extends IService {
    void attachAudioDumpWidget(ViewGroup r100, ViewGroup.LayoutParams r101, Function1<? super Boolean, Unit> r102);

    void openRTCDebugDialog(RTCInfo r100, Context r101, String r102);
}
