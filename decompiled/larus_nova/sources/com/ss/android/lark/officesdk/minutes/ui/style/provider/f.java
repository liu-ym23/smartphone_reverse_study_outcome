package com.ss.android.lark.officesdk.minutes.ui.style.provider;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;

/* JADX INFO: loaded from: classes37.dex */
public class f implements com.ss.android.lark.officesdk.minutes.ui.style.contract.h {
    private final com.ss.android.lark.officesdk.minutes.ui.style.contract.b activity;
    private final com.ss.android.lark.officesdk.minutes.ui.style.contract.c capability;
    private final com.ss.android.lark.officesdk.minutes.ui.style.contract.d color;
    private final com.ss.android.lark.officesdk.minutes.ui.style.contract.e drawable;
    private final com.ss.android.lark.officesdk.minutes.ui.style.contract.f layout;
    private final com.ss.android.lark.officesdk.minutes.ui.style.contract.a quotaCta;
    private final com.ss.android.lark.officesdk.minutes.ui.style.contract.g shape;
    private final MmRecordingUILaunchMode uiLaunchMode;

    public f() {
        this.uiLaunchMode = MmRecordingUILaunchMode.UNKNOWN;
        this.activity = new a();
        this.layout = new d();
        this.color = new b();
        this.drawable = new c();
        this.shape = new e();
        this.capability = com.ss.android.lark.officesdk.minutes.ui.style.contract.c.a.f436891a;
        com.ss.android.lark.officesdk.minutes.ui.style.contract.a.f436888a.getClass();
        this.quotaCta = com.ss.android.lark.officesdk.minutes.ui.style.contract.a.C5216a.f436890b;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.h
    public ewb.a createRecordingNotificationProcessor() {
        return ewb.a.C5827a.f474612a;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.h
    public com.ss.android.lark.officesdk.minutes.ui.style.contract.b getActivity() {
        return this.activity;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.h
    public qub.b getBubble() {
        return qub.b.a.f534852a;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.h
    public com.ss.android.lark.officesdk.minutes.ui.style.contract.c getCapability() {
        return this.capability;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.h
    public com.ss.android.lark.officesdk.minutes.ui.style.contract.d getColor() {
        return this.color;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.h
    public qub.c getDialog() {
        return qub.c.a.f534853a;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.h
    public com.ss.android.lark.officesdk.minutes.ui.style.contract.e getDrawable() {
        return this.drawable;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.h
    public com.ss.android.lark.officesdk.minutes.ui.style.contract.f getLayout() {
        return this.layout;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.h
    public qub.d getLoading() {
        return qub.d.a.f534854a;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.h
    public qub.e getPanel() {
        return qub.e.a.f534855a;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.h
    public com.ss.android.lark.officesdk.minutes.ui.style.contract.a getQuotaCta() {
        return this.quotaCta;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.h
    public com.ss.android.lark.officesdk.minutes.ui.style.contract.g getShape() {
        return this.shape;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.h
    public qub.h getToast() {
        return qub.h.a.f534856a;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.h
    public MmRecordingUILaunchMode getUiLaunchMode() {
        return this.uiLaunchMode;
    }
}
