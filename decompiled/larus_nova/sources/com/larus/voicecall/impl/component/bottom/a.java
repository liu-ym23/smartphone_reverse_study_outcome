package com.larus.voicecall.impl.component.bottom;

import com.larus.av_call.model.RealtimePageMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.larus.voicecall.impl.component.bottom.a$a, reason: collision with other inner class name */
    public static final class C4524a implements w3a.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f377199a;

        public C4524a(a r100) {
            this.f377199a = r100;
        }

        @Override // w3a.i
        public final void a(w3a.h r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            if ((r100 instanceof w3a.j) == false) goto L6;
            w3a.j r101 = (w3a.j) r100;
            this.f377199a.getClass();
            return;
        L6:
            if ((r100 instanceof w3a.a) == false) goto L10;
            a r102 = this.f377199a;
            RealtimePageMode r103 = ((w3a.a) r100).f558190a;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r103, "newMode");
            return;
        }
    }

    public a(w3a.k r100) {
        C4524a r101 = new C4524a(this);
        if (r100 == null) goto L6;
        r100.c(r101);
        return;
    }
}
