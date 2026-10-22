package com.bytedance.mira.stub;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes21.dex */
public class BaseStubReceiver extends BroadcastReceiver {

    public static final class CodeConst {
        public static final String EXTRA_STUB_ACTIVITYINFO = "stub_activityinfo";
        public static final String EXTRA_TARGET_ACTIVITYINFO = "target_activityinfo";
        public static final String EXTRA_TARGET_INTENT = "target_intent";

        public CodeConst() {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r100, Intent r101) {
    }

    public BaseStubReceiver() {
    }
}
