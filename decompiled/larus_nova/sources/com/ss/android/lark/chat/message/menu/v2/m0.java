package com.ss.android.lark.chat.message.menu.v2;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PanelType f415760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f415761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f415762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PanelActionType f415763d;

    public final PanelType getType() {
        return this.f415760a;
    }

    public m0(PanelType r100, float r101, boolean r102, PanelActionType r103) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r103, ReportConstant.COMMON_ACTION_TYPE);
        this.f415760a = r100;
        this.f415761b = r101;
        this.f415762c = r102;
        this.f415763d = r103;
    }

    public static m0 a(m0 r100, PanelType r101, float r102, boolean r103, PanelActionType r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f415760a;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.f415761b;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.f415762c;
    L12:
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.f415763d;
    L14:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r104, ReportConstant.COMMON_ACTION_TYPE);
        return new m0(r101, r102, r103, r104);
    }
}
