package com.larksuite.component.universe_design.dialog;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c extends UDBaseDialogBuilder<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f284877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f284878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f284879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f284880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f284881e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f284882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f284883g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f284884h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f284885i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f284886j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CharSequence f284887k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f284888l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f284889m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public a f284890n;

    public interface a {
        void onTextChanged(CharSequence r100);
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f284877a = -1;
        this.f284878b = -1;
        this.f284879c = -1;
        this.f284880d = -1;
        this.f284881e = -1;
        this.f284882f = -1;
        this.f284883g = -1;
        this.f284884h = -1;
        this.f284885i = -1;
        this.f284887k = "";
        setMController$universe_ui_dialog_release(new d(r100));
        UDBaseDialogBuilder.b r101 = UDBaseDialogBuilder.Companion;
        r101.getClass();
        setMMarginInDp$universe_ui_dialog_release(UDBaseDialogBuilder.access$getDialogMargin$cp());
        r101.getClass();
        setMMaxWidth$universe_ui_dialog_release(UDBaseDialogBuilder.access$getDialogMaxWidth$cp());
    }
}
