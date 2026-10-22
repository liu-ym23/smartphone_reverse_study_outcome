package com.larus.praise;

import android.app.Activity;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J@\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\fH&J\b\u0010\u000f\u001a\u00020\u0005H&¨\u0006\u0010"}, d2 = {"Lcom/larus/praise/IPraiseService;", "", "isExpectShowPraiseDialog", "", "tryShowPraiseDialog", "", "uid", "", "delayMillSec", "activity", "Landroid/app/Activity;", "from", "", "feedbackScene", "messageId", "tryRequestPraiseDialog", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IPraiseService {
    boolean a();

    void b(long r100, long r101, Activity r102, String r103, String r104, String r105);

    void c();
}
