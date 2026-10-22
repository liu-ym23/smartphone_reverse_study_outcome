package com.larus.dora.impl.device.settings.media;

import com.larus.dora.api.model.FlowDoraVideoRecordConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface a0 {

    public static final class a implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FlowDoraVideoRecordConfig f334820a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f334820a, ((a) r100).f334820a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f334820a.hashCode();
        }

        public final String toString() {
            return "Config(cfg=" + this.f334820a + ')';
        }

        public a(FlowDoraVideoRecordConfig r100) {
            Intrinsics.checkNotNullParameter(r100, "cfg");
            this.f334820a = r100;
        }
    }
}
