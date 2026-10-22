package com.larksuite.component.universe_design.dialog;

import android.content.Context;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a extends UDBaseDialogBuilder<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f284870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UDCheckBox.c f284871b;

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f284870a = "";
        setMController$universe_ui_dialog_release(new b(r100));
        UDBaseDialogBuilder.b r101 = UDBaseDialogBuilder.Companion;
        r101.getClass();
        setMMarginInDp$universe_ui_dialog_release(UDBaseDialogBuilder.access$getDialogMargin$cp());
        r101.getClass();
        setMMaxWidth$universe_ui_dialog_release(UDBaseDialogBuilder.access$getDialogMaxWidth$cp());
    }
}
