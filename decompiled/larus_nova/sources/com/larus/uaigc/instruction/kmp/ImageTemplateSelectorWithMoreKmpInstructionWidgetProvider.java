package com.larus.uaigc.instruction.kmp;

import android.content.Context;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.bmhome.instruction.kmp.IKmpInstructionWidgetProvider;
import com.ss.android.lark.utils.statistics.PerfLog;
import cq8.a0;
import cq8.w;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\r"}, d2 = {"Lcom/larus/uaigc/instruction/kmp/ImageTemplateSelectorWithMoreKmpInstructionWidgetProvider;", "Lcom/larus/bmhome/instruction/kmp/IKmpInstructionWidgetProvider;", "Lcom/larus/bmhome/instruction/core/model/widget/ImageTemplateSelectorWithMoreDescriptor;", "<init>", "()V", "match", "", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "provide", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageTemplateSelectorWithMoreKmpInstructionWidgetProvider implements IKmpInstructionWidgetProvider<w> {
    public ImageTemplateSelectorWithMoreKmpInstructionWidgetProvider() {
    }

    @Override // com.larus.bmhome.instruction.kmp.IKmpInstructionWidgetProvider
    public final boolean a(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        return r100 instanceof w;
    }

    @Override // com.larus.bmhome.instruction.kmp.IKmpInstructionWidgetProvider
    public final AbsKmpInstructionWidget b(Context r100, a0 r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter((w) r101, "descriptor");
        return new KmpImageTemplateSelectorWithMoreWidget(r100, null, 6, 0);
    }
}
