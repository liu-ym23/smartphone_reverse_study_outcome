package jk1;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public static long a(Bundle r100) {
        if (r100.getLong(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_ID, 0) <= 0) goto L6;
        return r100.getLong(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_ID);
    L6:
        if (TextUtils.isEmpty(r100.getString(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_ID, "")) == true) goto L15;
        return CastLongProtector.parseLong(r100.getString(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_ID));
    L9:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L15:
        return 0;
    }
}
