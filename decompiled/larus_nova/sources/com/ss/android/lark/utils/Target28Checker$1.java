package com.ss.android.lark.utils;

import android.os.Build;
import java.util.HashSet;

/* JADX INFO: loaded from: classes38.dex */
class Target28Checker$1 extends HashSet<String> {
    public Target28Checker$1() {
        add("MeetingFeedbackDialogActivity");
        add("TTCJPayInputPasswordActivity");
        if (Build.VERSION.SDK_INT <= 26) goto L6;
        add("DriveCarrierActivity");
        return;
    }
}
