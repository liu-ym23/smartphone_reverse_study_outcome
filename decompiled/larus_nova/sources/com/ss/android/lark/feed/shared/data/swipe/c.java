package com.ss.android.lark.feed.shared.data.swipe;

import com.bytedance.lark.pb.feed.v1.FeedSlideActionSetting;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f421152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FeedSlideActionSetting f421153b;

    public c(a r100, FeedSlideActionSetting r101) {
        this.f421152a = r100;
        this.f421153b = r101;
    }

    public final void a() {
        a r100 = this.f421152a;
        FeedSlideActionSetting r101 = this.f421153b;
        r100.f421147b.setValue(r101);
        ((ArrayList) r100.f421148c).clear();
        ((ArrayList) r100.f421149d).clear();
        List<FeedSlideActionSetting.FeedSlideActionType> r102 = r101.left_slide_action;
        Map<FeedSlideActionSetting.FeedSlideActionType, List<FeedActionType>> r103 = a.f421143f;
        boolean r104 = false;
        if (r102 == null) goto L10;
        FeedSlideActionSetting r105 = r100.f421147b.getValue();
        if (r105 == null) goto L7;
        boolean r106 = Intrinsics.areEqual(r105.left_slide_action_on, Boolean.TRUE);
    L8:
        if (r106 == false) goto L10;
        List<FeedActionType> r107 = r100.f421148c;
        ArrayList r108 = (ArrayList) r107;
        r108.addAll(a.C4964a.a(r102));
        goto L10
    L7:
        r106 = false;
    L10:
        List<FeedSlideActionSetting.FeedSlideActionType> r109 = r101.right_slide_action;
        if (r109 == null) goto L18;
        FeedSlideActionSetting r110 = r100.f421147b.getValue();
        if (r110 == null) goto L15;
        r104 = Intrinsics.areEqual(r110.right_slide_action_on, Boolean.TRUE);
    L15:
        if (r104 == false) goto L19;
        List<FeedActionType> r111 = r100.f421149d;
        ArrayList r112 = (ArrayList) r111;
        r112.addAll(a.C4964a.a(r109));
        return;
    L19:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
