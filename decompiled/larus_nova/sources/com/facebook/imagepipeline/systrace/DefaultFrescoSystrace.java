package com.facebook.imagepipeline.systrace;

import android.os.Trace;
import com.alipay.sdk.m.n.a;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultFrescoSystrace implements FrescoSystrace.Systrace {

    /* JADX INFO: loaded from: classes23.dex */
    public static final class DefaultArgsBuilder implements FrescoSystrace.ArgsBuilder {
        private final StringBuilder mStringBuilder;

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public void flush() {
            if (this.mStringBuilder.length() <= 127) goto L5;
            this.mStringBuilder.setLength(127);
        L5:
            Trace.beginSection(this.mStringBuilder.toString());
        }

        public DefaultArgsBuilder(String r100) {
            this.mStringBuilder = new StringBuilder(r100);
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public FrescoSystrace.ArgsBuilder arg(String r100, Object r101) {
            StringBuilder r102 = this.mStringBuilder;
            r102.append(';');
            r102.append(r100);
            r102.append(a.f25612h);
            if (r101 != null) goto L5;
            String r103 = "null";
        L6:
            r102.append(r103);
            return this;
        L5:
            r103 = r101.toString();
            goto L6
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public FrescoSystrace.ArgsBuilder arg(String r100, double r101) {
            StringBuilder r102 = this.mStringBuilder;
            r102.append(';');
            r102.append(r100);
            r102.append(a.f25612h);
            r102.append(Double.toString(r101));
            return this;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public FrescoSystrace.ArgsBuilder arg(String r100, int r101) {
            StringBuilder r102 = this.mStringBuilder;
            r102.append(';');
            r102.append(r100);
            r102.append(a.f25612h);
            r102.append(Integer.toString(r101));
            return this;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public FrescoSystrace.ArgsBuilder arg(String r100, long r101) {
            StringBuilder r102 = this.mStringBuilder;
            r102.append(';');
            r102.append(r100);
            r102.append(a.f25612h);
            r102.append(Long.toString(r101));
            return this;
        }
    }

    public DefaultFrescoSystrace() {
    }

    @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace
    public void beginSection(String r100) {
    }

    @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace
    public void endSection() {
    }

    @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace
    public boolean isTracing() {
        return false;
    }

    @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace
    public FrescoSystrace.ArgsBuilder beginSectionWithArgs(String r100) {
        return FrescoSystrace.NO_OP_ARGS_BUILDER;
    }
}
