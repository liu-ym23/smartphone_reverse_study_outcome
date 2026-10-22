package com.larksuite.component.card.component.audio.service;

import com.larksuite.component.card.protocol.data.media.AudioInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public interface b extends com.larksuite.component.card.service.c {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f283301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f283302b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f283301a, r101.f283301a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f283302b, r101.f283302b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f283301a.hashCode() * 31;
            String r101 = this.f283302b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "CardAudioMonitorData(bizID=" + this.f283301a + ", source=" + this.f283302b + ')';
        }

        public a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "bizID");
            this.f283301a = r100;
            this.f283302b = r101;
        }
    }

    void c(String r100, a r101);

    void e(az7.a r100);

    void f(String r100, AudioInfo r101, int r102, a r103);

    CardAudioStateEntity getState(String r100);

    void j(String r100, AudioInfo r101, int r102, a r103, boolean r104);

    void l(String r100, a r101);
}
