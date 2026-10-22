package com.ss.android.lark.officesdk.minutes.ui.style;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class MmUIStyleContextWrapper extends ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MmRecordingUILaunchMode f436886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f436887b;

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (Intrinsics.areEqual(r100, "layout_inflater") == false) goto L7;
        return (LayoutInflater) this.f436887b.getValue();
    L7:
        return super.getSystemService(r100);
    }

    public MmUIStyleContextWrapper(Context r100, MmRecordingUILaunchMode r101) {
        Intrinsics.checkNotNullParameter(r100, "base");
        Intrinsics.checkNotNullParameter(r101, "uiLaunchMode");
        super(r100);
        this.f436886a = r101;
        this.f436887b = LazyKt.lazy(new MmUIStyleContextWrapper$layoutInflater$2(this));
    }
}
