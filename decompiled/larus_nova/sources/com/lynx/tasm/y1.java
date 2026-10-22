package com.lynx.tasm;

import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class y1 extends TemplateData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f384114a;

    @Override // com.lynx.tasm.TemplateData
    public final boolean checkIsLegalData() {
        return true;
    }

    @Override // com.lynx.tasm.TemplateData
    public final void flush() {
    }

    @Override // com.lynx.tasm.TemplateData
    public final long getNativePtr() {
        return 0;
    }

    @Override // com.lynx.tasm.TemplateData
    public final TemplateData deepClone() {
        return new y1(this.f384114a);
    }

    @Override // com.lynx.tasm.TemplateData
    public final boolean isEmpty() {
        return this.f384114a.isEmpty();
    }

    @Override // com.lynx.tasm.TemplateData
    public final TemplateData shallowClone() {
        TraceEvent.beginSection("TemplateData.ShallowClone");
        y1 r100 = new y1(this.f384114a);
        TraceEvent.endSection("TemplateData.ShallowClone");
        return r100;
    }

    @Override // com.lynx.tasm.TemplateData
    public final Map<Object, Object> toMap() {
        return this.f384114a;
    }

    public y1(Map<String, Object> r100) {
        this.f384114a = r100;
        markReadOnly();
    }

    @Override // com.lynx.tasm.TemplateData
    public final void markState(String r100) {
        LLog.e("LynxTemplateData", "markState is not supported for static-page data");
    }

    @Override // com.lynx.tasm.TemplateData
    public final void updateWithTemplateData(TemplateData r100) {
        LLog.e("LynxTemplateData", "updateWithTemplateData is not supported for static-page data");
    }
}
