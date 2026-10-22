package com.ss.android.lark.officesdk.minutes.service.recording.common.core;

import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.larus.nova.R;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.e;
import com.ss.android.lark.utils.UIHelper;
import eub.d;
import eub.f;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f434177a = 0;

    static {
    }

    public static f a(String r210, String r211, String r212, long r213, long r214, long r215) {
        String r100 = r211;
        Intrinsics.checkNotNullParameter(r210, "sessionKey");
        Intrinsics.checkNotNullParameter(r100, "hardwareDeviceId");
        Intrinsics.checkNotNullParameter(r212, "audioPath");
        String r101 = StringsKt.replace$default(StringsKt.replace$default("d1204-offline-upload-" + r210, ":", "", false, 4, null), "_", "-", false, 4, null);
        MmRecordingSource r110 = MmRecordingSource.FEISHU_HARDWARE_D1204;
        String r102 = new SimpleDateFormat("MM-dd HH:mm", Locale.getDefault()).format(new Date(r214));
        int r103 = e.f434040a;
        List r104 = CollectionsKt.listOf(new d(r212, null, UIHelper.getString(R.string.View_MempopeTwo_BrandName_Menu) + '_' + r102 + ".ogg", r213, RangesKt.coerceAtLeast(r215 - r214, 1000), 1, 2));
        String r105 = String.valueOf(r214);
        String r106 = String.valueOf(r215);
        String r107 = String.valueOf(TimeZone.getDefault().getOffset(r214) / BaseConstants.Time.HOUR);
        Pair[] r108 = new Pair[8];
        r108[0] = TuplesKt.to("hardware_file_ids", r210);
        if (StringsKt.isBlank(r211) == false) goto L5;
    L8:
        r108[1] = TuplesKt.to("hardware_device_ids", r100);
        r108[2] = TuplesKt.to("file_unique_id_list", r210);
        r108[3] = TuplesKt.to("offline_line_index", "0");
        r108[4] = TuplesKt.to("record_index", "0");
        r108[5] = TuplesKt.to("is_last_record", "true");
        r108[6] = TuplesKt.to("offline_local_recording", "true");
        r108[7] = TuplesKt.to("transfer_type", OperationName.OPERATION_OFFLINE_AVAILABLE);
        return new f(r101, r110, r104, r210, r105, r106, r107, MapsKt.mapOf(r108), null, 256);
    L5:
        if (StringsKt.startsWith$default(r100, "anker_d1204_", false, 2, null) == true) goto L8;
        r100 = "anker_d1204_" + r100;
        goto L8
    }
}
